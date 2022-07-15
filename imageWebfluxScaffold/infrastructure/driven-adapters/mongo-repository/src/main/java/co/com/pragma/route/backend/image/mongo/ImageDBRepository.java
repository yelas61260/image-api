package co.com.pragma.route.backend.image.mongo;

import co.com.pragma.route.backend.image.mongo.model.ImageData;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;

public interface ImageDBRepository extends ReactiveMongoRepository<ImageData, String>, ReactiveQueryByExampleExecutor<ImageData> {
}
