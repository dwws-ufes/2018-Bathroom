package br.ufes.informatica.pooptime.core.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.ufes.informatica.pooptime.people.domain.Person;

@Entity
public class User extends Person {
	/** Serialization id. */
	private static final long serialVersionUID = 1L;

	/** Short name to use when there isn't much space. */
	@Basic
	@NotNull
	@Size(max = 15)
	private String shortName;

	/** Electronic address, which also serves as username for identification. */
	@Basic
	@Size(max = 100)
	private String email;

	/** The password, which identifies the user. */
	@Basic
	@Size(max = 32)
	private String password;

	/** The timestamp of the moment this User was created. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	/** The last time the data about the user was updated. */
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date lastUpdateDate;

	/** The last time the user logged in the system. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLoginDate;

	/** Getter for shortName. */
	public String getShortName() {
		return shortName;
	}

	/** Setter for shortName. */
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

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
	
	/** Getter for creationDate. */
	public Date getCreationDate() {
		return creationDate;
	}

	/** Setter for creationDate. */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/** Getter for lastUpdateDate. */
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	/** Setter for lastUpdateDate. */
	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	/** Getter for lastLoginDate. */
	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	/** Setter for lastLoginDate. */
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
}

