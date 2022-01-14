package gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import dao.Archivos;
import dol.Informacion;
import funciones.GestionarArchivos;

public class MenuPrincipal {
	BufferedReader lector1 = new BufferedReader(new InputStreamReader(System.in));
		Scanner scan = new Scanner(System.in);
	
	

public void mostrarMenuPrincipal() throws Exception
	
	{
	GestionarArchivos gp = new GestionarArchivos();
	
	Informacion pr= null;
	
	int opcion = 0 ;
	int IDproducto = 0;
	
	do {
		menuPrincipal();
				
		opcion = validaEntero(lector1);
		
		
		switch (opcion) {
		case 1 -> {
		
			Archivos.writeToFile(gp.mostrarTodo());
			pr = pedirDatos(lector1);
			gp.guardar(pr);
			
		}
		case 2 -> {
			IDproducto = pedirID(lector1);
			pr = pedirDatos(lector1);
			gp.editar(IDproducto, pr);
		}
		case 3 -> {
			Informacion info = gp.mostrarPorId(1);
			mostrarEncabezado();
			imprimirInformacion(info);
		}
		
		case 4 -> {
			IDproducto = pedirID(lector1);
			gp.eliminar(IDproducto);
		}
		case 5 -> {
			Archivos.writeToFile(gp.mostrarTodo());
			mostrarEncabezado();
			for(Informacion product : gp.mostrarTodo())
			{
				imprimirInformacion(product);
			}
		}
		
		case 6 -> {
			System.exit(1);		
			}
		default ->
			throw new IllegalArgumentException("Valor inesperado: " + opcion);
		}
			
	} while(true);
		
	}
	
	 private void menuPrincipal() {
			System.out.println("=======================================================");
			System.out.println("    Bienvenido al Sistema de Registro de Empleados");
			System.out.println("      1.   Agregar Empleado");
			System.out.println("      2.   Editar Empleado");
			System.out.println("      3.   Buscar producto por ID");
			System.out.println("      4.   Eliminar un Empleado");
			System.out.println("      5.   Ver Todos los Empleados ");
			System.out.println("      6.   Salir de la aplicacion");
			System.out.println("=======================================================");
		}
	 
	 private Informacion pedirDatos(BufferedReader lector) throws IOException {
			Informacion info = new Informacion();
			System.out.println("Ingrese el Nombre del Empleado");
			info.setNombre(lector.readLine());
			System.out.println("Ingrese el Apellido del Empleado");
			info.setApellido(lector.readLine());
			System.out.println("Ingrese la Direccion del Empleado");
			info.setDireccion(lector.readLine());
			System.out.println("Ingrese el Salario del Empleado");
			info.setSalario(Double.parseDouble(lector.readLine()));
			return info;
		}
		
		private int pedirID(BufferedReader lector) throws NumberFormatException, IOException {
			int Id = 0;
			System.out.println("Ingrese el ID a Buscar"); 
			Id = Integer.parseInt(lector.readLine());
			
			return Id;
		}
		private void mostrarEncabezado() {
			System.out.println("| Id   |  Nombre      |  Apellido     |  Salario         |  Direccion ");
		}
		private void imprimirInformacion(Informacion info3) {
			System.out.printf("| %-5d",info3.getId());
			System.out.printf("| %-13s",info3.getNombre());
			System.out.printf("| %-14s",info3.getApellido());
			System.out.printf("| C$%-15.2f",info3.getSalario());
			System.out.printf("| %-15s%n",info3.getDireccion());
		}
		private int validaEntero(BufferedReader lector) throws IOException
		{
			int entero = 0;
			boolean fl = false;	
			do {
				try {
					entero = Integer.parseInt(lector.readLine());
					fl = false;
				} catch (NumberFormatException e) {
					System.out.println("Digite un numero entero, intente nuevamente");
					fl = true;
				}
				
			}while(fl);
			
			return entero;
		}
}
