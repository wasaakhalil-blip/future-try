package net.fxgear.b;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.microedition.khronos.opengles.GL10;
import net.fxgear.GlobalDefine;
import net.fxgear.b.h;

/* compiled from: FXMesh */
public class k {
    private int A;
    private int B;
    private float[] C;
    private int D;
    private boolean E;
    private long F;
    private float G;
    private float H;
    private h.d I;
    private e J;
    private String K;
    private float[] L;
    private float[] M;
    private float N;
    private float[] O;
    private float[] P;
    private float Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private boolean U;
    private boolean V;
    private float[] W;
    private int X;
    private float[] Y;
    private float[] Z;

    /* renamed from: a  reason: collision with root package name */
    public int[] f696a;
    private GlobalDefine.CLOTHES_CATEGORY_TYPE aa;

    /* renamed from: b  reason: collision with root package name */
    Bitmap f697b;
    Bitmap[] c;
    String[] d;
    int[] e;
    String f;
    Bitmap[] g;
    Bitmap[] h;
    private int i;
    private int j;
    private int k;
    private int[] l;
    private float[] m;
    private float n;
    private float o;
    private float p;
    private float[] q;
    private float[] r;
    private float[] s;
    private float[] t;
    private float[] u;
    private float[] v;
    private int w;
    private int x;
    private int y;
    private int z;

    public k() {
        this.i = -1;
        this.j = -1;
        this.k = -1;
        this.f696a = null;
        this.l = null;
        this.m = null;
        this.f697b = null;
        this.n = -1.0f;
        this.o = -1.0f;
        this.p = -1.0f;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = -1;
        this.x = -1;
        this.y = -1;
        this.z = -1;
        this.A = -1;
        this.B = -1;
        this.C = null;
        this.D = 0;
        this.E = false;
        this.F = 0;
        this.G = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        this.H = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        this.I = h.d.NONE;
        this.K = new String();
        this.L = null;
        this.M = new float[3];
        this.N = 1.0f;
        this.O = new float[14];
        this.P = null;
        this.Q = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        this.R = false;
        this.S = false;
        this.T = false;
        this.U = false;
        this.V = false;
        this.X = -1;
        this.Y = new float[]{1.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE};
        this.Z = new float[]{1.0f, 1.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE};
        this.aa = GlobalDefine.CLOTHES_CATEGORY_TYPE.Default;
        this.w = -1;
        this.J = null;
        this.M[0] = 1.0f;
        this.M[1] = 1.0f;
        this.M[2] = 1.0f;
        this.N = 1.0f;
        this.O[0] = 1.0f;
        this.O[1] = 1.0f;
        this.O[2] = 1.0f;
        this.O[3] = 1.0f;
        this.O[4] = 1.0f;
        this.O[5] = 1.0f;
        this.O[6] = 1.0f;
        this.O[7] = 1.0f;
        this.O[8] = 1.0f;
        this.O[9] = 1.0f;
        this.O[10] = 1.0f;
        this.O[11] = 1.0f;
        this.O[12] = 1.0f;
        this.O[13] = 0.7f;
    }

    public void a() {
        this.D++;
    }

    public void b() {
        this.D--;
        if (this.D == 0) {
            this.F = System.currentTimeMillis();
        }
    }

    public float c() {
        return ((float) (System.currentTimeMillis() - this.F)) / 1000.0f;
    }

    public int d() {
        return this.D;
    }

    public void e() {
        this.E = true;
    }

    public void f() {
        this.E = false;
    }

    public void g() {
        this.S = true;
        this.K = "gabage mesh";
        if (this.R) {
            this.J.B();
        }
    }

    public boolean h() {
        return this.S;
    }

    public void a(boolean z2) {
        this.T = z2;
    }

    public boolean i() {
        return this.T;
    }

    public void b(boolean z2) {
        this.R = z2;
    }

    public boolean j() {
        return this.R;
    }

    public void c(boolean z2) {
        this.V = z2;
    }

    public void a(GlobalDefine.CLOTHES_CATEGORY_TYPE clothes_category_type) {
        this.aa = clothes_category_type;
    }

    public GlobalDefine.CLOTHES_CATEGORY_TYPE k() {
        return this.aa;
    }

    public boolean l() {
        return this.E;
    }

    public boolean m() {
        if (this.w != -1 && ((this.A != -1 || this.J.r() != -1) && this.J.a())) {
            return true;
        }
        Log.i("FXMesh : ", this.w + " " + this.A + " " + this.J.r() + " " + this.I);
        return false;
    }

