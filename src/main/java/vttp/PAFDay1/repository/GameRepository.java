package vttp.PAFDay1.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp.PAFDay1.model.Comment;
import vttp.PAFDay1.model.Game;

@Repository
public class GameRepository {
    @Autowired
    private JdbcTemplate template;

    public Optional<Game> getGameByGid(Integer gid) {
        final SqlRowSet result = template.queryForRowSet(
            Queries.SQL_SELECT_GAME_BY_GID, gid
        );

        if (!result.next()) {
            return Optional.empty();
        }
        
        Game g = Game.create(result);
        
        return Optional.of(g);
    }

    public List<Comment> getCommentsByGid(Integer gid, Integer limit, Integer offset) {
        final SqlRowSet result = template.queryForRowSet(
            Queries.SQL_SELECT_COMMENT_BY_GID, gid, limit, offset
        );

        if (!result.next()) {
            return List.of();
        }

        List<Comment> commentList = Comment.generateList(result);

        return commentList;
    }
}
