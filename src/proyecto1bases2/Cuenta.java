/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1bases2;


public class Cuenta {
    
    public String id;
    public String codigo;
    public String nombre;
    public String estado;
    
    public String getId(){
        return id;
    }
    public String getEstado(){
        return estado;
    }
    
    public String getCodigo(){
        return codigo;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    @Override
    public String toString() {
        String s = "Activa";
        if(estado.equals("0")){
            s = "Cancelada";
        }else if(estado.equals("1")){
            s = "Activa";
        }else if(estado.equals("2")){
            s = "Bloqueada";
        }
        return codigo + " - " + nombre+ " - " + s;
    }
    
    
}
