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
   private int codigoTipoDenuncia;
   private String descricaoDenuncia;

    public TipoDenuncia() {
    }

    public TipoDenuncia(int codigoTipoDenuncia) {
        this.codigoTipoDenuncia = codigoTipoDenuncia;
    }

    public TipoDenuncia(String descricaoDenuncia) {
        this.descricaoDenuncia = descricaoDenuncia;
    }

    public TipoDenuncia(int codigoTipoDenuncia, String descricaoDenuncia) {
        this.codigoTipoDenuncia = codigoTipoDenuncia;
        this.descricaoDenuncia = descricaoDenuncia;
    }

    public int getCodigoTipoDenuncia() {
        return codigoTipoDenuncia;
    }

    public void setCodigoTipoDenuncia(int codigoTipoDenuncia) {
        this.codigoTipoDenuncia = codigoTipoDenuncia;
    }

    public String getDescricaoDenuncia() {
        return descricaoDenuncia;
    }

    public void setDescricaoDenuncia(String descricaoDenuncia) {
        this.descricaoDenuncia = descricaoDenuncia;
    }
   
   

}
