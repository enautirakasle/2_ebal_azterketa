package ejecutables;

import java.util.Scanner;

import modelo.bean.Usuario;
import modelo.dao.ModeloUsuario;

public class InsertarUsuario {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Introduce tu nombre y apellido");
		String nombreApellido = scan.nextLine();
		
		System.out.println("Introduce el DNI");
		String dni = scan.nextLine();
		
		System.out.println("Introduce el codigo de usuario");
		String codigo = scan.nextLine();
		
		Usuario usuario = new Usuario();
		usuario.setNombreApellido(nombreApellido);
		usuario.setDni(dni);
		usuario.setCodigo(codigo);
		
		ModeloUsuario mUsuario = new ModeloUsuario();
		
		if(!mUsuario.exist(codigo)){
			mUsuario.insert(usuario);
			System.out.println("Usuario registrado");
		}else{
			System.out.println("Codigo duplicado");
		}
		
		
		
	}

}
