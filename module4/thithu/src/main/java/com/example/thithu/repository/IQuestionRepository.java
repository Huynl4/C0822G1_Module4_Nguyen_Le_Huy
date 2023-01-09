package com.example.thithu.repository;

import com.example.thithu.dto.IQuestionDto;
import com.example.thithu.dto.QuestionDto;
import com.example.thithu.model.QuestionContent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IQuestionRepository extends JpaRepository<QuestionContent, Long> {
    @Query(value = "select * from question_content where title like concat('%', :title, '%') and question_type_id = :questionTypeId and question_content.flag_delete = true", nativeQuery = true)
    Page<QuestionContent> search(Pageable pageable, @Param("title") String title, @Param("questionTypeId") Integer questionTypeId);

    @Query(value = "select * from question_content where title like concat('%', :title, '%') and flag_delete = true ",nativeQuery = true)
    Page<QuestionContent> showList(@Param("title") String title, Pageable pageable);


    @Query(value = "select qc.id, qc.answer as answer, " +
            "qc.content as content," +
            "qc.date as `date`," +
            "qc.status as status," +
            "qc.title as title," +
            "qt.name as name " +
            "from `question_content` qc " +
            "join `question_type` qt " +
            "on qc.question_type_id = qt.id " +
            "where qc.id = :id and qc.flag_delete = true ",nativeQuery = true)
    List<IQuestionDto> findAllQuestion(@Param("id") Long id);
}
