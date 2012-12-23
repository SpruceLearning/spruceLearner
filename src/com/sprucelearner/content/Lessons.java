package com.sprucelearner.content;
/**
 * @author qiumin
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sprucelearner.R;


public class Lessons {
	public static class LessonItem {

        public String id;
        public String content;

        public LessonItem(String id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
	
// temporary hacked list items. Remove when connected with future database
	
    public static List<LessonItem> LESSON_ITEMS_0 = new ArrayList<LessonItem>();
    public static List<LessonItem> LESSON_ITEMS_1 = new ArrayList<LessonItem>();
    public static List<LessonItem> LESSON_ITEMS_2 = new ArrayList<LessonItem>();
    
    public static Map<String, LessonItem> LESSON_ITEM_MAP = new HashMap<String, LessonItem>();

    static {
        addItem(new LessonItem("0", "一元一次方程"),LESSON_ITEMS_0);
        addItem(new LessonItem("1", "椭圆的画法"),LESSON_ITEMS_0);
        addItem(new LessonItem("2", "余弦定理"),LESSON_ITEMS_0);
        addItem(new LessonItem("3", "锦瑟"),LESSON_ITEMS_1);
        addItem(new LessonItem("4", "新东方"),LESSON_ITEMS_2);
    }
//////
    private static void addItem(LessonItem item, List<LessonItem> LESSON_ITEMS) {
        LESSON_ITEMS.add(item);
        LESSON_ITEM_MAP.put(item.id, item);
    }
}
