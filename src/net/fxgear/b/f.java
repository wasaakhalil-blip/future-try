package net.fxgear.b;

import android.util.Log;

/* compiled from: FXBlendTarget */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private int f676a = 0;

    /* renamed from: b  reason: collision with root package name */
    private float[] f677b = null;
    private float[] c = null;
    private float[] d = null;

    public void a() {
        this.f677b = null;
        this.c = null;
        this.d = null;
    }

    public int b() {
        return this.f676a;
    }

    public void a(float[] fArr) {
        if (fArr.length == this.f677b.length) {
            for (int i = 0; i < this.f676a * 3; i++) {
                this.c[i] = this.f677b[i] - fArr[i];
            }
            return;
        }
        Log.i("FXBlendTarget : ", "BlendTable Num : " + this.f677b.length + " , OriginalTable Num : " + fArr.length);
    }

    public void a(int i) {
        this.f676a = i;
        int i2 = i * 3;
        this.f677b = new float[i2];
        this.c = new float[i2];
        this.d = new float[(i * 2)];
    }

    public void b(float[] fArr) {
        if (fArr == null) {
            Log.e("FXBlendTarget : ", "SetBlendTable error:" + fArr);
        } else if (fArr.length <= 0) {
            Log.e("FXBlendTarget : ", "SetBlendTable array length error:" + fArr.length);
        } else {
            this.f677b = (float[]) fArr.clone();
        }
    }

    public void c(float[] fArr) {
        if (fArr == null) {
            Log.e("FXBlendTarget : ", "SetUVTable error:" + fArr);
        } else if (fArr.length <= 0) {
            Log.e("FXBlendTarget : ", "SetUVTable array length error:" + fArr.length);
        } else {
            if (this.f676a * 2 == fArr.length) {
                this.d = (float[]) fArr.clone();
                return;
            }
            Log.i("FXBlendTarget : ", "Data Num : " + (this.f676a * 2) + " , InpuTable Num : " + fArr.length);
        }
    }

    public float[] c() {
        return this.f677b;
    }

    public float[] a(float f, int[] iArr) {
        float[] fArr = new float[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            fArr[i] = this.c[iArr[i]] * f;
        }
        return fArr;
    }

    public float[] a(float f) {
        float[] fArr = new float[(this.f676a * 3)];
        for (int i = 0; i < this.f676a * 3; i++) {
            fArr[i] = this.c[i] * f;
        }
        return fArr;
    }
}
