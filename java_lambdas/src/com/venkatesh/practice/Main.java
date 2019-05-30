package com.venkatesh.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(
                new Person("Venkatesh", "Devale", 24),
                new Person("Rohit", "Shrishrimal", 25),
                new Person("Pradnyesh", "Patil", 26)
        ) ;

        //Sort list by last name
        Collections.sort(personList, (p1, p2) -> p1.getLastName().compareToIgnoreCase(p2.getLastName()));

        //Printing all the list
        //System.out.println(personList);

        //Print only elements starting with 'c' or any other condition
        printConditionally(personList, (person) -> person.getLastName().startsWith("D"));

    }

    public static void printConditionally(List<Person> personList, Condition condition) {
        for(Person person: personList) {
            if(condition.test(person)) {
                System.out.println(person);
            }
        }
    }


}

interface Condition {
    boolean test(Person person);
}
