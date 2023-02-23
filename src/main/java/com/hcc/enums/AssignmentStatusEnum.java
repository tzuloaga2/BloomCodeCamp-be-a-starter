package com.hcc.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

public enum AssignmentStatusEnum {
        @JsonFormat(shape = JsonFormat.Shape.OBJECT)

       NotYetStarted(1, "Not yet started"),
        WorkingOnIt(2, "Working on it"),
        NearlyThere(3, "Nearly there"),
        Done(4, "Done");


        private int assignmentStatusNumber;

        private String assignmentStatusMessage;
        AssignmentStatusEnum(int assignmentStatusNumber, String assignmentStatusMessage) {
            this.assignmentStatusNumber = assignmentStatusNumber;
            this.assignmentStatusMessage = assignmentStatusMessage;
        }

        public int getAssignmentStatusNumber() { return assignmentStatusNumber; }
        public String getAssignmentStatusMessage() { return assignmentStatusMessage; }

}
