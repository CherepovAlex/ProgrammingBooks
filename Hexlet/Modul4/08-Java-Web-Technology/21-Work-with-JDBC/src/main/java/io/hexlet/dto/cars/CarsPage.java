package io.hexlet.dto.cars;

import io.hexlet.model.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class CarsPage {
    private List<Car> cars;
}
