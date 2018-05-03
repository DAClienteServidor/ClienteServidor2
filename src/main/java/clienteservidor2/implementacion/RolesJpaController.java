/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteservidor2.implementacion;

import clienteservidor2.dao.DAO;
import clienteservidor2.modelo.Pasajes;
import clienteservidor2.modelo.Roles;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;

/**
 *
 * @author maria
 */
public class RolesJpaController implements DAO<List<Roles>> {
    
        @PersistenceContext (unitName="ClienteServidor2")
    private EntityManager em;

        //OVERRIDES---------------------------------------
        
        
    @Override
    public void create(Object obj) {
    Roles R= (Roles) obj;
    em.persist(R);
    }

    @Override
    public void update(Object obj) {
    Roles R= (Roles) obj;
    em.persist(R);
    }

    @Override
    public void delete(Object obj) {
    Roles R= (Roles) obj;
    em.persist(R);
    }

    @Override
    public List<Roles> findAll() {
   CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Roles> q = cb.createQuery(Roles.class);
		
		Root<Roles> root = q.from(Roles.class);
		q.select(root);
		
		TypedQuery<Roles> query = em.createQuery(q);
		
		return query.getResultList();    }

 //OTROS---------------------------------------------------------   
    public Roles findRoles(Integer id) {
        try {
            return em.find(Roles.class, id);
        } finally {
            em.close();
        }
    }

    public int getRolesCount() {
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Roles> rt = cq.from(Roles.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
   
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
