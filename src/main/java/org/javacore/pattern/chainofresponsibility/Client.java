package org.javacore.pattern.chainofresponsibility;

import java.util.function.Function;
import java.util.function.UnaryOperator;

class Client {
	public static void main(String[] args) {
//		Approver wjzhang,gyang,jguo,meeting;
//		wjzhang = new Director("张无忌");
//		gyang = new VicePresident("杨过");
//		jguo = new President("郭靖");
//		meeting = new Congress("董事会");
//
//		//创建职责链
//        wjzhang.setSuccessor(gyang);
//        gyang.setSuccessor(jguo);
//        jguo.setSuccessor(meeting);
//
//		//创建采购单
//		PurchaseRequest pr1 = new PurchaseRequest(45000,10001,"购买倚天剑");
//		wjzhang.processRequest(pr1);
//
//		PurchaseRequest pr2 = new PurchaseRequest(60000,10002,"购买《葵花宝典》");
//		wjzhang.processRequest(pr2);
//
//		PurchaseRequest pr3 = new PurchaseRequest(160000,10003,"购买《金刚经》");
//		wjzhang.processRequest(pr3);
//
//		PurchaseRequest pr4 = new PurchaseRequest(800000,10004,"购买桃花岛");
//		wjzhang.processRequest(pr4);
//        ProcessingObject<String> p1 = new HeaderTextProcessing();
//        ProcessingObject<String> p2 = new SpellCheckerProcessing();
//
//        p1.setSuccessor(p2);                               //←─将两个处理对象链接起来
//
//        String result = p1.handle("Aren't labdas really sexy?!!");
//        System.out.println(result);
//        Function<String, String> function = (String text) -> "" + text;
        UnaryOperator<String> headerProcessing =
            (String text) -> "From Raoul, Mario and Alan: " + text;    //←─第一个处理对象

        UnaryOperator<String> spellCheckerProcessing =
            (String text) -> text.replaceAll("labda", "lambda");   // ←─第二个处理对象

        Function<String, String> pipeline =
            headerProcessing.andThen(spellCheckerProcessing);   // ←─将两个方法结合起来，结果就是一个操作链

        String result = pipeline.apply("Aren't labdas really sexy?!!");
        System.out.println(result);
    }
}
