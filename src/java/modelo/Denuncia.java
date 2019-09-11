/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author eliezer
 */
public class Denuncia  implements Serializable{
   private Integer codigoDenuncia;
   private Municipio municipio;
   private TipoDenuncia tipoDenuncia;
   private String descricaoDenuncia;
   private Date dataRegistoDenuncia;
   private String nomeCidadaoDenuncia;
   private String emailCidadaoDenuncia;
   private String telefoneCidadaoDenuncia;
   private Date dataNascimentoCidadaoDenuncia;
   private Date dataOcorrenciaDenuncia;

    public Denuncia() {
    }

    public Denuncia(int codigoDenuncia) {
        this.codigoDenuncia = codigoDenuncia;
    }

    public Denuncia(Municipio municipio, TipoDenuncia tipoDenuncia, String descricaoDenuncia, Date dataRegistoDenuncia, String nomeCidadaoDenuncia, String emailCidadaoDenuncia, String telefoneCidadaoDenuncia, Date dataNascimentoCidadaoDenuncia, Date dataOcorrenciaDenuncia) {
        this.municipio = municipio;
        this.tipoDenuncia = tipoDenuncia;
        this.descricaoDenuncia = descricaoDenuncia;
        this.dataRegistoDenuncia = dataRegistoDenuncia;
        this.nomeCidadaoDenuncia = nomeCidadaoDenuncia;
        this.emailCidadaoDenuncia = emailCidadaoDenuncia;
        this.telefoneCidadaoDenuncia = telefoneCidadaoDenuncia;
        this.dataNascimentoCidadaoDenuncia = dataNascimentoCidadaoDenuncia;
        this.dataOcorrenciaDenuncia = dataOcorrenciaDenuncia;
    }

    public Denuncia(int codigoDenuncia, Municipio municipio, TipoDenuncia tipoDenuncia, String descricaoDenuncia, Date dataRegistoDenuncia, String nomeCidadaoDenuncia, String emailCidadaoDenuncia, String telefoneCidadaoDenuncia, Date dataNascimentoCidadaoDenuncia, Date dataOcorrenciaDenuncia) {
        this.codigoDenuncia = codigoDenuncia;
        this.municipio = municipio;
        this.tipoDenuncia = tipoDenuncia;
        this.descricaoDenuncia = descricaoDenuncia;
        this.dataRegistoDenuncia = dataRegistoDenuncia;
        this.nomeCidadaoDenuncia = nomeCidadaoDenuncia;
        this.emailCidadaoDenuncia = emailCidadaoDenuncia;
        this.telefoneCidadaoDenuncia = telefoneCidadaoDenuncia;
        this.dataNascimentoCidadaoDenuncia = dataNascimentoCidadaoDenuncia;
        this.dataOcorrenciaDenuncia = dataOcorrenciaDenuncia;
    }
    

    public int getCodigoDenuncia() {
        return codigoDenuncia;
    }

