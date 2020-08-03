package pl.patryk.wine.service;

import pl.patryk.wine.model.WineInfo;

public interface IWineInfoService {
    void save(WineInfo wineInfo);
    void delete(WineInfo wineInfo);
}
