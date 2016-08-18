package com.easyar.tool;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.concurrent.ExecutionException;

import org.json.JSONException;



public class Tools {
	public static String Str2Img(String name,String image) throws IOException, JSONException, InterruptedException, ExecutionException{
		
		String folderpath  = System.getProperty("user.dir") +"\\Pic";
		Path path = Paths.get(folderpath , name+".jpg");
		Files.write(path, Base64.getDecoder().decode(image));
		String PicPath = folderpath+"\\"+name+".jpg";	
		return PicPath;
		
	}
	
	public static void main(String[] args) throws IOException, JSONException, InterruptedException, ExecutionException {
		String str  = Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get("ar02.jpg")));
		System.out.println(Str2Img("004",str));
	}
	
	
}
