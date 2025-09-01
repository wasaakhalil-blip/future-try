

// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingview\a.java ==========

package net.fxgear.fittingview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.Log;
import android.view.MotionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import net.fxgear.GlobalDefine;
import net.fxgear.b.g;
import net.fxgear.b.h;
import net.fxgear.customface.CustomFaceInterface;
import net.fxgear.fittingview.FittingSurfaceView;
import net.fxgear.fittingview.data.FittingFaceData;
import net.fxgear.fittingview.data.b;
import net.fxgear.fittingview.data.d;
import net.fxgear.fittingview.data.h;

/* compiled from: FittingRenderer */
class a implements GLSurfaceView.Renderer {
    private b A = new b();
    private h B = new h();
    private ArrayList<d> C = new ArrayList<>();
    private net.fxgear.fittingview.data.a D = new net.fxgear.fittingview.data.a();
    private h.e E = h.e.REAL;
    private h.e F = h.e.REAL;
    private int G = 4;
    private int H = 1;
    private float[] I = new float[3];
    private float J = 1.0f;
    private int K = 400;
    private int L = 900;
    private boolean M = false;
    private boolean N = false;
    private boolean O = false;
    private boolean P = false;
    private boolean Q = false;
    private boolean R = false;
    private boolean S = false;
    private boolean T = false;
    private boolean U = false;
    /* access modifiers changed from: private */
    public boolean V = false;
    private boolean W = false;
    private boolean X = false;
    private boolean Y = false;
    private boolean Z = false;

    /* renamed from: a  reason: collision with root package name */
    Bitmap f1479a = null;
    private boolean aa = false;
    private boolean ab = false;
    private boolean ac = false;
    private boolean ad = false;
    /* access modifiers changed from: private */
    public boolean ae = false;
    private boolean af = false;
    private boolean ag = true;
    /* access modifiers changed from: private */
    public boolean ah = true;
    private boolean ai = true;
    private float aj = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    private float ak = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    private float al = 1.0f;
    private Object am = new Object();
    private ArrayList<Object<GL10, FittingSurfaceView.c>> an = null;
    private qlSolver ao = null;

    /* renamed from: b  reason: collision with root package name */
    boolean f1480b = false;
    long c = 0;
    float d = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    boolean e = false;
    long f = 100000;
    int g = -1;
    float h = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    float[] i = null;
    float j = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    long k = -1;
    int l = -1;
    boolean m = false;
    Bitmap n = null;
    int o = -1;
    boolean p = false;
    boolean q = false;
    net.fxgear.b.a r = null;
    CustomFaceInterface s = null;
    FittingSurfaceView.a t = null;
    Object u = new Object();
    private C0054a v = new C0054a() {
        public void a(GL10 gl10) {
        }

        public void b(GL10 gl10) {
            if (a.this.x != null) {
                a.this.x.a(gl10);
            }
            boolean unused = a.this.w = false;
        }
    };
    /* access modifiers changed from: private */
    public boolean w = false;
    /* access modifiers changed from: private */
    public b x;
    private Context y;
    private g[] z = new g[h.e.values().length];

    /* renamed from: net.fxgear.fittingview.a$a  reason: collision with other inner class name */
    /* compiled from: FittingRenderer */
    public interface C0054a {
        void a(GL10 gl10);

        void b(GL10 gl10);
    }

    public a(Context context, FittingSurfaceView.a aVar) {
        this.y = context;
        this.t = aVar;
        this.s = new CustomFaceInterface(this.y);
        this.r = new net.fxgear.b.a();
        this.c = System.currentTimeMillis();
        this.d = (float) System.currentTimeMillis();
        this.z[b(h.e.NONE)] = new g(this.aj, this.ak, this.al, h.e.NONE);
        this.z[b(h.e.AVATAR)] = new g(this.aj, this.ak, this.al, h.e.AVATAR);
        this.z[b(h.e.AVATAR_CUSTOM_FACE_EDITING)] = new g(this.aj, this.ak, this.al, h.e.AVATAR_CUSTOM_FACE_EDITING);
        this.z[b(h.e.AVATAR_FACE_EDITING)] = new g(this.aj, this.ak, this.al, h.e.AVATAR_FACE_EDITING);
        this.z[b(h.e.AVATAR_HAIR_EDITING)] = new g(this.aj, this.ak, this.al, h.e.AVATAR_HAIR_EDITING);
        this.z[b(h.e.AVATAR_SKIN_TONE_EDITING)] = new g(this.aj, this.ak, this.al, h.e.AVATAR_SKIN_TONE_EDITING);
        this.z[b(h.e.AVATAR_BODY_EDITING)] = new g(this.aj, this.ak, this.al, h.e.AVATAR_BODY_EDITING);
        this.z[b(h.e.REAL)] = new g(this.aj, this.ak, this.al, h.e.REAL);
        this.z[b(h.e.CAPTURE)] = new g(this.aj, this.ak, this.al, h.e.CAPTURE);
        this.z[b(h.e.CHECK_CLOTHES_SIZE)] = new g(this.aj, this.ak, this.al, h.e.CHECK_CLOTHES_SIZE);
        this.an = new ArrayList<>();
        this.ao = new qlSolver(this);
        this.r.a(this.ao);
    }

