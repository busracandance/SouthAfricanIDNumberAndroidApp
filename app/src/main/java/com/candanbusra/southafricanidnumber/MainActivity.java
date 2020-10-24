package com.candanbusra.southafricanidnumber;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etInput;
    Button btnSubmit;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            etInput=findViewById(R.id.etInput);
            btnSubmit=findViewById(R.id.btnSubmit);
            tvResult=findViewById(R.id.tvResult);

            tvResult.setVisibility(View.GONE);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            btnSubmit.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {

                    String id=etInput.getText().toString().trim();
                    if (id.length()!=13){

                        builder.setTitle("WARNING!");
                        builder.setMessage("PLEASE ENTER A VALID ID NUMBER.");
                        builder.setPositiveButton("OK", null);
                        builder.show();
                    }
                    String dateOfBirth=id.substring(0,6);
                    String editedDateOfBirth=dateOfBirth.substring(0,2)+"/"+dateOfBirth.substring(2,4)+"/"+dateOfBirth.substring(4,6);

                    int gender= Integer.parseInt(Character.toString(id.charAt(6)));
                    String sGender;
                    if (gender<5)
                        sGender="Female";
                    else
                        sGender="Male";

                    int nationality=Integer.parseInt(Character.toString(id.charAt(10)));
                    String sNationality;
                    if (nationality==0)
                        sNationality="South Africa Citizen";
                    else
                        sNationality="Permanent Resident";


                    tvResult.setText("Date of Birth: "+editedDateOfBirth+"\n"+"Gender: "+sGender+"\n"+"Nationality: "+sNationality);
                    tvResult.setVisibility(View.VISIBLE);
                }
            });

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}