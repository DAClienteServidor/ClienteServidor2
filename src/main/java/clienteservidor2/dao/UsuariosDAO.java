/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clienteservidor2.dao;

import clienteservidor2.modelo.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author usuario
 */
@Stateless
public class UsuariosDAO extends DAO<Usuarios> {

    @PersistenceContext(unitName = "clienteServ-pu")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosDAO() {
        super(Usuarios.class);  //Llama a la superclase AbstractFacade y le pasa la entidad Usuarios
    }

    public Usuarios iniciarSesion(Usuarios us) throws Exception {
        Usuarios usuario = null;
        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Usuarios> cq = cb.createQuery(Usuarios.class);

            Root<Usuarios> e = cq.from(Usuarios.class);
            
            
            cq.where(cb.and((cb.equal(e.get("usuario"), us.getUsuario())), (cb.equal(e.get("contrasena"), us.getContrasena()))));

            Query query = em.createQuery(cq);
            
            List<Usuarios> lista = query.getResultList();
            if (!lista.isEmpty()) {
                usuario = lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return usuario;
    }

}
