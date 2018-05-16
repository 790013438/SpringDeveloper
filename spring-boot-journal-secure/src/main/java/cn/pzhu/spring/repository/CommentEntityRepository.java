package cn.pzhu.spring.repository;

import cn.pzhu.spring.domain.CommentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentEntityRepository extends JpaRepository<CommentEntity, String> {
    Page<CommentEntity> findAllByOrderByCreatedDate(Pageable pageable);
}
