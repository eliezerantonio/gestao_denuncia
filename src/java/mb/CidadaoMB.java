/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import dao.CidadaoDAO;
import dao.MunicipioDAO;
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

/**
 *
 * @author eliezer
 */
@Named(value = "cidadaoMB")
@SessionScoped
public class CidadaoMB implements Serializable {

    public CidadaoMB() {
    }

    Cidadao cidadao = new Cidadao();
    CidadaoDAO cidadaoDAO = new CidadaoDAO();

    List<Cidadao> cidadaos = new ArrayList<>();

    //lista para carregar a comboBox de municipio
    List<Municipio> municipios = new ArrayList();

    public String guardar(ActionEvent evt) {

        try {

            cidadaoDAO.save(cidadao);
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvado com sucesso", "Guardar");
            facesContext.addMessage("dialogo_guardar", facesMessage);

        } catch (Exception e) {
            FacesContext facesContext2 = FacesContext.getCurrentInstance();
            FacesMessage facesMessage2 = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar" + e.getLocalizedMessage(), "Guardar");
            facesContext2.addMessage("dialogo_guardar", facesMessage2);

        }
        return "cidadao_listar?faces-redirect=true";
    }

    public String delete() {

        cidadaoDAO.delete(cidadao);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminar\t", "\tDados Eliminados com sucesso!"));
        return "cidadao_listar_sem_template?faces-redirect=true";
    }

    public void edit(ActionEvent evt) {

        try {
            if (cidadaoDAO.update(cidadao)) {

                FacesContext facesContext = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Editado com sucesso", "Editar");
                facesContext.addMessage("dialogo_editar", facesMessage);

            } else {
                FacesContext facesContext2 = FacesContext.getCurrentInstance();
                FacesMessage facesMessage2 = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao editar", "Editar");
                facesContext2.addMessage("dialogo_editar", facesMessage2);
            }

        } catch (Exception e) {

        }

    }

    public Cidadao getCidadao() {
        return cidadao;
    }

    public void setCidadao(Cidadao cidadao) {
        this.cidadao = cidadao;
    }

    public List<Cidadao> getCidadaos() {
        cidadaos = cidadaoDAO.findAll();
        return cidadaos;
    }
    MunicipioDAO municipioDAO = new MunicipioDAO();

    public List<Municipio> getMunicipios() {
        municipios = municipioDAO.findAll();
        return municipios;
    }

}
