package practice;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class DeserializeJson {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {

		ObjectMapper mapper=new ObjectMapper();
		RMGYantraPojo obj = mapper.readValue(new File("./rmgyantra.json"), RMGYantraPojo.class);
		System.out.println(obj.getCreatedBy());
	}

}
