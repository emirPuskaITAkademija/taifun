package ba.smoki.taifun.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PrepaidServiceTerminationOperation implements Operation {

    public static final String PREPAID_TERMINATION = "PREPAID_TERMINATION";

    @Override
    public boolean check(String operationName) {
        return PREPAID_TERMINATION.equals(operationName);
    }

    @Override
    public void execute() {
        System.out.println("Izvrši TERMINACIJU PREPAID servisa...");
    }
}
