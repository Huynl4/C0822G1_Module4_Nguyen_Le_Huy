package com.example.thithu1.repository;

import com.example.thithu1.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBookRepository extends JpaRepository<Book, Long> {
    @Query(value = "select b.* from `book` b join `book_type` bt on bt.id=b.book_type_id where b.title like concat('%', :title,'%') and bt.name like concat('%',:name,'%') and b.flag_delete= true ", nativeQuery = true)
    Page<Book> search(Pageable pageable, @Param("title") String title, @Param("name") String bookTypeId);

    @Query(value = "select * from book where title like concat('%', :title,'%') and flag_delete = true ",nativeQuery = true)
    Page<Book> showList(Pageable pageable, @Param("title") String title);
}
