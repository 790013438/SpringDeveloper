package cn.pzhu.spring.repository;

import cn.pzhu.spring.domain.SurveyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "surveyEntity", path="pzhu")
public interface SurveyEntityRepository extends JpaRepository<SurveyEntity, Long> {
}
