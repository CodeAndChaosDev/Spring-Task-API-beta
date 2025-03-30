package taskapi.circle.taskapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

import taskapi.circle.taskapi.models.User;
import taskapi.circle.taskapi.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    // Add methods to interact with the user repository as needed
    // For example, you can add methods to create, update, delete, and retrieve users
    // Example method to get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    // Example method to get a user by ID
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    // Example method to create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }
    // Example method to update an existing user
    public User updateUser(Long id, User user) {
        User existingUser = getUserById(id);
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            existingUser.setRole(user.getRole());
            return userRepository.save(existingUser);
        }
        return null;
    }

    // Example method to delete a user
    public User deleteUser(Long id) {
        User user = getUserById(id);
        if (user != null) {
            userRepository.delete(user);
        }
        return user;
    }
    // Example method to find a user by username
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    // Example method to find a user by email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    // Example method to find a user by role
    public List<User> findByRole(String role) {
        return userRepository.findByRole(role);
    }
    // Example method to find a user by username and email
    public User findByUsernameAndEmail(String username, String email) {
        return userRepository.findByUsernameAndEmail(username, email);
    }

    // Example method to find a user by username and password
    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
    // Example method to find a user by username and email and password
    public User findByUsernameAndEmailAndPassword(String username, String email, String password) {
        return userRepository.findByUsernameAndEmailAndPassword(username, email, password);
    }
    

}
