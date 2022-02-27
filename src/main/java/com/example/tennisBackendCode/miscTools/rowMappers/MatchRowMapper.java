package com.example.tennisBackendCode.miscTools.rowMappers;

import com.example.tennisBackendCode.model.Match;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MatchRowMapper implements RowMapper<Match> {
    @Override
    public Match mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Match(
                rs.getDate("tourney_date"),
                rs.getString("tourney_name"),
                rs.getString("surface"),
                rs.getString("round"),
                rs.getString("winner_name"),
                rs.getShort("winner_rank"),
                rs.getString("loser_name"),
                rs.getShort("loser_rank"),
                rs.getString("score")
        );
    }
}
