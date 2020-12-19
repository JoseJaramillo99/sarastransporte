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
import sara.entity.Categoria;

/**
 *
 * @author victo
 */
@Stateless
public class CategoriaFacade extends AbstractFacade<Categoria> implements CategoriaFacadeLocal {

    @PersistenceContext(unitName = "sarastransportePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategoriaFacade() {
        super(Categoria.class);
    }
    
    @Override
    public int cantidadVehiculosCategoria( int categoria){
        try {
            Query qt = em.createNativeQuery("SELECT COUNT(*) FROM vehiculo WHERE caid = ?1");
            qt.setParameter(1, categoria);
            return ((Number)qt.getSingleResult()).intValue();
        } catch (Exception e) {
            return 0;
        }
    }
    
}
