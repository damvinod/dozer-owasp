package com.damvinod.ms.api.dozer.oswap;

import static org.jsoup.parser.Parser.unescapeEntities;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;
import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;
import org.springframework.boot.jackson.JsonComponent;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;

@JsonComponent
public class DefaultJsonDeserializer extends JsonDeserializer<String> implements ContextualDeserializer {

  public static final PolicyFactory POLICY_FACTORY =
      new HtmlPolicyBuilder().allowElements("a", "p")
      .allowUrlProtocols("https")
      .allowAttributes("class").onElements("p")
      .toFactory();

  PolicyFactory policy = Sanitizers.FORMATTING.and(Sanitizers.LINKS);

  @Override
  public JsonDeserializer<?> createContextual(DeserializationContext ctxt,
      BeanProperty property)
          throws JsonMappingException {
    return this;
  }

  @Override
  public String deserialize(JsonParser parser, DeserializationContext ctxt)
      throws IOException, JsonProcessingException {

    String value = parser.getValueAsString();
    if (StringUtils.isEmpty(value) ) {
      return value;
    } else                             {
      String originalWithUnescaped  = unescapeUntilNoHtmlEntityFound(value);
      String htmlSafe = policy.sanitize(originalWithUnescaped);
      return unescapeEntities(htmlSafe, true);
    }
  }

  private String unescapeUntilNoHtmlEntityFound(final String value){
    String unescaped = unescapeEntities(value, true);
    if ( !unescaped.equals(value) ) {
      return unescapeUntilNoHtmlEntityFound(unescaped);
    } else {
      return unescaped;
    }
  }
}
