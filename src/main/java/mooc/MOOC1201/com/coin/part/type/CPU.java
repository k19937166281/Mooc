package mooc.MOOC1201.com.coin.part.type;

import mooc.MOOC1201.com.coin.concept.Component;
import mooc.MOOC1201.com.coin.concept.Workable;

/**
 * CPU  CPU的抽象定义，继承自Component，实现Workable
 * @author Tom
 *
 */
public abstract class CPU extends Component implements Workable {
	
	protected int coreNum;
	
	public CPU(String name, int coreNum, double price) {
		super(name, price);
		this.coreNum = coreNum;
	}
	
	@Override
	public String description() {
		StringBuilder cpuDescBuilder = new StringBuilder();
		cpuDescBuilder.append(super.description())
			.append(" Core Num:{")
			.append(coreNum)
			.append("}");
		return cpuDescBuilder.toString();
	}
	
}
