package com.example.tennisBackendCode.miscTools.rowMappers;

import com.example.tennisBackendCode.model.PlayerStatistics;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerStatisticsRowMapper implements RowMapper<PlayerStatistics> {
    @Override
    public PlayerStatistics mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new PlayerStatistics(
                rs.getShort(1), rs.getShort(2),
                rs.getInt(3), rs.getInt(4), rs.getBigDecimal(5),rs.getBigDecimal(6),
                rs.getBigDecimal(7), rs.getInt(8), rs.getBigDecimal(9), rs.getInt(10), rs.getBigDecimal(11),
                rs.getBigDecimal(12), rs.getBigDecimal(13), rs.getBigDecimal(14), rs.getInt(15), rs.getBigDecimal(16),
                rs.getInt(17), rs.getBigDecimal(18), rs.getBigDecimal(19), rs.getBigDecimal(20));
    }
}
