package br.edu.imepac.administrativo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
        scanBasePackages = {
                "br.edu.imepac",
                "br.edu.imepac.administrativo",
        }
)
@EnableJpaRepositories(basePackages = {"br.edu.imepac.central.repositories"})
@EntityScan(basePackages = {"br.edu.imepac.central.models"})
public class ClinicaMedicaAdministrativo {
    public static void main(String[] args) {
        SpringApplication.run(ClinicaMedicaAdministrativo.class, args);
    }
}