package com.byethost32.httpindre1234.darbuotoju_sarasas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Button new_Work_Button = (Button) findViewById(R.id.new_work_button);

        new_Work_Button.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   Intent goToNewWorkActivity = new Intent(SearchActivity.this, NewWorkActivity.class);
                   startActivity(goToNewWorkActivity);
               }
           }


        );
    }
}





