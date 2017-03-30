package tk.qcute.wegrab;


import android.content.Context;
import android.content.pm.PackageManager;

import static de.robv.android.xposed.XposedHelpers.callMethod;
import static de.robv.android.xposed.XposedHelpers.callStaticMethod;
import static de.robv.android.xposed.XposedHelpers.findClass;

public class Version {

    public static void Initialization(String packageName) throws PackageManager.NameNotFoundException{
        //filter
        if((WeChatVersion!=null && QQVersion!=null))return;
        //activity context
        Context context = (Context)callMethod(callStaticMethod(findClass("android.app.ActivityThread", null), "currentActivityThread"), "getSystemContext");
        //get wechat version name
        if (packageName.equals("com.tencent.mm")) {
            WeChatVersion = context.getPackageManager().getPackageInfo("com.tencent.mm", 0).versionName;
            setWeChatArgument(WeChatVersion);
        }
        //get qq version name
        if (packageName.equals("com.tencent.mobileqq")) {
            QQVersion = context.getPackageManager().getPackageInfo("com.tencent.mobileqq", 0).versionName;
            setQQArgument(QQVersion);
            QQ.des = new tencent.com.cftutils.DesEncUtil();
        }
    }


    //WeChat
    //version
    private static String WeChatVersion = null;

    public static String networkFunction = "vy";
    public static String networkClass = "com.tencent.mm.model.ak";

    public static String attachMessageClass = "com.tencent.mm.plugin.luckymoney.c.ae";
    public static String messageClass = "com.tencent.mm.e.b.by";
    public static String messageMethod = "b";

    private static void setWeChatArgument(String version) {
        switch (version) {
            case "6.5.4":
                networkFunction = "vy";
                networkClass = "com.tencent.mm.model.ak";
                messageClass = "com.tencent.mm.e.b.by";
                break;
            case "6.5.6":
                networkFunction = "vM";
                networkClass = "com.tencent.mm.model.al";
                messageClass = "com.tencent.mm.e.b.by";
                break;
            case "6.5.7":
                networkFunction = "vM";
                networkClass = "com.tencent.mm.model.al";
                messageClass = "com.tencent.mm.e.b.by";
                break;
            default:
                networkFunction = "vM";
                networkClass = "com.tencent.mm.model.al";
                messageClass = "com.tencent.mm.e.b.by";
        }
    }

    public static boolean isSupportWeChat(String version) {
        switch (version) {
            case "6.5.3":
            case "6.5.4":
            case "6.5.6":return true;
            default:return false;
        }
    }


    //QQ
    //version
    public static String QQVersion = null;

    public static String walletPluginClass = "com.tenpay.android.qqplugin.a.q";
    public static String pickObjectClass = "com.tenpay.android.qqplugin.c.d";
    private static void setQQArgument(String version) {
        switch (version) {
            case "6.7.0":"com.tenpay.android.qqplugin.b.d";break;
            case "6.7.1":"com.tenpay.android.qqplugin.c.d";break;
            default:break;
        }
    }

    public static boolean isSupportQQ(String version) {
        switch (version) {
            case "6.7.0":
            case "6.7.1":return true;
            default:return false;
        }
    }
}
