/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

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
import modelo.Provincia;

/**
 *
 * @author eliezer
 */
@Named(value = "provinciaMB")
@SessionScoped
public class ProvinciaMB implements Serializable {

    public ProvinciaMB() {
    }

    Provincia provincia = new Provincia();
    ProvinciaDAO provinciaDAO = new ProvinciaDAO();
    List<Provincia> provincias = new ArrayList<>();

   
  
   

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvicia(Provincia provincia) {
        this.provincia = provincia;
    }

     public List<Provincia> getProvincias() {
        provincias = provinciaDAO.findAll();
        return provincias;
    }

}
