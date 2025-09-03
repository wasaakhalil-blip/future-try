package net.fxgear.b;

import android.opengl.GLES20;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.opengles.GL10;
import net.fxgear.fittingview.qlSolver;

/* compiled from: FXBaseMesh */
public class d {
    private float A;
    private boolean B;

    /* renamed from: a  reason: collision with root package name */
    private float[] f672a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f673b;
    private float[] c;
    private boolean d;
    private float[] e;
    private boolean f;
    private short[] g;
    private boolean h;
    private short[] i;
    private short[] j;
    private float[] k;
    private int[] l;
    private float[] m;
    private boolean n;
    private float[] o;
    private boolean p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private float y;
    private float z;

    public d() {
        this.f672a = null;
        this.f673b = false;
        this.c = null;
        this.d = false;
        this.e = null;
        this.f = false;
        this.g = null;
        this.h = false;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = false;
        this.o = null;
        this.p = false;
        this.q = -1;
        this.r = -1;
        this.s = -1;
        this.t = -1;
        this.u = -1;
        this.v = -1;
        this.w = -1;
        this.x = -1;
        this.y = -1.0f;
        this.z = -1.0f;
        this.A = -1.0f;
        this.B = true;
        this.x = -1;
        this.k = null;
        this.r = -1;
        this.s = -1;
        this.t = -1;
        this.w = -1;
        this.v = -1;
    }

    public boolean a() {
        if (this.q != -1 && this.r != -1 && this.s != -1 && this.u != -1 && this.v != -1) {
            return true;
        }
        Log.i("FXBaseMesh : ", this.q + " " + this.r + " " + this.s + " " + this.t + " " + this.u + " " + this.v);
        return false;
    }

    public void a(GL10 gl10) {
        this.x = -1;
        this.w = -1;
        this.f672a = null;
        this.c = null;
        this.e = null;
        this.m = null;
        this.g = null;
        this.k = null;
        this.l = null;
        this.o = null;
        int[] iArr = new int[1];
        if (this.q != -1) {
            iArr[0] = this.q;
            GLES20.glDeleteBuffers(1, iArr, 0);
            this.q = -1;
        }
        if (this.r != -1) {
            iArr[0] = this.r;
            GLES20.glDeleteBuffers(1, iArr, 0);
            this.r = -1;
        }
        if (this.s != -1) {
            iArr[0] = this.s;
            GLES20.glDeleteBuffers(1, iArr, 0);
            this.s = -1;
        }
        if (this.t != -1) {
            iArr[0] = this.t;
            GLES20.glDeleteBuffers(1, iArr, 0);
            this.t = -1;
        }
        if (this.u != -1) {
            iArr[0] = this.u;
            GLES20.glDeleteBuffers(1, iArr, 0);
            this.u = -1;
        }
        if (this.v != -1) {
            iArr[0] = this.v;
            GLES20.glDeleteBuffers(1, iArr, 0);
            this.v = -1;
        }
    }

    public void b() {
        c();
        d();
        e();
        f();
        k();
        l();
    }

    public void a(boolean z2) {
        this.B = z2;
    }

    public void a(float[] fArr) {
        this.o = (float[]) fArr.clone();
        this.p = true;
    }

    public void c() {
        if (this.p) {
            if (this.o == null || this.o.length <= 0) {
                Log.e("FXBaseMesh : ", "mTex data is not valid");
            } else {
                int i2 = this.q;
                FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect((this.o.length * 32) / 8).order(ByteOrder.nativeOrder()).asFloatBuffer();
                asFloatBuffer.put(this.o).position(0);
                int[] iArr = new int[1];
                GLES20.glGenBuffers(1, iArr, 0);
                asFloatBuffer.rewind();
                GLES20.glBindBuffer(34962, iArr[0]);
                GLES20.glBufferData(34962, (asFloatBuffer.capacity() * 32) / 8, asFloatBuffer, 35044);
                GLES20.glBindBuffer(34962, 0);
                asFloatBuffer.clear();
                this.q = iArr[0];
                if (i2 != -1) {
                    Log.i("FXBaseMesh : ", "mTexVBO is already exist. Destroy and generate vbo..");
                    GLES20.glDeleteBuffers(1, new int[]{i2}, 0);
                }
                Log.i("FXBaseMesh : ", "mTexVBO is generated : " + this.q);
            }
            this.p = false;
        }
    }

