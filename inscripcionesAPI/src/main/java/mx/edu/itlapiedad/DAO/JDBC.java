package mx.edu.itlapiedad.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mx.edu.itlapiedad.DAO.RM;
import mx.edu.itlapiedad.DAO.RMCARRERAS;
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

@Repository
public class JDBC implements DAO {

	@Autowired
	JdbcTemplate conexion;
	
	String sql;
	@Override
	//DOCENTES
	//servicio web para consultar docentes
	public List<Docentes> consultarDocentes() {
		sql = "SELECT * FROM docentes";
		return conexion.query(sql, new RM());
	}
	
	
	//servicio web para consultar docentes mediante
	//su id del docente
	@Override
	public Docentes buscarDocente(int iddocente) {
		sql = "SELECT * FROM docentes WHERE iddocente = ?";
		return conexion.queryForObject(sql, new RM(), iddocente);
	}
	
	//CARRERAS
	//servicio web para consultar carreras
	@Override
	public List<Carreras> consultarCarreras() {
		sql = "SELECT * FROM carreras";
		return conexion.query(sql, new RMCARRERAS());
	}
	
	//servicio web para consultar carreras mediante el id de la carrera
	@Override
	public Carreras buscarCarreras(int idcarrera) {
		sql = "SELECT * FROM carreras WHERE idcarrera = ?";
		return conexion.queryForObject(sql, new RMCARRERAS(), idcarrera);
	}
	
	//MATERIAS
	//servicio web para consultar materias mediante el id de las materias 
	@Override
	public Materias buscarMaterias(int idmaterias) {
		sql = "SELECT * FROM materias WHERE idmaterias = ?";
		return conexion.queryForObject(sql, new RMMaterias(), idmaterias);
	}
	
	//servicio web para consultar materias mediante el id de la carrera
	@Override
	public List<Materias> buscarMateriaCarrera(int  idcarrera) {
		sql ="SELECT * FROM Materias WHERE idcarrera =?";
		return conexion.query(sql,new RMMaterias(), idcarrera);
	}
	
	//ALUMNOS
	//servicio web para cosnultar alumnos mediante el id del alumno
	@Override
	public Alumnos buscarAlumno(int idAlumno) {
		// TODO Auto-generated method stub
		sql ="SELECT * FROM Alumnos WHERE idAlumno =?";
		return conexion.queryForObject(sql, new RMAlumnos(), idAlumno);
	}
	
	//servicio web para consultar alumnos mediante el numero de control y contraseña
	@Override
	public int sesion(SesionAlumno alumno) {
		sql ="SELECT * FROM Alumnos WHERE NoControl =? and Contraseña = ?";
		int idAlumno=0;
		try {
			idAlumno= conexion.queryForObject(sql, new RMAlumnos(), alumno.getNoControl(),alumno.getContraseña()).getIdAlumno();
		}catch (Exception e) {
			// TODO: handle exception
		}
		return idAlumno;
		
	}

	//servicio web para consultar alumnos mediante el id de la carrera
	@Override
	public List<Alumnos> buscarAlumnCarrera(int idcarrera) {
		sql ="select * from alumnos where idCarrera =?";
		return conexion.query(sql,new RMAlumnos(), idcarrera);
	}
	
	
	//KARDEX
	//servicio web para consultar el kardex
	@Override
	public List<Kardex> consultaKardexMateria(int idalumno) {
		sql ="select m.nombre_materia,  m.creditos, m.codigo_materia, c.calificacion\r\n" + 
	            "from materias m\r\n" + 
	            "join cursada c on c.materias_idmaterias=m.idmaterias\r\n" + 
	            "join alumnos a on a.idalumno=c.alumnos_idAlumno\r\n" + 
	            "where a.idalumno=?";
		return conexion.query(sql,new RMKardex(), idalumno);
	}
	
