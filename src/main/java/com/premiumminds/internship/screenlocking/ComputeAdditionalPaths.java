package com.premiumminds.internship.screenlocking;

import java.util.LinkedList;
import java.util.List;

public class ComputeAdditionalPaths {
    public List<Integer> [] matrix;
    public List<FromTo> [] moreNeighbors;

    public ComputeAdditionalPaths(){
        matrix=new List[10];
        moreNeighbors = new List[10];
        intiMatrix();
        initAdditionalPaths();
    }
    private void intiMatrix(){
        matrix[1]=addNeighbors(2,4,5,6,8);
        matrix[2]=addNeighbors(1,3,4,5,6,7,9);
        matrix[3]=addNeighbors(2,5,6,4,8);
        matrix[4]=addNeighbors(1,2,3,5,9,7,8);
        matrix[5]=addNeighbors(1,2,3,4,6,7,8,9);
        matrix[6]=addNeighbors(1,2,3,5,7,8,9);
        matrix[7]=addNeighbors(4,2,5,6,8);
        matrix[8]=addNeighbors(7,4,1,5,3,6,9);
        matrix[9]= addNeighbors(8,4,5,2,6);
    }

    public List<Integer> normalNeighbors(int number){
        return matrix[number];
    }
    public List<FromTo> moreNeighbors(int number){ return moreNeighbors[number];}
    private List<Integer> addNeighbors(int ...args){
        List<Integer> list = new LinkedList<>();
        for (Integer i:args) {
            list.add(i);
        }
        return list;
    }
    private List<FromTo> addMoreNeighbors(FromTo ...args){
        List<FromTo> list = new LinkedList<>();
        for (FromTo i:args) {
            list.add(i);
        }
        return list;
    }
    public record FromTo(int x, int y) {}
    public FromTo toFromTo(int x, int y){
        return new FromTo(x,y);
    }
    private void initAdditionalPaths(){
        moreNeighbors[1]=addMoreNeighbors(toFromTo(2,3),toFromTo(4,7),toFromTo(5,9));
        moreNeighbors[2]=addMoreNeighbors(toFromTo(5,8));
        moreNeighbors[3]=addMoreNeighbors(toFromTo(2,1),toFromTo(5,7),toFromTo(6,9));
        moreNeighbors[4]=addMoreNeighbors(toFromTo(5,6));
        moreNeighbors[5]=addMoreNeighbors();
        moreNeighbors[6]=addMoreNeighbors(toFromTo(5,4));
        moreNeighbors[7]=addMoreNeighbors(toFromTo(5,3),toFromTo(4,1),toFromTo(8,9));
        moreNeighbors[8]=addMoreNeighbors(toFromTo(5,2));
        moreNeighbors[9]=addMoreNeighbors(toFromTo(5,1),toFromTo(6,3),toFromTo(8,7));
    }
}
