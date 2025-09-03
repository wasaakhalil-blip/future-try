package net.fxgear.b;

import android.opengl.Matrix;
import android.util.Log;
import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL10;
import net.fxgear.GlobalDefine;
import net.fxgear.b.p;

/* compiled from: FXAnimator */
public class b {
    private int A = 0;
    private float B = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    private float[] C = new float[4];
    private float[] D = new float[4];
    private float[] E = new float[4];
    private j F = new j();
    private j G = new j();
    private j H = new j();
    private final float[] I = {GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE};
    private final float[] J = {1.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE};
    private j K = new j();
    private j L = new j();

    /* renamed from: a  reason: collision with root package name */
    q f668a = new q();

    /* renamed from: b  reason: collision with root package name */
    q f669b = new q();
    float[] c = new float[3];
    float[] d = new float[3];
    q e = new q();
    q f = new q();
    q g = new q();
    q h = new q();
    q i = new q();
    i j = null;
    float[] k = new float[4];
    float[] l = new float[4];
    float[] m = new float[3];
    float[] n = new float[3];
    float[] o = new float[3];
    float[] p = new float[3];
    float[] q = new float[3];
    float[] r = new float[3];
    float[] s = new float[3];
    float[] t = new float[3];
    float[] u = new float[3];
    q v = new q();
    private n w = null;
    private p x = null;
    private p.a y = null;
    private p.a z = null;

    public b(n nVar) {
        this.w = nVar;
        this.f668a.b();
        this.f669b.b();
        this.e.b();
        this.f.b();
        this.g.b();
        this.h.b();
        this.i.b();
    }

    public void a() {
        this.w = null;
        if (this.x != null) {
            this.x.a((GL10) null);
            this.x = null;
        }
        this.y = null;
        this.z = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        if (this.f668a != null) {
            this.f668a.a();
            this.f668a = null;
        }
        if (this.f669b != null) {
            this.f669b.a();
            this.f669b = null;
        }
        this.c = null;
        this.d = null;
        if (this.e != null) {
            this.e.a();
            this.e = null;
        }
        if (this.f != null) {
            this.f.a();
            this.f = null;
        }
        if (this.g != null) {
            this.g.a();
            this.g = null;
        }
        if (this.h != null) {
            this.h.a();
            this.h = null;
        }
        if (this.i != null) {
            this.i.a();
            this.i = null;
        }
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        if (this.v != null) {
            this.v.a();
            this.v = null;
        }
    }

    public void a(int i2, int i3) {
        this.x = this.w.c(i3);
        if (this.x != null) {
            this.y = this.x.E();
            if (this.y != null) {
                if (i2 != -2) {
                    this.A = i2;
                    this.B = 1.0f;
                }
                if (this.A == -1) {
                    c();
                    this.x = this.w.c(i3).a();
                    if (this.x != null) {
                        this.y = this.x.E();
                        if (this.y != null) {
                            c();
                        }
                    }
                } else if (this.x.o() == 0) {
                    if (this.A == 0) {
                        this.A = 1;
                    }
                    a(this.x.F());
                    b();
                    this.x = this.w.c(i3).a();
                    if (this.x != null) {
                        this.y = this.x.E();
                        this.z = this.w.c(i3).E();
                        b(this.x.F());
                        b();
                    }
                } else if (this.x.o() == 1) {
                    c(this.x.F());
                    b();
                }
            }
        }
    }

    public void a(float f2, int i2) {
        this.x = this.w.c(i2);
        if (this.x != null) {
            this.y = this.x.E();
            if (this.y != null) {
                if (this.x.o() == 1) {
                    f2 += this.x.c / 30.0f;
                }
                this.A = (int) (((float) this.y.f710b) * f2);
                if (this.A < this.x.e(this.x.F()).p().size() - 2) {
                    this.B = (f2 - (((float) this.A) * this.y.c)) / this.y.c;
                    if (this.B < GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
                        this.B = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
                    }
                    if (this.A == -1) {
                        return;
                    }
                    if (this.x.o() == 0) {
                        if (this.A == 0) {
                            this.A = 1;
                        }
                        a(this.x.F());
                        b();
                        this.x = this.w.c(i2).a();
                        if (this.x != null) {
                            this.y = this.x.E();
                            this.z = this.w.c(i2).E();
                            b(this.x.F());
                            b();
                        }
                    } else if (this.x.o() == 1) {
                        c(this.x.F());
                        b();
                    }
                }
            }
        }
    }

    public static void a(p pVar, int i2) {
        p.a E2 = pVar.E();
        i e2 = pVar.e(i2);
        float[] fArr = {e2.l()[0], e2.l()[1], e2.l()[2], 1.0f};
        q c2 = e2.k().c(e2.i());
        int i3 = i2 * 4;
        int n2 = e2.n();
        if (n2 != -1) {
            int i4 = n2 * 4;
            int i5 = i4 + 0;
            int i6 = i4 + 1;
            int i7 = i4 + 2;
            float[] fArr2 = {E2.k[i5], E2.k[i6], E2.k[i7]};
            q qVar = new q();
            qVar.b();
            qVar.f711a = (double) E2.l[i5];
            qVar.f712b = (double) E2.l[i6];
            qVar.c = (double) E2.l[i7];
            qVar.d = (double) E2.l[i4 + 3];
            c2.a(qVar.c(c2));
            float[] a2 = qVar.a(fArr[0], fArr[1], fArr[2]);
            fArr[0] = a2[0] + fArr2[0];
            fArr[1] = a2[1] + fArr2[1];
            fArr[2] = a2[2] + fArr2[2];
        }
        e2.e(fArr);
        e2.f(c2.f());
        e2.b();
        e2.e();
        int i8 = i3 + 0;
        E2.k[i8] = fArr[0];
        int i9 = i3 + 1;
        E2.k[i9] = fArr[1];
        int i10 = i3 + 2;
        E2.k[i10] = fArr[2];
        int i11 = i3 + 3;
        E2.k[i11] = 1.0f;
        E2.l[i8] = (float) c2.f711a;
        E2.l[i9] = (float) c2.f712b;
        E2.l[i10] = (float) c2.c;
        E2.l[i11] = (float) c2.d;
        for (int i12 = 0; i12 < e2.o().size(); i12++) {
            a(pVar, e2.c(i12));
        }
    }

