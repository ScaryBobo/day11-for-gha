package vttp.PAFDay1.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Game {
    private Integer gid;
    private String name;
    private Integer year;
    private Integer ranking;
    private Integer users_rated;
    private String url;
    private String image;

    public Integer getGid() {
        return gid;
    }
    public void setGid(Integer gid) {
        this.gid = gid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    public Integer getRanking() {
        return ranking;
    }
    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }
    public Integer getUsers_rated() {
        return users_rated;
    }
    public void setUsers_rated(Integer users_rated) {
        this.users_rated = users_rated;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public static Game create(SqlRowSet rs) {
        Game g = new Game();
        g.setGid(rs.getInt("gid"));
        g.setName(rs.getString("name"));
        g.setYear(rs.getInt("year"));
        g.setRanking(rs.getInt("ranking"));
        g.setUsers_rated(rs.getInt("users_rated"));
        g.setUrl(rs.getString("url"));
        g.setImage(rs.getString("image"));

        return g;
    }
}
