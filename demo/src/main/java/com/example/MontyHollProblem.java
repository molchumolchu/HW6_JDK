package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import lombok.Getter;


// Создать свой Java Maven или Gradle проект;
// Подключить зависимость lombok.
// Можно подумать о подключении какой-нибудь математической библиотеки для работы со статистикой
// Самостоятельно реализовать прикладную задачу;
// Сохранить результат в HashMap<шаг теста, результат>
// Вывести на экран статистику по победам и поражениям

public class MontyHollProblem {
    // 0 - лошади
    // 1 - авто
    public static ArrayList<Integer> list = new ArrayList<>();
    public static HashMap<Integer, String> resulList = new HashMap<>();
    public static int count = 0;
    public static int countWin = 0;
    public static int countLooser = 0;

    public static void main(String[] args) {
        
        gameProcess();
        gameProcess();
        gameProcess();
        gameProcess();
        gameProcess();

        System.out.println(resulList);

        System.out.println("\n Сыграно " +count+ " раз:\n Побед - "+countWin+"\n Поражений - " +countLooser);
    }
    


    //сборка игры
    public static void gameProcess(){
        init(list);
        // System.out.println(Arrays.toString(list.toArray()));
        // System.out.println(list.contains(1));// проверка наличия а/м
        // System.out.println(list.size()); // проверка размера
        
        int index = firstChoiseDoor(list);
        int num = list.get(firstChoiseDoor(list));

        System.out.println("Игрок выбрал дверь " + index + " за которой " + num +" (0-лошадь / 1- а/м)");

        gameRessult(list);
    }

    // метод инициализации 
    public static void init(ArrayList<Integer> list){
        for (int i = 0; i < 999; i++) {
            list.add(0);
        }
        list.add(new Random().nextInt(0,1000), 1);

        System.out.println("Список создан, а/м находится за " + list.indexOf(1) + " дверью");
    }

    // метод выбора игроком двери
    public static int firstChoiseDoor (ArrayList<Integer> list){
        int index = new Random().nextInt(0,1000);
        int num = list.get(index);
        return index;

    }

    // метод оставления 2-х дверей 
    public static void gameRessult (ArrayList<Integer> list){
        int indDoor1 = list.get(firstChoiseDoor(list));
        int indDoor2 = new Random().nextInt(0,1000);
        // System.out.println(indDoor2+" 1"); // для проверки

        if (indDoor1 == 1){
            while (list.get(indDoor2).equals(1)) {
                indDoor2= new Random().nextInt(0,1000);
            }
            System.out.println("Ведущий предложил дверь "+indDoor2 + " за которой "+ list.get(indDoor2)+" (0-лошадь / 1- а/м)");
        }

        else {
            indDoor2= list.indexOf(1);
            System.out.println("Ведущий предложил дверь "+indDoor2 + " за которой "+ list.get(indDoor2)+" (0-лошадь / 1- а/м)");
        } 

        lastChoise(indDoor1, indDoor2, list, count);
        count++;
        
    }


    // игрок выбирает между 2-мя оставшимися дверьми
    public static void lastChoise(int indDoor1, int indDoor2, ArrayList<Integer> list, int count){
        ArrayList<Integer> lastChoiseSheet = new ArrayList<>(Arrays.asList(indDoor1, indDoor2));
        int lastGameChoise = lastChoiseSheet.get(new Random().nextInt(0,2));
        if (list.get(lastGameChoise).equals(1)){
            countWin++;
            System.out.println("Игрок победил");
            resulList.put(count, "победа");
        }
        else {
            countLooser++;
            System.out.println("Игрок проиграл");
            resulList.put(count, "проигрыш");
        }
    }
}
