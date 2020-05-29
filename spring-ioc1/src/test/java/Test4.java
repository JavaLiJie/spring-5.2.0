import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: spring
 * @ClassName Test4
 * @description:$
 * @author: 李杰
 * @create: 2020-05-27 20:41
 * @Version 1.0
 **/

public class Test4 {

	@Test
	public static void main(String[] args) {
		test();
	}

	private static void test() {
		/*try {
			System.out.println(1/0);
		}catch (Exception e){
			throw new RuntimeException(e);
		}
		System.out.println("异常之后的事");*/
		Map<String,String> map1=new HashMap<>();
		Map<String,String> map2=new HashMap<>();
		map1.put("k1","v1");
		map1.put("k2","v2");
		map1.put("k3","v3");
		map2.putAll(map1);
		//map2.put("k4","v4");
		map2.forEach((k,v)->{
			System.out.println(k+"******"+v);
		});
	}

}
