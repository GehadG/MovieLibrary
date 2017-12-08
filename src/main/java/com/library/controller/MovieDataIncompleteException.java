/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Administrator
 */
@ResponseStatus(value=HttpStatus.PRECONDITION_REQUIRED, reason="Movie name and release date required")
public class MovieDataIncompleteException extends RuntimeException{
    
}
