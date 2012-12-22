package com.sprucelearner.content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    public static List<LessonItem> LESSON_ITEMS = new ArrayList<LessonItem>();
    public static Map<String, LessonItem> LESSON_ITEM_MAP = new HashMap<String, LessonItem>();

    static {
        addItem(new LessonItem("1", "一元一次方程"));
        addItem(new LessonItem("2", "椭圆的画法"));
        addItem(new LessonItem("3", "二元一次方程"));
    }

    private static void addItem(LessonItem item) {
        LESSON_ITEMS.add(item);
        LESSON_ITEM_MAP.put(item.id, item);
    }
}
