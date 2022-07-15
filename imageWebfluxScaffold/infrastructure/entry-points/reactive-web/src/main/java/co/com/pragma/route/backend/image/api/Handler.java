package co.com.pragma.route.backend.image.api;

import co.com.pragma.route.backend.image.model.image.Image;
import co.com.pragma.route.backend.image.usecase.converter.ConverterUseCase;
import co.com.pragma.route.backend.image.usecase.image.ImageUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {
    private final ImageUseCase imageUseCase;
    private final ConverterUseCase converterUseCase;

    public Mono<ServerResponse> getImageById(ServerRequest serverRequest) {
        String customerId = serverRequest.pathVariable("id");
        return imageUseCase.getById(customerId)
                .flatMap(img -> ServerResponse.ok().bodyValue(img))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> getImageFileById(ServerRequest serverRequest) {
        String customerId = serverRequest.pathVariable("id");
        return imageUseCase.getById(customerId)
                .flatMap(img -> ServerResponse.ok().bodyValue(
                        converterUseCase.convertBase64StringToImageFile(img.getBodyBase64())
                        )
                )
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> create(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Image.class)
                .flatMap(img -> imageUseCase.create(img))
                .flatMap(img -> ServerResponse.ok().bodyValue(img))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> update(ServerRequest serverRequest) {
        String customerId = serverRequest.pathVariable("id");
        return serverRequest.bodyToMono(Image.class)
                .flatMap(img -> {
                    img.setId(customerId);
                    return imageUseCase.update(img);
                })
                .flatMap(img -> ServerResponse.ok().bodyValue(img))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
