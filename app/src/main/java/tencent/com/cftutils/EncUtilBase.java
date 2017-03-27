package tencent.com.cftutils;

/**
 * Created by BALDOOR on 2016/12/7.
 */

public class EncUtilBase {
    public EncUtilBase() {
        try {
            System.load("/data/data/tk.qcute.wegrab/lib/libcftutils_v1.2.4.so");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
