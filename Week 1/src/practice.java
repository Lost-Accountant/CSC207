public class practice {
    // method 1
    public static int random(int i){
        int num = 99;
        if (i > num) {
            int temp = i;
            i = num;
            num = temp;
        } else {
            i = 0;
            num = 100;
        }
        return(i);
    }
    // method 2
    public static int mystery1(int n){
        int s = 0;
        int i = 2;
        while (i <= n){
            s = ++s;
            i = i + 2;
        }
        return(s);
    }
    // method 3
    public static int mystery2(int n){
        int s = 0;
        for(int i=1; i < n; i = i+2){
            s = ++s;
        }
        return(s);
    }
    public static void main(String[] args){
        System.out.println(random(5));
        System.out.println(mystery1(8));
        System.out.println(mystery2(8));
    }
}
