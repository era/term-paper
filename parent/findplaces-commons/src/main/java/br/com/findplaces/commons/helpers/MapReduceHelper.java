package br.com.findplaces.commons.helpers;

import java.util.Map;

public class MapReduceHelper {

	public static void addOrIncrease(Map<Object, Integer> map, Object key){
		if(map.containsKey(key)){
			Integer count = map.get(key);
			map.put(key, count++);
		} else {
			map.put(key,1);
		}
	}
}
