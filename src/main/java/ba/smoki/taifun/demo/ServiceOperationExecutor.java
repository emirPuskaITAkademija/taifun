package ba.smoki.taifun.demo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceOperationExecutor {

//    @Autowired
    private final List<Operation> operations;

    public ServiceOperationExecutor(List<Operation> operations){
        this.operations = operations;
    }



    public void triggerServiceOperationExecution(String operationName){
        operations
                .stream()
                .filter(operation -> operation.check(operationName))
                .forEach(Operation::execute);
    }
}
