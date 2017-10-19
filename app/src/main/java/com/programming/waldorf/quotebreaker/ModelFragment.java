package com.programming.waldorf.quotebreaker;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;


public class ModelFragment extends Fragment {

    int brandSelectionElement = 0;
    private double baseEquipmentPrice;
    public String[] payneFurnaceModels = {"N/A", "Single Stage (PG95SAS)", "Two Stage (PG95XAT)"};
    public String[] carrierFurnaceModels = {"Single Stage (59SC5A)","Two Stage (59TN6A)",
            "Variable (59MN7A)"};
    private static final String TAG = "Thomas!!! = ";
    private int selectBtuElement = 0;
    int equipmentOptionSelection = 0;
    ViewPager mViewPager;

    modelSectionListener activityCommander;

    public interface modelSectionListener{
        public void setBrand (int brand);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof modelSectionListener) {
            activityCommander = (modelSectionListener) context;
        }
    }

    // constructor
    public ModelFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_model, container, false);

        setBtuElement();

        // find the Views
        Button carrierBtn = (Button) rootView.findViewById(R.id.carrier_check);
        Button payneBtn = (Button) rootView.findViewById(R.id.payne_check);
        final TextView optionOne = (TextView) rootView.findViewById(R.id.option_one);
        final TextView optionOnePrice = (TextView) rootView.findViewById(R.id.option_one_price);
        final TextView optionTwo = (TextView) rootView.findViewById(R.id.option_two);
        final TextView optionTwoPrice = (TextView) rootView.findViewById(R.id.option_two_price);
        final TextView optionThree = (TextView) rootView.findViewById(R.id.option_three);
        final TextView optionThreePrice = (TextView) rootView.findViewById(R.id.option_three_price);
        Button saveBrandButton = (Button) rootView.findViewById(R.id.brand_save_btn);
        mViewPager = getActivity().findViewById(R.id.container);

        // find the views for the equipment selection check boxes
        final CheckBox optionOneCheck = (CheckBox) rootView.findViewById(R.id.option_one_check);
        final CheckBox optionTwoCheck = (CheckBox) rootView.findViewById(R.id.option_two_check);
        final CheckBox optionThreeCheck = (CheckBox) rootView.findViewById(R.id.option_three_check);




        // option 1 check box for the first row in equipment selection
        optionOneCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    optionTwoCheck.setChecked(false);
                    optionThreeCheck.setChecked(false);
                    equipmentOptionSelection = 1;
                    Log.v(TAG,"Option 1 in equipment selection selected");
                }
            }
        });


        // option 2 check box for the second row in equipment selection
        optionTwoCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionOneCheck.setChecked(false);
                optionThreeCheck.setChecked(false);
                equipmentOptionSelection = 2;
                Log.v(TAG,"Option 2 in equipment selection selected");
            }
        });


        // option 3 check box for the third row in equipment selection
        optionThreeCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                optionOneCheck.setChecked(false);
                optionTwoCheck.setChecked(false);
                equipmentOptionSelection = 3;
                Log.v(TAG,"Option 3 in equipment selection selected");

            }
        });

        // Carrier Brand Selection Button
        carrierBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                brandSelectionElement = 0;
                optionOne.setText(String.valueOf(carrierFurnaceModels[0]));
                optionTwo.setText(String.valueOf(carrierFurnaceModels[1]));
                optionThree.setText(String.valueOf(carrierFurnaceModels[2]));

                // 40,000 BTU option
                if (selectBtuElement == 0) {
                    optionOnePrice.setText(getString(R.string.carrier_single_40_price));
                    optionTwoPrice.setText(getString(R.string.unavailable));
                    optionThreePrice.setText(getString(R.string.unavailable));
                    Log.v(TAG,"Carrier Selected BTU element = 0");
                    // 60,000 BTU option
                }else if(selectBtuElement == 1) {
                    optionOnePrice.setText(getString(R.string.carrier_single_60_price));
                    optionTwoPrice.setText(getString(R.string.carrier_two_60_price));
                    optionThreePrice.setText(getString(R.string.carrier_mod_60_price));
                    Log.v(TAG,"Carrier Selected BTU element = 1");
                    // 80,000 BTU option
                }else if(selectBtuElement == 2) {
                    optionOnePrice.setText(getString(R.string.carrier_single_80_price));
                    optionTwoPrice.setText(getString(R.string.carrier_two_80_price));
                    optionThreePrice.setText(getString(R.string.carrier_mod_80_price));
                    Log.v(TAG,"Carrier Selected BTU element = 2");
                    // 100,000 BTU option
                }else if(selectBtuElement == 3) {
                    optionOnePrice.setText(getString(R.string.carrier_single_100_price));
                    optionTwoPrice.setText(getString(R.string.carrier_two_100_price));
                    optionThreePrice.setText(getString(R.string.carrier_mod_100_price));
                    Log.v(TAG,"Carrier Selected BTU element = 3");
                    // 120,000 BTU option
                }else if(selectBtuElement == 4) {
                    optionOnePrice.setText(getString(R.string.carrier_single_120_price));
                    optionTwoPrice.setText(getString(R.string.carrier_two_120_price));
                    optionThreePrice.setText(getString(R.string.carrier_mod_120_price));
                    Log.v(TAG,"Carrier Selected BTU element = 4");
                }
            }
        });

        // Payne Brand selection Button
        payneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                brandSelectionElement = 1;
                optionOne.setText(String.valueOf(payneFurnaceModels[0]));
                optionTwo.setText(String.valueOf(payneFurnaceModels[1]));
                optionThree.setText(String.valueOf(payneFurnaceModels[2]));

                // 40,000 BTU option
                if (selectBtuElement == 0) {
                    optionOnePrice.setText(getString(R.string.unavailable));
                    optionTwoPrice.setText(getString(R.string.payne_single_40_price));
                    optionThreePrice.setText(getString(R.string.payne_two_40_price));
                    Log.v(TAG,"Payne Selected BTU element = 0");
                    // 60,000 BTU option
                }else if(selectBtuElement == 1) {
                    optionOnePrice.setText(getString(R.string.unavailable));
                    optionTwoPrice.setText(getString(R.string.payne_single_60_price));
                    optionThreePrice.setText(getString(R.string.payne_two_60_price));
                    Log.v(TAG,"Payne Selected BTU element = 1");
                    // 80,000 BTU option
                }else if(selectBtuElement == 2) {
                    optionOnePrice.setText(getString(R.string.unavailable));
                    optionTwoPrice.setText(getString(R.string.payne_single_80_price));
                    optionThreePrice.setText(getString(R.string.payne_two_80_price));
                    Log.v(TAG,"Payne Selected BTU element = 2");
                    // 100,000 BTU option
                }else if(selectBtuElement == 3) {
                    optionOnePrice.setText(getString(R.string.unavailable));
                    optionTwoPrice.setText(getString(R.string.payne_single_100_price));
                    optionThreePrice.setText(getString(R.string.payne_two_100_price));
                    Log.v(TAG,"Payne Selected BTU element = 3");
                    // 120,000 BTU option
                }else if(selectBtuElement == 4) {
                    optionOnePrice.setText(getString(R.string.unavailable));
                    optionTwoPrice.setText(getString(R.string.payne_single_120_price));
                    optionThreePrice.setText(getString(R.string.payne_two_120_price));
                    Log.v(TAG,"Payne Selected BTU element = 4");
                }
            }
        });

        saveBrandButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClicked(view);
            }
        });

        return rootView;
    }

    public void setBtuElement() {
        Log.v(TAG,"setBtuElement inside ModelFragment started");
        selectBtuElement = ((MainActivity)getActivity()).getBtuSelected();
    }

    public void buttonClicked (View view) {
        Log.v(TAG,"Started buttonClicked() ");
        activityCommander.setBrand(brandSelectionElement);
        Log.v(TAG,"save button in ModelFragment sent " + brandSelectionElement);
        mViewPager.setCurrentItem(2);
    }

}
