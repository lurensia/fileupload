package site.metacoding.ex1.web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class Ex1Controller {

    @GetMapping
    public String test0() {
        return "<h1>Test<h1/>";
    }

    @PostMapping
    public String test1() {
        return "<h1>Test<h1/>";
    }

    @PutMapping
    public String test2() {
        return "<h1>Test<h1/>";
    }

    @DeleteMapping
    public String test3() {
        return "<h1>Test<h1/>";
    }
}
