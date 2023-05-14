/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.caricatures.view;

import cr.caricature.service.*;
import java.util.Scanner;

/**
 *
 * @author MarBadilla
 */
public class CatalogView {
   
    public static void main(String[] args) {
        var op = -1;
        var scanner= new Scanner(System.in);
        
        IMenuCaricatures catalog =  (IMenuCaricatures) new MenuCaricaturesImplementation();
        
        while(op != 0){
            System.out.println("Choose an option \n"
                    +"1. Start Caricatures Catalog \n"
                    +"2. Add a Caricature \n"
                    +"3. Make a List of Caricatures \n"
                    +"4. Search Caricature \n"
                    +"0. Exit");
            op = Integer.parseInt(scanner.nextLine());
            
            switch(op){
                case 1:
                    catalog.initMenuCaricatures();
                    break;
                case 2:
                    System.out.println("Add a name");
                    var name = scanner.nextLine();
                    
                    System.out.println("Add a description");
                    var des = scanner.nextLine();
                    catalog.addCaricature(name, des);
                    break;
                case 3:
                    catalog.listCaricatures();
                    break;
                case 4:
                    System.out.println("Add a name");
                    var search = scanner.nextLine();
                    catalog.searchCaricature(search);
                    break; 
                case 0: 
                    System.out.println("Good Bye");  
                    break;
                default:
                    System.out.println("Invalid option");
            }    
        }
    }  
}
