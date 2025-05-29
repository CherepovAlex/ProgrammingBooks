package io.hexlet.dto.courses;

import io.hexlet.dto.BasePage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import io.hexlet.model.Course;

import java.util.List;

@AllArgsConstructor
@Getter
public class CoursesPage extends BasePage{
    private List<Course> courses;
    private String flash;
}