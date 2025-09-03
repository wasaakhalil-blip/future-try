package net.fxgear.b;

import android.util.Log;
import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL10;
import net.fxgear.GlobalDefine;
import net.fxgear.b.h;

/* compiled from: FXBlendShape */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private int f674a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<f> f675b;
    private String c;
    private h.a d;
    private d e;
    private d f;
    private int g;
    private long h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;

    public e() {
        this.f674a = 0;
        this.f675b = null;
        this.c = new String();
        this.d = h.a.NONE;
        this.e = new d();
        this.f = new d();
        this.g = 0;
        this.h = 0;
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        this.f675b = new ArrayList<>();
    }

    public boolean a() {
        return this.e.a();
    }

    public e(int i2) {
        this.f674a = 0;
        this.f675b = null;
        this.c = new String();
        this.d = h.a.NONE;
        this.e = new d();
        this.f = new d();
        this.g = 0;
        this.h = 0;
        this.i = false;
        this.j = false;
        this.k = false;
        this.l = false;
        this.f674a = i2;
        this.f675b = new ArrayList<>();
    }

    public void b() {
        if (this.e != null) {
            this.e.b();
        }
        if (this.f != null) {
            this.f.b();
        }
    }

    public void a(GL10 gl10) {
        if (this.f675b != null) {
            for (int i2 = 0; i2 < this.f675b.size(); i2++) {
                this.f675b.get(i2).a();
            }
            this.f675b.clear();
            this.f675b = null;
        }
        this.c = null;
        this.d = null;
        if (this.e != null) {
            this.e.a(gl10);
            this.e = null;
        }
        if (this.f != null) {
            this.f.a(gl10);
            this.f = null;
        }
    }

    public void c() {
        this.g++;
    }

    public void d() {
        this.g--;
        if (this.g == 0) {
            this.h = System.currentTimeMillis();
        }
    }

    public float e() {
        return ((float) (System.currentTimeMillis() - this.h)) / 1000.0f;
    }

    public int f() {
        return this.g;
    }

    public void g() {
        this.i = true;
    }

    public void h() {
        this.i = false;
    }

    public boolean i() {
        return this.i;
    }

    public void a(String str) {
        this.c = str;
    }

    public void a(d dVar) {
        this.e = dVar;
    }

    public d j() {
        return this.e;
    }

    public void a(h.a aVar) {
        this.d = aVar;
    }

    public String k() {
        return this.c;
    }

    public float l() {
        if (this.e == null) {
            return -1.0f;
        }
        return this.e.m();
    }

    public float m() {
        if (this.e == null) {
            return -1.0f;
        }
        return this.e.n();
    }

    public float n() {
        if (this.e == null) {
            return -1.0f;
        }
        return this.e.o();
    }

    public void a(f fVar, float[] fArr) {
        fVar.a(fArr);
        this.f675b.add(fVar);
        this.f674a = fVar.b();
    }

    public ArrayList<f> o() {
        if (this.f675b != null) {
            return this.f675b;
        }
        Log.e("FXBlendShape : ", "BlendShape does not have mBlendTargetList");
        return null;
    }

    public void a(boolean z) {
        this.l = z;
    }

    public boolean p() {
        return this.l;
    }

    public float[] q() {
        if (this.e == null) {
            return null;
        }
        return this.e.p();
    }

    public int r() {
        if (this.e == null) {
            return -1;
        }
        return this.e.q();
    }

    public int s() {
        if (this.e == null) {
            return -1;
        }
        return this.e.r();
    }

    public int t() {
        if (this.e == null) {
            return -1;
        }
        return this.e.u();
    }

    public int u() {
        if (this.e == null) {
            return -1;
        }
        return this.e.t();
    }

    public int v() {
        if (this.e == null) {
            return -1;
        }
        return this.e.s();
    }

    public int w() {
        if (this.e == null) {
            return -1;
        }
        return this.e.v();
    }

    public int x() {
        if (this.e == null) {
            return -1;
        }
        return this.e.w();
    }

    public int[] y() {
        if (this.e == null) {
            return null;
        }
        return this.e.x();
    }

    public float[] z() {
        if (this.e == null) {
            return null;
        }
        return this.e.y();
    }

    public float[] A() {
        if (this.e == null) {
            return null;
        }
        return this.e.z();
    }

    public void B() {
        this.j = true;
        this.c = "gabage mesh";
    }

    public boolean C() {
        return this.j;
    }

    public void b(boolean z) {
        this.k = z;
    }

    public boolean D() {
        return this.k;
    }

    public float a(float[] fArr, float[] fArr2, int[] iArr, float f2) {
        if (this.f675b == null) {
            Log.i("FXBlendShape : ", "[c] SearchUpdatePosUsingWeight Target List 0");
            return GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        }
        float[] fArr3 = new float[iArr.length];
        int size = this.f675b.size();
        for (int i2 = 0; i2 < size; i2++) {
            float[] a2 = this.f675b.get(i2).a(fArr[i2], iArr);
            for (int i3 = 0; i3 < iArr.length; i3++) {
                fArr3[i3] = fArr3[i3] + a2[i3];
            }
        }
        for (int i4 = 0; i4 < iArr.length; i4++) {
            fArr3[i4] = fArr3[i4] + fArr2[iArr[i4]];
        }
        return (fArr3[0] - fArr3[1]) - f2;
    }

    public float[] a(float[] fArr, float[] fArr2) {
        if (this.f675b == null) {
            Log.i("FXBlendShape : ", "Target List 0");
            return null;
        }
        int length = fArr.length;
        int size = this.f675b.size();
        float[] fArr3 = new float[fArr2.length];
        float[] fArr4 = new float[size];
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 < length) {
                fArr4[i2] = fArr[i2];
            } else {
                fArr4[i2] = 0.0f;
            }
        }
        if (length == 16 && length < size) {
            float f2 = fArr[14];
            float f3 = fArr[15];
            fArr4[14] = 0.0f;
            fArr4[15] = 0.0f;
            fArr4[18] = f2;
            fArr4[16] = f2;
            fArr4[14] = f2;
            fArr4[20] = f2;
            fArr4[22] = f3;
            fArr4[24] = f3;
        }
        for (int i3 = 0; i3 < fArr3.length; i3++) {
            fArr3[i3] = fArr2[i3];
        }
        for (int i4 = 0; i4 < size; i4++) {
            if (fArr4[i4] != GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
                float[] a2 = this.f675b.get(i4).a(fArr4[i4]);
                for (int i5 = 0; i5 < this.f674a * 3; i5++) {
                    fArr3[i5] = fArr3[i5] + a2[i5];
                }
            }
        }
        return fArr3;
    }
}
