package uz.themind.hibernate.jdbc;

import org.springframework.jdbc.core.RowMapper;
import uz.themind.hibernate.domain.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRowMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Person(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("location"),
                resultSet.getDate("birth_date"));
    }
}
