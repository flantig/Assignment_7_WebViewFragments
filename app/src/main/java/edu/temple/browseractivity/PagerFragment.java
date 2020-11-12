package edu.temple.browseractivity;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PagerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PagerFragment extends Fragment {
    ViewPager viewPager;
    ArrayList<PageViewerFragment> pageview;

    public PagerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pager, container, false);
        viewPager = view.findViewById(R.id.pager);
        pageview = new ArrayList<>();

        viewPager.setAdapter(new FragmentStatePagerAdapter(getChildFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return pageview.get(position);
            }

            @Override
            public int getCount() {
                return pageview.size();
            }
        });

        return view;
    }
}
