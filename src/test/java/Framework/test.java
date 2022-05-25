package Framework;

public class test {

    public static void main(String[] args) {

        int n = 7;
        int i, j;
        for (i = 0; i < n; i++) {


            for (j = n - i; j > 1; j--)
                //7-0;7>0;7--
                //
                {
                    System.out.print(" ");
                }

                for (j = 0; j <= i; j++) {
                    System.out.print("* ");
                }
                System.out.println();
            }

        }
    }


