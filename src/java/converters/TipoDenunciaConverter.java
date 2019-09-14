/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converters;

import dao.DenunciaDAO;
import dao.TipoDenunciaDAO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.TipoDenuncia;

/**
 *
 * @author eliezer
 */
@FacesConverter(value = "tipoDenunciaConverter", forClass = TipoDenuncia.class)
public class TipoDenunciaConverter implements Converter {

    TipoDenunciaDAO tipoDenunciaDAO = new TipoDenunciaDAO();

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Integer id = Integer.parseInt(value);
        try {
            return tipoDenunciaDAO.findById(id);
        } catch (Exception ex) {
            System.err.println("Erro na conversão: D " + ex.getMessage());
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            TipoDenuncia tipoDenuncia = (TipoDenuncia) value;
            return String.valueOf(tipoDenuncia.getCodigoTipoDenuncia()
            );
        }
        return null;
    }
}
