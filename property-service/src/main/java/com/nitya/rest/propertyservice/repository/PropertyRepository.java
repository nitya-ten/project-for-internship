package com.nitya.rest.propertyservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nitya.rest.propertyservice.entity.Property;

import jakarta.transaction.Transactional;

@Transactional
@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer>{

	Optional<Property> findByUserId(Integer userId);

	void deleteByUserId(Integer userId);

	List<Property> findAllByUserId(Integer userId);

	void deleteAllByUserId(Integer userId);

}
