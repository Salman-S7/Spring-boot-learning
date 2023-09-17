package LearnDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcRepository {
    private static final String SQL_QUERY = """
            insert into courses(id,name,author)
            values(1,'learn spring boot','salman');
            """;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void insert(){
        jdbcTemplate.update(SQL_QUERY);
    }
}
