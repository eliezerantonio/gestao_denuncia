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
public class TipoFuncionario {

    private int codigoTipoFuncionario;
    private String descricaoFuncionario;

    public TipoFuncionario() {
    }

    public TipoFuncionario(int codigoTipoFuncionario) {
        this.codigoTipoFuncionario = codigoTipoFuncionario;
    }
    

    public TipoFuncionario(int codigoTipoFuncionario, String descricaoFuncionario) {
        this.codigoTipoFuncionario = codigoTipoFuncionario;
        this.descricaoFuncionario = descricaoFuncionario;
    }

    public String getDescricaoFuncionario() {
        return descricaoFuncionario;
    }

    public void setDescricaoFuncionario(String descricaoFuncionario) {
        this.descricaoFuncionario = descricaoFuncionario;
    }

    public int getCodigoTipoFuncionario() {
        return codigoTipoFuncionario;
    }

    public void setCodigoTipoFuncionario(int codigoTipoFuncionario) {
        this.codigoTipoFuncionario = codigoTipoFuncionario;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + this.codigoTipoFuncionario;
        hash = 31 * hash + Objects.hashCode(this.descricaoFuncionario);
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
        final TipoFuncionario other = (TipoFuncionario) obj;
        if (this.codigoTipoFuncionario != other.codigoTipoFuncionario) {
            return false;
        }
        if (!Objects.equals(this.descricaoFuncionario, other.descricaoFuncionario)) {
            return false;
        }
        return true;
    }
    
    
    

}
