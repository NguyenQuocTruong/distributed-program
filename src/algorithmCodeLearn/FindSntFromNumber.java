package algorithmCodeLearn;

/*
* Bài Toán
* Cho 1 số tự nhiên n
* Mỗi một lần ta thay thế n bằng tổng các thừa số nguyên tố của nó
* (ví dụ n = 12 = 2*2*3 thì sau đó, n sẽ được thay thế bằng số 2+2+3 = 7)
* Lặp cho đến khi n là 1 số nguyên tố thì dừng và in ra n
* */
class FindSntFromNumber {

    private static int execute(int n){

        int sum = 0, i = 2, result = 0;

        while(n >= 1){
            int y = n;
            // Phân tích n thành tích các thừa số nguyên tố
            if(n % i == 0){
                n = n / i;
                sum += i;
            }else{
                i++;
//                System.out.println("i = " + i);
            }

            // Nếu n == 1 --> gán lại các giá trị cho n, sum , i nếu thỏa mãn ( y != sum)
            // vì nếu (y == sum) vòng lặp sẽ vô hạn
            if(n == 1 ){
                if(sum != y ){
                    n = sum;
                    sum = 0;
                    i = 2;
                }else {
                    result = sum;
                    break;
                }
            }

        }
        System.out.println("result = " + result);
        return result;
    }

    public static void main(String[] args) {

        /*Chưa pass qua test case n = 4*/
        execute(4);
    }
}
