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
    public static List<LessonItem> LESSON_ITEMS_3 = new ArrayList<LessonItem>();
    
    public static Map<String, LessonItem> LESSON_ITEM_MAP = new HashMap<String, LessonItem>();

    static {
        addItem(new LessonItem("0", "余弦定理"),LESSON_ITEMS_0);
        addItem(new LessonItem("1", "椭圆的画法"),LESSON_ITEMS_0);
        addItem(new LessonItem("2","直线与方程单元测试"),LESSON_ITEMS_0);
        addItem(new LessonItem("3","高中数学必修内容训练试题(18)——会考模拟试题（1）"),LESSON_ITEMS_0);  
        addItem(new LessonItem("4", "一元一次方程习题讲解"),LESSON_ITEMS_0);
        addItem(new LessonItem("5", "李商隐诗两首，视频朗读"),LESSON_ITEMS_1);
        addItem(new LessonItem("6", "阅读理解：背影"),LESSON_ITEMS_1);
        addItem(new LessonItem("7", "阅读理解：桂花为什么不香"),LESSON_ITEMS_1);
        addItem(new LessonItem("8", "新东方语法精讲"),LESSON_ITEMS_2);
        addItem(new LessonItem("9","尚没有课程资源"),LESSON_ITEMS_3);
    }
//////
    private static void addItem(LessonItem item, List<LessonItem> LESSON_ITEMS) {
        LESSON_ITEMS.add(item);
        LESSON_ITEM_MAP.put(item.id, item);
    }
}
