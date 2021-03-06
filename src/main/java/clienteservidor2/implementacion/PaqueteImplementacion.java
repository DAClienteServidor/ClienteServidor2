/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteservidor2.implementacion;

import clienteservidor2.dao.DAO;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import clienteservidor2.modelo.Paquete;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;

/**
 *
 * @author maria
 */
public class PaqueteImplementacion implements DAO<Paquete> {
        
     @PersistenceContext (unitName="clienteServ-pu")
     private EntityManager em;

//OVERRIDES---------------------------------------------
    @Override
    public void create(Paquete P) {
        em.persist(P);
    }

    @Override
    public void update(Paquete P) {
        em.persist(P);
    }

    @Override
    public void delete(Paquete P) {
        em.persist(P);
    }

    @Override
    public List<Paquete> findAll() {
         CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Paquete> q = cb.createQuery(Paquete.class);
		
		Root<Paquete> root = q.from(Paquete.class);
		q.select(root);
		
		TypedQuery<Paquete> query = em.createQuery(q);
		
                return query.getResultList();  
    }
    
//OTROS-----------------------------------
    
    
    public Paquete findPaquete(Integer id) {
        try {
            return em.find(Paquete.class, id);
        } finally {
            em.close();
        }
    }

    public int getPaqueteCount() {
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Paquete> rt = cq.from(Paquete.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
  
}
