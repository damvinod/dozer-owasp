package com.damvinod.ms.api.dozer.controller;

import org.apache.camel.CamelContext;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.damvinod.ms.api.dozer.to.Agent;
import com.damvinod.ms.api.dozer.to.AgentTemp;

@RestController
public class BasicController {

  @Autowired
  DozerBeanMapper dozerBeanMapper;

  @Autowired
  private CamelContext camelContext;

  @GetMapping(path = "/test")
  public Agent test() {

    AgentTemp agentTemp = new AgentTemp();
    agentTemp.setName("vinod");

    Agent agent = dozerBeanMapper.map(agentTemp, Agent.class);

    System.out.println("agent....." + agent.getFullName());

    return agent;
  }

  @GetMapping(path="/test1")
  public Agent test1() throws Exception {


    //camelContext.addRoutes(new CamelBuilder());

    //camelContext.createProducerTemplate().sendBody(new CamelBuilder());

    String a  = (String) camelContext.createProducerTemplate().requestBody("direct:start", "hello");
    System.out.println(a);

    return null;
  }
}