package com.programming.waldorf.quotebreaker;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;
import android.app.Activity;

/**
 * A simple {@link Fragment} subclass.
 */
public class SizingFragment extends Fragment {

    private int[] selectedBtus = {40000,60000,80000,100000,120000};
    private int storyMultiplier = 28;
    private int selectBtuElement = 0;
    private static final String TAG = "Thomas!!! = ";
    private EditText sqfootInput;
    private TextView requiredBtusView;

    SizingSectionListener activityCommander;


    public interface SizingSectionListener{
        public void createSize(int btu);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof SizingSectionListener) {
            activityCommander = (SizingSectionListener) context;
        }
    }

    // constructor
    public SizingFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sizing, container, false);


        // set the check boxes to operate independently, and set the multiplier.
        final CheckBox checkboxOneStory = (CheckBox) view.findViewById(R.id.one_story_check);
        final CheckBox checkboxTwoStory = (CheckBox) view.findViewById(R.id.two_story_check);
        final Button calculateBtn = (Button) view.findViewById(R.id.calculate_square_button);
        sqfootInput = (EditText) view.findViewById(R.id.calculated_square);
        Log.v(TAG," value of edit text sqFootInput " + sqfootInput);
        requiredBtusView = (TextView) view.findViewById(R.id.required_btu_display);
        final Button saveButton = (Button) view.findViewById(R.id.size_next_button);




        // one story check box (default is one story)
        checkboxOneStory.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    checkboxTwoStory.setChecked(false);
                    storyMultiplier = 28;
                    Log.v(TAG, ("set story check to ONE story"));
                }
            }
        });

        // two story check box (default is one story)
        checkboxTwoStory.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                {
                    checkboxOneStory.setChecked(false);
                    storyMultiplier = 35;
                    Log.v(TAG, ("set story check to TWO story"));
                }
            }
        });



        calculateBtn.setOnClickListener(
                new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String stringSqFoot = sqfootInput.getText().toString();
                Log.v(TAG," vlaue if edit text stringSqFoot " + stringSqFoot );
                int squareFeetEntered = Integer.parseInt(stringSqFoot);
                Log.v(TAG," vlaue if edit text squareFeetEntered " + squareFeetEntered );

                int requiredBtus = squareFeetEntered * storyMultiplier;

                requiredBtusView.setText(String.valueOf(requiredBtus));
                Log.v(TAG, "Calculate Button Was Pushed ");
            }
        });

        final TextView selectedBtuView = (TextView) view.findViewById(R.id.selected_btu_display);

        final Button addBtn = (Button) view.findViewById(R.id.bump_up_button);
        final Button subtractBtn = (Button) view.findViewById(R.id.bump_down_button);

        // + button to page through the BTU list
        addBtn.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "The + button was pushed");
                selectBtuElement--;
                if(selectBtuElement < 0) {
                    selectBtuElement++;
                    Log.v(TAG, "selectedBtuElement =" + selectBtuElement);
                }
                selectedBtuView.setText(String.valueOf(selectedBtus[selectBtuElement]));
            }
        });

        // - button to page through the BTU list
        subtractBtn.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "The - button was pushed");
                selectBtuElement++;
                if(selectBtuElement > 4) {
                    selectBtuElement--;
                    Log.v(TAG, "selectedBtuElement =" + selectBtuElement);
                }
                selectedBtuView.setText(String.valueOf(selectedBtus[selectBtuElement]));
            }
        });

        saveButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.v(TAG,"The Save Button was clicked inside Sizing Fragment");
                        buttonClicked(view);
                    }
                }
        );

        return view;
    }

    public void buttonClicked (View view) {
        Log.v(TAG,"Started buttonClicked() ");
        activityCommander.createSize(selectBtuElement);
    }


}
