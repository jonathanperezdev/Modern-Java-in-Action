package org.modern.java.inaction.quiz37;

public class ConstructorReference {
    public void main(String args[]){
        TriFunction<RGB, Integer> triFunc = RGB::new;
        RGB rgb = triFunc.apply(10,10,10);
    }
}
