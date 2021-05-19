package com.sandwich.core.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sandwich.core.app.model.Detail;

public interface DetailsRepository extends JpaRepository<Detail, Long> {

}
