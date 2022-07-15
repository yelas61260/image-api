package co.com.pragma.route.backend.image.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class RouterRest {
@Bean
public RouterFunction<ServerResponse> routerFunction(Handler handler) {
    return route(GET("/api/image/{id}"), handler::getImageById)
            .andRoute(POST("/api/image"), handler::create)
            .andRoute(PUT("/api/image/{id}"), handler::update)
            .andRoute(GET("/api/image/{id}/file"), handler::getImageFileById);
    }
}
