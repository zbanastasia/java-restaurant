package Restaurant;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Table> tables = new ArrayList<>();
    public static Menu menu = new Menu();

    public static void openTables() { //создаем 7 столиков
        for (int i = 1; i < 7; i++) {
            Table some = new Table(i);
            tables.add(some);
        }
    }

    public static void showTables() { // вывод информации о столиках

        for (Table str : tables) {
            if (str.taken) {
                System.out.print(str.number + " Занят | ");

            } else {
                System.out.print(str.number + " Свободен | ");

            }
        }
        System.out.println("");
    }

    public static void serveTable(int pick) { // обслуживание столика (добавление блюд)
        Scanner sc = new Scanner(System.in);
        menu.showMenu();
        tables.get(pick - 1).takeTable();
        System.out.println("Выберите блюда (для выхода выберите 10): ");
        //System.out.println("Для выхода выберите 10 ");
        int dish = 1;
        while (dish != 10) {
            dish = sc.nextInt();
            if (dish == 10) {
                break;
            }
            tables.get(pick - 1).addDish(dish - 1);
        }
        tables.get(pick - 1).showInfo();

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        openTables();
        for(int i=0;i<10;i++) {
            System.out.print("1 - Рассчитать столик  |  ");
            System.out.print("2 - Cоздать заказ  |  ");
            System.out.print("3 - Добавить заказ  |  ");
            System.out.println("4 - Информация о столиках");
            int t = sc.nextInt();

            if(t<1 || t>4){
                System.out.print("Неверное число!");
            }

            if (t == 1) {
                System.out.println("Какой стол рассчитать? ");
                int table = sc.nextInt();
                if(table<1 || table >6){
                    System.out.println("Неверное число!");
                }
                else{tables.get(table - 1).closeTable();}
            }
            if (t == 2) {
                showTables();
                System.out.println("Выбери стол: ");
                int table = sc.nextInt();
                if(table<1 || table >6){
                    System.out.println("Неверное число!");
                }
                else if(!tables.get(table-1).taken) {
                    tables.get(table-1).takeTable();
                    serveTable(table);
                }

            }
            if(t==3){
                showTables();
                System.out.println("Куда добавить заказ? ");
                serveTable(sc.nextInt());
            }
            if (t == 4) {
                showTables();
            }
        }


    }
}
