package shopping_app.services;
import lombok.AllArgsConstructor;
import java.io.File;
import static shopping_app.constant.Constant.RESOURCE_PATH;

public class ResourcesService {

	@AllArgsConstructor
	public enum Resource {

		ADMIN("admin"), CUSTOMER("customer"), ITEMS("items");

		private String value;
	}

	public File getFileByResourceName(Resource resource) {
		return new File(RESOURCE_PATH + resource.value + ".txt");
	}

}
