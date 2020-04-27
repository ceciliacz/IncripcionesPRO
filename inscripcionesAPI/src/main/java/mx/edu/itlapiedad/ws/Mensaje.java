package mx.edu.itlapiedad.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.itlapiedad.DAO.DAO;
import mx.edu.itlapiedad.models.Docente;
import mx.edu.itlapiedad.models.Materias;
import mx.edu.itlapiedad.models.Alumno;
import mx.edu.itlapiedad.models.Carreras;

@RestController
@RequestMapping("/tec")
public class Mensaje {
	
	@Autowired
	DAO repositorio;
	
	@GetMapping("docente")
	public List<Docente> consultarDocente(){
		return repositorio.consultarDocentes();
	}
	@GetMapping("docente/{iddocente}")
	public Docente buscarDocente(@PathVariable int iddocente) {
		return repositorio.buscarDocente(iddocente);
	}
	//CARRERAS
	@GetMapping("carreras")
	public List<Carreras> consultarCarreras(){
		return repositorio.consultarCarreras();
	}
	@GetMapping("carreras/{idcarrera}")
	public Carreras buscarCarreras(@PathVariable int idcarrera) {
		return repositorio.buscarCarreras(idcarrera);
	}
	@GetMapping("materias/{idmaterias}")
	public Materias buscarMaterias(@PathVariable int idmaterias) {
		return repositorio.buscarMaterias(idmaterias);
	}
	@GetMapping("materias")
	public List<Materias> buscarMateriasCarrera(@RequestParam String carrera) {
		return repositorio.buscarMateriaCarrera(carrera);
	}
	
	//Estos son los alumnos
	@GetMapping("alumno/idAlumno")
	public Alumno buscarAlumno(@PathVariable int idAlumno) {
		return repositorio.buscarAlumno(idAlumno);
	}
	
	@GetMapping("alumnos/carreras/{idcarrera}")
	public Carreras buscarCarrerasAlumno(@PathVariable int idcarrera) {
		return repositorio.buscarCarreras(idcarrera);
	}
	
	@RequestMapping("sesion")
	public Alumno recuperarSesion(@RequestBody Alumno alumno) {
		return repositorio.sesion(alumno);
	}
}