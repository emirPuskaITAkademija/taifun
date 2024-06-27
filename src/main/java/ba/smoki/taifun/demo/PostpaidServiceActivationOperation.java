package ba.smoki.taifun.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PostpaidServiceActivationOperation implements Operation{

    public static final String POSTPAID_ACTIVATION = "POSTAPID_ACTIVATION";

    @Override
    public boolean check(String operationName) {
        return POSTPAID_ACTIVATION.equals(operationName);
    }

    @Override
    public void execute() {
        System.out.println("Izvrši AKTIVACIJU POSTPAID operacije...");
    }
}
