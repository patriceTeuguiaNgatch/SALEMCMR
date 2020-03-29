// package org.salem.domain.don;

// import java.io.Serializable;
// import java.util.HashSet;
// import java.util.Objects;
// import java.util.Set;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.FetchType;
// import javax.persistence.GeneratedValue;
// import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.ManyToOne;
// import javax.persistence.Table;
// import org.salem.domain.account.Account;

// @Entity
// @Table(name = "dons")
// public class Don implements Serializable {

// private static final long serialVersionUID = 1L;

// @Id
// @Column(name = "donId")
// @GeneratedValue
// private Long donId;

// @Column(name = "roadNumber")
// private String roadNumber;

// @Column(name = "town")
// private String town;

// @Column(name = "postalCode")
// private String postalCode;

// @Column(name = "phoneNumber")
// private String phoneNumber;

// @Column(name = "country")
// private String country;

// @Column(name = "king")
// private String king;

// @Column(name = "comments")
// private String comments;

// @Column(name = "isConfidential")
// private Boolean isConfidential;

// @ManyToOne(fetch = FetchType.LAZY, optional = false)
// @JoinColumn(name = "acaount_id", nullable = false)
// private Set<Account> Accounts = new HashSet<>();

// public Don() {
// }

// public Don(Long donId, String roadNumber, String town, String postalCode,
// String phoneNumber, String country,
// String king, String comments, Boolean isConfidential, Set<Account> Accounts)
// {
// this.donId = donId;
// this.roadNumber = roadNumber;
// this.town = town;
// this.postalCode = postalCode;
// this.phoneNumber = phoneNumber;
// this.country = country;
// this.king = king;
// this.comments = comments;
// this.isConfidential = isConfidential;
// this.Accounts = Accounts;
// }

// public Long getDonId() {
// return this.donId;
// }

// public void setDonId(Long donId) {
// this.donId = donId;
// }

// public String getRoadNumber() {
// return this.roadNumber;
// }

// public void setRoadNumber(String roadNumber) {
// this.roadNumber = roadNumber;
// }

// public String getTown() {
// return this.town;
// }

// public void setTown(String town) {
// this.town = town;
// }

// public String getPostalCode() {
// return this.postalCode;
// }

// public void setPostalCode(String postalCode) {
// this.postalCode = postalCode;
// }

// public String getPhoneNumber() {
// return this.phoneNumber;
// }

// public void setPhoneNumber(String phoneNumber) {
// this.phoneNumber = phoneNumber;
// }

// public String getCountry() {
// return this.country;
// }

// public void setCountry(String country) {
// this.country = country;
// }

// public String getKing() {
// return this.king;
// }

// public void setKing(String king) {
// this.king = king;
// }

// public String getComments() {
// return this.comments;
// }

// public void setComments(String comments) {
// this.comments = comments;
// }

// public Boolean isIsConfidential() {
// return this.isConfidential;
// }

// public Boolean getIsConfidential() {
// return this.isConfidential;
// }

// public void setIsConfidential(Boolean isConfidential) {
// this.isConfidential = isConfidential;
// }

// public Set<Account> getAccounts() {
// return this.Accounts;
// }

// public void setAccounts(Set<Account> Accounts) {
// this.Accounts = Accounts;
// }

// @Override
// public boolean equals(Object o) {
// if (o == this)
// return true;
// if (!(o instanceof Don)) {
// return false;
// }
// Don don = (Don) o;
// return Objects.equals(donId, don.donId) && Objects.equals(roadNumber,
// don.roadNumber)
// && Objects.equals(town, don.town) && Objects.equals(postalCode,
// don.postalCode)
// && Objects.equals(phoneNumber, don.phoneNumber) && Objects.equals(country,
// don.country)
// && Objects.equals(king, don.king) && Objects.equals(comments, don.comments)
// && Objects.equals(isConfidential, don.isConfidential) &&
// Objects.equals(Accounts, don.Accounts);
// }

// @Override
// public int hashCode() {
// return Objects.hash(donId, roadNumber, town, postalCode, phoneNumber,
// country, king, comments, isConfidential,
// Accounts);
// }

// @Override
// public String toString() {
// return "{" + " donId='" + getDonId() + "'" + ", roadNumber='" +
// getRoadNumber() + "'" + ", town='" + getTown()
// + "'" + ", postalCode='" + getPostalCode() + "'" + ", phoneNumber='" +
// getPhoneNumber() + "'"
// + ", country='" + getCountry() + "'" + ", king='" + getKing() + "'" + ",
// comments='" + getComments()
// + "'" + ", isConfidential='" + isIsConfidential() + "'" + ", Accounts='" +
// getAccounts() + "'" + "}";
// }

// }