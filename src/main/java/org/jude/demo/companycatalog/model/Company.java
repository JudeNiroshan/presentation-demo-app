package org.jude.demo.companycatalog.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "company_name")
    private String companyName;
    private String domain;
    @Column(name = "founded_year")
    private int foundedYear;
    private String location;
    private double rating;
    @Column(name = "img_location")
    private String imgLocation;

    public Company() {
    }
}
