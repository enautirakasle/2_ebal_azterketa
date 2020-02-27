package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Conector;
import modelo.bean.Inscripcion;
import modelo.bean.Usuario;

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

	public ArrayList<Usuario> getUsuariosInscritos(int idActividad) {
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		
		try {
			PreparedStatement pst = super.conexion.prepareStatement("select usuarios.* "
					+ "from inscripciones join usuarios on inscripciones.id_usuario= usuarios.id "
					+ "where inscripciones.id_actividad = ?");
			pst.setInt(1, idActividad);

			ResultSet rs = pst.executeQuery();
			
			
			while(rs.next()){
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNombreApellido(rs.getString("nombre_apellido"));
				usuario.setDni(rs.getString("dni"));
				usuario.setCodigo(rs.getString("codigo"));
				
				usuarios.add(usuario);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
		
	}
	
}
