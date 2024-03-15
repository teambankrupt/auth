package com.example.auth.entities;

import com.example.auth.enums.AccessLevels;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "privileges", schema = "auth")
public class Privilege extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String label;

    private String description;

    @OneToMany(orphanRemoval = true, mappedBy = "privilege")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<UrlAccess> urlAccesses = new ArrayList<>();

    public Privilege() {
    }

    public Privilege(String name, String label) {
        this.name = name;
        this.label = label;
    }

    public String[] accessesArr(AccessLevels accessLevel) {
        return this.getUrlAccesses()
                .stream().filter(ua -> ua.getAccessLevel().equals(accessLevel))
                .map(UrlAccess::getUrl).toList().toArray(String[]::new);
    }

    public String accessesStr(String accessLevel) {
        return String.join(",", this.accessesArr(AccessLevels.from(accessLevel)));
    }

    public boolean containsAccessUrl(String accessLevel, String url) {
        return Arrays.asList(this.accessesArr(AccessLevels.from(accessLevel))).contains(url);
    }

    public List<UrlAccess> getUrlAccesses() {
        return urlAccesses;
    }

    public void setUrlAccesses(List<UrlAccess> urlAccesses) {
        this.urlAccesses = urlAccesses;
    }

    public String getName() {
        return name;
    }

    public String getLabel() {
        return label;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
