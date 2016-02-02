import java.util.MissingResourceException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.*;
import java.util.Scanner;


public class UI
{
    private static final UI instance = new UI();
    private Locale locale;
    private ResourceBundle rb;
    private Scanner input;

    private UI()
    {
        input = new Scanner(System.in);
        init("en");
    }

    public static final UI getInstance()
    {
        return instance;
    }

    public void init(String ccode)
    {
        locale = new Locale(ccode);
        rb = ResourceBundle.getBundle("Strings", locale);
    }

    public Code translateCode(String c)
    {
        if(c.equals(rb.getString("menu.code.inspect"))) return Code.INSPECT;
        if(c.equals(rb.getString("menu.code.add"))) return Code.ADD;
        if(c.equals(rb.getString("menu.code.edit"))) return Code.EDIT;
        if(c.equals(rb.getString("menu.code.delete"))) return Code.DELETE;
        if(c.equals(rb.getString("menu.code.exit"))) return Code.EXIT;
        return Code.INVALID;
    }


    // Output methods
    //
    private String getLocalized(String s)
    {
        try
        {
            return rb.getString(s);
        }
        catch(MissingResourceException e) {}
        return s;
    }

    public void print(String s)
    {
        System.out.print(getLocalized(s));
    }

    public void displayMenu()
    {
        print("menu");
    }

    public void displayAnimal(Animal animal)
    {
        String out =
        "================\n" +
        getLocalized("animal.name") + ": " + animal.getName() + "\n" +
        getLocalized("animal.legs") + ": " + animal.getLegs() + "\n" +
        getLocalized("animal.arms") + ": " + animal.getArms() + "\n" +
        getLocalized("animal.tails") + ": " + animal.getTails() + "\n" +
        getLocalized((animal.getBurrow() ? "animal.does.burrow" : "animal.not.burrow")) + "\n" +
        getLocalized((animal.getSwim() ? "animal.does.swim" : "animal.not.swim")) + "\n" +
        getLocalized((animal.getFly() ? "animal.does.fly" : "animal.not.fly")) + "\n" +
        "================\n";

        System.out.print(out);
    }


    // User Input methods
    //
    public String getInput(String prompt)
    {
        print(prompt);
        print("> ");
        return input.nextLine();
    }
    public int getInt(String prompt)
    {
        String newPrompt = prompt;
        int in;
        do
        {
            try
            {
                in = Integer.parseInt(getInput(newPrompt));
                return in;
            }
            catch(NumberFormatException e) {}
            newPrompt = "prompt.invalid";
        }
        while(true);
    }
    public int getInt(String prompt, int max)
    {
        String newPrompt = prompt;
        int in = max+1;
        do
        {
            try
            {
                in = getInt(newPrompt);
            }
            catch(NumberFormatException e) {}
            newPrompt = "prompt.range";
        }
        while(in > max-1 || in < 0);
        return in;
    }
    public boolean getBool(String prompt)
    {
        return getInput(prompt).substring(0).toUpperCase().equals(getLocalized("menu.code.yes")) ? true : false;
    }
}

enum Code
{
    INSPECT,
    ADD,
    EDIT,
    DELETE,
    EXIT,
    INVALID
}
