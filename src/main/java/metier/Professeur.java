/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mac-clement
 */
@Entity
@Table(name = "PROFESSEUR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Professeur.findAll", query = "SELECT p FROM Professeur p")
    , @NamedQuery(name = "Professeur.findByPassword", query = "SELECT p FROM Professeur p WHERE p.password = :password")
    , @NamedQuery(name = "Professeur.findByMail", query = "SELECT p FROM Professeur p WHERE p.mail = :mail")
    , @NamedQuery(name = "Professeur.findById", query = "SELECT p FROM Professeur p WHERE p.id = :id")})
public class Professeur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    private static final long serialVersionUID = 1L;
    @Column(name = "MAIL",unique = true)
    private String mail;
    @Column(name = "PASSWORD")
    private String password;
    @ManyToOne
    private Matiere matiere;

    public Professeur() {
        this.id = this.hashCode();
    }

    public Professeur(String email, String password) {
        this();
        this.mail = email;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Professeur)) {
            return false;
        }
        Professeur other = (Professeur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\nEleve{" + "password=" + password + ", email=" + mail + ", id=" + id + '}';
    }

}
