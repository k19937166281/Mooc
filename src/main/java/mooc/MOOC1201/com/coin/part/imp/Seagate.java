package mooc.MOOC1201.com.coin.part.imp;

import mooc.MOOC1201.com.coin.part.type.Disk;

/**
 * Seagate 希捷硬盘类
 * @author Tom
 *
 */

public class Seagate extends Disk {

	public Seagate(String name, double price, int volume) {
		super(name, price, volume);
	}

	@Override
    public void work() {
		System.out.println("This is seagate disk working");
	}
	
}
