package com.shuframework.jdk7.collection.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * 模拟斗地主洗牌和发牌
 * 	牌是HashMap, 发牌分配的是index, 看牌是index,然后翻译为value
 * 
 * 分析：
 * 	(1)创建一个牌盒
 * 	(2)装牌
 * 	(3)洗牌
 * 	(4)发牌
 * 	(5)看牌
 * 
 * @author shu
 *
 */
public class PokerExerciseDemo {
	
	private static final String KEY_PLAYER = "player";
	private static final String KEY_DIPAI = "diPai";
	
	// 创建一个牌盒
	private Map<Integer, String> pokerMap = null;
	// 牌的序号
	private List<Integer> list = null;

	public Map<Integer, String> getPokerMap() {
		return pokerMap;
	}

	public List<Integer> getList() {
		return list;
	}

	/**
	 * 创建一个牌盒, 且装牌, 形成一幅牌
	 * 
	 * @return
	 */
	public void init() {
		pokerMap = new HashMap<>();
		list = new ArrayList<Integer>();
		// 装牌
		// 黑桃A,黑桃2,黑桃3,...黑桃K
		// 红桃A,...
		// 梅花A,...
		// 方块A,...
		// 定义一个花色数组
		String[] colors = { "♠", "♥", "♣", "♦" };
		// 定义一个点数数组
		String[] numbers = { "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2" };
		int index = 0;
		// 装牌
		for (String number : numbers) {
			for (String color : colors) {
				pokerMap.put(index, color.concat(number));
				list.add(index);
				index++;
			}
		}
		pokerMap.put(index, "小王");
		list.add(index);
		index++;
		pokerMap.put(index, "大王");
		list.add(index);
	}
	
	/**
	 * 发牌
	 * 
	 * @param list
	 * @return
	 */
	public Map<String, TreeSet<Integer>> deal(List<Integer> list) {
		Map<String, TreeSet<Integer>> map = new HashMap<>();
		//3个玩家和底牌
		TreeSet<Integer> player1 = new TreeSet<>();
		TreeSet<Integer> player2 = new TreeSet<>();
		TreeSet<Integer> player3 = new TreeSet<>();
		TreeSet<Integer> diPai = new TreeSet<>();
		
		int max = list.size();
		for (int i = 0; i < max; i++) {
			if (i >= max - 3) {
				diPai.add(list.get(i));
			} else if (i % 3 == 0) {
				player1.add(list.get(i));
			} else if (i % 3 == 1) {
				player2.add(list.get(i));
			} else if (i % 3 == 2) {
				player3.add(list.get(i));
			}
		}
		
		//TreeSet自带排序功能
		map.put(KEY_PLAYER + 1, player1);
		map.put(KEY_PLAYER + 2, player2);
		map.put(KEY_PLAYER + 3, player3);
		map.put(KEY_DIPAI, diPai);
		
		return map;
	}
	
	/**
	 * 看牌
	 * 
	 * @param name
	 * @param list
	 */
	public void lookPoker(String name, TreeSet<Integer> list) {
		System.out.print(name + "的牌是：");
		for (Integer index : list) {
			System.out.print(pokerMap.get(index) + " ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		PokerExerciseDemo pokerDemo = new PokerExerciseDemo();
		pokerDemo.init();
//		pokerDemo.getPokerMap();
		List<Integer> list = pokerDemo.getList();
		// 洗牌
		Collections.shuffle(list);
		// 发牌
		Map<String, TreeSet<Integer>> map = pokerDemo.deal(list);
		// 看牌
		pokerDemo.lookPoker("玩家1", map.get(KEY_PLAYER + 1));
		pokerDemo.lookPoker("玩家2", map.get(KEY_PLAYER + 2));
		pokerDemo.lookPoker("玩家3", map.get(KEY_PLAYER + 3));
		pokerDemo.lookPoker("底牌", map.get(KEY_DIPAI));
	}
}
