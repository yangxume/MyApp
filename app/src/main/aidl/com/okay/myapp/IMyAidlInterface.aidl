// IMyAidlInterface.aidl
package com.okay.myapp;
import com.okay.myapp.bean.IMyCallbackListener;
// Declare any non-default types here with import statements

interface IMyAidlInterface {

   void testMethod(String str);
   void resisterListener(IMyCallbackListener listener);
   void unResisterListener(IMyCallbackListener listener);

}
