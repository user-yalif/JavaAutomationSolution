package org.alifanov.utility;

import java.util.Collections;
import java.util.List;

public class ArayListsHelper {
	
	public static <T extends Comparable<T>> List<T> sortAscending(List<T> list){
		Collections.sort(list);
		return list;
	}
}
