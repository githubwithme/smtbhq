//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations 3.2.
//


package com.bhq.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bhq.R.id;
import com.bhq.R.layout;

import org.androidannotations.api.builder.ActivityIntentBuilder;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;

@SuppressLint({
    "NewApi"
})
public final class Offline_ShowCJXX_
    extends Offline_ShowCJXX
    implements HasViews, OnViewChangedListener
{

    private final OnViewChangedNotifier onViewChangedNotifier_ = new OnViewChangedNotifier();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        OnViewChangedNotifier previousNotifier = OnViewChangedNotifier.replaceNotifier(onViewChangedNotifier_);
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
        OnViewChangedNotifier.replaceNotifier(previousNotifier);
        setContentView(layout.showcjxx);
    }

    private void init_(Bundle savedInstanceState) {
        OnViewChangedNotifier.registerOnViewChangedListener(this);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    @Override
    public void setContentView(View view, LayoutParams params) {
        super.setContentView(view, params);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    public static Offline_ShowCJXX_.IntentBuilder_ intent(Context context) {
        return new Offline_ShowCJXX_.IntentBuilder_(context);
    }

    public static Offline_ShowCJXX_.IntentBuilder_ intent(android.app.Fragment fragment) {
        return new Offline_ShowCJXX_.IntentBuilder_(fragment);
    }

    public static Offline_ShowCJXX_.IntentBuilder_ intent(android.support.v4.app.Fragment supportFragment) {
        return new Offline_ShowCJXX_.IntentBuilder_(supportFragment);
    }

    @Override
    public void onViewChanged(HasViews hasViews) {
        tv_tz = ((TextView) hasViews.findViewById(id.tv_tz));
        tv_ldm = ((TextView) hasViews.findViewById(id.tv_ldm));
        tv_xx = ((TextView) hasViews.findViewById(id.tv_xx));
        tv_gang = ((TextView) hasViews.findViewById(id.tv_gang));
        tv_spyj = ((TextView) hasViews.findViewById(id.tv_spyj));
        tv_delete = ((TextView) hasViews.findViewById(id.tv_delete));
        img_tip = ((ImageView) hasViews.findViewById(id.img_tip));
        tv_ke = ((TextView) hasViews.findViewById(id.tv_ke));
        tv_cjsj = ((TextView) hasViews.findViewById(id.tv_cjsj));
        tv_type = ((TextView) hasViews.findViewById(id.tv_type));
        tv_ywm = ((TextView) hasViews.findViewById(id.tv_ywm));
        imgbtn_back = ((ImageButton) hasViews.findViewById(id.imgbtn_back));
        tv_edit = ((TextView) hasViews.findViewById(id.tv_edit));
        tv_bhjb = ((TextView) hasViews.findViewById(id.tv_bhjb));
        tv_mu = ((TextView) hasViews.findViewById(id.tv_mu));
        tv_sfxwz = ((TextView) hasViews.findViewById(id.tv_sfxwz));
        img_container = ((FrameLayout) hasViews.findViewById(id.img_container));
        tv_szhj = ((TextView) hasViews.findViewById(id.tv_szhj));
        tv_bz = ((TextView) hasViews.findViewById(id.tv_bz));
        tv_sprxm = ((TextView) hasViews.findViewById(id.tv_sprxm));
        tv_spsj = ((TextView) hasViews.findViewById(id.tv_spsj));
        tv_title = ((TextView) hasViews.findViewById(id.tv_title));
        tv_bwd = ((TextView) hasViews.findViewById(id.tv_bwd));
        tv_bwys = ((TextView) hasViews.findViewById(id.tv_bwys));
        if (tv_edit!= null) {
            tv_edit.setOnClickListener(new OnClickListener() {


                @Override
                public void onClick(View view) {
                    Offline_ShowCJXX_.this.tv_edit();
                }

            }
            );
        }
        if (tv_delete!= null) {
            tv_delete.setOnClickListener(new OnClickListener() {


                @Override
                public void onClick(View view) {
                    Offline_ShowCJXX_.this.tv_delete();
                }

            }
            );
        }
        if (imgbtn_back!= null) {
            imgbtn_back.setOnClickListener(new OnClickListener() {


                @Override
                public void onClick(View view) {
                    Offline_ShowCJXX_.this.imgbtn_back();
                }

            }
            );
        }
        afterOncreate();
    }

    public static class IntentBuilder_
        extends ActivityIntentBuilder<Offline_ShowCJXX_.IntentBuilder_>
    {

        private android.app.Fragment fragment_;
        private android.support.v4.app.Fragment fragmentSupport_;

        public IntentBuilder_(Context context) {
            super(context, Offline_ShowCJXX_.class);
        }

        public IntentBuilder_(android.app.Fragment fragment) {
            super(fragment.getActivity(), Offline_ShowCJXX_.class);
            fragment_ = fragment;
        }

        public IntentBuilder_(android.support.v4.app.Fragment fragment) {
            super(fragment.getActivity(), Offline_ShowCJXX_.class);
            fragmentSupport_ = fragment;
        }

        @Override
        public void startForResult(int requestCode) {
            if (fragmentSupport_!= null) {
                fragmentSupport_.startActivityForResult(intent, requestCode);
            } else {
                if (fragment_!= null) {
                    fragment_.startActivityForResult(intent, requestCode);
                } else {
                    super.startForResult(requestCode);
                }
            }
        }

    }

}
