package servicio;

import modelo.Cliente;

public interface ServiciosCliente {

	public void agregarCliente(Cliente cli);

	public Cliente buscar(String run);

	public void editarCliente(Cliente cli);

	public void listarClientes();
}
