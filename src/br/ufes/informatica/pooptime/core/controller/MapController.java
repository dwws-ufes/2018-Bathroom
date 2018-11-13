package br.ufes.informatica.pooptime.core.controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import br.ufes.informatica.pooptime.core.application.ManageBathroomsService;
import br.ufes.informatica.pooptime.core.domain.Bathroom;

//@SessionScoped
@RequestScoped
@Named
public class MapController implements Serializable {
    
	private static final long serialVersionUID = 1L;

	private MapModel mapModel;
	
	@EJB
	private ManageBathroomsService manageBathrooms;
	
	private List<Bathroom> bathrooms;
	
	private Bathroom bathroom;
    
    private String bathroomName;
    
    private double lat;
      
    private double lng;
    
    private BigDecimal price;
  
    @PostConstruct
    public void init() {
        mapModel = new DefaultMapModel();
        bathrooms = manageBathrooms.getDAO().retrieveAll();
        
        for(Bathroom bath: bathrooms) {
        	LatLng coordinate = new LatLng(bath.getLatitude(), bath.getLongitude());
        	mapModel.addOverlay(new Marker(coordinate, bath.getName()));
        }
    }
      
    public MapModel getMapModel() {
        return mapModel;
    }
      
    public Bathroom getBathroom() {
		return bathroom;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setBathroom(Bathroom bathroom) {
		this.bathroom = bathroom;
	}

	public String getBathroomName() {
        return bathroomName;
    }
  
    public void setBathroomName(String bathroomName) {
        this.bathroomName = bathroomName;
    }
  
    public double getLat() {
        return lat;
    }
  
    public void setLat(double lat) {
        this.lat = lat;
    }
  
    public double getLng() {
        return lng;
    }
  
    public void setLng(double lng) {
        this.lng = lng;
    }
      
    public void addMarker() {
        Marker marker = new Marker(new LatLng(lat, lng), bathroomName);
        mapModel.addOverlay(marker);
        this.bathroom = new Bathroom();
        this.bathroom.setName(bathroomName);
        this.bathroom.setLatitude((float)lat);
        this.bathroom.setLongitude((float)lng);
        this.bathroom.setPrice(price);
        manageBathrooms.getDAO().save(bathroom);
          
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Added", "Lat:" + lat + ", Lng:" + lng));
    }
}
