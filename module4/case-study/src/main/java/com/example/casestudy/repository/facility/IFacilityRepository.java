package com.example.casestudy.repository.facility;

import com.example.casestudy.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFacilityRepository extends JpaRepository<Facility, Long> {
    @Query(value = "SELECT * FROM `furama`.facility where name like %:name% and facility_type_id like %:facilityTypeId% and facility.flag_delete = true", nativeQuery = true)
    Page<Facility> search(Pageable pageable, @Param("name") String name, @Param("facilityTypeId") String facilityTypeId);
}
