package site.metacoding.fileupload;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class JoinDto {
    private String username; // form 태그 name = "username"
    private MultipartFile file; // form 태그 name = "username"
}
