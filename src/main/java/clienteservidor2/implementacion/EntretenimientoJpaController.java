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
import clienteservidor2.modelo.Entretenimiento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;

/**
 *
 * @author maria
 */
public class EntretenimientoJpaController implements DAO<List<Entretenimiento>> {

    
    @PersistenceContext (unitName="ClienteServidor2")
     private EntityManager em;
    
    //OVERRIDES---------------------------------------------------------
    
    @Override
    public void create(Object obj) {
        Entretenimiento E = (Entretenimiento) obj;
        em.persist(E);   
    }

    @Override
    public void update(Object obj) {
        Entretenimiento E = (Entretenimiento) obj;
        em.persist(E);  
    }

    @Override
    public void delete(Object obj) {
        Entretenimiento E = (Entretenimiento) obj;
        em.persist(E); }

    @Override
    public List<Entretenimiento> findAll() {
   CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Entretenimiento> q = cb.createQuery(Entretenimiento.class);
		
		Root<Entretenimiento> root = q.from(Entretenimiento.class);
		q.select(root);
		
		TypedQuery<Entretenimiento> query = em.createQuery(q);
		
                return query.getResultList();     
    }
  //OTROS-----------------------------------------------------------
    
        public Entretenimiento findEntretenimiento(Integer id) {
        try {
            return em.find(Entretenimiento.class, id);
        } finally {
            em.close();
        }
    }

    public int getEntretenimientoCount() {
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Entretenimiento> rt = cq.from(Entretenimiento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }




    
}
