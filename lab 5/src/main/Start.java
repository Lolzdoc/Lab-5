package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Start {
    String[][] blosum62 = new String[24][24];
    HashMap<Character,Integer> blosum_Index = new HashMap<Character, Integer>();

    private ArrayList<String> pre(){
        ArrayList<String> inputList = new ArrayList<String>();
        try{
            BufferedReader blosumReader = new BufferedReader(new FileReader(new File("in filer/BLOSUM62.txt")));
            String line = "";
            String[] rows;
            String Debug= "";
            int j = 0;
            line = blosumReader.readLine();

            while(line != null){

                System.out.println(line);
                rows = line.split(" +");
                for(int i = 1; i<25;i++){
                    blosum62[j][i-1] = rows[i].trim();
                    Debug+=" "+ rows[i];
                }
                j=j+1;
                System.out.println(Debug);
                Debug = "";
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
    private int allScore(int[][] matrix, char dna_0Component, char dna_1Component){
        return -1;

    }
    public static void main(String[] args){
        Start start = new Start();
        ArrayList<String> inputList = new ArrayList<String>();
        inputList = start.pre();
        ArrayList<Species> speciesList = new ArrayList<Species>();
        for(int i = 0; i<inputList.size()/2; i=i+2){
            speciesList.add(new Species(inputList.get(i),inputList.get(i+1)));
        }
        char[] dna_0 = speciesList.get(0).name.toCharArray();
        char[] dna_1 = speciesList.get(1).name.toCharArray();
        int sizeX = speciesList.get(0).name.length()+1;
        int sizeY = speciesList.get(1).name.length()+1;
        int[][] matrix = new int[sizeX][sizeY];
        for(int i = 0; i<sizeX;i++){
            matrix[i][0] = 0;
        }
        for(int i = 0; i<sizeY;i++){
            matrix[0][i] = 0;
        }
        for(int i = 1; i<sizeX;i++){
            for(int j = 1; j<sizeY;j++){


            }
        }



    }



}
