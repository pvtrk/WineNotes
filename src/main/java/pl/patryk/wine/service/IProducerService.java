package pl.patryk.wine.service;

import pl.patryk.wine.model.Producer;

import java.util.List;

public interface IProducerService {
    List<Producer> findAll();
}
