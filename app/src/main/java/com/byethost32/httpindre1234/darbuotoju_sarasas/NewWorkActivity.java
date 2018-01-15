package com.byethost32.httpindre1234.darbuotoju_sarasas;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NewWorkActivity extends AppCompatActivity {
    // kelias byethost iki register.php failiuko
    private static final String REGISTER_URL = "http://indre1234.byethost32.com/mobile/new_work.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_work);

        Button entry_new_work = (Button) findViewById(R.id.new_work_entry_button);
        final EditText new_work_name = (EditText) findViewById(R.id.new_work_name);
        final EditText new_work_secondname = (EditText) findViewById(R.id.new_work_socondname);

        final EditText new_position = (EditText) findViewById(R.id.new_position);



        entry_new_work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Validation.isValid(new_work_name.getText().toString()) && Validation.isValid(new_work_secondname.getText().toString()) && Validation.isValid(new_position.getText().toString())){

                    registerUser(new_work_name.getText().toString(), new_work_secondname.getText().toString(), new_position.getText().toString());
                    Intent goToSearchActivity = new Intent(NewWorkActivity.this, SearchActivity.class);
                    startActivity(goToSearchActivity);
                    Toast.makeText(NewWorkActivity.this, "Darbuotojas sekmingai įtrauktas į lentelę", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(NewWorkActivity.this, "Blogai įvesti duomenys", Toast.LENGTH_LONG).show();
                }
            }
        });

    }



    private void registerUser(String name, String secondname, String position) {
        String urlSuffix = "?name="+name+"&secondname="+secondname+"&position="+position;
        class RegisterUser extends AsyncTask<String, Void, String> {

            ProgressDialog loading;


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(NewWorkActivity.this, "Prašome palaukti",null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(String... params) {
                String s = params[0];

                BufferedReader bufferedReader = null;
                try {
                    URL url = new URL(REGISTER_URL+s);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();

                    // byethost naudoja antibot sistema, todel reikia kiekvienam rankutėmis suvesti cookie turinį,
                    // kuris pas kiekviena bus skirtingas. kaip tai padaryti zemiau nuoroda
                    // http://stackoverflow.com/questions/31912000/byethost-server-passing-html-values-checking-your-browser-with-json-string
                    con.setRequestProperty("Cookie", "__test=7a4d917e220fbf9a55cab3046bd1a3b7; expires=2038 m. sausio 1 d., penktadienis 01:55:55; path=/");
                    bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                    String result;

                    result = bufferedReader.readLine();

                    return result;
                }catch(Exception e){
                    return null;
                }
            }
        }

        RegisterUser ru = new RegisterUser();
        ru.execute(urlSuffix);
    }
}
