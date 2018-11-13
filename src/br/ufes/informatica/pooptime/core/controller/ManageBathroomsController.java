package br.ufes.informatica.pooptime.core.controller;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudService;
import br.ufes.inf.nemo.jbutler.ejb.controller.CrudController;
import br.ufes.informatica.pooptime.core.application.ManageBathroomsService;
import br.ufes.informatica.pooptime.core.domain.Bathroom;

@Named @SessionScoped
public class ManageBathroomsController extends CrudController<Bathroom> {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ManageBathroomsService manageBathroomsService;
	
	@Override
	protected CrudService<Bathroom> getCrudService() {
		return manageBathroomsService;
	}

	@Override
	protected void initFilters() { }
	
}