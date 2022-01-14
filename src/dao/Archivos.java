package dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import dol.Informacion;

public class Archivos {
	public static void writeToFile(List<Informacion> i) throws  IOException {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Archivo.bin"))) {
			oos.writeObject(i);
		}
	}
	public static List<Informacion> readFile() throws IOException, ClassNotFoundException {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Archivo.bin"))) {
			@SuppressWarnings("unchecked")
			List<Informacion>info = (List<Informacion>) ois.readObject();
			return info;
		}
	}
}
