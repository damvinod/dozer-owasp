package com.damvinod.ms.api.dozer.config;

import static springfox.documentation.builders.PathSelectors.regex;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Value("${app.contextPath}")
  private String contextPath;

  @Value("${app.swagger.title}")
  private String title;

  @Value("${app.swagger.desc}")
  private String desc;

  /**
   * This method will display the request details.
   *
   * @return
   */
  @Bean
  public Docket apiInformation() {
    return new Docket(DocumentationType.SWAGGER_2).groupName("333333")
        .apiInfo(generalInformation()).useDefaultResponseMessages(false)
        .globalResponseMessage(RequestMethod.GET, responseMessageList())
        .globalResponseMessage(RequestMethod.POST, responseMessageList())
        .globalResponseMessage(RequestMethod.PUT, responseMessageList()).select()
        .paths(regex("/getDetails" + "/.*")).build();
  }

  private ApiInfo generalInformation() {
    Contact contact = new Contact("","","");

    return new ApiInfoBuilder().title(title).description(desc)
        .termsOfServiceUrl("33").contact(contact)
        .license("22").licenseUrl("455")
        .version("1.0").build();
  }



  private List<ResponseMessage> responseMessageList() {
    final List<ResponseMessage> responseMessageList = new ArrayList<ResponseMessage>();
    responseMessageList
    .add(new ResponseMessageBuilder().code(HttpStatus.INTERNAL_SERVER_ERROR.value())
        .message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
        .responseModel(new ModelRef("Error")).build());
    responseMessageList.add(new ResponseMessageBuilder().code(HttpStatus.FORBIDDEN.value())
        .message(HttpStatus.FORBIDDEN.getReasonPhrase()).build());
    responseMessageList.add(new ResponseMessageBuilder().code(HttpStatus.NOT_FOUND.value())
        .message(HttpStatus.NOT_FOUND.getReasonPhrase()).build());
    responseMessageList.add(new ResponseMessageBuilder().code(HttpStatus.OK.value())
        .message(HttpStatus.OK.getReasonPhrase()).build());
    responseMessageList.add(new ResponseMessageBuilder().code(HttpStatus.CREATED.value())
        .message(HttpStatus.CREATED.getReasonPhrase()).build());
    return responseMessageList;
  }
}
