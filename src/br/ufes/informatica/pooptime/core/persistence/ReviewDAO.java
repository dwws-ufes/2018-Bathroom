package br.ufes.informatica.pooptime.core.persistence;

import java.util.List;

import javax.ejb.Local;

import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseDAO;
import br.ufes.informatica.pooptime.core.domain.Review;

@Local
public interface ReviewDAO extends BaseDAO<Review>{

	List<Review> retrieveByBathroomId(long id);

}
