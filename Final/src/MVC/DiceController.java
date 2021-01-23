package MVC;

public class DiceController {
    private Dice model;
    private DiceView view;

    public DiceController(Dice model){
        this.model = model;
        this.view = null;
    }

    public void addModel(Dice model){
        this.model = model;
    }

    public void addView(DiceView view){
        this.view = view;
    }

    public void roll(){
        this.model.roll();
    }

    public int getD1(){return model.getD1();}
    public int getD2(){return model.getD2();}



}
