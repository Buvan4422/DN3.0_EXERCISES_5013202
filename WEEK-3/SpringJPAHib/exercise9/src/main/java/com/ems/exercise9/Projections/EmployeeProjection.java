package com.ems.exercise9.Projections;

import org.springframework.beans.factory.annotation.Value;

public interface EmployeeProjection {
    
    // Projection of specific fields
    @Value("#{target.name} #{target.email}")
    String getEmployeeDetails();

    String getName();
    String getEmail();
}
