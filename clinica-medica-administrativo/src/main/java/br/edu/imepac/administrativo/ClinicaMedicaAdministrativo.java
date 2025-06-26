package br.edu.imepac.administrativo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
        "br.edu.imepac.administrativo",
        "br.edu.imepac.central"
})
public class ClinicaMedicaAdministrativo {

    public static void main(String[] args) {
        SpringApplication.run(ClinicaMedicaAdministrativo.class, args);
    }
}