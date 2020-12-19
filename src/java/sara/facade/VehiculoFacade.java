/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sara.facade;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sara.entity.Vehiculo;

/**
 *
 * @author victo
 */
@Stateless
public class VehiculoFacade extends AbstractFacade<Vehiculo> implements VehiculoFacadeLocal {

    @PersistenceContext(unitName = "sarastransportePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VehiculoFacade() {
        super(Vehiculo.class);
    }
    
    @Override
    public List<Vehiculo> listaVehiculosPorcategoria(int fk_categoria){
        try {
            Query qt = em.createQuery("SELECT p FROM Vehiculo p WHERE p.caid.caid = :fk_categoria");
            qt.setParameter("fk_categoria", fk_categoria);
            return   qt.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
    
    
}
