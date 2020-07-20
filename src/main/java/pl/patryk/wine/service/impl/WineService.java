package pl.patryk.wine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.patryk.wine.dao.WineDAO;
import pl.patryk.wine.service.IWineService;

@Service
public class WineService implements IWineService {

    private WineDAO wineDAO;

    public WineService() {
    }

    @Autowired
    public WineService(WineDAO wineDAO) {
        this.wineDAO = wineDAO;
    }
}
