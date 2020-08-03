package pl.patryk.wine.service;

import pl.patryk.wine.model.Country;

import java.util.List;

public interface ICountryService {
    List<Country> findAll();
}