    public void a(float[] fArr) {
        if (fArr == null || fArr.length <= 0) {
            Log.e("FXMesh : ", "pos data is not valid");
        } else {
            this.C = (float[]) fArr.clone();
        }
    }

    public void b(float[] fArr) {
        this.M[0] = fArr[0];
        this.M[1] = fArr[1];
        this.M[2] = fArr[2];
    }

    public float[] n() {
        return this.M;
    }

    public void a(float f2) {
        this.N = f2;
    }

    public float o() {
        return this.N;
    }

    public void c(float[] fArr) {
        this.O[0] = fArr[0];
        this.O[1] = fArr[1];
        this.O[2] = fArr[2];
        this.O[3] = fArr[3];
        this.O[4] = fArr[4];
        this.O[5] = fArr[5];
        this.O[6] = fArr[6];
        this.O[7] = fArr[7];
        this.O[8] = fArr[8];
        this.O[9] = fArr[9];
        this.O[10] = fArr[10];
        this.O[11] = fArr[11];
        this.O[12] = fArr[12];
        this.O[13] = fArr[13];
    }

    public float[] p() {
        return this.O;
    }

    public void b(float f2) {
        this.n = f2;
    }

    public void c(float f2) {
        this.o = f2;
    }

    public void d(float f2) {
        this.p = f2;
    }

    public float q() {
        if (this.n > GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
            return this.n;
        }
        return this.J.l();
    }

    public float r() {
        if (this.o > GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
            return this.o;
        }
        return this.J.m();
    }

    public float s() {
        if (this.p > GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
            return this.p;
        }
        return this.J.n();
    }

    public void t() {
        C();
        ah();
        ai();
        E();
        u();
        z();
        A();
        B();
        if (this.J != null) {
            this.J.b();
        }
    }

    public void a(Bitmap bitmap) {
        if (this.c != null) {
            for (Bitmap bitmap2 : this.c) {
                if (bitmap2 != null && !bitmap2.isRecycled()) {
                    bitmap2.recycle();
                }
            }
        }
        this.c = new Bitmap[1];
        this.c[0] = bitmap;
    }

    public void a(Bitmap[] bitmapArr, String[] strArr) {
        if (this.c != null) {
            for (Bitmap bitmap : this.c) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
        }
        this.c = new Bitmap[bitmapArr.length];
        for (int i2 = 0; i2 < bitmapArr.length; i2++) {
            this.c[i2] = bitmapArr[i2];
        }
        this.d = new String[strArr.length];
        for (int i3 = 0; i3 < strArr.length; i3++) {
            this.d[i3] = strArr[i3];
        }
    }

    public void a(String str) {
        if (str != null) {
            this.f = str;
        }
    }

    public void b(Bitmap bitmap) {
        if (this.f697b != null) {
            this.f697b.recycle();
            this.f697b = null;
        }
        this.f697b = bitmap;
        this.U = bitmap != null;
    }

    public void a(Bitmap[] bitmapArr) {
        this.g = bitmapArr;
    }

    public void b(Bitmap[] bitmapArr) {
        this.h = bitmapArr;
    }

    public void d(float[] fArr) {
        this.m = (float[]) fArr.clone();
    }

