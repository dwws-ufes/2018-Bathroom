package br.ufes.informatica.pooptime.core.converter;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

import br.ufes.informatica.pooptime.core.domain.Bathroom;
import br.ufes.informatica.pooptime.core.persistence.BathroomDAO;

@FacesConverter("bathroomConverter")
public class BathroomConverter implements Converter {

    @Named(value="bathroomConverterBean")
    @RequestScoped
    public static class Bean {
        @Inject
        private BathroomDAO bathroomDAO;

        public BathroomDAO getBathroomDAO() {
            return bathroomDAO;
        }
    }

    private BathroomDAO getBathroomDAO(FacesContext context) {
        Application app = context.getApplication();
        Bean bean = app.evaluateExpressionGet(context, "#{" + "bathroomConverterBean" + "}", Bean.class);
        BathroomDAO bathroomDAO = bean.getBathroomDAO();
        return bathroomDAO;
    }

    @Override
    public Bathroom getAsObject(FacesContext context, UIComponent component, String name) {
        BathroomDAO bathroomDAO = getBathroomDAO(context);
        return (name == null || name.isEmpty()) ? null : bathroomDAO.retrieveByName(name);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object name) {
    	if (name == null) {
    		return null;
    	} else {
    		Bathroom bathroom = (Bathroom) name;
    		return bathroom.getName();
    	}
    }

}