package com.example.casestudy.repository.contract;

import com.example.casestudy.dto.AttachFacilityDto;
import com.example.casestudy.model.contract.AttachFacility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAttachFacilityRepository extends JpaRepository<AttachFacility, Long> {
    @Query(value = "select af.id, f.name as facilityName, " +
            "af.cost as cost, " +
            "sum(cd.quantity) " +
            "as totalQuantity, (af.cost * sum(cd.quantity)) " +
            "as totalMoney " +
            "from contract " +
            "join facility f " +
            "on f.id = contract.facility_id " +
            "join contract_detail cd " +
            "on contract.id = cd.contract_id " +
            "join attach_facility af " +
            "on af.id = cd.attach_facility_id " +
            "where contract.id=:id " +
            "group by af.id, contract.id", nativeQuery = true)
    List<AttachFacilityDto> findAllAttach(@Param("id") Long id);
}
