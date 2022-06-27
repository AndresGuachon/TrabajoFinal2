/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.utiles;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *
 * @author 
 */
public class Utilidades {
    public static Field getField(String name, Class clazz) {
        Field[] fields = clazz.getDeclaredFields();
        Field aux = null;
        for (int i = 0; i < fields.length; i++) {

            if (name.toString().equalsIgnoreCase(fields[i].getName())) {
                aux = fields[i];
                break;
            }

        }
        if (aux != null) return aux;
        
        fields = clazz.getSuperclass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {

            if (name.toString().equalsIgnoreCase(fields[i].getName())) {
                aux = fields[i];
                break;
            }

        }

        return aux;
    }

    public static Method getMethod(String name, Class clazz) {

        Method[] methods = clazz.getDeclaredMethods();
        Method aux = null;

        for (int i = 0; i < methods.length; i++) {
        //    System.out.println(methods[i].getName());
            if (name.toString().equalsIgnoreCase(methods[i].getName())) {
                aux = methods[i];
                break;
            }

        }
        if(aux != null) return aux;
        methods = clazz.getSuperclass().getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
        //    System.out.println(methods[i].getName());
            if (name.toString().equalsIgnoreCase(methods[i].getName())) {
                aux = methods[i];
                break;
            }

        }
        return aux;
    }
      
    public static Boolean isNumber(Class clase) {
        return clase.getSuperclass().getSimpleName().equalsIgnoreCase("Number");
    }
    
    public static Boolean isString(Class clase) {
        return clase.getSimpleName().equalsIgnoreCase("String");
    }
    
    public static Boolean isCharacter(Class clase) {
        return clase.getSimpleName().equalsIgnoreCase("Character");
    }

    public static Boolean isBoolean(Class clase) {
        return clase.getSimpleName().equalsIgnoreCase("Boolean");
    }
    
    public static Boolean isPrimitivo(Class clase) {
        return clase.isPrimitive();
    }
    
    public static Boolean isObject(Class clase) {
        return (!isPrimitivo(clase) && !isBoolean(clase) && !isCharacter(clase)&& !isString(clase)&& !isNumber(clase));
    }
    public static String capitalizar(String field) {
        char[] arr = field.toCharArray();
        arr[0] = Character.toUpperCase(arr[0]);//apellido ---> Apellido
        return new String(arr);
    }

}
