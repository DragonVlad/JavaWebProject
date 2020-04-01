package com.routeapp.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String outPlace;
    private String inPlace;
    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOutPlace(){
        return outPlace;
    }

    public void setOutPlace(String outPlace){
        this.outPlace = outPlace;
    }

    public String getInPlace(){
        return inPlace;
    }

    public void setInPlace(String inPlace){
        this.inPlace = inPlace;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
