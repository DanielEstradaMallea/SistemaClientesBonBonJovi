package utilidades;

import java.util.Scanner;

public class Utilidad {

	/**
	 * Método que imprime 15 lineas en blanco
	 * 
	 * @author Daniel Estrada
	 */
	public static void limpiar() {
		for (int i = 0; i < 15; i++) {
			System.out.println("");
		}
	}

	/**
	 * Método que genera una pausa de 2 segundos
	 * 
	 * @author Daniel Estrada
	 */
	public static void esperar() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Método que valida que dato ingresado sea de tipo Integer, en caso de no
	 * cumplir retorna null
	 * 
	 * @author Daniel Estrada
	 */

	public static Integer validarNumero() {
		int numeroValidado = 0;
		try {
			Scanner sc = new Scanner(System.in);
			numeroValidado = sc.nextInt();
			return numeroValidado;

		} catch (Exception e) {
			System.out.println("Dato ingresado no es un numero\n");
			return null;
		}

	}

	/**
	 * Método que mide el tamaño del String segun los paramentros min y max,
	 * arrojando true si cumple con los parametros o false si no cumple
	 * 
	 * @author Daniel Estrada
	 */
	public static boolean DimensionString(String dato, int min, int max) {

		if (dato.length() > min && dato.length() < max) {

			return false;

		} else {
			System.out.printf("Dato fuera de rango, Min %d caracteres y Max %d caracteres\n", min, max);
			return true;
		}
	}
}
