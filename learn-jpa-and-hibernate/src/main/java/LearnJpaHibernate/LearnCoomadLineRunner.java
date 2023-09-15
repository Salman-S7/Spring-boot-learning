package LearnJpaHibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LearnCoomadLineRunner implements CommandLineRunner {
	@Autowired
	private JdbcRepository jdbcRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("we are her in run method");
		jdbcRepository.insert();
	}

}
