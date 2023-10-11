package com.example.ms25relations;

import com.example.ms25relations.domain.Student;
import com.example.ms25relations.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class Ms25RelationsApplication implements CommandLineRunner {

    private final StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(Ms25RelationsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Student a1 = Student.builder()
                .id(6L)
                .age(259)
                .firstName("Alihs")
                .lastName("Xaliqsd")
                .studentNumber("AA1778582")
                .jpa(95).build();
        studentRepository.save(a1);

    }
}
