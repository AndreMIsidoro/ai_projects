package com.andreisidoro;

import java.util.List;

import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.andreisidoro.mcp.service.CourseService;

@SpringBootApplication
public class CoursesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoursesApplication.class, args);
    }

    @Bean
    public List<ToolCallback> myTools(CourseService courseService) {
        return List.of(ToolCallbacks.from(courseService));
    }
} 