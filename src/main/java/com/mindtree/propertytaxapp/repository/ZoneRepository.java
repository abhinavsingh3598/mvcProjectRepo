package com.mindtree.propertytaxapp.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.mindtree.propertytaxapp.entity.Zone;
@Repository
public interface ZoneRepository extends JpaRepository<Zone, Integer> {

	@Transactional
	@Query("select z from Zone z")
	List<Zone> getAllZones();
	
}
