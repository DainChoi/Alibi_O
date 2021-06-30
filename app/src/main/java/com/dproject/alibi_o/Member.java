package com.dproject.alibi_o;

class Member {
    private String emailId;     // 이메일 아이디
    private String name;     // 이름

    public Member(String emailId, String name) {
        this.emailId = emailId;
        this.name = name;
    }

    public Member(){}

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
