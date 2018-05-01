package cn.pzhu.spring.repository;

import cn.pzhu.spring.domain.FavoritesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@Transactional
@RepositoryRestResource(collectionResourceRel = "favorites", path="university")
public interface FavoritesEntityRepository extends JpaRepository<FavoritesEntity, String> {
}
