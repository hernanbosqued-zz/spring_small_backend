package spring_small_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository repository;

    //private final AtomicLong counter = new AtomicLong();
    //@RequestMapping("/greeting")
    //public Task greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
    //    return new Task(counter.incrementAndGet(), name,"description", true);
    //}

    @GetMapping(path="/add") // Map ONLY GET Requests
    //public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email) {
    public @ResponseBody String addNewUser () {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        Task n = new Task();
        n.setDescription("lombok description");
        n.setTitle("lombok title");
        n.setDone(true);
        repository.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody
    Iterable<Task> getTasks() {
        return repository.findAll();
    }
}
