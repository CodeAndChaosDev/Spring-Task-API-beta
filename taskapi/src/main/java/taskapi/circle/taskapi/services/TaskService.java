package taskapi.circle.taskapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import taskapi.circle.taskapi.models.Task;
import taskapi.circle.taskapi.repositories.TaskRepository;



@Service
public class TaskService {
    private  final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;

    }   
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public Task removeTask(Long id) {
        Task task = getTaskById(id);
        if (task != null) {
            taskRepository.delete(task);
        }
        return task;
    }
    public Task updateTask(Long id, Task task) {
        Task existingTask = getTaskById(id);
        if (existingTask != null) {
            existingTask.setTitle(task.getTitle());
            existingTask.setDescription(task.getDescription());
            existingTask.setCompleted(task.getCompleted());
            return taskRepository.save(existingTask);
        }
        return null;
    }

}

