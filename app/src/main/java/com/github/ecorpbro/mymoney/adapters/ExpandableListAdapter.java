package com.github.ecorpbro.mymoney.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.github.ecorpbro.mymoney.R;

import java.util.HashMap;
import java.util.List;

public class ExpandableListAdapter extends BaseExpandableListAdapter {
    public static final String TAG = "ExpandableListAdapter";

    private Context context;
    private List<String> listGroup;
    private HashMap<String,List<String>> mapChild;

    public ExpandableListAdapter(Context context, List<String> listGroup, HashMap<String, List<String>> mapChild) {
        this.context = context;
        this.listGroup = listGroup;
        this.mapChild = mapChild;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mapChild.get(listGroup.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        String childMenuText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.menu_item_child, null);
        }

        TextView txtMenuChild = (TextView) convertView.findViewById(R.id.txtChildMenu);

        txtMenuChild.setText(childMenuText);
        return convertView;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String groupMenuText = (String) getGroup(groupPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.menu_item_group, null);
        }

        TextView txtMenuGroup = (TextView) convertView.findViewById(R.id.menuItemGroup);
        txtMenuGroup.setText(groupMenuText);
        return convertView;
    }

    @Override
    public int getGroupCount() {
        return listGroup.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mapChild.get(listGroup.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listGroup.get(groupPosition);
    }



    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }



    @Override
    public boolean hasStableIds() {
        return false;
    }





    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
