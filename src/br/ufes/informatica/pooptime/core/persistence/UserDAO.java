package br.ufes.informatica.pooptime.core.persistence;

import java.util.List;

import br.ufes.inf.nemo.jbutler.ejb.persistence.BaseDAO;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.MultiplePersistentObjectsFoundException;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.PersistentObjectNotFoundException;
import br.ufes.informatica.pooptime.core.domain.User;

public interface UserDAO extends BaseDAO<User> {

	User retrieveByEmail(String email)
			throws PersistentObjectNotFoundException, MultiplePersistentObjectsFoundException;

	List<User> retrieveByEmailToList(String email);

}
