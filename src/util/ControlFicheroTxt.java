package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ControlFicheroTxt {
	
	File archivo;
	
	public void crearFichero () throws IOException {
		String ruta = "discordBOTChistes.txt";
		archivo = new File(ruta);
		BufferedWriter bw;
		if(archivo.exists()) {
		      System.out.println("El archivo ya existe.");
		} else {
		      System.out.println("El fichero no existe.");
		      bw = new BufferedWriter(new FileWriter(archivo));
		      bw.write("Linea 1");
		      bw.close();
		}
	}
	
	public void escribirFichero () {
		if (archivo.exists()) {
			
		}
	}

}
