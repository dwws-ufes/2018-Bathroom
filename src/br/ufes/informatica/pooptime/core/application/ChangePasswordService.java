package br.ufes.informatica.pooptime.core.application;

import java.io.Serializable;

import javax.ejb.Local;

import br.ufes.informatica.pooptime.core.exceptions.OperationFailedException;

/**
 * Local EJB interface for the session information component. This bean is responsible for storing information on each
 * different user of the system, such as the User object that represents the logged in user. It should also provide
 * an authentication method for the controller, identifying users of the system.
 * 
 * @author Vitor E. Silva Souza (vitorsouza@gmail.com)
 */
@Local
public interface ChangePasswordService extends Serializable {

	/**
	 * TODO: document this method.
	 * 
	 * @param passwordCode
	 * @param password
	 * @throws InvalidPasswordCodeException
	 * @throws OperationFailedException
	 */
	void setNewPassword(String email, String password) throws OperationFailedException;

	/**
	 * TODO: document this method.
	 * 
	 * @param email
	 */
	void resetPassword(String email);
}