// Builder Pattern

public class Pizza {
    private String name;
    private boolean extraCheese, extraSauce, pepperoni;

    public Pizza(String name){
        this.name = name;

        // default customization
        this.extraCheese = false;
        this.extraSauce = false;
        this.pepperoni = false;
    }

    public void setExtraCheese(boolean extraCheese){
        this.extraCheese = extraCheese;
    }

    public void setExtraSauce(boolean extraSauce){
        this.extraSauce = extraSauce;
    }

    public void setPepperoni(boolean pepperoni){
        this.pepperoni = pepperoni;
    }

    public String toString(){
        return(this.name + " Extra Sauce: " + this.extraSauce +
                " Extra Cheese: " + this.extraCheese +
                " Pepperoni: " + this.pepperoni);
    }
}
