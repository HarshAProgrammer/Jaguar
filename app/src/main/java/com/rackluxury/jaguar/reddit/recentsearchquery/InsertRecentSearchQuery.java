package com.rackluxury.jaguar.reddit.recentsearchquery;

import android.os.AsyncTask;

import java.util.List;

import com.rackluxury.jaguar.reddit.RedditDataRoomDatabase;

public class InsertRecentSearchQuery {
    public interface InsertRecentSearchQueryListener {
        void success();
    }

    public static void insertRecentSearchQueryListener(RedditDataRoomDatabase redditDataRoomDatabase, String username,
                                                String recentSearchQuery, InsertRecentSearchQueryListener insertRecentSearchQueryListener) {
        new InsertRecentSearchQueryAsyncTask(redditDataRoomDatabase, username, recentSearchQuery, insertRecentSearchQueryListener).execute();
    }

    private static class InsertRecentSearchQueryAsyncTask extends AsyncTask<Void, Void, Void> {

        private final RecentSearchQueryDao recentSearchQueryDao;
        private final String username;
        private final String recentSearchQuery;
        private final InsertRecentSearchQueryListener insertRecentSearchQueryListener;

        public InsertRecentSearchQueryAsyncTask(RedditDataRoomDatabase redditDataRoomDatabase, String username,
                                                String recentSearchQuery, InsertRecentSearchQueryListener insertRecentSearchQueryListener) {
            this.recentSearchQueryDao = redditDataRoomDatabase.recentSearchQueryDao();
            this.username = username;
            this.recentSearchQuery = recentSearchQuery;
            this.insertRecentSearchQueryListener = insertRecentSearchQueryListener;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            List<RecentSearchQuery> recentSearchQueries = recentSearchQueryDao.getAllRecentSearchQueries(username);
            if (recentSearchQueries.size() >= 5) {
                for (int i = 4; i < recentSearchQueries.size(); i++) {
                    recentSearchQueryDao.deleteRecentSearchQueries(recentSearchQueries.get(i));
                }
            }

            recentSearchQueryDao.insert(new RecentSearchQuery(username, recentSearchQuery));
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            insertRecentSearchQueryListener.success();
        }
    }
}
