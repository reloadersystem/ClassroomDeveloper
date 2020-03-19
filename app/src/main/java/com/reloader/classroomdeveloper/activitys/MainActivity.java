package com.reloader.classroomdeveloper.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.reloader.classroomdeveloper.Entidades.MCursos;
import com.reloader.classroomdeveloper.R;
import com.reloader.classroomdeveloper.Servicios.Constantes;
import com.reloader.classroomdeveloper.Servicios.HelperWs;
import com.reloader.classroomdeveloper.Servicios.MethodWs;
import com.reloader.classroomdeveloper.adapters.RecyclerAdapterCursos;
import com.reloader.classroomdeveloper.interfaces.OnCursosListener;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Reloader on 16/03/2020.
 */
public class MainActivity extends AppCompatActivity {

    Button btn_buscar;
    String KeyApi, Token, coursesStates, studentId, teacherId, Refresh_Token;
    private List<MCursos> mCursosList;
    RecyclerAdapterCursos recyclerAdapterCursos;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_buscar = findViewById(R.id.btn_buscar);
        recyclerView = findViewById(R.id.recycler_cursos);

        mCursosList = new ArrayList<>();

        //https://classroom.googleapis.com/v1/courses?courseStates=ACTIVE&studentId=jgrandez.ti@sacooliveros.edu.pe&teacherId=106561750177077134995


        btn_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KeyApi = Constantes.API_KEY;
                Token = Constantes.TOKEN_CLASSROOM;
                Refresh_Token = Constantes.TOKEN_REFRESH;
                coursesStates = "ACTIVE";
                //studentId = "rcorrea.ti@sacooliveros.edu.pe";
                studentId = "classroom.dev@sacooliveros.edu.pe";
//                teacherId = "103900861770560048977"; //5to catolica
                teacherId = "112956248399671464321"; //5to sm

                {
                    MethodWs methodWs = HelperWs.getConfiguration(getApplicationContext()).create(MethodWs.class);
                    Call<ResponseBody> responseBodyCall = methodWs.getCursosMail(coursesStates, studentId, teacherId, Token);
                    responseBodyCall.enqueue(new Callback<ResponseBody>() {

                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            ResponseBody informacion = response.body();

                            if (response.isSuccessful()) {
                                try {
                                    String cadena_respuesta = informacion.string();
                                    Log.v("RsptaResponse", cadena_respuesta);

                                    JSONObject jsonObject = new JSONObject(cadena_respuesta);
                                    String coursesdata = jsonObject.getString("courses");

                                    JSONArray jsonArray = new JSONArray(coursesdata);
                                    int datos = jsonArray.length();
                                    Log.v("datos", datos + "solucion");

                                    for (int idx = 0; idx < datos; idx++) {

                                        JSONObject jsonCursos = jsonArray.getJSONObject(idx);
//                            String id = jsonCursos.getString("id");
//                            String name = jsonCursos.getString("name");
//                            String section = jsonCursos.getString("section");
//                            String descriptionHeading = jsonCursos.getString("descriptionHeading");
//                            String room = jsonCursos.getString("room");
//                            String ownerId = jsonCursos.getString("ownerId");
//                            String creationTime = jsonCursos.getString("creationTime");
//                            String updateTime = jsonCursos.getString("updateTime");
//                            String enrollmentCode = jsonCursos.getString("enrollmentCode");
//                            String courseState = jsonCursos.getString("courseState");
//                            String alternateLink = jsonCursos.getString("alternateLink");
//                            String teacherGroupEmail = jsonCursos.getString("teacherGroupEmail");
//                            String courseGroupEmail = jsonCursos.getString("courseGroupEmail");
//                            JSONObject folders = jsonCursos.getJSONObject("teacherFolder");
//                            String guardiansEnabled = jsonCursos.getString("guardiansEnabled");
//                            String calendarId = jsonCursos.getString("calendarId");

                                        mCursosList.add(new MCursos(
                                                jsonCursos.getString("id"),
                                                jsonCursos.getString("name"),
                                                jsonCursos.getString("section"),
                                                jsonCursos.getString("descriptionHeading"),
                                                // jsonCursos.getString("room"),
                                                jsonCursos.getString("ownerId"),
                                                jsonCursos.getString("creationTime"),
                                                jsonCursos.getString("updateTime"),
                                                jsonCursos.getString("enrollmentCode"),
                                                jsonCursos.getString("courseState"),
                                                jsonCursos.getString("alternateLink"),
                                                jsonCursos.getString("teacherGroupEmail"),
                                                jsonCursos.getString("courseGroupEmail"),
                                                // jsonCursos.getJSONObject("teacherFolder"),
                                                jsonCursos.getString("guardiansEnabled"),
                                                jsonCursos.getString("calendarId")
                                        ));
                                    }

                                    GridLayoutManager layoutManager
                                            = new GridLayoutManager(MainActivity.this, 2);
                                    recyclerAdapterCursos = new RecyclerAdapterCursos(MainActivity.this, mCursosList);
                                    recyclerView.setLayoutManager(layoutManager);
                                    recyclerView.setAdapter(recyclerAdapterCursos);
                                    recyclerAdapterCursos.setOnCursosListener(new OnCursosListener() {
                                        @Override
                                        public void onCursosTitleClicked(int position) {

                                            String name = mCursosList.get(position).getName();
                                            String section = mCursosList.get(position).getSection();
                                            String enrollmentCode = mCursosList.get(position).getEnrollmentCode();

                                            Intent intent = new Intent(MainActivity.this, ClaseClassroomActivity.class);
                                            intent.putExtra("name", name);
                                            intent.putExtra("section", section);
                                            intent.putExtra("enrollmentCode", enrollmentCode);
                                            startActivity(intent);
                                        }
                                    });


                                } catch (Exception e) {
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
        });
    }

}
