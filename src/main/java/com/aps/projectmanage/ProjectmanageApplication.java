package com.aps.projectmanage;

import com.aps.projectmanage.domain.entity.Project;
import com.aps.projectmanage.service.ProjectService;
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

	@Bean
	CommandLineRunner testProjectService(ProjectService projectService) {
		return args -> {
			System.out.println("🔹 Testing ProjectService...");

			// Tạo mới project
			Project project = new Project();
			project.setName("Project 1");
			project.setDescription("This is a test project.");
			Project savedProject = projectService.createProject(project);
			System.out.println("✅ Created Project: " + savedProject);

			// Lấy project theo ID
			Optional<Project> retrievedProject = projectService.getProjectById(savedProject.getId());
			System.out.println("🔍 Retrieved Project: " + retrievedProject.orElse(null));

			// Cập nhật project
			if (retrievedProject.isPresent()) {
				Project updateProject = retrievedProject.get();
				updateProject.setName("Updated Project Name");
				Project updatedProject = projectService.updateProject(updateProject);
				System.out.println("✅ Updated Project: " + updatedProject);
			}

			// Lấy tất cả projects
			System.out.println("📌 All Projects: " + projectService.getAllProjects());


			// Kiểm tra lại xem có tồn tại không
			Optional<Project> deletedCheck = projectService.getProjectById(savedProject.getId());
			System.out.println("🔍 Project Exists After Delete: " + deletedCheck.isPresent());
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ProjectmanageApplication.class, args);
	}

}
