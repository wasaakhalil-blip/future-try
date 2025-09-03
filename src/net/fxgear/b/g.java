package net.fxgear.b;

import android.graphics.Point;
import android.opengl.Matrix;
import android.view.MotionEvent;
import javax.microedition.khronos.opengles.GL10;
import net.fxgear.GlobalDefine;
import net.fxgear.b.h;

/* compiled from: FXCamera */
public class g {
    private float[] A = new float[3];
    private float B = 53.8f;
    private float C = 30.8f;
    private float D = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    private float E = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    private boolean F = false;
    private float G = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    private float H = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    private float I = -80.0f;
    private float J = -60.0f;
    private final float[] K = {GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 73.0f, 410.0f};
    private final float[] L = {GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 40.0f, 410.0f};
    private float M = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    private final float N = 50.0f;
    private boolean O = false;
    private p P;

    /* renamed from: a  reason: collision with root package name */
    float f678a = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;

    /* renamed from: b  reason: collision with root package name */
    float f679b = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    int c = 0;
    h.e d = h.e.NONE;
    private final int e = 0;
    private final int f = 1;
    private final int g = 2;
    private final int h = 3;
    private float i = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    private float j = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    private float k = 1.0f;
    private float l = 1.0f;
    private Point m = new Point();
    private float[] n = new float[16];
    private float[] o = new float[16];
    private float[] p = new float[16];
    private float[] q = new float[16];
    private float[] r = new float[16];
    private float[] s = new float[16];
    private float[] t = new float[16];
    private final float[] u = {GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 73.0f, 410.0f};
    private final float[] v = {GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 7.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE};
    private final float[] w = {GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE};
    private float[] x = new float[3];
    private float[] y = new float[3];
    private float[] z = new float[3];

    public float b(float f2) {
        return (f2 * 3.1415927f) / 180.0f;
    }

    public g() {
    }

    public g(float f2, float f3, float f4, h.e eVar) {
        this.i = f2;
        this.j = f3;
        this.k = f4;
        this.d = eVar;
        this.z[0] = 0.0f;
        this.z[1] = 0.0f;
        this.z[2] = 0.0f;
        this.x[0] = 0.0f;
        this.x[1] = this.I;
        this.x[2] = 0.0f;
        this.y[0] = 0.0f;
        this.y[1] = 0.0f;
        this.y[2] = 0.0f;
        this.A[0] = -1000000.0f;
        this.A[1] = -106.0f;
        this.A[2] = 0.0f;
        this.u[0] = this.K[0];
        this.u[1] = this.K[1];
        this.u[2] = this.K[2];
        double tan = Math.tan((double) (b(this.C) / 2.0f));
        double sqrt = (double) ((float) Math.sqrt((double) (((this.u[0] - this.v[0]) * (this.u[0] - this.v[0])) + ((this.u[1] - this.v[1]) * (this.u[1] - this.v[1])) + ((this.u[2] - this.v[2]) * (this.u[2] - this.v[2])))));
        Double.isNaN(sqrt);
        this.D = ((float) (tan * sqrt)) * 2.0f;
        this.P = new p();
    }

    public void a() {
        this.i = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        this.j = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        this.k = 1.0f;
        this.z[0] = 0.0f;
        this.z[1] = 0.0f;
        this.z[2] = 0.0f;
        if (this.O) {
            this.x[0] = 0.0f;
            this.x[1] = this.J;
            this.x[2] = 0.0f;
            this.u[0] = this.L[0];
            this.u[1] = this.L[1];
            this.u[2] = this.L[2];
        } else {
            this.x[0] = 0.0f;
            this.x[1] = this.I;
            this.x[2] = 0.0f;
            this.u[0] = this.K[0];
            this.u[1] = this.K[1];
            this.u[2] = this.K[2];
        }
        this.y[0] = 0.0f;
        this.y[1] = 0.0f;
        this.y[2] = 0.0f;
        this.A[0] = -1000000.0f;
        this.A[1] = -106.0f;
        this.A[2] = 0.0f;
    }

    public void b() {
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.A = null;
        if (this.P != null) {
            this.P.a((GL10) null);
            this.P = null;
        }
    }

    public void a(boolean z2) {
        this.O = z2;
        if (z2) {
            this.x[0] = 0.0f;
            this.x[1] = this.J;
            this.x[2] = 0.0f;
            this.u[0] = this.L[0];
            this.u[1] = this.L[1];
            this.u[2] = this.L[2];
            return;
        }
        this.x[0] = 0.0f;
        this.x[1] = this.I;
        this.x[2] = 0.0f;
        this.u[0] = this.K[0];
        this.u[1] = this.K[1];
        this.u[2] = this.K[2];
    }

