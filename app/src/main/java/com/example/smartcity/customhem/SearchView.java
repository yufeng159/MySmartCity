package com.example.smartcity.customhem;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;


import com.example.smartcity.R;

import java.util.ArrayList;
import java.util.List;

public class SearchView extends LinearLayout implements TextWatcher {
    private EditText et_search;
    private SearchWay searchWay;
    private String searchText;
    private SearchWay mSearch;
    private WaitThread waitThread;
    private int waitTime=200;
    int curTime;
    private Handler handler;
    public SearchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.searchview, null);
        et_search = view.findViewById(R.id.edt_search);
        et_search.addTextChangedListener(this);
        handler = new Handler() {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                if (0==msg.what){
                    List searchList=new ArrayList();
                    List list=mSearch.getData();
                    if (list!=null){
                        for (Object o : list) {
                            if (mSearch.matchItem(o, searchText)) {
                                searchList.add(o);
                            }
                        }
                        mSearch.update(searchList);
                    }
                }
            }
        };
        ViewGroup.LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        addView(view, params);

    }
    public void setSearchWay(SearchWay search){
        mSearch = search;
    }

    /**
     * 获取搜索框的文字
     */
    public String getText(){
        return et_search.getText().toString();
    }

    public SearchWay getSearchWay(SearchWay<String> searchWay) {
        return mSearch;
    }
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
    private class WaitThread extends Thread {
        @Override
        public void run() {
            //等待延时
            for (curTime = 0; curTime < waitTime; curTime += 100){
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

            handler.sendEmptyMessage(0);
        }
    }

    /**
     * 用于匹配项
     */
    public static abstract class SearchWay<T> {
        /**
         * @return 数据源
         */
        public abstract List<T> getData();

        /**
         * @return item中是否包含有s
         */
        public abstract boolean matchItem(T item, String s);

        /**
         * 更新列表
         *
         * @param resultList 匹配的数据，重新加载到列表
         */
        public abstract void update(List<T> resultList);
    }
}

