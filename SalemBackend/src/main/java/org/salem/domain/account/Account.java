package org.salem.domain.account;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "accountId")
    @GeneratedValue
    private Long accountId;

    @Column(name = "firtName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "telephoneNumber")
    private String telephoneNumber;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "accounts_roles", joinColumns = @JoinColumn(name = "accountId"), inverseJoinColumns = @JoinColumn(name = "roleId"))
    private Set<Role> roles = new HashSet<>();

    public Account() {
    }

    public Account(String firstName, String lastName, String password, String email, String telephoneNumber,
            Set<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.telephoneNumber = telephoneNumber;
        this.roles = roles;
    }

    public Long getAccountId() {
        return this.accountId;
    }

    public void setAccounId(Long accountId) {
        this.accountId = accountId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephoneNumber() {
        return this.telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Set<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRoles(Role role) {
        roles.add(role);
        role.getAccounts().add(this);
    }

    public void removeRole(Role role) {
        roles.remove(role);
        role.getAccounts().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Account)) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(accountId, account.accountId) && Objects.equals(firstName, account.firstName)
                && Objects.equals(lastName, account.lastName) && Objects.equals(password, account.password)
                && Objects.equals(email, account.email) && Objects.equals(telephoneNumber, account.telephoneNumber)
                && Objects.equals(roles, account.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, firstName, lastName, password, email, telephoneNumber, roles);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getAccountId() + "'" + ", firstName='" + getFirstName() + "'" + ", lastName='"
                + getLastName() + "'" + ", password='" + getPassword() + "'" + ", email='" + getEmail() + "'"
                + ", telephoneNumber='" + getTelephoneNumber() + "'" + ", roles='" + getRoles() + "'" + "}";
    }

}