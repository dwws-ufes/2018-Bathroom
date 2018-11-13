package br.ufes.informatica.pooptime.core.application;

import java.util.List;

import javax.ejb.Local;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudService;
import br.ufes.informatica.pooptime.core.domain.Bathroom;
import br.ufes.informatica.pooptime.core.domain.Review;
import br.ufes.informatica.pooptime.core.domain.User;

@Local
public interface ManageReviewsService extends CrudService<Review> {

	List<Bathroom> listBathrooms();
	
	List<User> findUserByEmail(String email);
}