    public void onDrawFrame(GL10 gl10) {
        FittingSurfaceView.c t2;
        try {
            FittingSurfaceView.c cVar = FittingSurfaceView.c.NONE;
            synchronized (this) {
                t2 = t(gl10);
                if (!this.ag || this.p) {
                    a(this.z[b(this.F)].e(), this.z[b(this.F)].f());
                } else {
                    boolean z2 = this.ah;
                    boolean z3 = this.ai;
                    GL10 gl102 = gl10;
                    this.r.a(gl102, this.z[b(this.F)].d(), this.z[b(this.F)].e(), this.z[b(this.F)].f(), b(gl10), z2, z3);
                }
            }
            c(gl10);
            p();
            if (t2 != FittingSurfaceView.c.NONE) {
                this.t.a(t2, true, (Throwable) null);
            }
        } catch (Throwable th) {
            this.t.a(FittingSurfaceView.c.NONE, false, th);
        }
    }

    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        for (int i4 = 0; i4 < h.e.values().length; i4++) {
            this.z[i4].a(i2, i3);
        }
        this.r.a(i2, i3);
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.v.a(gl10);
        if (!this.f1480b) {
            int[] iArr = new int[1];
            GLES20.glGetIntegerv(3379, iArr, 0);
            this.r.b(iArr[0]);
            this.r.a();
            this.r.e();
            synchronized (this.am) {
                this.f1480b = true;
                this.am.notifyAll();
            }
        }
        a(this.E, this.G, this.H, true);
        this.r.b();
        this.r.a(this.E, this.G);
    }

    public void a() {
        Log.e("FittingRenderer", "[c] Destroy()+");
        this.y = null;
        synchronized (this.an) {
            this.an.clear();
        }
    }

    public void a(GL10 gl10) {
        if (this.r != null) {
            this.r.a(gl10);
            this.r = null;
        }
        if (this.s != null) {
            this.s.release();
            this.s = null;
        }
        if (this.z != null) {
            for (int i2 = 0; i2 < h.e.values().length; i2++) {
                this.z[i2].b();
                this.z[i2] = null;
            }
            this.z = null;
        }
        if (this.x != null) {
            this.x.a();
            this.x = null;
        }
    }

    private int b(GL10 gl10) {
        if (this.E == h.e.REAL) {
            this.v.b(gl10);
            if (this.x != null) {
                int c2 = this.x.c();
                if (c2 == this.l) {
                    return (int) (((long) c2) + (System.currentTimeMillis() - this.k));
                }
                this.l = c2;
                this.k = System.currentTimeMillis();
                return c2;
            }
        }
        return 0;
    }

    private void c(GL10 gl10) {
        this.d = ((float) (System.currentTimeMillis() - this.c)) / 1000.0f;
        if (this.d > 5.0f || this.e) {
            synchronized (this.u) {
                Log.i("FittingRenderer", "Running FXGC...");
                this.r.b(gl10);
                this.c = System.currentTimeMillis();
                this.e = false;
            }
        }
    }

    private void p() {
        if (this.g == -1) {
            this.f = System.currentTimeMillis();
            this.g++;
        } else {
            this.g++;
        }
        if (this.g == 60) {
            long currentTimeMillis = System.currentTimeMillis();
            this.h = ((float) this.g) / (((float) (currentTimeMillis - this.f)) / 1000.0f);
            this.f = currentTimeMillis;
            this.g = 0;
        }
    }

    public float b() {
        return this.h;
    }

    private void d(GL10 gl10) {
        if (this.r.j(this.A.e()) && this.r.k(this.A.e()) != this.s.GetBilateralFilteringValue() && this.s.GetFaceData() != null) {
            this.s.PrepareBilateralFiltering(this.A.b().b());
            int GenerateBilateralFilteringTexture = this.s.GenerateBilateralFilteringTexture();
            this.s.ReleaseBilateralFiltering();
            Log.i("FittingRenderer", "[c] mNeedUpdateCustomfaceTexture - glTextureID: " + GenerateBilateralFilteringTexture + ", " + this.s.GetBilateralFilteringValue());
            this.r.a(this.A.e(), GenerateBilateralFilteringTexture, this.s.GetBilateralFilteringValue());
        }
    }

    private void a(final FittingSurfaceView.c cVar) {
        if (this.E == h.e.REAL) {
            this.z[b(this.E)].a(this.r.e(4));
        }
        if (this.x != null) {
            this.x.a();
            this.x = null;
        }
        if (this.x == null) {
            this.x = new b(this.y, this.r.d(4));
            this.x.a(i(), (SurfaceTexture.OnFrameAvailableListener) null, new MediaPlayer.OnInfoListener() {
                public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                    if (i != 3) {
                        return false;
                    }
                    switch (cVar) {
                        case B:
                            boolean unused = a.this.V = true;
                            break;
                        case BACD:
                            boolean unused2 = a.this.ae = true;
                            break;
                    }
                    boolean unused3 = a.this.ah = true;
                    return false;
                }
            }, (MediaPlayer.OnCompletionListener) null);
            this.x.b();
        }
    }

    private void q() {
        if (this.n != null) {
            this.r.a(this.n);
            this.n.recycle();
            this.n = null;
        }
    }

    private void e(GL10 gl10) {
        if (this.x != null) {
            this.x.a();
            this.x = null;
        }
        this.r.b();
        d(gl10);
        this.ag = true;
        if (this.o != -1) {
            this.r.a(this.o);
            c();
            this.o = -1;
        }
    }

    private void f(GL10 gl10) {
        if (this.i != null) {
            this.r.b(this.G, (float[]) this.i.clone(), this.j);
            this.i = null;
        }
        this.z[b(this.E)].a(this.r.c(this.G));
        this.r.b();
    }

    private void g(GL10 gl10) {
        a(FittingSurfaceView.c.B);
    }

    private void h(GL10 gl10) {
        this.r.b();
        this.ai = true;
    }

    private void i(GL10 gl10) {
        s();
        this.r.g(this.G);
        this.r.b();
        if (this.r.b(this.D.a())) {
            this.r.a(this.E, this.G);
            this.F = this.E;
        }
        o();
    }

    private void r() {
        for (int i2 = 0; i2 < this.C.size(); i2++) {
            if (this.C.get(i2).d() != 1) {
                this.r.a(this.C.get(i2).e());
            }
        }
    }

    private void j(GL10 gl10) {
        this.r.c(this.G, this.I);
        this.r.b();
    }

    private void k(GL10 gl10) {
        this.r.a(this.G, this.J);
        this.r.b();
    }

    private void l(GL10 gl10) {
        this.z[b(h.e.CAPTURE)].a();
        if (this.M) {
            this.z[b(h.e.CAPTURE)].a(this.z[b(h.e.AVATAR)]);
        }
        this.f1479a = this.r.a(this.z[b(h.e.CAPTURE)].d(), this.z[b(h.e.CAPTURE)].e(), this.z[b(h.e.CAPTURE)].f(), this.G, this.M, this.N, this.O);
    }

    private boolean m(GL10 gl10) {
        boolean SaveCustomMesh = (!this.q || !(this.q ? this.s.PrepareCustomFace() : false) || !this.s.GenerateCustomFace() || !this.q) ? false : this.s.SaveCustomMesh();
        this.s.release();
        if (!this.q) {
            SaveCustomMesh = false;
        }
        if (SaveCustomMesh) {
            this.ag = false;
            this.r.c();
            c();
        }
        if (!(!SaveCustomMesh || this.s.GetFittingAvatarData() == null || this.s.GetFittingAnimationData() == null)) {
            this.A = this.s.GetFittingAvatarData();
            this.D = this.s.GetFittingAnimationData();
            a(this.D, this.A, false);
            this.r.g(this.G);
            this.r.b();
            d(gl10);
            this.ag = true;
        }
        this.s.SetFittingAvatarData((b) null);
        this.s.SetFittingAnimationData((net.fxgear.fittingview.data.a) null);
        return SaveCustomMesh;
    }

    private void n(GL10 gl10) {
        this.r.b();
        d(gl10);
    }

    private void o(GL10 gl10) {
        this.r.b();
        this.r.a(this.E, this.G);
        this.F = this.E;
    }

    private void p(GL10 gl10) {
        if (this.i != null) {
            this.r.b(this.G, (float[]) this.i.clone(), this.j);
            this.i = null;
        }
        this.z[b(this.E)].a(this.r.c(this.G));
        s();
        this.r.g(this.G);
        this.r.b();
        d(gl10);
        this.r.a(this.E, this.G);
        this.F = this.E;
        this.ag = true;
        if (this.o != -1) {
            this.r.a(this.o);
            c();
            this.o = -1;
        }
        o();
    }

    private boolean q(GL10 gl10) {
        boolean SaveCustomMesh = (!this.s.PrepareCustomFace() || !this.s.GenerateCustomFace()) ? false : this.s.SaveCustomMesh();
        this.s.release();
        this.ag = false;
        this.r.c();
        c();
        if (this.i != null) {
            this.r.b(this.G, (float[]) this.i.clone(), this.j);
            this.i = null;
        }
        this.z[b(this.E)].a(this.r.c(this.G));
        s();
        this.r.g(this.G);
        this.r.b();
        d(gl10);
        this.r.a(this.E, this.G);
        this.F = this.E;
        this.ag = true;
        if (this.o != -1) {
            this.r.a(this.o);
            c();
            this.o = -1;
        }
        o();
        return SaveCustomMesh;
    }

    private void r(GL10 gl10) {
        a(FittingSurfaceView.c.BACD);
    }

    private void s(GL10 gl10) {
        this.r.i(this.H);
        s();
        this.r.g(this.G);
        this.r.b();
        d(gl10);
        this.r.a(this.E, this.G);
        this.F = this.E;
        this.ag = true;
        this.ai = true;
        if (this.o != -1) {
            this.r.a(this.o);
            c();
            this.o = -1;
        }
    }

    private FittingSurfaceView.c t(GL10 gl10) {
        FittingSurfaceView.c cVar = FittingSurfaceView.c.NONE;
        if (this.m) {
            q();
            this.m = false;
        }
        if (this.T) {
            e(gl10);
            cVar = FittingSurfaceView.c.A;
            this.T = false;
        }
        if (this.Y) {
            f(gl10);
            this.Y = false;
            cVar = FittingSurfaceView.c.E;
        }
        if (this.U) {
            g(gl10);
            this.U = false;
        }
        if (this.V) {
            h(gl10);
            cVar = FittingSurfaceView.c.B;
            this.V = false;
        }
        if (this.W) {
            i(gl10);
            cVar = FittingSurfaceView.c.C;
            this.W = false;
        }
        if (this.Z) {
            j(gl10);
            cVar = FittingSurfaceView.c.F;
            this.Z = false;
        }
        if (this.aa) {
            k(gl10);
            cVar = FittingSurfaceView.c.G;
            this.aa = false;
        }
        if (this.R) {
            l(gl10);
            cVar = FittingSurfaceView.c.CAPTURE_DATA;
            this.R = false;
        }
        if (this.P) {
            boolean m2 = m(gl10);
            if (!m2) {
                this.t.a(FittingSurfaceView.c.CUSTOM_DATA, m2, (Throwable) null);
            } else {
                cVar = FittingSurfaceView.c.CUSTOM_DATA;
            }
            this.P = false;
        }
        if (this.Q) {
            n(gl10);
            cVar = FittingSurfaceView.c.CUSTOM_DATA;
            this.Q = false;
        }
        if (this.X) {
            o(gl10);
            cVar = FittingSurfaceView.c.D;
            this.X = false;
        }
        if (this.ab) {
            p(gl10);
            this.ab = false;
            cVar = FittingSurfaceView.c.ACED;
        }
        if (this.ac) {
            boolean q2 = q(gl10);
            this.ac = false;
            if (!q2) {
                this.t.a(FittingSurfaceView.c.FACED, q2, (Throwable) null);
            } else {
                cVar = FittingSurfaceView.c.FACED;
            }
        }
        if (this.ad) {
            r(gl10);
            this.ad = false;
        }
        if (this.ae) {
            s(gl10);
            cVar = FittingSurfaceView.c.BACD;
            this.ae = false;
        }
        if (this.af) {
            r();
            this.af = false;
        }
        if (!this.S) {
            return cVar;
        }
        FittingSurfaceView.c cVar2 = FittingSurfaceView.c.RENDER_CANCEL;
        this.S = false;
        return cVar2;
    }

    public void a(boolean z2) {
        this.p = z2;
        if (z2) {
            this.S = true;
        }
    }

    public void a(int i2, int i3) {
        GLES20.glViewport(0, 0, i2, i3);
        GLES20.glClearColor(0.76171875f, 0.765625f, 0.75390625f, 1.0f);
        GLES20.glClearStencil(0);
        GLES20.glClear(17664);
        this.r.j();
    }

    public void c() {
        this.e = true;
    }

    public void a(b bVar, net.fxgear.fittingview.data.a aVar, boolean z2, boolean z3) {
        Log.i("FittingRenderer", "SetAvatarData");
        if (bVar.i() == 2 || bVar.i() == 3) {
            this.z[b(h.e.NONE)].a(true);
            this.z[b(h.e.AVATAR)].a(true);
            this.z[b(h.e.AVATAR_CUSTOM_FACE_EDITING)].a(true);
            this.z[b(h.e.AVATAR_FACE_EDITING)].a(true);
            this.z[b(h.e.AVATAR_HAIR_EDITING)].a(true);
            this.z[b(h.e.AVATAR_SKIN_TONE_EDITING)].a(true);
            this.z[b(h.e.AVATAR_BODY_EDITING)].a(true);
            this.z[b(h.e.REAL)].a(true);
            this.z[b(h.e.CAPTURE)].a(true);
            this.z[b(h.e.CHECK_CLOTHES_SIZE)].a(true);
        } else {
            this.z[b(h.e.NONE)].a(false);
            this.z[b(h.e.AVATAR)].a(false);
            this.z[b(h.e.AVATAR_CUSTOM_FACE_EDITING)].a(false);
            this.z[b(h.e.AVATAR_FACE_EDITING)].a(false);
            this.z[b(h.e.AVATAR_HAIR_EDITING)].a(false);
            this.z[b(h.e.AVATAR_SKIN_TONE_EDITING)].a(false);
            this.z[b(h.e.AVATAR_BODY_EDITING)].a(false);
            this.z[b(h.e.REAL)].a(false);
            this.z[b(h.e.CAPTURE)].a(false);
            this.z[b(h.e.CHECK_CLOTHES_SIZE)].a(false);
        }
        if (z3) {
            this.ag = false;
        }
        if (z2) {
            this.r.d();
            c();
        }
        this.A = bVar;
        this.D = aVar;
        a(this.D, this.A, z2);
        this.r.g(this.G);
        if (z3) {
            this.T = true;
            if (bVar.b().c()) {
                c();
            }
        }
    }

    public void a(net.fxgear.fittingview.data.h hVar, boolean z2) {
        Log.i("FittingRenderer", "SetRealData");
        this.ah = false;
        this.ai = false;
        this.B = hVar;
        a(this.B);
        if (z2) {
            this.U = true;
        }
    }

    public void a(ArrayList<d> arrayList, boolean z2) {
        Log.i("FittingRenderer", "SetClothesDataList");
        this.C.clear();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (arrayList.get(i2) != null) {
                this.C.add(arrayList.get(i2));
            }
        }
        a(this.C);
        if (z2) {
            this.W = true;
        }
    }

    public void a(ArrayList<d> arrayList, b bVar, net.fxgear.fittingview.data.a aVar, boolean z2) {
        Log.i("FittingRenderer", "[c] SetClothesDataList()+");
        this.A = bVar;
        this.D = aVar;
        a(aVar, bVar, false);
        this.r.a(aVar.a(), aVar.b());
        a(arrayList, z2);
    }

    public void a(h.e eVar, int i2, int i3, boolean z2) {
        Log.i("FittingRenderer", "SetSceneModeAndModelCategory");
        boolean z3 = this.E != eVar;
        this.G = i2;
        this.H = i3;
        this.E = eVar;
        switch (eVar) {
            case AVATAR:
                this.z[b(h.e.AVATAR)].a();
                break;
            case AVATAR_CUSTOM_FACE_EDITING:
                if (z3) {
                    this.z[b(h.e.AVATAR_CUSTOM_FACE_EDITING)].a();
                    break;
                }
                break;
            case AVATAR_FACE_EDITING:
                if (z3) {
                    this.z[b(h.e.AVATAR_FACE_EDITING)].a();
                    break;
                }
                break;
            case AVATAR_HAIR_EDITING:
                if (z3) {
                    this.z[b(h.e.AVATAR_HAIR_EDITING)].a();
                    break;
                }
                break;
            case AVATAR_SKIN_TONE_EDITING:
                if (z3) {
                    this.z[b(h.e.AVATAR_SKIN_TONE_EDITING)].a();
                    break;
                }
                break;
            case AVATAR_BODY_EDITING:
                if (z3) {
                    this.z[b(h.e.AVATAR_BODY_EDITING)].a();
                    break;
                }
                break;
            case CHECK_CLOTHES_SIZE:
                this.z[b(h.e.CHECK_CLOTHES_SIZE)].a();
                break;
        }
        if (z2) {
            this.X = true;
        }
    }

    public void a(float[] fArr, int i2, float f2, boolean z2) {
        Log.i("FittingRenderer", "SetBodyBlendWeight");
        this.i = (float[]) fArr.clone();
        this.j = f2;
        this.r.f(i2);
        if (z2) {
            this.Y = true;
        }
    }

    public void a(FittingFaceData fittingFaceData, b bVar, net.fxgear.fittingview.data.a aVar, ArrayList<d> arrayList, float[] fArr, float f2, h.e eVar, int i2, boolean z2, boolean z3) throws InterruptedException {
        Log.i("FittingRenderer", "SetCustomfaceGenerateAndAvatarDataAndClothDataListAndBodyBlendWeightAndSceneModeAndModelCategory");
        StringBuilder sb = new StringBuilder();
        sb.append("face data : ");
        sb.append(fittingFaceData != null);
        Log.i("FittingRenderer", sb.toString());
        synchronized (this.am) {
            while (!this.f1480b) {
                Log.w("FittingRenderer", "[L] Not Initialize.");
                this.am.wait();
            }
            Log.i("FittingRenderer", "[L] Initialized.");
        }
        if (this.y != null) {
            synchronized (this.u) {
                if (fittingFaceData != null) {
                    try {
                        a(fittingFaceData, false);
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
                a(fArr, -1, f2, false);
                a(bVar, aVar, z2, false);
            }
            a(arrayList, false);
            a(eVar, i2, bVar.i(), false);
            if (!z3) {
                return;
            }
            if (fittingFaceData != null) {
                this.ac = true;
            } else {
                this.ab = true;
            }
        }
    }

    public void a(net.fxgear.fittingview.data.h hVar, b bVar, net.fxgear.fittingview.data.a aVar, ArrayList<d> arrayList, h.e eVar, int i2, boolean z2, boolean z3) throws InterruptedException {
        Log.i("FittingRenderer", "SetRealDataAndAvatarDataAndClothDataListAndSceneModeAndModelCategory");
        synchronized (this.am) {
            while (!this.f1480b) {
                Log.w("FittingRenderer", "[L] Not Initialize.");
                this.am.wait();
            }
            Log.i("FittingRenderer", "[L] Initialized.");
        }
        if (this.y != null) {
            synchronized (this.u) {
                this.ag = false;
                this.ah = false;
                this.ai = false;
                a(bVar, aVar, z2, false);
                a(hVar, false);
            }
            a(arrayList, false);
            a(eVar, i2, hVar.d(), false);
            if (z3) {
                this.ad = true;
            }
        }
    }

    public void a(float[] fArr, boolean z2) {
        Log.i("FittingRenderer", "SetSkinTone");
        this.I[0] = fArr[0];
        this.I[1] = fArr[1];
        this.I[2] = fArr[2];
        if (z2) {
            this.Z = true;
        }
    }

    public void a(float f2, boolean z2) {
        Log.i("FittingRenderer", "SetFaceScale");
        this.J = f2;
        if (z2) {
            this.aa = true;
        }
    }

    public void a(net.fxgear.fittingview.data.a aVar, b bVar, boolean z2) {
        Log.e("FittingRenderer", "[c] UpdateAvatarData()+");
        if (this.D.c() == null) {
            Log.e("FittingRenderer", "[c] ERROR: UpdateAvatarData BlendTargetFilePathList null!");
            return;
        }
        this.r.a(aVar.a(), aVar.c(), aVar.b(), bVar.e(), bVar.i());
        if (this.i != null) {
            this.r.a(bVar.e(), (float[]) this.i.clone());
        }
        this.r.a(bVar.a().a(), bVar.a().b(), bVar.a().c(), bVar.a().e(), bVar.e(), h.d.BODY, bVar.a().d(), z2, false);
        boolean z3 = true;
        this.r.a(bVar.b().a(), (ArrayList<String>) new ArrayList(Arrays.asList(new String[]{bVar.b().b()})), bVar.b().b(), (ArrayList<String>) null, bVar.e(), h.d.HEAD, (ArrayList<String>) null, z2, false);
        this.r.a(bVar.e(), bVar.b().c());
        if (this.A.c().d().size() != 0) {
            if (this.A.c().b() == null) {
                z3 = false;
            } else if (this.r.g() == h.e.AVATAR_HAIR_EDITING) {
                this.r.e(aVar.a());
            }
            if (z3) {
                this.r.a(aVar.a(), this.A.c().c(), this.A.c().b(), bVar.e(), bVar.i());
                this.r.a(bVar.c().a(), bVar.c().d(), bVar.e(), h.d.HAIR, (ArrayList<String>) null, z2, false);
                this.r.a(bVar.e(), bVar.c().e());
                if (bVar.c().f() != null) {
                    this.r.a(bVar.c().f().b(), (ArrayList<String>) null, (String) null, (ArrayList<String>) null, bVar.e(), h.d.HAIR_ACC, (ArrayList<String>) null, z2, true);
                    this.r.b(bVar.e(), bVar.c().f().a());
                } else {
                    this.r.a(bVar.e(), h.d.HAIR_ACC);
                }
            } else {
                this.r.a(bVar.c().a(), bVar.c().d(), bVar.e(), h.d.HAIR, (ArrayList<String>) null, z2, true);
                this.r.a(bVar.e(), bVar.c().e());
                this.r.e(aVar.a());
                if (bVar.c().f() != null) {
                    this.r.a(bVar.c().f().b(), (ArrayList<String>) null, (String) null, (ArrayList<String>) null, bVar.e(), h.d.HAIR_ACC, (ArrayList<String>) null, z2, true);
                    this.r.b(bVar.e(), bVar.c().f().a());
                } else {
                    this.r.a(bVar.e(), h.d.HAIR_ACC);
                }
            }
        }
        this.r.c(bVar.e(), FittingSurfaceView.computeColorTemperature(bVar.g()));
        this.r.a(bVar.e(), bVar.h());
        if (this.A.d() != null && this.A.f() > GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
            a(this.A.d(), this.A.f(), false);
        }
    }

    public void a(FittingFaceData fittingFaceData, boolean z2) {
        this.q = true;
        fittingFaceData.SetFaceType(1);
        this.s.Initial(fittingFaceData, true);
        if (z2) {
            this.P = true;
        }
    }

    public void a(FittingFaceData fittingFaceData, b bVar, net.fxgear.fittingview.data.a aVar) {
        this.q = true;
        fittingFaceData.SetFaceType(1);
        this.s.Initial(fittingFaceData, true);
        this.s.SetFittingAvatarData(bVar);
        this.s.SetFittingAnimationData(aVar);
        this.P = true;
    }

    public void d() {
        this.q = false;
        this.P = false;
        this.s.release();
    }

    public void a(FittingFaceData fittingFaceData, float f2, boolean z2) {
        if (fittingFaceData == null) {
            fittingFaceData = this.A.d();
        }
        if (fittingFaceData != null) {
            fittingFaceData.SetCustomBitmapFilePath(this.A.b().b());
            this.s.Initial(fittingFaceData, false);
        }
        if (this.s.GetFaceData() == null) {
            Log.e("FittingRenderer", "[c] ERROR: SetCustomfaceTexture() - GetFaceData == null");
            return;
        }
        this.s.SetBilateralFilteringValue(f2);
        if (z2) {
            this.Q = true;
        }
    }

    public void a(Bitmap bitmap) {
        this.n = bitmap;
        this.m = true;
    }

    public void a(int i2, int i3, boolean z2, boolean z3, boolean z4) {
        this.K = i2;
        this.L = i3;
        this.z[b(h.e.CAPTURE)].a(this.K, this.L);
        this.M = z2;
        this.N = z3;
        this.O = z4;
        this.R = true;
    }

    public Bitmap e() {
        return this.f1479a;
    }

    private void a(net.fxgear.fittingview.data.h hVar) {
        if (hVar.a() == null) {
            Log.e("FittingRenderer", "[c] ERROR: UpdateRealData GetAnimationFilePath() == null!");
        } else {
            this.r.a(hVar.a(), hVar.b(), hVar.c(), hVar.d());
        }
    }

    public h.d a(int i2) {
        switch (i2) {
            case 0:
                return h.d.INNER;
            case 1:
                return h.d.PANTS;
            case 2:
                return h.d.ONEPIECE;
            case 3:
                return h.d.JACK;
            case 4:
                return h.d.COAT;
            case 5:
                return h.d.SHOES;
            default:
                return h.d.NONE;
        }
    }

    private void a(ArrayList<d> arrayList) {
        if (arrayList.size() == 0) {
            Log.e("FittingRenderer", "There are no clothes.");
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (arrayList.get(i2).d() != 1) {
                h.d a2 = a(arrayList.get(i2).c());
                if (a2 == h.d.SHOES) {
                    this.r.a(arrayList.get(i2).h(), arrayList.get(i2).i(), arrayList.get(i2).b(), a2);
                } else {
                    this.r.a(arrayList.get(i2).e(), arrayList.get(i2).f(), arrayList.get(i2).g(), arrayList.get(i2).l(), arrayList.get(i2).k(), a2, arrayList.get(i2).j(), arrayList.get(i2).m());
                }
            }
        }
    }

    private void s() {
        boolean z2;
        if (this.C.size() == 0) {
            Log.e("FittingRenderer", "There are no clothes.");
            return;
        }
        boolean z3 = false;
        boolean z4 = false;
        for (int i2 = 0; i2 < this.C.size(); i2++) {
            if (a(this.C.get(i2).c()) == h.d.INNER && this.C.get(i2).d() != 1) {
                z3 = true;
            }
            if (a(this.C.get(i2).c()) == h.d.ONEPIECE && this.C.get(i2).d() != 1) {
                z3 = true;
            }
            if ((a(this.C.get(i2).c()) == h.d.JACK || a(this.C.get(i2).c()) == h.d.COAT) && this.C.get(i2).d() != 1) {
                z4 = true;
            }
        }
        if (z4) {
            z2 = true;
            z3 = true;
        } else {
            z2 = false;
        }
        this.r.a(this.C.get(0).b(), z3, z2, false);
        for (int i3 = 0; i3 < this.C.size(); i3++) {
            if (this.C.get(i3).d() != 1) {
                boolean a2 = this.r.a(this.C.get(i3).e(), this.C.get(i3).b());
                if (!a2) {
                    this.r.a(this.C.get(i3).e(), this.C.get(i3).f(), this.C.get(i3).g(), this.C.get(i3).l(), this.C.get(i3).k(), a(this.C.get(i3).c()), this.C.get(i3).j(), this.C.get(i3).m());
                    a2 = this.r.a(this.C.get(i3).e(), this.C.get(i3).b());
                }
                this.r.b();
                if (!a2) {
                    Log.e("FittingRenderer", "Attach cloth failed.");
                }
            } else if (a(this.C.get(i3).c()) == h.d.JACK || a(this.C.get(i3).c()) == h.d.COAT) {
                boolean z5 = false;
                for (int i4 = 0; i4 < this.C.size(); i4++) {
                    if ((a(this.C.get(i4).c()) == h.d.JACK || a(this.C.get(i4).c()) == h.d.COAT) && this.C.get(i4).d() == -1) {
                        z5 = true;
                    }
                }
                if (!z5) {
                    this.r.a(this.C.get(i3).b(), a(this.C.get(i3).c()));
                }
            } else {
                this.r.a(this.C.get(i3).b(), a(this.C.get(i3).c()));
            }
        }
    }

    public void b(boolean z2) {
        this.r.a(z2);
    }

    public boolean f() {
        return this.r.i();
    }

    public void a(h.e eVar) {
        switch (eVar) {
            case AVATAR:
                this.z[b(h.e.AVATAR)].a();
                return;
            case AVATAR_FACE_EDITING:
                this.z[b(h.e.AVATAR_FACE_EDITING)].a();
                return;
            case AVATAR_HAIR_EDITING:
                this.z[b(h.e.AVATAR_HAIR_EDITING)].a();
                return;
            case AVATAR_BODY_EDITING:
                this.z[b(h.e.AVATAR_BODY_EDITING)].a();
                return;
            case REAL:
                this.z[b(h.e.REAL)].a();
                return;
            case CHECK_CLOTHES_SIZE:
                this.z[b(h.e.CHECK_CLOTHES_SIZE)].a();
                return;
            default:
                return;
        }
    }

    private int b(h.e eVar) {
        switch (eVar) {
            case NONE:
                return 0;
            case AVATAR:
                return 1;
            case AVATAR_CUSTOM_FACE_EDITING:
                return 2;
            case AVATAR_FACE_EDITING:
                return 3;
            case AVATAR_HAIR_EDITING:
                return 4;
            case AVATAR_SKIN_TONE_EDITING:
                return 5;
            case AVATAR_BODY_EDITING:
                return 6;
            case REAL:
                return 7;
            case CAPTURE:
                return 8;
            case CHECK_CLOTHES_SIZE:
                return 9;
            default:
                return -1;
        }
    }

    public h.e g() {
        return this.r.g();
    }

    public int h() {
        return this.r.h();
    }

    public int i() {
        return this.r.f();
    }

    public void a(float f2) {
        this.z[b(this.E)].d(f2);
    }

    public float j() {
        return this.z[b(this.E)].h();
    }

    public void b(float f2) {
        this.z[b(this.E)].e(f2);
    }

    public float k() {
        return this.z[b(this.E)].i();
    }

    public boolean a(MotionEvent motionEvent) {
        boolean b2 = this.r.b((int) motionEvent.getX(), (int) motionEvent.getY());
        Log.d("FittingRenderer", "[JE] Point in body: " + b2);
        return b2;
    }

    public void b(MotionEvent motionEvent) {
        this.z[b(this.E)].a(motionEvent);
    }

    public void a(MotionEvent motionEvent, boolean z2, boolean z3) {
        this.z[b(this.E)].a(motionEvent, z2, z3);
    }

    public void c(MotionEvent motionEvent) {
        this.z[b(this.E)].b(motionEvent);
    }

    public void a(MotionEvent motionEvent, boolean z2, boolean z3, boolean z4) {
        this.z[b(this.E)].a(motionEvent, z2, z3, z4);
    }

    public void d(MotionEvent motionEvent) {
        this.z[b(this.E)].c(motionEvent);
    }

    public void a(h.f fVar) {
        if (this.ao != null) {
            this.ao.a(fVar);
        }
    }

    public h.f l() {
        return this.ao != null ? this.ao.c() : h.f.DISABLED;
    }

    public void a(h.c cVar) {
        if (this.ao != null) {
            this.ao.a(cVar);
        }
    }

    public h.c m() {
        return this.ao != null ? this.ao.d() : h.c.Color;
    }

    public void c(boolean z2) {
        this.af = z2;
    }

    public int n() {
        return this.G;
    }

    public void a(int i2, h.d dVar) {
        this.r.a(i2, this.G, dVar);
    }

    public void o() {
        this.r.k();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingview\b.java ==========

package net.fxgear.fittingview;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.Surface;

/* compiled from: VideoFrameInterface */
class b {

    /* renamed from: a  reason: collision with root package name */
    private final String f1486a = "Movie2Texture";

    /* renamed from: b  reason: collision with root package name */
    private MediaPlayer f1487b;
    private SurfaceTexture c;
    private int d;
    private int e;
    private Object f = new Object();
    private final int g = 20000;

    public b(Context context, String str) {
        this.f1487b = MediaPlayer.create(context, Uri.parse(str));
        if (this.f1487b == null) {
            Log.e("Movie2Texture", "MediaPlayer is null. path : " + str);
        } else {
            this.f1487b.setLooping(true);
        }
        this.e = 0;
    }

    public void a() {
        Log.i("Movie2Texture", "[c] Finalize()");
        this.e = 0;
        synchronized (this.f) {
            if (this.c != null) {
                this.c.release();
                this.c = null;
            }
            if (this.f1487b != null) {
                this.f1487b.setLooping(false);
                this.f1487b.release();
                this.f1487b = null;
            }
        }
    }

    public boolean a(int i, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, MediaPlayer.OnInfoListener onInfoListener, MediaPlayer.OnCompletionListener onCompletionListener) {
        if (this.f1487b == null) {
            Log.e("Movie2Texture", "[c] Prepare - mMp null return");
            return false;
        }
        this.d = i;
        this.c = new SurfaceTexture(this.d);
        if (onFrameAvailableListener != null) {
            this.c.setOnFrameAvailableListener(onFrameAvailableListener);
        }
        Surface surface = new Surface(this.c);
        this.f1487b.setSurface(surface);
        surface.release();
        if (onInfoListener != null) {
            this.f1487b.setOnInfoListener(onInfoListener);
        }
        if (onCompletionListener != null) {
            this.f1487b.setOnCompletionListener(onCompletionListener);
        }
        this.e = 0;
        return true;
    }

    public void b() {
        if (this.f1487b != null) {
            this.f1487b.start();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(javax.microedition.khronos.opengles.GL10 r5) {
        /*
            r4 = this;
            java.lang.Object r5 = r4.f
            monitor-enter(r5)
            android.graphics.SurfaceTexture r0 = r4.c     // Catch:{ all -> 0x002f }
            if (r0 == 0) goto L_0x002d
            android.media.MediaPlayer r0 = r4.f1487b     // Catch:{ all -> 0x002f }
            if (r0 != 0) goto L_0x000c
            goto L_0x002d
        L_0x000c:
            android.graphics.SurfaceTexture r0 = r4.c     // Catch:{ all -> 0x002f }
            r0.updateTexImage()     // Catch:{ all -> 0x002f }
            android.graphics.SurfaceTexture r0 = r4.c     // Catch:{ all -> 0x002f }
            long r0 = r0.getTimestamp()     // Catch:{ all -> 0x002f }
            r2 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = r0 / r2
            int r0 = (int) r0     // Catch:{ all -> 0x002f }
            if (r0 <= 0) goto L_0x0023
            r1 = 20000(0x4e20, float:2.8026E-41)
            if (r0 >= r1) goto L_0x0023
            goto L_0x0029
        L_0x0023:
            android.media.MediaPlayer r0 = r4.f1487b     // Catch:{ all -> 0x002f }
            int r0 = r0.getCurrentPosition()     // Catch:{ all -> 0x002f }
        L_0x0029:
            r4.e = r0     // Catch:{ all -> 0x002f }
            monitor-exit(r5)     // Catch:{ all -> 0x002f }
            return
        L_0x002d:
            monitor-exit(r5)     // Catch:{ all -> 0x002f }
            return
        L_0x002f:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x002f }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fittingview.b.a(javax.microedition.khronos.opengles.GL10):void");
    }

    public int c() {
        return this.e;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingview\FittingSurfaceView.java ==========

package net.fxgear.fittingview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.opengles.GL10;
import net.fxgear.GlobalDefine;
import net.fxgear.b.h;
import net.fxgear.customface.CustomFaceInterface;
import net.fxgear.customface.f;
import net.fxgear.fittingview.data.FittingFaceData;
import net.fxgear.fittingview.data.d;
import net.fxgear.fittingview.data.g;

public abstract class FittingSurfaceView extends GLSurfaceView implements View.OnTouchListener {
    public static final float[] KELVIN_RANGE = {4000.0f, 6600.0f, 15000.0f};
    /* access modifiers changed from: private */
    public Throwable A = null;
    /* access modifiers changed from: private */
    public IFittingSurfaceViewEventListener B = null;
    private float C = 10.0f;
    private final float D = 17.0f;
    private final int E = 300;
    private final int F = 1;
    private Handler G = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 1) {
                Log.i("FittingSurfaceView", "[c] mHandler EVENT_ONE_CLICK_CHECK");
                if (FittingSurfaceView.this.f) {
                    Log.i("FittingSurfaceView", "[c] mHandler OnOneClick event op!");
                    if (FittingSurfaceView.this.B != null) {
                        FittingSurfaceView.this.B.OnOneClick();
                    }
                    FittingSurfaceView.this.f = false;
                }
            }
        }
    };

    /* renamed from: a  reason: collision with root package name */
    boolean f1471a = false;

    /* renamed from: b  reason: collision with root package name */
    boolean f1472b = false;
    float c = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    float d = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    long e = 0;
    boolean f = false;
    boolean g = true;
    boolean h = true;
    boolean i = true;
    boolean j = false;
    boolean k = false;
    float l = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    float m = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    float n = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    float o = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    private final String p = "FittingSurfaceView";
    private Context q;
    private final a r;
    private int s;
    private int t;
    private a u = new a() {
        public void a(c cVar, boolean z, Throwable th) {
            Log.i("FittingSurfaceView", "[c] OnFinishAsyncRender()+ " + cVar + ", " + z);
            boolean unused = FittingSurfaceView.this.z = z;
            if (FittingSurfaceView.this.x == cVar) {
                Log.i("FittingSurfaceView", "[c] OnFinishAsyncRender() Sync notify: " + cVar + ", " + z);
                if (cVar != c.RENDER_CANCEL) {
                    FittingSurfaceView.this.SetRenderCancel(false);
                }
                c unused2 = FittingSurfaceView.this.x = c.NONE;
                if (FittingSurfaceView.this.w) {
                    synchronized (FittingSurfaceView.this.v) {
                        try {
                            FittingSurfaceView.this.v.notify();
                            boolean unused3 = FittingSurfaceView.this.w = false;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            Throwable unused4 = FittingSurfaceView.this.A = th;
            if (th != null) {
                boolean unused5 = FittingSurfaceView.this.z = false;
            }
        }
    };
    /* access modifiers changed from: private */
    public final Object v = new Object();
    /* access modifiers changed from: private */
    public boolean w = false;
    /* access modifiers changed from: private */
    public c x = c.NONE;
    private long y = 5000;
    /* access modifiers changed from: private */
    public boolean z = false;

    public interface IFittingSurfaceViewEventListener {
        void OnBodySlide(boolean z);

        void OnDoubleClick();

        void OnOneClick();
    }

    public interface a {
        void a(c cVar, boolean z, Throwable th);
    }

    public enum c {
        NONE,
        CAPTURE_DATA,
        CUSTOM_DATA,
        RENDER_CANCEL,
        A,
        B,
        C,
        D,
        E,
        F,
        G,
        ACED,
        FACED,
        BACD,
        CM
    }

    public int GetCustomFaceStorageMinSize() {
        return 4808704;
    }

    class b implements GLSurfaceView.EGLConfigChooser {
        b() {
        }

        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            int[] iArr = new int[1];
            egl10.eglChooseConfig(eGLDisplay, new int[]{12329, 0, 12352, 4, 12351, 12430, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12326, 8, 12338, 1, 12337, 4, 12344}, eGLConfigArr, 1, iArr);
            if (iArr[0] == 0) {
                return null;
            }
            return eGLConfigArr[0];
        }
    }

    public FittingSurfaceView(Context context) {
        super(context);
        this.q = context;
        setEGLConfigChooser(new b());
        setEGLContextClientVersion(2);
        this.r = new a(this.q, this.u);
        setRenderer(this.r);
        setRenderMode(1);
        setPreserveEGLContextOnPause(true);
        setOnTouchListener(this);
        SetSolverMode(h.f.COLLISION_RESOLUTION);
        this.C = GlobalDefine.GetPixelFromDP(context, 17.0f);
    }

    /* access modifiers changed from: protected */
    public boolean SetBackgroundBGBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return false;
        }
        this.r.a(bitmap);
        return true;
    }

    @SuppressLint({"NewApi"})
    public void onPause() {
        Log.i("FittingSurfaceView", "[c] onPause()");
        this.f1472b = true;
        super.onPause();
    }

    public void onResume() {
        Log.i("FittingSurfaceView", "[c] onResume()");
        this.f1472b = false;
        super.onResume();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int pointerCount = motionEvent.getPointerCount();
        if (pointerCount > 1) {
            this.f = false;
            this.j = false;
        }
        if (action == 6) {
            this.r.c(motionEvent);
        } else if (action != 261) {
            switch (action) {
                case 0:
                    if (pointerCount == 1) {
                        this.c = motionEvent.getX();
                        this.d = motionEvent.getY();
                        this.f = true;
                        this.l = motionEvent.getX();
                        this.m = motionEvent.getY();
                        this.n = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
                        this.o = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
                        this.j = this.r.a(motionEvent);
                    }
                    this.r.b(motionEvent);
                    break;
                case 1:
                    if (this.f) {
                        if (System.currentTimeMillis() - this.e < 300) {
                            Log.i("FittingSurfaceView", "[c] OnDoubleClick");
                            this.G.removeMessages(1);
                            if (this.B != null) {
                                this.B.OnDoubleClick();
                            }
                            this.f = false;
                            this.e = 0;
                        } else {
                            this.G.sendEmptyMessageDelayed(1, 300);
                            this.e = System.currentTimeMillis();
                        }
                    } else if (this.j && this.B != null) {
                        this.B.OnBodySlide(this.k);
                    }
                    this.j = false;
                    this.n = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
                    this.o = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
                    this.r.d(motionEvent);
                    break;
                case 2:
                    this.n += Math.abs(this.l - motionEvent.getX());
                    this.o += Math.abs(this.m - motionEvent.getY());
                    this.l = motionEvent.getX();
                    this.m = motionEvent.getY();
                    if (Math.abs(motionEvent.getX() - this.c) > this.C || Math.abs(motionEvent.getY() - this.d) > this.C) {
                        this.f = false;
                        if (!this.j || this.n >= this.o) {
                            this.j = false;
                        } else if (motionEvent.getY() > this.d) {
                            this.k = false;
                        } else {
                            this.k = true;
                        }
                    }
                    if (!this.j) {
                        this.r.a(motionEvent, this.g, this.h, this.i);
                        break;
                    }
                    break;
            }
        } else {
            this.r.a(motionEvent, this.h, this.i);
        }
        return true;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        this.t = i3;
        this.s = i4;
        super.surfaceChanged(surfaceHolder, i2, i3, i4);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Log.i("FittingSurfaceView", "[c] surfaceCreated()");
        this.f1471a = true;
        super.surfaceCreated(surfaceHolder);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Log.i("FittingSurfaceView", "[c] surfaceDestroyed()");
        this.f1471a = false;
        super.surfaceDestroyed(surfaceHolder);
    }

    public void onDestroy() {
        Log.i("FittingSurfaceView", "[c] onDestroy()");
        this.r.a((GL10) null);
        this.r.a();
    }

    public boolean GetSurfaceViewPause() {
        return this.f1472b;
    }

    public float GetFPS() {
        return this.r.b();
    }

    public void SetIFittingSurfaceViewEventListener(IFittingSurfaceViewEventListener iFittingSurfaceViewEventListener) {
        this.B = iFittingSurfaceViewEventListener;
    }

    public boolean SetRenderCancel(boolean z2) {
        this.r.a(z2);
        return this.x != c.NONE;
    }

    public void SetClothDataList(ArrayList<d> arrayList, net.fxgear.fittingview.data.b bVar, net.fxgear.fittingview.data.a aVar) throws Throwable {
        Log.i("FittingSurfaceView", "[c] SetClothDataList()+");
        synchronized (this.r) {
            this.x = c.C;
            this.A = null;
            this.z = false;
            this.r.a(arrayList, bVar, aVar, true);
        }
        synchronized (this.v) {
            try {
                if (this.f1471a && this.x == c.C) {
                    this.w = true;
                    this.v.wait(this.y);
                }
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
        Log.i("FittingSurfaceView", "[c] SetClothDataList()-");
        Log.i("FittingSurfaceView", "[L] result: " + this.z + ", lock: " + this.w);
        if (!this.z) {
            Log.i("FittingSurfaceView", "Failed setClothes.");
        }
        if (this.A != null) {
            throw this.A;
        }
    }

    public h.d GetClothesMeshCategory(int i2) {
        return this.r.a(i2);
    }

    public void SetBodyWeightDataAsync(int i2, float[] fArr, float f2) {
        synchronized (this.r) {
            this.A = null;
            this.z = false;
            this.r.a(fArr, i2, f2, true);
        }
    }

    public void SetBodyWeightData(float[] fArr, float f2) throws Throwable {
        Log.i("FittingSurfaceView", "[c] SetBodyWeightData()+");
        synchronized (this.r) {
            this.x = c.E;
            this.A = null;
            this.z = false;
            this.r.a(fArr, -1, f2, true);
        }
        synchronized (this.v) {
            try {
                if (this.f1471a && this.x == c.E) {
                    this.w = true;
                    this.v.wait(this.y);
                }
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
        Log.i("FittingSurfaceView", "[c] SetBodyWeightData()-");
        Log.i("FittingSurfaceView", "[L] result: " + this.z + ", lock: " + this.w);
        if (!this.z) {
            Log.i("FittingSurfaceView", "Failed set body weight.");
        }
        if (this.A != null) {
            throw this.A;
        }
    }

    public void SetModeData(net.fxgear.fittingview.data.h hVar, net.fxgear.fittingview.data.b bVar, net.fxgear.fittingview.data.a aVar, g gVar, FittingFaceData fittingFaceData, boolean z2) throws Throwable {
        Log.i("FittingSurfaceView", "[c] SetModeData()+ " + gVar.e());
        c SetModeDataAsync = SetModeDataAsync(hVar, bVar, aVar, gVar, fittingFaceData, z2);
        this.A = null;
        this.z = false;
        synchronized (this.v) {
            try {
                if (this.f1471a && this.x == SetModeDataAsync) {
                    this.w = true;
                    this.v.wait(this.y);
                }
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
        Log.i("FittingSurfaceView", "[c] SetModeData()- " + gVar.e());
        Log.i("FittingSurfaceView", "[L] result: " + this.z + ", lock: " + this.w);
        if (!this.z) {
            Log.i("FittingSurfaceView", "Failed set mode.");
        }
        if (this.A != null) {
            throw this.A;
        }
    }

    public c SetModeDataAsync(net.fxgear.fittingview.data.h hVar, net.fxgear.fittingview.data.b bVar, net.fxgear.fittingview.data.a aVar, g gVar, FittingFaceData fittingFaceData, boolean z2) throws Throwable {
        c cVar;
        if (gVar.b() == 2) {
            Log.e("FittingSurfaceView", "[c] ERROR: SetModeDataAsync AGE_OLD");
        }
        int i2 = 0;
        if (gVar.e() == h.e.AVATAR || gVar.e() == h.e.CHECK_CLOTHES_SIZE || gVar.e() == h.e.AVATAR_BODY_EDITING || gVar.e() == h.e.AVATAR_CUSTOM_FACE_EDITING || gVar.e() == h.e.AVATAR_FACE_EDITING || gVar.e() == h.e.AVATAR_SKIN_TONE_EDITING || gVar.e() == h.e.AVATAR_HAIR_EDITING) {
            if (gVar.a() == 0) {
                if (gVar.b() == 0) {
                    i2 = 2;
                } else {
                    int b2 = gVar.b();
                }
            } else if (gVar.a() != 1) {
                Log.e("FittingSurfaceView", "ERROR: GENDER UNISEX ");
            } else if (gVar.b() == 0) {
                i2 = 3;
            } else if (gVar.b() == 1) {
                i2 = 1;
            }
        } else if (gVar.e() == h.e.REAL) {
            i2 = 4;
        } else {
            Log.e("FittingSurfaceView", "WARNING: Edit or Capture mode");
        }
        synchronized (this.r) {
            switch (gVar.e()) {
                case REAL:
                    cVar = c.BACD;
                    this.x = cVar;
                    this.r.a(hVar, bVar, aVar, gVar.c(), gVar.e(), i2, z2, true);
                    break;
                case AVATAR:
                case CHECK_CLOTHES_SIZE:
                case AVATAR_BODY_EDITING:
                case AVATAR_CUSTOM_FACE_EDITING:
                case AVATAR_FACE_EDITING:
                case AVATAR_HAIR_EDITING:
                case AVATAR_SKIN_TONE_EDITING:
                    if (gVar.e() == h.e.CHECK_CLOTHES_SIZE) {
                        this.r.a(h.f.SIZE_SIMULATION);
                        this.r.a(h.c.Color);
                    } else {
                        this.r.a(h.f.COLLISION_RESOLUTION);
                    }
                    cVar = fittingFaceData == null ? c.ACED : c.FACED;
                    this.x = cVar;
                    this.r.a(fittingFaceData, bVar, aVar, gVar.c(), gVar.d(), gVar.f(), gVar.e(), i2, z2, true);
                    break;
                default:
                    cVar = c.NONE;
                    Log.e("FittingSurfaceView", " SCENE_MODE None or Capture ");
                    break;
            }
        }
        return cVar;
    }

    public void UpdateSkinToneAsync(float f2) {
        synchronized (this.r) {
            this.A = null;
            this.z = false;
            this.r.a(computeColorTemperature(f2), true);
        }
    }

    public void UpdateSkinTone(float f2) throws Throwable {
        Log.i("FittingSurfaceView", "[c] UpdateSkinTone()+");
        synchronized (this.r) {
            this.x = c.F;
            this.A = null;
            this.z = false;
            this.r.a(computeColorTemperature(f2), true);
        }
        synchronized (this.v) {
            try {
                if (this.f1471a && this.x == c.F) {
                    this.w = true;
                    this.v.wait(this.y);
                }
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
        Log.i("FittingSurfaceView", "[c] UpdateSkinTone()- " + this.z);
        Log.i("FittingSurfaceView", "[L] result: " + this.z + ", lock: " + this.w);
        if (!this.z) {
            Log.i("FittingSurfaceView", "Failed update skin tone.");
        }
        if (this.A != null) {
            throw this.A;
        }
    }

    public void SetFaceScaleAsync(float f2) {
        synchronized (this.r) {
            this.A = null;
            this.z = false;
            this.r.a(f2, true);
        }
    }

    public void SetFaceScale(float f2) throws Throwable {
        Log.i("FittingSurfaceView", "[c] SetFaceScale()+");
        synchronized (this.r) {
            this.x = c.G;
            this.A = null;
            this.z = false;
            this.r.a(f2, true);
        }
        synchronized (this.v) {
            try {
                if (this.f1471a && this.x == c.G) {
                    this.w = true;
                    this.v.wait(this.y);
                }
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
        Log.i("FittingSurfaceView", "[c] SetFaceScale()- " + this.z);
        Log.i("FittingSurfaceView", "[L] result: " + this.z + ", lock: " + this.w);
        if (!this.z) {
            Log.i("FittingSurfaceView", "Failed set face scale.");
        }
        if (this.A != null) {
            throw this.A;
        }
    }

    public boolean SetCustomfaceGenerateAndAvatarData(FittingFaceData fittingFaceData, net.fxgear.fittingview.data.b bVar, net.fxgear.fittingview.data.a aVar) throws Throwable {
        Log.i("FittingSurfaceView", "[c] SetCustomfaceGenerateAndAvatarData()+");
        synchronized (this.r) {
            this.x = c.CUSTOM_DATA;
            this.A = null;
            this.z = false;
            this.r.a(fittingFaceData, bVar, aVar);
        }
        synchronized (this.v) {
            try {
                if (this.f1471a && this.x == c.CUSTOM_DATA) {
                    this.w = true;
                    this.v.wait(this.y * 4);
                }
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
        Log.i("FittingSurfaceView", "[c] SetCustomfaceGenerateAndAvatarData()- result: " + this.z + ", lock: " + this.w);
        this.r.d();
        if (!this.z) {
            Log.i("FittingSurfaceView", "Failed set custom face generate.");
        }
        if (this.A == null) {
            return this.z;
        }
        throw this.A;
    }

    public boolean UpdateCustomfaceTexture(float f2) throws Throwable {
        Log.i("FittingSurfaceView", "[c] UpdateCustomfaceTexture()+");
        synchronized (this.r) {
            this.x = c.CUSTOM_DATA;
            this.A = null;
            this.z = false;
            this.r.a((FittingFaceData) null, f2, true);
        }
        synchronized (this.v) {
            try {
                if (this.f1471a && this.x == c.CUSTOM_DATA) {
                    this.w = true;
                    this.v.wait(this.y);
                }
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
        Log.i("FittingSurfaceView", "[c] UpdateCustomfaceTexture()- result: " + this.z + ", lock: " + this.w);
        if (!this.z) {
            Log.i("FittingSurfaceView", "Failed update custom face texture.");
        }
        if (this.A == null) {
            return this.z;
        }
        throw this.A;
    }

    public Bitmap GetScreenShot(int i2, int i3, boolean z2, boolean z3, boolean z4) throws Throwable {
        Log.i("FittingSurfaceView", "[c] GetScreenShot()+");
        synchronized (this.r) {
            this.x = c.CAPTURE_DATA;
            this.A = null;
            this.z = false;
            this.r.a(i2, i3, z2, z3, z4);
        }
        synchronized (this.v) {
            try {
                if (this.f1471a && this.x == c.CAPTURE_DATA) {
                    this.w = true;
                    this.v.wait(this.y * 2);
                }
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
        Log.i("FittingSurfaceView", "[c] GetScreenShot()- result: " + this.z + ", lock: " + this.w);
        if (!this.z) {
            Log.i("FittingSurfaceView", "Failed get screen shot.");
        }
        if (this.A != null) {
            throw this.A;
        } else if (this.z) {
            return this.r.e();
        } else {
            return null;
        }
    }

    public void SetAnimationPause(boolean z2) {
        this.r.b(z2);
    }

    public boolean GetAnimationPause() {
        return this.r.f();
    }

    public void ResetCamera(h.e eVar) {
        this.r.a(eVar);
    }

    public h.e GetCurrentSceneMode() {
        return this.r.g();
    }

    public int GetCurrentModelCategory() {
        return this.r.h();
    }

    public void SetScaleZoom(float f2) {
        this.r.a(f2);
    }

    public float GetScaleZoom() {
        return this.r.j();
    }

    public void SetScaleTranslation(float f2) {
        this.r.b(f2);
    }

    public float GetScaleTranslation() {
        return this.r.k();
    }

    public static int[] GetFaceDetectPositions(FittingFaceData fittingFaceData, boolean z2, int i2, int i3, int i4, int i5) {
        int[] GetFaceFeatureDetect = CustomFaceInterface.GetFaceFeatureDetect(fittingFaceData, z2, i2, i3, i4, i5);
        if (GetFaceFeatureDetect != null) {
            return f.a(fittingFaceData, GetFaceFeatureDetect);
        }
        return null;
    }

    public static int[] GetFaceAreaDetectPositions(FittingFaceData fittingFaceData) {
        return CustomFaceInterface.GetFaceFeatureAreaDetect(fittingFaceData);
    }

    public void SetTouchAvailable(boolean z2, boolean z3, boolean z4) {
        this.g = z2;
        this.h = z3;
        this.i = z4;
    }

    public static float[] computeColorTemperature(float f2) {
        float f3;
        if (f2 > 0.5f) {
            f3 = KELVIN_RANGE[0] + (((KELVIN_RANGE[1] - KELVIN_RANGE[0]) * (1.0f - f2)) / 0.5f);
        } else {
            f3 = KELVIN_RANGE[1] + (((KELVIN_RANGE[2] - KELVIN_RANGE[1]) * (0.5f - f2)) / 0.5f);
        }
        float f4 = f3 / 100.0f;
        float[] fArr = {GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE};
        if (f4 <= 66.0f) {
            fArr[0] = 255.0f;
        } else {
            fArr[0] = f4 - 60.0f;
            fArr[0] = ((float) Math.pow((double) fArr[0], -0.133205d)) * 329.69873f;
            if (fArr[0] < GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
                fArr[0] = 0.0f;
            }
            if (fArr[0] > 255.0f) {
                fArr[0] = 255.0f;
            }
        }
        if (f4 <= 66.0f) {
            fArr[1] = f4;
            fArr[1] = (((float) Math.log((double) fArr[1])) * 99.4708f) - 161.11957f;
            if (fArr[1] < GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
                fArr[1] = 0.0f;
            }
            if (fArr[1] > 255.0f) {
                fArr[1] = 255.0f;
            }
        } else {
            fArr[1] = f4 - 60.0f;
            fArr[1] = ((float) Math.pow((double) fArr[1], -0.075515d)) * 288.12216f;
            if (fArr[1] < GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
                fArr[1] = 0.0f;
            }
            if (fArr[1] > 255.0f) {
                fArr[1] = 255.0f;
            }
        }
        if (f4 >= 66.0f) {
            fArr[2] = 255.0f;
        } else if (f4 <= 19.0f) {
            fArr[2] = 0.0f;
        } else {
            fArr[2] = f4 - 10.0f;
            fArr[2] = (((float) Math.log((double) fArr[2])) * 138.51773f) - 305.0448f;
            if (fArr[2] < GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
                fArr[2] = 0.0f;
            }
            if (fArr[2] > 255.0f) {
                fArr[2] = 255.0f;
            }
        }
        return fArr;
    }

    public static float colorTemperatureToNormalizeValue(float[] fArr) {
        float f2;
        if (fArr[0] < 255.0f) {
            f2 = ((float) Math.pow((double) (fArr[1] / 288.12216f), -13.242402171753957d)) + 60.0f;
        } else {
            f2 = (float) Math.exp((double) ((fArr[1] + 161.11957f) / 99.4708f));
        }
        float f3 = f2 * 100.0f;
        if (f3 > KELVIN_RANGE[1]) {
            return 0.5f - (((f3 - KELVIN_RANGE[1]) * 0.5f) / (KELVIN_RANGE[2] - KELVIN_RANGE[1]));
        }
        return 1.0f - (((f3 - KELVIN_RANGE[0]) * 0.5f) / (KELVIN_RANGE[1] - KELVIN_RANGE[0]));
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0029 A[SYNTHETIC, Splitter:B:17:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0034 A[SYNTHETIC, Splitter:B:23:0x0034] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean savePNG(android.graphics.Bitmap r3, java.lang.String r4) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r4)
            r4 = 0
            r1 = 0
            r0.createNewFile()     // Catch:{ Exception -> 0x0023 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x0023 }
            r2.<init>(r0)     // Catch:{ Exception -> 0x0023 }
            android.graphics.Bitmap$CompressFormat r0 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ Exception -> 0x001e, all -> 0x001b }
            r1 = 100
            r3.compress(r0, r1, r2)     // Catch:{ Exception -> 0x001e, all -> 0x001b }
            r4 = 1
            r2.close()     // Catch:{ IOException -> 0x002d }
            goto L_0x0031
        L_0x001b:
            r3 = move-exception
            r1 = r2
            goto L_0x0032
        L_0x001e:
            r3 = move-exception
            r1 = r2
            goto L_0x0024
        L_0x0021:
            r3 = move-exception
            goto L_0x0032
        L_0x0023:
            r3 = move-exception
        L_0x0024:
            r3.printStackTrace()     // Catch:{ all -> 0x0021 }
            if (r1 == 0) goto L_0x0031
            r1.close()     // Catch:{ IOException -> 0x002d }
            goto L_0x0031
        L_0x002d:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0031:
            return r4
        L_0x0032:
            if (r1 == 0) goto L_0x003c
            r1.close()     // Catch:{ IOException -> 0x0038 }
            goto L_0x003c
        L_0x0038:
            r4 = move-exception
            r4.printStackTrace()
        L_0x003c:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.fittingview.FittingSurfaceView.savePNG(android.graphics.Bitmap, java.lang.String):boolean");
    }

    public h.f GetSolverMode() {
        return this.r.l();
    }

    public void SetSolverMode(h.f fVar) {
        this.r.a(fVar);
    }

    public h.c GetClothRenderMode() {
        return this.r.m();
    }

    public void SetClothRenderMode(h.c cVar) {
        this.r.a(cVar);
    }

    public void SetClothSize(HashMap<h.d, Integer> hashMap) {
        if (hashMap != null && this.r.g() == h.e.CHECK_CLOTHES_SIZE) {
            for (h.d next : hashMap.keySet()) {
                if (next != h.d.NONE) {
                    this.r.a(hashMap.get(next).intValue(), next);
                }
            }
            this.r.o();
        }
    }

    public void StartClothSolver() {
        this.r.o();
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingview\qlSolver.java ==========

package net.fxgear.fittingview;

import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;
import net.fxgear.ClothesSizeProvider;
import net.fxgear.GlobalDefine;
import net.fxgear.b.d;
import net.fxgear.b.e;
import net.fxgear.b.f;
import net.fxgear.b.h;
import net.fxgear.b.k;

public class qlSolver {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final String f1512a = qlSolver.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private boolean f1513b = false;
    /* access modifiers changed from: private */
    public a c = null;
    /* access modifiers changed from: private */
    public k d = null;
    /* access modifiers changed from: private */
    public k e = null;
    /* access modifiers changed from: private */
    public k f = null;
    /* access modifiers changed from: private */
    public int g = 0;
    /* access modifiers changed from: private */
    public int h = 0;
    /* access modifiers changed from: private */
    public int i = 0;
    /* access modifiers changed from: private */
    public h.f j = h.f.SIZE_SIMULATION;
    private h.c k = h.c.Color;
    private b l = null;

    public static native short[] getEdgeIds(short[] sArr);

    /* access modifiers changed from: private */
    public static native void getGarmentPressure(float[] fArr);

    /* access modifiers changed from: private */
    public static native void getGarmentStrain(float[] fArr);

    /* access modifiers changed from: private */
    public static native void getResult(float[] fArr);

    private static native void initCollisionObjects(float[] fArr, short[] sArr, short[] sArr2);

    private static native boolean initSolver_Multilayer(int i2, float[] fArr, float[] fArr2, short[] sArr, short[] sArr2, float[] fArr3, float f2, float f3, float[] fArr4, float[] fArr5, short[] sArr3, short[] sArr4, float[] fArr6, float f4, float f5, float[] fArr7, float[] fArr8, short[] sArr5, short[] sArr6, float[] fArr9, float f6, float f7);

    /* access modifiers changed from: private */
    public static native double onStep();

    private class b extends Thread {

        /* renamed from: b  reason: collision with root package name */
        private int f1517b;
        private double c;

        private b() {
            this.f1517b = 40;
            this.c = 1.0d;
        }

        public void run() {
            int i;
            long nanoTime = System.nanoTime();
            int a2 = qlSolver.this.g + qlSolver.this.h + qlSolver.this.i;
            float[] fArr = new float[a2];
            int i2 = a2 / 3;
            float[] fArr2 = new float[i2];
            float[] fArr3 = new float[i2];
            if (qlSolver.this.j == h.f.COLLISION_RESOLUTION) {
                this.f1517b = 40;
                this.c = 1.0d;
                i = 0;
            } else {
                this.f1517b = 100;
                this.c = 0.05d;
                i = 30;
            }
            int i3 = 0;
            while (i3 < this.f1517b && !isInterrupted()) {
                double e = qlSolver.onStep();
                if (!isInterrupted()) {
                    qlSolver.getResult(fArr);
                    if (qlSolver.this.j == h.f.SIZE_SIMULATION) {
                        qlSolver.getGarmentStrain(fArr2);
                        qlSolver.getGarmentPressure(fArr3);
                    }
                    if (isInterrupted()) {
                        break;
                    }
                    if (qlSolver.this.d != null) {
                        qlSolver.this.d.k(qlSolver.this.d.h(Arrays.copyOfRange(fArr, 0, qlSolver.this.g)));
                        if (qlSolver.this.j == h.f.SIZE_SIMULATION) {
                            qlSolver.this.d.l(qlSolver.this.d.i(Arrays.copyOfRange(fArr2, 0, qlSolver.this.g / 3)));
                            qlSolver.this.d.m(qlSolver.this.d.i(Arrays.copyOfRange(fArr3, 0, qlSolver.this.g / 3)));
                        }
                    }
                    if (isInterrupted()) {
                        break;
                    }
                    if (qlSolver.this.e != null) {
                        qlSolver.this.e.k(qlSolver.this.e.h(Arrays.copyOfRange(fArr, qlSolver.this.g, qlSolver.this.g + qlSolver.this.h)));
                        if (qlSolver.this.j == h.f.SIZE_SIMULATION) {
                            qlSolver.this.e.l(qlSolver.this.e.i(Arrays.copyOfRange(fArr2, qlSolver.this.g / 3, (qlSolver.this.g + qlSolver.this.h) / 3)));
                            qlSolver.this.e.m(qlSolver.this.e.i(Arrays.copyOfRange(fArr3, qlSolver.this.g / 3, (qlSolver.this.g + qlSolver.this.h) / 3)));
                        }
                    }
                    if (isInterrupted()) {
                        break;
                    }
                    if (qlSolver.this.f != null) {
                        qlSolver.this.f.k(qlSolver.this.f.h(Arrays.copyOfRange(fArr, qlSolver.this.g + qlSolver.this.h, qlSolver.this.g + qlSolver.this.h + qlSolver.this.i)));
                        if (qlSolver.this.j == h.f.SIZE_SIMULATION) {
                            qlSolver.this.f.l(qlSolver.this.f.i(Arrays.copyOfRange(fArr2, (qlSolver.this.g + qlSolver.this.h) / 3, ((qlSolver.this.g + qlSolver.this.h) + qlSolver.this.i) / 3)));
                            qlSolver.this.f.m(qlSolver.this.f.i(Arrays.copyOfRange(fArr3, (qlSolver.this.g + qlSolver.this.h) / 3, ((qlSolver.this.g + qlSolver.this.h) + qlSolver.this.i) / 3)));
                        }
                    }
                    if (!isInterrupted()) {
                        qlSolver.this.c.c(true);
                        if (i3 > i && e < this.c) {
                            break;
                        }
                        i3++;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            String i4 = qlSolver.this.f1512a;
            Log.d(i4, "Total elapsed time for " + (i3 + 1) + " frames : " + (((float) (System.nanoTime() - nanoTime)) * 1.0E-9f));
        }
    }

    public qlSolver(a aVar) {
        this.c = aVar;
    }

    private class a {

        /* renamed from: a  reason: collision with root package name */
        float[] f1514a;

        /* renamed from: b  reason: collision with root package name */
        float[] f1515b;
        short[] c;
        short[] d;
        float[] e;

        private a() {
            this.f1514a = null;
            this.f1515b = null;
            this.c = null;
            this.d = null;
            this.e = null;
        }
    }

    public boolean a(k kVar, k kVar2, k kVar3, k kVar4, k kVar5) {
        float f2;
        float f3;
        float f4;
        qlSolver qlsolver = this;
        k kVar6 = kVar2;
        k kVar7 = kVar3;
        k kVar8 = kVar4;
        k kVar9 = kVar5;
        qlsolver.f1513b = false;
        b();
        if (kVar == null) {
            return false;
        }
        if (kVar6 == null && kVar7 == null && kVar8 == null && kVar9 == null) {
            return false;
        }
        long nanoTime = System.nanoTime();
        float[] ak = kVar.ak();
        a a2 = a(kVar2, true, false, (float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, ak);
        a a3 = a(kVar3, true, (kVar7 == null || kVar9 == null) ? false : true, 0.4f, ak);
        long j2 = nanoTime;
        a a4 = a(kVar5, true, false, (float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, ak);
        a a5 = a(kVar4, true, (kVar8 == null || kVar9 == null) ? false : true, 0.5f, ak);
        if (qlsolver.j == h.f.SIZE_SIMULATION) {
            f4 = 0.5f;
            f3 = 0.5f;
            f2 = 0.5f;
        } else {
            f4 = 1.0f;
            f3 = 1.0f;
            f2 = 1.0f;
        }
        if (kVar8 == null) {
            qlsolver.d = kVar6;
            qlsolver.e = kVar7;
            qlsolver.f = kVar9;
            a aVar = a3;
            a aVar2 = a2;
            if (!initSolver_Multilayer(qlsolver.j == h.f.COLLISION_RESOLUTION ? 0 : 1, a2.f1514a, a2.f1515b, a2.c, a2.d, a2.e, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, f4, a3.f1514a, a3.f1515b, a3.c, a3.d, a3.e, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, f3, a4.f1514a, a4.f1515b, a4.c, a4.d, a4.e, (kVar7 == null && kVar6 == null) ? GlobalDefine.DEFAULT_AUTO_FILTER_VALUE : 2.0f, 1.0f)) {
                return false;
            }
            qlsolver = this;
            qlsolver.g = qlsolver.d != null ? aVar2.f1514a.length : 0;
            qlsolver.h = qlsolver.e != null ? aVar.f1514a.length : 0;
            qlsolver.i = qlsolver.f != null ? a4.f1514a.length : 0;
        } else {
            a aVar3 = a3;
            qlsolver.d = kVar7;
            qlsolver.e = kVar8;
            qlsolver.f = kVar9;
            if (!initSolver_Multilayer(qlsolver.j == h.f.COLLISION_RESOLUTION ? 0 : 1, aVar3.f1514a, aVar3.f1515b, aVar3.c, aVar3.d, aVar3.e, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, f3, a5.f1514a, a5.f1515b, a5.c, a5.d, a5.e, kVar7 != null ? 1.5f : GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, f2, a4.f1514a, a4.f1515b, a4.c, a4.d, a4.e, 3.0f, 1.0f)) {
                return false;
            }
            qlsolver.g = qlsolver.d != null ? aVar3.f1514a.length : 0;
            qlsolver.h = qlsolver.e != null ? a5.f1514a.length : 0;
            qlsolver.i = qlsolver.f != null ? a4.f1514a.length : 0;
        }
        a a6 = a(kVar, false, false, (float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, (float[]) null);
        initCollisionObjects(a6.f1514a, a6.c, a6.d);
        qlsolver.f1513b = true;
        float[] fArr = new float[(qlsolver.g + qlsolver.h + qlsolver.i)];
        getResult(fArr);
        if (qlsolver.d != null) {
            qlsolver.d.k(qlsolver.d.h(Arrays.copyOfRange(fArr, 0, qlsolver.g)));
        }
        if (qlsolver.e != null) {
            qlsolver.e.k(qlsolver.e.h(Arrays.copyOfRange(fArr, qlsolver.g, qlsolver.g + qlsolver.h)));
        }
        if (qlsolver.f != null) {
            qlsolver.f.k(qlsolver.f.h(Arrays.copyOfRange(fArr, qlsolver.g + qlsolver.h, qlsolver.g + qlsolver.h + qlsolver.i)));
        }
        qlsolver.c.c(true);
        String str = qlsolver.f1512a;
        StringBuilder sb = new StringBuilder();
        sb.append("elapsed time for qlSolver::initSolver : ");
        double nanoTime2 = (double) (System.nanoTime() - j2);
        Double.isNaN(nanoTime2);
        sb.append(nanoTime2 * 1.0E-9d);
        Log.d(str, sb.toString());
        return qlsolver.f1513b;
    }

    private a a(k kVar, boolean z, boolean z2, float f2, float[] fArr) {
        k kVar2 = kVar;
        a aVar = new a();
        if (kVar2 == null) {
            return aVar;
        }
        e Y = kVar.Y();
        d j2 = Y.j();
        float[] ag = kVar.ag();
        int[] x = j2.x();
        if (!z || this.j != h.f.SIZE_SIMULATION) {
            aVar.f1514a = new float[j2.p().length];
            for (int i2 = 0; i2 < x.length; i2++) {
                int i3 = i2 * 3;
                aVar.f1514a[x[i2] * 3] = ag[i3];
                aVar.f1514a[(x[i2] * 3) + 1] = ag[i3 + 1];
                aVar.f1514a[(x[i2] * 3) + 2] = ag[i3 + 2];
            }
        } else {
            aVar.f1514a = (float[]) Y.a(ClothesSizeProvider.GetClothesWeigthArray(this.c.n(), kVar.aj()), Y.q()).clone();
            kVar.g(aVar.f1514a);
        }
        aVar.f1515b = null;
        if (z && this.j == h.f.SIZE_SIMULATION) {
            aVar.f1515b = new float[j2.p().length];
            for (int i4 = 0; i4 < x.length; i4++) {
                int i5 = i4 * 3;
                aVar.f1515b[x[i4] * 3] = ag[i5];
                aVar.f1515b[(x[i4] * 3) + 1] = ag[i5 + 1];
                aVar.f1515b[(x[i4] * 3) + 2] = ag[i5 + 2];
            }
        }
        if (z2) {
            ArrayList<f> o = Y.o();
            if (o.size() == 27) {
                float f3 = Pattern.compile("WomCloTop120").matcher(Y.k()).find() ? 1.0f : f2;
                aVar.f1515b = a(aVar.f1515b == null ? aVar.f1514a : aVar.f1515b, Y.a(fArr, o.get(26).c()), f3);
            }
        }
        aVar.c = j2.h();
        aVar.d = j2.j();
        if (z) {
            aVar.e = kVar.ae();
        }
        return aVar;
    }

    private float[] a(float[] fArr, float[] fArr2, float f2) {
        if (fArr.length != fArr2.length) {
            String str = this.f1512a;
            Log.e(str, "BlendVertices received different num vertices " + fArr.length + ", " + fArr2.length);
            return null;
        }
        float[] fArr3 = new float[fArr.length];
        for (int i2 = 0; i2 < fArr.length; i2++) {
            fArr3[i2] = ((1.0f - f2) * fArr[i2]) + (fArr2[i2] * f2);
        }
        return fArr3;
    }

    public void a() {
        if (this.f1513b) {
            this.l = new b();
            this.l.start();
        }
    }

    public void b() {
        if (this.l != null) {
            System.nanoTime();
            if (this.l.isAlive()) {
                this.l.interrupt();
                try {
                    this.l.join();
                } catch (InterruptedException unused) {
                }
            }
            System.nanoTime();
        }
    }

    public h.f c() {
        return this.j;
    }

    public void a(h.f fVar) {
        b();
        this.j = fVar;
    }

    public h.c d() {
        return this.k;
    }

    public void a(h.c cVar) {
        this.k = cVar;
    }

    static {
        System.loadLibrary("qlSolver");
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingview\data\a.java ==========

package net.fxgear.fittingview.data;

import java.util.ArrayList;

/* compiled from: FittingAnimationData */
public class a {

    /* renamed from: a  reason: collision with root package name */
    protected String f1492a;

    /* renamed from: b  reason: collision with root package name */
    protected String f1493b;
    protected ArrayList<String> c;
    protected int d;
    private final String e = "FittingAnimationData";

    public void a(String str) {
        this.f1492a = str;
    }

    public void b(String str) {
        this.f1493b = str;
    }

    public void c(String str) {
        if (this.c == null) {
            this.c = new ArrayList<>();
        }
        this.c.add(str);
    }

    public String a() {
        return this.f1492a;
    }

    public String b() {
        return this.f1493b;
    }

    public ArrayList<String> c() {
        return this.c;
    }

    public void a(int i) {
        this.d = i;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingview\data\b.java ==========

package net.fxgear.fittingview.data;

import android.util.Log;
import net.fxgear.GlobalDefine;
import net.fxgear.fittingview.FittingSurfaceView;
import net.fxgear.util.FXUtil;

/* compiled from: FittingAvatarData */
public class b {

    /* renamed from: a  reason: collision with root package name */
    protected int f1494a;

    /* renamed from: b  reason: collision with root package name */
    protected c f1495b;
    protected f c;
    protected e d;
    protected FittingFaceData e;
    protected float f;
    protected float g;
    protected float h;
    protected int i;
    private final String j = "FittingAvatarData";

    public b() {
        Log.i("FittingAvatarData", "FittingAvatarData()");
        this.g = FittingSurfaceView.colorTemperatureToNormalizeValue(new float[]{(float) FXUtil.redFromColor(-1), (float) FXUtil.greenFromColor(-1), (float) FXUtil.blueFromColor(-1)});
        this.f = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        this.h = 20.0f;
    }

    public void a(c cVar) {
        this.f1495b = cVar;
    }

    public void a(f fVar) {
        this.c = fVar;
    }

    public void a(e eVar) {
        this.d = eVar;
    }

    public void a(FittingFaceData fittingFaceData) {
        this.e = fittingFaceData;
    }

    public c a() {
        return this.f1495b;
    }

    public f b() {
        return this.c;
    }

    public e c() {
        return this.d;
    }

    public FittingFaceData d() {
        return this.e;
    }

    public void a(int i2) {
        this.f1494a = i2;
    }

    public int e() {
        return this.f1494a;
    }

    public void a(float f2) {
        this.f = f2;
    }

    public float f() {
        return this.f;
    }

    public void b(float f2) {
        this.g = f2;
    }

    public float g() {
        return this.g;
    }

    public void c(float f2) {
        this.h = f2;
    }

    public float h() {
        return this.h;
    }

    public void b(int i2) {
        this.i = i2;
    }

    public int i() {
        return this.i;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingview\data\c.java ==========

package net.fxgear.fittingview.data;

import java.util.ArrayList;

/* compiled from: FittingBodyData */
public class c {

    /* renamed from: a  reason: collision with root package name */
    protected String f1496a;

    /* renamed from: b  reason: collision with root package name */
    protected String f1497b;
    protected ArrayList<String> c;
    protected ArrayList<String> d;
    protected ArrayList<String> e;
    protected int f;
    private final String g = "FittingBodyData";

    public void a(String str) {
        this.f1496a = str;
    }

    public void a(ArrayList<String> arrayList) {
        this.c = arrayList;
    }

    public void b(String str) {
        this.f1497b = str;
    }

    public void c(String str) {
        if (this.d == null) {
            this.d = new ArrayList<>();
        }
        this.d.add(str);
    }

    public void a(int i, String str) {
        if (this.e == null) {
            this.e = new ArrayList<>();
        }
        this.e.add(i, str);
    }

    public String a() {
        return this.f1496a;
    }

    public ArrayList<String> b() {
        return this.c;
    }

    public String c() {
        return this.f1497b;
    }

    public ArrayList<String> d() {
        return this.d;
    }

    public ArrayList<String> e() {
        return this.e;
    }

    public void a(int i) {
        this.f = i;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingview\data\d.java ==========

package net.fxgear.fittingview.data;

import android.util.Log;
import java.util.ArrayList;
import net.fxgear.GlobalDefine;

/* compiled from: FittingClothData */
public class d {

    /* renamed from: a  reason: collision with root package name */
    protected int f1498a;

    /* renamed from: b  reason: collision with root package name */
    protected int f1499b;
    protected int c;
    protected String d;
    protected ArrayList<String> e;
    protected ArrayList<String> f;
    protected String g;
    protected String h;
    protected String i;
    protected String j;
    protected int k;
    protected int l;
    protected GlobalDefine.CLOTHES_CATEGORY_TYPE m = GlobalDefine.CLOTHES_CATEGORY_TYPE.Default;
    private final String n = "FittingClothData";

    public d() {
        Log.i("FittingClothData", "FittingClothData()+");
    }

    public void a(String str) {
        this.d = str;
    }

    public String a() {
        return this.d;
    }

    public void a(int i2) {
        this.f1499b = i2;
    }

    public void b(int i2) {
        this.f1498a = i2;
    }

    public void c(int i2) {
        this.c = i2;
    }

    public void b(String str) {
        this.h = str;
    }

    public void c(String str) {
        this.g = str;
    }

    public void d(String str) {
        if (this.f == null) {
            this.f = new ArrayList<>();
        }
        this.f.add(str);
    }

    public void e(String str) {
        this.i = str;
    }

    public void f(String str) {
        this.j = str;
    }

    public int b() {
        return this.f1499b;
    }

    public int c() {
        return this.f1498a;
    }

    public int d() {
        return this.c;
    }

    public String e() {
        return this.h;
    }

    public String f() {
        return this.g;
    }

    public ArrayList<String> g() {
        return this.f;
    }

    public String h() {
        return this.i;
    }

    public String i() {
        return this.j;
    }

    public void d(int i2) {
        this.k = i2;
    }

    public int j() {
        return this.k;
    }

    public void a(GlobalDefine.CLOTHES_CATEGORY_TYPE clothes_category_type) {
        this.m = clothes_category_type;
    }

    public GlobalDefine.CLOTHES_CATEGORY_TYPE k() {
        return this.m;
    }

    public void g(String str) {
        if (this.e == null) {
            this.e = new ArrayList<>();
        }
        this.e.add(str);
    }

    public ArrayList<String> l() {
        return this.e;
    }

    public void e(int i2) {
        this.l = i2;
    }

    public int m() {
        return this.l;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingview\data\e.java ==========

package net.fxgear.fittingview.data;

import java.util.ArrayList;

/* compiled from: FittingHairData */
public class e {

    /* renamed from: a  reason: collision with root package name */
    protected int f1500a;

    /* renamed from: b  reason: collision with root package name */
    protected b f1501b;
    protected a c;
    protected String d;
    protected ArrayList<String> e;
    protected String f;
    protected String g;
    protected int h;
    private final String i = "FittingHairData";

    public void a(String str) {
        this.d = str;
    }

    public void b(String str) {
        this.f = str;
    }

    public void c(String str) {
        this.g = str;
    }

    public void d(String str) {
        if (this.e == null) {
            this.e = new ArrayList<>();
        }
        this.e.add(str);
    }

    public String a() {
        return this.d;
    }

    public String b() {
        return this.f;
    }

    public String c() {
        return this.g;
    }

    public ArrayList<String> d() {
        return this.e;
    }

    public void a(int i2) {
        this.f1500a = i2;
    }

    public void b(int i2) {
        this.h = i2;
    }

    public void a(b bVar) {
        this.f1501b = bVar;
    }

    public b e() {
        return this.f1501b;
    }

    public void a(a aVar) {
        this.c = aVar;
    }

    public a f() {
        return this.c;
    }

    /* compiled from: FittingHairData */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public float f1504a;

        /* renamed from: b  reason: collision with root package name */
        public float f1505b;
        public float c;
        public float d;
        public float e = 0.7f;
        public float[] f;
        public float[] g;
        public float[] h;

        public void a(float f2) {
            this.f1504a = f2;
        }

        public void b(float f2) {
            this.f1505b = f2;
        }

        public void c(float f2) {
            this.c = f2;
        }

        public void d(float f2) {
            this.d = f2;
        }

        public void e(float f2) {
            this.e = f2;
        }

        public void a(float[] fArr) {
            if (fArr != null && fArr.length == 3) {
                if (this.f == null) {
                    this.f = new float[3];
                }
                this.f[0] = fArr[0];
                this.f[1] = fArr[1];
                this.f[2] = fArr[2];
            }
        }

        public void b(float[] fArr) {
            if (fArr != null && fArr.length == 3) {
                if (this.g == null) {
                    this.g = new float[3];
                }
                this.g[0] = fArr[0];
                this.g[1] = fArr[1];
                this.g[2] = fArr[2];
            }
        }

        public void c(float[] fArr) {
            if (fArr != null && fArr.length == 3) {
                if (this.h == null) {
                    this.h = new float[3];
                }
                this.h[0] = fArr[0];
                this.h[1] = fArr[1];
                this.h[2] = fArr[2];
            }
        }
    }

    /* compiled from: FittingHairData */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f1502a;

        /* renamed from: b  reason: collision with root package name */
        public b f1503b;
        public String c;

        public void a(int i) {
            this.f1502a = i;
        }

        public void a(b bVar) {
            this.f1503b = bVar;
        }

        public void a(String str) {
            this.c = str;
        }

        public b a() {
            return this.f1503b;
        }

        public String b() {
            return this.c;
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingview\data\f.java ==========

package net.fxgear.fittingview.data;

import android.util.Log;

/* compiled from: FittingHeadData */
public class f {

    /* renamed from: a  reason: collision with root package name */
    protected String f1506a;

    /* renamed from: b  reason: collision with root package name */
    protected String f1507b;
    protected boolean c = false;
    protected boolean d = false;
    protected int e;
    private final String f = "FittingHeadData";

    public f() {
        Log.i("FittingHeadData", "FittingHeadData()+");
    }

    public void a(String str) {
        this.f1506a = str;
    }

    public void b(String str) {
        this.f1507b = str;
    }

    public String a() {
        return this.f1506a;
    }

    public String b() {
        return this.f1507b;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public boolean c() {
        return this.d;
    }

    public void a(int i) {
        this.e = i;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingview\data\FittingFaceData.java ==========

package net.fxgear.fittingview.data;

import android.util.Log;
import java.io.File;
import net.fxgear.GlobalDefine;

public class FittingFaceData {
    private static String A = "eyeR.xml";
    private static String B = "mouth.xml";
    private static String C = "nose.xml";
    public static final int COUNT_CUSTOM_FACE_OUTPUT = 7;
    public static final String CUSTOMFACE_DETECT_CROP_FACE_FILE = "Custom_Detect_Crop_Face.png";
    public static final String CUSTOMFACE_DETECT_ORI_IMAGE_FILE = "Custom_Detect_Ori_Image.bmp";
    public static final String CUSTOMFACE_DETECT_POSITION_FILE = "Custom_Detect_Position.bin";
    public static final String CUSTOMFACE_MESH_TYPE_1_FILE = "Mesh_Type_1_Custom.bin";
    public static final String CUSTOMFACE_MESH_TYPE_2_FILE = "Mesh_Type_2_Custom.bin";
    public static final String CUSTOMFACE_MESH_TYPE_3_FILE = "Mesh_Type_3_Custom.bin";
    public static final String CUSTOMFACE_TEXTURE_TYPE_FILE = "Texture_Type_Custom.png";
    private static String D = "pos1.bin";
    private static String E = "pos2.bin";
    private static String F = "pos3.bin";
    public static final String FILE_EXTENSION_DOT = ".";
    public static final String FILE_NAME_UNDER_BAR = "_";
    private static String G = "pos4.bin";
    private static String H = "pos5.bin";
    public static final int INDEX_CUSTOM_DETECT_CROP_FACE_FILE = 2;
    public static final int INDEX_CUSTOM_DETECT_ORI_IMAGE_FILE = 1;
    public static final int INDEX_CUSTOM_DETECT_POSITION_FILE = 0;
    public static final int INDEX_MESH_TYPE_1_CUSTOM_FILE = 4;
    public static final int INDEX_MESH_TYPE_2_CUSTOM_FILE = 5;
    public static final int INDEX_MESH_TYPE_3_CUSTOM_FILE = 6;
    public static final int INDEX_TEXTURE_TYPE_CUSTOM_FILE = 3;
    private static String c = "/sdcard/face3.0/Avatar/";
    private static String d = "Man/Head/Face/";
    private static String e = "Woman/Head/Face/";
    private static String f = "Common/";
    private static String g = "Head/Face/";
    private static String h = ("Kids/" + g);
    private static String i = ("Adult/" + g);
    private static String j = "Type1/";
    private static String k = "Type2/";
    private static String l = "Type3/";
    private static String m = "Type4/";
    private static String n = "Type5/";
    private static String o = "face.gun";
    private static String p = "base.gun";
    private static String q = "lips.gun";
    private static String r = "eyeL.gun";
    private static String s = "eyeR.gun";
    private static String t = "BaseFace.png";
    private static String u = "BaseFace.jpg";
    private static String v = "FaceMask.png";
    private static String w = "JawMask.png";
    private static String x = "SharpMask.png";
    private static String y = "base.bin";
    private static String z = "eyeL.xml";
    private a I = a.FEMALE;
    private int J = 1;
    private int K = 3;
    private String L = null;
    private int[] M;
    private String N = null;
    private String O = null;
    private String P = null;
    private String Q = null;
    private String R = null;
    private String S = null;
    private String T = null;
    private String U = null;
    private String V = null;
    private String W = null;
    private String X = null;
    private String Y = null;
    private String Z = null;

    /* renamed from: a  reason: collision with root package name */
    protected int f1488a;

    /* renamed from: b  reason: collision with root package name */
    protected int f1489b;

    public enum a {
        MALE,
        FEMALE
    }

    public FittingFaceData() {
        Log.i("FittingFaceData", "FittingFaceData()");
    }

    public FittingFaceData(int i2, String str, int[] iArr, a aVar, int i3, String str2, String str3, String str4, int i4) {
        Log.i("FittingFaceData", "FittingFaceData(values, totalTypeNum) " + str3);
        this.f1488a = i2;
        this.L = str;
        this.M = iArr;
        this.I = aVar;
        this.f1489b = i3;
        this.N = str2;
        this.O = str3;
        this.P = this.O + g;
        this.Q = this.O + h;
        this.R = this.O + i;
        this.S = str4;
        this.K = i4;
    }

    public FittingFaceData(int i2, String str, int[] iArr, a aVar, int i3, String str2, String str3, String str4) {
        Log.i("FittingFaceData", "FittingFaceData(values) " + str3);
        this.f1488a = i2;
        this.L = str;
        this.M = iArr;
        this.I = aVar;
        this.f1489b = i3;
        this.N = str2;
        this.O = str3;
        this.P = this.O + g;
        this.Q = this.O + h;
        this.R = this.O + i;
        this.S = str4;
    }

    public void ClearData() {
        Log.i("FittingFaceData", "ClearData()");
        this.L = null;
        this.M = null;
        this.N = null;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = null;
    }

    public void SetCustomBitmapFilePath(String str) {
        this.L = str;
    }

    public String GetCustomBitmapFilePath() {
        return this.L;
    }

    public void SetCustomDetectPosition(int[] iArr) {
        this.M = iArr;
    }

    public int[] GetCustomDetectPosition() {
        return this.M;
    }

    public void SetFaceGender(a aVar) {
        this.I = aVar;
    }

    public a GetFaceGender() {
        return this.I;
    }

    public void SetFaceType(int i2) {
        this.J = i2;
    }

    public int GetFaceType() {
        return this.J;
    }

    public int GetTotalTypeNum() {
        return this.K;
    }

    public String GetFaceTypePath() {
        if (this.J == 1) {
            return j;
        }
        return this.J == 2 ? k : l;
    }

    public void SetFaceBasePath(String str) {
        this.N = str;
    }

    public String GetFaceBaseGenderPath() {
        if (this.N != null) {
            return this.N;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        sb.append(this.I == a.MALE ? d : e);
        return sb.toString();
    }

    public void SetCommonPath(String str) {
        Log.e("FittingFaceData", "[c] SetFaceCommonPath: " + str);
        this.O = str;
        this.P = this.O + g;
        this.Q = this.O + h;
        this.R = this.O + i;
    }

    public String GetCommonPath() {
        Log.e("FittingFaceData", "[c] GetCommonPath: " + this.O);
        if (this.O != null) {
            return this.O;
        }
        return c + f;
    }

    public void SetFaceSavePath(String str) {
        this.S = str;
    }

    public String GetFaceSavePath() {
        if (this.S != null) {
            return this.S;
        }
        return new File(GetFaceBaseGenderPath()).getParent() + File.separator;
    }

    public String GetFaceBaseGenderTypePath() {
        StringBuilder sb;
        String GetFaceBaseGenderPath;
        if (a()) {
            sb = new StringBuilder();
            GetFaceBaseGenderPath = this.Q;
        } else {
            sb = new StringBuilder();
            GetFaceBaseGenderPath = GetFaceBaseGenderPath();
        }
        sb.append(GetFaceBaseGenderPath);
        sb.append(GetFaceTypePath());
        return sb.toString();
    }

    public String GetCommonFaceDB() {
        return this.P + o;
    }

    public String GetCommonBaseDB() {
        return this.P + p;
    }

    public String GetCommonLipsDB() {
        return this.P + q;
    }

    public String GetCommonEyeLDB() {
        return this.P + r;
    }

    public String GetCommonEyeRDB() {
        return this.P + s;
    }

    public String GetFaceBase_BaseFaceJpg() {
        return this.N + u;
    }

    public String GetFaceBase_FaceMaskPng() {
        StringBuilder sb;
        String str;
        if (a()) {
            sb = new StringBuilder();
            str = this.Q;
        } else {
            sb = new StringBuilder();
            str = this.N;
        }
        sb.append(str);
        sb.append(v);
        return sb.toString();
    }

    public String GetFaceBase_JawMaskPng() {
        StringBuilder sb;
        String str;
        if (a()) {
            sb = new StringBuilder();
            str = this.Q;
        } else {
            sb = new StringBuilder();
            str = this.N;
        }
        sb.append(str);
        sb.append(w);
        return sb.toString();
    }

    public String GetFaceBase_SharpMaskPng() {
        StringBuilder sb;
        String str;
        if (a()) {
            sb = new StringBuilder();
            str = this.Q;
        } else {
            sb = new StringBuilder();
            str = this.N;
        }
        sb.append(str);
        sb.append(x);
        return sb.toString();
    }

    public String GetFaceBaseGenderBaseBin() {
        StringBuilder sb;
        String GetFaceBaseGenderPath;
        if (a()) {
            sb = new StringBuilder();
            GetFaceBaseGenderPath = this.Q;
        } else {
            sb = new StringBuilder();
            GetFaceBaseGenderPath = GetFaceBaseGenderPath();
        }
        sb.append(GetFaceBaseGenderPath);
        sb.append(y);
        return sb.toString();
    }

    public String GetFaceBaseGenderTypePos1() {
        return GetFaceBaseGenderTypePath() + D;
    }

    public String GetFaceBaseGenderTypePos2() {
        return GetFaceBaseGenderTypePath() + E;
    }

    public String GetFaceBaseGenderTypePos3() {
        return GetFaceBaseGenderTypePath() + F;
    }

    public String GetFaceBaseGenderTypePos4() {
        return GetFaceBaseGenderTypePath() + G;
    }

    public String GetFaceBaseGenderTypePos5() {
        return GetFaceBaseGenderTypePath() + H;
    }

    public String GetFaceBaseGenderEyeL() {
        StringBuilder sb;
        String GetFaceBaseGenderPath;
        if (a()) {
            sb = new StringBuilder();
            GetFaceBaseGenderPath = this.Q;
        } else {
            sb = new StringBuilder();
            GetFaceBaseGenderPath = GetFaceBaseGenderPath();
        }
        sb.append(GetFaceBaseGenderPath);
        sb.append(z);
        return sb.toString();
    }

    public String GetFaceBaseGenderEyeR() {
        StringBuilder sb;
        String GetFaceBaseGenderPath;
        if (a()) {
            sb = new StringBuilder();
            GetFaceBaseGenderPath = this.Q;
        } else {
            sb = new StringBuilder();
            GetFaceBaseGenderPath = GetFaceBaseGenderPath();
        }
        sb.append(GetFaceBaseGenderPath);
        sb.append(A);
        return sb.toString();
    }

    public String GetFaceBaseGenderMouth() {
        StringBuilder sb;
        String GetFaceBaseGenderPath;
        if (a()) {
            sb = new StringBuilder();
            GetFaceBaseGenderPath = this.Q;
        } else {
            sb = new StringBuilder();
            GetFaceBaseGenderPath = GetFaceBaseGenderPath();
        }
        sb.append(GetFaceBaseGenderPath);
        sb.append(B);
        return sb.toString();
    }

    public String GetFaceBaseGenderNose() {
        StringBuilder sb;
        String GetFaceBaseGenderPath;
        if (a()) {
            sb = new StringBuilder();
            GetFaceBaseGenderPath = this.Q;
        } else {
            sb = new StringBuilder();
            GetFaceBaseGenderPath = GetFaceBaseGenderPath();
        }
        sb.append(GetFaceBaseGenderPath);
        sb.append(C);
        return sb.toString();
    }

    public void SetFittingFaceDataId(int i2) {
        Log.i("FittingFaceData", "SetFittingFaceDataId(), id = " + i2);
        this.f1488a = i2;
    }

    public int GetFittingFaceDataId() {
        Log.i("FittingFaceData", "SetFittingFaceDataId(), id = " + this.f1488a);
        return this.f1488a;
    }

    public void SetCustomFaceDetectPositionFile(String str) {
        this.T = str;
    }

    public String GetCustomFaceDetectPositionFile() {
        if (this.T != null) {
            return this.T;
        }
        return GetFaceSavePath() + "Custom_Detect_Position.bin";
    }

    public void SetCustomFaceDetectOriImageFile(String str) {
        this.U = str;
    }

    public String GetCustomFaceDetectOriImageFile() {
        if (this.U != null) {
            return this.U;
        }
        return GetFaceSavePath() + CUSTOMFACE_DETECT_ORI_IMAGE_FILE;
    }

    public void SetCustomFaceDetectCropFaceFile(String str) {
        this.V = str;
    }

    public String GetCustomFaceDetectCropFaceFile() {
        if (this.V != null) {
            return this.V;
        }
        return GetFaceSavePath() + "Custom_Detect_Crop_Face.png";
    }

    public void SetCustomFaceTextureTypeFile(String str) {
        this.W = str;
    }

    public String GetCustomFaceTextureTypeFile() {
        if (this.W != null) {
            return this.W;
        }
        return GetFaceSavePath() + "Texture_Type_Custom.png";
    }

    public void SetCustomFaceMeshType1File(String str) {
        this.X = str;
    }

    public String GetCustomFaceMeshType1File() {
        if (this.X != null) {
            return this.X;
        }
        return GetFaceSavePath() + CUSTOMFACE_MESH_TYPE_1_FILE;
    }

    public void SetCustomFaceMeshType2File(String str) {
        this.Y = str;
    }

    public String GetCustomFaceMeshType2File() {
        if (this.Y != null) {
            return this.Y;
        }
        return GetFaceSavePath() + CUSTOMFACE_MESH_TYPE_2_FILE;
    }

    public void SetCustomFaceMeshType3File(String str) {
        this.Z = str;
    }

    public String GetCustomFaceMeshType3File() {
        if (this.Z != null) {
            return this.Z;
        }
        return GetFaceSavePath() + CUSTOMFACE_MESH_TYPE_3_FILE;
    }

    public static String[] GetCustomFaceFile(String str) {
        File[] listFiles = new File(str).listFiles();
        String[] strArr = null;
        for (int i2 = 0; i2 < listFiles.length; i2++) {
            if (listFiles[i2].isFile() && listFiles[i2].getName().contains("Custom")) {
                if (strArr == null) {
                    strArr = new String[7];
                }
                String absolutePath = listFiles[i2].getAbsolutePath();
                if (absolutePath.contains("Custom_Detect_Position")) {
                    strArr[0] = absolutePath;
                } else if (absolutePath.contains("Custom_Detect_Ori_Image")) {
                    strArr[1] = absolutePath;
                } else if (absolutePath.contains("Custom_Detect_Crop_Face")) {
                    strArr[2] = absolutePath;
                } else if (absolutePath.contains("Texture_Type_Custom")) {
                    strArr[3] = absolutePath;
                } else if (absolutePath.contains("Mesh_Type_1_Custom")) {
                    strArr[4] = absolutePath;
                } else if (absolutePath.contains("Mesh_Type_2_Custom")) {
                    strArr[5] = absolutePath;
                } else if (absolutePath.contains("Mesh_Type_3_Custom")) {
                    strArr[6] = absolutePath;
                } else {
                    Log.e("FittingFaceData", "[c] ERROR: GetCustomFaceFile() - wrong custom file: " + absolutePath);
                }
            }
        }
        return strArr;
    }

    public static String[] GenerateCustomFaceFile(String str, FittingFaceData fittingFaceData) {
        long currentTimeMillis = System.currentTimeMillis();
        String[] strArr = {str + File.separator + "Custom_Detect_Position" + "_" + currentTimeMillis + GlobalDefine.EXTENSION_BIN, str + File.separator + "Custom_Detect_Ori_Image" + "_" + currentTimeMillis + ".bmp", str + File.separator + "Custom_Detect_Crop_Face" + "_" + currentTimeMillis + GlobalDefine.EXTENSION_PNG, str + File.separator + "Texture_Type_Custom" + "_" + currentTimeMillis + GlobalDefine.EXTENSION_PNG, str + File.separator + "Mesh_Type_1_Custom" + "_" + currentTimeMillis + GlobalDefine.EXTENSION_BIN, str + File.separator + "Mesh_Type_2_Custom" + "_" + currentTimeMillis + GlobalDefine.EXTENSION_BIN, str + File.separator + "Mesh_Type_3_Custom" + "_" + currentTimeMillis + GlobalDefine.EXTENSION_BIN};
        if (fittingFaceData != null) {
            fittingFaceData.SetCustomFaceDetectPositionFile(strArr[0]);
            fittingFaceData.SetCustomFaceDetectOriImageFile(strArr[1]);
            fittingFaceData.SetCustomFaceDetectCropFaceFile(strArr[2]);
            fittingFaceData.SetCustomFaceTextureTypeFile(strArr[3]);
            fittingFaceData.SetCustomFaceMeshType1File(strArr[4]);
            fittingFaceData.SetCustomFaceMeshType2File(strArr[5]);
            fittingFaceData.SetCustomFaceMeshType3File(strArr[6]);
        }
        return strArr;
    }

    public void SetModelGender(int i2) {
        this.f1489b = i2;
    }

    public int GetModelGender() {
        return this.f1489b;
    }

    private boolean a() {
        return this.f1489b == 3 || this.f1489b == 2;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingview\data\g.java ==========

package net.fxgear.fittingview.data;

import android.util.Log;
import java.util.ArrayList;
import net.fxgear.b.h;

/* compiled from: FittingModeData */
public class g {

    /* renamed from: a  reason: collision with root package name */
    protected ArrayList<d> f1508a;

    /* renamed from: b  reason: collision with root package name */
    protected int f1509b;
    protected int c;
    protected float[] d;
    protected h.e e;
    protected float f;
    private final String g = "FittingModeData";

    public g() {
        Log.i("FittingModeData", "FittingModeData()+");
    }

    public void a(int i) {
        this.f1509b = i;
    }

    public int a() {
        return this.f1509b;
    }

    public void b(int i) {
        this.c = i;
    }

    public int b() {
        return this.c;
    }

    public void a(ArrayList<d> arrayList) {
        this.f1508a = arrayList;
    }

    public ArrayList<d> c() {
        return this.f1508a;
    }

    public void a(float[] fArr) {
        this.d = fArr;
    }

    public float[] d() {
        return this.d;
    }

    public void a(h.e eVar) {
        this.e = eVar;
    }

    public h.e e() {
        return this.e;
    }

    public void a(float f2) {
        this.f = f2;
    }

    public float f() {
        return this.f;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\fittingview\data\h.java ==========

package net.fxgear.fittingview.data;

import android.util.Log;

/* compiled from: FittingRealData */
public class h {

    /* renamed from: a  reason: collision with root package name */
    protected int f1510a;

    /* renamed from: b  reason: collision with root package name */
    protected String f1511b;
    protected String c;
    protected boolean d = false;
    protected int e;
    private final String f = "FittingRealData";

    public h() {
        Log.i("FittingRealData", "FittingRealData()+");
    }

    public void a(String str) {
        this.c = str;
    }

    public void b(String str) {
        this.f1511b = str;
    }

    public String a() {
        return this.c;
    }

    public String b() {
        return this.f1511b;
    }

    public void a(int i) {
        this.f1510a = i;
    }

    public int c() {
        return this.f1510a;
    }

    public void b(int i) {
        this.e = i;
    }

    public int d() {
        return this.e;
    }
}


