package com.zero.sqlserver.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "Employees")
@Data
public class SystemUserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeID;

    private String firstName;
    private String lastName;
    private Date birthDate;
    private Date hireDate;
    private String position;


}