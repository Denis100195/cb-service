package ru.financial.data.cbservice.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.financial.data.cbservice.domain.repository.CursOnDateRepository;
import ru.financial.data.cbservice.entity.CursOnDate;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.List;

@Repository
public class CursOnDateRepositoryImpl implements CursOnDateRepository {
    private final JdbcTemplate jdbcTemplate;
    public CursOnDateRepositoryImpl(final DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    private static final String SELECT_CURS_ON_DATE_BETWEEN_DATES = "select * from curs_on_date where date between ? and ?";
    private static final String SELECT_CURS_ON_DATE = "select * from curs_on_date where date = ?";
    private static final String INSERT_CURS_ON_DATE_INTO_DB = "INSERT INTO curs_on_date values (?,?,?,?,?,?,?)";
    @Override
    public void insertCursOnDate(CursOnDate curseOnDate) {
        jdbcTemplate.update(INSERT_CURS_ON_DATE_INTO_DB, getParams(curseOnDate));
    }
    @Override
    public List<CursOnDate> findCursOnDateBetweenDates(LocalDate fromDate, LocalDate toDate) {
        return jdbcTemplate.query(SELECT_CURS_ON_DATE_BETWEEN_DATES, cursOnDateRowMapper, fromDate, toDate);
    }
    @Override
    public CursOnDate findCursOnDate(LocalDate date) {
        return jdbcTemplate.queryForObject(SELECT_CURS_ON_DATE, CursOnDate.class, date);
    }
    private RowMapper<CursOnDate> cursOnDateRowMapper = (resultSet, i) ->
            new CursOnDate(
                    resultSet.getTimestamp("date").toLocalDateTime().toLocalDate(),
                    resultSet.getString("name"),
                    resultSet.getLong("nom"),
                    resultSet.getDouble("curs"),
                    resultSet.getInt("code"),
                    resultSet.getString("ch_code"),
                    resultSet.getDouble("unit_rate")
            );
    private Object[] getParams(CursOnDate cursOnDate) {
        Object[] params = new Object[7];
        params[0] = cursOnDate.getDate();
        params[1] = cursOnDate.getName();
        params[2] = cursOnDate.getNom();
        params[3] = cursOnDate.getCurs();
        params[4] = cursOnDate.getCode();
        params[5] = cursOnDate.getChCode();
        params[6] = cursOnDate.getUnitRate();
        return params;
    }
}
