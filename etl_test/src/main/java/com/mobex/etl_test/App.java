package com.mobex.etl_test;
import com.mobex.etl_lib.CribmasterFactory;
import com.mobex.etl_lib.EtlTest;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println("Running Cribmaster test");
        EtlTest cm = CribmasterFactory.createCribmaster();
        cm.test();

    }
}
