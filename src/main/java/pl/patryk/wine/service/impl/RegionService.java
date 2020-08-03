package pl.patryk.wine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.patryk.wine.dao.RegionDAO;
import pl.patryk.wine.model.Region;
import pl.patryk.wine.service.IRegionService;

import java.util.List;

@Service
public class RegionService implements IRegionService {

    private RegionDAO regionDAO;

    public RegionService() {
    }

    @Autowired
    public RegionService(RegionDAO regionDAO) {
        this.regionDAO = regionDAO;
    }

    @Override
    public List<Region> findAll() {
        return this.regionDAO.findAll();
    }
}
