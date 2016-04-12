package ui;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import parts.Part2;
import ru.uraljournal.udevs.ural.R;

public class ParseTask extends AsyncTask<Void, Void, String> {
    //использование new ParseTask().execute();
    HttpURLConnection urlConnection = null;
    BufferedReader reader = null;
    String resultJson = "";
    public List<Person> urlList;
    public RecyclerView rv;

    public static String LOG_TAG = "my_log";

    @Override
    protected String doInBackground(Void... params) {
        // получаем данные с внешнего ресурса
        try {
            URL url = new URL("http://addvural.pe.hu/052013.json");

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuilder buffer = new StringBuilder();

            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            resultJson = buffer.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultJson;
    }

    @Override
    protected void onPostExecute(String strJson) {
        super.onPostExecute(strJson);
        // выводим целиком полученную json-строку
        Log.d(LOG_TAG, strJson);

        JSONObject dataJsonObj;
        String secondName;

        try {
            dataJsonObj = new JSONObject(strJson);
            JSONArray friends = dataJsonObj.getJSONArray("Films");

            Log.d(LOG_TAG, "Вошли в Films: " + friends);
            urlList = new ArrayList<>();

            for (int i = 1; i < friends.length(); i++) {
                JSONObject c = friends.getJSONObject(i);

                String title = c.getString("title");
                String author = c.getString("author");
                String razdel = c.getString("razdel");

                Log.i(LOG_TAG, title);
                Log.i(LOG_TAG, author);
                Log.i(LOG_TAG, razdel);
                urlList.add(new Person(author, title, R.drawable.ic_launcher));
            }

            new Part2().persons = urlList;
            // 1. достаем инфо о втором друге - индекс 1
            /*JSONObject secondFriend = friends.getJSONObject(1);
            secondName = secondFriend.getString("name");
            Log.d(LOG_TAG, "Второе имя: " + secondName);*/

            // 2. перебираем и выводим контакты каждого друга
            /*for (int i = 0; i < friends.length(); i++) {
                JSONObject friend = friends.getJSONObject(i);

                JSONObject contacts = friend.getJSONObject("contacts");

                String phone = contacts.getString("mobile");
                String email = contacts.getString("email");
                String skype = contacts.getString("skype");

                Log.d(LOG_TAG, "phone: " + phone);
                Log.d(LOG_TAG, "email: " + email);
                Log.d(LOG_TAG, "skype: " + skype);
            }*/

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
