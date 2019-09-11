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
public class Municipio {
    private int codigoMunicipio;
    private String nomeMunicipio;
    private Provincia provicia;

    public Municipio() {
    }

    public Municipio(int codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }
    
    

    public Municipio(String nomeMunicipio, Provincia provicia) {
        this.nomeMunicipio = nomeMunicipio;
        this.provicia = provicia;
    }

    public Municipio(int codigoMunicipio, String nomeMunicipio, Provincia provicia) {
        this.codigoMunicipio = codigoMunicipio;
        this.nomeMunicipio = nomeMunicipio;
        this.provicia = provicia;
    }

    
    
    public int getCodigoMunicipio() {
        return codigoMunicipio;
    }

    public void setCodigoMunicipio(int codigoMunicipio) {
        this.codigoMunicipio = codigoMunicipio;
    }

    public String getNomeMunicipio() {
        return nomeMunicipio;
    }

    public void setNomeMunicipio(String nomeMunicipio) {
        this.nomeMunicipio = nomeMunicipio;
    }

    public Provincia getProvicia() {
        return provicia;
    }

    public void setProvicia(Provincia provicia) {
        this.provicia = provicia;
    }
  @Override
    public String toString() {
        return "Municipio{" + "codigoMunicipio=" + codigoMunicipio + ", nomeMunicipio=" + nomeMunicipio + ", provicia=" + provicia + '}';
    }

  
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + this.codigoMunicipio;
        hash = 41 * hash + Objects.hashCode(this.nomeMunicipio);
        hash = 41 * hash + Objects.hashCode(this.provicia);
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
        final Municipio other = (Municipio) obj;
        if (this.codigoMunicipio != other.codigoMunicipio) {
            return false;
        }
        if (!Objects.equals(this.nomeMunicipio, other.nomeMunicipio)) {
            return false;
        }
        if (!Objects.equals(this.provicia, other.provicia)) {
            return false;
        }
        return true;
    }

 
    
    
    
}
