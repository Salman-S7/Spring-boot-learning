package LearnDb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class JdbcCommandLineRunnerClass implements CommandLineRunner {
    @Autowired
    private JdbcRepository jdbcRepository;
    @Override
    public void run(String... args) throws Exception {
        jdbcRepository.insert();
    }
}
