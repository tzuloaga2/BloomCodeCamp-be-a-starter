package com.hcc.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

public enum AssignmentEnum {
    @JsonFormat(shape = JsonFormat.Shape.OBJECT)

        Greeting1(1, "Introduction"),
        Greeting2(2, "Module 1"),
        Greeting3(3, "Module 2"),
        Greeting4(4, "Final project");

        private int assignmentNumber;

        private String assignmentMessage;
        AssignmentEnum(int assignmentNumber, String assignmentMessage) {
            this.assignmentNumber = assignmentNumber;
            this.assignmentMessage = assignmentMessage;
        }
    int getAssignmentNumber() { return assignmentNumber; }
    String getAssignmentMessage() { return assignmentMessage; }

}
