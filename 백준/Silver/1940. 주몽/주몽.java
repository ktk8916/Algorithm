import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int size = sc.nextInt();
        int target = sc.nextInt();
        int[] materials = new int[size];
        
        for(int i=0;i<size;i++){
            materials[i] = sc.nextInt();
        }
        
        Arrays.sort(materials);
        
        int start = 0;
        int end = size - 1;
        int count = 0;
        
        while(start < end){
            int sum = materials[start] + materials[end];
            if(sum == target){
                count++;
                start++;
                end--;
            }else if(sum < target){
                start++;
            }else{
                end--;
            }
        }
        
        System.out.println(count);
    }
}