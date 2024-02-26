import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int size = sc.nextInt();
        int[] numbers = new int[size];
        for(int i=0;i<size;i++){
            numbers[i] = sc.nextInt();
        }
        
        Arrays.sort(numbers);
        
        int count = 0;
       
        for(int i=0;i<size;i++){
            int target = numbers[i];
            
            int start = 0;
            int end = size - 1;
          
            while(start < end){
                int sum = numbers[start] + numbers[end];
                if(sum == target){
                    if(start != i && end != i){
                        count++;
                        break;    
                    } else if(start == i){
                        start++;
                    } else if(end == i){
                        end--;
                    }
                } else if(sum < target){
                    start++;
                } else {
                    end--;
                }
            }
        }
        
        System.out.println(count);
    }
}