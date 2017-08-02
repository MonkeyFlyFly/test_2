package com.cassca.thread;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
public class ThreadA implements Runnable{
//	private Map<Object,Object> map = new HashMap();
	private ConcurrentMap<Object,Object> map = new ConcurrentHashMap();
	private Object key;
	private Object value;
	private static int i = 0;
	private ThreadA() {
	}
	public ThreadA(Object key,Object value){
		this.key=key;
		this.value=value;
	}
	@Override
	public void run() {
		while(i<10){
			try {
				Thread.sleep(1000);
				if(map.get(key.toString()+i)==null){
					Object exist = map.putIfAbsent(key.toString()+i, value.toString()+i);
					if(exist!=null){
						System.out.println("----------->"+exist);
					}
				}
//				System.out.println(exist+"--------->putIfAbsent");
			} catch (InterruptedException e) {
			}
			i++;
		}
		
		
		Iterator it= map.entrySet().iterator();
		while(it.hasNext()){
			Entry obj =(Entry) it.next();
			System.out.println(obj.getKey()+"------"+obj.getValue());
			
		}
	}
	

}
