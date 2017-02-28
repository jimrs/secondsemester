/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author jakub
 */
public class RangeCreator {
    private int rangeStart;
    private int rangeEnd;
    
    public RangeCreator(int rangeStart, int rangeEnd) {
        changeRange(rangeStart, rangeEnd);
    }
    
    public void changeRange(int rangeStart, int rangeEnd) {
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;
    }
    
    public int[] getRange() {
        int step = 1;
        if (rangeEnd < rangeStart) {
            step = -1;
        }
        int size = Math.abs(rangeEnd - rangeStart) + 1;
        int[] result = new int[size];
        for (int i = 0; i < size; ++i) {
            result[i] = rangeStart + step * i;
        }
        return result;
    }
}
