// Builder pattern

public class PizzaBuilder {
    private String name;

    // default option
    private boolean extraSauce = false;
    private boolean extraCheese = false;
    private boolean pepperoni = false;
    private boolean tomatoes = false;
    private boolean pineapple = false;

    public PizzaBuilder(String name){
        this.name = name;
    }

    // customization methods
    public PizzaBuilder addExtraSauce(){
        this.extraSauce = true;
        return this;
    }

    public PizzaBuilder addExtraCheese(){
        this.extraCheese = true;
        return this;
    }

    public PizzaBuilder addPepperoni(){
        this.pepperoni = true;
        return this;
    }

    // Build a customized Pizza
    public Pizza getPizza(){
        Pizza p = new Pizza(this.name);
        p.setExtraCheese(extraCheese);
        p.setExtraSauce(extraSauce);
        p.setPepperoni(pepperoni);
        return p;
    }
}
