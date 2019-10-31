package csc207.phase1.UTFantasy.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import csc207.phase1.UTFantasy.Character.Player;
import csc207.phase1.UTFantasy.R;
import csc207.phase1.UTFantasy.User;
import csc207.phase1.UTFantasy.UserManager;

public class CustomizeActivity extends Activity {

    // determine the progress of this activity
    // 0 indicates player is asked for name
    // 1 indicates player is asked for gender
    private int progress = 0;

    // the name of the player
    private String name;

    // the gender of the player
    private String gender;
    UserManager userManager = UserManager.getUserManager();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        // set the content view of this activity to activity_customize
        setContentView(R.layout.activity_customize);

        // initialize all the palette
        final Button buttonA = findViewById(R.id.button_a);
        final Button buttonB = findViewById(R.id.button_b);
        final TextView textViewName = findViewById(R.id.text_view_name);
        final TextView textViewGender = findViewById(R.id.text_view_gender);
        final EditText editTextName = findViewById(R.id.edit_text_name);
        final RadioGroup radioGroup = findViewById(R.id.radio_button_group);
        final RadioButton buttonBoy = findViewById(R.id.radio_button_boy);
        final RadioButton buttonGirl = findViewById(R.id.radio_button_girl);

        // the things to do when button A or button B is clicked
        final View.OnClickListener click = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (progress == 0) {
                    name = editTextName.getText().toString();
                    // assign name by the input of EditText
                    if (!name.isEmpty()){
                        // set the questions of name to be invisible
                        textViewName.setVisibility(View.GONE);
                        editTextName.setVisibility(View.GONE);

                        // set the questions of gender to be visible
                        textViewGender.setVisibility(View.VISIBLE);
                        radioGroup.setVisibility(View.VISIBLE);
                        buttonBoy.setVisibility(View.VISIBLE);
                        buttonGirl.setVisibility(View.VISIBLE);

                        // increase the progress
                        progress += 1;
                    }else{
                        Toast.makeText(CustomizeActivity.this,
                                "Please Create A Name", Toast.LENGTH_LONG).show();
                        progress = 0;
                    }


                } else if (progress == 1) {

                        if (buttonBoy.isChecked()) {
                        gender = "boy";
                        move_to_main();
                        }else if (buttonGirl.isChecked()){
                        gender = "girl";
                        move_to_main();
                        }else{
                            Toast.makeText(CustomizeActivity.this,
                                    "Please Choose A Gender", Toast.LENGTH_LONG).show();
                        }

                }
            }
        };
        buttonA.setOnClickListener(click);

        buttonB.setOnClickListener(click);
    }

    private void move_to_main(){
        Intent login_intent = getIntent();
        final String username = login_intent.getStringExtra("username");
        // initialize the intent
        Intent intent = new Intent(CustomizeActivity.this, MainActivity.class);

        // pass in name and gender to MainActivity
        Player player = new Player(name, gender);
        User user = userManager.getUser(username);
        user.setPlayer(player);
        userManager.saveUserManager(CustomizeActivity.this);
        intent.putExtra("username", username);

        // now go to main activity
        startActivity(intent);

    }
}
