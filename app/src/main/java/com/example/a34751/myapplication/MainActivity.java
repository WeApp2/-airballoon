package com.example.a34751.myapplication;

import android.content.res.XmlResourceParser;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;

import java.io.InputStream;
import java.util.ArrayList;

import pojo.MainMenu;
import pojo.MenuItem;
import service.MenuService;
import utils.MainMenuPullParse;

public class MainActivity extends AppCompatActivity {
    private ArrayList<MainMenu> menus;
    private XmlPullParser menuParser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inilizeMenuDate();
    }
    private void inilizeMenuDate(){
        menuParser=getXMLFromResXml(R.xml.menu);
        menus= MainMenuPullParse.ParseXml(menuParser);
        for(MainMenu menu:menus){
            Log.v("debug","id="+menu.getId());
            Log.v("debug","name="+menu.getName());
            Log.v("debug","url="+menu.getUrl());
            Log.v("debug","type="+menu.getType());
            for(MenuItem item:menu.getMenuItems()){
                Log.v("debug","id="+item.getId());
                Log.v("debug","name="+item.getName());
                Log.v("debug","url="+item.getUrl());
                Log.v("debug","sort="+item.getSort());
            }
        }

    }
    public XmlResourceParser getXMLFromResXml(int id){
        XmlResourceParser xmlParser = null;
        try {
            xmlParser = this.getResources().getXml(id);
            return xmlParser;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xmlParser;
    }
}
