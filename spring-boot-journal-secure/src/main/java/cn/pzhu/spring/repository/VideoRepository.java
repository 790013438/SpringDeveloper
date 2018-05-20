package cn.pzhu.spring.repository;

import cn.pzhu.spring.domain.VideoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<VideoEntity, String> {

    Page<VideoEntity> findByNameContains(String title, Pageable pageable);

    VideoEntity findFirstByName(String name);
}
