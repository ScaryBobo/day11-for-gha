package vttp.PAFDay1;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import vttp.PAFDay1.model.Comment;
import vttp.PAFDay1.model.Game;
import vttp.PAFDay1.repository.GameRepository;

@SpringBootTest
class PafDay1ApplicationTests {
	@Autowired
	private GameRepository gameRepo;

	@Test
	void shouldReturnAGame() {
		Optional<Game> opt = gameRepo.getGameByGid(10);
		Assertions.assertTrue(opt.isPresent());
	}

	@Test
	void shouldReturnEmpty() {
		Optional<Game> opt = gameRepo.getGameByGid(99999);
		Assertions.assertFalse(opt.isPresent(), "gid = 99999");
	}

	@Test
	void shouldReturnCommentsList() {
		List<Comment> testCommentList = gameRepo.getCommentsByGid(10, 0, 0);
		Assertions.assertFalse(testCommentList.isEmpty());
	}

	@Test
	void shouldReturnEmptyCommentsList() {
		List<Comment> testCommentList = gameRepo.getCommentsByGid(99999, 10, 10);
		Assertions.assertTrue(testCommentList.isEmpty());
	}
}
