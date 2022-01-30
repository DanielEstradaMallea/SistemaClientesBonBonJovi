package vista;



import java.util.Scanner;

import utilidades.Utilidad;

public abstract class MenuPlantilla {
	protected  Scanner sc = new Scanner(System.in);

	public final void iniciarMenu() {
		Integer opcion;
		do {

			do {
				System.out.println(" _______________________________________");
				System.out.println("|      BIENVENIDOS A BON BON JOVI       |");
				System.out.println("|                                       |");
				System.out.println("| 1.-Listar Clientes                    |");
				System.out.println("| 2.-Agregar Clientes                   |");
				System.out.println("| 3.-Editar Clientes                    |");
				System.out.println("| 4.-Cargar Datos                       |");
				System.out.println("| 5.-Exportar Datos                     |");
				System.out.println("| 6.-Salir                              |");
				System.out.println("|_______________________________________|");
    			System.out.print("Opcion : ");

				opcion = Utilidad.validarNumero();
			} while (opcion == null);
			switch (opcion) {
			case 1:
				ListarCliente();

				break;
			case 2:
				System.out.println("");
                AgregarCliente();
				break;
			case 3:
				System.out.println("");
				EditarCliente();

				break;
			case 4:
				System.out.println("");
                importarDatos();
				break;
			case 5:
				System.out.println("");
                exportarDatos();
				break;
			case 6:
				System.out.println("");
				terminarDatos();
				break;

			default:
				System.out.println("opcion incorrecta");
				break;
			}

		} while (opcion != 6);
	}
	public abstract void ListarCliente();
	
	public abstract void AgregarCliente();
	
	public abstract void EditarCliente();
	
	public abstract void importarDatos();
	
	public abstract void exportarDatos();

	public abstract void terminarDatos();
	
}
