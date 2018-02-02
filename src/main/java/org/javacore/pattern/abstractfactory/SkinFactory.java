package org.javacore.pattern.abstractfactory;

//界面皮肤工厂接口：抽象工厂
interface SkinFactory {
     Button createButton();
     TextField createTextField();
     ComboBox createComboBox();
}
