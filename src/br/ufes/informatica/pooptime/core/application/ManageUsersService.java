package br.ufes.informatica.pooptime.core.application;

import javax.ejb.Local;

import br.ufes.inf.nemo.jbutler.ejb.application.CrudService;
import br.ufes.informatica.pooptime.core.domain.User;

@Local
public interface ManageUsersService extends CrudService<User> {

}
