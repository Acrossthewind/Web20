package cn.edu.ctbu.servlet;

import cn.edu.ctbu.mybatis.mapper.UserMapper;
import cn.edu.ctbu.mybatis.pojo.User;
import cn.edu.ctbu.mybatis.utils.SqlSessionUtil;
import cn.edu.ctbu.servlet.mybase.BaseUpdateServlet;
import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 周肆淋
 * @version 1.0
 * @description: TODO
 * @date 2023/5/4 21:43
 */

@WebServlet("/update")
public class UpdateServlet extends BaseUpdateServlet {

    @ResponseBody
    public void update(HttpServletRequest req, HttpServletResponse resp,String username,
                       String password,String newPassword,String newPasswordAgain) throws IOException {

        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserByUsername(username);

        User checkLogin = mapper.checkLogin(username, password);

        if(user!=null){
            if(checkLogin!=null){
                if(newPassword.equals(newPasswordAgain)){
                    mapper.update(checkLogin.getId(),newPassword);
                    resp.getWriter().write("密码修改成功，请返回登录");
                }
                else{
                    resp.getWriter().write("两次密码不一致，请检查");
                }
            }else{
                resp.getWriter().write("用户名或密码错误，请检查");
            }

        }else{
            resp.getWriter().write("用户名不存在，请注册");
        }


    }


}
