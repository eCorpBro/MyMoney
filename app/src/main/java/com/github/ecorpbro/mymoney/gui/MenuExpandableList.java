package com.github.ecorpbro.mymoney.gui;

import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import com.github.ecorpbro.mymoney.adapters.ExpandableListAdapter;
import android.widget.ExpandableListView;

import androidx.drawerlayout.widget.DrawerLayout;

import com.github.ecorpbro.mymoney.R;
import com.github.ecorpbro.mymoney.activites.ContentFragment;
import com.github.ecorpbro.mymoney.activites.MainActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuExpandableList {
    public static final String TAG = "MenuExpandableList";

    private AppCompatActivity context;
    private DrawerLayout navDrawer;

    private ExpandableListAdapter listAdapter;
    private ExpandableListView expListView;

    private List<String> listGroup;
    private HashMap<String,List<String>> mapChild;

    public MenuExpandableList(final AppCompatActivity context) {
        this.context = context;
        expListView = (ExpandableListView) context.findViewById(R.id.expLvMenu);
        navDrawer = (DrawerLayout) context.findViewById(R.id.drawer_layout);

        fillMenu();

        listAdapter = new ExpandableListAdapter(context, listGroup, mapChild);

        expListView.setAdapter(listAdapter);

        Log.d(TAG, "Constructor MenuExpandableList " + listAdapter);

        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return false;
            }
        });

        expListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {

            }
        });

        expListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {

            }
        });

        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                Log.d(TAG,"setOnChildClickListener");

                ContentFragment fragment = new ContentFragment();
                Bundle args = new Bundle();
                args.putInt(MainActivity.TEST_CONTENT,childPosition);
                fragment.setArguments(args);

                FragmentManager fragmentManager = context.getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

                navDrawer.closeDrawer(Gravity.LEFT);
                return true;
            }
        });
    }

    private void fillMenu() {
        listGroup = new ArrayList<String>();
        mapChild = new HashMap<String, List<String>>();

        listGroup.add(context.getResources().getString(R.string.menu1));
        listGroup.add(context.getResources().getString(R.string.menu2));
        listGroup.add(context.getResources().getString(R.string.menu3));

        List<String> menu1 = new ArrayList<String>();
        for (String child:context.getResources().getStringArray(R.array.menu1_childs)) {
            menu1.add(child);
        }

        List<String> menu2 = new ArrayList<String>();
        for (String child:context.getResources().getStringArray(R.array.menu2_childs)) {
            menu2.add(child);
        }

        List<String> menu3 = new ArrayList<String>();
        for (String child:context.getResources().getStringArray(R.array.menu3_childs)) {
            menu3.add(child);
        }

        mapChild.put(listGroup.get(0), menu1);
        mapChild.put(listGroup.get(1), menu2);
        mapChild.put(listGroup.get(2), menu3);
    }
}
