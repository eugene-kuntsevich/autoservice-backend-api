package com.app.service;

import static com.app.AppStorage.carIdGenerator;
import static com.app.AppStorage.cars;
import static com.app.util.ValidatorUtil.checkNullableIdentity;
import static com.app.util.ValidatorUtil.checkNullableObject;

import com.app.exception.NullableObjectIdentityException;
import com.app.exception.ObjectNotExistException;
import com.app.model.Car;
import com.app.service.api.CarService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

  @Override
  public Car findCarById(Long id) throws ObjectNotExistException {
    Car car = cars.get(id);
    checkNullableObject(car);
    return car;
  }

  @Override
  public List<Car> findAllCars() {
    return new ArrayList<>(cars.values());
  }

  @Override
  public Car findCarByNumber(String number) {
    return cars.values().stream().filter(car -> number.equals(car.getCarNumber())).findFirst()
        .orElse(null);
  }

  @Override
  public Long addCar(Car car) {
    Long newId = ++carIdGenerator;
    car.setId(newId);
    cars.put(newId, car);
    return newId;
  }

  @Override
  public void updateCar(Car car) throws NullableObjectIdentityException, ObjectNotExistException {
    Long carId = car.getId();
    checkNullableIdentity(carId);
    checkNullableObject(car);
    cars.put(carId, car);
  }

  @Override
  public void deleteCarById(Long carId) throws NullableObjectIdentityException {
    checkNullableIdentity(carId);
    cars.remove(carId);
  }
}
