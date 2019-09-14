/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import dao.CidadaoDAO;
import dao.DenunciaDAO;
import dao.FuncionarioDAO;
import dao.MunicipioDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Cidadao;
import modelo.Denuncia;
import modelo.Funcionario;
import modelo.Municipio;
import modelo.Provincia;
import modelo.TipoDenuncia;

/**
 *
 * @author eliezer
 */
public class TesteCidadao {

    public static void main(String... args) {
        /*    Date hoje = new Date();
        System.out.println(hoje);
        Municipio municipio = new Municipio();
        municipio.setCodigoMunicipio(1);
        CidadaoDAO cidadaoDAO = new CidadaoDAO();
        Municipio municipio1 = new Municipio();
        Cidadao cidadao = new Cidadao();
        cidadao.setNomeCidadao("Eliezer");
        cidadao.setSobrenomeCidadao("jdjsd");
        cidadao.setTelefoneCidadao("5555");
        cidadao.setEmailCidadao("skjdjksd");
        cidadao.setDataNascimentoCidadao(hoje);
        cidadao.setUsuarioCidadao("sdsd");
        cidadao.setSenhaCidadao("jhjh");
        cidadao.setMunicipio(municipio);
        cidadaoDAO.save(cidadao);*/
        Municipio municipio = new Municipio(1);
        
        ArrayList<Municipio> lista = new ArrayList();
        MunicipioDAO municipioDAO = new MunicipioDAO();
        TipoDenuncia tipoDenuncia = new TipoDenuncia(1);
        Denuncia denuncia = new Denuncia(municipio,tipoDenuncia,"eliezer","eliezer@gmail.com","jsnasa","sasas");
        DenunciaDAO denunciaDAO = new DenunciaDAO();
        denunciaDAO.save(denuncia);
        
        
        
        
        
        
        
        
        
        

       

    }
}
