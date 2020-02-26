package ejecutables;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.bean.Actividad;
import modelo.bean.Inscripcion;
import modelo.dao.ModeloActividad;
import modelo.dao.ModeloInscripcion;

public class ConsultarInscripciones {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Introduce un id de actividad");
		int idActividad = Integer.parseInt(scan.nextLine());
		
		ModeloActividad mActividad = new ModeloActividad();

		Actividad actividad = mActividad.getConInscipciones(idActividad);
		ArrayList<Inscripcion> inscripciones = actividad.getIscripciones();
		
		System.out.println("Listado de usuarios inscriptos");
		for(int i = 0; i<inscripciones.size(); i++){
			Inscripcion inscripcion = inscripciones.get(i);
			
			System.out.println(inscripcion.getUsuario());
		}
		
	}

}
