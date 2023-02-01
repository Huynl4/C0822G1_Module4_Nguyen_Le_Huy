package com.example.phim.repository;

import com.example.phim.model.Chieu;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IChieuRepository extends JpaRepository<Chieu, Long> {
    @Query(value = "select c.* from `chieu` c join `phim` p on p.id = c.phim_id where c.code like concat('%',:code,'%') and c.date like concat('%',:date,'%') and p.name like concat('%',:name,'%') and c.flag_delete= true", nativeQuery = true)
    Page<Chieu> search(Pageable pageable, @Param("code") String code, @Param("date") String date, @Param("name") String name);

}
