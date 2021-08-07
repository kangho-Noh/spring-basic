package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!");
        return "hello";
    }

    @GetMapping("hello-mvc") //@RequestParam에서 name은 query key 이름 정하는 변수, required는 쿼리가 필수인지 아닌지.
    public String helloMvc(@RequestParam(name = "key", required=false) String name, Model model){ //cmd+p 파라미터 정보 알 수 있는 커맨드!! 많이 쓰임
        model.addAttribute("name", name); //"name"은 view에서 쓰이는 변수 이름 ${name}, name은 query key이름을 String으로 담고 있는 변수
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello "+name;
    }

    //json 형식으로 api 생성
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name; //key

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}
