package ejecutables;

import java.util.Scanner;

import modelo.bean.Actividad;
import modelo.dao.ModeloActividad;

public class ModificarDiaSemana {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Introduce un id de actividad");
		int idActividad = Integer.parseInt(scan.nextLine());
		
		ModeloActividad mActividad = new ModeloActividad();
		Actividad actividad = mActividad.get(idActividad);
		
		System.out.println("Introduce los nuevos dias de la semana");
		String diasSemana = scan.nextLine();
		
		actividad.setDias(diasSemana);
		
		mActividad.update(actividad);
		
		System.out.println("Actividad modificada");

	}

}
