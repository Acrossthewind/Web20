package cn.edu.ctbu.servlet;

import cn.edu.ctbu.mybatis.mapper.QuestionMapper;
import cn.edu.ctbu.mybatis.pojo.Question;
import cn.edu.ctbu.mybatis.utils.SqlSessionUtil;
import com.google.gson.Gson;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 周肆淋
 * @version 1.0
 * @description: TODO
 * @date 2023/5/6 15:36
 */

@WebServlet("/comp")
public class ComputeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        //获取总题目数
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        QuestionMapper mapper = sqlSession.getMapper(QuestionMapper.class);
        List<Question> lists = mapper.findAllQuestions();
        int size = lists.size();

        //答题数、成绩、正确率
        int count=0; int score=0;
        String msgSuccess="";
        String msgError="";

        //循环对比答案
        for (int i = 1; i <= size; i++) {
            Question question = mapper.getQuestionById(i);
            String questionStr = question.getQuestion();
            String right_answer = question.getRight_answer();
            String myAnswers = req.getParameter(String.valueOf(i));
            if(myAnswers!=null){
                count++;
                if (right_answer.equals(myAnswers)){
                    msgSuccess+=i+",";
                    score=score+10;
                }
                else{
                    msgError+=i+",";
                }
            }

        }
        float accuracy=(float) score/(float) count*10;

        Map<String,String> map = new HashMap<String,String>();
        map.put("msgSuccess", msgSuccess);
        map.put("msgError", msgError);
        map.put("count", String.valueOf(count));
        map.put("score", String.valueOf(score));
        map.put("accuracy", String.format("%.2f",accuracy));

        Gson gson = new Gson();
        String s = gson.toJson(map);
        resp.getWriter().print(s);







    }
}
