/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eliezer
 */
public class Cidadao implements Serializable {

    private Integer codigoCidadao;
    private String nomeCidadao;
    private String sobrenomeCidadao;
    private String telefoneCidadao;
    private String emailCidadao;
    private Date dataNascimentoCidadao;
    private String usuarioCidadao;
    private String senhaCidadao;
    private Date dataCadastro;
    private Municipio municipio;

    public Cidadao() {
    }

    public Cidadao(String nomeCidadao, String sobrenomeCidadao, String telefoneCidadao, String emailCidadao, Date dataNascimentoCidadao, String usuarioCidadao, String senhaCidadao, Date dataCadastro, Municipio municipio) {
        this.nomeCidadao = nomeCidadao;
        this.sobrenomeCidadao = sobrenomeCidadao;
        this.telefoneCidadao = telefoneCidadao;
        this.emailCidadao = emailCidadao;
        this.dataNascimentoCidadao = dataNascimentoCidadao;
        this.usuarioCidadao = usuarioCidadao;
        this.senhaCidadao = senhaCidadao;
        this.dataCadastro = dataCadastro;
        this.municipio = municipio;
    }

    public Cidadao(Integer codigoCidadao, String nomeCidadao, String sobrenomeCidadao, String telefoneCidadao, String emailCidadao, Date dataNascimentoCidadao, String usuarioCidadao, String senhaCidadao, Date dataCadastro, Municipio municipio) {
        this.codigoCidadao = codigoCidadao;
        this.nomeCidadao = nomeCidadao;
        this.sobrenomeCidadao = sobrenomeCidadao;
        this.telefoneCidadao = telefoneCidadao;
        this.emailCidadao = emailCidadao;
        this.dataNascimentoCidadao = dataNascimentoCidadao;
        this.usuarioCidadao = usuarioCidadao;
        this.senhaCidadao = senhaCidadao;
        this.dataCadastro = dataCadastro;
        this.municipio = municipio;
    }

    public Cidadao(Integer codigoCidadao) {
        this.codigoCidadao = codigoCidadao;
    }

    

    public String getSobrenomeCidadao() {
        return sobrenomeCidadao;
    }

    public void setSobrenomeCidadao(String sobrenomeCidadao) {
        this.sobrenomeCidadao = sobrenomeCidadao;
    }

    public Integer getCodigoCidadao() {
        return codigoCidadao;
    }

    public void setCodigoCidadao(Integer codigoCidadao) {
        this.codigoCidadao = codigoCidadao;
    }

    public String getNomeCidadao() {
        return nomeCidadao;
    }

    public void setNomeCidadao(String nomeCidadao) {
        this.nomeCidadao = nomeCidadao;
    }

    public String getTelefoneCidadao() {
        return telefoneCidadao;
    }

    public void setTelefoneCidadao(String telefoneCidadao) {
        this.telefoneCidadao = telefoneCidadao;
    }

    public String getEmailCidadao() {
        return emailCidadao;
    }

    public void setEmailCidadao(String emailCidadao) {
        this.emailCidadao = emailCidadao;
    }

    public Date getDataNascimentoCidadao() {
        return dataNascimentoCidadao;
    }

    public void setDataNascimentoCidadao(Date dataNascimentoCidadao) {
        this.dataNascimentoCidadao = dataNascimentoCidadao;
    }

    public String getUsuarioCidadao() {
        return usuarioCidadao;
    }

    public void setUsuarioCidadao(String usuarioCidadao) {
        this.usuarioCidadao = usuarioCidadao;
    }

    public String getSenhaCidadao() {
        return senhaCidadao;
    }

    public void setSenhaCidadao(String senhaCidadao) {
        this.senhaCidadao = senhaCidadao;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        return "Cidadao{" + "codigoCidadao=" + codigoCidadao + ", nomeCidadao=" + nomeCidadao + ", telefoneCidadao=" + telefoneCidadao + ", emailCidadao=" + emailCidadao + ", dataNascimentoCidadao=" + dataNascimentoCidadao + ", usuarioCidadao=" + usuarioCidadao + ", senhaCidadao=" + senhaCidadao + '}';
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.codigoCidadao);
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
        final Cidadao other = (Cidadao) obj;
        if (!Objects.equals(this.codigoCidadao, other.codigoCidadao)) {
            return false;
        }
        return true;
    }

}
