package edu.kh.test;

import java.io.FileWriter;
import java.io.IOException;

public class TestService {

	public void outputtest() {
		
		FileWriter fw = null;
		
		try { 
			
			fw = new FileWriter("test1.txt",true);
			fw.write(97);
			fw.write(65);
			
			
		}catch (IOException e) {
			e.printStackTrace();
			
		}finally {
			
		}try {
			fw.close();
		} 
		
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
