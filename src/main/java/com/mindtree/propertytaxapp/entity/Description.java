package com.mindtree.propertytaxapp.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 * @author M1056078
 *
 */
@Entity
public class Description implements Comparable<Description>{

	
	@Id
	private int descriptionId;
	 

	private String descriptionType;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "propertyDescription",fetch = FetchType.LAZY)
	private List<Property> descriptionProperties;

	public int getDescriptionId() {
		return descriptionId;
	}

	public void setDescriptionId(int descriptionId) {
		this.descriptionId = descriptionId;
	}

	public List<Property> getDescriptionProperties() {
		return descriptionProperties;
	}

	public void setDescriptionProperties(List<Property> descriptionProperties) {
		this.descriptionProperties = descriptionProperties;
	}

	public String getDescriptionType() {
		return descriptionType;
	}

	public void setDescriptionType(String descriptionType) {
		this.descriptionType = descriptionType;
	}

	
	
	
	public Description() {
		super();
		
	}

	public Description(int descriptionId, String descriptionType, List<Property> descriptionProperties) {
		super();
		this.descriptionId = descriptionId;
		this.descriptionType = descriptionType;
		this.descriptionProperties = descriptionProperties;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descriptionId, descriptionProperties, descriptionType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Description other = (Description) obj;
		return descriptionId == other.descriptionId
				&& Objects.equals(descriptionProperties, other.descriptionProperties)
				&& Objects.equals(descriptionType, other.descriptionType);
	}

	@Override
	public int compareTo(Description o) {
		
		return this.descriptionId-o.descriptionId;
	}
	
	
	
}
