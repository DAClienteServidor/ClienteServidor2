/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteservidor2.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author maria
 */
@MappedSuperclass
public abstract class BaseEntity implements Serializable{

    private static final long serialVersionUID = 1L;
   
    // Properties -------------------------------------------------------------

        @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;


// Getters/Setters-------------------------------------------------------------
    
    public Long getId() {
		return id;
	}

    public void setId(Long id) {
        this.id = id;
	}

    
   
    
}
