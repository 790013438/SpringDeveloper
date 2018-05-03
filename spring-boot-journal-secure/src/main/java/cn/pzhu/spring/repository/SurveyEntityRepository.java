package cn.pzhu.spring.repository;

import cn.pzhu.spring.domain.SurveyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
@RepositoryRestResource(collectionResourceRel = "surveyEntity", path="university")
public interface SurveyEntityRepository extends JpaRepository<SurveyEntity, Long> {
}
