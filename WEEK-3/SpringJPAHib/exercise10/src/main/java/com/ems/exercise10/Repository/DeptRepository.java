package com.ems.exercise10.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ems.exercise10.Entity.Department;
import com.ems.exercise10.Projections.DepartmentDTO;

public interface DeptRepository extends JpaRepository<Department,Long> {
    @Query(name="Department.findByName")
    Optional<Department> findByName(String name);
   @SuppressWarnings("null")
    Optional<Department> findById(Long id);
    
    @Query("SELECT new com.example.DepartmentDTO(d.name, SIZE(d.employees)) FROM Department d")
    List<DepartmentDTO> findAllDepartmentDTOs();
}