package com.mindtree.propertytaxapp.entity;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * @author M1056078
 *
 */
@Entity
@Table(name = "property")
public class Property implements Comparable<Property> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "p_id")
	private long propertyId;

	@NotNull

	@Column(name = "assessment_year")
	private int propertyYearOfAssessment;

	@NotNull

	@Column(name = "owner_name")
	private String propertyOwnerName;

	@NotNull
	@Column(unique = true, name = "owner_email")
	private String propertyOwnerEmailAddress;

	@NotNull
	@Column(name = "address")
	private String propertyAddress;

	@NotNull
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private Zone propertyZone;

	@NotNull
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Description propertyDescription;

	@NotNull
	@Column(name = "status")
	private String propertyStatus;

	@NotNull

	@Column(name = "const_year")
	private String propertyYearOfConstruction;

	@NotNull
	@Column(name = "area_per_sq_foot")
	private String propertyAreaInSquareFoot;

	@NotNull
	@Column(name = "total_tax")
	double propertyTotalPayableTaxAmount;

	public long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(long propertyId) {
		this.propertyId = propertyId;
	}

	public int getPropertyYearOfAssessment() {
		return propertyYearOfAssessment;
	}

	public void setPropertyYearOfAssessment(int propertyYearOfAssessment) {
		this.propertyYearOfAssessment = propertyYearOfAssessment;
	}

	public String getPropertyOwnerName() {
		return propertyOwnerName;
	}

	public void setPropertyOwnerName(String propertyOwnerName) {
		this.propertyOwnerName = propertyOwnerName;
	}

	public String getPropertyOwnerEmailAddress() {
		return propertyOwnerEmailAddress;
	}

	public void setPropertyOwnerEmailAddress(String propertyOwnerEmailAddress) {
		this.propertyOwnerEmailAddress = propertyOwnerEmailAddress;
	}

	public String getPropertyAddress() {
		return propertyAddress;
	}

	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	public Zone getPropertyZone() {
		return propertyZone;
	}

	public void setPropertyZone(Zone propertyZone) {
		this.propertyZone = propertyZone;
	}

	public Description getPropertyDescription() {
		return propertyDescription;
	}

	public void setPropertyDescription(Description propertyDescription) {
		this.propertyDescription = propertyDescription;
	}

	public String getPropertyStatus() {
		return propertyStatus;
	}

	public void setPropertyStatus(String propertyStatus) {
		this.propertyStatus = propertyStatus;
	}

	public String getPropertyYearOfConstruction() {
		return propertyYearOfConstruction;
	}

	public void setPropertyYearOfConstruction(String propertyYearOfConstruction) {
		this.propertyYearOfConstruction = propertyYearOfConstruction;
	}

	public String getPropertyAreaInSquareFoot() {
		return propertyAreaInSquareFoot;
	}

	public void setPropertyAreaInSquareFoot(String propertyAreaInSquareFoot) {
		this.propertyAreaInSquareFoot = propertyAreaInSquareFoot;
	}

	public double getPropertyTotalPayableTaxAmount() {
		return propertyTotalPayableTaxAmount;
	}

	public void setPropertyTotalPayableTaxAmount(double propertyTotalPayableTaxAmount) {
		this.propertyTotalPayableTaxAmount = propertyTotalPayableTaxAmount;
	}

	public Property() {
		super();

	}

	public Property(long propertyId, int propertyYearOfAssessment, String propertyOwnerName,
			String propertyOwnerEmailAddress, String propertyAddress, Zone propertyZone,
			Description propertyDescription, String propertyStatus, String propertyYearOfConstruction,
			String propertyAreaInSquareFoot, double propertyTotalPayableTaxAmount) {
		super();
		this.propertyId = propertyId;
		this.propertyYearOfAssessment = propertyYearOfAssessment;
		this.propertyOwnerName = propertyOwnerName;
		this.propertyOwnerEmailAddress = propertyOwnerEmailAddress;
		this.propertyAddress = propertyAddress;
		this.propertyZone = propertyZone;
		this.propertyDescription = propertyDescription;
		this.propertyStatus = propertyStatus;
		this.propertyYearOfConstruction = propertyYearOfConstruction;
		this.propertyAreaInSquareFoot = propertyAreaInSquareFoot;
		this.propertyTotalPayableTaxAmount = propertyTotalPayableTaxAmount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(propertyAddress, propertyAreaInSquareFoot, propertyDescription, propertyId,
				propertyOwnerEmailAddress, propertyOwnerName, propertyStatus, propertyTotalPayableTaxAmount,
				propertyYearOfAssessment, propertyYearOfConstruction, propertyZone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Property other = (Property) obj;
		return Objects.equals(propertyAddress, other.propertyAddress)
				&& Objects.equals(propertyAreaInSquareFoot, other.propertyAreaInSquareFoot)
				&& Objects.equals(propertyDescription, other.propertyDescription) && propertyId == other.propertyId
				&& Objects.equals(propertyOwnerEmailAddress, other.propertyOwnerEmailAddress)
				&& Objects.equals(propertyOwnerName, other.propertyOwnerName)
				&& Objects.equals(propertyStatus, other.propertyStatus)
				&& Double.doubleToLongBits(propertyTotalPayableTaxAmount) == Double
						.doubleToLongBits(other.propertyTotalPayableTaxAmount)
				&& propertyYearOfAssessment == other.propertyYearOfAssessment
				&& Objects.equals(propertyYearOfConstruction, other.propertyYearOfConstruction)
				&& Objects.equals(propertyZone, other.propertyZone);
	}

	@Override
	public int compareTo(Property o) {
		return (int) (this.propertyId - o.propertyId);

	}

}
