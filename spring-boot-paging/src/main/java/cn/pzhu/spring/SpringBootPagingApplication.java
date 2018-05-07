package cn.pzhu.spring;

import cn.pzhu.spring.domain.Country;
import cn.pzhu.spring.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootPagingApplication {

    private final CountryRepository countryRepository;

    @Autowired
    public SpringBootPagingApplication(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootPagingApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            countryRepository.save(new Country("Earth", "World"));
            countryRepository.save(new Country("China", "Peking"));
            countryRepository.save(new Country("Germany", "Berlin"));
            countryRepository.save(new Country("USA", "Washington DC"));
            countryRepository.save(new Country("Russia", "Moscow"));
            countryRepository.save(new Country("Namibia", "Windhoek"));
            countryRepository.save(new Country("India", "New Delhi"));
            countryRepository.save(new Country("North Korea", "Pyongyang"));
            countryRepository.save(new Country("Kenya", "Nairobi"));
            countryRepository.save(new Country("Canada", "Ottawa"));
            countryRepository.save(new Country("Jamaica", "Kingston"));
            countryRepository.save(new Country("Brazil", "Brasilia"));
            countryRepository.save(new Country("Egypt", "Cairo"));
        };
    }
}
