package com.example.auth.entities;

import com.example.auth.enums.AccessLevels;

import javax.persistence.*;

@Entity
@Table(name = "url_accesses", schema = "auth")
public class UrlAccess extends BaseEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "privilege_id")
    private Privilege privilege;

    @Enumerated(EnumType.STRING)
    @Column(name = "access_level", nullable = false)
    private AccessLevels accessLevel;

    @Column(name = "url", nullable = false)
    private String url;

    public UrlAccess() {
    }

    public UrlAccess(AccessLevels accessLevel, String url) {
        this.accessLevel = accessLevel;
        this.url = url;
    }

    public UrlAccess(Privilege privilege, AccessLevels accessLevel, String url) {
        this.privilege = privilege;
        this.accessLevel = accessLevel;
        this.url = url;
    }

    public Privilege getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Privilege privilege) {
        this.privilege = privilege;
    }

    public AccessLevels getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(AccessLevels accessLevel) {
        this.accessLevel = accessLevel;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
