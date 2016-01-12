package com.oa.rssreader;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements MyListFragment.OnItemSelectedListener{

    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showFragments();
        //checkFragments();
    }

    private void showFragments(){
        // get fragment manager
        fm = getSupportFragmentManager();

        // add
        FragmentTransaction ft1 = fm.beginTransaction();
        ft1.add(R.id.listcontainer,new MyListFragment());
        ft1.addToBackStack(null);
        ft1.commit();

        FragmentTransaction ft2 = fm.beginTransaction();
        ft2.add(R.id.detailscontainer, new DetailFragment());
        ft2.addToBackStack(null);
        ft2.commit();

        // replace
//        FragmentTransaction ft = fm.beginTransaction();
//        ft.replace(R.id.your_placehodler, new YourFragment());
//        ft.commit();

        // remove
//        Fragment fragment = fm.findFragmentById(R.id.your_placehodler);
//        FragmentTransaction ft = fm.beginTransaction();
//        ft.remove(fragment);
//        ft.commit();
    }
    private void checkFragments(){
        DetailFragment fragment1 = (DetailFragment) fm.
                findFragmentById(R.id.detailscontainer);
        if (fragment1==null || ! fragment1.isInLayout()) {
            // start new Activity
            System.out.println("fragment1 not show");
        }else {
            //fragment.update(...);
            System.out.println("fragment1 show");
        }

        MyListFragment fragment2 = (MyListFragment) fm.
                findFragmentById(R.id.listcontainer);
        if (fragment2==null || ! fragment2.isInLayout()) {
            // start new Activity
            System.out.println("fragment2 not show");
        }else {
            //fragment.update(...);
            System.out.println("fragment2 show");
        }
    }

    @Override
    public void onRssItemSelected(String link) {
//        checkFragments();
//        FrameLayout frameLayout1 = (FrameLayout) findViewById(R.id.listcontainer);
//        frameLayout1.setVisibility(View.GONE);
//
        FrameLayout frameLayout2 = (FrameLayout) findViewById(R.id.detailscontainer);
        frameLayout2.setVisibility(View.VISIBLE);

        DetailFragment fragment = (DetailFragment) fm.findFragmentById(R.id.detailscontainer);
        fragment.setText(link);

//        FragmentTransaction ft1 = fm.beginTransaction();
//        MyListFragment listFragment = (MyListFragment) getFragmentManager().findFragmentById(R.id.listcontainer);
//        ft1.remove(listFragment);
//        ft1.addToBackStack("rtyu");
//        ft1.commit();
    }
}