    public static void b(p pVar, int i2) {
        int i3 = i2;
        p.a E2 = pVar.a().E();
        i e2 = pVar.a().e(i3);
        float[] fArr = {e2.l()[0], e2.l()[1], e2.l()[2], 1.0f};
        q c2 = e2.k().c(e2.i());
        int i4 = i3 * 4;
        int n2 = e2.n();
        if (n2 != -1) {
            int i5 = n2 * 4;
            int i6 = i5 + 0;
            int i7 = i5 + 1;
            int i8 = i5 + 2;
            float[] fArr2 = {E2.k[i6], E2.k[i7], E2.k[i8]};
            q qVar = new q();
            qVar.b();
            qVar.f711a = (double) E2.l[i6];
            qVar.f712b = (double) E2.l[i7];
            qVar.c = (double) E2.l[i8];
            qVar.d = (double) E2.l[i5 + 3];
            c2.a(qVar.c(c2));
            float[] a2 = qVar.a(fArr[0], fArr[1], fArr[2]);
            fArr[0] = a2[0] + fArr2[0];
            fArr[1] = a2[1] + fArr2[1];
            fArr[2] = a2[2] + fArr2[2];
        } else {
            p.a E3 = pVar.E();
            float[] fArr3 = {E3.k[300], E3.k[301], E3.k[302]};
            q qVar2 = new q();
            qVar2.b();
            qVar2.f711a = (double) E3.l[300];
            qVar2.f712b = (double) E3.l[301];
            qVar2.c = (double) E3.l[302];
            qVar2.d = (double) E3.l[303];
            c2.a(qVar2.c(c2));
            float[] a3 = qVar2.a(fArr[0], fArr[1], fArr[2]);
            fArr[0] = a3[0] + fArr3[0];
            fArr[1] = a3[1] + fArr3[1];
            fArr[2] = a3[2] + fArr3[2];
        }
        e2.e(fArr);
        e2.f(c2.f());
        e2.b();
        e2.e();
        int i9 = i4 + 0;
        E2.k[i9] = fArr[0];
        int i10 = i4 + 1;
        E2.k[i10] = fArr[1];
        int i11 = i4 + 2;
        E2.k[i11] = fArr[2];
        int i12 = i4 + 3;
        E2.k[i12] = 1.0f;
        E2.l[i9] = (float) c2.f711a;
        E2.l[i10] = (float) c2.f712b;
        E2.l[i11] = (float) c2.c;
        E2.l[i12] = (float) c2.d;
        for (int i13 = 0; i13 < e2.o().size(); i13++) {
            b(pVar, e2.c(i13));
        }
    }

    public static void c(p pVar, int i2) {
        p.a E2 = pVar.E();
        i e2 = pVar.e(i2);
        float[] fArr = {e2.l()[0], e2.l()[1], e2.l()[2], 1.0f};
        q c2 = e2.k().c(e2.i());
        int i3 = i2 * 4;
        int n2 = e2.n();
        if (n2 != -1) {
            int i4 = n2 * 4;
            int i5 = i4 + 0;
            int i6 = i4 + 1;
            int i7 = i4 + 2;
            float[] fArr2 = {E2.m[i5], E2.m[i6], E2.m[i7]};
            q qVar = new q();
            qVar.b();
            qVar.f711a = (double) E2.n[i5];
            qVar.f712b = (double) E2.n[i6];
            qVar.c = (double) E2.n[i7];
            qVar.d = (double) E2.n[i4 + 3];
            c2.a(qVar.c(c2));
            float[] a2 = qVar.a(fArr[0], fArr[1], fArr[2]);
            fArr[0] = a2[0] + fArr2[0];
            fArr[1] = a2[1] + fArr2[1];
            fArr[2] = a2[2] + fArr2[2];
        }
        e2.e(fArr);
        e2.f(c2.f());
        e2.b();
        e2.e();
        int i8 = i3 + 0;
        E2.m[i8] = fArr[0];
        int i9 = i3 + 1;
        E2.m[i9] = fArr[1];
        int i10 = i3 + 2;
        E2.m[i10] = fArr[2];
        int i11 = i3 + 3;
        E2.m[i11] = 1.0f;
        E2.n[i8] = (float) c2.f711a;
        E2.n[i9] = (float) c2.f712b;
        E2.n[i10] = (float) c2.c;
        E2.n[i11] = (float) c2.d;
        for (int i12 = 0; i12 < e2.o().size(); i12++) {
            c(pVar, e2.c(i12));
        }
    }

    public static void d(p pVar, int i2) {
        int i3 = i2;
        p a2 = pVar.a();
        p.a E2 = a2.E();
        if (E2 == null || E2.m == null || E2.n == null) {
            Log.e("FXAnimator : ", "[c] CalculateDefaultBindPoseHairFromQuaternion error: currentAnimationInfo null!");
            return;
        }
        i e2 = a2.e(i3);
        float[] fArr = {e2.l()[0], e2.l()[1], e2.l()[2], 1.0f};
        q c2 = e2.k().c(e2.i());
        int i4 = i3 * 4;
        int n2 = e2.n();
        if (n2 != -1) {
            int i5 = n2 * 4;
            int i6 = i5 + 0;
            int i7 = i5 + 1;
            int i8 = i5 + 2;
            float[] fArr2 = {E2.m[i6], E2.m[i7], E2.m[i8]};
            q qVar = new q();
            qVar.b();
            qVar.f711a = (double) E2.n[i6];
            qVar.f712b = (double) E2.n[i7];
            qVar.c = (double) E2.n[i8];
            qVar.d = (double) E2.n[i5 + 3];
            c2.a(qVar.c(c2));
            float[] a3 = qVar.a(fArr[0], fArr[1], fArr[2]);
            fArr[0] = a3[0] + fArr2[0];
            fArr[1] = a3[1] + fArr2[1];
            fArr[2] = a3[2] + fArr2[2];
        } else {
            p.a E3 = pVar.E();
            if (E3 == null || E3.m == null || E3.n == null) {
                Log.e("FXAnimator : ", "[c] CalculateDefaultBindPoseHairFromQuaternion error: baseAnimationInfo null!");
                return;
            }
            float[] fArr3 = {E3.m[300], E3.m[301], E3.m[302]};
            q qVar2 = new q();
            qVar2.b();
            qVar2.f711a = (double) E3.n[300];
            qVar2.f712b = (double) E3.n[301];
            qVar2.c = (double) E3.n[302];
            qVar2.d = (double) E3.n[303];
            c2.a(qVar2.c(c2));
            float[] a4 = qVar2.a(fArr[0], fArr[1], fArr[2]);
            fArr[0] = a4[0] + fArr3[0];
            fArr[1] = a4[1] + fArr3[1];
            fArr[2] = a4[2] + fArr3[2];
        }
        e2.e(fArr);
        e2.f(c2.f());
        e2.b();
        e2.e();
        int i9 = i4 + 0;
        E2.m[i9] = fArr[0];
        int i10 = i4 + 1;
        E2.m[i10] = fArr[1];
        int i11 = i4 + 2;
        E2.m[i11] = fArr[2];
        int i12 = i4 + 3;
        E2.m[i12] = 1.0f;
        E2.n[i9] = (float) c2.f711a;
        E2.n[i10] = (float) c2.f712b;
        E2.n[i11] = (float) c2.c;
        E2.n[i12] = (float) c2.d;
        for (int i13 = 0; i13 < e2.o().size(); i13++) {
            d(pVar, e2.c(i13));
        }
    }

