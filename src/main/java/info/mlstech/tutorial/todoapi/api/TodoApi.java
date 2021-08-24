package info.mlstech.tutorial.todoapi.api;

import info.mlstech.tutorial.todoapi.biz.TodoBiz;
import info.mlstech.tutorial.todoapi.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoApi {

    @Autowired
    private TodoBiz todoBiz;

    // No.1
    @GetMapping("/ok")
    public String ok() {
        return "ok";
    }

    // No.2
    @GetMapping
    public List<Todo> getTodoList() {

        return todoBiz.listAll();
    }

    // No.3
    @GetMapping("/test/add/todos")
    public String testAddTodos() {


        List<Todo> todos = new ArrayList<>();
        todos.add(new Todo(null, "Call Metting", ""));
        todos.add(new Todo(null, "Print File", ""));

        todoBiz.addTestTodos(todos);

        return "ok";

    }

    @PostMapping("/todo")
    public String addTodo(@RequestBody Todo todo) {

        todoBiz.addTodo(todo);

        return "ok";
    }

}
