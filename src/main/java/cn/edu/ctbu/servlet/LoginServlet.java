package cn.edu.ctbu.servlet;

import cn.edu.ctbu.mybatis.mapper.AdminMapper;
import cn.edu.ctbu.mybatis.mapper.UserMapper;
import cn.edu.ctbu.mybatis.pojo.Admin;
import cn.edu.ctbu.mybatis.pojo.User;
import cn.edu.ctbu.mybatis.utils.SqlSessionUtil;
import cn.edu.ctbu.servlet.mybase.ViewBaseServlet;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 周肆淋
 * @version 1.0
 * @description: TODO
 * @date 2023/5/4 15:31
 */
@WebServlet("/login")
public class LoginServlet extends ViewBaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        super.processTemplate("Login",req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        //获取username、password、choose
        String username = req.getParameter("username");
        String passwordStr = req.getParameter("password");
        String choose = req.getParameter("choose");


        //测试是否存在该用户，存在则通过
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        HttpSession session = req.getSession();

        //若为student
        if (choose.equals("student")){
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.getUserByUsername(username);
            if(user != null){
                User loginUser = mapper.checkLogin(username, passwordStr);
                if(loginUser!=null){
                    session.setAttribute("username", loginUser.getUsername());
                    session.setAttribute("id", loginUser.getId());
                    super.processTemplate("Student",req,resp);
                }
                else{
                    session.setAttribute("msg","密码或者用户名错误");
                    super.processTemplate("Login",req,resp);
                }
            }else{
                session.setAttribute("msg","不存在该用户,请注册");
                super.processTemplate("Login",req,resp);
            }
        }
        //若为teacher
        else if(choose.equals("teacher")){
            AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
            Admin admin = mapper.getUserByUsername(username);
            if(admin != null){
                Admin admin1 = mapper.checkLogin(username, passwordStr);
                if(admin1!=null){
                    req.getRequestDispatcher("Student.html").forward(req,resp);
                }
                else{
                    session.setAttribute("msg","管理员密码或者用户名错误");
                    super.processTemplate("Login",req,resp);
                }
            }else{
                session.setAttribute("msg","不存在该管理员");
                super.processTemplate("Login",req,resp);
            }


        }

    }
}
