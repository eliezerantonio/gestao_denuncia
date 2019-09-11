/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import dao.EstadoDAO;
import dao.MunicipioDAO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.Estado;
import modelo.Municipio;

/**
 *
 * @author eliezer
 */
@FacesConverter(value = "estadoConverter", forClass = Estado.class)
public class EstadoConverter implements Converter {

    EstadoDAO estadoDAO = new EstadoDAO();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Integer id = Integer.parseInt(value);
        try {
            return estadoDAO.findById(id);
        } catch (Exception ex) {
            System.err.println("Erro na conversão: E" + ex.getMessage());
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
      
      if (value != null) {
            Estado estado = (Estado) value;
            return String.valueOf(estado.getCodigoEstado());
        }
        return null;
    }
}
