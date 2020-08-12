package test.study;

import sun.misc.ProxyGenerator;
import test.study.bean.TestService;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @program: spring
 * @ClassName studyProxyTest
 * @description:$
 * @author: 李杰
 * @create: 2020-08-12 15:12
 * @Version 1.0
 **/

public class studyProxyTest {
	/**最终生成的字节码文件是class LiJieProxy extends Proxy implements IFoxDao ,不是FoxDao类型的*/
	public static void main(String[] args) {
		byte[] $Proxy0s = ProxyGenerator.generateProxyClass("LiJieProxy", new Class[]{TestService.class});
		OutputStream outputStream=null;
		try {
			outputStream=new FileOutputStream("LiJieProxy.class");
			outputStream.write($Proxy0s);
			outputStream.flush();
			outputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}