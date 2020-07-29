package com.hhx.polymorphism;

/**
 * @author huhaixaing
 * @date 2020/7/29 14:51
 * @Description: com.hhx.polymorphism
 */

/**
 * #总结:
 * #1.当父类只有含参构造方法时,子类必须(在子类的第一行)调用父类的有参构造(不用super调用父类的含参构造的话,编译器会报错);
 * ![](https://img2020.cnblogs.com/blog/1771591/202007/1771591-20200729163427245-1115519799.png)
 * #2.当父类同时含有有参和空参构造时:
 * #2.1子类可以主动有且仅可任意(在子类的第一行)调用父类一个构造方法;
 * ![](https://img2020.cnblogs.com/blog/1771591/202007/1771591-20200729163858344-428077613.png)
 * #2.1.1子类可以(在子类的第一行)主动调用父类的含参构造
 * ![](https://img2020.cnblogs.com/blog/1771591/202007/1771591-20200729163639590-153926641.png)
 * #2.1.2子类也可以主动(在子类的第一行)调用父类的无参构造
 * ![](https://img2020.cnblogs.com/blog/1771591/202007/1771591-20200729163904796-1941948776.png)
 * #2.2若子类未主动(在子类的第一行)调用父类的任意一个构造方法,系统会默认调用父类的无参构造
 * ![](https://img2020.cnblogs.com/blog/1771591/202007/1771591-20200729164741574-999343285.png)
 */
class A {
    public A(){
        System.out.println("A");
    }
}
public class B extends A{

    public  B(){
        super();
        System.out.println("B");
    }

    public static void main(String[] args) {
        A a = new B();
          a = new A();
    }
}
