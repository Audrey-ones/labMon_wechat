package com.sery.labmon.service;

import com.sun.jna.Library;
import com.sun.jna.Native;

public class TestDll {

    public interface TscLibDll extends Library {
        TscLibDll INSTANCE = (TscLibDll) Native.loadLibrary ("RemoteClient", TscLibDll.class);
        /*testDLL INSTANCE = (testDLL) Native.loadLibrary ("RemoteClient", testDLL.class);*/
        void InitRemoting();
        int GetState();

    }

    public static void TestDllImpl (){
        TscLibDll.INSTANCE.InitRemoting();
        TscLibDll.INSTANCE.GetState();
    }

    public static void main(String[] args) {
        if (TscLibDll.INSTANCE == null){
            System.out.println("null");
        }else {
            System.out.println(TscLibDll.INSTANCE.getClass());

        }
        //TestDllImpl();
        //System.out.println(TscLibDll.INSTANCE.GetState());
    }


}
