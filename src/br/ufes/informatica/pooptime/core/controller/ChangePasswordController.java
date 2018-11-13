package br.ufes.informatica.pooptime.core.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.inject.Named;

import br.ufes.inf.nemo.jbutler.ejb.controller.JSFController;
import br.ufes.informatica.pooptime.core.application.ChangePasswordService;
import br.ufes.informatica.pooptime.core.domain.User;
import br.ufes.informatica.pooptime.core.exceptions.OperationFailedException;

/**
 * Session-scoped managed bean that provides to web pages the login service, indication if the user is logged in and the
 * current date/time.
 * 
 * @author Vitor E. Silva Souza (vitorsouza@gmail.com)
 */
@Named
@SessionScoped
public class ChangePasswordController extends JSFController {
	
	/** Serialization id. */
	private static final long serialVersionUID = 1L;

	/** The logger. */
	private static final Logger logger = Logger.getLogger(ChangePasswordController.class.getCanonicalName());

	/** The "Change Password" service. */
	@EJB
	private ChangePasswordService changePasswordService;

	/** TODO: document this field. */
	private User user;

	/** TODO: document this field. */
	private String password;

	/** TODO: document this field. */
	private String repeatPassword;

	/** TODO: document this field. */
	private String email;
	/** Getter for email. */
	
	public String getEmail() {
		return email;
	}

	/** Setter for email. */
	public void setEmail(String email) {
		this.email = email;
	}

	/** Getter for password. */
	public String getPassword() {
		return password;
	}

	/** Setter for password. */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/** Getter for password. */
	public String getRepeatPassword() {
		return repeatPassword;
	}

	/** Setter for password. */
	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}
	
	/** Getter for User. */
	public User getUser() {
		return user;
	}
	
	/**
	 * Checks if both password fields have the same value.
	 * 
	 * This method is intended to be used with AJAX.
	 */
	public void ajaxCheckPasswords() {
		checkPasswords();
	}

	/**
	 * Checks if the contents of the password fields match.
	 * 
	 * @return <code>true</code> if the passwords match, <code>false</code> otherwise.
	 */
	private boolean checkPasswords() {
		if (((repeatPassword != null) && (!repeatPassword.equals(password))) || ((repeatPassword == null) && (password != null))) {
			logger.log(Level.INFO, "Password and repeated password are not the same");
			addGlobalI18nMessage("msgsCore", FacesMessage.SEVERITY_WARN, "changePassword.error.passwordsDontMatch.summary", "changePassword.error.passwordsDontMatch.detail");
			return false;
		}
		return true;
	}

	/**
	 * TODO: document this method.
	 * 
	 * @return
	 */
	public String setNewPassword() {
		logger.log(Level.FINEST, "Setting new password for academic {0} (password code {1})", new Object[] { user, email });

		// Checks if the passwords match.
		if (!checkPasswords()) return null;

		// Changes the password.
		try {
			changePasswordService.setNewPassword(email, password);
		}
		catch (OperationFailedException e) {
			logger.log(Level.SEVERE, "Change password threw exception", e);
			addGlobalI18nMessage("msgsCore", FacesMessage.SEVERITY_FATAL, "changePassword.error.operationFailed.summary", "changePassword.error.operationFailed.detail");
			return null;
		}
		
		return "done.xhtml";
	}

	/**
	 * TODO: document this method.
	 * 
	 * @return
	 */
	public void resetPassword() {
		// Resets the password and displays a message.
		changePasswordService.resetPassword(email);
		addGlobalI18nMessage("msgsCore", FacesMessage.SEVERITY_INFO, "changePassword.message.resetRequested.summary", new Object[] {}, "changePassword.message.resetRequested.detail", new Object[] { email });
	}

	public String changePassword() {
		logger.log(Level.FINEST, "Changing password for academic {0} (password code {1})", new Object[] { user, email });

		// Checks if the passwords match.
		if (!checkPasswords()) return null;

		System.out.println("########### Change password of " + user + " to: " + password);
		return null;
	}
}
