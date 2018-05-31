/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import metier.Note;

/**
 *
 * @author mac-clement
 */
public class JPANoteDAO extends JPADAO<Note> implements NoteDAO {

    @Override
    public Note find(Integer id) {
        return this.em.find(Note.class, id);
    }

    @Override
    public List<Note> findAll() {
        return em.createNamedQuery("Note.findAll").getResultList();
    }

    @Override
    public boolean deleteAll() {
        List<Note> notesList = this.findAll();
        for (Note note : notesList) {
            this.em.remove(note);
        }
        return true;
    }

}
