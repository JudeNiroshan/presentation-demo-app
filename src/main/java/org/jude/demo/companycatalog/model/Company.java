package org.jude.demo.companycatalog.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Company {
    private String companyName;
    private String domain;
    private int foundedYear;
    private String location;
    private double rating;
    private String imgLocation;
}
