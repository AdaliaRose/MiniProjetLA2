/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import metier.Eleve;

/**
 *
 * @author mac-clement
 */
public class JPAEleveDAO extends JPADAO<Eleve> implements EleveDAO {

    @Override
    public Eleve find(Integer id) {
        return this.em.find(Eleve.class, id);
    }

    @Override
    public List<Eleve> findAll() {
        return em.createNamedQuery("Eleve.findAll").getResultList();
    }
    
    public Eleve findByMail(String mail){
        return em.createNamedQuery("Eleve.findByMail",Eleve.class)
                .setParameter("mail", mail)
                .getSingleResult();
    }
    
    @Override
    public boolean deleteAll() {
        List<Eleve> eleveList = this.findAll();
        for (Eleve eleve : eleveList) {
            this.em.remove(eleve);
        }
        return true;
    }
}
