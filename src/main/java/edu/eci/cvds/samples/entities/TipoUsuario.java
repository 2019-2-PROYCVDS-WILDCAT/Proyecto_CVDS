/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cvds.samples.entities;

/**
 *
 * @author AlejandroB
 */
public enum TipoUsuario {
    Comunidad(1),
    Administrador(2);
    private Integer id;
    TipoUsuario(Integer value){
        this.id = value;
    }
    public Integer getId(){
        return id;
    }
    
    public static TipoUsuario fromId(Integer id){
        for (TipoUsuario at : TipoUsuario.values()){
            if (at.getId().equals(id)){
                return at;
            }
        }
        return null;
    }
    public static int getId(String enumTipoUsuario){
        return TipoUsuario.valueOf(enumTipoUsuario).getId();
    }
}
