package LearnJpaHibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/*
 * Everything is correct but still i am not able to put data into database ..
 * why is this is happening i don't know 
 * i'll try to find solution for it..
 *  
 * */
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
