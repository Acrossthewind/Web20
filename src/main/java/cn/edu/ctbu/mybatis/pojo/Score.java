package cn.edu.ctbu.mybatis.pojo;

/**
 * @author 周肆淋
 * @version 1.0
 * @description: TODO
 * @date 2023/5/6 21:32
 */
public class Score {
    private Integer id;
    private String username;
    private Integer score;

    public Score() {
    }

    public Score(Integer id, String username, Integer score) {
        this.id = id;
        this.username = username;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Integer getScore() {
        return score;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", score=" + score +
                '}';
    }
}
