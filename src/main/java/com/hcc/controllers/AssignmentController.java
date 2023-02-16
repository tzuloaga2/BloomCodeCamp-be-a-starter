package com.hcc.controllers;

import com.hcc.dtos.AssignmentResponseDto;
import com.hcc.entities.Assignment;
import com.hcc.entities.User;
import com.hcc.enums.AuthorityEnum;
import com.hcc.repositories.AssignmentRepository;
import com.hcc.repositories.UserRepository;
import com.hcc.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.Assign;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@RestController
@RequestMapping

public class AssignmentController {
    //Get Assignments By User /api/assignments

    @Autowired
    AssignmentRepository assignmentRepository;
    @GetMapping("/api/assignments")
    public ResponseEntity<?> getAssignmentByUser(@AuthenticationPrincipal User user) {
        Set<Assignment> answer = assignmentRepository.findAssigmentByUser(user);
        return ResponseEntity.ok(answer);
    }
    //get assignments by id
    @GetMapping("/api/assignments/{id}")
    public ResponseEntity<?> getAssignmentById(@PathVariable Long id, @AuthenticationPrincipal User user) {
        Optional<Assignment> assignments = assignmentRepository.findById(id);
        return ResponseEntity.ok(new AssignmentResponseDto(assignments.orElse(new Assignment())));
    }
    //put assignment by id /api/assignments/{id}

    //check if this is correct below
    @PutMapping("/api/assignments/{id}")
    public ResponseEntity<?> putAssignmentsById(@PathVariable Long id, @RequestBody Assignment assignment, @AuthenticationPrincipal User user) {
        Optional assignments = assignmentRepository.findById(id);
        return ResponseEntity.ok(assignments);
    }

    //post assignment /api/assignments
    @PostMapping("/api/assignments/{id}")
    public void save(@RequestBody Assignment assignment){
        assignmentRepository.save(assignment);
    }
}