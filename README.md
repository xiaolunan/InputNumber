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
### 使用方法
#### 添加依赖
##### build.gradle
```
maven { url 'https://jitpack.io' }
```
##### add的build.gradle
```
implementation 'com.github.xiaolunan:InputNumber:1.1'
```
##### 布局中引用
```
<com.rcl.lib.inputnumber.InputNumberView
    xmlns:rcl="http://schemas.android.com/apk/res-auto"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    rcl:btnDisable="false"
    rcl:defaultNumber="5"
    rcl:numberMax="15"
    rcl:numberMin="-5"
    rcl:step="2" />
```

