package taskapi.circle.taskapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import taskapi.circle.taskapi.models.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);
    // Custom query methods can be defined here if needed

    public User findByEmail(String email);

    public List<User> findByRole(String role);

    public User findByUsernameAndEmail(String username, String email);

    public User findByUsernameAndPassword(String username, String password);

    public User findByUsernameAndEmailAndPassword(String username, String email, String password);

    
}
