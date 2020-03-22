package org.javacore.pattern.chainofresponsibility;

public class SpellCheckerProcessing extends ProcessingObject<String> {
    public String handleWork(String text){
        return text.replaceAll("labda", "lambda");    //←─糟糕，我们漏掉了Lambda中的m字符
    }
}
