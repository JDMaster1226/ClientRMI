package edu.uptc.run;

import java.rmi.RemoteException;
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
				remoteMethods.saludo("juan");
				
					System.out.println(remoteMethods.listaStock());
					System.out.println("quiero soja, 50 unidades");
					remoteMethods.agregarCompra("juan", "soja", 50);
					
				
			}else{
				System.out.println("Problemas con la conexion");
			}
		}catch (RemoteException e) {
			System.out.println("Problema con los metodos remotos");
		}
	}

}
