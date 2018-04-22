package edu.zufe.rms.path;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class TestFilePath {
	
	@Test
	public static void main(String[] args) throws IOException {
		File file = new File("hello1.txt");
		file.createNewFile();
		System.out.println(file.getPath());
	}

}
