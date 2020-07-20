package pl.patryk.wine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.patryk.wine.dao.NoteDAO;
import pl.patryk.wine.service.INoteService;

@Service
public class NoteService implements INoteService {

    private NoteDAO noteDAO;

    public NoteService() {
    }

    @Autowired
    NoteService(NoteDAO noteDAO) {
        this.noteDAO = noteDAO;
    }
}
