package net.fxgear;

import net.fxgear.GlobalDefine;
import org.json.JSONArray;
import org.json.JSONException;

public class ClothesSizeProvider {
    public static int CLOTHES_SIZE_MAX = 6;
    public static int CLOTHES_SIZE_MIN = 0;

    /* renamed from: a  reason: collision with root package name */
    private static final String f560a = "ClothesSizeProvider";

    /* renamed from: b  reason: collision with root package name */
    private static int f561b = 26;
    private static String c = "[[0.0, 0.35, 0.0, 0.4, 0.0, 0.22, 0.0, 0.5, 0.0, 0.5, 0.0, 0.0, 0.0, 0.2, 0.0, 0.0, 0.2, 1.0, 0.0, 0.5, 0.03, 0.0, 0.0, 0.0, 0.0, 0.1],[0.0, 0.2, 0.0, 0.2, 0.0, 0.06, 0.0, 0.33, 0.0, 0.5, 0.3, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.3, 0.0, 0.0, 0.13, 0.0, 0.0, 0.0, 0.0, 0.0],[0.0, 0.2, 0.0, 0.2, 0.0, 0.06, 0.0, 0.33, 0.0, 0.5, 0.3, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.15, 0.0, 0.23, 0.0, 0.0, 0.0, 0.2, 0.0],[0.0, 0.0, 0.0, 0.0, 0.0, 0.06, 0.0, 0.0, 0.0, 0.0, 0.5, 0.0, 0.2, 0.0, 0.2, 0.0, 0.2, 0.0, 0.3, 0.0, 0.4, 0.0, 0.2, 0.0, 0.2, 0.0],[0.0, 0.0, 0.0, 0.0, 0.0, 0.06, 0.0, 0.0, 0.0, 0.0, 0.3, 0.0, 0.2, 0.0, 0.4, 0.0, 0.35, 0.0, 0.5, 0.0, 0.63, 0.0, 0.5, 0.0, 0.3, 0.0],[0.0, 0.0, 0.0, 0.0, 0.0, 0.06, 0.0, 0.0, 0.0, 0.0, 0.1, 0.0, 0.3, 0.0, 0.6, 0.0, 0.5, 0.0, 0.8, 0.0, 0.79, 0.0, 0.7, 0.0, 0.4, 0.0],[0.0, 0.0, 0.0, 0.0, 0.0, 0.06, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.4, 0.0, 0.8, 0.0, 0.6, 0.0, 1.0, 0.0, 1.0, 0.0, 0.9, 0.0, 0.62, 0.0]]";
    private static String d = "[[0.0,  0.17,   0.0,    0.17,  0.0,     0.269, 0.0,   0.225, 0.0,   0.225, 0.0,  0.0,  0.0,  0.6, 0.0,  0.6, 0.0,   0.4, 0.0,  0.4, 0.05, 0.0, 0.0,  0.0, 0.0,  0.0],[0.0,  0.085,  0.0,    0.085, 0.0,     0.128, 0.0,   0.065, 0.0,   0.065, 0.07, 0.0,  0.0,  0.3, 0.0,  0.3, 0.0,   0.2, 0.0,  0.2, 0.15, 0.0, 0.07, 0.0, 0.07, 0.0],[0.0,  0.0,    0.0,    0.0,   0.0,     0.0,   0.0,   0.0,   0.0,   0.0,   0.13, 0.0,  0.0,  0.0, 0.0,  0.0, 0.05,  0.0, 0.05, 0.0, 0.23, 0.0, 0.13, 0.0, 0.13, 0.0],[0.07, 0.0,    0.07,   0.0,   0.142,   0.0,   0.07,  0.0,   0.07,  0.0,   0.24, 0.0,  0.19, 0.0, 0.19, 0.0, 0.2,   0.0, 0.2,  0.0, 0.42, 0.0, 0.23, 0.0, 0.23, 0.0],[0.13, 0.0,    0.13,   0.0,   0.27,    0.0,   0.13,  0.0,   0.13,  0.0,   0.39, 0.0,  0.38, 0.0, 0.38, 0.0, 0.42,  0.0, 0.42, 0.0, 0.63, 0.0, 0.39, 0.0, 0.39, 0.0],[0.205,0.0,    0.205,  0.0,   0.333,   0.0,   0.167, 0.0,   0.167, 0.0,   0.54, 0.0,  0.53, 0.0, 0.53, 0.0, 0.58,  0.0, 0.58, 0.0, 0.84, 0.0, 0.54, 0.0, 0.54, 0.0],[0.21, 0.0,    0.21,   0.0,   0.4,     0.0,   0.198, 0.0,   0.198, 0.0,   0.68, 0.0,  0.67, 0.0, 0.67, 0.0, 0.75,  0.0, 0.75, 0.0, 1.15, 0.0, 0.68, 0.0, 0.68, 0.0]]";
    private static String e = "[[0.0, 0.35, 0.0, 0.35, 0.0, 0.22, 0.0, 0.11, 0.0, 0.11, 0.0, 0.3, 0.0, 0.45, 0.0, 0.45, 0.0, 0.34, 0.0, 0.0, 0.0,  0.06, 0.0, 0.3, 0.0, 0.15],[0.0, 0.17, 0.0, 0.17, 0.0,   0.0,  0.0,   0.0,  0.0,   0.0, 0.0, 0.0, 0.0, 0.3,  0.0, 0.3,  0.0, 0.15, 0.0, 0.0, 0.06, 0.0,  0.0, 0.0, 0.0, 0.0],[0.0,   0.0,  0.0,   0.0,  0.076, 0.0,  0.056, 0.0,  0.056, 0.0, 0.0, 0.0, 0.0, 0.0,  0.0,  0.0,  0.2, 0.0,  0.0, 0.0, 0.31, 0.0,  0.2, 0.0, 0.0, 0.0],[0.061, 0.0,  0.061, 0.0,  0.15,  0.0,  0.11,  0.0,  0.11,  0.0, 0.3,  0.0, 0.25, 0.0, 0.25, 0.0,  0.5, 0.0,  0.0, 0.0, 0.54, 0.0,  0.3,  0.0, 0.3, 0.0],[0.144, 0.0,  0.144, 0.0,  0.189, 0.0,  0.11,  0.0,  0.11,  0.0, 0.44, 0.0, 0.48, 0.0, 0.48, 0.0,  0.84, 0.0, 0.0, 0.0, 0.8,  0.0,  0.44, 0.0, 0.44, 0.0],[0.185, 0.0,  0.185, 0.0,  0.225, 0.0,  0.111, 0.0,  0.111, 0.0, 0.6,  0.0, 0.7,  0.0, 0.7,  0.0,  1.14, 0.0, 0.0, 0.0, 1.02, 0.0,  0.6,  0.0, 0.6, 0.0],[0.185, 0.0,  0.185, 0.0,  0.264, 0.0,  0.111, 0.0,  0.111, 0.0, 0.7,  0.0, 1.0,  0.0, 1.0,  0.0,  1.4,  0.0, 0.0, 0.0, 1.28, 0.0,  0.7,  0.0, 0.7, 0.0]]";
    private static final int[] f = {12, 13, 16, 17, 18, 19};
    private static final int[] g = {20, 21, 22, 23};

