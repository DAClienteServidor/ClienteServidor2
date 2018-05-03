/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteservidor2.dao;

import static java.nio.file.Files.list;
import static java.util.Collections.list;
import javax.ejb.Local;

/**
 *
 * @author maria
 * @param <T>
 * @param 
 */

@Local
public interface DAO<T>{
    
    
        void create(Object obj);
	
	void update(Object obj);
	
	void delete(Object obj);
	
	T findAll();
	
}
