package info.mlstech.tutorial.todoapi.biz;

import info.mlstech.tutorial.todoapi.model.Todo;
import info.mlstech.tutorial.todoapi.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TodoBiz {

    @Autowired
    private TodoRepository todoRepository;

    @Transactional
    public void addTestTodos(List<Todo> todos) {

        todos.forEach(o -> todoRepository.save(o));
    }

    @Transactional
    public void addTodo(Todo todo) {

        todoRepository.save(todo);
    }

    @Transactional
    public List<Todo> listAll() {

        return todoRepository.findAll();
    }


}
