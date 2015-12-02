package com.bhq.ui;

import android.app.Fragment;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bhq.R;
import com.bhq.adapter.Offline_ListViewEventAdapter;
import com.bhq.app.AppContext;
import com.bhq.bean.BHQ_XHSJ;
import com.bhq.bean.dt_manager_offline;
import com.bhq.common.SqliteDb;
import com.bhq.common.StringUtils;
import com.bhq.common.UIHelper;
import com.bhq.widget.NewDataToast;
import com.bhq.widget.PullToRefreshListView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author :hc-sima
 * @version :1.0
 * @createTime：2015-8-19 下午2:41:19
 * @description :
 */
@EFragment
public class Offline_EventListFragment extends Fragment
{
	private AppContext appContext;// 全局Context
	private List<BHQ_XHSJ> listData = new ArrayList<BHQ_XHSJ>();
	private Offline_ListViewEventAdapter listAdapter;
	private View list_footer;
	private TextView list_foot_more;
	private ProgressBar list_foot_progress;
	private int listSumData;

	@ViewById
	PullToRefreshListView frame_listview_plant;

	@AfterViews
	void afterOncreate()
	{
		initAnimalListView();
	}

	@Override
	public void onResume()
	{
		super.onResume();
		getListData(UIHelper.LISTVIEW_ACTION_REFRESH, UIHelper.LISTVIEW_DATATYPE_NEWS, frame_listview_plant, listAdapter, list_foot_more, list_foot_progress, AppContext.PAGE_SIZE, 0);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View rootView = inflater.inflate(R.layout.eventlistfragment, container, false);
		appContext = (AppContext) getActivity().getApplication();
		IntentFilter refresh_Filter = new IntentFilter(AppContext.ACTION_REFRESH_PLANT);
		getActivity().registerReceiver(refresh_Receiver, refresh_Filter);
		return rootView;
	}

	BroadcastReceiver refresh_Receiver = new BroadcastReceiver()
	{
		@SuppressWarnings("deprecation")
		@Override
		public void onReceive(Context context, Intent intent)// 通过获取数据库更新房间按钮
		{
			initAnimalListView();
		}
	};

