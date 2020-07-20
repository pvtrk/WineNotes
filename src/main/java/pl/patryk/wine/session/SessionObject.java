package pl.patryk.wine.session;

import pl.patryk.wine.model.User;

public class SessionObject {
    private boolean isLogged;
    private User user;

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
