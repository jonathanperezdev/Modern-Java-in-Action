package org.modern.java.inaction.chapter11;

import org.modern.java.inaction.chapter11.domain.Car;
import org.modern.java.inaction.chapter11.domain.Insurance;
import org.modern.java.inaction.chapter11.domain.Person;

import java.util.Optional;

public class OptionalExtractAndTransform {
    public static void main(String[] args){
        Insurance insurance = new Insurance();
        insurance.setName("testInsurance");

        Car car = new Car();
        car.setInsurance(Optional.of(insurance));

        Person person = new Person();
        person.setCar(Optional.of(car));

        //Get insurance name all way
        String name;
        if(insurance.getName() != null){
            name = insurance.getName();
        }

        //Using map
        Optional<String> nameOpt = Optional.ofNullable(insurance)
                .map(Insurance::getName);

        //If I want to get person.car.insurance.name
        Optional<String> nameOptChain = Optional.of(person)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName);

        //Why not use map, cause if you use map(Person::getCar), you would get Optional<Car>, with flatmap, you get the content of the optional

    }
}
