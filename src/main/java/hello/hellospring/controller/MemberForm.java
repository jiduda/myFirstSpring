package hello.hellospring.controller;

public class MemberForm {   // templates/members/createMemberForm 의 input 태그 name 을 받아옴
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {  // 받은 name 을 할당
        this.name = name;
    }
}
