package com.xyy;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println(String.class.getClassLoader());
        System.out.println(App.class.getClassLoader());
        System.out.println(App.class.getClassLoader().getParent());
    }
}
