package com.example.ms25relations.service;

import com.example.ms25relations.domain.SearchCriteria;
import com.example.ms25relations.domain.Student;
import com.example.ms25relations.domain.StudentSpecification;
import com.example.ms25relations.repository.StudentRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getAllBy(){
        return studentRepository.findAll(ageGreaterThan(20));
    }

    public List<Student> getAllByName(){
        return studentRepository.findAll(Specification.where(nameLike("Alihuseyn")).and(ageGreaterThan(20)));
    }

    public List<Student> jpaGreaterThan91(){
        return studentRepository.findAll(jpaGreaterThan(91.0));
    }

    public List<Student> getAllByCriteria(List<SearchCriteria> dto) {
        StudentSpecification studentSpecification = new StudentSpecification();
        dto.forEach(studentSpecification::add);
        return studentRepository.findAll(studentSpecification);
    }

    private Specification<Student> ageGreaterThan(int age){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get(Student.Fields.age),age));
    }

    private Specification<Student> nameLike(String firstName){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(Student.Fields.firstName),firstName));
    }

    private Specification<Student> jpaGreaterThan(double jpa){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get(Student.Fields.jpa),jpa));
    }


}
