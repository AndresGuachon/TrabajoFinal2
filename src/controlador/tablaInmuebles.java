/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import javax.swing.table.AbstractTableModel;
import modelo.inmuebles;

/**
 *
 * @author 
 */
public class tablaInmuebles extends AbstractTableModel{
    ListaEnlazada<inmuebles> lista;

    public ListaEnlazada<inmuebles> getLista() {
        return lista;
    }

    public void setLista(ListaEnlazada<inmuebles> lista) {
        this.lista = lista;
    }

    @Override
    public int getRowCount() {
        return lista.getSize();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public String getColumnName(int column){
        switch (column) {
            case 0: return "Id";
            case 1: return "Nombre";
            case 2: return "Precio";
            case 3: return "Area";
            default: return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        inmuebles inm = lista.obtenerDato(rowIndex);
        switch (columnIndex) {
            case 0: return inm.getIDInmueble();
            case 1: return inm.getTipo();
            case 2: return inm.getPrecio();
            case 3: return inm.getArea();
            default: return null;
        }
    }
}
