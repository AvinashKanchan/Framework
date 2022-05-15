package practice;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;


public class SerializeJson {
	
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		
		RMGYantraPojo rmg=new RMGYantraPojo("Punit", "Sony", "Completed", 10);
		
		ObjectMapper mapper=new ObjectMapper();
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File("./rmgyantra.json"), rmg);
		System.out.println("object is serialized");
	}

}
