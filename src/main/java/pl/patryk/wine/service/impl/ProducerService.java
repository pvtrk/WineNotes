package pl.patryk.wine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.patryk.wine.dao.ProducerDAO;
import pl.patryk.wine.model.Producer;
import pl.patryk.wine.service.IProducerService;

import java.util.List;

@Service
public class ProducerService implements IProducerService {

    private ProducerDAO producerDAO;

    public ProducerService() {
    }

    @Autowired
    public ProducerService(ProducerDAO producerDAO) {
        this.producerDAO = producerDAO;
    }

    @Override
    public List<Producer> findAll() {
        return producerDAO.findAll();
    }
}
