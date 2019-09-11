/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import dao.DespachoDAO;
import modelo.Denuncia;
import modelo.Despacho;
import modelo.Estado;
import modelo.Funcionario;

/**
 *
 * @author eliezer
 */
public class TesteDespacho {
    
    
    public  static void main(String...args) {
        Funcionario funcionario = new Funcionario(1);
        Estado estado = new Estado(3);
        Denuncia denuncia = new Denuncia(1);
        Despacho despacho = new Despacho(funcionario,denuncia,estado);
        DespachoDAO despachoDAO = new DespachoDAO();
        
        despachoDAO.save(despacho);
        
        
        
    }
    
    
}
