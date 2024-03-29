package com.rackluxury.jaguar.reddit.services;

import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;

import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.inject.Named;

import com.rackluxury.jaguar.reddit.Infinity;
import com.rackluxury.jaguar.reddit.RedditDataRoomDatabase;
import com.rackluxury.jaguar.reddit.customtheme.CustomThemeWrapper;
import com.rackluxury.jaguar.reddit.utils.MaterialYouUtils;
import com.rackluxury.jaguar.reddit.utils.SharedPreferencesUtils;

public class MaterialYouService extends IntentService {

    @Inject
    @Named("default")
    SharedPreferences mSharedPreferences;
    @Inject
    @Named("light_theme")
    SharedPreferences lightThemeSharedPreferences;
    @Inject
    @Named("dark_theme")
    SharedPreferences darkThemeSharedPreferences;
    @Inject
    @Named("amoled_theme")
    SharedPreferences amoledThemeSharedPreferences;
    @Inject
    RedditDataRoomDatabase redditDataRoomDatabase;
    @Inject
    CustomThemeWrapper customThemeWrapper;
    @Inject
    Executor executor;

    public MaterialYouService() {
        super("MaterialYouService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        ((Infinity) getApplication()).getAppComponent().inject(this);
        if (mSharedPreferences.getBoolean(SharedPreferencesUtils.ENABLE_MATERIAL_YOU, false)) {
            MaterialYouUtils.changeTheme(this, executor, new Handler(), redditDataRoomDatabase,
                    customThemeWrapper, lightThemeSharedPreferences, darkThemeSharedPreferences,
                    amoledThemeSharedPreferences);
        }
    }
}