package payroll;

import com.rockets.rockets.entities.Country;
import com.rockets.rockets.repositories.CountryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    public CommandLineRunner initDatabase(CountryRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Country("Colombia","Col")));
            log.info("Preloading " + repository.save(new Country("United States","USA")));
            log.info("Preloading " + repository.save(new Country("Japan","JPN")));
            log.info("Preloading " + repository.save(new Country("Russia","RUS")));
            log.info("Preloading " + repository.save(new Country("Germany","GER")));
        };
    }
}