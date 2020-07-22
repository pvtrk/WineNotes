package pl.patryk.wine.service;

import pl.patryk.wine.model.Wine;

import java.util.List;

public interface IWineService {
    List<Wine> findAll();
}
