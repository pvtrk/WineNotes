package pl.patryk.wine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.patryk.wine.dao.CountryDAO;
import pl.patryk.wine.model.Country;
import pl.patryk.wine.service.ICountryService;

import java.util.List;

@Service
public class CountryService implements ICountryService {

    private CountryDAO countryDAO;

    public CountryService() {
    }

    @Autowired
    CountryService(CountryDAO countryDAO) {
        this.countryDAO = countryDAO;
    }

    @Override
    public List<Country> findAll() {
        return this.countryDAO.findAll();
    }
}
