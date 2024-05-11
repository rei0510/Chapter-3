package com.example.chapter3.homework;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.List;

public class PlaceholderFragment extends Fragment {

    private ListView listView;

    private LottieAnimationView lottieAnimationView;

    private AnimatorSet animatorSet;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        View view = inflater.inflate(R.layout.fragment_placeholder, container,
                false);
        lottieAnimationView = view.findViewById(R.id.animation_view);
        listView = view.findViewById(R.id.list_view);

        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                List list = new ArrayList();
                list.add("好友1");
                list.add("好友2");
                list.add("好友3");
                list.add("好友4");
                list.add("好友5");
                ArrayAdapter adapter = new ArrayAdapter(listView.getContext(),android.R.layout.simple_list_item_1,list);
                listView.setAdapter(adapter);
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(lottieAnimationView,"alpha",1,0);
                animator1.setDuration(2000);
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(listView,"alpha",0,1);
                animator2.setDuration(2000);

                animatorSet = new AnimatorSet();
                animatorSet.playTogether(animator1);
                animatorSet.playTogether(animator2);
                animatorSet.start();

            }
        }, 5000);
    }
}
