package Restaurant;

import java.util.ArrayList;

public class Table {

    int number;
    boolean taken = false; // проверка занят ли столик
    public static ArrayList<String> dishesForTable = new ArrayList<String>(); //список блюд для одного стола

    Table(int number){
        this.number = number;
    }


    public void takeTable(){ //занимаем столик
        if(taken){
          //  System.out.println("Стол занят");
        }
        else {
            taken = true;
        }
    }

    public void addDish(int i){ // добавить блюдо
        dishesForTable.add(Menu.menu.get(i));
    }

    public void showInfo(){ //вывод информации о столике
        if(taken){
            System.out.println("Столик номер " + number+  " занят");
            for (String str: dishesForTable) // выводим список блюд заказанных на столик
            {
                System.out.println(" "+str);
            }
        }
        else{
            System.out.print("Свободен");
        }
    }

    public void closeTable(){ // рассчет стола
        if(taken) {
            int schet = 0;
            for (String str : dishesForTable) {
                schet += Menu.menuPrice.get(str);
            }
            System.out.println("Счет " + schet + "р.");
            taken = false; // освобождаем стол
        }
        else{
            System.out.println("Столик не занят!");
        }


    }
}