    public void a(int i2) {
        this.j = this.x.e(i2);
        this.F = this.j.d(this.A);
        if (this.F == null) {
            Log.e("FXAnimator : ", "Keyframe is missing!");
            return;
        }
        if (this.A + 1 >= this.j.p().size()) {
            this.K = this.F;
        } else {
            j.a(this.F, this.j.d(this.A + 1), this.B, this.K);
        }
        this.E[0] = this.K.g()[0];
        this.E[1] = this.K.g()[1];
        this.E[2] = this.K.g()[2];
        this.E[3] = 1.0f;
        this.D[0] = this.j.l()[0];
        this.D[1] = this.j.l()[1];
        this.D[2] = this.j.l()[2];
        this.D[3] = 1.0f;
        if (i2 == this.x.F()) {
            this.C[0] = this.E[0];
            this.C[1] = this.E[1];
            this.C[2] = this.E[2];
            this.C[3] = 1.0f;
        } else {
            if (i2 >= 73 || i2 == 64) {
                this.C[0] = this.E[0];
                this.C[1] = this.E[1];
                this.C[2] = this.E[2];
            } else {
                this.C[0] = this.D[0];
                this.C[1] = this.D[1];
                this.C[2] = this.D[2];
            }
            this.C[3] = 1.0f;
        }
        this.j.k().a(this.K.f(), this.f668a);
        if (this.j.n() != -1) {
            this.c[0] = this.y.h[(this.j.n() * 4) + 0];
            this.c[1] = this.y.h[(this.j.n() * 4) + 1];
            this.c[2] = this.y.h[(this.j.n() * 4) + 2];
            this.f669b.f711a = (double) this.y.j[(this.j.n() * 4) + 0];
            this.f669b.f712b = (double) this.y.j[(this.j.n() * 4) + 1];
            this.f669b.c = (double) this.y.j[(this.j.n() * 4) + 2];
            this.f669b.d = (double) this.y.j[(this.j.n() * 4) + 3];
            this.f669b.a(this.f668a, this.e);
            this.f668a.a(this.e);
            this.f669b.a(this.C[0], this.C[1], this.C[2], this.d);
            this.C[0] = this.d[0] + this.c[0];
            this.C[1] = this.d[1] + this.c[1];
            this.C[2] = this.d[2] + this.c[2];
        }
        this.j.e(this.C);
        this.j.f(this.f668a.f());
        this.j.b();
        int i3 = i2 * 4;
        int i4 = i3 + 0;
        this.y.h[i4] = this.C[0];
        int i5 = i3 + 1;
        this.y.h[i5] = this.C[1];
        int i6 = i3 + 2;
        this.y.h[i6] = this.C[2];
        int i7 = i3 + 3;
        this.y.h[i7] = 1.0f;
        this.y.j[i4] = (float) this.f668a.f711a;
        this.y.j[i5] = (float) this.f668a.f712b;
        this.y.j[i6] = (float) this.f668a.c;
        this.y.j[i7] = (float) this.f668a.d;
        ArrayList<Integer> o2 = this.j.o();
        for (int i8 = 0; i8 < o2.size(); i8++) {
            a(o2.get(i8).intValue());
        }
    }

