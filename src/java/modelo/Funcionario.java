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
public class Funcionario {
   private int codigoFuncionario;
   private byte fotoDenucia;
   private String nomeFuncionario;
   private String sobrenomeFuncionario;
   private String telefoneFuncionario;
   private String emailFuncionario;
   private String usuarioFuncionario;
   private String senhaFuncionario;
   private String sexo;
   private TipoFuncionario tipoFuncionario;
   

    public Funcionario() {
    }

    public Funcionario(int codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public Funcionario(String usuarioFuncionario, String senhaFuncionario) {
        this.usuarioFuncionario = usuarioFuncionario;
        this.senhaFuncionario = senhaFuncionario;
    }
    

    public Funcionario(String nomeFuncionario, String sobrenomeFuncionario, String telefoneFuncionario, String emailFuncionario, String senhaFuncionario, String sexo, TipoFuncionario tipoFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
        this.sobrenomeFuncionario = sobrenomeFuncionario;
        this.telefoneFuncionario = telefoneFuncionario;
        this.emailFuncionario = emailFuncionario;
        this.senhaFuncionario = senhaFuncionario;
        this.sexo = sexo;
        this.tipoFuncionario = tipoFuncionario;
    }

    public Funcionario(byte fotoDenucia, String nomeFuncionario, String sobrenomeFuncionario, String telefoneFuncionario, String emailFuncionario, String senhaFuncionario, String sexo, TipoFuncionario tipoFuncionario) {
        this.fotoDenucia = fotoDenucia;
        this.nomeFuncionario = nomeFuncionario;
        this.sobrenomeFuncionario = sobrenomeFuncionario;
        this.telefoneFuncionario = telefoneFuncionario;
        this.emailFuncionario = emailFuncionario;
        this.senhaFuncionario = senhaFuncionario;
        this.sexo = sexo;
        this.tipoFuncionario = tipoFuncionario;
    }
    

    public Funcionario(int codigoFuncionario, byte fotoDenucia, String nomeFuncionario, String sobrenomeFuncionario, String telefoneFuncionario, String emailFuncionario, String senhaFuncionario, String sexo, TipoFuncionario tipoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
        this.fotoDenucia = fotoDenucia;
        this.nomeFuncionario = nomeFuncionario;
        this.sobrenomeFuncionario = sobrenomeFuncionario;
        this.telefoneFuncionario = telefoneFuncionario;
        this.emailFuncionario = emailFuncionario;
        this.senhaFuncionario = senhaFuncionario;
        this.sexo = sexo;
        this.tipoFuncionario = tipoFuncionario;
    }

   

    public int getCodigoFuncionario() {
        return codigoFuncionario;
    }

    public void setCodigoFuncionario(int codigoFuncionario) {
        this.codigoFuncionario = codigoFuncionario;
    }

    public byte getFotoDenucia() {
        return fotoDenucia;
    }

    public void setFotoDenucia(byte fotoDenucia) {
        this.fotoDenucia = fotoDenucia;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getSobrenomeFuncionario() {
        return sobrenomeFuncionario;
    }

    public void setSobrenomeFuncionario(String sobrenomeFuncionario) {
        this.sobrenomeFuncionario = sobrenomeFuncionario;
    }

    public String getTelefoneFuncionario() {
        return telefoneFuncionario;
    }

    public void setTelefoneFuncionario(String telefoneFuncionario) {
        this.telefoneFuncionario = telefoneFuncionario;
    }

    public String getEmailFuncionario() {
        return emailFuncionario;
    }

    public void setEmailFuncionario(String emailFuncionario) {
        this.emailFuncionario = emailFuncionario;
    }

    public String getSenhaFuncionario() {
        return senhaFuncionario;
    }

    public void setSenhaFuncionario(String senhaFuncionario) {
        this.senhaFuncionario = senhaFuncionario;
    }

    public TipoFuncionario getTipoFuncionario() {
        return tipoFuncionario;
    }

    public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
        this.tipoFuncionario = tipoFuncionario;
    }

    public String getUsuarioFuncionario() {
        return usuarioFuncionario;
    }

    public void setUsuarioFuncionario(String usuarioFuncionario) {
        this.usuarioFuncionario = usuarioFuncionario;
    }
    
    

    @Override
    public String toString() {
        return "Funcionario{" + "codigoFuncionario=" + codigoFuncionario + ", "
                + "fotoDenucia=" + fotoDenucia + ", nomeFuncionario=" + nomeFuncionario + ", sobrenomeFuncionario=" +
                sobrenomeFuncionario + ", telefoneFuncionario=" + telefoneFuncionario + ", emailFuncionario=" + emailFuncionario + ","
                + " senhaFuncionario=" + senhaFuncionario + ", tipoFuncionario=" + tipoFuncionario + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.codigoFuncionario;
        hash = 97 * hash + this.fotoDenucia;
        hash = 97 * hash + Objects.hashCode(this.nomeFuncionario);
        hash = 97 * hash + Objects.hashCode(this.sobrenomeFuncionario);
        hash = 97 * hash + Objects.hashCode(this.telefoneFuncionario);
        hash = 97 * hash + Objects.hashCode(this.emailFuncionario);
        hash = 97 * hash + Objects.hashCode(this.senhaFuncionario);
        hash = 97 * hash + Objects.hashCode(this.tipoFuncionario);
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
        final Funcionario other = (Funcionario) obj;
        if (this.codigoFuncionario != other.codigoFuncionario) {
            return false;
        }
        if (this.fotoDenucia != other.fotoDenucia) {
            return false;
        }
        if (!Objects.equals(this.nomeFuncionario, other.nomeFuncionario)) {
            return false;
        }
        if (!Objects.equals(this.sobrenomeFuncionario, other.sobrenomeFuncionario)) {
            return false;
        }
        if (!Objects.equals(this.telefoneFuncionario, other.telefoneFuncionario)) {
            return false;
        }
        if (!Objects.equals(this.emailFuncionario, other.emailFuncionario)) {
            return false;
        }
        if (!Objects.equals(this.senhaFuncionario, other.senhaFuncionario)) {
            return false;
        }
        if (!Objects.equals(this.tipoFuncionario, other.tipoFuncionario)) {
            return false;
        }
        return true;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

   
    
    
}
