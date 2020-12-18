/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sara.facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sara.entity.Datospersonales;

/**
 *
 * @author victo
 */
@Stateless
public class DatospersonalesFacade extends AbstractFacade<Datospersonales> implements DatospersonalesFacadeLocal {

    @PersistenceContext(unitName = "sarastransportePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DatospersonalesFacade() {
        super(Datospersonales.class);
    }
    
}
