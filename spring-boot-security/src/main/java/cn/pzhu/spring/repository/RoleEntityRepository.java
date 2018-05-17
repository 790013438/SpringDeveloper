package cn.pzhu.spring.repository;

import cn.pzhu.spring.domain.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleEntityRepository extends JpaRepository<RoleEntity, String> {
}
