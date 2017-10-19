package com.programming.waldorf.quotebreaker;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class TotalsFragment extends Fragment {

    ViewPager mViewPager;
    private static final String TAG = "Thomas!!! = ";
    private double baseEquipmentPrice = 0.0;
    private double totalPrice = 0.0;
    private double baseAddOnPrice = 0.0;
    private int selectBtuElement = 0;
    private int brandSelectionElement = 0;
    private int equipmentOptionSelection = 0;

    // constructor
    public TotalsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_totals, container, false);

        mViewPager = getActivity().findViewById(R.id.container);
        final TextView grandTotalView = (TextView) rootview.findViewById(R.id.total_quote_price_display);

        Button grandTotalBtn = (Button) rootview.findViewById(R.id.grand_total_button);
        grandTotalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "Grand total button was pushed");
                baseEquipmentPrice = 0.0;
                totalPrice = 0.0;
                baseEquipmentPrice = basePriceFinder(
                        selectBtuElement, brandSelectionElement, equipmentOptionSelection);
                totalPrice = baseEquipmentPrice + baseAddOnPrice;
                Log.v(TAG, " total price = " + totalPrice + " and base price = "
                        + baseEquipmentPrice);
                grandTotalView.setText(String.format("$%.2f", totalPrice));
            }
        });

        Button resetAllButton = (Button) rootview.findViewById(R.id.reset_total_button);
        resetAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //TODO set this list up in Activity to clear all fields
            /*  Log.v(TAG, "Reset button was pushed");
                optionOneCheck.setChecked(false);
                optionTwoCheck.setChecked(false);
                optionThreeCheck.setChecked(false);
                condPumpAdd.setChecked(false);
                progTstatAdd.setChecked(false);
                twoStageProgTstatAdd.setChecked(false);
                infinityWifiAdd.setChecked(false);
                lowboyBootAdd.setChecked(false);
                crawlAtticAdd.setChecked(false);
                afterHoursAdd.setChecked(false);
                onePermitAdd.setChecked(false);
                twoPermitAdd.setChecked(false);
                lpConversionAdd.setChecked(false);
                horizonalAdd.setChecked(false);
                tenYearWarAdd.setChecked(false);
            */
                baseEquipmentPrice = 0.0;
                brandSelectionElement = 0;
                equipmentOptionSelection = 0;
                baseAddOnPrice = 0.0;
                totalPrice = 0.0;
                grandTotalView.setText(String.format("$%.2f", totalPrice));
                Log.v(TAG, "baseEquipmentPrice = " + baseEquipmentPrice +
                        "selectedBtuElement = " + selectBtuElement +
                        "brandSelectionElement = " + brandSelectionElement +
                        "equipmentOptionSelection = " + equipmentOptionSelection +
                        "total Price = " + totalPrice);
            }
        });

        return rootview;
    }


    private double basePriceFinder(int btus, int brand, int stages) {
        Log.v(TAG, "basePriceFinder btus= " + btus + " brand = " + brand + " stages " + stages);
        double equipmentPrice = 0;
        if (btus == 0 & brand == 0 & stages == 1) {
            // 40,000 BTU Single Stage Carrier Furnace #1
            equipmentPrice = 2997.00;
        } else if (btus == 0 & brand == 0 & stages == 2) {
            // 40,000 BTU Two Stage Carrier Furnace (currently unavailable)
            equipmentPrice = 0.0;
        } else if (btus == 0 & brand == 0 & stages == 3) {
            // 40,000 BTU Modulating Carrier Furnace (currently unavailable)
            equipmentPrice = 0.0;
        } else if (btus == 1 & brand == 0 & stages == 1) {
            // 60,000 BTU Single Stage Carrier Furnace #2
            equipmentPrice = 3039.00;
        } else if (btus == 1 & brand == 0 & stages == 2) {
            // 60,000 BTU Two Stage Carrier Furnace #3
            equipmentPrice = 4058.00;
        } else if (btus == 1 & brand == 0 & stages == 3) {
            // 60,000 BTU Modulating Carrier Furnace #4
            equipmentPrice = 4504.00;
        } else if (btus == 2 & brand == 0 & stages == 1) {
            // 80,000 BTU Single Stage Carrier Furnace #5
            equipmentPrice = 3118.00;
        } else if (btus == 2 & brand == 0 & stages == 2) {
            // 80,000 BTU Two Stage Carrier Furnace #6
            equipmentPrice = 4299.00;
        } else if (btus == 2 & brand == 0 & stages == 3) {
            // 80,000 BTU Modulation Carrier Furnace #7
            equipmentPrice = 4719.00;
        } else if (btus == 3 & brand == 0 & stages == 1) {
            // 100,000 BTU Single Stage Carrier Furnace #8
            equipmentPrice = 3171.00;
        } else if (btus == 3 & brand == 0 & stages == 2) {
            // 100,000 BTU Two Stage Carrier Furnace #9
            equipmentPrice = 4504.00;
        } else if (btus == 3 & brand == 0 & stages == 3) {
            // 100,000 BTU Modulating Carrier Furnace #10
            equipmentPrice = 4982.00;
        } else if (btus == 4 & brand == 0 & stages == 1) {
            // 120,000 BTU Single Stage Carrier Furnace #11
            equipmentPrice = 3223.00;
        } else if (btus == 4 & brand == 0 & stages == 2) {
            // 120,000 BTU Two Stage Carrier Furnace #12
            equipmentPrice = 4667.00;
        } else if (btus == 4 & brand == 0 & stages == 3) {
            // 120,000 BTU Modulating Carrier Furnace #13
            equipmentPrice = 5139.75;
        } else if (btus == 0 & brand == 1 & stages == 1) {
            // 45,000 BTU Single Stage Payne 80%AFUE Furnace
            equipmentPrice = 0.0;
        } else if (btus == 0 & brand == 1 & stages == 2) {
            // 40,000 BTU Single Stage Payne Furnace #14
            equipmentPrice = 2457.00;
        } else if (btus == 0 & brand == 1 & stages == 3) {
            // 40,000 BTU Two Stage Payne Furnace @15
            equipmentPrice = 2698.00;
        } else if (btus == 1 & brand == 1 & stages == 1) {
            // unknown BTU 80% Payne Furnace
            equipmentPrice = 0.0;
        } else if (btus == 1 & brand == 1 & stages == 2) {
            // 60,000 BTU Single Stage Payne Furnace #16
            equipmentPrice = 2420.00;
        } else if (btus == 1 & brand == 1 & stages == 3) {
            // 60,000 BTU Two Stage Payne Furnace #17
            equipmentPrice = 2829.00;
        } else if (btus == 2 & brand == 1 & stages == 1) {
            // unknown BTU Payne 80% Furnace
            equipmentPrice = 0.0;
        } else if (btus == 2 & brand == 1 & stages == 2) {
            // 80,000 BTU Single Stage Payne Furnace #18
            equipmentPrice = 2465.00;
        } else if (btus == 2 & brand == 1 & stages == 3) {
            // 80,000 BTU Two Stage Payne Furnace #19
            equipmentPrice = 2961.00;
        } else if (btus == 3 & brand == 1 & stages == 1) {
            // unknown BTU Payne 80% Furnace
            equipmentPrice = 0.0;
        } else if (btus == 3 & brand == 1 & stages == 2) {
            // 100,000 BTU Single Stage Payne Furnace #20
            equipmentPrice = 2520.00;
        } else if (btus == 3 & brand == 1 & stages == 3) {
            // 100,000 BTU Two Stage Payne Furnace #21
            equipmentPrice = 3066.00;
        } else if (btus == 4 & brand == 1 & stages == 1) {
            // Unknown BTU Payne 80% Furnace
            equipmentPrice = 0.0;
        } else if (btus == 4 & brand == 1 & stages == 2) {
            // 120,000 BTU Single Stage Payne Furnace #22
            equipmentPrice = 2620.00;
        } else if (btus == 4 & brand == 1 & stages == 3) {
            // 120,000 BTU Two Stage Payne Furnace #23
            equipmentPrice = 3223.00;
        }

        Log.v(TAG, "basePriceFinder equipmentPrice = " + equipmentPrice);
        return equipmentPrice;
    }
        //TODO finish the totalsFragment button click
    /*
    public void buttonClicked (View view) {
        Log.v(TAG,"Started buttonClicked() ");
        activityCommander.setBrand(brandSelectionElement);
        Log.v(TAG,"save button in ModelFragment sent " + brandSelectionElement);
        mViewPager.setCurrentItem(0);
    }
    */

}




