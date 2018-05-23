package cn.pzhu.spring.repository;

import cn.pzhu.spring.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserEntityRepository extends JpaRepository<UserEntity, String> {
    UserEntity findByEmail(String email);

    List<UserEntity> findByNameContains(String name);
}
