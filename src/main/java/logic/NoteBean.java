/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import dao.JPANoteDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import metier.Eleve;
import metier.Matiere;
import metier.Note;

/**
 *
 * @author fdacquin
 */
@ViewScoped
@ManagedBean
public class NoteBean {

    private JPANoteDAO noteDAO = new JPANoteDAO();

    private Note selectedNote;

    private Eleve newEleve;
    private Matiere newMatiere;
    private Integer newNote;

    public List<Note> getAllNotes() {
        return noteDAO.findAll();
    }

    public void addNewNote() {
        Note note = new Note(newEleve, newMatiere, newNote);
        noteDAO.create(note);
    }

    public Note getSelectedNote() {
        return selectedNote;
    }

    public void setSelectedNote(Note selectedNote) {
        this.selectedNote = selectedNote;
    }

    public Eleve getNewEleve() {
        return newEleve;
    }

    public void setNewEleve(Eleve newEleve) {
        this.newEleve = newEleve;
    }

    public Matiere getNewMatiere() {
        return newMatiere;
    }

    public void setNewMatiere(Matiere newMatiere) {
        this.newMatiere = newMatiere;
    }

    public Integer getNewNote() {
        return newNote;
    }

    public void setNewNote(Integer newNote) {
        this.newNote = newNote;
    }

}
