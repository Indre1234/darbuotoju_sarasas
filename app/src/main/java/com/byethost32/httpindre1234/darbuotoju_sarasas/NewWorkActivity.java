package com.byethost32.httpindre1234.darbuotoju_sarasas;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
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

        final CheckBox rd_2014 = (CheckBox) findViewById(R.id.rd_2014);
        final CheckBox rd_2015 = (CheckBox) findViewById(R.id.rd_2015);
        final CheckBox rd_2016 = (CheckBox) findViewById(R.id.rd_2016);
        final CheckBox rd_2017 = (CheckBox) findViewById(R.id.rd_2017);
        final CheckBox rd_2018 = (CheckBox) findViewById(R.id.rd_2018);

        final RadioGroup genders = (RadioGroup) findViewById(R.id.new_gender);
        final RadioButton[] gender = new RadioButton[1];

        final Spinner new_position = (Spinner) findViewById(R.id.new_position);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(NewWorkActivity.this,
                R.array.new_position, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        new_position.setAdapter(adapter);






        Button entry_new_work = (Button) findViewById(R.id.new_work_entry_button);
        final EditText new_work_name = (EditText) findViewById(R.id.new_work_name);
        final EditText new_work_secondname = (EditText) findViewById(R.id.new_work_socondname);

        final EditText new_pay = (EditText) findViewById(R.id.new_pay);






        entry_new_work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int selectedID = genders.getCheckedRadioButtonId();
                gender[0] = (RadioButton) findViewById(selectedID);



                StringBuffer vData = new StringBuffer();
                if (rd_2014.isChecked()) {
                    vData.append(getResources().getString(R.string.rd_2014)).append(",");
                }

                if (rd_2015.isChecked()) {
                    vData.append(getResources().getString(R.string.rd_2015)).append(" ");
                }

                if (rd_2016.isChecked()) {
                    vData.append(getResources().getString(R.string.rd_2016)).append(" ");
                }

                if (rd_2017.isChecked()) {
                    vData.append(getResources().getString(R.string.rd_2017)).append(" ");
                }

                if (rd_2018.isChecked()) {
                    vData.append(getResources().getString(R.string.rd_2018)).append(" ");
                }



                Toast.makeText(NewWorkActivity.this,vData+"\n"+gender[0].getText().toString()+"\n"+new_position.getSelectedItem().toString(), Toast.LENGTH_LONG).show();

                if (Validation.isValid(new_work_name.getText().toString()) && Validation.isValid(new_work_secondname.getText().toString())){
                    Toast.makeText(NewWorkActivity.this,
                            new_work_name.getText().toString()+"\n"+
                                    new_work_secondname.getText().toString()+"\n"+
                                    new_pay.getText().toString(), Toast.LENGTH_LONG).show();
                    registerUser(new_work_name.getText().toString(), new_work_secondname.getText().toString(), new_pay.getText().toString());

                    Intent goToSearchActivity = new Intent(NewWorkActivity.this, SearchActivity.class);
                    startActivity(goToSearchActivity);

                    //Toast.makeText(NewWorkActivity.this, "Darbuotojas sekmingai įtrauktas į lentelę", Toast.LENGTH_LONG).show();
                } else {
                    //Toast.makeText(NewWorkActivity.this, "Blogai įvesti duomenys", Toast.LENGTH_LONG).show();
                }
            }
        });

    }



    private void registerUser(String name, String secondname, String pay) {
        String urlSuffix = "?name="+name+"&secondname="+secondname+"&pay="+pay;
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
