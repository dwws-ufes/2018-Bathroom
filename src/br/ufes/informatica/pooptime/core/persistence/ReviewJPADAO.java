package br.ufes.informatica.pooptime.core.persistence;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseJPADAO;
import br.ufes.informatica.pooptime.core.domain.Bathroom;
import br.ufes.informatica.pooptime.core.domain.Bathroom_;
import br.ufes.informatica.pooptime.core.domain.Review;
import br.ufes.informatica.pooptime.core.domain.Review_;

@Stateless
public class ReviewJPADAO extends BaseJPADAO<Review> implements ReviewDAO {
		private static final long serialVersionUID = 1L;
		
		private static final Logger logger = Logger.getLogger(ReviewJPADAO.class.getCanonicalName());
		
		@PersistenceContext
		private EntityManager entityManager;
		
		@Override
		protected EntityManager getEntityManager() {
				return entityManager;
		}
		
		public List<Review> retrieveByBathroomId(long id) {
			logger.log(Level.FINE, "Retrieving the Reviews whose bathroom_id is \"{0}\"...", id);
			
			// Constructs the query over the User class.
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<Review> cq = cb.createQuery(Review.class);
			Root<Review> root = cq.from(Review.class);

			// Filters the query with the email.
			cq.where(cb.equal(root.get(Review_.bathroom_id), id));
			logger.log(Level.INFO, "Retrieve Reviews by the bathroom_id \"{0}\" returned \"{1}\"", new Object[] { id});
			return entityManager.createQuery(cq).getResultList();
		}

}