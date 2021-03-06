package org.macesdev.stillflap.scripts;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.*;
import org.macesdev.stillflap.run;

public class setLanguageVeriable {
	public static String lang;
	static String jsonData;
	static String path = run.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "/gameConfig.json";

	
	public static String parseJSON(String gettingValue) throws JSONException, IOException {
		File myObj = new File(path);
	    Scanner myReader = new Scanner(myObj);
	    while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        jsonData = data;
	    }
	    myReader.close();
	    
	    JSONObject obj = new JSONObject(jsonData);  

		return obj.getString(gettingValue);
	}
	
	public static void createJSON(String ver) throws IOException {
        JSONObject jo = new JSONObject();
          
        try {
	        jo.put("language", org.macesdev.stillflap.scripts.languageSettings.script(false, null));
	        jo.put("version", ver);
	        jo.put("nextVersion", org.macesdev.stillflap.assets.lang.general.nextVersionSTR);
		} catch (JSONException e) {
			e.printStackTrace();
		}

          
	    String jsonContent = jo.toString();
	    BufferedWriter writer = new BufferedWriter(new FileWriter(path));
	    writer.write(jsonContent);
	    writer.close();
	}
}