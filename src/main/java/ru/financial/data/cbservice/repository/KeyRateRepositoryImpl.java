package ru.financial.data.cbservice.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.financial.data.cbservice.domain.repository.KeyRateRepository;
import ru.financial.data.cbservice.entity.KeyRate;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.List;

@Repository
public class KeyRateRepositoryImpl implements KeyRateRepository {
    private final JdbcTemplate jdbcTemplate;
    public KeyRateRepositoryImpl(final DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    private static final String SELECT_KEYRATE_BETWEEN_DATES = "select * from key_rate where date between ? and ?";
    private static final String SELECT_KEYRATE_ON_DATE = "select * from key_rate where date = ?";
    private static final String INSERT_KEYRATE_INTO_DB = "INSERT INTO key_rate values (?,?)";
    @Override
    public void insertKeyRate(KeyRate keyRate) {
        jdbcTemplate.update(INSERT_KEYRATE_INTO_DB, getParams(keyRate));
    }
    @Override
    public List<KeyRate> findKeyRateBetweenDates(LocalDate fromDate, LocalDate toDate) {
        return jdbcTemplate.query(SELECT_KEYRATE_BETWEEN_DATES, keyRateRowMapper, fromDate, toDate);
    }
    @Override
    public KeyRate findKeyRateOnDate(LocalDate date) {
        return jdbcTemplate.queryForObject(SELECT_KEYRATE_ON_DATE, KeyRate.class, date);
    }
    private RowMapper<KeyRate> keyRateRowMapper = (resultSet, i) ->
            new KeyRate(
                    resultSet.getTimestamp("date").toLocalDateTime().toLocalDate(),
                    resultSet.getDouble("rate")
            );
    private Object[] getParams(KeyRate keyRate) {
        Object[] params = new Object[2];
        params[0] = keyRate.getDate();
        params[1] = keyRate.getRate();
        return params;
    }
}
