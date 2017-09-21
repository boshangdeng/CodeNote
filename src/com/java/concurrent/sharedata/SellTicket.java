package com.java.concurrent.sharedata;

public class SellTicket {
	public static void main(String[] args) {
		Ticket ticket = new Ticket();
		new Thread(ticket).start();
		new Thread(ticket).start();
	}
}

class Ticket implements Runnable {
	private int ticket = 10;

	@Override
	public void run() {
		while (ticket > 0) {
			ticket--;
			System.out.println("当前票数为" + ticket);
		}
	}

}