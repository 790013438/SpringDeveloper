package cn.pzhu.spring.repository;

import cn.pzhu.spring.domain.TaskEntity;
import cn.pzhu.spring.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskEntityRepository extends JpaRepository<TaskEntity, Long> {

    List<TaskEntity> findByUserEntity(UserEntity userEntity);
}
