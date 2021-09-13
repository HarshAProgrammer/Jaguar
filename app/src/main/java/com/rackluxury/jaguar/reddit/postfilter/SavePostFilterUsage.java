package com.rackluxury.jaguar.reddit.postfilter;

import java.util.concurrent.Executor;

import com.rackluxury.jaguar.reddit.RedditDataRoomDatabase;

public class SavePostFilterUsage {
    public static void savePostFilterUsage(RedditDataRoomDatabase redditDataRoomDatabase, Executor executor,
                                           PostFilterUsage postFilterUsage) {
        executor.execute(() -> redditDataRoomDatabase.postFilterUsageDao().insertPostFilterUsage(postFilterUsage));
    }
}
