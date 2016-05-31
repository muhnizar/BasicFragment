package com.example.moohn.basicfragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.moohn.basicfragment.apis.Shakespeare;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {


    public static DetailFragment newInstance(int index) {

        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putInt("index",index);
        fragment.setArguments(args);
        return fragment;
    }

    public int getShownIndex(){
        return getArguments().getInt("index",0);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ScrollView scrollView = new ScrollView(getActivity());
        TextView textView = new TextView(getActivity());
        /*int padding = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 4, getActivity()
                        .getResources().getDisplayMetrics());
        textView.setPadding(padding, padding, padding, padding);
        */
        textView.setText(Shakespeare.DIALOGUE[getShownIndex()]);
        scrollView.addView(textView);
        return scrollView;
    }
}
