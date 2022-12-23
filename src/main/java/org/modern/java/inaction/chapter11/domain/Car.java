package org.modern.java.inaction.chapter11.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class Car {
    private Optional<Insurance> insurance;
}
