package spring_small_backend;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String title;
    String description;
    boolean done;

    Task(){
    }

    Task(String title, String description, boolean done) {
        this.title = title;
        this.description = description;
        this.done = done;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return done;
    }
}