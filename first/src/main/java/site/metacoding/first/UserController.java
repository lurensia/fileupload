package site.metacoding.first;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    Dog d;

    // Di라고 함. ioC컨테이너에 있으니까 주입해 줄 수 있음
    // Dependency injection 의존성 주입
    public UserController(Dog d, HttpServletRequest request) {
        System.out.println("usercontroller 생성자 생성됨");
        this.d = d;
        System.out.println(d.getName());
    }

    @GetMapping("/home")
    public void home() {
        System.out.println("home~~~~~~~~~~~~~~");
    }

    @GetMapping("/bye")
    public void bye() {
        System.out.println("bye~~~~~~~~~~~~~~~");

    }

    @GetMapping("/bye2")
    public String bye2() {
        return "<h1>bye</h1>"; // printWriter -> write -> flush
    }
}
