package co.com.pragma.route.backend.image.model.image.exception.notfound;

public class ImageNotFoundException extends ApiNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ImageNotFoundException() {
		super("Image not found");
	}

}
