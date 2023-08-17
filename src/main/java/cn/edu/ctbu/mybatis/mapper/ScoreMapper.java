package cn.edu.ctbu.mybatis.mapper;

import cn.edu.ctbu.mybatis.pojo.Score;
import org.apache.ibatis.annotations.Param;

public interface ScoreMapper {

    /**
     * 插入成绩
     * @param username
     * @param score
     * @return
     */
    int insert(@Param("username") String username, @Param("score") Integer score,@Param("id") Integer id);
}
