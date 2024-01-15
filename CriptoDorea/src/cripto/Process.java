package cripto;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Process {
	
	public static void process(String arquivo1, String arquivo2) {
		
		try {
			FileInputStream file1 = new FileInputStream(arquivo1);
			FileOutputStream file2 = new FileOutputStream(arquivo2);
			boolean eof = false; int count = 0;
			while (!eof) {
				int input = file1.read();
				if (input != -1) {
					file2.write(input);
					count++;
				} else eof = true;
			}
			file1.close();
			file2.close();
			System.out.println("Copia concluida\nBytes lidos: " + count);
		} catch (IOException e) {
			System.out.println("Error -- " + e.toString());
		}
		
	}

}
