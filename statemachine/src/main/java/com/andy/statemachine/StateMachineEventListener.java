package com.andy.statemachine;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;

@Slf4j
public class StateMachineEventListener extends StateMachineListenerAdapter<String, String> {

    @Override
    public void stateChanged(State<String, String> from, State<String, String> to) {
        log.info(String.format("State change from:: %s to:: %s", from == null? "Init State" : from.getId(), to.getId()));
    }

    @Override
    public void stateEntered(State<String, String> state) {
        log.info(String.format("State entered :: %s ", state.getId()));
    }

    @Override
    public void stateExited(State<String, String> state) {
        log.info(String.format("State exited :: %s ", state.getId()));
    }

    @Override
    public void eventNotAccepted(Message<String> event) {
        log.info(String.format("State entered :: %s ", event.getPayload()));
    }

    @Override
    public void transition(Transition<String, String> transition) {
        if (transition.getSource()!=null)
        log.info(String.format("State transition from:: %s to:: %s", transition.getSource().getId(), transition.getTarget().getId()));
    }

    @Override
    public void transitionStarted(Transition<String, String> transition) {
        if (transition.getSource()!=null)
        log.info(String.format("State transition started from:: %s to:: %s", transition.getSource().getId(), transition.getTarget().getId()));
    }

    @Override
    public void transitionEnded(Transition<String, String> transition) {
        if (transition.getSource()!=null)
        log.info(String.format("State transition ended from:: %s to:: %s", transition.getSource().getId(), transition.getTarget().getId()));
    }

    @Override
    public void stateMachineStarted(StateMachine<String, String> stateMachine) {
        log.info(String.format("State machine started :: %s ",  stateMachine.getId()));
    }

    @Override
    public void stateMachineStopped(StateMachine<String, String> stateMachine) {
        log.info(String.format("State machine stopped :: %s ",  stateMachine.getId()));
        stateMachine.stop();
    }

    @Override
    public void stateMachineError(StateMachine<String, String> stateMachine, Exception exception) {
        log.info(String.format("State machine error :: %s , exception ::\n %s ",  stateMachine.getId()), exception.getMessage());
    }

    @Override
    public void extendedStateChanged(Object key, Object value) {
        super.extendedStateChanged(key, value);
    }

    @Override
    public void stateContext(StateContext<String, String> stateContext) {
        super.stateContext(stateContext);
    }
}