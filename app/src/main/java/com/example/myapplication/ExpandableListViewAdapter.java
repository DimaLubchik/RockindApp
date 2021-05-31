package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class ExpandableListViewAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> chapterList; //список типов строк
    private HashMap<String, List<Exercise>> topicsList; //расширяемый список создается на hashmap



    public ExpandableListViewAdapter(Context context, List<String> chapterList,HashMap<String,List<Exercise>> topicsList) {

        this.context = context;
        this.chapterList = chapterList;
        this.topicsList = topicsList;

    }

    @Override
    public int getGroupCount() {
        return this.chapterList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.topicsList.get(this.chapterList.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.chapterList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.topicsList.get(this.chapterList.get(groupPosition)).get(childPosition);
    }


    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String chapterTitle = (String) getGroup(groupPosition);

        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.chapter,null);
        }
        TextView chapterTv = convertView.findViewById(R.id.chapter_tv);
        chapterTv.setText(chapterTitle);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        Exercise currentEx = (Exercise) getChild(groupPosition, childPosition);

        if(convertView==null){
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.topicks_list,null);
        }
        LinearLayout topic_layout = convertView.findViewById(R.id.topic_layout);
        TextView topicTv =topic_layout.findViewById(R.id.topics_tv);
        TextView sub_title =topic_layout.findViewById(R.id.textView_topicList);
        sub_title.setVisibility(View.INVISIBLE);
        ImageView img =topic_layout.findViewById(R.id.imageFor);
        topicTv.setText(currentEx.name);
        img.setImageResource(currentEx.image);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
