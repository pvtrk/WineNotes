package pl.patryk.wine.service;

import pl.patryk.wine.model.Region;

import java.util.List;

public interface IRegionService {
    List<Region> findAll();
}
