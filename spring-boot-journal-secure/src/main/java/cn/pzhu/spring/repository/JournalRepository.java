package cn.pzhu.spring.repository;

import cn.pzhu.spring.domain.JournalEntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.format.annotation.DateTimeFormat;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Transactional
@RepositoryRestResource(collectionResourceRel = "entry", path="journal")
public interface JournalRepository extends JpaRepository<JournalEntryEntity, Long> {

    List<JournalEntryEntity> findByCreatedAfter(@Param("after") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)Date date);
    List<JournalEntryEntity> findByCreatedBetween(@Param("after") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)Date after, @Param("before") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date before);
    List<JournalEntryEntity> findByTitleContaining(@Param("word") String word);
    List<JournalEntryEntity> findBySummaryContaining(@Param("word") String word);


}