    public static float[] GetClothesWeigthArray(int i, int i2) {
        if (i < 0 || i > 3) {
            i = 1;
        }
        String str = d;
        switch (i) {
            case 0:
                str = e;
                break;
            case 1:
                str = d;
                break;
        }
        if (i2 < CLOTHES_SIZE_MIN || i2 > CLOTHES_SIZE_MAX) {
            i2 = 2;
        }
        float[] fArr = new float[f561b];
        try {
            JSONArray jSONArray = new JSONArray(str).getJSONArray(i2);
            int i3 = 0;
            while (true) {
                if (i3 < jSONArray.length()) {
                    if (i3 < f561b) {
                        float f2 = (float) jSONArray.getDouble(i3);
                        if (f2 < GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
                            f2 = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
                        } else if (f2 > 1.0f) {
                            f2 = 1.0f;
                        }
                        fArr[i3] = f2;
                        i3++;
                    }
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return fArr;
    }

    public static GlobalDefine.ClothesSize GetClosestClothSize(int i, int i2, int i3, boolean z) {
        boolean z2 = false;
        int i4 = i == 2 ? i2 == 1 ? 2 : 0 : (i == 1 && i2 == 1) ? 3 : 1;
        if (i3 != 1) {
            z2 = true;
        }
        int GetClosestClothSize = GetClosestClothSize(i4, AvatarSetting.a(), z2, z);
        if (GetClosestClothSize < 0 || GetClosestClothSize >= GlobalDefine.ClothesSize.values().length) {
            return null;
        }
        return GlobalDefine.ClothesSize.values()[GetClosestClothSize];
    }

    public static int GetClosestClothSize(int i, float[] fArr, boolean z, boolean z2) {
        int[] iArr;
        if (z) {
            iArr = f;
        } else {
            iArr = g;
        }
        int i2 = -1;
        int i3 = -1;
        float f2 = 100000.0f;
        float f3 = 200000.0f;
        for (int i4 = CLOTHES_SIZE_MIN; i4 <= CLOTHES_SIZE_MAX; i4++) {
            float f4 = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            int i5 = i;
            float[] GetClothesWeigthArray = GetClothesWeigthArray(i, i4);
            int i6 = 0;
            while (i6 < iArr.length) {
                double d2 = (double) f4;
                double pow = Math.pow((double) (fArr[iArr[i6]] - GetClothesWeigthArray[iArr[i6]]), 2.0d);
                Double.isNaN(d2);
                f4 = (float) (d2 + pow);
                i6++;
                int i7 = i;
            }
            if (f4 < f2) {
                i2 = i3;
                f3 = f2;
                i3 = i4;
                f2 = f4;
            } else if (f4 < f3) {
                i2 = i4;
                f3 = f4;
            }
        }
        return z2 ? i2 : i3;
    }
}
