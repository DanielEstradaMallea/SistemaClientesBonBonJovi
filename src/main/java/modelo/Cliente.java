package modelo;

public class Cliente {

	private String runcliente;
	private String nombrecliente;
	private String apellidoCliente;
	private int edadCliente;
	private CategoriaEnum nombreCategoria;

	public Cliente(String runcliente, String nombrecliente, String apellidoCliente, int edadCliente,
			CategoriaEnum nombreCategoria) {
		super();
		this.runcliente = runcliente;
		this.nombrecliente = nombrecliente;
		this.apellidoCliente = apellidoCliente;
		this.edadCliente = edadCliente;
		this.nombreCategoria = nombreCategoria;
	}

	public String getRuncliente() {
		return runcliente;
	}

	public void setRuncliente(String runcliente) {
		this.runcliente = runcliente;
	}

	public String getNombrecliente() {
		return nombrecliente;
	}

	public void setNombrecliente(String nombrecliente) {
		this.nombrecliente = nombrecliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public int getEdadCliente() {
		return edadCliente;
	}

	public void setEdadCliente(int edadCliente) {
		this.edadCliente = edadCliente;
	}

	public CategoriaEnum getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(CategoriaEnum nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

//	@Override
//	public String toString() {
//		return "Cliente [runcliente=" + runcliente + ", nombrecliente=" + nombrecliente + ", apellidoCliente="
//				+ apellidoCliente + ", edadCliente=" + edadCliente + ", nombreCategoria=" + nombreCategoria + "]";
//	}
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Run del cliente : %s \n", getRuncliente()));
		sb.append(String.format("Nombres del cliente : %s \n", getNombrecliente()));
		sb.append(String.format("Apellidos del cliente : %s \n", getApellidoCliente()));
		sb.append(String.format("Años como cliente: %d \n", getEdadCliente()));
		sb.append(String.format("Categoria del cliente: %s \n", getNombreCategoria()));

		return sb.toString();
	}

}
