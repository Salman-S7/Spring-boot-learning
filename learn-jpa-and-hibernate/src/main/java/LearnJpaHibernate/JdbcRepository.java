package LearnJpaHibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private String SQL_QUERY = """
				insert into courses(id,name,author) values(1,'learn hibernate','salman');
			""";

	public void insert() {
		System.out.println("insert is called");
		System.out.println(jdbcTemplate.update(SQL_QUERY));
	}

}
