package com.library.controller;

import java.util.ArrayList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Controller {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
            System.getProperties().put("server.port", 8081);
            SpringApplication.run(Controller.class, args);
         
    }
}
