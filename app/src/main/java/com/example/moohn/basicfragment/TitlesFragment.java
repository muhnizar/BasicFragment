package com.example.moohn.basicfragment;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.moohn.basicfragment.apis.Shakespeare;

/**
 * A simple {@link Fragment} subclass.
 */
public class TitlesFragment extends ListFragment {

    boolean mDualPane = false;
    private int mCurCheckPosition = 0;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // populate the list
        setListAdapter(new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_activated_1, Shakespeare.TITLES));

        // check to see if we have a frame in which to embed the details
        View detailsFrame = getActivity().findViewById(R.id.details);
        mDualPane = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

        Toast.makeText(getActivity(),"mDualPane " +mDualPane,Toast.LENGTH_SHORT).show();

        // Restore the last state for checked position
        if (savedInstanceState != null){
            mCurCheckPosition = savedInstanceState.getInt("curChoice", 0);
        }

        if (mDualPane){
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            showDetails(mCurCheckPosition);
        }else{
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            getListView().setItemChecked(mCurCheckPosition,true);
        }
    }

    // helper function
    void showDetails(int index){
        mCurCheckPosition = index;
        if (mDualPane){
            getListView().setItemChecked(index,true);
            DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.details);

            if (detailFragment ==  null || detailFragment.getShownIndex() != index){
                DetailFragment.newInstance(index);
                Toast.makeText(getActivity(), "show details fragment create and replace fragment ", Toast.LENGTH_SHORT);

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.details,detailFragment);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }
        }else{
            Intent intent = new Intent();
            intent.setClass(getActivity(),DetailFragment.class);
            intent.putExtra("index", index);
            startActivity(intent);
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("curChoice",mCurCheckPosition);
    }




}
