package pl.patryk.wine.service;

import pl.patryk.wine.model.Note;

import java.util.List;

public interface INoteService {
    List<Note> findNotesForUser(Long userId);
}
