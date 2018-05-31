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
@Table(name = "ELEVE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Eleve.findAll", query = "SELECT e FROM Eleve e")
    , @NamedQuery(name = "Eleve.findByPassword", query = "SELECT e FROM Eleve e WHERE e.password = :password")
    , @NamedQuery(name = "Eleve.findByMail", query = "SELECT e FROM Eleve e WHERE e.mail = :mail")
    , @NamedQuery(name = "Eleve.findById", query = "SELECT e FROM Eleve e WHERE e.id = :id")})
public class Eleve implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    private static final long serialVersionUID = 1L;
    @Column(name = "MAIL", unique = true)
    private String mail;
    @Column(name = "PASSWORD")
    private String password;
    @OneToMany(mappedBy = "eleve")
    private List<Note> notesList;

    public Eleve() {
        this.id = this.hashCode();
    }

    public Eleve(String email, String password) {
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

    @Override
    public int hashCode() {
        int hash = 1;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Eleve)) {
            return false;
        }
        Eleve other = (Eleve) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "\nEleve{" + "password=" + password + ", email=" + mail + ", id=" + id + '}';
    }

    public List<Note> getNotesList() {
        return notesList;
    }

    public void setNotesList(List<Note> notesList) {
        this.notesList = notesList;
    }

}
