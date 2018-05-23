package cn.pzhu.spring.service;

import cn.pzhu.spring.domain.RoleEntity;
import cn.pzhu.spring.domain.RoleEnumerated;
import cn.pzhu.spring.domain.UserEntity;
import cn.pzhu.spring.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserEntityRepository userEntityRepository;

    public void createUser(UserEntity userEntity) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        userEntity.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));

        RoleEntity roleEntity = new RoleEntity(RoleEnumerated.USER);
        List<RoleEntity> roleEntityList = new ArrayList<>();
        roleEntityList.add(roleEntity);

        userEntity.setRoles(roleEntityList);
        userEntityRepository.save(userEntity);
    }

    public void createAdmin(UserEntity userEntity) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        userEntity.setPassword(bCryptPasswordEncoder.encode(userEntity.getPassword()));

        RoleEntity roleEntity = new RoleEntity(RoleEnumerated.ADMIN);
        List<RoleEntity> roleEntityList = new ArrayList<>();
        roleEntityList.add(roleEntity);

        userEntity.setRoles(roleEntityList);
        userEntityRepository.save(userEntity);
    }

    public UserEntity findOne(String email) {
        return userEntityRepository.findByEmail(email);
    }

    public boolean isUserPresent(String email) {
      UserEntity userEntity = userEntityRepository.findByEmail(email);
        return userEntity != null;
    }
}
