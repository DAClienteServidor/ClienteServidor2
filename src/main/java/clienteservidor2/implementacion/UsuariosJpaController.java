/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteservidor2.implementacion;

import clienteservidor2.dao.DAO;
import clienteservidor2.modelo.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
/** import clienteservidor2.modelo.Usuarios_;**/
import javax.persistence.Query;

/**
 *
 * @author maria
 */

@Stateless
public class UsuariosJpaController implements DAO<List<Usuarios>> {

    @PersistenceContext (unitName="ClienteServidor2")
    private EntityManager em;
    
    //OVERRIDES-----------------------------------------
    
    @Override
    public void create(Object obj) {
    Usuarios U= (Usuarios) obj;
    em.persist(U);
    }

    @Override
    public void update(Object obj) {
    Usuarios U= (Usuarios) obj;
    em.persist(U);
    }

    @Override
    public void delete(Object obj) {
    Usuarios U= (Usuarios) obj;
    em.persist(U);
    
    }

   
    @Override
    public List<Usuarios> findAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Usuarios> q = cb.createQuery(Usuarios.class);
		
		Root<Usuarios> root = q.from(Usuarios.class);
		q.select(root);
		
		TypedQuery<Usuarios> query = em.createQuery(q);
		
		return query.getResultList();
    }
    
// OTROS -------------------------------------------------------------
    public Usuarios findUsuario(Integer id) {
        try {
            return em.find(Usuarios.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuariosCount() {
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuarios> rt = cq.from(Usuarios.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    /**
    public List<Usuarios> findByNombreApellido(String nombreApellido) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Usuarios> q = cb.createQuery(Usuarios.class);
		
		Root<Usuarios> root = q.from(Usuarios.class);
		q.select(root);
	
        Predicate predicate = cb.and(
                cb.like(root.get(Usuarios_.Nombre), likeString(nombreApellido)),
                cb.like(root.get(Usuarios_.Apellido), likeString(nombreApellido))
        );
		
		q.where(predicate);
		
		TypedQuery<Usuarios> query = em.createQuery(q);
		
		return query.getResultList();
	}
    
   public Optional<Usuarios> findByNumeroDocumento(String dni) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Usuarios> q = cb.createQuery(Usuarios.class);
		
		Root<Usuarios> root = q.from(Usuarios.class);
		q.select(root);
		
		Predicate predicate = cb.equal(
				root.get(Usuarios_.dni), dni);
		
		q.where(predicate);
		
		TypedQuery<Usuarios> query = em.createQuery(q);
		
		Usuarios Usuarios = null;
		try {
			Usuarios = query.getSingleResult();
		} catch (NoResultException e1) {
		} catch (NonUniqueResultException e2) {
		}
		
		return Optional.ofNullable(Usuarios);
	}

	public static final String likeString(String search)  {
		StringBuilder builder = new StringBuilder();
		
		if(search.charAt(0) != '%')
			builder.append('%');
		builder.append(search.toUpperCase());	
		if(search.charAt(search.length()-1) != '%')
			builder.append('%');
		
		return builder.toString();
	}	 
   
    -----------------------------------------------------------------**/
}
   