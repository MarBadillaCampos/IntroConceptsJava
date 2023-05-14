/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.caricature.service;

import cr.caricature.data.DataBaseImplementation;
import cr.caricature.data.IDataBaseConnection;
import cr.caricature.domain.Caricature;
import cr.caricature.exception.DataAccessException;


/**
 *
 * @author MarBadilla
 */
public class MenuCaricaturesImplementation implements IMenuCaricatures {
    
    private final IDataBaseConnection info;

    public MenuCaricaturesImplementation() {
        this.info = new DataBaseImplementation();
    }
    
    

    @Override
    public void addCaricature(String name, String description) {
        Caricature car= new Caricature(name,description);
        boolean moreInf= false;
        try {
            moreInf= info.isDataBase(NAME_CARICATURE);
            info.write(car, NAME_CARICATURE, moreInf);   
        } catch (DataAccessException ex) {
             System.out.println("Error is not posible to add that Caricature");
             ex.printStackTrace(System.out);    
        }
    }
    @Override
    public void listCaricatures() {
        try{
            var caricatures = this.info.listCharacters(NAME_CARICATURE);
            for(var caricature: caricatures){
                System.out.println("Caricature: "+caricature);
            }
        }catch(DataAccessException ex){
             System.out.println("Error is not posible to show the list of Caricatures");
             ex.printStackTrace(System.out);
        }
        
    }

    @Override
    public void searchCaricature(String search) {
      String result=null;
        try {
            result= this.info.searchCaricature(NAME_CARICATURE, search);
            
        } catch (DataAccessException ex) {
           System.out.println("Error is not posible to search that information");
             ex.printStackTrace(System.out);
        }
        System.out.println("Result: "+result);
    }

    @Override
    public void initMenuCaricatures() {
        try {
            if(this.info.isDataBase(NAME_CARICATURE)){
                info.delete(NAME_CARICATURE);
                info.create(NAME_CARICATURE);
            }else{
                info.create(NAME_CARICATURE);
                
            } } catch (DataAccessException ex) {
           System.out.println("Error is not posible to Init Caricatures");
             ex.printStackTrace(System.out);
        }
    }
    
}
