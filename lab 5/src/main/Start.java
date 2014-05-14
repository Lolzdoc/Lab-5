package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Start {
    static String[][] blosum62 = new String[24][24];
    static HashMap<Character,Integer> blosum_Index = new HashMap<Character, Integer>();
    final static int gap = -4;
    static int[][] matrix;
    private ArrayList<String> pre(){
        ArrayList<String> inputList = new ArrayList<String>();
        try{
            BufferedReader blosumReader = new BufferedReader(new FileReader(new File("lab 5/inputFiles/BLOSUM62.txt")));
            String line = "";
            String[] rows;
            String Debug= "";
            int j = 0;
            line = blosumReader.readLine();

            while(line != null){
                rows = line.split(" +");
                blosum_Index.put(rows[0].trim().charAt(0), j);
                for(int i = 1; i<25;i++){
                    blosum62[j][i-1] = rows[i].trim();
                }
                j=j+1;
                line = blosumReader.readLine();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        inputList.add(">Sphinx");
        inputList.add("KQRK");
        inputList.add(">Bandersnatch");
        inputList.add("KAK");
        inputList.add(">Snark");
        inputList.add("KQRIKAAKABK");
        return inputList;

    }




    public static void main(String[] args){
        Start start = new Start();
        ArrayList<String> inputList = new ArrayList<String>();
        inputList = start.pre();
        ArrayList<Species> speciesList = new ArrayList<Species>();
        for(int i = 0; i<inputList.size()/2; i=i+2){
            speciesList.add(new Species(inputList.get(i),inputList.get(i+1)));
        }
        char[] dna_0 = speciesList.get(0).dna.toCharArray();
        char[] dna_1 = speciesList.get(1).dna.toCharArray();
        int sizeX = speciesList.get(0).dna.length();
        int sizeY = speciesList.get(1).dna.length();
        matrix = new int[sizeX+1][sizeY+1];
        for(int i = 0; i<sizeX;i++){
            matrix[i][0] = gap*i;
        }
        for(int i = 0; i<sizeY;i++){
            matrix[0][i] = gap*i;

        }
        Set<Character> a = blosum_Index.keySet();
        Iterator aa = a.iterator();



        for(int i = 1; i< sizeX; i++){
            for(int j = 1; j < sizeY;j++){
                int left,diag,top;
                left = matrix[i - 1][j]+gap;
                diag = matrix[i-1][j-1]+ Integer.parseInt(blosum62[blosum_Index.get(dna_0[i-1])][blosum_Index.get(dna_1[j-1])]);
                top = matrix[i][j-1] + gap;

                int max = Math.max(left,diag);
                if(max < top){
                    max = top;
                }
                matrix[i][j] = max;
            }
        }

        for(int i = 0; i<4;i++){
            String debug1 ="";
            for(int j =0; j < 3; j++){

                debug1 = debug1+matrix[i][j]+" ";

            }
            System.out.println(debug1);
        }



        String x_Dna ="";
        String y_Dna ="";
        int i = dna_0.length-1;
        int j = dna_1.length-1;
        int superScore;
        int current_Score;
        int left_Score;
        int top_Score;
        int diag_Score;




        while((i > 0 && j > 0)){
            current_Score = matrix[i][j];
            left_Score = matrix[i-1][j];
            top_Score = matrix[i][j-1];
            diag_Score = matrix[i-1][j-1];

            System.out.println("current_Score ="+current_Score+ " left_Score = "+left_Score+" top_Score = "+top_Score + " diag_Score = "+diag_Score);
            System.out.println(dna_0[i-1]+" & "+dna_1[j-1]+" blir: "+blosum62[blosum_Index.get(dna_0[i-1])][blosum_Index.get(dna_1[j-1])]);

            if(current_Score == (diag_Score + Integer.parseInt(blosum62[blosum_Index.get(dna_0[i-1])][blosum_Index.get(dna_1[j-1])]))){
                x_Dna = dna_0[i-1]+x_Dna;
                y_Dna = dna_1[j-1]+y_Dna;
                i-=1;
                j-=1;
            } else if(current_Score == (left_Score+gap)){
                x_Dna = dna_0[i-1]+x_Dna;
                y_Dna = '-'+y_Dna;
                i-=1;
            } else if(current_Score == top_Score + gap){
                x_Dna = '-'+x_Dna;
                y_Dna = dna_1[j-1]+y_Dna;
                j-=1;
            }
            System.out.println("i = "+i+" j = "+j);

        }
        System.out.println(x_Dna+"\n"+y_Dna);





    }



}
