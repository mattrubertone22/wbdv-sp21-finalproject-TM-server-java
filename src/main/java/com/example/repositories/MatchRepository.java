package com.example.repositories;

import com.example.models.Match;
import com.example.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MatchRepository extends CrudRepository<Match, Long> {
    @Query("select match FROM Match match WHERE match.matchId=:matchId")
    public Match findCommentByMatchId(@Param("matchId") String matchId);

    @Query("select match FROM Match match WHERE match.userId=:userId")
    public Match findCommentByUserId(@Param("userId") Long userId);

    @Query("SELECT match FROM Match match")
    public List<Match> findAllMatch();

}