    public void u() {
        int[] iArr;
        if (this.c != null && this.c.length > 0) {
            int[] iArr2 = this.e;
            this.e = new int[this.c.length];
            for (int i2 = 0; i2 < this.e.length; i2++) {
                this.e[i2] = -1;
            }
            if (this.f697b != null) {
                iArr = new int[(this.f697b.getWidth() * this.f697b.getHeight())];
                this.f697b.getPixels(iArr, 0, this.f697b.getWidth(), 0, 0, this.f697b.getWidth(), this.f697b.getHeight());
            } else {
                iArr = null;
            }
            int[] iArr3 = new int[1];
            for (int i3 = 0; i3 < this.c.length; i3++) {
                Bitmap bitmap = this.c[i3];
                int[] iArr4 = new int[(bitmap.getWidth() * bitmap.getHeight())];
                int[] iArr5 = iArr4;
                bitmap.getPixels(iArr4, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
                if (i3 == 0 && v()) {
                    a(iArr5);
                }
                if (iArr != null) {
                    for (int i4 = 0; i4 < iArr5.length; i4++) {
                        iArr5[i4] = (iArr5[i4] << 8) | (iArr[i4] & 255);
                    }
                } else {
                    for (int i5 = 0; i5 < iArr5.length; i5++) {
                        int i6 = iArr5[i5];
                        iArr5[i5] = (i6 >>> 24) | (i6 << 8);
                    }
                }
                ByteBuffer allocateDirect = ByteBuffer.allocateDirect(bitmap.getWidth() * bitmap.getHeight() * 4);
                IntBuffer asIntBuffer = allocateDirect.asIntBuffer();
                asIntBuffer.position(0);
                asIntBuffer.put(iArr5);
                GLES20.glGenTextures(1, iArr3, 0);
                GLES20.glBindTexture(3553, iArr3[0]);
                GLES20.glTexParameteri(3553, 10241, 9729);
                GLES20.glTexParameteri(3553, 10240, 9729);
                GLES20.glTexImage2D(3553, 0, 6408, bitmap.getWidth(), bitmap.getHeight(), 0, 6408, 5121, allocateDirect);
                allocateDirect.clear();
                bitmap.recycle();
                Log.i("FXMesh : ", "Texture is generated : " + iArr3[0]);
                this.e[i3] = iArr3[0];
            }
            this.c = null;
            GLES20.glBindTexture(3553, 0);
            this.j = this.e[0];
            if (iArr2 != null) {
                for (int i7 = 0; i7 < iArr2.length; i7++) {
                    if (iArr2[i7] != -1) {
                        iArr3[0] = iArr2[i7];
                        GLES20.glDeleteTextures(1, iArr3, 0);
                    }
                }
            }
        }
        if (this.I == h.d.BODY) {
            y();
        }
    }

    public boolean v() {
        return this.I == h.d.INNER || this.I == h.d.PANTS || this.I == h.d.JACK || this.I == h.d.COAT || this.I == h.d.ONEPIECE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int[] r12) {
        /*
            r11 = this;
            r0 = 3
            float[] r0 = new float[r0]
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
        L_0x0008:
            int r6 = r12.length
            r7 = 2
            r8 = 1
            if (r2 >= r6) goto L_0x005a
            r6 = r12[r2]
            int r9 = r6 >> 16
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r10 = r6 >> 8
            r10 = r10 & 255(0xff, float:3.57E-43)
            r6 = r6 & 255(0xff, float:3.57E-43)
            android.graphics.Color.RGBToHSV(r9, r10, r6, r0)
            r6 = r0[r7]
            r7 = 1045220557(0x3e4ccccd, float:0.2)
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 >= 0) goto L_0x0026
            goto L_0x0057
        L_0x0026:
            int r4 = r4 + 1
            r6 = r0[r8]
            r7 = 1048576000(0x3e800000, float:0.25)
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 >= 0) goto L_0x0031
            goto L_0x0057
        L_0x0031:
            r6 = r0[r1]
            r7 = 1101004800(0x41a00000, float:20.0)
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 < 0) goto L_0x0055
            r6 = r0[r1]
            r7 = 1133903872(0x43960000, float:300.0)
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 <= 0) goto L_0x0042
            goto L_0x0055
        L_0x0042:
            r6 = r0[r1]
            r7 = 1110704128(0x42340000, float:45.0)
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 <= 0) goto L_0x0057
            r6 = r0[r1]
            r7 = 1117126656(0x42960000, float:75.0)
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 >= 0) goto L_0x0057
            int r5 = r5 + 1
            goto L_0x0057
        L_0x0055:
            int r3 = r3 + 1
        L_0x0057:
            int r2 = r2 + 100
            goto L_0x0008
        L_0x005a:
            float r12 = (float) r3
            float r0 = (float) r4
            float r12 = r12 / r0
            r2 = 1050253722(0x3e99999a, float:0.3)
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 <= 0) goto L_0x0067
            r12 = 1
        L_0x0065:
            r0 = 0
            goto L_0x0072
        L_0x0067:
            float r12 = (float) r5
            float r12 = r12 / r0
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 <= 0) goto L_0x0070
            r12 = 0
            r0 = 1
            goto L_0x0072
        L_0x0070:
            r12 = 0
            goto L_0x0065
        L_0x0072:
            r2 = 0
            r3 = 1065353216(0x3f800000, float:1.0)
            if (r12 == 0) goto L_0x0092
            if (r0 == 0) goto L_0x0092
            float[] r12 = r11.Y
            r12[r1] = r2
            float[] r12 = r11.Y
            r12[r8] = r3
            float[] r12 = r11.Y
            r12[r7] = r3
            float[] r12 = r11.Z
            r12[r1] = r2
            float[] r12 = r11.Z
            r12[r8] = r3
            float[] r12 = r11.Z
            r12[r7] = r3
            goto L_0x00af
        L_0x0092:
            if (r12 == 0) goto L_0x00a1
            float[] r12 = r11.Y
            r12[r1] = r3
            float[] r12 = r11.Y
            r12[r8] = r3
            float[] r12 = r11.Y
            r12[r7] = r2
            goto L_0x00af
        L_0x00a1:
            if (r0 == 0) goto L_0x00af
            float[] r12 = r11.Z
            r12[r1] = r3
            float[] r12 = r11.Z
            r12[r8] = r2
            float[] r12 = r11.Z
            r12[r7] = r2
        L_0x00af:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.b.k.a(int[]):void");
    }

    public float[] w() {
        return this.Y;
    }

    public float[] x() {
        return this.Z;
    }

    public void y() {
        if (this.d != null) {
            int i2 = 0;
            while (i2 < this.d.length) {
                if (!this.d[i2].equals(this.f) || this.e == null || this.e.length <= i2) {
                    i2++;
                } else {
                    this.j = this.e[i2];
                    return;
                }
            }
        }
    }

    public void z() {
        if (this.g != null) {
            int[] iArr = this.f696a != null ? (int[]) this.f696a.clone() : null;
            int[] iArr2 = new int[1];
            int[] iArr3 = new int[this.g.length];
            for (int i2 = 0; i2 < iArr3.length; i2++) {
                iArr3[i2] = -1;
            }
            for (int i3 = 0; i3 < this.g.length; i3++) {
                GLES20.glGenTextures(1, iArr2, 0);
                GLES20.glBindTexture(3553, iArr2[0]);
                GLES20.glTexParameteri(3553, 10241, 9729);
                GLES20.glTexParameteri(3553, 10240, 9729);
                GLUtils.texImage2D(3553, 0, this.g[i3], 0);
                GLES20.glBindTexture(3553, 0);
                this.g[i3].recycle();
                Log.i("FXMesh : ", "Texture is generated : " + iArr2[0]);
                this.g[i3] = null;
                iArr3[i3] = iArr2[0];
            }
            this.g = null;
            this.f696a = (int[]) iArr3.clone();
            if (iArr != null) {
                for (int i4 = 0; i4 < iArr.length; i4++) {
                    if (iArr[i4] != -1) {
                        iArr2[0] = iArr[i4];
                        GLES20.glDeleteTextures(1, iArr2, 0);
                    }
                }
            }
        }
    }

    public void A() {
        if (this.h != null) {
            int[] iArr = new int[1];
            if (this.l != null) {
                for (int i2 = 0; i2 < this.l.length; i2++) {
                    if (this.l[i2] != -1) {
                        iArr[0] = this.l[i2];
                        GLES20.glDeleteTextures(1, iArr, 0);
                        this.l[i2] = -1;
                    }
                }
                this.l = null;
            }
            this.l = new int[this.h.length];
            for (int i3 = 0; i3 < this.l.length; i3++) {
                this.l[i3] = -1;
            }
            for (int i4 = 0; i4 < this.h.length; i4++) {
                GLES20.glGenTextures(1, iArr, 0);
                GLES20.glBindTexture(3553, iArr[0]);
                GLES20.glTexParameteri(3553, 10241, 9729);
                GLES20.glTexParameteri(3553, 10240, 9729);
                GLUtils.texImage2D(3553, 0, this.h[i4], 0);
                GLES20.glBindTexture(3553, 0);
                this.h[i4].recycle();
                Log.i("FXMesh : ", "Texture is generated : " + iArr[0]);
                this.h[i4] = null;
                this.l[i4] = iArr[0];
            }
            this.h = null;
        }
    }

    public void B() {
        if (this.m != null && this.m.length > 0) {
            int i2 = this.B;
            FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect((this.m.length * 32) / 8).order(ByteOrder.nativeOrder()).asFloatBuffer();
            asFloatBuffer.put(this.m).position(0);
            int[] iArr = new int[1];
            GLES20.glGenBuffers(1, iArr, 0);
            asFloatBuffer.rewind();
            GLES20.glBindBuffer(34962, iArr[0]);
            GLES20.glBufferData(34962, (asFloatBuffer.capacity() * 32) / 8, asFloatBuffer, 35044);
            GLES20.glBindBuffer(34962, 0);
            asFloatBuffer.clear();
            this.B = iArr[0];
            if (i2 != -1) {
                Log.i("FXMesh : ", "mPartIDVBO is already exist. Destroy and generate vbo..");
                GLES20.glDeleteBuffers(1, new int[]{i2}, 0);
            }
            Log.i("FXMesh : ", "mPartIDVBO is generated : " + this.B);
        }
        this.m = null;
    }

    public void e(float[] fArr) {
        this.q = (float[]) fArr.clone();
        this.r = (float[]) fArr.clone();
        if (this.I != h.d.INNER && this.I != h.d.PANTS && this.I != h.d.JACK && this.I != h.d.COAT && this.I != h.d.ONEPIECE) {
            if (this.s == null || this.t == null) {
                float[] fArr2 = new float[(fArr.length / 3)];
                for (int i2 = 0; i2 < fArr2.length; i2++) {
                    fArr2[i2] = 0.0f;
                }
                l(fArr2);
                m(fArr2);
            }
        }
    }

    public void C() {
        if (this.q != null && this.q.length > 0) {
            int i2 = this.w;
            FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect((this.q.length * 32) / 8).order(ByteOrder.nativeOrder()).asFloatBuffer();
            asFloatBuffer.put(this.q).position(0);
            int[] iArr = new int[1];
            GLES20.glGenBuffers(1, iArr, 0);
            asFloatBuffer.rewind();
            GLES20.glBindBuffer(34962, iArr[0]);
            GLES20.glBufferData(34962, (asFloatBuffer.capacity() * 32) / 8, asFloatBuffer, 35044);
            GLES20.glBindBuffer(34962, 0);
            asFloatBuffer.clear();
            this.w = iArr[0];
            if (i2 != -1) {
                Log.i("FXMesh : ", "mPosVBO is already exist. Destroy and generate vbo..");
                GLES20.glDeleteBuffers(1, new int[]{i2}, 0);
            }
            Log.i("FXMesh : ", "mPosVBO is generated : " + this.w);
        }
        this.q = null;
        D();
    }

    public void D() {
        if (this.u != null && this.u.length > 0) {
            int i2 = this.z;
            FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect((this.u.length * 32) / 8).order(ByteOrder.nativeOrder()).asFloatBuffer();
            asFloatBuffer.put(this.u).position(0);
            int[] iArr = new int[1];
            GLES20.glGenBuffers(1, iArr, 0);
            asFloatBuffer.rewind();
            GLES20.glBindBuffer(34962, iArr[0]);
            GLES20.glBufferData(34962, (asFloatBuffer.capacity() * 32) / 8, asFloatBuffer, 35044);
            GLES20.glBindBuffer(34962, 0);
            asFloatBuffer.clear();
            this.z = iArr[0];
            if (i2 != -1) {
                Log.i("FXMesh : ", "mPosVBO is already exist. Destroy and generate vbo..");
                GLES20.glDeleteBuffers(1, new int[]{i2}, 0);
            }
            Log.i("FXMesh : ", "mSupplimentPosVBO is generated : " + this.z);
        }
        this.u = null;
    }

    public void f(float[] fArr) {
        this.v = (float[]) fArr.clone();
    }

    public void E() {
        if (this.v != null && this.v.length > 0) {
            int i2 = this.A;
            FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect((this.v.length * 32) / 8).order(ByteOrder.nativeOrder()).asFloatBuffer();
            asFloatBuffer.put(this.v).position(0);
            int[] iArr = new int[1];
            GLES20.glGenBuffers(1, iArr, 0);
            asFloatBuffer.rewind();
            GLES20.glBindBuffer(34962, iArr[0]);
            GLES20.glBufferData(34962, (asFloatBuffer.capacity() * 32) / 8, asFloatBuffer, 35044);
            GLES20.glBindBuffer(34962, 0);
            asFloatBuffer.clear();
            this.A = iArr[0];
            if (i2 != -1) {
                Log.i("FXMesh : ", "mTexVBO is already exist. Destroy and generate vbo..");
                GLES20.glDeleteBuffers(1, new int[]{i2}, 0);
            }
            Log.i("FXMesh : ", "mTexVBO is generated : " + this.A);
        }
        this.v = null;
    }

    public void a(GL10 gl10) {
        int[] iArr = new int[1];
        if (this.w != -1) {
            iArr[0] = this.w;
            GLES20.glDeleteBuffers(1, iArr, 0);
            this.w = -1;
        }
        if (this.x != -1) {
            iArr[0] = this.x;
            GLES20.glDeleteBuffers(1, iArr, 0);
            this.x = -1;
        }
        if (this.y != -1) {
            iArr[0] = this.y;
            GLES20.glDeleteBuffers(1, iArr, 0);
            this.y = -1;
        }
        if (this.A != -1) {
            iArr[0] = this.A;
            GLES20.glDeleteBuffers(1, iArr, 0);
            this.A = -1;
        }
        if (this.B != -1) {
            iArr[0] = this.B;
            GLES20.glDeleteBuffers(1, iArr, 0);
            this.B = -1;
        }
        if (this.k != -1) {
            iArr[0] = this.k;
            GLES20.glDeleteTextures(1, iArr, 0);
            this.k = -1;
        }
        if (this.f696a != null) {
            for (int i2 = 0; i2 < this.f696a.length; i2++) {
                if (this.f696a[i2] != -1) {
                    iArr[0] = this.f696a[i2];
                    GLES20.glDeleteTextures(1, iArr, 0);
                    this.f696a[i2] = -1;
                }
            }
        }
        this.f696a = null;
        if (this.l != null) {
            for (int i3 = 0; i3 < this.l.length; i3++) {
                if (this.l[i3] != -1) {
                    iArr[0] = this.l[i3];
                    GLES20.glDeleteTextures(1, iArr, 0);
                    this.l[i3] = -1;
                }
            }
        }
        this.l = null;
        if (this.e != null) {
            for (int i4 = 0; i4 < this.e.length; i4++) {
                if (this.e[i4] != -1) {
                    iArr[0] = this.e[i4];
                    GLES20.glDeleteTextures(1, iArr, 0);
                    this.e[i4] = -1;
                }
            }
        }
        this.j = -1;
        this.e = null;
        this.C = null;
        this.m = null;
        if (this.c != null) {
            for (Bitmap bitmap : this.c) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
        }
        this.c = null;
        if (this.f697b != null) {
            this.f697b.recycle();
            this.f697b = null;
        }
        if (this.g != null) {
            for (int i5 = 0; i5 < this.g.length; i5++) {
                this.g[i5].recycle();
                this.g[i5] = null;
            }
            this.g = null;
        }
        if (this.h != null) {
            for (int i6 = 0; i6 < this.h.length; i6++) {
                this.h[i6].recycle();
                this.h[i6] = null;
            }
            this.h = null;
        }
        this.q = null;
        this.v = null;
        this.K = null;
        this.L = null;
    }

    public int F() {
        return this.w;
    }

    public int G() {
        return this.x;
    }

    public int H() {
        return this.y;
    }

    public int I() {
        if (this.A >= 0) {
            return this.A;
        }
        return this.J.r();
    }

    public int J() {
        return this.J.s();
    }

    public int K() {
        if (this.B != -1) {
            return this.B;
        }
        return this.J.t();
    }

    public int L() {
        return this.J.u();
    }

    public int M() {
        return this.J.v();
    }

    public int N() {
        return this.J.w();
    }

    public int O() {
        return this.J.x();
    }

    public void a(h.d dVar) {
        this.I = dVar;
    }

    public h.d P() {
        return this.I;
    }

    public void a(int i2) {
        this.i = i2;
    }

    public int Q() {
        return this.i;
    }

    public void b(int i2) {
        if (!"release".equals("release")) {
            Log.d("FXMesh : ", "SetTextureID()+, textureID: " + i2);
        }
        this.j = i2;
    }

    public int R() {
        if (this.k != -1) {
            return this.k;
        }
        return this.j;
    }

    public int S() {
        if (this.e != null) {
            return this.e[0];
        }
        Log.e("FXMesh : ", "GetDefaultTexureID()-, mMainTextureIDs is null, it's mTextureID");
        return this.j;
    }

    public int[] T() {
        return this.l;
    }

    public int U() {
        if (this.f696a == null) {
            return -1;
        }
        return this.f696a[0];
    }

    public int V() {
        if (this.f696a == null) {
            return -1;
        }
        return this.f696a[1];
    }

    public int W() {
        if (this.f696a == null) {
            return -1;
        }
        return this.f696a[2];
    }

    public int X() {
        if (this.f696a == null) {
            return -1;
        }
        return this.f696a[3];
    }

    public void a(e eVar) {
        this.J = eVar;
    }

    public e Y() {
        return this.J;
    }

    public void Z() {
        if (this.J != null) {
            this.J.B();
        }
    }

    public void b(String str) {
        this.K = str;
    }

    public String aa() {
        return this.K;
    }

    public void c(int i2) {
        int[] iArr = new int[1];
        if (this.k != -1) {
            iArr[0] = this.k;
            GLES20.glDeleteTextures(1, iArr, 0);
            this.k = -1;
        }
        this.k = i2;
    }

    public void e(float f2) {
        this.Q = f2;
    }

    public float ab() {
        return this.Q;
    }

    private boolean n(float[] fArr) {
        if (this.L == null || this.L.length != fArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < fArr.length; i2++) {
            if (Math.abs(fArr[i2] - this.L[i2]) > 1.0E-7f) {
                return false;
            }
        }
        Log.i("FXMesh : ", "Blendweight is same, VBO is reserved.");
        return true;
    }

    public float a(float[] fArr, int[] iArr, float f2) {
        return this.J != null ? this.J.a(fArr, this.J.q(), iArr, f2) : GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    }

    public float[] a(float[] fArr, p pVar, boolean z2) {
        if (z2 || !n(fArr) || this.P == null) {
            float[] fArr2 = null;
            if (this.J != null) {
                float[] a2 = this.J.a(fArr, this.J.q());
                if (a2 == null) {
                    Log.e("FXMesh : ", "[c] ERROR: ApplyBlendWeight updatedPos == null");
                    return null;
                }
                if (this.C != null) {
                    g(a2);
                }
                if (this.P != null) {
                    this.P[0] = a2[(this.J.y()[(int) this.P[1]] * 3) + 1];
                    this.P[2] = a2[(this.J.y()[(int) this.P[3]] * 3) + 1];
                    Log.e("FXMesh : ", "[c] GetTuckInBlendWeight mLastTuckInValue update : " + this.P[0]);
                    return this.P;
                }
                fArr2 = l.a(pVar, a2, this.J.y(), this.J.z(), this.f697b, this.I);
                if (fArr2 != null) {
                    this.P = fArr2;
                }
            }
            return fArr2;
        }
        Log.e("FXMesh : ", "[c] GetTuckInBlendWeight isAlreadyApplied true : " + this.P);
        return this.P;
    }

    public void a(float[] fArr, p pVar) {
        if (!n(fArr)) {
            if (this.J != null) {
                float[] a2 = this.J.a(fArr, this.J.q());
                if (a2 == null) {
                    Log.e("FXMesh : ", "[c] ERROR: ApplyBlendWeight updatedPos == null");
                    return;
                }
                if (this.C != null) {
                    g(a2);
                    e(h(a2));
                    this.L = (float[]) fArr.clone();
                } else {
                    e(h(a2));
                    this.L = (float[]) fArr.clone();
                }
                if (this.I != h.d.HEAD && this.I != h.d.HAIR && this.I != h.d.SHOES && this.I != h.d.NONE) {
                    float[] fArr2 = new float[((this.J.z().length / 4) * 2)];
                    float[] fArr3 = {100000.0f, 100000.0f, 100000.0f};
                    float[] a3 = l.a(pVar, a2, this.J.y(), this.J.z(), fArr2, (short[]) null, this.J.A(), this.f697b);
                    b(a3[0]);
                    c(a3[1]);
                    d(a3[2]);
                    d(fArr2);
                    return;
                }
                return;
            }
            Log.e("FXMesh : ", "mPos or mMeshBlendShape is null");
        }
    }

    public void f(float f2) {
        this.G = f2;
    }

    public float ac() {
        return this.G;
    }

    public void g(float f2) {
        this.H = f2;
    }

    public float ad() {
        return this.H;
    }

    public void g(float[] fArr) {
        if (this.C == null) {
            Log.e("FXMesh : ", "mTargetPos is null");
            return;
        }
        if (fArr.length != this.C.length) {
            Log.e("FXMesh : ", "basePos length is not equal to targetPos length");
        }
        float[] q2 = this.J.q();
        for (int i2 = 0; i2 < fArr.length; i2++) {
            fArr[i2] = fArr[i2] + (this.C[i2] - q2[i2]);
        }
    }

    public float[] h(float[] fArr) {
        int[] y2 = this.J.y();
        if (y2 == null) {
            Log.e("FXMesh : ", "[c] ERROR: GetNativeVertex mappingTable == null");
            return fArr;
        }
        float[] fArr2 = new float[(y2.length * 3)];
        for (int i2 = 0; i2 < y2.length; i2++) {
            int i3 = i2 * 3;
            fArr2[i3 + 0] = fArr[(y2[i2] * 3) + 0];
            fArr2[i3 + 1] = fArr[(y2[i2] * 3) + 1];
            fArr2[i3 + 2] = fArr[(y2[i2] * 3) + 2];
        }
        return fArr2;
    }

    public float[] i(float[] fArr) {
        int[] y2 = this.J.y();
        if (y2 == null) {
            Log.e("FXMesh : ", "[c] ERROR: GetNativeScalar mappingTable == null");
            return fArr;
        }
        float[] fArr2 = new float[y2.length];
        for (int i2 = 0; i2 < y2.length; i2++) {
            fArr2[i2] = fArr[y2[i2]];
        }
        return fArr2;
    }

    public void j(float[] fArr) {
        this.W = (float[]) fArr.clone();
    }

    public float[] ae() {
        return this.W;
    }

    public boolean af() {
        int i2 = 0;
        if (this.J == null) {
            Log.e("FXMesh : ", "[i] UpdateCollisionTable failed since the blendShape is not ready");
            return false;
        } else if (this.J.j() == null) {
            Log.e("FXMesh : ", "[i] UpdateCollisionTable() - no base mesh exists -" + this.i);
            return false;
        } else if (this.W != null && this.W.length == this.J.j().p().length / 3) {
            return true;
        } else {
            if (this.f697b == null) {
                int length = this.J.j().p().length / 3;
                if (length > 0) {
                    this.W = new float[length];
                    while (i2 < length) {
                        this.W[i2] = 1.0f;
                        i2++;
                    }
                } else {
                    Log.e("FXMesh : ", "[i] UpdateCollisionTable() - no mesh vertex data exists -" + this.i);
                    return false;
                }
            } else {
                float[] z2 = this.J.j().z();
                int[] x2 = this.J.j().x();
                this.W = new float[(this.J.j().p().length / 3)];
                while (i2 < x2.length) {
                    int i3 = i2 * 2;
                    this.W[x2[i2]] = ((float) (this.f697b.getPixel((int) (z2[i3] * ((float) this.f697b.getWidth())), (int) ((1.0f - z2[i3 + 1]) * ((float) this.f697b.getHeight()))) & 255)) / 255.0f;
                    i2++;
                }
            }
            return true;
        }
    }

    public float[] ag() {
        return this.r;
    }

    public void k(float[] fArr) {
        this.q = (float[]) fArr.clone();
    }

    public void l(float[] fArr) {
        this.s = (float[]) fArr.clone();
    }

    public void m(float[] fArr) {
        this.t = (float[]) fArr.clone();
    }

    public void ah() {
        if (this.s != null && this.s.length > 0) {
            int i2 = this.x;
            FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect((this.s.length * 32) / 8).order(ByteOrder.nativeOrder()).asFloatBuffer();
            asFloatBuffer.put(this.s).position(0);
            int[] iArr = new int[1];
            GLES20.glGenBuffers(1, iArr, 0);
            asFloatBuffer.rewind();
            GLES20.glBindBuffer(34962, iArr[0]);
            GLES20.glBufferData(34962, (asFloatBuffer.capacity() * 32) / 8, asFloatBuffer, 35048);
            GLES20.glBindBuffer(34962, 0);
            asFloatBuffer.clear();
            this.x = iArr[0];
            if (i2 != -1) {
                Log.i("FXMesh : ", "mStrainVBO is already exist. Destroy and generate vbo..");
                GLES20.glDeleteBuffers(1, new int[]{i2}, 0);
            }
            Log.i("FXMesh : ", "mStrainVBO is generated : " + this.x);
        }
        this.s = null;
    }

    public void ai() {
        if (this.t != null && this.t.length > 0) {
            int i2 = this.y;
            FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect((this.t.length * 32) / 8).order(ByteOrder.nativeOrder()).asFloatBuffer();
            asFloatBuffer.put(this.t).position(0);
            int[] iArr = new int[1];
            GLES20.glGenBuffers(1, iArr, 0);
            asFloatBuffer.rewind();
            GLES20.glBindBuffer(34962, iArr[0]);
            GLES20.glBufferData(34962, (asFloatBuffer.capacity() * 32) / 8, asFloatBuffer, 35048);
            GLES20.glBindBuffer(34962, 0);
            asFloatBuffer.clear();
            this.y = iArr[0];
            if (i2 != -1) {
                Log.i("FXMesh : ", "mStrainVBO is already exist. Destroy and generate vbo..");
                GLES20.glDeleteBuffers(1, new int[]{i2}, 0);
            }
            Log.i("FXMesh : ", "mPressureVBO is generated : " + this.y);
        }
        this.t = null;
    }

    public void d(int i2) {
        this.X = i2;
    }

    public int aj() {
        return this.X;
    }

    public float[] ak() {
        return this.L;
    }
}
```
This is the content for `k.java`. I'll create the file.
