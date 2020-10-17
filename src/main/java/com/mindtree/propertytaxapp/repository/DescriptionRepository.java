package com.mindtree.propertytaxapp.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.propertytaxapp.entity.Description;


/**
 * @author M1056078
 *
 */
@Repository
public interface DescriptionRepository extends JpaRepository<Description, Integer> {

	
	@Transactional
	@Query("select d from Description d")
	List<Description> getAllDescriptions();
	
}
