package com.reloader.classroomdeveloper.Servicios;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by Reloader on 16/03/2020.
 */


public interface MethodWs {

    @GET("courses?")
    Call<ResponseBody> getCursosMail(
            @Query("courseStates") String courseStates,
            @Query("studentId") String studentId,
            @Query("teacherId") String teacherId,
            @Query("access_token") String access_token
    );

    @GET("wsObtenerSubCategoria.php?")
    @Headers("Content-Type:application/json")
    Call<ResponseBody> getSubCategorias(@Query("vIdCategoria") String vIdCategoria,
                                        @Query("vCoordenadas") String mCoordenadas
    );

    @GET("wsObtenerServicios.php?")
    @Headers("Content-Type:application/json")
    Call<ResponseBody> getServiciosSelected(@Query("vSubCategoria") String vSubCategoria,
                                            @Query("vIdEmpresa") String vIdEmpresa,
                                            @Query("vIdLocal") String vIdLocal
    );

    @GET("wsObtenerFavoritos.php?")
        //http://cfperuweb.com/aga/appReservas/wsObtenerFavoritos.php?vIdUsuario=2
    Call<ResponseBody> getListFavoritos(@Query("vIdUsuario") String vIdUsuario);

    @GET("wsObtenerHorariosDisponibles.php?")
        //http://cfperuweb.com/aga/appReservas/wsObtenerHorariosDisponibles.php?vFecha=2020-02-25&vIdLocal=1
    Call<ResponseBody> getHorariosDisponible(@Query("vFecha") String vFecha,
                                             @Query("vIdLocal") String vIdLocal);

    @GET("wsObtenerDetalleEmpresa.php?")
        //http://cfperuweb.com/aga/appReservas/wsObtenerDetalleEmpresa.php?vIdLocal=1
    Call<ResponseBody> getDetalleEmpresa(@Query("vIdLocal") String vIdLocal);

    @GET("wsVerificarExisteDelivery.php?")
        //http://cfperuweb.com/aga/appReservas/wsVerificarExisteDelivery.php?vIdLocal=1
    Call<ResponseBody> getVerificarDelivery(@Query("vIdLocal") String vIdLocal);

}

