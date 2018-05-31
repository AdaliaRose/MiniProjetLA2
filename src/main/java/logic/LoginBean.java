/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dao.JPAEleveDAO;
import dao.JPANoteDAO;
import dao.JPAMatiereDAO;
import dao.JPAProfesseurDAO;
import dao.ProfesseurDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import metier.Eleve;
import metier.Note;
import metier.Professeur;

/**
 *
 * @author fdacquin
 */
@SessionScoped
@ManagedBean
public class LoginBean {

    private String mail;
    private String password;
    private boolean isProfesseur;

    private JPAEleveDAO eleveDAO = new JPAEleveDAO();
    private JPAProfesseurDAO professeurDAO = new JPAProfesseurDAO();

    private Professeur loggedProfesseur = null;
    private Eleve loggedEleve = null;

    public String doLogin() {
        if (isProfesseur) {
            Professeur professeur = professeurDAO.findByMail(mail);
            if (professeur == null || !professeur.getPassword().equals(password)) {
                return "";
            }
            loggedProfesseur = professeur;
            System.out.println("Connecté en tant que prof");
        } else {
            Eleve eleve = eleveDAO.findByMail(mail);
            if (eleve == null || !eleve.getPassword().equals(password)) {
                return "";
            }
            loggedEleve = eleve;
            System.out.println("Connecté en tant qu'eleve");
        }
        return "index.xhtml?faces-redirect=true";
    }

    public Professeur getLoggedProfesseur() {
        return loggedProfesseur;
    }

    public void setLoggedProfesseur(Professeur loggedProfesseur) {
        this.loggedProfesseur = loggedProfesseur;
    }

    public Eleve getLoggedEleve() {
        return loggedEleve;
    }

    public void setLoggedEleve(Eleve loggedEleve) {
        this.loggedEleve = loggedEleve;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIsProfesseur() {
        return isProfesseur;
    }

    public void setIsProfesseur(boolean isProfesseur) {
        this.isProfesseur = isProfesseur;
    }

}
