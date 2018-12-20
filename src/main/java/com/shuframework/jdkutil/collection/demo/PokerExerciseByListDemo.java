package com.shuframework.jdkutil.collection.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 模拟斗地主洗牌和发牌 (只用List)
 * 	牌是拼接好的字符串 (发牌分配的是字符串, 看牌也是字符串)
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
public class PokerExerciseByListDemo {
	
	private static final String KEY_PLAYER = "player";
	private static final String KEY_DIPAI = "diPai";
	
	
	/**
	 * 创建一个牌盒, 且装牌, 形成一幅牌
	 * 
	 * @return
	 */
	public static List<String> init() {
		// 创建一个牌盒
		List<String> list = new ArrayList<String>();

		// 装牌
		// 黑桃A,黑桃2,黑桃3,...黑桃K
		// 红桃A,...
		// 梅花A,...
		// 方块A,...
		// 定义一个花色数组
		String[] colors = { "♠", "♥", "♣", "♦" };
		// 定义一个点数数组
		String[] numbers = { "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2" };
		// 装牌
		for (String number : numbers) {
			for (String color : colors) {
				list.add(color.concat(number));
			}
		}
		list.add("小王");
		list.add("大王");
		
		return list;
	}
	
	/**
	 * 发牌
	 * 
	 * @param list
	 * @return
	 */
	public static Map<String, List<String>> deal(List<String> list) {
		Map<String, List<String>> map = new HashMap<>();
		//3个玩家和底牌
		List<String> player1 = new ArrayList<String>();
		List<String> player2 = new ArrayList<String>();
		List<String> player3 = new ArrayList<String>();
		List<String> diPai = new ArrayList<String>();
		
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
		
		//排序, 其实是对牌盒进行排序（这个排序不准）
//		Collections.sort(player1);
//		Collections.sort(player2);
//		Collections.sort(player3);
//		Collections.sort(diPai);
		
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
	public static void lookPoker(String name, List<String> list) {
		System.out.print(name + "的牌是：");
		for (String s : list) {
			System.out.print(s + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		//创建一幅牌
		List<String> list = init();
		// 洗牌
		Collections.shuffle(list);
		// 发牌
		Map<String, List<String>> map = deal(list);
		// 看牌
		lookPoker("玩家1", map.get(KEY_PLAYER + 1));
		lookPoker("玩家2", map.get(KEY_PLAYER + 2));
		lookPoker("玩家3", map.get(KEY_PLAYER + 3));
		lookPoker("底牌", map.get(KEY_DIPAI));
	}

}
