package hello.hellospring.controller;

//실무에서 약관 정보, 부가정보 등을 회원가입 때 한 번에 받기 때문에 form 형식으로 받는 것이 좋다.
public class MemberForm {
    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

}