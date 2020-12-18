/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sara.facade;

import java.util.List;
import javax.ejb.Local;
import sara.entity.Datospersonales;

/**
 *
 * @author victo
 */
@Local
public interface DatospersonalesFacadeLocal {

    void create(Datospersonales datospersonales);

    void edit(Datospersonales datospersonales);

    void remove(Datospersonales datospersonales);

    Datospersonales find(Object id);

    List<Datospersonales> findAll();

    List<Datospersonales> findRange(int[] range);

    int count();
    
}
