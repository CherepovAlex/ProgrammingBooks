package io.hexlet.dto.cars;

import io.hexlet.model.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CarPage {
    private Car car;
}
