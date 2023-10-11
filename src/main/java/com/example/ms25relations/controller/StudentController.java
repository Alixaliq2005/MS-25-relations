package com.example.ms25relations.controller;

import com.example.ms25relations.domain.SearchCriteria;
import com.example.ms25relations.domain.Student;
import com.example.ms25relations.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/studentss")
@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    private final ModelMapper modelMapper;

    @GetMapping("/list")
    public List<Student> getListByCriteria(@RequestBody List<SearchCriteria> dto){
        return studentService.getAllByCriteria(dto);
    }




}
