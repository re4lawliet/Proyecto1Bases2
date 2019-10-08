/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1bases2;

/**
 *
 * @author Haldamir
 */
public class Usuario {
    public String id_usuario;
    public String nombre_completo;
    public String dpi;
    
    public String getId_Usuario(){
        return id_usuario;
    }
    
    public String getNombre_Completo(){
        return nombre_completo;
    }
    
    @Override
    public String toString() {
        return nombre_completo + " - " + dpi;
    }
    
}
