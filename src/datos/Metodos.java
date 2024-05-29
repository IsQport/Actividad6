/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.util.List;

/**
 *
 * @author Main7
 */
public class Metodos<T> {
    
    private final List<T> a;

    public Metodos(List<T> a) {
        this.a = a;
    }
    
    public void agregarRegistro(T p){
        this.a.add(p);
    }
    
    public void modificar(int i, T p){
        this.a.set(i, p);
    }
    
   
    public T obtenerRegistro(int i){
        return (T)this.a.get(i);
    }
    
    public int cantidadRegistro(){
        return this.a.size();
    }
    
}
