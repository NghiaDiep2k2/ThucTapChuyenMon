package com.example.foodapp.retrofit;

import com.example.foodapp.model.NotiResponse;
import com.example.foodapp.model.NotiSendData;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiPushNotification {
    @Headers(
            {
                    "Content-Type:application/json",
                        "Authorization:key=AAAAwQXU_oc:APA91bHCGZuYTjpVmZ6XGshoSUb3o6AK51QUk6-3ZH9Ax-8t4FNSt-K0oPhoEVVcWgQ8SggtVVotDm_7ouKpytqVbgpbGZ10gh50swTaKjf3pG_d9lXFhljVYxn5mis1JQ_e6QJWvU08"
            }
    )
    @POST("fcm/send")
    Observable<NotiResponse> sendNotification(@Body NotiSendData data);
}
