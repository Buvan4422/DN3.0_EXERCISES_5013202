package com.ems.exercise9.Projections;

import org.springframework.beans.factory.annotation.Value;

public interface DepartmentProjection {
    
    // Projection of specific fields
    @Value("#{target.name} #{target.employees.size()}")
    String getDepartmentSummary();

    String getName();
}

