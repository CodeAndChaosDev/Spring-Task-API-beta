package taskapi.circle.taskapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import taskapi.circle.taskapi.models.User;
import taskapi.circle.taskapi.models.Task;
import taskapi.circle.taskapi.models.WorkSpace;
import taskapi.circle.taskapi.repositories.TaskRepository;
import taskapi.circle.taskapi.repositories.UserRepository;
import taskapi.circle.taskapi.repositories.WorkSpaceRepository;

@Service
public class WorkSpaceService {
    private final WorkSpaceRepository workSpaceRepository;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    
    public WorkSpaceService(WorkSpaceRepository workSpaceRepository, TaskRepository taskRepository, UserRepository userRepository) {
        this.workSpaceRepository = workSpaceRepository;
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }
    @Transactional
    public List<WorkSpace> getAllWorkSpaces() {
        return workSpaceRepository.findAll();
    }
    
    @Transactional  // 👈 Keeps the Hibernate session open
    public WorkSpace getWorkspaceWithDetails(Long workspaceId) {
        WorkSpace workspace = workSpaceRepository.findById(workspaceId)
                .orElseThrow(() -> new RuntimeException("Workspace not found"));
        workspace.getTasks().size();  // 👈 Forces initialization
        workspace.getUsers().size();  // 👈 Forces initialization
        return workspace;
    }

    public WorkSpace createWorkSpace(WorkSpace workSpace) {
        return workSpaceRepository.save(workSpace);
    }
    public WorkSpace updateWorkSpace(Long id, WorkSpace workSpace) {
        WorkSpace existingWorkSpace = getWorkspaceWithDetails(id);
        if (existingWorkSpace != null) {
            existingWorkSpace.setName(workSpace.getName());
            existingWorkSpace.setDescription(workSpace.getDescription());
            return workSpaceRepository.save(existingWorkSpace);
        }
        return null;
    }
    public WorkSpace deleteWorkSpace(Long id) {
        WorkSpace workSpace = getWorkspaceWithDetails(id);
        if (workSpace != null) {
            workSpaceRepository.delete(workSpace);
        }
        return workSpace;
    }
    public List<WorkSpace> findByName(String name) {
        return workSpaceRepository.findByName(name);
    }
    public List<WorkSpace> findByDescription(String description) {
        return workSpaceRepository.findByDescription(description);
    }
    public List<WorkSpace> findByNameAndDescription(String name, String description) {
        return workSpaceRepository.findByNameAndDescription(name, description);
    }
    public List<WorkSpace> findByNameOrDescription(String name, String description) {
        return workSpaceRepository.findByNameOrDescription(name, description);
    }
    public List<WorkSpace> findByNameAndDescriptionAndId(String name, String description, Long id) {
        return workSpaceRepository.findByNameAndDescriptionAndId(name, description, id);
    }

    public List<WorkSpace> findByNameOrDescriptionAndId(String name, String description, Long id) {
        return workSpaceRepository.findByNameOrDescriptionAndId(name, description, id);
    }

     // Associate existing task with a workspace
     public WorkSpace addTaskToWorkspace(Long workspaceId, Long taskId) {
        WorkSpace workspace = workSpaceRepository.findById(workspaceId)
                .orElseThrow(() -> new RuntimeException("Workspace not found"));

        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setWorkspace(workspace);
        taskRepository.save(task);

        return workSpaceRepository.findById(workspaceId).get();
    }

     // Associate existing user with a workspace
     public WorkSpace addUserToWorkspace(Long workspaceId, Long userId) {
        WorkSpace workspace = workSpaceRepository.findById(workspaceId)
                .orElseThrow(() -> new RuntimeException("Workspace not found"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setWorkspace(workspace);
        userRepository.save(user);

        return workSpaceRepository.findById(workspaceId).get();
    }


}
