package com.pragma.route.backend.image.infrastructure.controller.api;

import java.net.URI;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.pragma.route.backend.image.ImageDtoDataTests;
import com.pragma.route.backend.image.ImageFileDataTests;
import com.pragma.route.backend.image.ApiResponseDataTests;
import com.pragma.route.backend.image.domain.exception.conflict.ImageConvertException;
import com.pragma.route.backend.image.domain.exception.conflict.ImageIdRequiredException;
import com.pragma.route.backend.image.domain.exception.notfound.ImageNotFoundException;
import com.pragma.route.backend.image.infrastructure.service.ImageApiService;

@WebMvcTest(controllers = ImageController.class)
public class ImageControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ImageApiService imageApiService;

	@BeforeEach
	public void setup() {		
		Mockito.when(imageApiService.create(ImageFileDataTests.multipartFileOk)).thenReturn(ImageDtoDataTests.imageOKCreated);
		Mockito.doThrow(RuntimeException.class).when(imageApiService).create(ImageFileDataTests.multipartFileErrorEmpty);
		Mockito.doThrow(ImageConvertException.class).when(imageApiService).create(ImageFileDataTests.multipartFileErrorNull);
		Mockito.doThrow(ImageConvertException.class).when(imageApiService).create(null);

		Mockito.when(imageApiService.update(ImageDtoDataTests.imageOKUpdated.getImageId(), ImageFileDataTests.multipartFileOk)).thenReturn(ImageDtoDataTests.imageOKUpdated);
		Mockito.doThrow(ImageIdRequiredException.class).when(imageApiService).update("", ImageFileDataTests.multipartFileOk);
		Mockito.doThrow(ImageIdRequiredException.class).when(imageApiService).update(null, ImageFileDataTests.multipartFileOk);
		Mockito.doThrow(ImageNotFoundException.class).when(imageApiService).update("NoExiste", ImageFileDataTests.multipartFileOk);
		Mockito.doThrow(RuntimeException.class).when(imageApiService).update(ImageDtoDataTests.imageOKUpdated.getImageId(), ImageFileDataTests.multipartFileErrorEmpty);
		Mockito.doThrow(ImageConvertException.class).when(imageApiService).update(ImageDtoDataTests.imageOKUpdated.getImageId(), ImageFileDataTests.multipartFileErrorNull);
		Mockito.doThrow(ImageConvertException.class).when(imageApiService).update(ImageDtoDataTests.imageOKUpdated.getImageId(), null);

		Mockito.when(imageApiService.getImageBase64(ImageDtoDataTests.imageOKCreated.getImageId())).thenReturn(ImageFileDataTests.stringBaseOk);
		Mockito.doThrow(ImageNotFoundException.class).when(imageApiService).getImageBase64("NoExiste");
		Mockito.doThrow(RuntimeException.class).when(imageApiService).getImageBase64("Error");
		Mockito.doThrow(RuntimeException.class).when(imageApiService).getImageBase64("");

		Mockito.when(imageApiService.getImageFile(ImageDtoDataTests.imageOKCreated.getImageId())).thenReturn(ImageFileDataTests.stringByteOk);
		Mockito.doThrow(ImageNotFoundException.class).when(imageApiService).getImageFile("NoExiste");
		Mockito.doThrow(RuntimeException.class).when(imageApiService).getImageFile("Error");
		Mockito.doThrow(RuntimeException.class).when(imageApiService).getImageFile("");
	}

	@Test
	public void create() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.multipart("/image/create")
				.file(ImageFileDataTests.multipartFileOk))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.equals(ApiResponseDataTests.response200Created);

		mockMvc.perform(MockMvcRequestBuilders.multipart("/image/create")
				.file(ImageFileDataTests.multipartFileErrorEmpty))
		.andExpect(MockMvcResultMatchers.status().is(500))
		.equals(ApiResponseDataTests.response500);

		mockMvc.perform(MockMvcRequestBuilders.multipart("/image/create")
				.file(ImageFileDataTests.multipartFileErrorNull))
		.andExpect(MockMvcResultMatchers.status().is(409))
		.equals(ApiResponseDataTests.response409);

		mockMvc.perform(MockMvcRequestBuilders.multipart("/image/create"))
		.andExpect(MockMvcResultMatchers.status().is(500));
	}
	
	@Test
	public void update() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.multipart(HttpMethod.PUT ,new URI("/image/PrueBa123U"))
				.file(ImageFileDataTests.multipartFileOk))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.equals(ApiResponseDataTests.response200Created);

		mockMvc.perform(MockMvcRequestBuilders.multipart(HttpMethod.PUT ,new URI("/image/NoExiste"))
				.file(ImageFileDataTests.multipartFileOk))
		.andExpect(MockMvcResultMatchers.status().is(404))
		.equals(ApiResponseDataTests.response404);

		mockMvc.perform(MockMvcRequestBuilders.multipart(HttpMethod.PUT ,new URI("/image/PrueBa123U"))
				.file(ImageFileDataTests.multipartFileErrorEmpty))
		.andExpect(MockMvcResultMatchers.status().is(500))
		.equals(ApiResponseDataTests.response500);

		mockMvc.perform(MockMvcRequestBuilders.multipart(HttpMethod.PUT ,new URI("/image/PrueBa123U"))
				.file(ImageFileDataTests.multipartFileErrorNull))
		.andExpect(MockMvcResultMatchers.status().is(409))
		.equals(ApiResponseDataTests.response409);

		mockMvc.perform(MockMvcRequestBuilders.multipart(HttpMethod.PUT ,new URI("/image/"))
				.file(ImageFileDataTests.multipartFileOk))
		.andExpect(MockMvcResultMatchers.status().is(404));
	}
	
	@Test
	public void getImageBase64() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/image/PrueBa123C/base64"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string(ImageFileDataTests.stringBaseOk));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/image/NoExiste/base64"))
		.andExpect(MockMvcResultMatchers.status().is(404))
		.equals(ApiResponseDataTests.response404);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/image/Error/base64"))
		.andExpect(MockMvcResultMatchers.status().is(500))
		.equals(ApiResponseDataTests.response500);

		mockMvc.perform(MockMvcRequestBuilders.get("/image//base64"))
		.andExpect(MockMvcResultMatchers.status().is(500));
	}
	
	@Test
	public void getImageFile() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/image/PrueBa123C/file"))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().bytes(ImageFileDataTests.stringByteOk));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/image/NoExiste/file"))
		.andExpect(MockMvcResultMatchers.status().is(404))
		.equals(ApiResponseDataTests.response404);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/image/Error/file"))
		.andExpect(MockMvcResultMatchers.status().is(500))
		.equals(ApiResponseDataTests.response500);

		mockMvc.perform(MockMvcRequestBuilders.get("/image//file"))
		.andExpect(MockMvcResultMatchers.status().is(500));
	}

}
