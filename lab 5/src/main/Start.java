package main;

import java.util.ArrayList;

/**
 * Created by hansr_000 on 2014-05-08.
 */
public class Start {
    private ArrayList<String> pre(){
        ArrayList<String> inputList = new ArrayList<String>();
        inputList.add(">Sphinx");
        inputList.add("KQRK");
        inputList.add(">Bandersnatch");
        inputList.add("KAK");
        inputList.add(">Snark");
        inputList.add("KQRIKAAKABK");
        return inputList;

    }
    private int allScore(int[][] matrix, char dna_0Component, char dna_1Component){
        return null;

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
                matrix[i][j]= start.allScore(matrix,dna_0[i],dna_1[j]);


            }
        }



    }



}
