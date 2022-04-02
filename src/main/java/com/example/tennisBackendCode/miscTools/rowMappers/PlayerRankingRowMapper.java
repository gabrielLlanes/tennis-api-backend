package com.example.tennisBackendCode.miscTools.rowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.tennisBackendCode.model.PlayerRank;

import org.springframework.jdbc.core.RowMapper;

public class PlayerRankingRowMapper implements RowMapper<PlayerRank>{

    @Override
    public PlayerRank mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new PlayerRank(rs.getShort(1), rs.getString(2), rs.getInt(3));
    }
    
}
