package com.example.Table;

import android.app.Activity;
import android.os.Bundle;

public class MyActivity extends Activity {

    MyQuestionsHandler Questions;



    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        Questions.fillQuestions();


    }
}
