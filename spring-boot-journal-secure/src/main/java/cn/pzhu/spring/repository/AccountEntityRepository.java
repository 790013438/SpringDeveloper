package cn.pzhu.spring.repository;

import cn.pzhu.spring.domain.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(exported = false)
public interface AccountEntityRepository extends JpaRepository<AccountEntity, String> {
    AccountEntity findAccountEntitiesByAccountName(String accountName);
    List<AccountEntity> findByUserEntityId(String id);
}
