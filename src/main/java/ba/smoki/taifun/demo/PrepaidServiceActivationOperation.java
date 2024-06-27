package ba.smoki.taifun.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PrepaidServiceActivationOperation implements Operation {

    public static final String PREPAID_ACTIVATION = "PREPAID_ACTIVATION";

    @Override
    public boolean check(String operationName) {
        return PREPAID_ACTIVATION.equals(operationName);
    }

    @Override
    public void execute() {
        System.out.println("Izvrši AKTIVACIJA PREPAID servisa...");
    }
}
