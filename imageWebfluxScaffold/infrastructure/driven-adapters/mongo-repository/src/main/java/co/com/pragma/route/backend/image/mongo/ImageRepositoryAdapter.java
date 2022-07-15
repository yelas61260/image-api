package co.com.pragma.route.backend.image.mongo;

import co.com.pragma.route.backend.image.model.image.Image;
import co.com.pragma.route.backend.image.model.image.gateways.ImageRepository;
import co.com.pragma.route.backend.image.mongo.helper.AdapterOperations;
import co.com.pragma.route.backend.image.mongo.model.ImageData;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class ImageRepositoryAdapter extends AdapterOperations<Image, ImageData, String, ImageDBRepository>
 implements ImageRepository
{

    public ImageRepositoryAdapter(ImageDBRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Image.class));
    }

    @Override
    public Mono<Image> getById(String imageId) {
        return super.findById(imageId);
    }

    @Override
    public Mono<Image> create(Image image) {
        return super.save(image);
    }

    @Override
    public Mono<Image> update(Image image) {
        return super.save(image);
    }
}
