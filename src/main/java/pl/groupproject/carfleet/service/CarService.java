package pl.groupproject.carfleet.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.groupproject.carfleet.dto.CarInformationDto;
import pl.groupproject.carfleet.dto.CarSelectDto;
import pl.groupproject.carfleet.dto.CarsDto;
import pl.groupproject.carfleet.model.Car;
import pl.groupproject.carfleet.repository.CarRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public void createOrUpdateCar(CarInformationDto car) {
        Car carEntity;
        if (car.getId() != null) {
            carEntity = carRepository.findById(car.getId()).orElseThrow(() -> new IllegalStateException("Nie istnieje auto z podanym id"));
            carEntity.setCarBrand(car.getCarBrand());
            carEntity.setCarModel(car.getCarModel());
            carEntity.setInitialMileage(car.getInitialMileage());
            carEntity.setFinaleMileage(car.getFinaleMileage());
            carEntity.setVinNr(car.getVinNr());
            carEntity.setAmountOfFuel(car.getAmountOfFuel());
        } else {
            carEntity = Car.builder()
                    .carBrand(car.getCarBrand())
                    .carModel(car.getCarModel())
                    .initialMileage(car.getInitialMileage())
                    .finaleMileage(car.getFinaleMileage())
                    .vinNr(car.getVinNr())
                    .amountOfFuel(car.getAmountOfFuel())
                    .build();
        }
        carRepository.save(carEntity);
    }


    private CarsDto mupToDto(Car car) {
        return new CarsDto(car.getId(), car.getCarBrand(), car.getCarModel(), car.getVinNr(), car.isReservation(), car.getCarUpdate(), car.getDeleteCar());
    }

    public List<CarSelectDto> getAllForSelect() {
        return carRepository.findAll().stream()
                .map(car -> new CarSelectDto(car.getId(), car.getVinNr()))
                .collect(Collectors.toList());
    }

    public List<CarsDto> getAll() {
        return carRepository.findAll().stream().map(this::mupToDto).collect(Collectors.toList());
    }

    public CarInformationDto getInformationAboutCar(Long id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new IllegalStateException("Nie istnieje auto z podanym id"));

        return CarInformationDto.builder()
                .id(car.getId())
                .carBrand(car.getCarBrand())
                .carModel(car.getCarModel())
                .initialMileage(car.getInitialMileage())
                .finaleMileage(car.getFinaleMileage())
                .vinNr(car.getVinNr())
                .amountOfFuel(car.getAmountOfFuel())
                .build();
    }

    public void makeReservation(String id) {
        Optional<Car> byId = carRepository.findById(Long.valueOf(id));
        Car car = byId.get();
        car.setReservation(!car.isReservation());
        carRepository.save(car);
    }


//    public void updateCar(String id) {
//        Optional<Car> updateById = carRepository.findById(Long.valueOf(id));
//        Car car = updateById.get();
//        carRepository.save(car);
//    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }


}