	//INFO-MATERIAS
	//SW para consultar la informacion del alumno
	@Override
	public List<Alumnos> buscarInfoAlumno(int idAlumno) {
		sql ="select a.idalumno, a.contraseña, a.correo, a.nombre, a.apellidos, a.noControl, c.nombre\r\n" + 
				"from alumnos a\r\n" + 
				"join carreras c on c.idcarrera=a.idcarrera\r\n" + 
				"where idalumno=?";
		return conexion.query(sql,new RMAlumnos(), idAlumno);
	}

	
	//DOCENTE-MATERIAS
	//SW para consultar el docente
	@Override
	public List<Imparte> consultaDocenteMateria(int idAlumno) {
		sql ="select m.codigo_materia, m.nombre_materia, d.iddocente, d.RFC, d.mail, m.creditos,  d.nombre, d.apellido\r\n" + 
				"from docentes d \r\n" + 
				"join imparte i on i.docentes_iddocente = d.iddocente\r\n" + 
				"join materias m on m.idmaterias = i.materias_idmaterias\r\n" + 
				"join horario h on h.materias_idmaterias = m.idmaterias\r\n" + 
				"join alumnos a on a.idalumno=h.alumnos_idAlumno\r\n" + 
				"where a.idAlumno = ?";
		return conexion.query(sql,new RMImparte(), idAlumno);
	}
	
	
	//HORARIOS
	//SW para consultar el horario
	@Override
	public List<Horario> consultaHorario(int idAlumno) {
		sql="select m.nombre_materia, h.hora, h.dia\r\n" + 
				"from materias m\r\n" + 
				"join horas h on h.materias_idmaterias = m.idmaterias\r\n" + 
				"join horario ho on ho.materias_idmaterias = m.idmaterias\r\n" + 
				"where ho.alumnos_idAlumno = ? order by h.dia;";
		return conexion.query(sql,new RMHorario(), idAlumno);
	}
	
	
	//SW para consultar horario de docentes
	@Override
	public List<Materias> horarioDocentesMaterias(int alumnos_idAlumno) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	//CARGA ACADEMICA
	//SW para consultar la carga academica
 	@Override
	public List<ModeloCargaAcademica> buscarMateriasCarga(String Carrera, String grupo, int semestre) {
		// TODO Auto-generated method stub
		sql="select ma.idmaterias, ma.creditos, ma.codigo_materia,ma.nombre_materia,se.numero_semestre,gr.grupo from materias ma\r\n" + 
				"join  carreras ca on ca.idcarrera = ma.idcarrera\r\n" + 
				"join grupo gr on gr.carreras_idcarrera = gr.idgrupo\r\n" + 
				"join semestre se on se.grupo_idgrupo = gr.idgrupo\r\n" + 
				"where se.numero_semestre = ? and gr.grupo= ? and ca.codigo = ?\r\n" + 
				"group by ma.idmaterias";
		return conexion.query(sql,new CargaRM(), semestre,grupo,Carrera);
	}
 	
 	
 	//INSERTAR CARGA ACADEMICA
 	
 	@Override
	public void insertar(InsertarCargaAcademica InsertarCargaAcademica) {
		sql = "INSERT INTO carga_academica (semestre_idsemestre, materias_idmaterias, alumnos_idAlumno) VALUES(?, ?, ?)";
		conexion.update(sql, InsertarCargaAcademica.getSemestre_idsemestre(), 
				InsertarCargaAcademica.getMaterias_idmaterias(), 
				InsertarCargaAcademica.getAlumnos_idAlumno());
		
	}
 	
 	//CONSULTAR DEPARTAMENTOS
 	@Override
	public List<Departamentos> consultarDepartamentos() {
		// TODO Auto-generated method stub
		sql="select * from departamento";
		return conexion.query(sql,new RMDepartamentos());
	}
 	@Override
	public void guardarpago(Pago pago) {
		sql = "INSERT INTO pago (idpago, estado, semestre_idsemestre, alumnos_idAlumno) VALUES(?, ?, ?, ?)";
		conexion.update(sql, pago.getIdpago(), pago.getEstado(), 
				pago.getSemestre_idsemestre(), 
				pago.getAlumnos_idAlumno());
		
	}
 	
 	
 	@Override
	public List<Docentes> buscarDocentePorDepartamento(int departamento_iddepartamento) {
		// TODO Auto-generated method stub
		sql="select * from docentes where departamento_iddepartamento = ?";
		return conexion.query(sql,new RM(), departamento_iddepartamento);
	}


}
