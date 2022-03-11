package site.metacoding.serverproject.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import site.metacoding.serverproject.domain.Hospital;
import site.metacoding.serverproject.domain.HospitalRepository;

@RequiredArgsConstructor
@Controller
public class DownloadController {

    private final HospitalRepository hospitalRepository;

    @GetMapping("/")
    public String main() {

        return "download";
    }

    @GetMapping("/download")
    public String download(Model model) {

        // 1. DB 연결
        RestTemplate rt = new RestTemplate();
        Hospital[] response = rt.getForObject("http://3.38.254.72:5000/api/hospital?sidoCdNm=부산&sgguCdNm=부산사하구",
                Hospital[].class);

        List<Hospital> hosList = Arrays.asList(response);

        // System.out.println("============" + hosList.get(0));

        // DB에 saveAll() 호출
        hospitalRepository.saveAll(hosList);

        // 1. HospitalRepository의 findAll() 호출
        // 2. model에 담기
        // model.addAttribute("hospitals", hospitalRepository.findAll());
        model.addAttribute("hospitals", hosList);

        // 3. mustache 파일에 뿌리기

        return "list";
    }

}
