/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Recarga;

/**
 *
 * @author Casa Ortopedica
 */
@Stateless
public class RecargaFacade extends AbstractFacade<Recarga> {

    @PersistenceContext(unitName = "RecargasDCPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RecargaFacade() {
        super(Recarga.class);
    }
    
}
