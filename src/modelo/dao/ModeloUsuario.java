package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import modelo.Conector;
import modelo.bean.Usuario;

public class ModeloUsuario extends Conector{

	public boolean exist(String codigo) {
		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("select * from usuarios where codigo = ?");
			pst.setString(1, codigo);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public Usuario get(String codigo) {
		PreparedStatement pst;
		try {
			pst = super.conexion.prepareStatement("select * from usuarios where codigo = ?");
			pst.setString(1, codigo);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNombreApellido(rs.getString("nombre_apellido"));
				usuario.setDni(rs.getString("dni"));
				usuario.setCodigo(rs.getString("codigo"));
				
				return usuario;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public void insert(Usuario usuario) {
		try {
			PreparedStatement pst = super.conexion.prepareStatement("insert into usuarios (nombre_apellido, dni, codigo) values (?, ?, ?)");
			pst.setString(1, usuario.getNombreApellido());
			pst.setString(2, usuario.getDni());
			pst.setString(3, usuario.getCodigo());
			
			pst.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
