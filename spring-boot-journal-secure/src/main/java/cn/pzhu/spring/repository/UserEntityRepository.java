package cn.pzhu.spring.repository;

import cn.pzhu.spring.domain.UserEntity;
import cn.pzhu.spring.domain.enumerate.RoleEnum;
import cn.pzhu.spring.repository.view.AppView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;

@Transactional
public interface UserEntityRepository extends JpaRepository<UserEntity, String> {

    UserEntity findByEmail(String email);

    UserEntity findByConfirmationToken(String token);

    @Query("select o.appName as appName, o.appLink as appLink, o.appImage as appImage " +
            " from UserAppEntity o where o.role = ?1 and o.appName LIKE ?2")
    Page<AppView> getApp(RoleEnum role, String appName, Pageable pageable);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update UserEntity set outDate=:outDate, confirmationToken=:validateCode " +
            " where email=:email")
    int setOutDateAndValidateCode(@Param("outDate") Date outDate,
                                  @Param("validateCode") String validateCode,
                                  @Param("email") String email);
}
