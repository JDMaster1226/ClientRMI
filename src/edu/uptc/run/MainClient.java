package edu.uptc.run;

import java.rmi.RemoteException;
import java.util.Scanner;

import javax.swing.JOptionPane;
import edu.uptc.conexion.Conexion;
import edu.uptc.remote.IMethods;

public class MainClient {

	public String solicitarNombre(){
		return JOptionPane.showInputDialog("Ingrese su nombre");
	}

	public int numeroUno(){
		return Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero Uno"));
	}

	public int numeroDos(){
		return Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero Dos"));
	}

	public int pedir() {
		return Integer.parseInt(JOptionPane.showInputDialog("Ingreseme esta"));

	}

	public static void main(String[] args) {
		MainClient mainClient = new MainClient();
		try {
			Conexion conexion = new Conexion();
			IMethods remoteMethods= conexion.searchServer();
			if (remoteMethods != null) {
				Scanner sc =new Scanner(System.in);
				System.out.println("escriba usuario");
				String nombreUser=sc.next();
				remoteMethods.saludo(nombreUser);

				int opcion = 1;
				while(opcion != 3) {
					System.out.println("");
					System.out.println("1.ver productos"
							+ "\n2.agregar compra"
							+ "\n3.salir");
					opcion=sc.nextInt();
					switch (opcion) {
					case 1:
						System.out.println(remoteMethods.listaStock());
						break;

					case 2:
						System.out.println("nombre producto");
						String nombreProducto=sc.next();
						System.out.println("cantidad ");
						int cantidad=sc.nextInt();
						double total=remoteMethods.agregarCompra(nombreUser, nombreProducto, cantidad);
						if(total>=0) {
							System.out.println("compra exitosa, total = "+total+"$");
						}else if(total==-1) {
							System.out.println("error, producto no encontrado");
						}else {
							System.out.println("error, cantidad no disponible");
						}
						break;
						
					default:
						System.out.println("hasta luego....");
						break;
					}
				}


			}else{
				System.out.println("Problemas con la conexion");
			}
		}catch (RemoteException e) {
			System.out.println("Problema con los metodos remotos");
		}
	}

}
