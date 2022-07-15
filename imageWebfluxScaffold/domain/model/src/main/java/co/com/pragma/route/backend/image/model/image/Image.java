package co.com.pragma.route.backend.image.model.image;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Image {

    private String id;
    private String imageName;
    private String bodyBase64;

}
