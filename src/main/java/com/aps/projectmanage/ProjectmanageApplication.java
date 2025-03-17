package com.aps.projectmanage;

import com.aps.projectmanage.domain.entity.Project;
import com.aps.projectmanage.domain.entity.User;
import com.aps.projectmanage.service.ProjectService;
import com.aps.projectmanage.service.UserService;
import com.aps.projectmanage.service.impl.ProjectServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@SpringBootApplication
public class ProjectmanageApplication {
    @RequestMapping("/")
    String home() {

        return "Hello world";
    }

    public static void main(String[] args) {
        SpringApplication.run(ProjectmanageApplication.class, args);
    }

}
