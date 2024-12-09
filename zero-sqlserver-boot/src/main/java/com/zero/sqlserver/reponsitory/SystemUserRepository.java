package com.zero.sqlserver.reponsitory;

import com.zero.sqlserver.domain.entity.SystemUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemUserRepository extends JpaRepository<SystemUserEntity, Integer> {

}