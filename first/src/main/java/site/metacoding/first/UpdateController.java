package site.metacoding.first;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UpdateController {

    @GetMapping("/updateForm")
    public String update() {
        return "updateForm";
    }
}
