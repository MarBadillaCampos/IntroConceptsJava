/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.caricature.data;

import cr.caricature.domain.Caricature;
import cr.caricature.exception.DataAccessException;
import cr.caricature.exception.DataReadException;
import cr.caricature.exception.DataWriteException;
import java.io.BufferedReader;
import java.io.*;
import java.util.*;




/**
 *
 * @author MarBadilla
 */
public class DataBaseImplementation implements IDataBaseConnection {

    @Override
    public boolean isDataBase(String DBname) throws DataAccessException {
       File  document = new File(DBname);
       return document.exists(); // return true or false
    }

    @Override
    public List<Caricature> listCharacters(String DBname) throws DataReadException {
       var document = new File(DBname);
       List<Caricature> characters = new ArrayList<>();
        try {
           try (BufferedReader input = new BufferedReader(new FileReader(document))) {
               String row = null;
               row = input.readLine();
               while(row != null ){
                   var carAux= new Caricature(row,"");// Create a new Object
                   characters.add(carAux);//Insert a new object
                   row = input.readLine(); // start again with a new object
               }
           }
            
        } catch (FileNotFoundException ex) { // Using our own exceptions
           
           throw new DataReadException("Caricatures List Exception" + ex.getMessage()); // Exception Spread 
           
        } catch (IOException ex) { 
           
           throw new DataReadException("Caricatures List Exception" + ex.getMessage());
        }
        return characters;    
    }

    @Override
    public void write(Caricature cari, String DBname, boolean added) throws DataWriteException {
       var document = new File(DBname);
        try {
           try (java.io.PrintWriter output = new PrintWriter(new FileWriter(document,added))) {
               output.println(cari.toString());
           }
            System.out.println("Written Successfully");    
        } catch (IOException ex) {
            throw new DataWriteException("Written Exception" + ex.getMessage());
            
        }
    }

    @Override
    public String searchCaricature(String DBname, String search) throws DataReadException {
      var document = new File(DBname);
      String result = null;
        try {
          try (java.io.BufferedReader input = new BufferedReader(new FileReader (document))) {
              String row = null;
              row = input.readLine();
              int i=1;
              while(row != null){
                  if( search != null && search.equalsIgnoreCase(row)){
                      result = "Caricature Found" + row + "number"+i;
                      break;
                  }
                  row = input.readLine();
                  i++;
              }
          }
        } catch (FileNotFoundException ex) {
             throw new DataReadException("Caricatures Search Exception" + ex.getMessage());
        } catch (IOException ex) { 
            throw new DataReadException("Caricatures Search Exception" + ex.getMessage());
        }
      return result;
    }

    @Override
    public void create(String DBname) throws DataAccessException {
       var document = new File(DBname);
        try {
            PrintWriter output= new PrintWriter(new FileWriter(document));
            output.close();
            System.out.println("New criature created");  
        } catch (IOException ex) {
            throw new DataAccessException("Caricatures Create Exception" + ex.getMessage()); 
        }
    }

    @Override
    public void delete(String DBname) throws DataAccessException {
        var document = new File(DBname);
        if(document.exists())
            document.delete();
        System.out.println("New criature created");   
    } 
}
