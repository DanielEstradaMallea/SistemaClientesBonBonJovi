package servicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import modelo.CategoriaEnum;
import modelo.Cliente;

public class ArchivoServicio extends Exportador {

	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
		// TODO Auto-generated method stub

	}

	public List<Cliente> cargarDatos(String file) {
		List<Cliente> lista = new ArrayList<>();
		String path = String.format("%s\\DBClientes.csv", file);
		File archivo = new File(path);
		if (archivo.exists()) {
			try {
				FileReader rd = new FileReader(archivo);
				BufferedReader lector = new BufferedReader(rd);

				String data = lector.readLine();
				while (data != null) {
					String[] datos = data.split(",");
					Cliente pro = new Cliente(datos[0],datos[1], datos[2], Integer.parseInt( datos[3]),CategoriaEnum.valueOf(datos[4]));
					lista.add(pro);
					data = lector.readLine();
				}
				lector.close();
			} catch (FileNotFoundException ex) {
				System.out.println(ex.getMessage());
				// Archivo no existe
			} catch (IOException e) {
				System.out.println(e.getMessage());
				// no pude leer el archivo
			}
		} else {
			System.out.println("Archivo no existe en ruta especificada");
			return null;
		}

		return lista;
	}
		
	

}