    public void b(float[] fArr) {
        this.f672a = (float[]) fArr.clone();
        this.f673b = true;
    }

    public void d() {
        if (this.f673b) {
            if (this.f672a == null || this.f672a.length <= 0) {
                Log.e("FXBaseMesh : ", "mBoneWeight data is not valid");
            } else {
                int i2 = this.r;
                FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect((this.f672a.length * 32) / 8).order(ByteOrder.nativeOrder()).asFloatBuffer();
                asFloatBuffer.put(this.f672a).position(0);
                int[] iArr = new int[1];
                GLES20.glGenBuffers(1, iArr, 0);
                asFloatBuffer.rewind();
                GLES20.glBindBuffer(34962, iArr[0]);
                GLES20.glBufferData(34962, (asFloatBuffer.capacity() * 32) / 8, asFloatBuffer, 35044);
                GLES20.glBindBuffer(34962, 0);
                asFloatBuffer.clear();
                this.r = iArr[0];
                if (i2 != -1) {
                    Log.i("FXBaseMesh : ", "mJointWeightVBO is already exist. Destroy and generate vbo..");
                    GLES20.glDeleteBuffers(1, new int[]{i2}, 0);
                }
                Log.i("FXBaseMesh : ", "mBoneWeightVBO is generated : " + this.r);
            }
            this.f672a = null;
            this.f673b = false;
        }
    }

    public void c(float[] fArr) {
        this.m = (float[]) fArr.clone();
        this.n = true;
    }

    public void e() {
        if (this.n) {
            if (this.m == null || this.m.length <= 0) {
                Log.e("FXBaseMesh : ", "mBoneID data is not valid");
            } else {
                int i2 = this.s;
                float[] fArr = new float[this.m.length];
                for (int i3 = 0; i3 < this.m.length; i3++) {
                    fArr[i3] = this.m[i3];
                }
                FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect((fArr.length * 32) / 8).order(ByteOrder.nativeOrder()).asFloatBuffer();
                asFloatBuffer.put(fArr).position(0);
                int[] iArr = new int[1];
                GLES20.glGenBuffers(1, iArr, 0);
                asFloatBuffer.rewind();
                GLES20.glBindBuffer(34962, iArr[0]);
                GLES20.glBufferData(34962, (asFloatBuffer.capacity() * 32) / 8, asFloatBuffer, 35044);
                GLES20.glBindBuffer(34962, 0);
                asFloatBuffer.clear();
                this.s = iArr[0];
                if (i2 != -1) {
                    Log.i("FXBaseMesh : ", "mBoneIDVBO is already exist. Destroy and generate vbo..");
                    GLES20.glDeleteBuffers(1, new int[]{i2}, 0);
                }
                Log.i("FXBaseMesh : ", "mBoneIDVBO is generated : " + this.s);
            }
            this.n = false;
        }
    }

    public void d(float[] fArr) {
        this.c = (float[]) fArr.clone();
        this.d = true;
    }

    public void f() {
        if (!this.B) {
            this.c = null;
            this.d = false;
        } else if (this.d) {
            if (this.c == null || this.c.length <= 0) {
                Log.e("FXBaseMesh : ", "mNor data is not valid");
            } else {
                int i2 = this.t;
                FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect((this.c.length * 32) / 8).order(ByteOrder.nativeOrder()).asFloatBuffer();
                asFloatBuffer.put(this.c).position(0);
                int[] iArr = new int[1];
                GLES20.glGenBuffers(1, iArr, 0);
                asFloatBuffer.rewind();
                GLES20.glBindBuffer(34962, iArr[0]);
                GLES20.glBufferData(34962, (asFloatBuffer.capacity() * 32) / 8, asFloatBuffer, 35044);
                GLES20.glBindBuffer(34962, 0);
                asFloatBuffer.clear();
                this.t = iArr[0];
                if (i2 != -1) {
                    Log.i("FXBaseMesh : ", "mNorVBO is already exist. Destroy and generate vbo..");
                    GLES20.glDeleteBuffers(1, new int[]{i2}, 0);
                }
                Log.i("FXBaseMesh : ", "mNorVBO is generated : " + this.t);
            }
            this.c = null;
            this.d = false;
        }
    }