	private void getListData(final int actiontype, final int objtype, final PullToRefreshListView lv, final BaseAdapter adapter, final TextView more, final ProgressBar progressBar, final int PAGESIZE, int PAGEINDEX)
	{
		dt_manager_offline dt_manager_offline = (com.bhq.bean.dt_manager_offline) SqliteDb.getCurrentUser(getActivity(), dt_manager_offline.class);
		List<BHQ_XHSJ> listNewData = SqliteDb.getEventList(getActivity(), BHQ_XHSJ.class, dt_manager_offline.getid());
		if (listNewData == null)
		{
			listNewData = new ArrayList<BHQ_XHSJ>();
		}
		// 数据处理
		int size = listNewData.size();
		switch (actiontype)
		{
		case UIHelper.LISTVIEW_ACTION_INIT:// 初始化
		case UIHelper.LISTVIEW_ACTION_REFRESH:// 顶部刷新
		case UIHelper.LISTVIEW_ACTION_CHANGE_CATALOG:// 页面切换
			int newdata = 0;// 该变量为新加载数据数量-只有顶部刷新才会使用到
			switch (objtype)
			{
			case UIHelper.LISTVIEW_DATATYPE_NEWS:
				listSumData = size;
				if (actiontype == UIHelper.LISTVIEW_ACTION_REFRESH)
				{
					if (listData.size() > 0)// 页面切换时，若之前列表中已有数据，则往上面添加，并判断去除重复
					{
						for (BHQ_XHSJ BHQ_XHSJ1 : listNewData)
						{
							boolean b = false;
							for (BHQ_XHSJ BHQ_XHSJ2 : listData)
							{
								if (BHQ_XHSJ1.getSJID().equals(BHQ_XHSJ2.getSJID()))
								{
									b = true;
									break;
								}
							}
							if (!b)// 两个不相等才添加
								newdata++;
						}
					} else
					{
						newdata = size;
					}
				}
				listData.clear();// 先清除原有数据
				listData.addAll(listNewData);
				break;
			case UIHelper.LISTVIEW_DATATYPE_BLOG:
			case UIHelper.LISTVIEW_DATATYPE_COMMENT:
			}
			if (actiontype == UIHelper.LISTVIEW_ACTION_REFRESH)
			{
				// 提示新加载数据
				if (newdata > 0)
				{
					NewDataToast.makeText(getActivity(), getString(R.string.new_data_toast_message, newdata), appContext.isAppSound(), R.raw.newdatatoast).show();
				} else
				{
					NewDataToast.makeText(getActivity(), getString(R.string.new_data_toast_none), false, R.raw.newdatatoast).show();
				}
			}
			break;
		case UIHelper.LISTVIEW_ACTION_SCROLL:// 底部刷新，并且判断去除重复数据
			switch (objtype)
			{
			case UIHelper.LISTVIEW_DATATYPE_NEWS:
				listSumData += size;
				if (listNewData.size() > 0)
				{
					for (BHQ_XHSJ BHQ_XHSJ1 : listNewData)
					{
						boolean b = false;
						for (BHQ_XHSJ BHQ_XHSJ2 : listData)
						{
							if (BHQ_XHSJ1.getSJID() == BHQ_XHSJ2.getSJID())
							{
								b = true;
								break;
							}
						}
						if (!b)
							listData.add(BHQ_XHSJ1);
					}
				} else
				{
					listData.addAll(listNewData);
				}
				break;
			case UIHelper.LISTVIEW_DATATYPE_BLOG:
				break;
			}
			break;
		}
		// 刷新列表
		if (size >= 0)
		{
			if (size < PAGESIZE)
			{
				lv.setTag(UIHelper.LISTVIEW_DATA_FULL);
				adapter.notifyDataSetChanged();
				more.setText(R.string.load_full);// 已经全部加载完毕
			} else if (size == PAGESIZE)
			{// 还有数据可以加载
				lv.setTag(UIHelper.LISTVIEW_DATA_MORE);
				adapter.notifyDataSetChanged();
				more.setText(R.string.load_more);
			}

		} else if (size == -1)
		{
			// 有异常--显示加载出错 & 弹出错误消息
			lv.setTag(UIHelper.LISTVIEW_DATA_MORE);
			more.setText(R.string.load_error);
			AppContext.makeToast(getActivity(), "load_error");
		}
		if (adapter.getCount() == 0)
		{
			lv.setTag(UIHelper.LISTVIEW_DATA_EMPTY);
			more.setText(R.string.load_empty);
		}
		progressBar.setVisibility(ProgressBar.GONE);
		// main_head_progress.setVisibility(ProgressBar.GONE);
		if (actiontype == UIHelper.LISTVIEW_ACTION_REFRESH)
		{
			lv.onRefreshComplete(getString(R.string.pull_to_refresh_update) + new Date().toLocaleString());
			lv.setSelection(0);
		} else if (actiontype == UIHelper.LISTVIEW_ACTION_CHANGE_CATALOG)
		{
			lv.onRefreshComplete();
			lv.setSelection(0);
		}

	}

