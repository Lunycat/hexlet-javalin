package org.example.hexlet.dto.cars;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.hexlet.dto.BasePage;
import org.example.hexlet.model.Car;

import java.util.List;

@Getter
@AllArgsConstructor
public class CarsPage extends BasePage {

    private List<Car> cars;
}
