package org.example;

import java.util.Scanner;

public class StringProcessor {

    public String Copies(int N, String s) {
        if (N < 0) return "Ошибка!!";
        if (N == 0) return " ";

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) {
            result.append(s).append("\n");
        }
        return result.toString().trim();
    }

    public int Entries(String m, String n) {
        if (n.isEmpty()) return -1;
        if (m.isEmpty()) return -2;
        return m.split(n, -1).length - 1;
    }

    public String Replace(String l) {
        return l.replace("1", "один")
                .replace("2", "два")
                .replace("3", "три");
    }

    public void Delete(StringBuilder k) {
        String d = k.toString().replace(" ", "");
        k.setLength(0);
        k.append(d);
        for (int i = 1; i < k.length(); i++) {
            k.deleteCharAt(i);
        }

    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("Введите данные в строку:");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println("Введите количество копий строки:");
        int N = in.nextInt();
        in.nextLine();

        StringProcessor processor = new StringProcessor();


        String copiesResult = processor.Copies(N, s);
        System.out.println("Результат копий строки:\n" + copiesResult);

        System.out.println("Введите первую строку:");
        String m = in.nextLine();
        System.out.println("Введите вторую строку:");
        String n = in.nextLine();


        int entriesResult = processor.Entries(m, n);
        if (entriesResult == -2) {
            System.out.println("Первая строка пустая");
        }
        else if (entriesResult == -1) {
            System.out.println("Вторая строка пустая");
        } else {
            System.out.println("Количество вхождений: " + entriesResult);
        }


        System.out.println("Введите строку для замены:");
        String l = in.nextLine();

        String replaceResult = processor.Replace(l);
        System.out.println("Замененная строка: " + replaceResult);

        System.out.println("Введите строку для удаления:");
        StringBuilder k = new StringBuilder(in.nextLine());
        processor.Delete(k);

        System.out.println("Результат после удаления: " + k);

        in.close();
    }
}
