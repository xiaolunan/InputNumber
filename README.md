自定义组合控件InputNumber
=======================
# InputNumber
##### 效果图
![](https://github.com/xiaolunan/InputNumber/blob/master/file/number.png)  
##### 属性介绍 attrs.xml
```
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <declare-styleable name="InputNumberView">
        <!--最小值-->
        <attr name="numberMin" format="integer" />
        <!--最大值-->
        <attr name="numberMax" format="integer" />
        <!--默认值-->
        <attr name="defaultNumber" format="integer" />
        <!--禁用-->
        <attr name="btnDisable" format="boolean" />
        <!--step 增加减少的间隔数-->
        <attr name="step" format="integer" />
    </declare-styleable>
</resources>
```
