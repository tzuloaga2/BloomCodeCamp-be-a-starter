package com.hcc.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

public enum AssignmentEnum {
    @JsonFormat(shape = JsonFormat.Shape.OBJECT)

        Introduction(1, "Introduction"),
        Module1(2, "Module 1"),
        Module2(3, "Module 2"),
        FinalProject(4, "Final project");

        private int assignmentNumber;

        private String assignmentMessage;
        AssignmentEnum(int assignmentNumber, String assignmentMessage) {
            this.assignmentNumber = assignmentNumber;
            this.assignmentMessage = assignmentMessage;
        }
    int getAssignmentNumber() { return assignmentNumber; }
    String getAssignmentMessage() { return assignmentMessage; }

}
