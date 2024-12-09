package com.zero.sqlserver.controller;

import com.zero.sqlserver.domain.entity.SystemUserEntity;
import com.zero.sqlserver.service.SystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class SystemUserController {

    private final SystemUserService systemUserService;

    @Autowired
    public SystemUserController(SystemUserService systemUserService) {
        this.systemUserService = systemUserService;
    }

    @GetMapping
    public List<SystemUserEntity> getAllEmployees() {
        return systemUserService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SystemUserEntity> getEmployeeById(@PathVariable Integer id) {
        return systemUserService.getEmployeeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public SystemUserEntity addEmployee(@RequestBody SystemUserEntity systemUserEntity) {
        return systemUserService.addEmployee(systemUserEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SystemUserEntity> updateEmployee(@PathVariable Integer id, @RequestBody SystemUserEntity systemUserEntityDetails) {
        return ResponseEntity.ok(systemUserService.updateEmployee(id, systemUserEntityDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id) {
        systemUserService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}