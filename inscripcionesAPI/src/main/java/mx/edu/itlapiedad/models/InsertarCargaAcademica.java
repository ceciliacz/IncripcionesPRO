package mx.edu.itlapiedad.models;

public class InsertarCargaAcademica {
	int semestre_idsemestre;
	int materias_idmaterias;
	int alumnos_idAlumno;
	
	public InsertarCargaAcademica() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InsertarCargaAcademica(int idcarga_academica, int semestre_idsemestre, int materias_idmaterias,
			int alumnos_idAlumno) {
		super();
		this.semestre_idsemestre = semestre_idsemestre;
		this.materias_idmaterias = materias_idmaterias;
		this.alumnos_idAlumno = alumnos_idAlumno;
	}

	public int getSemestre_idsemestre() {
		return semestre_idsemestre;
	}

	public void setSemestre_idsemestre(int semestre_idsemestre) {
		this.semestre_idsemestre = semestre_idsemestre;
	}

	public int getMaterias_idmaterias() {
		return materias_idmaterias;
	}

	public void setMaterias_idmaterias(int materias_idmaterias) {
		this.materias_idmaterias = materias_idmaterias;
	}

	public int getAlumnos_idAlumno() {
		return alumnos_idAlumno;
	}

	public void setAlumnos_idAlumno(int alumnos_idAlumno) {
		this.alumnos_idAlumno = alumnos_idAlumno;
	}
	
	
}
