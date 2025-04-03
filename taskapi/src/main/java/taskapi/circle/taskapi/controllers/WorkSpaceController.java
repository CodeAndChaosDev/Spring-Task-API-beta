package taskapi.circle.taskapi.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import taskapi.circle.taskapi.models.WorkSpace;
import taskapi.circle.taskapi.services.WorkSpaceService;


@RestController
@RequestMapping("/workspaces")
@CrossOrigin(origins = "*")
public class WorkSpaceController {
    private final WorkSpaceService workSpaceService;
    public WorkSpaceController(WorkSpaceService workSpaceService) {
        this.workSpaceService = workSpaceService;
    }
    
    @GetMapping
    public List<WorkSpace> getAllWorkSpaces() {
        return workSpaceService.getAllWorkSpaces();
    }
    @GetMapping("/{id}")
    public WorkSpace getWorkSpaceById(@PathVariable Long id) {
        return workSpaceService.getWorkspaceWithDetails(id);
    }
    @PostMapping
    public WorkSpace createWorkSpace(@RequestBody WorkSpace workSpace) {
        return workSpaceService.createWorkSpace(workSpace);
    }
    @PutMapping("/{id}")
    public WorkSpace updateWorkSpace(@PathVariable Long id, @RequestBody WorkSpace workSpace) {
        return workSpaceService.updateWorkSpace(id, workSpace);
    }
    @DeleteMapping("/{id}")
    public WorkSpace deleteWorkSpace(@PathVariable Long id) {
        return workSpaceService.deleteWorkSpace(id);
    }
    @GetMapping("/name/{name}")
    public List<WorkSpace> getWorkSpacesByName(@PathVariable String name) {
        return workSpaceService.findByName(name);
    }
    @GetMapping("/description/{description}")
    public List<WorkSpace> getWorkSpacesByDescription(@PathVariable String description) {
        return workSpaceService.findByDescription(description);
    }
    @GetMapping("/nameAndDescription/{name}/{description}")
    public List<WorkSpace> getWorkSpacesByNameAndDescription(@PathVariable String name, @PathVariable String description) {
        return workSpaceService.findByNameAndDescription(name, description);
    }
    @GetMapping("/nameOrDescription/{name}/{description}")
    public List<WorkSpace> getWorkSpacesByNameOrDescription(@PathVariable String name, @PathVariable String description) {
        return workSpaceService.findByNameOrDescription(name, description);
    }
    @GetMapping("/nameAndDescriptionAndId/{name}/{description}/{id}")
    public List<WorkSpace> getWorkSpacesByNameAndDescriptionAndId(@PathVariable String name, @PathVariable String description, @PathVariable Long id) {
        return workSpaceService.findByNameAndDescriptionAndId(name, description, id);
    }

     // API to add an existing task to a workspace
    @PutMapping("/{workspaceId}/tasks/{taskId}")
    public ResponseEntity<WorkSpace> addTaskToWorkspace(
            @PathVariable Long workspaceId, @PathVariable Long taskId) {
        WorkSpace updatedWorkspace = workSpaceService.addTaskToWorkspace(workspaceId, taskId);
        return ResponseEntity.ok(updatedWorkspace);
    }

     // API to add an existing user to a workspace
     @PutMapping("/{workspaceId}/users/{userId}")
     public ResponseEntity<WorkSpace> addUserToWorkspace(
             @PathVariable Long workspaceId, @PathVariable Long userId) {
         WorkSpace updatedWorkspace = workSpaceService.addUserToWorkspace(workspaceId, userId);
         return ResponseEntity.ok(updatedWorkspace);
     }
}
    
