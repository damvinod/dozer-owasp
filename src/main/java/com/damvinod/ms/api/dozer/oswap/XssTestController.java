package com.damvinod.ms.api.dozer.oswap;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.damvinod.ms.api.dozer.to.Agent;
import com.damvinod.ms.api.dozer.to.AgentTemp;

@RestController
@RequestMapping("/getDetails")
public class XssTestController {

  @PostMapping(path="/vinod")
  public Agent getAgent(@RequestBody AgentTemp agentTemp) {

    System.out.println("agentTemp...." + agentTemp);
    return new Agent("Dampuru Vinod", "Vinod");
  }

}
