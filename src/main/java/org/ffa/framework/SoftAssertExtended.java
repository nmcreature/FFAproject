package org.ffa.framework;

import org.testng.asserts.Assertion;
import org.testng.asserts.IAssert;
import org.testng.collections.Maps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class SoftAssertExtended extends Assertion {

    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");

    private final Map<String, IAssert<?>> errorsMap = Maps.newLinkedHashMap();

    @Override
    protected void doAssert(IAssert<?> a) {
        onBeforeAssert(a);
        try {
            a.doAssert();
            onAssertSuccess(a);
        } catch (AssertionError ex) {
            onAssertFailure(a, ex);
            errorsMap.put(ex.getMessage() + " at line "
                    + (String.valueOf(Thread.currentThread().getStackTrace()[3].getLineNumber())), a);
            String filename = (Thread.currentThread().getStackTrace()[3].getMethodName())
                    + "_" + (String.valueOf(Thread.currentThread().getStackTrace()[3].getLineNumber())) + "_"
                    + dateFormat.format(new Date()) + ".png";
//            ScreenshotTaker.takeScreenShot(filename);
        } finally {
            onAfterAssert(a);
        }
    }

    public void assertAll() {
        if (!errorsMap.isEmpty()) {
            StringBuilder sb = new StringBuilder("The following asserts failed:");
            boolean first = true;
            for (Map.Entry<String, IAssert<?>> ae : errorsMap.entrySet()) {
                if (first) {
                    first = false;
                } else {
                    sb.append(",");
                }
                sb.append("\n\t");
                sb.append(ae.getKey());
            }
            throw new AssertionError(sb.toString());
        }
    }

}
