/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import negocio.Cliente;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

/**
 *
 * @author Main7
 */
public class ClienteDAO implements metodosDAO<Cliente>{
    
    private final List<Cliente> lista;
    private Metodos<Cliente> metodos;
    private final String ruta = "cliente.txt";
    private boolean resp;
    private Cliente cliente;
    
    
    
    public ClienteDAO() {
        
        lista = new ArrayList<>();
        metodos = new Metodos<>(lista);
        cargarLista();
    }
    
    private void cargarLista(){
        
        Cliente cliente;
        for(String dato: Acceso.cargarArchivos(ruta)){
            StringTokenizer st = new StringTokenizer(dato,",");
            cliente = new Cliente(Integer.parseInt(st.nextToken()),st.nextToken());
            metodos.agregarRegistro(cliente);
        }
    }
    
    @Override
    public List listar() {
       List<Cliente> registros = new ArrayList<>();
       
        try {
            for(String dato: Acceso.cargarArchivos(ruta)){
                StringTokenizer st = new StringTokenizer(dato,",");
                cliente = new Cliente(Integer.parseInt(st.nextToken()),st.nextToken());
                registros.add(cliente);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar clientes "+ e.getMessage());
        }
        return registros;
    }

    @Override
    public boolean insertar(Cliente obj) {
        
        resp = false;
        PrintWriter pw;
        FileWriter fw;
        
        try{
            fw = new FileWriter("Archivos/"+ruta);
            pw = new PrintWriter(fw);
            obj = new Cliente(obj.getCi(),obj.getNombre());
            metodos.agregarRegistro(obj);
            for(int i = 0; i< metodos.cantidadRegistro(); i++){
                cliente = metodos.obtenerRegistro(i);
                pw.println(String.valueOf(cliente.getCi()+","+cliente.getNombre()));
            }
            pw.close();
            resp = true;
            
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error al insertar clientes "+ e.getMessage());
        }
        return resp;
        
    }

    @Override
    public boolean actualizar(Cliente obj) {
        resp = false;
        PrintWriter pw;
        FileWriter fw;
        
        try{
            fw = new FileWriter("Archivos/"+ruta);
            pw = new PrintWriter(fw);
            obj = new Cliente(obj.getCi(),obj.getNombre());
            int codigo = buscaCodigo(obj.getCi());
            if(codigo == -1){
                metodos.agregarRegistro(obj);
            }else{
                metodos.modificar(codigo, obj);
            }
            
           
            for(int i = 0; i< metodos.cantidadRegistro(); i++){
                cliente = metodos.obtenerRegistro(i);
                pw.println(String.valueOf(cliente.getCi()+","+cliente.getNombre()));
            }
            pw.close();
            resp = true;
            
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error al modificar clientes "+ e.getMessage());
        }
        return resp;    
    }

    @Override
    public int buscaCodigo(int codigo) {
        
        for(int i=0; i < metodos.cantidadRegistro();i++){
            if(codigo == metodos.obtenerRegistro(i).getCi()){
                return i;
            }
        }
        return -1;
    }
    
}
