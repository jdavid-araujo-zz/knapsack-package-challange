import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import exception.APIException;
import model.Item;
import model.Package;
import packer.Packer;

public class PackerTest {

	private String path = "src\\test\\resources\\input-sample1.txt";
	private String path1 = "src\\test\\resources\\input-sample2.txt";
	private String path3 = "src\\test\\resources\\input-sample3.txt";
	private String path4 = "src\\test\\resources\\input-sample4.txt";
	private String path5 = "src\\test\\resources\\input-sample5.txt";
	
	private String mockIndexResultOutput() {
		String result = "4\n" 	+
						"-\n" 	+
						"2,7\n" +
						"8,9\n";
		
		return result;
	}

	
	@Test
	public void getIndexSucess() throws APIException {
		String result = Packer.pack(path);
				
		assertEquals(mockIndexResultOutput(), result);
		
	}
	
	@Test()
	public void makeExceptionWhenItemWeightMoreThan100() {
        Exception exception = assertThrows(
			APIException.class, 
			() -> Packer.pack(path1));
			
        assertTrue((exception.getMessage().equals("Max weight of an item is ≤ 100")));
	}
	
	
	@Test()
	public void makeExceptionWhenItemCostMoreThan100() {
        Exception exception = assertThrows(
			APIException.class, 
			() -> Packer.pack(path3));
			
        assertTrue((exception.getMessage().equals("Max cost of an item is ≤ 100")));
	}
	
	@Test()
	public void makeExceptionWhenPackageWightMoreThan100() {
        Exception exception = assertThrows(
			APIException.class, 
			() -> Packer.pack(path4));
			
        assertTrue((exception.getMessage().equals("Max weight that a package can take is ≤ 100")));
	}
	
	@Test()
	public void makeExceptionWhenItemsMoreThan15() {
        Exception exception = assertThrows(
			APIException.class, 
			() -> Packer.pack(path5));
			
        assertTrue((exception.getMessage().equals("There might be up to 15 items you need to choose from")));
	}
}
