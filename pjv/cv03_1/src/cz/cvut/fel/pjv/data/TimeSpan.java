/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fel.pjv.data;

/**
 *
 * @author maresj29
 */
public class TimeSpan {
    int hour, minute, second;
    
    public TimeSpan() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    public TimeSpan(int second) {
        this.second = second;
    }

    public TimeSpan(int minute, int second) {
        this.minute = minute;
        this.second = second;
    }

    public TimeSpan(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    
    void setTime(int hour, int minute, int second) {
        
    }
}
