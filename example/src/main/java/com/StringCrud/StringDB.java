package com.StringCrud;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

abstract class StringDB {

	private final AtomicInteger count = new AtomicInteger(0);
	protected Map<Integer, String> map;

	{
		try {
			map = SaveLoad.getProperties();//получение строк из файла
			assert map != null;
			count.getAndSet(map.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected boolean insert(String val) {
		if("".equals(val))
			return false;
		map.put(count.getAndIncrement(), val);
		return true;
	}

	protected boolean update(String val, int id) {
		if (!map.containsKey(id)) {
			return false;
		} else {
			map.put(id, val);
			return true;
		}
	}

	protected boolean remove(int id) {
		if (!map.containsKey(id)) {
			return false;
		} else {
			count.getAndDecrement();
			for (int i = id; i < count.get(); i++) {
				map.put(i, map.get(i + 1));
			}
		}
		return true;
	}

	protected String get(int id) {
		if (id >= 0) {
			return id + "-" + map.get(id);
		}
		StringBuilder rasault = new StringBuilder();
		for (int i = 0; i < count.get(); i++) {
			rasault.append(" ").append(i).append("-").append(map.get(i));
		}
		return rasault.toString();
	}
}
