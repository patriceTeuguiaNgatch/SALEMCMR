package org.salem.domain.don;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.salem.domain.account.Account;

@Entity
@Table(name = "dons")
public class Don implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "donId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long donId;

    @Embedded
    private Address Address;

    @Column(name = "king")
    private String king;

    @Column(name = "comment")
    private String comment;

    @Column(name = "isConfidential")
    private boolean isConfidential;

    @Enumerated(EnumType.STRING)
    @Column(name = "eDon")
    private Edon eDon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_don_id", referencedColumnName = "accountId")
    private Account account;

    public Don() {
    }

    public Don(final Address Address, final String king, final String comment, final boolean isConfidential,
            final Edon eDon) {
        this.Address = Address;
        this.king = king;
        this.comment = comment;
        this.isConfidential = isConfidential;
        this.eDon = eDon;
    }

    public Long getDonId() {
        return this.donId;
    }

    public void setDonId(final Long donId) {
        this.donId = donId;
    }

    public Address getAddress() {
        return this.Address;
    }

    public void setAddress(final Address Address) {
        this.Address = Address;
    }

    public String getKing() {
        return this.king;
    }

    public void setKing(final String king) {
        this.king = king;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(final String comment) {
        this.comment = comment;
    }

    public boolean isIsConfidential() {
        return this.isConfidential;
    }

    public boolean getIsConfidential() {
        return this.isConfidential;
    }

    public void setIsConfidential(final boolean isConfidential) {
        this.isConfidential = isConfidential;
    }

    public Account getAccount() {
        return this.account;
    }

    public void setAccount(final Account account) {
        this.account = account;
        account.getDons().add(this);
    }

    public Edon getEDon() {
        return this.eDon;
    }

    public void setEDon(final Edon eDon) {
        this.eDon = eDon;
    }

    public Boolean isConfidential() {
        return this.isConfidential;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Don)) {
            return false;
        }
        final Don don = (Don) o;
        return Objects.equals(donId, don.donId) && Objects.equals(Address, don.Address)
                && Objects.equals(king, don.king) && Objects.equals(comment, don.comment)
                && isConfidential == don.isConfidential && Objects.equals(eDon, don.eDon)
                && Objects.equals(account, don.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(donId, Address, king, comment, isConfidential, eDon, account);
    }

}