package com.example.contactsapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactsapplication.Adapter.AdapterView;
import com.example.contactsapplication.model.DetailsClass;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText rsname,rsage;
    RadioButton rdoMale, rdoFemale;
    RadioGroup radioGroup;
    Spinner spinnerimg;
    RecyclerView viewR;
    Button btnsave;
    String gender, name, age;
    int imageposition;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rsname = findViewById(R.id.rsname);
        rsage = findViewById(R.id.rsage);
        rdoMale = findViewById(R.id.rdoMale);
        rdoFemale = findViewById(R.id.rdoFemale);
        spinnerimg = findViewById(R.id.spinnerimg);
        btnsave = findViewById(R.id.btnsave);
        radioGroup = findViewById(R.id.radiogroup);
        viewR = findViewById(R.id.recy);
        final List<DetailsClass> detailsClasses = new ArrayList<>();
        final int[] title = {

                (R.drawable.pele),
                (R.drawable.messi),
                (R.drawable.crs),
                (R.drawable.robben),
                (R.drawable.zidane)
        };
        final String[] titlename={
                "Pele",
                "Messi",
                "crs",
                "zidane",
                "robben",
        };

        ArrayAdapter<String> imgtitle = new ArrayAdapter<>(MainActivity.this,
                android.R.layout.simple_list_item_1, titlename);
        spinnerimg.setAdapter(imgtitle);
        btnsave.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                name = rsname.getText().toString();
                int selectid = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(selectid);
                gender = radioButton.getText().toString();
                age = (rsage.getText().toString());
                int position = (spinnerimg.getSelectedItemPosition());
                imageposition = title [position];
                detailsClasses.add(new DetailsClass(name, age, gender, imageposition));
                AdapterView adapterView=new AdapterView(MainActivity.this,detailsClasses);
                viewR.setAdapter(adapterView);
                viewR.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            }
        });
    }
}