    public void a(float f2) {
        this.M = f2;
    }

    public void c() {
        Matrix.setIdentityM(this.n, 0);
        Matrix.setIdentityM(this.p, 0);
        Matrix.setIdentityM(this.q, 0);
        Matrix.setIdentityM(this.s, 0);
        Matrix.setIdentityM(this.t, 0);
        Matrix.setIdentityM(this.r, 0);
        float f2 = this.G / this.H;
        float f3 = this.O ? -20.0f : -80.0f;
        if (this.d == h.e.AVATAR || this.d == h.e.CHECK_CLOTHES_SIZE) {
            Matrix.perspectiveM(this.o, 0, this.C, f2, 10.0f, 600.0f);
            Matrix.setLookAtM(this.p, 0, this.u[0], this.u[1], this.u[2], this.v[0], this.v[1], this.v[2], this.w[0], this.w[1], this.w[2]);
            Matrix.translateM(this.s, 0, this.x[0], this.x[1], this.x[2]);
            Matrix.translateM(this.t, 0, this.y[0], this.y[1], this.y[2]);
            Matrix.scaleM(this.q, 0, this.k, this.k, this.k);
            Matrix.rotateM(this.r, 0, this.j, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        } else if (this.d == h.e.AVATAR_HAIR_EDITING) {
            Matrix.perspectiveM(this.o, 0, this.C, f2, 10.0f, 600.0f);
            Matrix.setLookAtM(this.p, 0, this.u[0], this.u[1], this.u[2], this.v[0], this.v[1], this.v[2], this.w[0], this.w[1], this.w[2]);
            Matrix.translateM(this.s, 0, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, f3 - this.M, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
            Matrix.translateM(this.t, 0, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, -70.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
            Matrix.scaleM(this.q, 0, 3.0f, 3.0f, 3.0f);
            Matrix.rotateM(this.r, 0, this.j, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        } else if (this.d == h.e.AVATAR_CUSTOM_FACE_EDITING) {
            Matrix.perspectiveM(this.o, 0, this.C, f2, 10.0f, 600.0f);
            Matrix.setLookAtM(this.p, 0, this.u[0], this.u[1], this.u[2], this.v[0], this.v[1], this.v[2], this.w[0], this.w[1], this.w[2]);
            Matrix.translateM(this.s, 0, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, f3 - this.M, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
            Matrix.translateM(this.t, 0, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, -70.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
            Matrix.scaleM(this.q, 0, 3.0f, 3.0f, 3.0f);
            Matrix.rotateM(this.r, 0, this.j, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        } else if (this.d == h.e.AVATAR_FACE_EDITING) {
            Matrix.perspectiveM(this.o, 0, this.C, f2, 10.0f, 600.0f);
            Matrix.setLookAtM(this.p, 0, this.u[0], this.u[1], this.u[2], this.v[0], this.v[1], this.v[2], this.w[0], this.w[1], this.w[2]);
            Matrix.translateM(this.s, 0, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, f3 - this.M, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
            Matrix.translateM(this.t, 0, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, -70.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
            Matrix.scaleM(this.q, 0, 3.0f, 3.0f, 3.0f);
            Matrix.rotateM(this.r, 0, this.j, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        } else if (this.d == h.e.AVATAR_SKIN_TONE_EDITING) {
            Matrix.perspectiveM(this.o, 0, this.C, f2, 10.0f, 600.0f);
            Matrix.setLookAtM(this.p, 0, this.u[0], this.u[1], this.u[2], this.v[0], this.v[1], this.v[2], this.w[0], this.w[1], this.w[2]);
            Matrix.translateM(this.s, 0, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, (f3 + 5.0f) - this.M, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
            Matrix.translateM(this.t, 0, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, -70.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
            Matrix.scaleM(this.q, 0, 3.0f, 3.0f, 3.0f);
            Matrix.rotateM(this.r, 0, this.j, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        } else if (this.d == h.e.AVATAR_BODY_EDITING) {
            Matrix.perspectiveM(this.o, 0, this.C, f2, 10.0f, 600.0f);
            Matrix.setLookAtM(this.p, 0, this.u[0], this.u[1], this.u[2] + 50.0f, this.v[0], this.v[1], this.v[2], this.w[0], this.w[1], this.w[2]);
            Matrix.translateM(this.s, 0, this.x[0], this.x[1], this.x[2]);
            Matrix.translateM(this.t, 0, this.y[0], this.y[1], this.y[2]);
            Matrix.scaleM(this.q, 0, this.k, this.k, this.k);
            Matrix.rotateM(this.r, 0, this.j, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        } else if (this.d == h.e.REAL) {
            Matrix.perspectiveM(this.o, 0, this.B, f2, 50.0f, 400.0f);
            if (this.P.w() == 1) {
                Matrix.setIdentityM(this.s, 0);
                Matrix.setIdentityM(this.t, 0);
                Matrix.setIdentityM(this.q, 0);
                Matrix.setIdentityM(this.r, 0);
                Matrix.setIdentityM(this.p, 0);
                Matrix.setIdentityM(this.o, 0);
                float[] v2 = this.P.v();
                float[] u2 = this.P.u();
                float[] t2 = this.P.t();
                this.o[0] = t2[0];
                this.o[1] = t2[4];
                this.o[2] = t2[8];
                this.o[3] = t2[12];
                this.o[4] = t2[1];
                this.o[5] = t2[5];
                this.o[6] = t2[9];
                this.o[7] = t2[13];
                this.o[8] = t2[2];
                this.o[9] = t2[6];
                this.o[10] = t2[10];
                this.o[11] = t2[14];
                this.o[12] = t2[3];
                this.o[13] = t2[7];
                this.o[14] = t2[11];
                this.o[15] = t2[15];
                float f4 = f2 * 1080.0f;
                this.o[0] = (this.o[0] * 608.0f) / f4;
                this.o[8] = (((((((this.o[8] - 1.0f) * -0.5f) * 608.0f) * f4) / 608.0f) * -2.0f) / f4) + 1.0f;
                this.o[5] = (this.o[5] * 1080.0f) / 1080.0f;
                this.o[9] = (((((((this.o[9] - 1.0f) * -0.5f) * 1080.0f) * 1080.0f) / 1080.0f) * -2.0f) / 1080.0f) + 1.0f;
                this.r[0] = u2[0];
                this.r[1] = u2[3];
                this.r[2] = u2[6];
                this.r[3] = 0.0f;
                this.r[4] = u2[1];
                this.r[5] = u2[4];
                this.r[6] = u2[7];
                this.r[7] = 0.0f;
                this.r[8] = u2[2];
                this.r[9] = u2[5];
                this.r[10] = u2[8];
                this.r[11] = 0.0f;
                this.r[12] = 0.0f;
                this.r[13] = 0.0f;
                this.r[14] = 0.0f;
                this.r[15] = 1.0f;
                Matrix.translateM(this.s, 0, (v2[0] * 100.0f) + this.P.j[0], (v2[1] * 100.0f) + this.P.j[1], ((-v2[2]) * 100.0f) + this.P.j[2]);
            } else if (this.P.s() != null) {
                Matrix.setLookAtM(this.p, 0, -this.P.s()[0], this.P.s()[1], this.P.s()[2], -this.P.s()[0], this.P.s()[1], -240.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
            }
            this.k = 1.0f;
        } else if (this.d == h.e.CAPTURE) {
            Matrix.perspectiveM(this.o, 0, this.C, f2, 10.0f, 600.0f);
            Matrix.setLookAtM(this.p, 0, this.u[0], this.u[1], this.u[2], this.v[0], this.v[1], this.v[2], this.w[0], this.w[1], this.w[2]);
            Matrix.translateM(this.s, 0, this.x[0], this.x[1], this.x[2]);
            Matrix.translateM(this.t, 0, this.y[0], this.y[1], this.y[2]);
            Matrix.scaleM(this.q, 0, this.k, this.k, this.k);
            Matrix.rotateM(this.r, 0, this.j, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        }
        Matrix.multiplyMM(this.n, 0, this.s, 0, this.n, 0);
        Matrix.multiplyMM(this.n, 0, this.t, 0, this.n, 0);
        Matrix.multiplyMM(this.n, 0, this.q, 0, this.n, 0);
        Matrix.multiplyMM(this.n, 0, this.r, 0, this.n, 0);
        Matrix.multiplyMM(this.n, 0, this.p, 0, this.n, 0);
        Matrix.multiplyMM(this.n, 0, this.o, 0, this.n, 0);
    }

    public void a(MotionEvent motionEvent) {
        this.A[0] = -1000000.0f;
        this.c = 1;
        this.m.x = (int) motionEvent.getX();
        this.m.y = (int) motionEvent.getY();
        this.F = false;
    }

    public void a(MotionEvent motionEvent, boolean z2, boolean z3) {
        if (this.c != 3) {
            this.f678a = a(motionEvent, z3);
            if (this.f678a > 100.0f && this.c != 3) {
                this.c = 2;
            }
        }
    }

    public void b(MotionEvent motionEvent) {
        this.c = 3;
        this.f678a = 100.0f;
    }

    public void a(MotionEvent motionEvent, boolean z2, boolean z3, boolean z4) {
        if (this.c != 3) {
            if (this.c == 1 && z2) {
                this.j += (motionEvent.getX() - ((float) this.m.x)) * 0.2f;
                this.i += (motionEvent.getY() - ((float) this.m.y)) * 0.2f;
                this.m.x = (int) motionEvent.getX();
                this.m.y = (int) motionEvent.getY();
            } else if (this.c == 2 && (z3 || z4)) {
                this.f679b = a(motionEvent, z4);
                if (this.f679b > 100.0f && this.c != 3 && z3) {
                    c(this.f679b / this.f678a);
                    this.f678a = this.f679b;
                }
            }
            this.i = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        }
    }

    private float a(MotionEvent motionEvent, boolean z2) {
        if (motionEvent.getPointerCount() == 2) {
            if (!this.F) {
                this.F = true;
                this.z[0] = 0.0f;
                this.z[1] = ((-(motionEvent.getY(0) + motionEvent.getY(1))) / 2.0f) + (this.H / 2.0f);
                this.z[2] = 0.0f;
                this.l = this.k;
            }
            float x2 = motionEvent.getX(0) - motionEvent.getX(1);
            float y2 = motionEvent.getY(0) - motionEvent.getY(1);
            if (z2) {
                if (this.A[0] > -100000.0f) {
                    float f2 = this.E / this.k;
                    float[] fArr = this.y;
                    fArr[1] = fArr[1] - ((((motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f) - this.A[1]) * f2);
                    this.A[0] = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
                    this.A[1] = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
                    float f3 = (((this.k / this.l) * this.z[1]) - this.z[1]) * f2;
                    this.z[1] = (this.k / this.l) * this.z[1];
                    this.l = this.k;
                    float[] fArr2 = this.y;
                    fArr2[1] = fArr2[1] - f3;
                    if (this.y[1] > this.k * 30.0f) {
                        this.y[1] = this.k * 30.0f;
                    }
                    if (this.y[1] < this.k * -30.0f) {
                        this.y[1] = this.k * -30.0f;
                    }
                } else {
                    this.A[0] = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
                    this.A[1] = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
                }
            }
            return (float) Math.sqrt((double) ((x2 * x2) + (y2 * y2)));
        } else if (motionEvent.getPointerCount() > 2) {
            this.c = 3;
            return GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        } else {
            this.c = 3;
            float x3 = motionEvent.getX(0);
            float y3 = motionEvent.getY(0);
            return (float) Math.sqrt((double) ((x3 * x3) + (y3 * y3)));
        }
    }

    public void c(float f2) {
        this.k *= f2;
        if (this.k < 0.5f) {
            this.k = 0.5f;
        }
        if (this.k > 3.8f) {
            this.k = 3.8f;
        }
    }

    public void c(MotionEvent motionEvent) {
        this.c = 0;
    }

    public float[] d() {
        c();
        return this.n;
    }

    public int e() {
        return (int) this.G;
    }

    public int f() {
        return (int) this.H;
    }

    public float g() {
        return this.j;
    }

    public void d(float f2) {
        this.k = f2;
        if (this.k > 3.8f) {
            this.k = 3.8f;
        }
        if (this.k < 0.5f) {
            this.k = 0.5f;
        }
    }

    public float h() {
        return this.k;
    }

    public void e(float f2) {
        this.y[1] = f2 * this.k;
        if (this.y[1] > this.k * 30.0f) {
            this.y[1] = this.k * 30.0f;
        }
        if (this.y[1] < this.k * -30.0f) {
            this.y[1] = this.k * -30.0f;
        }
    }

    public float i() {
        return this.y[1] / this.k;
    }

    public void a(int i2, int i3) {
        this.G = (float) i2;
        this.H = (float) i3;
        this.E = this.D / this.H;
    }

    public void a(p pVar) {
        this.P = pVar;
    }

    public float[] j() {
        return this.x;
    }

    public float[] k() {
        return this.y;
    }

    public void a(g gVar) {
        this.j = gVar.g();
        this.k = gVar.h();
        this.x[0] = gVar.j()[0];
        this.x[1] = gVar.j()[1];
        this.x[2] = gVar.j()[2];
        this.y[0] = gVar.k()[0];
        this.y[1] = gVar.k()[1];
        this.y[2] = gVar.k()[2];
    }
}
