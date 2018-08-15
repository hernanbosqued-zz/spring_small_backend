package spring_small_backend;

import org.springframework.data.repository.CrudRepository;

interface TaskRepository extends CrudRepository<Task, Long> {
}
