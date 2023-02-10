package com.hcc.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

public enum AuthorityEnum {
    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
        Greeting1(1, "Learner"),
        Greeting2(2, "Reviewer"),
        Greeting3(3, "Owner"),
        Greeting4(4, "Teacher");

        private int authorityNumber;

        private String authorityLevelMessage;
        AuthorityEnum(int authorityNumber, String authorityLevelMessage) {
            this.authorityNumber = authorityNumber;
            this.authorityLevelMessage = authorityLevelMessage;
        }


        int getAuthorityNumber() { return authorityNumber; }
        String getAuthorityLevelMessage() { return authorityLevelMessage; }
    }

