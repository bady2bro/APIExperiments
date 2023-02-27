package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        IntStream.range(22,30).forEach(System.out::print);
        System.out.println("\nBye world!");
        IntStream.range(100, 135).skip(6).forEach(System.out::print);
        System.out.println("\nSum world!");
        System.out.print(IntStream.range(1,5).sum());
        List<Integer> list = IntStream.range(2,9).filter(n->n<8).boxed().toList();
        List<String> result = Stream.of(Locale.getISOCountries()).toList();
        System.out.println("\nAny stream world!");
        Stream.of("1",'3',"234").findFirst().ifPresent(System.out::println);
        Stream.of("1",'3',"234").skip(1).findAny().ifPresent(System.out::println);
        System.out.println("\nSorted stream world!");
        Stream.of("3","234","1").sorted().findFirst().ifPresent(System.out::println);
        System.out.println("\nArray stream world!");
        String[] sArray={"Asd","asd","abd","fwew","bbts","ntef"};
        Arrays.stream(sArray).filter(s->s.startsWith("a")).sorted().forEach(System.out::println);
        System.out.println();
        Arrays.stream(sArray).filter(s->s.toLowerCase().startsWith("a")).sorted(String::compareToIgnoreCase).forEach(System.out::println);
        System.out.println("\nAverage stream world!");
        Arrays.stream(new double[] {2.3,3.5,5.5}).map(x->x*x).average().ifPresent(System.out::println);
        System.out.println("\nList stream world!");
        List<String> sList=Arrays.asList("Asd","asd","abd","fwew","bbts","ntef","Baba");
        sList.stream().map(String::toLowerCase).filter(s->s.startsWith("b")).sorted().forEach(System.out::println);
        System.out.println("\nFile stream world!");
        Stream<String> sFile= Files.lines(Paths.get("C:\\Users\\apintea\\IdeaProjects\\tset-tester-challenge\\my-first-rest-api\\src\\main\\resources\\test.txt"));
        sFile.sorted().forEach(System.out::println);
        sFile.close();
    }
}