package main.java.fullsearch.dfs;

import java.util.*;
public class DFSTemplate {
    public static void main(String[] args) {

    }

    private void DFS1(){
        //탐색범위는 어떻게

        Stack<Integer> st = new Stack<>();

        st.push(1);
        while(!st.isEmpty()){
            int a = st.pop();
            if(a == 100) break;

            st.push(a+1);
            st.push(a-1);
            st.push(a*2);
        }
    }
}
