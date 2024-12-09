package com.zero.sqlserver.service.impl;

import com.zero.sqlserver.domain.entity.SystemUserEntity;
import com.zero.sqlserver.reponsitory.SystemUserRepository;
import com.zero.sqlserver.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SystemUserServiceImpl implements SystemUserService {

    private final SystemUserRepository systemUserRepository;

    @Autowired
    public SystemUserServiceImpl(SystemUserRepository systemUserRepository) {
        this.systemUserRepository = systemUserRepository;
    }

    @Override
    public List<SystemUserEntity> getAllEmployees() {
        return systemUserRepository.findAll();
    }

    @Override
    public Optional<SystemUserEntity> getEmployeeById(Integer id) {
        return systemUserRepository.findById(id);
    }

    @Override
    public SystemUserEntity addEmployee(SystemUserEntity systemUserEntity) {
        return systemUserRepository.save(systemUserEntity);
    }

    @Override
    public SystemUserEntity updateEmployee(Integer id, SystemUserEntity systemUserEntityDetails) {
        SystemUserEntity systemUserEntity = systemUserRepository.findById(id).orElseThrow(RuntimeException::new);
        systemUserEntity.setFirstName(systemUserEntityDetails.getFirstName());
        systemUserEntity.setLastName(systemUserEntityDetails.getLastName());
        systemUserEntity.setBirthDate(systemUserEntityDetails.getBirthDate());
        systemUserEntity.setHireDate(systemUserEntityDetails.getHireDate());
        systemUserEntity.setPosition(systemUserEntityDetails.getPosition());
        return systemUserRepository.save(systemUserEntity);
    }

    @Override
    public void deleteEmployee(Integer id) {
        systemUserRepository.deleteById(id);
    }
}