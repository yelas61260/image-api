package co.com.pragma.route.backend.image.usecase.converter;

import co.com.pragma.route.backend.image.model.image.exception.ImageConvertException;
import lombok.RequiredArgsConstructor;

import java.util.Base64;

@RequiredArgsConstructor
public class ConverterUseCase {

    public byte[] convertBase64StringToImageFile(String imageString) {
        if (imageString == null || imageString.isEmpty()) {
            throw new ImageConvertException();
        }
        return Base64.getDecoder().decode(imageString);
    }
}
