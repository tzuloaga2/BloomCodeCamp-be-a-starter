package com.hcc.dtos;

public class AssignmentEnumDto {
    //reason for this class?

    private String assignmentName;
    private Integer assignmentNumber;

    public AssignmentEnumDto(String assignmentName, Integer assignmentNumber){
        this.assignmentName = assignmentName;
        this.assignmentNumber = assignmentNumber;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public Integer getAssignmentNumber() {
        return assignmentNumber;
    }

    public void setAssignmentNumber(Integer assignmentNumber) {
        this.assignmentNumber = assignmentNumber;
    }
}
