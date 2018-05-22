package cn.pzhu.spring.service;

import cn.pzhu.spring.domain.TaskEntity;
import cn.pzhu.spring.domain.UserEntity;
import cn.pzhu.spring.repository.TaskEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskEntityRepository taskEntityRepository;

    public void addTask(TaskEntity taskEntity, UserEntity userEntity) {
        taskEntity.setUserEntity(userEntity);
        taskEntityRepository.save(taskEntity);
    }

    public List<TaskEntity> findUserTask(UserEntity userEntity) {
        return taskEntityRepository.findByUserEntity(userEntity);
    }
}
