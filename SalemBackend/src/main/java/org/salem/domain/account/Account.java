package org.salem.domain.account;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.salem.domain.don.Don;
import org.salem.domain.don.Name;

@Entity
@Table(name = "accounts")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "accountId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;

    @Embedded
    private Name name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "accounts_roles", joinColumns = @JoinColumn(name = "account_Id", referencedColumnName = "accountId"), inverseJoinColumns = @JoinColumn(name = "role_Id", referencedColumnName = "roleId"))
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Set<Don> dons;

    public Account() {
        this.dons = new HashSet<>();
    }

    public Account(Name name, String password, String email, String phoneNumber, Set<Role> roles) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.roles = roles;
        this.dons = new HashSet<>();
    }

    public Long getAccountId() {
        return this.accountId;
    }

    public void setAccounId(Long accountId) {
        this.accountId = accountId;
    }

    public Name getName() {
        return this.name;
    }

    public void setName(Name name) {
        this.name = name;
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

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Set<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<Don> getDons() {
        return this.dons;
    }

    public void setDons(Set<Don> dons) {
        this.dons = dons;
        for (Don don : dons) {
            don.setAccount(this);
        }
    }

    public void addRoles(Role role) {
        roles.add(role);
        role.getAccounts().add(this);
    }

    public void removeRole(Role role) {
        roles.remove(role);
        role.getAccounts().remove(this);
    }

    public Boolean hasEmail(String email) {
        return this.email.equals(email);
    }

    public boolean hasPassword(String password, String secret) {
        String passwordDecrypt = this.decryptPassword(secret);
        return password.equals(passwordDecrypt);
    }

    public void encryptPassword(String secret) {
        this.password = AdvancedEncryption.encrypt(this.password, secret);
    }

    private String decryptPassword(String secret) {
        return AdvancedEncryption.decrypt(this.password, secret);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Account)) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(accountId, account.accountId) && Objects.equals(name, account.name)
                && Objects.equals(password, account.password) && Objects.equals(email, account.email)
                && Objects.equals(phoneNumber, account.phoneNumber) && Objects.equals(roles, account.roles)
                && Objects.equals(dons, account.dons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, name, password, email, phoneNumber, roles, dons);
    }

}