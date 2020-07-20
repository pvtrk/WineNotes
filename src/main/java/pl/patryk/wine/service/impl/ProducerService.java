package pl.patryk.wine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.patryk.wine.dao.ProducerDAO;
import pl.patryk.wine.service.IProducerService;

@Service
public class ProducerService implements IProducerService {

    private ProducerDAO producerDAO;

    public ProducerService() {
    }

    @Autowired
    public ProducerService(ProducerDAO producerDAO) {
        this.producerDAO = producerDAO;
    }
}
