package taskapi.circle.taskapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;
    private String role;
    private String createdAt;
    private String updatedAt;
 
    @ManyToOne
    @JoinColumn(name = "workspace_id", nullable = true)
    private WorkSpace workspace; 
    
}
