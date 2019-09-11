/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import dao.FuncionarioDAO;
import java.awt.event.ActionEvent;
import java.io.Serializable;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.swing.JOptionPane;
import modelo.Funcionario;

/**
 *
 * @author eliezer
 */
@Named(value = "loginMb")
@SessionScoped
public class LoginMb implements Serializable {

    public LoginMb() {

    }
    private Funcionario funcionario = new Funcionario();
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    public String entrar(ActionEvent ev) {

        try {

            if (funcionarioDAO.logar(funcionario)) {
                FacesContext facesContext = FacesContext.getCurrentInstance();
                FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "Login efectuado com sucesso", "entrar");
                facesContext.addMessage("entrar", facesMessage);

                return "funcionario_index?faces-redirect=true";

            }

        } catch (Exception e) {
        }

        return "funcionario_login?faces-redirect=true";

    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

}
