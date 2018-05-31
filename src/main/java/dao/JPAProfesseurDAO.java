/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import metier.Professeur;

/**
 *
 * @author mac-clement
 */
public class JPAProfesseurDAO extends JPADAO<Professeur> implements ProfesseurDAO {

    @Override
    public Professeur find(Integer id) {
        return this.em.find(Professeur.class, id);
    }

    @Override
    public List<Professeur> findAll() {
        return em.createNamedQuery("Professeur.findAll").getResultList();
    }

    public Professeur findByMail(String mail) {
        return em.createNamedQuery("Professeur.findByMail", Professeur.class)
                .setParameter("mail", mail)
                .getSingleResult();
    }

    @Override
    public boolean deleteAll() {
        List<Professeur> professeursList = this.findAll();
        for (Professeur professeur : professeursList) {
            this.em.remove(professeur);
        }
        return true;
    }
}
