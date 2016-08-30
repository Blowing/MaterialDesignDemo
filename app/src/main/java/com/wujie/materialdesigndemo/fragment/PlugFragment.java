package com.wujie.materialdesigndemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.wujie.materialdesigndemo.R;

/**
 * Created by wujie on 2016/8/30.
 */
public class PlugFragment extends Fragment{


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plug, container, false);
        view.findViewById(R.id.float_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Snackbar snacker = Snackbar.make(view, "你来点我呀",Snackbar.LENGTH_LONG);
                View snackbarView = snacker.getView();
                ViewGroup.LayoutParams vl = snackbarView.getLayoutParams();
                CoordinatorLayout.LayoutParams cl = new CoordinatorLayout.LayoutParams(vl.width, vl.height);
                cl.gravity = Gravity.CENTER_VERTICAL;
                snackbarView.setLayoutParams(cl);
                ImageView imageView = new ImageView(getActivity().getApplicationContext());
                imageView.setImageResource(R.mipmap.ic_launcher);


                Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbarView;
                Snackbar.SnackbarLayout.LayoutParams l1 = new Snackbar.SnackbarLayout.LayoutParams(vl.WRAP_CONTENT, vl.WRAP_CONTENT);
                l1.gravity = Gravity.CENTER_VERTICAL;
                imageView.setLayoutParams(l1);

                snackbarLayout.addView(imageView, 0);
                snacker.show();

                snacker.setAction("打我呀", new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        snacker.dismiss();
                    }
                });
            }
        });
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
