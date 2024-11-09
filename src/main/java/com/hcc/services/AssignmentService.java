package com.hcc.services;

import com.hcc.entities.Assignment;
import com.hcc.entities.User;
import com.hcc.repositories.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AssignmentService {

    @Autowired
    AssignmentRepository assignmentRepository;


    public Set<Assignment> getAssignmentsByUser(User user) {
        return assignmentRepository.findByUser(user);
    }

    public Assignment getAssignmentById(Long id) {
        return assignmentRepository.findById(id).orElse(new Assignment());
    }

    public Assignment updateAssignmentById(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    // Can combine and delete duplicate
    public Assignment createAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }
}
