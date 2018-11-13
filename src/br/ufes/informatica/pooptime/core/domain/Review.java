package br.ufes.informatica.pooptime.core.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObjectSupport;

@Entity
public class Review extends PersistentObjectSupport implements Comparable<Review> {
	private static final long serialVersionUID = 1L;
	
	@NotNull
	@ManyToOne
	private User user;
	
	@NotNull
	@ManyToOne
	private Bathroom bathroom;

	@Size(max = 20)
	private String userName;
	
	@NotNull
	private Integer rating;
	
	private String comment;
	
	/** The timestamp of the moment this Review was created. */
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Bathroom getBathroom() {
		return bathroom;
	}
	
	public void setBathroom(Bathroom bathroom) {
		this.bathroom = bathroom;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	/** Getter for creationDate. */
	public Date getCreationDate() {
		return creationDate;
	}

	/** Setter for creationDate. */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public int compareTo(Review o) {
		return (int) (rating - o.rating);
	}
}