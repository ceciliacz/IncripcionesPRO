package mx.edu.itlapiedad.DAO;

import java.util.List;

import mx.edu.itlapiedad.models.Docentes;
import mx.edu.itlapiedad.models.Horario;
import mx.edu.itlapiedad.models.Imparte;
import mx.edu.itlapiedad.models.InsertarCargaAcademica;
import mx.edu.itlapiedad.models.Kardex;
import mx.edu.itlapiedad.models.Materias;
import mx.edu.itlapiedad.models.ModeloCargaAcademica;
import mx.edu.itlapiedad.models.Pago;
import mx.edu.itlapiedad.models.SesionAlumno;
import mx.edu.itlapiedad.models.Alumnos;
import mx.edu.itlapiedad.models.Carreras;
import mx.edu.itlapiedad.models.Departamentos;
public interface DAO {
//prueba
	List<Docentes> consultarDocentes();
	Docentes buscarDocente(int iddocente);
	List<Materias> horarioDocentesMaterias(int alumnos_idAlumno);
	List<Carreras> consultarCarreras();
	Carreras buscarCarreras(int idcarrera);
	Alumnos buscarAlumno(int idAlumno);
	int sesion(SesionAlumno alumno);
	Materias buscarMaterias(int idmaterias);
	List<Alumnos> buscarAlumnCarrera(int idcarrera);
	List<Materias> buscarMateriaCarrera(int idcarrera);
	List<Kardex> consultaKardexMateria(int idalumno);
	List<Alumnos> buscarInfoAlumno(int idAlumno);
	List<Imparte> consultaDocenteMateria(int idAlumno);
	List<Horario> consultaHorario(int idAlumno);
	public void insertar(InsertarCargaAcademica InsertarCargaAcademica);
	
	List<ModeloCargaAcademica> buscarMateriasCarga(String Carrera, String grupo, int semestre);
	
	List<Departamentos> consultarDepartamentos();
	public void guardarpago(Pago pago);
	List<Docentes> buscarDocentePorDepartamento(int departamento_iddepartamento);
}
