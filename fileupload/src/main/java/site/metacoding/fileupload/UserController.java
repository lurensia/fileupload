package site.metacoding.fileupload;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserRepository userRepository;

    @PostMapping("/user")
    public String join(JoinDto joinDto) { // 버퍼로 읽는거 1.Json 2.있는 그대로 받고 싶을 때

        UUID uuid = UUID.randomUUID();

        String requestFileName = joinDto.getFile().getOriginalFilename();
        System.out.println("전송받은 파일명" + requestFileName);

        String convertFileName = uuid + "_" + requestFileName;

        // 메모리에 있는 파일 데이터를 파일 시스템을 옮겨야 함.
        // 1.빈 파일 생성 haha.png
        // File file = new File("d:\\example\\file.txt");
        // 2.빈 파일에 스트림 연결
        // 3.for문 돌리면서 바이트로 쓰면 됨. FileWriter 객체
        try {
            // 1.폴더가 이미 만들어져 이썽야 함.
            // 2. 리눅스는 / 를 사용하고 윈도우는 \ 사용한다.
            // imgUrl = a.png(경로는 따로 저장해둬야한다.)
            // 3. 윈도우 : c:/upload/ 4. 리눅스 : /upload/
            // 우리는 상대경로 사용할 예정
            Path filePath = Paths.get("src/main/resources/static/upload/" + convertFileName);
            System.out.println(filePath);
            Files.write(filePath, joinDto.getFile().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return requestFileName;
    }
}