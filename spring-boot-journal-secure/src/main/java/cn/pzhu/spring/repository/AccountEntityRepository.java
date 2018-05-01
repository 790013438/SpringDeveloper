package cn.pzhu.spring.repository;

import cn.pzhu.spring.domain.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountEntityRepository extends JpaRepository<AccountEntity, String> {
    AccountEntity findAccountEntitiesByAccountName(String accountName);
}
