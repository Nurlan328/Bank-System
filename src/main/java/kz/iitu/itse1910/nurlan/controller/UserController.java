package kz.iitu.itse1910.nurlan.controller;

import kz.iitu.itse1910.nurlan.model.Users;
import kz.iitu.itse1910.nurlan.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping
public class UserController {

    RegistrationService registrationService;

    @Autowired
    public UserController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/profile/index")
    public String home(Model model) {
        List<Users> list =  registrationService.getAllUsers();

        model.addAttribute("list", list);
        return "profile/index";
    }

    @PostMapping("/profile/upload")
    public String fileUpload(@Param("username") String username,
                             @RequestParam("file") MultipartFile file,
                             Model model) throws IOException {
        registrationService.updatePhotoByUsername(file.getBytes(),username);
        model.addAttribute("success", "File Uploaded Successfully!!!");
        return "profile/index";
    }

    @GetMapping("/profile/downloadfile")
    public void downloadFile(@Param("id") int id ,
                             Model model,
                             HttpServletResponse response) throws IOException {
        Users temp = registrationService.findUserById(id);
        if(temp!=null) {
            Users student = temp;
            response.setContentType("application/octet-stream");
            String headerKey = "Content-Disposition";
            String headerValue = "attachment";
            response.setHeader(headerKey, headerValue);
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(student.getPhoto());
            outputStream.close();
        }
    }

    @GetMapping("/profile/image")
    public void showImage(@Param("id") int id, HttpServletResponse response, Users student)
            throws ServletException, IOException {

        student = registrationService.findUserById(id);
        response.setContentType("image/jpeg; image/jpg; image/png");
        response.getOutputStream().write(student.getPhoto());
        response.getOutputStream().close();
    }

    @GetMapping("/profile/image1")
    public void showImage1(@Param("username") String username, HttpServletResponse response, Users student)
            throws ServletException, IOException {
        student = registrationService.findByUsername(username);
        response.setContentType("image/jpeg; image/jpg; image/png");
        response.getOutputStream().write(student.getPhoto());
        response.getOutputStream().close();
    }


}
