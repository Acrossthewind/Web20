package cn.edu.ctbu.servlet;

import cn.edu.ctbu.mybatis.mapper.QuestionMapper;
import cn.edu.ctbu.mybatis.pojo.Question;
import cn.edu.ctbu.mybatis.utils.SqlSessionUtil;
import cn.edu.ctbu.servlet.mybase.BaseQuestionServlet;
import cn.edu.ctbu.servlet.mybase.ViewBaseServlet;
import com.google.gson.Gson;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 周肆淋
 * @version 1.0
 * @description: TODO
 * @date 2023/5/5 19:12
 */


@WebServlet("/test")
public class QuestionServlet extends BaseQuestionServlet {

    @ResponseBody
    public void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        QuestionMapper mapper = sqlSession.getMapper(QuestionMapper.class);
        List<Question> lists = mapper.findAllQuestions();

        /*Map<String, Object> map = new HashMap<String, Object>();
        map.put("lists",lists );*/

        Collections.shuffle(lists);

        Gson gson = new Gson();
        String s = gson.toJson(lists);
        resp.getWriter().print(s);





    }
}
