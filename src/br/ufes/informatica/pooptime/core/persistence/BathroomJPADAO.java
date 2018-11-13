package br.ufes.informatica.pooptime.core.persistence;

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

@Stateless
public class BathroomJPADAO extends BaseJPADAO<Bathroom> implements BathroomDAO {
		private static final long serialVersionUID = 1L;
		
		private static final Logger logger = Logger.getLogger(BathroomJPADAO.class.getCanonicalName());
		
		@PersistenceContext
		private EntityManager entityManager;
		
		@Override
		protected EntityManager getEntityManager() {
				return entityManager;
		}
		
		/** @see br.ufes.informatica.pooptime.core.persistence.UserDAO#retrieveByEmail(java.lang.String) */
		@Override
		public Bathroom retrieveByName(String name) {
			logger.log(Level.FINE, "Retrieving the User whose e-mail is \"{0}\"...", name);
			
			// Constructs the query over the User class.
			CriteriaBuilder cb = entityManager.getCriteriaBuilder();
			CriteriaQuery<Bathroom> cq = cb.createQuery(Bathroom.class);
			Root<Bathroom> root = cq.from(Bathroom.class);

			// Filters the query with the email.
			cq.where(cb.equal(root.get(Bathroom_.name), name));
			logger.log(Level.INFO, "Retrieve User by the email \"{0}\" returned \"{1}\"", new Object[] { name });
			return entityManager.createQuery(cq).getSingleResult();
		}

}