    public void setCodigoDenuncia(int codigoDenuncia) {
        this.codigoDenuncia = codigoDenuncia;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public TipoDenuncia getTipoDenuncia() {
        return tipoDenuncia;
    }

    public void setTipoDenuncia(TipoDenuncia tipoDenuncia) {
        this.tipoDenuncia = tipoDenuncia;
    }

    public String getDescricaoDenuncia() {
        return descricaoDenuncia;
    }

    public void setDescricaoDenuncia(String descricaoDenuncia) {
        this.descricaoDenuncia = descricaoDenuncia;
    }

    public Date getDataRegistoDenuncia() {
        return dataRegistoDenuncia;
    }

    public void setDataRegistoDenuncia(Date dataRegistoDenuncia) {
        this.dataRegistoDenuncia = dataRegistoDenuncia;
    }

    public String getNomeCidadaoDenuncia() {
        return nomeCidadaoDenuncia;
    }

    public void setNomeCidadaoDenuncia(String nomeCidadaoDenuncia) {
        this.nomeCidadaoDenuncia = nomeCidadaoDenuncia;
    }

    public String getEmailCidadaoDenuncia() {
        return emailCidadaoDenuncia;
    }

    public void setEmailCidadaoDenuncia(String emailCidadaoDenuncia) {
        this.emailCidadaoDenuncia = emailCidadaoDenuncia;
    }

    public String getTelefoneCidadaoDenuncia() {
        return telefoneCidadaoDenuncia;
    }

    public void setTelefoneCidadaoDenuncia(String telefoneCidadaoDenuncia) {
        this.telefoneCidadaoDenuncia = telefoneCidadaoDenuncia;
    }

    public Date getDataNascimentoCidadaoDenuncia() {
        return dataNascimentoCidadaoDenuncia;
    }

    public void setDataNascimentoCidadaoDenuncia(Date dataNascimentoCidadaoDenuncia) {
        this.dataNascimentoCidadaoDenuncia = dataNascimentoCidadaoDenuncia;
    }

    public Date getDataOcorrenciaDenuncia() {
        return dataOcorrenciaDenuncia;
    }

    public void setDataOcorrenciaDenuncia(Date dataOcorrenciaDenuncia) {
        this.dataOcorrenciaDenuncia = dataOcorrenciaDenuncia;
    }

    @Override
    public String toString() {
        return "Denuncia{" + "codigoDenucia=" + codigoDenuncia + ", municipio=" + municipio + ", tipoDenuncia=" + tipoDenuncia + ", descricaoDenuncia=" + descricaoDenuncia + ", dataRegistoDenuncia=" + dataRegistoDenuncia + ", nomeCidadaoDenuncia=" + nomeCidadaoDenuncia + ", emailCidadaoDenuncia=" + emailCidadaoDenuncia + ", telefoneCidadaoDenuncia=" + telefoneCidadaoDenuncia + ", dataNascimentoCidadaoDenuncia=" + dataNascimentoCidadaoDenuncia + ", dataOcorrenciaDenuncia=" + dataOcorrenciaDenuncia + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.codigoDenuncia;
        hash = 53 * hash + Objects.hashCode(this.municipio);
        hash = 53 * hash + Objects.hashCode(this.tipoDenuncia);
        hash = 53 * hash + Objects.hashCode(this.descricaoDenuncia);
        hash = 53 * hash + Objects.hashCode(this.dataRegistoDenuncia);
        hash = 53 * hash + Objects.hashCode(this.nomeCidadaoDenuncia);
        hash = 53 * hash + Objects.hashCode(this.emailCidadaoDenuncia);
        hash = 53 * hash + Objects.hashCode(this.telefoneCidadaoDenuncia);
        hash = 53 * hash + Objects.hashCode(this.dataNascimentoCidadaoDenuncia);
        hash = 53 * hash + Objects.hashCode(this.dataOcorrenciaDenuncia);
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
        final Denuncia other = (Denuncia) obj;
        if (this.codigoDenuncia != other.codigoDenuncia) {
            return false;
        }
        if (!Objects.equals(this.descricaoDenuncia, other.descricaoDenuncia)) {
            return false;
        }
        if (!Objects.equals(this.nomeCidadaoDenuncia, other.nomeCidadaoDenuncia)) {
            return false;
        }
        if (!Objects.equals(this.emailCidadaoDenuncia, other.emailCidadaoDenuncia)) {
            return false;
        }
        if (!Objects.equals(this.telefoneCidadaoDenuncia, other.telefoneCidadaoDenuncia)) {
            return false;
        }
        if (!Objects.equals(this.municipio, other.municipio)) {
            return false;
        }
        if (!Objects.equals(this.tipoDenuncia, other.tipoDenuncia)) {
            return false;
        }
        if (!Objects.equals(this.dataRegistoDenuncia, other.dataRegistoDenuncia)) {
            return false;
        }
        if (!Objects.equals(this.dataNascimentoCidadaoDenuncia, other.dataNascimentoCidadaoDenuncia)) {
            return false;
        }
        if (!Objects.equals(this.dataOcorrenciaDenuncia, other.dataOcorrenciaDenuncia)) {
            return false;
        }
        return true;
    }
   
   
   
   
        

   

   
    
    
}
 