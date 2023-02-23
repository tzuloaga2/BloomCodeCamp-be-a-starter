package com.hcc.services;

import com.hcc.entities.Assignment;
import com.hcc.entities.User;
import com.hcc.enums.AssignmentStatusEnum;
import com.hcc.repositories.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class AssignmentService {

    @Autowired
    AssignmentRepository assignmentRepository;

    public Assignment save(User user){
        Assignment assignment = new Assignment();
        assignment.setUser(user);
        assignment.setStatus(AssignmentStatusEnum.NotYetStarted.getAssignmentStatusMessage());
        assignment.setAssignmentnumber(nextAssignment(user));

        return assignmentRepository.save(assignment);
    }


    private Integer nextAssignment(User user) {
        Set<Assignment> assignmentByUser = assignmentRepository.findAssignmentByUser(user);
        if(assignmentByUser == null){
            return 1;
        }
        Optional<Integer> sortedAssignments = assignmentByUser.stream()
                .sorted((a1,a2) -> {
                    if(a1.getAssignmentnumber() == null){
                        return 1;
                    }
                    if(a2.getAssignmentnumber() == null){
                        return 1;
                    }
                    return a2.getAssignmentnumber().compareTo(a1.getAssignmentnumber());
                }).map(assignment -> {
                    if(assignment.getAssignmentnumber() == null){
                        return 1;
                    }
                    return assignment.getAssignmentnumber() + 1;
                }).findFirst();
        return sortedAssignments.orElse(1);
    }


}
