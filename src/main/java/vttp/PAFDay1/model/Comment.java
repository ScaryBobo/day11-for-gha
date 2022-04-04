package vttp.PAFDay1.model;

import java.util.LinkedList;
import java.util.List;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public class Comment {
    private String cid;
    private String user;
    private Integer rating;
    private String text;
    private Integer gid;

    public String getCid() {
        return cid;
    }
    public void setCid(String cid) {
        this.cid = cid;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public Integer getRating() {
        return rating;
    }
    public void setRating(Integer rating) {
        this.rating = rating;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public Integer getGid() {
        return gid;
    }
    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public static List<Comment> generateList(SqlRowSet rs) {
        List<Comment> commentList = new LinkedList<Comment>();
        
        while (rs.next()) {
            Comment c = new Comment();
            c.setCid(rs.getString("c_id"));
            c.setUser(rs.getString("user"));
            c.setRating(rs.getInt("rating"));
            c.setText(rs.getString("c_text"));
            c.setGid(rs.getInt("gid"));

            commentList.add(c);
        }

        return commentList;
    }
}
