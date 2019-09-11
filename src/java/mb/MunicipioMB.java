/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import dao.MunicipioDAO;
import dao.ProvinciaDAO;
import java.awt.event.ActionEvent;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Cidadao;
import modelo.Municipio;
import modelo.Provincia;

/**
 *
 * @author eliezer
 */
@Named(value = "municipioMB")
@SessionScoped
public class MunicipioMB implements Serializable {

    public MunicipioMB() {
    }

    Provincia provincia = new Provincia();
    Municipio municipio = new Municipio();
    MunicipioDAO municipioDAO = new MunicipioDAO();
    List<Municipio> municipios = new ArrayList<>();

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public List<Municipio> getMunicipios() {
     municipios = municipioDAO.findAll();
        return municipios;
    }

}
