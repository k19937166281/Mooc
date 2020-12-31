package mooc.MOOC1201.com.coin.product;

import mooc.MOOC1201.com.coin.concept.Component;
import mooc.MOOC1201.com.coin.concept.Workable;
import mooc.MOOC1201.com.coin.part.type.CPU;
import mooc.MOOC1201.com.coin.part.type.Disk;


/**
 * Computer 矿机类
 * @author Tom
 *
 */
public class Computer extends Component implements Workable {

	private CPU cpu;
	private Disk disk;
	
	public Computer(String name, CPU cpu, Disk disk){
		super(name, -1);
		this.cpu = cpu;
		this.disk = disk;
		super.setPrice(cpu.getPrice() + disk.getPrice());
	}
	
	/**
	 * work() 定义Computer中各个部件的执行顺序
	 */
	@Override
    public void work() {
		cpu.work();
		disk.work();
	}

	@Override
    public String description() {
		StringBuilder cmputerDescBuilder = new StringBuilder();
		cmputerDescBuilder.append(super.description())
			.append("CPU description: {")
			.append(cpu.description())
			.append("}")
			.append("; Disk descripton: {")
			.append(disk.description())
			.append("}");
		return cmputerDescBuilder.toString();
		
	}
}
