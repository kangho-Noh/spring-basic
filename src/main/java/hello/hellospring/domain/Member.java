package hello.hellospring.domain;

public class Member {
    private Long id; // 데이터를 구분하기 위한 id.. long이 아닌 Long인 이유 -> Long은 null을 사용할 수 있음
    private String name; // 사용자 이름

    //getter setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
