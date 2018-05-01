package cn.pzhu.spring.service;

import cn.pzhu.spring.domain.CollectEntity;
import cn.pzhu.spring.domain.FavoritesEntity;

public interface FavoritesService {
    FavoritesEntity saveFavorites(String userId, String name);

    FavoritesEntity saveFavorites(CollectEntity collect);

    void countFavorites(String id);

}