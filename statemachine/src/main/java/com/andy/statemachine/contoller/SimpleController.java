package com.andy.statemachine.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.statemachine.StateMachine;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/statemachine")
public class SimpleController {

    @Autowired
    StateMachine<String, String> stateMachine;

    @PostMapping(path="/state")
    public HttpEntity<Void> setState(@RequestParam("event") String event) {
        stateMachine.sendEvent(event);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    @GetMapping(path="/state")
    @ResponseBody
    public String getState() {
        return stateMachine.getState().getId();
    }
}
