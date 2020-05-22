package mx.edu.itlapiedad.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mx.edu.itlapiedad.DAO.DAO;
import mx.edu.itlapiedad.models.Docentes;

@RestController
@RequestMapping("/tec")
@CrossOrigin(origins = "*", methods={RequestMethod.GET})
public class ITLP_Docente {
	@Autowired
	DAO repositorio;
	
	//DOCENTE
	@GetMapping("docente")
	public List<Docentes> consultarDocente(){
		return repositorio.consultarDocentes();
	}
	
	//DOCENTE-ID
	@GetMapping("docente/{iddocente}")
	public Docentes buscarDocente(@PathVariable int iddocente) {
		return repositorio.buscarDocente(iddocente);
	}
	
	//DOCENTE-IDDEPARTAMENTO
		@GetMapping("docente/departamento/{departamento_iddepartamento}")
		public List<Docentes> buscarDocentePorDepartamento(@PathVariable int departamento_iddepartamento) {
			return repositorio.buscarDocentePorDepartamento(departamento_iddepartamento);
		}
	
	
	
}
