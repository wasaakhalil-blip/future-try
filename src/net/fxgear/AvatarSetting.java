package net.fxgear;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import net.fxgear.util.Matrix;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AvatarSetting {
    public static final int BODY_PART_ARM_CIRCUMFERENCE = 10;
    public static final int BODY_PART_ARM_LENGTH = 2;
    public static final int BODY_PART_BUST_CIRCUMFERENCE = 7;
    public static final int BODY_PART_CALF_LENGTH = 4;
    public static final int BODY_PART_CUP_SIZE = 8;
    public static final int BODY_PART_HEAD_HEIGHT = 14;
    public static final int BODY_PART_HIP_CIRCUMFERENCE = 11;
    public static final int BODY_PART_LOWER_BODY_SIZE = 6;
    public static final int BODY_PART_NONE = -1;
    public static final int BODY_PART_SHOULDER_LENGTH = 1;
    public static final int BODY_PART_TALL_LENGTH = 0;
    public static final int BODY_PART_THIGH_CIRCUMFERENCE = 12;
    public static final int BODY_PART_THIGH_LENGTH = 3;
    public static final int BODY_PART_UPPER_BODY_SIZE = 5;
    public static final int BODY_PART_WAIST_CIRCUMFERENCE = 9;
    public static final double HEAD_DEFAULT_HEIGHT = 20.0d;
    public static float NO_VALUE = -1.0f;

    /* renamed from: a  reason: collision with root package name */
    static final String f544a = "AvatarSetting";

    /* renamed from: b  reason: collision with root package name */
    private static Context f545b = null;
    private static double c = 20.0d;
    private static double[] d = new double[26];
    private static double[] e = new double[18];
    private static int f = -1;
    private static int g = -1;
    private static double h = ((double) NO_VALUE);
    private static double i = ((double) NO_VALUE);
    private static ArrayList<b> j = null;
    private static b k = null;
    /* access modifiers changed from: private */
    public static final String[] l = {"XXS", "XS", "S", "M", "L", "XL", "XXL"};
    /* access modifiers changed from: private */
    public static final int[] m = {13, 6, 9, 14, 15, 16, 17};
    private static final int[] n = {0, 1, 2, 3, 4};
    private static final int[] o = {5, 6};
    /* access modifiers changed from: private */
    public static final int[] p = {13, 6, 14, 15, 16, 17};
    private static final int[] q = {0, 1, 2, 3};
    private static final int[] r = {4, 5};

    public static class HairTypeFilesInfo {

        /* renamed from: a  reason: collision with root package name */
        int f546a;

        /* renamed from: b  reason: collision with root package name */
        File f547b;
        File c;
        File d;
        File e;
        File f;
        File g;
        File h;
        TypeResource i;
        c j;
        a k;
        public int mTypeID;
    }

    public static class HeadTypeFilesInfo {

        /* renamed from: a  reason: collision with root package name */
        int f548a;

        /* renamed from: b  reason: collision with root package name */
        File f549b;
        File c;
        TypeResource d;
        public int mTypeID;
    }

    public static class TypeResource {
        public String mDescriptionText;
        public String mNormalThumbnailPath;
        public String mSelectedThumbnailPath;
    }

    static double a(double d2, double d3, double d4) {
        return (d2 - d3) / (d4 - d3);
    }

    private static int a(int i2, int i3) {
        return ((i2 - 1) * 3) + (i3 - 1);
    }

    static double b(double d2, double d3, double d4) {
        return (d2 * (d4 - d3)) + d3;
    }

    private static double c(double d2, double d3, double d4) {
        return (d2 * (d4 - d3)) + d3;
    }

    private double d(double d2, double d3, double d4) {
        return (d2 * (d4 - d3)) + d3;
    }

    static class c {

        /* renamed from: a  reason: collision with root package name */
        int f558a;

        /* renamed from: b  reason: collision with root package name */
        float f559b;
        float c;
        float d;
        float e;
        float f;
        public float[] g;
        public float[] h;
        public float[] i;

        c() {
        }
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        File f550a;

        /* renamed from: b  reason: collision with root package name */
        c f551b;

        a() {
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        public ArrayList<HeadTypeFilesInfo> f552a = new ArrayList<>();

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<HairTypeFilesInfo> f553b = new ArrayList<>();
        /* access modifiers changed from: private */
        public a[] c = new a[18];
        /* access modifiers changed from: private */
        public double d;
        /* access modifiers changed from: private */
        public double e;
        /* access modifiers changed from: private */
        public double f;
        /* access modifiers changed from: private */
        public ArrayList<String> g;
        /* access modifiers changed from: private */
        public Matrix h;
        /* access modifiers changed from: private */
        public Matrix i;

        private int a(int i2) {
            switch (i2) {
                case 10:
                case 11:
                    return 5;
                case 12:
                case GlobalDefine.RESULT_CODE_ERROR_MALFORMEDURL:
                    return 6;
                case 14:
                case GlobalDefine.RESULT_CODE_ERROR_OUT_OF_MEMORY:
                    return 13;
                case GlobalDefine.RESULT_CODE_ERROR_NOT_FOUND_FILE:
                case GlobalDefine.RESULT_CODE_ERROR_FAILED_TO_SAVE_BITMAP:
                    return 14;
                case GlobalDefine.RESULT_CODE_ERROR_FAILED_TO_DETECT:
                case GlobalDefine.RESULT_CODE_ERROR_FAILED_TO_DETECT_WITH_LOW_SCROE:
                    return 9;
                case GlobalDefine.RESULT_CODE_ERROR_FAILED_TO_DETECT_ZERO_FACE:
                case 21:
                    return 15;
                case 22:
                case 23:
                    return 16;
                case 24:
                case 25:
                    return 17;
                default:
                    return 0;
            }
        }

        /* access modifiers changed from: private */
        public int a(int i2, boolean z) {
            if (i2 == 9) {
                return z ? 18 : 19;
            }
            switch (i2) {
                case 5:
                    return z ? 10 : 11;
                case 6:
                    return z ? 12 : 13;
                default:
                    switch (i2) {
                        case GlobalDefine.RESULT_CODE_ERROR_MALFORMEDURL:
                            return z ? 14 : 15;
                        case 14:
                            return z ? 16 : 17;
                        case GlobalDefine.RESULT_CODE_ERROR_OUT_OF_MEMORY:
                            return z ? 20 : 21;
                        case GlobalDefine.RESULT_CODE_ERROR_NOT_FOUND_FILE:
                            return z ? 22 : 23;
                        case GlobalDefine.RESULT_CODE_ERROR_FAILED_TO_SAVE_BITMAP:
                            return z ? 24 : 25;
                        default:
                            return -1;
                    }
            }
        }

        private class a {

            /* renamed from: a  reason: collision with root package name */
            int[] f556a;

            /* renamed from: b  reason: collision with root package name */
            double[] f557b;
            double[] c;
            double d;
            double[] e;

            private a() {
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:69:0x0340 A[SYNTHETIC, Splitter:B:69:0x0340] */
        /* JADX WARNING: Removed duplicated region for block: B:75:0x034a A[SYNTHETIC, Splitter:B:75:0x034a] */
        /* JADX WARNING: Removed duplicated region for block: B:81:0x0354 A[SYNTHETIC, Splitter:B:81:0x0354] */
        /* JADX WARNING: Removed duplicated region for block: B:86:0x035f A[SYNTHETIC, Splitter:B:86:0x035f] */
        /* JADX WARNING: Removed duplicated region for block: B:94:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:72:0x0345=Splitter:B:72:0x0345, B:66:0x033b=Splitter:B:66:0x033b, B:78:0x034f=Splitter:B:78:0x034f} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public b(android.content.Context r13, int r14, int r15) {
            /*
                r12 = this;
                r12.<init>()
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                r12.f552a = r0
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                r12.f553b = r0
                r0 = 18
                net.fxgear.AvatarSetting$b$a[] r0 = new net.fxgear.AvatarSetting.b.a[r0]
                r12.c = r0
                r0 = 0
                r12.h = r0
                r12.i = r0
                r1 = 2
                r2 = 1
                if (r14 != r1) goto L_0x0028
                if (r15 != r2) goto L_0x0025
                java.lang.String r3 = "Boy"
                goto L_0x002f
            L_0x0025:
                java.lang.String r3 = "Man"
                goto L_0x002f
            L_0x0028:
                if (r15 != r2) goto L_0x002d
                java.lang.String r3 = "Girl"
                goto L_0x002f
            L_0x002d:
                java.lang.String r3 = "Woman"
            L_0x002f:
                java.lang.String r4 = net.fxgear.AvatarSetting.f544a
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = "genderDirectoryName "
                r5.append(r6)
                r5.append(r3)
                java.lang.String r5 = r5.toString()
                android.util.Log.i(r4, r5)
                java.io.File r4 = net.fxgear.GlobalDefine.GetAvatarDirectory(r13)
                java.io.File r5 = new java.io.File
                java.lang.String r6 = "%s/%s"
                java.lang.Object[] r7 = new java.lang.Object[r1]
                java.io.File r8 = r4.getAbsoluteFile()
                r9 = 0
                r7[r9] = r8
                r7[r2] = r3
                java.lang.String r6 = java.lang.String.format(r6, r7)
                java.lang.String r7 = "Head"
                r5.<init>(r6, r7)
                boolean r6 = r5.exists()
                if (r6 == 0) goto L_0x009a
                boolean r6 = r5.isDirectory()
                if (r6 == 0) goto L_0x009a
                r12.a((android.content.Context) r13, (java.io.File) r5)
                java.util.ArrayList<net.fxgear.AvatarSetting$HeadTypeFilesInfo> r5 = r12.f552a
                int r5 = r5.size()
                if (r5 != 0) goto L_0x00bb
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = "Not exist head datas.(gender : "
                r5.append(r6)
                r5.append(r14)
                java.lang.String r6 = ", age : "
                r5.append(r6)
                r5.append(r15)
                java.lang.String r6 = ")"
                r5.append(r6)
                java.lang.String r5 = r5.toString()
                net.fxgear.util.FXUtil.OccurRunTimeException((java.lang.String) r5)
                goto L_0x00bb
            L_0x009a:
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = "Not exist head data directory.(gender : "
                r5.append(r6)
                r5.append(r14)
                java.lang.String r6 = ", age : "
                r5.append(r6)
                r5.append(r15)
                java.lang.String r6 = ")"
                r5.append(r6)
                java.lang.String r5 = r5.toString()
                net.fxgear.util.FXUtil.OccurRunTimeException((java.lang.String) r5)
            L_0x00bb:
                java.io.File r5 = new java.io.File
                java.lang.String r6 = "%s/%s"
                java.lang.Object[] r7 = new java.lang.Object[r1]
                java.io.File r8 = r4.getAbsoluteFile()
                r7[r9] = r8
                r7[r2] = r3
                java.lang.String r6 = java.lang.String.format(r6, r7)
                java.lang.String r7 = "Hair"
                r5.<init>(r6, r7)
                boolean r6 = r5.exists()
                if (r6 == 0) goto L_0x010b
                boolean r6 = r5.isDirectory()
                if (r6 == 0) goto L_0x010b
                r12.b(r13, r5)
                java.util.ArrayList<net.fxgear.AvatarSetting$HairTypeFilesInfo> r13 = r12.f553b
                int r13 = r13.size()
                if (r13 != 0) goto L_0x012c
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>()
                java.lang.String r5 = "Not exist hair datas.(gender : "
                r13.append(r5)
                r13.append(r14)
                java.lang.String r5 = ", age : "
                r13.append(r5)
                r13.append(r15)
                java.lang.String r5 = ")"
                r13.append(r5)
                java.lang.String r13 = r13.toString()
                net.fxgear.util.FXUtil.OccurRunTimeException((java.lang.String) r13)
                goto L_0x012c
            L_0x010b:
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>()
                java.lang.String r5 = "Not exist hair data directory.(gender : "
                r13.append(r5)
                r13.append(r14)
                java.lang.String r5 = ", age : "
                r13.append(r5)
                r13.append(r15)
                java.lang.String r5 = ")"
                r13.append(r5)
                java.lang.String r13 = r13.toString()
                net.fxgear.util.FXUtil.OccurRunTimeException((java.lang.String) r13)
            L_0x012c:
                r13 = 3
                if (r15 != r2) goto L_0x014d
                java.io.File r3 = new java.io.File
                java.lang.String r5 = "%s/%s/%s"
                java.lang.Object[] r6 = new java.lang.Object[r13]
                java.io.File r4 = r4.getAbsoluteFile()
                r6[r9] = r4
                java.lang.String r4 = "Common"
                r6[r2] = r4
                java.lang.String r4 = "Kids"
                r6[r1] = r4
                java.lang.String r4 = java.lang.String.format(r5, r6)
                java.lang.String r5 = "Body"
                r3.<init>(r4, r5)
                goto L_0x0165
            L_0x014d:
                java.io.File r5 = new java.io.File
                java.lang.String r6 = "%s/%s"
                java.lang.Object[] r7 = new java.lang.Object[r1]
                java.io.File r4 = r4.getAbsoluteFile()
                r7[r9] = r4
                r7[r2] = r3
                java.lang.String r3 = java.lang.String.format(r6, r7)
                java.lang.String r4 = "Body"
                r5.<init>(r3, r4)
                r3 = r5
            L_0x0165:
                java.io.File r4 = new java.io.File
                java.lang.String r5 = "ControlAttributes.txt"
                r4.<init>(r3, r5)
                boolean r3 = r4.exists()
                if (r3 == 0) goto L_0x0368
                boolean r3 = r4.isFile()
                if (r3 == 0) goto L_0x0368
                long r5 = r4.length()
                int r3 = (int) r5
                byte[] r3 = new byte[r3]
                java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x034e, IOException -> 0x0344, JSONException -> 0x033a }
                r5.<init>(r4)     // Catch:{ FileNotFoundException -> 0x034e, IOException -> 0x0344, JSONException -> 0x033a }
                r5.read(r3)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                java.lang.String r0 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r0.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r3.<init>(r0)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                net.fxgear.AvatarSetting$b$a[] r0 = r12.c     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                java.lang.String r4 = "elbow_to_wrist"
                org.json.JSONObject r4 = r3.getJSONObject(r4)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                net.fxgear.AvatarSetting$b$a r4 = r12.a((org.json.JSONObject) r4)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r0[r9] = r4     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                net.fxgear.AvatarSetting$b$a[] r0 = r12.c     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                java.lang.String r4 = "shoulder_to_elbow"
                org.json.JSONObject r4 = r3.getJSONObject(r4)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                net.fxgear.AvatarSetting$b$a r4 = r12.a((org.json.JSONObject) r4)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r0[r2] = r4     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                net.fxgear.AvatarSetting$b$a[] r0 = r12.c     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                java.lang.String r4 = "neck_to_hip_center"
                org.json.JSONObject r4 = r3.getJSONObject(r4)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                net.fxgear.AvatarSetting$b$a r4 = r12.a((org.json.JSONObject) r4)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r0[r1] = r4     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                net.fxgear.AvatarSetting$b$a[] r0 = r12.c     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                java.lang.String r1 = "knee_to_foot"
                org.json.JSONObject r1 = r3.getJSONObject(r1)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                net.fxgear.AvatarSetting$b$a r1 = r12.a((org.json.JSONObject) r1)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r0[r13] = r1     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                net.fxgear.AvatarSetting$b$a[] r13 = r12.c     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r0 = 4
                java.lang.String r1 = "hip_to_knee"
                org.json.JSONObject r1 = r3.getJSONObject(r1)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                net.fxgear.AvatarSetting$b$a r1 = r12.a((org.json.JSONObject) r1)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r13[r0] = r1     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                net.fxgear.AvatarSetting$b$a[] r13 = r12.c     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r0 = 5
                java.lang.String r1 = "hipR_to_hipL"
                org.json.JSONObject r1 = r3.getJSONObject(r1)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                net.fxgear.AvatarSetting$b$a r1 = r12.a((org.json.JSONObject) r1)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r13[r0] = r1     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                net.fxgear.AvatarSetting$b$a[] r13 = r12.c     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r0 = 6
                java.lang.String r1 = "shoulderR_to_shoulderL"
                org.json.JSONObject r1 = r3.getJSONObject(r1)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                net.fxgear.AvatarSetting$b$a r1 = r12.a((org.json.JSONObject) r1)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r13[r0] = r1     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                net.fxgear.AvatarSetting$b$a[] r13 = r12.c     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r0 = 7
                java.lang.String r1 = "arm_thick"
                org.json.JSONObject r1 = r3.getJSONObject(r1)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                net.fxgear.AvatarSetting$b$a r1 = r12.a((org.json.JSONObject) r1)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r13[r0] = r1     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                net.fxgear.AvatarSetting$b$a[] r13 = r12.c     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r0 = 8
                java.lang.String r1 = "chest_thick"
                org.json.JSONObject r1 = r3.getJSONObject(r1)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                net.fxgear.AvatarSetting$b$a r1 = r12.a((org.json.JSONObject) r1)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r13[r0] = r1     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                net.fxgear.AvatarSetting$b$a[] r13 = r12.c     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r0 = 9
                java.lang.String r1 = "chest_cup"
                org.json.JSONObject r1 = r3.getJSONObject(r1)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                net.fxgear.AvatarSetting$b$a r1 = r12.a((org.json.JSONObject) r1)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r13[r0] = r1     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                net.fxgear.AvatarSetting$b$a[] r13 = r12.c     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r0 = 10
                java.lang.String r1 = "belly_thick"
                org.json.JSONObject r1 = r3.getJSONObject(r1)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                net.fxgear.AvatarSetting$b$a r1 = r12.a((org.json.JSONObject) r1)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r13[r0] = r1     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                net.fxgear.AvatarSetting$b$a[] r13 = r12.c     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r0 = 11
                java.lang.String r1 = "pelvis_thick"
                org.json.JSONObject r1 = r3.getJSONObject(r1)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                net.fxgear.AvatarSetting$b$a r1 = r12.a((org.json.JSONObject) r1)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r13[r0] = r1     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                net.fxgear.AvatarSetting$b$a[] r13 = r12.c     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r0 = 12
                java.lang.String r1 = "leg_thick"
                org.json.JSONObject r1 = r3.getJSONObject(r1)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                net.fxgear.AvatarSetting$b$a r1 = r12.a((org.json.JSONObject) r1)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r13[r0] = r1     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                net.fxgear.AvatarSetting$b$a[] r13 = r12.c     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r0 = 13
                java.lang.String r1 = "arm_thick_length"
                org.json.JSONObject r1 = r3.getJSONObject(r1)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                net.fxgear.AvatarSetting$b$a r1 = r12.a((org.json.JSONObject) r1)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r13[r0] = r1     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                net.fxgear.AvatarSetting$b$a[] r13 = r12.c     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r0 = 14
                java.lang.String r1 = "chest_thick_length"
                org.json.JSONObject r1 = r3.getJSONObject(r1)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                net.fxgear.AvatarSetting$b$a r1 = r12.a((org.json.JSONObject) r1)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r13[r0] = r1     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                net.fxgear.AvatarSetting$b$a[] r13 = r12.c     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r0 = 15
                java.lang.String r1 = "belly_thick_length"
                org.json.JSONObject r1 = r3.getJSONObject(r1)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                net.fxgear.AvatarSetting$b$a r1 = r12.a((org.json.JSONObject) r1)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r13[r0] = r1     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                net.fxgear.AvatarSetting$b$a[] r13 = r12.c     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r0 = 16
                java.lang.String r1 = "pelvis_thick_length"
                org.json.JSONObject r1 = r3.getJSONObject(r1)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                net.fxgear.AvatarSetting$b$a r1 = r12.a((org.json.JSONObject) r1)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r13[r0] = r1     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                net.fxgear.AvatarSetting$b$a[] r13 = r12.c     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r0 = 17
                java.lang.String r1 = "leg_thick_length"
                org.json.JSONObject r1 = r3.getJSONObject(r1)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                net.fxgear.AvatarSetting$b$a r1 = r12.a((org.json.JSONObject) r1)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r13[r0] = r1     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r0 = 0
                r12.d = r0     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                net.fxgear.AvatarSetting$b$a[] r13 = r12.c     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r13 = r13[r9]     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                double[] r13 = r13.e     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r0 = 4611686018427387904(0x4000000000000000, double:2.0)
                if (r13 == 0) goto L_0x02e2
                net.fxgear.AvatarSetting$b$a[] r13 = r12.c     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r13 = r13[r9]     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                double[] r13 = r13.e     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                int r13 = r13.length     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                if (r13 <= 0) goto L_0x02e2
                net.fxgear.AvatarSetting$b$a[] r13 = r12.c     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r13 = r13[r9]     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                double[] r13 = r13.e     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                int r13 = r13.length     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                int r13 = r13 - r2
                double r6 = (double) r13     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r12.e = r6     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                java.lang.String r13 = "default_size_index"
                boolean r13 = r3.has(r13)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                if (r13 == 0) goto L_0x02d8
                java.lang.String r13 = "default_size_index"
                double r0 = r3.getDouble(r13)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r12.f = r0     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                goto L_0x02ef
            L_0x02d8:
                double r6 = r12.d     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                double r10 = r12.e     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r13 = 0
                double r6 = r6 + r10
                double r6 = r6 / r0
                r12.f = r6     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                goto L_0x02ef
            L_0x02e2:
                r6 = 4618441417868443648(0x4018000000000000, double:6.0)
                r12.e = r6     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                double r6 = r12.d     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                double r10 = r12.e     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r13 = 0
                double r6 = r6 + r10
                double r6 = r6 / r0
                r12.f = r6     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
            L_0x02ef:
                java.util.ArrayList r13 = new java.util.ArrayList     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r13.<init>()     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r12.g = r13     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                java.lang.String r13 = "size_text"
                boolean r13 = r3.has(r13)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                if (r13 == 0) goto L_0x0316
                java.lang.String r13 = "size_text"
                org.json.JSONArray r13 = r3.getJSONArray(r13)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
            L_0x0304:
                int r0 = r13.length()     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                if (r9 >= r0) goto L_0x0323
                java.util.ArrayList<java.lang.String> r0 = r12.g     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                java.lang.String r1 = r13.getString(r9)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r0.add(r1)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                int r9 = r9 + 1
                goto L_0x0304
            L_0x0316:
                java.util.ArrayList<java.lang.String> r13 = r12.g     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                java.lang.String[] r0 = net.fxgear.AvatarSetting.l     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                java.util.List r0 = java.util.Arrays.asList(r0)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
                r13.addAll(r0)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
            L_0x0323:
                if (r15 == r2) goto L_0x0328
                r12.a((int) r14, (int) r15)     // Catch:{ FileNotFoundException -> 0x0334, IOException -> 0x0331, JSONException -> 0x032e, all -> 0x032c }
            L_0x0328:
                r5.close()     // Catch:{ IOException -> 0x0358 }
                goto L_0x0368
            L_0x032c:
                r13 = move-exception
                goto L_0x035d
            L_0x032e:
                r13 = move-exception
                r0 = r5
                goto L_0x033b
            L_0x0331:
                r13 = move-exception
                r0 = r5
                goto L_0x0345
            L_0x0334:
                r13 = move-exception
                r0 = r5
                goto L_0x034f
            L_0x0337:
                r13 = move-exception
                r5 = r0
                goto L_0x035d
            L_0x033a:
                r13 = move-exception
            L_0x033b:
                r13.printStackTrace()     // Catch:{ all -> 0x0337 }
                if (r0 == 0) goto L_0x0368
                r0.close()     // Catch:{ IOException -> 0x0358 }
                goto L_0x0368
            L_0x0344:
                r13 = move-exception
            L_0x0345:
                r13.printStackTrace()     // Catch:{ all -> 0x0337 }
                if (r0 == 0) goto L_0x0368
                r0.close()     // Catch:{ IOException -> 0x0358 }
                goto L_0x0368
            L_0x034e:
                r13 = move-exception
            L_0x034f:
                r13.printStackTrace()     // Catch:{ all -> 0x0337 }
                if (r0 == 0) goto L_0x0368
                r0.close()     // Catch:{ IOException -> 0x0358 }
                goto L_0x0368
            L_0x0358:
                r13 = move-exception
                r13.printStackTrace()
                goto L_0x0368
            L_0x035d:
                if (r5 == 0) goto L_0x0367
                r5.close()     // Catch:{ IOException -> 0x0363 }
                goto L_0x0367
            L_0x0363:
                r14 = move-exception
                r14.printStackTrace()
            L_0x0367:
                throw r13
            L_0x0368:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.fxgear.AvatarSetting.b.<init>(android.content.Context, int, int):void");
        }

        /* JADX WARNING: Removed duplicated region for block: B:28:0x00c2  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00c5  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void a(int r24, int r25) {
            /*
                r23 = this;
                r0 = r23
                r1 = r24
                r2 = r25
                r3 = 1
                if (r1 != r3) goto L_0x0010
                if (r2 == r3) goto L_0x0010
                int[] r4 = net.fxgear.AvatarSetting.m
                goto L_0x0014
            L_0x0010:
                int[] r4 = net.fxgear.AvatarSetting.p
            L_0x0014:
                net.fxgear.util.Matrix r5 = new net.fxgear.util.Matrix
                int r6 = r4.length
                int r7 = r4.length
                r8 = 0
                r5.<init>(r6, r7, r8)
                r0.h = r5
                net.fxgear.util.Matrix r5 = new net.fxgear.util.Matrix
                int r6 = r4.length
                int r7 = r4.length
                r5.<init>(r6, r7, r8)
                r0.i = r5
                r6 = 0
            L_0x0029:
                int r7 = r4.length
                if (r6 >= r7) goto L_0x00e3
                r7 = r4[r6]
                net.fxgear.AvatarSetting$b$a[] r8 = r0.c
                r8 = r8[r7]
                int[] r8 = r8.f556a
                net.fxgear.AvatarSetting$b$a[] r9 = r0.c
                r9 = r9[r7]
                double[] r9 = r9.c
                net.fxgear.AvatarSetting$b$a[] r10 = r0.c
                r10 = r10[r7]
                double[] r10 = r10.f557b
                net.fxgear.AvatarSetting$b$a[] r11 = r0.c
                r11 = r11[r7]
                double r11 = r11.d
                r13 = 0
            L_0x0047:
                int r14 = r8.length
                if (r13 >= r14) goto L_0x00db
                r14 = r8[r13]
                int r14 = r0.a((int) r14)
                r15 = r9[r13]
                double r15 = r15 - r11
                r17 = r10[r13]
                double r17 = r17 - r11
                r5 = 16
                if (r7 != r5) goto L_0x00b3
                if (r14 != r5) goto L_0x00b3
                r5 = 0
            L_0x005e:
                int r3 = r8.length
                if (r5 >= r3) goto L_0x0074
                r3 = r8[r5]
                int r3 = r0.a((int) r3)
                r20 = r4
                r4 = 5
                if (r3 != r4) goto L_0x006f
                r19 = r5
                goto L_0x0078
            L_0x006f:
                int r5 = r5 + 1
                r4 = r20
                goto L_0x005e
            L_0x0074:
                r20 = r4
                r19 = -1
            L_0x0078:
                if (r19 < 0) goto L_0x00b5
                r3 = r9[r13]
                double r3 = r3 - r11
                r5 = 1
                float r15 = b(r1, r2, r5)
                r21 = r6
                double r5 = (double) r15
                net.fxgear.AvatarSetting$b$a[] r15 = r0.c
                r15 = r15[r7]
                double[] r15 = r15.c
                r16 = r15[r19]
                double r16 = r16 - r11
                java.lang.Double.isNaN(r5)
                double r5 = r5 * r16
                double r15 = r3 + r5
                r3 = r10[r13]
                double r3 = r3 - r11
                r5 = 0
                float r6 = b(r1, r2, r5)
                double r5 = (double) r6
                r22 = r8
                net.fxgear.AvatarSetting$b$a[] r8 = r0.c
                r8 = r8[r7]
                double[] r8 = r8.f557b
                r17 = r8[r19]
                double r17 = r17 - r11
                java.lang.Double.isNaN(r5)
                double r5 = r5 * r17
                double r17 = r3 + r5
                goto L_0x00b9
            L_0x00b3:
                r20 = r4
            L_0x00b5:
                r21 = r6
                r22 = r8
            L_0x00b9:
                r3 = r15
                r5 = r17
                int r8 = r0.a((int) r14, (int) r1, (int) r2)
                if (r8 >= 0) goto L_0x00c5
                r15 = r21
                goto L_0x00d1
            L_0x00c5:
                net.fxgear.util.Matrix r14 = r0.h
                r15 = r21
                r14.set(r15, r8, r3)
                net.fxgear.util.Matrix r3 = r0.i
                r3.set(r15, r8, r5)
            L_0x00d1:
                int r13 = r13 + 1
                r6 = r15
                r4 = r20
                r8 = r22
                r3 = 1
                goto L_0x0047
            L_0x00db:
                r20 = r4
                r15 = r6
                int r6 = r15 + 1
                r3 = 1
                goto L_0x0029
            L_0x00e3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.fxgear.AvatarSetting.b.a(int, int):void");
        }

        /* access modifiers changed from: private */
        public static float b(int i2, int i3, boolean z) {
            float[] fArr = {0.5f, 1.0f, 0.5f, 0.5f, 0.1f, 0.1f, 0.1f, 0.1f};
            int i4 = 0;
            int i5 = (i2 == 1 ? 1 : 0) + (i3 == 1 ? 2 : 0);
            if (!z) {
                i4 = 4;
            }
            return fArr[i5 + i4];
        }

        private int a(int i2, int i3, int i4) {
            int[] d2 = (i3 != 1 || i4 == 1) ? AvatarSetting.p : AvatarSetting.m;
            for (int i5 = 0; i5 < d2.length; i5++) {
                if (d2[i5] == i2) {
                    return i5;
                }
            }
            return -1;
        }

        private a a(JSONObject jSONObject) throws JSONException {
            a aVar = new a();
            JSONArray jSONArray = jSONObject.getJSONArray("affected_target_num");
            aVar.f556a = new int[jSONArray.length()];
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                aVar.f556a[i2] = jSONArray.getInt(i2);
            }
            JSONArray jSONArray2 = jSONObject.getJSONArray("target_min");
            aVar.f557b = new double[jSONArray2.length()];
            for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                aVar.f557b[i3] = jSONArray2.getDouble(i3);
            }
            JSONArray jSONArray3 = jSONObject.getJSONArray("target_max");
            aVar.c = new double[jSONArray3.length()];
            for (int i4 = 0; i4 < jSONArray3.length(); i4++) {
                aVar.c[i4] = jSONArray3.getDouble(i4);
            }
            aVar.d = jSONObject.getDouble("target_default");
            if (jSONObject.has("size_list")) {
                JSONArray jSONArray4 = jSONObject.getJSONArray("size_list");
                aVar.e = new double[jSONArray4.length()];
                for (int i5 = 0; i5 < jSONArray4.length(); i5++) {
                    aVar.e[i5] = jSONArray4.getDouble(i5);
                }
            }
            return aVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:102:0x0196 A[SYNTHETIC, Splitter:B:102:0x0196] */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x0142 A[SYNTHETIC, Splitter:B:79:0x0142] */
        /* JADX WARNING: Removed duplicated region for block: B:87:0x014f A[SYNTHETIC, Splitter:B:87:0x014f] */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x015c A[SYNTHETIC, Splitter:B:95:0x015c] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void a(android.content.Context r12, java.io.File r13) {
            /*
                r11 = this;
                java.lang.String r0 = net.fxgear.util.FXUtil.GetCurrentLanguageCode(r12)
                java.io.File r1 = new java.io.File
                java.lang.String r2 = "Mesh.bin"
                r1.<init>(r13, r2)
                java.io.File r2 = new java.io.File
                java.lang.String r3 = "Texture.jpg"
                r2.<init>(r13, r3)
                boolean r3 = r1.exists()
                if (r3 == 0) goto L_0x023c
                boolean r3 = r1.isFile()
                if (r3 == 0) goto L_0x023c
                boolean r3 = r2.exists()
                if (r3 == 0) goto L_0x021d
                boolean r3 = r2.isFile()
                if (r3 == 0) goto L_0x021d
                java.io.File r12 = net.fxgear.GlobalDefine.GetAvatarHeadResourceDirectory(r12)
                java.io.File[] r12 = r12.listFiles()
                r13 = 0
                r3 = 0
            L_0x0034:
                int r4 = r12.length
                if (r3 >= r4) goto L_0x0212
                r4 = r12[r3]
                boolean r5 = r4.isDirectory()
                if (r5 == 0) goto L_0x020e
                java.lang.String r5 = r4.getName()
                java.lang.String r6 = "Type_"
                boolean r5 = r5.startsWith(r6)
                if (r5 == 0) goto L_0x020e
                java.lang.String r5 = r4.getName()
                int r5 = r11.a((java.lang.String) r5)
                if (r5 <= 0) goto L_0x020e
                r6 = 0
            L_0x0056:
                java.util.ArrayList<net.fxgear.AvatarSetting$HeadTypeFilesInfo> r7 = r11.f552a
                int r7 = r7.size()
                if (r6 >= r7) goto L_0x006f
                java.util.ArrayList<net.fxgear.AvatarSetting$HeadTypeFilesInfo> r7 = r11.f552a
                java.lang.Object r7 = r7.get(r6)
                net.fxgear.AvatarSetting$HeadTypeFilesInfo r7 = (net.fxgear.AvatarSetting.HeadTypeFilesInfo) r7
                int r7 = r7.mTypeID
                if (r7 != r5) goto L_0x006c
                r6 = 1
                goto L_0x0070
            L_0x006c:
                int r6 = r6 + 1
                goto L_0x0056
            L_0x006f:
                r6 = 0
            L_0x0070:
                if (r6 != 0) goto L_0x020e
                java.io.File r6 = new java.io.File
                java.lang.String r7 = "Resource"
                r6.<init>(r4, r7)
                boolean r4 = r6.exists()
                if (r4 == 0) goto L_0x01f3
                boolean r4 = r6.isDirectory()
                if (r4 == 0) goto L_0x01f3
                java.io.File r4 = new java.io.File
                java.lang.String r7 = "Thumbnail_normal.png"
                r4.<init>(r6, r7)
                java.io.File r7 = new java.io.File
                java.lang.String r8 = "Thumbnail_selected.png"
                r7.<init>(r6, r8)
                boolean r8 = r4.exists()
                if (r8 == 0) goto L_0x00a0
                boolean r8 = r7.exists()
                if (r8 == 0) goto L_0x00a0
                goto L_0x00cf
            L_0x00a0:
                java.io.File r4 = new java.io.File
                java.lang.String r7 = "Android"
                r4.<init>(r6, r7)
                java.io.File r7 = new java.io.File
                java.lang.String r8 = "Thumbnail_normal.png"
                r7.<init>(r4, r8)
                boolean r8 = r7.exists()
                if (r8 == 0) goto L_0x01d7
                boolean r8 = r7.isFile()
                if (r8 == 0) goto L_0x01d7
                java.io.File r8 = new java.io.File
                java.lang.String r9 = "Thumbnail_selected.png"
                r8.<init>(r4, r9)
                boolean r4 = r8.exists()
                if (r4 == 0) goto L_0x01bb
                boolean r4 = r8.isFile()
                if (r4 == 0) goto L_0x01bb
                r4 = r7
                r7 = r8
            L_0x00cf:
                java.io.File r8 = new java.io.File
                java.lang.String r9 = "Description.txt"
                r8.<init>(r6, r9)
                boolean r6 = r8.exists()
                if (r6 == 0) goto L_0x019f
                boolean r6 = r8.isFile()
                if (r6 == 0) goto L_0x019f
                long r9 = r8.length()
                int r6 = (int) r9
                byte[] r6 = new byte[r6]
                r9 = 0
                java.io.FileInputStream r10 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0155, IOException -> 0x0148, JSONException -> 0x013b }
                r10.<init>(r8)     // Catch:{ FileNotFoundException -> 0x0155, IOException -> 0x0148, JSONException -> 0x013b }
                r10.read(r6)     // Catch:{ FileNotFoundException -> 0x0134, IOException -> 0x0130, JSONException -> 0x012c, all -> 0x0129 }
                java.lang.String r8 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x0134, IOException -> 0x0130, JSONException -> 0x012c, all -> 0x0129 }
                r8.<init>(r6)     // Catch:{ FileNotFoundException -> 0x0134, IOException -> 0x0130, JSONException -> 0x012c, all -> 0x0129 }
                org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ FileNotFoundException -> 0x0134, IOException -> 0x0130, JSONException -> 0x012c, all -> 0x0129 }
                r6.<init>(r8)     // Catch:{ FileNotFoundException -> 0x0134, IOException -> 0x0130, JSONException -> 0x012c, all -> 0x0129 }
                boolean r8 = r6.has(r0)     // Catch:{ FileNotFoundException -> 0x0134, IOException -> 0x0130, JSONException -> 0x012c, all -> 0x0129 }
                if (r8 == 0) goto L_0x0108
                java.lang.String r8 = r6.getString(r0)     // Catch:{ FileNotFoundException -> 0x0134, IOException -> 0x0130, JSONException -> 0x012c, all -> 0x0129 }
            L_0x0106:
                r9 = r8
                goto L_0x010f
            L_0x0108:
                java.lang.String r8 = "en"
                java.lang.String r8 = r6.getString(r8)     // Catch:{ FileNotFoundException -> 0x0134, IOException -> 0x0130, JSONException -> 0x012c, all -> 0x0129 }
                goto L_0x0106
            L_0x010f:
                java.lang.String r8 = "order"
                boolean r8 = r6.has(r8)     // Catch:{ FileNotFoundException -> 0x0134, IOException -> 0x0130, JSONException -> 0x012c, all -> 0x0129 }
                if (r8 == 0) goto L_0x011e
                java.lang.String r8 = "order"
                int r6 = r6.getInt(r8)     // Catch:{ FileNotFoundException -> 0x0134, IOException -> 0x0130, JSONException -> 0x012c, all -> 0x0129 }
                goto L_0x011f
            L_0x011e:
                r6 = 0
            L_0x011f:
                r10.close()     // Catch:{ IOException -> 0x0123 }
                goto L_0x0127
            L_0x0123:
                r8 = move-exception
                r8.printStackTrace()
            L_0x0127:
                r8 = r9
                goto L_0x0165
            L_0x0129:
                r12 = move-exception
                goto L_0x0194
            L_0x012c:
                r6 = move-exception
                r8 = r9
                r9 = r10
                goto L_0x013d
            L_0x0130:
                r6 = move-exception
                r8 = r9
                r9 = r10
                goto L_0x014a
            L_0x0134:
                r6 = move-exception
                r8 = r9
                r9 = r10
                goto L_0x0157
            L_0x0138:
                r12 = move-exception
                r10 = r9
                goto L_0x0194
            L_0x013b:
                r6 = move-exception
                r8 = r9
            L_0x013d:
                r6.printStackTrace()     // Catch:{ all -> 0x0138 }
                if (r9 == 0) goto L_0x0164
                r9.close()     // Catch:{ IOException -> 0x0146 }
                goto L_0x0164
            L_0x0146:
                r6 = move-exception
                goto L_0x0161
            L_0x0148:
                r6 = move-exception
                r8 = r9
            L_0x014a:
                r6.printStackTrace()     // Catch:{ all -> 0x0138 }
                if (r9 == 0) goto L_0x0164
                r9.close()     // Catch:{ IOException -> 0x0153 }
                goto L_0x0164
            L_0x0153:
                r6 = move-exception
                goto L_0x0161
            L_0x0155:
                r6 = move-exception
                r8 = r9
            L_0x0157:
                r6.printStackTrace()     // Catch:{ all -> 0x0138 }
                if (r9 == 0) goto L_0x0164
                r9.close()     // Catch:{ IOException -> 0x0160 }
                goto L_0x0164
            L_0x0160:
                r6 = move-exception
            L_0x0161:
                r6.printStackTrace()
            L_0x0164:
                r6 = 0
            L_0x0165:
                net.fxgear.AvatarSetting$HeadTypeFilesInfo r9 = new net.fxgear.AvatarSetting$HeadTypeFilesInfo
                r9.<init>()
                r9.mTypeID = r5
                r9.f548a = r6
                r9.f549b = r1
                r9.c = r2
                net.fxgear.AvatarSetting$TypeResource r5 = new net.fxgear.AvatarSetting$TypeResource
                r5.<init>()
                r9.d = r5
                net.fxgear.AvatarSetting$TypeResource r5 = r9.d
                java.lang.String r4 = r4.getAbsolutePath()
                r5.mNormalThumbnailPath = r4
                net.fxgear.AvatarSetting$TypeResource r4 = r9.d
                java.lang.String r5 = r7.getAbsolutePath()
                r4.mSelectedThumbnailPath = r5
                net.fxgear.AvatarSetting$TypeResource r4 = r9.d
                r4.mDescriptionText = r8
                java.util.ArrayList<net.fxgear.AvatarSetting$HeadTypeFilesInfo> r4 = r11.f552a
                r4.add(r9)
                goto L_0x020e
            L_0x0194:
                if (r10 == 0) goto L_0x019e
                r10.close()     // Catch:{ IOException -> 0x019a }
                goto L_0x019e
            L_0x019a:
                r13 = move-exception
                r13.printStackTrace()
            L_0x019e:
                throw r12
            L_0x019f:
                java.lang.String r4 = net.fxgear.AvatarSetting.f544a
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r7 = "Not exist head type "
                r6.append(r7)
                r6.append(r5)
                java.lang.String r5 = " description."
                r6.append(r5)
                java.lang.String r5 = r6.toString()
                android.util.Log.w(r4, r5)
                goto L_0x020e
            L_0x01bb:
                java.lang.String r4 = net.fxgear.AvatarSetting.f544a
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r7 = "Not exist head type "
                r6.append(r7)
                r6.append(r5)
                java.lang.String r5 = " thumbnail."
                r6.append(r5)
                java.lang.String r5 = r6.toString()
                android.util.Log.w(r4, r5)
                goto L_0x020e
            L_0x01d7:
                java.lang.String r4 = net.fxgear.AvatarSetting.f544a
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r7 = "Not exist head type "
                r6.append(r7)
                r6.append(r5)
                java.lang.String r5 = " thumbnail."
                r6.append(r5)
                java.lang.String r5 = r6.toString()
                android.util.Log.w(r4, r5)
                goto L_0x020e
            L_0x01f3:
                java.lang.String r4 = net.fxgear.AvatarSetting.f544a
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r7 = "Not exist head type "
                r6.append(r7)
                r6.append(r5)
                java.lang.String r5 = " resource directory."
                r6.append(r5)
                java.lang.String r5 = r6.toString()
                android.util.Log.w(r4, r5)
            L_0x020e:
                int r3 = r3 + 1
                goto L_0x0034
            L_0x0212:
                java.util.ArrayList<net.fxgear.AvatarSetting$HeadTypeFilesInfo> r12 = r11.f552a
                net.fxgear.AvatarSetting$b$1 r13 = new net.fxgear.AvatarSetting$b$1
                r13.<init>()
                java.util.Collections.sort(r12, r13)
                return
            L_0x021d:
                java.io.File r12 = r13.getParentFile()
                java.lang.String r12 = r12.getName()
                java.lang.String r13 = net.fxgear.AvatarSetting.f544a
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Not exist head type texture file."
                r0.append(r1)
                r0.append(r12)
                java.lang.String r12 = r0.toString()
                android.util.Log.w(r13, r12)
                return
            L_0x023c:
                java.io.File r12 = r13.getParentFile()
                java.lang.String r12 = r12.getName()
                java.lang.String r13 = net.fxgear.AvatarSetting.f544a
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Not exist default head mesh file."
                r0.append(r1)
                r0.append(r12)
                java.lang.String r12 = r0.toString()
                android.util.Log.w(r13, r12)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.fxgear.AvatarSetting.b.a(android.content.Context, java.io.File):void");
        }

        /* JADX WARNING: Removed duplicated region for block: B:32:0x0108 A[SYNTHETIC, Splitter:B:32:0x0108] */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x0118 A[SYNTHETIC, Splitter:B:41:0x0118] */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x0123 A[SYNTHETIC, Splitter:B:48:0x0123] */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x012a A[SYNTHETIC, Splitter:B:52:0x012a] */
        /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:62:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Unknown top exception splitter block from list: {B:29:0x0103=Splitter:B:29:0x0103, B:38:0x0113=Splitter:B:38:0x0113, B:45:0x011e=Splitter:B:45:0x011e} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private net.fxgear.AvatarSetting.c a(java.io.File r12) {
            /*
                r11 = this;
                r0 = 0
                if (r12 == 0) goto L_0x0133
                boolean r1 = r12.exists()
                if (r1 == 0) goto L_0x0133
                boolean r1 = r12.isFile()
                if (r1 == 0) goto L_0x0133
                net.fxgear.AvatarSetting$c r1 = new net.fxgear.AvatarSetting$c
                r1.<init>()
                long r2 = r12.length()
                int r2 = (int) r2
                byte[] r2 = new byte[r2]
                java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x011c, IOException -> 0x0111, JSONException -> 0x0101, all -> 0x00fe }
                r3.<init>(r12)     // Catch:{ FileNotFoundException -> 0x011c, IOException -> 0x0111, JSONException -> 0x0101, all -> 0x00fe }
                r3.read(r2)     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                java.lang.String r12 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                r12.<init>(r2)     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                r2.<init>(r12)     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                java.lang.String r12 = "version"
                int r12 = r2.getInt(r12)     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                r1.f558a = r12     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                java.lang.String r12 = "material"
                org.json.JSONObject r12 = r2.getJSONObject(r12)     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                java.lang.String r2 = "ambient"
                double r4 = r12.getDouble(r2)     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                float r2 = (float) r4     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                r1.f559b = r2     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                java.lang.String r2 = "diffuse"
                double r4 = r12.getDouble(r2)     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                float r2 = (float) r4     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                r1.c = r2     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                java.lang.String r2 = "specular"
                double r4 = r12.getDouble(r2)     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                float r2 = (float) r4     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                r1.d = r2     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                java.lang.String r2 = "specularExp"
                double r4 = r12.getDouble(r2)     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                float r2 = (float) r4     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                r1.e = r2     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                int r2 = r1.f558a     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                r4 = 1060320051(0x3f333333, float:0.7)
                r5 = 2
                if (r2 < r5) goto L_0x007a
                java.lang.String r2 = "alphaThreshold"
                double r6 = r12.getDouble(r2)     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                float r2 = (float) r6     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                r1.f = r2     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                float r2 = r1.f     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                r6 = 0
                int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
                if (r2 != 0) goto L_0x007c
                r1.f = r4     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                goto L_0x007c
            L_0x007a:
                r1.f = r4     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
            L_0x007c:
                java.lang.String r2 = "pointLight0"
                org.json.JSONArray r2 = r12.getJSONArray(r2)     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                r4 = 3
                float[] r6 = new float[r4]     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                r1.g = r6     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                float[] r6 = r1.g     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                r7 = 0
                double r8 = r2.getDouble(r7)     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                float r8 = (float) r8     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                r6[r7] = r8     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                float[] r6 = r1.g     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                r8 = 1
                double r9 = r2.getDouble(r8)     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                float r9 = (float) r9     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                r6[r8] = r9     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                float[] r6 = r1.g     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                double r9 = r2.getDouble(r5)     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                float r2 = (float) r9     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                r6[r5] = r2     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                java.lang.String r2 = "pointLight1"
                org.json.JSONArray r2 = r12.getJSONArray(r2)     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                float[] r6 = new float[r4]     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                r1.h = r6     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                float[] r6 = r1.h     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                double r9 = r2.getDouble(r7)     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                float r9 = (float) r9     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                r6[r7] = r9     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                float[] r6 = r1.h     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                double r9 = r2.getDouble(r8)     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                float r9 = (float) r9     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                r6[r8] = r9     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                float[] r6 = r1.h     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                double r9 = r2.getDouble(r5)     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                float r2 = (float) r9     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                r6[r5] = r2     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                java.lang.String r2 = "directionalLight"
                org.json.JSONArray r12 = r12.getJSONArray(r2)     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                float[] r2 = new float[r4]     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                r1.i = r2     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                float[] r2 = r1.i     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                double r9 = r12.getDouble(r7)     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                float r4 = (float) r9     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                r2[r7] = r4     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                float[] r2 = r1.i     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                double r6 = r12.getDouble(r8)     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                float r4 = (float) r6     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                r2[r8] = r4     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                float[] r2 = r1.i     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                double r6 = r12.getDouble(r5)     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                float r12 = (float) r6     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                r2[r5] = r12     // Catch:{ FileNotFoundException -> 0x00fc, IOException -> 0x00fa, JSONException -> 0x00f8 }
                r3.close()     // Catch:{ IOException -> 0x00f2 }
                goto L_0x00f6
            L_0x00f2:
                r12 = move-exception
                r12.printStackTrace()
            L_0x00f6:
                r0 = r1
                goto L_0x0126
            L_0x00f8:
                r12 = move-exception
                goto L_0x0103
            L_0x00fa:
                r12 = move-exception
                goto L_0x0113
            L_0x00fc:
                r12 = move-exception
                goto L_0x011e
            L_0x00fe:
                r12 = move-exception
                r3 = r0
                goto L_0x0128
            L_0x0101:
                r12 = move-exception
                r3 = r0
            L_0x0103:
                r12.printStackTrace()     // Catch:{ all -> 0x0127 }
                if (r3 == 0) goto L_0x0126
                r3.close()     // Catch:{ IOException -> 0x010c }
                goto L_0x0126
            L_0x010c:
                r12 = move-exception
                r12.printStackTrace()
                goto L_0x0126
            L_0x0111:
                r12 = move-exception
                r3 = r0
            L_0x0113:
                r12.printStackTrace()     // Catch:{ all -> 0x0127 }
                if (r3 == 0) goto L_0x0126
                r3.close()     // Catch:{ IOException -> 0x010c }
                goto L_0x0126
            L_0x011c:
                r12 = move-exception
                r3 = r0
            L_0x011e:
                r12.printStackTrace()     // Catch:{ all -> 0x0127 }
                if (r3 == 0) goto L_0x0126
                r3.close()     // Catch:{ IOException -> 0x010c }
            L_0x0126:
                return r0
            L_0x0127:
                r12 = move-exception
            L_0x0128:
                if (r3 == 0) goto L_0x0132
                r3.close()     // Catch:{ IOException -> 0x012e }
                goto L_0x0132
            L_0x012e:
                r0 = move-exception
                r0.printStackTrace()
            L_0x0132:
                throw r12
            L_0x0133:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.fxgear.AvatarSetting.b.a(java.io.File):net.fxgear.AvatarSetting$c");
        }

        private a b(File file) {
            if (file == null || !file.exists() || !file.isDirectory()) {
                return null;
            }
            File file2 = new File(file, GlobalDefine.FILE_NAME_MESH);
            if (!file2.exists() || !file2.isFile()) {
                String str = AvatarSetting.f544a;
                Log.w(str, "Not exist accessories mesh file : " + file);
                return null;
            }
            c a2 = a(new File(file, GlobalDefine.FILE_NAME_MATERIAL_INFO));
            if (a2 == null) {
                String str2 = AvatarSetting.f544a;
                Log.w(str2, "Not exist accessories material file : " + file);
                return null;
            }
            a aVar = new a();
            aVar.f550a = file2;
            aVar.f551b = a2;
            return aVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:103:0x021b A[SYNTHETIC, Splitter:B:103:0x021b] */
        /* JADX WARNING: Removed duplicated region for block: B:110:0x0226 A[SYNTHETIC, Splitter:B:110:0x0226] */
        /* JADX WARNING: Removed duplicated region for block: B:117:0x0234 A[SYNTHETIC, Splitter:B:117:0x0234] */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x0210 A[SYNTHETIC, Splitter:B:96:0x0210] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void b(android.content.Context r18, java.io.File r19) {
            /*
                r17 = this;
                r1 = r17
                java.io.File[] r2 = r19.listFiles()
                r4 = 0
            L_0x0007:
                int r0 = r2.length
                if (r4 >= r0) goto L_0x034f
                r0 = r2[r4]
                boolean r5 = r0.isDirectory()
                if (r5 == 0) goto L_0x0347
                java.lang.String r5 = r0.getName()
                java.lang.String r6 = "Type_"
                boolean r5 = r5.startsWith(r6)
                if (r5 == 0) goto L_0x0347
                java.lang.String r5 = r0.getName()
                int r5 = r1.a((java.lang.String) r5)
                if (r5 <= 0) goto L_0x0347
                r6 = 0
            L_0x0029:
                java.util.ArrayList<net.fxgear.AvatarSetting$HairTypeFilesInfo> r7 = r1.f553b
                int r7 = r7.size()
                if (r6 >= r7) goto L_0x0042
                java.util.ArrayList<net.fxgear.AvatarSetting$HairTypeFilesInfo> r7 = r1.f553b
                java.lang.Object r7 = r7.get(r6)
                net.fxgear.AvatarSetting$HairTypeFilesInfo r7 = (net.fxgear.AvatarSetting.HairTypeFilesInfo) r7
                int r7 = r7.mTypeID
                if (r7 != r5) goto L_0x003f
                r6 = 1
                goto L_0x0043
            L_0x003f:
                int r6 = r6 + 1
                goto L_0x0029
            L_0x0042:
                r6 = 0
            L_0x0043:
                if (r6 != 0) goto L_0x0347
                java.io.File r6 = new java.io.File
                java.lang.String r7 = "Mesh.bin"
                r6.<init>(r0, r7)
                boolean r7 = r6.exists()
                if (r7 == 0) goto L_0x0329
                boolean r7 = r6.isFile()
                if (r7 == 0) goto L_0x0329
                java.io.File r7 = new java.io.File
                java.lang.String r8 = "Texture_Color.png"
                r7.<init>(r0, r8)
                boolean r8 = r7.exists()
                if (r8 == 0) goto L_0x030b
                boolean r8 = r7.isFile()
                if (r8 == 0) goto L_0x030b
                java.io.File r8 = new java.io.File
                java.lang.String r9 = "Texture_Shading.png"
                r8.<init>(r0, r9)
                boolean r9 = r8.exists()
                if (r9 == 0) goto L_0x02ed
                boolean r9 = r8.isFile()
                if (r9 == 0) goto L_0x02ed
                java.io.File r9 = new java.io.File
                java.lang.String r10 = "Texture_Shadow.png"
                r9.<init>(r0, r10)
                boolean r10 = r9.exists()
                if (r10 == 0) goto L_0x02cf
                boolean r10 = r9.isFile()
                if (r10 == 0) goto L_0x02cf
                java.io.File r10 = new java.io.File
                java.lang.String r11 = "Texture_Base.png"
                r10.<init>(r0, r11)
                boolean r11 = r10.exists()
                if (r11 == 0) goto L_0x00a5
                boolean r11 = r10.isFile()
                if (r11 == 0) goto L_0x00a5
                goto L_0x00c0
            L_0x00a5:
                java.lang.String r11 = net.fxgear.AvatarSetting.f544a
                java.lang.StringBuilder r12 = new java.lang.StringBuilder
                r12.<init>()
                java.lang.String r13 = "Not exist hair type "
                r12.append(r13)
                r12.append(r5)
                java.lang.String r13 = " texture shadow file."
                r12.append(r13)
                java.lang.String r12 = r12.toString()
                android.util.Log.w(r11, r12)
            L_0x00c0:
                java.io.File r11 = new java.io.File
                java.lang.String r12 = "Bone_Animation.bin"
                r11.<init>(r0, r12)
                boolean r12 = r11.exists()
                if (r12 == 0) goto L_0x00d4
                boolean r12 = r11.isFile()
                if (r12 == 0) goto L_0x00d4
                goto L_0x00ef
            L_0x00d4:
                java.lang.String r12 = net.fxgear.AvatarSetting.f544a
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>()
                java.lang.String r14 = "Not exist hair type "
                r13.append(r14)
                r13.append(r5)
                java.lang.String r14 = " boneAnimation file."
                r13.append(r14)
                java.lang.String r13 = r13.toString()
                android.util.Log.w(r12, r13)
            L_0x00ef:
                java.io.File r12 = new java.io.File
                java.lang.String r13 = "Bone_Hierarchy.bin"
                r12.<init>(r0, r13)
                boolean r13 = r12.exists()
                if (r13 == 0) goto L_0x0103
                boolean r13 = r12.isFile()
                if (r13 == 0) goto L_0x0103
                goto L_0x011e
            L_0x0103:
                java.lang.String r13 = net.fxgear.AvatarSetting.f544a
                java.lang.StringBuilder r14 = new java.lang.StringBuilder
                r14.<init>()
                java.lang.String r15 = "Not exist hair type "
                r14.append(r15)
                r14.append(r5)
                java.lang.String r15 = " boneHierarchy file."
                r14.append(r15)
                java.lang.String r14 = r14.toString()
                android.util.Log.w(r13, r14)
            L_0x011e:
                java.io.File r13 = new java.io.File
                java.lang.String r14 = "MaterialInfo.txt"
                r13.<init>(r0, r14)
                net.fxgear.AvatarSetting$c r13 = r1.a((java.io.File) r13)
                if (r13 != 0) goto L_0x0146
                java.lang.String r14 = net.fxgear.AvatarSetting.f544a
                java.lang.StringBuilder r15 = new java.lang.StringBuilder
                r15.<init>()
                java.lang.String r3 = "Not exist hair type "
                r15.append(r3)
                r15.append(r5)
                java.lang.String r3 = " material info file."
                r15.append(r3)
                java.lang.String r3 = r15.toString()
                android.util.Log.w(r14, r3)
            L_0x0146:
                java.io.File r3 = new java.io.File
                java.lang.String r14 = "Accessories"
                r3.<init>(r0, r14)
                net.fxgear.AvatarSetting$a r3 = r1.b((java.io.File) r3)
                if (r3 != 0) goto L_0x0171
                java.lang.String r14 = net.fxgear.AvatarSetting.f544a
                java.lang.StringBuilder r15 = new java.lang.StringBuilder
                r15.<init>()
                r16 = r2
                java.lang.String r2 = "Not exist hair type "
                r15.append(r2)
                r15.append(r5)
                java.lang.String r2 = " accessories file."
                r15.append(r2)
                java.lang.String r2 = r15.toString()
                android.util.Log.w(r14, r2)
                goto L_0x0173
            L_0x0171:
                r16 = r2
            L_0x0173:
                java.io.File r2 = new java.io.File
                java.lang.String r14 = "Resource"
                r2.<init>(r0, r14)
                boolean r0 = r2.isDirectory()
                if (r0 == 0) goto L_0x02b2
                boolean r0 = r2.exists()
                if (r0 == 0) goto L_0x02b2
                java.io.File r0 = new java.io.File
                java.lang.String r14 = "Thumbnail_normal.png"
                r0.<init>(r2, r14)
                boolean r14 = r0.exists()
                if (r14 == 0) goto L_0x019b
                boolean r14 = r0.isFile()
                if (r14 == 0) goto L_0x019b
                r14 = r0
                goto L_0x01b5
            L_0x019b:
                java.io.File r0 = new java.io.File
                java.lang.String r14 = "Android"
                r0.<init>(r2, r14)
                java.io.File r14 = new java.io.File
                java.lang.String r15 = "Thumbnail_normal.png"
                r14.<init>(r0, r15)
                boolean r0 = r14.exists()
                if (r0 == 0) goto L_0x0295
                boolean r0 = r14.isFile()
                if (r0 == 0) goto L_0x0295
            L_0x01b5:
                java.io.File r0 = new java.io.File
                java.lang.String r15 = "Description.txt"
                r0.<init>(r2, r15)
                boolean r2 = r0.exists()
                r15 = 0
                if (r2 == 0) goto L_0x023e
                boolean r2 = r0.isFile()
                if (r2 == 0) goto L_0x023e
                long r1 = r0.length()
                int r1 = (int) r1
                byte[] r1 = new byte[r1]
                java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x021f, IOException -> 0x0214, JSONException -> 0x0209, all -> 0x0205 }
                r2.<init>(r0)     // Catch:{ FileNotFoundException -> 0x021f, IOException -> 0x0214, JSONException -> 0x0209, all -> 0x0205 }
                r2.read(r1)     // Catch:{ FileNotFoundException -> 0x0203, IOException -> 0x0201, JSONException -> 0x01ff }
                java.lang.String r0 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x0203, IOException -> 0x0201, JSONException -> 0x01ff }
                r0.<init>(r1)     // Catch:{ FileNotFoundException -> 0x0203, IOException -> 0x0201, JSONException -> 0x01ff }
                org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ FileNotFoundException -> 0x0203, IOException -> 0x0201, JSONException -> 0x01ff }
                r1.<init>(r0)     // Catch:{ FileNotFoundException -> 0x0203, IOException -> 0x0201, JSONException -> 0x01ff }
                java.lang.String r0 = "order"
                boolean r0 = r1.has(r0)     // Catch:{ FileNotFoundException -> 0x0203, IOException -> 0x0201, JSONException -> 0x01ff }
                if (r0 == 0) goto L_0x01f2
                java.lang.String r0 = "order"
                int r0 = r1.getInt(r0)     // Catch:{ FileNotFoundException -> 0x0203, IOException -> 0x0201, JSONException -> 0x01ff }
                r1 = r0
                goto L_0x01f3
            L_0x01f2:
                r1 = 0
            L_0x01f3:
                r2.close()     // Catch:{ IOException -> 0x01f8 }
                goto L_0x025a
            L_0x01f8:
                r0 = move-exception
                r2 = r0
                r2.printStackTrace()
                goto L_0x025a
            L_0x01ff:
                r0 = move-exception
                goto L_0x020b
            L_0x0201:
                r0 = move-exception
                goto L_0x0216
            L_0x0203:
                r0 = move-exception
                goto L_0x0221
            L_0x0205:
                r0 = move-exception
                r1 = r0
                r2 = r15
                goto L_0x0232
            L_0x0209:
                r0 = move-exception
                r2 = r15
            L_0x020b:
                r0.printStackTrace()     // Catch:{ all -> 0x0230 }
                if (r2 == 0) goto L_0x0259
                r2.close()     // Catch:{ IOException -> 0x022a }
                goto L_0x0259
            L_0x0214:
                r0 = move-exception
                r2 = r15
            L_0x0216:
                r0.printStackTrace()     // Catch:{ all -> 0x0230 }
                if (r2 == 0) goto L_0x0259
                r2.close()     // Catch:{ IOException -> 0x022a }
                goto L_0x0259
            L_0x021f:
                r0 = move-exception
                r2 = r15
            L_0x0221:
                r0.printStackTrace()     // Catch:{ all -> 0x0230 }
                if (r2 == 0) goto L_0x0259
                r2.close()     // Catch:{ IOException -> 0x022a }
                goto L_0x0259
            L_0x022a:
                r0 = move-exception
                r1 = r0
                r1.printStackTrace()
                goto L_0x0259
            L_0x0230:
                r0 = move-exception
                r1 = r0
            L_0x0232:
                if (r2 == 0) goto L_0x023d
                r2.close()     // Catch:{ IOException -> 0x0238 }
                goto L_0x023d
            L_0x0238:
                r0 = move-exception
                r2 = r0
                r2.printStackTrace()
            L_0x023d:
                throw r1
            L_0x023e:
                java.lang.String r0 = net.fxgear.AvatarSetting.f544a
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Not exist hair type "
                r1.append(r2)
                r1.append(r5)
                java.lang.String r2 = " description."
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                android.util.Log.w(r0, r1)
            L_0x0259:
                r1 = 0
            L_0x025a:
                net.fxgear.AvatarSetting$HairTypeFilesInfo r0 = new net.fxgear.AvatarSetting$HairTypeFilesInfo
                r0.<init>()
                r0.mTypeID = r5
                r0.f546a = r1
                r0.f547b = r6
                r0.c = r7
                r0.d = r8
                r0.e = r9
                r0.f = r10
                r0.g = r11
                r0.h = r12
                r0.j = r13
                r0.k = r3
                net.fxgear.AvatarSetting$TypeResource r1 = new net.fxgear.AvatarSetting$TypeResource
                r1.<init>()
                r0.i = r1
                net.fxgear.AvatarSetting$TypeResource r1 = r0.i
                java.lang.String r2 = r14.getAbsolutePath()
                r1.mNormalThumbnailPath = r2
                net.fxgear.AvatarSetting$TypeResource r1 = r0.i
                r1.mSelectedThumbnailPath = r15
                net.fxgear.AvatarSetting$TypeResource r1 = r0.i
                r1.mDescriptionText = r15
                r1 = r17
                java.util.ArrayList<net.fxgear.AvatarSetting$HairTypeFilesInfo> r2 = r1.f553b
                r2.add(r0)
                goto L_0x0349
            L_0x0295:
                java.lang.String r0 = net.fxgear.AvatarSetting.f544a
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Not exist hair type "
                r2.append(r3)
                r2.append(r5)
                java.lang.String r3 = " thumbnail."
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                android.util.Log.w(r0, r2)
                goto L_0x0349
            L_0x02b2:
                java.lang.String r0 = net.fxgear.AvatarSetting.f544a
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Not exist hair type "
                r2.append(r3)
                r2.append(r5)
                java.lang.String r3 = " resource directory."
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                android.util.Log.w(r0, r2)
                goto L_0x0349
            L_0x02cf:
                r16 = r2
                java.lang.String r0 = net.fxgear.AvatarSetting.f544a
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Not exist hair type "
                r2.append(r3)
                r2.append(r5)
                java.lang.String r3 = " texture shadow file."
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                android.util.Log.w(r0, r2)
                goto L_0x0349
            L_0x02ed:
                r16 = r2
                java.lang.String r0 = net.fxgear.AvatarSetting.f544a
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Not exist hair type "
                r2.append(r3)
                r2.append(r5)
                java.lang.String r3 = " texture shade file."
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                android.util.Log.w(r0, r2)
                goto L_0x0349
            L_0x030b:
                r16 = r2
                java.lang.String r0 = net.fxgear.AvatarSetting.f544a
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Not exist hair type "
                r2.append(r3)
                r2.append(r5)
                java.lang.String r3 = " texture color file."
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                android.util.Log.w(r0, r2)
                goto L_0x0349
            L_0x0329:
                r16 = r2
                java.lang.String r0 = net.fxgear.AvatarSetting.f544a
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r2.<init>()
                java.lang.String r3 = "Not exist hair type "
                r2.append(r3)
                r2.append(r5)
                java.lang.String r3 = " mesh file."
                r2.append(r3)
                java.lang.String r2 = r2.toString()
                android.util.Log.w(r0, r2)
                goto L_0x0349
            L_0x0347:
                r16 = r2
            L_0x0349:
                int r4 = r4 + 1
                r2 = r16
                goto L_0x0007
            L_0x034f:
                java.util.ArrayList<net.fxgear.AvatarSetting$HairTypeFilesInfo> r0 = r1.f553b
                net.fxgear.AvatarSetting$b$2 r2 = new net.fxgear.AvatarSetting$b$2
                r2.<init>()
                java.util.Collections.sort(r0, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.fxgear.AvatarSetting.b.b(android.content.Context, java.io.File):void");
        }

        private int a(String str) {
            try {
                return Integer.parseInt(str.substring(str.lastIndexOf("_") + 1));
            } catch (NumberFormatException e2) {
                e2.printStackTrace();
                return -1;
            }
        }
    }

    public AvatarSetting(Context context) {
        f545b = context;
    }

    public AvatarSetting(Context context, int i2, int i3) {
        f545b = context;
        SetCharacter(i2, i3);
    }

    public void SetCharacter(int i2, int i3) {
        if (f != i2 || g != i3) {
            f = i2;
            g = i3;
            InitializeBodyParts();
        }
    }

    public void InitializeBodyParts() {
        for (int i2 = 0; i2 < d.length; i2++) {
            d[i2] = 0.0d;
        }
        k = a(f545b, f, g);
        h = k.f;
        i = k.f;
        c = 20.0d;
        for (int i3 = 0; i3 < 18; i3++) {
            if (g == 1) {
                e[i3] = k.c[i3].d;
            } else {
                e[i3] = k.c[i3].e[(int) k.f];
            }
        }
    }

    public static double GetMinimumOfBodyPart(Context context, int i2, int i3, int i4) {
        double d2 = (double) NO_VALUE;
        b a2 = a(context, i2, i3);
        switch (i4) {
            case 0:
                return a2.c[2].f557b[0] + a2.c[4].f557b[0] + a2.c[3].f557b[0] + 20.0d;
            case 1:
                return a2.c[6].f557b[0];
            case 2:
                return a2.c[0].f557b[0] + a2.c[1].f557b[0];
            case 3:
                return a2.c[4].f557b[0];
            case 4:
                return a2.c[3].f557b[0];
            case 5:
            case 6:
                return a2.d;
            case 7:
                return a2.c[14].f557b[0] + ((i2 != 1 || i3 == 1) ? 0.0d : a2.c[9].f557b[0]);
            case 8:
                return a2.c[9].f557b[0];
            case 9:
                return a2.c[15].f557b[0];
            case 10:
                return a2.c[13].f557b[0];
            case 11:
                return a2.c[16].f557b[0];
            case 12:
                return a2.c[17].f557b[0];
            case GlobalDefine.RESULT_CODE_ERROR_MALFORMEDURL:
            case 14:
                return 19.0d;
            default:
                return d2;
        }
    }

    public static double GetMaximumOfBodyPart(Context context, int i2, int i3, int i4) {
        double d2 = (double) NO_VALUE;
        b a2 = a(context, i2, i3);
        switch (i4) {
            case 0:
                return a2.c[2].c[0] + a2.c[4].c[0] + a2.c[3].c[0] + 20.0d;
            case 1:
                return a2.c[6].c[0];
            case 2:
                return a2.c[0].c[0] + a2.c[1].c[0];
            case 3:
                return a2.c[4].c[0];
            case 4:
                return a2.c[3].c[0];
            case 5:
            case 6:
                return a2.e;
            case 7:
                return a2.c[14].c[0] + ((i2 != 1 || i3 == 1) ? 0.0d : a2.c[9].c[0]);
            case 8:
                return a2.c[9].c[0];
            case 9:
                return a2.c[15].c[0];
            case 10:
                return a2.c[13].c[0];
            case 11:
                return a2.c[16].c[0];
            case 12:
                return a2.c[17].c[0];
            case GlobalDefine.RESULT_CODE_ERROR_MALFORMEDURL:
            case 14:
                return 21.0d;
            default:
                return d2;
        }
    }

    public static double GetDefaultOfBodyPart(Context context, int i2, int i3, int i4) {
        double d2 = (double) NO_VALUE;
        b a2 = a(context, i2, i3);
        if (i3 == 1) {
            switch (i4) {
                case 0:
                    return a2.c[2].d + a2.c[4].d + a2.c[3].d + 20.0d;
                case 1:
                    return a2.c[6].d;
                case 2:
                    return a2.c[1].d + a2.c[0].d;
                case 3:
                    return a2.c[4].d;
                case 4:
                    return a2.c[3].d;
                case 5:
                case 6:
                    return a2.f;
                case 7:
                    return a2.c[14].d;
                case 8:
                    return a2.c[9].d;
                case 9:
                    return a2.c[15].d;
                case 10:
                    return a2.c[13].d;
                case 11:
                    return a2.c[16].d;
                case 12:
                    return a2.c[17].d;
                case GlobalDefine.RESULT_CODE_ERROR_MALFORMEDURL:
                case 14:
                    break;
                default:
                    return d2;
            }
        } else {
            int a3 = (int) a2.f;
            switch (i4) {
                case 0:
                    return a2.c[2].d + a2.c[4].d + a2.c[3].d + 20.0d;
                case 1:
                    return a2.c[6].e[a3];
                case 2:
                    return a2.c[1].d + a2.c[0].d;
                case 3:
                    return a2.c[4].d;
                case 4:
                    return a2.c[3].d;
                case 5:
                case 6:
                    return a2.f;
                case 7:
                    return a2.c[14].e[a3] + (i2 == 1 ? a2.c[9].e[a3] : 0.0d);
                case 8:
                    return a2.c[9].e[a3];
                case 9:
                    return a2.c[15].e[a3];
                case 10:
                    return a2.c[13].e[a3];
                case 11:
                    return a2.c[16].e[a3];
                case 12:
                    return a2.c[17].e[a3];
                case GlobalDefine.RESULT_CODE_ERROR_MALFORMEDURL:
                case 14:
                    break;
                default:
                    return d2;
            }
        }
        return 20.0d;
    }

    private static b a(Context context, int i2, int i3) {
        if (j == null) {
            e();
        }
        int a2 = a(i2, i3);
        b bVar = j.get(a2);
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b(context, i2, i3);
        j.set(a2, bVar2);
        return bVar2;
    }

    private static void e() {
        j = new ArrayList<>();
        for (int i2 = 0; i2 < 6; i2++) {
            j.add((Object) null);
        }
    }

    public static int GetHeadTypeCount(Context context, int i2, int i3) {
        return a(context, i2, i3).f552a.size();
    }

    public static int GetHairTypeCount(Context context, int i2, int i3) {
        return a(context, i2, i3).f553b.size();
    }

    public static HeadTypeFilesInfo GetHeadTypeInfoByIndex(Context context, int i2, int i3, int i4) {
        return a(context, i3, i4).f552a.get(i2);
    }

    public static HairTypeFilesInfo GetHairTypeInfoByIndex(Context context, int i2, int i3, int i4) {
        return a(context, i3, i4).f553b.get(i2);
    }

    public static HeadTypeFilesInfo GetHeadTypeInfoByType(Context context, int i2, int i3, int i4) {
        Iterator<HeadTypeFilesInfo> it = a(context, i3, i4).f552a.iterator();
        while (it.hasNext()) {
            HeadTypeFilesInfo next = it.next();
            if (next.mTypeID == i2) {
                return next;
            }
        }
        return null;
    }

    public static HairTypeFilesInfo GetHairTypeInfoByType(Context context, int i2, int i3, int i4) {
        Iterator<HairTypeFilesInfo> it = a(context, i3, i4).f553b.iterator();
        while (it.hasNext()) {
            HairTypeFilesInfo next = it.next();
            if (next.mTypeID == i2) {
                return next;
            }
        }
        return null;
    }

    public static int GetHeadTypeByIndex(Context context, int i2, int i3, int i4) {
        return GetHeadTypeInfoByIndex(context, i2, i3, i4).mTypeID;
    }

    public static int GetHairTypeByIndex(Context context, int i2, int i3, int i4) {
        return GetHairTypeInfoByIndex(context, i2, i3, i4).mTypeID;
    }

    public static int GetIndexOfHeadType(Context context, int i2, int i3, int i4) {
        b a2 = a(context, i3, i4);
        for (int i5 = 0; i5 < a2.f552a.size(); i5++) {
            if (a2.f552a.get(i5).mTypeID == i2) {
                return i5;
            }
        }
        return -1;
    }

    public static int GetIndexOfHairType(Context context, int i2, int i3, int i4) {
        b a2 = a(context, i3, i4);
        for (int i5 = 0; i5 < a2.f553b.size(); i5++) {
            if (a2.f553b.get(i5).mTypeID == i2) {
                return i5;
            }
        }
        return -1;
    }

    public static ArrayList<TypeResource> GetHeadTypeResources(Context context, int i2, int i3) {
        b a2 = a(context, i2, i3);
        ArrayList<TypeResource> arrayList = new ArrayList<>();
        Iterator<HeadTypeFilesInfo> it = a2.f552a.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().d);
        }
        return arrayList;
    }

    public static ArrayList<TypeResource> GetHairTypeResources(Context context, int i2, int i3) {
        b a2 = a(context, i2, i3);
        ArrayList<TypeResource> arrayList = new ArrayList<>();
        Iterator<HairTypeFilesInfo> it = a2.f553b.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().i);
        }
        return arrayList;
    }

    public static boolean IsExistHeadType(Context context, int i2, int i3, int i4) {
        return GetHeadTypeInfoByType(context, i2, i3, i4) != null;
    }

    public static boolean IsExistHairType(Context context, int i2, int i3, int i4) {
        return GetHairTypeInfoByType(context, i2, i3, i4) != null;
    }

    public static void ClearData() {
        if (j != null) {
            j.clear();
            j = null;
        }
        f = -1;
        g = -1;
        h = (double) NO_VALUE;
        i = (double) NO_VALUE;
        k = null;
    }

    public static double GetValueOfBodyPart(int i2) {
        double d2 = (double) NO_VALUE;
        switch (i2) {
            case 0:
                return e[2] + e[3] + e[4] + 20.0d;
            case 1:
                return e[6];
            case 2:
                return e[0] + e[1];
            case 3:
                return e[4];
            case 4:
                return e[3];
            case 5:
                return h;
            case 6:
                return i;
            case 7:
                return e[14] + ((f != 1 || g == 1) ? 0.0d : e[9]);
            case 8:
                return e[9];
            case 9:
                return e[15];
            case 10:
                return e[13];
            case 11:
                return e[16];
            case 12:
                return e[17];
            case GlobalDefine.RESULT_CODE_ERROR_MALFORMEDURL:
            case 14:
                return c;
            default:
                String str = f544a;
                Log.e(str, "ERROR :: wrong body part : " + i2);
                return d2;
        }
    }

    public double GetAvatarHeighWithoutHeadSize() {
        return GetValueOfBodyPart(0) - 20.0d;
    }

    public int SetValueOfBodyPart(int i2, double d2) {
        double GetDefaultOfBodyPart = Double.compare(d2, (double) NO_VALUE) == 0 ? GetDefaultOfBodyPart(f545b, f, g, i2) : d2;
        switch (i2) {
            case 0:
                a(GetDefaultOfBodyPart);
                break;
            case 1:
                d(GetDefaultOfBodyPart);
                return 5;
            case 2:
                i(GetDefaultOfBodyPart);
                return 0;
            case 3:
                a(GetDefaultOfBodyPart, true);
                return 6;
            case 4:
                b(GetDefaultOfBodyPart, true);
                return 2;
            case 5:
                b(GetDefaultOfBodyPart);
                break;
            case 6:
                c(GetDefaultOfBodyPart);
                break;
            case 7:
                e(GetDefaultOfBodyPart);
                return 1;
            case 8:
                f(GetDefaultOfBodyPart);
                return 3;
            case 9:
                g(GetDefaultOfBodyPart);
                return 8;
            case 10:
                j(GetDefaultOfBodyPart);
                return 0;
            case 11:
                h(GetDefaultOfBodyPart);
                return 4;
            case 12:
                k(GetDefaultOfBodyPart);
                return 7;
            case GlobalDefine.RESULT_CODE_ERROR_MALFORMEDURL:
            case 14:
                c = d2;
                break;
            default:
                String str = f544a;
                Log.e(str, "ERROR :: wrong body part : " + i2);
                break;
        }
        return -1;
    }

    public double GetLowThresholdValueOfBodyPart(int i2) {
        switch (i2) {
            case 0:
                return k.c[2].f557b[0] + k.c[4].f557b[0] + k.c[3].f557b[0] + 20.0d;
            case 1:
                return k.c[6].f557b[0];
            case 2:
                return k.c[1].f557b[0] + k.c[0].f557b[0];
            case 3:
                if (e[2] == k.c[2].c[0]) {
                    return e[4];
                }
                double d2 = k.c[2].c[0] - e[2];
                double d3 = e[4] - k.c[4].f557b[0];
                if (d2 > d3) {
                    d2 = d3;
                }
                return e[4] - d2;
            case 4:
                if (e[2] == k.c[2].c[0]) {
                    return e[3];
                }
                double d4 = k.c[2].c[0] - e[2];
                double d5 = e[3] - k.c[3].f557b[0];
                if (d4 > d5) {
                    d4 = d5;
                }
                return e[3] - d4;
            case 5:
                return k.d;
            case 6:
                return k.d;
            case 7:
                double d6 = k.c[14].f557b[0];
                return (f != 1 || g == 1) ? d6 : k.c[9].f557b[0] + d6;
            case 8:
                return k.c[9].f557b[0];
            case 9:
                return k.c[15].f557b[0];
            case 10:
                return k.c[13].f557b[0];
            case 11:
                return k.c[16].f557b[0];
            case 12:
                return k.c[17].f557b[0];
            case 14:
                return 19.0d;
            default:
                String str = f544a;
                Log.e(str, "ERROR :: wrong body part : " + i2);
                return -1.0d;
        }
    }

    public double GetHighThresholdValueOfBodyPart(int i2) {
        switch (i2) {
            case 0:
                return k.c[2].c[0] + k.c[4].c[0] + k.c[3].c[0] + 20.0d;
            case 1:
                return k.c[6].c[0];
            case 2:
                return k.c[1].c[0] + k.c[0].c[0];
            case 3:
                if (e[2] == k.c[2].f557b[0]) {
                    return e[4];
                }
                double d2 = e[2] - k.c[2].f557b[0];
                double d3 = k.c[4].c[0] - e[4];
                if (d2 > d3) {
                    d2 = d3;
                }
                return d2 + e[4];
            case 4:
                if (e[2] == k.c[2].f557b[0]) {
                    return e[3];
                }
                double d4 = e[2] - k.c[2].f557b[0];
                double d5 = k.c[3].c[0] - e[3];
                if (d4 > d5) {
                    d4 = d5;
                }
                return d4 + e[3];
            case 5:
                return k.e;
            case 6:
                return k.e;
            case 7:
                double d6 = k.c[14].c[0];
                return (f != 1 || g == 1) ? d6 : k.c[9].c[0] + d6;
            case 8:
                return k.c[9].c[0];
            case 9:
                return k.c[15].c[0];
            case 10:
                return k.c[13].c[0];
            case 11:
                return k.c[16].c[0];
            case 12:
                return k.c[17].c[0];
            case 14:
                return 21.0d;
            default:
                String str = f544a;
                Log.e(str, "ERROR :: wrong body part : " + i2);
                return -1.0d;
        }
    }

    static float[] a() {
        float[] fArr = new float[26];
        for (int i2 = 0; i2 < 26; i2++) {
            fArr[i2] = (float) (Math.floor(d[i2] * 1000000.0d) / 1000000.0d);
        }
        return fArr;
    }

    public double GetHeadScale() {
        return (c / 20.0d) * 1.0499999523162842d;
    }

    public void Destroy() {
        ClearData();
    }

    private void a(double d2) {
        double d3;
        double d4;
        double d5;
        double d6;
        double d7;
        double d8;
        double d9;
        double d10;
        double d11;
        double d12;
        double d13;
        double d14;
        double d15;
        double d16;
        double d17;
        double d18;
        double d19;
        double d20;
        double d21;
        double d22 = e[2] + e[3] + e[4];
        double d23 = (d2 - 20.0d) - d22;
        double d24 = (e[2] / d22) * d23;
        double d25 = (e[4] / d22) * d23;
        double d26 = (e[3] / d22) * d23;
        double d27 = e[2] + d24;
        double d28 = e[4] + d25;
        double d29 = e[3] + d26;
        if (d23 <= 0.0d) {
            if (d23 < 0.0d) {
                if (d27 <= k.c[2].f557b[0]) {
                    double d30 = d27 - k.c[2].f557b[0];
                    d17 = k.c[2].f557b[0];
                    double d31 = d25 + d26;
                    d28 += (d25 / d31) * d30;
                    d29 += d30 * (d26 / d31);
                    if (d28 <= k.c[4].f557b[0]) {
                        double d32 = d28 - k.c[4].f557b[0];
                        d20 = k.c[4].f557b[0];
                        d6 = d29 + d32;
                    } else {
                        if (d29 <= k.c[3].f557b[0]) {
                            double d33 = d29 - k.c[3].f557b[0];
                            d18 = k.c[3].f557b[0];
                            d19 = d28 + d33;
                            d4 = d17;
                            d3 = d19;
                            a(d3, false);
                            b(d5, false);
                            l(d4);
                        }
                        d7 = d17;
                        d3 = d28;
                        d5 = d6;
                        a(d3, false);
                        b(d5, false);
                        l(d4);
                    }
                } else if (d28 <= k.c[4].f557b[0]) {
                    double d34 = d28 - k.c[4].f557b[0];
                    d3 = k.c[4].f557b[0];
                    double d35 = d24 + d26;
                    d13 = d27 + ((d24 / d35) * d34);
                    d14 = d29 + (d34 * (d26 / d35));
                    if (d13 <= k.c[2].f557b[0]) {
                        d7 = k.c[2].f557b[0];
                        d6 = d14 + (d13 - k.c[2].f557b[0]);
                        d5 = d6;
                        a(d3, false);
                        b(d5, false);
                        l(d4);
                    }
                    if (d14 <= k.c[3].f557b[0]) {
                        d15 = k.c[3].f557b[0];
                        d16 = d13 + (d14 - k.c[3].f557b[0]);
                        d21 = d16;
                        d5 = d15;
                        d4 = d21;
                        a(d3, false);
                        b(d5, false);
                        l(d4);
                    }
                    d7 = d13;
                    d5 = d6;
                    a(d3, false);
                    b(d5, false);
                    l(d4);
                } else if (d29 <= k.c[3].f557b[0]) {
                    double d36 = d29 - k.c[3].f557b[0];
                    d8 = k.c[3].f557b[0];
                    double d37 = d24 + d25;
                    d9 = d27 + ((d24 / d37) * d36);
                    d10 = d28 + (d36 * (d25 / d37));
                    if (d9 <= k.c[2].f557b[0]) {
                        d4 = k.c[2].f557b[0];
                        d10 += d9 - k.c[2].f557b[0];
                        d18 = d8;
                        d3 = d19;
                        a(d3, false);
                        b(d5, false);
                        l(d4);
                    }
                    if (d10 <= k.c[4].f557b[0]) {
                        d11 = k.c[4].f557b[0];
                        d12 = d9 + (d10 - k.c[4].f557b[0]);
                        d21 = d12;
                        d5 = d8;
                        d3 = d11;
                        d4 = d21;
                        a(d3, false);
                        b(d5, false);
                        l(d4);
                    }
                    d4 = d9;
                    d18 = d8;
                    d3 = d19;
                    a(d3, false);
                    b(d5, false);
                    l(d4);
                }
            }
            d7 = d27;
            d3 = d28;
            d5 = d6;
            a(d3, false);
            b(d5, false);
            l(d4);
        } else if (d27 >= k.c[2].c[0]) {
            double d38 = d27 - k.c[2].c[0];
            d17 = k.c[2].c[0];
            double d39 = d25 + d26;
            d28 += (d25 / d39) * d38;
            d29 += d38 * (d26 / d39);
            if (d28 >= k.c[4].c[0]) {
                double d40 = d28 - k.c[4].c[0];
                d20 = k.c[4].c[0];
                d6 = d29 + d40;
            } else {
                if (d29 >= k.c[3].c[0]) {
                    double d41 = d29 - k.c[3].c[0];
                    d18 = k.c[3].c[0];
                    d19 = d28 + d41;
                    d4 = d17;
                    d3 = d19;
                    a(d3, false);
                    b(d5, false);
                    l(d4);
                }
                d7 = d17;
                d3 = d28;
                d5 = d6;
                a(d3, false);
                b(d5, false);
                l(d4);
            }
        } else if (d28 >= k.c[4].c[0]) {
            double d42 = d28 - k.c[4].c[0];
            d3 = k.c[4].c[0];
            double d43 = d24 + d26;
            d13 = d27 + ((d24 / d43) * d42);
            d14 = d29 + (d42 * (d26 / d43));
            if (d13 >= k.c[2].c[0]) {
                d7 = k.c[2].c[0];
                d6 = d14 + (d13 - k.c[2].c[0]);
                d5 = d6;
                a(d3, false);
                b(d5, false);
                l(d4);
            }
            if (d14 >= k.c[3].c[0]) {
                d15 = k.c[3].c[0];
                d16 = d13 + (d14 - k.c[3].c[0]);
                d21 = d16;
                d5 = d15;
                d4 = d21;
                a(d3, false);
                b(d5, false);
                l(d4);
            }
            d7 = d13;
            d5 = d6;
            a(d3, false);
            b(d5, false);
            l(d4);
        } else {
            if (d29 >= k.c[3].c[0]) {
                double d44 = d29 - k.c[3].c[0];
                d8 = k.c[3].c[0];
                double d45 = d24 + d25;
                d9 = d27 + ((d24 / d45) * d44);
                d10 = d28 + (d44 * (d25 / d45));
                if (d9 >= k.c[2].c[0]) {
                    d4 = k.c[2].c[0];
                    d10 += d9 - k.c[2].c[0];
                    d18 = d8;
                    d3 = d19;
                    a(d3, false);
                    b(d5, false);
                    l(d4);
                }
                if (d10 >= k.c[4].c[0]) {
                    d11 = k.c[4].c[0];
                    d12 = d9 + (d10 - k.c[4].c[0]);
                    d21 = d12;
                    d5 = d8;
                    d3 = d11;
                    d4 = d21;
                    a(d3, false);
                    b(d5, false);
                    l(d4);
                }
                d4 = d9;
                d18 = d8;
                d3 = d19;
                a(d3, false);
                b(d5, false);
                l(d4);
            }
            d7 = d27;
            d3 = d28;
            d5 = d6;
            a(d3, false);
            b(d5, false);
            l(d4);
        }
        d7 = d17;
        d3 = d20;
        d5 = d6;
        a(d3, false);
        b(d5, false);
        l(d4);
    }

    private void f() {
        Matrix solve;
        boolean z;
        long nanoTime = System.nanoTime();
        int[] iArr = (f != 1 || g == 1) ? p : m;
        Matrix matrix = new Matrix(iArr.length, 1);
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int i3 = iArr[i2];
            matrix.set(i2, 0, e[i3] - k.c[i3].d);
            String str = f544a;
            Log.i(str, "delta size of " + i2 + " is " + matrix.get(i2, 0));
        }
        Matrix matrix2 = new Matrix(iArr.length, iArr.length);
        boolean[] zArr = new boolean[iArr.length];
        for (int i4 = 0; i4 < iArr.length; i4++) {
            if (matrix.get(i4, 0) >= 0.0d) {
                zArr[i4] = true;
            } else {
                zArr[i4] = false;
            }
        }
        int i5 = 0;
        do {
            for (int i6 = 0; i6 < iArr.length; i6++) {
                if (zArr[i6]) {
                    for (int i7 = 0; i7 < matrix2.getRowDimension(); i7++) {
                        matrix2.set(i7, i6, k.h.get(i7, i6));
                    }
                } else {
                    for (int i8 = 0; i8 < matrix2.getRowDimension(); i8++) {
                        matrix2.set(i8, i6, k.i.get(i8, i6));
                    }
                }
            }
            solve = matrix2.solve(matrix);
            z = false;
            for (int i9 = 0; i9 < iArr.length; i9++) {
                if (solve.get(i9, 0) < 0.0d) {
                    zArr[i9] = !zArr[i9];
                    z = true;
                }
            }
            String str2 = f544a;
            Log.i(str2, "SolveCorrelatedWeightsFromBodySizes iteration : " + i5);
            i5++;
            if (i5 <= 2) {
                break;
                break;
            }
            break;
        } while (z);
        for (int i10 = 0; i10 < iArr.length; i10++) {
            if (zArr[i10]) {
                int a2 = k.a(iArr[i10], true);
                d[a2] = solve.get(i10, 0);
                d[a2 + 1] = 0.0d;
                if (d[a2] < 0.0d) {
                    String str3 = f544a;
                    Log.e(str3, "NEGATIVE weight " + a2 + " with " + d[a2]);
                }
            } else {
                int a3 = k.a(iArr[i10], false);
                d[a3] = solve.get(i10, 0);
                d[a3 - 1] = 0.0d;
                if (d[a3] < 0.0d) {
                    String str4 = f544a;
                    Log.e(str4, "NEGATIVE weight " + a3 + " with " + d[a3]);
                }
            }
        }
        String str5 = f544a;
        Log.i(str5, "SolveCorrelatedWeightsFromBodySizes time : " + (((float) (System.nanoTime() - nanoTime)) * 1.0E-9f));
    }

    private void b(double d2) {
        h = d2;
        if (g == 1) {
            double d3 = d2 / (k.e - k.d);
            double d4 = (k.c[13].d - k.c[13].f557b[0]) / (k.c[13].c[0] - k.c[13].f557b[0]);
            double d5 = d3 > 0.5d ? d4 + ((1.0d - d4) * (d3 - 0.5d) * 2.0d) : d4 * d3 * 2.0d;
            j(d(d5, k.c[13].f557b[0], k.c[13].c[0]));
            d(d(d5, k.c[6].f557b[0], k.c[6].c[0]));
            e(d(d5, k.c[14].f557b[0], k.c[14].c[0]));
            f(d(d5, k.c[9].f557b[0], k.c[9].c[0]));
            g(d(d5, k.c[15].f557b[0], k.c[15].c[0]));
            return;
        }
        int max = Math.max((int) Math.floor(d2), (int) k.d);
        int min = Math.min(max + 1, (int) k.e);
        double d6 = (double) max;
        Double.isNaN(d6);
        double d7 = d2 - d6;
        int[] iArr = (f != 1 || g == 1) ? p : m;
        int[] iArr2 = (f != 1 || g == 1) ? q : n;
        for (int i2 : iArr2) {
            int i3 = iArr[i2];
            e[i3] = d(d7, k.c[i3].e[max], k.c[i3].e[min]);
        }
        f();
    }

    private void c(double d2) {
        double d3;
        double d4;
        i = d2;
        if (g == 1) {
            double d5 = d2 / (k.e - k.d);
            double d6 = (k.c[17].d - k.c[17].f557b[0]) / (k.c[17].c[0] - k.c[17].f557b[0]);
            double d7 = (k.c[16].d - k.c[16].f557b[0]) / (k.c[16].c[0] - k.c[16].f557b[0]);
            double d8 = k.c[5].d;
            double d9 = k.c[5].f557b[0];
            double d10 = k.c[5].c[0];
            double d11 = k.c[5].f557b[0];
            double d12 = 1.0d - d6;
            double d13 = 1.0d - d7;
            if (d5 > 0.5d) {
                double d14 = d5 - 0.5d;
                d3 = d6 + (d12 * d14 * 2.0d);
                d4 = d7 + (d13 * d14 * 2.0d);
            } else {
                d3 = d6 * d5 * 2.0d;
                d4 = d7 * d5 * 2.0d;
            }
            k(d(d3, k.c[17].f557b[0], k.c[17].c[0]));
            h(d(d4, k.c[16].f557b[0], k.c[16].c[0]));
            return;
        }
        int max = Math.max((int) Math.floor(d2), (int) k.d);
        int min = Math.min(max + 1, (int) k.e);
        double d15 = (double) max;
        Double.isNaN(d15);
        double d16 = d2 - d15;
        int[] iArr = (f != 1 || g == 1) ? p : m;
        int[] iArr2 = (f != 1 || g == 1) ? r : o;
        for (int i2 : iArr2) {
            int i3 = iArr[i2];
            e[i3] = d(d16, k.c[i3].e[max], k.c[i3].e[min]);
        }
        f();
        double[] dArr = d;
        b bVar = k;
        double a2 = (double) b.b(f, g, true);
        double d17 = d[22];
        Double.isNaN(a2);
        dArr[10] = a2 * d17;
        double[] dArr2 = d;
        b bVar2 = k;
        double a3 = (double) b.b(f, g, false);
        double d18 = d[23];
        Double.isNaN(a3);
        dArr2[11] = a3 * d18;
    }

    private void d(double d2) {
        e[6] = d2;
        if (g == 1) {
            double a2 = a(d2, k.c[6].d, k.c[6].f557b[0], k.c[6].c[0]);
            if (a2 > 0.0d) {
                d[12] = a2;
                d[13] = 0.0d;
            } else if (a2 < 0.0d) {
                d[12] = 0.0d;
                d[13] = -a2;
            } else {
                d[12] = 0.0d;
                d[13] = 0.0d;
            }
        } else {
            f();
        }
    }

    private void e(double d2) {
        e[14] = d2;
        if (g == 1) {
            double a2 = a(d2, k.c[14].d, k.c[14].f557b[0], k.c[14].c[0]);
            if (a2 > 0.0d) {
                d[16] = a2;
                d[17] = 0.0d;
            } else if (a2 < 0.0d) {
                d[16] = 0.0d;
                d[17] = -a2;
            } else {
                d[16] = 0.0d;
                d[17] = 0.0d;
            }
        } else {
            if (f == 1) {
                e[14] = d2 - e[9];
            }
            f();
        }
    }

    private void f(double d2) {
        e[9] = d2;
        if (g == 1) {
            double a2 = a(d2, k.c[9].d, k.c[9].f557b[0], k.c[9].c[0]);
            if (a2 > 0.0d) {
                d[18] = a2;
                d[19] = 0.0d;
            } else if (a2 < 0.0d) {
                d[18] = 0.0d;
                d[19] = -a2;
            } else {
                d[18] = 0.0d;
                d[19] = 0.0d;
            }
        } else {
            f();
        }
    }

    private void g(double d2) {
        e[15] = d2;
        if (g == 1) {
            double a2 = a(d2, k.c[15].d, k.c[15].f557b[0], k.c[15].c[0]);
            String str = f544a;
            Log.i(str, "SetWaistCircumference() value : " + d2 + ", weight : " + a2);
            if (a2 > 0.0d) {
                d[20] = a2;
                d[21] = 0.0d;
            } else if (a2 < 0.0d) {
                d[20] = 0.0d;
                d[21] = -a2;
            } else {
                d[20] = 0.0d;
                d[21] = 0.0d;
            }
        } else {
            f();
        }
    }

    private void h(double d2) {
        double d3 = d2;
        e[16] = d3;
        if (g == 1) {
            double a2 = a(d2, k.c[16].d, k.c[16].f557b[0], k.c[16].c[0]);
            String str = f544a;
            Log.i(str, "SetHipSize() value : " + d3 + ", weight : " + a2);
            if (a2 > 0.0d) {
                d[22] = a2;
                d[23] = 0.0d;
            } else if (a2 < 0.0d) {
                d[22] = 0.0d;
                d[23] = -a2;
            } else {
                d[22] = 0.0d;
                d[23] = 0.0d;
            }
            double[] dArr = d;
            b bVar = k;
            double a3 = (double) b.b(f, g, true);
            double d4 = d[22];
            Double.isNaN(a3);
            dArr[10] = a3 * d4;
            double[] dArr2 = d;
            b bVar2 = k;
            double a4 = (double) b.b(f, g, false);
            double d5 = d[23];
            Double.isNaN(a4);
            dArr2[11] = a4 * d5;
            return;
        }
        f();
        double[] dArr3 = d;
        b bVar3 = k;
        double a5 = (double) b.b(f, g, true);
        double d6 = d[22];
        Double.isNaN(a5);
        dArr3[10] = a5 * d6;
        double[] dArr4 = d;
        b bVar4 = k;
        double a6 = (double) b.b(f, g, false);
        double d7 = d[23];
        Double.isNaN(a6);
        dArr4[11] = a6 * d7;
    }

    private void i(double d2) {
        double d3 = d2 - (e[1] + e[0]);
        double d4 = e[1] / (e[0] + e[1]);
        double[] dArr = e;
        dArr[1] = dArr[1] + (d3 * d4);
        double[] dArr2 = e;
        dArr2[0] = dArr2[0] + (d3 * (1.0d - d4));
        double a2 = a(e[1], k.c[1].d, k.c[1].f557b[0], k.c[1].c[0]);
        if (a2 > 0.0d) {
            d[2] = a2;
            d[3] = 0.0d;
        } else {
            d[2] = 0.0d;
            d[3] = -a2;
        }
        double a3 = a(e[0], k.c[0].d, k.c[0].f557b[0], k.c[0].c[0]);
        if (a3 > 0.0d) {
            d[0] = a3;
            d[1] = 0.0d;
            return;
        }
        d[0] = 0.0d;
        d[1] = -a3;
    }

    private void j(double d2) {
        e[13] = d2;
        if (g == 1) {
            double a2 = a(d2, k.c[13].d, k.c[13].f557b[0], k.c[13].c[0]);
            if (a2 > 0.0d) {
                d[14] = a2;
                d[15] = 0.0d;
            } else if (a2 < 0.0d) {
                d[14] = 0.0d;
                d[15] = -a2;
            } else {
                d[14] = 0.0d;
                d[15] = 0.0d;
            }
        } else {
            f();
        }
    }

    private void k(double d2) {
        e[17] = d2;
        if (g == 1) {
            double a2 = a(d2, k.c[17].d, k.c[17].f557b[0], k.c[17].c[0]);
            String str = f544a;
            Log.i(str, "SetLegCircumference() value : " + d2 + ", weight : " + a2);
            if (a2 > 0.0d) {
                d[24] = a2;
                d[25] = 0.0d;
            } else if (a2 < 0.0d) {
                d[24] = 0.0d;
                d[25] = -a2;
            } else {
                d[24] = 0.0d;
                d[25] = 0.0d;
            }
        } else {
            f();
        }
    }

    private void l(double d2) {
        double a2 = a(d2, k.c[2].d, k.c[2].f557b[0], k.c[2].c[0]);
        double d3 = e[2];
        e[2] = d2;
        if (a2 > 0.0d) {
            d[4] = a2;
            d[5] = 0.0d;
        } else if (a2 < 0.0d) {
            d[4] = 0.0d;
            d[5] = -a2;
        } else {
            d[4] = 0.0d;
            d[5] = 0.0d;
        }
    }

    private void a(double d2, boolean z) {
        double a2 = a(d2, k.c[4].d, k.c[4].f557b[0], k.c[4].c[0]);
        double d3 = d2 - e[4];
        if (z) {
            l(e[2] - d3);
        }
        e[4] = d2;
        if (a2 > 0.0d) {
            d[8] = a2;
            d[9] = 0.0d;
        } else if (a2 < 0.0d) {
            d[8] = 0.0d;
            d[9] = -a2;
        } else {
            d[8] = 0.0d;
            d[9] = 0.0d;
        }
    }

    private void b(double d2, boolean z) {
        double a2 = a(d2, k.c[3].d, k.c[3].f557b[0], k.c[3].c[0]);
        double d3 = d2 - e[3];
        if (z) {
            l(e[2] - d3);
        }
        e[3] = d2;
        if (a2 > 0.0d) {
            d[6] = a2;
            d[7] = 0.0d;
        } else if (a2 < 0.0d) {
            d[6] = 0.0d;
            d[7] = -a2;
        } else {
            d[6] = 0.0d;
            d[7] = 0.0d;
        }
    }

    private double a(double d2, double d3, double d4, double d5) {
        if (Double.compare(d2, d3) > 0) {
            if (Double.compare(d5, d3) == 0) {
                return 0.0d;
            }
            return (d2 - d3) / (d5 - d3);
        } else if (Double.compare(d2, d3) >= 0 || Double.compare(d4, d3) == 0) {
            return 0.0d;
        } else {
            return (d2 - d3) / (d3 - d4);
        }
    }

    private static float a(float f2, double d2, double d3, double d4) {
        if (f2 > GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
            double d5 = (double) f2;
            Double.isNaN(d5);
            return (float) ((d5 * (d4 - d2)) + d2);
        } else if (f2 >= GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
            return (float) d2;
        } else {
            double d6 = (double) f2;
            Double.isNaN(d6);
            return (float) ((d6 * (d2 - d3)) + d2);
        }
    }

    public static void SolveCorrelatedBodySizesFromWeights(BodySizeData bodySizeData, int i2, int i3, b bVar, float[] fArr) {
        int[] iArr = (f != 1 || g == 1) ? p : m;
        Matrix matrix = new Matrix(iArr.length, iArr.length);
        Matrix matrix2 = new Matrix(iArr.length, 1);
        for (int i4 = 0; i4 < iArr.length; i4++) {
            int a2 = bVar.a(iArr[i4], true);
            int a3 = bVar.a(iArr[i4], false);
            if ((fArr[a2] > GlobalDefine.DEFAULT_AUTO_FILTER_VALUE && Float.compare(fArr[a3], GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) == 0) || fArr[a3] <= GlobalDefine.DEFAULT_AUTO_FILTER_VALUE || Float.compare(fArr[a2], GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) != 0) {
                for (int i5 = 0; i5 < matrix.getRowDimension(); i5++) {
                    matrix.set(i5, i4, bVar.h.get(i5, i4));
                }
                matrix2.set(i4, 0, (double) fArr[a2]);
            } else {
                for (int i6 = 0; i6 < matrix.getRowDimension(); i6++) {
                    matrix.set(i6, i4, bVar.i.get(i6, i4));
                }
                matrix2.set(i4, 0, (double) fArr[a3]);
            }
        }
        Matrix times = matrix.times(matrix2);
        bodySizeData.mArmThickSize = ((float) times.get(0, 0)) + ((float) bVar.c[13].d);
        bodySizeData.mShoulderSize = ((float) times.get(1, 0)) + ((float) bVar.c[6].d);
        bodySizeData.mCupSize = ((float) times.get(2, 0)) + ((float) bVar.c[9].d);
        bodySizeData.mBustSize = ((float) times.get(3, 0)) + ((float) bVar.c[14].d);
        if (i2 == 1 && i3 != 1) {
            bodySizeData.mBustSize += bodySizeData.mCupSize;
        }
        bodySizeData.mWaistSize = ((float) times.get(4, 0)) + ((float) bVar.c[15].d);
        bodySizeData.mHipSize = ((float) times.get(5, 0)) + ((float) bVar.c[16].d);
        bodySizeData.mThighThickSize = ((float) times.get(6, 0)) + ((float) bVar.c[17].d);
    }

    public static BodySizeData GetBodySizeData(Context context, int i2, int i3, float f2, float f3, float[] fArr, float f4) {
        float f5;
        Context context2 = context;
        int i4 = i2;
        int i5 = i3;
        float f6 = f2;
        float f7 = f3;
        float[] fArr2 = fArr;
        float f8 = f4;
        BodySizeData bodySizeData = new BodySizeData();
        bodySizeData.mTallSize = (float) GetDefaultOfBodyPart(context2, i4, i5, 0);
        bodySizeData.mUpperSize = (float) GetDefaultOfBodyPart(context2, i4, i5, 5);
        bodySizeData.mLowerSize = (float) GetDefaultOfBodyPart(context2, i4, i5, 6);
        bodySizeData.mShoulderSize = (float) GetDefaultOfBodyPart(context2, i4, i5, 1);
        bodySizeData.mBustSize = (float) GetDefaultOfBodyPart(context2, i4, i5, 7);
        bodySizeData.mCupSize = (float) GetDefaultOfBodyPart(context2, i4, i5, 8);
        bodySizeData.mWaistSize = (float) GetDefaultOfBodyPart(context2, i4, i5, 9);
        bodySizeData.mHipSize = (float) GetDefaultOfBodyPart(context2, i4, i5, 11);
        bodySizeData.mArmLengthSize = (float) GetDefaultOfBodyPart(context2, i4, i5, 2);
        bodySizeData.mArmThickSize = (float) GetDefaultOfBodyPart(context2, i4, i5, 10);
        bodySizeData.mThighLengthSize = (float) GetDefaultOfBodyPart(context2, i4, i5, 3);
        bodySizeData.mThighThickSize = (float) GetDefaultOfBodyPart(context2, i4, i5, 12);
        bodySizeData.mCalfLengthSize = (float) GetDefaultOfBodyPart(context2, i4, i5, 4);
        bodySizeData.mHeadHeight = (float) GetDefaultOfBodyPart(context2, i4, i5, 14);
        b a2 = a(context, i2, i3);
        if (Float.compare(f6, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) >= 0) {
            bodySizeData.mUpperSize = (float) c((double) f6, a2.d, a2.e);
        }
        if (Float.compare(f7, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) >= 0) {
            bodySizeData.mLowerSize = (float) c((double) f7, a2.d, a2.e);
        }
        if (Float.compare(f8, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) >= 0) {
            bodySizeData.mHeadHeight = (float) c((double) f8, 19.0d, 21.0d);
        }
        if (fArr2 != null && fArr2.length == 26) {
            for (int i6 = 0; i6 < fArr2.length; i6 += 2) {
                float f9 = fArr2[i6];
                float f10 = fArr2[i6 + 1];
                if (f9 <= GlobalDefine.DEFAULT_AUTO_FILTER_VALUE || Float.compare(f10, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) != 0) {
                    f5 = (f10 <= GlobalDefine.DEFAULT_AUTO_FILTER_VALUE || Float.compare(f9, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) != 0) ? GlobalDefine.DEFAULT_AUTO_FILTER_VALUE : -f10;
                } else {
                    f5 = f9;
                }
                int i7 = i6 / 2;
                switch (i7) {
                    case 7:
                        i7 = 13;
                        break;
                    case 8:
                        i7 = 14;
                        break;
                    case 10:
                        i7 = 15;
                        break;
                    case 11:
                        i7 = 16;
                        break;
                    case 12:
                        i7 = 17;
                        break;
                }
                float a3 = a(f5, a2.c[i7].d, a2.c[i7].f557b[0], a2.c[i7].c[0]);
                if (i7 != 9) {
                    switch (i7) {
                        case 0:
                            bodySizeData.mArmLengthSize = a3;
                            break;
                        case 1:
                            bodySizeData.mArmLengthSize += a3;
                            break;
                        case 2:
                            bodySizeData.mTallSize = a3;
                            break;
                        case 3:
                            bodySizeData.mCalfLengthSize = a3;
                            bodySizeData.mTallSize += a3;
                            break;
                        case 4:
                            bodySizeData.mThighLengthSize = a3;
                            bodySizeData.mTallSize += a3;
                            break;
                        case 5:
                            break;
                        case 6:
                            bodySizeData.mShoulderSize = a3;
                            break;
                        default:
                            switch (i7) {
                                case GlobalDefine.RESULT_CODE_ERROR_MALFORMEDURL:
                                    bodySizeData.mArmThickSize = a3;
                                    break;
                                case 14:
                                    bodySizeData.mBustSize = a3;
                                    break;
                                case GlobalDefine.RESULT_CODE_ERROR_OUT_OF_MEMORY:
                                    bodySizeData.mWaistSize = a3;
                                    break;
                                case GlobalDefine.RESULT_CODE_ERROR_NOT_FOUND_FILE:
                                    bodySizeData.mHipSize = a3;
                                    break;
                                case GlobalDefine.RESULT_CODE_ERROR_FAILED_TO_SAVE_BITMAP:
                                    bodySizeData.mThighThickSize = a3;
                                    break;
                            }
                    }
                } else {
                    bodySizeData.mCupSize = a3;
                }
            }
            double d2 = (double) bodySizeData.mTallSize;
            Double.isNaN(d2);
            bodySizeData.mTallSize = (float) (d2 + 20.0d);
            if (i5 != 1) {
                SolveCorrelatedBodySizesFromWeights(bodySizeData, i4, i5, a2, fArr2);
            }
        }
        return bodySizeData;
    }

    public static void ConvertThicknessToCircumference(Context context, int i2, int i3, BodySizeData bodySizeData) {
        b a2 = a(context, i2, i3);
        if (((double) bodySizeData.mArmThickSize) < a2.c[13].f557b[0]) {
            bodySizeData.mArmThickSize = GetCircumferenceFromDiameter(context, bodySizeData.mArmThickSize, 10, i2, i3);
        }
        if (((double) bodySizeData.mCupSize) > a2.c[9].c[0]) {
            bodySizeData.mCupSize = (float) a2.c[9].d;
        }
        if (((double) bodySizeData.mBustSize) < a2.c[14].f557b[0]) {
            bodySizeData.mBustSize = GetCircumferenceFromDiameter(context, bodySizeData.mBustSize, 7, i2, i3);
            if (i2 == 1 && i3 != 1) {
                bodySizeData.mBustSize += bodySizeData.mCupSize;
            }
        }
        if (((double) bodySizeData.mWaistSize) < a2.c[15].f557b[0]) {
            bodySizeData.mWaistSize = GetCircumferenceFromDiameter(context, bodySizeData.mWaistSize, 9, i2, i3);
        }
        if (((double) bodySizeData.mHipSize) < a2.c[16].f557b[0]) {
            bodySizeData.mHipSize = GetCircumferenceFromDiameter(context, bodySizeData.mHipSize, 11, i2, i3);
        }
        if (((double) bodySizeData.mThighThickSize) < a2.c[17].f557b[0]) {
            bodySizeData.mThighThickSize = GetCircumferenceFromDiameter(context, bodySizeData.mThighThickSize, 12, i2, i3);
        }
    }

    public static float GetCircumferenceFromDiameter(Context context, float f2, int i2, int i3, int i4) {
        float f3 = f2;
        int i5 = i2;
        b a2 = a(context, i3, i4);
        switch (i5) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 8:
            case 14:
                return f3;
            case 7:
                return (a2.c[14].f557b[0] <= 0.0d || a2.c[14].c[0] <= 0.0d) ? f3 : (float) b(a((double) f3, a2.c[8].f557b[0], a2.c[8].c[0]), a2.c[14].f557b[0], a2.c[14].c[0]);
            case 9:
                if (a2.c[15].f557b[0] <= 0.0d || a2.c[15].c[0] <= 0.0d) {
                    return f3;
                }
                return (float) b(a((double) f3, a2.c[10].f557b[0], a2.c[10].c[0]), a2.c[15].f557b[0], a2.c[15].c[0]);
            case 10:
                if (a2.c[13].f557b[0] <= 0.0d || a2.c[13].c[0] <= 0.0d) {
                    return f3;
                }
                return (float) b(a((double) f3, a2.c[7].f557b[0], a2.c[7].c[0]), a2.c[13].f557b[0], a2.c[13].c[0]);
            case 11:
                if (a2.c[16].f557b[0] <= 0.0d || a2.c[16].c[0] <= 0.0d) {
                    return f3;
                }
                return (float) b(a((double) f3, a2.c[11].f557b[0], a2.c[11].c[0]), a2.c[16].f557b[0], a2.c[16].c[0]);
            case 12:
                if (a2.c[17].f557b[0] <= 0.0d || a2.c[17].c[0] <= 0.0d) {
                    return f3;
                }
                return (float) b(a((double) f3, a2.c[12].f557b[0], a2.c[12].c[0]), a2.c[17].f557b[0], a2.c[17].c[0]);
            default:
                String str = f544a;
                Log.e(str, "ERROR :: wrong body part : " + i5);
                return f3;
        }
    }

    public static ArrayList<String> GetBodySizeTextList(Context context, int i2, int i3) {
        return new ArrayList<>(a(context, i2, i3).g);
    }
}
