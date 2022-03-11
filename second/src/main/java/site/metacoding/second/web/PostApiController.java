package site.metacoding.second.web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class PostApiController {

    // 데이터만 주는것을 API컨트롤러라고 한다.

    // 구체적으로 뭘 달라고 요청!! - body x

    @GetMapping("/post/{id}")
    public String Post1(@PathVariable int id) {
        return "주세요 id : " + id;
    }

    // Select +FROM post WHERE title = ?
    // 구체적으로 뭘 달라고 요청!! - body x
    // http://localhost:8000/post?tltle=?
    @GetMapping("/post")
    public String search(String title) {
        return "";
    }

    // http://localhost:8000/post
    // body : title=제목1&content=내용1
    // header : Content-Type : application/x-www-form-urlencoded
    // 멀 줘야 함 - body O
    // request.getParameter() 메서드가 스프링 기본 파싱 전략
    @PostMapping("/post")
    public String test2(String title, String content) {
        return "줄께요 : title : " + title + ", content : " + content;
    }

    // http://localhost:8000/post

    // UPDATE post SET title = ?,content =? WHERE id =?
    // title.content(primary Key:id)
    // 뭘 줘야 함 - body o
    @PutMapping("/post/{id}")
    public String test3(String title, String content, @PathVariable int id) {
        return "수정해줄게요 title : " + title + ", content : " + content + ",id : " + id;
    }

    // http://localhost:8000/post?title=제목1
    // DELETE from post WHERE title = ?

    // http://localhost:8000/post/1
    // DELETE from post WHERE id = ?
    // 구체적으로 뭘 삭제해야함 - body o
    @DeleteMapping("/post/{id}")
    public String Post4(@PathVariable int id) {
        return "삭제해줄게요 id : " + id;
    }

    // http://localhost:8000/post?title=제목1
    // DELETE from post WHERE title = ?
    // 구체적으로 뭘 삭제해야함 - body o
    @DeleteMapping("/post")
    public String Post5(String title) {
        return "삭제해줄게요 title : " + title;
    }
}
