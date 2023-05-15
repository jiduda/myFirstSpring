package hello.hellospring.domain;

public class Member {

    private Long id;    // 고객의 id 값을 저장할 변수
    private String name;    // 고객의 이름 값을 저장할 변수

    public Long getId() {   // id 반환
        return id;
    }

    public void setId(Long id) {    // id 저장
        this.id = id;
    }

    public String getName() {   // 이름 반환
        return name;
    }

    public void setName(String name) {  // 이름 저장
        this.name = name;
    }
}
