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
public class Provincia {

    private int codigoProvincia;
    private String descricaoDenucia;

    public Provincia() {
    }

    
    
    public Provincia(int codigoProvincia, String descricaoDenucia) {
        this.codigoProvincia = codigoProvincia;
        this.descricaoDenucia = descricaoDenucia;
    }

    public Provincia(String descricaoDenucia) {
        this.descricaoDenucia = descricaoDenucia;
    }

    public int getCodigoProvincia() {
        return codigoProvincia;
    }

    public void setCodigoProvincia(int codigoProvincia) {
        this.codigoProvincia = codigoProvincia;
    }

    public String getDescricaoDenucia() {
        return descricaoDenucia;
    }

    public void setDescricaoDenucia(String descricaoDenucia) {
        this.descricaoDenucia = descricaoDenucia;
    }

    @Override
    public String toString() {
        return "Provincia{" + "codigoProvincia=" + codigoProvincia + ", descricaoDenucia=" + descricaoDenucia + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.codigoProvincia;
        hash = 59 * hash + Objects.hashCode(this.descricaoDenucia);
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
        final Provincia other = (Provincia) obj;
        if (this.codigoProvincia != other.codigoProvincia) {
            return false;
        }
        if (!Objects.equals(this.descricaoDenucia, other.descricaoDenucia)) {
            return false;
        }
        return true;
    }

}