    public void b(int i2) {
        this.j = this.x.e(i2);
        this.F = this.j.d(this.A);
        if (this.F == null) {
            Log.e("FXAnimator : ", "Keyframe is missing!");
            return;
        }
        if (this.A + 1 >= this.j.p().size()) {
            this.K = this.F;
        } else {
            j.a(this.F, this.j.d(this.A + 1), this.B, this.K);
        }
        this.C[0] = this.K.g()[0];
        this.C[1] = this.K.g()[1];
        this.C[2] = this.K.g()[2];
        this.C[3] = 1.0f;
        this.j.k().a(this.K.f(), this.f668a);
        if (this.j.n() != -1) {
            this.c[0] = this.y.h[(this.j.n() * 4) + 0];
            this.c[1] = this.y.h[(this.j.n() * 4) + 1];
            this.c[2] = this.y.h[(this.j.n() * 4) + 2];
            this.f669b.f711a = (double) this.y.j[(this.j.n() * 4) + 0];
            this.f669b.f712b = (double) this.y.j[(this.j.n() * 4) + 1];
            this.f669b.c = (double) this.y.j[(this.j.n() * 4) + 2];
            this.f669b.d = (double) this.y.j[(this.j.n() * 4) + 3];
            this.f669b.a(this.f668a, this.e);
            this.f668a.a(this.e);
            this.f669b.a(this.C[0], this.C[1], this.C[2], this.d);
            this.C[0] = this.d[0] + this.c[0];
            this.C[1] = this.d[1] + this.c[1];
            this.C[2] = this.d[2] + this.c[2];
        } else {
            this.c[0] = this.z.h[300];
            this.c[1] = this.z.h[301];
            this.c[2] = this.z.h[302];
            this.f669b.f711a = (double) this.z.j[300];
            this.f669b.f712b = (double) this.z.j[301];
            this.f669b.c = (double) this.z.j[302];
            this.f669b.d = (double) this.z.j[303];
            this.f669b.a(this.f668a, this.e);
            this.f668a.a(this.e);
            this.f669b.a(this.C[0], this.C[1], this.C[2], this.d);
            this.C[0] = this.d[0] + this.c[0];
            this.C[1] = this.d[1] + this.c[1];
            this.C[2] = this.d[2] + this.c[2];
        }
        this.j.e(this.C);
        this.j.f(this.f668a.f());
        this.j.b();
        int i3 = i2 * 4;
        int i4 = i3 + 0;
        this.y.h[i4] = this.C[0];
        int i5 = i3 + 1;
        this.y.h[i5] = this.C[1];
        int i6 = i3 + 2;
        this.y.h[i6] = this.C[2];
        int i7 = i3 + 3;
        this.y.h[i7] = 1.0f;
        this.y.j[i4] = (float) this.f668a.f711a;
        this.y.j[i5] = (float) this.f668a.f712b;
        this.y.j[i6] = (float) this.f668a.c;
        this.y.j[i7] = (float) this.f668a.d;
        ArrayList<Integer> o2 = this.j.o();
        for (int i8 = 0; i8 < o2.size(); i8++) {
            b(o2.get(i8).intValue());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:121:0x05c1  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x06f9 A[LOOP:0: B:123:0x06f3->B:125:0x06f9, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0204  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(int r21) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            net.fxgear.b.p r2 = r0.x
            int r2 = r2.k()
            r3 = 3
            r4 = 2
            r5 = 0
            r6 = 1
            if (r2 == r3) goto L_0x001b
            net.fxgear.b.p r2 = r0.x
            int r2 = r2.k()
            if (r2 != r4) goto L_0x0019
            goto L_0x001b
        L_0x0019:
            r2 = 0
            goto L_0x001c
        L_0x001b:
            r2 = 1
        L_0x001c:
            net.fxgear.b.p r7 = r0.x
            net.fxgear.b.i r7 = r7.e((int) r1)
            r0.j = r7
            net.fxgear.b.p r7 = r0.x
            java.lang.String r7 = r7.m()
            java.lang.String r8 = "Woman/Animation_55.bin"
            boolean r7 = r7.contains(r8)
            if (r7 != 0) goto L_0x0060
            net.fxgear.b.p r7 = r0.x
            java.lang.String r7 = r7.m()
            java.lang.String r9 = "Woman/Animation_66.bin"
            boolean r7 = r7.contains(r9)
            if (r7 != 0) goto L_0x0060
            net.fxgear.b.p r7 = r0.x
            java.lang.String r7 = r7.m()
            java.lang.String r9 = "Boy/Animation_120.bin"
            boolean r7 = r7.contains(r9)
            if (r7 != 0) goto L_0x0060
            net.fxgear.b.p r7 = r0.x
            java.lang.String r7 = r7.m()
            java.lang.String r9 = "Boy/Animation_160.bin"
            boolean r7 = r7.contains(r9)
            if (r7 == 0) goto L_0x005d
            goto L_0x0060
        L_0x005d:
            r7 = 0
        L_0x005e:
            r9 = 0
            goto L_0x00a0
        L_0x0060:
            net.fxgear.b.p r7 = r0.x
            java.lang.String r7 = r7.m()
            java.lang.String r9 = "Woman/Animation_55.bin"
            boolean r7 = r7.contains(r9)
            if (r7 != 0) goto L_0x0099
            net.fxgear.b.p r7 = r0.x
            java.lang.String r7 = r7.m()
            java.lang.String r9 = "Woman/Animation_66.bin"
            boolean r7 = r7.contains(r9)
            if (r7 != 0) goto L_0x0099
            net.fxgear.b.p r7 = r0.x
            java.lang.String r7 = r7.m()
            java.lang.String r9 = "Boy/Animation_160.bin"
            boolean r7 = r7.contains(r9)
            if (r7 == 0) goto L_0x008b
            goto L_0x0099
        L_0x008b:
            net.fxgear.b.p r7 = r0.x
            java.lang.String r7 = r7.m()
            java.lang.String r9 = "Boy/Animation_120.bin"
            boolean r7 = r7.contains(r9)
            r7 = 1
            goto L_0x005e
        L_0x0099:
            r7 = 1061997773(0x3f4ccccd, float:0.8)
            r7 = 1
            r9 = 1061997773(0x3f4ccccd, float:0.8)
        L_0x00a0:
            r10 = 51
            r11 = -1
            if (r1 != r10) goto L_0x00e6
            if (r7 == 0) goto L_0x00e6
            net.fxgear.b.p r7 = r0.x
            java.lang.String r7 = r7.m()
            java.lang.String r10 = "Woman/Animation_55.bin"
            boolean r7 = r7.contains(r10)
            if (r7 != 0) goto L_0x00e3
            net.fxgear.b.p r7 = r0.x
            java.lang.String r7 = r7.m()
            java.lang.String r10 = "Woman/Animation_66.bin"
            boolean r7 = r7.contains(r10)
            if (r7 != 0) goto L_0x00e3
            net.fxgear.b.p r7 = r0.x
            java.lang.String r7 = r7.m()
            java.lang.String r10 = "Boy/Animation_160.bin"
            boolean r7 = r7.contains(r10)
            if (r7 == 0) goto L_0x00d2
            goto L_0x00e3
        L_0x00d2:
            net.fxgear.b.p r7 = r0.x
            java.lang.String r7 = r7.m()
            java.lang.String r10 = "Boy/Animation_120.bin"
            boolean r7 = r7.contains(r10)
            if (r7 == 0) goto L_0x012b
            r7 = 48
            goto L_0x012c
        L_0x00e3:
            r7 = 49
            goto L_0x012c
        L_0x00e6:
            r10 = 55
            if (r1 != r10) goto L_0x012b
            if (r7 == 0) goto L_0x012b
            net.fxgear.b.p r7 = r0.x
            java.lang.String r7 = r7.m()
            java.lang.String r10 = "Woman/Animation_55.bin"
            boolean r7 = r7.contains(r10)
            if (r7 != 0) goto L_0x0128
            net.fxgear.b.p r7 = r0.x
            java.lang.String r7 = r7.m()
            java.lang.String r10 = "Woman/Animation_66.bin"
            boolean r7 = r7.contains(r10)
            if (r7 != 0) goto L_0x0128
            net.fxgear.b.p r7 = r0.x
            java.lang.String r7 = r7.m()
            java.lang.String r10 = "Boy/Animation_160.bin"
            boolean r7 = r7.contains(r10)
            if (r7 == 0) goto L_0x0117
            goto L_0x0128
        L_0x0117:
            net.fxgear.b.p r7 = r0.x
            java.lang.String r7 = r7.m()
            java.lang.String r10 = "Boy/Animation_120.bin"
            boolean r7 = r7.contains(r10)
            if (r7 == 0) goto L_0x012b
            r7 = 52
            goto L_0x012c
        L_0x0128:
            r7 = 53
            goto L_0x012c
        L_0x012b:
            r7 = -1
        L_0x012c:
            net.fxgear.b.i r10 = r0.j
            int r12 = r0.A
            net.fxgear.b.j r10 = r10.d((int) r12)
            r0.F = r10
            if (r7 < 0) goto L_0x0146
            net.fxgear.b.p r10 = r0.x
            net.fxgear.b.i r10 = r10.e((int) r7)
            int r12 = r0.A
            net.fxgear.b.j r10 = r10.d((int) r12)
            r0.H = r10
        L_0x0146:
            int r10 = r0.A
            int r10 = r10 + r6
            net.fxgear.b.i r12 = r0.j
            java.util.ArrayList r12 = r12.p()
            int r12 = r12.size()
            if (r10 < r12) goto L_0x0164
            net.fxgear.b.j r10 = r0.F
            if (r10 == 0) goto L_0x015d
            net.fxgear.b.j r10 = r0.F
            r0.K = r10
        L_0x015d:
            if (r7 < 0) goto L_0x018e
            net.fxgear.b.j r10 = r0.H
            r0.L = r10
            goto L_0x018e
        L_0x0164:
            net.fxgear.b.j r10 = r0.F
            net.fxgear.b.i r12 = r0.j
            int r13 = r0.A
            int r13 = r13 + r6
            net.fxgear.b.j r12 = r12.d((int) r13)
            float r13 = r0.B
            net.fxgear.b.j r14 = r0.K
            net.fxgear.b.j.a(r10, r12, r13, r14)
            if (r7 < 0) goto L_0x018e
            net.fxgear.b.j r10 = r0.H
            net.fxgear.b.p r12 = r0.x
            net.fxgear.b.i r12 = r12.e((int) r7)
            int r13 = r0.A
            int r13 = r13 + r6
            net.fxgear.b.j r12 = r12.d((int) r13)
            float r13 = r0.B
            net.fxgear.b.j r14 = r0.L
            net.fxgear.b.j.a(r10, r12, r13, r14)
        L_0x018e:
            net.fxgear.b.p r10 = r0.x
            int r10 = r10.F()
            r12 = 1065353216(0x3f800000, float:1.0)
            if (r1 != r10) goto L_0x01c1
            float[] r10 = r0.k
            net.fxgear.b.j r13 = r0.K
            float[] r13 = r13.g()
            r13 = r13[r5]
            r10[r5] = r13
            float[] r10 = r0.k
            net.fxgear.b.j r13 = r0.K
            float[] r13 = r13.g()
            r13 = r13[r6]
            r10[r6] = r13
            float[] r10 = r0.k
            net.fxgear.b.j r13 = r0.K
            float[] r13 = r13.g()
            r13 = r13[r4]
            r10[r4] = r13
            float[] r10 = r0.k
            r10[r3] = r12
            goto L_0x01e9
        L_0x01c1:
            float[] r10 = r0.k
            net.fxgear.b.i r13 = r0.j
            float[] r13 = r13.l()
            r13 = r13[r5]
            r10[r5] = r13
            float[] r10 = r0.k
            net.fxgear.b.i r13 = r0.j
            float[] r13 = r13.l()
            r13 = r13[r6]
            r10[r6] = r13
            float[] r10 = r0.k
            net.fxgear.b.i r13 = r0.j
            float[] r13 = r13.l()
            r13 = r13[r4]
            r10[r4] = r13
            float[] r10 = r0.k
            r10[r3] = r12
        L_0x01e9:
            net.fxgear.b.i r10 = r0.j
            net.fxgear.b.q r10 = r10.k()
            net.fxgear.b.i r13 = r0.j
            net.fxgear.b.q r13 = r13.i()
            net.fxgear.b.q r14 = r0.f668a
            r10.a((net.fxgear.b.q) r13, (net.fxgear.b.q) r14)
            int r10 = r1 * 4
            net.fxgear.b.i r13 = r0.j
            int r13 = r13.n()
            if (r13 == r11) goto L_0x05c1
            int r11 = r13 * 4
            float[] r8 = r0.c
            net.fxgear.b.p$a r12 = r0.y
            float[] r12 = r12.h
            int r17 = r11 + 0
            r12 = r12[r17]
            r8[r5] = r12
            float[] r8 = r0.c
            net.fxgear.b.p$a r12 = r0.y
            float[] r12 = r12.h
            int r18 = r11 + 1
            r12 = r12[r18]
            r8[r6] = r12
            float[] r8 = r0.c
            net.fxgear.b.p$a r12 = r0.y
            float[] r12 = r12.h
            int r19 = r11 + 2
            r12 = r12[r19]
            r8[r4] = r12
            net.fxgear.b.q r8 = r0.f669b
            net.fxgear.b.p$a r12 = r0.y
            float[] r12 = r12.j
            r12 = r12[r17]
            double r14 = (double) r12
            r8.f711a = r14
            net.fxgear.b.q r8 = r0.f669b
            net.fxgear.b.p$a r12 = r0.y
            float[] r12 = r12.j
            r12 = r12[r18]
            double r14 = (double) r12
            r8.f712b = r14
            net.fxgear.b.q r8 = r0.f669b
            net.fxgear.b.p$a r12 = r0.y
            float[] r12 = r12.j
            r12 = r12[r19]
            double r14 = (double) r12
            r8.c = r14
            net.fxgear.b.q r8 = r0.f669b
            net.fxgear.b.p$a r12 = r0.y
            float[] r12 = r12.j
            int r11 = r11 + r3
            r12 = r12[r11]
            double r14 = (double) r12
            r8.d = r14
            net.fxgear.b.q r8 = r0.f669b
            net.fxgear.b.q r12 = r0.f668a
            net.fxgear.b.q r14 = r0.e
            r8.a((net.fxgear.b.q) r12, (net.fxgear.b.q) r14)
            net.fxgear.b.q r8 = r0.f668a
            net.fxgear.b.q r12 = r0.e
            r8.a((net.fxgear.b.q) r12)
            net.fxgear.b.q r8 = r0.f669b
            float[] r12 = r0.k
            r12 = r12[r5]
            float[] r14 = r0.k
            r14 = r14[r6]
            float[] r15 = r0.k
            r15 = r15[r4]
            float[] r3 = r0.d
            r8.a((float) r12, (float) r14, (float) r15, (float[]) r3)
            float[] r3 = r0.l
            float[] r8 = r0.d
            r8 = r8[r5]
            float[] r12 = r0.c
            r12 = r12[r5]
            float r8 = r8 + r12
            r3[r5] = r8
            float[] r3 = r0.l
            float[] r8 = r0.d
            r8 = r8[r6]
            float[] r12 = r0.c
            r12 = r12[r6]
            float r8 = r8 + r12
            r3[r6] = r8
            float[] r3 = r0.l
            float[] r8 = r0.d
            r8 = r8[r4]
            float[] r12 = r0.c
            r12 = r12[r4]
            float r8 = r8 + r12
            r3[r4] = r8
            if (r2 == 0) goto L_0x02ad
            r3 = 75
            if (r1 == r3) goto L_0x02ab
            r3 = 89
            if (r1 != r3) goto L_0x02ad
        L_0x02ab:
            r3 = 1
            goto L_0x02ae
        L_0x02ad:
            r3 = 0
        L_0x02ae:
            net.fxgear.b.i r8 = r0.j
            boolean r8 = r8.a()
            if (r8 == 0) goto L_0x064a
            net.fxgear.b.j r8 = r0.F
            if (r8 == 0) goto L_0x064a
            net.fxgear.b.j r8 = r0.F
            boolean r8 = r8.b()
            if (r8 != 0) goto L_0x064a
            if (r3 != 0) goto L_0x064a
            r3 = 72
            r8 = 68
            r12 = 67
            if (r1 != r12) goto L_0x02cf
            r3 = 68
            goto L_0x02e3
        L_0x02cf:
            if (r1 != r8) goto L_0x02d4
            r3 = 67
            goto L_0x02e3
        L_0x02d4:
            r14 = 70
            if (r1 != r14) goto L_0x02db
            if (r2 != 0) goto L_0x02e2
            goto L_0x02e3
        L_0x02db:
            r14 = 71
            if (r1 != r14) goto L_0x02e2
            if (r2 != 0) goto L_0x02e2
            goto L_0x02e3
        L_0x02e2:
            r3 = r13
        L_0x02e3:
            net.fxgear.b.p r14 = r0.x
            net.fxgear.b.i r14 = r14.e((int) r3)
            int r15 = r0.A
            net.fxgear.b.j r14 = r14.d((int) r15)
            int r15 = r0.A
            int r15 = r15 + r6
            net.fxgear.b.i r8 = r0.j
            java.util.ArrayList r8 = r8.p()
            int r8 = r8.size()
            if (r15 < r8) goto L_0x030a
            if (r14 != 0) goto L_0x0307
            java.lang.String r3 = "FXAnimator : "
            java.lang.String r8 = "null!!"
            android.util.Log.e(r3, r8)
        L_0x0307:
            r0.G = r14
            goto L_0x031e
        L_0x030a:
            net.fxgear.b.p r8 = r0.x
            net.fxgear.b.i r3 = r8.e((int) r3)
            int r8 = r0.A
            int r8 = r8 + r6
            net.fxgear.b.j r3 = r3.d((int) r8)
            float r8 = r0.B
            net.fxgear.b.j r15 = r0.G
            net.fxgear.b.j.a(r14, r3, r8, r15)
        L_0x031e:
            float[] r3 = r0.o
            float[] r8 = r0.l
            r8 = r8[r5]
            float[] r14 = r0.c
            r14 = r14[r5]
            float r8 = r8 - r14
            r3[r5] = r8
            float[] r3 = r0.o
            float[] r8 = r0.l
            r8 = r8[r6]
            float[] r14 = r0.c
            r14 = r14[r6]
            float r8 = r8 - r14
            r3[r6] = r8
            float[] r3 = r0.o
            float[] r8 = r0.l
            r8 = r8[r4]
            float[] r14 = r0.c
            r14 = r14[r4]
            float r8 = r8 - r14
            r3[r4] = r8
            r3 = 70
            if (r1 == r3) goto L_0x034d
            r3 = 71
            if (r1 != r3) goto L_0x034f
        L_0x034d:
            if (r2 == 0) goto L_0x0359
        L_0x034f:
            if (r1 == r12) goto L_0x0359
            r2 = 68
            if (r1 != r2) goto L_0x0356
            goto L_0x0359
        L_0x0356:
            r16 = 0
            goto L_0x035b
        L_0x0359:
            r16 = 1065353216(0x3f800000, float:1.0)
        L_0x035b:
            float[] r2 = r0.p
            net.fxgear.b.j r3 = r0.G
            float[] r3 = r3.g()
            r3 = r3[r5]
            float r3 = r3 * r16
            net.fxgear.b.p$a r8 = r0.y
            float[] r8 = r8.h
            r8 = r8[r17]
            r14 = 1065353216(0x3f800000, float:1.0)
            float r15 = r14 - r16
            float r8 = r8 * r15
            float r3 = r3 + r8
            r2[r5] = r3
            float[] r2 = r0.p
            net.fxgear.b.j r3 = r0.G
            float[] r3 = r3.g()
            r3 = r3[r6]
            float r3 = r3 * r16
            net.fxgear.b.p$a r8 = r0.y
            float[] r8 = r8.h
            r8 = r8[r18]
            float r8 = r8 * r15
            float r3 = r3 + r8
            r2[r6] = r3
            float[] r2 = r0.p
            net.fxgear.b.j r3 = r0.G
            float[] r3 = r3.g()
            r3 = r3[r4]
            float r3 = r3 * r16
            net.fxgear.b.p$a r8 = r0.y
            float[] r8 = r8.h
            r8 = r8[r19]
            float r8 = r8 * r15
            float r3 = r3 + r8
            r2[r4] = r3
            if (r7 < 0) goto L_0x03f6
            float[] r2 = r0.q
            net.fxgear.b.j r3 = r0.K
            float[] r3 = r3.g()
            r3 = r3[r5]
            float r3 = r3 * r9
            net.fxgear.b.j r7 = r0.L
            float[] r7 = r7.g()
            r7 = r7[r5]
            r8 = 1065353216(0x3f800000, float:1.0)
            float r14 = r8 - r9
            float r7 = r7 * r14
            float r3 = r3 + r7
            r2[r5] = r3
            float[] r2 = r0.q
            net.fxgear.b.j r3 = r0.K
            float[] r3 = r3.g()
            r3 = r3[r6]
            float r3 = r3 * r9
            net.fxgear.b.j r7 = r0.L
            float[] r7 = r7.g()
            r7 = r7[r6]
            float r7 = r7 * r14
            float r3 = r3 + r7
            r2[r6] = r3
            float[] r2 = r0.q
            net.fxgear.b.j r3 = r0.K
            float[] r3 = r3.g()
            r3 = r3[r4]
            float r3 = r3 * r9
            net.fxgear.b.j r7 = r0.L
            float[] r7 = r7.g()
            r7 = r7[r4]
            float r7 = r7 * r14
            float r3 = r3 + r7
            r2[r4] = r3
            goto L_0x041a
        L_0x03f6:
            float[] r2 = r0.q
            net.fxgear.b.j r3 = r0.K
            float[] r3 = r3.g()
            r3 = r3[r5]
            r2[r5] = r3
            float[] r2 = r0.q
            net.fxgear.b.j r3 = r0.K
            float[] r3 = r3.g()
            r3 = r3[r6]
            r2[r6] = r3
            float[] r2 = r0.q
            net.fxgear.b.j r3 = r0.K
            float[] r3 = r3.g()
            r3 = r3[r4]
            r2[r4] = r3
        L_0x041a:
            float[] r2 = r0.r
            float[] r3 = r0.q
            r3 = r3[r5]
            float[] r7 = r0.p
            r7 = r7[r5]
            float r3 = r3 - r7
            r2[r5] = r3
            float[] r2 = r0.r
            float[] r3 = r0.q
            r3 = r3[r6]
            float[] r7 = r0.p
            r7 = r7[r6]
            float r3 = r3 - r7
            r2[r6] = r3
            float[] r2 = r0.r
            float[] r3 = r0.q
            r3 = r3[r4]
            float[] r7 = r0.p
            r7 = r7[r4]
            float r3 = r3 - r7
            r2[r4] = r3
            float[] r2 = r0.o
            float[] r3 = r0.r
            net.fxgear.b.q r7 = r0.v
            net.fxgear.b.q.a((float[]) r2, (float[]) r3, (net.fxgear.b.q) r7)
            r2 = 66
            if (r1 != r2) goto L_0x0538
            net.fxgear.b.p r1 = r0.x
            net.fxgear.b.i r1 = r1.e((int) r12)
            int r2 = r0.A
            net.fxgear.b.j r1 = r1.d((int) r2)
            net.fxgear.b.p r2 = r0.x
            r3 = 68
            net.fxgear.b.i r2 = r2.e((int) r3)
            int r3 = r0.A
            net.fxgear.b.j r2 = r2.d((int) r3)
            float[] r3 = r0.s
            float[] r7 = r1.g()
            r7 = r7[r5]
            float[] r8 = r2.g()
            r8 = r8[r5]
            float r7 = r7 - r8
            r3[r5] = r7
            float[] r3 = r0.s
            float[] r7 = r1.g()
            r7 = r7[r6]
            float[] r8 = r2.g()
            r8 = r8[r6]
            float r7 = r7 - r8
            r3[r6] = r7
            float[] r3 = r0.s
            float[] r1 = r1.g()
            r1 = r1[r4]
            float[] r2 = r2.g()
            r2 = r2[r4]
            float r1 = r1 - r2
            r3[r4] = r1
            net.fxgear.b.p r1 = r0.x
            r2 = 70
            net.fxgear.b.i r1 = r1.e((int) r2)
            int r2 = r0.A
            net.fxgear.b.j r1 = r1.d((int) r2)
            net.fxgear.b.p r2 = r0.x
            r3 = 71
            net.fxgear.b.i r2 = r2.e((int) r3)
            int r3 = r0.A
            net.fxgear.b.j r2 = r2.d((int) r3)
            float[] r3 = r0.t
            float[] r7 = r1.g()
            r7 = r7[r5]
            float[] r8 = r2.g()
            r8 = r8[r5]
            float r7 = r7 - r8
            r3[r5] = r7
            float[] r3 = r0.t
            float[] r7 = r1.g()
            r7 = r7[r6]
            float[] r8 = r2.g()
            r8 = r8[r6]
            float r7 = r7 - r8
            r3[r6] = r7
            float[] r3 = r0.t
            float[] r1 = r1.g()
            r1 = r1[r4]
            float[] r2 = r2.g()
            r2 = r2[r4]
            float r1 = r1 - r2
            r3[r4] = r1
            float[] r1 = r0.t
            float[] r2 = r0.J
            net.fxgear.b.q r3 = r0.h
            net.fxgear.b.q.a((float[]) r1, (float[]) r2, (net.fxgear.b.q) r3)
            float[] r1 = r0.J
            float[] r2 = r0.s
            net.fxgear.b.q r3 = r0.e
            net.fxgear.b.q.a((float[]) r1, (float[]) r2, (net.fxgear.b.q) r3)
            net.fxgear.b.q r1 = r0.i
            r2 = -1105143428(0xffffffffbe20d97c, float:-0.15707964)
            float[] r3 = r0.s
            r1.a((float) r2, (float[]) r3)
            net.fxgear.b.q r1 = r0.h
            net.fxgear.b.q r2 = r0.e
            net.fxgear.b.q r3 = r0.f
            r1.a((net.fxgear.b.q) r2, (net.fxgear.b.q) r3)
            net.fxgear.b.q r1 = r0.f
            net.fxgear.b.q r2 = r0.i
            net.fxgear.b.q r3 = r0.e
            r1.a((net.fxgear.b.q) r2, (net.fxgear.b.q) r3)
            net.fxgear.b.q r1 = r0.v
            net.fxgear.b.q r2 = r0.e
            net.fxgear.b.q r3 = r0.g
            r1.a((net.fxgear.b.q) r2, (net.fxgear.b.q) r3)
            net.fxgear.b.q r1 = r0.v
            net.fxgear.b.q r2 = r0.g
            r1.a((net.fxgear.b.q) r2)
            net.fxgear.b.q r1 = r0.f668a
            net.fxgear.b.q r2 = r0.e
            net.fxgear.b.q r3 = r0.g
            r1.a((net.fxgear.b.q) r2, (net.fxgear.b.q) r3)
            net.fxgear.b.q r1 = r0.f668a
            net.fxgear.b.q r2 = r0.g
            r1.a((net.fxgear.b.q) r2)
        L_0x0538:
            net.fxgear.b.q r1 = r0.f
            net.fxgear.b.p$a r2 = r0.y
            float[] r2 = r2.j
            r2 = r2[r17]
            double r2 = (double) r2
            r1.f711a = r2
            net.fxgear.b.q r1 = r0.f
            net.fxgear.b.p$a r2 = r0.y
            float[] r2 = r2.j
            r2 = r2[r18]
            double r2 = (double) r2
            r1.f712b = r2
            net.fxgear.b.q r1 = r0.f
            net.fxgear.b.p$a r2 = r0.y
            float[] r2 = r2.j
            r2 = r2[r19]
            double r2 = (double) r2
            r1.c = r2
            net.fxgear.b.q r1 = r0.f
            net.fxgear.b.p$a r2 = r0.y
            float[] r2 = r2.j
            r2 = r2[r11]
            double r2 = (double) r2
            r1.d = r2
            net.fxgear.b.q r1 = r0.v
            net.fxgear.b.q r2 = r0.f
            net.fxgear.b.q r3 = r0.g
            r1.a((net.fxgear.b.q) r2, (net.fxgear.b.q) r3)
            net.fxgear.b.q r1 = r0.g
            float[] r2 = r0.k
            r2 = r2[r5]
            float[] r3 = r0.k
            r3 = r3[r6]
            float[] r7 = r0.k
            r7 = r7[r4]
            float[] r8 = r0.u
            r1.a((float) r2, (float) r3, (float) r7, (float[]) r8)
            float[] r1 = r0.l
            float[] r2 = r0.u
            r2 = r2[r5]
            float[] r3 = r0.c
            r3 = r3[r5]
            float r2 = r2 + r3
            r1[r5] = r2
            float[] r1 = r0.l
            float[] r2 = r0.u
            r2 = r2[r6]
            float[] r3 = r0.c
            r3 = r3[r6]
            float r2 = r2 + r3
            r1[r6] = r2
            float[] r1 = r0.l
            float[] r2 = r0.u
            r2 = r2[r4]
            float[] r3 = r0.c
            r3 = r3[r4]
            float r2 = r2 + r3
            r1[r4] = r2
            net.fxgear.b.p r1 = r0.x
            net.fxgear.b.i r1 = r1.e((int) r13)
            net.fxgear.b.q r2 = r0.g
            float[] r2 = r2.f()
            r1.f(r2)
            net.fxgear.b.p r1 = r0.x
            net.fxgear.b.i r1 = r1.e((int) r13)
            r1.b()
            goto L_0x064a
        L_0x05c1:
            float[] r1 = r0.l
            float[] r2 = r0.k
            r2 = r2[r5]
            r1[r5] = r2
            float[] r1 = r0.l
            float[] r2 = r0.k
            r2 = r2[r6]
            r1[r6] = r2
            float[] r1 = r0.l
            float[] r2 = r0.k
            r2 = r2[r4]
            r1[r4] = r2
            float[] r1 = r0.l
            float[] r2 = r0.k
            r3 = 3
            r2 = r2[r3]
            r1[r3] = r2
            net.fxgear.b.p r1 = r0.x
            r2 = 70
            net.fxgear.b.i r1 = r1.e((int) r2)
            int r2 = r0.A
            net.fxgear.b.j r1 = r1.d((int) r2)
            net.fxgear.b.p r2 = r0.x
            r3 = 71
            net.fxgear.b.i r2 = r2.e((int) r3)
            int r3 = r0.A
            net.fxgear.b.j r2 = r2.d((int) r3)
            float[] r3 = r0.t
            float[] r7 = r1.g()
            r7 = r7[r5]
            float[] r8 = r2.g()
            r8 = r8[r5]
            float r7 = r7 - r8
            r3[r5] = r7
            float[] r3 = r0.t
            float[] r7 = r1.g()
            r7 = r7[r6]
            float[] r8 = r2.g()
            r8 = r8[r6]
            float r7 = r7 - r8
            r3[r6] = r7
            float[] r3 = r0.t
            float[] r1 = r1.g()
            r1 = r1[r4]
            float[] r2 = r2.g()
            r2 = r2[r4]
            float r1 = r1 - r2
            r3[r4] = r1
            float[] r1 = r0.J
            float[] r2 = r0.t
            net.fxgear.b.q r3 = r0.e
            net.fxgear.b.q.a((float[]) r1, (float[]) r2, (net.fxgear.b.q) r3)
            net.fxgear.b.q r1 = r0.f668a
            net.fxgear.b.q r2 = r0.e
            net.fxgear.b.q r3 = r0.g
            r1.a((net.fxgear.b.q) r2, (net.fxgear.b.q) r3)
            net.fxgear.b.q r1 = r0.f668a
            net.fxgear.b.q r2 = r0.g
            r1.a((net.fxgear.b.q) r2)
        L_0x064a:
            net.fxgear.b.i r1 = r0.j
            float[] r2 = r0.l
            r1.e(r2)
            net.fxgear.b.i r1 = r0.j
            net.fxgear.b.q r2 = r0.f668a
            float[] r2 = r2.f()
            r1.f(r2)
            net.fxgear.b.i r1 = r0.j
            r1.b()
            net.fxgear.b.p$a r1 = r0.y
            float[] r1 = r1.h
            int r2 = r10 + 0
            float[] r3 = r0.l
            r3 = r3[r5]
            r1[r2] = r3
            net.fxgear.b.p$a r1 = r0.y
            float[] r1 = r1.h
            int r3 = r10 + 1
            float[] r7 = r0.l
            r7 = r7[r6]
            r1[r3] = r7
            net.fxgear.b.p$a r1 = r0.y
            float[] r1 = r1.h
            int r7 = r10 + 2
            float[] r8 = r0.l
            r8 = r8[r4]
            r1[r7] = r8
            net.fxgear.b.p$a r1 = r0.y
            float[] r1 = r1.h
            r8 = 3
            int r10 = r10 + r8
            r8 = 1065353216(0x3f800000, float:1.0)
            r1[r10] = r8
            net.fxgear.b.p$a r1 = r0.y
            float[] r1 = r1.i
            net.fxgear.b.j r8 = r0.K
            float[] r8 = r8.g()
            r8 = r8[r5]
            r1[r2] = r8
            net.fxgear.b.p$a r1 = r0.y
            float[] r1 = r1.i
            net.fxgear.b.j r8 = r0.K
            float[] r8 = r8.g()
            r6 = r8[r6]
            r1[r3] = r6
            net.fxgear.b.p$a r1 = r0.y
            float[] r1 = r1.i
            net.fxgear.b.j r6 = r0.K
            float[] r6 = r6.g()
            r4 = r6[r4]
            r1[r7] = r4
            net.fxgear.b.p$a r1 = r0.y
            float[] r1 = r1.i
            r4 = 1065353216(0x3f800000, float:1.0)
            r1[r10] = r4
            net.fxgear.b.p$a r1 = r0.y
            float[] r1 = r1.j
            net.fxgear.b.q r4 = r0.f668a
            double r8 = r4.f711a
            float r4 = (float) r8
            r1[r2] = r4
            net.fxgear.b.p$a r1 = r0.y
            float[] r1 = r1.j
            net.fxgear.b.q r2 = r0.f668a
            double r8 = r2.f712b
            float r2 = (float) r8
            r1[r3] = r2
            net.fxgear.b.p$a r1 = r0.y
            float[] r1 = r1.j
            net.fxgear.b.q r2 = r0.f668a
            double r2 = r2.c
            float r2 = (float) r2
            r1[r7] = r2
            net.fxgear.b.p$a r1 = r0.y
            float[] r1 = r1.j
            net.fxgear.b.q r2 = r0.f668a
            double r2 = r2.d
            float r2 = (float) r2
            r1[r10] = r2
            net.fxgear.b.i r1 = r0.j
            java.util.ArrayList r1 = r1.o()
        L_0x06f3:
            int r2 = r1.size()
            if (r5 >= r2) goto L_0x0709
            java.lang.Object r2 = r1.get(r5)
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            r0.c(r2)
            int r5 = r5 + 1
            goto L_0x06f3
        L_0x0709:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.b.b.c(int):void");
    }

    public void b() {
        for (int i2 = 0; i2 < this.x.y(); i2++) {
            Matrix.multiplyMM(this.y.p, 0, this.x.e(i2).c(), 0, this.x.e(i2).d(), 0);
            this.e.a(this.y.p);
            this.e.d();
            int i3 = i2 * 4;
            int i4 = i3 + 0;
            this.y.q[i4] = (float) this.e.f711a;
            int i5 = i3 + 1;
            this.y.q[i5] = (float) this.e.f712b;
            int i6 = i3 + 2;
            this.y.q[i6] = (float) this.e.c;
            int i7 = i3 + 3;
            this.y.q[i7] = (float) this.e.d;
            float[] fArr = this.y.r;
            double d2 = (double) this.y.p[12];
            double d3 = this.e.d;
            Double.isNaN(d2);
            double d4 = (double) this.y.p[13];
            double d5 = this.e.c;
            Double.isNaN(d4);
            double d6 = (double) this.y.p[14];
            double d7 = this.e.f712b;
            Double.isNaN(d6);
            fArr[i4] = (float) ((((d2 * d3) + (d4 * d5)) - (d6 * d7)) * 0.5d);
            float[] fArr2 = this.y.r;
            double d8 = (double) (-this.y.p[12]);
            double d9 = this.e.c;
            Double.isNaN(d8);
            double d10 = d8 * d9;
            double d11 = (double) this.y.p[13];
            double d12 = this.e.d;
            Double.isNaN(d11);
            double d13 = d10 + (d11 * d12);
            double d14 = (double) this.y.p[14];
            double d15 = this.e.f711a;
            Double.isNaN(d14);
            fArr2[i5] = (float) ((d13 + (d14 * d15)) * 0.5d);
            float[] fArr3 = this.y.r;
            double d16 = (double) this.y.p[12];
            double d17 = this.e.f712b;
            Double.isNaN(d16);
            double d18 = d16 * d17;
            double d19 = (double) this.y.p[13];
            double d20 = this.e.f711a;
            Double.isNaN(d19);
            double d21 = d18 - (d19 * d20);
            double d22 = (double) this.y.p[14];
            double d23 = this.e.d;
            Double.isNaN(d22);
            fArr3[i6] = (float) ((d21 + (d22 * d23)) * 0.5d);
            float[] fArr4 = this.y.r;
            double d24 = (double) this.y.p[12];
            double d25 = this.e.f711a;
            Double.isNaN(d24);
            double d26 = d24 * d25;
            double d27 = (double) this.y.p[13];
            double d28 = this.e.f712b;
            Double.isNaN(d27);
            double d29 = d26 + (d27 * d28);
            double d30 = (double) this.y.p[14];
            double d31 = this.e.c;
            Double.isNaN(d30);
            fArr4[i7] = (float) ((d29 + (d30 * d31)) * -0.5d);
        }
    }

    public void c() {
        int i2 = 0;
        int i3 = 0;
        while (i3 < this.x.y()) {
            Matrix.setIdentityM(this.y.p, i2);
            this.e.a(this.y.p);
            this.e.d();
            int i4 = i3 * 4;
            int i5 = i4 + 0;
            this.y.q[i5] = (float) this.e.f711a;
            int i6 = i4 + 1;
            this.y.q[i6] = (float) this.e.f712b;
            int i7 = i4 + 2;
            this.y.q[i7] = (float) this.e.c;
            int i8 = i4 + 3;
            this.y.q[i8] = (float) this.e.d;
            float[] fArr = this.y.r;
            double d2 = (double) this.y.p[12];
            double d3 = this.e.d;
            Double.isNaN(d2);
            double d4 = (double) this.y.p[13];
            int i9 = i3;
            double d5 = this.e.c;
            Double.isNaN(d4);
            double d6 = (d2 * d3) + (d4 * d5);
            double d7 = (double) this.y.p[14];
            double d8 = this.e.f712b;
            Double.isNaN(d7);
            fArr[i5] = (float) ((d6 - (d7 * d8)) * 0.5d);
            float[] fArr2 = this.y.r;
            double d9 = (double) (-this.y.p[12]);
            double d10 = this.e.c;
            Double.isNaN(d9);
            double d11 = d9 * d10;
            double d12 = (double) this.y.p[13];
            double d13 = this.e.d;
            Double.isNaN(d12);
            double d14 = d11 + (d12 * d13);
            double d15 = (double) this.y.p[14];
            double d16 = this.e.f711a;
            Double.isNaN(d15);
            fArr2[i6] = (float) ((d14 + (d15 * d16)) * 0.5d);
            float[] fArr3 = this.y.r;
            double d17 = (double) this.y.p[12];
            double d18 = this.e.f712b;
            Double.isNaN(d17);
            double d19 = d17 * d18;
            double d20 = (double) this.y.p[13];
            double d21 = this.e.f711a;
            Double.isNaN(d20);
            double d22 = d19 - (d20 * d21);
            double d23 = (double) this.y.p[14];
            double d24 = this.e.d;
            Double.isNaN(d23);
            fArr3[i7] = (float) ((d22 + (d23 * d24)) * 0.5d);
            float[] fArr4 = this.y.r;
            double d25 = (double) this.y.p[12];
            double d26 = this.e.f711a;
            Double.isNaN(d25);
            double d27 = d25 * d26;
            double d28 = (double) this.y.p[13];
            double d29 = this.e.f712b;
            Double.isNaN(d28);
            double d30 = d27 + (d28 * d29);
            double d31 = (double) this.y.p[14];
            double d32 = this.e.c;
            Double.isNaN(d31);
            fArr4[i8] = (float) ((d30 + (d31 * d32)) * -0.5d);
            i3 = i9 + 1;
            i2 = 0;
        }
    }
}
