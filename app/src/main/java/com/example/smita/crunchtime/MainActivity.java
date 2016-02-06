package com.example.smita.crunchtime;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editHeight = (EditText) findViewById(R.id.editHeight);
        final EditText editWeight = (EditText) findViewById(R.id.editWeight);
        final EditText editAge = (EditText) findViewById(R.id.editAge);
        final Switch gender = (Switch) findViewById(R.id.switch2);
        final Switch unit = (Switch) findViewById(R.id.switch1);
        final EditText number = (EditText) findViewById(R.id.etText);
        final Spinner type = (Spinner) findViewById(R.id.spinner);
        final TextView pushups = (TextView) findViewById(R.id.pushupsCount);
        final TextView situps = (TextView) findViewById(R.id.situpsCount);
        final TextView squats = (TextView) findViewById(R.id.squatsCount);
        final TextView leglift = (TextView) findViewById(R.id.legliftCount);
        final TextView plank = (TextView) findViewById(R.id.plankCount);
        final TextView jjacks = (TextView) findViewById(R.id.jumpingjackCount);
        final TextView pullup = (TextView) findViewById(R.id.pullupCount);
        final TextView cycle = (TextView) findViewById(R.id.cyclingCount);
        final TextView walk = (TextView) findViewById(R.id.walkingCount);
        final TextView jog = (TextView) findViewById(R.id.joggingCount);
        final TextView swim = (TextView) findViewById(R.id.swimmingCount);
        final TextView sclimb = (TextView) findViewById(R.id.stairclimbCount);
        final TextView cal = (TextView) findViewById(R.id.textCalories);
        Button convert = (Button) findViewById(R.id.buttonConvert);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double weight = Integer.valueOf(editWeight.getText().toString());
                double height = Integer.valueOf(editHeight.getText().toString()) * 2.54;
                int age = Integer.valueOf(editAge.getText().toString());
                String selected = type.getSelectedItem().toString();
                double num = Double.valueOf(number.getText().toString());
                if (unit.isChecked()){
                    weight = weight * 2.2;
                }
                double BMR = 0;
                if (gender.isChecked()){
                    BMR = (13.75 * weight) + (5.003*height) - (6.755 * age) + 66;
                }
                else{
                    BMR = (9.563 * weight) + (1.850 * height) - (4.676 * age) + 655.1;
                }
                double MET = 0;
                double T = 0;
                int calburned = 0;
                switch(selected){
                    case "Calories Burned":
                        calburned = (int) num;
                        cal.setText(String.valueOf(calburned) + " Calories Burned");
                        break;
                    case "Pushups (reps)":
                        MET = 3.8;
                        num = (num/60) * .05;
                        break;
                    case "Situps (reps)":
                        MET = 3.8;
                        num = (num/60) * .082;
                        break;
                    case "Squats (reps)":
                        MET = 5.0;
                        num = (num/60) * .082;
                        break;
                    case "Leg-lift (min)":
                        MET = 3.5;
                        num = num/60;
                        break;
                    case "Plank (min)":
                        MET = 3.8;
                        num = num/60;
                        break;
                    case "Jumping Jacks (min)":
                        MET = 8.0;
                        num = num/60;
                        break;
                    case "Pullup (reps)":
                        MET = 8.0;
                        num = (num/60) * .16662;
                        break;
                    case "Cycling (min)":
                        MET = 6.0;
                        num = num/60;
                        break;
                    case "Walking (min)":
                        MET = 3.8;
                        num = num/60;
                        break;
                    case "Jogging (min)":
                        MET = 8.0;
                        num = num/60;
                        break;
                    case "Swimming (min)":
                        MET = 8.0;
                        num = num/60;
                        break;
                    case "Stair Climbing (min)":
                        MET = 9.0;
                        num = num/60;
                        break;
                }

                if (MET != 0.0){
                    calburned = (int) ((BMR/24)*MET*num);
                    cal.setText(String.valueOf(calburned) + " Calories Burned");
                }

                double individNum = (calburned/((BMR/24) * 3.8));
                pushups.setText(String.valueOf((int) (((calburned/ ((BMR/24) * 3.8))/.05)*60)));
                situps.setText(String.valueOf((int) (((calburned/ ((BMR/24) * 3.8))/.082)*60)));
                squats.setText(String.valueOf((int) (((calburned/ ((BMR/24) * 5.0))/.082)*60)));
                leglift.setText(String.valueOf((int) (((calburned / ((BMR/24) * 3.5)) * 60))));
                plank.setText(String.valueOf((int) (((calburned / ((BMR / 24) * 3.8)) * 60))));
                jjacks.setText(String.valueOf((int) (((calburned / ((BMR / 24) * 8.0)) * 60))));
                pullup.setText(String.valueOf((int) (((calburned/ ((BMR/24) * 8.0))/.16662)*60)));
                cycle.setText(String.valueOf((int) (((calburned / ((BMR / 24) * 6.0)) * 60))));
                walk.setText(String.valueOf((int) (((calburned / ((BMR / 24) * 3.8)) * 60))));
                jog.setText(String.valueOf((int) (((calburned / ((BMR / 24) * 8.0)) * 60))));
                swim.setText(String.valueOf((int) (((calburned / ((BMR / 24) * 8.0)) * 60))));
                sclimb.setText(String.valueOf((int) (((calburned / ((BMR / 24) * 8.0)) * 60))));

            }
        });


    }
}
