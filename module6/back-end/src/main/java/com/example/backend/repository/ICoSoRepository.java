package com.example.backend.repository;

import com.example.backend.dto.ICoSoDTO;
import com.example.backend.model.CoSo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface ICoSoRepository extends JpaRepository<CoSo, Integer> {


    @Query(value = "select * from co_so where flag_delete = true", nativeQuery = true)
    List<CoSo> getAll();

    @Modifying
    @Query(value = "update co_so set flag_delete = false where id = :id", nativeQuery = true)
    void deleteId(@Param("id") Integer id);


    @Query(value = "select * from co_so where id =:id", nativeQuery = true)
    CoSo findId(Integer id);

    @Query(value = " select co_so.name as coSoName,co_so.address as coSoAddress, co_so.date_open as coSoDateOpen,co_so.person as coSoPerson from co_so" +
            " where co_so.name like concat('%',:coSoName,'%') and co_so.person like concat('%',:coSoPerson,'%')", nativeQuery = true)
    List<ICoSoDTO> search(@Param("coSoName") String coSoName,
                          @Param("coSoPerson") String coSoPerson);

    @Modifying
    @Query(value = "insert into exam6.co_so (address, date_open, name, person)" +
            "VALUES (:address, :dateOpen, :name, :person, :flagDelete)", nativeQuery = true)
    void createCoSo(@Param("address") String address,
                    @Param("dateOpen") String dateOpen,
                    @Param("name") String name,
                    @Param("person") String person);
}
