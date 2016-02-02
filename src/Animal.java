class Animal
{
    String name;
    int legs;
    int arms;
    int tails;
    boolean burrow;
    boolean swim;
    boolean fly;

    Animal(String name, int legs, int arms, int tails, boolean burrow, boolean swim, boolean fly)
    {
        this.name = name;
        this.legs = legs;
        this.arms = arms;
        this.tails = tails;
        this.burrow = burrow;
        this.swim = swim;
        this.fly = fly;
    }

    public String getName()
    {
        return name;
    }

    public int getLegs()
    {
        return legs;
    }

    public int getArms()
    {
        return arms;
    }

    public int getTails()
    {
        return tails;
    }

    public boolean getBurrow()
    {
        return burrow;
    }

    public boolean getSwim()
    {
        return swim;
    }

    public boolean getFly()
    {
        return fly;
    }
}
