package filereadpoc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileReadPOC {
	
	public FileReadPOC() {};
	
	public void read(String arg0, String arg1)  {
		InputStream input = null;
		try {
			input = new FileInputStream(arg0 + "/apps/" + arg1 + "/test.txt");
			System.out.println("inside input try");
			System.out.println(input.toString());
			int content;
			while ((content = input.read()) != -1) {
				// convert to char and display it
				System.out.print((char) content);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(input.toString());
			try {
				input.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
