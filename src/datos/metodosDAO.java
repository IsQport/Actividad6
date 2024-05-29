/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;

import java.util.List;

/**
 *
 * @author Main7
 */
public interface metodosDAO<T> {
    
    public List<T> listar();
    public boolean insertar(T obj);
    public boolean actualizar(T obj);
    public int buscaCodigo(int codigo);
  
}
