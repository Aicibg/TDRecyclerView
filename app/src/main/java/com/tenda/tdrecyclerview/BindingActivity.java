package com.tenda.tdrecyclerview;

import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tenda.tdrecycler.adapter.BindingViewHolder;
import com.tenda.tdrecycler.adapter.SingleTypeAdapter;
import com.tenda.tdrecycler.base.BaseLayout;
import com.tenda.tdrecyclerview.databinding.ActivityBindingBinding;

import java.util.ArrayList;
import java.util.List;

public class BindingActivity extends AppCompatActivity {
    private ActivityBindingBinding mActivityBindingBinding;
    private SingleTypeAdapter<String> mStringSingleTypeAdapter;
    private static List<String> lists = new ArrayList<>();
    private int currentPage = 1, totalPage = 6;

    static {
        lists.add("你的名字 1");
        lists.add("你的名字 2");
        lists.add("你的名字 3");
        lists.add("你的名字 4");
        lists.add("你的名字 5");
        lists.add("你的名字 6");
        lists.add("你的名字 7");
        lists.add("你的名字 8");
        lists.add("你的名字 9");
        lists.add("你的名字 10");
        lists.add("你的名字 11");
        lists.add("你的名字 12");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityBindingBinding = DataBindingUtil.setContentView(this, R.layout.activity_binding);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//
//        ViewGroup adVentureView = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.adventure_layout, (ViewGroup) findViewById(android.R.id.content), false);
//        mActivityBindingBinding.bindRecycler.setAdtureView(adVentureView);

        ViewGroup bottomView = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.bottom_view, (ViewGroup) findViewById(android.R.id.content), false);
        mActivityBindingBinding.bindRecycler.setBottomView(bottomView);

        mStringSingleTypeAdapter = new SingleTypeAdapter<String>(this,R.layout.item_binding_view);
        mStringSingleTypeAdapter.setDecorator(new AdapterDecorator());
        mStringSingleTypeAdapter.setPresenter(new AdapterPresenter());
        mStringSingleTypeAdapter.addAll(lists);

        mActivityBindingBinding.setAdapter(mStringSingleTypeAdapter);
        mActivityBindingBinding.setLayoutManager(layoutManager);

        mActivityBindingBinding.bindRecycler.setTotalPages(5);

        mActivityBindingBinding.bindRecycler.setOnRefreshAndLoadingListener(new BaseLayout.RefreshAndLoadingListener() {
            @Override
            public void refresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        currentPage = 1;
                        mStringSingleTypeAdapter.clear();
                        mStringSingleTypeAdapter.addAll(lists);
                        mActivityBindingBinding.bindRecycler.setPullLoadEnable(currentPage >= totalPage ? false : true);
//                        mActivityBindingBinding.bindRecycler.removeErrorView();
                        mActivityBindingBinding.bindRecycler.resetEntryView();
                        mActivityBindingBinding.bindRecycler.endRefresh();
                    }
                }, 600);

            }

            @Override
            public void load() {
                currentPage++;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (currentPage >= totalPage) {
                            mActivityBindingBinding.bindRecycler.pullNoMoreEvent();
                        } else {
                            List<String> items = new ArrayList<String>();
                            for (int i = 0; i < 10; i++) {
                                items.add("你的名字 " + i);
                            }
                            mStringSingleTypeAdapter.addAll(items);
                            mActivityBindingBinding.bindRecycler.endLoadingMore();
                        }
                    }
                }, 600);

            }
        });
    }


    public class AdapterPresenter implements SingleTypeAdapter.Presenter<String> {
        public void onItemClick(String str) {
            Toast.makeText(BindingActivity.this, str, Toast.LENGTH_SHORT).show();
        }
    }

    public class AdapterDecorator implements SingleTypeAdapter.Decorator {
        @Override
        public void decorator(BindingViewHolder holder, int position, int viewType) {

        }
    }
}
