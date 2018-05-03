package cn.pzhu.spring.repository;

import cn.pzhu.spring.domain.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

public interface AccountEntityRepository extends JpaRepository<AccountEntity, String> {
    AccountEntity findAccountEntitiesByAccountName(String accountName);
    List<AccountEntity> findByUserEntityId(String id);
}
