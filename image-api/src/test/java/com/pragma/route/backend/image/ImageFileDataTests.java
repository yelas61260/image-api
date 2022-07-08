package com.pragma.route.backend.image;

import java.util.Base64;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

@SpringBootTest
public class ImageFileDataTests {

	public static String stringBaseOk = Base64.getEncoder().encodeToString("Contenido".getBytes());
	public static String stringBaseErrorEmpty = "";
	public static String stringBaseErrorNull = null;
	public static byte[] stringByteOk = Base64.getDecoder().decode(stringBaseOk);
	public static byte[] stringByteErrorEmpty = new byte[0];
	public static byte[] stringByteErrorNull = null;
	public static MockMultipartFile multipartFileOk = new MockMultipartFile("mi imagen", stringByteOk);
	public static MockMultipartFile multipartFileErrorEmpty = new MockMultipartFile("mi imagen", stringByteErrorEmpty);
	public static MockMultipartFile multipartFileErrorNull = new MockMultipartFile("mi imagen", stringByteErrorNull);

}