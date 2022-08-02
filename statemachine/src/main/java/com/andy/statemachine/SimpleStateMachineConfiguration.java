package com.andy.statemachine;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.Arrays;
import java.util.HashSet;

@Slf4j
@Configuration
@EnableStateMachine(name = "simpleStateMachineConfigure")
public class SimpleStateMachineConfiguration  extends StateMachineConfigurerAdapter<String, String> {

    @Override
    public void configure(StateMachineStateConfigurer<String, String> states) throws Exception {

        states
                .withStates()
                .initial("InitialState")
                .end("FinalState")
                .states(new HashSet<>(Arrays.asList("S1", "S2", "S3")));

    }

    @Override
    public void configure(
            StateMachineTransitionConfigurer<String, String> transitions)
            throws Exception {

        transitions
                .withExternal().source("InitialState").target("S1").event("E1")
                .and()
                .withExternal().source("S1").target("S2").event("E2")
                .and()
                .withExternal()
                .source("S2").target("FinalState").event("end");
    }

    @Override
    public void configure(StateMachineConfigurationConfigurer<String, String> config)
            throws Exception {

        config
                .withConfiguration()
                .listener(stateMachineEventListener())
                .machineId("simpleStateMachine");
    }

    @Bean
    public StateMachineEventListener stateMachineEventListener(){
        return new StateMachineEventListener();
    }
}

