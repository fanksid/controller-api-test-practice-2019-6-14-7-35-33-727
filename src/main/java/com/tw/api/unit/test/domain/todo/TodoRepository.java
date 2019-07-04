package com.tw.api.unit.test.domain.todo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class TodoRepository {

    private Set<Todo> todos;

    public TodoRepository() {
        this.todos = new HashSet<>();
    }

    public List<Todo> getAll() {
        return new ArrayList<>(todos);
    }

    public Optional<Todo> findById(long id) {
        return todos.stream().filter(todo -> todo.getId() == id).findFirst();
    }

    public void delete(Todo todo) {
        todos.remove(todo);
    }

    public void add(Todo todo) {
        if (todo.getId() == 0) {
            todo.setId(todos.size() + 1);
            todo.setOrder(1);
        }
        todos.add(todo);
    }

}
