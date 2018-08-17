package spring_small_backend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class TaskController {

    private final TaskRepository repository;

    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping(path = "/tasks")
    public @ResponseBody
    Iterable<Task> getTasks() {
        return repository.findAll();
    }

    @PostMapping("/tasks")
    public Task createNote(@Valid @RequestBody Task note) {
        return repository.save(note);
    }

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable(value = "id") long id) {
        return repository.findById(id).orElseThrow(null);
    }

    @PutMapping("/tasks/{id}")
    public Task updateNote(@PathVariable(value = "id") long id, @Valid @RequestBody Task task) {
        Task response = repository.findById(id).orElseThrow(null);
        response.setTitle(task.title);
        response.setDescription(task.description);
        response.setDone(task.done);
        return repository.save(response);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Task> deleteNote(@PathVariable(value = "id") long id) {
        Task note = repository.findById(id).orElseThrow(null);
        repository.delete(note);
        return ResponseEntity.ok().build();
    }
}
