package org.javacore.io.test.nio;
/**
 * ���Է���
 * @author yangtao__anxpp.com
 * @version 1.0
 */
public class Test {
	//����������
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception{
		//服务端
		Server.start();
		//����ͻ������ڷ���������ǰִ�д���
		Thread.sleep(100);
		//客户端
		Client.start();
		while (true){
		    Client.sendMsg("222");
        }
//		while(Client.sendMsg(new Scanner(System.in).nextLine()));
	}
}
