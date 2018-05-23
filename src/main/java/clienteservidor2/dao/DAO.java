/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteservidor2.dao;

import static java.nio.file.Files.list;
import static java.util.Collections.list;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author maria
 * @param <T>
 * @param 
 */

@Local
public interface DAO<T>{
    
    
        void create(T obj);
	
	void update(T obj);
	
	void delete(T obj);
	
	   List<T> findAll();
	
}
