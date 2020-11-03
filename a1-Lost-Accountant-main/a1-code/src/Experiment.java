import static org.junit.Assert.assertEquals;

public class Experiment {


    public static void main (String [] args){
        Othello o;
        Move[] moves = { new Move(2, 4), new Move(2, 5), new Move(2, 6), new Move(2, 3), new Move(2, 2), new Move(3, 2),
                new Move(4, 2), new Move(5, 4), new Move(6, 4) };

        o = new Othello();

        for(int i=0;i<moves.length;i++) {
            System.out.println("During play" + o.isGameOver());
            System.out.println(o.getBoardString());
            o.move(moves[i].getRow(), moves[i].getCol());
        }
        System.out.println(o.getBoardString());
        boolean result = o.isGameOver();
        System.out.println("After winner" + o.isGameOver());
    }
}
