package cn.pzhu.spring.repository;

import cn.pzhu.spring.domain.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskEntityRepository extends JpaRepository<TaskEntity, Long> {
}
