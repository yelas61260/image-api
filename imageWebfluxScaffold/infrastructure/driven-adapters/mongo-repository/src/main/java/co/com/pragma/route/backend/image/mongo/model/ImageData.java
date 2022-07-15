package co.com.pragma.route.backend.image.mongo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("image-repo")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageData {

    @Id
    private String id;

    private String imageName;
    private String bodyBase64;

}
