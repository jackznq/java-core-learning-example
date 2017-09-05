package org.javacore.pattern.decorator;

//文本框类：具体构件类
class TextBox implements Component
{
       public  void display()
       {
              System.out.println("显示文本框！");
       }
}
