package taskapi.circle.taskapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import taskapi.circle.taskapi.models.Task;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByCompleted(boolean completed);
    List<Task> findByTitleContainingIgnoreCase(String title);
    List<Task> findByDescriptionContainingIgnoreCase(String description);
    List<Task> findByTitleContainingIgnoreCaseAndDescriptionContainingIgnoreCase(String title, String description);
    List<Task> findByTitleContainingIgnoreCaseAndCompleted(String title, boolean completed);
}