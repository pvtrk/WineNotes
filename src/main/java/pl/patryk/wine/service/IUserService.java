package pl.patryk.wine.service;

import pl.patryk.wine.model.User;

public interface IUserService {
    User findUserById(Long id);
}
