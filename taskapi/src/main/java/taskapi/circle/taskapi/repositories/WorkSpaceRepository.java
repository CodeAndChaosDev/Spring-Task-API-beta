package taskapi.circle.taskapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import taskapi.circle.taskapi.models.WorkSpace;

@Repository
public interface WorkSpaceRepository extends JpaRepository<WorkSpace, Long> {

    public List<WorkSpace> findByName(String name);

    public List<WorkSpace> findByDescription(String description);

    public List<WorkSpace> findByNameAndDescription(String name, String description);

    public List<WorkSpace> findByNameOrDescription(String name, String description);

    public List<WorkSpace> findByNameAndDescriptionAndId(String name, String description, Long id);

    public List<WorkSpace> findByNameOrDescriptionAndId(String name, String description, Long id);
    
}
