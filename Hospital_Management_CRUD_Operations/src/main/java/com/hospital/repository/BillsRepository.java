package com.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.model.Bill;

public interface BillsRepository extends JpaRepository<Bill, Long>{

}
