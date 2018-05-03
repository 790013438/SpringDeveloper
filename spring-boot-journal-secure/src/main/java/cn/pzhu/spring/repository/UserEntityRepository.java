package cn.pzhu.spring.repository;

import cn.pzhu.spring.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import javax.transaction.Transactional;

@Transactional
@RepositoryRestResource(collectionResourceRel = "userEntity", path="university")
public interface UserEntityRepository extends JpaRepository<UserEntity, String>{

    UserEntity findByEmail(String email);

    UserEntity findByConfirmationToken(String token);
}
