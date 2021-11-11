package org.modern.java.inaction.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Trader {
    private final String name;
    private final String city;

    @Override
    public String toString(){
        return "Trader:"+this.name + " in " + this.city;
    }
}
