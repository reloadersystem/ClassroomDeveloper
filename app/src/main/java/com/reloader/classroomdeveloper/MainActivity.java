package com.reloader.classroomdeveloper;

import android.os.Bundle;
import android.util.Log;

import com.reloader.classroomdeveloper.Servicios.Constantes;
import com.reloader.classroomdeveloper.Servicios.HelperWs;
import com.reloader.classroomdeveloper.Servicios.MethodWs;

import java.io.IOException;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //https://classroom.googleapis.com/v1/courses?courseStates=ACTIVE&studentId=jgrandez.ti@sacooliveros.edu.pe&teacherId=106561750177077134995


        String KeyApi = Constantes.API_KEY;
        String Token = Constantes.TOKEN_CLASSROOM;
        String coursesStates = "ACTIVE";
        String studentId = "jgrandez.ti@sacooliveros.edu.pe";
        String teacherId = "106561750177077134995";


        MethodWs methodWs = HelperWs.getConfiguration(this).create(MethodWs.class);
        Call<ResponseBody> responseBodyCall = methodWs.getCursosMail(coursesStates, studentId, teacherId, Token);
        responseBodyCall.enqueue(new Callback<ResponseBody>() {

            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                ResponseBody informacion = response.body();

                // mlistCategorias = new ArrayList<>();

                // https://classroom.googleapis.com/v1/courses?courseStates=ACTIVE&studentId=jgrandez.ti@sacooliveros.edu.pe&teacherId=106561750177077134995
                //https://classroom.googleapis.com/v1/courses?courseStates=ACTIVE&studentId=rcorrea.ti%40sacooliveros.edu.pe&teacherId=106561750177077134995&access_token=ya29.a0Adw1xeVKBdi1vy1uw6-HTBM1bP4XBMfxxNeGJlZ2FoWCBlC4kjpdaGNMnmJdmWZS72YMub1-6x5DeByLlGVznnNWbL4PPGa5MA9FzN56TRYIXi_jtUONEa9nXBEzK1PdIceFqotlCUlHEXRdW059mxixjP0paRna5FU&key=[YOUR_API_KEY]' \


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
