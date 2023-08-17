package cn.edu.ctbu.servlet;

import cn.edu.ctbu.mybatis.mapper.UserMapper;
import cn.edu.ctbu.mybatis.pojo.User;
import cn.edu.ctbu.mybatis.utils.SqlSessionUtil;
import cn.edu.ctbu.mybatis.utils.StringUtil;
import cn.edu.ctbu.servlet.mybase.BaseInsertServlet;
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

@WebServlet("/insert")
public class InsertServlet extends BaseInsertServlet {

    @ResponseBody
    public void insertUser(HttpServletRequest req, HttpServletResponse resp,String username,String password,String passwordAgain) throws IOException {


        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserByUsername(username);


        //1.检查username是否符合规范
        if(StringUtil.checkName(username)){
            //2.判断是否已经存在该用户
            if(user==null){
                //3.判断password是否符合规范
                if(StringUtil.checkPwd(password)){
                    //4.判断两次密码是否一致
                    if(password.equals(passwordAgain)){
                        mapper.insert(username, password);
                        /*System.out.println("注册成功，请返回登录");*/
                        resp.getWriter().write("注册成功，请返回登录");
                    }
                    //两次密码不一致，提示对比两次密码
                    else{
                        /*System.out.println("两次密码不一致，请确认");*/
                        resp.getWriter().write("两次密码不一致，请确认");

                    }
                }
                //密码格式错误，提示修改密码
                else{
                    resp.getWriter().write("密码格式错误");
                }
            }
            //用户名已存在，提示修改用户名
            else{
                /*System.out.println("用户名已存在，请更换");*/
                resp.getWriter().write("用户名已存在，请更换");
            }
        //格式不对，提示格式错误
        }
        else{
            resp.getWriter().write("用户名格式错误");
        }




    }
}
