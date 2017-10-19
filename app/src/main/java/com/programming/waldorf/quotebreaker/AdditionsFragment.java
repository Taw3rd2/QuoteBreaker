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


public class AdditionsFragment extends Fragment {

    ViewPager mViewPager;
    additionsTotalsListener activityCommander;
    private static final String TAG = "Thomas!!! = ";
    private double baseAddOnPrice = 0.0;
    private double totalAddonPrice = 0.0;

    public interface additionsTotalsListener {
        public void setAdditionsTotals (double addTotals);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof additionsTotalsListener) {
            activityCommander = (additionsTotalsListener) context;
        }
    }

    //constructor
    public AdditionsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_additions, container, false);

        mViewPager = getActivity().findViewById(R.id.container);
        Button add_save_btn = (Button) rootview.findViewById(R.id.additions_save_btn);

        // condensate pump add on check box
        final CheckBox condPumpAdd = (CheckBox) rootview.findViewById(R.id.cond_pump_addon_check);
        condPumpAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (condPumpAdd.isChecked()) {
                    baseAddOnPrice += 210.00;
                    Log.v(TAG, "condensate pump is checked");
                }else{
                    condPumpAdd.setChecked(false);
                    baseAddOnPrice -= 210.00;
                    Log.v(TAG, "condensate pump is unchecked");
                }
            }
        });

        // programmable thermostat add on check box
        final CheckBox progTstatAdd = (CheckBox) rootview.findViewById(R.id.programmable_tstat_addon_check);
        progTstatAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (progTstatAdd.isChecked()) {
                    baseAddOnPrice += 126.00;
                    Log.v(TAG, "prog tstat is checked");
                }else{
                    progTstatAdd.setChecked(false);
                    baseAddOnPrice -= 126.00;
                    Log.v(TAG, "prog tstat id unchecked");
                }
            }
        });

        // two stage programmable thermostat add on check box
        final CheckBox twoStageProgTstatAdd = (CheckBox) rootview.findViewById(R.id.two_stage_stat_check);
        twoStageProgTstatAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (twoStageProgTstatAdd.isChecked()) {
                    baseAddOnPrice += 210.00;
                    Log.v (TAG, "two stage prog tstat is checked");
                }else{
                    twoStageProgTstatAdd.setChecked(false);
                    baseAddOnPrice -= 210.00;
                    Log.v (TAG, "two stage prog tstat is unchecked");
                }
            }
        });

        // WiFi for Infinity touch controls add on check box
        final CheckBox infinityWifiAdd = (CheckBox) rootview.findViewById(R.id.infinity_wifi_check);
        infinityWifiAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (infinityWifiAdd.isChecked()) {
                    baseAddOnPrice += 750.00;
                    Log.v (TAG, "infinity wifi is checked ");
                }else{
                    infinityWifiAdd.setChecked(false);
                    baseAddOnPrice -= 750.00;
                    Log.v (TAG, "infinity wifi is checked ");
                }
            }
        });

        // Return air boot for low-boy furnaces add on check box
        final CheckBox lowboyBootAdd = (CheckBox) rootview.findViewById(R.id.lowboy_boot_addon_check);
        lowboyBootAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lowboyBootAdd.isChecked()) {
                    baseAddOnPrice += 131.00;
                    Log.v(TAG, "lowboy boot is checked");
                }else{
                    lowboyBootAdd.setChecked(false);
                    baseAddOnPrice -= 131.00;
                    Log.v(TAG, "lowboy boot is unchecked");
                }
            }
        });

        // Crawlspace or Attic work add on check box
        final CheckBox crawlAtticAdd = (CheckBox) rootview.findViewById(R.id.crawl_attic_check);
        crawlAtticAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lowboyBootAdd.isChecked()) {
                    baseAddOnPrice += 210.00;
                    Log.v (TAG, "crawl/attic is checked");
                }else{
                    lowboyBootAdd.setChecked(false);
                    baseAddOnPrice -= 210.00;
                    Log.v (TAG, "crawl/attic is unchecked");
                }
            }
        });

        // After hours labor add on check box
        final CheckBox afterHoursAdd = (CheckBox) rootview.findViewById(R.id.after_hours_check);
        afterHoursAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (afterHoursAdd.isChecked()) {
                    baseAddOnPrice += 210.00;
                    Log.v(TAG,"afterhours is checked");
                }else{
                    afterHoursAdd.setChecked(false);
                    baseAddOnPrice -= 210.00;
                    Log.v(TAG,"afterhours is unchecked");
                }
            }
        });

        // One piece of equipment permit cost add on check box
        final CheckBox onePermitAdd = (CheckBox) rootview.findViewById(R.id.one_piece_permit_check);
        onePermitAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onePermitAdd.isChecked()) {
                    baseAddOnPrice += 160.00;
                    Log.v(TAG, "onePermit is checked");
                }else{
                    onePermitAdd.setChecked(false);
                    baseAddOnPrice -= 160.00;
                    Log.v(TAG, "onePermit is unchecked");
                }
            }
        });

        // Two pieces of equipment permit cost add on check box
        final CheckBox twoPermitAdd = (CheckBox) rootview.findViewById(R.id.two_piece_permit_check);
        twoPermitAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (twoPermitAdd.isChecked()) {
                    baseAddOnPrice += 210.00;
                    Log.v(TAG, "twoPermit is checked");
                }else{
                    twoPermitAdd.setChecked(false);
                    baseAddOnPrice -= 210.00;
                    Log.v(TAG, "twoPermit is unchecked");
                }
            }
        });

        // Natural to Propane gas conversion kit add on check box
        final CheckBox lpConversionAdd = (CheckBox) rootview.findViewById(R.id.conversion_kit_check);
        lpConversionAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lpConversionAdd.isChecked()) {
                    baseAddOnPrice += 184.00;
                    Log.v(TAG,"LP kit is checked");
                }else{
                    lpConversionAdd.setChecked(false);
                    baseAddOnPrice -= 184.00;
                    Log.v(TAG,"LP kit is unchecked");
                }
            }
        });

        // Horizontal Installation add on check box
        final CheckBox horizonalAdd = (CheckBox) rootview.findViewById(R.id.horizonal_install_check);
        horizonalAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (horizonalAdd.isChecked()) {
                    baseAddOnPrice += 150.00;
                    Log.v(TAG, "horizonal is checked ");
                }else{
                    horizonalAdd.setChecked(false);
                    baseAddOnPrice -= 150.00;
                    Log.v(TAG, "horizonal is unchecked ");
                }
            }
        });

        // Ten Year Labor warranty add on check box
        final CheckBox tenYearWarAdd = (CheckBox) rootview.findViewById(R.id.ten_year_labor_check);
        tenYearWarAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tenYearWarAdd.isChecked()) {
                    baseAddOnPrice += 475.00;
                    Log.v(TAG, "ten year warranty add on is checked");
                }else{
                    tenYearWarAdd.setChecked(false);
                    baseAddOnPrice -= 475.00;
                    Log.v(TAG, "ten year warranty add on is unchecked");
                }
            }
        });

        add_save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClicked(view);
            }
        });

        return rootview;
    }

    public void buttonClicked (View view) {
        Log.v(TAG,"Save buttonClicked() ");
        activityCommander.setAdditionsTotals(totalAddonPrice);
        Log.v(TAG,"save button in AddidtionsFragment sent " + totalAddonPrice);
        mViewPager.setCurrentItem(3);
    }

}
