package com.mindtree.propertytaxapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.propertytaxapp.entity.Property;

/**
 * @author M1056078
 *
 */
@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {

}
