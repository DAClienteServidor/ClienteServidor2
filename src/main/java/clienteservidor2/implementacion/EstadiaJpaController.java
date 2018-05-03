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
import clienteservidor2.modelo.Estadia;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;

/**
 *
 * @author maria
 */
public class EstadiaJpaController implements DAO<List<Estadia>> {

    @PersistenceContext (unitName="ClienteServidor2")
     private EntityManager em;
    
    // OVERRIDES-------------------------------------------------------
    
    
    @Override
    public void create(Object obj) {
    Estadia E = (Estadia) obj;
        em.persist(E); 
    }

    @Override
    public void update(Object obj) {
    Estadia E = (Estadia) obj;
        em.persist(E);    
    }

    @Override
    public void delete(Object obj) {
    Estadia E = (Estadia) obj;
        em.persist(E);
    }

    @Override
    public List<Estadia> findAll() {
          CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Estadia> q = cb.createQuery(Estadia.class);
		
		Root<Estadia> root = q.from(Estadia.class);
		q.select(root);
		
		TypedQuery<Estadia> query = em.createQuery(q);
		
                return query.getResultList(); 
    }

    // OTROS ------------------------------------------------------
    
    public Estadia findEstadia(Integer id) {
        try {
            return em.find(Estadia.class, id);
        } finally {
            em.close();
        }
    }

    public int getEstadiaCount() {
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Estadia> rt = cq.from(Estadia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

 
}
