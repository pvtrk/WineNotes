package pl.patryk.wine.service;

import pl.patryk.wine.model.Note;

import java.util.List;

public interface INoteService {
    List<Note> findAllNotesForUser(Long userId);
    List<Note> findSearchedNotes(Long userId, String filterText);
    List<Note> findNotesForUser(Long userId, String filterText);
}
