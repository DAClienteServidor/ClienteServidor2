/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteservidor2.implementacion;

import clienteservidor2.dao.DAO;
import clienteservidor2.modelo.Componentes;
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
public class ComponentesJpaController implements DAO<List<Componentes>> {

    
    @PersistenceContext (unitName="clienteServ-pu")
     private EntityManager em;
    
//OVERRIDES---------------------------------------------------
    
    @Override
    public void create(Object obj) {
        Componentes C = (Componentes) obj;
        em.persist(C);   
    }

    @Override
    public void update(Object obj) {
        Componentes C = (Componentes) obj;
        em.persist(C);   
   }

    @Override
    public void delete(Object obj) {
        Componentes C = (Componentes) obj;
        em.persist(C);   
   }

    @Override
    public List<Componentes> findAll() {
   CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Componentes> q = cb.createQuery(Componentes.class);
		
		Root<Componentes> root = q.from(Componentes.class);
		q.select(root);
		
		TypedQuery<Componentes> query = em.createQuery(q);
		
                return query.getResultList();     
    }

//OTROS---------------------------------------------------
    public Componentes findComponentes(Integer id) {
        try {
            return em.find(Componentes.class, id);
        } finally {
            em.close();
        }
    }

    public int getComponentesCount() {
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Componentes> rt = cq.from(Componentes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
        

}



