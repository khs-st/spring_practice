package hello.hellospring.controller;

public class MemberForm {
    //createMemberForm.html의 input name 값과 매칭
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
