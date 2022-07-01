package com.pragma.route.backend.image.application.service.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Base64;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.image.application.dto.ImageDTO;
import com.pragma.route.backend.image.application.mapper.ImageWithDtoMapper;
import com.pragma.route.backend.image.application.service.ImageService;
import com.pragma.route.backend.image.domain.model.Image;
import com.pragma.route.backend.image.domain.service.ImageDomainService;

@SpringBootTest
public class ImageServiceImplTests {
	
	private ImageService imageService;
	
	@Mock
	private ImageDomainService imageDomainService;
	
	@Mock
	private ImageWithDtoMapper imageWithDtoMapper;

	private Image imageOk1;
	private Image imageOk2;
	private ImageDTO imageDtoOk1;
	private ImageDTO imageDtoOk2;
	private ImageDTO imageDtoError1;
	private ImageDTO imageDtoError2;
	
	private String stringBase;
	private byte[] stringByte;
	
	@BeforeEach
	public void setup() {
		imageService = new ImageServiceImpl(imageDomainService, imageWithDtoMapper);
		
		String originalString = "Contenido";
		stringBase = Base64.getEncoder().encodeToString(originalString.getBytes());
		stringByte = Base64.getDecoder().decode(stringBase);	

		imageOk1 = Image.builder()
				.associationType(1)
				.resourceId(1)
				.bodyBase64(stringBase)
				.imageName("imagen")
				.build();

		imageOk2 = Image.builder()
				.associationType(1)
				.resourceId(1)
				.build();
		
		imageDtoOk1 = ImageDTO.builder()
				.associationType(1)
				.resourceId(1)
				.imageBase64(stringBase)
				.imageName("imagen")
				.build();
		
		imageDtoOk2 = ImageDTO.builder()
				.associationType(1)
				.resourceId(1)
				.build();
		
		imageDtoError1 = ImageDTO.builder()
				.associationType(1)
				.resourceId(2)
				.imageBase64("Content2")
				.imageName("imagen2")
				.build();
		
		imageDtoError2 = ImageDTO.builder()
				.associationType(1)
				.resourceId(2)
				.build();
		
		Mockito.when(imageDomainService.prepareToCreate(1, 1, "imagen", stringByte)).thenReturn(imageOk1);
		Mockito.when(imageDomainService.prepareToUpdate(1, 1, "imagen", stringByte)).thenReturn(imageOk1);
		Mockito.when(imageDomainService.getByAssociationTypeAndResourceId(1, 1)).thenReturn(imageOk2);		

		Mockito.when(imageWithDtoMapper.toDto(imageOk1)).thenReturn(imageDtoOk1);
		Mockito.when(imageWithDtoMapper.toDto(imageOk2)).thenReturn(imageDtoOk2);
		Mockito.when(imageWithDtoMapper.toEntity(imageDtoOk1)).thenReturn(imageOk1);
		Mockito.when(imageWithDtoMapper.toEntity(imageDtoOk2)).thenReturn(imageOk2);
	}

	@Test
	public void getByAssociationTypeAndResourceId() {
		assertThat(imageService.getByAssociationTypeAndResourceId(1, 1)).isEqualTo(imageDtoOk2);
		assertThat(imageService.getByAssociationTypeAndResourceId(1, 1)).isNotEqualTo(imageDtoOk1);
		assertThat(imageService.getByAssociationTypeAndResourceId(1, 1)).isNotEqualTo(imageDtoError1);
		assertThat(imageService.getByAssociationTypeAndResourceId(1, 1)).isNotEqualTo(imageDtoError2);
	}

	@Test
	public void prepareToCreate() {
		assertThat(imageService.prepareToCreate(1, 1, "imagen", stringByte)).isEqualTo(imageDtoOk1);
		assertThat(imageService.prepareToCreate(1, 1, "imagen", stringByte)).isNotEqualTo(imageDtoError1);
		assertThat(imageService.prepareToCreate(1, 1, "imagen", stringByte)).isNotEqualTo(imageDtoError2);
	}

	@Test
	public void prepareToUpdate() {
		assertThat(imageService.prepareToUpdate(1, 1, "imagen", stringByte)).isEqualTo(imageDtoOk1);
		assertThat(imageService.prepareToUpdate(1, 1, "imagen", stringByte)).isNotEqualTo(imageDtoError1);
		assertThat(imageService.prepareToUpdate(1, 1, "imagen", stringByte)).isNotEqualTo(imageDtoError2);
	}

}
