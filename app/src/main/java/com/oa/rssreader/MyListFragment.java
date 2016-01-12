package com.oa.rssreader;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MyListFragment extends Fragment {
    public interface OnItemSelectedListener {
        public void onRssItemSelected(String link);
    }
    private OnItemSelectedListener listener;


    @Override
    public void onAttach(Context context) {
        System.out.println("onAttach() "+context);
        super.onAttach(context);
        if (context instanceof OnItemSelectedListener) {
            listener = (OnItemSelectedListener) context;
            System.out.println("listener= "+listener);
        } else {
            throw new ClassCastException(context.toString()
                    + " must implemenet MyListFragment.OnItemSelectedListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_list,
                container, false);
        Button button = (Button) view.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDetail("fake");
            }
        });
        return view;
    }



    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    // may also be triggered from the Activity
    public void updateDetail(String uri) {
        // create a string just for testing
        String newTime = String.valueOf(System.currentTimeMillis());

        // inform the Activity about the change based
        // interface defintion
        listener.onRssItemSelected(newTime);
    }
}
