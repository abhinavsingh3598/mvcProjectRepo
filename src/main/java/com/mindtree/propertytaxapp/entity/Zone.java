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
public class Zone implements Comparable<Zone>{

@Id
private int zoneId;

private String zoneName;


@OneToMany(cascade = CascadeType.ALL,mappedBy = "propertyZone" ,fetch = FetchType.LAZY )
private List<Property> zoneProperties;

public int getZoneId() {
	return zoneId;
}

public void setZoneId(int zoneId) {
	this.zoneId = zoneId;
}

public List<Property> getZoneProperties() {
	return zoneProperties;
}

public void setZoneProperties(List<Property> zoneProperties) {
	this.zoneProperties = zoneProperties;
}

public String getZoneName() {
	return zoneName;
}

public void setZoneName(String zoneName) {
	this.zoneName = zoneName;
}



public Zone() {
	super();
	
}

public Zone(int zoneId, String zoneName, List<Property> zoneProperties) {
	super();
	this.zoneId = zoneId;
	this.zoneName = zoneName;
	this.zoneProperties = zoneProperties;
}

@Override
public int hashCode() {
	return Objects.hash(zoneId, zoneName, zoneProperties);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Zone other = (Zone) obj;
	return zoneId == other.zoneId && Objects.equals(zoneName, other.zoneName)
			&& Objects.equals(zoneProperties, other.zoneProperties);
}

@Override
public int compareTo(Zone o) {
	
	return this.zoneId-o.zoneId;
}


}
