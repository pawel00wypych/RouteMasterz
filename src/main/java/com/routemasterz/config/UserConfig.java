package com.routemasterz.config;

import com.routemasterz.model.*;
import com.routemasterz.repository.CheckpointsRepository;
import com.routemasterz.repository.RoutesRepository;
import com.routemasterz.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.List;

import static java.util.Calendar.MARCH;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository,
                                        RoutesRepository routesRepository,
                                        CheckpointsRepository checkpointsRepository,
                                        PasswordEncoder passwordEncoder) {

        return args -> {

            UserEntityDetails adamDetails = new UserEntityDetails(
                    "Adam",
                    "Kowalski",
                    "Warszawa",
                    "Hans-Trans".toLowerCase(),
                    111222333,
                    "/photo.png",
                    LocalDate.of(2015, MARCH, 22).toString()
            );

            UserEntityDetails marekDetails = new UserEntityDetails(
                    "Marek",
                    "Drwal",
                    "Warszawa",
                    "Hans-Trans".toLowerCase(),
                    444222333,
                    "/photo.png",
                    LocalDate.of(2019, MARCH, 20).toString()
            );

            UserEntityDetails kacperDetails = new UserEntityDetails(
                    "Kacper",
                    "Mostowiak",
                    "Kraków",
                    "Janusz-Trans".toLowerCase(),
                    444111333,
                    "/photo.png",
                    LocalDate.of(2021, MARCH, 10).toString()
            );

            UserEntityDetails monikaDetails = new UserEntityDetails(
                    "Monika",
                    "Smith",
                    "Kraków",
                    "Hans-Trans".toLowerCase(),
                    999111333,
                    "/photo.png",
                    LocalDate.of(2020, MARCH, 15).toString()
            );

            UserEntity adam = new UserEntity(
                    Role.LOGISTICIAN,
                    "adam@email.com",
                    passwordEncoder.encode("password"),
                    LocalDate.of(2015, MARCH, 22).toString(),
                    adamDetails);

            UserEntity marek = new UserEntity(
                    Role.DRIVER,
                    "marek@email.com",
                    passwordEncoder.encode("password"),
                    LocalDate.of(2019, MARCH, 20).toString(),
                    marekDetails);

            UserEntity kacper = new UserEntity(
                    Role.DRIVER,
                    "kacper@email.com",
                    passwordEncoder.encode("password"),
                    LocalDate.of(2021, MARCH, 10).toString(),
                    kacperDetails);

            UserEntity monika = new UserEntity(
                    Role.ADMIN,
                    "monika@email.com",
                    passwordEncoder.encode("password"),
                    LocalDate.of(2020, MARCH, 15).toString(),
                    monikaDetails);


            userRepository.saveAll(List.of(adam, marek,kacper,monika));

            Route adamRoute1 = new Route(
                    "trasa adamowa 1",
                    LocalDate.now().toString(),
                    adam
            );

            Route adamRoute2 = new Route(
                    "trasa adamowa 2",
                    LocalDate.now().toString(),
                    adam
            );

            Route adamRoute3 = new Route(
                    "trasa adamowa 3",
                    LocalDate.now().toString(),
                    adam
            );

            routesRepository.save(adamRoute1);
            routesRepository.save(adamRoute2);
            routesRepository.save(adamRoute3);

            Checkpoint check1 = new Checkpoint(
                    adamRoute1,
                    "Poland",
                    "Pawia 5",
                    "Cracow",
                    "Lesser Poland Voivodeship",
                    "31-154",
                    "6:00",
                    0);

            Checkpoint check2 = new Checkpoint(
                    adamRoute1,
                    "Poland",
                    "Przy Rondzie 7",
                    "Cracow",
                    "Lesser Poland Voivodeship",
                    "31-547",
                    "6:30",
                    1);

            Checkpoint check3 = new Checkpoint(
                    adamRoute2,
                    "Poland",
                    "Mogilska 116",
                    "Cracow",
                    "Lesser Poland Voivodeship",
                    "31-445",
                    "8:00",
                    0);

            Checkpoint check4 = new Checkpoint(
                    adamRoute3,
                    "Poland",
                    "plac defilad 1",
                    "Warsaw",
                    "Masovian Voivodeship",
                    "00-901",
                    "7:00",
                    0);

            checkpointsRepository.save(check1);
            checkpointsRepository.save(check2);
            checkpointsRepository.save(check3);
            checkpointsRepository.save(check4);
        };

    }
}