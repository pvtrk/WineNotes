package pl.patryk.wine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.patryk.wine.dao.WineInfoDAO;
import pl.patryk.wine.model.WineInfo;
import pl.patryk.wine.service.IWineInfoService;


@Service
public class WineInfoService implements IWineInfoService {
    private WineInfoDAO wineInfoDAO;

    @Autowired
    public WineInfoService(WineInfoDAO wineInfoDAO) {
        this.wineInfoDAO = wineInfoDAO;
    }

    public WineInfoService() {
    }

    @Override
    public void save(WineInfo wineInfo) {
        this.wineInfoDAO.save(wineInfo);
    }

    @Override
    public void delete(WineInfo wineInfo) {
        this.wineInfoDAO.delete(wineInfo);
    }
}
