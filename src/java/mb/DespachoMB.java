/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import dao.CidadaoDAO;
import dao.DenunciaDAO;
import dao.DespachoDAO;
import dao.EstadoDAO;
import dao.FuncionarioDAO;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Denuncia;
import modelo.Despacho;
import modelo.Estado;
import modelo.Funcionario;

/**
 *
 * @author eliezer
 */
@Named(value = "despachoMB")
@Dependent
public class DespachoMB implements Serializable {

    /**
     * Creates a new instance of DespachoMB
     */
    public DespachoMB() {
    }

    private Despacho despacho = new Despacho();
    private final DespachoDAO despachoDAO = new DespachoDAO();

    private List<Despacho> despachos = new ArrayList<>();
    private List<Denuncia> denuncias = new ArrayList<>();
    private List<Funcionario> funcionarios = new ArrayList<>();
    private List<Estado> estados = new ArrayList<>();

    public String guardar(ActionEvent evt) {

        try {

            despachoDAO.save(despacho);
            FacesContext facesContext = FacesContext.getCurrentInstance();
            FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvado com sucesso", "Guardar");
            facesContext.addMessage("dialogo_guardar", facesMessage);

        } catch (Exception e) {
            FacesContext facesContext2 = FacesContext.getCurrentInstance();
            FacesMessage facesMessage2 = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar" + e.getLocalizedMessage(), "Guardar");
            facesContext2.addMessage("dialogo_guardar", facesMessage2);

        }
        return "despacho_listar_1?faces-redirect=true";
    }

    public String delete() {

        despachoDAO.delete(despacho);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Eliminar\t", "\tDados Eliminados com sucesso!"));
        return "despacho_listar_1?faces-redirect=true";
    }

    public Despacho getDespacho() {
        return despacho;
    }

    public void setDespacho(Despacho despacho) {
        this.despacho = despacho;
    }

    public List<Despacho> getDespachos() {
        despachos = despachoDAO.findAll();
        return despachos;
    }

    DenunciaDAO denunciaDAO = new DenunciaDAO();

    public List<Denuncia> getDenuncias() {
        denuncias = denunciaDAO.findAll();
        return denuncias;
    }

    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    public List<Funcionario> getFuncionarios() {
        funcionarios = funcionarioDAO.findAll();
        return funcionarios;
    }

    EstadoDAO estadoDAO = new EstadoDAO();

    public List<Estado> getEstados() {
        estados = estadoDAO.findAll();
        return estados;
    }

    public String entrar() {
        
       
        
        
        
        
        return "/paginas/funcionario/funcionario_index?faces-redirect=true";
    }
  

}