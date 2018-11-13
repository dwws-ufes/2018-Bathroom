package br.ufes.informatica.pooptime.core.application;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;

import br.ufes.inf.nemo.jbutler.TextUtils;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.MultiplePersistentObjectsFoundException;
import br.ufes.inf.nemo.jbutler.ejb.persistence.exceptions.PersistentObjectNotFoundException;
import br.ufes.informatica.pooptime.core.domain.User;
import br.ufes.informatica.pooptime.core.exceptions.OperationFailedException;
import br.ufes.informatica.pooptime.core.persistence.UserDAO;

/**
 * Stateful session bean implementing the session information component. See the implemented interface documentation for
 * details.
 * 
 * @author Vitor E. Silva Souza (vitorsouza@gmail.com)
 * @see br.org.feees.sigme.core.application.SessionInformation
 */
@SessionScoped
@Stateful
public class ChangePasswordServiceBean implements ChangePasswordService {
	
	/** TODO: document this field. */
	private static final long serialVersionUID = 1L;

	/** The logger. */
	private static final Logger logger = Logger.getLogger(ChangePasswordServiceBean.class.getCanonicalName());

	/** TODO: document this field. */
	@EJB
	private UserDAO userDAO;

	/** TODO: document this field. */
	@EJB
	private CoreInformation coreInformation;

	
	/**
	 * @see br.ufes.inf.nemo.marvin.core.application.ChangePasswordService#setNewPassword(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public void setNewPassword(String email, String password) throws OperationFailedException {
		try {
			// Retrieves the academic given her password code.
			logger.log(Level.INFO, "Setting a new password for user with email: {0}", new Object[] { email });
			User user = userDAO.retrieveByEmail(email);

			// Sets the new password
			user.setPassword(TextUtils.produceMd5Hash(password));

			// Saves the user.
			userDAO.save(user);
		}

		// In case the password code fails to retrieve a single academic, report it as invalid.
		catch (PersistentObjectNotFoundException | MultiplePersistentObjectsFoundException e) {
			logger.log(Level.WARNING, "Unable to retrieve an academic with email: " + email, e);
		}

		// In case the password cannot be encoded.
		catch (NoSuchAlgorithmException e) {
			// Logs and rethrows the exception for the controller to display the error to the user.
			logger.log(Level.SEVERE, "Could not find MD5 algorithm for password encription!", e);
			throw new OperationFailedException(e);
		}
	}

	/** @see br.ufes.inf.nemo.marvin.core.application.ChangePasswordService#resetPassword(java.lang.String) */
	@Override
	public void resetPassword(String email) {
		try {
			// Retrieves the academic that owns the email and sets a new password code.
			@SuppressWarnings("unused")
			User user = userDAO.retrieveByEmail(email);
		}
		catch (PersistentObjectNotFoundException | MultiplePersistentObjectsFoundException e) {
			logger.log(Level.WARNING, "No academic with the given e-mail: {0}. Staying silent, since this is a reset password feature.", new Object[] { email });
		}
	}

	}
