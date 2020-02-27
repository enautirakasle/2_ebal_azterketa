package ejecutables;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.bean.Actividad;
import modelo.bean.Inscripcion;
import modelo.bean.Usuario;
import modelo.dao.ModeloActividad;
import modelo.dao.ModeloInscripcion;

public class ConsultarInscripciones {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Introduce un id de actividad");
		int idActividad = Integer.parseInt(scan.nextLine());
		
		ModeloInscripcion mInscripcion = new ModeloInscripcion();

		ArrayList<Usuario> usuariosInscritos = mInscripcion.getUsuariosInscritos(idActividad);
		
		System.out.println("Listado de usuarios inscriptos");
		
		for(int i = 0; i<usuariosInscritos.size(); i++){
			Usuario usuario = usuariosInscritos.get(i);
			
			System.out.println(usuario);
		}
		
	}

}
