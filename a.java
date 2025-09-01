package net.fxgear;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* compiled from: AsyncWorker */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final String f659a = a.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Handler f660b;
    private Handler c;
    private HandlerThread d = new HandlerThread(this.f659a);
    private Handler.Callback e = new Handler.Callback() {
        public boolean handleMessage(Message message) {
            if (message == null || message.what != 99 || message.obj == null || !(message.obj instanceof b) || a.this.f660b == null) {
                return false;
            }
            boolean unused = a.this.f = true;
            b bVar = (b) message.obj;
            final C0022a aVar = bVar.f665b;
            bVar.f664a.run();
            if (a.this.f660b == null) {
                return false;
            }
            a.this.f660b.post(new Runnable() {
                public void run() {
                    boolean unused = a.this.f = false;
                    if (aVar != null) {
                        aVar.a();
                    }
                }
            });
            return false;
        }
    };
    /* access modifiers changed from: private */
    public boolean f;

    /* renamed from: net.fxgear.a$a  reason: collision with other inner class name */
    /* compiled from: AsyncWorker */
    public interface C0022a {
        void a();
    }

    /* compiled from: AsyncWorker */
    private class b {

        /* renamed from: a  reason: collision with root package name */
        Runnable f664a;

        /* renamed from: b  reason: collision with root package name */
        C0022a f665b;

        private b() {
        }
    }

    public a() {
        this.d.start();
        this.f660b = new Handler(Looper.getMainLooper());
        this.c = new Handler(this.d.getLooper(), this.e);
    }

    public void a(Runnable runnable, C0022a aVar) {
        if (runnable != null && aVar != null) {
            if (this.c != null) {
                b bVar = new b();
                bVar.f664a = runnable;
                bVar.f665b = aVar;
                this.c.obtainMessage(99, bVar).sendToTarget();
                return;
            }
            Log.e(this.f659a, "Illegal state.");
        }
    }

    public boolean a() {
        if (!this.f) {
            return this.c != null && this.c.hasMessages(99);
        }
        return true;
    }

    public void b() {
        Log.d(this.f659a, "Destroy()+");
        if (this.d != null) {
            this.d.quitSafely();
            this.d = null;
        }
        if (this.f660b != null) {
            this.f660b.removeCallbacksAndMessages((Object) null);
            this.f660b = null;
        }
        if (this.c != null) {
            this.c.removeCallbacksAndMessages((Object) null);
            this.c = null;
        }
    }
}
package net.fxgear;

public class AvatarData {
    public int mAge;
    public float mAutoNormalizedColor;
    public int mAvatarID;
    public BodySizeData mBodyData;
    public String mFolderName;
    public int mGender;
    public int mHairType;
    public int mHeadType;
    public int mHueRGBColor;
    public boolean mIsCustomFace;
    public String mThumbnailPath;
}
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
package net.fxgear;

public class BodySizeData {
    public float mArmLengthSize = AvatarSetting.NO_VALUE;
    public float mArmThickSize = AvatarSetting.NO_VALUE;
    public float mBustSize = AvatarSetting.NO_VALUE;
    public float mCalfLengthSize = AvatarSetting.NO_VALUE;
    public float mCupSize = AvatarSetting.NO_VALUE;
    public float mHeadHeight = 20.0f;
    public float mHipSize = AvatarSetting.NO_VALUE;
    public float mLowerSize = AvatarSetting.NO_VALUE;
    public float mShoulderSize = AvatarSetting.NO_VALUE;
    public float mTallSize = AvatarSetting.NO_VALUE;
    public float mThighLengthSize = AvatarSetting.NO_VALUE;
    public float mThighThickSize = AvatarSetting.NO_VALUE;
    public float mUpperSize = AvatarSetting.NO_VALUE;
    public float mWaistSize = AvatarSetting.NO_VALUE;
}
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
package net.fxgear;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import net.fxgear.AvatarSetting;
import net.fxgear.GlobalDefine;
import net.fxgear.a;
import net.fxgear.b.h;
import net.fxgear.customface.CustomFaceInterface;
import net.fxgear.fittingview.FittingSurfaceView;
import net.fxgear.fittingview.data.FittingFaceData;
import net.fxgear.fittingview.data.a;
import net.fxgear.fittingview.data.b;
import net.fxgear.fittingview.data.c;
import net.fxgear.fittingview.data.d;
import net.fxgear.fittingview.data.e;
import net.fxgear.fittingview.data.f;
import net.fxgear.fittingview.data.g;
import net.fxgear.fittingview.data.h;
import net.fxgear.util.FXUtil;

public class FittingView extends FittingSurfaceView {
    public static final ClothesFileInfo[] EMPTY_CLOTHES = {new ClothesFileInfo(), new ClothesFileInfo(), new ClothesFileInfo(), new ClothesFileInfo(), new ClothesFileInfo()};
    /* access modifiers changed from: private */
    public ClothesFileInfo[] A = new ClothesFileInfo[5];
    /* access modifiers changed from: private */
    public GlobalDefine.ClothesSize[] B = {null, null, null, null, null};
    /* access modifiers changed from: private */
    public AvatarSetting C = null;
    private a D;
    /* access modifiers changed from: private */
    public Bitmap E;
    /* access modifiers changed from: private */
    public final String p = FittingView.class.getSimpleName();
    /* access modifiers changed from: private */
    public int q = 0;
    /* access modifiers changed from: private */
    public int r = 1;
    /* access modifiers changed from: private */
    public int s = 2;
    /* access modifiers changed from: private */
    public int t = 0;
    /* access modifiers changed from: private */
    public int u = 0;
    /* access modifiers changed from: private */
    public RealVideoFileInfo v = new RealVideoFileInfo();
    private int w = -1;
    private boolean x = false;
    private float y = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    private float z = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;

    public interface OnFittingViewListener {
        void OnClothChange(ClothesFileInfo[] clothesFileInfoArr);

        void OnFinishAsyncWork(Runnable runnable);

        void OnOccurError(GlobalDefine.Result result);

        void OnResultCustomFace(GlobalDefine.Result result);

        void OnStartAsyncWork();
    }

    /* access modifiers changed from: private */
    public int b(int i, int i2, int i3) {
        if (i == 0) {
            return 4;
        }
        if (i2 == 2) {
            return i3 == 1 ? 2 : 0;
        }
        if (i2 != 1) {
            return 0;
        }
        if (i3 == 1) {
            return 3;
        }
        return i3 == 2 ? 1 : 0;
    }

