package vttp.PAFDay1.repository;

public class Queries {
    public static final String SQL_SELECT_GAME_BY_GID = "SELECT * FROM game WHERE gid = ?";

    public static final String SQL_SELECT_COMMENT_BY_GID = "SELECT * FROM comment WHERE gid = ? LIMIT ? OFFSET ?";
}
