package br.ufes.informatica.pooptime.core.controller;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudService;
import br.ufes.inf.nemo.jbutler.ejb.application.filters.LikeFilter;
import br.ufes.inf.nemo.jbutler.ejb.controller.CrudController;
import br.ufes.informatica.pooptime.core.application.ManageUsersService;
import br.ufes.informatica.pooptime.core.domain.User;

@Named
@SessionScoped
public class ManageUsersController extends CrudController<User> {

	@EJB 
	private ManageUsersService manageUsersService;

	@Override
	protected CrudService<User> getCrudService() {
		// TODO Auto-generated method stub
		return manageUsersService;
	}
	
	@Override
	protected User createNewEntity() {
		return new User();
	}

	@Override
	protected void initFilters() {
		addFilter(new LikeFilter("manageUsers.filter.byName", "name", getI18nMessage("msgsCore", "manageUsers.text.filter.byName")));
		
	}
	
	
}
