/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import datos.ClienteDAO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Main7
 */
public class ClienteService {
    
    private ClienteDAO clienteDao;
    private Cliente cliente;
    private DefaultTableModel modeloTabla;

    public ClienteService() {
        this.clienteDao = new ClienteDAO();
        this.cliente = new Cliente();
    }
    
    public DefaultTableModel listar(){
        String[] titulos = {"CI", "NOMBRE"};
        this.modeloTabla = new DefaultTableModel(null, titulos);
        
        String[] registro = new String[2];
        List<Cliente> lista = clienteDao.listar();
        
        for(Cliente c: lista){
            registro[0] = Integer.toString(c.getCi());
            registro[1] = c.getNombre();
            this.modeloTabla.addRow(registro);
    
        }
        return this.modeloTabla;
    }
    
    public String insertar(Integer ci, String nombre){
        if(clienteDao.buscaCodigo(ci) != -1){
            return "El CI ingresado ya existe";
        }else{
            cliente.setCi(ci);
            cliente.setNombre(nombre);
            
            if(clienteDao.insertar(cliente)){
                return "OK";
            }else{
                return "Error en el Registro";
            }   
        }
    }
    
    public String actualizar(Integer ci, String nombre){
        
        cliente.setCi(ci);
        cliente.setNombre(nombre);

        if(clienteDao.actualizar(cliente)){
            return "OK";
        }else{
            return "Error en el Registro";
        }   
        
    }
}
