package ba.smoki.taifun.demo;

import org.springframework.stereotype.Component;

@Component
public class PostpaidServiceTerminationOperation implements Operation{

    public static final String POSTPAID_TERMINATION = "POSTPAID_TERMINATION";

    @Override
    public boolean check(String operationName) {
        return POSTPAID_TERMINATION.equals(operationName);
    }

    @Override
    public void execute() {
        System.out.println("Izvrši TERMINACIJU POSTPAID servisa");
    }
}
