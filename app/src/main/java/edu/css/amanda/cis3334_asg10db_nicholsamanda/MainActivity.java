package edu.css.amanda.cis3334_asg10db_nicholsamanda;

/**
 * Created by Amanda on 4/1/2018.
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends Activity {

    // declare variables
    private User user;
    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = AppDatabase.getDatabase(getApplicationContext());

        // cleanup for testing some initial data
        database.userDao().removeAllUsers();
        // add some data
        List<User> users = database.userDao().getAllUser();
        if (users.size()==0) {
            database.userDao().addUser(new User(1, "Test 1", 1));
            user = database.userDao().getAllUser().get(0);
            Toast.makeText(this, String.valueOf(user.id), Toast.LENGTH_SHORT).show();
            Trophy trophy = new Trophy(user.id, "Learned to use 3");
            database.trophyDao().addTrophy(trophy);
            database.userDao().addUser(new User(2, "Test 2", 2));
            database.userDao().addUser(new User(3, "Test 3", 3));
        }

        updateFirstUserData();

    }


    private void updateFirstUserData() {
        List<User> user = database.userDao().getAllUser();
        List<Trophy> trophiesForUser = database.trophyDao().findTrophiesForUser(user.get(0).id);
        TextView textView = findViewById(R.id.result);              // don't have .xml
        Toast.makeText(this, trophiesForUser.toString(), Toast.LENGTH_SHORT).show();
        if (user.size()>0){
            textView.setText(user.get(0).name + " Skill points " + user.get(0).skillPoints + " Trophys " + trophiesForUser.size() );
        }
    }

    public void onClick(View view){
        if (view.getId()==R.id.addtrophybutton) {               // don't have .xml
            // TODO add trophy
            // TODO call updatefirstUserData
            Toast.makeText(this,String.valueOf(user.id), Toast.LENGTH_SHORT).show();
            Trophy trophy = new Trophy(user.id, "More stuff");
            database.trophyDao().addTrophy(trophy);
        }
        if (view.getId()==R.id.increaseskills ){                // don't have .xml
            user.skillPoints++;
            database.userDao().updateUser(user);
            // TODO to skillpoints

        }
        // TODO call updatefirstUserData
        updateFirstUserData();

    }
    // reset instance
    @Override
    protected void onDestroy() {
        AppDatabase.destroyInstance();
        super.onDestroy();
    }
}
