package utils;

import android.view.Menu;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;;

import java.util.ArrayList;

import pojo.MainMenu;
import pojo.MenuItem;

/**
 * Created by Juncal on 2016-09-28.
 */

public class MainMenuPullParse {
    public static ArrayList<MainMenu> Parse(String menuString){
        ArrayList<MainMenu> menuArray = new ArrayList<MainMenu>();

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();

            //¶¨Òå½âÎöÆ÷ XmlPullParser
            XmlPullParser parser = factory.newPullParser();

            //»ñÈ¡xmlÊäÈëÊý¾Ý
            parser.setInput(new StringReader(menuString));

            menuArray = ParseXml(parser);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return menuArray;
    }

    public static ArrayList<MainMenu> Parse(InputStream menuIS){
        ArrayList<MainMenu> menuArray = new ArrayList<MainMenu>();
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(menuIS,"utf-8");
            menuArray = ParseXml(parser);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return menuArray;
    }

    public static ArrayList<MainMenu> ParseXml(XmlPullParser parser){
        ArrayList<MainMenu> mainMenuArray = new ArrayList<MainMenu>();
        ArrayList<MenuItem> menuItemArray = new ArrayList<MenuItem>();
        MainMenu menuTemp = null;
        MenuItem menuItem=null;
        String id;
        String name;
        String url;
        int sort;
        try {
            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    case XmlPullParser.START_DOCUMENT:
                        break;

                    case XmlPullParser.START_TAG:
                        String tagName = parser.getName();

                        if(tagName.equals("MainMenu")){
                            menuItemArray=new ArrayList<MenuItem>();
                            menuTemp = new MainMenu();
                            menuTemp.setId(Integer.parseInt(parser.getAttributeValue(0)));
                            menuTemp.setName(parser.getAttributeValue(1));
                            menuTemp.setType(Integer.parseInt(parser.getAttributeValue(2)));
                            menuTemp.setUrl(parser.getAttributeValue(3));

                        }else if(tagName.equals("menuItem")){
                            menuItem = new MenuItem();
                        }
                        else if(tagName.equals("id")){
                            id=parser.nextText();
                            parser.next();
                            name=parser.nextText();
                            parser.next();
                            url=parser.nextText();
                            parser.next();
                            sort=Integer.parseInt(parser.nextText());
                            menuItem.setId(id);
                            menuItem.setName(name);
                            menuItem.setUrl(url);
                            menuItem.setSort(sort);
                        }
                        break;

                    case XmlPullParser.END_TAG:
                        if(parser.getName().equals("MainMenu")) {
                            menuTemp.setMenuItems(menuItemArray);
                            mainMenuArray.add(menuTemp);
                        }else if(parser.getName().equals("menuItem")){
                            menuItemArray.add(menuItem);
                        }
                        break;
                    case XmlPullParser.END_DOCUMENT:

                        break;
                }

                eventType = parser.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

        return mainMenuArray;
    }
}
