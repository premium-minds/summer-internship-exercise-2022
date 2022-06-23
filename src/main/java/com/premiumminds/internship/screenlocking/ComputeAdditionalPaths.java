package com.premiumminds.internship.screenlocking;

import java.util.LinkedList;
import java.util.List;

public class ComputeAdditionalPaths {
    public ComputeAdditionalPaths(){}
    public List<Integer> normalNeighbors(int number) throws Exception {
        if(number==1){
            return addNeighbors(2,4,5,6,8); //1
        }else if(number==2){
            return addNeighbors(1,3,4,5,6,7,9);  //2
        }else if(number==3){
            return addNeighbors(2,5,6,4,8); //3
        }else if(number==4){
            return addNeighbors(1,2,3,5,9,7); //4
        }else if(number==5){
            return addNeighbors(1,2,3,4,6,7,8,9); //5
        }else if(number==6){
            return addNeighbors(1,2,3,5,7,8,9); //6
        }else if(number==7){
            return addNeighbors(4,2,5,6,8); //7
        }else if(number==8){
            return addNeighbors(7,4,1,5,3,6,9); //8
        }else if (number==9){
            return addNeighbors(8,4,5,2,6); //9
        }else {
            throw new Exception("UNKNOWN NUMBER");
        }
    }
    private List<Integer> addNeighbors(int ...args){
        List<Integer> list = new LinkedList<>();
        for (Integer i:args) {
            list.add(i);
        }
        return list;
    }
    public List<Integer> additionalPaths(boolean [] inPath, int number) {
        List<Integer> auxNodes = new LinkedList<>();
        switch (number) {
            case 1:
                if (inPath[2]) {
                    auxNodes.add(3);
                }
                if (inPath[4]) {
                    auxNodes.add(7);
                }
                if (inPath[5]) {
                    auxNodes.add(9);
                } break;
            case 2:
                if (inPath[5]) {
                    auxNodes.add(8);
                } break;
            case 3:
                if (inPath[5]) {
                    auxNodes.add(7);
                }
                if (inPath[6]) {
                    auxNodes.add(9);
                } break;
            case 4:
                if (inPath[5]) {
                    auxNodes.add(6);
                } break;
            case 5: break;
            case 6:
                if (inPath[5]) {
                    auxNodes.add(4);
                } break;
            case 7:
                if (inPath[5]) {
                    auxNodes.add(3);
                }
                if (inPath[4]) {
                    auxNodes.add(1);
                }
                if (inPath[8]) {
                    auxNodes.add(9);
                } break;
            case 8:
                if (inPath[5]) {
                    auxNodes.add(2);
                } break;
            case 9:
                if (inPath[5]) {
                    auxNodes.add(1);
                }
                if (inPath[6]) {
                    auxNodes.add(3);
                }
                if (inPath[8]) {
                    auxNodes.add(7);
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + number);
        }
        return auxNodes;
    }
}
