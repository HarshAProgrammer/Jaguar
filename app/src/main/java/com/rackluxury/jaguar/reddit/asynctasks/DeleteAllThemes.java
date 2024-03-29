package com.rackluxury.jaguar.reddit.asynctasks;

import android.content.SharedPreferences;
import android.os.Handler;

import java.util.concurrent.Executor;

import com.rackluxury.jaguar.reddit.RedditDataRoomDatabase;

public class DeleteAllThemes {

    public static void deleteAllThemes(Executor executor, Handler handler,
                                       RedditDataRoomDatabase redditDataRoomDatabase,
                                       SharedPreferences lightThemeSharedPreferences,
                                       SharedPreferences darkThemeSharedPreferences,
                                       SharedPreferences amoledThemeSharedPreferences,
                                       DeleteAllThemesListener deleteAllThemesListener) {
        executor.execute(() -> {
            redditDataRoomDatabase.customThemeDao().deleteAllCustomThemes();
            lightThemeSharedPreferences.edit().clear().apply();
            darkThemeSharedPreferences.edit().clear().apply();
            amoledThemeSharedPreferences.edit().clear().apply();
            handler.post(deleteAllThemesListener::success);
        });
    }

    public interface DeleteAllThemesListener {
        void success();
    }
}
