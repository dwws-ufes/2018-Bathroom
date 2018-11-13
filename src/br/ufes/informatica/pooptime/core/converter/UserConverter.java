package br.ufes.informatica.pooptime.core.converter;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.Application;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;

import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.MultiplePersistentObjectsFoundException;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.PersistentObjectNotFoundException;
import br.ufes.informatica.pooptime.core.domain.User;
import br.ufes.informatica.pooptime.core.persistence.UserDAO;

@FacesConverter("userConverter")
public class UserConverter implements Converter {

    @Named(value="userConverterBean")
    @RequestScoped
    public static class Bean {
        @Inject
        private UserDAO userDAO;

        public UserDAO getUserDAO() {
            return userDAO;
        }
    }

    private UserDAO getUserDAO(FacesContext context) {
        Application app = context.getApplication();
        Bean bean = app.evaluateExpressionGet(context, "#{" + "userConverterBean" + "}", Bean.class);
        UserDAO userDAO = bean.getUserDAO();
        return userDAO;
    }

    @Override
    public User getAsObject(FacesContext context, UIComponent component, String value) {
        UserDAO userDAO = getUserDAO(context);
        try {
			return (value == null || value.isEmpty()) ? null : userDAO.retrieveByEmail(value);
		} catch (PersistentObjectNotFoundException | MultiplePersistentObjectsFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
    	if (value == null) {
    		return null;
    	} else {
    		User user = (User) value;
    		return user.getEmail();
    	}
    }
}
