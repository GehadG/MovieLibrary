/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.controller;

import java.util.Objects;

/**
 *
 * @author Administrator
 */
public class Movie {

    private String name;
    private String director;
    private String rating;
    private int releaseYear;
    private String id;

    public Movie() {
    }
    

    public Movie(String name, String director, String rating, int releaseYear, String id) {
        this.name = name;
        this.director = director;
        this.rating = rating;
        this.releaseYear = releaseYear;
        this.id = id;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + Objects.hashCode(this.director);
        hash = 53 * hash + Objects.hashCode(this.releaseYear);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (obj instanceof Movie) {
            Movie movie = (Movie) obj;
            if(this.id.equals(movie.getId())){
                return true;
            }
            
        }
        return false;
    }

}



