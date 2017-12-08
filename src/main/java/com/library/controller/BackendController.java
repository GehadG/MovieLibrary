/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrator
 */
@RestController
public class BackendController {

    @RequestMapping(value = "movies", method = RequestMethod.GET)
    public ResponseEntity<List<Movie>> listMovies() {

        return new ResponseEntity<>(MovieList.getInstance().getMovies(), HttpStatus.OK);
    }
    @RequestMapping(value = "movies/{from}/{to}", method = RequestMethod.GET)
    public ResponseEntity<List<Movie>> getMoviesWithDate(@PathVariable int from ,@PathVariable int to) {

        return new ResponseEntity<>(MovieList.getInstance().getMoviesWithDate(from, to), HttpStatus.OK);
    }

    @RequestMapping(value = "movies", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) throws MovieAlreadyExistsException, MovieDataIncompleteException {
        if (movie.getName() == null || movie.getReleaseYear() == 0) {
            throw new MovieDataIncompleteException();
        }
        return new ResponseEntity<>(MovieList.getInstance().addMovie(movie), HttpStatus.CREATED);
    }

    @RequestMapping(value = "movies/{movieID}", method = RequestMethod.GET)
    public ResponseEntity<Movie> findMovieById(@PathVariable String movieID) {

        return new ResponseEntity<>(MovieList.getInstance().getMovieById(movieID), HttpStatus.OK);
    }

    @RequestMapping(value = "movies/{movieID}", method = RequestMethod.PUT, consumes = "application/json")
    public ResponseEntity<Movie> updateMovieById(@RequestBody Movie movie,@PathVariable String movieID) {
        movie.setId(movieID);
        return new ResponseEntity<>(MovieList.getInstance().updateMovie(movie), HttpStatus.OK);
    }

    @RequestMapping(value = "movies/{movieID}", method = RequestMethod.DELETE)
    public ResponseEntity<String> removeMovieById(@PathVariable String movieID) {
        return new ResponseEntity<>(MovieList.getInstance().removeMovie(movieID), HttpStatus.OK);
    }

}
