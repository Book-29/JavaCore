package ru.innopolis.repository.impl;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.innopolis.model.Users;
import ru.innopolis.repository.UsersRepository;

import javax.sql.DataSource;

public class UsersRepositoryImpl implements UsersRepository {
   private JdbcTemplate jdbcTemplate;

    public UsersRepositoryImpl(JdbcTemplate jdbcTemplate) {
        DataSource dataSource = new PGSimpleDataSource() ;

        jdbcTemplate.setDataSource(dataSource);

         this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Users findById(Long id) {
        jdbcTemplate.execute("DELETE FROM users");
        return jdbcTemplate.queryForObject("SELECT * FROM users u WHERE u.id = " + id, rowMapper());
    }

    private RowMapper<Users> rowMapper() {
        return (rs, rowNum) -> {
            Users users = new Users();
            users.setId(rs.getLong("id"));
            users.setFio(rs.getString("fio"));
            return users;
        };
    }
}
