package Restaurant;
import java.util.ArrayList;
import java.util.HashMap;

public class Menu {
    public static HashMap<String, Integer> menuPrice = new HashMap<String, Integer>(); // блюда и цены на них для рассчета столика
    public static ArrayList<String> menu = new ArrayList<>(); // сами блюда

    Menu(){
        menuPrice.put("Суп", 500); //инициализируем цены и меню
        menuPrice.put("Салат", 500);
        menuPrice.put("Второе", 600);
        menuPrice.put("Напиток", 400);
        menuPrice.put("Десерт", 900);
        menu.add("Суп");
        menu.add("Салат");
        menu.add("Второе");
        menu.add("Напиток");
        menu.add("Десерт");

    }
    public void showMenu(){ // показываем меню
        int i = 1;
        System.out.println("   Меню    ");
        for (String str: menu)
        {
            String space = " ";
            for(int a =0;a<(10-str.length());a++){
                space += " ";
        }
            System.out.println(i + " "+str + space + Menu.menuPrice.get(str)+ "р.");
            i++;
        }
    }


}
