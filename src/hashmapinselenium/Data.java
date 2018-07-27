package hashmapinselenium;

import java.util.HashMap;
import java.util.Map;

public class Data {
	
	public static Map<String, String> credentialsMap(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("admin", "Admin:admin123");
		return map;
	}

}
