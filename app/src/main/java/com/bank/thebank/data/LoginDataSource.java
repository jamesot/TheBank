package com.bank.thebank.data;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;


import com.bank.thebank.Interface.ResultCallback;
import com.bank.thebank.Interface.ServerLoginCallback;
import com.bank.thebank.controllers.PostData;
import com.bank.thebank.data.model.LoggedInUser;
import com.bank.thebank.data.model.Login;
import com.bank.thebank.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;
import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
public class LoginDataSource {

    private boolean debug;

    public void login(final String username, String password, final Context context, final ResultCallback<LoggedInUser> callback) {

        try {
            Log.e("user", "loggin in user");
            String userName = "Guest";
            if (Utils.checkDefaults("ui_user_name", context))
                userName = Utils.getDefaults("ui_user_name", context);

//            Saving data to SQLite using Litepal Framework
            checkUserIfExistsThenSave(username, userName, password, context);
            Utils.setDefaults("is_loggedin", "true", context);

            LoggedInUser realUser =
                    new LoggedInUser(
                            java.util.UUID.randomUUID().toString(),
                            userName);
            callback.handleResult(new Result.Success<>(realUser));


            // TODO: Function below handles authentication using remote server aunthenication
            // TODO: Due to time constraint, I wasn't able to finalize on that, uncomment code to see that

            /*Map<String, String> credentials = new HashMap<String, String>();
            credentials.put("userid", username);
            credentials.put("password", password);

            PostData postData = new PostData(context);
            postData.login("login/mobile", credentials, null, null, new ServerLoginCallback() {
                @Override
                public Result.Success<LoggedInUser> onSuccess(String result) {
                    try {
                        JSONObject jsonObject = new JSONObject(result);
                        Utils.setDefaults("is_logged_in", "true", context);
                        LoggedInUser realUser =
                                new LoggedInUser(
                                        java.util.UUID.randomUUID().toString(),
                                        jsonObject.getString("first_name") +
                                                " " + jsonObject.getString("last_name"));
                        callback.handleResult(new Result.Success<>(realUser));

                    } catch (JSONException e) {
                        callback.handleResult(new Result.Error(new Exception("Error parsing server response", e)));
                    }

                    return null;
                }

                @Override
                public void onSuccess(JSONObject response) {

                }
            });*/

        } catch (Exception e) {
            Log.e("error while logging in", e.toString());
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }

    private void checkUserIfExistsThenSave(String nat_id, String username, String password, Context context) {
        List<String> stringList = new ArrayList<String>();
        Cursor cursor = null;

        try {
            cursor = Connector.getDatabase().rawQuery("select * from login where national_id=" + nat_id,
                    null);
            if (cursor.getCount() < 1) {
                Log.e("No data", "No data");

                Login login = new Login();
                login.setNaitionalId(nat_id);
                login.setPassword(password);
                login.setUserName(username);
                login.save();
                Utils.showToast("New user account created", context);

            }

            if (cursor.moveToFirst()) {
                do {


                    String id = cursor.getString(cursor.getColumnIndex("id"));
                    Utils.showToast("You have successfully logged in!", context);

                } while (cursor.moveToNext());
                Log.e("StringList", stringList.toString() + stringList.size());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }
}
