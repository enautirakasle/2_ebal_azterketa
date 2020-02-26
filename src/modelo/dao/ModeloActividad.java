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

	public Actividad get(int idActividad) {
		
		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("select * from actividades where id= ?");
			pst.setInt(1, idActividad);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				Actividad actividad = new Actividad();
				actividad.setId(rs.getInt("id"));
				actividad.setNombre(rs.getString("nombre"));
				actividad.setDias(rs.getString("dias_semana"));
				actividad.setFecha_inicio(rs.getDate("fecha_inicio"));
				actividad.setHoras(rs.getInt("horas"));
				actividad.setMaxParticipantes(rs.getInt("max_participantes"));
				actividad.setPrecio(rs.getDouble("precio"));
				
				return actividad;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public void update(Actividad actividad) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("UPDATE actividades SET dias_semana = ? WHERE id = ?");
			pst.setString(1, actividad.getDias());
			pst.setInt(2, actividad.getId());
			pst.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
