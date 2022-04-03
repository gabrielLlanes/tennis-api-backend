package com.example.tennisBackendCode.miscTools.rowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.tennisBackendCode.model.DailyMatch;

import org.springframework.jdbc.core.RowMapper;

public class DailyMatchRowMapper implements RowMapper<DailyMatch>{

    @Override
    public DailyMatch mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new DailyMatch(rs.getDate(1), rs.getString(2), rs.getString(3),
        rs.getString(4), rs.getString(5), rs.getString(6));
    }
    
}
