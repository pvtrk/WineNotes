package pl.patryk.wine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.patryk.wine.dao.NoteDAO;
import pl.patryk.wine.model.Note;
import pl.patryk.wine.service.INoteService;

import java.util.ArrayList;
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
    public List<Note> findNotesForUser(Long userId) {
        List<Note> notes = new ArrayList<>();
        notes = noteDAO.findNotesForUser(userId);
        return notes;
    }
}
