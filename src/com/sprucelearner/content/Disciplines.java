package com.sprucelearner.content;
/**
 * @author qiumin
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Disciplines {

    public static class DisciplineItem {

        public String id;
        public String content;

        public DisciplineItem(String id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }

    public static List<DisciplineItem> DISP_ITEMS = new ArrayList<DisciplineItem>();
    public static Map<String, DisciplineItem> DISP_ITEM_MAP = new HashMap<String, DisciplineItem>();

    static {
        addItem(new DisciplineItem("0", "高一（上）数学"));
        addItem(new DisciplineItem("1", "高一（上）语文"));
        addItem(new DisciplineItem("2", "高一（上）英语"));
        addItem(new DisciplineItem("3", "高一（上）物理"));
        addItem(new DisciplineItem("4", "高一（上）化学"));
        addItem(new DisciplineItem("5", "高一（上）生物"));
        addItem(new DisciplineItem("6", "高一（上）政治"));
        addItem(new DisciplineItem("7", "高一（上）历史"));
        addItem(new DisciplineItem("8", "高一（上）地理"));
    }

    private static void addItem(DisciplineItem item) {
        DISP_ITEMS.add(item);
        DISP_ITEM_MAP.put(item.id, item);
    }
}