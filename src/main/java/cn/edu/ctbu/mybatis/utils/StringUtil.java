package cn.edu.ctbu.mybatis.utils;

/**
 * @author 周肆淋
 * @version 1.0
 * @description: TODO
 * @date 2023/5/9 14:46
 */


public class StringUtil {

    /**
     * 用于用户名验证 必须是6-10位字母、数字、下划线（这里字母、数字、下划线是指任意组合，没有必须三类均包含）
     * 不能以数字开头
     * @param name
     * @return
     */
    public static boolean checkName(String name) {
        String regExp = "^[^0-9][\\w_]{5,9}$";
        if(name.matches(regExp)) {
            return true;
        }else {
            return false;
        }
    }


    /**
     * 密码验证 至少8个字符，至少1个大写字母，1个小写字母和1个数字,不能包含特殊字符（非数字字母）
     *  @param pwd
     *  @return
     */
    public static boolean checkPwd(String pwd) {
        String regExp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
        if (pwd.matches(regExp)) {
            return true;
        }
        return false;
    }

}
