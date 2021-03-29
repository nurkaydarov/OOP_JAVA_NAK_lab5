// Работа с ХМL
package kz.pvl.nak.java.oop.lab5;


import java.util.prefs.Preferences;

public class Main {

    public static void main(String[] args) {

        final int row = 4;
        final int col = 5;
        int[][] matrix = new int[row][col];
        int count;
        Preferences reg = Preferences.userRoot().node("nak_oop_lab5");


        System.out.println("Лабораторная работа №5");
        System.out.println("Задание: ...");
        System.out.println("Подсчитать количество отрицательных элементов в таблице и увеличить на это значение минимальный и максимальный элементы таблицы");

        try {



                for (int i = 0; i < row; i++)
                {
                    for (int j = 0; j < col; j++) {
                        matrix[i][j]= (int) Math.round((Math.random() * 18) - 9);// Генерируем рандомные числа
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println();
                }




            /*
             * Part 2 Алгоритм
             */
            int mini = 0, min_j = 0, maxi = 0, max_j = 0;
            int max = matrix[maxi][max_j], min = matrix[mini][min_j], maxElement , minElement ;

            int nCount = 0;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {

                    count = matrix[i][j];

                    if (count < 0) {
                        nCount = nCount + 1;
                    }

                    if (count < min) {
                        min = matrix[i][j];
                        mini = i;
                        min_j = j;
                    }
                    if (count > max) {
                        max = matrix[i][j];
                        maxi = i;
                        max_j = j;
                    }
                }

            }
            minElement = nCount + min; // Сумма кол-во отрицательных чисел и минимального элемента в матрице
            maxElement = nCount + max; // Сумма кол-во отрицательных чисел и максимального элемента в матрице

            matrix[maxi][max_j] = maxElement; // И заменяем его на сумму отрицательных + мин элемента

            matrix[mini][min_j] = minElement;

            System.out.println(" ----- ");


            System.out.println("Min Element " + min);
            System.out.println("Max Element " + max);

            System.out.println("Кол-во отрицательных чисел " + nCount);
            System.out.println(" ");
            /* End Part 3*/

            /*Part 3*/
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    // Сохраняем данные в переменную, хранящую данные xml
                    reg.putInt("matrix" + i + j, matrix[i][j]);

                    count =  reg.getInt("matrix" + i + j, matrix[i][j]);
                    System.out.print(count + " ");
                }
                System.out.println();
            }



            /*End Part 3 */
        } catch (Exception e) {
            System.err.println("Error 404");
        }

    }
}
