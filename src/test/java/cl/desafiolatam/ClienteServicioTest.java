package cl.desafiolatam;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.CategoriaEnum;
import modelo.Cliente;
import servicio.ClienteServicio;

class ClienteServicioTest {

	private ClienteServicio cs;

	@BeforeEach

	void setup() {
		cs = new ClienteServicio();
	}

	@Test
	public void AgregarclienteTest() {

		Cliente cli = new Cliente("12345678-9", "nombre1 nombre2", "apellido1 apellido2", 5, CategoriaEnum.Activo);

		cs.agregarCliente(cli);

		assertTrue(cs.getListaClientes().size() == 1);

	}

	@Test

	public void AgregarClienteNullTest() {

		Cliente cli = null;

		try {

			cs.agregarCliente(cli);
			fail("Expected an NullPointerException to be thrown");
		} catch (NullPointerException e) {
			assertEquals(e.getMessage(), "No se puede agregar cliente nulo");
		} catch (Throwable t) {
			fail("Expected an NullPointerException to be thrown");
		}

	}

}
