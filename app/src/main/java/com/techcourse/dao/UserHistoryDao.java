package com.techcourse.dao;

import com.techcourse.domain.UserHistory;
import nextstep.jdbc.JdbcTemplate;

public class UserHistoryDao {

    private final JdbcTemplate jdbcTemplate;

    public UserHistoryDao(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void log(final UserHistory userHistory) {
        final String sql = "insert into user_history "
                + "(user_id, account, password, email, created_at, created_by) "
                + "values (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                userHistory.getUserId(),
                userHistory.getAccount(),
                userHistory.getPassword(),
                userHistory.getEmail(),
                userHistory.getCreatedAt(),
                userHistory.getCreateBy()
        );
    }
}
