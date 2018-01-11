package com.byethost32.httpindre1234.darbuotoju_sarasas;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RegisterActivity extends Activity {

    // kelias byethost iki register.php failiuko
    private static final String REGISTER_URL = "http://indre1234.byethost32.com/mobile/register.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);



        Button registration_Finish_Button = (Button) findViewById(R.id.registration_finish_button);
        final EditText registrationUserName = (EditText) findViewById(R.id.registration_username);
        final EditText registrationEmail = (EditText) findViewById(R.id.registration_email);
        final EditText registrationPassword = (EditText) findViewById(R.id.registration_password);



        registration_Finish_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Validation.isValid(registrationUserName.getText().toString()) && Validation.isValidEmail(registrationEmail.getText().toString()) && Validation.isValid(registrationPassword.getText().toString())){

                    registerUser(registrationUserName.getText().toString(), registrationPassword.getText().toString(), registrationEmail.getText().toString());
                    Intent goToRegistrationActivity = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(goToRegistrationActivity);
                    Toast.makeText(RegisterActivity.this, "Sekmingai užregistruotas naujas vartotojas", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(RegisterActivity.this, "Blogai įvesti duomenys", Toast.LENGTH_LONG).show();
                }
            }
        });

    }



    private void registerUser(String username, String password, String email) {
        String urlSuffix = "?username="+username+"&password="+password+"&email="+email;
        class RegisterUser extends AsyncTask<String, Void, String> {

            ProgressDialog loading;


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(RegisterActivity.this, "Prašome palaukti",null, true, true);
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
