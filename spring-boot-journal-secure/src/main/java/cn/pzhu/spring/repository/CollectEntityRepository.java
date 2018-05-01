package cn.pzhu.spring.repository;

import cn.pzhu.spring.domain.CollectEntity;
import cn.pzhu.spring.domain.CollectType;
import cn.pzhu.spring.domain.IsDelete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@Transactional
@RepositoryRestResource(collectionResourceRel = "collect", path="university")
public interface CollectEntityRepository extends JpaRepository<CollectEntity, String> {

    Long countByFavoritesIdAndTypeAndIsDelete(String id, CollectType aPublic, IsDelete no);

    Long countByFavoritesIdAndIsDelete(String id, IsDelete no);
}
