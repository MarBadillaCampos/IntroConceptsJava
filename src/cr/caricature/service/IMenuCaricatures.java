/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.caricature.service;

/**
 *
 * @author MarBadilla
 */
public interface IMenuCaricatures {// Bussiness phase
   String  NAME_CARICATURE = "caricatures.txt";
   
    void addCaricature(String name,String description);
    void listCaricatures();
    void searchCaricature(String search);
    void initMenuCaricatures();  
}
