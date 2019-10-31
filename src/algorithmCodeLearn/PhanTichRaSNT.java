package algorithmCodeLearn;

import java.util.ArrayList;
import java.util.List;

/*
* Nhập vào một số nguyên n
* Phân tích n thành tích của các thừa số nguyên tố
* Ví dụ: nhập vào n = 8
* n = 8 = 2 * 2 * 2
* */
public class PhanTichRaSNT<S> {
    public static void main(String args[]) {

        int n = 6, i = 2;
        int x = n;
        List<Integer> lst = new ArrayList<>();
        while(n > 1){
            if(n%i == 0){
                n = n / i;
                lst.add(i);
            }else{
                i++;
            }
        }
        System.out.print( x + " = ");
        for (int element : lst) {
            System.out.print(element + "*");
        }

    }
}
