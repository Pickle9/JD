package by.htp.hw2.task1;

/*Задание №1.
Напишите программу нахождения гипотенузы и плозади прямоугольного треугольника по двум катетам.*/


public class Solution {
    public static void main(String[] args) {
        double a = 3.0;   //Катет a.
        double b = 3.0;   //Катет b.
        double hyp = Math.sqrt(Math.pow(a,2) + Math.pow(b,2));   //Расчёт гипотенузы.
        double square = (a * b)/2;   //Расчёт площади

        System.out.println(String.format("Гипотенуза треугольника с катетами %o и %o = %f", (int)a, (int)b, hyp));   //Для более красивого кода использую String.format,
                                                                                                                    // а для красивых цифр при выводе на экран привожу a и b к int-у.
        System.out.println("А площадь данного треугольника = " + square);
    }
}
