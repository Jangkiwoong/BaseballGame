

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static int[] numbers;
    private static String THREE_STRIKE = "3S";

    public static void main(String[] args) throws IOException {

        int index = 0;
        numbers = new int[3];
        HashSet<Integer> set = new HashSet<>(); //나온 숫자를 저장하는 곳
        while (true) {
            if (index == 3) break;
            int randNum = (int) (Math.random() * 10); //랜덤 숫자 만들기
            if (!set.contains(randNum)) { //랜덤 숫자가 아직 나오지 않았다면
                numbers[index] = randNum; //숫자 대입
                set.add(randNum); //숫자 저장
                index++;
            }
        }
        //System.out.println(Arrays.toString(numbers));
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");

        int count = 0;
        Scanner sc = new Scanner(System.in);

        while (true){
            count ++;

            System.out.print(count + "번째 시도 : ");
            String answer = sc.nextLine();

            String result = check(answer); //결과 받아오기
            System.out.println(result);

            if (result.equals(THREE_STRIKE)) {
                System.out.println(count+"번만에 맞히셨습니다.");
                System.out.println("게임을 종료합니다.");
                break;
            }

        }

    }

    public static String check(String answer) {
        int strike = 0;
        int ball = 0;
        int answerInt = Integer.parseInt(answer);

        int[] checkNum = new int[3];
        for (int i = 0; i < 3; i++) {
            checkNum[i] = answer.charAt(i) - '0';
        }

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < checkNum.length; j++) {
                if (numbers[i] == checkNum[j]) {
                    if (i == j) {
                        strike ++;
                    } else ball ++;
                }
            }
        }

        if (ball == 3) { //3B
            return "3B";
        }
        else if (strike == 3) { //3S
            return "3S";
        }
        else { //나머지 결과
            return ball + "B" + strike + "S";
        }

    }

}
