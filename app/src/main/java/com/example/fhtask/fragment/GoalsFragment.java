package com.example.fhtask.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.fhtask.R;

public class GoalsFragment extends Fragment implements View.OnClickListener {

    TextView tv_info,tv_better,tv_risk,tv_family;
    ViewPager viewPager;
    ImageButton img_left,img_right;
    int position;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_goals, container, false);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        tv_better = (TextView) getActivity().findViewById(R.id.tv_better);
        tv_info = (TextView) getActivity().findViewById(R.id.tv_info);
        tv_risk = (TextView) getActivity().findViewById(R.id.tv_risk);
        tv_family = (TextView) getActivity().findViewById(R.id.tv_family);

        img_left = (ImageButton) getActivity().findViewById(R.id.btn_left);
        img_right = (ImageButton) getActivity().findViewById(R.id.btn_right);
        viewPager = (ViewPager) getActivity().findViewById(R.id.vp);

        tv_info.setOnClickListener(this);
        tv_better.setOnClickListener(this);
        tv_risk.setOnClickListener(this);
        tv_family.setOnClickListener(this);

        setViewPager();

         position = viewPager.getCurrentItem();
//        Toast.makeText(getContext(),position,Toast.LENGTH_LONG).show();

        FragmentManager fragmentManager= getActivity().getSupportFragmentManager();
        viewPager.setAdapter(new MyAdapter(fragmentManager));

        tv_info.setBackgroundResource(R.drawable.button_shape_orange);


        img_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Increase Counter to move to next Image
                if (position == 0) {
                    viewPager.setCurrentItem(0);
                } else {
                    position--;
                    viewPager.setCurrentItem(position);
                }
            }
        });

        img_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position == 3) {
                    viewPager.setCurrentItem(3);
                } else {
                    position++;
                    viewPager.setCurrentItem(position);
                }
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_info:
                tv_info.setBackgroundResource(R.drawable.button_shape_orange);
                tv_better.setBackgroundResource(R.drawable.button_shape_pink);
                tv_risk.setBackgroundResource(R.drawable.button_shape_pink);
                tv_family.setBackgroundResource(R.drawable.button_shape_pink);
                viewPager.setCurrentItem(0);
                break;
            case R.id.tv_better:
                tv_info.setBackgroundResource(R.drawable.button_shape_pink);
                tv_better.setBackgroundResource(R.drawable.button_shape_orange);
                tv_risk.setBackgroundResource(R.drawable.button_shape_pink);
                tv_family.setBackgroundResource(R.drawable.button_shape_pink);
                viewPager.setCurrentItem(1);
                break;
            case R.id.tv_risk:
                tv_info.setBackgroundResource(R.drawable.button_shape_pink);
                tv_better.setBackgroundResource(R.drawable.button_shape_pink);
                tv_risk.setBackgroundResource(R.drawable.button_shape_orange);
                tv_family.setBackgroundResource(R.drawable.button_shape_pink);
                viewPager.setCurrentItem(2);
                break;
            case R.id.tv_family:
                tv_info.setBackgroundResource(R.drawable.button_shape_pink);
                tv_better.setBackgroundResource(R.drawable.button_shape_pink);
                tv_risk.setBackgroundResource(R.drawable.button_shape_pink);
                tv_family.setBackgroundResource(R.drawable.button_shape_orange);
                viewPager.setCurrentItem(3);
                break;
        }

    }

    public static class MyAdapter extends FragmentPagerAdapter {
        private static int NUM_ITEMS = 4;

        public MyAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 1: // Fragment # 0 - This will show FirstFragment different title
                case 2:
                case 3: // Fragment # 1 - This will show SecondFragment
                    return betterFragment.newInstance();
                case 0: // Fragment # 0 - This will show FirstFragment
                default:
                    return  InfoFragment.newInstance();
            }
        }
    }

    public void setViewPager(){
        if(viewPager.getCurrentItem() == 0){
            tv_info.setBackgroundResource(R.drawable.button_shape_orange);
            tv_better.setBackgroundResource(R.drawable.button_shape_pink);
            tv_risk.setBackgroundResource(R.drawable.button_shape_pink);
            tv_family.setBackgroundResource(R.drawable.button_shape_pink);
        }else if (viewPager.getCurrentItem() == 1)
        {
            tv_info.setBackgroundResource(R.drawable.button_shape_pink);
            tv_better.setBackgroundResource(R.drawable.button_shape_orange);
            tv_risk.setBackgroundResource(R.drawable.button_shape_pink);
            tv_family.setBackgroundResource(R.drawable.button_shape_pink);
        }
    }
}