	/**
	 * @description:初始化动物列表
	 * @createTime：2015-8-10 上午11:25:25
	 */
	private void initAnimalListView()
	{
		listAdapter = new Offline_ListViewEventAdapter(getActivity(), listData, R.layout.eventlist_item);
		list_footer = getActivity().getLayoutInflater().inflate(R.layout.listview_footer, null);
		list_foot_more = (TextView) list_footer.findViewById(R.id.listview_foot_more);
		list_foot_progress = (ProgressBar) list_footer.findViewById(R.id.listview_foot_progress);
		frame_listview_plant.addFooterView(list_footer);// 添加底部视图 必须在setAdapter前
		frame_listview_plant.setAdapter(listAdapter);
		frame_listview_plant.setOnItemClickListener(new AdapterView.OnItemClickListener()
		{
			public void onItemClick(AdapterView<?> parent, View view, int position, long id)
			{
				// 点击头部、底部栏无效
				if (position == 0 || view == list_footer)
					return;

				// RK_LDRK rk_LDRK = null;
				// // 判断是否是TextView
				// if (view instanceof TextView)
				// {
				// rk_LDRK = (RK_LDRK) view.getTag();
				// } else
				// {
				// TextView tv = (TextView)
				// view.findViewById(R.id.news_listitem_title);
				// rk_LDRK = (RK_LDRK) tv.getTag();
				// }
				// if (rk_LDRK == null)
				// return;
				BHQ_XHSJ bhq_XHSJ = listData.get(position - 1);
				if (bhq_XHSJ == null)
					return;
				Intent intent = new Intent(getActivity(), Offline_ShowEventContent_.class);
				intent.putExtra("bean", bhq_XHSJ);// 因为list中添加了头部,因此要去掉一个
				getActivity().startActivity(intent);

			}
		});
		frame_listview_plant.setOnScrollListener(new AbsListView.OnScrollListener()
		{
			public void onScrollStateChanged(AbsListView view, int scrollState)
			{
				frame_listview_plant.onScrollStateChanged(view, scrollState);

				// 数据为空--不用继续下面代码了
				if (listData.isEmpty())
					return;

				// 判断是否滚动到底部
				boolean scrollEnd = false;
				try
				{
					if (view.getPositionForView(list_footer) == view.getLastVisiblePosition())
						scrollEnd = true;
				} catch (Exception e)
				{
					scrollEnd = false;
				}

				int lvDataState = StringUtils.toInt(frame_listview_plant.getTag());
				if (scrollEnd && lvDataState == UIHelper.LISTVIEW_DATA_MORE)
				{
					frame_listview_plant.setTag(UIHelper.LISTVIEW_DATA_LOADING);
					list_foot_more.setText(R.string.load_ing);// 之前显示为"完成"加载
					list_foot_progress.setVisibility(View.VISIBLE);
					// 当前pageIndex
					int pageIndex = listSumData / AppContext.PAGE_SIZE;// 总数里面包含几个PAGE_SIZE
					getListData(UIHelper.LISTVIEW_ACTION_SCROLL, UIHelper.LISTVIEW_DATATYPE_NEWS, frame_listview_plant, listAdapter, list_foot_more, list_foot_progress, AppContext.PAGE_SIZE, pageIndex);
					// loadLvNewsData(curNewsCatalog, pageIndex, lvNewsHandler,
					// UIHelper.LISTVIEW_ACTION_SCROLL);
				}
			}

			public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount)
			{
				frame_listview_plant.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount);
			}
		});
		frame_listview_plant.setOnRefreshListener(new PullToRefreshListView.OnRefreshListener()
		{
			public void onRefresh()
			{
				// loadLvNewsData(curNewsCatalog, 0, lvNewsHandler,
				// UIHelper.LISTVIEW_ACTION_REFRESH);
				getListData(UIHelper.LISTVIEW_ACTION_REFRESH, UIHelper.LISTVIEW_DATATYPE_NEWS, frame_listview_plant, listAdapter, list_foot_more, list_foot_progress, AppContext.PAGE_SIZE, 0);
			}
		});
		// 加载资讯数据
		if (listData.isEmpty())
		{
			getListData(UIHelper.LISTVIEW_ACTION_INIT, UIHelper.LISTVIEW_DATATYPE_NEWS, frame_listview_plant, listAdapter, list_foot_more, list_foot_progress, AppContext.PAGE_SIZE, 0);
		}
	}
}
