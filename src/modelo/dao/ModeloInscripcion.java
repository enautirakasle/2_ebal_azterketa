package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import modelo.Conector;
import modelo.bean.Inscripcion;

public class ModeloInscripcion extends Conector{

	public void delete(Inscripcion inscripcion) {
		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("DELETE FROM `inscripciones` WHERE id_usuario=? and id_actividad=?");
			pst.setInt(1, inscripcion.getUsuario().getId());
			pst.setInt(2, inscripcion.getActividad().getId());
			pst.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
}
