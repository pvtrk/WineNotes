package pl.patryk.wine.session;

import pl.patryk.wine.model.Note;
import pl.patryk.wine.model.User;

import java.util.List;

public class TastingRoom {
    private User owner;
    private List<User> userList;
    private List<Note> noteList;

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }
}
