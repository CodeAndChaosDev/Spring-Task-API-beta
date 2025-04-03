package taskapi.circle.taskapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkSpaceDTO {
    private Long id;
    private String name;
    private String description;
    private String createdAt;
    private String updatedAt;
    private String ownerId;

}
