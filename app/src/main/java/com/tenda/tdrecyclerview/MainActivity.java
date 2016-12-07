package com.tenda.tdrecyclerview;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tenda.tdrecycler.NRecyclerView;
import com.tenda.tdrecycler.base.BaseLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private NRecyclerView mNRecyclerView;
    private MyAdapter adapter;
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
        setContentView(R.layout.activity_main);
        initView();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mNRecyclerView.setLayoutManager(layoutManager);

        ViewGroup adVentureView = (ViewGroup) LayoutInflater.from(this).inflate(R.layout.adventure_layout,(ViewGroup)findViewById(android.R.id.content),false);
        mNRecyclerView.setAdtureView(adVentureView);

        ViewGroup bottomView= (ViewGroup) LayoutInflater.from(this).inflate(R.layout.bottom_view,(ViewGroup)findViewById(android.R.id.content),false);
        mNRecyclerView.setBottomView(bottomView);

        adapter = new MyAdapter();
        adapter.addAll(lists);

        mNRecyclerView.setAdapter(adapter);
        mNRecyclerView.setTotalPages(5);

        mNRecyclerView.setOnRefreshAndLoadingListener(new BaseLayout.RefreshAndLoadingListener() {
            @Override
            public void refresh() {
               new Handler().postDelayed(new Runnable() {
                   @Override
                   public void run() {
                       currentPage = 1;
                       adapter.clean();
                       adapter.addAll(lists);
                       mNRecyclerView.setPullLoadEnable(currentPage>=totalPage?false:true);
                       mNRecyclerView.removeErrorView();
                       mNRecyclerView.resetEntryView();
                       mNRecyclerView.endRefresh();
                   }
               },600);

            }

            @Override
            public void load() {
              currentPage++;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (currentPage>=totalPage){
                            mNRecyclerView.pullNoMoreEvent();
                        }else {
                            List<String> items=new ArrayList<String>();
                            for(int i=0;i<10;i++){
                                items.add("你的名字 "+i);
                            }
                            adapter.addAll(items);
                            mNRecyclerView.endLoadingMore();
                        }
                }
            },600);

            }
        });
    }

    private void initView() {
        mNRecyclerView = (NRecyclerView) findViewById(R.id.recycler);
    }


    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        private List<String> mDatas;

        public MyAdapter() {
            mDatas = new ArrayList<>();
        }

        public void addAll(Collection collection) {
            mDatas.addAll(collection);
            notifyDataSetChanged();
        }

        public void clean() {
            mDatas.clear();
            notifyDataSetChanged();
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_view, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.tvText.setText(mDatas.get(position));
        }

        @Override
        public int getItemCount() {
            return mDatas.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            private TextView tvText;

            public MyViewHolder(View itemView) {
                super(itemView);
                tvText = (TextView) itemView.findViewById(R.id.item_tv_text);
            }
        }
    }
}
