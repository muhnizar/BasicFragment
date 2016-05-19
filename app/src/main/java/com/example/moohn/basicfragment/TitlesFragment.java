package com.example.moohn.basicfragment;


import android.app.ListFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.ArrayAdapter;

import com.example.moohn.basicfragment.apis.Shakespeare;

/**
 * A simple {@link Fragment} subclass.
 */
public class TitlesFragment extends ListFragment {
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_activated_1, Shakespeare.TITLES));
    }
}
