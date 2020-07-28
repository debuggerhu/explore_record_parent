package com.hhx.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author huhaixaing
 * @date 2020/7/28 14:12
 * @Description: PACKAGE_NAME
 */
public class StreamTest {

    public static void main(String[] args) {

        System.out.println(getString());
    }

    private static String getString() {
        listLink().stream();
        String target="aa";
        Map<String, String> map = listLink().stream().collect(Collectors.toMap(Link::getName, Link::getPath));
        List<String> targets = listLink().stream().map(Link::getName).collect(Collectors.toList());
        //模拟链接跳转的方法,匹配不到就抛异常
        if (!targets.contains(target)){
            throw new RuntimeException("no found the target in targets");
        }
        return map.get(target);
    }


    public static ArrayList<Link> listLink() {
       ArrayList<Link> list = new ArrayList<Link>();
       list.add(new Link("aaa","/aaa/",""));
       list.add(new Link("bbb","/bbb/",""));
       list.add(new Link("ccc","/ccc/",""));
       return list;
   }
}
