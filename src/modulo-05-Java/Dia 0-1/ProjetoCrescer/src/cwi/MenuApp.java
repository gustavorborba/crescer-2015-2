package cwi;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MenuApp {
	public void Escrever(String caminho, ArrayList<String> lista){
		try {
			File arquivo = new File(caminho);
			if(!arquivo.exists()){
				arquivo.createNewFile();
			}
			BufferedWriter write= new BufferedWriter(new FileWriter(arquivo));
			for(int i = 0; i<lista.size(); i++){
				write.write(lista.get(i));
				write.newLine();
			}
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
