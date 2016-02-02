// ArrayList Program
// Gordon Doskas
// PRG/421
// February 1, 2016
// Roland Morales

// This program allows for the manipulation of animal objects that each contain the
// properties of number of legs, arms, and tails; and whether or not they burrow,
// swim, and fly.
//
// A menu system allows for the users to add an animal, inputing these properties
// (for the bools, a y or Y indicates true, all others false). It also allows
// animals to be edited and deleted.

import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        UI ui = UI.getInstance();
        if(args.length > 0 && args[0] != null)
        {
            ui.init(args[0]);
        }

        ArrayList<Animal> animals = new ArrayList<Animal>();

        int menu = 1;
        do
        {
            ui.displayMenu();

            switch(ui.translateCode(ui.getInput("").substring(0).toUpperCase()))
            {
                case INSPECT:
                    ui.print("menu.inspect");
                    for(int i = 0; i < animals.size(); i++)
                    {
                        ui.print((i+1) + " - " + animals.get(i).getName() + "\n");
                    }
                    menu = ui.getInt("", animals.size()+1);
                    if(menu > 0)
                    {
                        ui.displayAnimal(animals.get(menu-1));
                    }
                    menu = 1;

                    break;

                case ADD:
                    animals.add(new Animal
                    (
                        ui.getInput("animal.name"),
                        ui.getInt("animal.legs"),
                        ui.getInt("animal.arms"),
                        ui.getInt("animal.tails"),
                        ui.getBool("animal.burrow"),
                        ui.getBool("animal.swim"),
                        ui.getBool("animal.fly")
                    ));
                    break;

                case EDIT:
                    ui.print("menu.edit");
                    for(int i = 0; i < animals.size(); i++)
                    {
                        ui.print((i+1) + " - " + animals.get(i).getName() + "\n");
                    }
                    menu = ui.getInt("", animals.size()+1);
                    if(menu > 0)
                    {
                        animals.set(menu-1, new Animal(
                            ui.getInput("animal.name"),
                            ui.getInt("animal.legs"),
                            ui.getInt("animal.arms"),
                            ui.getInt("animal.tails"),
                            ui.getBool("animal.burrow"),
                            ui.getBool("animal.swim"),
                            ui.getBool("animal.fly")
                        ));
                    }
                    menu = 1;
                    break;

                case DELETE:
                    ui.print("menu.delete");
                    for(int i = 0; i < animals.size(); i++)
                    {
                        ui.print((i+1) + " - " + animals.get(i).getName() + "\n");
                    }
                    menu = ui.getInt("", animals.size()+1);
                    if(menu > 0)
                    {
                        animals.remove(menu-1);
                    }
                    menu = 1;
                    break;

                case EXIT:
                    ui.print("goodbye");
                    menu = 0;
                    break;
            }
        }
        while(menu != 0);
    }
}
