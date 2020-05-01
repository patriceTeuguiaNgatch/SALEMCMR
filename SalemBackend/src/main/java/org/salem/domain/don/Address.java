package org.salem.domain.don;

import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

    private String roadNumber;

    private String town;

    private String zipCode;

    public Address() {
    }

    public Address(String roadNumber, String town, String zipCode) {
        this.roadNumber = roadNumber;
        this.town = town;
        this.zipCode = zipCode;
    }

    public String getRoadNumber() {
        return this.roadNumber;
    }

    public void setRoadNumber(String roadNumber) {
        this.roadNumber = roadNumber;
    }

    public String getTown() {
        return this.town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Address)) {
            return false;
        }
        Address address = (Address) o;
        return Objects.equals(roadNumber, address.roadNumber) && Objects.equals(town, address.town)
                && Objects.equals(zipCode, address.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roadNumber, town, zipCode);
    }

}