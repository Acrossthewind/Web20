package cn.edu.ctbu.mybatis;

import cn.edu.ctbu.mybatis.mapper.QuestionMapper;
import cn.edu.ctbu.mybatis.mapper.UserMapper;
import cn.edu.ctbu.mybatis.pojo.Question;
import cn.edu.ctbu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author 周肆淋
 * @version 1.0
 * @description: TODO
 * @date 2023/5/5 19:03
 */
public class TestQuestionMapper {
    @Test
    public void testFindAll(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        QuestionMapper mapper = sqlSession.getMapper(QuestionMapper.class);
        List<Question> list = mapper.findAllQuestions();
        System.out.println(list);
    }

    @Test
    public void testFindQuestionById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        QuestionMapper mapper = sqlSession.getMapper(QuestionMapper.class);
        Question question = mapper.getQuestionById(1);
        System.out.println(question.getQuestion());
        System.out.println(question.getRight_answer());
    }
}
