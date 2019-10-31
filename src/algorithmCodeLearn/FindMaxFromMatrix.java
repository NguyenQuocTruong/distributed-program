package algorithmCodeLearn;
import java.util.Scanner;

/*
* Tìm số lớn nhất trong mảng 2 chiều
* */
public class FindMaxFromMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap So chieu");
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] myMatrix = new int[m][n];

        System.out.println("Nhap Gia Tri Cho Mang");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                myMatrix[i][j] = scanner.nextInt();
            }
        }

        int max = 0;
        System.out.println("Mảng vừa nhập");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(myMatrix[i][j] + " ");
            }
        }

        /*Get max */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(max <= myMatrix[i][j]){
                    max = myMatrix[i][j];
                }
            }
        }

        System.out.println("The max value is: " + max);
    }
}

