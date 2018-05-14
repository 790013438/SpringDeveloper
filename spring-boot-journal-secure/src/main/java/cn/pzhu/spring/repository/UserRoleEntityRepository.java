package cn.pzhu.spring.repository;

import cn.pzhu.spring.domain.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleEntityRepository extends JpaRepository<UserRoleEntity, String> {

    UserRoleEntity findByUserEntityId(String userEntityId);
}
