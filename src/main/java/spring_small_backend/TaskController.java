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
    ResponseEntity<DataResponse<Iterable<Task>>> getTasks() {
        return ResponseEntity.ok().body(new DataResponse<>(true, repository.findAll()));
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<DataResponse<Task>> getTask(@PathVariable(value = "id") long id) {
        return ResponseEntity.ok().body(new DataResponse<>(true, repository.findById(id).orElseThrow(null)));
    }

    @PostMapping("/tasks")
    public ResponseEntity<DataResponse<Task>> createNote(@Valid @RequestBody Task task) {
        return ResponseEntity.ok().body(new DataResponse<>(true, repository.save(task)));
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<DataResponse<Task>> updateNote(@PathVariable(value = "id") long id, @Valid @RequestBody Task task) {
        Task response = repository.findById(id).orElseThrow(null);
        response.setTitle(task.title);
        response.setDescription(task.description);
        response.setDone(task.done);
        return ResponseEntity.ok().body(new DataResponse<>(true, repository.save(response)));
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Response> deleteNote(@PathVariable(value = "id") long id) {
        Task note = repository.findById(id).orElseThrow(null);
        repository.delete(note);
        return ResponseEntity.ok().body(new Response(true));
    }
}
