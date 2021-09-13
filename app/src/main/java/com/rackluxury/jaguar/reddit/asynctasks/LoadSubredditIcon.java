package com.rackluxury.jaguar.reddit.asynctasks;

import android.os.Handler;

import java.util.ArrayList;
import java.util.concurrent.Executor;

import com.rackluxury.jaguar.reddit.RedditDataRoomDatabase;
import com.rackluxury.jaguar.reddit.subreddit.FetchSubredditData;
import com.rackluxury.jaguar.reddit.subreddit.SubredditDao;
import com.rackluxury.jaguar.reddit.subreddit.SubredditData;
import retrofit2.Retrofit;

public class LoadSubredditIcon {

    public static void loadSubredditIcon(Executor executor, Handler handler, RedditDataRoomDatabase redditDataRoomDatabase,
                                         String subredditName, Retrofit retrofit,
                                         LoadSubredditIconAsyncTaskListener loadSubredditIconAsyncTaskListener) {
        executor.execute(() -> {
            SubredditDao subredditDao = redditDataRoomDatabase.subredditDao();
            SubredditData subredditData = subredditDao.getSubredditData(subredditName);
            if (subredditData != null) {
                String iconImageUrl = subredditDao.getSubredditData(subredditName).getIconUrl();
                handler.post(() -> loadSubredditIconAsyncTaskListener.loadIconSuccess(iconImageUrl));
            } else {
                handler.post(() -> FetchSubredditData.fetchSubredditData(retrofit, subredditName, new FetchSubredditData.FetchSubredditDataListener() {
                    @Override
                    public void onFetchSubredditDataSuccess(SubredditData subredditData1, int nCurrentOnlineSubscribers) {
                        ArrayList<SubredditData> singleSubredditDataList = new ArrayList<>();
                        singleSubredditDataList.add(subredditData1);
                        InsertSubscribedThings.insertSubscribedThings(executor, handler, redditDataRoomDatabase, null,
                                null, null, singleSubredditDataList,
                                () -> loadSubredditIconAsyncTaskListener.loadIconSuccess(subredditData1.getIconUrl()));
                    }

                    @Override
                    public void onFetchSubredditDataFail(boolean isQuarantined) {
                        loadSubredditIconAsyncTaskListener.loadIconSuccess(null);
                    }
                }));
            }
        });
    }

    public interface LoadSubredditIconAsyncTaskListener {
        void loadIconSuccess(String iconImageUrl);
    }
}
