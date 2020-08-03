package pl.patryk.wine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.patryk.wine.dao.NoteDAO;
import pl.patryk.wine.model.Note;
import pl.patryk.wine.service.INoteService;


import java.util.List;

@Service
public class NoteService implements INoteService {

    private NoteDAO noteDAO;

    public NoteService() {
    }

    @Autowired
    NoteService(NoteDAO noteDAO) {
        this.noteDAO = noteDAO;
    }

    @Override
    public List<Note> findAllNotesForUser(Long userId) {
        return  noteDAO.findAllNotesForUser(userId);

    }

    @Override
    public List<Note> findSearchedNotes(Long userId, String filterText) {
        return noteDAO.findSearchedNotes(userId, filterText);
    }

    public List<Note> findNotesForUser(Long userId, String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            return findAllNotesForUser(userId);
        } else {
            return findSearchedNotes(userId, filterText);
        }
    }

    @Override
    public void save(Note note) {
        this.noteDAO.save(note);
    }

    @Override
    public void delete(Note note) {
        this.noteDAO.delete(note);
    }
}
