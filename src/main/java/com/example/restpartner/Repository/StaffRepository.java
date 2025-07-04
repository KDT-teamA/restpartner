package com.example.restpartner.Repository;

import com.example.restpartner.Entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<StaffEntity, Integer> {
}
