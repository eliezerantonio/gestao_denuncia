/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import dao.DenunciaDAO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.Denuncia;

/**
 *
 * @author eliezer
 */
@FacesConverter(value = "denunciaConverter", forClass = Denuncia.class)
public class DenunciaConverter implements Converter {

    DenunciaDAO denunciaDAO = new DenunciaDAO();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Integer id = Integer.parseInt(value);
        try {
            return denunciaDAO.findById(id);
        } catch (Exception ex) {
            System.err.println("Erro na conversão: D " + ex.getMessage());
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
      
      if (value != null) {
            Denuncia denuncia = (Denuncia) value;
            return String.valueOf(denuncia.getCodigoDenuncia()
            );
        }
        return null;
    }
}
