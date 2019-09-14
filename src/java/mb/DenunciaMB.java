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
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import modelo.Denuncia;
import modelo.Estado;
import modelo.Municipio;
import modelo.TipoDenuncia;

/**
 *
 * @author eliezer
 */
@Named(value = "denunciaMB")
@Dependent
public class DenunciaMB {

    private Denuncia denuncia = new Denuncia();
    DenunciaDAO denunciaDAO = new DenunciaDAO();
    private List<Denuncia> denuncias = new ArrayList<>();
    private List<Estado> estados = new ArrayList<>();
    EstadoDAO estadoDAO = new EstadoDAO();
    private List<Municipio> municipios = new ArrayList<>();
    MunicipioDAO municipioDAO = new MunicipioDAO();

    TipoDenuncia tipoDenuncia = new TipoDenuncia();
    private List<TipoDenuncia> tipoDenuncias = new ArrayList<>();
    TipoDenunciaDAO tipoDenunciaDAO = new TipoDenunciaDAO();

    public DenunciaMB() {
    }

    public String save(ActionEvent evt) {
       denunciaDAO.save(denuncia);

       return "funcionario_index?faces-redirect=true";
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

    public Denuncia getDenuncia() {
        return denuncia;
    }

    public void setDenuncia(Denuncia denuncia) {
        this.denuncia = denuncia;
    }

    public List<TipoDenuncia> getTipoDenuncias() {
        tipoDenuncias = tipoDenunciaDAO.findAll();
        return tipoDenuncias;
    }

    public void setTipoDenuncias(List<TipoDenuncia> tipoDenuncias) {
        this.tipoDenuncias = tipoDenuncias;
    }

}
