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
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
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
public final class ShowPlant_
    extends ShowPlant
    implements HasViews, OnViewChangedListener
{

    private final OnViewChangedNotifier onViewChangedNotifier_ = new OnViewChangedNotifier();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        OnViewChangedNotifier previousNotifier = OnViewChangedNotifier.replaceNotifier(onViewChangedNotifier_);
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
        OnViewChangedNotifier.replaceNotifier(previousNotifier);
        setContentView(layout.showplant);
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

    public static ShowPlant_.IntentBuilder_ intent(Context context) {
        return new ShowPlant_.IntentBuilder_(context);
    }

    public static ShowPlant_.IntentBuilder_ intent(android.app.Fragment fragment) {
        return new ShowPlant_.IntentBuilder_(fragment);
    }

    public static ShowPlant_.IntentBuilder_ intent(android.support.v4.app.Fragment supportFragment) {
        return new ShowPlant_.IntentBuilder_(supportFragment);
    }

    @Override
    public void onViewChanged(HasViews hasViews) {
        contain_more = ((FrameLayout) hasViews.findViewById(id.contain_more));
        tv_name = ((TextView) hasViews.findViewById(id.tv_name));
        fl_contain = ((FrameLayout) hasViews.findViewById(id.fl_contain));
        btn_other = ((Button) hasViews.findViewById(id.btn_other));
        btn_record = ((Button) hasViews.findViewById(id.btn_record));
        img_container = ((FrameLayout) hasViews.findViewById(id.img_container));
        imgbtn_back = ((ImageButton) hasViews.findViewById(id.imgbtn_back));
        btn_foundation = ((Button) hasViews.findViewById(id.btn_foundation));
        btn_video = ((Button) hasViews.findViewById(id.btn_video));
        tv_number = ((TextView) hasViews.findViewById(id.tv_number));
        if (imgbtn_back!= null) {
            imgbtn_back.setOnClickListener(new OnClickListener() {


                @Override
                public void onClick(View view) {
                    ShowPlant_.this.imgbtn_back();
                }

            }
            );
        }
        if (btn_video!= null) {
            btn_video.setOnClickListener(new OnClickListener() {


                @Override
                public void onClick(View view) {
                    ShowPlant_.this.btn_video();
                }

            }
            );
        }
        if (btn_foundation!= null) {
            btn_foundation.setOnClickListener(new OnClickListener() {


                @Override
                public void onClick(View view) {
                    ShowPlant_.this.btn_foundation();
                }

            }
            );
        }
        if (btn_other!= null) {
            btn_other.setOnClickListener(new OnClickListener() {


                @Override
                public void onClick(View view) {
                    ShowPlant_.this.btn_other();
                }

            }
            );
        }
        if (btn_record!= null) {
            btn_record.setOnClickListener(new OnClickListener() {


                @Override
                public void onClick(View view) {
                    ShowPlant_.this.btn_record();
                }

            }
            );
        }
        afterOncreate();
    }

    public static class IntentBuilder_
        extends ActivityIntentBuilder<ShowPlant_.IntentBuilder_>
    {

        private android.app.Fragment fragment_;
        private android.support.v4.app.Fragment fragmentSupport_;

        public IntentBuilder_(Context context) {
            super(context, ShowPlant_.class);
        }

        public IntentBuilder_(android.app.Fragment fragment) {
            super(fragment.getActivity(), ShowPlant_.class);
            fragment_ = fragment;
        }

        public IntentBuilder_(android.support.v4.app.Fragment fragment) {
            super(fragment.getActivity(), ShowPlant_.class);
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
