package ba.smoki.taifun.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoRestController {

    public static final String TODO_SERVICE_URL = "https://jsonplaceholder.typicode.com/todos";

    @GetMapping
    public List<Todo> todos(){
        RestTemplate restTemplate = new RestTemplate();
        List<Todo> todos = restTemplate.getForObject(TODO_SERVICE_URL, ArrayList.class);
        return todos;
    }
}
