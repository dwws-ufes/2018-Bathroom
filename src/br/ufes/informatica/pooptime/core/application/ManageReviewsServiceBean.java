package br.ufes.informatica.pooptime.core.application;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudServiceBean;
import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseDAO;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.MultiplePersistentObjectsFoundException;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.PersistentObjectNotFoundException;
import br.ufes.informatica.pooptime.core.domain.Bathroom;
import br.ufes.informatica.pooptime.core.domain.Review;
import br.ufes.informatica.pooptime.core.domain.User;
import br.ufes.informatica.pooptime.core.persistence.BathroomDAO;
import br.ufes.informatica.pooptime.core.persistence.ReviewDAO;
import br.ufes.informatica.pooptime.core.persistence.UserDAO;

@Stateless @PermitAll
public class ManageReviewsServiceBean extends CrudServiceBean<Review> implements ManageReviewsService {
		private static final long serialVersionUID = 1L;
		
		@EJB
		private ReviewDAO ReviewDAO;
		
		@EJB
		private BathroomDAO bathroomDAO;
		
		@EJB
		private UserDAO userDAO;
		
		@Override
		public BaseDAO<Review> getDAO() {
				return ReviewDAO;
		}
		
	    @Override
		public List<Bathroom> listBathrooms() {
		    return bathroomDAO.retrieveAll();
		}
	    
	    @Override
	    public List<User> findUserByEmail(String email) {
	        return userDAO.retrieveByEmailToList(email);
	    }
		    
		 
		
}
