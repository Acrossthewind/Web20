package cn.edu.ctbu.mybatis.mapper;

import cn.edu.ctbu.mybatis.pojo.Admin;
import cn.edu.ctbu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    /**
     * 根据用户名查询用户
     *
     * @param username
     * @return
     */
    Admin getUserByUsername(@Param("username") String username);

    /**
     * 根据用户名和密码查询是否存在该用户
     *
     * @param username
     * @param password
     */
    Admin checkLogin(@Param("username") String username, @Param("password") String password);

}