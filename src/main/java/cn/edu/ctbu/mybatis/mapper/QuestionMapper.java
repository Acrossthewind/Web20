package cn.edu.ctbu.mybatis.mapper;

import cn.edu.ctbu.mybatis.pojo.Question;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QuestionMapper {
    /**
     * 查询所有题目
     * @return List<Question>
     */
    List<Question> findAllQuestions();

    /**
     * 根据id查询到问题
     * @param id
     * @return
     */
    Question getQuestionById(@Param("id") Integer id);
}
