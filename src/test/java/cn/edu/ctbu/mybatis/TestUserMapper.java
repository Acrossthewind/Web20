package cn.edu.ctbu.mybatis;

import cn.edu.ctbu.mybatis.mapper.AdminMapper;
import cn.edu.ctbu.mybatis.mapper.UserMapper;
import cn.edu.ctbu.mybatis.pojo.Admin;
import cn.edu.ctbu.mybatis.pojo.User;
import cn.edu.ctbu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author 周肆淋
 * @version 1.0
 * @description: TODO
 * @date 2023/5/4 9:50
 */
public class TestUserMapper {
    @Test
    public void testGetUserByUsername(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserByUsername("zsl");
        System.out.println(user);
    }

    @Test
    public void testCheckLogin(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.checkLogin("zsl", "226226");
        System.out.println(user);
    }

    @Test
    public void testGetUserByUsername1(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        Admin admin = mapper.getUserByUsername("admin");
        System.out.println(admin);


    }

    @Test
    public void testCheckLogin1(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        AdminMapper mapper = sqlSession.getMapper(AdminMapper.class);
        Admin admin = mapper.checkLogin("admin", "123456");
        System.out.println(admin);

    }

    @Test
    public void testInsert(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.insert("ztz", "123456");
        System.out.println(i);
    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.update(2, "123654");
        System.out.println(i);
    }


}
