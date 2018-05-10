package cn.pzhu.spring.service.impl;

import cn.pzhu.spring.domain.CollectEntity;
import cn.pzhu.spring.domain.FavoritesEntity;
import cn.pzhu.spring.domain.enumerate.CollectType;
import cn.pzhu.spring.domain.enumerate.IsDelete;
import cn.pzhu.spring.repository.CollectEntityRepository;
import cn.pzhu.spring.repository.FavoritesEntityRepository;
import cn.pzhu.spring.service.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("favoritesService")
public class FavoritesServiceImpl implements FavoritesService {
    @Autowired
    private FavoritesEntityRepository favoritesEntityRepository;
    @Autowired
    private CollectEntityRepository collectEntityRepository;

    @Override
    public FavoritesEntity saveFavorites(String userId, String name) {
        FavoritesEntity favoritesEntity = new FavoritesEntity();
        favoritesEntity.setName(name);
        favoritesEntity.setUserId(userId);
        favoritesEntity.setCount(0L);
        favoritesEntity.setPublicCount(10L);
        favoritesEntity.setCreateTime(System.currentTimeMillis());
        favoritesEntity.setLastModifyTime(System.currentTimeMillis());
        favoritesEntityRepository.save(favoritesEntity);
        return favoritesEntity;
    }

    /**
     * 保存
     */
    public FavoritesEntity saveFavorites(CollectEntity collectEntity) {
        FavoritesEntity favoritesEntity = new FavoritesEntity();
        favoritesEntity.setName(collectEntity.getNewFavorites());
        favoritesEntity.setUserId(collectEntity.getUserId());
        favoritesEntity.setCount(1L);
        if (CollectType.PUBLIC == collectEntity.getType()) {
            favoritesEntity.setPublicCount(1L);
        } else {
            favoritesEntity.setPublicCount(10L);
        }
        favoritesEntity.setCreateTime(System.currentTimeMillis());
        favoritesEntity.setLastModifyTime(System.currentTimeMillis());
        favoritesEntityRepository.save(favoritesEntity);
        return favoritesEntity;
    }

    @Override
    public void countFavorites(String id) {
        FavoritesEntity favoritesEntity = favoritesEntityRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "请求的id不存在"
                ));
        favoritesEntity.setCount(collectEntityRepository.countByFavoritesIdAndIsDelete(id, IsDelete.NO));
        favoritesEntity.setPublicCount(collectEntityRepository.countByFavoritesIdAndTypeAndIsDelete(id, CollectType.PUBLIC, IsDelete.NO));
        favoritesEntity.setLastModifyTime(System.currentTimeMillis());
        favoritesEntityRepository.save(favoritesEntity);
    }
}