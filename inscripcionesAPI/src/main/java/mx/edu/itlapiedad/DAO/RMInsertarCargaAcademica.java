package mx.edu.itlapiedad.DAO;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import mx.edu.itlapiedad.models.InsertarCargaAcademica;
public class RMInsertarCargaAcademica implements RowMapper<InsertarCargaAcademica>{
	@Override
	public InsertarCargaAcademica mapRow(ResultSet rs, int rowNum) throws SQLException {
		InsertarCargaAcademica InsertarCargaAcademica= new InsertarCargaAcademica();
		InsertarCargaAcademica.setSemestre_idsemestre(rs.getInt("semestre_idsemestre"));
		InsertarCargaAcademica.setMaterias_idmaterias(rs.getInt("materias_idmaterias"));
		InsertarCargaAcademica.setAlumnos_idAlumno(rs.getInt("alumnos_idalumnos"));
		return InsertarCargaAcademica;
	}

}
