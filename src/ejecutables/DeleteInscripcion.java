package ejecutables;

import java.util.Scanner;

import modelo.bean.Actividad;
import modelo.bean.Inscripcion;
import modelo.bean.Usuario;
import modelo.dao.ModeloActividad;
import modelo.dao.ModeloInscripcion;
import modelo.dao.ModeloUsuario;

public class DeleteInscripcion {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Introduce un id de actividad");
		int idActividad = Integer.parseInt(scan.nextLine());
		
		ModeloActividad mActividad = new ModeloActividad();
		Actividad actividad = mActividad.get(idActividad);
		
		System.out.println("Introduce un codigo de usuario");
		String codigoUsuario = scan.nextLine();
		
		ModeloUsuario mUsuario = new ModeloUsuario();
		Usuario usuario = mUsuario.get(codigoUsuario);
		
		Inscripcion inscripcion = new Inscripcion();
		inscripcion.setActividad(actividad);
		inscripcion.setUsuario(usuario);
		
		
		ModeloInscripcion mInscripcion = new ModeloInscripcion();
		mInscripcion.delete(inscripcion);
		System.out.println("Borrada la inscripcion");
		
		

	}

}
