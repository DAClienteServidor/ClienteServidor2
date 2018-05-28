/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteservidor2.dao;

import clienteservidor2.modelo.Pasajes;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author usuario
 */
@Stateless
public class PasajesFacade extends AbstractFacade<Pasajes> {

    @PersistenceContext(unitName = "clienteServ-pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PasajesFacade() {
        super(Pasajes.class);
    }
    
}
