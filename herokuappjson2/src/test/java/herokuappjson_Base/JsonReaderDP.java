package herokuappjson_Base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

public class JsonReaderDP {

	@DataProvider(name = "jsondata")
	public String[] getJsondata() {
		
		JSONParser jsonParser = new JSONParser();
		FileReader reader = null;
		Object obj = null;

		try {
			reader = new FileReader("./src/test/resources/TestData.json");
			obj = jsonParser.parse(reader);
		} catch (FileNotFoundException e1) {

			e1.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		} catch (ParseException e) {

			e.printStackTrace();
		}
		JSONArray data = (JSONArray) obj;
		String arr[]=new String[data.size()];
for(int i=0;i<data.size();i++) {
		JSONObject jsonobj = (JSONObject) data.get(i);
		String username = (String) jsonobj.get("username");
		String password = (String) jsonobj.get("password");
		arr[i] = username + "," + password;
}
	return arr;

		
		
	}

}
