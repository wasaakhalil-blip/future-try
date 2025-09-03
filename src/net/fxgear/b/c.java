package net.fxgear.b;

import android.util.Log;

/* compiled from: FXAvatar */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public k f670a;

    /* renamed from: b  reason: collision with root package name */
    public k f671b;
    public k c;
    public k d;
    public k e;
    public k f;
    public k g;
    public k h;
    public k i;
    public float[] j;
    public float[] k;
    public float l;
    public float[] m;
    public float[] n;
    public boolean o;
    public boolean p;
    public boolean q;

    c() {
        this.f670a = null;
        this.f671b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = new float[3];
        this.l = 1.0f;
        this.m = new float[14];
        this.n = new float[14];
        this.o = false;
        this.p = false;
        this.q = false;
        this.j = new float[26];
        for (int i2 = 0; i2 < 26; i2++) {
            this.j[i2] = 0.0f;
        }
        this.k[0] = 1.0f;
        this.k[1] = 1.0f;
        this.k[2] = 1.0f;
        this.m[0] = 1.0f;
        this.m[1] = 1.0f;
        this.m[2] = 1.0f;
    }

    public void a(float[] fArr) {
        if (this.j != null) {
            this.j = null;
        }
        if (fArr.length <= 0) {
            Log.e("FXAvatar : ", "Input blend weight is null!");
            return;
        }
        this.j = new float[26];
        if (fArr.length == 16) {
            for (int i2 = 0; i2 < 14; i2++) {
                this.j[i2] = fArr[i2];
            }
            float f2 = fArr[14];
            float f3 = fArr[15];
            this.j[14] = f2;
            this.j[15] = 0.0f;
            this.j[16] = f2;
            this.j[17] = 0.0f;
            this.j[18] = f2;
            this.j[19] = 0.0f;
            this.j[20] = f2;
            this.j[21] = 0.0f;
            this.j[22] = f3;
            this.j[23] = 0.0f;
            this.j[24] = f3;
            this.j[25] = 0.0f;
            return;
        }
        this.j = (float[]) fArr.clone();
    }

    public float[] a() {
        if (this.j != null) {
            return this.j;
        }
        Log.e("FXAvatar : ", "mBlendWeight is null");
        return null;
    }

    public void b(float[] fArr) {
        this.k[0] = fArr[0];
        this.k[1] = fArr[1];
        this.k[2] = fArr[2];
        if (this.f670a != null) {
            this.f670a.b(fArr);
        }
        if (this.f671b != null) {
            this.f671b.b(fArr);
        }
    }

    public void a(boolean z, boolean z2, boolean z3) {
        this.o = z3;
        this.p = z2;
        this.q = z;
    }

    public void a(float f2) {
        this.l = f2;
        if (this.f670a != null) {
            this.f670a.a(f2);
        }
        if (this.f671b != null) {
            this.f671b.a(f2);
        }
        if (this.c != null) {
            this.c.a(f2);
        }
        if (this.d != null) {
            this.d.a(f2);
        }
    }

    public void a(float f2, float f3, float f4, float[] fArr, float[] fArr2, float[] fArr3, float f5, float f6) {
        this.m[0] = f2;
        this.m[1] = f3;
        this.m[2] = f4;
        this.m[3] = fArr[0];
        this.m[4] = fArr[1];
        this.m[5] = fArr[2];
        this.m[6] = fArr2[0];
        this.m[7] = fArr2[1];
        this.m[8] = fArr2[2];
        this.m[9] = fArr3[0];
        this.m[10] = fArr3[1];
        this.m[11] = fArr3[2];
        this.m[12] = f5;
        this.m[13] = f6;
        if (this.c != null) {
            this.c.c(this.m);
        }
    }

    public void a(float f2, float f3, float f4, float[] fArr, float[] fArr2, float[] fArr3, float f5) {
        this.n[0] = f2;
        this.n[1] = f3;
        this.n[2] = f4;
        this.n[3] = fArr[0];
        this.n[4] = fArr[1];
        this.n[5] = fArr[2];
        this.n[6] = fArr2[0];
        this.n[7] = fArr2[1];
        this.n[8] = fArr2[2];
        this.n[9] = fArr3[0];
        this.n[10] = fArr3[1];
        this.n[11] = fArr3[2];
        this.n[12] = f5;
        this.n[13] = 0.7f;
        if (this.d != null) {
            this.d.c(this.n);
        }
    }

    public void b() {
        if (this.f670a != null) {
            this.f670a.b(this.k);
            this.f670a.a(this.l);
        }
        if (this.f671b != null) {
            this.f671b.b(this.k);
            this.f671b.a(this.l);
        }
        if (this.c != null) {
            this.c.a(this.l);
            this.c.c(this.m);
        }
        if (this.d != null) {
            this.d.a(this.l);
            this.d.c(this.n);
        }
    }
}
