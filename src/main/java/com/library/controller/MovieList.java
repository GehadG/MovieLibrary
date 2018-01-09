/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.controller;

import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author Administrator
 */
public class MovieList {

    private ArrayList<Movie> movies = new ArrayList<>();

    private MovieList() {
    }

    public static MovieList getInstance() {
        return MovieListHolder.INSTANCE;
    }

    private static class MovieListHolder {

    	
    	
    	
    	
    	
        private static final MovieList 	INSTANCES = new MovieList();
    }

    public Movie addMovie(Movie movie) throws MovieAlreadyExistsException {
        for (Movie m : movies) {
            if (m.getName().equalsIgnoreCase(movie.getName()) && m.getReleaseYear()==(movie.getReleaseYear())) {
                throw new MovieAlreadyExistsException();
            }
        }
        movie.setId(UUID.randomUUID().toString());
        movies.add(movie);
        return movie;
    }

    public String removeMovie(String movieID) throws MovieNotFoundException {
        Movie movie = new Movie();
        movie.setId(movieID);
        if (!movies.remove(movie)) {
            throw new MovieNotFoundException();
        }
        return "Movie Successfully Removed";

    }

    public Movie getMovieById(String id) throws MovieNotFoundException {
        for (Movie m : movies) {
            if (m.getId().equals(id)) {
                return m;
            }
        }
        throw new MovieNotFoundException();
    }

    public Movie updateMovie(Movie movie) throws MovieNotFoundException {
        for (Movie m : movies) {
            if (m.equals(movie)) {
                movies.set(movies.indexOf(m), movie);
                return movie;
            }
        }
        throw new MovieNotFoundException();
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }
    public ArrayList<Movie> getMoviesWithDate(int from , int to){
        ArrayList<Movie> matches = new ArrayList<>();
        for(Movie m : movies){
            if(m.getReleaseYear()>=from && m.getReleaseYear()<=to){
                matches.add(m);
            }
        }
        
        
        return matches;
    }
}
