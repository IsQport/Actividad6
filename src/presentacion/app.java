/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package presentacion;

import datos.Acceso;

/**
 *
 * @author Main7
 */
public class app {

    
    public static void main(String[] args) {
        Acceso.cargarArchivos("cliente.txt");
        
        FrmCliente cl = new FrmCliente();
        cl.setVisible(true);
    }
    
}
