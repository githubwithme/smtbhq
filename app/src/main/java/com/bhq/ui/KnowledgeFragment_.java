//
// DO NOT EDIT THIS FILE, IT HAS BEEN GENERATED USING AndroidAnnotations 3.2.
//


package com.bhq.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.bhq.widget.PullToRefreshListView;

import org.androidannotations.api.builder.FragmentBuilder;
import org.androidannotations.api.view.HasViews;
import org.androidannotations.api.view.OnViewChangedListener;
import org.androidannotations.api.view.OnViewChangedNotifier;

public final class KnowledgeFragment_
    extends com.bhq.ui.KnowledgeFragment
    implements HasViews, OnViewChangedListener
{

    private final OnViewChangedNotifier onViewChangedNotifier_ = new OnViewChangedNotifier();
    private View contentView_;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        OnViewChangedNotifier previousNotifier = OnViewChangedNotifier.replaceNotifier(onViewChangedNotifier_);
        init_(savedInstanceState);
        super.onCreate(savedInstanceState);
        OnViewChangedNotifier.replaceNotifier(previousNotifier);
    }

    @Override
    public View findViewById(int id) {
        if (contentView_ == null) {
            return null;
        }
        return contentView_.findViewById(id);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        contentView_ = super.onCreateView(inflater, container, savedInstanceState);
        return contentView_;
    }

    @Override
    public void onDestroyView() {
        contentView_ = null;
        super.onDestroyView();
    }

    private void init_(Bundle savedInstanceState) {
        OnViewChangedNotifier.registerOnViewChangedListener(this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onViewChangedNotifier_.notifyViewChanged(this);
    }

    public static KnowledgeFragment_.FragmentBuilder_ builder() {
        return new KnowledgeFragment_.FragmentBuilder_();
    }

    @Override
    public void onViewChanged(HasViews hasViews) {
        main_head_progress = ((ProgressBar) hasViews.findViewById(com.bhq.R.id.main_head_progress));
        btn_zcwj = ((Button) hasViews.findViewById(com.bhq.R.id.btn_zcwj));
        btn_da = ((Button) hasViews.findViewById(com.bhq.R.id.btn_da));
        btn_flfg = ((Button) hasViews.findViewById(com.bhq.R.id.btn_flfg));
        frame_listview_news = ((PullToRefreshListView) hasViews.findViewById(com.bhq.R.id.frame_listview_news));
        if (btn_da!= null) {
            btn_da.setOnClickListener(new OnClickListener() {


                @Override
                public void onClick(View view) {
                    KnowledgeFragment_.this.btn_da();
                }

            }
            );
        }
        if (btn_zcwj!= null) {
            btn_zcwj.setOnClickListener(new OnClickListener() {


                @Override
                public void onClick(View view) {
                    KnowledgeFragment_.this.btn_zcwj();
                }

            }
            );
        }
        if (btn_flfg!= null) {
            btn_flfg.setOnClickListener(new OnClickListener() {


                @Override
                public void onClick(View view) {
                    KnowledgeFragment_.this.btn_flfg();
                }

            }
            );
        }
        afterOncreate();
    }

    public static class FragmentBuilder_
        extends FragmentBuilder<KnowledgeFragment_.FragmentBuilder_, com.bhq.ui.KnowledgeFragment>
    {


        @Override
        public com.bhq.ui.KnowledgeFragment build() {
            KnowledgeFragment_ fragment_ = new KnowledgeFragment_();
            fragment_.setArguments(args);
            return fragment_;
        }

    }

}
