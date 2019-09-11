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
public class TipoDenuncia {
   private int codigoTpoDenuncia;
   private String descricaoDenuncia;

    public TipoDenuncia() {
    }

    public TipoDenuncia(int codigoTpoDenuncia) {
        this.codigoTpoDenuncia = codigoTpoDenuncia;
    }

    public TipoDenuncia(int codigoTpoDenuncia, String descricaoDenuncia) {
        this.codigoTpoDenuncia = codigoTpoDenuncia;
        this.descricaoDenuncia = descricaoDenuncia;
    }

    public int getCodigoTpoDenuncia() {
        return codigoTpoDenuncia;
    }

    public void setCodigoTpoDenuncia(int codigoTpoDenuncia) {
        this.codigoTpoDenuncia = codigoTpoDenuncia;
    }

    public String getDescricaoDenuncia() {
        return descricaoDenuncia;
    }

    public void setDescricaoDenuncia(String descricaoDenuncia) {
        this.descricaoDenuncia = descricaoDenuncia;
    }

    @Override
    public String toString() {
        return "TipoDenuncia{" + "codigoTpoDenuncia=" + codigoTpoDenuncia + ", descricaoDenuncia=" + descricaoDenuncia + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.codigoTpoDenuncia;
        hash = 79 * hash + Objects.hashCode(this.descricaoDenuncia);
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
        final TipoDenuncia other = (TipoDenuncia) obj;
        if (this.codigoTpoDenuncia != other.codigoTpoDenuncia) {
            return false;
        }
        if (!Objects.equals(this.descricaoDenuncia, other.descricaoDenuncia)) {
            return false;
        }
        return true;
    }

   
    
}
