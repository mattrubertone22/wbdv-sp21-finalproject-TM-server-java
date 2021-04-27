package com.example.repositories;

import com.example.models.Match;
import com.example.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MatchRepository extends CrudRepository<Match, Long> {
    @Query("select match FROM Match match WHERE match.teamId=:teamId")
    public List<Match> findCommentByTeamId(@Param("teamId") Long teamId);

    @Query("select match FROM Match match WHERE match.uid=:uid")
    public List<Match> findCommentByUserId(@Param("uid") Long uid);

    @Query("SELECT match FROM Match match")
    public List<Match> findAllMatch();

}
