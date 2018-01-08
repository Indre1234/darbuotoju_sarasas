package com.byethost32.httpindre1234.darbuotoju_sarasas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Button loginButton = (Button) findViewById(R.id.login_submit);

        final EditText loginUsernanme = (EditText) findViewById(R.id.login_username);

        final EditText loginPassword = (EditText) findViewById(R.id.login_password);


        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //vygdomas kodas kai paspaudziam mygtuka

                //pirmas parametras langas i kuri isves pranesima
                //antras teksatas
                //trecias pranesimo galiojimas
                Toast.makeText(LoginActivity.this,
                        "Prisijungimo vardas: " + loginUsernanme.getText().toString() + "\n" +
                        "Slaptažodis: " + loginPassword.getText().toString(),
                        Toast.LENGTH_LONG).show();

                Intent goToSearchActivity = new Intent(LoginActivity.this, SearchActivity.class);
                startActivity(goToSearchActivity);
            }


        });




    }
}