package org.modern.java.inaction.quiz37;

@FunctionalInterface
public interface TriFunction<T,U> {
    T apply(U red, U green, U blue);
}
