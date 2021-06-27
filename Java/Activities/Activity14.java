package activities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class Activity14 {

	public static void main(String[] args) throws IOException {
		File file = new File("src/new1.txt");
		boolean fStatus = file.createNewFile();
		if(fStatus)
			System.out.println("File created successfully");
		else
			System.out.println("File already present");
		
		FileWriter fw=new FileWriter("src/new1.txt");    
        fw.write("Hello World!!");   
        fw.write("Welcome to the world of coding");
        fw.close();  
		
		//get the file Object
		File fileUtil = FileUtils.getFile("src/new1.txt");
		//Read file
		System.out.println("Data in file: " + FileUtils.readFileToString(fileUtil, "UTF8"));
		
		//Create directory
		File destDir = new File("resourcesfile");
		System.out.println(destDir);
		//Copy file to directory
		FileUtils.copyFileToDirectory(file, destDir);
		
		//Get file from new directory
		File newFile = FileUtils.getFile(destDir, "new1.txt");
		//Read data from file
		String newFileData = FileUtils.readFileToString(newFile, "UTF8");
		
		System.out.println("Data in new file : "+newFileData);

	}

}
