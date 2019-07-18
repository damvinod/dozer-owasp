package com.damvinod.ms.api.dozer.oswap;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter{

  @Override
  public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.add(jsonConverter());
  }
  @Bean
  public HttpMessageConverter<?> jsonConverter() {
    SimpleModule module = new SimpleModule();
    module.addDeserializer(String.class, new DefaultJsonDeserializer());
    ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().build();
    objectMapper.registerModule(module);
    return new MappingJackson2HttpMessageConverter(objectMapper);
  }
}
