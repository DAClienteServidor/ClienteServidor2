/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteservidor2.implementacion;

import clienteservidor2.dao.DAO;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import clienteservidor2.modelo.Pasajes;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;

/**
 *
 * @author maria
 */
public class PasajesJpaController implements DAO<List<Pasajes>> {
    
     @PersistenceContext (unitName="clienteServ-pu")
     private EntityManager em;

//OVERRIDES-------------------------------------------
     
     
    @Override
    public void create(Object obj) {
    Pasajes P = (Pasajes) obj;
    em.persist(P);
    }

    @Override
    public void update(Object obj) {
    Pasajes P = (Pasajes) obj;
    em.persist(P);
    }

    @Override
    public void delete(Object obj) {
    Pasajes P = (Pasajes) obj;
    em.persist(P);
    }

    @Override
    public List<Pasajes> findAll() {
     CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Pasajes> q = cb.createQuery(Pasajes.class);
		
		Root<Pasajes> root = q.from(Pasajes.class);
		q.select(root);
		
		TypedQuery<Pasajes> query = em.createQuery(q);
		
		return query.getResultList();  
    }

    //OTROS-------------------------------------------

public Pasajes findPasajes(Integer id) {
        try {
            return em.find(Pasajes.class, id);
        } finally {
            em.close();
        }
    }

    public int getPasajesCount() {
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pasajes> rt = cq.from(Pasajes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }    
}
