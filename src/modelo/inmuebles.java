/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author LENOVO
 */
public class inmuebles {

    private Integer IDInmueble;
    private String tipo;
    private Integer precio;
    private Integer area;

    public Integer getIDInmueble() {
        return IDInmueble;
    }

    /**
     * @param IDInmueble the IDInmueble to set
     */
    public void setIDInmueble(Integer IDInmueble) {
        this.IDInmueble = IDInmueble;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the precio
     */
    public Integer getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    /**
     * @return the area
     */
    public Integer getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(Integer area) {
        this.area = area;
    }
    
}
