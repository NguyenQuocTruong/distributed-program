package algorithmCodeLearn;

import java.util.ArrayList;
import java.util.List;

public class FindSntMaxBetweenTwoNumber {
    private static int greatestCommonPrimeDivisor(int a, int b)
    {   int maxSnt = -1, count = 0;
        List<Integer> lst = new ArrayList<>();

        if(a > b){
            for(int i = 2; i<= b; i++){
                if((a % i == 0 ) && (b % i == 0)){
                    for(int j = 2; j <= i; j++){
                        if(i % j == 0 )
                            count ++;
                    }
                    if (count <= 1)
                        lst.add(i);
                }
            }
        }

        if( a < b ){
            for(int i = 2; i<= a; i++){
                if((a % i == 0 ) && (b % i == 0)){
                    for(int j = 2; j <= i; j++){
                        if(i % j == 0 )
                            count ++;
                    }
                    if (count <= 1)
                        lst.add(i);
                }
            }
        }

        if( a == b ){
            for(int i = 2; i <= a; i++){
                if((a % i == 0 ) && (b % i == 0)){
                    for(int j = 2; j <= i; j++){
                        if(i % j == 0 )
                            count ++;
                    }
                    if (count <= 1)
                        lst.add(i);
                }
            }
        }

        for(int i = 0; i< lst.size(); i++){
//            System.out.print(lst.get(i) + " ");
            if(maxSnt < lst.get(i)){
                maxSnt = lst.get(i);
            }
        }
        System.out.println();

        return maxSnt;
    }

    public static void main(String[] args) {
        /*for(int i = 2; i <= 150; i++ ){
            for (int j = 2 ; j<= 150; j++)
                System.out.println("max snt [" + i + "][" + j+ "] === " + greatestCommonPrimeDivisor(i, j));
        }*/

        System.out.println("max snt = " + greatestCommonPrimeDivisor(100, 140));

    }
}
