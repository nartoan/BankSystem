package tsdv.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {
	public static void writeToEndFile(String path, String content) {
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(path, true);
			BufferedWriter writer = new BufferedWriter(fileWriter);
			if ((new File(path)).length() != 0) {
				writer.append("\n");
			}
		    writer.append(content);
		    
		    writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeToFile(String path, String content) {
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(path);
			BufferedWriter writer = new BufferedWriter(fileWriter);
		    writer.write(content);
		    
		    writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
