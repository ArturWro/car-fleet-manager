package pl.groupproject.carfleet.service;

import static java.util.Objects.nonNull;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.assertj.core.util.Preconditions;
import org.springframework.stereotype.Service;
import pl.groupproject.carfleet.dto.CarDto;
import pl.groupproject.carfleet.dto.CarInformationDto;
import pl.groupproject.carfleet.dto.CarSelectDto;
import pl.groupproject.carfleet.dto.VinObject;
import pl.groupproject.carfleet.exception.CarException;
import pl.groupproject.carfleet.model.Car;
import pl.groupproject.carfleet.repository.CarRepository;

@Service
@RequiredArgsConstructor
public class CarService {

  private final CarRepository carRepository;

  // zweryfikuj logike czy podawales do tej pory id podczas tworzenia auta, jezeli tak to trzeba zrobic tak zeby to hibernate utowrzyl ID a nie my musimy o tym myslec
  public VinObject createCar(CarInformationDto carDto) {
    Preconditions.checkArgument(nonNull(carDto.getVinNr()), "VIN number cannot be null");

    if (carWithVinNumberExists(carDto)) {
      throw new CarException("Car with id: " + carDto.getId() + " does not exists");
    }

    CarDto carToPersist = CarDto.builder()
        .carBrand(carDto.getCarBrand())
        .carModel(carDto.getCarModel())
        .initialMileage(carDto.getInitialMileage())
        .finaleMileage(carDto.getFinaleMileage())
        .vinNr(carDto.getVinNr())
        .amountOfFuel(carDto.getAmountOfFuel())
        .build();
    //dolozyc mapper ktory zmapuje nam obiekt carToPersist na CarEntity i zapisze ponizej
    carRepository.save(mapCarDtoToCarEntity(carToPersist));
    return VinObject.builder()
        .withVinNumber(carDto.getVinNr())
        .build();
  }

  private boolean carWithVinNumberExists(CarInformationDto carDto) {
    return carRepository.findById(carDto.getId()).isPresent();
  }


  private CarDto mupToDto(Car car) {
    return CarDto.builder()
        .id()
        .build();
    //pozbywamy sie konstruktora pisanego przez new(...)
    return new CarDto(car.getId(), car.getCarBrand(), car.getCarModel(), car.getVinNr(),
        car.isReservation(), car.getCarUpdate(), car.getDeleteCar());
  }

  public List<CarSelectDto> getAllForSelect() {
    return carRepository.findAll().stream()
        .map(car -> new CarSelectDto(car.getId(), car.getVinNr()))
        //toSet()
        .collect(Collectors.toList());
  }

  public List<CarDto> getAll() {
    return carRepository.findAll()
        .stream()
        .map(this::mupToDto)
        .collect(Collectors.toList());
    //toSet()
  }

  public CarInformationDto getInformationAboutCar(Long id) {
    Car car = carRepository.findById(id)
        //eng
        .orElseThrow(() -> new IllegalStateException("Nie istnieje auto z podanym id"));

    return CarInformationDto.builder()
        .withId(car.getId())
        .withCarBrand(car.getCarBrand())
        .withCarModel(car.getCarModel())
        .withInitialMileage(car.getInitialMileage())
        .withFinaleMileage(car.getFinaleMileage())
        .withVinNr(car.getVinNr())
        .withAmountOfFuel(car.getAmountOfFuel())
        .build();
  }

  public void makeReservation(String id) {
    Optional<Car> byId = carRepository.findById(Long.valueOf(id));
    Car car = byId.get();
    //nie mozemy robic get() jak nie upewnimy sie czy get istnieje, musimy uzyc metody ifPresent() z Optional
    car.setReservation(!car.isReservation());
    //zamiast set to zrobmy obiekt z tego i builder()
    carRepository.save(car);
  }


  //lepiej zwrocic cos z tej metody np, VIN, albo ID albo ogolnie detale usunieto auta a nie sam void bez logowania itp.
  public void deleteCar(Long id) {
    carRepository.deleteById(id);
  }


}
