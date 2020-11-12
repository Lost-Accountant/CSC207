public class BuilderExample {

    public static void main(String [] args){
        Pizza a = new PizzaBuilder("My Pizza").addExtraCheese().addExtraSauce().addPepperoni().getPizza();
        System.out.println(a.toString());
    }
}
