public class Rectangle {
    private int x,y;
    private int width, height;

    // Constructor when complete input
    public Rectangle(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    // Constructor when no input
    public Rectangle(){
        // this: calls complete constructor
        this(0, 0, 1, 1);
    }

    // Constructor when width and height provided
    public Rectangle(int width, int height) {
        // this: calls complete constructor
        this(0, 0, width, height);
    }
}
