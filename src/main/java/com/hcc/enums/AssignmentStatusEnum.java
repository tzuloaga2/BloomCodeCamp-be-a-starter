package com.hcc.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

public enum AssignmentStatusEnum {
        @JsonFormat(shape = JsonFormat.Shape.OBJECT)

        Greeting1(1, "Not yet started"),
        Greeting2(2, "Working on it"),
        Greeting3(3, "Nearly there"),
        Greeting4(4, "Done");


        private int assignmentStatusNumber;

        private String assignmentStatusMessage;
        AssignmentStatusEnum(int assignmentStatusNumber, String assignmentStatusMessage) {
            this.assignmentStatusNumber = assignmentStatusNumber;
            this.assignmentStatusMessage = assignmentStatusMessage;
        }


        int getAssignmentStatusNumber() { return assignmentStatusNumber; }
        String getAssignmentStatusMessage() { return assignmentStatusMessage; }

}
