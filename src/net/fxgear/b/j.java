package net.fxgear.b;

/* compiled from: FXKeyframe */
public class j {
    private static q h = new q();
    private static float[] i = new float[3];
    private static q j = new q();
    private static float[] k = new float[3];

    /* renamed from: a  reason: collision with root package name */
    boolean f694a = false;

    /* renamed from: b  reason: collision with root package name */
    private int f695b;
    private float c;
    private float[] d = new float[3];
    private q e = new q();
    private int f = 0;
    private int g = 0;

    public j() {
    }

    public j(j jVar) {
        this.f695b = jVar.d();
        this.c = jVar.e();
        this.d = (float[]) jVar.g().clone();
        this.e.a(jVar.f());
        this.f = jVar.c();
    }

    public j(int i2, float f2, q qVar, float[] fArr) {
        this.f695b = i2;
        this.c = f2;
        this.d = (float[]) fArr.clone();
        this.e.a(qVar);
        this.f = 0;
    }

    public j(int i2, float f2, float[] fArr, q qVar, float[] fArr2, float[] fArr3, int i3, int i4) {
        this.f695b = i2;
        this.c = f2;
        if (fArr2 != null) {
            this.d = (float[]) fArr2.clone();
        }
        this.e.a(qVar);
        this.g = i3;
        this.f = i4;
    }

    public void a() {
        this.d = null;
        if (this.e != null) {
            this.e.a();
            this.e = null;
        }
    }

    public void a(j jVar) {
        this.f695b = jVar.d();
        this.c = jVar.e();
        this.d = (float[]) jVar.g().clone();
        this.e.a(jVar.f());
        this.f = jVar.c();
    }

    public void a(int i2, float f2, float[] fArr, q qVar, int i3) {
        this.f695b = i2;
        this.c = f2;
        if (this.d == null) {
            this.d = new float[3];
        }
        this.d[0] = fArr[0];
        this.d[1] = fArr[1];
        this.d[2] = fArr[2];
        if (this.e == null) {
            this.e = new q();
        }
        this.e.a(qVar);
        this.f = i3;
    }

    public void a(boolean z) {
        this.f694a = z;
    }

    public boolean b() {
        return this.f694a;
    }

    public void a(float f2, float f3, float f4) {
        this.d[0] = f2;
        this.d[1] = f3;
        this.d[2] = f4;
    }

    public int c() {
        return this.f;
    }

    public int d() {
        return this.f695b;
    }

    public float e() {
        return this.c;
    }

    public q f() {
        return this.e;
    }

    public float[] g() {
        return this.d;
    }

    public static void a(j jVar, j jVar2, float f2, j jVar3) {
        float f3 = 1.0f - f2;
        i[0] = (jVar.g()[0] * f3) + (jVar2.g()[0] * f2);
        i[1] = (jVar.g()[1] * f3) + (jVar2.g()[1] * f2);
        i[2] = (f3 * jVar.g()[2]) + (jVar2.g()[2] * f2);
        jVar.f().a(jVar2.f(), (double) f2, h);
        jVar3.a(jVar.d(), jVar.e(), i, h, jVar.c());
    }

    public static void b(j jVar, j jVar2, float f2, j jVar3) {
        float f3 = 1.0f - f2;
        k[0] = (jVar.g()[0] * f3) + (jVar2.g()[0] * f2);
        k[1] = (jVar.g()[1] * f3) + (jVar2.g()[1] * f2);
        k[2] = (f3 * jVar.g()[2]) + (jVar2.g()[2] * f2);
        jVar.f().a(jVar2.f(), (double) f2, j);
        jVar3.a(jVar.d(), jVar.e(), k, j, jVar.c());
    }
}
