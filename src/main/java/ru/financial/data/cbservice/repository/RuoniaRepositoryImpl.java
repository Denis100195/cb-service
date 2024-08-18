package ru.financial.data.cbservice.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.financial.data.cbservice.domain.repository.RuoniaRepository;
import ru.financial.data.cbservice.entity.Ruonia;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.List;

@Repository
public class RuoniaRepositoryImpl implements RuoniaRepository {
    private final JdbcTemplate jdbcTemplate;
    public RuoniaRepositoryImpl(final DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    private static final String SELECT_RUONIA_BETWEEN_DATES = "select * from ruonia where date between ? and ?";
    private static final String SELECT_RUONIA_ON_DATE = "select * from ruonia where date = ?";
    private static final String INSERT_RUONIA_INTO_DB = "INSERT INTO ruonia values (?,?,?,?)";

    @Override
    public void insertRuonia(Ruonia ruonia) {
        jdbcTemplate.update(INSERT_RUONIA_INTO_DB, getParams(ruonia));
    }
    @Override
    public List<Ruonia> findRuoniaBetweenDates(LocalDate fromDate, LocalDate toDate) {
        return jdbcTemplate.query(SELECT_RUONIA_BETWEEN_DATES, ruoniaRowMapper, fromDate, toDate);
    }

    @Override
    public Ruonia findRuoniaOnDate(LocalDate date) {
        return jdbcTemplate.queryForObject(SELECT_RUONIA_ON_DATE, Ruonia.class, date);
    }
    private RowMapper<Ruonia> ruoniaRowMapper = (resultSet, i) ->
            new Ruonia(
                    resultSet.getTimestamp("date").toLocalDateTime().toLocalDate(),
                    resultSet.getDouble("ruonia"),
                    resultSet.getDouble("volume"),
                    resultSet.getTimestamp("date_update").toLocalDateTime().toLocalDate()
            );
    private Object[] getParams(Ruonia ruonia) {
        Object[] params = new Object[4];
        params[0] = ruonia.getDate();
        params[1] = ruonia.getRuonia();
        params[2] = ruonia.getVolume();
        params[3] = ruonia.getDateUpdate();
        return params;
    }
}
