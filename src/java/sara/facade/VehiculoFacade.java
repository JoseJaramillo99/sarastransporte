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
 * @author mompo
 */
@Stateless
public class VehiculoFacade extends AbstractFacade<Vehiculo> implements VehiculoFacadeLocal {

    @PersistenceContext(unitName = "sarastransportePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    @Override
    public List<Vehiculo> listaVehiculosporcategoria(int caid){
        try {
            Query qt = em.createQuery("SELECT p FROM Vehiculo p WHERE p.categoria_caid= :caid");
            qt.setParameter("catid", caid);
            return   qt.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    public VehiculoFacade() {
        super(Vehiculo.class);
    }
    
}
