package com.hcc.controllers;

import com.hcc.entities.Assignment;
import com.hcc.entities.User;
import com.hcc.services.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/assignments")
public class AssignmentController {
    @Autowired
    AssignmentService assignmentService;

    @GetMapping()
    ResponseEntity<?> getAssignmentsByUser(@AuthenticationPrincipal User user) {
        Set<Assignment> assignments = assignmentService.getAssignmentsByUser(user);
        return ResponseEntity.ok(assignments);
    }

    @GetMapping("{id}")
    ResponseEntity<?> getAssignmentById(@AuthenticationPrincipal User user, @PathVariable Long id) {
        Assignment assignment = assignmentService.getAssignmentById(id);
        return ResponseEntity.ok(assignment);
    }

    @PutMapping()
    ResponseEntity<?> updateAssignmentById(@AuthenticationPrincipal User user, @RequestBody Assignment assignment) {
        //Put for updating
        Assignment updatedAssignment = assignmentService.updateAssignmentById(assignment);
        return ResponseEntity.ok(updatedAssignment);
    }

    @PostMapping()
    ResponseEntity<?> createAssignment(@AuthenticationPrincipal User user, @RequestBody Assignment assignment) {
        //Post for creating
        Assignment newAssignment = assignmentService.createAssignment(assignment);
        return ResponseEntity.ok(newAssignment);
    }

}
