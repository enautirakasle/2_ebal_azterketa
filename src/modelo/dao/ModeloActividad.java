package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Conector;
import modelo.bean.Actividad;
import modelo.bean.Inscripcion;
import modelo.bean.Usuario;

public class ModeloActividad extends Conector{

	public Actividad getConInscipciones(int idActividad) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("select inscripciones.*, usuarios.* "
					+ "from inscripciones join usuarios on inscripciones.id_usuario= usuarios.id "
					+ "where inscripciones.id_actividad = ?");
			pst.setInt(1, idActividad);

			ResultSet rs = pst.executeQuery();
			Actividad actividad = new Actividad();
			ArrayList<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
			
			while(rs.next()){
				
				
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("usuarios.id"));
				usuario.setNombreApellido(rs.getString("usuarios.nombre_apellido"));
				usuario.setDni(rs.getString("usuarios.dni"));
				usuario.setCodigo(rs.getString("usuarios.codigo"));
				
				Inscripcion inscripcion = new Inscripcion();
				inscripcion.setUsuario(usuario);
				inscripciones.add(inscripcion);
				
			}
			actividad.setIscripciones(inscripciones);
			
			return actividad;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
