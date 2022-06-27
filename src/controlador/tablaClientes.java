/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.clientes;

/**
 *
 * @author LENOVO
 */
public class tablaClientes {
    ListaEnlazada<clientes> lista;

    public ListaEnlazada<clientes> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<clientes> lista) {
        this.lista = lista;
    }

    public int getRowCount() {
        return lista.getSize();
    }

    public int getColumnCount() {
        return 3;
    }
    
    public String getColumnName(int column){
        switch (column) {
            case 0: return "Nombre";
            case 1: return "Apellido";
            case 2: return "Cedula";
            default: return null;
        }
    }

    public Object getValueAt(int rowIndex, int columnIndex) {

        clientes cl = lista.obtenerDato(rowIndex);
        switch (columnIndex) {
            case 0: return cl.getNombre();
            case 1: return cl.getApellido();
            case 2: return cl.getCedula();
            default: return null;
        }
    }
}
