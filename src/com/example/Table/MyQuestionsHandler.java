package com.example.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vert on 27.02.14.
 */
public class MyQuestionsHandler {
    static public final int QUESTIONS_COUNT = 25;

    static public final int A = 0;
    static public final int B = 1;
    static public final int C = 2;
    static public final int D = 3;
    static public final int E = 4;





    List<MyQuestion> AllQuestions = new ArrayList<MyQuestion>();


    void fillQuestions()
    {
        AllQuestions.get(0).setConditionChecker(new MyConditionChecker() {
            @Override
            public boolean CheckCondition() {
                /** find first 'B' question */
                int first_B_question=-1; // knowingly incorrect value
                
                for(int i=0; i<QUESTIONS_COUNT; i++)
                    if(AllQuestions.get(i).getCurrentCondition() == B){
                        first_B_question = i;
                        break; //out of for()
                    }

                    switch(AllQuestions.get(0).getCurrentCondition()){
                        case A: //'A'
                            return false;
                        case B: //'B'
                            return (first_B_question == 1)? true : false; // redundant but more readable
                        case C: //'C'
                            return (first_B_question == 2)? true : false;
                        case D: //'D'
                            return (first_B_question == 3)? true : false;
                        case E: //'E'
                            return (first_B_question == 4)? true : false;
                        default:
                            return false;
                    }
                }
        });

        AllQuestions.get(1).setConditionChecker(new MyConditionChecker() {
            @Override
            public boolean CheckCondition() {
                int first_of_two_last_serial_questions = -1;
                //condition for Q2 (the only two serial questions are..)
                for(int i=0; i<QUESTIONS_COUNT-1; i++)
                    if(AllQuestions.get(i).getCurrentCondition() == AllQuestions.get(i+1).getCurrentCondition())
                        first_of_two_last_serial_questions = i;
                //end for

                switch(AllQuestions.get(1).getCurrentCondition()){
                    case A: //'A'
                        return ( first_of_two_last_serial_questions == 5 );
                    case B: //'B'
                        return ( first_of_two_last_serial_questions == 6 );
                    case C: //'C'
                        return ( first_of_two_last_serial_questions == 7 );
                    case D: //D
                        return ( first_of_two_last_serial_questions == 8 );
                    case E: //E
                        return ( first_of_two_last_serial_questions == 9 );
                    default:
                        return false;
                }
            }
        });

        AllQuestions.get(2).setConditionChecker(new MyConditionChecker() {
            @Override
            public boolean CheckCondition() {
                /**
                 * total E answers count
                 */
                int total_E_count = 0;
                
                for(int i=0; i<QUESTIONS_COUNT; i++)
                    if(AllQuestions.get(i).getCurrentCondition() == E) // 'E'
                        ++total_E_count;
                //end for

                switch(AllQuestions.get(2).getCurrentCondition()){
                    case A: //'A'
                        return ( total_E_count == 0 );
                    case B: //'B'
                        return ( total_E_count == 1 );
                    case C: //'C'
                        return ( total_E_count == 2 );
                    case D: //'D'
                        return ( total_E_count == 3 );
                    case E: //'E'
                        return ( total_E_count == 4 );
                    default:
                        return false;
                }
            }
        });

        AllQuestions.get(3).setConditionChecker(new MyConditionChecker() {
            @Override
            public boolean CheckCondition() {
                /**
                 * total A answers count
                 */
                int total_A_count = 0;
                
                for(int i=0; i<QUESTIONS_COUNT; i++)
                    if(AllQuestions.get(i).getCurrentCondition() == 0) //'A'
                        ++total_A_count;
                //end for

                switch(AllQuestions.get(3).getCurrentCondition()){
                    case A: //'A'
                        return ( total_A_count == 4 );
                    case B: //'B'
                        return ( total_A_count == 5 );
                    case C: //'C'
                        return ( total_A_count == 6 );
                    case D: //'D'
                        return ( total_A_count == 7 );
                    case E: //'E'
                        return ( total_A_count == 8 );
                    default:
                        return false;
                }
            }
        });

        AllQuestions.get(4).setConditionChecker(new MyConditionChecker() {
            @Override
            public boolean CheckCondition() {
                /**
                 * answer to Q5 is identical to Q1 
                 */
                return AllQuestions.get(0).getCurrentCondition() == AllQuestions.get(4).getCurrentCondition();
            }
        });

        AllQuestions.get(5).setConditionChecker(new MyConditionChecker() {
            @Override
            public boolean CheckCondition() {
                /**
                 * answer to Q17 is ... 
                 */
                int answer_to_q17 = AllQuestions.get(16).getCurrentCondition();

                switch(AllQuestions.get(5).getCurrentCondition()){
                    case A: //'A'
                        return ( answer_to_q17 == C ); //'C'
                    case B: //'B'
                        return ( answer_to_q17 == D ); //'D'
                    case C: //'C'
                        return ( answer_to_q17 == E ); //'E'
                    case D: //'D'
                        return ( answer_to_q17 < 2 || answer_to_q17 > 4 ); //nothing of above
                    case E: //'E'
                        return false; // all of the above - impossible
                    default:
                        return false;
                }
            }
        });


        AllQuestions.get(6).setConditionChecker(new MyConditionChecker() {
            @Override
            public boolean CheckCondition() {
                /**
                 * answer to Q7 and Q8 are spaced ...
                 */
                int answer_to_q8 = AllQuestions.get(7).getCurrentCondition();

                switch(AllQuestions.get(6).getCurrentCondition()){
                    case A: //'A'
                        return ( answer_to_q8 == E ); //spaced by four letters
                    case B: //'B'
                        return ( answer_to_q8 == E ); //spaced by three letters
                    case C: //'C'
                        return ( answer_to_q8 == A || answer_to_q8 == E ); //spaced by two letters
                    case D: //'D'
                        return ( answer_to_q8 == C || answer_to_q8 == E ); //spaced by one letter
                    case E: //'E'
                        return answer_to_q8 == E; // same
                    default:
                        return false;
                }
            }
        });

        AllQuestions.get(7).setConditionChecker(new MyConditionChecker() {
            @Override
            public boolean CheckCondition() {
                /**
                 * total A + E count
                 */
                int A_E_count = 0;

                for(int i=0; i<QUESTIONS_COUNT; i++)
                    if(AllQuestions.get(i).getCurrentCondition() == A || AllQuestions.get(i).getCurrentCondition() == E)
                        ++A_E_count;

                switch(AllQuestions.get(7).getCurrentCondition()){
                    case A: //'A'
                        return ( A_E_count == 4 );
                    case B: //'B'
                        return ( A_E_count == 5 );
                    case C: //'C'
                        return ( A_E_count == 6 );
                    case D: //'D'
                        return ( A_E_count == 7 );
                    case E: //'E'
                        return ( A_E_count == 8 );
                    default:
                        return false;
                }
            }
        });


        AllQuestions.get(8).setConditionChecker(new MyConditionChecker() {
            @Override
            public boolean CheckCondition() {
                /**
                 * Next Q with same answer as this is...
                 */
                int nextSameAnswer = -1;
                int thisAnswer = AllQuestions.get(8).getCurrentCondition();

                for(int i=8; i<QUESTIONS_COUNT; i++)
                    if(AllQuestions.get(i).getCurrentCondition() == thisAnswer){
                        nextSameAnswer = i;
                        break;
                    }

                switch(AllQuestions.get(8).getCurrentCondition()){
                    case A: //'A'
                        return ( nextSameAnswer == 9 );
                    case B: //'B'
                        return ( nextSameAnswer == 10 );
                    case C: //'C'
                        return ( nextSameAnswer == 11 );
                    case D: //'D'
                        return ( nextSameAnswer == 12 );
                    case E: //'E'
                        return ( nextSameAnswer == 13 );
                    default:
                        return false;
                }
            }
        });








    }


    /**
     * One-time list initialization
     */
    public MyQuestionsHandler() {
        for(int i=0; i<QUESTIONS_COUNT; i++)
        {
            AllQuestions.add(new MyQuestion(0));
        }
    }
}
