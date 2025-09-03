package net.fxgear.b;

import android.opengl.Matrix;
import java.util.ArrayList;

/* compiled from: FXJoint */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private String f692a;

    /* renamed from: b  reason: collision with root package name */
    private float[] f693b;
    private q c;
    private float[] d;
    private q e;
    private float[] f;
    private float[] g;
    private float[] h;
    private float[] i;
    private q j;
    private int k;
    private float[] l;
    private float[] m;
    private float[] n;
    private float[] o;
    private ArrayList<Integer> p;
    private ArrayList<j> q;
    private boolean r;
    private int s;

    public i() {
        this.f693b = new float[3];
        this.c = new q();
        this.d = new float[3];
        this.e = new q();
        this.f = new float[3];
        this.g = new float[3];
        this.h = new float[3];
        this.i = new float[3];
        this.j = new q();
        this.l = new float[16];
        this.m = new float[16];
        this.n = new float[16];
        this.o = new float[16];
        this.r = false;
        this.s = -1;
        this.f692a = "FXJoint";
        float[] fArr = this.f693b;
        float[] fArr2 = this.f693b;
        this.f693b[2] = 0.0f;
        fArr2[1] = 0.0f;
        fArr[0] = 0.0f;
        float[] fArr3 = this.d;
        float[] fArr4 = this.d;
        this.d[2] = 0.0f;
        fArr4[1] = 0.0f;
        fArr3[0] = 0.0f;
        float[] fArr5 = this.f;
        float[] fArr6 = this.f;
        this.f[2] = 0.0f;
        fArr6[1] = 0.0f;
        fArr5[0] = 0.0f;
        float[] fArr7 = this.h;
        float[] fArr8 = this.h;
        this.h[2] = 0.0f;
        fArr8[1] = 0.0f;
        fArr7[0] = 0.0f;
        this.k = -1;
        this.p = new ArrayList<>();
        this.q = new ArrayList<>();
    }

    public i(i iVar) {
        this.f693b = new float[3];
        this.c = new q();
        this.d = new float[3];
        this.e = new q();
        this.f = new float[3];
        this.g = new float[3];
        this.h = new float[3];
        this.i = new float[3];
        this.j = new q();
        this.l = new float[16];
        this.m = new float[16];
        this.n = new float[16];
        this.o = new float[16];
        this.r = false;
        this.s = -1;
        this.f692a = iVar.f692a;
        this.f693b = (float[]) iVar.h().clone();
        this.d = (float[]) iVar.j().clone();
        this.f = (float[]) iVar.l().clone();
        this.h = (float[]) iVar.m().clone();
        this.k = iVar.n();
        this.c.a(iVar.i());
        this.e.a(iVar.k());
        this.p = new ArrayList<>();
        for (int i2 = 0; i2 < iVar.o().size(); i2++) {
            this.p.add(new Integer(iVar.c(i2)));
        }
        this.q = new ArrayList<>();
    }

    public void a(boolean z) {
        this.f693b = null;
        if (this.c != null) {
            this.c.a();
            this.c = null;
        }
        this.d = null;
        if (this.e != null) {
            this.e.a();
            this.e = null;
        }
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        if (this.j != null) {
            this.j.a();
            this.j = null;
        }
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        if (this.p != null) {
            this.p.clear();
            this.p = null;
        }
        if (!z) {
            this.q = null;
        } else if (this.q != null) {
            for (int i2 = 0; i2 < this.q.size(); i2++) {
                this.q.get(i2).a();
            }
            this.q.clear();
            this.q = null;
        }
    }

    public void a(String str) {
        this.f692a = str;
    }

    public void b(boolean z) {
        this.r = z;
    }

    public boolean a() {
        return this.r;
    }

    public void a(float[] fArr) {
        this.f693b = (float[]) fArr.clone();
    }

    public void a(q qVar) {
        this.c.a(qVar);
    }

    public void b(float[] fArr) {
        this.d = (float[]) fArr.clone();
    }

    public void b(q qVar) {
        this.e.a(qVar);
    }

    public void c(float[] fArr) {
        this.f = (float[]) fArr.clone();
    }

    public void d(float[] fArr) {
        this.h = (float[]) fArr.clone();
    }

    public void e(float[] fArr) {
        Matrix.setIdentityM(this.o, 0);
        Matrix.translateM(this.o, 0, fArr[0], fArr[1], fArr[2]);
    }

    public void f(float[] fArr) {
        for (int i2 = 0; i2 < 16; i2++) {
            this.n[i2] = fArr[i2];
        }
    }

    public void b() {
        Matrix.multiplyMM(this.l, 0, this.o, 0, this.n, 0);
    }

    public float[] c() {
        return this.l;
    }

    public float[] d() {
        return this.m;
    }

    public void e() {
        Matrix.invertM(this.m, 0, this.l, 0);
    }

    public void a(int i2) {
        this.k = i2;
    }

    public void b(int i2) {
        this.p.add(Integer.valueOf(i2));
    }

    public void a(ArrayList<j> arrayList) {
        this.q.addAll(arrayList);
    }

    public void a(j jVar) {
        this.q.add(jVar);
    }

    public void f() {
        this.q.clear();
    }

    public String g() {
        return this.f692a;
    }

    public float[] h() {
        return this.f693b;
    }

    public q i() {
        return this.c;
    }

    public float[] j() {
        return this.d;
    }

    public q k() {
        return this.e;
    }

    public float[] l() {
        return this.f;
    }

    public float[] m() {
        return this.h;
    }

    public int n() {
        return this.k;
    }

    public int c(int i2) {
        if (i2 < this.p.size()) {
            return this.p.get(i2).intValue();
        }
        return -1;
    }

    public ArrayList<Integer> o() {
        return this.p;
    }

    public j d(int i2) {
        if (this.q.size() <= i2) {
            return null;
        }
        return this.q.get(i2);
    }

    public ArrayList<j> p() {
        return this.q;
    }
}
