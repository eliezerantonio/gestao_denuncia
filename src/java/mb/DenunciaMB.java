/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import dao.DenunciaDAO;
import dao.EstadoDAO;
import dao.MunicipioDAO;
import dao.TipoDenunciaDAO;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import javax.inject.Named;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Denuncia;
import modelo.Estado;
import modelo.Municipio;
import modelo.TipoDenuncia;

/**
 *
 * @author eliezer
 */
@Named(value = "denunciaMB")
@SessionScoped
public class DenunciaMB implements Serializable {

    private Denuncia denuncia = new Denuncia();
    DenunciaDAO denunciaDAO = new DenunciaDAO();
    private List<Denuncia> denuncias = new ArrayList<>();

    private List<Estado> estados = new ArrayList<>();
    EstadoDAO estadoDAO = new EstadoDAO();

    private List<Municipio> municipios = new ArrayList<>();
    MunicipioDAO municipioDAO = new MunicipioDAO();

    private List<TipoDenuncia> tipoDenuncias = new ArrayList<>();
    TipoDenunciaDAO tipoDenunciaDAO = new TipoDenunciaDAO();

    public DenunciaMB() {
    }
    
    public void inicializar(){
    
    if(this.denuncia == null){
        limpar();
    }
}
    public void limpar(){
        denuncia = new Denuncia();
    }

    public void save(ActionEvent evt) {
        
         limpar();

        if (denunciaDAO.save(denuncia)) {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvado com sucesso, Receberá atendimento por e-mail quando a sua denuncia for atendida", "dialogo_guardar");
            facesContext.addMessage("dialogo_guardar", facesMessage);
            
            
        }
        else{
             FacesContext facesContext = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao Denunciar Verifique os campos", "dialogo_guardar");
                facesContext.addMessage("dialogo_guardar", facesMessage);
        }
    }
    

    public List<Denuncia> getDenuncias() {
        denuncias = denunciaDAO.findAll();
        return denuncias;

    }

    public List<Estado> getEstados() {
        estados = estadoDAO.findAll();
        return estados;
    }

    public List<Municipio> getMunicipios() {
        municipios = municipioDAO.findAll();
        return municipios;
    }

    public List<TipoDenuncia> getTipoDenuncias() {
        tipoDenuncias = tipoDenunciaDAO.findAll();
        return tipoDenuncias;
    }

    public Denuncia getDenuncia() {
        return denuncia;
    }

    public void setDenuncia(Denuncia denuncia) {
        this.denuncia = denuncia;
    }

}
