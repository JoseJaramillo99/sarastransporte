/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sara.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sara.entity.Usuario;

/**
 *
 * @author victo
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "sarastransportePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    public Usuario loginUsuario(String usuarioIn, String passIn) {
        try {
            Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.usulogin = :usuarioIn AND u.usupass = :passIn");
            q.setParameter("usuarioIn", usuarioIn);
            q.setParameter("passIn", passIn);
            return (Usuario) q.getSingleResult();
        } catch (Exception e) {
            return new Usuario();
        }
    }
}
