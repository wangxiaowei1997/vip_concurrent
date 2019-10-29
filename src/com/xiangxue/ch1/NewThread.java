package com.xiangxue.ch1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *@author Mark老师   享学课堂 https://enjoy.ke.qq.com 
 *
 *类说明：如何新建线程
 */
public class NewThread {
	/*扩展自Thread类*/
	
	/*实现Runnable接口*/
	private static class UseRun implements Runnable{

		@Override
		public void run() {
			System.out.println("I am implements Runnable");
		}
		
	}
	
	/*实现Callable接口，允许有返回值*/
	private static class UseCall implements Callable<String>{

		@Override
		public String call() throws Exception {
			Thread.sleep(1000);
			System.out.println("I am implements Callable");
			return "CallResult:小宝贝";
		}
		
	}	
	
	public static void main(String[] args) 
			throws InterruptedException, ExecutionException {
		
		UseRun useRun = new UseRun();
		new Thread(useRun).start();
		Thread t = new Thread(useRun);
		//这里向上面的线程发出中断信号,是否中断由线程自己决定
		t.interrupt();
		
		UseCall useCall = new UseCall();
		FutureTask<String> futureTask = new FutureTask<>(useCall);
		new Thread(futureTask).start();
		System.out.println(futureTask.get());
	}
}
