package servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import modelo.Cliente;

public class ExportadorTxt extends Exportador {

	@Override
	public void exportar(String fileName, List<Cliente> listaClientes) {
		// TODO Auto-generated method stub

		String path = String.format("%s/clientes.txt", fileName);
		File archivo = new File(path);
		if (!archivo.exists()) {
			try {
				archivo.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		}
		try {

			FileWriter fw = new FileWriter(archivo.getAbsoluteFile(), true);
			BufferedWriter escritor = new BufferedWriter(fw);

//				for (Cliente cli : listaClientes) {
//					String clienteTxt = String.format("%s,%s,%s,%s,%s", cli.getRuncliente(),cli.getNombrecliente(),
//							cli.getApellidoCliente(),String.valueOf(cli.getEdadCliente()),cli.getNombreCategoria());//							
//					escritor.write(clienteTxt);
//					escritor.newLine();
//				} 

			listaClientes.stream().forEach(x -> {
				try {
					escritor.write(String.format("%s,%s,%s,%s,%s", x.getRuncliente(), x.getNombrecliente(),
							x.getApellidoCliente(), String.valueOf(x.getEdadCliente()), x.getNombreCategoria()));
					escritor.newLine();

				} catch (IOException e) {
										// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println(e2.getMessage());
				}
				
				
			});
			escritor.close();

		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

}
