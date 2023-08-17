package cn.edu.ctbu.servlet;

import cn.edu.ctbu.mybatis.mapper.ScoreMapper;
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
import java.util.Map;

/**
 * @author 周肆淋
 * @version 1.0
 * @description: TODO
 * @date 2023/5/7 9:24
 */

@WebServlet("/score")
public class ScoreServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession();
        String scoreStr = req.getParameter("score");
        Object usernameObj = session.getAttribute("username");
        String username = String.valueOf(usernameObj);

        Object idObj = session.getAttribute("id");
        String idStr = String.valueOf(idObj);
        int id = Integer.parseInt(idStr);
        int score = Integer.parseInt(scoreStr);

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        ScoreMapper mapper = sqlSession.getMapper(ScoreMapper.class);
       mapper.insert(username, score, id);


        Map<String,String> map=new HashMap<String,String>();
        String msg="insert successfully";
        map.put("msg",msg);

        Gson gson = new Gson();
        String s = gson.toJson(map);
        resp.getWriter().print(s);



    }
}
