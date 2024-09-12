import java.util.*;
public class Practise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
             ans.add(sc.nextInt());
        }
        int k = sc.nextInt();
        int del = ans.size() - k;
        ans.remove(del);

        // for(int i=0;i<ans.size();i++){
        //     System.out.print(ans.get(i)+" ");
        // }
        System.out.println(ans);

    }
}
