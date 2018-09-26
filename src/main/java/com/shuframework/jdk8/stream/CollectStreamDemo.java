package com.shuframework.jdk8.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

/**
 * 集合的流操作
 * Created by shu on 2018/7/23.
 */
public class CollectStreamDemo {

    private Map<Integer, List<Integer>> map;

    @Test
    public void test(){
        List<String> list = new ArrayList<>();
        List<String> permissionList = new ArrayList<>();
        //排除的list
        List<String> filterList = new ArrayList<>();

        list.add("1");
        list.add("2");
        list.add("3");

        permissionList.add("1");
        permissionList.add("2");
        permissionList.add("4");

        filterList.add("1");

//        long start1 = System.currentTimeMillis();
//        List<String> newList = list.stream().filter(str -> permissionList.contains(str))
//                .filter(str -> !filterList.contains(str))
//                .collect(Collectors.toList());
//        long end1 = System.currentTimeMillis();
//        System.out.println("newList: " + (end1 - start1));
//        System.out.println(newList);

        long start2 = System.currentTimeMillis();
        List<String> newList2 = list.stream().filter(str ->
                    permissionList.contains(str) && !filterList.contains(str)
                ).collect(Collectors.toList());
        long end2 = System.currentTimeMillis();
        System.out.println("newList: " + (end2 - start2));
        System.out.println(newList2);
    }

    @Test
    public void test2(){
        //查询出来的数据
        List<Map<String, Object>> list = initListData();
//        System.out.println(list);
        List<Map<String, Object>> mapList = list.stream().map(plateNumMap -> {
            Map<String, Object> newMap = new HashMap<>();
            newMap.put("carPlate", (String) plateNumMap.get("plateNum"));
            newMap.put((String) plateNumMap.get("offTimeFormat"), (Integer) plateNumMap.get("totalPrice"));
            return newMap;
        }).collect(Collectors.toList());
        System.out.println(mapList);
        Map<String, List<Map<String, Object>>> carPlateMap = mapList.stream().collect(Collectors.groupingBy(map -> (String) map.get("carPlate")));
        System.out.println(carPlateMap);

        List<Map<String, Object>> returnList = new ArrayList<>();
//        String keys1 = "2018/07/01";
//        String keys2 = "2018/07/02";

        for (Map.Entry<String, List<Map<String, Object>>> entry : carPlateMap.entrySet()){
            Map<String, Object> returnMap = new TreeMap<>();
            returnMap.put("carPlate", entry.getKey());
            returnMap.put("2018/07/01", 0);
            returnMap.put("2018/07/02", 0);
            List<Map<String, Object>> valueList = entry.getValue();
            for(Map<String, Object> map : valueList){
//                for (Map.Entry<String, Object> entry22 : map.entrySet()){
//                    returnMap.put(entry22.getKey(), entry22.getValue());
//                }
                returnMap.putAll(map);
            }
            returnList.add(returnMap);
        }
        System.out.println(returnList);

    }

    private List<Map<String, Object>> initListData() {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map1 = new HashMap<>();
        map1.put("plateNum", "鄂A000001");
        map1.put("offTimeFormat", "2018/07/01");
        map1.put("totalPrice", 100);
        Map<String, Object> map2 = new HashMap<>();
        map2.put("plateNum", "鄂A000001");
        map2.put("offTimeFormat", "2018/07/02");
        map2.put("totalPrice", 200);

        Map<String, Object> map3 = new HashMap<>();
        map3.put("plateNum", "鄂A000002");
        map3.put("offTimeFormat", "2018/07/01");
        map3.put("totalPrice", 120);
        Map<String, Object> map4 = new HashMap<>();
        map4.put("plateNum", "鄂A000002");
        map4.put("offTimeFormat", "2018/07/02");
        map4.put("totalPrice", 220);

        Map<String, Object> map5 = new HashMap<>();
        map5.put("plateNum", "鄂A000003");
        map5.put("offTimeFormat", "2018/07/02");
        map5.put("totalPrice", 130);

        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);
        list.add(map5);
        return list;
    }



    @Test
    public void test3(){
        Map<Integer, List<Integer>> map = initDistinctMapData();
        System.out.println("去重前:" + map);
        //冒泡比较
        //java.util.ConcurrentModificationException
//        map.forEach((k,v) -> {
////            System.out.println(k +","+v);
//            Set<Integer> keys =  map.keySet();
//            for(Integer i : keys){
//                if(!i.equals(k) && v.contains(i)){
//                    map.remove(i);
//                }
//            }
//        });
        map.entrySet().iterator();

        System.out.println("去重后:" + map);
    }

    private Map<Integer, List<Integer>> initDistinctMapData() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(11);
        list1.add(111);
        List<Integer> list2 = new ArrayList<>();
        list2.add(11);
        list2.add(111);
        List<Integer> list3 = new ArrayList<>();
        list3.add(12);
        list3.add(121);
        Map<Integer, List<Integer>> map = new TreeMap<>();
//        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(1, list1);
        map.put(11, list2);
        map.put(12, list3);
        return map;
    }

}
