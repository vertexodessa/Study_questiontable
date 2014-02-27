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

        AllQuestions.get(9).setConditionChecker(new MyConditionChecker() {
            @Override
            public boolean CheckCondition() {
                /**
                 * Answer to Q16 is...
                 */
                int q16Answer = AllQuestions.get(15).getCurrentCondition();

                switch(AllQuestions.get(9).getCurrentCondition()){
                    case A: //'A'
                        return ( q16Answer == D );
                    case B: //'B'
                        return ( q16Answer == A );
                    case C: //'C'
                        return ( q16Answer == E );
                    case D: //'D'
                        return ( q16Answer == B );
                    case E: //'E'
                        return ( q16Answer == C );
                    default:
                        return false;
                }
            }
        });

        AllQuestions.get(10).setConditionChecker(new MyConditionChecker() {
            @Override
            public boolean CheckCondition() {
                /**
                 * Sum of 'B' answers count in [Q1-Q10] is...
                 */
                int sumBAnswers = 0;
                for(int i=0; i<10; i++)
                    if(AllQuestions.get(i).getCurrentCondition() == B)
                        ++sumBAnswers;
                //end for

                switch(AllQuestions.get(10).getCurrentCondition()){
                    case A: //'A'
                        return ( sumBAnswers == 0 );
                    case B: //'B'
                        return ( sumBAnswers == 1 );
                    case C: //'C'
                        return ( sumBAnswers == 2 );
                    case D: //'D'
                        return ( sumBAnswers == 3 );
                    case E: //'E'
                        return ( sumBAnswers == 4 );
                    default:
                        return false;
                }
            }
        });

        AllQuestions.get(11).setConditionChecker(new MyConditionChecker() {
            @Override
            public boolean CheckCondition() {
                /**
                 * Sum of 'B', 'C', 'D' answers count in is...
                 */
                int sumBCDAnswers = 0;

                for(int i=0; i<QUESTIONS_COUNT; i++)
                    if( AllQuestions.get(i).getCurrentCondition() == B
                            || AllQuestions.get(i).getCurrentCondition() == C
                            || AllQuestions.get(i).getCurrentCondition() == D)
                        ++sumBCDAnswers;
                //end for

                switch(AllQuestions.get(11).getCurrentCondition()){
                    case A: //'A'
                        return ( sumBCDAnswers%2 == 0 ); // odd
                    case B: //'B'
                        return ( sumBCDAnswers%2 == 1 ); // even
                    case C: //'C'
                        return ( (Math.sqrt(sumBCDAnswers) * Math.sqrt(sumBCDAnswers)) == sumBCDAnswers ); // is square
                    case D: //'D'
                         // is prime number
                        for(int i=2; i<sumBCDAnswers; i++){
                            if(sumBCDAnswers%i == 0){
                                return false; //number is divisible so its not prime
                            }
                        }
                        return true; //number is prime now

                    case E: //'E'
                        return ( sumBCDAnswers%5 == 0 ); // can divide by 5
                    default:
                        return false;
                }
            }
        });

        AllQuestions.get(12).setConditionChecker(new MyConditionChecker() {
            @Override
            public boolean CheckCondition() {
                /**
                 * The only Q which answer is A and which number is even is...
                 */
                int evenAQuestion = -1;
                for(int i=0; i<QUESTIONS_COUNT; i++)
                    if(AllQuestions.get(i).getCurrentCondition() == A && i%2 == 1)
                        evenAQuestion = i;
                //end for

                switch(AllQuestions.get(12).getCurrentCondition()){
                    case A: //'A'
                        return ( evenAQuestion == 8 );
                    case B: //'B'
                        return ( evenAQuestion == 10 );
                    case C: //'C'
                        return ( evenAQuestion == 12 );
                    case D: //'D'
                        return ( evenAQuestion == 14 );
                    case E: //'E'
                        return ( evenAQuestion == 16 );
                    default:
                        return false;
                }
            }
        });

        AllQuestions.get(13).setConditionChecker(new MyConditionChecker() {
            @Override
            public boolean CheckCondition() {
                /**
                 * Total D answer count is...
                 */
                int DCount = 0;
                for(int i=0; i<QUESTIONS_COUNT; i++)
                    if(AllQuestions.get(i).getCurrentCondition() == D)
                        ++DCount;
                //end for

                switch(AllQuestions.get(13).getCurrentCondition()){
                    case A: //'A'
                        return ( DCount == 6 );
                    case B: //'B'
                        return ( DCount == 7 );
                    case C: //'C'
                        return ( DCount == 8 );
                    case D: //'D'
                        return ( DCount == 9 );
                    case E: //'E'
                        return ( DCount == 10 );
                    default:
                        return false;
                }
            }
        });

        AllQuestions.get(14).setConditionChecker(new MyConditionChecker() {
            @Override
            public boolean CheckCondition() {
                /**
                 * Answer to Q12 is...
                 */
                int q12Answer = AllQuestions.get(11).getCurrentCondition();


                switch(AllQuestions.get(14).getCurrentCondition()){
                    case A: //'A'
                        return ( q12Answer == A );
                    case B: //'B'
                        return ( q12Answer == B );
                    case C: //'C'
                        return ( q12Answer == C );
                    case D: //'D'
                        return ( q12Answer == D );
                    case E: //'E'
                        return ( q12Answer == E );
                    default:
                        return false;
                }
            }
        });

        AllQuestions.get(15).setConditionChecker(new MyConditionChecker() {
            @Override
            public boolean CheckCondition() {
                /**
                 * Answer to Q10 is...
                 */
                int q10Answer = AllQuestions.get(9).getCurrentCondition();


                switch(AllQuestions.get(15).getCurrentCondition()){
                    case A: //'A'
                        return ( q10Answer == D );
                    case B: //'B'
                        return ( q10Answer == C );
                    case C: //'C'
                        return ( q10Answer == B );
                    case D: //'D'
                        return ( q10Answer == A );
                    case E: //'E'
                        return ( q10Answer == E );
                    default:
                        return false;
                }
            }
        });

        AllQuestions.get(16).setConditionChecker(new MyConditionChecker() {
            @Override
            public boolean CheckCondition() {
                /**
                 * Answer to Q6 is...
                 */
                int q6Answer = AllQuestions.get(5).getCurrentCondition();


                switch(AllQuestions.get(16).getCurrentCondition()){
                    case A: //'A'
                        return ( q6Answer == C );
                    case B: //'B'
                        return ( q6Answer == D );
                    case C: //'C'
                        return ( q6Answer == E );
                    case D: //'D'
                        return ( q6Answer == A || q6Answer == B );
                    case E: //'E'
                        return ( false );
                    default:
                        return false;
                }
            }
        });


        AllQuestions.get(17).setConditionChecker(new MyConditionChecker() {
            @Override
            public boolean CheckCondition() {
                /**
                 * Total A answer count is...
                 */
                int ACount = 0, BCount = 0, CCount = 0, DCount = 0, ECount = 0;
                for(int i=0; i<QUESTIONS_COUNT; i++){
                    switch(AllQuestions.get(i).getCurrentCondition()){
                        case A:
                            ACount++;
                            break;
                        case B:
                            BCount++;
                            break;
                        case C:
                            CCount++;
                            break;
                        case D:
                            DCount++;
                            break;
                        case E:
                            ECount++;
                            break;
                        default:
                            break;
                    }
                }
                //end for

                switch(AllQuestions.get(17).getCurrentCondition()){
                    case A: //'A'
                        return ( ACount == BCount ); //equal to B answer count
                    case B: //'B'
                        return ( ACount == CCount ); //equal to C answer count
                    case C: //'C'
                        return ( ACount == DCount ); //equal to D answer count
                    case D: //'D'
                        return ( ACount == ECount ); //equal to E answer count
                    case E: //'E'
                        return ( ACount != BCount && ACount != CCount && ACount != DCount && ACount != ECount );
                    default:
                        return false;
                }
            }
        });

        AllQuestions.get(18).setConditionChecker(new MyConditionChecker() {
            @Override
            public boolean CheckCondition() {
                /**
                 * Always true
                 */
                return true;
            }
        });

        AllQuestions.get(19).setConditionChecker(new MyConditionChecker() {
            @Override
            public boolean CheckCondition() {
                /**
                 * Always true
                 */
                return true;
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
