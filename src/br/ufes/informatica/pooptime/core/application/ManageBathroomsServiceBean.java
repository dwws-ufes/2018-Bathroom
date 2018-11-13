package br.ufes.informatica.pooptime.core.application;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudServiceBean;
import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseDAO;
import br.ufes.informatica.pooptime.core.domain.Bathroom;
import br.ufes.informatica.pooptime.core.domain.Review;
import br.ufes.informatica.pooptime.core.persistence.BathroomDAO;
import br.ufes.informatica.pooptime.core.persistence.ReviewDAO;

@Stateless @PermitAll
public class ManageBathroomsServiceBean extends CrudServiceBean<Bathroom> implements ManageBathroomsService {
		private static final long serialVersionUID = 1L;
		
		@EJB
		private BathroomDAO bathroomDAO;
		
		@EJB
		private ReviewDAO reviewDAO;
		
		
		@Override
		public BaseDAO<Bathroom> getDAO() {
				return bathroomDAO;
		}

		@Override
		public List<Review> listReviews(long id) {
		    return reviewDAO.retrieveByBathroomId(id);
		}
}
