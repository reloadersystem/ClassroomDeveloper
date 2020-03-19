package com.reloader.classroomdeveloper.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.reloader.classroomdeveloper.R;

import androidx.appcompat.app.AppCompatActivity;

public class ClaseClassroomActivity extends AppCompatActivity {

    private String name;
    private String section;
    private String enrollmentCode;

    TextView txt_clasetitle, txt_clasedescripcion, txt_clasecodigo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clase_classroom);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            name = (String) bundle.get("name");
            section = (String) bundle.get("section");
            enrollmentCode = (String) bundle.get("enrollmentCode");
        }

        txt_clasetitle = findViewById(R.id.txt_clasetitle);
        txt_clasedescripcion = findViewById(R.id.txt_clasedescripcion);
        txt_clasecodigo = findViewById(R.id.txt_clasecodigo);

        txt_clasetitle.setText(name);
        txt_clasedescripcion.setText(section);
        txt_clasecodigo.setText("Código de la clase: " + enrollmentCode);
    }
}
