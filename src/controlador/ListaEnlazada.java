/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.utiles.TipoOrdenacion;
import controlador.utiles.Utilidades;
import static controlador.utiles.Utilidades.getMethod;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import modelo.clientes;
import modelo.inmuebles;

/**
 *
 * @author
 */
public class ListaEnlazada<E> {

    private NodoLista<E> cabecera;

    private Integer size;

    public NodoLista<E> getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoLista<E> cabecera) {
        this.cabecera = cabecera;
    }

    /**
     * Constructor de la clase se inicializa la lista en null y el tamanio en 0
     */
    public ListaEnlazada() {
        cabecera = null;
        size = 0;
    }

    /**
     * Permite ver si la lista esta vacia
     *
     * @return Boolean true si esta vacia, false si esta llena
     */
    public Boolean estaVacia() {
        return cabecera == null;
    }

    private void insertar(E dato) {
        NodoLista<E> nuevo = new NodoLista<>(dato, null);
        if (estaVacia()) {
            cabecera = nuevo;
        } else {
            NodoLista<E> aux = cabecera;
            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }
            aux.setSiguiente(nuevo);
        }
        size++;
    }

    public void insertarCabecera(E dato) {
        if (estaVacia()) {
            insertar(dato);
        } else {
            NodoLista<E> nuevo = new NodoLista<>(dato, null);

            nuevo.setSiguiente(cabecera);
            cabecera = nuevo;
            size++;
        }
    }

    public void insertar(E dato, Integer pos) {
        //lista size = 1
        if (estaVacia()) {
            insertar(dato);
        } else if (pos >= 0 && pos < size) {
            NodoLista<E> nuevo = new NodoLista<>(dato, null);
            if (pos == (size - 1)) {
                insertar(dato);

            } else {

                NodoLista<E> aux = cabecera;
                for (int i = 0; i < pos - 1; i++) {
                    aux = aux.getSiguiente();
                }
                NodoLista<E> siguiente = aux.getSiguiente();
                aux.setSiguiente(nuevo);
                nuevo.setSiguiente(siguiente);
                size++;
            }

        }
    }

    public void imprimir() {
        System.out.println("**************************");
        NodoLista<E> aux = cabecera;
        for (int i = 0; i < getSize(); i++) {
            System.out.print(aux.getDato().toString() + "\t");
            aux = aux.getSiguiente();
        }
        System.out.println("\n" + "**************************");
    }

    public Integer getSize() {
        return size;
    }

    /**
     * Metodo que permite obtener un dato segun la posicion
     *
     * @param pos posicion en la lista
     * @return Elemento
     */
    public E obtenerDato(Integer pos) {
        if (!estaVacia()) {
            if (pos >= 0 && pos < size) {
                E dato = null;
                if (pos == 0) {
                    dato = cabecera.getDato();
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    }
                    dato = aux.getDato();
                }

                return dato;
            }
        }
        return null;
    }

    public void vaciar() {
        cabecera = null;
        size = 0;
        //en c utilizamos el free
        //malloc
    }

    public void modificarDato(Integer pos, E datoM) {
        if (!estaVacia()) {
            if (pos >= 0 && pos < size) {
                // E dato = null;
                if (pos == 0) {
                    cabecera.setDato(datoM);
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSiguiente();
                    }
                    aux.setDato(datoM);
                }

            } else {
                System.out.println("Error en obtener dato: No existe la posicion dada");
            }

        } else {
            System.out.println("Error en obtener dato: La lista esta vacia, por endde no hay esa posicion");
        }
    }

    public E[] toArray() {
        // E[] matriz = (E[]) (new Object[this.size]);
        Class<E> clazz = null;
        E[] matriz = null;
        if (this.size > 0) {
            matriz = (E[]) java.lang.reflect.Array.newInstance(cabecera.getDato().getClass(), this.size);
            NodoLista<E> aux = cabecera;
            for (int i = 0; i < this.size; i++) {
                matriz[i] = aux.getDato();
                //System.out.print(aux.getDato().toString() + "\t");
                aux = aux.getSiguiente();
            }
        }

        return matriz;
    }

    public ListaEnlazada<E> toList(E[] matriz) {
        //E[] matriz = (E[]) (new Object[this.size]);
        this.vaciar();
        for (int i = 0; i < matriz.length; i++) {
            this.insertar(matriz[i]);
        }
        return this;
    }

    private Object[] evaluaCambiarDatoNoObjeto(Class clazz, E auxJ, E auxJ1, TipoOrdenacion tipoOrdenacion, Integer j, E[] matriz) throws Exception {
        Object aux[] = new Object[2];//aux[0];--->null
        if (clazz.getSuperclass().getSimpleName().equalsIgnoreCase("Number")) {
            // Number datoJ = (Number) auxJ;
            // Number datoJ1 = (Number) auxJ1;
            if (tipoOrdenacion.toString().equalsIgnoreCase(TipoOrdenacion.ASCENDENTE.toString())) {
                if ((((Number) auxJ).doubleValue() > ((Number) auxJ1).doubleValue())) {
                    aux[0] = auxJ1;
                    aux[1] = j;
                    //  cambioBurbuja(j, matriz);
                }
            } else {
                if ((((Number) auxJ).doubleValue() < ((Number) auxJ1).doubleValue())) {
                    // cambioBurbuja(j, matriz);
                    aux[0] = auxJ1;
                    aux[1] = j;
                }
            }
        } else if (Utilidades.isString(clazz)) {
            String datoJ = (String) auxJ;
            String datoJ1 = (String) auxJ1;
            if (tipoOrdenacion.toString().equalsIgnoreCase(TipoOrdenacion.ASCENDENTE.toString())) {
                if ((datoJ.toLowerCase().compareTo(datoJ1.toLowerCase()) > 0)) {
                    //cambioBurbuja(j, matriz);
                    aux[0] = auxJ1;
                    aux[1] = j;
                }
            } else {
                if ((datoJ.toLowerCase().compareTo(datoJ1.toLowerCase()) < 0)) {
                    //cambioBurbuja(j, matriz);
                    aux[0] = auxJ1;
                    aux[1] = j;
                }
            }

        } else if (Utilidades.isCharacter(clazz)) {
            Character datoJ = (Character) auxJ;
            Character datoJ1 = (Character) auxJ1;
            if (tipoOrdenacion.toString().equalsIgnoreCase(TipoOrdenacion.ASCENDENTE.toString())) {
                if (datoJ > datoJ1) {
                    //cambioBurbuja(j, matriz);
                    aux[0] = auxJ1;
                    aux[1] = j;
                }
            } else {
                if (datoJ < datoJ1) {
                    //cambioBurbuja(j, matriz);
                    aux[0] = auxJ1;
                    aux[1] = j;
                }
            }

        }
        return aux;
    }

    private Object[] evaluaCambiarDato(Class clazz, E auxJ, E auxJ1, Method method, Method method1, TipoOrdenacion tipoOrdenacion, Integer j) throws Exception {
        Object aux[] = new Object[2];
        if (clazz.getSuperclass().getSimpleName().equalsIgnoreCase("Number")) {
            Number datoJ = (Number) method.invoke(auxJ);
            Number datoJ1 = (Number) method1.invoke(auxJ1);
            if (tipoOrdenacion.toString().equalsIgnoreCase(TipoOrdenacion.ASCENDENTE.toString())) {
                if ((datoJ.doubleValue() > datoJ1.doubleValue())) {
                    // cambioBurbuja(j, matriz);
                    aux[0] = auxJ1;
                    aux[1] = j;
                }
            } else {
                if ((datoJ.doubleValue() < datoJ1.doubleValue())) {
                    //    cambioBurbuja(j, matriz);
                    aux[0] = auxJ1;
                    aux[1] = j;
                }
            }
        } else if (Utilidades.isString(clazz)) {
            String datoJ = (String) method.invoke(auxJ);
            String datoJ1 = (String) method1.invoke(auxJ1);
            if (tipoOrdenacion.toString().equalsIgnoreCase(TipoOrdenacion.ASCENDENTE.toString())) {
                if ((datoJ.toLowerCase().compareTo(datoJ1.toLowerCase()) > 0)) {
                    //   cambioBurbuja(j, matriz);
                    aux[0] = auxJ1;
                    aux[1] = j;
                }
            } else {
                if ((datoJ.toLowerCase().compareTo(datoJ1.toLowerCase()) < 0)) {
                    //  cambioBurbuja(j, matriz);
                    aux[0] = auxJ1;
                    aux[1] = j;
                }
            }

        } else if (Utilidades.isCharacter(clazz)) {
            Character datoJ = (Character) method.invoke(auxJ);
            Character datoJ1 = (Character) method1.invoke(auxJ1);
            if (tipoOrdenacion.toString().equalsIgnoreCase(TipoOrdenacion.ASCENDENTE.toString())) {
                if (datoJ > datoJ1) {
                    // cambioBurbuja(j, matriz);
                    aux[0] = auxJ1;
                    aux[1] = j;
                }
            } else {
                if (datoJ < datoJ1) {
                    //  cambioBurbuja(j, matriz);
                    aux[0] = auxJ1;
                    aux[1] = j;
                }
            }

        }
        return aux;
    }

    public ListaEnlazada<E> shell(String atributo, TipoOrdenacion tipoOrdenacion) throws Exception {
        Class<E> clazz = null;
        if (size > 0) {
            clazz = (Class<E>) cabecera.getDato().getClass();//primitivo, Dato envolvente, Object
            Boolean isObject = Utilidades.isObject(clazz);//si es objeto
            int n = size;
            int salto = n;
            boolean ordenado;
            while (salto > 1) {
                salto = salto / 2;
                do {
                    ordenado = true;
                    for (int j = 0; j <= n - 1 - salto; j++) {
                        int k = j + salto;
                        if (isObject) {
                            Field field = Utilidades.getField(atributo, clazz);
                            E auxJ = this.obtenerDato(j);
                            E auxK = this.obtenerDato(k);
                            Method method = getMethod("get" + Utilidades.capitalizar(atributo), auxJ.getClass());
                            Method method1 = getMethod("get" + Utilidades.capitalizar(atributo), auxK.getClass());
                            if (field.getType().getSuperclass().getSimpleName().equalsIgnoreCase("Number")) {
                                Number datoJ = (Number) method.invoke(auxJ);
                                Number datoK = (Number) method1.invoke(auxK);
                                if (tipoOrdenacion.toString().equalsIgnoreCase(tipoOrdenacion.ASCENDENTE.toString())) {
                                    if (datoJ.doubleValue() > datoK.doubleValue()) {
                                        E aux = auxJ;
                                        this.modificarDato(j, auxK);
                                        this.modificarDato(k, aux);
                                        ordenado = false;
                                    }
                                } else {
                                    if (datoJ.doubleValue() < datoK.doubleValue()) {
                                        E aux = auxJ;
                                        this.modificarDato(j, auxK);
                                        this.modificarDato(k, aux);
                                        ordenado = false;
                                    }
                                }
                            }
                            if (Utilidades.isString(field.getType())) {
                                String datoJ = (String) method.invoke(auxJ);
                                String datoK = (String) method1.invoke(auxK);
                                if (tipoOrdenacion.toString().equalsIgnoreCase(tipoOrdenacion.ASCENDENTE.toString())) {
                                    if (datoJ.toLowerCase().compareTo(datoK.toLowerCase()) > 0) {
                                        E aux = auxJ;
                                        this.modificarDato(j, auxK);
                                        this.modificarDato(k, aux);
                                        ordenado = false;
                                    }
                                } else {
                                    if (datoJ.toLowerCase().compareTo(datoK.toLowerCase()) < 0) {
                                        E aux = auxJ;
                                        this.modificarDato(j, auxK);
                                        this.modificarDato(k, aux);
                                        ordenado = false;
                                    }
                                }
                            }
                            if (Utilidades.isCharacter(field.getType())) {
                                Character datoJ = (Character) method.invoke(auxJ);
                                Character datoK = (Character) method1.invoke(auxK);
                                if (tipoOrdenacion.toString().equalsIgnoreCase(tipoOrdenacion.ASCENDENTE.toString())) {
                                    if (datoJ > datoK) {
                                        E aux = auxJ;
                                        this.modificarDato(j, auxK);
                                        this.modificarDato(k, aux);
                                        ordenado = false;
                                    }
                                } else {
                                    if (datoJ < datoK) {
                                        E aux = auxJ;
                                        this.modificarDato(j, auxK);
                                        this.modificarDato(k, aux);
                                        ordenado = false;
                                    }
                                }
                            }
                        }
                    }
                } while (!ordenado);
            }
        }
        return this;
    }

    /*public ListaEnlazada<cliente> QuickSortedad(ListaEnlazada<cliente> lista, Integer izq, Integer der, TipoOrdenacion tipoOrdenacion) throws Exception {
        ListaEnlazada<cliente> listap = null;
        listap = lista;
        cliente aux;
        cliente pivote = listap.obtenerDato(izq);
        int i = izq;
        int j = der;
        while (i < j) {
            if (tipoOrdenacion.toString().equalsIgnoreCase(tipoOrdenacion.ASCENDENTE.toString())) { //Si se cambia de ascendente a descendente se tardara mas de 1 min pero funcionara
                while (listap.obtenerDato(i).getEdad() <= pivote.getEdad() && i < j) {
                    i++;
                }
                while (listap.obtenerDato(j).getEdad() > pivote.getEdad()) {
                    j--;
                }
            } else { //Si se cambia de ascendente a descendente se tardara mas de 1 min pero funcionara
                while (listap.obtenerDato(i).getEdad() >= pivote.getEdad() && i < j) {
                    i++;
                }
                while (listap.obtenerDato(j).getEdad() < pivote.getEdad()) {
                    j--;
                }
            }
            if (i < j) {
                aux = listap.obtenerDato(i);
                listap.modificarDato(i, listap.obtenerDato(j));
                listap.modificarDato(j, aux);
            }
        }
        listap.modificarDato(izq, listap.obtenerDato(j));
        listap.modificarDato(j, pivote);

        if (izq < j - 1) {
            QuickSortedad(listap, izq, j - 1, tipoOrdenacion);
        }

        if (j + 1 < der) {
            QuickSortedad(listap, j + 1, der, tipoOrdenacion);
        }
        return listap;
    }*/

    public ListaEnlazada<clientes> QuickSortID(ListaEnlazada<clientes> lista, Integer izq, Integer der, TipoOrdenacion tipoOrdenacion) throws Exception {
        clientes aux;
        clientes pivote = lista.obtenerDato(izq);
        int i = izq;
        int j = der;
        while (i < j) {
            if (tipoOrdenacion.toString().equalsIgnoreCase(tipoOrdenacion.ASCENDENTE.toString())) { //Si se cambia de ascendente a descendente se tardara mas de 1 min pero funcionara
                while (lista.obtenerDato(i).getIDPersona() <= pivote.getIDPersona() && i < j) {
                    i++;
                }
                while (lista.obtenerDato(j).getIDPersona() > pivote.getIDPersona()) {
                    j--;
                }
            } else { //Si se cambia de ascendente a descendente se tardara mas de 1 min pero funcionara
                while (lista.obtenerDato(i).getIDPersona() >= pivote.getIDPersona() && i < j) {
                    i++;
                }
                while (lista.obtenerDato(j).getIDPersona() < pivote.getIDPersona()) {
                    j--;
                }
            }
            if (i < j) {
                aux = lista.obtenerDato(i);
                lista.modificarDato(i, lista.obtenerDato(j));
                lista.modificarDato(j, aux);
            }
        }
        lista.modificarDato(izq, lista.obtenerDato(j));
        lista.modificarDato(j, pivote);

        if (izq < j - 1) {
            QuickSortID(lista, izq, j - 1, tipoOrdenacion);
        }

        if (j + 1 < der) {
            QuickSortID(lista, j + 1, der, tipoOrdenacion);
        }
        return lista;
    }

    public ListaEnlazada<clientes> QuickSortNombre(ListaEnlazada<clientes> lista, Integer izq, Integer der, TipoOrdenacion tipoOrdenacion) throws Exception {
        clientes aux;
        clientes pivote = lista.obtenerDato(izq);
        int i = izq;
        int j = der;
        while (i < j) {
            if (tipoOrdenacion.toString().equalsIgnoreCase(tipoOrdenacion.ASCENDENTE.toString())) { //Si se cambia de ascendente a descendente se tardara mas de 1 min pero funcionara
                while (lista.obtenerDato(i).getNombre().compareTo(pivote.getNombre()) <= 0 && i < j) {
                    i++;
                }
                while (lista.obtenerDato(j).getNombre().compareTo(pivote.getNombre()) > 0) {
                    j--;
                }
            } else { //Si se cambia de ascendente a descendente se tardara mas de 1 min pero funcionara
                while (lista.obtenerDato(i).getNombre().compareTo(pivote.getNombre()) >= 0 && i < j) {
                    i++;
                }
                while (lista.obtenerDato(j).getNombre().compareTo(pivote.getNombre()) < 0) {
                    j--;
                }
            }
            if (i < j) {
                aux = lista.obtenerDato(i);
                lista.modificarDato(i, lista.obtenerDato(j));
                lista.modificarDato(j, aux);
            }
        }
        lista.modificarDato(izq, lista.obtenerDato(j));
        lista.modificarDato(j, pivote);

        if (izq < j - 1) {
            QuickSortNombre(lista, izq, j - 1, tipoOrdenacion);
        }

        if (j + 1 < der) {
            QuickSortNombre(lista, j + 1, der, tipoOrdenacion);
        }
        return lista;
    }

    public String llenarString() {
        String palabra = "";
        for (int i = 1; i <= 5; i++) {
            int c = (int) ((Math.random() * (('z' - 'a') + 1)) + 'a');
            char l = (char) c;
            palabra = palabra + l;
        }
        return palabra;
    }

    public Integer llenarInt() {
        Integer i = 0;
        i = (int) (Math.random() * 100);
        return i;
    }

    /*public ListaEnlazada<clientes> llenarLista() {
        ListaEnlazada<clientes> liPersona = new ListaEnlazada<>();
        for (int i = 0; i < 1000; i++) {
            clientes person = new clientes();
            person.setEdad(llenarInt());
            person.setIDPersona(i);
            person.setNombre(llenarString());
            liPersona.insertarCabecera(person);
        }
        return liPersona;
    }*/
    public boolean binaria(Object valor, ListaEnlazada<E> lista, String atributo) throws Exception {
        boolean encontrado = false;
        Class<E> clazz = null;
        clazz = (Class<E>) cabecera.getDato().getClass();
        int inicio = 0;
        int fin = lista.getSize() - 1;
        Boolean isObject = Utilidades.isObject(clazz);
        while (inicio <= fin && !encontrado) {
            int medio = (inicio + fin) / 2;
            if (isObject) {
                Field field = Utilidades.getField(atributo, clazz);
                E auxMedio = this.obtenerDato(medio);
                Method method = getMethod("get" + Utilidades.capitalizar(atributo), auxMedio.getClass());
                if (field.getType().getSuperclass().getSimpleName().equalsIgnoreCase("Number")) {
                    shell(atributo, TipoOrdenacion.ASCENDENTE);
                    Number datoMedio = (Number) method.invoke(auxMedio);
                    if (datoMedio.intValue() == (int) valor) {
                        encontrado = true;
                    } else {
                        if (datoMedio.intValue() > (int) valor) {
                            fin = medio - 1;
                        } else {
                            inicio = medio + 1;
                        }
                    }
                }
                if (Utilidades.isString(field.getType())) {
                    shell(atributo, TipoOrdenacion.ASCENDENTE);
                    String datoMedio = (String) method.invoke(auxMedio);
                    if (datoMedio.equalsIgnoreCase(valor.toString())) {
                        encontrado = true;
                    } else {
                        if (datoMedio.toLowerCase().compareTo(valor.toString().toLowerCase()) > 0) {
                            fin = medio - 1;
                        } else {
                            inicio = medio + 1;
                        }
                    }
                }
            }
        }
        return encontrado;
    }

   public void agregar(Object[] o) {
        ListaEnlazada<inmuebles> listaInm = new ListaEnlazada<>();
  tablaInmuebles tp = new tablaInmuebles();
        try {
          //  tp.setLista(listaInm);
           // tp.setLista(listaInm);
         //   tp.setLista(listaInm);
            //tp.setLista(listaInm);
            //tp.setLista(listaInm);

        } catch (Exception e) {

        }
    }
public void editar(Object[] o) {
      ListaEnlazada<inmuebles> listaInm = new ListaEnlazada<>();
  tablaInmuebles tp = new tablaInmuebles();
        try {
          //  tp.setLista(listaInm);
           // tp.setLista(listaInm);
         //   tp.setLista(listaInm);
            //tp.setLista(listaInm);
            //tp.setLista(listaInm);

        } catch (Exception e) {

        } 
   }
}
