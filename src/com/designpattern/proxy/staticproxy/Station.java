package com.designpattern.proxy.staticproxy;

/**
 * ≥µ’æ
 * 
 * @author wangbo
 *
 */
public class Station implements TicketService {

	@Override
	public void sellTicket() {
		System.out.println("\n\t €∆±.....\n");
	}

	@Override
	public void inquire() {
		System.out.println("\n\tŒ —Ø......\n");
	}

	@Override
	public void withdraw() {
		System.out.println("\n\tÕÀ∆±......\n");
	}

}
