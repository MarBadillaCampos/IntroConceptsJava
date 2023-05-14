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
import java.util.List;

/**
 *
 * @author MarBadilla
 */
public interface IDataBaseConnection {
    
    boolean isDataBase(String DBname)throws DataAccessException;
    
    List<Caricature> listCharacters(String DBname) throws DataReadException;
    
    void write(Caricature cari,String DBname, boolean added ) throws DataWriteException;
    
    String searchCaricature(String DBname, String search) throws DataReadException;
    
    void create(String DBname) throws DataAccessException;
    
    void delete(String DBname) throws DataAccessException;
}
