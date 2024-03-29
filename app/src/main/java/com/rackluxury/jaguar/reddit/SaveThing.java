package com.rackluxury.jaguar.reddit;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

import com.rackluxury.jaguar.reddit.apis.RedditAPI;
import com.rackluxury.jaguar.reddit.utils.APIUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SaveThing {
    public static void saveThing(Retrofit oauthRetrofit, String accessToken, String fullname,
                                 SaveThingListener saveThingListener) {
        Map<String, String> params = new HashMap<>();
        params.put(APIUtils.ID_KEY, fullname);
        oauthRetrofit.create(RedditAPI.class).save(APIUtils.getOAuthHeader(accessToken), params).enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
                if (response.isSuccessful()) {
                    saveThingListener.success();
                } else {
                    saveThingListener.failed();
                }
            }

            @Override
            public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
                saveThingListener.failed();
            }
        });
    }

    public static void unsaveThing(Retrofit oauthRetrofit, String accessToken, String fullname,
                                   SaveThingListener saveThingListener) {
        Map<String, String> params = new HashMap<>();
        params.put(APIUtils.ID_KEY, fullname);
        oauthRetrofit.create(RedditAPI.class).unsave(APIUtils.getOAuthHeader(accessToken), params).enqueue(new Callback<String>() {
            @Override
            public void onResponse(@NonNull Call<String> call, @NonNull Response<String> response) {
                if (response.isSuccessful()) {
                    saveThingListener.success();
                } else {
                    saveThingListener.failed();
                }
            }

            @Override
            public void onFailure(@NonNull Call<String> call, @NonNull Throwable t) {
                saveThingListener.failed();
            }
        });
    }

    public interface SaveThingListener {
        void success();

        void failed();
    }
}
