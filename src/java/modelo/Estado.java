/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Objects;

/**
 *
 * @author eliezer
 */
public class Estado {
    private int codigoEstado;
    private String descricaoEstado;

    public Estado() {
    }

    public Estado(int codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public int getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(int codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public String getDescricaoEstado() {
        return descricaoEstado;
    }

    public void setDescricaoEstado(String descricaoEstado) {
        this.descricaoEstado = descricaoEstado;
    }

    public Estado(int codigoEstado, String descricaoEstado) {
        this.codigoEstado = codigoEstado;
        this.descricaoEstado = descricaoEstado;
    }

    public Estado(String descricaoEstado) {
        this.descricaoEstado = descricaoEstado;
    }

    @Override
    public String toString() {
        return "Estado{" + "codigoEstado=" + codigoEstado + ", descricaoEstado=" + descricaoEstado + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + this.codigoEstado;
        hash = 47 * hash + Objects.hashCode(this.descricaoEstado);
        return hash;
    }

   

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Estado other = (Estado) obj;
        if (this.codigoEstado != other.codigoEstado) {
            return false;
        }
        if (this.descricaoEstado != other.descricaoEstado) {
            return false;
        }
        return true;
    }
    
    
    
    
}
