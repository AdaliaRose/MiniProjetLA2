/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dao.JPAMatiereDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import metier.Eleve;
import metier.Matiere;

/**
 *
 * @author fdacquin
 */
@ViewScoped
@ManagedBean
public class MatiereBean {

    private JPAMatiereDAO matiereDAO = new JPAMatiereDAO();

    private Matiere selectedMatiere;

    private String newNom;

    public List<Matiere> getAllMatieres() {
        return matiereDAO.findAll();
    }

    public void addNewMatiere() {
        Matiere matiere = new Matiere(newNom);
        matiereDAO.create(matiere);
    }

    public Matiere getSelectedMatiere() {
        return selectedMatiere;
    }

    public void setSelectedMatiere(Matiere selectedMatiere) {
        this.selectedMatiere = selectedMatiere;
    }

    public String getNewNom() {
        return newNom;
    }

    public void setNewNom(String newNom) {
        this.newNom = newNom;
    }

}
