package com.example.todo_22;

import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.ref.WeakReference;
import java.util.jar.JarException;

public class Fetchbook extends AsyncTask<String,Void,String>{
    private WeakReference<TextView> mtitleText;
    private WeakReference<TextView> mAuthor;
    Fetchbook(TextView titleText, TextView authorText){
        this.mtitleText = new WeakReference<>(titleText);
        this.mAuthor = new WeakReference<>(authorText);
    }

    @Override
    protected String doInBackground(String... strings) {
        return NetworkUtils.getBookInfo(strings[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        try {
            JSONObject jsonObject =new JSONObject(s);
            JSONArray itemsArray = jsonObject.getJSONArray("items");

            int i =0;
            String title = null;
            String author = null;

            while (i < itemsArray.length() &&
                    (author == null && title == null)) {
                // Get the current item information.
                JSONObject book = itemsArray.getJSONObject(i);
                JSONObject volumeInfo = book.getJSONObject("volumeInfo");

                // Try to get the author and title from the current item,
                // catch if either field is empty and move on.
                try {
                    title = volumeInfo.getString("title");
                    author = volumeInfo.getString("authors");
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // Move to the next item.
                i++;
            }
            if (title != null && author != null) {
                mtitleText.get().setText(title);
                mAuthor.get().setText(author);
            }
            else {
                mtitleText.get().setText(R.string.no_results);
                mAuthor.get().setText("");
            }
        }
        catch (Exception e) {
            // If onPostExecute does not receive a proper JSON string,
            // update the UI to show failed results.
            mtitleText.get().setText(R.string.no_results);
            mAuthor.get().setText("");
            e.printStackTrace();
        }
        super.onPostExecute(s);
    }

}
