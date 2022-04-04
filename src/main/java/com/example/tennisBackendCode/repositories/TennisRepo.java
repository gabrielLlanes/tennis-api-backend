package com.example.tennisBackendCode.repositories;

import com.example.tennisBackendCode.miscTools.rowMappers.DailyMatchRowMapper;
import com.example.tennisBackendCode.miscTools.rowMappers.MatchRowMapper;
import com.example.tennisBackendCode.miscTools.rowMappers.PlayerNameMapper;
import com.example.tennisBackendCode.miscTools.rowMappers.PlayerRankingRowMapper;
import com.example.tennisBackendCode.miscTools.rowMappers.PlayerStatisticsRowMapper;
import com.example.tennisBackendCode.model.DailyMatch;
import com.example.tennisBackendCode.model.DailyMatchID;
import com.example.tennisBackendCode.model.Match;
import com.example.tennisBackendCode.model.Player;
import com.example.tennisBackendCode.model.PlayerRank;
import com.example.tennisBackendCode.model.PlayerStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class TennisRepo {
    private final JdbcTemplate jdbc;
    private Logger logger = Logger.getLogger("Repo");

    @Autowired
    public TennisRepo(JdbcTemplate jdbc) {this.jdbc = jdbc;}

    public List<Match> getAllMatches() {
        String sql = "select * from atp_match_overview";
        return jdbc.query(sql, new MatchRowMapper());
    }

    public List<Match> getMatchesByPlayerNames(String player1, String player2) {
        String sql = "select tourney_date, tourney_name, surface, round, winner_name, winner_rank, " +
                "loser_name, loser_rank, score from atp_match_overview " +
                "where (winner_name ilike ? and loser_name ilike ?) " +
                "or (winner_name ilike ? and loser_name ilike ?) order by tourney_date desc";
        return jdbc.query(sql, new MatchRowMapper(),player1,player2,player2,player1);
    }

    public PlayerStatistics getPlayerStatisticsByName(String playerName) {
        String sql = "with indwins as\n" +
                "(select * from atp_match where winner_name ilike ?),\n" +
                "indlosses as\n" +
                "(select * from atp_match where loser_name ilike ?)\n" +
                "\n" +
                "select\n" +
                "(select count(*) from atp_match_overview where winner_name ilike ?) career_wins,\n" +
                "(select count(*) from atp_match_overview where loser_name ilike ?) career_losses,\n" +
                "((select sum(w_ace) from indwins) + (select sum(l_ace) from indlosses))::integer total_aces,\n" +
                "\n" +
                "((select sum(w_df) from indwins) + (select sum(l_df) from indlosses))::integer total_df,\n" +
                "\n" +
                "(( \n" +
                "\t((select sum(w_1stin) from indwins) + (select sum(l_1stin) from indlosses))::numeric / \n" +
                "\t((select sum(w_svpt) from indwins) + (select sum(l_svpt) from indlosses))\n" +
                ")*100)::numeric(3,1) first_serve_in_pct,\n" +
                "\n" +
                "((\n" +
                "\t((select sum(w_1stwon) from indwins)::numeric + (select sum(l_1stwon) from indlosses)) /\n" +
                "\t((select sum(w_1stin) from indwins) + (select sum(l_1stin) from indlosses))\n" +
                ")*100)::numeric(3,1) first_serve_win_pct,\n" +
                "\n" +
                "((\n" +
                "\t((select sum(w_2ndwon) from indwins)::numeric + (select sum(l_2ndwon) from indlosses)) /\n" +
                "\t((select sum(w_svpt - w_1stin) from indwins) + (select sum(l_svpt - l_1stin) from indlosses))\n" +
                ")*100)::numeric(3,1) second_serve_win_pct,\n" +
                "\n" +
                "(\n" +
                "\t((select sum(w_bpfaced) from indwins) + (select sum(l_bpfaced) from indlosses))\n" +
                ")::integer break_points_faced,\n" +
                "\n" +
                "((\n" +
                "\t((select sum(w_bpsaved) from indwins)::numeric + (select sum(l_bpsaved) from indlosses)) /\n" +
                "\t((select sum(w_bpfaced) from indwins) + (select sum(l_bpfaced) from indlosses))\n" +
                ")*100)::numeric(3,1) break_points_saved_pct,\n" +
                "\n" +
                "(\n" +
                "\t(select sum(w_svgms) from indwins) + (select sum(l_svgms) from indlosses)\n" +
                ")::integer service_games_played,\n" +
                "\n" +
                "((\n" +
                "\t((select sum(w_svgms - w_bpfaced + w_bpsaved) from indwins)::numeric + (select sum(l_svgms - l_bpfaced + l_bpsaved) from indlosses)) /\n" +
                "\t((select sum(w_svgms) from indwins) + (select sum(l_svgms) from indlosses))\n" +
                ")*100)::numeric(3,1) service_games_won_pct,\n" +
                "\n" +
                "((\n" +
                "\t((select sum(w_1stwon + w_2ndwon) from indwins)::numeric + (select sum(l_1stwon + l_2ndwon) from indlosses)) /\n" +
                "\t((select sum(w_svpt) from indwins) + (select sum(l_svpt) from indlosses))\n" +
                ")*100)::numeric(3,1) serivce_points_won_pct,\n" +
                "\n" +
                "((1-(\n" +
                "\t((select sum(l_1stwon) from indwins)::numeric + (select sum(w_1stwon) from indlosses)) /\n" +
                "\t((select sum(l_1stin) from indwins) + (select sum(w_1stin) from indlosses))\n" +
                "))*100)::numeric(3,1) return_first_serve_win_pct,\n" +
                "\n" +
                "((1-(\n" +
                "\t((select sum(l_2ndwon) from indwins)::numeric + (select sum(w_2ndwon) from indlosses)) /\n" +
                "\t((select sum(l_svpt - l_1stin) from indwins) + (select sum(w_svpt - w_1stin) from indlosses))\n" +
                "))*100)::numeric(3,1) return_second_serve_win_pct,\n" +
                "\n" +
                "(\n" +
                "\t((select sum(l_bpfaced) from indwins) + (select sum(w_bpfaced) from indlosses))\n" +
                ")::integer return_break_point_opportunities,\n" +
                "\n" +
                "((1-(\n" +
                "\t((select sum(l_bpsaved) from indwins)::numeric + (select sum(w_bpsaved) from indlosses)) /\n" +
                "\t((select sum(l_bpfaced) from indwins) + (select sum(w_bpfaced) from indlosses))\n" +
                "))*100)::numeric(3,1) break_points_converted_pct,\n" +
                "\n" +
                "(\n" +
                "\t(select sum(l_svgms) from indwins) + (select sum(w_svgms) from indlosses)\n" +
                ")::integer return__games_played,\n" +
                "\n" +
                "((\n" +
                "\t((select sum(l_bpfaced - l_bpsaved) from indwins)::numeric + (select sum(w_bpfaced - w_bpsaved) from indlosses)) /\n" +
                "\t((select sum(l_svgms) from indwins) + (select sum(w_svgms) from indlosses))\n" +
                ")*100)::numeric(3,1) return_games_won_pct,\n" +
                "\n" +
                "((\n" +
                "\t((select sum(l_svpt - l_1stwon - l_2ndwon) from indwins)::numeric + (select sum(w_svpt - w_1stwon - w_2ndwon) from indlosses)) /\n" +
                "\t((select sum(l_svpt) from indwins) + (select sum(w_svpt) from indlosses))\n" +
                ")*100)::numeric(3,1) return_points_won_pct,\n" +
                "\n" +
                "((\n" +
                "\t(\n" +
                "\t\t(select sum(w_1stwon + w_2ndwon + l_svpt - l_1stwon - l_2ndwon) from indwins)::numeric + \n" +
                "\t\t(select sum(l_1stwon + l_2ndwon + w_svpt - w_1stwon - w_2ndwon) from indlosses)\n" +
                "\t) / \n" +
                "\t(\n" +
                "\t\t((select sum(w_svpt + l_svpt) from indwins) + (select sum(w_svpt + l_svpt) from indlosses))\n" +
                "\t)\n" +
                ")*100)::numeric(3,1) total_points_won_pct";
        PlayerStatistics ps = jdbc.query(sql, new PlayerStatisticsRowMapper(), playerName, playerName,
                playerName, playerName).get(0);

        return ps;
    }

    public ArrayList<Match> getAllMatchesByPlayer(String playerName) {
        String sql = "select * from atp_match_overview\n" +
                " where winner_name ilike ? or loser_name ilike ?\n" +
                " order by tourney_date desc";
        return (ArrayList<Match>)jdbc.query(sql, new MatchRowMapper(), playerName, playerName);
    }

    public void calculateAllStatistics() {
        if(jdbc.queryForList("select * from all_statistics;").size() != 0) {return;}
        new ArrayList<String>(getAllPlayerNames()).forEach(pName -> {
            String sqlNumberMatches = "select * from atp_match_overview where winner_name = ? or loser_name = ?";
            if (jdbc.query(sqlNumberMatches, new MatchRowMapper(), pName,pName).size() < 20) {}
            else {String sql = "insert into all_statistics\n" +
                    "\n" +
                    "with indwins as\n" +
                    "(select * from atp_match where winner_name = ?),\n" +
                    "indlosses as\n" +
                    "(select * from atp_match where loser_name = ?)\n" +
                    "\n" +
                    "select\n" +
                    "(select count(*) from atp_match_overview where winner_name = ?),\n" +
                    "(select count(*) from atp_match_overview where loser_name = ?),\n" +
                    "((select sum(w_ace) from indwins) + (select sum(l_ace) from indlosses))::integer,\n" +
                    "\n" +
                    "((select sum(w_df) from indwins) + (select sum(l_df) from indlosses))::integer,\n" +
                    "\n" +
                    "(( \n" +
                    "\t((select sum(w_1stin) from indwins) + (select sum(l_1stin) from indlosses))::numeric / \n" +
                    "\t((select sum(w_svpt) from indwins) + (select sum(l_svpt) from indlosses))\n" +
                    ")*100)::numeric(3,1),\n" +
                    "\n" +
                    "((\n" +
                    "\t((select sum(w_1stwon) from indwins)::numeric + (select sum(l_1stwon) from indlosses)) /\n" +
                    "\t((select sum(w_1stin) from indwins) + (select sum(l_1stin) from indlosses))\n" +
                    ")*100)::numeric(3,1),\n" +
                    "\n" +
                    "((\n" +
                    "\t((select sum(w_2ndwon) from indwins)::numeric + (select sum(l_2ndwon) from indlosses)) /\n" +
                    "\t((select sum(w_svpt - w_1stin) from indwins) + (select sum(l_svpt - l_1stin) from indlosses))\n" +
                    ")*100)::numeric(3,1),\n" +
                    "\n" +
                    "(\n" +
                    "\t((select sum(w_bpfaced) from indwins) + (select sum(l_bpfaced) from indlosses))\n" +
                    ")::integer,\n" +
                    "\n" +
                    "((\n" +
                    "\t((select sum(w_bpsaved) from indwins)::numeric + (select sum(l_bpsaved) from indlosses)) /\n" +
                    "\t((select sum(w_bpfaced) from indwins) + (select sum(l_bpfaced) from indlosses))\n" +
                    ")*100)::numeric(3,1),\n" +
                    "\n" +
                    "(\n" +
                    "\t(select sum(w_svgms) from indwins) + (select sum(l_svgms) from indlosses)\n" +
                    ")::integer,\n" +
                    "\n" +
                    "((\n" +
                    "\t((select sum(w_svgms - w_bpfaced + w_bpsaved) from indwins)::numeric + (select sum(l_svgms - l_bpfaced + l_bpsaved) from indlosses)) /\n" +
                    "\t((select sum(w_svgms) from indwins) + (select sum(l_svgms) from indlosses))\n" +
                    ")*100)::numeric(3,1),\n" +
                    "\n" +
                    "((\n" +
                    "\t((select sum(w_1stwon + w_2ndwon) from indwins)::numeric + (select sum(l_1stwon + l_2ndwon) from indlosses)) /\n" +
                    "\t((select sum(w_svpt) from indwins) + (select sum(l_svpt) from indlosses))\n" +
                    ")*100)::numeric(3,1),\n" +
                    "\n" +
                    "((1-(\n" +
                    "\t((select sum(l_1stwon) from indwins)::numeric + (select sum(w_1stwon) from indlosses)) /\n" +
                    "\t((select sum(l_1stin) from indwins) + (select sum(w_1stin) from indlosses))\n" +
                    "))*100)::numeric(3,1),\n" +
                    "\n" +
                    "((1-(\n" +
                    "\t((select sum(l_2ndwon) from indwins)::numeric + (select sum(w_2ndwon) from indlosses)) /\n" +
                    "\t((select sum(l_svpt - l_1stin) from indwins) + (select sum(w_svpt - w_1stin) from indlosses))\n" +
                    "))*100)::numeric(3,1),\n" +
                    "\n" +
                    "(\n" +
                    "\t((select sum(l_bpfaced) from indwins) + (select sum(w_bpfaced) from indlosses))\n" +
                    ")::integer,\n" +
                    "\n" +
                    "((1-(\n" +
                    "\t((select sum(l_bpsaved) from indwins)::numeric + (select sum(w_bpsaved) from indlosses)) /\n" +
                    "\t((select sum(l_bpfaced) from indwins) + (select sum(w_bpfaced) from indlosses))\n" +
                    "))*100)::numeric(3,1),\n" +
                    "\n" +
                    "(\n" +
                    "\t(select sum(l_svgms) from indwins) + (select sum(w_svgms) from indlosses)\n" +
                    ")::integer,\n" +
                    "\n" +
                    "((\n" +
                    "\t((select sum(l_bpfaced - l_bpsaved) from indwins)::numeric + (select sum(w_bpfaced - w_bpsaved) from indlosses)) /\n" +
                    "\t((select sum(l_svgms) from indwins) + (select sum(w_svgms) from indlosses))\n" +
                    ")*100)::numeric(3,1),\n" +
                    "\n" +
                    "((\n" +
                    "\t((select sum(l_svpt - l_1stwon - l_2ndwon) from indwins)::numeric + (select sum(w_svpt - w_1stwon - w_2ndwon) from indlosses)) /\n" +
                    "\t((select sum(l_svpt) from indwins) + (select sum(w_svpt) from indlosses))\n" +
                    ")*100)::numeric(3,1),\n" +
                    "\n" +
                    "((\n" +
                    "\t(\n" +
                    "\t\t(select sum(w_1stwon + w_2ndwon + l_svpt - l_1stwon - l_2ndwon) from indwins)::numeric + \n" +
                    "\t\t(select sum(l_1stwon + l_2ndwon + w_svpt - w_1stwon - w_2ndwon) from indlosses)\n" +
                    "\t) / \n" +
                    "\t(\n" +
                    "\t\t((select sum(w_svpt + l_svpt) from indwins) + (select sum(w_svpt + l_svpt) from indlosses))\n" +
                    "\t)\n" +
                    ")*100)::numeric(3,1),\n" +
                    "\n" +
                    "?,\n" +
                    "(select player_id from atp_player play\n" +
                    " where play.player_name = ?)";
                jdbc.update(sql, pName, pName,pName,pName,pName,pName);}
        });
    }
    public List<PlayerRank> getRankings() {
        String sql = "select * from atp_ranking";
        return jdbc.query(sql, new PlayerRankingRowMapper());
    }
    public List<DailyMatch> getDailyMatchesGet(java.sql.Date date) {
        String sql = "select * from daily_matches where tourney_date = ?";
        List<DailyMatch> l = jdbc.query(sql, new DailyMatchRowMapper(), date);
        return l;
    }
    public List<DailyMatch> getDailyMatchesPost(DailyMatchID[] matches, java.sql.Date date) {
        logger.info(String.format("%d", matches.length));
        logger.info(date.toString());
        logger.info(Arrays.toString(matches));
        for(DailyMatchID match : matches) {
            String sql = "insert into daily_matches values (?, ?, ?, ?, ?, ?);";
            DailyMatch dm = convert(match);
            logger.info(dm.toString());
            //update only if valid match returned
            if(!(dm == null)) jdbc.update(sql, dm.getMatchDate(), dm.getTourneyName(), dm.getHomePlayer(), dm.getAwayPlayer(), dm.getWinnerName(), dm.getScore());
        }
        List<DailyMatch> l = jdbc.query("select * from daily_matches where tourney_date = ?", new DailyMatchRowMapper(), date);
        return l;
    }
    private DailyMatch convert(DailyMatchID dmID) {
        String queryForNameByID = "select player_name from atp_player_2 where player_id = ?";
        RowMapper<String> idToNameMapper = new RowMapper<String>() {
            @Override
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString(1);
            }
        };
        List<String> homeQuery = jdbc.query(queryForNameByID, idToNameMapper, dmID.getHomeID());
        List<String> awayQuery = jdbc.query(queryForNameByID, idToNameMapper, dmID.getAwayID());
        List<String> winnerQuery = jdbc.query(queryForNameByID, idToNameMapper, dmID.getWinnerID());

        if(homeQuery.size() == 0 || awayQuery.size() == 0 || winnerQuery.size() == 0) {
            return null;
        }
        String homePlayer = homeQuery.get(0);
        String awayPlayer = awayQuery.get(0);
        String winnerName = winnerQuery.get(0);

        return new DailyMatch(dmID.getMatchDate(), dmID.getTourneyName(), homePlayer, awayPlayer, winnerName, dmID.getScore());
    }

    public ArrayList<String> getAllPlayerNames() {
        return (ArrayList<String>)jdbc.query("select player_name from atp_player", new PlayerNameMapper());
    }

    public void insertPlayers(Player[] players) {
        for(Player player : players) {
            String insertPlayerSQL = "insert into atp_player_2 values (?, ?, ?);";
            try {
                jdbc.update(insertPlayerSQL, player.getPlayerID(), player.getPlayerName(), player.getCountry());
            }
            catch (DataAccessException ex) {
                //if primary key constraint is violated.
            }
        }
    }


}
