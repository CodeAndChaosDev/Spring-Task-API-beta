package taskapi.circle.taskapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import taskapi.circle.taskapi.models.WorkSpace;
import taskapi.circle.taskapi.repositories.WorkSpaceRepository;

@Service
public class WorkSpaceService {
    private final WorkSpaceRepository workSpaceRepository;
    public WorkSpaceService(WorkSpaceRepository workSpaceRepository) {
        this.workSpaceRepository = workSpaceRepository;
    }
    public List<WorkSpace> getAllWorkSpaces() {
        return workSpaceRepository.findAll();
    }
    
    public WorkSpace getWorkSpaceById(Long id) {
        return workSpaceRepository.findById(id).orElse(null);
    }
    public WorkSpace createWorkSpace(WorkSpace workSpace) {
        return workSpaceRepository.save(workSpace);
    }
    public WorkSpace updateWorkSpace(Long id, WorkSpace workSpace) {
        WorkSpace existingWorkSpace = getWorkSpaceById(id);
        if (existingWorkSpace != null) {
            existingWorkSpace.setName(workSpace.getName());
            existingWorkSpace.setDescription(workSpace.getDescription());
            return workSpaceRepository.save(existingWorkSpace);
        }
        return null;
    }
    public WorkSpace deleteWorkSpace(Long id) {
        WorkSpace workSpace = getWorkSpaceById(id);
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


}
