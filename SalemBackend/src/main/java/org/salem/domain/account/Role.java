package org.salem.domain.account;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "roleId")
    @GeneratedValue
    private Long roleId;

    @Enumerated(EnumType.STRING)
    @Column(name = "eRole")
    private ERole eRole;

    @ManyToMany(mappedBy = "roles", cascade = { CascadeType.MERGE })
    private Set<Account> accounts = new HashSet<>();

    public Role() {
    }

    public Role(final ERole eRole) {
        this.eRole = eRole;
    }

    public Long getRoleId() {
        return this.roleId;
    }

    public void setRoleId(final Long roleId) {
        this.roleId = roleId;
    }

    public ERole getERole() {
        return this.eRole;
    }

    public void setERole(final ERole eRole) {
        this.eRole = eRole;
    }

    public Set<Account> getAccounts() {
        return this.accounts;
    }

    public void setAccounts(final Set<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Role)) {
            return false;
        }
        final Role role = (Role) o;
        return Objects.equals(roleId, role.roleId) && Objects.equals(eRole, role.eRole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, eRole);
    }

    @Override
    public String toString() {
        return "{" + " id='" + getRoleId() + "'" + ", eRole='" + getERole() + "'" + "}";
    }

}