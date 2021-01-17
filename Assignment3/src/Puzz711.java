 public class Puzz711 {
        public static void main(String [] args){
            Puzz711 p=new Puzz711();
            System.out.println(p.solve711());
        }

        public String solve711() {
            double a, b, c, d;
            for (a = 0.00; a < 7.11; a = a + .01) {
                for (b = 0.00; b < 7.11; b = b + .01) {
                    for (c = 0.00; c < 7.11; c = c + .01) {
                        for (d = 0.00; d < 7.11; d = d + .01) {
                            System.out.println(a);
                            System.out.println(b);
                            System.out.println(c);
                            System.out.println(d);
                            if (a * b * c * d == 7.11 && a + b + c + d == 7.11) {
                                return (a + " " + b + " " + c + " " + d);
                            }
                        }
                    }
                }
            }
            return "";
        }
        // Doesn't solve the problem since d is accumulated first, and this will make d a relatively large
     // number eventually, near the end of loop of d, when adding with a, b, and c, which are still small.
     // When double numbers with decimals are added with big double numbers, some information for small double
     // numbers would be lost due to limited info storing space, causing the final sum to be inaccurate. Therefore,
     // the sum will likely not be 7.11 exactly, which makes the loop non-stoppable.
}
