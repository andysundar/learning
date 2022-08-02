package com.andy.statemachine;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SimpleStateMachineRunner implements ApplicationRunner {

    private final StateMachine<String, String> stateMachine;

    SimpleStateMachineRunner(StateMachine<String, String> stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        stateMachine.start();
        log.info("Start State Machine " + stateMachine.getState().getId());
    }
}
