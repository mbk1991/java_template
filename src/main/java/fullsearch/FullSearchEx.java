package main.java.fullsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FullSearchEx {
    public static void main(String[] args) {

        char[] words = "AEIOU".toCharArray();
        boolean[] isUse = new boolean[words.length];
        Arrays.fill(isUse,false);

        List<String> combWordList = new ArrayList<>();
//
//            for(int j=0; j<words.length; j++){
//                combWordList.add(""+words[j]);
//                for(int k=0; k<words.length; k++){
//                    combWordList.add(""+words[j]+words[k]);
//                    for(int l=0; l<words.length; l++){
//                        combWordList.add(""+words[j]+words[k]+words[l]);
//                        for(int m=0; m<words.length; m++){
//                            combWordList.add(""+words[j]+words[k]+words[l]+words[m]);
//                            for(int n=0; n<words.length; n++){
//                                combWordList.add(""+words[j]+words[k]+words[l]+words[m]+words[n]);
//                            }
//                        }
//                    }
//                }
//            }
        comb("",combWordList,words,isUse);
        System.out.println(combWordList);
    }

    public static void comb(String word, List words, char[] elements, boolean[] isUse){
        words.add(word);
        if(word.length() == 5) return;
        for(int i=0;i<elements.length; i++){
            if(!isUse[i]){
                boolean[] chked = Arrays.copyOf(isUse, isUse.length);
                chked[i] = true;
                comb(word+elements[i],words,elements,chked);
            }
        }
    }
}
