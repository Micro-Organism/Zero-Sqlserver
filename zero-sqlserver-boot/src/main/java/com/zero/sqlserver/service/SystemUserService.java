package com.zero.sqlserver.service;

import com.zero.sqlserver.domain.entity.SystemUserEntity;

import java.util.List;
import java.util.Optional;

public interface SystemUserService {

    List<SystemUserEntity> getAllEmployees();

    Optional<SystemUserEntity> getEmployeeById(Integer id);

    SystemUserEntity addEmployee(SystemUserEntity systemUserEntity);

    SystemUserEntity updateEmployee(Integer id, SystemUserEntity systemUserEntityDetails);

    void deleteEmployee(Integer id);
}