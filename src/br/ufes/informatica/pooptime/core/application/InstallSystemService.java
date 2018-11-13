package br.ufes.informatica.pooptime.core.application;

import java.io.Serializable;

import javax.ejb.Local;

import br.ufes.informatica.pooptime.core.domain.MarvinConfiguration;
import br.ufes.informatica.pooptime.core.domain.User;
import br.ufes.informatica.pooptime.core.exceptions.SystemInstallFailedException;

/**
 * TODO: document this type.
 *
 * @author Vítor E. Silva Souza (vitorsouza@gmail.com)
 * @version 1.0
 */
@Local
public interface InstallSystemService extends Serializable {
	/**
	 * TODO: document this method.
	 * 
	 * @param config
	 * @param admin
	 * @throws SystemInstallFailedException
	 */
	void installSystem(MarvinConfiguration config, User admin) throws SystemInstallFailedException;
}
