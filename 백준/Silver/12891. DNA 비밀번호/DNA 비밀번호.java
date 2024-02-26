import java.util.*;

class Main{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int length = sc.nextInt();
        sc.nextLine();
        char[] password = sc.nextLine().toCharArray();
        int[] checkCount = new int[4];
        int[] passwordCount = new int[4];

        int answer = 0;

        Map<Character, Integer> dnaIndex = new HashMap<>();
        dnaIndex.put('A', 0);
        dnaIndex.put('C', 1);
        dnaIndex.put('G', 2);
        dnaIndex.put('T', 3);

        for(int i=0;i<4;i++){
            int count = sc.nextInt();
            checkCount[i] = count;
        }

        for(int i=0;i<length;i++){
            passwordCount[dnaIndex.get(password[i])]++;
        }

        if(checkPassword(checkCount, passwordCount)){
            answer++;
        }

        for(int i=length;i<size;i++){
            passwordCount[dnaIndex.get(password[i])]++;
            passwordCount[dnaIndex.get(password[i - length])]--;
            if(checkPassword(checkCount, passwordCount)){
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static boolean checkPassword(int[] checkCount, int[] passwordCount){
        for(int i=0;i<4;i++){
            if(checkCount[i] > passwordCount[i]){
                return false;
            }
        }
        return true;
    }
}