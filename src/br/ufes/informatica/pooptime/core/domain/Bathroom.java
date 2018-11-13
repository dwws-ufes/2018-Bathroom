package br.ufes.informatica.pooptime.core.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.ufes.inf.nemo.jbutler.ejb.persistence.PersistentObjectSupport;

@Entity
public class Bathroom extends PersistentObjectSupport implements Comparable<Bathroom> {
	private static final long serialVersionUID = 1L;
	
	@Size(max = 100)
	private String name;
	
	private String description;
	
	private float latitude;
	
	private float longitude;
	
	private boolean isClean = false, isCozy = false, isLowProfile = false, isAcessible = false, hasPaper = false, isFree = false;
	
	@OneToMany(mappedBy = "bathroom", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Review> reviews;
	
	@NotNull
	private BigDecimal price;
		
	public boolean getIsClean() {
		return isClean;
	}
	public void setIsClean(boolean isClean) {
		this.isClean = isClean;
	}
	public boolean getIsFree() {
		return isFree;
	}
	public void setIsFree(boolean isFree) {
		this.isFree = isFree;
	}
	public boolean getIsCozy() {
		return isCozy;
	}
	public void setIsCozy(boolean isCozy) {
		this.isCozy = isCozy;
	}
	public boolean getIsLowProfile() {
		return isLowProfile;
	}
	public void setIsLowProfile(boolean isLowProfile) {
		this.isLowProfile = isLowProfile;
	}
	public boolean getIsAcessible() {
		return isAcessible;
	}
	public void setIsAcessible(boolean isAcessible) {
		this.isAcessible = isAcessible;
	}
	public boolean getHasPaper() {
		return hasPaper;
	}
	public void setHasPaper(boolean hasPaper) {
		this.hasPaper = hasPaper;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	
	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price= price;
	}

	@Override
	public int compareTo(Bathroom o) {
		return price.compareTo(o.price);
	}
}