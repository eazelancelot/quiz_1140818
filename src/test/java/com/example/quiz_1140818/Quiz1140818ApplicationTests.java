package com.example.quiz_1140818;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.quiz_1140818.dao.FillinDao;
import com.example.quiz_1140818.dao.QuizDao;

//@SpringBootTest
class Quiz1140818ApplicationTests {
	
	@Autowired
	private QuizDao quizDao;
	
	@Autowired
	private FillinDao fillinDao;

	@Test
	void contextLoads() {
		quizDao.deleteByIdInWithCondition(List.of(3,4,5));
	}
	
	@Test
	public void mapTest() {
		Map<String, List<Integer>> map = new HashMap<>();
		map.put("AAA", new ArrayList<>(List.of(1,2)));
		List<Integer> list = map.get("AAA");
		list.add(3);
		list = map.get("AAA");
		System.out.println("======================");
	}
	
	@Test
	public void mapTest1() {
		// 選項編號,     選項,    次數
		Map<Integer, Map<String, Integer>> codeOpCountMap = new HashMap<>();
		Map<String, Integer> opCountMap = new HashMap<>();
		opCountMap.put("紅茶", 1);
		opCountMap.put("綠茶", 1);
		codeOpCountMap.put(1, opCountMap);
		System.out.println(codeOpCountMap);
		//==========================
		// 綠茶的次數 + 1
		opCountMap = codeOpCountMap.get(1);
		int count = opCountMap.get("綠茶") + 1;
		// 更新次數的值
		opCountMap.put("綠茶", count);
		System.out.println(opCountMap);
		System.out.println(codeOpCountMap);
	}
	
	@Test
	public void mapTest2() {
		Map<String, Integer> opCountMap = new HashMap<>();
		opCountMap.put("紅茶", 1);
		opCountMap.put("綠茶", 1);
		for(String opName : opCountMap.keySet()) {
			System.out.println("key: " + opName);
			System.out.println("value: " + opCountMap.get(opName));
		}
		System.out.println("===================");
		opCountMap.forEach((opName, count) -> {
			System.out.println("key: " + opName);
			System.out.println("value: " + count);
		});
		
	}

}
