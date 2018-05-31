/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dao.JPAEleveDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import metier.Eleve;

/**
 *
 * @author fdacquin
 */
@ViewScoped
@ManagedBean
public class EleveBean {

    private JPAEleveDAO eleveDAO = new JPAEleveDAO();

    private Eleve selectedEleve;

    private String newMail;
    private String newPassword;

    public List<Eleve> getAllEleves() {
        return eleveDAO.findAll();
    }
    
    public void addNewEleve(){
        Eleve eleve = new Eleve(newMail, newPassword);
        eleveDAO.create(eleve);
    }

    public Eleve getSelectedEleve() {
        return selectedEleve;
    }

    public void setSelectedEleve(Eleve selectedEleve) {
        this.selectedEleve = selectedEleve;
    }

    public String getNewMail() {
        return newMail;
    }

    public void setNewMail(String newMail) {
        this.newMail = newMail;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

}
