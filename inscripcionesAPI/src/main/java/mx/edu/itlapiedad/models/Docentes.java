package mx.edu.itlapiedad.models;

public class Docentes {
	int iddocente;
	String nombre;
	String apellido;
	String RFC;
	String mail;
	int departamento_iddepartamento;
	public Docentes() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Docentes(int iddocente, String nombre, String apellido, String rFC, String mail,
			int departamento_iddepartamento) {
		super();
		this.iddocente = iddocente;
		this.nombre = nombre;
		this.apellido = apellido;
		RFC = rFC;
		this.mail = mail;
		this.departamento_iddepartamento = departamento_iddepartamento;
	}
	public int getIddocente() {
		return iddocente;
	}
	public void setIddocente(int iddocente) {
		this.iddocente = iddocente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getRFC() {
		return RFC;
	}
	public void setRFC(String rFC) {
		RFC = rFC;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getDepartamento_iddepartamento() {
		return departamento_iddepartamento;
	}
	public void setDepartamento_iddepartamento(int departamento_iddepartamento) {
		this.departamento_iddepartamento = departamento_iddepartamento;
	}
	
	
	

}
