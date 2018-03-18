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
				String nombreUser="juan";
				remoteMethods.saludo(nombreUser);

				int opcion = 1;
				while(opcion != 3) {
					System.out.println("");
					System.out.println("1.ver productos"
							+ "\n2.agregar compra"
							+ "\n3.salir");
					switch (opcion) {
					case 1:
						System.out.println(remoteMethods.listaStock());
						break;

					case 2:
						String nombreProducto=sc.nextLine();
						int cantidad=sc.nextInt();
						if(remoteMethods.agregarCompra(nombreUser, nombreProducto, cantidad)) {
							System.out.println("compra exitosa");
						}else {
							System.out.println("error, verifique los datos");
						}
						break;
						
					default:
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
