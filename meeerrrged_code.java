

// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\customface\a.java ==========

package net.fxgear.customface;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.Matrix;
import java.lang.reflect.Array;
import net.fxgear.GlobalDefine;
import net.fxgear.customface.b;
import net.fxgear.fittingview.data.FittingFaceData;

/* compiled from: CustomFaceResourceManager */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f720a = "a";

    /* renamed from: b  reason: collision with root package name */
    private double[] f721b = {0.0d, 0.0d, 0.0d};
    private final int c = 3;
    private int d = 3;
    private final int e = 5;
    private final int f = 4;
    private float[] g = new float[16];
    private b.C0024b h;
    private int[] i;
    private int[] j;
    private float[][][] k = ((float[][][]) Array.newInstance(float[].class, new int[]{3, 5}));
    private b.a[] l = new b.a[4];
    private Bitmap m;
    private Bitmap n;
    private Bitmap o;
    private Bitmap p;
    private FittingFaceData q;

    public int e() {
        return 21;
    }

    public int f() {
        return 5;
    }

    public int g() {
        return 4;
    }

    public a(Context context, FittingFaceData fittingFaceData) {
        FittingFaceData fittingFaceData2 = fittingFaceData;
        this.q = fittingFaceData2;
        float[] fArr = new float[16];
        float[] fArr2 = new float[16];
        float[] fArr3 = {GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 155.0f, 150.0f};
        if (fittingFaceData.GetModelGender() == 3 || fittingFaceData.GetModelGender() == 2) {
            fArr3[1] = 93.5f;
        } else {
            fArr3[1] = 155.0f;
        }
        Matrix.perspectiveM(fArr, 0, 10.0f, 1.0f, 0.3f, 1000.0f);
        Matrix.setLookAtM(fArr2, 0, fArr3[0], fArr3[1], fArr3[2], GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, fArr3[1], GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        Matrix.multiplyMM(this.g, 0, fArr, 0, fArr2, 0);
        a(fittingFaceData2);
    }

    public void a(FittingFaceData fittingFaceData) {
        b();
        this.f721b[0] = 0.0d;
        this.f721b[1] = 0.0d;
        this.f721b[2] = 0.0d;
        this.h = b.a(fittingFaceData.GetFaceBaseGenderBaseBin());
        this.i = b.b(fittingFaceData.GetFaceBaseGenderBaseBin());
        int length = this.h.e.length / 3;
        this.d = fittingFaceData.GetTotalTypeNum();
        int i2 = 0;
        while (i2 < this.d) {
            int i3 = i2 + 1;
            fittingFaceData.SetFaceType(i3);
            this.k[i2][0] = b.c(fittingFaceData.GetFaceBaseGenderTypePos1());
            this.k[i2][1] = b.c(fittingFaceData.GetFaceBaseGenderTypePos2());
            this.k[i2][2] = b.c(fittingFaceData.GetFaceBaseGenderTypePos3());
            this.k[i2][3] = b.c(fittingFaceData.GetFaceBaseGenderTypePos4());
            this.k[i2][4] = b.c(fittingFaceData.GetFaceBaseGenderTypePos5());
            i2 = i3;
        }
        this.l[0] = b.a(fittingFaceData.GetFaceBaseGenderEyeL(), length);
        this.l[1] = b.a(fittingFaceData.GetFaceBaseGenderEyeR(), length);
        this.l[2] = b.a(fittingFaceData.GetFaceBaseGenderMouth(), length);
        this.l[3] = b.a(fittingFaceData.GetFaceBaseGenderNose(), length);
        if (fittingFaceData.GetModelGender() == 2 || fittingFaceData.GetModelGender() == 3) {
            for (int i4 = 0; i4 < 3; i4++) {
                this.l[0].f723a[i4] = d.l[i4];
            }
            for (int i5 = 0; i5 < 3; i5++) {
                this.l[1].f723a[i5] = d.m[i5];
            }
            for (int i6 = 0; i6 < 3; i6++) {
                this.l[2].f723a[i6] = d.n[i6];
            }
            for (int i7 = 0; i7 < 3; i7++) {
                this.l[3].f723a[i7] = d.o[i7];
            }
            this.j = d.c;
        } else if (fittingFaceData.GetFaceGender() == FittingFaceData.a.MALE) {
            for (int i8 = 0; i8 < 3; i8++) {
                this.l[0].f723a[i8] = d.d[i8];
            }
            for (int i9 = 0; i9 < 3; i9++) {
                this.l[1].f723a[i9] = d.e[i9];
            }
            for (int i10 = 0; i10 < 3; i10++) {
                this.l[2].f723a[i10] = d.f[i10];
            }
            for (int i11 = 0; i11 < 3; i11++) {
                this.l[3].f723a[i11] = d.g[i11];
            }
            this.j = d.f737a;
        } else {
            for (int i12 = 0; i12 < 3; i12++) {
                this.l[0].f723a[i12] = d.h[i12];
            }
            for (int i13 = 0; i13 < 3; i13++) {
                this.l[1].f723a[i13] = d.i[i13];
            }
            for (int i14 = 0; i14 < 3; i14++) {
                this.l[2].f723a[i14] = d.j[i14];
            }
            for (int i15 = 0; i15 < 3; i15++) {
                this.l[3].f723a[i15] = d.k[i15];
            }
            this.j = d.f738b;
        }
        for (int i16 = 0; i16 < this.h.e.length / 3; i16++) {
            float[] fArr = this.h.e;
            int i17 = (i16 * 3) + 0;
            fArr[i17] = fArr[i17] * -1.0f;
        }
        for (int i18 = 0; i18 < this.d; i18++) {
            for (int i19 = 0; i19 < 5; i19++) {
                for (int i20 = 0; i20 < this.h.e.length / 3; i20++) {
                    float[] fArr2 = this.k[i18][i19];
                    int i21 = (i20 * 3) + 0;
                    fArr2[i21] = fArr2[i21] * -1.0f;
                }
            }
        }
        for (int i22 = 0; i22 < length; i22++) {
            double[] dArr = this.f721b;
            double d2 = dArr[0];
            int i23 = i22 * 3;
            double d3 = (double) this.h.e[i23 + 0];
            Double.isNaN(d3);
            dArr[0] = d2 + d3;
            double[] dArr2 = this.f721b;
            double d4 = dArr2[1];
            double d5 = (double) this.h.e[i23 + 1];
            Double.isNaN(d5);
            dArr2[1] = d4 + d5;
            double[] dArr3 = this.f721b;
            double d6 = dArr3[2];
            double d7 = (double) this.h.e[i23 + 2];
            Double.isNaN(d7);
            dArr3[2] = d6 + d7;
        }
        for (int i24 = 0; i24 < 3; i24++) {
            double[] dArr4 = this.f721b;
            double d8 = dArr4[i24];
            double d9 = (double) length;
            Double.isNaN(d9);
            dArr4[i24] = d8 / d9;
        }
        this.p = BitmapFactory.decodeFile(fittingFaceData.GetFaceBase_BaseFaceJpg());
        this.m = BitmapFactory.decodeFile(fittingFaceData.GetFaceBase_FaceMaskPng());
        this.n = BitmapFactory.decodeFile(fittingFaceData.GetFaceBase_JawMaskPng());
        this.o = BitmapFactory.decodeFile(fittingFaceData.GetFaceBase_SharpMaskPng());
    }

    public String a() {
        return this.q.GetCustomFaceTextureTypeFile();
    }

    public void b() {
        if (this.h != null) {
            this.h.f725a = null;
            this.h.f726b = null;
            this.h.c = null;
            this.h.d = null;
            this.h.e = null;
            this.h = null;
        }
        this.i = null;
        this.j = null;
        for (int i2 = 0; i2 < 3; i2++) {
            for (int i3 = 0; i3 < 5; i3++) {
                this.k[i2][i3] = null;
            }
        }
        for (int i4 = 0; i4 < 4; i4++) {
            this.l[i4] = null;
        }
        if (this.p != null && !this.p.isRecycled()) {
            this.p.recycle();
            this.p = null;
        }
        if (this.m != null && !this.m.isRecycled()) {
            this.m.recycle();
            this.m = null;
        }
        if (this.n != null && !this.n.isRecycled()) {
            this.n.recycle();
            this.n = null;
        }
        if (this.o != null && !this.o.isRecycled()) {
            this.o.recycle();
            this.o = null;
        }
    }

    public double[] c() {
        return this.f721b;
    }

    public int d() {
        return this.h.e.length / 3;
    }

    public float[] h() {
        return this.g;
    }

    public b.C0024b i() {
        return this.h;
    }

    public int[] j() {
        return this.j;
    }

    public int[] k() {
        return this.i;
    }

    public float[] l() {
        return this.h.e;
    }

    public float[] a(int i2, int i3) {
        return this.k[i2][i3];
    }

    public b.a a(int i2) {
        return this.l[i2];
    }

    public Bitmap m() {
        return this.p;
    }

    public Bitmap n() {
        return this.m;
    }

    public Bitmap o() {
        return this.n;
    }

    public Bitmap p() {
        return this.o;
    }

    public int q() {
        return this.d;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\customface\b.java ==========

package net.fxgear.customface;

import android.util.Log;
import java.io.FileInputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* compiled from: FaceImport */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f722a = "b";

    /* renamed from: net.fxgear.customface.b$b  reason: collision with other inner class name */
    /* compiled from: FaceImport */
    public static class C0024b {

        /* renamed from: a  reason: collision with root package name */
        public float[] f725a;

        /* renamed from: b  reason: collision with root package name */
        public float[] f726b;
        public float[] c;
        public short[] d;
        public float[] e;
    }

    /* compiled from: FaceImport */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public float[] f723a;

        /* renamed from: b  reason: collision with root package name */
        public float[] f724b;

        public a(float[] fArr, float[] fArr2) {
            this.f723a = fArr;
            this.f724b = fArr2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:67:0x01f7 A[SYNTHETIC, Splitter:B:67:0x01f7] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.fxgear.customface.b.C0024b a(java.lang.String r15) {
        /*
            java.lang.String r0 = f722a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "[c] ReadMeshByte()+ "
            r1.append(r2)
            r1.append(r15)
            java.lang.String r1 = r1.toString()
            android.util.Log.i(r0, r1)
            net.fxgear.customface.b$b r0 = new net.fxgear.customface.b$b
            r0.<init>()
            r1 = 0
            java.io.DataInputStream r2 = new java.io.DataInputStream     // Catch:{ Exception -> 0x01f0 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x01f0 }
            r3.<init>(r15)     // Catch:{ Exception -> 0x01f0 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x01f0 }
            r15 = 4
            byte[] r1 = new byte[r15]     // Catch:{ Exception -> 0x01ee }
            r2.read(r1)     // Catch:{ Exception -> 0x01ee }
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.wrap(r1)     // Catch:{ Exception -> 0x01ee }
            java.nio.ByteOrder r4 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ Exception -> 0x01ee }
            java.nio.ByteBuffer r3 = r3.order(r4)     // Catch:{ Exception -> 0x01ee }
            int r3 = r3.getInt()     // Catch:{ Exception -> 0x01ee }
            r4 = r3 & 1
            r5 = 0
            r6 = 1
            if (r4 == 0) goto L_0x0042
            r4 = 1
            goto L_0x0043
        L_0x0042:
            r4 = 0
        L_0x0043:
            r7 = r3 & 2
            if (r7 == 0) goto L_0x0049
            r7 = 1
            goto L_0x004a
        L_0x0049:
            r7 = 0
        L_0x004a:
            r8 = r3 & 4
            if (r8 == 0) goto L_0x0050
            r8 = 1
            goto L_0x0051
        L_0x0050:
            r8 = 0
        L_0x0051:
            r9 = r3 & 8
            if (r9 == 0) goto L_0x0057
            r9 = 1
            goto L_0x0058
        L_0x0057:
            r9 = 0
        L_0x0058:
            r10 = r3 & 16
            if (r10 == 0) goto L_0x005e
            r10 = 1
            goto L_0x005f
        L_0x005e:
            r10 = 0
        L_0x005f:
            r11 = r3 & 32
            if (r11 == 0) goto L_0x0065
            r11 = 1
            goto L_0x0066
        L_0x0065:
            r11 = 0
        L_0x0066:
            r3 = r3 & 64
            if (r3 == 0) goto L_0x006b
            goto L_0x006c
        L_0x006b:
            r6 = 0
        L_0x006c:
            if (r4 == 0) goto L_0x00a8
            r2.read(r1)     // Catch:{ Exception -> 0x01ee }
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.wrap(r1)     // Catch:{ Exception -> 0x01ee }
            java.nio.ByteOrder r3 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ Exception -> 0x01ee }
            java.nio.ByteBuffer r1 = r1.order(r3)     // Catch:{ Exception -> 0x01ee }
            int r1 = r1.getInt()     // Catch:{ Exception -> 0x01ee }
            int r3 = r1 * 12
            byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x01ee }
            r2.read(r3)     // Catch:{ Exception -> 0x01ee }
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.wrap(r3)     // Catch:{ Exception -> 0x01ee }
            java.nio.ByteOrder r4 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ Exception -> 0x01ee }
            java.nio.ByteBuffer r3 = r3.order(r4)     // Catch:{ Exception -> 0x01ee }
            int r4 = r1 * 3
            float[] r12 = new float[r4]     // Catch:{ Exception -> 0x01ee }
            r0.f725a = r12     // Catch:{ Exception -> 0x01ee }
            java.nio.FloatBuffer r3 = r3.asFloatBuffer()     // Catch:{ Exception -> 0x01ee }
            r12 = 0
        L_0x009b:
            if (r12 >= r4) goto L_0x00a9
            float[] r13 = r0.f725a     // Catch:{ Exception -> 0x01ee }
            float r14 = r3.get(r12)     // Catch:{ Exception -> 0x01ee }
            r13[r12] = r14     // Catch:{ Exception -> 0x01ee }
            int r12 = r12 + 1
            goto L_0x009b
        L_0x00a8:
            r1 = 0
        L_0x00a9:
            if (r7 == 0) goto L_0x00d4
            int r3 = r1 * 12
            byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x01ee }
            r2.read(r3)     // Catch:{ Exception -> 0x01ee }
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.wrap(r3)     // Catch:{ Exception -> 0x01ee }
            java.nio.ByteOrder r4 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ Exception -> 0x01ee }
            java.nio.ByteBuffer r3 = r3.order(r4)     // Catch:{ Exception -> 0x01ee }
            int r4 = r1 * 3
            float[] r7 = new float[r4]     // Catch:{ Exception -> 0x01ee }
            r0.f726b = r7     // Catch:{ Exception -> 0x01ee }
            java.nio.FloatBuffer r3 = r3.asFloatBuffer()     // Catch:{ Exception -> 0x01ee }
            r7 = 0
        L_0x00c7:
            if (r7 >= r4) goto L_0x00d4
            float[] r12 = r0.f726b     // Catch:{ Exception -> 0x01ee }
            float r13 = r3.get(r7)     // Catch:{ Exception -> 0x01ee }
            r12[r7] = r13     // Catch:{ Exception -> 0x01ee }
            int r7 = r7 + 1
            goto L_0x00c7
        L_0x00d4:
            if (r8 == 0) goto L_0x00ff
            int r3 = r1 * 8
            byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x01ee }
            r2.read(r3)     // Catch:{ Exception -> 0x01ee }
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.wrap(r3)     // Catch:{ Exception -> 0x01ee }
            java.nio.ByteOrder r4 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ Exception -> 0x01ee }
            java.nio.ByteBuffer r3 = r3.order(r4)     // Catch:{ Exception -> 0x01ee }
            int r1 = r1 * 2
            float[] r4 = new float[r1]     // Catch:{ Exception -> 0x01ee }
            r0.c = r4     // Catch:{ Exception -> 0x01ee }
            java.nio.FloatBuffer r3 = r3.asFloatBuffer()     // Catch:{ Exception -> 0x01ee }
            r4 = 0
        L_0x00f2:
            if (r4 >= r1) goto L_0x00ff
            float[] r7 = r0.c     // Catch:{ Exception -> 0x01ee }
            float r8 = r3.get(r4)     // Catch:{ Exception -> 0x01ee }
            r7[r4] = r8     // Catch:{ Exception -> 0x01ee }
            int r4 = r4 + 1
            goto L_0x00f2
        L_0x00ff:
            if (r9 == 0) goto L_0x013c
            byte[] r1 = new byte[r15]     // Catch:{ Exception -> 0x01ee }
            r2.read(r1)     // Catch:{ Exception -> 0x01ee }
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.wrap(r1)     // Catch:{ Exception -> 0x01ee }
            java.nio.ByteOrder r3 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ Exception -> 0x01ee }
            java.nio.ByteBuffer r1 = r1.order(r3)     // Catch:{ Exception -> 0x01ee }
            int r1 = r1.getInt()     // Catch:{ Exception -> 0x01ee }
            int r3 = r1 * 4
            byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x01ee }
            r2.read(r3)     // Catch:{ Exception -> 0x01ee }
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.wrap(r3)     // Catch:{ Exception -> 0x01ee }
            java.nio.ByteOrder r4 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ Exception -> 0x01ee }
            java.nio.ByteBuffer r3 = r3.order(r4)     // Catch:{ Exception -> 0x01ee }
            short[] r4 = new short[r1]     // Catch:{ Exception -> 0x01ee }
            r0.d = r4     // Catch:{ Exception -> 0x01ee }
            java.nio.IntBuffer r3 = r3.asIntBuffer()     // Catch:{ Exception -> 0x01ee }
            r4 = 0
        L_0x012e:
            if (r4 >= r1) goto L_0x013c
            short[] r7 = r0.d     // Catch:{ Exception -> 0x01ee }
            int r8 = r3.get(r4)     // Catch:{ Exception -> 0x01ee }
            short r8 = (short) r8     // Catch:{ Exception -> 0x01ee }
            r7[r4] = r8     // Catch:{ Exception -> 0x01ee }
            int r4 = r4 + 1
            goto L_0x012e
        L_0x013c:
            if (r10 == 0) goto L_0x0156
            byte[] r1 = new byte[r15]     // Catch:{ Exception -> 0x01ee }
            r2.read(r1)     // Catch:{ Exception -> 0x01ee }
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.wrap(r1)     // Catch:{ Exception -> 0x01ee }
            java.nio.ByteOrder r3 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ Exception -> 0x01ee }
            java.nio.ByteBuffer r1 = r1.order(r3)     // Catch:{ Exception -> 0x01ee }
            int r1 = r1.getInt()     // Catch:{ Exception -> 0x01ee }
            int r1 = r1 * 4
            r2.skipBytes(r1)     // Catch:{ Exception -> 0x01ee }
        L_0x0156:
            if (r11 == 0) goto L_0x01ad
            java.lang.String r1 = f722a     // Catch:{ Exception -> 0x01ee }
            java.lang.String r3 = "[c] useSkin skipped!"
            android.util.Log.e(r1, r3)     // Catch:{ Exception -> 0x01ee }
            byte[] r1 = new byte[r15]     // Catch:{ Exception -> 0x01ee }
            r2.read(r1)     // Catch:{ Exception -> 0x01ee }
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.wrap(r1)     // Catch:{ Exception -> 0x01ee }
            java.nio.ByteOrder r4 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ Exception -> 0x01ee }
            java.nio.ByteBuffer r3 = r3.order(r4)     // Catch:{ Exception -> 0x01ee }
            int r3 = r3.getInt()     // Catch:{ Exception -> 0x01ee }
            int r4 = r3 * 4
            r2.skipBytes(r4)     // Catch:{ Exception -> 0x01ee }
            r4 = 0
        L_0x0178:
            if (r4 >= r3) goto L_0x0191
            r2.read(r1)     // Catch:{ Exception -> 0x01ee }
            java.nio.ByteBuffer r7 = java.nio.ByteBuffer.wrap(r1)     // Catch:{ Exception -> 0x01ee }
            java.nio.ByteOrder r8 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ Exception -> 0x01ee }
            java.nio.ByteBuffer r7 = r7.order(r8)     // Catch:{ Exception -> 0x01ee }
            int r7 = r7.getInt()     // Catch:{ Exception -> 0x01ee }
            r2.skipBytes(r7)     // Catch:{ Exception -> 0x01ee }
            int r4 = r4 + 1
            goto L_0x0178
        L_0x0191:
            byte[] r1 = new byte[r15]     // Catch:{ Exception -> 0x01ee }
            r2.read(r1)     // Catch:{ Exception -> 0x01ee }
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.wrap(r1)     // Catch:{ Exception -> 0x01ee }
            java.nio.ByteOrder r3 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ Exception -> 0x01ee }
            java.nio.ByteBuffer r1 = r1.order(r3)     // Catch:{ Exception -> 0x01ee }
            int r1 = r1.getInt()     // Catch:{ Exception -> 0x01ee }
            int r1 = r1 * 4
            int r1 = r1 * 2
            int r1 = r1 * 4
            r2.skipBytes(r1)     // Catch:{ Exception -> 0x01ee }
        L_0x01ad:
            if (r6 == 0) goto L_0x01ea
            byte[] r15 = new byte[r15]     // Catch:{ Exception -> 0x01ee }
            r2.read(r15)     // Catch:{ Exception -> 0x01ee }
            java.nio.ByteBuffer r15 = java.nio.ByteBuffer.wrap(r15)     // Catch:{ Exception -> 0x01ee }
            java.nio.ByteOrder r1 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ Exception -> 0x01ee }
            java.nio.ByteBuffer r15 = r15.order(r1)     // Catch:{ Exception -> 0x01ee }
            int r15 = r15.getInt()     // Catch:{ Exception -> 0x01ee }
            int r1 = r15 * 3
            float[] r3 = new float[r1]     // Catch:{ Exception -> 0x01ee }
            r0.e = r3     // Catch:{ Exception -> 0x01ee }
            int r15 = r15 * 12
            byte[] r15 = new byte[r15]     // Catch:{ Exception -> 0x01ee }
            r2.read(r15)     // Catch:{ Exception -> 0x01ee }
            java.nio.ByteBuffer r15 = java.nio.ByteBuffer.wrap(r15)     // Catch:{ Exception -> 0x01ee }
            java.nio.ByteOrder r3 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ Exception -> 0x01ee }
            java.nio.ByteBuffer r15 = r15.order(r3)     // Catch:{ Exception -> 0x01ee }
            java.nio.FloatBuffer r15 = r15.asFloatBuffer()     // Catch:{ Exception -> 0x01ee }
        L_0x01dd:
            if (r5 >= r1) goto L_0x01ea
            float[] r3 = r0.e     // Catch:{ Exception -> 0x01ee }
            float r4 = r15.get(r5)     // Catch:{ Exception -> 0x01ee }
            r3[r5] = r4     // Catch:{ Exception -> 0x01ee }
            int r5 = r5 + 1
            goto L_0x01dd
        L_0x01ea:
            r2.close()     // Catch:{ Exception -> 0x01ee }
            goto L_0x01ff
        L_0x01ee:
            r15 = move-exception
            goto L_0x01f2
        L_0x01f0:
            r15 = move-exception
            r2 = r1
        L_0x01f2:
            r15.printStackTrace()
            if (r2 == 0) goto L_0x01ff
            r2.close()     // Catch:{ IOException -> 0x01fb }
            goto L_0x01ff
        L_0x01fb:
            r15 = move-exception
            r15.printStackTrace()
        L_0x01ff:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.customface.b.a(java.lang.String):net.fxgear.customface.b$b");
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x00d4 A[SYNTHETIC, Splitter:B:52:0x00d4] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int[] b(java.lang.String r10) {
        /*
            r0 = 0
            java.io.DataInputStream r1 = new java.io.DataInputStream     // Catch:{ Exception -> 0x00cd }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00cd }
            r2.<init>(r10)     // Catch:{ Exception -> 0x00cd }
            r1.<init>(r2)     // Catch:{ Exception -> 0x00cd }
            r10 = 4
            byte[] r2 = new byte[r10]     // Catch:{ Exception -> 0x00cb }
            r1.read(r2)     // Catch:{ Exception -> 0x00cb }
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.wrap(r2)     // Catch:{ Exception -> 0x00cb }
            java.nio.ByteOrder r3 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ Exception -> 0x00cb }
            java.nio.ByteBuffer r2 = r2.order(r3)     // Catch:{ Exception -> 0x00cb }
            int r2 = r2.getInt()     // Catch:{ Exception -> 0x00cb }
            r3 = r2 & 1
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x0027
            r3 = 1
            goto L_0x0028
        L_0x0027:
            r3 = 0
        L_0x0028:
            r6 = r2 & 2
            if (r6 == 0) goto L_0x002e
            r6 = 1
            goto L_0x002f
        L_0x002e:
            r6 = 0
        L_0x002f:
            r7 = r2 & 4
            if (r7 == 0) goto L_0x0035
            r7 = 1
            goto L_0x0036
        L_0x0035:
            r7 = 0
        L_0x0036:
            r8 = r2 & 8
            if (r8 == 0) goto L_0x003c
            r8 = 1
            goto L_0x003d
        L_0x003c:
            r8 = 0
        L_0x003d:
            r9 = r2 & 16
            if (r9 == 0) goto L_0x0042
            goto L_0x0043
        L_0x0042:
            r5 = 0
        L_0x0043:
            r9 = r2 & 32
            r2 = r2 & 64
            if (r3 == 0) goto L_0x0062
            byte[] r2 = new byte[r10]     // Catch:{ Exception -> 0x00cb }
            r1.read(r2)     // Catch:{ Exception -> 0x00cb }
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.wrap(r2)     // Catch:{ Exception -> 0x00cb }
            java.nio.ByteOrder r3 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ Exception -> 0x00cb }
            java.nio.ByteBuffer r2 = r2.order(r3)     // Catch:{ Exception -> 0x00cb }
            int r2 = r2.getInt()     // Catch:{ Exception -> 0x00cb }
            int r3 = r2 * 12
            r1.skipBytes(r3)     // Catch:{ Exception -> 0x00cb }
            goto L_0x0063
        L_0x0062:
            r2 = 0
        L_0x0063:
            if (r6 == 0) goto L_0x006a
            int r3 = r2 * 12
            r1.skipBytes(r3)     // Catch:{ Exception -> 0x00cb }
        L_0x006a:
            if (r7 == 0) goto L_0x0071
            int r2 = r2 * 8
            r1.skipBytes(r2)     // Catch:{ Exception -> 0x00cb }
        L_0x0071:
            if (r8 == 0) goto L_0x008b
            byte[] r2 = new byte[r10]     // Catch:{ Exception -> 0x00cb }
            r1.read(r2)     // Catch:{ Exception -> 0x00cb }
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.wrap(r2)     // Catch:{ Exception -> 0x00cb }
            java.nio.ByteOrder r3 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ Exception -> 0x00cb }
            java.nio.ByteBuffer r2 = r2.order(r3)     // Catch:{ Exception -> 0x00cb }
            int r2 = r2.getInt()     // Catch:{ Exception -> 0x00cb }
            int r2 = r2 * 4
            r1.skipBytes(r2)     // Catch:{ Exception -> 0x00cb }
        L_0x008b:
            if (r5 == 0) goto L_0x00c7
            byte[] r10 = new byte[r10]     // Catch:{ Exception -> 0x00cb }
            r1.read(r10)     // Catch:{ Exception -> 0x00cb }
            java.nio.ByteBuffer r10 = java.nio.ByteBuffer.wrap(r10)     // Catch:{ Exception -> 0x00cb }
            java.nio.ByteOrder r2 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ Exception -> 0x00cb }
            java.nio.ByteBuffer r10 = r10.order(r2)     // Catch:{ Exception -> 0x00cb }
            int r10 = r10.getInt()     // Catch:{ Exception -> 0x00cb }
            int r2 = r10 * 4
            byte[] r2 = new byte[r2]     // Catch:{ Exception -> 0x00cb }
            r1.read(r2)     // Catch:{ Exception -> 0x00cb }
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.wrap(r2)     // Catch:{ Exception -> 0x00cb }
            java.nio.ByteOrder r3 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ Exception -> 0x00cb }
            java.nio.ByteBuffer r2 = r2.order(r3)     // Catch:{ Exception -> 0x00cb }
            int[] r3 = new int[r10]     // Catch:{ Exception -> 0x00cb }
            java.nio.IntBuffer r0 = r2.asIntBuffer()     // Catch:{ Exception -> 0x00c4 }
        L_0x00b7:
            if (r4 >= r10) goto L_0x00c2
            int r2 = r0.get(r4)     // Catch:{ Exception -> 0x00c4 }
            r3[r4] = r2     // Catch:{ Exception -> 0x00c4 }
            int r4 = r4 + 1
            goto L_0x00b7
        L_0x00c2:
            r0 = r3
            goto L_0x00c7
        L_0x00c4:
            r10 = move-exception
            r0 = r3
            goto L_0x00cf
        L_0x00c7:
            r1.close()     // Catch:{ Exception -> 0x00cb }
            goto L_0x00dc
        L_0x00cb:
            r10 = move-exception
            goto L_0x00cf
        L_0x00cd:
            r10 = move-exception
            r1 = r0
        L_0x00cf:
            r10.printStackTrace()
            if (r1 == 0) goto L_0x00dc
            r1.close()     // Catch:{ IOException -> 0x00d8 }
            goto L_0x00dc
        L_0x00d8:
            r10 = move-exception
            r10.printStackTrace()
        L_0x00dc:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.customface.b.b(java.lang.String):int[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:67:0x0167 A[SYNTHETIC, Splitter:B:67:0x0167] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static float[] c(java.lang.String r11) {
        /*
            java.lang.String r0 = f722a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "[c] ReadPositionBytes()+ "
            r1.append(r2)
            r1.append(r11)
            java.lang.String r1 = r1.toString()
            android.util.Log.i(r0, r1)
            r0 = 0
            java.io.DataInputStream r1 = new java.io.DataInputStream     // Catch:{ Exception -> 0x0160 }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0160 }
            r2.<init>(r11)     // Catch:{ Exception -> 0x0160 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0160 }
            r11 = 4
            byte[] r2 = new byte[r11]     // Catch:{ Exception -> 0x015e }
            r1.read(r2)     // Catch:{ Exception -> 0x015e }
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.wrap(r2)     // Catch:{ Exception -> 0x015e }
            java.nio.ByteOrder r3 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ Exception -> 0x015e }
            java.nio.ByteBuffer r2 = r2.order(r3)     // Catch:{ Exception -> 0x015e }
            int r2 = r2.getInt()     // Catch:{ Exception -> 0x015e }
            r3 = r2 & 1
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x003d
            r3 = 1
            goto L_0x003e
        L_0x003d:
            r3 = 0
        L_0x003e:
            r6 = r2 & 2
            if (r6 == 0) goto L_0x0044
            r6 = 1
            goto L_0x0045
        L_0x0044:
            r6 = 0
        L_0x0045:
            r7 = r2 & 4
            if (r7 == 0) goto L_0x004b
            r7 = 1
            goto L_0x004c
        L_0x004b:
            r7 = 0
        L_0x004c:
            r8 = r2 & 8
            if (r8 == 0) goto L_0x0052
            r8 = 1
            goto L_0x0053
        L_0x0052:
            r8 = 0
        L_0x0053:
            r9 = r2 & 16
            if (r9 == 0) goto L_0x0059
            r9 = 1
            goto L_0x005a
        L_0x0059:
            r9 = 0
        L_0x005a:
            r10 = r2 & 32
            if (r10 == 0) goto L_0x0060
            r10 = 1
            goto L_0x0061
        L_0x0060:
            r10 = 0
        L_0x0061:
            r2 = r2 & 64
            if (r2 == 0) goto L_0x0066
            goto L_0x0067
        L_0x0066:
            r5 = 0
        L_0x0067:
            if (r3 == 0) goto L_0x0082
            byte[] r2 = new byte[r11]     // Catch:{ Exception -> 0x015e }
            r1.read(r2)     // Catch:{ Exception -> 0x015e }
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.wrap(r2)     // Catch:{ Exception -> 0x015e }
            java.nio.ByteOrder r3 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ Exception -> 0x015e }
            java.nio.ByteBuffer r2 = r2.order(r3)     // Catch:{ Exception -> 0x015e }
            int r2 = r2.getInt()     // Catch:{ Exception -> 0x015e }
            int r3 = r2 * 12
            r1.skipBytes(r3)     // Catch:{ Exception -> 0x015e }
            goto L_0x0083
        L_0x0082:
            r2 = 0
        L_0x0083:
            if (r6 == 0) goto L_0x008a
            int r3 = r2 * 12
            r1.skipBytes(r3)     // Catch:{ Exception -> 0x015e }
        L_0x008a:
            if (r7 == 0) goto L_0x0091
            int r2 = r2 * 8
            r1.skipBytes(r2)     // Catch:{ Exception -> 0x015e }
        L_0x0091:
            if (r8 == 0) goto L_0x00ab
            byte[] r2 = new byte[r11]     // Catch:{ Exception -> 0x015e }
            r1.read(r2)     // Catch:{ Exception -> 0x015e }
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.wrap(r2)     // Catch:{ Exception -> 0x015e }
            java.nio.ByteOrder r3 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ Exception -> 0x015e }
            java.nio.ByteBuffer r2 = r2.order(r3)     // Catch:{ Exception -> 0x015e }
            int r2 = r2.getInt()     // Catch:{ Exception -> 0x015e }
            int r2 = r2 * 4
            r1.skipBytes(r2)     // Catch:{ Exception -> 0x015e }
        L_0x00ab:
            if (r9 == 0) goto L_0x00c5
            byte[] r2 = new byte[r11]     // Catch:{ Exception -> 0x015e }
            r1.read(r2)     // Catch:{ Exception -> 0x015e }
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.wrap(r2)     // Catch:{ Exception -> 0x015e }
            java.nio.ByteOrder r3 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ Exception -> 0x015e }
            java.nio.ByteBuffer r2 = r2.order(r3)     // Catch:{ Exception -> 0x015e }
            int r2 = r2.getInt()     // Catch:{ Exception -> 0x015e }
            int r2 = r2 * 4
            r1.skipBytes(r2)     // Catch:{ Exception -> 0x015e }
        L_0x00c5:
            if (r10 == 0) goto L_0x011c
            java.lang.String r2 = f722a     // Catch:{ Exception -> 0x015e }
            java.lang.String r3 = "[c] useSkin skipped!"
            android.util.Log.e(r2, r3)     // Catch:{ Exception -> 0x015e }
            byte[] r2 = new byte[r11]     // Catch:{ Exception -> 0x015e }
            r1.read(r2)     // Catch:{ Exception -> 0x015e }
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.wrap(r2)     // Catch:{ Exception -> 0x015e }
            java.nio.ByteOrder r6 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ Exception -> 0x015e }
            java.nio.ByteBuffer r3 = r3.order(r6)     // Catch:{ Exception -> 0x015e }
            int r3 = r3.getInt()     // Catch:{ Exception -> 0x015e }
            int r6 = r3 * 4
            r1.skipBytes(r6)     // Catch:{ Exception -> 0x015e }
            r6 = 0
        L_0x00e7:
            if (r6 >= r3) goto L_0x0100
            r1.read(r2)     // Catch:{ Exception -> 0x015e }
            java.nio.ByteBuffer r7 = java.nio.ByteBuffer.wrap(r2)     // Catch:{ Exception -> 0x015e }
            java.nio.ByteOrder r8 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ Exception -> 0x015e }
            java.nio.ByteBuffer r7 = r7.order(r8)     // Catch:{ Exception -> 0x015e }
            int r7 = r7.getInt()     // Catch:{ Exception -> 0x015e }
            r1.skipBytes(r7)     // Catch:{ Exception -> 0x015e }
            int r6 = r6 + 1
            goto L_0x00e7
        L_0x0100:
            byte[] r2 = new byte[r11]     // Catch:{ Exception -> 0x015e }
            r1.read(r2)     // Catch:{ Exception -> 0x015e }
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.wrap(r2)     // Catch:{ Exception -> 0x015e }
            java.nio.ByteOrder r3 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ Exception -> 0x015e }
            java.nio.ByteBuffer r2 = r2.order(r3)     // Catch:{ Exception -> 0x015e }
            int r2 = r2.getInt()     // Catch:{ Exception -> 0x015e }
            int r2 = r2 * 4
            int r2 = r2 * 2
            int r2 = r2 * 4
            r1.skipBytes(r2)     // Catch:{ Exception -> 0x015e }
        L_0x011c:
            if (r5 == 0) goto L_0x015a
            byte[] r11 = new byte[r11]     // Catch:{ Exception -> 0x015e }
            r1.read(r11)     // Catch:{ Exception -> 0x015e }
            java.nio.ByteBuffer r11 = java.nio.ByteBuffer.wrap(r11)     // Catch:{ Exception -> 0x015e }
            java.nio.ByteOrder r2 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ Exception -> 0x015e }
            java.nio.ByteBuffer r11 = r11.order(r2)     // Catch:{ Exception -> 0x015e }
            int r11 = r11.getInt()     // Catch:{ Exception -> 0x015e }
            int r2 = r11 * 3
            float[] r3 = new float[r2]     // Catch:{ Exception -> 0x015e }
            int r11 = r11 * 12
            byte[] r11 = new byte[r11]     // Catch:{ Exception -> 0x0157 }
            r1.read(r11)     // Catch:{ Exception -> 0x0157 }
            java.nio.ByteBuffer r11 = java.nio.ByteBuffer.wrap(r11)     // Catch:{ Exception -> 0x0157 }
            java.nio.ByteOrder r0 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ Exception -> 0x0157 }
            java.nio.ByteBuffer r11 = r11.order(r0)     // Catch:{ Exception -> 0x0157 }
            java.nio.FloatBuffer r11 = r11.asFloatBuffer()     // Catch:{ Exception -> 0x0157 }
        L_0x014a:
            if (r4 >= r2) goto L_0x0155
            float r0 = r11.get(r4)     // Catch:{ Exception -> 0x0157 }
            r3[r4] = r0     // Catch:{ Exception -> 0x0157 }
            int r4 = r4 + 1
            goto L_0x014a
        L_0x0155:
            r0 = r3
            goto L_0x015a
        L_0x0157:
            r11 = move-exception
            r0 = r3
            goto L_0x0162
        L_0x015a:
            r1.close()     // Catch:{ Exception -> 0x015e }
            goto L_0x016f
        L_0x015e:
            r11 = move-exception
            goto L_0x0162
        L_0x0160:
            r11 = move-exception
            r1 = r0
        L_0x0162:
            r11.printStackTrace()
            if (r1 == 0) goto L_0x016f
            r1.close()     // Catch:{ IOException -> 0x016b }
            goto L_0x016f
        L_0x016b:
            r11 = move-exception
            r11.printStackTrace()
        L_0x016f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.customface.b.c(java.lang.String):float[]");
    }

    public static a a(String str, int i) {
        float[] fArr;
        float[] fArr2;
        Log.i(f722a, "[c] ReadClusterDataBytes()+ " + str + ", " + i);
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            newInstance.setNamespaceAware(true);
            XmlPullParser newPullParser = newInstance.newPullParser();
            newPullParser.setInput(fileInputStream, "UTF-8");
            fArr = new float[i];
            int i2 = 0;
            while (i2 < fArr.length) {
                try {
                    fArr[i2] = 0.0f;
                    i2++;
                } catch (Exception e) {
                    e = e;
                    fArr2 = null;
                    e.printStackTrace();
                    return new a(fArr2, fArr);
                }
            }
            float[] fArr3 = null;
            float[] fArr4 = null;
            float[] fArr5 = null;
            boolean z = false;
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                switch (eventType) {
                    case 2:
                        String name = newPullParser.getName();
                        if (!name.equals("shape")) {
                            if (!name.equals("weights")) {
                                if (name.equals("point")) {
                                    if (!z) {
                                        String attributeValue = newPullParser.getAttributeValue(0);
                                        String attributeValue2 = newPullParser.getAttributeValue(1);
                                        int intValue = Integer.valueOf(attributeValue.trim()).intValue();
                                        String[] split = attributeValue2.trim().split("[ ]");
                                        fArr3[intValue] = Float.valueOf(split[0]).floatValue();
                                        fArr4[intValue] = Float.valueOf(split[1]).floatValue();
                                        fArr5[intValue] = Float.valueOf(split[2]).floatValue();
                                        break;
                                    } else {
                                        fArr[Integer.valueOf(newPullParser.getAttributeValue(0).trim()).intValue()] = Float.valueOf(newPullParser.getAttributeValue(1).trim()).floatValue();
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            } else {
                                int intValue2 = Integer.valueOf(newPullParser.getAttributeValue((String) null, "max")).intValue();
                                z = true;
                                break;
                            }
                        } else {
                            int intValue3 = Integer.valueOf(newPullParser.getAttributeValue((String) null, "size")).intValue();
                            if (intValue3 <= 0) {
                                break;
                            } else {
                                fArr3 = new float[intValue3];
                                fArr4 = new float[intValue3];
                                fArr5 = new float[intValue3];
                                break;
                            }
                        }
                    case 3:
                    case 4:
                        break;
                }
            }
            float b2 = b(fArr3);
            float b3 = b(fArr4);
            float b4 = b(fArr5);
            float a2 = a(fArr3);
            float a3 = a(fArr4);
            float a4 = a(fArr5);
            fArr2 = new float[3];
            try {
                fArr2[0] = (b2 + a2) / 2.0f;
                fArr2[1] = (b3 + a3) / 2.0f;
                fArr2[2] = (b4 + a4) / 2.0f;
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            fArr = null;
            fArr2 = null;
            e.printStackTrace();
            return new a(fArr2, fArr);
        }
        return new a(fArr2, fArr);
    }

    private static float a(float[] fArr) {
        float f = fArr[0];
        for (int i = 0; i < fArr.length; i++) {
            if (fArr[i] > f) {
                f = fArr[i];
            }
        }
        return f;
    }

    private static float b(float[] fArr) {
        float f = fArr[0];
        for (int i = 0; i < fArr.length; i++) {
            if (fArr[i] < f) {
                f = fArr[i];
            }
        }
        return f;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\customface\BitmapUtil.java ==========

package net.fxgear.customface;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.Log;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class BitmapUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final String f713a = "BitmapUtil";

    private static boolean a(int i) {
        return i % 4 > 0;
    }

    public static int GetBitmapFileSize(Bitmap bitmap) {
        boolean z;
        int i = 0;
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            byte[] bArr = null;
            int i2 = width * 3;
            if (a(i2)) {
                bArr = new byte[(4 - (i2 % 4))];
                for (int i3 = 0; i3 < bArr.length; i3++) {
                    bArr[i3] = -1;
                }
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i = bArr.length;
            }
            return ((i2 + i) * height) + 54;
        }
        Log.e(f713a, "bitmap is null");
        return 0;
    }

    public static Bitmap GetRotatedBitmap(Bitmap bitmap, int i) {
        if (i == 0) {
            Log.e(f713a, "degrees is 0, return the original bitmap");
            return bitmap;
        } else if (bitmap != null) {
            Matrix matrix = new Matrix();
            matrix.setRotate((float) i, ((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
            try {
                Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                if (bitmap == createBitmap) {
                    return bitmap;
                }
                bitmap.recycle();
                return createBitmap;
            } catch (OutOfMemoryError unused) {
                Log.e(f713a, "[ERROR] :: GetRotatedBitmap(), Out of memory to rotate, return the original bitmap");
                return bitmap;
            }
        } else {
            Log.e(f713a, "bitmap is null");
            return bitmap;
        }
    }

    public static boolean save(Bitmap bitmap, String str) {
        byte[] bArr;
        boolean z;
        String str2 = str;
        if (bitmap == null || str2 == null) {
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = width * 3;
        if (a(i)) {
            byte[] bArr2 = new byte[(4 - (i % 4))];
            for (int i2 = 0; i2 < bArr2.length; i2++) {
                bArr2[i2] = -1;
            }
            bArr = bArr2;
            z = true;
        } else {
            bArr = null;
            z = false;
        }
        int i3 = width * height;
        int[] iArr = new int[i3];
        int length = (i + (z ? bArr.length : 0)) * height;
        int i4 = length + 54;
        int[] iArr2 = iArr;
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        ByteBuffer allocate = ByteBuffer.allocate(i4);
        try {
            allocate.put((byte) 66);
            allocate.put((byte) 77);
            allocate.put(b(i4));
            allocate.put(a(0));
            allocate.put(a(0));
            allocate.put(b(54));
            allocate.put(b(40));
            allocate.put(b(((!z || bArr.length != 3) ? 0 : 1) + width));
            allocate.put(b(height));
            allocate.put(a(1));
            allocate.put(a(24));
            allocate.put(b(0));
            allocate.put(b(length));
            allocate.put(b(0));
            allocate.put(b(0));
            allocate.put(b(0));
            allocate.put(b(0));
            int i5 = (height - 1) * width;
            while (true) {
                int i6 = i3;
                i3 = i5;
                int i7 = i6;
                if (height > 0) {
                    for (int i8 = i3; i8 < i7; i8++) {
                        allocate.put((byte) (iArr2[i8] & 255));
                        allocate.put((byte) ((iArr2[i8] & 65280) >> 8));
                        allocate.put((byte) ((iArr2[i8] & 16711680) >> 16));
                    }
                    if (z) {
                        allocate.put(bArr);
                    }
                    height--;
                    i5 = i3 - width;
                } else {
                    FileOutputStream fileOutputStream = new FileOutputStream(str2);
                    fileOutputStream.write(allocate.array());
                    fileOutputStream.close();
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static byte[] b(int i) throws IOException {
        return new byte[]{(byte) (i & 255), (byte) ((65280 & i) >> 8), (byte) ((16711680 & i) >> 16), (byte) ((i & -16777216) >> 24)};
    }

    private static byte[] a(short s) throws IOException {
        return new byte[]{(byte) (s & 255), (byte) ((s & 65280) >> 8)};
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\customface\c.java ==========

package net.fxgear.customface;

import android.util.Log;
import java.lang.reflect.Array;
import net.fxgear.GlobalDefine;
import net.fxgear.fittingview.data.FittingFaceData;

/* compiled from: FaceMeshGenerator */
public class c {
    private static final String c = "c";
    private double[] A;
    private float[] B;
    private float[] C;
    private double[] D;
    private double[] E;
    private double[] F;
    private double[] G;
    private double[] H;
    private double[] I;
    private float[] J;
    private float[] K;
    private float[] L;
    private int M;
    private int N;
    private b O;
    private d P;
    private a Q;
    private a R;
    private f S;
    private double[] T = {0.0d, 0.0d, 0.0d};
    private double[] U = new double[3];
    private double[] V = {0.0d, 0.0d, 0.0d, 1.0d};
    private double W;
    private double X;
    private double Y;
    private double Z;

    /* renamed from: a  reason: collision with root package name */
    public double[] f727a;
    private double aa;
    private double ab;
    private double ac;
    private double ad;
    private double ae;
    private double af;
    private double ag;
    private double ah;
    private double ai;
    private double aj;
    private double ak;
    private double al;
    private double am;
    private double an;
    private double ao;
    private double ap;
    private double aq;
    private double ar;
    private double as;
    private double at;
    private double au;
    private double av = 1.0E-9d;
    private double aw;
    private double ax;
    private double ay;

    /* renamed from: b  reason: collision with root package name */
    boolean f728b = true;
    private int d = 5;
    private int e = 10;
    private int f = 10;
    private int[] g = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39};
    private int h = 40;
    private int i = 6;
    private int[] j = {32, 34, 36, 38, 41};
    private int k = 5;
    private int[] l = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};
    private int m = 32;
    private int n = 20;
    private double[] o = {0.0d, 0.0d, 0.0d};
    private double[] p = {0.0d, 0.0d, 0.0d};
    private double[] q = {0.0d, 0.0d, 0.0d};
    private double[] r;
    private int[] s;
    private int t;
    private int u;
    private int v;
    private int w;
    private float[] x;
    private double[] y;
    private double[] z;

    public c(a aVar, f fVar) {
        a(aVar);
        this.S = fVar;
        this.B = new float[(this.t * 3)];
        this.C = new float[(this.t * 3)];
        this.y = new double[(this.t * 3)];
        this.z = new double[(this.t * 3)];
        this.A = new double[(this.t * 3)];
        this.D = new double[(this.u * 2)];
        this.f727a = new double[this.v];
        this.E = new double[this.w];
        this.F = new double[this.w];
        this.G = new double[this.w];
        this.H = new double[this.w];
        this.I = new double[this.w];
        this.O = new b(this.i, this.h);
        this.P = new d(this, this.v, this.k);
        this.Q = new a(this, this.n, this.m);
        this.J = new float[(this.u * 2)];
        this.K = new float[(this.t * 3)];
        this.L = new float[(this.t * 3)];
    }

    public void a(a aVar) {
        String str = c;
        Log.i(str, "[c] loadResource - vertexNum: " + this.t + ", " + aVar.d());
        this.R = aVar;
        this.r = aVar.c();
        this.t = aVar.d();
        this.u = aVar.e();
        this.v = aVar.f();
        this.w = aVar.g();
        this.x = aVar.l();
        this.s = aVar.j();
    }

    public void a() {
        for (int i2 = 0; i2 < 3; i2++) {
            this.o[i2] = 0.0d;
            this.p[i2] = 0.0d;
            this.q[i2] = 0.0d;
        }
        for (int i3 = 0; i3 < this.v; i3++) {
            this.f727a[i3] = 0.0d;
        }
        for (int i4 = 0; i4 < this.w; i4++) {
            this.E[i4] = 0.0d;
            this.F[i4] = 0.0d;
            this.G[i4] = 0.0d;
            this.H[i4] = 1.0d;
            this.I[i4] = 1.0d;
        }
    }

    public boolean a(FittingFaceData.a aVar, int i2) {
        float[] b2 = f.b();
        if (b2 == null) {
            Log.e(c, "[c] ERROR: createCustomMesh featurePositions == null!");
            return false;
        }
        float f2 = 0.6f;
        if (!(i2 == 3 || i2 == 2 || aVar != FittingFaceData.a.MALE)) {
            f2 = 0.8f;
        }
        d.w = f2;
        d.x = (i2 == 3 || i2 == 2) ? 3.0f : GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        a();
        a(b2);
        b(b2);
        c(b2);
        if (d.F == 0) {
            for (int i3 = 0; i3 < this.L.length; i3++) {
                this.L[i3] = (float) this.y[i3];
            }
        }
        if (d.F == 1) {
            for (int i4 = 0; i4 < this.L.length; i4++) {
                this.L[i4] = (float) this.z[i4];
            }
        }
        if (d.F == 2) {
            for (int i5 = 0; i5 < this.L.length; i5++) {
                this.L[i5] = (float) this.A[i5];
            }
        }
        d(this.L);
        return true;
    }

    public float[] a(int i2) {
        float[] fArr = {GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE};
        float[] fArr2 = {GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE};
        for (int i3 = 0; i3 < this.t; i3++) {
            for (int i4 = 0; i4 < 3; i4++) {
                fArr[i4] = this.R.a(0, 0)[(i3 * 3) + i4];
            }
            for (int i5 = 0; i5 < 3; i5++) {
                fArr2[i5] = this.R.a(i2, 0)[(i3 * 3) + i5];
            }
            for (int i6 = 0; i6 < this.v; i6++) {
                for (int i7 = 0; i7 < 3; i7++) {
                    double d2 = (double) fArr[i7];
                    double d3 = this.f727a[i6];
                    int i8 = (i3 * 3) + i7;
                    double d4 = (double) (this.R.a(0, i6)[i8] - this.R.a(0, 0)[i8]);
                    Double.isNaN(d4);
                    Double.isNaN(d2);
                    fArr[i7] = (float) (d2 + (d3 * d4));
                }
            }
            for (int i9 = 0; i9 < this.v; i9++) {
                for (int i10 = 0; i10 < 3; i10++) {
                    double d5 = (double) fArr2[i10];
                    double d6 = this.f727a[i9];
                    int i11 = (i3 * 3) + i10;
                    double d7 = (double) (this.R.a(i2, i9)[i11] - this.R.a(i2, 0)[i11]);
                    Double.isNaN(d7);
                    Double.isNaN(d5);
                    fArr2[i10] = (float) (d5 + (d6 * d7));
                }
            }
            for (int i12 = 0; i12 < 3; i12++) {
                int i13 = (i3 * 3) + i12;
                this.K[i13] = this.L[i13] + (d.w * (fArr2[i12] - fArr[i12]));
            }
        }
        return this.K;
    }

    public float[] b(int i2) {
        for (int i3 = 0; i3 < this.u; i3++) {
            if (i2 == 0) {
                for (int i4 = 0; i4 < 3; i4++) {
                    this.V[i4] = this.y[(this.s[i3] * 3) + i4];
                }
            }
            if (i2 == 1) {
                for (int i5 = 0; i5 < 3; i5++) {
                    this.V[i5] = this.z[(this.s[i3] * 3) + i5];
                }
            }
            if (i2 == 2) {
                for (int i6 = 0; i6 < 3; i6++) {
                    this.V[i6] = this.A[(this.s[i3] * 3) + i6];
                }
            }
            a(this.V);
            for (int i7 = 0; i7 < 2; i7++) {
                this.J[(i3 * 2) + i7] = (float) this.U[i7];
            }
        }
        return this.J;
    }

    public float[] c(int i2) {
        for (int i3 = 0; i3 < this.t; i3++) {
            if (i2 == 0) {
                for (int i4 = 0; i4 < 3; i4++) {
                    this.V[i4] = this.y[(i3 * 3) + i4];
                }
            }
            if (i2 == 1) {
                for (int i5 = 0; i5 < 3; i5++) {
                    this.V[i5] = this.z[(i3 * 3) + i5];
                }
            }
            if (i2 == 2) {
                for (int i6 = 0; i6 < 3; i6++) {
                    this.V[i6] = this.A[(i3 * 3) + i6];
                }
            }
            a(this.V);
            for (int i7 = 0; i7 < 3; i7++) {
                this.K[(i3 * 3) + i7] = (float) this.U[i7];
            }
        }
        return this.K;
    }

    public void a(float[] fArr) {
        this.M = this.i;
        this.N = this.h;
        double[] dArr = new double[this.M];
        double[] dArr2 = new double[this.M];
        double[] dArr3 = new double[this.N];
        double[] dArr4 = new double[this.M];
        double[] dArr5 = new double[this.N];
        dArr[0] = this.o[0];
        dArr[1] = this.o[1];
        dArr[2] = this.o[2];
        dArr[3] = this.p[0];
        dArr[4] = this.p[1];
        dArr[5] = this.p[2];
        for (int i2 = 0; i2 < this.h; i2++) {
            dArr3[i2] = (double) fArr[this.g[i2]];
        }
        int i3 = 0;
        while (i3 < this.d) {
            for (int i4 = 0; i4 < this.M; i4++) {
                double d2 = (double) (i3 + 1);
                Double.isNaN(d2);
                dArr4[i4] = 0.1d / d2;
            }
            for (int i5 = 0; i5 < this.N; i5++) {
                dArr5[i5] = 1.0d;
            }
            int i6 = i3;
            this.O.a(dArr2, dArr, dArr4, dArr3, dArr5);
            for (int i7 = 0; i7 < this.M; i7++) {
                dArr[i7] = dArr2[i7];
            }
            i3 = i6 + 1;
        }
        this.o[0] = dArr[0];
        this.o[1] = dArr[1];
        double[] dArr6 = this.o;
        double d3 = dArr[2];
        double d4 = (double) d.x;
        Double.isNaN(d4);
        dArr6[2] = d3 + d4;
        this.p[0] = dArr[3];
        this.p[1] = dArr[4];
        this.p[2] = dArr[5];
        double[] dArr7 = this.p;
        dArr7[0] = dArr7[0] * 0.0d;
        a(false, this.y, this.x);
    }

    /* access modifiers changed from: private */
    public void a(double[] dArr, double[] dArr2) {
        this.o[0] = dArr[0];
        this.o[1] = dArr[1];
        this.o[2] = dArr[2];
        this.p[0] = dArr[3];
        this.p[1] = dArr[4];
        this.p[2] = dArr[5];
        double[] dArr3 = this.p;
        dArr3[0] = dArr3[0] * 0.0d;
        a(true, this.y, this.x);
        for (int i2 = 0; i2 < this.u; i2++) {
            int i3 = this.s[i2];
            for (int i4 = 0; i4 < 3; i4++) {
                this.V[i4] = this.y[(i3 * 3) + i4];
            }
            a(this.V);
            int i5 = i2 * 2;
            this.D[i5 + 0] = this.U[0];
            this.D[i5 + 1] = this.U[1];
        }
        for (int i6 = 0; i6 < this.h; i6++) {
            dArr2[i6] = this.D[this.g[i6]];
        }
    }

    private void a(boolean z2, double[] dArr, float[] fArr) {
        for (int i2 = 0; i2 < 3; i2++) {
            this.q[i2] = this.r[i2] + this.o[i2];
        }
        int i3 = this.t;
        if (z2) {
            i3 = this.u;
        }
        int i4 = i3;
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = z2 ? this.s[i5] : i5;
            for (int i7 = 0; i7 < 3; i7++) {
                int i8 = (i6 * 3) + i7;
                double d2 = (double) fArr[i8];
                double d3 = this.o[i7];
                Double.isNaN(d2);
                dArr[i8] = d2 + d3;
            }
            int i9 = i6 * 3;
            int i10 = i9 + 0;
            int i11 = i9 + 1;
            int i12 = i9 + 2;
            a(dArr[i10], dArr[i11], dArr[i12], this.p, false);
            dArr[i10] = this.q[0] + this.aw;
            dArr[i11] = this.q[1] + this.ax;
            dArr[i12] = this.q[2] + this.ay;
        }
    }

    public void b(float[] fArr) {
        this.M = this.v;
        this.N = this.k;
        double[] dArr = new double[this.M];
        double[] dArr2 = new double[this.M];
        double[] dArr3 = new double[this.N];
        double[] dArr4 = new double[this.M];
        double[] dArr5 = new double[this.N];
        for (int i2 = 0; i2 < this.v; i2++) {
            dArr[i2] = this.f727a[i2];
        }
        for (int i3 = 0; i3 < this.k; i3++) {
            dArr3[i3] = (double) fArr[this.j[i3]];
        }
        for (int i4 = 0; i4 < this.e; i4++) {
            for (int i5 = 0; i5 < this.M; i5++) {
                double d2 = (double) (i4 + 1);
                Double.isNaN(d2);
                dArr4[i5] = 1.0d / d2;
            }
            for (int i6 = 0; i6 < this.N; i6++) {
                dArr5[i6] = 100.0d;
            }
            this.P.a(dArr2, dArr, dArr4, dArr3, dArr5);
            for (int i7 = 0; i7 < this.M; i7++) {
                if (dArr2[i7] < 0.0d) {
                    dArr[i7] = 0.0d;
                } else {
                    dArr[i7] = dArr2[i7];
                }
            }
        }
        for (int i8 = 0; i8 < this.v; i8++) {
            this.f727a[i8] = dArr[i8];
            if (this.f727a[i8] > 1.0d) {
                this.f727a[i8] = 1.0d;
            }
            if (this.f727a[i8] < 0.0d) {
                this.f727a[i8] = 0.0d;
            }
        }
        a(false);
    }

    public void c(float[] fArr) {
        this.M = this.n;
        this.N = this.m;
        double[] dArr = new double[this.M];
        double[] dArr2 = new double[this.M];
        double[] dArr3 = new double[this.N];
        double[] dArr4 = new double[this.M];
        double[] dArr5 = new double[this.N];
        dArr[0] = this.E[0];
        dArr[1] = this.F[0];
        dArr[2] = this.H[0];
        dArr[3] = this.I[0];
        dArr[4] = this.G[0];
        dArr[5] = this.E[1];
        dArr[6] = this.F[1];
        dArr[7] = this.H[1];
        dArr[8] = this.I[1];
        dArr[9] = this.G[1];
        dArr[10] = this.E[2];
        dArr[11] = this.F[2];
        dArr[12] = this.H[2];
        dArr[13] = this.I[2];
        dArr[14] = this.G[2];
        dArr[15] = this.E[3];
        dArr[16] = this.F[3];
        dArr[17] = this.H[3];
        dArr[18] = this.I[3];
        dArr[19] = this.G[3];
        c(dArr, dArr3);
        if (fArr[21] - fArr[23] > ((float) (dArr3[21] - dArr3[23]))) {
            this.f728b = true;
        } else {
            this.f728b = false;
        }
        for (int i2 = 0; i2 < this.m; i2++) {
            dArr3[i2] = (double) fArr[this.l[i2]];
        }
        for (int i3 = 0; i3 < this.f; i3++) {
            for (int i4 = 0; i4 < this.M; i4++) {
                double d2 = (double) (i3 + 1);
                Double.isNaN(d2);
                dArr4[i4] = 0.1d / d2;
            }
            for (int i5 = 0; i5 < this.N; i5++) {
                dArr5[i5] = 100.0d;
            }
            this.Q.a(dArr2, dArr, dArr4, dArr3, dArr5);
            for (int i6 = 0; i6 < this.M; i6++) {
                dArr[i6] = dArr2[i6];
            }
        }
        this.E[0] = dArr[0];
        this.F[0] = dArr[1];
        this.H[0] = dArr[2];
        this.I[0] = dArr[3];
        this.G[0] = dArr[4];
        this.E[1] = dArr[5];
        this.F[1] = dArr[6];
        this.H[1] = dArr[7];
        this.I[1] = dArr[8];
        this.G[1] = dArr[9];
        this.E[2] = dArr[10];
        this.F[2] = dArr[11];
        this.H[2] = dArr[12];
        this.I[2] = dArr[13];
        this.G[2] = dArr[14];
        this.E[3] = dArr[15];
        this.F[3] = dArr[16];
        this.H[3] = dArr[17];
        this.I[3] = dArr[18];
        this.G[3] = dArr[19];
        b(false);
    }

    /* access modifiers changed from: private */
    public void b(double[] dArr, double[] dArr2) {
        for (int i2 = 0; i2 < this.v; i2++) {
            this.f727a[i2] = dArr[i2];
            if (this.f727a[i2] > 1.0d) {
                this.f727a[i2] = 1.0d;
            }
            if (this.f727a[i2] < 0.0d) {
                this.f727a[i2] = 0.0d;
            }
        }
        a(true);
        for (int i3 = 0; i3 < this.u; i3++) {
            int i4 = this.s[i3];
            for (int i5 = 0; i5 < 3; i5++) {
                this.V[i5] = this.z[(i4 * 3) + i5];
            }
            a(this.V);
            int i6 = i3 * 2;
            this.D[i6 + 0] = this.U[0];
            this.D[i6 + 1] = this.U[1];
        }
        for (int i7 = 0; i7 < this.j.length; i7++) {
            dArr2[i7] = this.D[this.j[i7]];
        }
    }

    private void a(boolean z2) {
        int i2;
        boolean z3 = z2;
        int i3 = this.t;
        if (z3) {
            i3 = this.s.length;
        }
        int i4 = 0;
        int i5 = 0;
        while (i5 < i3) {
            int i6 = z3 ? this.s[i5] : i5;
            int i7 = 0;
            while (true) {
                i2 = 3;
                if (i7 >= 3) {
                    break;
                }
                this.T[i7] = (double) this.x[(i6 * 3) + i7];
                i7++;
            }
            int i8 = 0;
            while (i8 < this.v) {
                int i9 = 0;
                while (i9 < i2) {
                    double[] dArr = this.T;
                    double d2 = dArr[i9];
                    double d3 = this.f727a[i8];
                    int i10 = (i6 * 3) + i9;
                    int i11 = i9;
                    double d4 = (double) (this.R.a(i4, i8)[i10] - this.x[i10]);
                    Double.isNaN(d4);
                    dArr[i11] = d2 + (d3 * d4);
                    i9 = i11 + 1;
                    i4 = 0;
                    i2 = 3;
                }
                i8++;
                i4 = 0;
                i2 = 3;
            }
            for (int i12 = 0; i12 < 3; i12++) {
                this.B[(i6 * 3) + i12] = (float) this.T[i12];
            }
            i5++;
            i4 = 0;
        }
        a(z3, this.z, this.B);
    }

    /* access modifiers changed from: private */
    public void c(double[] dArr, double[] dArr2) {
        this.E[0] = dArr[0];
        this.F[0] = dArr[1];
        this.H[0] = dArr[2];
        this.I[0] = dArr[3];
        this.G[0] = dArr[4];
        this.E[1] = dArr[5];
        this.F[1] = dArr[6];
        this.H[1] = dArr[7];
        this.I[1] = dArr[8];
        this.G[1] = dArr[9];
        this.E[2] = dArr[10];
        this.F[2] = dArr[11];
        this.H[2] = dArr[12];
        this.I[2] = dArr[13];
        this.G[2] = dArr[14];
        this.E[3] = dArr[15];
        this.F[3] = dArr[16];
        this.H[3] = dArr[17];
        this.I[3] = dArr[18];
        this.G[3] = dArr[19];
        if (this.f728b) {
            this.F[3] = 0.0d;
        } else {
            this.I[3] = 1.0d;
        }
        b(true);
        for (int i2 = 0; i2 < this.u; i2++) {
            for (int i3 = 0; i3 < 3; i3++) {
                this.V[i3] = this.A[(this.s[i2] * 3) + i3];
            }
            a(this.V);
            int i4 = i2 * 2;
            this.D[i4 + 0] = this.U[0];
            this.D[i4 + 1] = this.U[1];
        }
        for (int i5 = 0; i5 < this.l.length; i5++) {
            dArr2[i5] = this.D[this.l[i5]];
        }
    }

    private void b(boolean z2) {
        boolean z3 = z2;
        int i2 = this.t;
        if (z3) {
            i2 = this.s.length;
        }
        int i3 = i2;
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = z3 ? this.s[i4] : i4;
            for (int i6 = 0; i6 < 3; i6++) {
                int i7 = (i5 * 3) + i6;
                this.C[i7] = this.B[i7];
            }
        }
        double[] dArr = {0.0d, 0.0d, 0.0d};
        for (int i8 = 0; i8 < this.w; i8++) {
            double[] dArr2 = this.q;
            double d2 = (double) this.R.a(i8).f723a[0];
            double d3 = this.E[i8];
            Double.isNaN(d2);
            dArr2[0] = d2 + d3;
            double[] dArr3 = this.q;
            double d4 = (double) this.R.a(i8).f723a[1];
            double d5 = this.F[i8];
            Double.isNaN(d4);
            dArr3[1] = d4 + d5;
            this.q[2] = (double) this.R.a(i8).f723a[2];
            int i9 = 0;
            while (i9 < i3) {
                int i10 = z3 ? this.s[i9] : i9;
                float f2 = this.R.a(i8).f724b[i10];
                float[] fArr = this.C;
                int i11 = i10 * 3;
                int i12 = i11 + 0;
                double d6 = (double) fArr[i12];
                double d7 = this.E[i8];
                double[] dArr4 = dArr;
                double d8 = (double) f2;
                Double.isNaN(d8);
                Double.isNaN(d6);
                fArr[i12] = (float) (d6 + (d7 * d8));
                float[] fArr2 = this.C;
                int i13 = i11 + 1;
                double d9 = (double) fArr2[i13];
                double d10 = this.F[i8];
                Double.isNaN(d8);
                Double.isNaN(d9);
                fArr2[i13] = (float) (d9 + (d10 * d8));
                float[] fArr3 = this.C;
                int i14 = i11 + 2;
                double d11 = (double) fArr3[i14];
                Double.isNaN(d11);
                fArr3[i14] = (float) (d11 + 0.0d);
                float[] fArr4 = this.C;
                Double.isNaN(d8);
                fArr4[i12] = ((this.C[i12] - ((float) this.q[0])) * ((float) (((this.H[i8] - 1.0d) * d8) + 1.0d))) + ((float) this.q[0]);
                float[] fArr5 = this.C;
                Double.isNaN(d8);
                fArr5[i13] = ((this.C[i13] - ((float) this.q[1])) * ((float) (((this.I[i8] - 1.0d) * d8) + 1.0d))) + ((float) this.q[1]);
                dArr4[0] = 0.0d;
                dArr4[1] = 0.0d;
                double d12 = this.G[i8];
                Double.isNaN(d8);
                dArr4[2] = d8 * d12;
                a((double) this.C[i12], (double) this.C[i13], (double) this.C[i14], dArr4, false);
                this.C[i12] = (float) (this.q[0] + this.aw);
                this.C[i13] = (float) (this.q[1] + this.ax);
                this.C[i14] = (float) (this.q[2] + this.ay);
                i9++;
                dArr = dArr4;
            }
            double[] dArr5 = dArr;
        }
        a(z3, this.A, this.C);
    }

    public void d(float[] fArr) {
        for (int i2 = 0; i2 < 3; i2++) {
            this.q[i2] = this.r[i2] + this.o[i2];
        }
        for (int i3 = 0; i3 < this.t; i3++) {
            int i4 = i3 * 3;
            int i5 = i4 + 0;
            int i6 = i4 + 1;
            int i7 = i4 + 2;
            a((double) fArr[i5], (double) fArr[i6], (double) fArr[i7], this.p, true);
            fArr[i5] = (float) ((this.q[0] + this.aw) - this.o[0]);
            fArr[i6] = (float) ((this.q[1] + this.ax) - this.o[1]);
            fArr[i7] = (float) ((this.q[2] + this.ay) - this.o[2]);
        }
    }

    public void a(double[] dArr) {
        float[] h2 = this.R.h();
        double d2 = (double) h2[0];
        double d3 = dArr[0];
        Double.isNaN(d2);
        double d4 = d2 * d3;
        double d5 = (double) h2[4];
        double d6 = dArr[1];
        Double.isNaN(d5);
        double d7 = d4 + (d5 * d6);
        double d8 = (double) h2[8];
        double d9 = dArr[2];
        Double.isNaN(d8);
        double d10 = d7 + (d8 * d9);
        double d11 = (double) h2[12];
        double d12 = dArr[3];
        Double.isNaN(d11);
        double d13 = d10 + (d11 * d12);
        double d14 = (double) h2[1];
        double d15 = dArr[0];
        Double.isNaN(d14);
        double d16 = d14 * d15;
        double d17 = (double) h2[5];
        double d18 = dArr[1];
        Double.isNaN(d17);
        double d19 = d16 + (d17 * d18);
        double d20 = (double) h2[9];
        double d21 = dArr[2];
        Double.isNaN(d20);
        double d22 = d19 + (d20 * d21);
        double d23 = (double) h2[13];
        double d24 = dArr[3];
        Double.isNaN(d23);
        double d25 = d22 + (d23 * d24);
        double d26 = (double) h2[2];
        double d27 = dArr[0];
        Double.isNaN(d26);
        double d28 = d26 * d27;
        double d29 = (double) h2[6];
        double d30 = dArr[1];
        Double.isNaN(d29);
        double d31 = d28 + (d29 * d30);
        double d32 = (double) h2[10];
        double d33 = dArr[2];
        Double.isNaN(d32);
        double d34 = d31 + (d32 * d33);
        double d35 = (double) h2[14];
        double d36 = dArr[3];
        Double.isNaN(d35);
        double d37 = d34 + (d35 * d36);
        double d38 = (double) h2[3];
        double d39 = dArr[0];
        Double.isNaN(d38);
        double d40 = d38 * d39;
        double d41 = d13;
        double d42 = (double) h2[7];
        double d43 = dArr[1];
        Double.isNaN(d42);
        double d44 = d40 + (d42 * d43);
        double d45 = (double) h2[11];
        double d46 = dArr[2];
        Double.isNaN(d45);
        double d47 = (double) h2[15];
        double d48 = dArr[3];
        Double.isNaN(d47);
        double d49 = d44 + (d45 * d46) + (d47 * d48);
        double d50 = d37 / d49;
        double[] dArr2 = this.U;
        double d51 = (double) d.v[0];
        Double.isNaN(d51);
        dArr2[0] = ((d41 / d49) + 1.0d) * 0.5d * d51;
        double[] dArr3 = this.U;
        double d52 = (double) d.v[1];
        Double.isNaN(d52);
        dArr3[1] = ((d25 / d49) + 1.0d) * 0.5d * d52;
        this.U[2] = d50;
    }

    /* access modifiers changed from: package-private */
    public void a(double d2, double d3, double d4, double[] dArr, boolean z2) {
        this.W = Math.cos(dArr[1] / 2.0d);
        this.X = Math.sin(dArr[1] / 2.0d);
        this.Y = Math.cos(dArr[2] / 2.0d);
        this.Z = Math.sin(dArr[2] / 2.0d);
        this.aa = Math.cos(dArr[0] / 2.0d);
        this.ab = Math.sin(dArr[0] / 2.0d);
        this.ac = this.W * this.Y;
        this.ad = this.X * this.Z;
        this.ae = (this.ac * this.aa) - (this.ad * this.ab);
        this.af = (this.ac * this.ab) + (this.ad * this.aa);
        this.ag = (this.X * this.Y * this.aa) + (this.W * this.Z * this.ab);
        this.ah = ((this.W * this.Z) * this.aa) - ((this.X * this.Y) * this.ab);
        if (z2) {
            this.af *= -1.0d;
            this.ag *= -1.0d;
            this.ah *= -1.0d;
        }
        this.au = Math.sqrt((this.af * this.af) + (this.ag * this.ag) + (this.ah * this.ah) + (this.ae * this.ae));
        if (this.au > this.av) {
            this.am = this.ae / this.au;
            this.an = (-this.af) / this.au;
            this.ao = (-this.ag) / this.au;
            this.ap = (-this.ah) / this.au;
        } else {
            this.am = this.ae;
            this.an = -this.af;
            this.ao = -this.ag;
            this.ap = -this.ah;
        }
        this.ai = 0.0d;
        this.aj = d2 - this.q[0];
        this.ak = d3 - this.q[1];
        this.al = d4 - this.q[2];
        this.ar = (((this.af * this.ai) + (this.ag * this.al)) - (this.ah * this.ak)) + (this.ae * this.aj);
        this.as = ((-this.af) * this.al) + (this.ag * this.ai) + (this.ah * this.aj) + (this.ae * this.ak);
        this.at = ((this.af * this.ak) - (this.ag * this.aj)) + (this.ah * this.ai) + (this.ae * this.al);
        this.aq = ((((-this.af) * this.aj) - (this.ag * this.ak)) - (this.ah * this.al)) + (this.ae * this.ai);
        this.af = (((this.ar * this.am) + (this.as * this.ap)) - (this.at * this.ao)) + (this.aq * this.an);
        this.ag = ((-this.ar) * this.ap) + (this.as * this.am) + (this.at * this.an) + (this.aq * this.ao);
        this.ah = ((this.ar * this.ao) - (this.as * this.an)) + (this.at * this.am) + (this.aq * this.ap);
        this.ae = ((((-this.ar) * this.an) - (this.as * this.ao)) - (this.at * this.ap)) + (this.aq * this.am);
        this.aw = this.af;
        this.ax = this.ag;
        this.ay = this.ah;
    }

    public void b() {
        this.r = null;
        this.s = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.f727a = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = null;
        this.L = null;
        if (this.O != null) {
            this.O.a();
            this.O = null;
        }
        if (this.P != null) {
            this.P.a();
            this.P = null;
        }
        if (this.Q != null) {
            this.Q.a();
            this.Q = null;
        }
    }

    /* compiled from: FaceMeshGenerator */
    public class b {

        /* renamed from: b  reason: collision with root package name */
        private final double f732b = 0.001d;
        private double[] c;
        private double[] d;
        private double[] e;
        private double[] f;
        private double[] g;
        private double[] h;
        private double[] i;
        private C0025c j;
        private C0025c k;
        private C0025c l;
        private C0025c m;
        private C0025c n;
        private C0025c o;
        private C0025c p;
        private C0025c q;
        private C0025c r;
        private C0025c s;
        private int t;
        private int u;

        public b(int i2, int i3) {
            this.t = i2;
            this.u = i3;
            this.j = new C0025c(i2, i2);
            this.k = new C0025c(i3, i3);
            this.l = new C0025c(i2, i3);
            this.m = new C0025c(i3, i2);
            this.c = new double[i2];
            this.d = new double[i3];
            this.e = new double[i3];
            this.f = new double[i2];
            this.g = new double[i2];
            this.h = new double[i3];
            this.i = new double[i3];
            this.n = new C0025c(i2, i3);
            this.o = new C0025c(i3, i2);
            this.p = new C0025c(i3, i3);
            this.q = new C0025c(i3, i3);
            this.r = new C0025c(i3, i3);
            this.s = new C0025c(i2, i3);
        }

        public void a(double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5) {
            for (int i2 = 0; i2 < this.t; i2++) {
                this.j.a(i2, i2, dArr3[i2]);
            }
            for (int i3 = 0; i3 < this.u; i3++) {
                this.k.a(i3, i3, dArr5[i3]);
            }
            for (int i4 = 0; i4 < this.t; i4++) {
                this.c[i4] = dArr2[i4];
            }
            for (int i5 = 0; i5 < this.u; i5++) {
                this.d[i5] = dArr4[i5];
            }
            c.this.a(this.c, this.e);
            for (int i6 = 0; i6 < this.t; i6++) {
                for (int i7 = 0; i7 < this.t; i7++) {
                    this.f[i7] = this.c[i7];
                }
                for (int i8 = 0; i8 < this.t; i8++) {
                    this.g[i8] = this.c[i8];
                }
                this.f[i6] = this.c[i6] - 5.0E-4d;
                this.g[i6] = this.c[i6] + 5.0E-4d;
                c.this.a(this.f, this.h);
                c.this.a(this.g, this.i);
                for (int i9 = 0; i9 < this.u; i9++) {
                    this.m.a(i9, i6, (this.i[i9] - this.h[i9]) * 1000.0d);
                }
            }
            c.this.a(this.n, this.m);
            c.this.a(this.o, this.m, this.j);
            c.this.a(this.p, this.o, this.n);
            c.this.b(this.q, this.k, this.p);
            c.this.b(this.r, this.q);
            c.this.a(this.s, this.j, this.n);
            c.this.a(this.l, this.s, this.r);
            for (int i10 = 0; i10 < this.t; i10++) {
                dArr[i10] = this.c[i10];
                for (int i11 = 0; i11 < this.u; i11++) {
                    dArr[i10] = dArr[i10] + (this.l.a(i10, i11) * (this.d[i11] - this.e[i11]));
                }
            }
        }

        public void a() {
            this.j = null;
            this.k = null;
            this.l = null;
            this.m = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = null;
            this.g = null;
            this.h = null;
            this.i = null;
            this.n = null;
            this.o = null;
            this.p = null;
            this.q = null;
            this.r = null;
            this.s = null;
        }
    }

    /* compiled from: FaceMeshGenerator */
    public class d {
        private C0025c A;
        private C0025c B;
        private C0025c C;
        private C0025c D;
        private C0025c E;
        private C0025c F;
        private C0025c G;
        private C0025c H;
        private double[] I;
        private double[] J;
        private double[] K;
        private int L;
        private int M;

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f735a;

        /* renamed from: b  reason: collision with root package name */
        private double f736b = 0.01d;
        private double c = 2.0d;
        private double d = 0.0d;
        private double e;
        private double[] f;
        private C0025c g;
        private double[] h;
        private double[] i;
        private C0025c j;
        private C0025c k;
        private int l;
        private C0025c m;
        private C0025c n;
        private C0025c o;
        private double p;
        private double q;
        private C0025c r;
        private C0025c s;
        private double[] t;
        private C0025c u;
        private C0025c v;
        private C0025c w;
        private C0025c x;
        private C0025c y;
        private C0025c z;

        public d(c cVar, int i2, int i3) {
            c cVar2 = cVar;
            int i4 = i2;
            int i5 = i3;
            this.f735a = cVar2;
            this.L = i4;
            this.M = i5;
            int i6 = i4 * 2;
            this.l = i6 + 1;
            double pow = Math.pow(this.f736b, 2.0d);
            double d2 = (double) i4;
            double d3 = this.d;
            Double.isNaN(d2);
            Double.isNaN(d2);
            this.e = (pow * (d3 + d2)) - d2;
            this.g = new C0025c(i4, i4);
            this.w = new C0025c(i5, i5);
            this.m = new C0025c(i4, this.l);
            this.y = new C0025c(i4, this.l);
            this.z = new C0025c(i4, this.l);
            this.n = new C0025c(i5, this.l);
            this.J = new double[i4];
            this.K = new double[i5];
            int i7 = this.l - 1;
            double d4 = this.e;
            Double.isNaN(d2);
            this.o = new C0025c(1, i7, 0.5d / (d4 + d2));
            this.r = new C0025c(i4, this.l - 1);
            this.s = new C0025c(i5, this.l - 1);
            this.B = new C0025c(i4, i4);
            double d5 = this.e;
            double d6 = this.e;
            Double.isNaN(d2);
            this.p = d5 / (d2 + d6);
            this.q = this.p + (1.0d - Math.pow(this.f736b, 2.0d)) + this.c;
            for (int i8 = 0; i8 < i4; i8++) {
                for (int i9 = 0; i9 < this.l - 1; i9++) {
                    this.r.a(i8, i9, this.o.a(0, i9));
                }
            }
            for (int i10 = 0; i10 < i5; i10++) {
                for (int i11 = 0; i11 < this.l - 1; i11++) {
                    this.s.a(i10, i11, this.o.a(0, i11));
                }
            }
            this.f = new double[i4];
            this.h = new double[i5];
            this.i = new double[i5];
            this.t = new double[i5];
            this.u = new C0025c(i4, i6);
            this.v = new C0025c(i5, i6);
            this.j = new C0025c(i4, i5);
            this.k = new C0025c(i5, i5);
            this.x = new C0025c(i4, i5);
            this.C = new C0025c(i5, i6);
            this.I = new double[i5];
            this.D = new C0025c(i5, i6);
            this.E = new C0025c(i6, i5);
            this.F = new C0025c(i5, i5);
            this.G = new C0025c(i6, i5);
            this.H = new C0025c(i5, i5);
            this.A = new C0025c(i5, i5);
        }

        public void a(double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5) {
            for (int i2 = 0; i2 < this.L; i2++) {
                this.g.a(i2, i2, dArr3[i2]);
            }
            for (int i3 = 0; i3 < this.M; i3++) {
                this.w.a(i3, i3, dArr5[i3]);
            }
            int i4 = this.L;
            for (int i5 = 0; i5 < this.L; i5++) {
                C0025c cVar = this.B;
                double d2 = (double) i4;
                double d3 = this.e;
                Double.isNaN(d2);
                cVar.a(i5, i5, Math.sqrt((d2 + d3) * this.g.a(i5, i5)));
            }
            for (int i6 = 0; i6 < this.L; i6++) {
                for (int i7 = 1; i7 < this.L + 1; i7++) {
                    this.y.a(i6, i7, -this.B.a(i6, i7 - 1));
                }
            }
            for (int i8 = 0; i8 < this.L; i8++) {
                for (int i9 = this.L + 1; i9 < (this.L * 2) + 1; i9++) {
                    this.y.a(i8, i9, this.B.a(i8, (i9 - this.L) - 1));
                }
            }
            for (int i10 = 0; i10 < this.L; i10++) {
                this.f[i10] = dArr2[i10];
            }
            for (int i11 = 0; i11 < this.M; i11++) {
                this.h[i11] = dArr4[i11];
            }
            for (int i12 = 0; i12 < this.L; i12++) {
                for (int i13 = 0; i13 < this.l; i13++) {
                    this.z.a(i12, i13, this.f[i12]);
                }
            }
            for (int i14 = 0; i14 < this.L; i14++) {
                for (int i15 = 0; i15 < this.l; i15++) {
                    this.m.a(i14, i15, this.y.a(i14, i15) + this.z.a(i14, i15));
                }
            }
            for (int i16 = 0; i16 < this.l; i16++) {
                for (int i17 = 0; i17 < this.L; i17++) {
                    this.J[i17] = this.m.a(i17, i16);
                }
                this.f735a.b(this.J, this.K);
                for (int i18 = 0; i18 < this.M; i18++) {
                    this.n.a(i18, i16, this.K[i18]);
                }
            }
            for (int i19 = 0; i19 < this.M; i19++) {
                int i20 = 0;
                while (i20 < i4 * 2) {
                    int i21 = i20 + 1;
                    this.C.a(i19, i20, this.s.a(i19, i20) * this.n.a(i19, i21));
                    i20 = i21;
                }
            }
            for (int i22 = 0; i22 < this.M; i22++) {
                this.I[i22] = 0.0d;
                for (int i23 = 0; i23 < i4 * 2; i23++) {
                    double[] dArr6 = this.I;
                    dArr6[i22] = dArr6[i22] + this.C.a(i22, i23);
                }
            }
            for (int i24 = 0; i24 < this.M; i24++) {
                this.i[i24] = (this.p * this.n.a(i24, 0)) + this.I[i24];
            }
            for (int i25 = 0; i25 < this.L; i25++) {
                int i26 = 0;
                while (i26 < this.L * 2) {
                    int i27 = i26 + 1;
                    this.u.a(i25, i26, this.m.a(i25, i27) - this.f[i25]);
                    i26 = i27;
                }
            }
            for (int i28 = 0; i28 < this.M; i28++) {
                this.t[i28] = this.n.a(i28, 0) - this.i[i28];
            }
            for (int i29 = 0; i29 < this.M; i29++) {
                int i30 = 0;
                while (i30 < this.L * 2) {
                    int i31 = i30 + 1;
                    this.v.a(i29, i30, this.n.a(i29, i31) - this.i[i29]);
                    i30 = i31;
                }
            }
            for (int i32 = 0; i32 < this.M; i32++) {
                for (int i33 = 0; i33 < this.L * 2; i33++) {
                    this.D.a(i32, i33, this.s.a(i32, i33) * this.v.a(i32, i33));
                }
            }
            for (int i34 = 0; i34 < this.M; i34++) {
                for (int i35 = 0; i35 < this.L * 2; i35++) {
                    this.E.a(i35, i34, this.D.a(i34, i35));
                }
            }
            this.f735a.a(this.j, this.u, this.E);
            for (int i36 = 0; i36 < this.M; i36++) {
                for (int i37 = 0; i37 < this.M; i37++) {
                    this.F.a(i36, i37, this.t[i37] * this.t[i36]);
                }
            }
            for (int i38 = 0; i38 < this.M; i38++) {
                for (int i39 = 0; i39 < this.L * 2; i39++) {
                    this.G.a(i39, i38, this.v.a(i38, i39));
                }
            }
            this.f735a.a(this.H, this.D, this.G);
            for (int i40 = 0; i40 < this.M; i40++) {
                for (int i41 = 0; i41 < this.M; i41++) {
                    this.k.a(i40, i41, (this.q * this.F.a(i40, i41)) + this.H.a(i40, i41) + this.w.a(i40, i41));
                }
            }
            this.f735a.b(this.A, this.k);
            this.f735a.a(this.x, this.j, this.A);
            for (int i42 = 0; i42 < this.L; i42++) {
                dArr[i42] = this.f[i42];
                for (int i43 = 0; i43 < this.M; i43++) {
                    dArr[i42] = dArr[i42] + (this.x.a(i42, i43) * (this.h[i43] - this.i[i43]));
                }
            }
        }

        public void a() {
            this.g = null;
            this.w = null;
            this.m = null;
            this.y = null;
            this.z = null;
            this.n = null;
            this.J = null;
            this.K = null;
            this.o = null;
            this.r = null;
            this.s = null;
            this.B = null;
            this.f = null;
            this.h = null;
            this.i = null;
            this.t = null;
            this.u = null;
            this.v = null;
            this.j = null;
            this.k = null;
            this.x = null;
            this.C = null;
            this.I = null;
            this.D = null;
            this.E = null;
            this.F = null;
            this.G = null;
            this.H = null;
            this.A = null;
        }
    }

    /* compiled from: FaceMeshGenerator */
    public class a {
        private C0025c A;
        private C0025c B;
        private C0025c C;
        private C0025c D;
        private C0025c E;
        private C0025c F;
        private C0025c G;
        private C0025c H;
        private double[] I;
        private double[] J;
        private double[] K;
        private int L;
        private int M;

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f729a;

        /* renamed from: b  reason: collision with root package name */
        private double f730b = 0.01d;
        private double c = 2.0d;
        private double d = 0.0d;
        private double e;
        private double[] f;
        private C0025c g;
        private double[] h;
        private double[] i;
        private C0025c j;
        private C0025c k;
        private int l;
        private C0025c m;
        private C0025c n;
        private C0025c o;
        private double p;
        private double q;
        private C0025c r;
        private C0025c s;
        private double[] t;
        private C0025c u;
        private C0025c v;
        private C0025c w;
        private C0025c x;
        private C0025c y;
        private C0025c z;

        public a(c cVar, int i2, int i3) {
            c cVar2 = cVar;
            int i4 = i2;
            int i5 = i3;
            this.f729a = cVar2;
            this.L = i4;
            this.M = i5;
            int i6 = i4 * 2;
            this.l = i6 + 1;
            double pow = Math.pow(this.f730b, 2.0d);
            double d2 = (double) i4;
            double d3 = this.d;
            Double.isNaN(d2);
            Double.isNaN(d2);
            this.e = (pow * (d3 + d2)) - d2;
            this.g = new C0025c(i4, i4);
            this.w = new C0025c(i5, i5);
            this.m = new C0025c(i4, this.l);
            this.y = new C0025c(i4, this.l);
            this.z = new C0025c(i4, this.l);
            this.n = new C0025c(i5, this.l);
            this.I = new double[i4];
            this.J = new double[i5];
            int i7 = this.l - 1;
            double d4 = this.e;
            Double.isNaN(d2);
            this.o = new C0025c(1, i7, 0.5d / (d4 + d2));
            this.r = new C0025c(i4, this.l - 1);
            this.s = new C0025c(i5, this.l - 1);
            this.A = new C0025c(i4, i4);
            double d5 = this.e;
            double d6 = this.e;
            Double.isNaN(d2);
            this.p = d5 / (d2 + d6);
            this.q = this.p + (1.0d - Math.pow(this.f730b, 2.0d)) + this.c;
            for (int i8 = 0; i8 < i4; i8++) {
                for (int i9 = 0; i9 < this.l - 1; i9++) {
                    this.r.a(i8, i9, this.o.a(0, i9));
                }
            }
            for (int i10 = 0; i10 < i5; i10++) {
                for (int i11 = 0; i11 < this.l - 1; i11++) {
                    this.s.a(i10, i11, this.o.a(0, i11));
                }
            }
            this.f = new double[i4];
            this.h = new double[i5];
            this.i = new double[i5];
            this.t = new double[i5];
            this.u = new C0025c(i4, i6);
            this.v = new C0025c(i5, i6);
            this.j = new C0025c(i4, i5);
            this.k = new C0025c(i5, i5);
            this.x = new C0025c(i4, i5);
            this.C = new C0025c(i5, i6);
            this.K = new double[i5];
            this.D = new C0025c(i5, i6);
            this.E = new C0025c(i6, i5);
            this.F = new C0025c(i5, i5);
            this.G = new C0025c(i6, i5);
            this.H = new C0025c(i5, i5);
            this.B = new C0025c(i5, i5);
        }

        public void a(double[] dArr, double[] dArr2, double[] dArr3, double[] dArr4, double[] dArr5) {
            for (int i2 = 0; i2 < this.L; i2++) {
                this.g.a(i2, i2, dArr3[i2]);
            }
            for (int i3 = 0; i3 < this.M; i3++) {
                this.w.a(i3, i3, dArr5[i3]);
            }
            int i4 = this.L;
            for (int i5 = 0; i5 < this.L; i5++) {
                C0025c cVar = this.A;
                double d2 = (double) i4;
                double d3 = this.e;
                Double.isNaN(d2);
                cVar.a(i5, i5, Math.sqrt((d2 + d3) * this.g.a(i5, i5)));
            }
            for (int i6 = 0; i6 < this.L; i6++) {
                for (int i7 = 1; i7 < this.L + 1; i7++) {
                    this.y.a(i6, i7, -this.A.a(i6, i7 - 1));
                }
            }
            for (int i8 = 0; i8 < this.L; i8++) {
                for (int i9 = this.L + 1; i9 < (this.L * 2) + 1; i9++) {
                    this.y.a(i8, i9, this.A.a(i8, (i9 - this.L) - 1));
                }
            }
            for (int i10 = 0; i10 < this.L; i10++) {
                this.f[i10] = dArr2[i10];
            }
            for (int i11 = 0; i11 < this.M; i11++) {
                this.h[i11] = dArr4[i11];
            }
            for (int i12 = 0; i12 < this.L; i12++) {
                for (int i13 = 0; i13 < this.l; i13++) {
                    this.z.a(i12, i13, this.f[i12]);
                }
            }
            for (int i14 = 0; i14 < this.L; i14++) {
                for (int i15 = 0; i15 < this.l; i15++) {
                    this.m.a(i14, i15, this.y.a(i14, i15) + this.z.a(i14, i15));
                }
            }
            for (int i16 = 0; i16 < this.l; i16++) {
                for (int i17 = 0; i17 < this.L; i17++) {
                    this.I[i17] = this.m.a(i17, i16);
                }
                this.f729a.c(this.I, this.J);
                for (int i18 = 0; i18 < this.M; i18++) {
                    this.n.a(i18, i16, this.J[i18]);
                }
            }
            for (int i19 = 0; i19 < this.M; i19++) {
                int i20 = 0;
                while (i20 < i4 * 2) {
                    int i21 = i20 + 1;
                    this.C.a(i19, i20, this.s.a(i19, i20) * this.n.a(i19, i21));
                    i20 = i21;
                }
            }
            for (int i22 = 0; i22 < this.M; i22++) {
                this.K[i22] = 0.0d;
                for (int i23 = 0; i23 < i4 * 2; i23++) {
                    double[] dArr6 = this.K;
                    dArr6[i22] = dArr6[i22] + this.C.a(i22, i23);
                }
            }
            for (int i24 = 0; i24 < this.M; i24++) {
                this.i[i24] = (this.p * this.n.a(i24, 0)) + this.K[i24];
            }
            for (int i25 = 0; i25 < this.L; i25++) {
                int i26 = 0;
                while (i26 < this.L * 2) {
                    int i27 = i26 + 1;
                    this.u.a(i25, i26, this.m.a(i25, i27) - this.f[i25]);
                    i26 = i27;
                }
            }
            for (int i28 = 0; i28 < this.M; i28++) {
                this.t[i28] = this.n.a(i28, 0) - this.i[i28];
            }
            for (int i29 = 0; i29 < this.M; i29++) {
                int i30 = 0;
                while (i30 < this.L * 2) {
                    int i31 = i30 + 1;
                    this.v.a(i29, i30, this.n.a(i29, i31) - this.i[i29]);
                    i30 = i31;
                }
            }
            for (int i32 = 0; i32 < this.M; i32++) {
                for (int i33 = 0; i33 < this.L * 2; i33++) {
                    this.D.a(i32, i33, this.s.a(i32, i33) * this.v.a(i32, i33));
                }
            }
            for (int i34 = 0; i34 < this.M; i34++) {
                for (int i35 = 0; i35 < this.L * 2; i35++) {
                    this.E.a(i35, i34, this.D.a(i34, i35));
                }
            }
            this.f729a.a(this.j, this.u, this.E);
            for (int i36 = 0; i36 < this.M; i36++) {
                for (int i37 = 0; i37 < this.M; i37++) {
                    this.F.a(i36, i37, this.t[i37] * this.t[i36]);
                }
            }
            for (int i38 = 0; i38 < this.M; i38++) {
                for (int i39 = 0; i39 < this.L * 2; i39++) {
                    this.G.a(i39, i38, this.v.a(i38, i39));
                }
            }
            this.f729a.a(this.H, this.D, this.G);
            for (int i40 = 0; i40 < this.M; i40++) {
                for (int i41 = 0; i41 < this.M; i41++) {
                    this.k.a(i40, i41, (this.q * this.F.a(i40, i41)) + this.H.a(i40, i41) + this.w.a(i40, i41));
                }
            }
            this.f729a.b(this.B, this.k);
            this.f729a.a(this.x, this.j, this.B);
            for (int i42 = 0; i42 < this.L; i42++) {
                dArr[i42] = this.f[i42];
                for (int i43 = 0; i43 < this.M; i43++) {
                    dArr[i42] = dArr[i42] + (this.x.a(i42, i43) * (this.h[i43] - this.i[i43]));
                }
            }
        }

        public void a() {
            this.g = null;
            this.w = null;
            this.m = null;
            this.y = null;
            this.z = null;
            this.n = null;
            this.I = null;
            this.J = null;
            this.o = null;
            this.r = null;
            this.s = null;
            this.A = null;
            this.f = null;
            this.h = null;
            this.i = null;
            this.t = null;
            this.u = null;
            this.v = null;
            this.j = null;
            this.k = null;
            this.x = null;
            this.C = null;
            this.K = null;
            this.D = null;
            this.E = null;
            this.F = null;
            this.G = null;
            this.H = null;
            this.B = null;
        }
    }

    /* renamed from: net.fxgear.customface.c$c  reason: collision with other inner class name */
    /* compiled from: FaceMeshGenerator */
    public class C0025c {

        /* renamed from: b  reason: collision with root package name */
        private int f734b;
        private int c;
        private double[][] d = ((double[][]) Array.newInstance(double.class, new int[]{this.f734b, this.c}));

        public int a() {
            return this.f734b;
        }

        public int b() {
            return this.c;
        }

        public C0025c(int i, int i2) {
            this.f734b = i;
            this.c = i2;
        }

        public C0025c(int i, int i2, double d2) {
            this.f734b = i;
            this.c = i2;
            for (int i3 = 0; i3 < this.f734b; i3++) {
                for (int i4 = 0; i4 < this.c; i4++) {
                    this.d[i3][i4] = d2;
                }
            }
        }

        public double a(int i, int i2) {
            return this.d[i][i2];
        }

        public void a(int i, int i2, double d2) {
            this.d[i][i2] = d2;
        }
    }

    public void a(C0025c cVar, C0025c cVar2, C0025c cVar3) {
        for (int i2 = 0; i2 < cVar2.a(); i2++) {
            for (int i3 = 0; i3 < cVar3.b(); i3++) {
                double d2 = 0.0d;
                for (int i4 = 0; i4 < cVar2.b(); i4++) {
                    d2 += cVar2.a(i2, i4) * cVar3.a(i4, i3);
                }
                cVar.a(i2, i3, d2);
            }
        }
    }

    public void a(C0025c cVar, C0025c cVar2) {
        for (int i2 = 0; i2 < cVar.a(); i2++) {
            for (int i3 = 0; i3 < cVar.b(); i3++) {
                cVar.a(i2, i3, cVar2.a(i3, i2));
            }
        }
    }

    public void b(C0025c cVar, C0025c cVar2, C0025c cVar3) {
        for (int i2 = 0; i2 < cVar.a(); i2++) {
            for (int i3 = 0; i3 < cVar.b(); i3++) {
                cVar.a(i2, i3, cVar2.a(i2, i3) + cVar3.a(i2, i3));
            }
        }
    }

    public void b(C0025c cVar, C0025c cVar2) {
        int a2 = cVar2.a();
        int b2 = cVar2.b();
        int i2 = b2 * 2;
        double[][] dArr = (double[][]) Array.newInstance(double.class, new int[]{a2, i2});
        double[] dArr2 = new double[i2];
        int i3 = 0;
        while (i3 < a2) {
            for (int i4 = 0; i4 < b2; i4++) {
                dArr[i3][i4] = cVar2.a(i3, i4);
            }
            C0025c cVar3 = cVar2;
            int i5 = 0;
            while (i5 < b2) {
                dArr[i3][b2 + i5] = i3 == i5 ? 1.0d : 0.0d;
                i5++;
            }
            i3++;
        }
        int i6 = 0;
        while (i6 < a2) {
            int i7 = i6;
            while (i7 < a2) {
                int i8 = i7 + 1;
                for (int i9 = i8; i9 < a2; i9++) {
                    if (Math.abs(dArr[i7][i6]) < Math.abs(dArr[i9][i6]) && i7 != i9) {
                        for (int i10 = 0; i10 < i2; i10++) {
                            double d2 = dArr[i7][i10];
                            dArr[i7][i10] = dArr[i9][i10];
                            dArr[i9][i10] = d2;
                        }
                    }
                }
                i7 = i8;
            }
            if (dArr[i6][i6] <= -1.0E-10d || dArr[i6][i6] >= 1.0E-10d) {
                for (int i11 = 0; i11 < a2; i11++) {
                    if (i6 != i11) {
                        for (int i12 = 0; i12 < i2; i12++) {
                            dArr2[i12] = dArr[i11][i12] - ((dArr[i11][i6] / dArr[i6][i6]) * dArr[i6][i12]);
                        }
                        for (int i13 = 0; i13 < i2; i13++) {
                            dArr[i11][i13] = dArr2[i13];
                        }
                    }
                }
                i6++;
            } else {
                return;
            }
        }
        for (int i14 = 0; i14 < a2; i14++) {
            for (int i15 = 0; i15 < i2; i15++) {
                dArr2[i15] = dArr[i14][i15] * (1.0d / dArr[i14][i14]);
            }
            for (int i16 = 0; i16 < i2; i16++) {
                dArr[i14][i16] = dArr2[i16];
            }
        }
        for (int i17 = 0; i17 < a2; i17++) {
            for (int i18 = 0; i18 < b2; i18++) {
                cVar.a(i17, i18, dArr[i17][b2 + i18]);
            }
            C0025c cVar4 = cVar;
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\customface\CustomFaceInterface.java ==========

package net.fxgear.customface;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import net.fxgear.fittingview.data.FittingFaceData;
import net.fxgear.fittingview.data.a;
import net.fxgear.fittingview.data.b;
import net.fxgear.util.FXUtil;

public class CustomFaceInterface {
    static final int FACE_DETECTION_FAIL_WITH_LOW_SCORE = -2;
    static final int FACE_DETECTION_FAIL_WITH_NO_FACE = -1;
    static final int FACE_DETECTION_SUCCESS = 1;
    private static final String TAG = "CustomFaceInterface";
    private static int[] info = new int[4];
    private static float[] mPose = new float[3];
    private static int[] trackLog = new int[4];
    private Context context;
    private c faceMeshGenerator;
    private e faceTextureGenerator;
    private f featurePointManager;
    private a mAnimationData;
    private b mAvatarData;
    private float mBilateralFilteringValue = 0.5f;
    private FittingFaceData mFaceData;
    private boolean mIsInitialized = false;
    private h renderer;
    private a resourceManager;

    public static native void checkSdkAllowed(Context context2);

    public static native int[] faceLandmarkAreaDetectorJNI(String str, int[] iArr);

    public static native void faceLandmarkDeleteJNI();

    public static native int[] faceLandmarkDetectorJNI(String str, boolean z, int i, int i2, int i3, int i4, int[] iArr, int[] iArr2);

    public static native boolean faceLandmarkInitJNI(String str, String str2, String str3, String str4, String str5);

    public static native double getErrorJNI();

    public static native boolean matrixSolverInitJNI(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int[] iArr4, int i3, int i4, int i5, int i6);

    public static native int[] modPoissonBlendingJNI(int[] iArr, int[] iArr2, int[] iArr3, int i, int i2);

    public static native void nextIterationJNI();

    public static native void releaseJNI();

    public static native void updateImageJNI(int[] iArr, int i);

    static {
        System.loadLibrary("face_landmark");
    }

    @SuppressLint({"NewApi"})
    public CustomFaceInterface(Context context2) {
        this.context = context2;
    }

    public void Initial(FittingFaceData fittingFaceData, boolean z) {
        if (this.mFaceData == null || this.mFaceData.GetFaceGender() != fittingFaceData.GetFaceGender()) {
            if (this.mIsInitialized) {
                release();
            }
            this.mIsInitialized = false;
        }
        this.mFaceData = fittingFaceData;
        if (!this.mIsInitialized && z) {
            if (!new File(fittingFaceData.GetCommonFaceDB()).exists() || !new File(fittingFaceData.GetCommonBaseDB()).exists() || !new File(fittingFaceData.GetCommonLipsDB()).exists() || !new File(fittingFaceData.GetCommonEyeLDB()).exists() || !new File(fittingFaceData.GetCommonEyeRDB()).exists()) {
                Log.e(TAG, "[c] ERROR: Initial DB file not found!");
                return;
            }
            this.resourceManager = new a(this.context, fittingFaceData);
            this.featurePointManager = new f();
            this.faceMeshGenerator = new c(this.resourceManager, this.featurePointManager);
            this.faceTextureGenerator = new e(this.resourceManager);
            this.renderer = new h(this.context);
            this.renderer.a(this.resourceManager, this.featurePointManager, this.faceMeshGenerator, this.faceTextureGenerator);
            this.mIsInitialized = true;
        }
    }

    public FittingFaceData GetFaceData() {
        return this.mFaceData;
    }

    public static int[] GetFaceFeatureAreaDetect(FittingFaceData fittingFaceData) {
        info[0] = -90;
        info[1] = -90;
        info[2] = -90;
        info[3] = 0;
        trackLog[0] = -1;
        if (!new File(fittingFaceData.GetCommonFaceDB()).exists() || !new File(fittingFaceData.GetCommonBaseDB()).exists() || !new File(fittingFaceData.GetCommonLipsDB()).exists() || !new File(fittingFaceData.GetCommonEyeLDB()).exists() || !new File(fittingFaceData.GetCommonEyeRDB()).exists()) {
            Log.e(TAG, "[c] GetFaceFeatureDetect DB file not found!");
            return null;
        }
        faceLandmarkInitJNI(fittingFaceData.GetCommonFaceDB(), fittingFaceData.GetCommonBaseDB(), fittingFaceData.GetCommonLipsDB(), fittingFaceData.GetCommonEyeLDB(), fittingFaceData.GetCommonEyeRDB());
        if (fittingFaceData.GetCustomBitmapFilePath() == null) {
            Log.e(TAG, "[c] ERROR: GetFaceFeatureDetect faceData.GetCustomBitmapFilePath() == null");
            faceLandmarkDeleteJNI();
            return null;
        }
        int[] faceLandmarkAreaDetectorJNI = faceLandmarkAreaDetectorJNI(fittingFaceData.GetCustomBitmapFilePath(), trackLog);
        String str = TAG;
        Log.i(str, "[c] areas: " + faceLandmarkAreaDetectorJNI[0] + ", " + faceLandmarkAreaDetectorJNI[1] + ", " + faceLandmarkAreaDetectorJNI[2] + ", " + faceLandmarkAreaDetectorJNI[3]);
        faceLandmarkDeleteJNI();
        return faceLandmarkAreaDetectorJNI;
    }

    public static int[] GetFaceFeatureDetect(FittingFaceData fittingFaceData, boolean z, int i, int i2, int i3, int i4) {
        info[0] = -90;
        info[1] = -90;
        info[2] = -90;
        info[3] = 0;
        trackLog[0] = -1;
        if (!new File(fittingFaceData.GetCommonFaceDB()).exists() || !new File(fittingFaceData.GetCommonBaseDB()).exists() || !new File(fittingFaceData.GetCommonLipsDB()).exists() || !new File(fittingFaceData.GetCommonEyeLDB()).exists() || !new File(fittingFaceData.GetCommonEyeRDB()).exists()) {
            Log.e(TAG, "[c] GetFaceFeatureDetect DB file not found!");
            return null;
        }
        faceLandmarkInitJNI(fittingFaceData.GetCommonFaceDB(), fittingFaceData.GetCommonBaseDB(), fittingFaceData.GetCommonLipsDB(), fittingFaceData.GetCommonEyeLDB(), fittingFaceData.GetCommonEyeRDB());
        if (fittingFaceData.GetCustomBitmapFilePath() == null) {
            Log.e(TAG, "[c] ERROR: GetFaceFeatureDetect faceData.GetCustomBitmapFilePath() == null");
            faceLandmarkDeleteJNI();
            return null;
        }
        int[] faceLandmarkDetectorJNI = faceLandmarkDetectorJNI(fittingFaceData.GetCustomBitmapFilePath(), z, i, i2, i3, i4, info, trackLog);
        String str = TAG;
        Log.e(str, "[c] ########################################   FACE TRACKING LOG = " + trackLog[0]);
        faceLandmarkDeleteJNI();
        return faceLandmarkDetectorJNI;
    }

    public static float[] GetFaceAngle() {
        mPose[0] = ((float) info[0]) / 90.0f;
        mPose[1] = ((float) info[1]) / 90.0f;
        mPose[2] = ((float) info[2]) / 90.0f;
        return mPose;
    }

    public static int GetCroppedFaceAreaPercent() {
        return 100 - info[3];
    }

    public static int GetFaceTrackingResult() {
        return trackLog[0];
    }

    public boolean setFaceFeatureDetectNSave(FittingFaceData fittingFaceData, int[] iArr, String str) {
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        if (decodeFile == null) {
            Log.e(TAG, "[c] setFaceFeatureDetectNSave faceBmp == null");
            return false;
        }
        this.featurePointManager.a(decodeFile, fittingFaceData.GetCustomDetectPosition());
        decodeFile.recycle();
        CopyFile(new File(str), fittingFaceData.GetCustomFaceDetectOriImageFile());
        return SaveFeaturePosition(iArr, fittingFaceData.GetCustomFaceDetectPositionFile());
    }

    public boolean PrepareCustomFace() {
        String GetCustomBitmapFilePath = this.mFaceData.GetCustomBitmapFilePath();
        int[] GetCustomDetectPosition = this.mFaceData.GetCustomDetectPosition();
        if (GetCustomBitmapFilePath == null || ((!GetCustomBitmapFilePath.contains(".bmp") && !GetCustomBitmapFilePath.contains(".BMP")) || GetCustomDetectPosition == null || GetCustomDetectPosition.length != 42)) {
            Log.e(TAG, "PrepareCustomFace(), [ERROR] :: Not Support params!");
            return false;
        } else if (!setFaceFeatureDetectNSave(this.mFaceData, GetCustomDetectPosition, GetCustomBitmapFilePath)) {
            Log.e(TAG, "PrepareCustomFace(), [ERROR] :: fail to setFaceFeatureDetectNSave");
            return false;
        } else {
            this.renderer.b();
            return true;
        }
    }

    public boolean GenerateCustomFace() {
        return this.renderer.a(this.mFaceData.GetFaceGender(), this.mFaceData.GetModelGender());
    }

    public boolean SaveCustomMesh() {
        String str;
        boolean z = false;
        for (int i = 0; i < this.resourceManager.q(); i++) {
            float[] a2 = this.faceMeshGenerator.a(i);
            for (int i2 = 0; i2 < a2.length / 3; i2++) {
                int i3 = (i2 * 3) + 0;
                a2[i3] = a2[i3] * -1.0f;
            }
            String str2 = TAG;
            Log.e(str2, "[c] UpdateCustomMesh() " + i + " finalMayaPosition.length: " + a2.length);
            if (i == 0) {
                str = this.mFaceData.GetCustomFaceMeshType1File();
            } else if (i == 1) {
                str = this.mFaceData.GetCustomFaceMeshType2File();
            } else {
                str = this.mFaceData.GetCustomFaceMeshType3File();
            }
            CopyFile(new File(this.mFaceData.GetFaceBaseGenderBaseBin()), str);
            z = UpdatePosition(a2, str);
        }
        return z;
    }

    public void release() {
        if (this.mFaceData != null) {
            this.mFaceData = null;
        }
        if (this.resourceManager != null) {
            this.resourceManager.b();
            this.resourceManager = null;
        }
        if (this.featurePointManager != null) {
            this.featurePointManager.a();
            this.featurePointManager = null;
        }
        if (this.faceMeshGenerator != null) {
            this.faceMeshGenerator.b();
            this.faceMeshGenerator = null;
        }
        if (this.faceTextureGenerator != null) {
            this.faceTextureGenerator.e();
            this.faceTextureGenerator = null;
        }
        if (this.renderer != null) {
            this.renderer.c();
            this.renderer = null;
        }
        this.mIsInitialized = false;
    }

    private boolean UpdateUV(float[] fArr, String str) {
        int i;
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
            byte[] bArr = new byte[4];
            randomAccessFile.read(bArr);
            int i2 = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getInt();
            boolean z = true;
            boolean z2 = (i2 & 1) != 0;
            boolean z3 = (i2 & 2) != 0;
            boolean z4 = (i2 & 4) != 0;
            int i3 = i2 & 8;
            int i4 = i2 & 16;
            int i5 = i2 & 32;
            int i6 = i2 & 64;
            if (z2) {
                randomAccessFile.read(bArr);
                i = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getInt();
                randomAccessFile.skipBytes(i * 12);
            } else {
                i = 0;
            }
            if (z3) {
                randomAccessFile.skipBytes(i * 12);
            }
            if (z4) {
                ByteBuffer order = ByteBuffer.allocate(i * 8).order(ByteOrder.LITTLE_ENDIAN);
                FloatBuffer asFloatBuffer = order.asFloatBuffer();
                for (float put : fArr) {
                    asFloatBuffer.put(put);
                }
                order.position(0);
                randomAccessFile.write(order.array());
                order.clear();
            } else {
                z = false;
            }
            randomAccessFile.close();
            return z;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean UpdatePosition(float[] fArr, String str) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
            boolean z = true;
            randomAccessFile.skipBytes(((int) randomAccessFile.length()) - ((fArr.length + 1) * 4));
            byte[] bArr = new byte[4];
            randomAccessFile.read(bArr);
            int i = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).getInt();
            String str2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("[c] SaveCustomMesh positionCount: ");
            sb.append(i);
            sb.append(", same: ");
            int i2 = i * 3;
            sb.append(fArr.length == i2);
            Log.i(str2, sb.toString());
            if (fArr.length == i2) {
                ByteBuffer order = ByteBuffer.allocate(fArr.length * 4).order(ByteOrder.LITTLE_ENDIAN);
                FloatBuffer asFloatBuffer = order.asFloatBuffer();
                for (float put : fArr) {
                    asFloatBuffer.put(put);
                }
                order.position(0);
                Log.i(TAG, "[c] SaveCustomMesh vertex positionAfterTBC.length: " + order.array().length);
                randomAccessFile.write(order.array());
                order.clear();
            } else {
                z = false;
            }
            randomAccessFile.close();
            return z;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void PrepareBilateralFiltering(String str) {
        Log.e(TAG, "[c] PrepareBilateralFiltering()");
        if (this.mFaceData == null) {
            String str2 = TAG;
            Log.e(str2, "[c] ERROR: PrepareBilateralFiltering mFaceData: " + this.mFaceData);
        } else if (this.faceTextureGenerator == null || !this.faceTextureGenerator.f()) {
            this.mFaceData.SetCustomBitmapFilePath(str);
            this.faceTextureGenerator = new e((a) null);
            this.faceTextureGenerator.a(this.mFaceData);
        } else {
            Log.e(TAG, "[c] WARNING: PrepareBilateralFiltering already is prepared!");
        }
    }

    public void SetBilateralFilteringValue(float f) {
        String str = TAG;
        Log.e(str, "[c] SetBilateralFilteringValue() - " + f);
        this.mBilateralFilteringValue = f;
    }

    public float GetBilateralFilteringValue() {
        return this.mBilateralFilteringValue;
    }

    public int GenerateBilateralFilteringTexture() {
        Log.e(TAG, "[c] GetBilateralFilteringTexture()");
        if (this.faceTextureGenerator != null) {
            return this.faceTextureGenerator.a(this.mBilateralFilteringValue);
        }
        Log.e(TAG, "[c] ERROR: GetBilateralFiltering faceTextureGenerator == null!");
        return 0;
    }

    public void SaveBilateralFiltering() {
        Log.e(TAG, "[c] SaveBilateralFiltering()");
        if (this.faceTextureGenerator == null || this.mFaceData == null) {
            Log.e(TAG, "[c] ERROR: SaveBilateralFiltering faceTextureGenerator == null or mFaceData == null");
        } else {
            this.faceTextureGenerator.a(this.mFaceData.GetCustomBitmapFilePath());
        }
    }

    public void ReleaseBilateralFiltering() {
        Log.e(TAG, "[c] ReleaseBilateralFiltering()");
        if (this.faceTextureGenerator != null) {
            this.faceTextureGenerator.g();
            this.faceTextureGenerator = null;
            return;
        }
        Log.e(TAG, "[c] ERROR: ReleaseBilateralFiltering faceTextureGenerator == null!");
    }

    public void SetFittingAvatarData(b bVar) {
        this.mAvatarData = bVar;
    }

    public b GetFittingAvatarData() {
        return this.mAvatarData;
    }

    public void SetFittingAnimationData(a aVar) {
        this.mAnimationData = aVar;
    }

    public a GetFittingAnimationData() {
        return this.mAnimationData;
    }

    private static boolean CopyFile(File file, String str) {
        if (file == null || !file.exists()) {
            return false;
        }
        if (str != null && str.equals(file.getAbsolutePath())) {
            return true;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            byte[] bArr = new byte[FXUtil.MAX_CUSTOM_FACE_IMAGE_SIZE];
            while (true) {
                int read = fileInputStream.read(bArr, 0, FXUtil.MAX_CUSTOM_FACE_IMAGE_SIZE);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.close();
                    fileInputStream.close();
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x002e A[SYNTHETIC, Splitter:B:20:0x002e] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0034 A[SYNTHETIC, Splitter:B:24:0x0034] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean SavePNG(android.graphics.Bitmap r2, java.lang.String r3) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r3)
            r3 = 0
            r0.createNewFile()     // Catch:{ Exception -> 0x0027 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0027 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0027 }
            android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ Exception -> 0x0022, all -> 0x001f }
            r0 = 100
            r2.compress(r3, r0, r1)     // Catch:{ Exception -> 0x0022, all -> 0x001f }
            r2 = 1
            r1.close()     // Catch:{ IOException -> 0x001a }
            goto L_0x0031
        L_0x001a:
            r3 = move-exception
            r3.printStackTrace()
            goto L_0x0031
        L_0x001f:
            r2 = move-exception
            r3 = r1
            goto L_0x0032
        L_0x0022:
            r2 = move-exception
            r3 = r1
            goto L_0x0028
        L_0x0025:
            r2 = move-exception
            goto L_0x0032
        L_0x0027:
            r2 = move-exception
        L_0x0028:
            r2.printStackTrace()     // Catch:{ all -> 0x0025 }
            r2 = 0
            if (r3 == 0) goto L_0x0031
            r3.close()     // Catch:{ IOException -> 0x001a }
        L_0x0031:
            return r2
        L_0x0032:
            if (r3 == 0) goto L_0x003c
            r3.close()     // Catch:{ IOException -> 0x0038 }
            goto L_0x003c
        L_0x0038:
            r3 = move-exception
            r3.printStackTrace()
        L_0x003c:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.customface.CustomFaceInterface.SavePNG(android.graphics.Bitmap, java.lang.String):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x004e A[SYNTHETIC, Splitter:B:23:0x004e] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0059 A[SYNTHETIC, Splitter:B:28:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean SaveFeaturePosition(int[] r5, java.lang.String r6) {
        /*
            r0 = 0
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0048 }
            r2.<init>(r6)     // Catch:{ Exception -> 0x0048 }
            r2.createNewFile()     // Catch:{ Exception -> 0x0048 }
            int r6 = r5.length     // Catch:{ Exception -> 0x0048 }
            int r6 = r6 * 4
            java.nio.ByteBuffer r6 = java.nio.ByteBuffer.allocate(r6)     // Catch:{ Exception -> 0x0048 }
            java.nio.ByteOrder r3 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ Exception -> 0x0048 }
            java.nio.ByteBuffer r6 = r6.order(r3)     // Catch:{ Exception -> 0x0048 }
            java.nio.IntBuffer r3 = r6.asIntBuffer()     // Catch:{ Exception -> 0x0048 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0048 }
            r4.<init>(r2)     // Catch:{ Exception -> 0x0048 }
            r1 = 0
        L_0x0021:
            int r2 = r5.length     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
            if (r1 >= r2) goto L_0x002c
            r2 = r5[r1]     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
            r3.put(r2)     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
            int r1 = r1 + 1
            goto L_0x0021
        L_0x002c:
            byte[] r5 = r6.array()     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
            r4.write(r5)     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
            r6.clear()     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
            r4.close()     // Catch:{ IOException -> 0x003a }
            goto L_0x003e
        L_0x003a:
            r5 = move-exception
            r5.printStackTrace()
        L_0x003e:
            r0 = 1
            goto L_0x0056
        L_0x0040:
            r5 = move-exception
            r1 = r4
            goto L_0x0057
        L_0x0043:
            r5 = move-exception
            r1 = r4
            goto L_0x0049
        L_0x0046:
            r5 = move-exception
            goto L_0x0057
        L_0x0048:
            r5 = move-exception
        L_0x0049:
            r5.printStackTrace()     // Catch:{ all -> 0x0046 }
            if (r1 == 0) goto L_0x0056
            r1.close()     // Catch:{ IOException -> 0x0052 }
            goto L_0x0056
        L_0x0052:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0056:
            return r0
        L_0x0057:
            if (r1 == 0) goto L_0x0061
            r1.close()     // Catch:{ IOException -> 0x005d }
            goto L_0x0061
        L_0x005d:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0061:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.customface.CustomFaceInterface.SaveFeaturePosition(int[], java.lang.String):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0033 A[SYNTHETIC, Splitter:B:18:0x0033] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0046 A[SYNTHETIC, Splitter:B:27:0x0046] */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.nio.IntBuffer LoadFeaturePosition(java.lang.String r4) {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ Exception -> 0x002c, all -> 0x0027 }
            r1.<init>(r4)     // Catch:{ Exception -> 0x002c, all -> 0x0027 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x002c, all -> 0x0027 }
            r4.<init>(r1)     // Catch:{ Exception -> 0x002c, all -> 0x0027 }
            r1 = 168(0xa8, float:2.35E-43)
            byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x0025 }
            r4.read(r1)     // Catch:{ Exception -> 0x0025 }
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.wrap(r1)     // Catch:{ Exception -> 0x0025 }
            java.nio.ByteOrder r2 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ Exception -> 0x0025 }
            java.nio.ByteBuffer r1 = r1.order(r2)     // Catch:{ Exception -> 0x0025 }
            r4.close()     // Catch:{ IOException -> 0x0020 }
            goto L_0x003c
        L_0x0020:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x003c
        L_0x0025:
            r1 = move-exception
            goto L_0x002e
        L_0x0027:
            r4 = move-exception
            r3 = r0
            r0 = r4
            r4 = r3
            goto L_0x0044
        L_0x002c:
            r1 = move-exception
            r4 = r0
        L_0x002e:
            r1.printStackTrace()     // Catch:{ all -> 0x0043 }
            if (r4 == 0) goto L_0x003b
            r4.close()     // Catch:{ IOException -> 0x0037 }
            goto L_0x003b
        L_0x0037:
            r4 = move-exception
            r4.printStackTrace()
        L_0x003b:
            r1 = r0
        L_0x003c:
            if (r1 == 0) goto L_0x0042
            java.nio.IntBuffer r0 = r1.asIntBuffer()
        L_0x0042:
            return r0
        L_0x0043:
            r0 = move-exception
        L_0x0044:
            if (r4 == 0) goto L_0x004e
            r4.close()     // Catch:{ IOException -> 0x004a }
            goto L_0x004e
        L_0x004a:
            r4 = move-exception
            r4.printStackTrace()
        L_0x004e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.customface.CustomFaceInterface.LoadFeaturePosition(java.lang.String):java.nio.IntBuffer");
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\customface\d.java ==========

package net.fxgear.customface;

import net.fxgear.GlobalDefine;

/* compiled from: FaceParameters */
public class d {
    public static float A = 0.2f;
    public static float[] B = {4000.0f, 6600.0f, 15000.0f};
    public static float C = 20.0f;
    public static float D = 0.1f;
    public static String E = "1";
    public static int F = 2;

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f737a = {1161, 994, 938, 929, 467, 634, 411, 402, 1089, 562, 340, 294, 922, 395, 302, 311, 1255, 728, 1313, 786, 328};

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f738b = {1359, 1344, 1540, 1496, 203, 218, 399, 355, 1654, 513, 1056, 1043, 1809, 668, 1037, 1022, 1324, 183, 1893, 752, 1028};
    public static final int[] c = {2200, 2331, 1584, 1580, 871, 735, 79, 75, 2385, 926, 758, 1072, 2582, 1148, 1181, 1257, 1838, 348, 2051, 579, 1076};
    public static float[] d = {-3.0f, 158.8f, 11.2f};
    public static float[] e = {3.0f, 158.8f, 11.2f};
    public static float[] f = {GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 152.0f, 11.8f};
    public static float[] g = {GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 158.5f, 13.0f};
    public static float[] h = {-3.0f, 158.6f, 10.4f};
    public static float[] i = {3.0f, 158.6f, 10.4f};
    public static float[] j = {GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 152.0f, 10.8f};
    public static float[] k = {GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 158.5f, 11.5f};
    public static float[] l = {-2.476f, 93.473f, 8.602f};
    public static float[] m = {2.476f, 93.473f, 8.602f};
    public static float[] n = {GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 88.241f, 9.533f};
    public static float[] o = {GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 92.145f, 9.733f};
    public static final int[] p = {36, 39, 37, 38, 40, 41};
    public static final int[] q = {42, 45, 43, 44, 46, 47};
    public static final int[] r = {31, 35, 27, 33};
    public static final int[] s = {48, 54, 51, 57};
    public static final int[] t = {0, 16, 4, 12, 8};
    public static final float[] u = {1.2f, 2.0f};
    public static final float[] v = {600.0f, 600.0f};
    public static float w = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    public static float x;
    public static float[] y = {0.02f, 1.0f};
    public static float[] z = {0.02f, 1.0f};
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\customface\DetectCustomFacePoints.java ==========

package net.fxgear.customface;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class DetectCustomFacePoints {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f714a = "DetectCustomFacePoints";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static Handler f715b = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            a aVar;
            if (message != null && message.what == 100 && (aVar = (a) message.obj) != null) {
                int i = message.arg1;
                if (i == -1) {
                    if (aVar.f != null) {
                        aVar.f.OnFinishToDetectCustomFace(aVar.f718a, aVar.f719b, aVar.c, aVar.d);
                        aVar.f = null;
                    }
                } else if (aVar.f != null) {
                    aVar.f.OnErrorToDetectCustomFace(i, aVar.e);
                    aVar.f = null;
                }
            }
        }
    };

    public interface OnDetectCustomFaceListener {
        void OnErrorToDetectCustomFace(int i, Object obj);

        void OnFinishToDetectCustomFace(String str, int[] iArr, float[] fArr, int i);

        void OnStartToDetectCustomFace();
    }

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        String f718a;

        /* renamed from: b  reason: collision with root package name */
        int[] f719b;
        float[] c;
        int d;
        Object e;
        OnDetectCustomFaceListener f;

        private a() {
            this.f718a = null;
            this.f719b = null;
            this.c = null;
            this.d = 0;
            this.e = null;
            this.f = null;
        }
    }

    public static class DetectFacePointsThread extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private Context f716a;

        /* renamed from: b  reason: collision with root package name */
        private String f717b;
        private int c;
        private int d;
        private int e;
        private OnDetectCustomFaceListener f;

        public DetectFacePointsThread(Context context, String str, int i, int i2, int i3, OnDetectCustomFaceListener onDetectCustomFaceListener) {
            this.f716a = context;
            this.f717b = str;
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = onDetectCustomFaceListener;
        }

        /* JADX WARNING: Removed duplicated region for block: B:162:0x025c  */
        /* JADX WARNING: Removed duplicated region for block: B:163:0x025e  */
        /* JADX WARNING: Removed duplicated region for block: B:166:0x0266  */
        /* JADX WARNING: Removed duplicated region for block: B:180:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x00dd A[SYNTHETIC, Splitter:B:55:0x00dd] */
        /* JADX WARNING: Removed duplicated region for block: B:76:0x0118 A[Catch:{ OutOfMemoryError -> 0x021c }] */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x0126 A[Catch:{ OutOfMemoryError -> 0x021c }] */
        /* JADX WARNING: Removed duplicated region for block: B:82:0x013b A[Catch:{ OutOfMemoryError -> 0x021c }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r15 = this;
                java.lang.String r0 = r15.f717b
                r1 = 18
                r2 = -1
                r3 = 0
                r4 = 0
                if (r0 == 0) goto L_0x0248
                int r0 = r15.c     // Catch:{ OutOfMemoryError -> 0x0221 }
                if (r0 == 0) goto L_0x001a
                java.lang.String r0 = r15.f717b     // Catch:{ OutOfMemoryError -> 0x0221 }
                android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeFile(r0)     // Catch:{ OutOfMemoryError -> 0x0221 }
                int r5 = r15.c     // Catch:{ OutOfMemoryError -> 0x0221 }
                android.graphics.Bitmap r0 = net.fxgear.customface.BitmapUtil.GetRotatedBitmap(r0, r5)     // Catch:{ OutOfMemoryError -> 0x0221 }
                goto L_0x0020
            L_0x001a:
                java.lang.String r0 = r15.f717b     // Catch:{ OutOfMemoryError -> 0x0221 }
                android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeFile(r0)     // Catch:{ OutOfMemoryError -> 0x0221 }
            L_0x0020:
                java.io.File r5 = new java.io.File     // Catch:{ OutOfMemoryError -> 0x021c }
                java.io.File r6 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ OutOfMemoryError -> 0x021c }
                java.lang.String r7 = "FACE_TEMP"
                r5.<init>(r6, r7)     // Catch:{ OutOfMemoryError -> 0x021c }
                boolean r6 = r5.exists()     // Catch:{ OutOfMemoryError -> 0x021c }
                if (r6 == 0) goto L_0x0038
                java.lang.String r5 = r5.getAbsolutePath()     // Catch:{ OutOfMemoryError -> 0x021c }
                net.fxgear.GlobalDefine.DeleteDirectoryRecursive(r5)     // Catch:{ OutOfMemoryError -> 0x021c }
            L_0x0038:
                java.io.File r5 = new java.io.File     // Catch:{ OutOfMemoryError -> 0x021c }
                android.content.Context r6 = r15.f716a     // Catch:{ OutOfMemoryError -> 0x021c }
                java.io.File r6 = net.fxgear.GlobalDefine.GetRootDirectory(r6)     // Catch:{ OutOfMemoryError -> 0x021c }
                java.lang.String r7 = "FACE_TEMP"
                r5.<init>(r6, r7)     // Catch:{ OutOfMemoryError -> 0x021c }
                boolean r6 = r5.exists()     // Catch:{ OutOfMemoryError -> 0x021c }
                if (r6 != 0) goto L_0x004e
                r5.mkdirs()     // Catch:{ OutOfMemoryError -> 0x021c }
            L_0x004e:
                java.io.File r6 = r5.getAbsoluteFile()     // Catch:{ OutOfMemoryError -> 0x021c }
                long r6 = net.fxgear.util.FXUtil.GetAvailableSpaceSize(r6)     // Catch:{ OutOfMemoryError -> 0x021c }
                int r8 = net.fxgear.customface.BitmapUtil.GetBitmapFileSize(r0)     // Catch:{ OutOfMemoryError -> 0x021c }
                long r8 = (long) r8     // Catch:{ OutOfMemoryError -> 0x021c }
                r10 = 4
                int r11 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
                if (r11 > 0) goto L_0x0204
                if (r0 == 0) goto L_0x006b
                int r6 = r0.getWidth()     // Catch:{ OutOfMemoryError -> 0x021c }
                int r7 = r0.getHeight()     // Catch:{ OutOfMemoryError -> 0x021c }
                goto L_0x006d
            L_0x006b:
                r6 = 0
                r7 = 0
            L_0x006d:
                r8 = 1024(0x400, float:1.435E-42)
                int r8 = net.fxgear.util.FXUtil.CalculateRatioForCustomFaceImage(r6, r7, r8, r8)     // Catch:{ OutOfMemoryError -> 0x021c }
                r9 = 1
                if (r8 <= r9) goto L_0x010a
                int r6 = r6 / r8
                int r7 = r7 / r8
                android.graphics.Bitmap r6 = android.graphics.Bitmap.createScaledBitmap(r0, r6, r7, r9)     // Catch:{ Exception -> 0x00cc, all -> 0x00c8 }
                java.io.File r7 = new java.io.File     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
                java.lang.String r9 = "FACE_TEMP"
                r7.<init>(r5, r9)     // Catch:{ Exception -> 0x00c5, all -> 0x00c2 }
                boolean r9 = r7.exists()     // Catch:{ Exception -> 0x00c0 }
                if (r9 == 0) goto L_0x008c
                r7.delete()     // Catch:{ Exception -> 0x00c0 }
            L_0x008c:
                java.lang.String r9 = r7.getAbsolutePath()     // Catch:{ Exception -> 0x00c0 }
                boolean r9 = net.fxgear.customface.BitmapUtil.save(r6, r9)     // Catch:{ Exception -> 0x00c0 }
                if (r9 == 0) goto L_0x00a1
                android.content.Context r9 = r15.f716a     // Catch:{ Exception -> 0x00c0 }
                int r11 = r15.d     // Catch:{ Exception -> 0x00c0 }
                int r12 = r15.e     // Catch:{ Exception -> 0x00c0 }
                int[] r9 = net.fxgear.util.FXUtil.GetFaceAreaDetecPositions(r9, r7, r11, r12)     // Catch:{ Exception -> 0x00c0 }
                goto L_0x00ab
            L_0x00a1:
                java.lang.String r9 = net.fxgear.customface.DetectCustomFacePoints.f714a     // Catch:{ Exception -> 0x00c0 }
                java.lang.String r11 = "[ERROR] :: mThread - fail to save resized bitmap"
                android.util.Log.e(r9, r11)     // Catch:{ Exception -> 0x00c0 }
                r9 = r4
            L_0x00ab:
                if (r6 == 0) goto L_0x00b6
                boolean r11 = r6.isRecycled()     // Catch:{ OutOfMemoryError -> 0x021c }
                if (r11 != 0) goto L_0x00b6
                r6.recycle()     // Catch:{ OutOfMemoryError -> 0x021c }
            L_0x00b6:
                boolean r6 = r7.exists()     // Catch:{ OutOfMemoryError -> 0x021c }
                if (r6 == 0) goto L_0x010b
                r7.delete()     // Catch:{ OutOfMemoryError -> 0x021c }
                goto L_0x010b
            L_0x00c0:
                r9 = move-exception
                goto L_0x00cf
            L_0x00c2:
                r5 = move-exception
                r7 = r4
                goto L_0x00f3
            L_0x00c5:
                r9 = move-exception
                r7 = r4
                goto L_0x00cf
            L_0x00c8:
                r5 = move-exception
                r6 = r4
                r7 = r6
                goto L_0x00f3
            L_0x00cc:
                r9 = move-exception
                r6 = r4
                r7 = r6
            L_0x00cf:
                java.lang.String r11 = net.fxgear.customface.DetectCustomFacePoints.f714a     // Catch:{ all -> 0x00f2 }
                java.lang.String r12 = "[ERROR] :: mThread - resize image exception"
                android.util.Log.e(r11, r12)     // Catch:{ all -> 0x00f2 }
                r9.printStackTrace()     // Catch:{ all -> 0x00f2 }
                if (r6 == 0) goto L_0x00e6
                boolean r9 = r6.isRecycled()     // Catch:{ OutOfMemoryError -> 0x021c }
                if (r9 != 0) goto L_0x00e6
                r6.recycle()     // Catch:{ OutOfMemoryError -> 0x021c }
            L_0x00e6:
                if (r7 == 0) goto L_0x010a
                boolean r6 = r7.exists()     // Catch:{ OutOfMemoryError -> 0x021c }
                if (r6 == 0) goto L_0x010a
                r7.delete()     // Catch:{ OutOfMemoryError -> 0x021c }
                goto L_0x010a
            L_0x00f2:
                r5 = move-exception
            L_0x00f3:
                if (r6 == 0) goto L_0x00fe
                boolean r8 = r6.isRecycled()     // Catch:{ OutOfMemoryError -> 0x021c }
                if (r8 != 0) goto L_0x00fe
                r6.recycle()     // Catch:{ OutOfMemoryError -> 0x021c }
            L_0x00fe:
                if (r7 == 0) goto L_0x0109
                boolean r6 = r7.exists()     // Catch:{ OutOfMemoryError -> 0x021c }
                if (r6 == 0) goto L_0x0109
                r7.delete()     // Catch:{ OutOfMemoryError -> 0x021c }
            L_0x0109:
                throw r5     // Catch:{ OutOfMemoryError -> 0x021c }
            L_0x010a:
                r9 = r4
            L_0x010b:
                java.io.File r6 = new java.io.File     // Catch:{ OutOfMemoryError -> 0x021c }
                java.lang.String r7 = "temp_bitmap.bmp"
                r6.<init>(r5, r7)     // Catch:{ OutOfMemoryError -> 0x021c }
                boolean r5 = r6.exists()     // Catch:{ OutOfMemoryError -> 0x021c }
                if (r5 == 0) goto L_0x011b
                r6.delete()     // Catch:{ OutOfMemoryError -> 0x021c }
            L_0x011b:
                java.lang.Thread r5 = java.lang.Thread.currentThread()     // Catch:{ OutOfMemoryError -> 0x021c }
                boolean r5 = r5.isInterrupted()     // Catch:{ OutOfMemoryError -> 0x021c }
                r7 = -2
                if (r5 == 0) goto L_0x013b
                java.lang.String r5 = net.fxgear.customface.DetectCustomFacePoints.f714a     // Catch:{ OutOfMemoryError -> 0x021c }
                java.lang.String r6 = "customFaceWorker cancel"
                android.util.Log.d(r5, r6)     // Catch:{ OutOfMemoryError -> 0x021c }
                net.fxgear.customface.DetectCustomFacePoints$OnDetectCustomFaceListener r5 = r15.f     // Catch:{ OutOfMemoryError -> 0x021c }
                if (r5 == 0) goto L_0x013a
                net.fxgear.customface.DetectCustomFacePoints$OnDetectCustomFaceListener r5 = r15.f     // Catch:{ OutOfMemoryError -> 0x021c }
                r5.OnErrorToDetectCustomFace(r7, r4)     // Catch:{ OutOfMemoryError -> 0x021c }
                r15.f = r4     // Catch:{ OutOfMemoryError -> 0x021c }
            L_0x013a:
                return
            L_0x013b:
                java.lang.String r5 = r6.getAbsolutePath()     // Catch:{ OutOfMemoryError -> 0x021c }
                boolean r11 = net.fxgear.customface.BitmapUtil.save(r0, r5)     // Catch:{ OutOfMemoryError -> 0x01fd }
                if (r11 == 0) goto L_0x01d7
                if (r9 == 0) goto L_0x0153
                r11 = 0
            L_0x0148:
                if (r11 >= r10) goto L_0x0153
                r12 = r9[r11]     // Catch:{ OutOfMemoryError -> 0x01fd }
                int r12 = r12 * r8
                r9[r11] = r12     // Catch:{ OutOfMemoryError -> 0x01fd }
                int r11 = r11 + 1
                goto L_0x0148
            L_0x0153:
                android.content.Context r8 = r15.f716a     // Catch:{ OutOfMemoryError -> 0x01fd }
                int r10 = r15.d     // Catch:{ OutOfMemoryError -> 0x01fd }
                int r11 = r15.e     // Catch:{ OutOfMemoryError -> 0x01fd }
                int[] r8 = net.fxgear.util.FXUtil.GetFaceDetectPositions(r8, r6, r10, r11, r9)     // Catch:{ OutOfMemoryError -> 0x01fd }
                float[] r9 = net.fxgear.customface.CustomFaceInterface.GetFaceAngle()     // Catch:{ OutOfMemoryError -> 0x01d3 }
                int r10 = net.fxgear.customface.CustomFaceInterface.GetCroppedFaceAreaPercent()     // Catch:{ OutOfMemoryError -> 0x01d0 }
                int r11 = net.fxgear.customface.CustomFaceInterface.GetFaceTrackingResult()     // Catch:{ OutOfMemoryError -> 0x01c8 }
                java.lang.Thread r12 = java.lang.Thread.currentThread()     // Catch:{ OutOfMemoryError -> 0x01c6 }
                boolean r12 = r12.isInterrupted()     // Catch:{ OutOfMemoryError -> 0x01c6 }
                if (r12 == 0) goto L_0x0191
                java.lang.String r3 = net.fxgear.customface.DetectCustomFacePoints.f714a     // Catch:{ OutOfMemoryError -> 0x01c6 }
                java.lang.String r12 = "customFaceWorker cancel"
                android.util.Log.d(r3, r12)     // Catch:{ OutOfMemoryError -> 0x01c6 }
                boolean r3 = r6.exists()     // Catch:{ OutOfMemoryError -> 0x01c6 }
                if (r3 == 0) goto L_0x0185
                r6.delete()     // Catch:{ OutOfMemoryError -> 0x01c6 }
            L_0x0185:
                net.fxgear.customface.DetectCustomFacePoints$OnDetectCustomFaceListener r3 = r15.f     // Catch:{ OutOfMemoryError -> 0x01c6 }
                if (r3 == 0) goto L_0x0190
                net.fxgear.customface.DetectCustomFacePoints$OnDetectCustomFaceListener r3 = r15.f     // Catch:{ OutOfMemoryError -> 0x01c6 }
                r3.OnErrorToDetectCustomFace(r7, r4)     // Catch:{ OutOfMemoryError -> 0x01c6 }
                r15.f = r4     // Catch:{ OutOfMemoryError -> 0x01c6 }
            L_0x0190:
                return
            L_0x0191:
                if (r8 == 0) goto L_0x01b4
                int r7 = r8.length     // Catch:{ OutOfMemoryError -> 0x01c6 }
                r12 = 0
            L_0x0195:
                if (r3 >= r7) goto L_0x01a0
                r13 = r8[r3]     // Catch:{ OutOfMemoryError -> 0x01c6 }
                if (r13 != 0) goto L_0x019d
                int r12 = r12 + 1
            L_0x019d:
                int r3 = r3 + 1
                goto L_0x0195
            L_0x01a0:
                int r3 = r8.length     // Catch:{ OutOfMemoryError -> 0x01c6 }
                if (r12 >= r3) goto L_0x01a5
                r3 = -1
                goto L_0x01b0
            L_0x01a5:
                java.lang.String r3 = net.fxgear.customface.DetectCustomFacePoints.f714a     // Catch:{ OutOfMemoryError -> 0x01c6 }
                java.lang.String r7 = "[ERROR] :: face detect error in faceArea."
                android.util.Log.e(r3, r7)     // Catch:{ OutOfMemoryError -> 0x01c6 }
                r3 = 20
            L_0x01b0:
                r14 = r10
                r10 = r3
                r3 = r14
                goto L_0x01e7
            L_0x01b4:
                if (r8 != 0) goto L_0x01c3
                java.lang.String r3 = net.fxgear.customface.DetectCustomFacePoints.f714a     // Catch:{ OutOfMemoryError -> 0x01c6 }
                java.lang.String r7 = "[ERROR] :: face detect error."
                android.util.Log.e(r3, r7)     // Catch:{ OutOfMemoryError -> 0x01c6 }
                r3 = r10
                r10 = 18
                goto L_0x01e7
            L_0x01c3:
                r3 = r10
                r10 = 0
                goto L_0x01e7
            L_0x01c6:
                r3 = move-exception
                goto L_0x01ca
            L_0x01c8:
                r3 = move-exception
                r11 = -1
            L_0x01ca:
                r14 = r3
                r3 = r0
                r0 = r5
                r5 = r14
                goto L_0x0229
            L_0x01d0:
                r6 = move-exception
                r3 = r0
                goto L_0x0201
            L_0x01d3:
                r6 = move-exception
                r3 = r0
                r9 = r4
                goto L_0x0201
            L_0x01d7:
                java.lang.String r7 = net.fxgear.customface.DetectCustomFacePoints.f714a     // Catch:{ OutOfMemoryError -> 0x01fd }
                java.lang.String r8 = "[ERROR] :: fail to save bitmap file."
                android.util.Log.e(r7, r8)     // Catch:{ OutOfMemoryError -> 0x01fd }
                r7 = 17
                r8 = r4
                r9 = r8
                r10 = 17
                r11 = -1
            L_0x01e7:
                if (r10 == r2) goto L_0x01f9
                boolean r7 = r6.exists()     // Catch:{ OutOfMemoryError -> 0x01f3 }
                if (r7 == 0) goto L_0x01f9
                r6.delete()     // Catch:{ OutOfMemoryError -> 0x01f3 }
                goto L_0x01f9
            L_0x01f3:
                r6 = move-exception
                r10 = r3
                r3 = r0
                r0 = r5
                r5 = r6
                goto L_0x0229
            L_0x01f9:
                r6 = r3
                r3 = r5
                r5 = r4
                goto L_0x0218
            L_0x01fd:
                r6 = move-exception
                r3 = r0
                r8 = r4
                r9 = r8
            L_0x0201:
                r0 = r5
                r5 = r6
                goto L_0x0227
            L_0x0204:
                java.lang.String r5 = net.fxgear.customface.DetectCustomFacePoints.f714a     // Catch:{ OutOfMemoryError -> 0x021c }
                java.lang.String r11 = "[ERROR] :: There is No enough space for saving."
                android.util.Log.e(r5, r11)     // Catch:{ OutOfMemoryError -> 0x021c }
                r5 = 0
                long r8 = r8 - r6
                java.lang.Long r5 = java.lang.Long.valueOf(r8)     // Catch:{ OutOfMemoryError -> 0x021c }
                r3 = r4
                r8 = r3
                r9 = r8
                r6 = 0
                r11 = -1
            L_0x0218:
                r14 = r10
                r10 = r6
                r6 = r14
                goto L_0x023b
            L_0x021c:
                r5 = move-exception
                r3 = r0
                r0 = r4
                r8 = r0
                goto L_0x0226
            L_0x0221:
                r0 = move-exception
                r5 = r0
                r0 = r4
                r3 = r0
                r8 = r3
            L_0x0226:
                r9 = r8
            L_0x0227:
                r10 = 0
                r11 = -1
            L_0x0229:
                java.lang.String r6 = net.fxgear.customface.DetectCustomFacePoints.f714a
                java.lang.String r7 = "[ERRPR] :: OutOfMemoryError"
                android.util.Log.e(r6, r7)
                r6 = 15
                r5.printStackTrace()
                r5 = r4
                r14 = r3
                r3 = r0
                r0 = r14
            L_0x023b:
                if (r0 == 0) goto L_0x0246
                boolean r7 = r0.isRecycled()
                if (r7 != 0) goto L_0x0246
                r0.recycle()
            L_0x0246:
                r0 = r6
                goto L_0x0259
            L_0x0248:
                java.lang.String r0 = net.fxgear.customface.DetectCustomFacePoints.f714a
                java.lang.String r5 = "[ERROR] :: Not found imageFile."
                android.util.Log.e(r0, r5)
                r0 = 16
                r3 = r4
                r5 = r3
                r8 = r5
                r9 = r8
                r10 = 0
                r11 = -1
            L_0x0259:
                switch(r11) {
                    case -2: goto L_0x025e;
                    case -1: goto L_0x0260;
                    default: goto L_0x025c;
                }
            L_0x025c:
                r1 = r0
                goto L_0x0260
            L_0x025e:
                r1 = 19
            L_0x0260:
                android.os.Handler r0 = net.fxgear.customface.DetectCustomFacePoints.f715b
                if (r0 == 0) goto L_0x02a8
                android.os.Message r0 = new android.os.Message
                r0.<init>()
                r6 = 100
                r0.what = r6
                r0.arg1 = r1
                net.fxgear.customface.DetectCustomFacePoints$a r6 = new net.fxgear.customface.DetectCustomFacePoints$a
                r6.<init>()
                net.fxgear.customface.DetectCustomFacePoints$OnDetectCustomFaceListener r4 = r15.f
                r6.f = r4
                if (r1 != r2) goto L_0x0285
                r6.f718a = r3
                r6.f719b = r8
                r6.c = r9
                r6.d = r10
                goto L_0x029f
            L_0x0285:
                java.lang.String r2 = net.fxgear.customface.DetectCustomFacePoints.f714a
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                java.lang.String r4 = "[ERROR] :: resultCode: "
                r3.append(r4)
                r3.append(r1)
                java.lang.String r1 = r3.toString()
                android.util.Log.e(r2, r1)
                r6.e = r5
            L_0x029f:
                r0.obj = r6
                android.os.Handler r1 = net.fxgear.customface.DetectCustomFacePoints.f715b
                r1.sendMessage(r0)
            L_0x02a8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.fxgear.customface.DetectCustomFacePoints.DetectFacePointsThread.run():void");
        }

        public synchronized void start() {
            super.start();
            if (this.f != null) {
                this.f.OnStartToDetectCustomFace();
            }
        }

        public void interrupt() {
            super.interrupt();
            if (DetectCustomFacePoints.f715b != null) {
                DetectCustomFacePoints.f715b.removeCallbacksAndMessages((Object) null);
                Handler unused = DetectCustomFacePoints.f715b = null;
            }
            this.f717b = null;
            this.f716a = null;
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\customface\e.java ==========

package net.fxgear.customface;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLES20;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import net.fxgear.GlobalDefine;
import net.fxgear.customface.b;
import net.fxgear.fittingview.data.FittingFaceData;
import net.fxgear.util.FXUtil;

/* compiled from: FaceTextureGenerator */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f739a = "e";
    private boolean A = false;
    private boolean B = false;
    private b.C0024b C = new b.C0024b();
    private short[] D = new short[0];

    /* renamed from: b  reason: collision with root package name */
    private a f740b;
    private b.C0024b c = new b.C0024b();
    private int[] d = new int[1];
    private int[] e = new int[1];
    private int[] f = new int[1];
    private l g;
    private int h = FXUtil.MAX_CUSTOM_FACE_IMAGE_SIZE;
    private int i = 512;
    private int j = 64;
    private ByteBuffer k = null;
    private float l = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    private Bitmap m;
    private Bitmap n;
    private Bitmap o;
    private Bitmap p;
    private Bitmap q;
    private Bitmap r;
    private j s = null;
    private j t = null;
    private j u = null;
    private j v = null;
    private j w = null;
    private j x = null;
    private j y = null;
    private j z = null;

    public e(a aVar) {
        this.d[0] = -1;
        this.e[0] = -1;
        this.f[0] = -1;
        this.f740b = aVar;
    }

    public void a() {
        this.c.f725a = new float[this.f740b.i().f725a.length];
        this.c.c = new float[this.f740b.i().c.length];
        this.c.d = new short[this.f740b.i().d.length];
        if (this.B) {
            this.C.f725a = new float[this.f740b.i().f725a.length];
            this.C.d = new short[(this.D.length * 3)];
        }
        this.k = ByteBuffer.allocateDirect(this.h * this.h * 4);
        this.g = new l();
        this.m = this.f740b.m();
        this.n = Bitmap.createBitmap(this.h, this.h, Bitmap.Config.ARGB_8888);
        this.r = Bitmap.createBitmap(this.h, this.h, Bitmap.Config.ARGB_8888);
        this.o = Bitmap.createScaledBitmap(this.m, this.i, this.i, true);
        this.q = Bitmap.createScaledBitmap(this.f740b.n(), this.i, this.i, false);
        this.s = k.a(this.f740b.m());
        this.t = k.a(this.f740b.n());
        this.v = k.a(this.f740b.o());
        this.w = k.a(this.f740b.p());
    }

    public void a(float[] fArr) {
        float f2 = d.v[0];
        float f3 = d.v[1];
        int[] k2 = this.f740b.k();
        float[] fArr2 = this.f740b.i().c;
        for (int i2 = 0; i2 < this.f740b.i().c.length / 2; i2++) {
            int i3 = i2 * 2;
            int i4 = i3 + 0;
            int i5 = k2[i2] * 3;
            this.c.c[i4] = fArr[i5 + 0] / f2;
            int i6 = i3 + 1;
            this.c.c[i6] = 1.0f - (fArr[i5 + 1] / f3);
            int i7 = i2 * 3;
            this.c.f725a[i7 + 0] = (fArr2[i4] - 0.5f) * 2.0f;
            this.c.f725a[i7 + 1] = (0.5f - fArr2[i6]) * 2.0f;
            this.c.f725a[i7 + 2] = 0.0f;
        }
        for (int i8 = 0; i8 < this.f740b.i().d.length; i8++) {
            this.c.d[i8] = this.f740b.i().d[i8];
        }
    }

    public void b() {
        float[] fArr = this.f740b.i().c;
        for (int i2 = 0; i2 < this.f740b.i().c.length / 2; i2++) {
            int i3 = i2 * 3;
            int i4 = i2 * 2;
            this.C.f725a[i3 + 0] = (fArr[i4 + 0] - 0.5f) * 2.0f;
            this.C.f725a[i3 + 1] = (0.5f - fArr[i4 + 1]) * 2.0f;
            this.C.f725a[i3 + 2] = 0.0f;
        }
        for (int i5 = 0; i5 < this.D.length; i5++) {
            int i6 = i5 * 3;
            this.C.d[i6 + 0] = this.f740b.i().d[(this.D[i5] * 3) + 0];
            this.C.d[i6 + 1] = this.f740b.i().d[(this.D[i5] * 3) + 1];
            this.C.d[i6 + 2] = this.f740b.i().d[(this.D[i5] * 3) + 2];
        }
        GLES20.glBindFramebuffer(36160, this.d[0]);
        GLES20.glViewport(0, 0, this.h, this.h);
        GLES20.glClearColor(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f);
        GLES20.glClear(16640);
        GLES20.glDisable(2929);
        this.g.c().a(this.C);
        this.g.c().a();
        this.k.position(0);
        GLES20.glReadPixels(0, 0, this.h, this.h, 6408, 5121, this.k);
        this.n.copyPixelsFromBuffer(this.k);
        GLES20.glEnable(2929);
        GLES20.glBindFramebuffer(36160, 0);
    }

    public void a(j jVar) {
        GLES20.glBindFramebuffer(36160, this.d[0]);
        GLES20.glViewport(0, 0, this.h, this.h);
        GLES20.glClearColor(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f);
        GLES20.glClear(16640);
        GLES20.glDisable(2929);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        this.g.a().a();
        this.g.a().a(this.s, this.t, 0);
        this.g.a().b();
        this.g.a().a(this.c);
        this.g.a().a(jVar, this.t, 0);
        this.g.a().b();
        GLES20.glDisable(3042);
        this.g.a().a();
        this.g.a().a(this.s, this.t, 1);
        this.g.a().b();
        this.k.position(0);
        GLES20.glReadPixels(0, 0, this.h, this.h, 6408, 5121, this.k);
        this.n.copyPixelsFromBuffer(this.k);
        GLES20.glEnable(2929);
        GLES20.glBindFramebuffer(36160, 0);
    }

    public void a(Bitmap bitmap, Bitmap bitmap2) {
        GLES20.glBindFramebuffer(36160, this.d[0]);
        GLES20.glViewport(0, 0, this.h, this.h);
        GLES20.glClearColor(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f);
        GLES20.glClear(16640);
        GLES20.glDisable(2929);
        this.x = k.a(bitmap);
        this.y = k.a(bitmap2);
        this.u = k.a(this.n);
        this.g.b().a(d.y, this.l);
        this.g.b().a(this.x, this.y, this.u, this.t, this.s, this.v, this.w);
        this.g.b().a();
        this.k.position(0);
        GLES20.glReadPixels(0, 0, this.h, this.h, 6408, 5121, this.k);
        this.n.copyPixelsFromBuffer(this.k);
        GLES20.glEnable(2929);
        GLES20.glBindFramebuffer(36160, 0);
    }

    public void c() {
        int[] iArr = new int[(this.i * this.i)];
        int[] iArr2 = new int[(this.i * this.i)];
        int[] iArr3 = new int[(this.i * this.i)];
        this.p = Bitmap.createScaledBitmap(this.n, this.i, this.i, true);
        this.p.getPixels(iArr, 0, this.i, 0, 0, this.i, this.i);
        this.o.getPixels(iArr2, 0, this.i, 0, 0, this.i, this.i);
        this.q.getPixels(iArr3, 0, this.i, 0, 0, this.i, this.i);
        Bitmap createBitmap = Bitmap.createBitmap(CustomFaceInterface.modPoissonBlendingJNI(iArr, iArr2, iArr3, this.i, this.i), this.i, this.i, Bitmap.Config.ARGB_8888);
        a(iArr, iArr3);
        Log.v("", "#####---  MODIFIED POISSON COMPLETED");
        a(this.p, createBitmap);
        Log.v("", "#####---  RESIZING COMPLETED");
        this.p.recycle();
        this.p = null;
        this.o.recycle();
        this.o = null;
        this.q.recycle();
        this.q = null;
        createBitmap.recycle();
    }

    public void b(j jVar) {
        GLES20.glBindFramebuffer(36160, this.d[0]);
        GLES20.glViewport(0, 0, this.h, this.h);
        GLES20.glClearColor(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f);
        GLES20.glClear(16640);
        GLES20.glDisable(2929);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        this.g.a().a();
        this.g.a().a(this.s, this.t, 0);
        this.g.a().b();
        this.g.a().a(this.c);
        this.g.a().a(jVar, this.t, 0);
        this.g.a().b();
        this.k.position(0);
        GLES20.glReadPixels(0, 0, this.h, this.h, 6408, 5121, this.k);
        this.n.copyPixelsFromBuffer(this.k);
        GLES20.glEnable(2929);
        GLES20.glBindFramebuffer(36160, 0);
        if (jVar != null) {
            jVar.a();
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(this.n, this.j, this.j, true);
        GLES20.glBindFramebuffer(36160, this.d[0]);
        GLES20.glViewport(0, 0, this.h, this.h);
        GLES20.glClearColor(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f);
        GLES20.glClear(16640);
        GLES20.glDisable(2929);
        this.x = k.a(createScaledBitmap);
        this.u = k.a(this.n);
        this.g.e().a(this.x, this.u, this.s, this.t, this.w);
        this.g.e().a();
        this.k.position(0);
        GLES20.glReadPixels(0, 0, this.h, this.h, 6408, 5121, this.k);
        this.n.copyPixelsFromBuffer(this.k);
        GLES20.glEnable(2929);
        GLES20.glBindFramebuffer(36160, 0);
        createScaledBitmap.recycle();
        if (this.u != null) {
            this.u.a();
            this.u = null;
        }
        if (this.x != null) {
            this.x.a();
            this.x = null;
        }
        Log.v("", "#####---  SimplePoissonBlending completed.");
    }

    public void a(j jVar, float[] fArr) {
        if (this.B) {
            b();
        }
        a(fArr);
        Log.v("", "#####----   PROJECTION TEX COORD COMPLETED");
        a(jVar);
        Log.v("", "#####--------   FACEOFF TEXTURE GENERATION COMPLETED");
        c();
        Log.v("", "#####------------   POISSON BLENDING COMPLETED");
        this.r = this.n;
        a(this.r, this.f740b.a());
        Log.v("", "#####----------------   BILATERAL FILTERING NOT YET COMPLETED");
    }

    public void b(j jVar, float[] fArr) {
        a(fArr);
        Log.v("", "#####----   PROJECTION TEX COORD COMPLETED");
        b(jVar);
        Log.v("", "#####------------   POISSON BLENDING COMPLETED");
        this.r = this.n;
        a(this.r, this.f740b.a());
    }

    public void a(int[] iArr, int[] iArr2) {
        float[] fArr = new float[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (((iArr2[i2] & 16711680) >> 16) == 255) {
                fArr[i2] = (((float) ((((iArr[i2] & 16711680) >> 16) + ((iArr[i2] & 65280) >> 8)) + (255 & iArr[i2]))) / 3.0f) / 255.0f;
            } else {
                fArr[i2] = -1.0f;
            }
        }
        int i3 = 0;
        float f2 = 1.0f;
        float f3 = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        while (i3 < 3) {
            float f4 = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            int i4 = 0;
            float f5 = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            for (int i5 = 0; i5 < iArr.length; i5++) {
                if (fArr[i5] >= GlobalDefine.DEFAULT_AUTO_FILTER_VALUE && fArr[i5] < f2 - f3) {
                    f4 += fArr[i5];
                    f5 += fArr[i5] * fArr[i5];
                    i4++;
                }
            }
            float f6 = (float) i4;
            float f7 = f4 / f6;
            i3++;
            float f8 = f7;
            f3 = (float) Math.sqrt((double) ((f5 / f6) - (f7 * f7)));
            f2 = f8;
        }
        this.l = f2;
        Log.v("", "#######  -------------------------  low intensity average = " + this.l);
    }

    public void d() {
        a(this.d, this.e, this.f, this.h);
    }

    public void a(int[] iArr, int[] iArr2, int[] iArr3, int i2) {
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLES20.glGenRenderbuffers(1, iArr2, 0);
        GLES20.glGenTextures(1, iArr3, 0);
        GLES20.glBindTexture(3553, iArr3[0]);
        GLES20.glTexImage2D(3553, 0, 6407, i2, i2, 0, 6407, 5121, (Buffer) null);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glBindFramebuffer(36160, iArr[0]);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, iArr3[0], 0);
        if (GLES20.glCheckFramebufferStatus(36160) == 36053) {
            Log.v("", "########  fbo success ");
        }
        GLES20.glBindFramebuffer(36160, 0);
    }

    public void a(Bitmap bitmap, String str) {
        File file = new File(str);
        FileOutputStream fileOutputStream = null;
        try {
            file.createNewFile();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream2);
            } catch (Exception e2) {
                e = e2;
                fileOutputStream = fileOutputStream2;
                try {
                    e.printStackTrace();
                    fileOutputStream.close();
                } catch (Throwable th) {
                    th = th;
                    try {
                        fileOutputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = fileOutputStream2;
                fileOutputStream.close();
                throw th;
            }
            try {
                fileOutputStream2.close();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        } catch (Exception e5) {
            e = e5;
            e.printStackTrace();
            fileOutputStream.close();
        }
    }

    public void e() {
        if (this.c != null) {
            this.c.f725a = null;
            this.c.f726b = null;
            this.c.c = null;
            this.c.d = null;
            this.c = null;
        }
        if (this.g != null) {
            this.g.f();
            this.g = null;
        }
        if (this.k != null) {
            this.k.clear();
            this.k = null;
        }
        if (this.m != null && !this.m.isRecycled()) {
            this.m.recycle();
            this.m = null;
        }
        if (this.n != null && !this.n.isRecycled()) {
            this.n.recycle();
            this.n = null;
        }
        if (this.r != null && !this.r.isRecycled()) {
            this.r.recycle();
            this.r = null;
        }
        if (this.s != null) {
            this.s.a();
            this.s = null;
        }
        if (this.t != null) {
            this.t.a();
            this.t = null;
        }
        if (this.v != null) {
            this.v.a();
            this.v = null;
        }
        if (this.u != null) {
            this.u.a();
            this.u = null;
        }
        if (this.x != null) {
            this.x.a();
            this.x = null;
        }
        if (this.y != null) {
            this.y.a();
            this.y = null;
        }
        if (this.f[0] != -1) {
            GLES20.glDeleteTextures(1, this.f, 0);
            this.f[0] = -1;
        }
        if (this.e[0] != -1) {
            GLES20.glDeleteRenderbuffers(1, this.e, 0);
            this.e[0] = -1;
        }
        if (this.d[0] != -1) {
            GLES20.glDeleteFramebuffers(1, this.d, 0);
            this.d[0] = -1;
        }
    }

    public void a(FittingFaceData fittingFaceData) {
        if (this.A) {
            Log.e(f739a, "[c] PrepareBilateralFiltering already init!");
        } else if (fittingFaceData == null || fittingFaceData.GetCustomBitmapFilePath() == null) {
            String str = f739a;
            Log.e(str, "[c] ERROR: PrepareBilateralFiltering faceData: " + fittingFaceData);
        } else {
            this.k = ByteBuffer.allocateDirect(this.h * this.h * 4);
            this.g = new l();
            Bitmap decodeFile = BitmapFactory.decodeFile(fittingFaceData.GetCustomBitmapFilePath());
            this.z = k.a(decodeFile);
            if (decodeFile != null && !decodeFile.isRecycled()) {
                decodeFile.recycle();
            }
            Bitmap decodeFile2 = BitmapFactory.decodeFile(fittingFaceData.GetFaceBase_JawMaskPng());
            this.v = k.a(decodeFile2);
            if (decodeFile2 != null && !decodeFile2.isRecycled()) {
                decodeFile2.recycle();
            }
            a(this.d, this.e, this.f, this.h);
            this.A = true;
        }
    }

    public boolean f() {
        return this.A;
    }

    public int a(float f2) {
        if (f2 == GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
            int c2 = this.z.c();
            this.z = null;
            return c2;
        }
        GLES20.glBindFramebuffer(36160, this.d[0]);
        GLES20.glViewport(0, 0, this.h, this.h);
        GLES20.glClearColor(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f);
        GLES20.glClear(16640);
        GLES20.glDisable(2929);
        this.g.d().a(f2 * d.C, d.D);
        this.g.d().a(this.z, this.v);
        this.g.d().a();
        GLES20.glEnable(2929);
        GLES20.glBindFramebuffer(36160, 0);
        int i2 = this.f[0];
        this.f[0] = -1;
        return i2;
    }

    public void a(String str) {
        GLES20.glBindFramebuffer(36160, this.d[0]);
        GLES20.glViewport(0, 0, this.h, this.h);
        GLES20.glReadPixels(0, 0, this.h, this.h, 6408, 5121, this.k);
        Bitmap createBitmap = Bitmap.createBitmap(this.h, this.h, Bitmap.Config.ARGB_8888);
        createBitmap.copyPixelsFromBuffer(this.k);
        GLES20.glEnable(2929);
        GLES20.glBindFramebuffer(36160, 0);
        a(createBitmap, str);
        if (createBitmap != null && !createBitmap.isRecycled()) {
            createBitmap.recycle();
        }
    }

    public void g() {
        if (!this.A) {
            Log.e(f739a, "[c] ReleaseBilateralFiltering isn't prepared!");
            return;
        }
        if (this.k != null) {
            this.k.clear();
            this.k = null;
        }
        if (this.g != null) {
            this.g.f();
            this.g = null;
        }
        if (this.z != null) {
            this.z.a();
            this.z = null;
        }
        if (this.v != null) {
            this.v.a();
            this.v = null;
        }
        if (this.f[0] != -1) {
            GLES20.glDeleteTextures(1, this.f, 0);
            this.f[0] = -1;
        }
        if (this.e[0] != -1) {
            GLES20.glDeleteRenderbuffers(1, this.e, 0);
            this.e[0] = -1;
        }
        if (this.d[0] != -1) {
            GLES20.glDeleteFramebuffers(1, this.d, 0);
            this.d[0] = -1;
        }
        this.A = false;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\customface\f.java ==========

package net.fxgear.customface;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import net.fxgear.GlobalDefine;
import net.fxgear.fittingview.data.FittingFaceData;

/* compiled from: FeaturePointsManager */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f741a = "f";

    /* renamed from: b  reason: collision with root package name */
    private static float[] f742b = new float[42];
    private static int[] c = new int[42];
    private Bitmap d;

    public static int[] a(FittingFaceData fittingFaceData, int[] iArr) {
        float[] fArr = f742b;
        int i = 0;
        for (int i2 = 0; i2 < 2; i2++) {
            for (int i3 = 0; i3 < 2; i3++) {
                fArr[(i * 2) + i3] = (float) iArr[(d.p[i2] * 2) + i3];
            }
            i++;
        }
        for (int i4 = 0; i4 < 2; i4++) {
            fArr[(i * 2) + i4] = ((float) (iArr[(d.p[2] * 2) + i4] + iArr[(d.p[3] * 2) + i4])) * 0.5f;
        }
        int i5 = i + 1;
        for (int i6 = 0; i6 < 2; i6++) {
            fArr[(i5 * 2) + i6] = ((float) (iArr[(d.p[4] * 2) + i6] + iArr[(d.p[5] * 2) + i6])) * 0.5f;
        }
        int i7 = i5 + 1;
        for (int i8 = 0; i8 < 2; i8++) {
            for (int i9 = 0; i9 < 2; i9++) {
                fArr[(i7 * 2) + i9] = (float) iArr[(d.q[i8] * 2) + i9];
            }
            i7++;
        }
        for (int i10 = 0; i10 < 2; i10++) {
            fArr[(i7 * 2) + i10] = ((float) (iArr[(d.q[2] * 2) + i10] + iArr[(d.q[3] * 2) + i10])) * 0.5f;
        }
        int i11 = i7 + 1;
        for (int i12 = 0; i12 < 2; i12++) {
            fArr[(i11 * 2) + i12] = ((float) (iArr[(d.q[4] * 2) + i12] + iArr[(d.q[5] * 2) + i12])) * 0.5f;
        }
        int i13 = i11 + 1;
        for (int i14 = 0; i14 < d.r.length; i14++) {
            for (int i15 = 0; i15 < 2; i15++) {
                fArr[(i13 * 2) + i15] = (float) iArr[(d.r[i14] * 2) + i15];
            }
            i13++;
        }
        for (int i16 = 0; i16 < d.s.length; i16++) {
            for (int i17 = 0; i17 < 2; i17++) {
                fArr[(i13 * 2) + i17] = (float) iArr[(d.s[i16] * 2) + i17];
            }
            i13++;
        }
        for (int i18 = 0; i18 < d.t.length; i18++) {
            for (int i19 = 0; i19 < 2; i19++) {
                fArr[(i13 * 2) + i19] = (float) iArr[(d.t[i18] * 2) + i19];
            }
            i13++;
        }
        float f = (fittingFaceData.GetModelGender() == 3 || fittingFaceData.GetModelGender() == 2) ? 1.2f : fittingFaceData.GetFaceGender() == FittingFaceData.a.MALE ? 1.1f : 1.0f;
        for (int i20 = 0; i20 < 2; i20++) {
            int i21 = i20 + 16;
            int i22 = i20 + 22;
            fArr[i21] = fArr[i22] + ((fArr[i21] - fArr[i22]) * f);
            int i23 = i20 + 18;
            fArr[i23] = fArr[i22] + ((fArr[i23] - fArr[i22]) * f);
        }
        if (fittingFaceData.GetModelGender() == 3 || fittingFaceData.GetModelGender() == 2) {
            float f2 = fArr[32];
            float f3 = fArr[34];
            float f4 = fArr[36];
            float f5 = fArr[38];
            float f6 = fArr[0];
            float f7 = fArr[10];
            if (f4 > f2 && f5 < f3) {
                if (f4 > f6) {
                    fArr[36] = f6;
                }
                if (f5 < f7) {
                    fArr[38] = f7;
                }
            }
        }
        for (int i24 = 0; i24 < f742b.length; i24++) {
            c[i24] = (int) (fArr[i24] + 0.5f);
        }
        return c;
    }

    public void a(Bitmap bitmap, int[] iArr) {
        if (iArr != null) {
            for (int i = 0; i < iArr.length; i++) {
                f742b[i] = (float) iArr[i];
            }
        }
        if (f742b == null) {
            Log.e(f741a, "[c] ERROR: generateFeaturePositionCropImage sFeaturePosition == null!");
            return;
        }
        float min = Math.min(f742b[32], f742b[36]);
        float min2 = Math.min(f742b[33], f742b[35]);
        float max = Math.max(f742b[34], f742b[38]) - min;
        float f = f742b[41] - min2;
        float f2 = min + (0.5f * max);
        float f3 = min2 + (0.2f * f);
        float max2 = Math.max(max * d.u[0], f * d.u[1]) / 2.0f;
        float f4 = f2 - max2;
        float f5 = f2 + max2;
        float f6 = f3 - max2;
        float f7 = f3 + max2;
        float f8 = f5 - f4;
        float f9 = f7 - f6;
        float max3 = Math.max(f4, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        float min3 = Math.min(f5, (float) bitmap.getWidth());
        float max4 = Math.max(f6, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        float min4 = Math.min(f7, (float) bitmap.getHeight());
        if (this.d != null && !this.d.isRecycled()) {
            this.d.recycle();
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, (int) max3, (int) max4, (int) (min3 - max3), (int) (min4 - max4));
        this.d = Bitmap.createBitmap((int) f8, (int) f9, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(this.d);
        canvas.drawColor(-1);
        canvas.drawBitmap(createBitmap, max3 - f4, max4 - f6, (Paint) null);
        createBitmap.recycle();
        for (int i2 = 0; i2 < 21; i2++) {
            int i3 = i2 * 2;
            int i4 = i3 + 0;
            f742b[i4] = d.v[0] * ((f742b[i4] - ((float) ((int) f4))) / f8);
            int i5 = i3 + 1;
            f742b[i5] = d.v[1] - (d.v[1] * ((f742b[i5] - ((float) ((int) f6))) / f9));
        }
    }

    public void a() {
        if (this.d != null && !this.d.isRecycled()) {
            this.d.recycle();
            this.d = null;
        }
    }

    public static float[] b() {
        return f742b;
    }

    public Bitmap c() {
        return this.d;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\customface\g.java ==========

package net.fxgear.customface;

import android.opengl.GLES20;
import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: PointRender */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private float[] f743a = new float[16];

    /* renamed from: b  reason: collision with root package name */
    private final String f744b = "precision highp float;\nattribute vec4 a_position;\nattribute vec4 a_color;\nuniform   mat4 u_mvp;\nvarying   vec3 v_color;\nvoid main() {\n      gl_PointSize = 10.0;\n      v_color = a_color.rgb;\n      gl_Position = u_mvp * a_position;\n}\n";
    private final String c = "precision highp float;\nvarying   vec3 v_color;\nvoid main()\n{\n  gl_FragColor = vec4(v_color, 1.0);\n}\n";
    private int d;
    private int e;
    private int f;
    private int g;
    private FloatBuffer h;
    private FloatBuffer i;
    private int j = 4;
    private int k;

    public g(int i2) {
        this.k = i2;
        this.d = i.a("precision highp float;\nattribute vec4 a_position;\nattribute vec4 a_color;\nuniform   mat4 u_mvp;\nvarying   vec3 v_color;\nvoid main() {\n      gl_PointSize = 10.0;\n      v_color = a_color.rgb;\n      gl_Position = u_mvp * a_position;\n}\n", "precision highp float;\nvarying   vec3 v_color;\nvoid main()\n{\n  gl_FragColor = vec4(v_color, 1.0);\n}\n");
        this.e = GLES20.glGetAttribLocation(this.d, "a_position");
        this.f = GLES20.glGetAttribLocation(this.d, "a_color");
        this.g = GLES20.glGetUniformLocation(this.d, "u_mvp");
        this.h = ByteBuffer.allocateDirect(this.k * 3 * this.j).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.i = ByteBuffer.allocateDirect(this.k * 3 * this.j).order(ByteOrder.nativeOrder()).asFloatBuffer();
        for (int i3 = 0; i3 < this.k * 3; i3++) {
            this.i.put(i3, 1.0f);
        }
    }

    public void a(float[] fArr) {
        this.h.put(fArr).position(0);
    }

    public void a(float f2, float f3, float f4) {
        for (int i2 = 0; i2 < this.k; i2++) {
            int i3 = i2 * 3;
            this.i.put(i3 + 0, f2);
            this.i.put(i3 + 1, f3);
            this.i.put(i3 + 2, f4);
        }
    }

    public void a() {
        Matrix.setIdentityM(this.f743a, 0);
        GLES20.glUseProgram(this.d);
        GLES20.glUniformMatrix4fv(this.g, 1, false, this.f743a, 0);
        GLES20.glEnableVertexAttribArray(this.e);
        GLES20.glVertexAttribPointer(this.e, 3, 5126, false, 0, this.h);
        GLES20.glEnableVertexAttribArray(this.f);
        GLES20.glVertexAttribPointer(this.f, 3, 5126, false, 0, this.i);
        GLES20.glDrawArrays(0, 0, this.k);
        GLES20.glDisableVertexAttribArray(this.e);
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\customface\h.java ==========

package net.fxgear.customface;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.Log;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import net.fxgear.GlobalDefine;
import net.fxgear.fittingview.data.FittingFaceData;

/* compiled from: Renderer */
public class h implements GLSurfaceView.Renderer {

    /* renamed from: a  reason: collision with root package name */
    private final String f745a = "VideoRender";

    /* renamed from: b  reason: collision with root package name */
    private int f746b;
    private int c;
    private Context d;
    private g e;
    private g f;
    private a g;
    private f h;
    private c i;
    private e j;
    private float[] k;
    private int l = 0;
    private j m;

    public h(Context context) {
        this.d = context;
    }

    public void a(a aVar, f fVar, c cVar, e eVar) {
        this.g = aVar;
        this.h = fVar;
        this.i = cVar;
        this.j = eVar;
    }

    public void a() {
        this.k = new float[63];
        float f2 = d.v[0];
        float f3 = d.v[1];
        this.f = new g(21);
        f fVar = this.h;
        float[] b2 = f.b();
        for (int i2 = 0; i2 < 21; i2++) {
            int i3 = i2 * 3;
            int i4 = i2 * 2;
            this.k[i3 + 0] = ((b2[i4 + 0] / f2) - 0.5f) * 2.0f;
            this.k[i3 + 1] = ((b2[i4 + 1] / f3) - 0.5f) * 2.0f;
            this.k[i3 + 2] = 0.0f;
        }
        this.f.a(this.k);
        this.f.a(1.0f, 1.0f, 1.0f);
        this.e = new g(21);
        float[] b3 = this.i.b(d.F);
        for (int i5 = 0; i5 < 21; i5++) {
            int i6 = i5 * 3;
            int i7 = i5 * 2;
            this.k[i6 + 0] = ((b3[i7 + 0] / f2) - 0.5f) * 2.0f;
            this.k[i6 + 1] = ((b3[i7 + 1] / f3) - 0.5f) * 2.0f;
            this.k[i6 + 2] = 0.0f;
        }
        this.e.a(this.k);
        this.e.a(1.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
    }

    public void onDrawFrame(GL10 gl10) {
        if (this.l == 1) {
            this.i.a(FittingFaceData.a.FEMALE, 1);
            this.j.a(this.m, this.i.c(d.F));
            a();
            this.l = 2;
        }
        GLES20.glViewport(0, 0, this.f746b, this.f746b);
        GLES20.glClearColor(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f);
        GLES20.glClear(16640);
        if (this.l == 2) {
            GLES20.glDisable(2929);
            GLES20.glDisable(2884);
            GLES20.glEnable(3042);
            GLES20.glBlendFunc(770, 771);
            this.f.a();
            this.e.a();
            GLES20.glEnable(2929);
            GLES20.glEnable(2884);
            GLES20.glCullFace(1028);
        }
    }

    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        Log.i("VideoRender", "[c] onSurfaceChanged()+ width:" + i2 + ", height:" + i3);
        this.f746b = i2;
        this.c = i3;
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        b();
    }

    public void b() {
        this.m = k.a(this.h.c());
        this.j.a();
        this.j.d();
    }

    public boolean a(FittingFaceData.a aVar, int i2) {
        if (!this.i.a(aVar, i2)) {
            Log.e("VideoRender", "[c] ERROR: generateCustomFace - createCustomMesh() return false");
            return false;
        }
        this.j.b(this.m, this.i.c(d.F));
        return true;
    }

    public void c() {
        this.k = null;
        if (this.m != null) {
            this.m.a();
            this.m = null;
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\customface\i.java ==========

package net.fxgear.customface;

import android.opengl.GLES20;

/* compiled from: ShaderUtil */
public class i {
    public static int a(String str, String str2) {
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, a(str, 35633));
        GLES20.glAttachShader(glCreateProgram, a(str2, 35632));
        GLES20.glLinkProgram(glCreateProgram);
        return glCreateProgram;
    }

    private static int a(String str, int i) {
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        throw new AssertionError("Shader compilation failed");
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\customface\j.java ==========

package net.fxgear.customface;

import android.opengl.GLES20;

/* compiled from: Texture */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private int f747a;

    /* renamed from: b  reason: collision with root package name */
    private int f748b;
    private int c;
    private int d;

    public j(int i, int i2) {
        this.f747a = i;
        this.f748b = i2;
    }

    public final void a() {
        GLES20.glDeleteTextures(1, new int[]{this.f748b}, 0);
    }

    public final int b() {
        return this.f747a;
    }

    public final int c() {
        return this.f748b;
    }

    public void a(int i) {
        this.c = i;
    }

    public void b(int i) {
        this.d = i;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\customface\k.java ==========

package net.fxgear.customface;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;

/* compiled from: TextureUtil */
public class k {
    public static j a(Bitmap bitmap) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        j jVar = new j(3553, iArr[0]);
        jVar.a(bitmap.getWidth());
        jVar.b(bitmap.getHeight());
        return jVar;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\customface\l.java ==========

package net.fxgear.customface;

import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import net.fxgear.GlobalDefine;
import net.fxgear.customface.b;

/* compiled from: faceRenderer */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private a f749a = new a();

    /* renamed from: b  reason: collision with root package name */
    private c f750b = new c();
    private b c = new b();
    private e d = new e();
    private f e = new f();
    private d f = new d();
    /* access modifiers changed from: private */
    public final float[] g = {-1.0f, -1.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f, -1.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, -1.0f, 1.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f, 1.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE};
    /* access modifiers changed from: private */
    public final float[] h = {GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f, 1.0f, 1.0f};
    /* access modifiers changed from: private */
    public final short[] i = {0, 1, 2, 2, 1, 3};

    public a a() {
        return this.f749a;
    }

    public c b() {
        return this.f750b;
    }

    public b c() {
        return this.c;
    }

    public e d() {
        return this.d;
    }

    public d e() {
        return this.f;
    }

    public void f() {
        if (this.f749a != null) {
            this.f749a.c();
            this.f749a = null;
        }
        if (this.f750b != null) {
            this.f750b.b();
            this.f750b = null;
        }
        if (this.c != null) {
            this.c.b();
            this.c = null;
        }
        if (this.d != null) {
            this.d.b();
            this.d = null;
        }
        if (this.e != null) {
            this.e.a();
            this.e = null;
        }
        if (this.f != null) {
            this.f.b();
            this.f = null;
        }
    }

    /* compiled from: faceRenderer */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        FloatBuffer f751a;

        /* renamed from: b  reason: collision with root package name */
        FloatBuffer f752b;
        ShortBuffer c;
        private int e;
        private final String f = "precision highp float;\nattribute vec4  a_position;\nattribute vec2  a_tex_coord;\nvarying   vec2  v_tex_coord;\nvoid main() {\n      v_tex_coord = a_tex_coord;\n      gl_Position = a_position;\n}\n";
        private final String g = "precision highp float;\nuniform sampler2D u_texture;\nuniform sampler2D u_mask;\nuniform int       u_masking;\nvarying vec2      v_tex_coord;\nvoid main()\n{\ngl_FragColor = vec4( texture2D(u_texture, v_tex_coord).rgb, 0.85 );\nif( u_masking > 0 && texture2D(u_mask, v_tex_coord).r > 0.0 ) discard;\n}\n";
        private int h = i.a("precision highp float;\nattribute vec4  a_position;\nattribute vec2  a_tex_coord;\nvarying   vec2  v_tex_coord;\nvoid main() {\n      v_tex_coord = a_tex_coord;\n      gl_Position = a_position;\n}\n", "precision highp float;\nuniform sampler2D u_texture;\nuniform sampler2D u_mask;\nuniform int       u_masking;\nvarying vec2      v_tex_coord;\nvoid main()\n{\ngl_FragColor = vec4( texture2D(u_texture, v_tex_coord).rgb, 0.85 );\nif( u_masking > 0 && texture2D(u_mask, v_tex_coord).r > 0.0 ) discard;\n}\n");
        private int i = GLES20.glGetAttribLocation(this.h, "a_position");
        private int j = GLES20.glGetAttribLocation(this.h, "a_tex_coord");
        private int k = GLES20.glGetUniformLocation(this.h, "u_texture");
        private int l = GLES20.glGetUniformLocation(this.h, "u_mask");
        private int m = GLES20.glGetUniformLocation(this.h, "u_masking");
        private j n;
        private j o;
        private int p = 0;

        public a() {
        }

        public void a(b.C0024b bVar) {
            c();
            this.e = bVar.d.length;
            this.f751a = ByteBuffer.allocateDirect(bVar.f725a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.f751a.put(bVar.f725a).position(0);
            this.f752b = ByteBuffer.allocateDirect(bVar.c.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.f752b.put(bVar.c).position(0);
            this.c = ByteBuffer.allocateDirect(bVar.d.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer();
            this.c.put(bVar.d).position(0);
        }

        public void a() {
            c();
            this.e = 6;
            this.f751a = ByteBuffer.allocateDirect(l.this.g.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.f751a.put(l.this.g).position(0);
            this.f752b = ByteBuffer.allocateDirect(l.this.h.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.f752b.put(l.this.h).position(0);
            this.c = ByteBuffer.allocateDirect(l.this.i.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer();
            this.c.put(l.this.i).position(0);
        }

        public void a(j jVar, j jVar2, int i2) {
            this.n = jVar;
            this.o = jVar2;
            this.p = i2;
        }

        public void b() {
            GLES20.glUseProgram(this.h);
            GLES20.glEnableVertexAttribArray(this.i);
            GLES20.glEnableVertexAttribArray(this.j);
            GLES20.glVertexAttribPointer(this.i, 3, 5126, false, 0, this.f751a);
            GLES20.glVertexAttribPointer(this.j, 2, 5126, false, 0, this.f752b);
            GLES20.glUniform1i(this.m, this.p);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(this.n.b(), this.n.c());
            GLES20.glUniform1i(this.k, 0);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(this.o.b(), this.o.c());
            GLES20.glUniform1i(this.l, 1);
            GLES20.glDrawElements(4, this.e, 5123, this.c);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, 0);
            GLES20.glDisableVertexAttribArray(this.i);
            GLES20.glDisableVertexAttribArray(this.j);
        }

        public void c() {
            if (this.f751a != null) {
                this.f751a.clear();
            }
            if (this.f752b != null) {
                this.f752b.clear();
            }
            if (this.c != null) {
                this.c.clear();
            }
        }
    }

    /* compiled from: faceRenderer */
    public class c {
        private j A;

        /* renamed from: a  reason: collision with root package name */
        FloatBuffer f755a;

        /* renamed from: b  reason: collision with root package name */
        FloatBuffer f756b;
        ShortBuffer c;
        float[] d = {GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f};
        float e = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        private final String g = "precision highp float;\nattribute vec4 a_position;\nattribute vec2 a_tex_coord;\nvarying   vec2 v_tex_coord;\nvoid main() {\n      v_tex_coord = a_tex_coord;\n      gl_Position = a_position;\n}\n";
        private final String h = "precision highp float;\nuniform sampler2D u_source;\nuniform sampler2D u_target;\nuniform sampler2D u_face;\nuniform sampler2D u_mask;\nuniform sampler2D u_base;\nuniform sampler2D u_jaws;\nuniform sampler2D u_sharp;\nuniform float     u_sharp_sigma;\nuniform vec2      u_jaw_blend_range;\nvarying vec2 v_tex_coord;\nvoid main()\n{\nvec3  source = texture2D(u_source, v_tex_coord).rgb;\nvec3  target = texture2D(u_target, v_tex_coord).rgb;\nvec3  face   = texture2D(u_face, v_tex_coord).rgb;\nvec3  base   = texture2D(u_base, v_tex_coord).rgb;\nfloat mask   = texture2D(u_mask, v_tex_coord).r;\nfloat jaws   = texture2D(u_jaws, v_tex_coord).r;\nfloat sharp  = texture2D(u_sharp, v_tex_coord).r;\njaws = smoothstep(u_jaw_blend_range.x, u_jaw_blend_range.y, jaws);\nvec2 offset = vec2( 1.0/512.0 );\nint  isBoundary = 0;\nfor(int i=-2; i<=2; i++)\nfor(int j=-2; j<=2; j++)\nif( int(255.0*mask) != int(255.0*texture2D(u_mask, v_tex_coord + vec2(i,j)*offset).r) ) isBoundary = 1;\nvec3 color = vec3(1.0);\nif( isBoundary == 1 ) color = target;\nelse                  color = face + target - source;\nfloat diff = (face.r+face.g+face.b)/3.0;\nfloat w = 1.0 - exp( -diff*diff/(u_sharp_sigma*u_sharp_sigma) );\ncolor = (1.0-sharp)*color + w*sharp*color;\ncolor = jaws*color + (1.0-jaws)*base;\ngl_FragColor = vec4( color, 1.0);\n}\n";
        private int i;
        private int j;
        private int k;
        private int l;
        private int m;
        private int n;
        private int o;
        private int p;
        private int q;
        private int r;
        private int s;
        private int t;
        private j u;
        private j v;
        private j w;
        private j x;
        private j y;
        private j z;

        public c() {
            this.f755a = ByteBuffer.allocateDirect(l.this.g.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.f755a.put(l.this.g).position(0);
            this.f756b = ByteBuffer.allocateDirect(l.this.h.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.f756b.put(l.this.h).position(0);
            this.c = ByteBuffer.allocateDirect(l.this.i.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer();
            this.c.put(l.this.i).position(0);
            this.i = i.a("precision highp float;\nattribute vec4 a_position;\nattribute vec2 a_tex_coord;\nvarying   vec2 v_tex_coord;\nvoid main() {\n      v_tex_coord = a_tex_coord;\n      gl_Position = a_position;\n}\n", "precision highp float;\nuniform sampler2D u_source;\nuniform sampler2D u_target;\nuniform sampler2D u_face;\nuniform sampler2D u_mask;\nuniform sampler2D u_base;\nuniform sampler2D u_jaws;\nuniform sampler2D u_sharp;\nuniform float     u_sharp_sigma;\nuniform vec2      u_jaw_blend_range;\nvarying vec2 v_tex_coord;\nvoid main()\n{\nvec3  source = texture2D(u_source, v_tex_coord).rgb;\nvec3  target = texture2D(u_target, v_tex_coord).rgb;\nvec3  face   = texture2D(u_face, v_tex_coord).rgb;\nvec3  base   = texture2D(u_base, v_tex_coord).rgb;\nfloat mask   = texture2D(u_mask, v_tex_coord).r;\nfloat jaws   = texture2D(u_jaws, v_tex_coord).r;\nfloat sharp  = texture2D(u_sharp, v_tex_coord).r;\njaws = smoothstep(u_jaw_blend_range.x, u_jaw_blend_range.y, jaws);\nvec2 offset = vec2( 1.0/512.0 );\nint  isBoundary = 0;\nfor(int i=-2; i<=2; i++)\nfor(int j=-2; j<=2; j++)\nif( int(255.0*mask) != int(255.0*texture2D(u_mask, v_tex_coord + vec2(i,j)*offset).r) ) isBoundary = 1;\nvec3 color = vec3(1.0);\nif( isBoundary == 1 ) color = target;\nelse                  color = face + target - source;\nfloat diff = (face.r+face.g+face.b)/3.0;\nfloat w = 1.0 - exp( -diff*diff/(u_sharp_sigma*u_sharp_sigma) );\ncolor = (1.0-sharp)*color + w*sharp*color;\ncolor = jaws*color + (1.0-jaws)*base;\ngl_FragColor = vec4( color, 1.0);\n}\n");
            this.j = GLES20.glGetAttribLocation(this.i, "a_position");
            this.k = GLES20.glGetAttribLocation(this.i, "a_tex_coord");
            this.l = GLES20.glGetUniformLocation(this.i, "u_source");
            this.m = GLES20.glGetUniformLocation(this.i, "u_target");
            this.n = GLES20.glGetUniformLocation(this.i, "u_face");
            this.o = GLES20.glGetUniformLocation(this.i, "u_mask");
            this.p = GLES20.glGetUniformLocation(this.i, "u_base");
            this.q = GLES20.glGetUniformLocation(this.i, "u_jaws");
            this.r = GLES20.glGetUniformLocation(this.i, "u_sharp");
            this.s = GLES20.glGetUniformLocation(this.i, "u_jaw_blend_range");
            this.t = GLES20.glGetUniformLocation(this.i, "u_sharp_sigma");
        }

        public void a(j jVar, j jVar2, j jVar3, j jVar4, j jVar5, j jVar6, j jVar7) {
            this.u = jVar;
            this.v = jVar2;
            this.w = jVar3;
            this.x = jVar4;
            this.y = jVar5;
            this.z = jVar6;
            this.A = jVar7;
        }

        public void a(float[] fArr, float f2) {
            this.d = fArr;
            this.e = f2;
        }

        public void a() {
            GLES20.glUseProgram(this.i);
            GLES20.glEnableVertexAttribArray(this.j);
            GLES20.glEnableVertexAttribArray(this.k);
            GLES20.glVertexAttribPointer(this.j, 3, 5126, false, 0, this.f755a);
            GLES20.glVertexAttribPointer(this.k, 2, 5126, false, 0, this.f756b);
            GLES20.glUniform1f(this.t, this.e);
            GLES20.glUniform2f(this.s, this.d[0], this.d[1]);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(this.u.b(), this.u.c());
            GLES20.glUniform1i(this.l, 0);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(this.v.b(), this.v.c());
            GLES20.glUniform1i(this.m, 1);
            GLES20.glActiveTexture(33986);
            GLES20.glBindTexture(this.w.b(), this.w.c());
            GLES20.glUniform1i(this.n, 2);
            GLES20.glActiveTexture(33987);
            GLES20.glBindTexture(this.x.b(), this.x.c());
            GLES20.glUniform1i(this.o, 3);
            GLES20.glActiveTexture(33988);
            GLES20.glBindTexture(this.y.b(), this.y.c());
            GLES20.glUniform1i(this.p, 4);
            GLES20.glActiveTexture(33989);
            GLES20.glBindTexture(this.z.b(), this.z.c());
            GLES20.glUniform1i(this.q, 5);
            GLES20.glActiveTexture(33990);
            GLES20.glBindTexture(this.A.b(), this.A.c());
            GLES20.glUniform1i(this.r, 6);
            GLES20.glDrawElements(4, 6, 5123, this.c);
            GLES20.glActiveTexture(33990);
            GLES20.glBindTexture(3553, 0);
            GLES20.glActiveTexture(33989);
            GLES20.glBindTexture(3553, 0);
            GLES20.glActiveTexture(33988);
            GLES20.glBindTexture(3553, 0);
            GLES20.glActiveTexture(33987);
            GLES20.glBindTexture(3553, 0);
            GLES20.glActiveTexture(33986);
            GLES20.glBindTexture(3553, 0);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, 0);
            GLES20.glDisableVertexAttribArray(this.j);
            GLES20.glDisableVertexAttribArray(this.k);
        }

        public void b() {
            if (this.f755a != null) {
                this.f755a.clear();
            }
            if (this.f756b != null) {
                this.f756b.clear();
            }
            if (this.c != null) {
                this.c.clear();
            }
        }
    }

    /* compiled from: faceRenderer */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        FloatBuffer f757a;

        /* renamed from: b  reason: collision with root package name */
        FloatBuffer f758b;
        ShortBuffer c;
        private final String e = "precision highp float;\nattribute vec4 a_position;\nattribute vec2 a_tex_coord;\nvarying   vec2 v_tex_coord;\nvoid main() {\n      v_tex_coord = a_tex_coord;\n      gl_Position = a_position;\n}\n";
        private final String f = "precision highp float;\nuniform sampler2D u_lows;\nuniform sampler2D u_face;\nuniform sampler2D u_base;\nuniform sampler2D u_outer_mask;\nuniform sampler2D u_inner_mask;\nvarying vec2 v_tex_coord;\nvoid main()\n{\nvec3  lows   = texture2D(u_lows, v_tex_coord).rgb;\nvec3  face   = texture2D(u_face, v_tex_coord).rgb;\nvec3  base   = texture2D(u_base, v_tex_coord).rgb;\nfloat outer_mask  = pow(texture2D(u_outer_mask, v_tex_coord).r, 1.0);\nfloat inner_mask  = pow(texture2D(u_inner_mask, v_tex_coord).r, 1.0);\nfloat offset = 1.0/64.0;\nint   kernel = 8;\nfloat sigma  = 2.0 * float(kernel*kernel);\nvec3  sum = vec3(0.0);\nvec2  pos = vec2(0.0);\nfloat div = 0.0;\nfor(int i=-kernel; i<=kernel; i++){ pos.x = v_tex_coord.x + float(i)*offset; \nfor(int j=-kernel; j<=kernel; j++)\n{\n    pos.y = v_tex_coord.y + float(j)*offset;\n    float d = float(i*i+j*j);\n    float w = exp( -d/sigma ) * smoothstep(0.6, 0.8, texture2D(u_outer_mask, pos).r);\n    sum += w * texture2D(u_lows, pos).rgb;\n    div += w;\n}}\nvec3 averaged_face = sum / div;\noffset = 1.0/1024.0;\nkernel = 3;\nsigma  = 2.0 * float(kernel*kernel);\nsum    = vec3(0.0);\ndiv    = 0.0;\nfloat sigma_s = 2.0 * 0.02 * 0.02;\nfor(int i=-kernel; i<=kernel; i++){ pos.x = v_tex_coord.x + float(i)*offset;for(int j=-kernel; j<=kernel; j++)\n{\n    pos.y = v_tex_coord.y + float(j)*offset;\n    vec3 n_color = texture2D(u_face, pos).rgb;\n    float d = float(i*i+j*j);\n    float s = length( face - n_color );\n    float w = exp( -d/sigma - s*s/sigma_s );\n    sum += w * n_color;\n    div += w;\n}}\nvec3 filtered_face = sum / div;\nfiltered_face = filtered_face * base / averaged_face;\nfiltered_face = smoothstep(vec3(0.12), vec3(1.2), filtered_face);\nfiltered_face = 0.98*vec3(1.0,0.95,1.0)*filtered_face + 0.02*base;\nfloat  blending_power  = 0.5;\nfloat  diff_magnitude  = length(filtered_face - base);\nif( filtered_face.r+filtered_face.g+filtered_face.b > base.r+base.g+base.b ) diff_magnitude = pow(diff_magnitude, 0.4);\nfloat  blending_weight = pow(diff_magnitude, blending_power) * pow(outer_mask, 1.0);\nvec3   blend_color = blending_weight*filtered_face + (1.0-blending_weight)*base;\nvec3   final_color = (1.0-outer_mask) * base + outer_mask * blend_color;\ngl_FragColor = vec4( final_color, 1.0);\n}\n";
        private int g;
        private int h;
        private int i;
        private int j;
        private int k;
        private int l;
        private int m;
        private int n;
        private j o;
        private j p;
        private j q;
        private j r;
        private j s;

        public d() {
            this.f757a = ByteBuffer.allocateDirect(l.this.g.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.f757a.put(l.this.g).position(0);
            this.f758b = ByteBuffer.allocateDirect(l.this.h.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.f758b.put(l.this.h).position(0);
            this.c = ByteBuffer.allocateDirect(l.this.i.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer();
            this.c.put(l.this.i).position(0);
            this.g = i.a("precision highp float;\nattribute vec4 a_position;\nattribute vec2 a_tex_coord;\nvarying   vec2 v_tex_coord;\nvoid main() {\n      v_tex_coord = a_tex_coord;\n      gl_Position = a_position;\n}\n", "precision highp float;\nuniform sampler2D u_lows;\nuniform sampler2D u_face;\nuniform sampler2D u_base;\nuniform sampler2D u_outer_mask;\nuniform sampler2D u_inner_mask;\nvarying vec2 v_tex_coord;\nvoid main()\n{\nvec3  lows   = texture2D(u_lows, v_tex_coord).rgb;\nvec3  face   = texture2D(u_face, v_tex_coord).rgb;\nvec3  base   = texture2D(u_base, v_tex_coord).rgb;\nfloat outer_mask  = pow(texture2D(u_outer_mask, v_tex_coord).r, 1.0);\nfloat inner_mask  = pow(texture2D(u_inner_mask, v_tex_coord).r, 1.0);\nfloat offset = 1.0/64.0;\nint   kernel = 8;\nfloat sigma  = 2.0 * float(kernel*kernel);\nvec3  sum = vec3(0.0);\nvec2  pos = vec2(0.0);\nfloat div = 0.0;\nfor(int i=-kernel; i<=kernel; i++){ pos.x = v_tex_coord.x + float(i)*offset; \nfor(int j=-kernel; j<=kernel; j++)\n{\n    pos.y = v_tex_coord.y + float(j)*offset;\n    float d = float(i*i+j*j);\n    float w = exp( -d/sigma ) * smoothstep(0.6, 0.8, texture2D(u_outer_mask, pos).r);\n    sum += w * texture2D(u_lows, pos).rgb;\n    div += w;\n}}\nvec3 averaged_face = sum / div;\noffset = 1.0/1024.0;\nkernel = 3;\nsigma  = 2.0 * float(kernel*kernel);\nsum    = vec3(0.0);\ndiv    = 0.0;\nfloat sigma_s = 2.0 * 0.02 * 0.02;\nfor(int i=-kernel; i<=kernel; i++){ pos.x = v_tex_coord.x + float(i)*offset;for(int j=-kernel; j<=kernel; j++)\n{\n    pos.y = v_tex_coord.y + float(j)*offset;\n    vec3 n_color = texture2D(u_face, pos).rgb;\n    float d = float(i*i+j*j);\n    float s = length( face - n_color );\n    float w = exp( -d/sigma - s*s/sigma_s );\n    sum += w * n_color;\n    div += w;\n}}\nvec3 filtered_face = sum / div;\nfiltered_face = filtered_face * base / averaged_face;\nfiltered_face = smoothstep(vec3(0.12), vec3(1.2), filtered_face);\nfiltered_face = 0.98*vec3(1.0,0.95,1.0)*filtered_face + 0.02*base;\nfloat  blending_power  = 0.5;\nfloat  diff_magnitude  = length(filtered_face - base);\nif( filtered_face.r+filtered_face.g+filtered_face.b > base.r+base.g+base.b ) diff_magnitude = pow(diff_magnitude, 0.4);\nfloat  blending_weight = pow(diff_magnitude, blending_power) * pow(outer_mask, 1.0);\nvec3   blend_color = blending_weight*filtered_face + (1.0-blending_weight)*base;\nvec3   final_color = (1.0-outer_mask) * base + outer_mask * blend_color;\ngl_FragColor = vec4( final_color, 1.0);\n}\n");
            this.h = GLES20.glGetAttribLocation(this.g, "a_position");
            this.i = GLES20.glGetAttribLocation(this.g, "a_tex_coord");
            this.j = GLES20.glGetUniformLocation(this.g, "u_lows");
            this.k = GLES20.glGetUniformLocation(this.g, "u_face");
            this.l = GLES20.glGetUniformLocation(this.g, "u_base");
            this.m = GLES20.glGetUniformLocation(this.g, "u_outer_mask");
            this.n = GLES20.glGetUniformLocation(this.g, "u_inner_mask");
        }

        public void a(j jVar, j jVar2, j jVar3, j jVar4, j jVar5) {
            this.o = jVar;
            this.p = jVar2;
            this.q = jVar3;
            this.r = jVar4;
            this.s = jVar5;
        }

        public void a() {
            GLES20.glUseProgram(this.g);
            GLES20.glEnableVertexAttribArray(this.h);
            GLES20.glEnableVertexAttribArray(this.i);
            GLES20.glVertexAttribPointer(this.h, 3, 5126, false, 0, this.f757a);
            GLES20.glVertexAttribPointer(this.i, 2, 5126, false, 0, this.f758b);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(this.o.b(), this.o.c());
            GLES20.glUniform1i(this.j, 0);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(this.p.b(), this.p.c());
            GLES20.glUniform1i(this.k, 1);
            GLES20.glActiveTexture(33986);
            GLES20.glBindTexture(this.q.b(), this.q.c());
            GLES20.glUniform1i(this.l, 2);
            GLES20.glActiveTexture(33987);
            GLES20.glBindTexture(this.r.b(), this.r.c());
            GLES20.glUniform1i(this.m, 3);
            GLES20.glActiveTexture(33988);
            GLES20.glBindTexture(this.s.b(), this.s.c());
            GLES20.glUniform1i(this.n, 4);
            GLES20.glDrawElements(4, 6, 5123, this.c);
            GLES20.glActiveTexture(33988);
            GLES20.glBindTexture(3553, 0);
            GLES20.glActiveTexture(33987);
            GLES20.glBindTexture(3553, 0);
            GLES20.glActiveTexture(33986);
            GLES20.glBindTexture(3553, 0);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, 0);
            GLES20.glDisableVertexAttribArray(this.h);
            GLES20.glDisableVertexAttribArray(this.i);
        }

        public void b() {
            if (this.f757a != null) {
                this.f757a.clear();
            }
            if (this.f758b != null) {
                this.f758b.clear();
            }
            if (this.c != null) {
                this.c.clear();
            }
        }
    }

    /* compiled from: faceRenderer */
    public class e {

        /* renamed from: a  reason: collision with root package name */
        FloatBuffer f759a;

        /* renamed from: b  reason: collision with root package name */
        FloatBuffer f760b;
        ShortBuffer c;
        private final String e = "precision highp float;\nattribute vec4 a_position;\nattribute vec2 a_tex_coord;\nvarying   vec2 v_tex_coord;\nvoid main() {\n      v_tex_coord = a_tex_coord;\n      gl_Position = a_position;\n}\n";
        private final String f = "precision highp float;\nuniform sampler2D u_face;\nuniform sampler2D u_mask;\nuniform float     u_kernel;\nuniform float     u_sigma;\nvarying vec2      v_tex_coord;\nvoid main()\n{\nint   kernel = int(u_kernel*texture2D(u_mask, v_tex_coord).r);\nfloat Od = 2.0*u_kernel*u_kernel;\nfloat Os = 2.0*(u_sigma*u_sigma);\nvec2  offset = vec2( 1.0/1024.0 );\nvec3  sum = vec3(0.0);\nfloat normalizer = 0.0;\nvec3 cv = texture2D(u_face, v_tex_coord).rgb;\nfor(int i=-kernel; i<=kernel; i++)\nfor(int j=-kernel; j<=kernel; j++)\n{\n   vec3  nv = texture2D(u_face, v_tex_coord + vec2(i,j)*offset).rgb;\n   float leng = length(vec2(i,j));\n   float diff = length( cv - nv );\n   float Wd = exp( -leng*leng/Od );\n   float Ws = exp( -diff*diff/Os );\n   normalizer += Wd*Ws;\n   sum += Wd*Ws * nv;\n}\ngl_FragColor = vec4( sum/normalizer, 1.0);\n}\n";
        private int g;
        private int h;
        private int i;
        private int j;
        private int k;
        private int l;
        private int m;
        private j n;
        private j o;
        private float p;
        private float q;

        public e() {
            this.f759a = ByteBuffer.allocateDirect(l.this.g.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.f759a.put(l.this.g).position(0);
            this.f760b = ByteBuffer.allocateDirect(l.this.h.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.f760b.put(l.this.h).position(0);
            this.c = ByteBuffer.allocateDirect(l.this.i.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer();
            this.c.put(l.this.i).position(0);
            this.g = i.a("precision highp float;\nattribute vec4 a_position;\nattribute vec2 a_tex_coord;\nvarying   vec2 v_tex_coord;\nvoid main() {\n      v_tex_coord = a_tex_coord;\n      gl_Position = a_position;\n}\n", "precision highp float;\nuniform sampler2D u_face;\nuniform sampler2D u_mask;\nuniform float     u_kernel;\nuniform float     u_sigma;\nvarying vec2      v_tex_coord;\nvoid main()\n{\nint   kernel = int(u_kernel*texture2D(u_mask, v_tex_coord).r);\nfloat Od = 2.0*u_kernel*u_kernel;\nfloat Os = 2.0*(u_sigma*u_sigma);\nvec2  offset = vec2( 1.0/1024.0 );\nvec3  sum = vec3(0.0);\nfloat normalizer = 0.0;\nvec3 cv = texture2D(u_face, v_tex_coord).rgb;\nfor(int i=-kernel; i<=kernel; i++)\nfor(int j=-kernel; j<=kernel; j++)\n{\n   vec3  nv = texture2D(u_face, v_tex_coord + vec2(i,j)*offset).rgb;\n   float leng = length(vec2(i,j));\n   float diff = length( cv - nv );\n   float Wd = exp( -leng*leng/Od );\n   float Ws = exp( -diff*diff/Os );\n   normalizer += Wd*Ws;\n   sum += Wd*Ws * nv;\n}\ngl_FragColor = vec4( sum/normalizer, 1.0);\n}\n");
            this.h = GLES20.glGetAttribLocation(this.g, "a_position");
            this.i = GLES20.glGetAttribLocation(this.g, "a_tex_coord");
            this.j = GLES20.glGetUniformLocation(this.g, "u_face");
            this.k = GLES20.glGetUniformLocation(this.g, "u_mask");
            this.l = GLES20.glGetUniformLocation(this.g, "u_kernel");
            this.m = GLES20.glGetUniformLocation(this.g, "u_sigma");
        }

        public void a(j jVar, j jVar2) {
            this.n = jVar;
            this.o = jVar2;
        }

        public void a(float f2, float f3) {
            this.p = f2;
            this.q = f3;
        }

        public void a() {
            GLES20.glUseProgram(this.g);
            GLES20.glEnableVertexAttribArray(this.h);
            GLES20.glEnableVertexAttribArray(this.i);
            GLES20.glVertexAttribPointer(this.h, 3, 5126, false, 0, this.f759a);
            GLES20.glVertexAttribPointer(this.i, 2, 5126, false, 0, this.f760b);
            GLES20.glUniform1f(this.l, this.p);
            GLES20.glUniform1f(this.m, this.q);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(this.n.b(), this.n.c());
            GLES20.glUniform1i(this.j, 0);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(this.o.b(), this.o.c());
            GLES20.glUniform1i(this.k, 1);
            GLES20.glDrawElements(4, 6, 5123, this.c);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, 0);
            GLES20.glDisableVertexAttribArray(this.h);
            GLES20.glDisableVertexAttribArray(this.i);
        }

        public void b() {
            if (this.f759a != null) {
                this.f759a.clear();
            }
            if (this.f760b != null) {
                this.f760b.clear();
            }
            if (this.c != null) {
                this.c.clear();
            }
        }
    }

    /* compiled from: faceRenderer */
    public class f {

        /* renamed from: a  reason: collision with root package name */
        FloatBuffer f761a;

        /* renamed from: b  reason: collision with root package name */
        FloatBuffer f762b;
        ShortBuffer c;
        private final String e = "precision highp float;\nattribute vec4 a_position;\nattribute vec2 a_tex_coord;\nvarying   vec2 v_tex_coord;\nvoid main() {\n      v_tex_coord = a_tex_coord;\n      gl_Position = a_position;\n}\n";
        private final String f = "precision highp float;\nuniform sampler2D u_image;\nuniform vec3      u_tone;\nvarying vec2      v_tex_coord;\nvoid main()\n{\nvec3 color = texture2D(u_image, v_tex_coord).rgb;\nfloat luminanceOld = (color.r + color.g + color.b)/3.0;\ncolor *= u_tone;\nfloat luminanceNew = (color.r + color.g + color.b)/3.0;\ncolor *= luminanceOld/luminanceNew;\ngl_FragColor = vec4( color, 1.0);\n}\n";
        private int g;
        private int h;
        private int i;
        private int j;
        private int k;
        private float[] l = {GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE};

        public f() {
            this.f761a = ByteBuffer.allocateDirect(l.this.g.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.f761a.put(l.this.g).position(0);
            this.f762b = ByteBuffer.allocateDirect(l.this.h.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.f762b.put(l.this.h).position(0);
            this.c = ByteBuffer.allocateDirect(l.this.i.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer();
            this.c.put(l.this.i).position(0);
            this.g = i.a("precision highp float;\nattribute vec4 a_position;\nattribute vec2 a_tex_coord;\nvarying   vec2 v_tex_coord;\nvoid main() {\n      v_tex_coord = a_tex_coord;\n      gl_Position = a_position;\n}\n", "precision highp float;\nuniform sampler2D u_image;\nuniform vec3      u_tone;\nvarying vec2      v_tex_coord;\nvoid main()\n{\nvec3 color = texture2D(u_image, v_tex_coord).rgb;\nfloat luminanceOld = (color.r + color.g + color.b)/3.0;\ncolor *= u_tone;\nfloat luminanceNew = (color.r + color.g + color.b)/3.0;\ncolor *= luminanceOld/luminanceNew;\ngl_FragColor = vec4( color, 1.0);\n}\n");
            this.h = GLES20.glGetAttribLocation(this.g, "a_position");
            this.i = GLES20.glGetAttribLocation(this.g, "a_tex_coord");
            this.j = GLES20.glGetUniformLocation(this.g, "u_image");
            this.k = GLES20.glGetUniformLocation(this.g, "u_tone");
        }

        public void a() {
            if (this.f761a != null) {
                this.f761a.clear();
            }
            if (this.f762b != null) {
                this.f762b.clear();
            }
            if (this.c != null) {
                this.c.clear();
            }
        }
    }

    /* compiled from: faceRenderer */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        FloatBuffer f753a;

        /* renamed from: b  reason: collision with root package name */
        ShortBuffer f754b;
        private int d;
        private final String e = "precision highp float;\nattribute vec4  a_position;\nvoid main() { gl_Position = a_position; }\n";
        private final String f = "precision highp float;\nvoid main()\n{ gl_FragColor = vec4(1.0); }\n";
        private int g = i.a("precision highp float;\nattribute vec4  a_position;\nvoid main() { gl_Position = a_position; }\n", "precision highp float;\nvoid main()\n{ gl_FragColor = vec4(1.0); }\n");
        private int h = GLES20.glGetAttribLocation(this.g, "a_position");

        public b() {
        }

        public void a(b.C0024b bVar) {
            b();
            this.d = bVar.d.length;
            this.f753a = ByteBuffer.allocateDirect(bVar.f725a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.f753a.put(bVar.f725a).position(0);
            this.f754b = ByteBuffer.allocateDirect(bVar.d.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer();
            this.f754b.put(bVar.d).position(0);
        }

        public void a() {
            GLES20.glUseProgram(this.g);
            GLES20.glEnableVertexAttribArray(this.h);
            GLES20.glVertexAttribPointer(this.h, 3, 5126, false, 0, this.f753a);
            GLES20.glDrawElements(4, this.d, 5123, this.f754b);
            GLES20.glDisableVertexAttribArray(this.h);
        }

        public void b() {
            if (this.f753a != null) {
                this.f753a.clear();
            }
            if (this.f754b != null) {
                this.f754b.clear();
            }
        }
    }
}


