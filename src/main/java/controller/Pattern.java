package controller;

public interface Pattern {
    String LOGIN = "([a-zA-Z0-9])+{5,}";
    String PASSWORD = "([a-zA-Z0-9])+{5,}";
    String EMAIL = "([A-Za-z0-9_.-])+@([A-z0-9_.-])+.([A-z])+";
    String ANIMAL = "([a-zA-Z0-9\\s_.,-])*";
    String BREED = "([a-zA-Z0-9\\s_.,-])*";
    String NAME = "([a-zA-Z0-9\\s_.,-])*";
    String AGE = "([a-zA-Z0-9\\s_.,-])*";
    String WEIGHT = "([a-zA-Z0-9\\s_.,-])*";
    String NUMBERPHONE = "([\\+a-zA-Z0-9])+{11,}";
    String SEARCH = "([a-zA-Z0-9\\s_.,-])*";
}
