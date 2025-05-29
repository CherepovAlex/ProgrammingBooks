package io.hexlet.dto.courses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import io.hexlet.model.Course;

@AllArgsConstructor
@Getter

public class CoursePage {
    private Course course;
}
