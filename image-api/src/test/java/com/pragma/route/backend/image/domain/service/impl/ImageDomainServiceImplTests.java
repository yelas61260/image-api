package com.pragma.route.backend.image.domain.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Base64;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.image.domain.exception.conflict.ImageConvertException;
import com.pragma.route.backend.image.domain.exception.conflict.ResourceIdInvalidException;
import com.pragma.route.backend.image.domain.exception.notfound.ResourceTypeNotFoundException;
import com.pragma.route.backend.image.domain.model.Image;
import com.pragma.route.backend.image.domain.service.ImageDomainService;
import com.pragma.route.backend.image.domain.service.util.ImageConverterDomainService;
import com.pragma.route.backend.image.domain.service.validator.ImageValidatorDomainService;

@SpringBootTest
public class ImageDomainServiceImplTests {
	
	@Mock
	private ImageValidatorDomainService imageValidatorService;
	
	@Mock
	private ImageConverterDomainService imageConverterDomainService;
	
	private ImageDomainService imageDomainService;
	
	private Image imageOK1;
	private Image imageOK2;
	
	@BeforeEach
	public void setup() {
		imageDomainService = new ImageDomainServiceImpl(imageValidatorService, imageConverterDomainService);
		
		String originalString = "Contenido";
		String stringBase = Base64.getEncoder().encodeToString(originalString.getBytes());
		byte[] stringByte = Base64.getDecoder().decode(stringBase);
		
		imageOK1 = Image.builder()
				.associationType(1)
				.resourceId(1)
				.imageName("imagen")
				.bodyBase64(stringBase)
				.build();
		
		imageOK2 = Image.builder()
				.associationType(1)
				.resourceId(1)
				.build();
		
		Image imageERROR1 = Image.builder()
				.associationType(0)
				.resourceId(1)
				.imageName("imagen")
				.bodyBase64(stringBase)
				.build();
		
		Image imageERROR2 = Image.builder()
				.associationType(1)
				.resourceId(0)
				.imageName("imagen")
				.bodyBase64(stringBase)
				.build();
		
		Image imageERROR3 = Image.builder()
				.associationType(0)
				.resourceId(1)
				.build();
		
		Image imageERROR4 = Image.builder()
				.associationType(1)
				.resourceId(0)
				.build();
		
		Mockito.when(imageConverterDomainService.convertBase64StringToImageFile(stringBase)).thenReturn(stringByte);
		Mockito.doThrow(ImageConvertException.class).when(imageConverterDomainService).convertBase64StringToImageFile("");
		Mockito.doThrow(ImageConvertException.class).when(imageConverterDomainService).convertBase64StringToImageFile(null);
		
		Mockito.when(imageConverterDomainService.convertImageFileToBase64String(stringByte)).thenReturn(stringBase);
		Mockito.doThrow(ImageConvertException.class).when(imageConverterDomainService).convertImageFileToBase64String(new byte[0]);
		Mockito.doThrow(ImageConvertException.class).when(imageConverterDomainService).convertImageFileToBase64String(null);
		
		Mockito.doNothing().when(imageValidatorService).validateImage(imageOK1);
		Mockito.doNothing().when(imageValidatorService).validateImage(imageOK2);
		Mockito.doThrow(ResourceTypeNotFoundException.class).when(imageValidatorService).validateImage(imageERROR1);
		Mockito.doThrow(ResourceIdInvalidException.class).when(imageValidatorService).validateImage(imageERROR2);
		Mockito.doThrow(ResourceTypeNotFoundException.class).when(imageValidatorService).validateImage(imageERROR3);
		Mockito.doThrow(ResourceIdInvalidException.class).when(imageValidatorService).validateImage(imageERROR4);
		
	}

	@Test
	public void prepareToCreate() {
		String originalString = "Contenido";
		String stringBase = Base64.getEncoder().encodeToString(originalString.getBytes());
		byte[] stringByte = Base64.getDecoder().decode(stringBase);
		
		assertThat(imageDomainService.prepareToCreate(1, 1, "imagen", stringByte)).isEqualTo(imageOK1);
		assertThrows(ResourceTypeNotFoundException.class, () -> imageDomainService.prepareToCreate(0, 1, "imagen", stringByte));
		assertThrows(ResourceIdInvalidException.class, () -> imageDomainService.prepareToCreate(1, 0, "imagen", stringByte));
		assertThrows(ImageConvertException.class, () -> imageDomainService.prepareToCreate(1, 1, "imagen", null));
		assertThrows(ImageConvertException.class, () -> imageDomainService.prepareToCreate(1, 1, "imagen", new byte[0]));
	}

	@Test
	public void prepareToUpdate() {
		String originalString = "Contenido";
		String stringBase = Base64.getEncoder().encodeToString(originalString.getBytes());
		byte[] stringByte = Base64.getDecoder().decode(stringBase);
		
		assertThat(imageDomainService.prepareToUpdate(1, 1, "imagen", stringByte)).isEqualTo(imageOK1);
		assertThrows(ResourceTypeNotFoundException.class, () -> imageDomainService.prepareToUpdate(0, 1, "imagen", stringByte));
		assertThrows(ResourceIdInvalidException.class, () -> imageDomainService.prepareToUpdate(1, 0, "imagen", stringByte));
		assertThrows(ImageConvertException.class, () -> imageDomainService.prepareToUpdate(1, 1, "imagen", null));
		assertThrows(ImageConvertException.class, () -> imageDomainService.prepareToUpdate(1, 1, "imagen", new byte[0]));
	}

	@Test
	public void getByAssociationTypeAndResourceId() {		
		assertThat(imageDomainService.getByAssociationTypeAndResourceId(1, 1)).isEqualTo(imageOK2);
		assertThrows(ResourceTypeNotFoundException.class, () -> imageDomainService.getByAssociationTypeAndResourceId(0, 1));
		assertThrows(ResourceIdInvalidException.class, () -> imageDomainService.getByAssociationTypeAndResourceId(1, 0));
	}

}
