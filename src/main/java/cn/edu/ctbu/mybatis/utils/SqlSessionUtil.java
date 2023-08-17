package cn.edu.ctbu.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 周肆淋
 * @version 1.0
 * @description: 获取SqlSession
 * @date 2023/4/28 15:53
 */
public class SqlSessionUtil {

    public static SqlSession getSqlSession(){
        SqlSession sqlSession=null;
        try {
            //获取配置文件输入流
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //获取SQLSessionFactoryBuilder
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
            //获取SQLSessionFactory
            SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(is);
            //获取SqlSession
            sqlSession = sessionFactory.openSession(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sqlSession;
    }
}