    public void a(short[] sArr) {
        this.g = (short[]) sArr.clone();
        this.h = true;
    }

    public void g() {
        if (this.j == null) {
            this.j = new short[this.g.length];
            for (int i2 = 0; i2 < this.g.length; i2++) {
                this.j[i2] = (short) this.l[this.g[i2]];
            }
        }
    }

    public short[] h() {
        return this.j;
    }

    public void i() {
        if (this.i == null) {
            this.i = qlSolver.getEdgeIds(this.j);
        }
    }

    public short[] j() {
        return this.i;
    }

    public void k() {
        if (this.h) {
            if (this.g == null || this.g.length <= 0) {
                Log.e("FXBaseMesh : ", "mIndex data is not valid");
            } else {
                int i2 = this.v;
                ShortBuffer asShortBuffer = ByteBuffer.allocateDirect((this.g.length * 16) / 8).order(ByteOrder.nativeOrder()).asShortBuffer();
                asShortBuffer.put(this.g).position(0);
                int[] iArr = new int[1];
                GLES20.glGenBuffers(1, iArr, 0);
                asShortBuffer.rewind();
                GLES20.glBindBuffer(34962, iArr[0]);
                GLES20.glBufferData(34962, (asShortBuffer.capacity() * 16) / 8, asShortBuffer, 35044);
                GLES20.glBindBuffer(34962, 0);
                asShortBuffer.clear();
                this.v = iArr[0];
                if (i2 != -1) {
                    Log.e("FXBaseMesh : ", "mIndexVBO is already exist. Destroy and generate vbo..");
                    GLES20.glDeleteBuffers(1, new int[]{i2}, 0);
                }
                Log.i("FXBaseMesh : ", "mIndexVBO is generated : " + this.v);
            }
            this.g = null;
            this.h = false;
        }
    }

    public void e(float[] fArr) {
        this.e = (float[]) fArr.clone();
        this.f = true;
    }

    public void l() {
        if (this.f) {
            if (this.e == null || this.e.length <= 0) {
                Log.e("FXBaseMesh : ", "mPartID data is not valid");
            } else {
                int i2 = this.u;
                FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect((this.e.length * 32) / 8).order(ByteOrder.nativeOrder()).asFloatBuffer();
                asFloatBuffer.put(this.e).position(0);
                int[] iArr = new int[1];
                GLES20.glGenBuffers(1, iArr, 0);
                asFloatBuffer.rewind();
                GLES20.glBindBuffer(34962, iArr[0]);
                GLES20.glBufferData(34962, (asFloatBuffer.capacity() * 32) / 8, asFloatBuffer, 35044);
                GLES20.glBindBuffer(34962, 0);
                asFloatBuffer.clear();
                this.u = iArr[0];
                if (i2 != -1) {
                    Log.i("FXBaseMesh : ", "mPartIDVBO is already exist. Destroy and generate vbo..");
                    GLES20.glDeleteBuffers(1, new int[]{i2}, 0);
                }
                Log.i("FXBaseMesh : ", "mPartIDVBO is generated : " + this.u);
            }
            this.e = null;
            this.f = false;
        }
    }

    public void a(int i2) {
        this.x = i2;
    }

    public void a(float f2) {
        this.y = f2;
    }

    public void b(float f2) {
        this.z = f2;
    }

    public void c(float f2) {
        this.A = f2;
    }

    public float m() {
        return this.y;
    }

    public float n() {
        return this.z;
    }

    public float o() {
        return this.A;
    }

    public void f(float[] fArr) {
        this.k = (float[]) fArr.clone();
    }

    public float[] p() {
        return this.k;
    }

    public int q() {
        return this.q;
    }

    public int r() {
        return this.t;
    }

    public int s() {
        return this.r;
    }

    public int t() {
        return this.s;
    }

    public int u() {
        return this.u;
    }

    public int v() {
        return this.v;
    }

    public void b(int i2) {
        if (i2 <= 0) {
            Log.e("FXBaseMesh : ", "SetIndexCount error posVBO:" + i2);
            return;
        }
        this.w = i2;
    }

    public int w() {
        return this.w;
    }

    public void a(int[] iArr) {
        this.l = (int[]) iArr.clone();
    }

    public int[] x() {
        return this.l;
    }

    public float[] y() {
        return this.m;
    }

    public float[] z() {
        return this.o;
    }
}
