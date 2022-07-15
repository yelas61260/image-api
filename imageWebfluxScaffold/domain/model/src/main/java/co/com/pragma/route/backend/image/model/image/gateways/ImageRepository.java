package co.com.pragma.route.backend.image.model.image.gateways;

import co.com.pragma.route.backend.image.model.image.Image;
import reactor.core.publisher.Mono;

public interface ImageRepository {

    Mono<Image> getById(String imageId);
    Mono<Image> create(Image image);
    Mono<Image> update(Image image);

}
