package com.reloader.classroomdeveloper;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.reloader.classroomdeveloper.Servicios.Constantes;
import com.reloader.classroomdeveloper.Servicios.HelperWs;
import com.reloader.classroomdeveloper.Servicios.MethodWs;

import java.io.IOException;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
/**
 * Created by Reloader on 16/03/2020.
 */
public class MainActivity extends AppCompatActivity {

    Button btn_buscar;
    String KeyApi, Token, coursesStates, studentId, teacherId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.item_cursos);

       // btn_buscar = findViewById(R.id.btn_buscar);

        //https://classroom.googleapis.com/v1/courses?courseStates=ACTIVE&studentId=jgrandez.ti@sacooliveros.edu.pe&teacherId=106561750177077134995


//        btn_buscar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                showRecycler();
//            }
//        });
//
//        KeyApi = Constantes.API_KEY;
//        Token = Constantes.TOKEN_CLASSROOM;
//        coursesStates = "ACTIVE";
//        studentId = "jgrandez.ti@sacooliveros.edu.pe";
//        teacherId = "106561750177077134995";
    }

    private void showRecycler() {
        MethodWs methodWs = HelperWs.getConfiguration(this).create(MethodWs.class);
        Call<ResponseBody> responseBodyCall = methodWs.getCursosMail(coursesStates, studentId, teacherId, Token);
        responseBodyCall.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                ResponseBody informacion = response.body();

                if (response.isSuccessful()) {
                    try {
                        String cadena_respuesta = informacion.string();
                        Log.v("RsptaResponse", cadena_respuesta);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("infoResponseFalse", t.getMessage());
            }
        });
    }

}
