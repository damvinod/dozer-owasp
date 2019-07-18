package com.damvinod.ms.api.dozer.controller;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelBuilder extends RouteBuilder {

  @Override
  public void configure() throws Exception {


    from("direct:start").log("${body}").process(processor -> processor.getIn().setBody("vinod"));

  }

}
