package vista;

import java.util.List;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ArchivoServicio;
import servicio.ClienteServicio;
import servicio.ExportadorCsv;
import servicio.ExportadorTxt;
import utilidades.Utilidad;

public class Menu extends MenuPlantilla {

	ClienteServicio cs = new ClienteServicio();
	ExportadorTxt et = new ExportadorTxt();
	ExportadorCsv ec = new ExportadorCsv();

	@Override
	public void ListarCliente() {
		// TODO Auto-generated method stub

		Utilidad.limpiar();
		System.out.println("------------Lista de Clientes--------------\n");
		cs.listarClientes();
		System.out.printf("Clientes encontrados : %d\n\n", cs.getListaClientes().size());
		System.out.println("Volviendo al sistema principal");
		Utilidad.esperar();
		Utilidad.limpiar();
	}

	@Override
	public void AgregarCliente() {
		// TODO Auto-generated method stub
		String run, nombres, apellidos;
		Integer antiguedad;
		System.out.println("-------------Crear Cliente-------------");
		Utilidad.limpiar();

		do {
			System.out.print("Ingresa RUN del Cliente : ");
			run = sc.nextLine().trim();
		} while (Utilidad.DimensionString(run, 8, 11));

		do {
			System.out.print("Ingresa Nombres del Cliente : ");
			nombres = sc.nextLine().trim();
		} while (Utilidad.DimensionString(nombres, 5, 50));

		do {
			System.out.print("Ingresa Apellidos del Cliente : ");
			apellidos = sc.nextLine().trim();
		} while (Utilidad.DimensionString(apellidos, 5, 50));

		do {
			System.out.print("Ingresa años como Cliente : ");
			antiguedad = Utilidad.validarNumero();
		} while (antiguedad == null);

		Cliente cli = new Cliente(run, nombres, apellidos, 0, CategoriaEnum.Activo);
		cs.agregarCliente(cli);

		System.out.println("---------------------------------------");
		System.out.println("Volviendo al sistema principal");
		Utilidad.esperar();
		Utilidad.limpiar();

	}

	@Override
	public void EditarCliente() {
		// TODO Auto-generated method stub
		Utilidad.limpiar();
		Integer opcionEditar;
		System.out.println("-------------Editar Cliente-------------\n");
		do {
			do {

				System.out.println("Seleccione qué desea hacer:\n");
				System.out.println("1.-Cambiar el estado del Cliente");
				System.out.println("2.-Editar los datos ingresados del Cliente\n");
				System.out.print("Opcion : ");
				opcionEditar = Utilidad.validarNumero();
				if (opcionEditar != null) {
					if (opcionEditar != 1 && opcionEditar != 2) {
						System.out.println("Opcion no existe, elija una correcta");
					}
				}
			} while (opcionEditar == null);

		} while (opcionEditar != 1 && opcionEditar != 2);

		System.out.println("----------------------------------------\n");
		System.out.println("Ingrese RUN del Cliente a editar:");
		String codigo = sc.next();
		Integer opcionEstado;
		Cliente cli1 = cs.buscar(codigo);

		if (cli1 != null) {

			if (opcionEditar == 1) {

				Utilidad.limpiar();
				System.out.println("-----Actualizando estado del Cliente-----\n");
				System.out.printf("RUN: %s, estado actual : %s  \n", cli1.getRuncliente(), cli1.getNombreCategoria());

				if (cli1.getNombreCategoria().equals(CategoriaEnum.Activo)) {

					do {
						do {

							System.out.println("1.-Si desea cambiar el estado del Cliente a Inactivo");
							System.out.println("2.-Si desea mantener el estado del cliente Activo");
							opcionEstado = Utilidad.validarNumero();
						} while (opcionEstado == null);

						switch (opcionEstado) {
						case 1:
							cli1.setNombreCategoria(CategoriaEnum.Inactivo);
							System.out.println("Estado cambiado");

							break;
						case 2:
							System.out.println("Estado se mantuvo");
							break;

						default:
							System.out.println("Opcion no existe");
							break;
						}
					} while (opcionEstado != 1 && opcionEstado != 2);
				} else {
					do {
						do {

							System.out.println("1.-Si desea cambiar el estado del Cliente a Activo");
							System.out.println("2.-Si desea mantener el estado del cliente Inactivo");
							opcionEstado = Utilidad.validarNumero();
						} while (opcionEstado == null);
						switch (opcionEstado) {
						case 1:
							cli1.setNombreCategoria(CategoriaEnum.Activo);
							System.out.println("Estado cambiado");

							break;
						case 2:
							System.out.println("Estado se mantuvo");
							break;

						default:
							System.out.println("Opcion no existe");
							break;
						}
					} while (opcionEstado != 1 && opcionEstado != 2);

				}

				System.out.println("---------------------------------------");

			}

			else if (opcionEditar == 2) {

				cs.editarCliente(cli1);
			}

			System.out.println("Volviendo al sistema principal");
			Utilidad.esperar();
			Utilidad.limpiar();
		} else {
			System.out.printf("El RUN %s buscado no esta asignado a ningun cliente\n", codigo);
			System.out.println("Volviendo al sistema principal");
			Utilidad.esperar();
			Utilidad.limpiar();
		}

	}

