package taskapi.circle.taskapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import taskapi.circle.taskapi.models.WorkSpace;

@Repository
public interface WorkSpaceRepository extends JpaRepository<WorkSpace, Long> {
    
}