    public static class ClothesFileInfo {
        public String mBaseDirectoryPath = null;
        public int mClothType = -1;
        public String mPackageFilePath = null;

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof ClothesFileInfo)) {
                return false;
            }
            ClothesFileInfo clothesFileInfo = (ClothesFileInfo) obj;
            return (this.mClothType != clothesFileInfo.mClothType || this.mBaseDirectoryPath == null || clothesFileInfo.mBaseDirectoryPath == null || !this.mBaseDirectoryPath.equals(clothesFileInfo.mBaseDirectoryPath) || this.mPackageFilePath == null || clothesFileInfo.mPackageFilePath == null || !this.mPackageFilePath.equals(clothesFileInfo.mPackageFilePath)) ? false : true;
        }

        private ClothesFileInfo a() {
            ClothesFileInfo clothesFileInfo = new ClothesFileInfo();
            clothesFileInfo.mClothType = this.mClothType;
            String str = null;
            clothesFileInfo.mBaseDirectoryPath = this.mBaseDirectoryPath != null ? new String(this.mBaseDirectoryPath) : null;
            if (this.mPackageFilePath != null) {
                str = new String(this.mPackageFilePath);
            }
            clothesFileInfo.mPackageFilePath = str;
            return clothesFileInfo;
        }

        /* access modifiers changed from: private */
        public static ClothesFileInfo[] b(ClothesFileInfo[] clothesFileInfoArr) {
            if (clothesFileInfoArr == null) {
                return null;
            }
            ClothesFileInfo[] clothesFileInfoArr2 = new ClothesFileInfo[clothesFileInfoArr.length];
            for (int i = 0; i < clothesFileInfoArr.length; i++) {
                clothesFileInfoArr2[i] = clothesFileInfoArr[i].a();
            }
            return clothesFileInfoArr2;
        }
    }

    public static class RealVideoFileInfo {
        public String mAnimationFilePath = null;
        public String mVideoFilePath = null;

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof RealVideoFileInfo)) {
                return false;
            }
            RealVideoFileInfo realVideoFileInfo = (RealVideoFileInfo) obj;
            return (this.mAnimationFilePath == null || realVideoFileInfo.mAnimationFilePath == null || !this.mAnimationFilePath.equals(realVideoFileInfo.mAnimationFilePath) || this.mVideoFilePath == null || realVideoFileInfo.mVideoFilePath == null || !this.mVideoFilePath.equals(realVideoFileInfo.mVideoFilePath)) ? false : true;
        }

        /* access modifiers changed from: private */
        public RealVideoFileInfo a() {
            RealVideoFileInfo realVideoFileInfo = new RealVideoFileInfo();
            String str = null;
            realVideoFileInfo.mAnimationFilePath = this.mAnimationFilePath != null ? new String(this.mAnimationFilePath) : null;
            if (this.mVideoFilePath != null) {
                str = new String(this.mVideoFilePath);
            }
            realVideoFileInfo.mVideoFilePath = str;
            return realVideoFileInfo;
        }
    }

    public FittingView(Context context, OnFittingViewListener onFittingViewListener) {
        super(context);
        CustomFaceInterface.checkSdkAllowed(context);
        this.D = new a();
        this.C = new AvatarSetting(context);
    }

    public boolean SetBackgroundBGBitmap(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            return false;
        }
        return super.SetBackgroundBGBitmap(bitmap);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x009e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean Initialize(int r3, int r4, int r5, int r6, int r7, int r8, boolean r9, net.fxgear.FittingView.ClothesFileInfo[] r10, net.fxgear.BodySizeData r11, int r12, float r13, net.fxgear.FittingView.OnFittingViewListener r14, java.lang.Runnable r15) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.lang.String r0 = r2.p     // Catch:{ all -> 0x009f }
            java.lang.String r1 = "Initialize()+"
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x009f }
            if (r3 != 0) goto L_0x000f
            java.lang.String r0 = "[ERROR] :: Illegal state. call another Initialize method with parameter RealVideoFileInfo for real mode"
            net.fxgear.util.FXUtil.OccurRunTimeException((java.lang.String) r0)     // Catch:{ all -> 0x009f }
        L_0x000f:
            net.fxgear.a r0 = r2.D     // Catch:{ all -> 0x009f }
            r1 = 0
            if (r0 == 0) goto L_0x009d
            net.fxgear.a r0 = r2.D     // Catch:{ all -> 0x009f }
            boolean r0 = r0.a()     // Catch:{ all -> 0x009f }
            if (r0 != 0) goto L_0x009d
            if (r14 == 0) goto L_0x0021
            r14.OnStartAsyncWork()     // Catch:{ all -> 0x009f }
        L_0x0021:
            r2.q = r3     // Catch:{ all -> 0x009f }
            r2.r = r4     // Catch:{ all -> 0x009f }
            r2.s = r5     // Catch:{ all -> 0x009f }
            r2.t = r6     // Catch:{ all -> 0x009f }
            r2.u = r7     // Catch:{ all -> 0x009f }
            r2.w = r8     // Catch:{ all -> 0x009f }
            r2.x = r9     // Catch:{ all -> 0x009f }
            r2.y = r13     // Catch:{ all -> 0x009f }
            r3 = 3
            float[] r3 = new float[r3]     // Catch:{ all -> 0x009f }
            int r4 = net.fxgear.util.FXUtil.redFromColor(r12)     // Catch:{ all -> 0x009f }
            float r4 = (float) r4     // Catch:{ all -> 0x009f }
            r3[r1] = r4     // Catch:{ all -> 0x009f }
            int r4 = net.fxgear.util.FXUtil.greenFromColor(r12)     // Catch:{ all -> 0x009f }
            float r4 = (float) r4     // Catch:{ all -> 0x009f }
            r5 = 1
            r3[r5] = r4     // Catch:{ all -> 0x009f }
            r4 = 2
            int r6 = net.fxgear.util.FXUtil.blueFromColor(r12)     // Catch:{ all -> 0x009f }
            float r6 = (float) r6     // Catch:{ all -> 0x009f }
            r3[r4] = r6     // Catch:{ all -> 0x009f }
            float r3 = net.fxgear.fittingview.FittingSurfaceView.colorTemperatureToNormalizeValue(r3)     // Catch:{ all -> 0x009f }
            r2.z = r3     // Catch:{ all -> 0x009f }
            int r3 = r2.r     // Catch:{ all -> 0x009f }
            int r4 = r2.s     // Catch:{ all -> 0x009f }
            r2.a((int) r3, (int) r4, (net.fxgear.BodySizeData) r11)     // Catch:{ all -> 0x009f }
            if (r10 == 0) goto L_0x0065
            int r3 = r10.length     // Catch:{ all -> 0x009f }
            net.fxgear.FittingView$ClothesFileInfo[] r4 = r2.A     // Catch:{ all -> 0x009f }
            int r4 = r4.length     // Catch:{ all -> 0x009f }
            if (r3 != r4) goto L_0x0065
            net.fxgear.FittingView$ClothesFileInfo[] r3 = net.fxgear.FittingView.ClothesFileInfo.b(r10)     // Catch:{ all -> 0x009f }
            goto L_0x006b
        L_0x0065:
            net.fxgear.FittingView$ClothesFileInfo[] r3 = EMPTY_CLOTHES     // Catch:{ all -> 0x009f }
            net.fxgear.FittingView$ClothesFileInfo[] r3 = net.fxgear.FittingView.ClothesFileInfo.b(r3)     // Catch:{ all -> 0x009f }
        L_0x006b:
            r11 = r3
            r3 = 0
        L_0x006d:
            net.fxgear.GlobalDefine$ClothesSize[] r4 = r2.B     // Catch:{ all -> 0x009f }
            int r4 = r4.length     // Catch:{ all -> 0x009f }
            if (r3 >= r4) goto L_0x0081
            int r4 = r2.r     // Catch:{ all -> 0x009f }
            int r6 = r2.s     // Catch:{ all -> 0x009f }
            net.fxgear.GlobalDefine$ClothesSize r4 = net.fxgear.ClothesSizeProvider.GetClosestClothSize((int) r4, (int) r6, (int) r3, (boolean) r1)     // Catch:{ all -> 0x009f }
            net.fxgear.GlobalDefine$ClothesSize[] r6 = r2.B     // Catch:{ all -> 0x009f }
            r6[r3] = r4     // Catch:{ all -> 0x009f }
            int r3 = r3 + 1
            goto L_0x006d
        L_0x0081:
            net.fxgear.GlobalDefine$Result r9 = new net.fxgear.GlobalDefine$Result     // Catch:{ all -> 0x009f }
            r9.<init>()     // Catch:{ all -> 0x009f }
            r9.resultCode = r1     // Catch:{ all -> 0x009f }
            net.fxgear.a r3 = r2.D     // Catch:{ all -> 0x009f }
            net.fxgear.FittingView$1 r4 = new net.fxgear.FittingView$1     // Catch:{ all -> 0x009f }
            r4.<init>(r11, r9)     // Catch:{ all -> 0x009f }
            net.fxgear.FittingView$12 r12 = new net.fxgear.FittingView$12     // Catch:{ all -> 0x009f }
            r6 = r12
            r7 = r2
            r8 = r14
            r10 = r15
            r6.<init>(r8, r9, r10, r11)     // Catch:{ all -> 0x009f }
            r3.a((java.lang.Runnable) r4, (net.fxgear.a.C0022a) r12)     // Catch:{ all -> 0x009f }
            monitor-exit(r2)
            return r5
        L_0x009d:
            monitor-exit(r2)
            return r1
        L_0x009f:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.FittingView.Initialize(int, int, int, int, int, int, boolean, net.fxgear.FittingView$ClothesFileInfo[], net.fxgear.BodySizeData, int, float, net.fxgear.FittingView$OnFittingViewListener, java.lang.Runnable):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00bb, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean Initialize(int r9, int r10, int r11, int r12, int r13, net.fxgear.FittingView.RealVideoFileInfo r14, int r15, boolean r16, net.fxgear.FittingView.ClothesFileInfo[] r17, net.fxgear.BodySizeData r18, int r19, float r20, net.fxgear.FittingView.OnFittingViewListener r21, java.lang.Runnable r22) {
        /*
            r8 = this;
            r1 = r8
            r0 = r17
            monitor-enter(r8)
            java.lang.String r2 = r1.p     // Catch:{ all -> 0x00bc }
            java.lang.String r3 = "Initialize()+"
            android.util.Log.d(r2, r3)     // Catch:{ all -> 0x00bc }
            r2 = r14
            boolean r3 = r8.a((net.fxgear.FittingView.RealVideoFileInfo) r14)     // Catch:{ all -> 0x00bc }
            if (r3 != 0) goto L_0x0017
            java.lang.String r3 = "Not found real data or illegal state."
            net.fxgear.util.FXUtil.OccurRunTimeException((java.lang.String) r3)     // Catch:{ all -> 0x00bc }
        L_0x0017:
            net.fxgear.a r3 = r1.D     // Catch:{ all -> 0x00bc }
            r4 = 0
            if (r3 == 0) goto L_0x00ba
            net.fxgear.a r3 = r1.D     // Catch:{ all -> 0x00bc }
            boolean r3 = r3.a()     // Catch:{ all -> 0x00bc }
            if (r3 != 0) goto L_0x00ba
            if (r21 == 0) goto L_0x0029
            r21.OnStartAsyncWork()     // Catch:{ all -> 0x00bc }
        L_0x0029:
            r5 = r9
            r1.q = r5     // Catch:{ all -> 0x00bc }
            r5 = r10
            r1.r = r5     // Catch:{ all -> 0x00bc }
            r5 = r11
            r1.s = r5     // Catch:{ all -> 0x00bc }
            r5 = r12
            r1.t = r5     // Catch:{ all -> 0x00bc }
            r5 = r13
            r1.u = r5     // Catch:{ all -> 0x00bc }
            net.fxgear.FittingView$RealVideoFileInfo r2 = r14.a()     // Catch:{ all -> 0x00bc }
            r1.v = r2     // Catch:{ all -> 0x00bc }
            r2 = r15
            r1.w = r2     // Catch:{ all -> 0x00bc }
            r2 = r16
            r1.x = r2     // Catch:{ all -> 0x00bc }
            r2 = r20
            r1.y = r2     // Catch:{ all -> 0x00bc }
            r2 = 3
            float[] r2 = new float[r2]     // Catch:{ all -> 0x00bc }
            int r5 = net.fxgear.util.FXUtil.redFromColor(r19)     // Catch:{ all -> 0x00bc }
            float r5 = (float) r5     // Catch:{ all -> 0x00bc }
            r2[r4] = r5     // Catch:{ all -> 0x00bc }
            int r5 = net.fxgear.util.FXUtil.greenFromColor(r19)     // Catch:{ all -> 0x00bc }
            float r5 = (float) r5     // Catch:{ all -> 0x00bc }
            r6 = 1
            r2[r6] = r5     // Catch:{ all -> 0x00bc }
            r5 = 2
            int r7 = net.fxgear.util.FXUtil.blueFromColor(r19)     // Catch:{ all -> 0x00bc }
            float r7 = (float) r7     // Catch:{ all -> 0x00bc }
            r2[r5] = r7     // Catch:{ all -> 0x00bc }
            float r2 = net.fxgear.fittingview.FittingSurfaceView.colorTemperatureToNormalizeValue(r2)     // Catch:{ all -> 0x00bc }
            r1.z = r2     // Catch:{ all -> 0x00bc }
            int r2 = r1.r     // Catch:{ all -> 0x00bc }
            int r5 = r1.s     // Catch:{ all -> 0x00bc }
            r7 = r18
            r8.a((int) r2, (int) r5, (net.fxgear.BodySizeData) r7)     // Catch:{ all -> 0x00bc }
            if (r0 == 0) goto L_0x007f
            int r2 = r0.length     // Catch:{ all -> 0x00bc }
            net.fxgear.FittingView$ClothesFileInfo[] r5 = r1.A     // Catch:{ all -> 0x00bc }
            int r5 = r5.length     // Catch:{ all -> 0x00bc }
            if (r2 != r5) goto L_0x007f
            net.fxgear.FittingView$ClothesFileInfo[] r0 = net.fxgear.FittingView.ClothesFileInfo.b(r17)     // Catch:{ all -> 0x00bc }
            goto L_0x0085
        L_0x007f:
            net.fxgear.FittingView$ClothesFileInfo[] r0 = EMPTY_CLOTHES     // Catch:{ all -> 0x00bc }
            net.fxgear.FittingView$ClothesFileInfo[] r0 = net.fxgear.FittingView.ClothesFileInfo.b(r0)     // Catch:{ all -> 0x00bc }
        L_0x0085:
            r2 = 0
        L_0x0086:
            net.fxgear.GlobalDefine$ClothesSize[] r5 = r1.B     // Catch:{ all -> 0x00bc }
            int r5 = r5.length     // Catch:{ all -> 0x00bc }
            if (r2 >= r5) goto L_0x009a
            int r5 = r1.r     // Catch:{ all -> 0x00bc }
            int r7 = r1.s     // Catch:{ all -> 0x00bc }
            net.fxgear.GlobalDefine$ClothesSize r5 = net.fxgear.ClothesSizeProvider.GetClosestClothSize((int) r5, (int) r7, (int) r2, (boolean) r4)     // Catch:{ all -> 0x00bc }
            net.fxgear.GlobalDefine$ClothesSize[] r7 = r1.B     // Catch:{ all -> 0x00bc }
            r7[r2] = r5     // Catch:{ all -> 0x00bc }
            int r2 = r2 + 1
            goto L_0x0086
        L_0x009a:
            net.fxgear.GlobalDefine$Result r2 = new net.fxgear.GlobalDefine$Result     // Catch:{ all -> 0x00bc }
            r2.<init>()     // Catch:{ all -> 0x00bc }
            r2.resultCode = r4     // Catch:{ all -> 0x00bc }
            net.fxgear.a r4 = r1.D     // Catch:{ all -> 0x00bc }
            net.fxgear.FittingView$23 r5 = new net.fxgear.FittingView$23     // Catch:{ all -> 0x00bc }
            r5.<init>(r0, r2)     // Catch:{ all -> 0x00bc }
            net.fxgear.FittingView$34 r7 = new net.fxgear.FittingView$34     // Catch:{ all -> 0x00bc }
            r9 = r7
            r10 = r8
            r11 = r21
            r12 = r2
            r13 = r22
            r14 = r0
            r9.<init>(r11, r12, r13, r14)     // Catch:{ all -> 0x00bc }
            r4.a((java.lang.Runnable) r5, (net.fxgear.a.C0022a) r7)     // Catch:{ all -> 0x00bc }
            monitor-exit(r8)
            return r6
        L_0x00ba:
            monitor-exit(r8)
            return r4
        L_0x00bc:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.FittingView.Initialize(int, int, int, int, int, net.fxgear.FittingView$RealVideoFileInfo, int, boolean, net.fxgear.FittingView$ClothesFileInfo[], net.fxgear.BodySizeData, int, float, net.fxgear.FittingView$OnFittingViewListener, java.lang.Runnable):boolean");
    }

    public void onDestroy() {
        Log.d(this.p, "onDestroy()+");
        if (this.D != null) {
            this.D.b();
            this.D = null;
        }
        if (this.C != null) {
            this.C.Destroy();
            this.C = null;
        }
        if (this.E != null) {
            if (this.E.isRecycled()) {
                this.E.recycle();
            }
            this.E = null;
        }
        super.onDestroy();
    }

    private boolean a(RealVideoFileInfo realVideoFileInfo) {
        if (realVideoFileInfo != null && realVideoFileInfo.mAnimationFilePath != null && realVideoFileInfo.mVideoFilePath != null) {
            return true;
        }
        Log.e(this.p, "[ERROR] :: invalid real video file info");
        return false;
    }

    /* access modifiers changed from: private */
    public b a(int i, int i2, int i3, int i4, int i5) {
        String str;
        String str2;
        int i6;
        File file;
        File file2;
        String str3;
        int i7 = i;
        int i8 = i2;
        Log.d(this.p, "CreateAvatarData()+");
        b bVar = new b();
        boolean z2 = false;
        if (i7 != 2) {
            if (i7 != 1) {
                bVar.a(1);
                str3 = GlobalDefine.DIRECTORY_NAME_WOMAN;
            } else if (i8 == 1) {
                bVar.a(3);
                str2 = String.format(GlobalDefine.FORMAT_PATH_DEPTH_1, new Object[]{GlobalDefine.DIRECTORY_NAME_COMMON, GlobalDefine.DIRECTORY_NAME_KIDS});
                str = GlobalDefine.DIRECTORY_NAME_GIRL;
                i6 = 3;
            } else {
                bVar.a(1);
                str3 = GlobalDefine.DIRECTORY_NAME_WOMAN;
            }
            str2 = str3;
            str = str2;
            i6 = 1;
        } else if (i8 == 1) {
            bVar.a(2);
            str2 = String.format(GlobalDefine.FORMAT_PATH_DEPTH_1, new Object[]{GlobalDefine.DIRECTORY_NAME_COMMON, GlobalDefine.DIRECTORY_NAME_KIDS});
            str = GlobalDefine.DIRECTORY_NAME_BOY;
            i6 = 2;
        } else {
            bVar.a(0);
            str2 = "Man";
            str = str2;
            i6 = 0;
        }
        bVar.b(i6);
        File GetAvatarDirectory = GlobalDefine.GetAvatarDirectory(getContext());
        File file3 = new File(String.format(GlobalDefine.FORMAT_PATH_DEPTH_1, new Object[]{GetAvatarDirectory.getAbsoluteFile(), str2}), GlobalDefine.DIRECTORY_NAME_BODY);
        File file4 = new File(String.format(GlobalDefine.FORMAT_PATH_DEPTH_1, new Object[]{GetAvatarDirectory.getAbsoluteFile(), str}), GlobalDefine.DIRECTORY_NAME_BODY);
        if (!file3.exists() || !file3.isDirectory() || !file4.exists() || !file4.isDirectory()) {
            FXUtil.OccurRunTimeException(file3 + " & " + file4);
        } else {
            c cVar = new c();
            cVar.a(i6);
            File file5 = new File(file3, GlobalDefine.FILE_NAME_MESH);
            if (!file5.exists() || !file5.isFile()) {
                FXUtil.OccurRunTimeException(file5);
            } else {
                cVar.a(file5.getAbsolutePath());
            }
            ArrayList<String> GetBodyTextureFileNames = GlobalDefine.GetBodyTextureFileNames(getContext(), i7, i8);
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = GetBodyTextureFileNames.iterator();
            while (it.hasNext()) {
                File file6 = new File(file4, it.next());
                if (file6.exists()) {
                    arrayList.add(file6.getAbsolutePath());
                }
            }
            cVar.a((ArrayList<String>) arrayList);
            File file7 = new File(file4, GlobalDefine.GetBodyTextureFileName(getContext(), i7, i8, i3));
            if (!file7.exists()) {
                file7 = new File(file4, GlobalDefine.GetBodyTextureFileName(getContext(), i7, i8, 0));
            }
            if (!file7.exists() || !file7.isFile()) {
                FXUtil.OccurRunTimeException(file7);
            } else {
                cVar.b(file7.getAbsolutePath());
            }
            for (int i9 = 1; i9 <= 26; i9++) {
                File file8 = new File(file3, String.format(GlobalDefine.FILE_NAME_FORMAT_BLEND_TARGET, new Object[]{Integer.valueOf(i9)}));
                if (!file8.exists() || !file8.isFile()) {
                    FXUtil.OccurRunTimeException(file8);
                } else {
                    cVar.c(file8.getAbsolutePath());
                }
            }
            for (int i10 = 0; i10 < 9; i10++) {
                File a2 = a(file3, i10);
                if (!a2.exists() || !a2.isFile()) {
                    FXUtil.OccurRunTimeException(a2);
                } else {
                    cVar.a(i10, a2.getAbsolutePath());
                }
            }
            bVar.a(cVar);
        }
        bVar.a(this.y);
        bVar.b(this.z);
        bVar.c((float) this.C.GetHeadScale());
        File file9 = new File(String.format(GlobalDefine.FORMAT_PATH_DEPTH_1, new Object[]{GetAvatarDirectory.getAbsoluteFile(), str}), GlobalDefine.DIRECTORY_NAME_HEAD);
        if (!file9.exists() || !file9.isDirectory()) {
            FXUtil.OccurRunTimeException(file9);
        } else {
            f fVar = new f();
            fVar.a(i6);
            boolean z3 = this.x;
            AvatarSetting.HeadTypeFilesInfo GetHeadTypeInfoByIndex = AvatarSetting.GetHeadTypeInfoByIndex(getContext(), i4, i7, i8);
            if (z3) {
                File GetAvatarRuntimeDirectory = GlobalDefine.GetAvatarRuntimeDirectory(getContext());
                fVar.a(true);
                String[] GetCustomFaceFile = FittingFaceData.GetCustomFaceFile(GetAvatarRuntimeDirectory.getAbsolutePath());
                file = null;
                if (GetCustomFaceFile == null || GetCustomFaceFile.length <= 0) {
                    FXUtil.OccurRunTimeException("[ERROR] :: Not found custom face files.");
                    file2 = null;
                } else {
                    File file10 = new File(GetCustomFaceFile[3]);
                    File a3 = a(GetCustomFaceFile, GetHeadTypeInfoByIndex.mTypeID);
                    if (a3 == null) {
                        FXUtil.OccurRunTimeException("[ERROR] :: Not found custom mesh file.");
                    }
                    File file11 = file10;
                    file = a3;
                    file2 = file11;
                }
            } else {
                file = GetHeadTypeInfoByIndex.f549b;
                file2 = GetHeadTypeInfoByIndex.c;
            }
            if (!file.exists() || !file.isFile()) {
                FXUtil.OccurRunTimeException(file);
            } else {
                fVar.a(file.getAbsolutePath());
            }
            if (!file2.exists() || !file2.isFile()) {
                FXUtil.OccurRunTimeException(file2);
            } else {
                fVar.b(file2.getAbsolutePath());
            }
            bVar.a(fVar);
        }
        File file12 = new File(String.format(GlobalDefine.FORMAT_PATH_DEPTH_1, new Object[]{GetAvatarDirectory.getAbsoluteFile(), str}), GlobalDefine.DIRECTORY_NAME_HAIR);
        if (!file12.exists() || !file12.isDirectory()) {
            FXUtil.OccurRunTimeException(file12);
        } else {
            e eVar = new e();
            eVar.b(i6);
            AvatarSetting.HairTypeFilesInfo GetHairTypeInfoByIndex = AvatarSetting.GetHairTypeInfoByIndex(getContext(), i5, i7, i8);
            AvatarSetting.c cVar2 = GetHairTypeInfoByIndex.j;
            e.b bVar2 = new e.b();
            bVar2.a(cVar2.f559b);
            bVar2.b(cVar2.c);
            bVar2.c(cVar2.d);
            bVar2.d(cVar2.e);
            bVar2.e(cVar2.f);
            bVar2.a(cVar2.g);
            bVar2.b(cVar2.h);
            bVar2.c(cVar2.i);
            eVar.a(cVar2.f558a);
            eVar.a(bVar2);
            if (GetHairTypeInfoByIndex.k != null) {
                AvatarSetting.a aVar = GetHairTypeInfoByIndex.k;
                e.a aVar2 = new e.a();
                File file13 = aVar.f550a;
                if (!file13.exists() || !file13.isFile()) {
                    FXUtil.OccurRunTimeException(file13);
                } else {
                    aVar2.a(file13.getAbsolutePath());
                }
                e.b bVar3 = new e.b();
                bVar3.a(aVar.f551b.f559b);
                bVar3.b(aVar.f551b.c);
                bVar3.c(aVar.f551b.d);
                bVar3.d(aVar.f551b.e);
                bVar3.a(aVar.f551b.g);
                bVar3.b(aVar.f551b.h);
                bVar3.c(aVar.f551b.i);
                aVar2.a(aVar.f551b.f558a);
                aVar2.a(bVar3);
                eVar.a(aVar2);
            }
            File file14 = GetHairTypeInfoByIndex.f547b;
            if (!file14.exists() || !file14.isFile()) {
                FXUtil.OccurRunTimeException(file14);
            } else {
                eVar.a(file14.getAbsolutePath());
            }
            File file15 = GetHairTypeInfoByIndex.c;
            if (!file15.exists() || !file15.isFile()) {
                FXUtil.OccurRunTimeException(file15);
            } else {
                eVar.d(file15.getAbsolutePath());
            }
            File file16 = GetHairTypeInfoByIndex.d;
            if (!file16.exists() || !file16.isFile()) {
                FXUtil.OccurRunTimeException(file16);
            } else {
                eVar.d(file16.getAbsolutePath());
            }
            File file17 = GetHairTypeInfoByIndex.e;
            if (!file17.exists() || !file17.isFile()) {
                FXUtil.OccurRunTimeException(file17);
            } else {
                eVar.d(file17.getAbsolutePath());
            }
            File file18 = GetHairTypeInfoByIndex.f;
            if (!file18.exists() || !file18.isFile()) {
                FXUtil.OccurRunTimeException(file18);
            } else {
                eVar.d(file18.getAbsolutePath());
            }
            File file19 = GetHairTypeInfoByIndex.g;
            if (file19 == null || !file19.exists()) {
                z2 = true;
            } else {
                eVar.b(file19.getAbsolutePath());
            }
            File file20 = GetHairTypeInfoByIndex.h;
            if (file20 != null && file20.exists()) {
                eVar.c(file20.getAbsolutePath());
                z2 = !z2;
            }
            if (!z2) {
                FXUtil.OccurRunTimeException("ERROR :: wrong anitmaion files");
            }
            bVar.a(eVar);
        }
        File GetAvatarFaceCommonDirectory = GlobalDefine.GetAvatarFaceCommonDirectory(getContext(), i7, i8);
        File GetAvatarFaceDirectory = GlobalDefine.GetAvatarFaceDirectory(getContext(), i7, i8);
        if (!GetAvatarFaceCommonDirectory.exists() || !GetAvatarFaceCommonDirectory.isDirectory()) {
            FXUtil.OccurRunTimeException(GetAvatarFaceCommonDirectory);
        } else {
            FittingFaceData fittingFaceData = new FittingFaceData(0, (String) null, (int[]) null, FittingFaceData.a.FEMALE, i6, GetAvatarFaceDirectory.getAbsolutePath() + File.separator, GetAvatarFaceCommonDirectory.getAbsolutePath() + File.separator, (String) null);
            fittingFaceData.SetModelGender(i6);
            bVar.a(fittingFaceData);
        }
        return bVar;
    }

    private File a(String[] strArr, int i) {
        String format = String.format(GlobalDefine.FILE_NAME_KEYWORD_FORMAT_CUSTOM_MESH_TYPE, new Object[]{Integer.valueOf(i)});
        for (String str : strArr) {
            if (str != null) {
                File file = new File(str);
                if (file.getName().endsWith(GlobalDefine.EXTENSION_BIN) && file.getName().startsWith(format)) {
                    return file;
                }
            }
        }
        return null;
    }

    private File a(File file, int i) {
        String str;
        if (file == null || !file.exists() || !file.isDirectory()) {
            Log.e(this.p, "ERROR :: Wrong body directory.");
            return null;
        } else if (i < 0 || i > 8) {
            Log.e(this.p, "ERROR :: Wrong body texture file index.");
            return null;
        } else {
            switch (i) {
                case 0:
                    str = GlobalDefine.FILE_NAME_BODY_TEXTURE_ARM_THICK;
                    break;
                case 1:
                    str = GlobalDefine.FILE_NAME_BODY_TEXTURE_BUST;
                    break;
                case 2:
                    str = GlobalDefine.FILE_NAME_BODY_TEXTURE_CALF_LENGTH;
                    break;
                case 3:
                    str = GlobalDefine.FILE_NAME_BODY_TEXTURE_CUP_SIZE;
                    break;
                case 4:
                    str = GlobalDefine.FILE_NAME_BODY_TEXTURE_HIP;
                    break;
                case 5:
                    str = GlobalDefine.FILE_NAME_BODY_TEXTURE_SHOULDER;
                    break;
                case 6:
                    str = GlobalDefine.FILE_NAME_BODY_TEXTURE_THIGH_LENGTH;
                    break;
                case 7:
                    str = GlobalDefine.FILE_NAME_BODY_TEXTURE_THIGH_THICK;
                    break;
                default:
                    str = GlobalDefine.FILE_NAME_BODY_TEXTURE_WAIST;
                    break;
            }
            File file2 = new File(file, str);
            if (file2.exists() && file2.isFile()) {
                return file2;
            }
            Log.e(this.p, "ERROR :: Not found body texture file.");
            return null;
        }
    }

    /* access modifiers changed from: private */
    public a a(int i, int i2, int i3) {
        String str;
        String str2 = this.p;
        Log.d(str2, "CreateAnimationData()+, animationType : " + i3);
        a aVar = new a();
        int i4 = 3;
        if (i == 2) {
            if (i2 == 1) {
                str = GlobalDefine.DIRECTORY_NAME_BOY;
                i4 = 2;
            } else {
                str = "Man";
                i4 = 0;
            }
        } else if (i != 1) {
            str = GlobalDefine.DIRECTORY_NAME_WOMAN;
        } else if (i2 == 1) {
            str = GlobalDefine.DIRECTORY_NAME_GIRL;
        } else {
            str = GlobalDefine.DIRECTORY_NAME_WOMAN;
            i4 = 1;
        }
        aVar.a(i4);
        File file = new File(GlobalDefine.GetAnimationDirectory(getContext()).getAbsoluteFile(), str);
        if (!file.exists() || !file.isDirectory()) {
            FXUtil.OccurRunTimeException(file);
        } else {
            File GetBoneAnimationFile = GlobalDefine.GetBoneAnimationFile(getContext(), i, i2, i3);
            if (GetBoneAnimationFile == null || !GetBoneAnimationFile.exists()) {
                GetBoneAnimationFile = GlobalDefine.GetBoneAnimationFile(getContext(), i, i2, 0);
            }
            if (!GetBoneAnimationFile.exists() || !GetBoneAnimationFile.isFile()) {
                FXUtil.OccurRunTimeException(GetBoneAnimationFile);
            } else {
                aVar.b(GetBoneAnimationFile.getAbsolutePath());
            }
            File file2 = new File(file, GlobalDefine.FILE_NAME_BONE_HIERARCHY);
            if (!file2.exists() || !file2.isFile()) {
                FXUtil.OccurRunTimeException(file2);
            } else {
                aVar.a(file2.getAbsolutePath());
            }
            for (int i5 = 1; i5 <= 16; i5++) {
                File file3 = new File(file, String.format(GlobalDefine.FILE_NAME_FORMAT_BLEND_TARGET, new Object[]{Integer.valueOf(i5)}));
                if (!file3.exists() || !file3.isFile()) {
                    FXUtil.OccurRunTimeException(file3);
                } else {
                    aVar.c(file3.getAbsolutePath());
                }
            }
        }
        return aVar;
    }

    /* access modifiers changed from: private */
    public h b(RealVideoFileInfo realVideoFileInfo) {
        Log.d(this.p, "CreateRealData()+");
        File file = null;
        if (realVideoFileInfo != null) {
            h hVar = new h();
            hVar.a(4);
            if (this.r == 2) {
                if (this.s == 1) {
                    hVar.b(2);
                } else {
                    hVar.b(0);
                }
            } else if (this.s == 1) {
                hVar.b(3);
            } else {
                hVar.b(1);
            }
            File file2 = realVideoFileInfo.mAnimationFilePath != null ? new File(realVideoFileInfo.mAnimationFilePath) : null;
            if (file2 == null || !file2.exists() || !file2.isFile()) {
                Log.e(this.p, "[ERROR] :: animationFile is null");
                FXUtil.OccurRunTimeException(file2);
            } else {
                hVar.a(file2.getAbsolutePath());
            }
            if (realVideoFileInfo.mVideoFilePath != null) {
                file = new File(realVideoFileInfo.mVideoFilePath);
            }
            if (file == null || !file.exists() || !file.isFile()) {
                Log.e(this.p, "[ERROR] :: videoFile is null");
                FXUtil.OccurRunTimeException(file);
            } else {
                hVar.b(file.getAbsolutePath());
            }
            return hVar;
        }
        Log.e(this.p, "[ERROR] :: realVideoFileInfo is null");
        return null;
    }

    private ClothesFileInfo[] a(ClothesFileInfo clothesFileInfo, ClothesFileInfo[] clothesFileInfoArr) {
        boolean z2;
        if (clothesFileInfoArr == null || clothesFileInfoArr.length != 5) {
            return null;
        }
        ClothesFileInfo[] a2 = ClothesFileInfo.b(clothesFileInfoArr);
        if (clothesFileInfo == null || clothesFileInfo.mBaseDirectoryPath == null) {
            z2 = true;
        } else {
            String name = new File(clothesFileInfo.mBaseDirectoryPath).getName();
            boolean z3 = GlobalDefine.GetClothesCategoryType(name) == GlobalDefine.CLOTHES_CATEGORY_TYPE.Swimsuit;
            z2 = GlobalDefine.GetClothesCategoryType(name) == GlobalDefine.CLOTHES_CATEGORY_TYPE.Jumpsuit;
            for (ClothesFileInfo clothesFileInfo2 : a2) {
                if (clothesFileInfo2.mBaseDirectoryPath != null) {
                    if (z3 != (GlobalDefine.GetClothesCategoryType(new File(clothesFileInfo2.mBaseDirectoryPath).getName()) == GlobalDefine.CLOTHES_CATEGORY_TYPE.Swimsuit)) {
                        clothesFileInfo2.mBaseDirectoryPath = null;
                        clothesFileInfo2.mPackageFilePath = null;
                    }
                }
            }
        }
        switch (clothesFileInfo.mClothType) {
            case 0:
                if (!(a2[2].mBaseDirectoryPath == null || GlobalDefine.GetClothesCategoryType(new File(a2[2].mBaseDirectoryPath).getName()) == GlobalDefine.CLOTHES_CATEGORY_TYPE.Jumpsuit)) {
                    a2[2].mBaseDirectoryPath = null;
                    a2[2].mPackageFilePath = null;
                    break;
                }
            case 1:
                a2[2].mBaseDirectoryPath = null;
                a2[2].mPackageFilePath = null;
                break;
            case 2:
                if (!z2) {
                    a2[0].mBaseDirectoryPath = null;
                    a2[0].mPackageFilePath = null;
                }
                a2[1].mBaseDirectoryPath = null;
                a2[1].mPackageFilePath = null;
                break;
            case 3:
                a2[4].mBaseDirectoryPath = null;
                a2[4].mPackageFilePath = null;
                break;
            case 4:
                a2[3].mBaseDirectoryPath = null;
                a2[3].mPackageFilePath = null;
                break;
        }
        return a2;
    }

    /* access modifiers changed from: private */
    public g a(int i, int i2, int i3, float[] fArr, float f, ClothesFileInfo[] clothesFileInfoArr) {
        Log.d(this.p, "GenerateModeData()+");
        g gVar = new g();
        if (i != 0) {
            switch (i) {
                case 2:
                case 7:
                    gVar.a(h.e.AVATAR_BODY_EDITING);
                    break;
                case 3:
                    gVar.a(h.e.AVATAR_HAIR_EDITING);
                    break;
                case 4:
                    gVar.a(h.e.AVATAR_FACE_EDITING);
                    break;
                case 5:
                    gVar.a(h.e.AVATAR_SKIN_TONE_EDITING);
                    break;
                case 6:
                    gVar.a(h.e.AVATAR_CUSTOM_FACE_EDITING);
                    break;
                case 8:
                    gVar.a(h.e.CHECK_CLOTHES_SIZE);
                    break;
                default:
                    gVar.a(h.e.AVATAR);
                    break;
            }
        } else {
            gVar.a(h.e.REAL);
        }
        boolean z2 = false;
        if (i2 == 2) {
            gVar.a(0);
        } else if (i2 == 1) {
            gVar.a(1);
        } else {
            gVar.a(2);
            Log.d(this.p, "gender - GENDER_UNISEX");
        }
        if (i3 == 1) {
            gVar.b(0);
        } else if (i3 == 2) {
            gVar.b(1);
        } else {
            gVar.b(2);
            Log.d(this.p, "gender - AGE_OLD");
        }
        gVar.a(fArr);
        gVar.a(f);
        h.e e = gVar.e();
        if (e == h.e.REAL || e == h.e.AVATAR || e == h.e.CHECK_CLOTHES_SIZE) {
            z2 = true;
        }
        ArrayList<d> a2 = a(clothesFileInfoArr, z2, b(i, i2, i3));
        if (a2 == null) {
            return null;
        }
        gVar.a(a2);
        return gVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.util.ArrayList<net.fxgear.fittingview.data.d>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: java.util.ArrayList<net.fxgear.fittingview.data.d>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: java.util.ArrayList<net.fxgear.fittingview.data.d>} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<net.fxgear.fittingview.data.d> a(net.fxgear.FittingView.ClothesFileInfo[] r18, boolean r19, int r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r3 = r20
            java.lang.String r4 = r0.p
            java.lang.String r5 = "GenerateClothDataList()+"
            android.util.Log.d(r4, r5)
            r4 = 0
            if (r1 != 0) goto L_0x0018
            java.lang.String r1 = r0.p
            java.lang.String r2 = "[ERROR] :: clothesFileInfoArray is null"
            android.util.Log.e(r1, r2)
            return r4
        L_0x0018:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            int r6 = r0.r
            r7 = 2
            r8 = 0
            r9 = 1
            if (r6 != r7) goto L_0x002c
            int r6 = r0.s
            if (r6 != r9) goto L_0x002a
            r6 = 2
            goto L_0x0037
        L_0x002a:
            r6 = 0
            goto L_0x0037
        L_0x002c:
            int r6 = r0.r
            if (r6 != r9) goto L_0x0036
            int r6 = r0.s
            if (r6 != r9) goto L_0x0036
            r6 = 3
            goto L_0x0037
        L_0x0036:
            r6 = 1
        L_0x0037:
            r11 = 5
            if (r1 == 0) goto L_0x02b5
            int r12 = r1.length
            if (r12 != r11) goto L_0x02b5
            r12 = 0
        L_0x003e:
            int r13 = r1.length
            if (r12 >= r13) goto L_0x02b3
            r13 = r1[r12]
            if (r13 == 0) goto L_0x0283
            java.lang.String r14 = r13.mBaseDirectoryPath
            if (r14 == 0) goto L_0x0268
            java.lang.String r14 = r13.mPackageFilePath
            if (r14 != 0) goto L_0x004f
            goto L_0x0268
        L_0x004f:
            int r14 = r13.mClothType
            if (r12 != r14) goto L_0x0235
            net.fxgear.fittingview.data.d r14 = new net.fxgear.fittingview.data.d
            r14.<init>()
            r14.b((int) r12)
            if (r19 == 0) goto L_0x005f
            r15 = -1
            goto L_0x0060
        L_0x005f:
            r15 = 1
        L_0x0060:
            r14.c((int) r15)
            r14.a((int) r3)
            net.fxgear.GlobalDefine$ClothesSize[] r15 = r0.B
            r15 = r15[r12]
            int r15 = r15.ordinal()
            r14.e((int) r15)
            java.io.File r15 = new java.io.File
            java.lang.String r10 = r13.mBaseDirectoryPath
            r15.<init>(r10)
            java.lang.String r10 = r15.getName()
            r14.a((java.lang.String) r10)
            if (r19 == 0) goto L_0x0233
            boolean r16 = r15.exists()
            if (r16 != 0) goto L_0x00a2
            java.lang.String r1 = r0.p
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "[ERROR] :: wrong baseDirectory path : "
            r2.append(r3)
            java.lang.String r3 = r15.getAbsolutePath()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r1, r2)
            return r4
        L_0x00a2:
            java.lang.String r11 = r13.mPackageFilePath
            if (r11 != 0) goto L_0x00b2
            java.lang.String r11 = r0.p
            java.lang.String r4 = "ERROR :: Not found package file."
            android.util.Log.e(r11, r4)
            r14.c((int) r9)
            r4 = 0
            goto L_0x00b9
        L_0x00b2:
            java.io.File r4 = new java.io.File
            java.lang.String r11 = r13.mPackageFilePath
            r4.<init>(r11)
        L_0x00b9:
            int r11 = r14.d()
            if (r11 == r9) goto L_0x0230
            boolean r11 = r4.exists()
            if (r11 == 0) goto L_0x0216
            boolean r4 = r4.isFile()
            if (r4 == 0) goto L_0x0216
            java.lang.String r4 = r13.mPackageFilePath
            r14.b((java.lang.String) r4)
            r4 = 1
        L_0x00d1:
            r11 = 26
            if (r4 > r11) goto L_0x0129
            java.lang.String r11 = "Cloth%s_Tar%s.bin"
            java.lang.Object[] r13 = new java.lang.Object[r7]
            java.lang.String r16 = net.fxgear.GlobalDefine.GetClothTargetName(r10)
            r13[r8] = r16
            java.lang.String r7 = "%03d"
            java.lang.Object[] r1 = new java.lang.Object[r9]
            java.lang.Integer r16 = java.lang.Integer.valueOf(r4)
            r1[r8] = r16
            java.lang.String r1 = java.lang.String.format(r7, r1)
            r13[r9] = r1
            java.lang.String r1 = java.lang.String.format(r11, r13)
            java.io.File r7 = new java.io.File
            r7.<init>(r15, r1)
            java.lang.String r1 = r7.getAbsolutePath()
            boolean r11 = r7.exists()
            if (r11 == 0) goto L_0x0111
            boolean r7 = r7.isFile()
            if (r7 == 0) goto L_0x0111
            r14.d((java.lang.String) r1)
            int r4 = r4 + 1
            r1 = r18
            r7 = 2
            goto L_0x00d1
        L_0x0111:
            java.lang.String r2 = r0.p
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "[ERROR] :: wrong blendTargetFile path : "
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            android.util.Log.e(r2, r1)
            r1 = 0
            return r1
        L_0x0129:
            java.lang.String r1 = "Cloth%s_Tar%s.bin"
            r4 = 2
            java.lang.Object[] r7 = new java.lang.Object[r4]
            java.lang.String r4 = net.fxgear.GlobalDefine.GetClothTargetName(r10)
            r7[r8] = r4
            java.lang.String r4 = "%03d"
            java.lang.Object[] r11 = new java.lang.Object[r9]
            java.lang.Integer r13 = java.lang.Integer.valueOf(r8)
            r11[r8] = r13
            java.lang.String r4 = java.lang.String.format(r4, r11)
            r7[r9] = r4
            java.lang.String r1 = java.lang.String.format(r1, r7)
            java.io.File r4 = new java.io.File
            r4.<init>(r15, r1)
            java.lang.String r1 = r4.getAbsolutePath()
            boolean r7 = r4.exists()
            if (r7 == 0) goto L_0x0176
            boolean r4 = r4.isFile()
            if (r4 == 0) goto L_0x0176
            r14.d((java.lang.String) r1)
            java.lang.String r4 = r0.p
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r11 = "Adding Tar000 of "
            r7.append(r11)
            r7.append(r1)
            java.lang.String r1 = r7.toString()
            android.util.Log.i(r4, r1)
        L_0x0176:
            java.io.File r1 = new java.io.File
            java.lang.String r4 = "Cloth%s_Base.bin"
            java.lang.Object[] r7 = new java.lang.Object[r9]
            java.lang.String r11 = net.fxgear.GlobalDefine.GetClothTargetName(r10)
            r7[r8] = r11
            java.lang.String r4 = java.lang.String.format(r4, r7)
            r1.<init>(r15, r4)
            java.lang.String r4 = r1.getAbsolutePath()
            boolean r7 = r1.exists()
            if (r7 == 0) goto L_0x01fe
            boolean r1 = r1.isFile()
            if (r1 == 0) goto L_0x01fe
            r14.c((java.lang.String) r4)
            net.fxgear.GlobalDefine$CLOTHES_CATEGORY_TYPE r1 = net.fxgear.GlobalDefine.GetClothesCategoryType(r10)
            r14.a((net.fxgear.GlobalDefine.CLOTHES_CATEGORY_TYPE) r1)
            net.fxgear.GlobalDefine$CLOTHES_CATEGORY_TYPE r4 = net.fxgear.GlobalDefine.CLOTHES_CATEGORY_TYPE.TuckIn
            if (r1 != r4) goto L_0x0230
            r1 = 1
        L_0x01a8:
            r4 = 8
            if (r1 > r4) goto L_0x0230
            java.lang.String r4 = "Cloth%s_Tuckin_Tar%s.bin"
            r7 = 2
            java.lang.Object[] r11 = new java.lang.Object[r7]
            java.lang.String r13 = net.fxgear.GlobalDefine.GetClothTargetName(r10)
            r11[r8] = r13
            java.lang.String r13 = "%03d"
            java.lang.Object[] r7 = new java.lang.Object[r9]
            java.lang.Integer r16 = java.lang.Integer.valueOf(r1)
            r7[r8] = r16
            java.lang.String r7 = java.lang.String.format(r13, r7)
            r11[r9] = r7
            java.lang.String r4 = java.lang.String.format(r4, r11)
            java.io.File r7 = new java.io.File
            r7.<init>(r15, r4)
            java.lang.String r4 = r7.getAbsolutePath()
            boolean r11 = r7.exists()
            if (r11 == 0) goto L_0x01e6
            boolean r7 = r7.isFile()
            if (r7 == 0) goto L_0x01e6
            r14.g(r4)
            int r1 = r1 + 1
            goto L_0x01a8
        L_0x01e6:
            java.lang.String r1 = r0.p
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "[ERROR] :: wrong tuckinTargetFile path : "
            r2.append(r3)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r1, r2)
            r1 = 0
            return r1
        L_0x01fe:
            java.lang.String r1 = r0.p
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "[ERROR] :: wrong baseMeshFile path : "
            r2.append(r3)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r1, r2)
            r1 = 0
            return r1
        L_0x0216:
            java.lang.String r1 = r0.p
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "[ERROR] :: wrong packageFile path : "
            r2.append(r3)
            java.lang.String r3 = r13.mPackageFilePath
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.e(r1, r2)
            r1 = 0
            return r1
        L_0x0230:
            r1 = 0
            goto L_0x02a4
        L_0x0233:
            r1 = r4
            goto L_0x02a4
        L_0x0235:
            r1 = r4
            java.lang.String r4 = r0.p
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r10 = "ERROR :: wrong clothType = "
            r7.append(r10)
            int r10 = r13.mClothType
            r7.append(r10)
            java.lang.String r7 = r7.toString()
            android.util.Log.e(r4, r7)
            net.fxgear.fittingview.data.d r14 = new net.fxgear.fittingview.data.d
            r14.<init>()
            r14.b((int) r12)
            r14.c((int) r9)
            r14.a((int) r3)
            net.fxgear.GlobalDefine$ClothesSize[] r4 = r0.B
            r4 = r4[r12]
            int r4 = r4.ordinal()
            r14.e((int) r4)
            goto L_0x02a4
        L_0x0268:
            r1 = r4
            net.fxgear.fittingview.data.d r14 = new net.fxgear.fittingview.data.d
            r14.<init>()
            r14.b((int) r12)
            r14.c((int) r9)
            r14.a((int) r3)
            net.fxgear.GlobalDefine$ClothesSize[] r4 = r0.B
            r4 = r4[r12]
            int r4 = r4.ordinal()
            r14.e((int) r4)
            goto L_0x02a4
        L_0x0283:
            r1 = r4
            java.lang.String r4 = r0.p
            java.lang.String r7 = "ERROR :: clothesFileInfo is null"
            android.util.Log.e(r4, r7)
            net.fxgear.fittingview.data.d r14 = new net.fxgear.fittingview.data.d
            r14.<init>()
            r14.b((int) r12)
            r14.c((int) r9)
            r14.a((int) r3)
            net.fxgear.GlobalDefine$ClothesSize[] r4 = r0.B
            r4 = r4[r12]
            int r4 = r4.ordinal()
            r14.e((int) r4)
        L_0x02a4:
            r14.d((int) r6)
            r5.add(r14)
            int r12 = r12 + 1
            r4 = r1
            r1 = r18
            r7 = 2
            r11 = 5
            goto L_0x003e
        L_0x02b3:
            r1 = r4
            goto L_0x02e2
        L_0x02b5:
            r1 = r4
            java.lang.String r2 = r0.p
            java.lang.String r4 = "WARNING :: param error."
            android.util.Log.e(r2, r4)
        L_0x02bd:
            r2 = 5
            if (r8 >= r2) goto L_0x02e2
            net.fxgear.fittingview.data.d r2 = new net.fxgear.fittingview.data.d
            r2.<init>()
            r2.b((int) r8)
            r2.c((int) r9)
            r2.a((int) r3)
            r2.d((int) r6)
            net.fxgear.GlobalDefine$ClothesSize[] r4 = r0.B
            r4 = r4[r8]
            int r4 = r4.ordinal()
            r2.e((int) r4)
            r5.add(r2)
            int r8 = r8 + 1
            goto L_0x02bd
        L_0x02e2:
            android.content.Context r2 = r17.getContext()
            int r4 = r0.r
            int r7 = r0.s
            r8 = 5
            java.io.File r2 = net.fxgear.GlobalDefine.GetClothTypeDirectory(r2, r4, r7, r8)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r7 = r2.getAbsolutePath()
            r4.append(r7)
            java.lang.String r7 = java.io.File.separator
            r4.append(r7)
            java.lang.String r7 = "Mesh.bin"
            r4.append(r7)
            java.lang.String r4 = r4.toString()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r2 = r2.getAbsolutePath()
            r7.append(r2)
            java.lang.String r2 = java.io.File.separator
            r7.append(r2)
            java.lang.String r2 = "Texture.png"
            r7.append(r2)
            java.lang.String r2 = r7.toString()
            java.io.File r7 = new java.io.File
            r7.<init>(r4)
            boolean r8 = r7.exists()
            if (r8 == 0) goto L_0x0334
            boolean r7 = r7.isFile()
            if (r7 != 0) goto L_0x0335
        L_0x0334:
            r4 = r1
        L_0x0335:
            java.io.File r7 = new java.io.File
            r7.<init>(r2)
            boolean r8 = r7.exists()
            if (r8 == 0) goto L_0x0348
            boolean r7 = r7.isFile()
            if (r7 != 0) goto L_0x0347
            goto L_0x0348
        L_0x0347:
            r1 = r2
        L_0x0348:
            if (r4 == 0) goto L_0x0368
            if (r1 == 0) goto L_0x0368
            net.fxgear.fittingview.data.d r2 = new net.fxgear.fittingview.data.d
            r2.<init>()
            r7 = 5
            r2.b((int) r7)
            r7 = -1
            r2.c((int) r7)
            r2.a((int) r3)
            r2.e((java.lang.String) r4)
            r2.f(r1)
            r2.d((int) r6)
            r5.add(r2)
        L_0x0368:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.FittingView.a(net.fxgear.FittingView$ClothesFileInfo[], boolean, int):java.util.ArrayList");
    }

    /* access modifiers changed from: private */
    public int a(ArrayList<d> arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            return 0;
        }
        Iterator<d> it = arrayList.iterator();
        while (it.hasNext()) {
            String a2 = it.next().a();
            if (a2 != null && a2.equals(GlobalDefine.BASE_CATEGORY_NAME_WEDDING)) {
                return 1;
            }
        }
        return 0;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003a, code lost:
        r3 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int b(java.util.ArrayList<net.fxgear.fittingview.data.d> r8) {
        /*
            r7 = this;
            int r0 = r7.q
            r1 = 0
            r2 = 8
            if (r0 != r2) goto L_0x0008
            return r1
        L_0x0008:
            r0 = 1
            if (r8 == 0) goto L_0x004f
            boolean r2 = r8.isEmpty()
            if (r2 != 0) goto L_0x004f
            java.util.Iterator r8 = r8.iterator()
            r2 = 0
            r3 = 0
        L_0x0017:
            boolean r4 = r8.hasNext()
            if (r4 == 0) goto L_0x0044
            java.lang.Object r4 = r8.next()
            net.fxgear.fittingview.data.d r4 = (net.fxgear.fittingview.data.d) r4
            int r5 = r4.c()
            r6 = -1
            switch(r5) {
                case 0: goto L_0x003c;
                case 1: goto L_0x0034;
                case 2: goto L_0x002c;
                default: goto L_0x002b;
            }
        L_0x002b:
            goto L_0x0017
        L_0x002c:
            int r4 = r4.d()
            if (r4 != r6) goto L_0x0017
            r2 = 1
            goto L_0x003a
        L_0x0034:
            int r4 = r4.d()
            if (r4 != r6) goto L_0x0017
        L_0x003a:
            r3 = 1
            goto L_0x0017
        L_0x003c:
            int r4 = r4.d()
            if (r4 != r6) goto L_0x0017
            r2 = 1
            goto L_0x0017
        L_0x0044:
            if (r2 == 0) goto L_0x004c
            if (r3 == 0) goto L_0x004a
            r1 = 3
            goto L_0x004f
        L_0x004a:
            r1 = 1
            goto L_0x004f
        L_0x004c:
            if (r3 == 0) goto L_0x004f
            r1 = 2
        L_0x004f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.FittingView.b(java.util.ArrayList):int");
    }

    private boolean a() {
        File GetAvatarRuntimeDirectory = GlobalDefine.GetAvatarRuntimeDirectory(getContext());
        if (!GetAvatarRuntimeDirectory.exists() || !GetAvatarRuntimeDirectory.isDirectory()) {
            Log.w(this.p, "[WARNING] :: Not found avatar runtime directory.");
        } else {
            String[] GetCustomFaceFile = FittingFaceData.GetCustomFaceFile(GetAvatarRuntimeDirectory.getAbsolutePath());
            if (GetCustomFaceFile == null || GetCustomFaceFile.length <= 0) {
                Log.w(this.p, "[WARNING] :: Not found custom face files.");
            } else {
                String str = GetCustomFaceFile[3];
                if (str != null) {
                    File file = new File(str);
                    if (!file.exists() || !file.isFile()) {
                        Log.e(this.p, "[ERROR] :: Not found custom texture file.");
                        return false;
                    }
                    int GetHeadTypeCount = AvatarSetting.GetHeadTypeCount(getContext(), this.r, this.s);
                    int i = 0;
                    while (i < GetHeadTypeCount) {
                        int i2 = AvatarSetting.GetHeadTypeInfoByIndex(getContext(), i, this.r, this.s).mTypeID;
                        File a2 = a(GetCustomFaceFile, i2);
                        if (a2 == null) {
                            String str2 = this.p;
                            Log.e(str2, "[ERROR] :: Custom mesh file path is null.(type : " + i2 + ")");
                            return false;
                        } else if (!a2.exists() || !a2.isFile()) {
                            String str3 = this.p;
                            Log.e(str3, "[ERROR] :: Not found custom mesh file.(type : " + i2 + ")");
                            return false;
                        } else {
                            i++;
                        }
                    }
                    return true;
                }
                Log.e(this.p, "[ERROR] :: Custom texture file path is null.");
                return false;
            }
        }
        return false;
    }

    public int GetCurrentMode() {
        return this.q;
    }

    public int GetCurrentGender() {
        return this.r;
    }

    public int GetCurrentAge() {
        return this.s;
    }

    public RealVideoFileInfo GetCurrentRealVideoFileInfo() {
        return this.v;
    }

    public int GetCurrentAvatarID() {
        return this.w;
    }

    public int GetCurrentHeadTypeIndex() {
        return this.t;
    }

    public int GetCurrentHairTypeIndex() {
        return this.u;
    }

    public Bitmap GetScreenShotImage() {
        if (this.E == null || this.E.isRecycled()) {
            return null;
        }
        return this.E;
    }

    public boolean IsWorkingRenderer() {
        if (this.D != null) {
            return this.D.a();
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0050, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean SetMode(int r4, final net.fxgear.FittingView.OnFittingViewListener r5, final java.lang.Runnable r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = r3.p     // Catch:{ all -> 0x0051 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0051 }
            r1.<init>()     // Catch:{ all -> 0x0051 }
            java.lang.String r2 = "SetMode()+, mode : "
            r1.append(r2)     // Catch:{ all -> 0x0051 }
            r1.append(r4)     // Catch:{ all -> 0x0051 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0051 }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x0051 }
            int r0 = r3.q     // Catch:{ all -> 0x0051 }
            r1 = 0
            if (r0 == r4) goto L_0x004f
            net.fxgear.a r0 = r3.D     // Catch:{ all -> 0x0051 }
            if (r0 == 0) goto L_0x0048
            net.fxgear.a r0 = r3.D     // Catch:{ all -> 0x0051 }
            boolean r0 = r0.a()     // Catch:{ all -> 0x0051 }
            if (r0 != 0) goto L_0x0048
            if (r5 == 0) goto L_0x002d
            r5.OnStartAsyncWork()     // Catch:{ all -> 0x0051 }
        L_0x002d:
            r3.q = r4     // Catch:{ all -> 0x0051 }
            net.fxgear.GlobalDefine$Result r4 = new net.fxgear.GlobalDefine$Result     // Catch:{ all -> 0x0051 }
            r4.<init>()     // Catch:{ all -> 0x0051 }
            r4.resultCode = r1     // Catch:{ all -> 0x0051 }
            net.fxgear.a r0 = r3.D     // Catch:{ all -> 0x0051 }
            net.fxgear.FittingView$42 r1 = new net.fxgear.FittingView$42     // Catch:{ all -> 0x0051 }
            r1.<init>(r4)     // Catch:{ all -> 0x0051 }
            net.fxgear.FittingView$43 r2 = new net.fxgear.FittingView$43     // Catch:{ all -> 0x0051 }
            r2.<init>(r5, r4, r6)     // Catch:{ all -> 0x0051 }
            r0.a((java.lang.Runnable) r1, (net.fxgear.a.C0022a) r2)     // Catch:{ all -> 0x0051 }
            r4 = 1
            monitor-exit(r3)
            return r4
        L_0x0048:
            java.lang.String r4 = r3.p     // Catch:{ all -> 0x0051 }
            java.lang.String r5 = "fittingView working."
            android.util.Log.d(r4, r5)     // Catch:{ all -> 0x0051 }
        L_0x004f:
            monitor-exit(r3)
            return r1
        L_0x0051:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.FittingView.SetMode(int, net.fxgear.FittingView$OnFittingViewListener, java.lang.Runnable):boolean");
    }

    public synchronized boolean SetCharacter(int i, int i2, int i3, int i4, int i5, boolean z2, ClothesFileInfo[] clothesFileInfoArr, BodySizeData bodySizeData, int i6, float f, OnFittingViewListener onFittingViewListener, Runnable runnable) {
        ClothesFileInfo[] clothesFileInfoArr2;
        Log.d(this.p, "SetCharacter()+");
        if (this.q == 0) {
            Log.e(this.p, "[ERROR] :: Illegal state. call another SetCharacter method with parameter RealVideoFileInfo for real mode");
            return false;
        } else if (this.D == null || this.D.a()) {
            Log.d(this.p, "fittingView working.");
            return false;
        } else {
            if (onFittingViewListener != null) {
                onFittingViewListener.OnStartAsyncWork();
            }
            final boolean z3 = this.w != i5;
            this.s = i2;
            this.r = i;
            this.t = i3;
            this.u = i4;
            this.w = i5;
            this.x = z2;
            this.y = f;
            this.z = FittingSurfaceView.colorTemperatureToNormalizeValue(new float[]{(float) FXUtil.redFromColor(i6), (float) FXUtil.greenFromColor(i6), (float) FXUtil.blueFromColor(i6)});
            a(this.r, this.s, bodySizeData);
            if (clothesFileInfoArr == null || clothesFileInfoArr.length != this.A.length) {
                clothesFileInfoArr2 = ClothesFileInfo.b(EMPTY_CLOTHES);
            } else {
                clothesFileInfoArr2 = ClothesFileInfo.b(clothesFileInfoArr);
            }
            final ClothesFileInfo[] clothesFileInfoArr3 = clothesFileInfoArr2;
            for (int i7 = 0; i7 < this.B.length; i7++) {
                this.B[i7] = ClothesSizeProvider.GetClosestClothSize(this.r, this.s, i7, false);
            }
            final GlobalDefine.Result result = new GlobalDefine.Result();
            result.resultCode = 0;
            final OnFittingViewListener onFittingViewListener2 = onFittingViewListener;
            final Runnable runnable2 = runnable;
            this.D.a((Runnable) new Runnable() {
                public void run() {
                    try {
                        AvatarSetting unused = FittingView.this.C;
                        float[] a2 = AvatarSetting.a();
                        float GetAvatarHeighWithoutHeadSize = (float) FittingView.this.C.GetAvatarHeighWithoutHeadSize();
                        int unused2 = FittingView.this.b(FittingView.this.q, FittingView.this.r, FittingView.this.s);
                        g a3 = FittingView.this.a(FittingView.this.q, FittingView.this.r, FittingView.this.s, a2, GetAvatarHeighWithoutHeadSize, clothesFileInfoArr3);
                        if (a3 == null) {
                            result.resultCode = 3;
                            return;
                        }
                        ClothesFileInfo[] unused3 = FittingView.this.A = clothesFileInfoArr3;
                        FittingView.this.SetModeData((net.fxgear.fittingview.data.h) null, FittingView.this.a(FittingView.this.r, FittingView.this.s, FittingView.this.b(a3.c()), FittingView.this.t, FittingView.this.u), FittingView.this.a(FittingView.this.r, FittingView.this.s, FittingView.this.a(a3.c())), a3, (FittingFaceData) null, z3);
                        result.resultCode = -1;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        result.resultCode = -3;
                        result.resultExtra = th;
                    }
                }
            }, (a.C0022a) new a.C0022a() {
                public void a() {
                    if (onFittingViewListener2 == null) {
                        return;
                    }
                    if (result.resultCode == -1) {
                        onFittingViewListener2.OnFinishAsyncWork(runnable2);
                        onFittingViewListener2.OnClothChange(clothesFileInfoArr3);
                        return;
                    }
                    onFittingViewListener2.OnOccurError(result);
                }
            });
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0096 A[LOOP:0: B:29:0x0091->B:31:0x0096, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean SetCharacter(int r10, int r11, int r12, int r13, net.fxgear.FittingView.RealVideoFileInfo r14, int r15, boolean r16, net.fxgear.FittingView.ClothesFileInfo[] r17, net.fxgear.BodySizeData r18, int r19, float r20, net.fxgear.FittingView.OnFittingViewListener r21, java.lang.Runnable r22) {
        /*
            r9 = this;
            r1 = r9
            r0 = r14
            r2 = r15
            r3 = r17
            monitor-enter(r9)
            java.lang.String r4 = r1.p     // Catch:{ all -> 0x00ce }
            java.lang.String r5 = "SetCharacter()+"
            android.util.Log.d(r4, r5)     // Catch:{ all -> 0x00ce }
            boolean r4 = r9.a((net.fxgear.FittingView.RealVideoFileInfo) r14)     // Catch:{ all -> 0x00ce }
            r5 = 0
            if (r4 != 0) goto L_0x0016
            monitor-exit(r9)
            return r5
        L_0x0016:
            net.fxgear.a r4 = r1.D     // Catch:{ all -> 0x00ce }
            if (r4 == 0) goto L_0x00c5
            net.fxgear.a r4 = r1.D     // Catch:{ all -> 0x00ce }
            boolean r4 = r4.a()     // Catch:{ all -> 0x00ce }
            if (r4 != 0) goto L_0x00c5
            if (r21 == 0) goto L_0x0027
            r21.OnStartAsyncWork()     // Catch:{ all -> 0x00ce }
        L_0x0027:
            int r6 = r1.w     // Catch:{ all -> 0x00ce }
            r7 = 1
            if (r6 != r2) goto L_0x0038
            net.fxgear.FittingView$RealVideoFileInfo r6 = r1.v     // Catch:{ all -> 0x00ce }
            boolean r6 = r6.equals(r14)     // Catch:{ all -> 0x00ce }
            if (r6 != 0) goto L_0x0035
            goto L_0x0038
        L_0x0035:
            r6 = r11
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r6 = r11
            r8 = 1
        L_0x003a:
            r1.s = r6     // Catch:{ all -> 0x00ce }
            r6 = r10
            r1.r = r6     // Catch:{ all -> 0x00ce }
            r6 = r12
            r1.t = r6     // Catch:{ all -> 0x00ce }
            r6 = r13
            r1.u = r6     // Catch:{ all -> 0x00ce }
            net.fxgear.FittingView$RealVideoFileInfo r0 = r14.a()     // Catch:{ all -> 0x00ce }
            r1.v = r0     // Catch:{ all -> 0x00ce }
            r1.w = r2     // Catch:{ all -> 0x00ce }
            r0 = r16
            r1.x = r0     // Catch:{ all -> 0x00ce }
            r0 = r20
            r1.y = r0     // Catch:{ all -> 0x00ce }
            r0 = 3
            float[] r0 = new float[r0]     // Catch:{ all -> 0x00ce }
            int r2 = net.fxgear.util.FXUtil.redFromColor(r19)     // Catch:{ all -> 0x00ce }
            float r2 = (float) r2     // Catch:{ all -> 0x00ce }
            r0[r5] = r2     // Catch:{ all -> 0x00ce }
            int r2 = net.fxgear.util.FXUtil.greenFromColor(r19)     // Catch:{ all -> 0x00ce }
            float r2 = (float) r2     // Catch:{ all -> 0x00ce }
            r0[r7] = r2     // Catch:{ all -> 0x00ce }
            r2 = 2
            int r6 = net.fxgear.util.FXUtil.blueFromColor(r19)     // Catch:{ all -> 0x00ce }
            float r6 = (float) r6     // Catch:{ all -> 0x00ce }
            r0[r2] = r6     // Catch:{ all -> 0x00ce }
            float r0 = net.fxgear.fittingview.FittingSurfaceView.colorTemperatureToNormalizeValue(r0)     // Catch:{ all -> 0x00ce }
            r1.z = r0     // Catch:{ all -> 0x00ce }
            int r0 = r1.r     // Catch:{ all -> 0x00ce }
            int r2 = r1.s     // Catch:{ all -> 0x00ce }
            r6 = r18
            r9.a((int) r0, (int) r2, (net.fxgear.BodySizeData) r6)     // Catch:{ all -> 0x00ce }
            if (r3 == 0) goto L_0x008a
            int r0 = r3.length     // Catch:{ all -> 0x00ce }
            net.fxgear.FittingView$ClothesFileInfo[] r2 = r1.A     // Catch:{ all -> 0x00ce }
            int r2 = r2.length     // Catch:{ all -> 0x00ce }
            if (r0 != r2) goto L_0x008a
            net.fxgear.FittingView$ClothesFileInfo[] r0 = net.fxgear.FittingView.ClothesFileInfo.b(r17)     // Catch:{ all -> 0x00ce }
            goto L_0x0090
        L_0x008a:
            net.fxgear.FittingView$ClothesFileInfo[] r0 = EMPTY_CLOTHES     // Catch:{ all -> 0x00ce }
            net.fxgear.FittingView$ClothesFileInfo[] r0 = net.fxgear.FittingView.ClothesFileInfo.b(r0)     // Catch:{ all -> 0x00ce }
        L_0x0090:
            r2 = 0
        L_0x0091:
            net.fxgear.GlobalDefine$ClothesSize[] r3 = r1.B     // Catch:{ all -> 0x00ce }
            int r3 = r3.length     // Catch:{ all -> 0x00ce }
            if (r2 >= r3) goto L_0x00a5
            int r3 = r1.r     // Catch:{ all -> 0x00ce }
            int r6 = r1.s     // Catch:{ all -> 0x00ce }
            net.fxgear.GlobalDefine$ClothesSize r3 = net.fxgear.ClothesSizeProvider.GetClosestClothSize((int) r3, (int) r6, (int) r2, (boolean) r5)     // Catch:{ all -> 0x00ce }
            net.fxgear.GlobalDefine$ClothesSize[] r6 = r1.B     // Catch:{ all -> 0x00ce }
            r6[r2] = r3     // Catch:{ all -> 0x00ce }
            int r2 = r2 + 1
            goto L_0x0091
        L_0x00a5:
            net.fxgear.GlobalDefine$Result r2 = new net.fxgear.GlobalDefine$Result     // Catch:{ all -> 0x00ce }
            r2.<init>()     // Catch:{ all -> 0x00ce }
            r2.resultCode = r5     // Catch:{ all -> 0x00ce }
            net.fxgear.a r3 = r1.D     // Catch:{ all -> 0x00ce }
            net.fxgear.FittingView$46 r5 = new net.fxgear.FittingView$46     // Catch:{ all -> 0x00ce }
            r5.<init>(r0, r2, r8)     // Catch:{ all -> 0x00ce }
            net.fxgear.FittingView$2 r6 = new net.fxgear.FittingView$2     // Catch:{ all -> 0x00ce }
            r10 = r6
            r11 = r9
            r12 = r21
            r13 = r2
            r14 = r22
            r15 = r0
            r10.<init>(r12, r13, r14, r15)     // Catch:{ all -> 0x00ce }
            r3.a((java.lang.Runnable) r5, (net.fxgear.a.C0022a) r6)     // Catch:{ all -> 0x00ce }
            monitor-exit(r9)
            return r7
        L_0x00c5:
            java.lang.String r0 = r1.p     // Catch:{ all -> 0x00ce }
            java.lang.String r2 = "fittingView working."
            android.util.Log.d(r0, r2)     // Catch:{ all -> 0x00ce }
            monitor-exit(r9)
            return r5
        L_0x00ce:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.FittingView.SetCharacter(int, int, int, int, net.fxgear.FittingView$RealVideoFileInfo, int, boolean, net.fxgear.FittingView$ClothesFileInfo[], net.fxgear.BodySizeData, int, float, net.fxgear.FittingView$OnFittingViewListener, java.lang.Runnable):boolean");
    }

    public synchronized boolean SetModeAndCharacter(int i, int i2, int i3, int i4, int i5, int i6, boolean z2, ClothesFileInfo[] clothesFileInfoArr, BodySizeData bodySizeData, int i7, float f, OnFittingViewListener onFittingViewListener, Runnable runnable) {
        final ClothesFileInfo[] clothesFileInfoArr2;
        int i8 = i;
        int i9 = i6;
        ClothesFileInfo[] clothesFileInfoArr3 = clothesFileInfoArr;
        synchronized (this) {
            Log.d(this.p, "SetModeAndCharacter()+");
            if (i8 == 0) {
                Log.e(this.p, "[ERROR] :: Illegal state. call another SetModeAndCharacter method with parameter RealVideoFileInfo for real mode");
                return false;
            } else if (this.D == null || this.D.a()) {
                Log.d(this.p, "fittingView working.");
                return false;
            } else {
                if (onFittingViewListener != null) {
                    onFittingViewListener.OnStartAsyncWork();
                }
                final boolean z3 = this.w != i9;
                this.q = i8;
                this.s = i3;
                this.r = i2;
                this.t = i4;
                this.u = i5;
                this.w = i9;
                this.x = z2;
                this.y = f;
                this.z = FittingSurfaceView.colorTemperatureToNormalizeValue(new float[]{(float) FXUtil.redFromColor(i7), (float) FXUtil.greenFromColor(i7), (float) FXUtil.blueFromColor(i7)});
                a(this.r, this.s, bodySizeData);
                if (clothesFileInfoArr3 == null || clothesFileInfoArr3.length != this.A.length) {
                    clothesFileInfoArr2 = ClothesFileInfo.b(EMPTY_CLOTHES);
                } else {
                    clothesFileInfoArr2 = ClothesFileInfo.b(clothesFileInfoArr);
                }
                final GlobalDefine.Result result = new GlobalDefine.Result();
                result.resultCode = 0;
                final OnFittingViewListener onFittingViewListener2 = onFittingViewListener;
                final GlobalDefine.Result result2 = result;
                final Runnable runnable2 = runnable;
                final ClothesFileInfo[] clothesFileInfoArr4 = clothesFileInfoArr2;
                this.D.a((Runnable) new Runnable() {
                    public void run() {
                        try {
                            AvatarSetting unused = FittingView.this.C;
                            float[] a2 = AvatarSetting.a();
                            float GetAvatarHeighWithoutHeadSize = (float) FittingView.this.C.GetAvatarHeighWithoutHeadSize();
                            int unused2 = FittingView.this.b(FittingView.this.q, FittingView.this.r, FittingView.this.s);
                            g a3 = FittingView.this.a(FittingView.this.q, FittingView.this.r, FittingView.this.s, a2, GetAvatarHeighWithoutHeadSize, clothesFileInfoArr2);
                            if (a3 == null) {
                                result.resultCode = 3;
                                return;
                            }
                            ClothesFileInfo[] unused3 = FittingView.this.A = clothesFileInfoArr2;
                            FittingView.this.SetModeData((net.fxgear.fittingview.data.h) null, FittingView.this.a(FittingView.this.r, FittingView.this.s, FittingView.this.b(a3.c()), FittingView.this.t, FittingView.this.u), FittingView.this.a(FittingView.this.r, FittingView.this.s, FittingView.this.a(a3.c())), a3, (FittingFaceData) null, z3);
                            result.resultCode = -1;
                        } catch (Throwable th) {
                            th.printStackTrace();
                            result.resultCode = -3;
                            result.resultExtra = th;
                        }
                    }
                }, (a.C0022a) new a.C0022a() {
                    public void a() {
                        if (onFittingViewListener2 == null) {
                            return;
                        }
                        if (result2.resultCode == -1) {
                            onFittingViewListener2.OnFinishAsyncWork(runnable2);
                            onFittingViewListener2.OnClothChange(clothesFileInfoArr4);
                            return;
                        }
                        onFittingViewListener2.OnOccurError(result2);
                    }
                });
                return true;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0095  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean SetModeAndCharacter(int r10, int r11, int r12, int r13, int r14, net.fxgear.FittingView.RealVideoFileInfo r15, int r16, boolean r17, net.fxgear.FittingView.ClothesFileInfo[] r18, net.fxgear.BodySizeData r19, int r20, float r21, net.fxgear.FittingView.OnFittingViewListener r22, java.lang.Runnable r23) {
        /*
            r9 = this;
            r1 = r9
            r0 = r15
            r2 = r16
            r3 = r18
            monitor-enter(r9)
            java.lang.String r4 = r1.p     // Catch:{ all -> 0x00c4 }
            java.lang.String r5 = "SetModeAndCharacter()+"
            android.util.Log.d(r4, r5)     // Catch:{ all -> 0x00c4 }
            boolean r4 = r9.a((net.fxgear.FittingView.RealVideoFileInfo) r15)     // Catch:{ all -> 0x00c4 }
            r5 = 0
            if (r4 != 0) goto L_0x001e
            java.lang.String r0 = r1.p     // Catch:{ all -> 0x00c4 }
            java.lang.String r2 = "Unknown real data ID."
            android.util.Log.d(r0, r2)     // Catch:{ all -> 0x00c4 }
            monitor-exit(r9)
            return r5
        L_0x001e:
            net.fxgear.a r4 = r1.D     // Catch:{ all -> 0x00c4 }
            if (r4 == 0) goto L_0x00bb
            net.fxgear.a r4 = r1.D     // Catch:{ all -> 0x00c4 }
            boolean r4 = r4.a()     // Catch:{ all -> 0x00c4 }
            if (r4 != 0) goto L_0x00bb
            if (r22 == 0) goto L_0x002f
            r22.OnStartAsyncWork()     // Catch:{ all -> 0x00c4 }
        L_0x002f:
            int r6 = r1.w     // Catch:{ all -> 0x00c4 }
            r7 = 1
            if (r6 != r2) goto L_0x0040
            net.fxgear.FittingView$RealVideoFileInfo r6 = r1.v     // Catch:{ all -> 0x00c4 }
            boolean r6 = r6.equals(r15)     // Catch:{ all -> 0x00c4 }
            if (r6 != 0) goto L_0x003d
            goto L_0x0040
        L_0x003d:
            r6 = r10
            r8 = 0
            goto L_0x0042
        L_0x0040:
            r6 = r10
            r8 = 1
        L_0x0042:
            r1.q = r6     // Catch:{ all -> 0x00c4 }
            r6 = r12
            r1.s = r6     // Catch:{ all -> 0x00c4 }
            r6 = r11
            r1.r = r6     // Catch:{ all -> 0x00c4 }
            r6 = r13
            r1.t = r6     // Catch:{ all -> 0x00c4 }
            r6 = r14
            r1.u = r6     // Catch:{ all -> 0x00c4 }
            net.fxgear.FittingView$RealVideoFileInfo r0 = r15.a()     // Catch:{ all -> 0x00c4 }
            r1.v = r0     // Catch:{ all -> 0x00c4 }
            r1.w = r2     // Catch:{ all -> 0x00c4 }
            r0 = r17
            r1.x = r0     // Catch:{ all -> 0x00c4 }
            r0 = r21
            r1.y = r0     // Catch:{ all -> 0x00c4 }
            r0 = 3
            float[] r0 = new float[r0]     // Catch:{ all -> 0x00c4 }
            int r2 = net.fxgear.util.FXUtil.redFromColor(r20)     // Catch:{ all -> 0x00c4 }
            float r2 = (float) r2     // Catch:{ all -> 0x00c4 }
            r0[r5] = r2     // Catch:{ all -> 0x00c4 }
            int r2 = net.fxgear.util.FXUtil.greenFromColor(r20)     // Catch:{ all -> 0x00c4 }
            float r2 = (float) r2     // Catch:{ all -> 0x00c4 }
            r0[r7] = r2     // Catch:{ all -> 0x00c4 }
            r2 = 2
            int r6 = net.fxgear.util.FXUtil.blueFromColor(r20)     // Catch:{ all -> 0x00c4 }
            float r6 = (float) r6     // Catch:{ all -> 0x00c4 }
            r0[r2] = r6     // Catch:{ all -> 0x00c4 }
            float r0 = net.fxgear.fittingview.FittingSurfaceView.colorTemperatureToNormalizeValue(r0)     // Catch:{ all -> 0x00c4 }
            r1.z = r0     // Catch:{ all -> 0x00c4 }
            int r0 = r1.r     // Catch:{ all -> 0x00c4 }
            int r2 = r1.s     // Catch:{ all -> 0x00c4 }
            r6 = r19
            r9.a((int) r0, (int) r2, (net.fxgear.BodySizeData) r6)     // Catch:{ all -> 0x00c4 }
            if (r3 == 0) goto L_0x0095
            int r0 = r3.length     // Catch:{ all -> 0x00c4 }
            net.fxgear.FittingView$ClothesFileInfo[] r2 = r1.A     // Catch:{ all -> 0x00c4 }
            int r2 = r2.length     // Catch:{ all -> 0x00c4 }
            if (r0 != r2) goto L_0x0095
            net.fxgear.FittingView$ClothesFileInfo[] r0 = net.fxgear.FittingView.ClothesFileInfo.b(r18)     // Catch:{ all -> 0x00c4 }
            goto L_0x009b
        L_0x0095:
            net.fxgear.FittingView$ClothesFileInfo[] r0 = EMPTY_CLOTHES     // Catch:{ all -> 0x00c4 }
            net.fxgear.FittingView$ClothesFileInfo[] r0 = net.fxgear.FittingView.ClothesFileInfo.b(r0)     // Catch:{ all -> 0x00c4 }
        L_0x009b:
            net.fxgear.GlobalDefine$Result r2 = new net.fxgear.GlobalDefine$Result     // Catch:{ all -> 0x00c4 }
            r2.<init>()     // Catch:{ all -> 0x00c4 }
            r2.resultCode = r5     // Catch:{ all -> 0x00c4 }
            net.fxgear.a r3 = r1.D     // Catch:{ all -> 0x00c4 }
            net.fxgear.FittingView$5 r5 = new net.fxgear.FittingView$5     // Catch:{ all -> 0x00c4 }
            r5.<init>(r0, r2, r8)     // Catch:{ all -> 0x00c4 }
            net.fxgear.FittingView$6 r6 = new net.fxgear.FittingView$6     // Catch:{ all -> 0x00c4 }
            r10 = r6
            r11 = r9
            r12 = r22
            r13 = r2
            r14 = r23
            r15 = r0
            r10.<init>(r12, r13, r14, r15)     // Catch:{ all -> 0x00c4 }
            r3.a((java.lang.Runnable) r5, (net.fxgear.a.C0022a) r6)     // Catch:{ all -> 0x00c4 }
            monitor-exit(r9)
            return r7
        L_0x00bb:
            java.lang.String r0 = r1.p     // Catch:{ all -> 0x00c4 }
            java.lang.String r2 = "fittingView working."
            android.util.Log.d(r0, r2)     // Catch:{ all -> 0x00c4 }
            monitor-exit(r9)
            return r5
        L_0x00c4:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.FittingView.SetModeAndCharacter(int, int, int, int, int, net.fxgear.FittingView$RealVideoFileInfo, int, boolean, net.fxgear.FittingView$ClothesFileInfo[], net.fxgear.BodySizeData, int, float, net.fxgear.FittingView$OnFittingViewListener, java.lang.Runnable):boolean");
    }

    public synchronized boolean ResetCamera(final OnFittingViewListener onFittingViewListener, final Runnable runnable) {
        if (this.D == null || this.D.a()) {
            Log.d(this.p, "AsyncWorker is working.");
            return false;
        }
        if (onFittingViewListener != null) {
            onFittingViewListener.OnStartAsyncWork();
        }
        this.D.a((Runnable) new Runnable() {
            public void run() {
                h.e eVar;
                h.e eVar2 = h.e.AVATAR;
                int b2 = FittingView.this.q;
                if (b2 != 0) {
                    switch (b2) {
                        case 2:
                        case 7:
                            eVar = h.e.AVATAR_BODY_EDITING;
                            break;
                        case 3:
                            eVar = h.e.AVATAR_HAIR_EDITING;
                            break;
                        case 4:
                            eVar = h.e.AVATAR_FACE_EDITING;
                            break;
                        case 5:
                            eVar = h.e.AVATAR_SKIN_TONE_EDITING;
                            break;
                        case 6:
                            eVar = h.e.AVATAR_CUSTOM_FACE_EDITING;
                            break;
                        case 8:
                            eVar = h.e.CHECK_CLOTHES_SIZE;
                            break;
                        default:
                            eVar = h.e.AVATAR;
                            break;
                    }
                } else {
                    eVar = h.e.REAL;
                }
                FittingView.this.ResetCamera(eVar);
            }
        }, (a.C0022a) new a.C0022a() {
            public void a() {
                if (onFittingViewListener != null) {
                    onFittingViewListener.OnFinishAsyncWork(runnable);
                }
            }
        });
        return true;
    }

    public synchronized boolean SetClothes(ClothesFileInfo clothesFileInfo, OnFittingViewListener onFittingViewListener, Runnable runnable) {
        return SetClothes(clothesFileInfo, ClothesSizeProvider.GetClosestClothSize(this.r, this.s, clothesFileInfo.mClothType, false), onFittingViewListener, runnable);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00b0, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean SetClothes(net.fxgear.FittingView.ClothesFileInfo r9, net.fxgear.GlobalDefine.ClothesSize r10, net.fxgear.FittingView.OnFittingViewListener r11, java.lang.Runnable r12) {
        /*
            r8 = this;
            monitor-enter(r8)
            int r0 = r8.q     // Catch:{ all -> 0x00b1 }
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x001b
            int r0 = r8.q     // Catch:{ all -> 0x00b1 }
            if (r0 == r1) goto L_0x001b
            int r0 = r8.q     // Catch:{ all -> 0x00b1 }
            r3 = 8
            if (r0 != r3) goto L_0x0012
            goto L_0x001b
        L_0x0012:
            java.lang.String r9 = r8.p     // Catch:{ all -> 0x00b1 }
            java.lang.String r10 = "WARNING :: illegalState - wrong mode."
            android.util.Log.e(r9, r10)     // Catch:{ all -> 0x00b1 }
            goto L_0x00af
        L_0x001b:
            if (r9 != 0) goto L_0x0026
            java.lang.String r9 = r8.p     // Catch:{ all -> 0x00b1 }
            java.lang.String r10 = "[ERROR] :: clothesFileInfo is null"
            android.util.Log.e(r9, r10)     // Catch:{ all -> 0x00b1 }
            monitor-exit(r8)
            return r2
        L_0x0026:
            int r0 = r9.mClothType     // Catch:{ all -> 0x00b1 }
            r3 = -1
            if (r0 <= r3) goto L_0x00a8
            int r0 = r9.mClothType     // Catch:{ all -> 0x00b1 }
            r3 = 5
            if (r0 >= r3) goto L_0x00a8
            net.fxgear.FittingView$ClothesFileInfo[] r0 = r8.A     // Catch:{ all -> 0x00b1 }
            int r3 = r9.mClothType     // Catch:{ all -> 0x00b1 }
            r0 = r0[r3]     // Catch:{ all -> 0x00b1 }
            boolean r0 = r0.equals(r9)     // Catch:{ all -> 0x00b1 }
            if (r0 != 0) goto L_0x00a0
            net.fxgear.a r0 = r8.D     // Catch:{ all -> 0x00b1 }
            if (r0 == 0) goto L_0x0098
            net.fxgear.a r0 = r8.D     // Catch:{ all -> 0x00b1 }
            boolean r0 = r0.a()     // Catch:{ all -> 0x00b1 }
            if (r0 != 0) goto L_0x0098
            if (r11 == 0) goto L_0x004d
            r11.OnStartAsyncWork()     // Catch:{ all -> 0x00b1 }
        L_0x004d:
            net.fxgear.FittingView$ClothesFileInfo[] r0 = r8.A     // Catch:{ all -> 0x00b1 }
            int r0 = r0.length     // Catch:{ all -> 0x00b1 }
            net.fxgear.FittingView$ClothesFileInfo[] r0 = new net.fxgear.FittingView.ClothesFileInfo[r0]     // Catch:{ all -> 0x00b1 }
            r3 = 0
        L_0x0053:
            int r4 = r0.length     // Catch:{ all -> 0x00b1 }
            if (r3 >= r4) goto L_0x0066
            int r4 = r9.mClothType     // Catch:{ all -> 0x00b1 }
            if (r3 != r4) goto L_0x005d
            r0[r3] = r9     // Catch:{ all -> 0x00b1 }
            goto L_0x0063
        L_0x005d:
            net.fxgear.FittingView$ClothesFileInfo[] r4 = r8.A     // Catch:{ all -> 0x00b1 }
            r4 = r4[r3]     // Catch:{ all -> 0x00b1 }
            r0[r3] = r4     // Catch:{ all -> 0x00b1 }
        L_0x0063:
            int r3 = r3 + 1
            goto L_0x0053
        L_0x0066:
            net.fxgear.FittingView$ClothesFileInfo[] r7 = r8.a((net.fxgear.FittingView.ClothesFileInfo) r9, (net.fxgear.FittingView.ClothesFileInfo[]) r0)     // Catch:{ all -> 0x00b1 }
            if (r10 != 0) goto L_0x0076
            int r10 = r8.r     // Catch:{ all -> 0x00b1 }
            int r0 = r8.s     // Catch:{ all -> 0x00b1 }
            int r3 = r9.mClothType     // Catch:{ all -> 0x00b1 }
            net.fxgear.GlobalDefine$ClothesSize r10 = net.fxgear.ClothesSizeProvider.GetClosestClothSize((int) r10, (int) r0, (int) r3, (boolean) r2)     // Catch:{ all -> 0x00b1 }
        L_0x0076:
            net.fxgear.GlobalDefine$ClothesSize[] r0 = r8.B     // Catch:{ all -> 0x00b1 }
            int r9 = r9.mClothType     // Catch:{ all -> 0x00b1 }
            r0[r9] = r10     // Catch:{ all -> 0x00b1 }
            net.fxgear.GlobalDefine$Result r5 = new net.fxgear.GlobalDefine$Result     // Catch:{ all -> 0x00b1 }
            r5.<init>()     // Catch:{ all -> 0x00b1 }
            r5.resultCode = r2     // Catch:{ all -> 0x00b1 }
            net.fxgear.a r9 = r8.D     // Catch:{ all -> 0x00b1 }
            net.fxgear.FittingView$9 r10 = new net.fxgear.FittingView$9     // Catch:{ all -> 0x00b1 }
            r10.<init>(r7, r5)     // Catch:{ all -> 0x00b1 }
            net.fxgear.FittingView$10 r0 = new net.fxgear.FittingView$10     // Catch:{ all -> 0x00b1 }
            r2 = r0
            r3 = r8
            r4 = r11
            r6 = r12
            r2.<init>(r4, r5, r6, r7)     // Catch:{ all -> 0x00b1 }
            r9.a((java.lang.Runnable) r10, (net.fxgear.a.C0022a) r0)     // Catch:{ all -> 0x00b1 }
            monitor-exit(r8)
            return r1
        L_0x0098:
            java.lang.String r9 = r8.p     // Catch:{ all -> 0x00b1 }
            java.lang.String r10 = "AsyncWorker is working."
            android.util.Log.d(r9, r10)     // Catch:{ all -> 0x00b1 }
            goto L_0x00af
        L_0x00a0:
            java.lang.String r9 = r8.p     // Catch:{ all -> 0x00b1 }
            java.lang.String r10 = "Did not change data."
            android.util.Log.d(r9, r10)     // Catch:{ all -> 0x00b1 }
            goto L_0x00af
        L_0x00a8:
            java.lang.String r9 = r8.p     // Catch:{ all -> 0x00b1 }
            java.lang.String r10 = "WARNING :: clothType is wrong."
            android.util.Log.e(r9, r10)     // Catch:{ all -> 0x00b1 }
        L_0x00af:
            monitor-exit(r8)
            return r2
        L_0x00b1:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.FittingView.SetClothes(net.fxgear.FittingView$ClothesFileInfo, net.fxgear.GlobalDefine$ClothesSize, net.fxgear.FittingView$OnFittingViewListener, java.lang.Runnable):boolean");
    }

    public synchronized boolean SetClothes(ClothesFileInfo[] clothesFileInfoArr, OnFittingViewListener onFittingViewListener, Runnable runnable) {
        for (int i = 0; i < this.B.length; i++) {
            this.B[i] = ClothesSizeProvider.GetClosestClothSize(this.r, this.s, i, false);
        }
        return SetClothes(clothesFileInfoArr, this.B, onFittingViewListener, runnable);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e1, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean SetClothes(net.fxgear.FittingView.ClothesFileInfo[] r9, net.fxgear.GlobalDefine.ClothesSize[] r10, net.fxgear.FittingView.OnFittingViewListener r11, java.lang.Runnable r12) {
        /*
            r8 = this;
            monitor-enter(r8)
            java.lang.String r0 = r8.p     // Catch:{ all -> 0x00e2 }
            java.lang.String r1 = "SetClothes()+"
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x00e2 }
            int r0 = r8.q     // Catch:{ all -> 0x00e2 }
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0022
            int r0 = r8.q     // Catch:{ all -> 0x00e2 }
            if (r0 == r1) goto L_0x0022
            int r0 = r8.q     // Catch:{ all -> 0x00e2 }
            r3 = 8
            if (r0 != r3) goto L_0x0019
            goto L_0x0022
        L_0x0019:
            java.lang.String r9 = r8.p     // Catch:{ all -> 0x00e2 }
            java.lang.String r10 = "WARNING :: illegalState - wrong mode."
            android.util.Log.e(r9, r10)     // Catch:{ all -> 0x00e2 }
            goto L_0x00e0
        L_0x0022:
            if (r9 == 0) goto L_0x00e0
            int r0 = r9.length     // Catch:{ all -> 0x00e2 }
            net.fxgear.FittingView$ClothesFileInfo[] r3 = r8.A     // Catch:{ all -> 0x00e2 }
            int r3 = r3.length     // Catch:{ all -> 0x00e2 }
            if (r0 != r3) goto L_0x00e0
            r0 = 0
        L_0x002b:
            net.fxgear.FittingView$ClothesFileInfo[] r3 = r8.A     // Catch:{ all -> 0x00e2 }
            int r3 = r3.length     // Catch:{ all -> 0x00e2 }
            if (r0 >= r3) goto L_0x0069
            r3 = r9[r0]     // Catch:{ all -> 0x00e2 }
            if (r3 != 0) goto L_0x0058
            java.lang.String r3 = r8.p     // Catch:{ all -> 0x00e2 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e2 }
            r4.<init>()     // Catch:{ all -> 0x00e2 }
            java.lang.String r5 = "clothesFileInfoArray["
            r4.append(r5)     // Catch:{ all -> 0x00e2 }
            r4.append(r0)     // Catch:{ all -> 0x00e2 }
            java.lang.String r5 = "] is null"
            r4.append(r5)     // Catch:{ all -> 0x00e2 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00e2 }
            android.util.Log.e(r3, r4)     // Catch:{ all -> 0x00e2 }
            net.fxgear.FittingView$ClothesFileInfo r3 = new net.fxgear.FittingView$ClothesFileInfo     // Catch:{ all -> 0x00e2 }
            r3.<init>()     // Catch:{ all -> 0x00e2 }
            r3.mClothType = r0     // Catch:{ all -> 0x00e2 }
            r9[r0] = r3     // Catch:{ all -> 0x00e2 }
        L_0x0058:
            r3 = r9[r0]     // Catch:{ all -> 0x00e2 }
            net.fxgear.FittingView$ClothesFileInfo[] r4 = r8.A     // Catch:{ all -> 0x00e2 }
            r4 = r4[r0]     // Catch:{ all -> 0x00e2 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x00e2 }
            if (r3 != 0) goto L_0x0066
            r0 = 1
            goto L_0x006a
        L_0x0066:
            int r0 = r0 + 1
            goto L_0x002b
        L_0x0069:
            r0 = 0
        L_0x006a:
            if (r0 == 0) goto L_0x00d9
            net.fxgear.a r0 = r8.D     // Catch:{ all -> 0x00e2 }
            if (r0 == 0) goto L_0x00d1
            net.fxgear.a r0 = r8.D     // Catch:{ all -> 0x00e2 }
            boolean r0 = r0.a()     // Catch:{ all -> 0x00e2 }
            if (r0 != 0) goto L_0x00d1
            if (r11 == 0) goto L_0x007d
            r11.OnStartAsyncWork()     // Catch:{ all -> 0x00e2 }
        L_0x007d:
            net.fxgear.FittingView$ClothesFileInfo[] r7 = net.fxgear.FittingView.ClothesFileInfo.b(r9)     // Catch:{ all -> 0x00e2 }
            if (r10 == 0) goto L_0x00a0
            r9 = 0
        L_0x0084:
            net.fxgear.GlobalDefine$ClothesSize[] r0 = r8.B     // Catch:{ all -> 0x00e2 }
            int r0 = r0.length     // Catch:{ all -> 0x00e2 }
            if (r9 >= r0) goto L_0x00b5
            r0 = r10[r9]     // Catch:{ all -> 0x00e2 }
            if (r0 != 0) goto L_0x0097
            int r0 = r8.r     // Catch:{ all -> 0x00e2 }
            int r3 = r8.s     // Catch:{ all -> 0x00e2 }
            net.fxgear.GlobalDefine$ClothesSize r0 = net.fxgear.ClothesSizeProvider.GetClosestClothSize((int) r0, (int) r3, (int) r9, (boolean) r2)     // Catch:{ all -> 0x00e2 }
            r10[r9] = r0     // Catch:{ all -> 0x00e2 }
        L_0x0097:
            net.fxgear.GlobalDefine$ClothesSize[] r0 = r8.B     // Catch:{ all -> 0x00e2 }
            r3 = r10[r9]     // Catch:{ all -> 0x00e2 }
            r0[r9] = r3     // Catch:{ all -> 0x00e2 }
            int r9 = r9 + 1
            goto L_0x0084
        L_0x00a0:
            r9 = 0
        L_0x00a1:
            net.fxgear.GlobalDefine$ClothesSize[] r10 = r8.B     // Catch:{ all -> 0x00e2 }
            int r10 = r10.length     // Catch:{ all -> 0x00e2 }
            if (r9 >= r10) goto L_0x00b5
            int r10 = r8.r     // Catch:{ all -> 0x00e2 }
            int r0 = r8.s     // Catch:{ all -> 0x00e2 }
            net.fxgear.GlobalDefine$ClothesSize r10 = net.fxgear.ClothesSizeProvider.GetClosestClothSize((int) r10, (int) r0, (int) r9, (boolean) r2)     // Catch:{ all -> 0x00e2 }
            net.fxgear.GlobalDefine$ClothesSize[] r0 = r8.B     // Catch:{ all -> 0x00e2 }
            r0[r9] = r10     // Catch:{ all -> 0x00e2 }
            int r9 = r9 + 1
            goto L_0x00a1
        L_0x00b5:
            net.fxgear.GlobalDefine$Result r5 = new net.fxgear.GlobalDefine$Result     // Catch:{ all -> 0x00e2 }
            r5.<init>()     // Catch:{ all -> 0x00e2 }
            r5.resultCode = r2     // Catch:{ all -> 0x00e2 }
            net.fxgear.a r9 = r8.D     // Catch:{ all -> 0x00e2 }
            net.fxgear.FittingView$11 r10 = new net.fxgear.FittingView$11     // Catch:{ all -> 0x00e2 }
            r10.<init>(r7, r5)     // Catch:{ all -> 0x00e2 }
            net.fxgear.FittingView$13 r0 = new net.fxgear.FittingView$13     // Catch:{ all -> 0x00e2 }
            r2 = r0
            r3 = r8
            r4 = r11
            r6 = r12
            r2.<init>(r4, r5, r6, r7)     // Catch:{ all -> 0x00e2 }
            r9.a((java.lang.Runnable) r10, (net.fxgear.a.C0022a) r0)     // Catch:{ all -> 0x00e2 }
            monitor-exit(r8)
            return r1
        L_0x00d1:
            java.lang.String r9 = r8.p     // Catch:{ all -> 0x00e2 }
            java.lang.String r10 = "AsyncWorker is working."
            android.util.Log.d(r9, r10)     // Catch:{ all -> 0x00e2 }
            goto L_0x00e0
        L_0x00d9:
            java.lang.String r9 = r8.p     // Catch:{ all -> 0x00e2 }
            java.lang.String r10 = "Did not change data."
            android.util.Log.d(r9, r10)     // Catch:{ all -> 0x00e2 }
        L_0x00e0:
            monitor-exit(r8)
            return r2
        L_0x00e2:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.FittingView.SetClothes(net.fxgear.FittingView$ClothesFileInfo[], net.fxgear.GlobalDefine$ClothesSize[], net.fxgear.FittingView$OnFittingViewListener, java.lang.Runnable):boolean");
    }

    public void SetClothesRenderingOption(GlobalDefine.ClothesVisualizationOption clothesVisualizationOption) {
        h.c cVar;
        if (clothesVisualizationOption == GlobalDefine.ClothesVisualizationOption.Tension) {
            cVar = h.c.Tension;
        } else if (clothesVisualizationOption == GlobalDefine.ClothesVisualizationOption.Pressure) {
            cVar = h.c.Pressure;
        } else {
            cVar = h.c.Color;
        }
        SetClothRenderMode(cVar);
    }

    public GlobalDefine.ClothesVisualizationOption GetClothesRenderingOption() {
        h.c GetClothRenderMode = GetClothRenderMode();
        if (GetClothRenderMode == h.c.Tension) {
            return GlobalDefine.ClothesVisualizationOption.Tension;
        }
        if (GetClothRenderMode == h.c.Pressure) {
            return GlobalDefine.ClothesVisualizationOption.Pressure;
        }
        return GlobalDefine.ClothesVisualizationOption.Color;
    }

    public void SetClothesSize(final HashMap<Integer, GlobalDefine.ClothesSize> hashMap, final OnFittingViewListener onFittingViewListener, final Runnable runnable) {
        if (GetCurrentSceneMode() != h.e.CHECK_CLOTHES_SIZE) {
            throw new UnsupportedOperationException("This method must be called in \"MODE_CHECK_CLOTHES_SIZE\" mode.");
        } else if (hashMap != null) {
            if (onFittingViewListener != null) {
                onFittingViewListener.OnStartAsyncWork();
            }
            this.D.a((Runnable) new Runnable() {
                public void run() {
                    HashMap hashMap = new HashMap();
                    for (Integer intValue : hashMap.keySet()) {
                        int intValue2 = intValue.intValue();
                        h.d GetClothesMeshCategory = FittingView.this.GetClothesMeshCategory(intValue2);
                        if (GetClothesMeshCategory != h.d.NONE) {
                            GlobalDefine.ClothesSize clothesSize = (GlobalDefine.ClothesSize) hashMap.get(Integer.valueOf(intValue2));
                            FittingView.this.B[intValue2] = clothesSize;
                            hashMap.put(GetClothesMeshCategory, Integer.valueOf(clothesSize.ordinal()));
                        }
                    }
                    FittingView.this.SetClothSize(hashMap);
                }
            }, (a.C0022a) new a.C0022a() {
                public void a() {
                    if (onFittingViewListener != null) {
                        onFittingViewListener.OnFinishAsyncWork(runnable);
                    }
                }
            });
        } else {
            Log.e(this.p, "[ERROR] :: SetClothesSize(), clothesSizeInfo is null");
        }
    }

    public double GetCurrentBodySize(int i) {
        if (this.C == null) {
            return (double) AvatarSetting.NO_VALUE;
        }
        AvatarSetting avatarSetting = this.C;
        return AvatarSetting.GetValueOfBodyPart(i);
    }

    public double GetCurrentBodyThresHoldMaxValue(int i) {
        if (this.C != null) {
            return this.C.GetHighThresholdValueOfBodyPart(i);
        }
        return (double) AvatarSetting.NO_VALUE;
    }

    public double GetCurrentBodyThresHoldMinValue(int i) {
        if (this.C != null) {
            return this.C.GetLowThresholdValueOfBodyPart(i);
        }
        return (double) AvatarSetting.NO_VALUE;
    }

    public BodySizeData GetCurrentBodySizeAll() {
        if (this.C == null) {
            return null;
        }
        BodySizeData bodySizeData = new BodySizeData();
        AvatarSetting avatarSetting = this.C;
        bodySizeData.mTallSize = (float) AvatarSetting.GetValueOfBodyPart(0);
        AvatarSetting avatarSetting2 = this.C;
        bodySizeData.mUpperSize = (float) AvatarSetting.GetValueOfBodyPart(5);
        AvatarSetting avatarSetting3 = this.C;
        bodySizeData.mLowerSize = (float) AvatarSetting.GetValueOfBodyPart(6);
        AvatarSetting avatarSetting4 = this.C;
        bodySizeData.mShoulderSize = (float) AvatarSetting.GetValueOfBodyPart(1);
        AvatarSetting avatarSetting5 = this.C;
        bodySizeData.mBustSize = (float) AvatarSetting.GetValueOfBodyPart(7);
        AvatarSetting avatarSetting6 = this.C;
        bodySizeData.mCupSize = (float) AvatarSetting.GetValueOfBodyPart(8);
        AvatarSetting avatarSetting7 = this.C;
        bodySizeData.mWaistSize = (float) AvatarSetting.GetValueOfBodyPart(9);
        AvatarSetting avatarSetting8 = this.C;
        bodySizeData.mHipSize = (float) AvatarSetting.GetValueOfBodyPart(11);
        AvatarSetting avatarSetting9 = this.C;
        bodySizeData.mArmLengthSize = (float) AvatarSetting.GetValueOfBodyPart(2);
        AvatarSetting avatarSetting10 = this.C;
        bodySizeData.mArmThickSize = (float) AvatarSetting.GetValueOfBodyPart(10);
        AvatarSetting avatarSetting11 = this.C;
        bodySizeData.mThighLengthSize = (float) AvatarSetting.GetValueOfBodyPart(3);
        AvatarSetting avatarSetting12 = this.C;
        bodySizeData.mThighThickSize = (float) AvatarSetting.GetValueOfBodyPart(12);
        AvatarSetting avatarSetting13 = this.C;
        bodySizeData.mCalfLengthSize = (float) AvatarSetting.GetValueOfBodyPart(4);
        AvatarSetting avatarSetting14 = this.C;
        bodySizeData.mHeadHeight = (float) AvatarSetting.GetValueOfBodyPart(14);
        return bodySizeData;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007d, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean SetBodySize(int r10, float r11, boolean r12, final net.fxgear.FittingView.OnFittingViewListener r13, final java.lang.Runnable r14) {
        /*
            r9 = this;
            monitor-enter(r9)
            java.lang.String r0 = r9.p     // Catch:{ all -> 0x0088 }
            java.lang.String r1 = "SetBodySize()+"
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x0088 }
            net.fxgear.AvatarSetting r0 = r9.C     // Catch:{ all -> 0x0088 }
            if (r0 == 0) goto L_0x007e
            r0 = 1
            if (r12 == 0) goto L_0x0056
            net.fxgear.a r11 = r9.D     // Catch:{ all -> 0x0088 }
            if (r11 == 0) goto L_0x004e
            net.fxgear.a r11 = r9.D     // Catch:{ all -> 0x0088 }
            boolean r11 = r11.a()     // Catch:{ all -> 0x0088 }
            if (r11 != 0) goto L_0x004e
            if (r13 == 0) goto L_0x0020
            r13.OnStartAsyncWork()     // Catch:{ all -> 0x0088 }
        L_0x0020:
            net.fxgear.AvatarSetting r11 = r9.C     // Catch:{ all -> 0x0088 }
            float[] r5 = net.fxgear.AvatarSetting.a()     // Catch:{ all -> 0x0088 }
            net.fxgear.AvatarSetting r11 = r9.C     // Catch:{ all -> 0x0088 }
            double r11 = r11.GetHeadScale()     // Catch:{ all -> 0x0088 }
            float r4 = (float) r11     // Catch:{ all -> 0x0088 }
            net.fxgear.AvatarSetting r11 = r9.C     // Catch:{ all -> 0x0088 }
            double r11 = r11.GetAvatarHeighWithoutHeadSize()     // Catch:{ all -> 0x0088 }
            float r6 = (float) r11     // Catch:{ all -> 0x0088 }
            net.fxgear.GlobalDefine$Result r11 = new net.fxgear.GlobalDefine$Result     // Catch:{ all -> 0x0088 }
            r11.<init>()     // Catch:{ all -> 0x0088 }
            net.fxgear.a r12 = r9.D     // Catch:{ all -> 0x0088 }
            net.fxgear.FittingView$16 r8 = new net.fxgear.FittingView$16     // Catch:{ all -> 0x0088 }
            r1 = r8
            r2 = r9
            r3 = r10
            r7 = r11
            r1.<init>(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0088 }
            net.fxgear.FittingView$17 r10 = new net.fxgear.FittingView$17     // Catch:{ all -> 0x0088 }
            r10.<init>(r13, r11, r14)     // Catch:{ all -> 0x0088 }
            r12.a((java.lang.Runnable) r8, (net.fxgear.a.C0022a) r10)     // Catch:{ all -> 0x0088 }
            monitor-exit(r9)
            return r0
        L_0x004e:
            java.lang.String r10 = r9.p     // Catch:{ all -> 0x0088 }
            java.lang.String r11 = "fittingView working."
            android.util.Log.d(r10, r11)     // Catch:{ all -> 0x0088 }
            goto L_0x0085
        L_0x0056:
            net.fxgear.AvatarSetting r12 = r9.C     // Catch:{ all -> 0x0088 }
            double r13 = (double) r11     // Catch:{ all -> 0x0088 }
            int r11 = r12.SetValueOfBodyPart(r10, r13)     // Catch:{ all -> 0x0088 }
            net.fxgear.AvatarSetting r12 = r9.C     // Catch:{ all -> 0x0088 }
            float[] r12 = net.fxgear.AvatarSetting.a()     // Catch:{ all -> 0x0088 }
            net.fxgear.AvatarSetting r13 = r9.C     // Catch:{ all -> 0x0088 }
            double r13 = r13.GetHeadScale()     // Catch:{ all -> 0x0088 }
            float r13 = (float) r13     // Catch:{ all -> 0x0088 }
            net.fxgear.AvatarSetting r14 = r9.C     // Catch:{ all -> 0x0088 }
            double r1 = r14.GetAvatarHeighWithoutHeadSize()     // Catch:{ all -> 0x0088 }
            float r14 = (float) r1     // Catch:{ all -> 0x0088 }
            r1 = 14
            if (r10 != r1) goto L_0x0079
            r9.SetFaceScaleAsync(r13)     // Catch:{ all -> 0x0088 }
            goto L_0x007c
        L_0x0079:
            r9.SetBodyWeightDataAsync(r11, r12, r14)     // Catch:{ all -> 0x0088 }
        L_0x007c:
            monitor-exit(r9)
            return r0
        L_0x007e:
            java.lang.String r10 = r9.p     // Catch:{ all -> 0x0088 }
            java.lang.String r11 = "mAvatarSetting is null."
            android.util.Log.d(r10, r11)     // Catch:{ all -> 0x0088 }
        L_0x0085:
            r10 = 0
            monitor-exit(r9)
            return r10
        L_0x0088:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.FittingView.SetBodySize(int, float, boolean, net.fxgear.FittingView$OnFittingViewListener, java.lang.Runnable):boolean");
    }

    public synchronized boolean SetBodySizeAll(BodySizeData bodySizeData, final OnFittingViewListener onFittingViewListener, final Runnable runnable) {
        Log.d(this.p, "SetBodySizeAll()+");
        if (this.C == null || bodySizeData == null) {
            Log.d(this.p, "ERROR :: IllegalState or param is null.");
        } else if (this.D == null || this.D.a()) {
            Log.d(this.p, "fittingView working.");
        } else {
            if (onFittingViewListener != null) {
                onFittingViewListener.OnStartAsyncWork();
            }
            a(this.r, this.s, bodySizeData);
            AvatarSetting avatarSetting = this.C;
            final float[] a2 = AvatarSetting.a();
            final float GetHeadScale = (float) this.C.GetHeadScale();
            final float GetAvatarHeighWithoutHeadSize = (float) this.C.GetAvatarHeighWithoutHeadSize();
            final GlobalDefine.Result result = new GlobalDefine.Result();
            final GlobalDefine.Result result2 = result;
            this.D.a((Runnable) new Runnable() {
                public void run() {
                    try {
                        FittingView.this.SetBodyWeightData(a2, GetAvatarHeighWithoutHeadSize);
                        FittingView.this.SetFaceScale(GetHeadScale);
                        result2.resultCode = -1;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        result2.resultCode = -3;
                        result2.resultExtra = th;
                    }
                }
            }, (a.C0022a) new a.C0022a() {
                public void a() {
                    if (onFittingViewListener == null) {
                        return;
                    }
                    if (result.resultCode == -1) {
                        onFittingViewListener.OnFinishAsyncWork(runnable);
                    } else {
                        onFittingViewListener.OnOccurError(result);
                    }
                }
            });
            return true;
        }
        return false;
    }

    public synchronized boolean SetAvatarModeAndWholeHead(int i, int i2, int i3, boolean z2, OnFittingViewListener onFittingViewListener, Runnable runnable) {
        if (i == 0) {
            String str = this.p;
            Log.e(str, "[ERROR] :: illegalState - wrong mode - " + i);
            return false;
        }
        boolean z3 = true;
        boolean z4 = i2 >= 0 && i2 < AvatarSetting.GetHairTypeCount(getContext(), this.r, this.s);
        int GetHeadTypeCount = AvatarSetting.GetHeadTypeCount(getContext(), this.r, this.s);
        if (i3 >= 0 && i3 < GetHeadTypeCount) {
            if (z2) {
                if (a()) {
                }
            }
            if (z4 || !z3) {
                Log.e(this.p, "[ERROR] :: invalid hair or head type");
                String str2 = this.p;
                Log.e(str2, "validHairType: " + z4 + ", hairTypeIndex: " + i2);
                String str3 = this.p;
                Log.e(str3, "validHeadType: " + z3 + ", headTypeIndex: " + i3);
                return false;
            }
            AvatarSetting avatarSetting = this.C;
            return a(i, i3, i2, z2, AvatarSetting.a(), onFittingViewListener, runnable);
        }
        z3 = false;
        if (z4) {
        }
        Log.e(this.p, "[ERROR] :: invalid hair or head type");
        String str22 = this.p;
        Log.e(str22, "validHairType: " + z4 + ", hairTypeIndex: " + i2);
        String str32 = this.p;
        Log.e(str32, "validHeadType: " + z3 + ", headTypeIndex: " + i3);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006d, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean SetAvatarHairType(int r5, final net.fxgear.FittingView.OnFittingViewListener r6, final java.lang.Runnable r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = r4.p     // Catch:{ all -> 0x006e }
            java.lang.String r1 = "SetAvatarHairType()+"
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x006e }
            int r0 = r4.q     // Catch:{ all -> 0x006e }
            r1 = 0
            if (r0 == 0) goto L_0x006c
            android.content.Context r0 = r4.getContext()     // Catch:{ all -> 0x006e }
            int r2 = r4.r     // Catch:{ all -> 0x006e }
            int r3 = r4.s     // Catch:{ all -> 0x006e }
            int r0 = net.fxgear.AvatarSetting.GetHairTypeCount(r0, r2, r3)     // Catch:{ all -> 0x006e }
            r2 = 1
            if (r5 < 0) goto L_0x0020
            if (r5 >= r0) goto L_0x0020
            r0 = 1
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            if (r0 == 0) goto L_0x0056
            net.fxgear.a r0 = r4.D     // Catch:{ all -> 0x006e }
            if (r0 == 0) goto L_0x004e
            net.fxgear.a r0 = r4.D     // Catch:{ all -> 0x006e }
            boolean r0 = r0.a()     // Catch:{ all -> 0x006e }
            if (r0 != 0) goto L_0x004e
            if (r6 == 0) goto L_0x0034
            r6.OnStartAsyncWork()     // Catch:{ all -> 0x006e }
        L_0x0034:
            r4.u = r5     // Catch:{ all -> 0x006e }
            net.fxgear.GlobalDefine$Result r5 = new net.fxgear.GlobalDefine$Result     // Catch:{ all -> 0x006e }
            r5.<init>()     // Catch:{ all -> 0x006e }
            r5.resultCode = r1     // Catch:{ all -> 0x006e }
            net.fxgear.a r0 = r4.D     // Catch:{ all -> 0x006e }
            net.fxgear.FittingView$20 r1 = new net.fxgear.FittingView$20     // Catch:{ all -> 0x006e }
            r1.<init>(r5)     // Catch:{ all -> 0x006e }
            net.fxgear.FittingView$21 r3 = new net.fxgear.FittingView$21     // Catch:{ all -> 0x006e }
            r3.<init>(r6, r5, r7)     // Catch:{ all -> 0x006e }
            r0.a((java.lang.Runnable) r1, (net.fxgear.a.C0022a) r3)     // Catch:{ all -> 0x006e }
            monitor-exit(r4)
            return r2
        L_0x004e:
            java.lang.String r5 = r4.p     // Catch:{ all -> 0x006e }
            java.lang.String r6 = "AsyncWorker is working."
            android.util.Log.d(r5, r6)     // Catch:{ all -> 0x006e }
            goto L_0x006c
        L_0x0056:
            java.lang.String r6 = r4.p     // Catch:{ all -> 0x006e }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x006e }
            r7.<init>()     // Catch:{ all -> 0x006e }
            java.lang.String r0 = "WARNING :: invalid hair type - "
            r7.append(r0)     // Catch:{ all -> 0x006e }
            r7.append(r5)     // Catch:{ all -> 0x006e }
            java.lang.String r5 = r7.toString()     // Catch:{ all -> 0x006e }
            android.util.Log.e(r6, r5)     // Catch:{ all -> 0x006e }
        L_0x006c:
            monitor-exit(r4)
            return r1
        L_0x006e:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.FittingView.SetAvatarHairType(int, net.fxgear.FittingView$OnFittingViewListener, java.lang.Runnable):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0077, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean SetAvatarHeadType(int r5, boolean r6, final net.fxgear.FittingView.OnFittingViewListener r7, final java.lang.Runnable r8) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = r4.p     // Catch:{ all -> 0x0078 }
            java.lang.String r1 = "SetAvatarHeadType()+"
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x0078 }
            int r0 = r4.q     // Catch:{ all -> 0x0078 }
            r1 = 0
            if (r0 == 0) goto L_0x0076
            android.content.Context r0 = r4.getContext()     // Catch:{ all -> 0x0078 }
            int r2 = r4.r     // Catch:{ all -> 0x0078 }
            int r3 = r4.s     // Catch:{ all -> 0x0078 }
            int r0 = net.fxgear.AvatarSetting.GetHeadTypeCount(r0, r2, r3)     // Catch:{ all -> 0x0078 }
            r2 = 1
            if (r5 < 0) goto L_0x0028
            if (r5 >= r0) goto L_0x0028
            if (r6 == 0) goto L_0x0026
            boolean r0 = r4.a()     // Catch:{ all -> 0x0078 }
            if (r0 == 0) goto L_0x0028
        L_0x0026:
            r0 = 1
            goto L_0x0029
        L_0x0028:
            r0 = 0
        L_0x0029:
            if (r0 == 0) goto L_0x0060
            net.fxgear.a r0 = r4.D     // Catch:{ all -> 0x0078 }
            if (r0 == 0) goto L_0x0058
            net.fxgear.a r0 = r4.D     // Catch:{ all -> 0x0078 }
            boolean r0 = r0.a()     // Catch:{ all -> 0x0078 }
            if (r0 != 0) goto L_0x0058
            if (r7 == 0) goto L_0x003c
            r7.OnStartAsyncWork()     // Catch:{ all -> 0x0078 }
        L_0x003c:
            r4.x = r6     // Catch:{ all -> 0x0078 }
            r4.t = r5     // Catch:{ all -> 0x0078 }
            net.fxgear.GlobalDefine$Result r5 = new net.fxgear.GlobalDefine$Result     // Catch:{ all -> 0x0078 }
            r5.<init>()     // Catch:{ all -> 0x0078 }
            r5.resultCode = r1     // Catch:{ all -> 0x0078 }
            net.fxgear.a r6 = r4.D     // Catch:{ all -> 0x0078 }
            net.fxgear.FittingView$22 r0 = new net.fxgear.FittingView$22     // Catch:{ all -> 0x0078 }
            r0.<init>(r5)     // Catch:{ all -> 0x0078 }
            net.fxgear.FittingView$24 r1 = new net.fxgear.FittingView$24     // Catch:{ all -> 0x0078 }
            r1.<init>(r7, r5, r8)     // Catch:{ all -> 0x0078 }
            r6.a((java.lang.Runnable) r0, (net.fxgear.a.C0022a) r1)     // Catch:{ all -> 0x0078 }
            monitor-exit(r4)
            return r2
        L_0x0058:
            java.lang.String r5 = r4.p     // Catch:{ all -> 0x0078 }
            java.lang.String r6 = "AsyncWorker is working."
            android.util.Log.d(r5, r6)     // Catch:{ all -> 0x0078 }
            goto L_0x0076
        L_0x0060:
            java.lang.String r6 = r4.p     // Catch:{ all -> 0x0078 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0078 }
            r7.<init>()     // Catch:{ all -> 0x0078 }
            java.lang.String r8 = "WARNING :: invalid head type - "
            r7.append(r8)     // Catch:{ all -> 0x0078 }
            r7.append(r5)     // Catch:{ all -> 0x0078 }
            java.lang.String r5 = r7.toString()     // Catch:{ all -> 0x0078 }
            android.util.Log.e(r6, r5)     // Catch:{ all -> 0x0078 }
        L_0x0076:
            monitor-exit(r4)
            return r1
        L_0x0078:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.FittingView.SetAvatarHeadType(int, boolean, net.fxgear.FittingView$OnFittingViewListener, java.lang.Runnable):boolean");
    }

    private boolean a(int i, int i2, int i3, boolean z2, final float[] fArr, final OnFittingViewListener onFittingViewListener, final Runnable runnable) {
        Log.d(this.p, "SetAvatarDataWithScene()+");
        if (i == 0 || fArr == null) {
            Log.e(this.p, "WARNING :: illegalState - wrong param");
            return false;
        } else if (this.D == null || this.D.a()) {
            Log.d(this.p, "AsyncWorker is working.");
            return false;
        } else {
            if (onFittingViewListener != null) {
                onFittingViewListener.OnStartAsyncWork();
            }
            this.q = i;
            this.t = i2;
            this.u = i3;
            this.x = z2;
            final GlobalDefine.Result result = new GlobalDefine.Result();
            result.resultCode = 0;
            this.D.a((Runnable) new Runnable() {
                public void run() {
                    try {
                        float GetAvatarHeighWithoutHeadSize = (float) FittingView.this.C.GetAvatarHeighWithoutHeadSize();
                        int unused = FittingView.this.b(FittingView.this.q, FittingView.this.r, FittingView.this.s);
                        g a2 = FittingView.this.a(FittingView.this.q, FittingView.this.r, FittingView.this.s, fArr, GetAvatarHeighWithoutHeadSize, FittingView.this.A);
                        if (a2 == null) {
                            result.resultCode = 3;
                            return;
                        }
                        FittingView.this.SetModeData((net.fxgear.fittingview.data.h) null, FittingView.this.a(FittingView.this.r, FittingView.this.s, FittingView.this.b(a2.c()), FittingView.this.t, FittingView.this.u), FittingView.this.a(FittingView.this.r, FittingView.this.s, FittingView.this.a(a2.c())), a2, (FittingFaceData) null, false);
                        result.resultCode = -1;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        result.resultCode = -3;
                        result.resultExtra = th;
                    }
                }
            }, (a.C0022a) new a.C0022a() {
                public void a() {
                    if (onFittingViewListener == null) {
                        return;
                    }
                    if (result.resultCode == -1) {
                        onFittingViewListener.OnFinishAsyncWork(runnable);
                    } else {
                        onFittingViewListener.OnOccurError(result);
                    }
                }
            });
            return true;
        }
    }

    private boolean a(int i, int i2, int i3, boolean z2, BodySizeData bodySizeData, final OnFittingViewListener onFittingViewListener, final Runnable runnable) {
        Log.d(this.p, "SetAvatarDataWithScene()+");
        if (i == 0 || bodySizeData == null) {
            Log.e(this.p, "WARNING :: illegalState - wrong param");
            return false;
        } else if (this.D == null || this.D.a()) {
            Log.d(this.p, "AsyncWorker is working.");
            return false;
        } else {
            if (onFittingViewListener != null) {
                onFittingViewListener.OnStartAsyncWork();
            }
            this.q = i;
            this.t = i2;
            this.u = i3;
            this.x = z2;
            a(this.r, this.s, bodySizeData);
            final GlobalDefine.Result result = new GlobalDefine.Result();
            result.resultCode = 0;
            this.D.a((Runnable) new Runnable() {
                public void run() {
                    try {
                        AvatarSetting unused = FittingView.this.C;
                        float[] a2 = AvatarSetting.a();
                        float GetAvatarHeighWithoutHeadSize = (float) FittingView.this.C.GetAvatarHeighWithoutHeadSize();
                        int unused2 = FittingView.this.b(FittingView.this.q, FittingView.this.r, FittingView.this.s);
                        g a3 = FittingView.this.a(FittingView.this.q, FittingView.this.r, FittingView.this.s, a2, GetAvatarHeighWithoutHeadSize, FittingView.this.A);
                        if (a3 == null) {
                            result.resultCode = 3;
                            return;
                        }
                        FittingView.this.SetModeData((net.fxgear.fittingview.data.h) null, FittingView.this.a(FittingView.this.r, FittingView.this.s, FittingView.this.b(a3.c()), FittingView.this.t, FittingView.this.u), FittingView.this.a(FittingView.this.r, FittingView.this.s, FittingView.this.a(a3.c())), a3, (FittingFaceData) null, false);
                        result.resultCode = -1;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        result.resultCode = -3;
                        result.resultExtra = th;
                    }
                }
            }, (a.C0022a) new a.C0022a() {
                public void a() {
                    if (onFittingViewListener == null) {
                        return;
                    }
                    if (result.resultCode == -1) {
                        onFittingViewListener.OnFinishAsyncWork(runnable);
                    } else {
                        onFittingViewListener.OnOccurError(result);
                    }
                }
            });
            return true;
        }
    }

    public synchronized boolean SetAvatarHairTypeWithSetAvatarMode(int i, int i2, OnFittingViewListener onFittingViewListener, Runnable runnable) {
        Log.d(this.p, "SetAvatarHairTypeWithSetAvatarMode()+");
        if (i != 0) {
            if (this.q != 0) {
                if (i2 >= 0 && i2 < AvatarSetting.GetHairTypeCount(getContext(), this.r, this.s)) {
                    int i3 = this.t;
                    boolean z2 = this.x;
                    AvatarSetting avatarSetting = this.C;
                    return a(i, i3, i2, z2, AvatarSetting.a(), onFittingViewListener, runnable);
                }
                String str = this.p;
                Log.e(str, "WARNING :: invalid hair type - " + i2);
                return false;
            }
        }
        Log.e(this.p, "WARNING :: illegalState - wrong mode.");
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0041 A[SYNTHETIC, Splitter:B:19:0x0041] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean SetAvatarHeadTypeWithSetAvatarMode(int r10, int r11, boolean r12, net.fxgear.FittingView.OnFittingViewListener r13, java.lang.Runnable r14) {
        /*
            r9 = this;
            monitor-enter(r9)
            java.lang.String r1 = r9.p     // Catch:{ all -> 0x0062 }
            java.lang.String r2 = "SetAvatarHeadTypeWithSetAvatarMode()+"
            android.util.Log.d(r1, r2)     // Catch:{ all -> 0x0062 }
            r1 = 0
            if (r10 == 0) goto L_0x0059
            int r3 = r9.q     // Catch:{ all -> 0x0062 }
            if (r3 != 0) goto L_0x0010
            goto L_0x0059
        L_0x0010:
            android.content.Context r3 = r9.getContext()     // Catch:{ all -> 0x0062 }
            int r4 = r9.r     // Catch:{ all -> 0x0062 }
            int r5 = r9.s     // Catch:{ all -> 0x0062 }
            int r3 = net.fxgear.AvatarSetting.GetHeadTypeCount(r3, r4, r5)     // Catch:{ all -> 0x0062 }
            r4 = 1
            if (r11 < 0) goto L_0x002a
            if (r11 >= r3) goto L_0x002a
            if (r12 == 0) goto L_0x002b
            boolean r3 = r9.a()     // Catch:{ all -> 0x0062 }
            if (r3 == 0) goto L_0x002a
            goto L_0x002b
        L_0x002a:
            r4 = 0
        L_0x002b:
            if (r4 == 0) goto L_0x0041
            int r4 = r9.u     // Catch:{ all -> 0x0062 }
            net.fxgear.AvatarSetting r1 = r9.C     // Catch:{ all -> 0x0062 }
            float[] r6 = net.fxgear.AvatarSetting.a()     // Catch:{ all -> 0x0062 }
            r1 = r9
            r2 = r10
            r3 = r11
            r5 = r12
            r7 = r13
            r8 = r14
            boolean r0 = r1.a((int) r2, (int) r3, (int) r4, (boolean) r5, (float[]) r6, (net.fxgear.FittingView.OnFittingViewListener) r7, (java.lang.Runnable) r8)     // Catch:{ all -> 0x0062 }
            monitor-exit(r9)
            return r0
        L_0x0041:
            java.lang.String r2 = r9.p     // Catch:{ all -> 0x0062 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0062 }
            r3.<init>()     // Catch:{ all -> 0x0062 }
            java.lang.String r4 = "WARNING :: invalid head type - "
            r3.append(r4)     // Catch:{ all -> 0x0062 }
            r3.append(r11)     // Catch:{ all -> 0x0062 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0062 }
            android.util.Log.e(r2, r0)     // Catch:{ all -> 0x0062 }
            monitor-exit(r9)
            return r1
        L_0x0059:
            java.lang.String r0 = r9.p     // Catch:{ all -> 0x0062 }
            java.lang.String r2 = "WARNING :: illegalState - wrong mode."
            android.util.Log.e(r0, r2)     // Catch:{ all -> 0x0062 }
            monitor-exit(r9)
            return r1
        L_0x0062:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.FittingView.SetAvatarHeadTypeWithSetAvatarMode(int, int, boolean, net.fxgear.FittingView$OnFittingViewListener, java.lang.Runnable):boolean");
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:17:0x0030=Splitter:B:17:0x0030, B:13:0x0027=Splitter:B:13:0x0027} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean SetBodySizeAllWithSetAvatarMode(int r11, net.fxgear.BodySizeData r12, net.fxgear.FittingView.OnFittingViewListener r13, java.lang.Runnable r14) {
        /*
            r10 = this;
            monitor-enter(r10)
            java.lang.String r0 = r10.p     // Catch:{ all -> 0x0039 }
            java.lang.String r1 = "SetBodySizeAllWithSetAvatarMode()+"
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x0039 }
            r0 = 0
            if (r11 == 0) goto L_0x0030
            int r1 = r10.q     // Catch:{ all -> 0x0039 }
            if (r1 != 0) goto L_0x0010
            goto L_0x0030
        L_0x0010:
            net.fxgear.AvatarSetting r1 = r10.C     // Catch:{ all -> 0x0039 }
            if (r1 == 0) goto L_0x0027
            if (r12 == 0) goto L_0x0027
            int r4 = r10.t     // Catch:{ all -> 0x0039 }
            int r5 = r10.u     // Catch:{ all -> 0x0039 }
            boolean r6 = r10.x     // Catch:{ all -> 0x0039 }
            r2 = r10
            r3 = r11
            r7 = r12
            r8 = r13
            r9 = r14
            boolean r11 = r2.a((int) r3, (int) r4, (int) r5, (boolean) r6, (net.fxgear.BodySizeData) r7, (net.fxgear.FittingView.OnFittingViewListener) r8, (java.lang.Runnable) r9)     // Catch:{ all -> 0x0039 }
            monitor-exit(r10)
            return r11
        L_0x0027:
            java.lang.String r11 = r10.p     // Catch:{ all -> 0x0039 }
            java.lang.String r12 = "ERROR :: IllegalState or param is null."
            android.util.Log.d(r11, r12)     // Catch:{ all -> 0x0039 }
            monitor-exit(r10)
            return r0
        L_0x0030:
            java.lang.String r11 = r10.p     // Catch:{ all -> 0x0039 }
            java.lang.String r12 = "WARNING :: illegalState - wrong mode."
            android.util.Log.e(r11, r12)     // Catch:{ all -> 0x0039 }
            monitor-exit(r10)
            return r0
        L_0x0039:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.FittingView.SetBodySizeAllWithSetAvatarMode(int, net.fxgear.BodySizeData, net.fxgear.FittingView$OnFittingViewListener, java.lang.Runnable):boolean");
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:20:0x0044=Splitter:B:20:0x0044, B:24:0x004d=Splitter:B:24:0x004d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean CreateCustomfaceData(final java.io.File r4, final int[] r5, final net.fxgear.FittingView.OnFittingViewListener r6, final java.lang.Runnable r7) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.lang.String r0 = r3.p     // Catch:{ all -> 0x0056 }
            java.lang.String r1 = "CreateCustomfaceData()+"
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x0056 }
            r0 = 0
            if (r4 == 0) goto L_0x004d
            boolean r1 = r4.exists()     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x004d
            boolean r1 = r4.isFile()     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x004d
            if (r5 != 0) goto L_0x001a
            goto L_0x004d
        L_0x001a:
            net.fxgear.a r1 = r3.D     // Catch:{ all -> 0x0056 }
            if (r1 == 0) goto L_0x0044
            net.fxgear.a r1 = r3.D     // Catch:{ all -> 0x0056 }
            boolean r1 = r1.a()     // Catch:{ all -> 0x0056 }
            if (r1 != 0) goto L_0x0044
            if (r6 == 0) goto L_0x002b
            r6.OnStartAsyncWork()     // Catch:{ all -> 0x0056 }
        L_0x002b:
            net.fxgear.GlobalDefine$Result r1 = new net.fxgear.GlobalDefine$Result     // Catch:{ all -> 0x0056 }
            r1.<init>()     // Catch:{ all -> 0x0056 }
            r1.resultCode = r0     // Catch:{ all -> 0x0056 }
            net.fxgear.a r0 = r3.D     // Catch:{ all -> 0x0056 }
            net.fxgear.FittingView$29 r2 = new net.fxgear.FittingView$29     // Catch:{ all -> 0x0056 }
            r2.<init>(r4, r5, r1)     // Catch:{ all -> 0x0056 }
            net.fxgear.FittingView$30 r4 = new net.fxgear.FittingView$30     // Catch:{ all -> 0x0056 }
            r4.<init>(r6, r1, r7)     // Catch:{ all -> 0x0056 }
            r0.a((java.lang.Runnable) r2, (net.fxgear.a.C0022a) r4)     // Catch:{ all -> 0x0056 }
            r4 = 1
            monitor-exit(r3)
            return r4
        L_0x0044:
            java.lang.String r4 = r3.p     // Catch:{ all -> 0x0056 }
            java.lang.String r5 = "AsyncWorker is working."
            android.util.Log.d(r4, r5)     // Catch:{ all -> 0x0056 }
            monitor-exit(r3)
            return r0
        L_0x004d:
            java.lang.String r4 = r3.p     // Catch:{ all -> 0x0056 }
            java.lang.String r5 = "WARNING :: param error."
            android.util.Log.e(r4, r5)     // Catch:{ all -> 0x0056 }
            monitor-exit(r3)
            return r0
        L_0x0056:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.FittingView.CreateCustomfaceData(java.io.File, int[], net.fxgear.FittingView$OnFittingViewListener, java.lang.Runnable):boolean");
    }

    public synchronized boolean SetDefaultAvatarFace(int i, OnFittingViewListener onFittingViewListener, Runnable runnable) {
        int i2;
        i2 = i;
        return SetAvatarHeadTypeWithSkinValue(i2, false, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, FittingSurfaceView.colorTemperatureToNormalizeValue(new float[]{(float) FXUtil.redFromColor(-1), (float) FXUtil.greenFromColor(-1), (float) FXUtil.blueFromColor(-1)}), onFittingViewListener, runnable);
    }

    public synchronized boolean SetAvatarSkinAuto(final float f, boolean z2, final OnFittingViewListener onFittingViewListener, final Runnable runnable) {
        Log.d(this.p, "SetAvatarSkinAuto()+");
        if (!z2) {
            this.y = f;
            try {
                UpdateCustomfaceTexture(f);
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
                if (onFittingViewListener != null) {
                    GlobalDefine.Result result = new GlobalDefine.Result();
                    result.resultCode = -3;
                    result.resultExtra = th;
                    onFittingViewListener.OnOccurError(result);
                }
                return false;
            }
        } else if (this.D == null || this.D.a()) {
            Log.d(this.p, "fittingView working.");
            return false;
        } else {
            if (onFittingViewListener != null) {
                onFittingViewListener.OnStartAsyncWork();
            }
            this.y = f;
            final GlobalDefine.Result result2 = new GlobalDefine.Result();
            this.D.a((Runnable) new Runnable() {
                public void run() {
                    try {
                        FittingView.this.UpdateCustomfaceTexture(f);
                        result2.resultCode = -1;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        result2.resultCode = -3;
                        result2.resultExtra = th;
                    }
                }
            }, (a.C0022a) new a.C0022a() {
                public void a() {
                    if (onFittingViewListener == null) {
                        return;
                    }
                    if (result2.resultCode == -1) {
                        onFittingViewListener.OnFinishAsyncWork(runnable);
                    } else {
                        onFittingViewListener.OnOccurError(result2);
                    }
                }
            });
            return true;
        }
    }

    public synchronized boolean SetAvatarSkinTone(final float f, boolean z2, final OnFittingViewListener onFittingViewListener, final Runnable runnable) {
        Log.d(this.p, "SetAvatarSkinTone()+");
        if (!z2) {
            this.z = f;
            UpdateSkinToneAsync(f);
            return true;
        } else if (this.D == null || this.D.a()) {
            Log.d(this.p, "fittingView working.");
            return false;
        } else {
            if (onFittingViewListener != null) {
                onFittingViewListener.OnStartAsyncWork();
            }
            this.z = f;
            final GlobalDefine.Result result = new GlobalDefine.Result();
            this.D.a((Runnable) new Runnable() {
                public void run() {
                    try {
                        FittingView.this.UpdateSkinTone(f);
                        result.resultCode = -1;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        result.resultCode = -3;
                        result.resultExtra = th;
                    }
                }
            }, (a.C0022a) new a.C0022a() {
                public void a() {
                    if (onFittingViewListener == null) {
                        return;
                    }
                    if (result.resultCode == -1) {
                        onFittingViewListener.OnFinishAsyncWork(runnable);
                    } else {
                        onFittingViewListener.OnOccurError(result);
                    }
                }
            });
            return true;
        }
    }

    public synchronized boolean SetAvatarSkinToneWithAuto(final float f, final float f2, boolean z2, final OnFittingViewListener onFittingViewListener, final Runnable runnable) {
        Log.d(this.p, "SetAvatarSkinToneWithAuto()+");
        if (!z2) {
            try {
                this.z = f;
                this.y = f2;
                UpdateCustomfaceTexture(f2);
                UpdateSkinTone(f);
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
                if (onFittingViewListener != null) {
                    GlobalDefine.Result result = new GlobalDefine.Result();
                    result.resultCode = -3;
                    result.resultExtra = th;
                    onFittingViewListener.OnOccurError(result);
                }
                return false;
            }
        } else if (this.D == null || this.D.a()) {
            Log.d(this.p, "fittingView working.");
            return false;
        } else {
            if (onFittingViewListener != null) {
                onFittingViewListener.OnStartAsyncWork();
            }
            this.z = f;
            this.y = f2;
            final GlobalDefine.Result result2 = new GlobalDefine.Result();
            this.D.a((Runnable) new Runnable() {
                public void run() {
                    try {
                        FittingView.this.UpdateCustomfaceTexture(f2);
                        FittingView.this.UpdateSkinTone(f);
                        result2.resultCode = -1;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        result2.resultCode = -3;
                        result2.resultExtra = th;
                    }
                }
            }, (a.C0022a) new a.C0022a() {
                public void a() {
                    if (onFittingViewListener == null) {
                        return;
                    }
                    if (result2.resultCode == -1) {
                        onFittingViewListener.OnFinishAsyncWork(runnable);
                    } else {
                        onFittingViewListener.OnOccurError(result2);
                    }
                }
            });
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007b, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean SetAvatarHeadTypeWithSkinValue(int r5, boolean r6, float r7, float r8, final net.fxgear.FittingView.OnFittingViewListener r9, final java.lang.Runnable r10) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = r4.p     // Catch:{ all -> 0x007c }
            java.lang.String r1 = "SetAvatarHeadTypeWithSkinValue()+"
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x007c }
            int r0 = r4.q     // Catch:{ all -> 0x007c }
            r1 = 0
            if (r0 == 0) goto L_0x007a
            android.content.Context r0 = r4.getContext()     // Catch:{ all -> 0x007c }
            int r2 = r4.r     // Catch:{ all -> 0x007c }
            int r3 = r4.s     // Catch:{ all -> 0x007c }
            int r0 = net.fxgear.AvatarSetting.GetHeadTypeCount(r0, r2, r3)     // Catch:{ all -> 0x007c }
            r2 = 1
            if (r5 < 0) goto L_0x0028
            if (r5 >= r0) goto L_0x0028
            if (r6 == 0) goto L_0x0026
            boolean r0 = r4.a()     // Catch:{ all -> 0x007c }
            if (r0 == 0) goto L_0x0028
        L_0x0026:
            r0 = 1
            goto L_0x0029
        L_0x0028:
            r0 = 0
        L_0x0029:
            if (r0 == 0) goto L_0x0064
            net.fxgear.a r0 = r4.D     // Catch:{ all -> 0x007c }
            if (r0 == 0) goto L_0x005c
            net.fxgear.a r0 = r4.D     // Catch:{ all -> 0x007c }
            boolean r0 = r0.a()     // Catch:{ all -> 0x007c }
            if (r0 != 0) goto L_0x005c
            if (r9 == 0) goto L_0x003c
            r9.OnStartAsyncWork()     // Catch:{ all -> 0x007c }
        L_0x003c:
            r4.x = r6     // Catch:{ all -> 0x007c }
            r4.t = r5     // Catch:{ all -> 0x007c }
            r4.y = r7     // Catch:{ all -> 0x007c }
            r4.z = r8     // Catch:{ all -> 0x007c }
            net.fxgear.GlobalDefine$Result r5 = new net.fxgear.GlobalDefine$Result     // Catch:{ all -> 0x007c }
            r5.<init>()     // Catch:{ all -> 0x007c }
            r5.resultCode = r1     // Catch:{ all -> 0x007c }
            net.fxgear.a r6 = r4.D     // Catch:{ all -> 0x007c }
            net.fxgear.FittingView$38 r7 = new net.fxgear.FittingView$38     // Catch:{ all -> 0x007c }
            r7.<init>(r5)     // Catch:{ all -> 0x007c }
            net.fxgear.FittingView$39 r8 = new net.fxgear.FittingView$39     // Catch:{ all -> 0x007c }
            r8.<init>(r9, r5, r10)     // Catch:{ all -> 0x007c }
            r6.a((java.lang.Runnable) r7, (net.fxgear.a.C0022a) r8)     // Catch:{ all -> 0x007c }
            monitor-exit(r4)
            return r2
        L_0x005c:
            java.lang.String r5 = r4.p     // Catch:{ all -> 0x007c }
            java.lang.String r6 = "AsyncWorker is working."
            android.util.Log.d(r5, r6)     // Catch:{ all -> 0x007c }
            goto L_0x007a
        L_0x0064:
            java.lang.String r6 = r4.p     // Catch:{ all -> 0x007c }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x007c }
            r7.<init>()     // Catch:{ all -> 0x007c }
            java.lang.String r8 = "WARNING :: invalid head type - "
            r7.append(r8)     // Catch:{ all -> 0x007c }
            r7.append(r5)     // Catch:{ all -> 0x007c }
            java.lang.String r5 = r7.toString()     // Catch:{ all -> 0x007c }
            android.util.Log.e(r6, r5)     // Catch:{ all -> 0x007c }
        L_0x007a:
            monitor-exit(r4)
            return r1
        L_0x007c:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.FittingView.SetAvatarHeadTypeWithSkinValue(int, boolean, float, float, net.fxgear.FittingView$OnFittingViewListener, java.lang.Runnable):boolean");
    }

    public synchronized boolean GetScreenShot(int i, int i2, boolean z2, boolean z3, boolean z4, OnFittingViewListener onFittingViewListener, Runnable runnable) {
        final OnFittingViewListener onFittingViewListener2 = onFittingViewListener;
        synchronized (this) {
            Log.d(this.p, "GetScreenShot()+");
            if (this.E != null) {
                if (!this.E.isRecycled()) {
                    this.E.recycle();
                }
                this.E = null;
            }
            if (this.D == null || this.D.a()) {
                Log.d(this.p, "fittingView working.");
                return false;
            }
            if (onFittingViewListener2 != null) {
                onFittingViewListener.OnStartAsyncWork();
            }
            final GlobalDefine.Result result = new GlobalDefine.Result();
            final int i3 = i;
            final int i4 = i2;
            final boolean z5 = z3;
            final boolean z6 = z2;
            final boolean z7 = z4;
            final GlobalDefine.Result result2 = result;
            final Runnable runnable2 = runnable;
            this.D.a((Runnable) new Runnable() {
                public void run() {
                    try {
                        Bitmap unused = FittingView.this.E = FittingView.this.GetScreenShot(i3, i4, z5, z6, z7);
                        result2.resultCode = -1;
                    } catch (Throwable th) {
                        th.printStackTrace();
                        result2.resultCode = -3;
                        result2.resultExtra = th;
                    }
                }
            }, (a.C0022a) new a.C0022a() {
                public void a() {
                    if (onFittingViewListener2 == null) {
                        return;
                    }
                    if (result.resultCode == -1) {
                        onFittingViewListener2.OnFinishAsyncWork(runnable2);
                    } else {
                        onFittingViewListener2.OnOccurError(result);
                    }
                }
            });
            return true;
        }
    }

    public synchronized boolean SetAvatarSkinToneWithChangeAvatarMode(int i, float f, float f2, OnFittingViewListener onFittingViewListener, Runnable runnable) {
        Log.d(this.p, "SetAvatarSkinToneWithChangeAvatarMode()+");
        if (i != 0) {
            if (this.q != 0) {
                this.y = f;
                this.z = f2;
                int i2 = this.t;
                int i3 = this.u;
                boolean z2 = this.x;
                AvatarSetting avatarSetting = this.C;
                return a(i, i2, i3, z2, AvatarSetting.a(), onFittingViewListener, runnable);
            }
        }
        Log.e(this.p, "WARNING :: illegalState - wrong mode.");
        return false;
    }

    private void a(int i, int i2, BodySizeData bodySizeData) {
        if (this.C != null && bodySizeData != null) {
            this.C.SetCharacter(i, i2);
            this.C.SetValueOfBodyPart(0, (double) bodySizeData.mTallSize);
            this.C.SetValueOfBodyPart(5, (double) bodySizeData.mUpperSize);
            this.C.SetValueOfBodyPart(6, (double) bodySizeData.mLowerSize);
            this.C.SetValueOfBodyPart(1, (double) bodySizeData.mShoulderSize);
            this.C.SetValueOfBodyPart(7, (double) bodySizeData.mBustSize);
            this.C.SetValueOfBodyPart(8, (double) bodySizeData.mCupSize);
            this.C.SetValueOfBodyPart(9, (double) bodySizeData.mWaistSize);
            this.C.SetValueOfBodyPart(11, (double) bodySizeData.mHipSize);
            this.C.SetValueOfBodyPart(2, (double) bodySizeData.mArmLengthSize);
            this.C.SetValueOfBodyPart(10, (double) bodySizeData.mArmThickSize);
            this.C.SetValueOfBodyPart(3, (double) bodySizeData.mThighLengthSize);
            this.C.SetValueOfBodyPart(12, (double) bodySizeData.mThighThickSize);
            this.C.SetValueOfBodyPart(4, (double) bodySizeData.mCalfLengthSize);
            this.C.SetValueOfBodyPart(14, (double) bodySizeData.mHeadHeight);
        }
    }
}
package net.fxgear;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.util.Log;
import android.util.TypedValue;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import net.fxgear.fittingview.data.FittingFaceData;

public class GlobalDefine {
    public static final int AGE_EARLY = 1;
    public static final String AGE_EARLY_STRING = "early";
    public static final int AGE_LATE = 3;
    public static final String AGE_LATE_STRING = "late";
    public static final int AGE_MIDDLE = 2;
    public static final String AGE_MIDDLE_STRING = "middle";
    public static final int ANIMTAION_TYPE_DEFAULT = 0;
    public static final int ANIMTAION_TYPE_WEDDING = 1;
    public static final int AVATAR_ID_NONE = -1;
    public static final String BASE_CATEGORY_NAME_WEDDING = "WomCloOne010";
    public static final int BODY_TEXTURE_TYPE_BOTTOM_NAKED = 2;
    public static final int BODY_TEXTURE_TYPE_DEFAULT = 0;
    public static final int BODY_TEXTURE_TYPE_NAKED = 3;
    public static final int BODY_TEXTURE_TYPE_TOP_NAKED = 1;
    public static final String CLOTH_DIRECTORY_KEYWORD = "Clo";
    public static final String CLOTH_GENDER_PREFIX_MAN = "Man";
    public static final String CLOTH_GENDER_PREFIX_WOMAN = "Wom";
    public static final int CLOTH_ID_NONE = -1;
    public static final String CLOTH_KEYWORD_BOTTOM = "Bot";
    public static final String CLOTH_KEYWORD_COAT = "Cot";
    public static final String CLOTH_KEYWORD_JACKET = "Jac";
    public static final String CLOTH_KEYWORD_ONEPIECE = "One";
    public static final String CLOTH_KEYWORD_SHOES = "Sho";
    public static final String CLOTH_KEYWORD_TOP = "Top";
    public static final int CONTENTS_DATA_COUNT = 3;
    public static final int CONTENTS_DATA_TYPE_BASE = 0;
    public static final int CONTENTS_DATA_TYPE_HAIR = 1;
    public static final int CONTENTS_DATA_TYPE_HEAD = 2;
    public static final int DATA_TYPE_DROPBOX = 3;
    public static final int DATA_TYPE_NEW_BALANCE_DEMO_DROPBOX = 4;
    public static final int DATA_TYPE_SERVER = 0;
    public static final int DATA_TYPE_TEST_3D_ARTS = 2;
    public static final int DATA_TYPE_TEST_GRAPHICS = 1;
    public static final boolean DEBUG = true;
    public static final float DEFAULT_AUTO_FILTER_VALUE = 0.0f;
    public static final String DEFAULT_FOLDER_NAME = "default";
    public static final int DEFAULT_HAIR_TYPE_INDEX = 0;
    public static final int DEFAULT_HEAD_TYPE_ID = 2;
    public static final int DEFAULT_HEAD_TYPE_INDEX = 0;
    public static final int DEFAULT_TEMPERATURE_COLOR_VALUE = -1;
    public static final String DIRECTORY_NAME_ACCESSORIES = "Accessories";
    public static final String DIRECTORY_NAME_ADULT = "Adult";
    public static final String DIRECTORY_NAME_ANIMATION = "Animation";
    public static final String DIRECTORY_NAME_AVATAR = "Avatar";
    public static final String DIRECTORY_NAME_AVATAR_DATA = "AvatarData";
    public static final String DIRECTORY_NAME_BASE = "Base";
    public static final String DIRECTORY_NAME_BODY = "Body";
    public static final String DIRECTORY_NAME_BOTTOM = "Bottom";
    public static final String DIRECTORY_NAME_BOY = "Boy";
    public static final String DIRECTORY_NAME_CHARACTER_DATA = "CharacterData";
    public static final String DIRECTORY_NAME_CLOTH = "Cloth";
    public static final String DIRECTORY_NAME_COAT = "Coat";
    public static final String DIRECTORY_NAME_COMMON = "Common";
    public static final String DIRECTORY_NAME_ENGINE = "Engine";
    public static final String DIRECTORY_NAME_FACE = "Face";
    public static final String DIRECTORY_NAME_GIRL = "Girl";
    public static final String DIRECTORY_NAME_HAIR = "Hair";
    public static final String DIRECTORY_NAME_HEAD = "Head";
    public static final String DIRECTORY_NAME_JACKET = "Jacket";
    public static final String DIRECTORY_NAME_KIDS = "Kids";
    public static final String DIRECTORY_NAME_MAN = "Man";
    public static final String DIRECTORY_NAME_ONEPIECE = "OnePiece";
    public static final String DIRECTORY_NAME_REAL = "Real";
    public static final String DIRECTORY_NAME_ROOT = "Data";
    public static final String DIRECTORY_NAME_RUNTIME = "Runtime";
    public static final String DIRECTORY_NAME_SHOES = "Shoes";
    public static final String DIRECTORY_NAME_SPECIAL_ANIMATIONS = "Special_Animations";
    public static final String DIRECTORY_NAME_TEMP = "TEMP";
    public static final String DIRECTORY_NAME_TOP = "Top";
    public static final String DIRECTORY_NAME_TYPE_RESOURCE = "Resource";
    public static final String DIRECTORY_NAME_UNISEX_ADULT = "UnisexAdult";
    public static final String DIRECTORY_NAME_UNISEX_CHILD = "UnisexChild";
    public static final String DIRECTORY_NAME_WOMAN = "Woman";
    public static final int ENGINE_DATA_TYPE = 0;
    public static final String EXTENSION_BIN = ".bin";
    public static final String EXTENSION_DAT = ".dat";
    public static final String EXTENSION_JPG = ".jpg";
    public static final String EXTENSION_MP4 = ".mp4";
    public static final String EXTENSION_PNG = ".png";
    public static final String EXTENSION_TXT = ".txt";
    public static final String EXTENSION_ZIP = ".zip";
    public static final String FILE_NAME_ANIMATION = "Animation.bin";
    public static final String FILE_NAME_ANIMATION_DEFAULT = "Bone_Animation.bin";
    public static final String FILE_NAME_ANIMATION_WEDDING = "Bone_Animation_Wedding.bin";
    public static final String FILE_NAME_AVATAR_THUMBNAIL = "Avatar_Thumbnail.png";
    public static final String FILE_NAME_BODY_TEXTURE_ARM_THICK = "Part_ArmThick.png";
    public static final String FILE_NAME_BODY_TEXTURE_BUST = "Part_Bust.png";
    public static final String FILE_NAME_BODY_TEXTURE_CALF_LENGTH = "Part_CalfLength.png";
    public static final String FILE_NAME_BODY_TEXTURE_CUP_SIZE = "Part_CupSize.png";
    public static final String FILE_NAME_BODY_TEXTURE_HIP = "Part_Hip.png";
    public static final String FILE_NAME_BODY_TEXTURE_SHOULDER = "Part_Shoulder.png";
    public static final String FILE_NAME_BODY_TEXTURE_THIGH_LENGTH = "Part_ThighLength.png";
    public static final String FILE_NAME_BODY_TEXTURE_THIGH_THICK = "Part_ThighThick.png";
    public static final String FILE_NAME_BODY_TEXTURE_WAIST = "Part_Waist.png";
    public static final String FILE_NAME_BONE_HIERARCHY = "Bone_Hierarchy.bin";
    public static final String FILE_NAME_CAPTURE = "Capture.png";
    public static final String FILE_NAME_CONTROL_ATTRIBUTES = "ControlAttributes.txt";
    public static final String FILE_NAME_CUSTOM_DETECT_CROP_FACE = "Custom_Detect_Crop_Face.png";
    public static final String FILE_NAME_CUSTOM_DETECT_POSITION = "Custom_Detect_Position.bin";
    public static final String FILE_NAME_CUSTOM_TEXTURE = "Texture_Type_Custom.png";
    public static final String FILE_NAME_DESCRIPTION = "Description.txt";
    public static final String FILE_NAME_FORMAT_ANIMATION = "Animation_%s.bin";
    public static final String FILE_NAME_FORMAT_BLEND_TARGET = "Blend_Target_%d.bin";
    public static final String FILE_NAME_FORMAT_CHARACTER_DATA = "CharacterData_%s_%s.dat";
    public static final String FILE_NAME_FORMAT_CLOTH_BASE_MESH = "Cloth%s_Base.bin";
    public static final String FILE_NAME_FORMAT_CLOTH_BLEND_TARGET = "Cloth%s_Tar%s.bin";
    public static final String FILE_NAME_FORMAT_CLOTH_TUCKIN_TARGET = "Cloth%s_Tuckin_Tar%s.bin";
    public static final String FILE_NAME_FORMAT_CUSTOM_MESH_TYPE = "Mesh_Type_%d_Custom.bin";
    public static final String FILE_NAME_FORMAT_VIDEO = "Video_%s.mp4";
    public static final String FILE_NAME_KEYWORD_FORMAT_CUSTOM_MESH_TYPE = "Mesh_Type_%d_Custom";
    public static final String FILE_NAME_MATERIAL_INFO = "MaterialInfo.txt";
    public static final String FILE_NAME_MESH = "Mesh.bin";
    public static final String FILE_NAME_PACKAGE = "package.bin";
    public static final String FILE_NAME_PREFIX_CHARACTER_DATA = "CharacterData";
    public static final String FILE_NAME_PREFIX_VIDEO = "Video_";
    public static final String FILE_NAME_SEPARATOR = "_";
    public static final String FILE_NAME_TEXTURE = "Texture.png";
    public static final String FILE_NAME_TEXTURE_BASE = "Texture_Base.png";
    public static final String FILE_NAME_TEXTURE_BOTTOM_NAKED_JPG = "Texture_bottom_naked.jpg";
    public static final String FILE_NAME_TEXTURE_COLOR = "Texture_Color.png";
    public static final String FILE_NAME_TEXTURE_JPG = "Texture.jpg";
    public static final String FILE_NAME_TEXTURE_NAKED_JPG = "Texture_naked.jpg";
    public static final String FILE_NAME_TEXTURE_SHADE = "Texture_Shading.png";
    public static final String FILE_NAME_TEXTURE_SHADOW = "Texture_Shadow.png";
    public static final String FILE_NAME_TEXTURE_TOP_NAKED_JPG = "Texture_top_naked.jpg";
    public static final String FILE_NAME_THUMBNAIL_NORMAL = "Thumbnail_normal.png";
    public static final String FILE_NAME_THUMBNAIL_SELECTED = "Thumbnail_selected.png";
    public static final String FILE_NAME_VIDEO = "Video.mp4";
    public static final String FITTING_BASE_DATA_FILE_NAME = "DATA_BASE.zip";
    public static final String FITTING_DATA_FILE_NAME = "DATA_V2.zip";
    public static final String FITTING_HAIR_DATA_FILE_NAME = "DATA_HAIR.zip";
    public static final String FITTING_HEAD_DATA_FILE_NAME = "DATA_HEAD.zip";
    public static final String FORMAT_PATH_DEPTH_1 = "%s/%s";
    public static final String FORMAT_QR_ANIMATION_URL = "%s/USER/%s/%s/Animation.bin";
    public static final String FORMAT_QR_CAPTURE_URL = "%s/USER/%s/%s/Capture.png";
    public static final String FORMAT_QR_VIDEO_URL = "%s/USER/%s/%s/Video.mp4";
    public static final String FORMAT_VERIFICATION_CONTENTS_FILE_NAME = "ContentsData_%d.dat";
    public static final int GENDER_MAN = 2;
    public static final String GENDER_MAN_STRING = "man";
    public static final int GENDER_UNISEX = 3;
    public static final String GENDER_UNISEX_STRING = "unisex";
    public static final int GENDER_WOMAN = 1;
    public static final String GENDER_WOMAN_STRING = "woman";
    public static final int ITEM_STATE_DOWNLOADED_DATA = 1;
    public static final int ITEM_STATE_NEED_TO_DOWNLOAD_DATA = 0;
    public static final int ITEM_STATE_NONE_INFO = -1;
    public static final String JSON_KEY_UPDATE_DATE_BASE = "base";
    public static final String JSON_KEY_UPDATE_DATE_HAIR = "hair";
    public static final String JSON_KEY_UPDATE_DATE_HEAD = "head";
    public static final int MODE_ADD_AVATAR = 7;
    public static final int MODE_AVATAR = 1;
    public static final int MODE_AVATAR_BODY_EDITING = 2;
    public static final int MODE_AVATAR_CUSTOM_FACE_EDITING = 6;
    public static final int MODE_AVATAR_FACE_EDITING = 4;
    public static final int MODE_AVATAR_HAIR_EDITING = 3;
    public static final int MODE_AVATAR_SKINTONE_EDITING = 5;
    public static final int MODE_CHECK_CLOTHES_SIZE = 8;
    public static final int MODE_REAL = 0;
    public static final String REAL_VIDEO_BODY_SIZE_CUSTOM = "FREE";
    public static final String REAL_VIDEO_DEFAULT_SIZE_BOY = "160";
    public static final String REAL_VIDEO_DEFAULT_SIZE_GIRL = "130";
    public static final String REAL_VIDEO_DEFAULT_SIZE_MAN = "105";
    public static final String REAL_VIDEO_DEFAULT_SIZE_WOMAN = "44";
    public static final int REAL_VIDEO_ID_NONE = -1;
    public static final String REAL_VIDEO_NONE_DATE = "0";
    public static final int RESULT_CODE_CANCEL = -2;
    public static final int RESULT_CODE_ERROR_CONNECTION = 10;
    public static final int RESULT_CODE_ERROR_EXIST_DATA = 5;
    public static final int RESULT_CODE_ERROR_EXPIRED_DATE = 12;
    public static final int RESULT_CODE_ERROR_FAILED_TO_DETECT = 18;
    public static final int RESULT_CODE_ERROR_FAILED_TO_DETECT_WITH_LOW_SCROE = 19;
    public static final int RESULT_CODE_ERROR_FAILED_TO_DETECT_ZERO_FACE = 20;
    public static final int RESULT_CODE_ERROR_FAILED_TO_SAVE_BITMAP = 17;
    public static final int RESULT_CODE_ERROR_ILLEGAL_STATE = 2;
    public static final int RESULT_CODE_ERROR_INSUFFICIENT_SPACE = 4;
    public static final int RESULT_CODE_ERROR_MALFORMEDURL = 13;
    public static final int RESULT_CODE_ERROR_NETWORK_IO = 14;
    public static final int RESULT_CODE_ERROR_NOT_FOUND_FILE = 16;
    public static final int RESULT_CODE_ERROR_OUT_OF_MEMORY = 15;
    public static final int RESULT_CODE_ERROR_PARAM = 1;
    public static final int RESULT_CODE_ERROR_RESPONSE = 11;
    public static final int RESULT_CODE_ERROR_UNKNOWN = 0;
    public static final int RESULT_CODE_ERROR_WRONG_DATA = 3;
    public static final int RESULT_CODE_OCCURED_EXCEPTION = -3;
    public static final int RESULT_CODE_SUCCESS = -1;
    public static final int STATE_DONE_CHANGE_DEFAULT_REAL_VIDEO = 2;
    public static final int STATE_DOWNLOAD_CHANGE_DEFAULT_REAL_VIDEO = 1;
    public static final int STATE_NONE_CHANGE_DEFAULT_REAL_VIDEO = 0;
    public static final String SYMBOL_TEMP = "_tmp";
    public static final String TAG = "GlobalDefine";
    public static final String TARGET_OS = "Android";
    public static final int THUMBNAIL_HEIGHT = 951;
    public static final int THUMBNAIL_WIDTH = 535;
    public static final String UNITY_CLOTH_DATA_DIRECTORY_NAME = "DAT";
    public static final String UNITY_PREFERENCE_NAME = "net.fxgear.fitnshop.v2.playerprefs";
    public static final String UNITY_REAL_VIDEO_ANIMATION_FILE_FORMAT = "%s_%s_Animation.bin";
    public static final String UNITY_REAL_VIDEO_DATA_DIRECTORY_NAME = "REC";
    public static final int UNITY_REAL_VIDEO_FILE_NAME_COMPONENT_COUNT = 3;
    public static final int UNITY_REAL_VIDEO_GENDER_INDEX = 0;
    public static final String UNITY_REAL_VIDEO_QR_DATA_DIRECTORY_NAME = "USER";
    public static final int UNITY_REAL_VIDEO_SIZE_OR_GUID_INDEX = 1;
    public static final String UNITY_REAL_VIDEO_VERSION_PERFERENCE_FORMAT = "ver_%s_%s";
    public static final String UNITY_REAL_VIDEO_VIDEO_FILE_FORMAT = "%s_%s_Video.mp4";
    public static final String URL_FITTING_DATA_FOLDER = "default/app/";
    public static final String VERIFICATION_FILE_NAME = "vDATA.fx";

    /* renamed from: a  reason: collision with root package name */
    private static String f653a;

    /* renamed from: b  reason: collision with root package name */
    private static String f654b;
    private static String c;
    private static String d;
    private static String e;
    private static String f;
    private static String g;
    private static String h;

    public enum CLOTHES_CATEGORY_TYPE {
        Default,
        TuckIn,
        Swimsuit,
        LongTop,
        Jumpsuit
    }

    public enum ClothesVisualizationOption {
        Color,
        Pressure,
        Tension
    }

    public static class Request {
    }

    public static class Result {
        public Request request;
        public int resultCode;
        public Object resultExtra;
    }

    public static String GetBodyTextureFileName(Context context, int i, int i2, int i3) {
        switch (i) {
            case 1:
                if (i2 != 2) {
                    return FILE_NAME_TEXTURE_JPG;
                }
                switch (i3) {
                    case 1:
                        return FILE_NAME_TEXTURE_TOP_NAKED_JPG;
                    case 2:
                        return FILE_NAME_TEXTURE_BOTTOM_NAKED_JPG;
                    case 3:
                        return FILE_NAME_TEXTURE_NAKED_JPG;
                    default:
                        return FILE_NAME_TEXTURE_JPG;
                }
            case 2:
                if (i2 != 2) {
                    return FILE_NAME_TEXTURE_JPG;
                }
                switch (i3) {
                    case 2:
                    case 3:
                        return FILE_NAME_TEXTURE_NAKED_JPG;
                    default:
                        return FILE_NAME_TEXTURE_JPG;
                }
            default:
                return FILE_NAME_TEXTURE_JPG;
        }
    }

    public static File GetEngineDirectory(Context context) {
        return null;
    }

    public static File GetEngineFaceDirectory(Context context) {
        return null;
    }

    public static String GetFittingDataFileName(int i) {
        switch (i) {
            case 0:
                return FITTING_BASE_DATA_FILE_NAME;
            case 1:
                return FITTING_HAIR_DATA_FILE_NAME;
            case 2:
                return FITTING_HEAD_DATA_FILE_NAME;
            default:
                return null;
        }
    }

    public enum ClothesSize {
        XS,
        S,
        M,
        L,
        XL,
        XXL,
        XXXL;

        public static String getClothesSizeName(ClothesSize clothesSize) {
            switch (clothesSize) {
                case XS:
                case S:
                case M:
                case L:
                case XL:
                    return clothesSize.name();
                case XXL:
                    return "2XL";
                case XXXL:
                    return "3XL";
                default:
                    return null;
            }
        }
    }

    public static File GetRootDirectory(Context context) {
        if (context == null) {
            return null;
        }
        if (f653a != null && f653a.length() > 0) {
            return new File(f653a);
        }
        File file = new File(context.getFilesDir(), DIRECTORY_NAME_ROOT);
        f653a = file.getAbsolutePath();
        return file;
    }

    public static void SetRootDirectory(String str) {
        f653a = str;
    }

    public static void SetRootDirectory(File file) {
        SetRootDirectory(file.getAbsolutePath());
    }

    public static File GetExternalDirectory() {
        return Environment.getExternalStorageDirectory();
    }

    public static File GetTempDirectory(Context context) {
        if (context != null) {
            return new File(GetRootDirectory(context), DIRECTORY_NAME_TEMP);
        }
        return null;
    }

    public static File GetAnimationDirectory(Context context) {
        if (context != null) {
            return new File(GetRootDirectory(context), DIRECTORY_NAME_ANIMATION);
        }
        return null;
    }

    public static File GetAvatarDirectory(Context context) {
        if (context != null) {
            return new File(GetRootDirectory(context), DIRECTORY_NAME_AVATAR);
        }
        return null;
    }

    public static File GetRealDirectory(Context context) {
        if (context != null) {
            return new File(GetRootDirectory(context), DIRECTORY_NAME_REAL);
        }
        return null;
    }

    public static File GetRealDirectory(Context context, int i, int i2) {
        String str;
        if (i == 2) {
            if (i2 == 1) {
                str = DIRECTORY_NAME_BOY;
            } else if (i2 == 2) {
                str = "Man";
            } else {
                Log.e(TAG, "GetRealDirectory(), gender is MAN, undefined age, age = " + i2);
                str = "Man";
            }
        } else if (i != 1) {
            Log.e(TAG, "GetRealDirectory(), gender is undefined, gender = " + i + ", age = " + i2);
            str = DIRECTORY_NAME_WOMAN;
        } else if (i2 == 1) {
            str = DIRECTORY_NAME_GIRL;
        } else if (i2 == 2) {
            str = DIRECTORY_NAME_WOMAN;
        } else {
            Log.e(TAG, "GetRealDirectory(), gender is WOMAN, undefined age, age = " + i2);
            str = DIRECTORY_NAME_WOMAN;
        }
        return new File(GetRealDirectory(context), str);
    }

    public static File GetAvatarCommonDirectory(Context context) {
        if (context != null) {
            return new File(GetAvatarDirectory(context), DIRECTORY_NAME_COMMON);
        }
        return null;
    }

    public static File GetAvatarHeadResourceDirectory(Context context) {
        if (context != null) {
            return new File(GetAvatarCommonDirectory(context), DIRECTORY_NAME_HEAD);
        }
        return null;
    }

    public static File GetAvatarFaceDirectory(Context context, int i, int i2) {
        String str;
        if (context == null) {
            return null;
        }
        if (i == 2) {
            if (i2 == 1) {
                str = DIRECTORY_NAME_BOY;
            } else if (i2 == 2) {
                str = "Man";
            } else {
                Log.e(TAG, "GetAvatarFaceDirectory(), gender is MAN, undefined age, age = " + i2);
                str = "Man";
            }
        } else if (i != 1) {
            Log.e(TAG, "GetAvatarFaceDirectory(), gender is undefined, gender = " + i + ", age = " + i2);
            str = DIRECTORY_NAME_WOMAN;
        } else if (i2 == 1) {
            str = DIRECTORY_NAME_GIRL;
        } else if (i2 == 2) {
            str = DIRECTORY_NAME_WOMAN;
        } else {
            Log.e(TAG, "GetAvatarFaceDirectory(), gender is WOMAN, undefined age, age = " + i2);
            str = DIRECTORY_NAME_WOMAN;
        }
        return new File(String.format("%s" + File.separator + "%s" + File.separator + "%s", new Object[]{GetAvatarDirectory(context).getAbsoluteFile(), str, DIRECTORY_NAME_HEAD}), DIRECTORY_NAME_FACE);
    }

    public static File GetAvatarFaceCommonDirectory(Context context, int i, int i2) {
        return GetAvatarCommonDirectory(context);
    }

    public static String GetClothTargetName(String str) {
        if (str.indexOf("Top") > -1) {
            return str.substring(str.indexOf("Top"), str.length());
        }
        if (str.indexOf(CLOTH_KEYWORD_BOTTOM) > -1) {
            return str.substring(str.indexOf(CLOTH_KEYWORD_BOTTOM), str.length());
        }
        if (str.indexOf(CLOTH_KEYWORD_ONEPIECE) > -1) {
            return str.substring(str.indexOf(CLOTH_KEYWORD_ONEPIECE), str.length());
        }
        if (str.indexOf(CLOTH_KEYWORD_JACKET) > -1) {
            return str.substring(str.indexOf(CLOTH_KEYWORD_JACKET), str.length());
        }
        if (str.indexOf(CLOTH_KEYWORD_COAT) > -1) {
            return str.substring(str.indexOf(CLOTH_KEYWORD_COAT), str.length());
        }
        return null;
    }

    public static File GetClothDirectory(Context context) {
        if (context != null) {
            return new File(GetRootDirectory(context), DIRECTORY_NAME_CLOTH);
        }
        return null;
    }

    public static File GetClothTypeDirectory(Context context, int i, int i2, int i3) {
        String str;
        String str2;
        if (i == 2) {
            if (i2 == 1) {
                str = DIRECTORY_NAME_BOY;
            } else if (i2 == 2) {
                str = "Man";
            } else {
                Log.e(TAG, "GetClothTypeDirectory(), gender is MAN, undefined age, age = " + i2);
                str = "Man";
            }
        } else if (i == 1) {
            if (i2 == 1) {
                str = DIRECTORY_NAME_GIRL;
            } else if (i2 == 2) {
                str = DIRECTORY_NAME_WOMAN;
            } else {
                Log.e(TAG, "GetClothTypeDirectory(), gender is WOMAN, undefined age, age = " + i2);
                str = DIRECTORY_NAME_WOMAN;
            }
        } else if (i2 == 1) {
            str = DIRECTORY_NAME_UNISEX_CHILD;
        } else if (i2 == 2) {
            str = DIRECTORY_NAME_UNISEX_ADULT;
        } else {
            Log.e(TAG, "GetClothTypeDirectory(), gender is UNISEX, undefined age, age = " + i2);
            str = DIRECTORY_NAME_UNISEX_CHILD;
        }
        if (i3 == 0) {
            str2 = "Top";
        } else if (i3 == 1) {
            str2 = DIRECTORY_NAME_BOTTOM;
        } else if (i3 == 2) {
            str2 = DIRECTORY_NAME_ONEPIECE;
        } else if (i3 == 3) {
            str2 = DIRECTORY_NAME_JACKET;
        } else if (i3 == 4) {
            str2 = DIRECTORY_NAME_COAT;
        } else if (i3 == 5) {
            str2 = DIRECTORY_NAME_SHOES;
        } else {
            Log.e(TAG, "GetClothDirectory(), undefined clothType = " + i3);
            str2 = "Top";
        }
        return new File(GetClothDirectory(context).getAbsolutePath() + File.separator + str + File.separator + str2);
    }

    public static CLOTHES_CATEGORY_TYPE GetClothesCategoryType(String str) {
        CLOTHES_CATEGORY_TYPE clothes_category_type;
        CLOTHES_CATEGORY_TYPE clothes_category_type2 = CLOTHES_CATEGORY_TYPE.Default;
        if (str.indexOf(CLOTH_KEYWORD_ONEPIECE) > -1) {
            String substring = str.substring(str.indexOf(CLOTH_KEYWORD_ONEPIECE) + CLOTH_KEYWORD_ONEPIECE.length());
            if (substring.startsWith("9")) {
                return CLOTHES_CATEGORY_TYPE.Swimsuit;
            }
            if (substring.equals("118")) {
                return CLOTHES_CATEGORY_TYPE.Jumpsuit;
            }
            return clothes_category_type2;
        } else if (str.indexOf("Top") <= -1) {
            return (str.indexOf(CLOTH_KEYWORD_BOTTOM) <= -1 || !str.substring(str.indexOf(CLOTH_KEYWORD_BOTTOM) + CLOTH_KEYWORD_BOTTOM.length()).startsWith("9")) ? clothes_category_type2 : CLOTHES_CATEGORY_TYPE.Swimsuit;
        } else {
            String substring2 = str.substring(str.indexOf("Top") + "Top".length());
            if (substring2.startsWith("7")) {
                clothes_category_type = CLOTHES_CATEGORY_TYPE.TuckIn;
            } else if (!substring2.startsWith("011") && !substring2.startsWith("111")) {
                return clothes_category_type2;
            } else {
                clothes_category_type = CLOTHES_CATEGORY_TYPE.LongTop;
            }
            return clothes_category_type;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean CopyFile(java.lang.String r6, java.lang.String r7) throws java.io.IOException {
        /*
            r0 = 0
            if (r6 != 0) goto L_0x000b
            java.lang.String r6 = "GlobalDefine"
            java.lang.String r7 = "CopyFile, sourcePath is null"
            android.util.Log.e(r6, r7)
            return r0
        L_0x000b:
            java.io.File r1 = new java.io.File
            r1.<init>(r7)
            java.io.File r7 = new java.io.File
            r7.<init>(r6)
            boolean r6 = r1.exists()
            if (r6 == 0) goto L_0x001e
            r1.delete()
        L_0x001e:
            r6 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x0047 }
            r2.<init>(r7)     // Catch:{ all -> 0x0047 }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ all -> 0x0045 }
            r7.<init>(r1)     // Catch:{ all -> 0x0045 }
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r6]     // Catch:{ all -> 0x0040 }
        L_0x002d:
            int r3 = r2.read(r1, r0, r6)     // Catch:{ all -> 0x0040 }
            r4 = -1
            if (r3 == r4) goto L_0x0038
            r7.write(r1, r0, r3)     // Catch:{ all -> 0x0040 }
            goto L_0x002d
        L_0x0038:
            r2.close()
            r7.close()
            r6 = 1
            return r6
        L_0x0040:
            r6 = move-exception
            r5 = r7
            r7 = r6
            r6 = r5
            goto L_0x0049
        L_0x0045:
            r7 = move-exception
            goto L_0x0049
        L_0x0047:
            r7 = move-exception
            r2 = r6
        L_0x0049:
            if (r2 == 0) goto L_0x004e
            r2.close()
        L_0x004e:
            if (r6 == 0) goto L_0x0053
            r6.close()
        L_0x0053:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.GlobalDefine.CopyFile(java.lang.String, java.lang.String):boolean");
    }

    public static boolean DeleteDirectoryRecursive(String str) {
        Log.i(TAG, "DeleteDirectoryRecursive, path : " + str);
        File file = new File(str);
        if (!file.exists()) {
            Log.e(TAG, "Not found directiry.");
            return false;
        } else if (file.isDirectory()) {
            String[] list = file.list();
            for (int i = 0; i < list.length; i++) {
                String str2 = str + "/" + list[i];
                File file2 = new File(str2);
                if (file2.isDirectory()) {
                    DeleteDirectoryRecursive(str2);
                } else {
                    file2.delete();
                    Log.i(TAG, file2.getName() + " file is delete.");
                }
            }
            file.delete();
            Log.i(TAG, file.getName() + " directory is delete.");
            return true;
        } else {
            Log.e(TAG, "path isn't directory, path :" + str);
            return false;
        }
    }

    public static boolean CopyDirectory(Context context, String str, String str2) {
        File file = new File(str2);
        if (file.exists()) {
            DeleteDirectoryRecursive(str2);
        }
        file.mkdirs();
        String[] list = new File(str).list();
        if (list == null || list.length <= 0) {
            return true;
        }
        int length = list.length;
        int i = 0;
        while (i < length) {
            String name = new File(list[i]).getName();
            try {
                CopyFile(str + File.separator + name, str2 + File.separator + name);
                i++;
            } catch (IOException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public static boolean CopyCustomFaceFiles(Context context, String str, String str2) {
        Log.i(TAG, "CopyCustomFaceFiles()+");
        boolean z = false;
        if (str == null || str2 == null) {
            Log.e(TAG, "[ERROR] :: sourceDirectoryPath or destDirectoryPath is null");
            return false;
        }
        File file = null;
        File file2 = new File(str);
        if (file2.exists() && file2.isDirectory()) {
            String[] GetCustomFaceFile = FittingFaceData.GetCustomFaceFile(file2.getAbsolutePath());
            if (GetCustomFaceFile != null && GetCustomFaceFile.length > 0) {
                file = new File(str2);
                if (file.exists()) {
                    DeleteDirectoryRecursive(str2);
                }
                file.mkdirs();
                int i = 0;
                while (true) {
                    if (i >= GetCustomFaceFile.length) {
                        z = true;
                        break;
                    }
                    String str3 = GetCustomFaceFile[i];
                    if (str3 == null) {
                        if (i != 2) {
                            Log.e(TAG, "[ERROR] :: filePath is null, FittingFaceData index: " + i);
                            break;
                        }
                    } else {
                        File file3 = new File(str3);
                        if (!file3.exists()) {
                            Log.e(TAG, "[ERROR] :: customFaceFile doesn't exist.");
                            break;
                        }
                        try {
                            String name = file3.getName();
                            if (!CopyFile(str + File.separator + name, str2 + File.separator + name)) {
                                Log.e(TAG, "[ERROR] :: fail to copy custom face file");
                                break;
                            }
                        } catch (IOException e2) {
                            Log.e(TAG, "[ERROR] :: IOException, fail to copy custom face file");
                            e2.printStackTrace();
                        }
                    }
                    i++;
                }
            } else {
                Log.e(TAG, "[ERROR] :: source directory doesn't have custom face file.");
            }
        } else {
            Log.e(TAG, "[ERROR] :: source directory doesn't exist.");
        }
        if (!z && file != null && file.exists()) {
            DeleteDirectoryRecursive(str2);
        }
        return z;
    }

    public static File GetClothTypeBaseDirectory(Context context, int i, int i2, int i3) {
        return new File(GetClothTypeDirectory(context, i, i2, i3), DIRECTORY_NAME_BASE);
    }

    public static File GetCharacterDataDirectory(Context context) {
        return new File(GetRootDirectory(context), "CharacterData");
    }

    public static File GetAvatarDataDirectory(Context context) {
        return new File(GetRootDirectory(context), DIRECTORY_NAME_AVATAR_DATA);
    }

    public static File GetAvatarDataDirectory(Context context, int i, int i2, String str) {
        String str2;
        File file = new File(GetRootDirectory(context), DIRECTORY_NAME_AVATAR_DATA);
        if (i == 2) {
            if (i2 == 1) {
                str2 = DIRECTORY_NAME_BOY;
            } else if (i2 == 2) {
                str2 = "Man";
            } else {
                Log.e(TAG, "GetAvatarDataDirectory(), gender is MAN, undefined age, age = " + i2);
                str2 = "Man";
            }
        } else if (i != 1) {
            Log.e(TAG, "GetAvatarDataDirectory(), gender is undefined, gender = " + i + ", age = " + i2);
            str2 = DIRECTORY_NAME_WOMAN;
        } else if (i2 == 1) {
            str2 = DIRECTORY_NAME_GIRL;
        } else if (i2 == 2) {
            str2 = DIRECTORY_NAME_WOMAN;
        } else {
            Log.e(TAG, "GetAvatarDataDirectory(), gender is WOMAN, undefined age, age = " + i2);
            str2 = DIRECTORY_NAME_WOMAN;
        }
        return new File(file.getAbsolutePath() + File.separator + str2 + File.separator + str);
    }

    public static File GetAvatarRuntimeDirectory(Context context) {
        return new File(GetRootDirectory(context).getAbsolutePath() + File.separator + DIRECTORY_NAME_AVATAR_DATA + File.separator + DIRECTORY_NAME_RUNTIME);
    }

    public static String GetCharacterDataFileName(int i, int i2) {
        String str;
        String str2;
        if (i == 1) {
            str = GENDER_WOMAN_STRING;
        } else if (i == 2) {
            str = GENDER_MAN_STRING;
        } else {
            Log.e(TAG, "GetCharacterDataFileName(), gender is undefined, gender = " + i);
            str = GENDER_WOMAN_STRING;
        }
        if (i2 == 1) {
            str2 = AGE_EARLY_STRING;
        } else if (i2 == 2) {
            str2 = AGE_MIDDLE_STRING;
        } else {
            Log.e(TAG, "GetCharacterDataFileName(), age is undefined, age = " + i2);
            str2 = AGE_MIDDLE_STRING;
        }
        return String.format(FILE_NAME_FORMAT_CHARACTER_DATA, new Object[]{str, str2});
    }

    public static File GetBoneAnimationFile(Context context, int i, int i2, int i3) {
        String str;
        String str2;
        if (i == 2) {
            if (i2 == 1) {
                str = DIRECTORY_NAME_BOY;
            } else if (i2 == 2) {
                str = "Man";
            } else {
                Log.e(TAG, "GetBoneAnimationFile(), gender is MAN, undefined age, age = " + i2);
                str = "Man";
            }
        } else if (i != 1) {
            Log.e(TAG, "GetBoneAnimationFile(), gender is undefined, gender = " + i + ", age = " + i2);
            str = DIRECTORY_NAME_WOMAN;
        } else if (i2 == 1) {
            str = DIRECTORY_NAME_GIRL;
        } else if (i2 == 2) {
            str = DIRECTORY_NAME_WOMAN;
        } else {
            Log.e(TAG, "GetBoneAnimationFile(), gender is WOMAN, undefined age, age = " + i2);
            str = DIRECTORY_NAME_WOMAN;
        }
        File file = new File(GetAnimationDirectory(context), str);
        if (!file.exists() || !file.isDirectory()) {
            Log.e(TAG, "[WARNING] Not found directory : " + file.getName());
        } else {
            switch (i3) {
                case 0:
                    str2 = FILE_NAME_ANIMATION_DEFAULT;
                    break;
                case 1:
                    str2 = String.format(FORMAT_PATH_DEPTH_1, new Object[]{DIRECTORY_NAME_SPECIAL_ANIMATIONS, FILE_NAME_ANIMATION_WEDDING});
                    break;
                default:
                    str2 = null;
                    break;
            }
            if (str2 != null) {
                return new File(file, str2);
            }
            Log.e(TAG, "[WARNING] Unknown aniamtion type : " + i3);
        }
        return null;
    }

    public static ArrayList<String> GetBodyTextureFileNames(Context context, int i, int i2) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 <= 3; i3++) {
            String GetBodyTextureFileName = GetBodyTextureFileName(context, i, i2, i3);
            if (!arrayList.contains(GetBodyTextureFileName)) {
                arrayList.add(GetBodyTextureFileName);
            }
        }
        return arrayList;
    }

    public static boolean NeedDefaultRealData(Context context) {
        if (context != null) {
            return context.getSharedPreferences("fitnshop_sdk", 0).getBoolean("default_real_data", true);
        }
        return false;
    }

    public static void SetDefaultRealData(Context context, boolean z) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("fitnshop_sdk", 0).edit();
            edit.putBoolean("default_real_data", z);
            edit.commit();
        }
    }

    public static boolean NeedMigrationUnityData(Context context) {
        if (context != null) {
            return context.getSharedPreferences("fitnshop_sdk", 0).getBoolean("migration_unity_data", true);
        }
        return false;
    }

    public static void SetMigrationUnityData(Context context, boolean z) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences("fitnshop_sdk", 0).edit();
            edit.putBoolean("migration_unity_data", z);
            edit.commit();
        }
    }

    public static int GetChangeDefaultRealVideoState(Context context) {
        if (context != null) {
            return context.getSharedPreferences("fitnshop_sdk", 0).getInt("change_default_real_video", 0);
        }
        return 0;
    }

    public static void SetChangeDefaultRealVideoState(Context context, int i) {
        if (context != null && i >= 0 && i <= 2) {
            SharedPreferences.Editor edit = context.getSharedPreferences("fitnshop_sdk", 0).edit();
            edit.putInt("change_default_real_video", i);
            edit.commit();
        }
    }

    public static void SetServerInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        f654b = str;
        d = str2;
        e = str3;
        c = str4;
        f = str5;
        g = str6;
        h = str7;
    }

    public static String GetFittingDataFileURL() {
        switch (0) {
            case 1:
                return "https://dl.dropboxusercontent.com/s/0xysqe9t1tzb6dd/DATA_V2.zip";
            case 2:
                return "https://dl.dropboxusercontent.com/s/0xysqe9t1tzb6dd/DATA_V2.zip";
            case 3:
                return "https://dl.dropboxusercontent.com/s/hqx30wt6w1dg6pq/DATA_V2.zip";
            default:
                return GetFittingDataRootURL() + FITTING_DATA_FILE_NAME;
        }
    }

    public static String GetLegacyApiUrl() {
        return f;
    }

    public static String GetLegacyMirrorQRUrl() {
        return g;
    }

    public static String GetLegacyMirrorDataUrl() {
        return h;
    }

    public static String GetApiURL() {
        return f654b;
    }

    public static String GetDataServerUrl() {
        return c;
    }

    public static String GetDataURL() {
        return c + UNITY_CLOTH_DATA_DIRECTORY_NAME;
    }

    public static String GetFittingDataRootURL() {
        return c + URL_FITTING_DATA_FOLDER;
    }

    public static String GetAccountUUID() {
        return d;
    }

    public static String GetDeviceUUID() {
        return e;
    }

    public static float GetPixelFromDP(Context context, float f2) {
        return TypedValue.applyDimension(1, f2, context.getResources().getDisplayMetrics());
    }
}
