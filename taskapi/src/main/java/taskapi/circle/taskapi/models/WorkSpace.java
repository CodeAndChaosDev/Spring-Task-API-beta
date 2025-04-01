package taskapi.circle.taskapi.models;


import java.util.List;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "workspace")
@Getter
@Setter
@NoArgsConstructor 
@AllArgsConstructor
public class WorkSpace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String createdAt;
    private String updatedAt;
    private String ownerId;

    @OneToMany(mappedBy = "workspace", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Task> tasks; 
    @OneToMany(mappedBy = "workspace", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<User> users; 


}
