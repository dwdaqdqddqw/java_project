import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        //게임에서 사용할 변수
        ArrayList<Integer> com = new ArrayList<>();
        ArrayList<Integer> user = new ArrayList<>();
        int gameCount = 0;//게임 카운트
        int strikeCnt=0, ballCnt=0;//스크라이크,볼 카운트

        //게임전체반복
        while(true) {
            //중복되지 않는 3개의 난수생성
                boolean pass = false;
                //1~9사이의 난수생성
            for (int i = 0; i < 3; i++) {
                int ramdom_int = random.nextInt(100) % 9 + 1;

                com.add(ramdom_int);
                if (com.contains(ramdom_int)) {
                    pass = true;
                } else {
                    i--;
                }

                if (pass && com.size() == 3) {
                    break;
                }
            }

            //난수확인
            System.out.println(com.get(0)+" "+com.get(1)+" "+com.get(2));

            //사용자로부터 3개의 정수를 입력받는다.
            System.out.println("3개의정수를 입력하세요(1~9)");
            System.out.println("스페이스로 구분하시고 마지막에 Enter를 눌러주세요");

            for (int i = 0; i < 3; i++) {

                user.add(scanner.nextInt());

            }

            //게임카운트 1회 증가
            gameCount++;

            for (int i = 0; i < 3; i++) {

                if (com.get(i) == user.get(i)) {
                    strikeCnt++;
                } else if (com.contains(user.get(i))) {
                    ballCnt++;
                }

            }

            //게임종료판단
            if(strikeCnt == 3) {
                System.out.println("3스트라이크 게임종료");
            } else {
                //하나도 못맞추는 경우
                if(strikeCnt == 0 && ballCnt == 0) {
                    System.out.println("아웃입니다");
                }
                else {
                    System.out.printf("%d스트라이크, %d볼\n",
                            strikeCnt, ballCnt);
                }
                //스트라이크, 볼 카운트 초기화
                strikeCnt = 0;
                ballCnt = 0;
                //continue문은 필요없음.
            }

            System.out.println("한게임 더 하시겠습니까?(0:종료,1:재시작)");
            int restart = scanner.nextInt();
            if(restart==0) {
                //게임종료
                System.out.println("\n==게임이 종료되었습니다.==\n");
                //실행되는 즉시 main함수가 종료된다.
                System.exit(0);
            } else if(restart==1){
                //게임을 재시작하기 위해 카운트변수 초기화
                strikeCnt = 0;
                ballCnt = 0;
                gameCount = 0;
                com.clear();
                user.clear();
                System.out.println("\n==게임을 재시작합니다.==\n");
            }
        }//게임 전체 반복 while end
    }//main 메서드 end
}//class 끝