	@Override
	public void importarDatos() {
		// TODO Auto-generated method stub
		Utilidad.limpiar();
		ArchivoServicio as = new ArchivoServicio();
		System.out.println("Importar Datos");
		System.out.println("Ingresa la ruta en donde se encuentra el archivo\r\n" + "DBClientes.csv:");
		String ruta = sc.next();
		List<Cliente> nueva = as.cargarDatos(ruta);
		if (nueva != null) {

			nueva.stream().forEach(obj -> cs.agregarCliente(obj));

			System.out.println("\nVolviendo al sistema principal");
			Utilidad.esperar();
			Utilidad.limpiar();
		} else {
			System.out.println("No hay elementos para importar");
			System.out.println("Volviendo al sistema principal");
			Utilidad.esperar();
			Utilidad.limpiar();
		}
	}

	@Override
	public void exportarDatos() {
		// TODO Auto-generated method stub
		Utilidad.limpiar();
		String ruta;
		Integer opcionExp;
		do {
			do {
				System.out.println("-----------Exportar Datos-----------\n");
				System.out.println("Seleccione formato para exportar");
				System.out.println("1.-Formato csv");
				System.out.println("2.-Formato txt\n");
				System.out.print("ingrese una opcion para exportar : ");
				opcionExp = Utilidad.validarNumero();
			} while (opcionExp == null);
			switch (opcionExp) {
			case 1:
				System.out.println("Ingresa la ruta en donde desea exportar el archivo ProductosImportados.csv");
				ruta = sc.next();
				ec.exportar(ruta, cs.getListaClientes());
				System.out.println("Datos Exportados");
				System.out.println("Volviendo al sistema principal");
				Utilidad.esperar();
				Utilidad.limpiar();

				break;
			case 2:
				System.out.println("Ingresa la ruta en donde desea exportar el archivo ProductosImportados.txt");
				ruta = sc.next();
				et.exportar(ruta, cs.getListaClientes());
				System.out.println("Datos Exportados");
				System.out.println("Volviendo al sistema principal");
				Utilidad.esperar();
				Utilidad.limpiar();
			default:
				System.out.println("Opcion no existe");
				break;

			}
		} while (opcionExp != 1 && opcionExp != 2);
	}

	@Override
	public void terminarDatos() {
		// TODO Auto-generated method stub
		Utilidad.limpiar();
		System.out.println("Gracias por usar BonBonJovi 🧁 Gestor ");
		System.out.println("Cerrando sistema...");
		Utilidad.esperar();
		System.out.println("Hasta la proxima");
		System.out.close();

	}

}
