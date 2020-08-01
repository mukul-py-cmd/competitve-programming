//https://codeforces.com/contest/1343/problem/E

import java.util.*;

public class Main{
    static ArrayList<ArrayList<Integer>> gr ;
    static ArrayList<ArrayList<String>>  atob ;
    static ArrayList<ArrayList<String>>  btoc ;
    static int[] price;
    static int max_length;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t =sc.nextInt();
        while(t-->0){
            int n=  sc.nextInt();
            int m=  sc.nextInt();
            int a=  sc.nextInt();
            int b=  sc.nextInt();
            int c=  sc.nextInt();
                gr = new ArrayList<>();
                atob = new ArrayList<>();
                btoc = new ArrayList<>();
                max_length = Integer.MAX_VALUE;
            for(int i = 0 ; i<= n;i++){
                gr.add(new ArrayList<>());
            }

            price =new int[m];
            for(int i = 0; i < m;i++){
                price[i] = sc.nextInt();
            }

            Arrays.sort(price);
            for(int i = 0; i < m;i++){
                int u = sc.nextInt();
                int v = sc.nextInt();
                gr.get(u).add(v);
                gr.get(v).add(u);    
            }

            
             Boolean[] visit = new Boolean[n+1];
                Arrays.fill(visit,false);
             dfs(a,b,0,visit,new ArrayList<String>(),1);
             int len_atob = max_length;
             max_length = Integer.MAX_VALUE;
             dfs(b,c,0,visit,new ArrayList<String>(),2);
             int len_btoc = max_length;

            ArrayList<Map<String,Integer>> master1 = new ArrayList<>();
            ArrayList<Map<String,Integer>> master2 = new ArrayList<>();
        for(int i = 0;i < atob.size();i++){
            if(atob.get(i).size() > len_atob){
                continue;
            }
            Map<String,Integer>  mp= new HashMap<>();
            Iterator<String> it = atob.get(i).iterator();
            while(it.hasNext()){
                String s_temp = it.next();
                mp.put(s_temp,mp.getOrDefault(s_temp,0)+1);

            }
            master1.add(mp);

        }

        for(int j =0; j< btoc.size();j++){
            if(btoc.get(j).size() > len_btoc){
            continue;
        }
        Map<String,Integer>  mp= new HashMap<>();
        Iterator<String> it = btoc.get(j).iterator();
        while(it.hasNext()){
            String s_temp = it.next();
            mp.put(s_temp,mp.getOrDefault(s_temp,0)+1);

        }

        master2.add(mp);

        }
        int final_ans = Integer.MAX_VALUE;
        for(int i = 0;i < master1.size();i++){
            for(int j =0; j< master2.size();j++){

               int temp_ans =  solve(master1.get(i),master2.get(j));
               final_ans = Math.min(final_ans,temp_ans);

            }
        }

System.out.println(final_ans);



        }}


public static int solve(Map<String,Integer> master1,Map<String,Integer> master2){
ArrayList<Integer> arr = new ArrayList<Integer>();
for(String k : master1.keySet()){
    int x = master1.get(k);
    int y =0;
    if(master2.containsKey(k)){
        y =  master2.get(k);
        master2.put(k,0);
    }
    
    arr.add(x+y);
    
}

for(String k : master2.keySet()){
    int x =  master2.get(k);
    if(x != 0){
        arr.add(x);
    }

}
int ans = 0;
Collections.sort(arr,Collections.reverseOrder());
/*
for(int i = 0; i < arr.size();i++){
    System.out.print(arr.get(i) +" ");
}
*/
for(int i = 0; i < arr.size();i++){
    
ans += arr.get(i)*price[i];
}
return ans;
}

public static void dfs(int a, int b, int d, Boolean[] visit,ArrayList<String> arr,int flag){
        if(a == b){
            if(flag ==1){
                atob.add(new ArrayList<>(arr));
            }else{
                btoc.add(new ArrayList<>(arr));
            }
            
            max_length = Math.min(arr.size(),max_length);
            return;
        }

        if(arr.size()> max_length ){
            return;
        }

        visit[a] =true;
        Iterator<Integer> it = gr.get(a).iterator();
        while(it.hasNext()){
            int v = it.next();
            if(!visit[v]){
                int j = Math.min(a,v);
                int l = Math.max(a,v);
                String key = String.valueOf(j)+"|"+String.valueOf(l);
            arr.add(key);
            dfs(v,b,d+1,visit,arr,flag);
            arr.remove(arr.size()-1);
            }
            

        }

        visit[a] = false;

        }


    }