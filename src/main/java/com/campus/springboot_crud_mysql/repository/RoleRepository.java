package com.campus.springboot_crud_mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campus.springboot_crud_mysql.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
