package br.ufes.informatica.pooptime.core.controller;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

import javax.inject.Named;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudService;
import br.ufes.inf.nemo.jbutler.ejb.controller.CrudController;
import br.ufes.informatica.pooptime.core.application.ManageReviewsService;
import br.ufes.informatica.pooptime.core.domain.Review;
import br.ufes.informatica.pooptime.core.domain.User;
import br.ufes.informatica.pooptime.core.domain.Bathroom;

@Named @SessionScoped
public class ManageReviewsController extends CrudController<Review> {
	private static final long serialVersionUID = 1L;

	@EJB
	private ManageReviewsService manageReviewsService;
	
	@Override
	protected CrudService<Review> getCrudService() {
		return manageReviewsService;
	}
	
	@Override
	protected void initFilters() { }
	
	public List<Bathroom> getBathrooms() {
        return manageReviewsService.listBathrooms();
	}
	
	public List<User> completeUserName(String email) {
		return manageReviewsService.findUserByEmail(email);
}
}