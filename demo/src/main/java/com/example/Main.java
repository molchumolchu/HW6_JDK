package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.util.ArithmeticUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class Main {
    public static void main(String[] args) {
        // System.out.println("Hello world!");
        double [] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics(array);
        System.out.println("Min mean "+ descriptiveStatistics.getMin());
        System.out.println("Max mean "+ descriptiveStatistics.getMax());
        System.out.println("Sum mean "+ descriptiveStatistics.getSum());
        System.out.println("Avarage mean "+ descriptiveStatistics.getMean());
        System.out.println("------------------");
        System.out.println("Factorial 5 = "+ArithmeticUtils.factorial(5));
        System.out.println("Наибольший общее частное 10 и 30 ="+ArithmeticUtils.lcm(10, 30));
        System.out.println("Наименьшее  делитель 10 и 30 ="+ArithmeticUtils.gcd(10, 30));
        System.out.println("16 число в степени 2? "+ArithmeticUtils.isPowerOfTwo(16));
        System.out.println("------------------");

        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(7,8,9,10,11,6,8,5,3));
        System.out.println(Lists.reverse(list));
        System.out.println(Lists.charactersOf("list"));
        System.out.println(Lists.partition(list, 2));
        System.out.println("объединение"+Sets.union(Set.copyOf(list), Set.copyOf(list2)));
        System.out.println("пересечение"+Sets.intersection(Set.copyOf(list), Set.copyOf(list2)));
        System.out.println("непересечение"+Sets.symmetricDifference(Set.copyOf(list), Set.copyOf(list2)));


    }
}