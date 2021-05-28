package com.example.todo_22;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class Bookloader extends AsyncTaskLoader<String> {
    private String mQuaryString;

    Bookloader(Context context, String queryString) {
        super(context);
        mQuaryString = queryString;
    }

    @Nullable
    @Override
    public String loadInBackground() {
        return NetworkUtils.getBookInfo(mQuaryString);

    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}
