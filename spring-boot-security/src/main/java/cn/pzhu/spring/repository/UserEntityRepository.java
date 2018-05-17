package cn.pzhu.spring.repository;

import cn.pzhu.spring.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntityRepository extends JpaRepository<UserEntity, String> {
}
