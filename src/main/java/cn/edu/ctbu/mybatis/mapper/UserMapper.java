package cn.edu.ctbu.mybatis.mapper;

import cn.edu.ctbu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {


    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    User getUserByUsername(@Param("username") String username);

    /**
     * 根据用户名和密码查询是否存在该用户
     * @param username
     * @param password
     */
    User checkLogin(@Param("username") String username, @Param("password") String password);

    /**
     * 添加用户
     * @param
     * @return
     */
    int insert(@Param("username") String username, @Param("password") String password);

    /**
     * 修改用户
     * @param
     * @return
     */
    int update(@Param("id") Integer id, @Param("password") String password);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int delete(Integer id);
}
