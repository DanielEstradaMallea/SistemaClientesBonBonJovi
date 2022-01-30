package servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import modelo.Cliente;
import utilidades.Utilidad;

public class ClienteServicio implements ServiciosCliente {

	private List<Cliente> listaClientes;

	public ClienteServicio() {

		listaClientes = new ArrayList<>();
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	@Override
	public String toString() {
		return "ClienteServicio [listaClientes=" + listaClientes + "]";
	}

	public void listarClientes() {

		if (listaClientes != null) {
			listaClientes.stream().forEach(x -> {
				System.out.println("-------------Datos del Cliente-------------\n");
				System.out.println(x);
				System.out.println("-------------------------------------------\n");

			});
		} else {
			System.out.println("No hay ningun cliente registrado");
		}
	}

	public void agregarCliente(Cliente cli) {

		if (cli == null) {
			throw new NullPointerException("No se puede agregar cliente nulo");
		} else {

			if (buscar(cli.getRuncliente()) == null) {
				listaClientes.add(cli);
				System.out.println("Cliente agregado");
			} else {
				System.out.println("Ingresó un RUN vacio o ya registrado");
			}
		}
	}

	public Cliente buscar(String run) {

//		for (Cliente cli : listaClientes) {
//			if (cli.getRuncliente().equals(run)) {
//				return cli;
//			}
//		}		
//		return null;

		return listaClientes.stream().filter(cli -> cli.getRuncliente().equals(run)).findFirst().orElse(null);
//		
//		

	}

	public void editarCliente(Cliente cli) {

		Integer alternativa;
		String run, nombres, apellidos;
		Scanner sc = new Scanner(System.in);

		do {
			do {
				System.out.printf("\n1.- El Run del Cliente es: %s \n", cli.getRuncliente());
				System.out.printf("2.- El Nombre del Cliente es: %s \n", cli.getNombrecliente());
				System.out.printf("3.- El Apellido del Cliente es: %s \n", cli.getApellidoCliente());
				System.out.printf("4.- Los años como cliente son: %s \n\n", cli.getEdadCliente());
				System.out.println("Ingrese la opción a editar de los datos del producto:\n");
				alternativa = Utilidad.validarNumero();
			} while (alternativa == null);

			switch (alternativa) {

			case 1:
				do {
					System.out.println("Ingrese el nuevo RUN");
					run = sc.nextLine().trim();
				} while (Utilidad.DimensionString(run, 8, 11));
				cli.setRuncliente(run);
				System.out.println("RUN cambiado satisfactoriamente");
				break;
			case 2:
				do {
					System.out.println("Ingrese el nuevo nombre del cliente");
					nombres = sc.nextLine().trim();
				} while (Utilidad.DimensionString(nombres, 5, 50));
				cli.setNombrecliente(nombres);
				System.out.println("Nombre cambiado satisfactoriamente");
				break;
			case 3:
				do {
					System.out.println("Ingrese el nuevo apellido");
					apellidos = sc.nextLine().trim();
				} while (Utilidad.DimensionString(apellidos, 5, 50));
				cli.setApellidoCliente(apellidos);
				System.out.println("Apellido cambiado satisfactoriamente");
				break;
			case 4:
				System.out.println("Ingrese la nueva antigüedad del cliente");
				Integer aniosCliente = Utilidad.validarNumero();
				cli.setEdadCliente(aniosCliente);
				System.out.println("Años como cliente cambiado");
				break;
			default:
				System.out.println("Alternativa no válida");
				break;
			}

		} while (alternativa != 1 && alternativa != 2 && alternativa != 3 && alternativa != 4);
	}

}
