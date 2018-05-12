package cn.pzhu.spring.repository;

import cn.pzhu.spring.domain.LessonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonEntityRepository extends JpaRepository<LessonEntity, String> {
}
