package cn.pzhu.spring.repository;

import cn.pzhu.spring.domain.SurveyDirectoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "t_survey_directory", path="dwsurvey")
public interface SurveyDirectoryRepository extends JpaRepository<SurveyDirectoryEntity, Long> {
}
