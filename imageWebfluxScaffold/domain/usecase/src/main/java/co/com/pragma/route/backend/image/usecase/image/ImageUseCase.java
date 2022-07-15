package co.com.pragma.route.backend.image.usecase.image;

import co.com.pragma.route.backend.image.model.image.Image;
import co.com.pragma.route.backend.image.model.image.gateways.ImageRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ImageUseCase {
    private final ImageRepository imageRepository;

    public Mono<Image> getById(String imageId) {
        return imageRepository.getById(imageId);
    }

    public Mono<Image> create(Image image) {
        return imageRepository.create(image);
    }

    public Mono<Image> update(Image image) {
        return imageRepository.update(image);
    }
}
