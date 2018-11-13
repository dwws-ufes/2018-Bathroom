package br.ufes.informatica.pooptime.core.application;

import java.util.List;

import javax.ejb.Local;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudService;
import br.ufes.informatica.pooptime.core.domain.Bathroom;
import br.ufes.informatica.pooptime.core.domain.Review;

@Local
public interface ManageBathroomsService extends CrudService<Bathroom> {

	List<Review> listReviews(long id);
}