package com.example.Table;

/**
 * Created by Vert on 27.02.14.
 */
public class MyQuestion {

    /**
     * Can be 'A', 'B', 'C', 'D' or 'E'
     */
    int CurrentCondition=0;

    /**
     * Function that executes when checking for conditions
     */

    public MyConditionChecker ConditionChecker;


    public MyQuestion() {
        CurrentCondition = 'A';
    }

    public MyQuestion(int currentCondition) {
        CurrentCondition = currentCondition;
    }

    public void setConditionChecker(MyConditionChecker condition) {
        ConditionChecker = condition;
    }

    public int getCurrentCondition() {
        return CurrentCondition;
    }

    public void setCurrentCondition(int currentCondition) {
        CurrentCondition = currentCondition;
    }

    @Override
    public String toString() {
        char value;
        switch(CurrentCondition)
        {
            case 0:
                value = 'A';
                break;
            case 1:
                value = 'B';
                break;
            case 2:
                value = 'C';
                break;
            case 3:
                value = 'D';
                break;
            case 4:
                value = 'E';
                break;

            default:
                value = '-';
        }
        return "MyQuestion{" +
                "CurrentCondition=" + value +
                '}';
    }
}
