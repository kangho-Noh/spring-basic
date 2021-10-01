package hello.hellospring.domain;

import javax.persistence.*;

@Entity
public class Member {

    //pk 설정정보. IDENTITY 방식은 pk를 직접 입력이 아닌 db가 알아서 설정하는 것을 말함.
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 데이터를 구분하기 위한 id.. long이 아닌 Long인 이유 -> Long은 null을 사용할 수 있음

    // @Column(name = "username") // name과 DB에서 username이라는 컬럼명을 매핑
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
