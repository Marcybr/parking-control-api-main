package com.api.parkingcontrol.models;

import com.api.parkingcontrol.enums.RoleName;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name="TB_ROLE")
public class RoleModel implements GrantedAuthority, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID roleId;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private RoleName rolename;

    @Override
    public String getAuthority() {
        return this.rolename.toString();
    }

    public UUID getRoleId() {
        return roleId;
    }

    public void setRoleId(UUID roleId) {
        this.roleId = roleId;
    }

    public RoleName getRolename() {
        return rolename;
    }

    public void setRolename(RoleName rolename) {
        this.rolename = rolename;
    }
}
