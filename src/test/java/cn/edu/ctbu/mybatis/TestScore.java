package cn.edu.ctbu.mybatis;

import cn.edu.ctbu.mybatis.mapper.ScoreMapper;
import cn.edu.ctbu.mybatis.mapper.UserMapper;
import cn.edu.ctbu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author 周肆淋
 * @version 1.0
 * @description: TODO
 * @date 2023/5/6 21:38
 */
public class TestScore {

    @Test
    public void testInsert(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        ScoreMapper mapper = sqlSession.getMapper(ScoreMapper.class);
        int i = mapper.insert("zzz", 150,1);
        System.out.println(i);

    }
}
