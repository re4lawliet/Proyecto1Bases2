package proyecto1bases2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Haldamir
 */
public class Agencia {
    public String id_agencia;
    public String nombre_agencia;
    
    
    
    
    
    public String getValue() {
        return this.id_agencia;
    }

    public String getLabel() {
        return this.nombre_agencia;
    }

    @Override
    public String toString() {
        return this.nombre_agencia;
    }
}
