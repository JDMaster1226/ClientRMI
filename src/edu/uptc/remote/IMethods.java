package edu.uptc.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMethods extends Remote{
	
	public String saludo(String nombre) throws RemoteException;
	public int sumaNumeros(int numeroUno, int numeroDos) throws RemoteException;
	public boolean agregarCompra(String nombreUser,String nombre, int cantidadPedida) throws RemoteException;
	public String listaStock() throws RemoteException;
}
