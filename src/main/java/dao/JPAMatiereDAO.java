/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import metier.Matiere;

/**
 *
 * @author mac-clement
 */
public class JPAMatiereDAO extends JPADAO<Matiere> implements MatiereDAO {

    @Override
    public Matiere find(Integer id) {
        return this.em.find(Matiere.class, id);
    }

    @Override
    public List<Matiere> findAll() {
        return em.createNamedQuery("Matiere.findAll").getResultList();
    }

    @Override
    public boolean deleteAll() {
        List<Matiere> matiereList = this.findAll();
        for (Matiere matiere : matiereList) {
            this.em.remove(matiere);
        }
        return true;
    }
}
