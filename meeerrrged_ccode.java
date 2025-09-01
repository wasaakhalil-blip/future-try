

// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\b\a.java ==========

package net.fxgear.b;

import android.graphics.Bitmap;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import javax.microedition.khronos.opengles.GL10;
import net.fxgear.GlobalDefine;
import net.fxgear.b.h;
import net.fxgear.b.l;
import net.fxgear.fittingview.data.e;
import net.fxgear.fittingview.qlSolver;

/* compiled from: FXAnimationInterface */
public class a {
    private static int[] h = {19, 7978};
    private static int[] i = {6607, 23608};
    private static float j = 0.5f;
    private static float k = 0.01f;

    /* renamed from: a  reason: collision with root package name */
    n f666a;

    /* renamed from: b  reason: collision with root package name */
    m f667b;
    qlSolver c;
    int d;
    int e;
    int f;
    int g;

    public a() {
        this.f666a = null;
        this.f667b = null;
        this.c = null;
        this.d = -1;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.f666a = new n();
        this.f667b = new m(this.f666a);
    }

    public void a() {
        this.f667b.a();
    }

    public void a(int i2, int i3) {
        this.f667b.a(i2, i3);
    }

    public void a(GL10 gl10) {
        if (this.f666a != null) {
            this.f666a.d();
            this.f666a = null;
        }
        if (this.f667b != null) {
            this.f667b.a(gl10);
            this.f667b = null;
        }
    }

    public void b(GL10 gl10) {
        this.f666a.a(gl10);
    }

    public void b() {
        this.f666a.a();
    }

    public void a(String str) {
        k a2 = this.f666a.a(str);
        if (a2 != null) {
            a2.C();
            a2.ah();
            a2.ai();
        }
    }

    public void c() {
        this.f666a.b();
    }

    public void d() {
        this.f666a.c();
    }

    public void a(int i2) {
        this.f666a.a(i2);
    }

    public void a(GL10 gl10, float[] fArr, int i2, int i3, int i4, boolean z, boolean z2) {
        this.f667b.a(gl10, fArr, i2, i3, i4, z, z2);
    }

    public void e() {
        this.d = l.a();
        this.f667b.f(this.d);
    }

    public void a(Bitmap bitmap) {
        this.f667b.a(bitmap, this.g);
    }

    public void b(int i2) {
        this.g = i2;
    }

    public float c(int i2) {
        return this.f667b.c(i2);
    }

    public int f() {
        return this.d;
    }

    public String d(int i2) {
        return this.f667b.d(i2);
    }

    public p e(int i2) {
        return this.f667b.e(i2);
    }

    public void a(h.e eVar, int i2) {
        this.f667b.a(eVar);
        this.f667b.b(i2);
    }

    public void f(int i2) {
        this.f667b.a(i2);
    }

    public h.e g() {
        return this.f667b.d();
    }

    public int h() {
        return this.f667b.f();
    }

    public void g(int i2) {
        if (this.f666a != null) {
            this.f666a.e(i2);
        }
    }

    public void a(String str, ArrayList<String> arrayList, String str2, int i2, int i3, int[] iArr, int i4) {
        p c2 = this.f666a.c(str);
        if (c2 == null) {
            c2 = l.a(str, str2, i3, iArr);
            c2.C();
            c2.b(0);
            c2.a(str);
            c2.b(str2);
            c2.a(i4);
            this.f666a.a(c2);
            b.c(c2, c2.F());
            if (c2.a() != null) {
                b.d(c2, c2.a().F());
            }
            this.f666a.a(c2, i2, true);
        } else {
            this.f666a.a(c2, i2, false);
        }
        e d2 = this.f666a.d(arrayList.get(0));
        if (d2 == null) {
            ArrayList<i> p = c2.p();
            int size = p.size();
            float[] fArr = new float[(size * 3)];
            for (int i5 = 0; i5 < size; i5++) {
                int i6 = i5 * 3;
                fArr[i6 + 0] = p.get(i5).l()[0];
                fArr[i6 + 1] = p.get(i5).l()[1];
                fArr[i6 + 2] = p.get(i5).l()[2];
            }
            e eVar = new e(size);
            for (int i7 = 0; i7 < arrayList.size(); i7++) {
                eVar.a(l.a(arrayList.get(i7), iArr), fArr);
            }
            eVar.a(h.a.SKELETON);
            eVar.a(arrayList.get(0));
            this.f666a.a(eVar);
            this.f666a.a(c2, eVar);
            return;
        }
        this.f666a.a(c2, d2);
    }

    public void a(String str, String str2, String str3, int i2, int i3, ArrayList<String> arrayList, int i4) {
        p c2 = this.f666a.c(str);
        if (c2 == null) {
            Log.e("FXAnimationInterface : ", "AttachAvatarHairSkeleton : Attaching custom hair requires body skeleton!");
        } else if (c2.a() == null) {
            p a2 = l.a(str2, str3, i3, arrayList);
            a2.C();
            a2.b(0);
            a2.a(str2);
            a2.b(str3);
            a2.a(i4);
            a2.a(arrayList);
            c2.a(a2);
            b.d(c2, c2.a().F());
        }
    }

    public void a(String str, String str2) {
        p c2 = this.f666a.c(str);
        if (c2 == null) {
            Log.e("FXAnimationInterface : ", "[c] ERROR: Skeleton " + str + " has not been loaded. Attach animation " + str2 + " failed.");
        } else if (c2.m() == null || !c2.m().equals(str2)) {
            c2.b(str2);
            int[] c3 = c(str);
            ArrayList<i> q = c2.q();
            int i2 = 0;
            if (q == null) {
                q = new ArrayList<>();
                int size = c2.p().size();
                while (i2 < size) {
                    q.add(new i());
                    i2++;
                }
            } else {
                int size2 = c2.p().size();
                while (i2 < size2) {
                    q.get(i2).f();
                    i2++;
                }
            }
            l.b(q, str2, c3);
            c2.c(q);
        } else {
            Log.i("FXAnimationInterface : ", "[c] ReplaceSkeletonAnimation() - return: same animation!");
        }
    }

    public boolean b(String str) {
        p c2 = this.f666a.c(str);
        if (c2 == null) {
            Log.e("FXAnimationInterface : ", "[c] ERROR: UpdateSkeletonAnimation() - skeletonRef == null: " + str);
            return false;
        }
        ArrayList<i> q = c2.q();
        if (q == null) {
            return false;
        }
        ArrayList<i> p = c2.p();
        for (int i2 = 0; i2 < p.size(); i2++) {
            p.get(i2).f();
            p.get(i2).a(q.get(i2).p());
            q.get(i2).a(false);
        }
        c2.D();
        q.clear();
        c2.c((ArrayList<i>) null);
        return true;
    }

    public void a(String str, String str2, int i2, int i3, int i4) {
        p b2 = this.f666a.b(str);
        if (b2 != null) {
            this.f666a.a(b2, i2, true);
            return;
        }
        p h2 = h(i4);
        if (h2 == null) {
            Log.e("FXAnimationInterface : ", "[c] ERROR: AttachCustomSkeleton not Man/Woman");
            return;
        }
        p pVar = new p();
        pVar.b(h2);
        pVar.c(i3);
        pVar.a(i4);
        pVar.B();
        a(pVar, str, i2, i4);
        l.a(pVar, str);
        pVar.b(1);
        pVar.a(str);
        pVar.b(str);
        pVar.c(str2);
        pVar.g(pVar.x());
        pVar.g(pVar.F());
        pVar.G();
        pVar.C();
        this.f666a.a(pVar);
        b.c(pVar, pVar.F());
        if (pVar.a() != null) {
            b.d(pVar, pVar.a().F());
        }
        this.f666a.a(pVar, i2, true);
    }

    public p h(int i2) {
        return this.f666a.d(i2);
    }

    public int[] c(String str) {
        return l.a(str);
    }

    public ArrayList<String> d(String str) {
        return l.b(str);
    }

    public void a(String str, ArrayList<String> arrayList, String str2, ArrayList<String> arrayList2, ArrayList<String> arrayList3, int i2, h.d dVar, int i3, boolean z, boolean z2) {
        String str3 = str;
        ArrayList<String> arrayList4 = arrayList;
        String str4 = str2;
        ArrayList<String> arrayList5 = arrayList2;
        ArrayList<String> arrayList6 = arrayList3;
        int i4 = i2;
        h.d dVar2 = dVar;
        k a2 = this.f666a.a(str3);
        e d2 = this.f666a.d(str3);
        if (a2 == null) {
            a2 = new k();
            a2.e();
            a2.a(i3);
            a2.a(dVar2);
            a2.b((Bitmap) null);
            a2.b(str3);
            if (arrayList4 != null) {
                Bitmap[] bitmapArr = new Bitmap[arrayList.size()];
                for (int i5 = 0; i5 < arrayList.size(); i5++) {
                    bitmapArr[i5] = l.a(arrayList4.get(i5), this.g);
                }
                a2.a(bitmapArr, (String[]) arrayList4.toArray(new String[arrayList.size()]));
                a2.a(str4);
            }
            this.f666a.a(a2);
        } else {
            a2.a(str4);
            a2.e();
        }
        if (d2 == null) {
            p b2 = this.f666a.b(i4);
            if (b2.E().k == null) {
                Log.e("FXAnimationInterface : ", "Skeleton data does not have a bind pose infomation, this causes wrong render result");
            }
            d a3 = l.a(str3, (dVar2 == h.d.HAIR || dVar2 == h.d.HEAD || dVar2 == h.d.HAIR_ACC) ? 46 : 0, b2, true);
            a3.a(z2);
            if (dVar2 == h.d.BODY) {
                a3.g();
                a3.i();
            }
            if (arrayList5 != null) {
                Bitmap[] bitmapArr2 = new Bitmap[arrayList2.size()];
                for (int i6 = 0; i6 < arrayList2.size(); i6++) {
                    bitmapArr2[i6] = l.a(arrayList5.get(i6), this.g);
                }
                a2.b(bitmapArr2);
            }
            e eVar = new e();
            eVar.g();
            eVar.a(a3);
            eVar.a(str3);
            eVar.a(h.a.MESH);
            this.f666a.a(eVar);
            if (arrayList6 != null) {
                for (int i7 = 0; i7 < arrayList3.size(); i7++) {
                    eVar.a(l.c(arrayList6.get(i7)), a3.p());
                }
                this.f666a.a(a2, eVar);
                float[] fArr = new float[26];
                for (int i8 = 0; i8 < 26; i8++) {
                    fArr[i8] = 0.0f;
                }
                a2.e(a2.h(eVar.a(fArr, eVar.q())));
            } else {
                this.f666a.a(a2, eVar);
                a2.e(a2.h(eVar.q()));
            }
        } else {
            this.f666a.a(a2, d2);
            d2.h();
        }
        this.f666a.a(a2, i4, z);
    }

    public void a(String str, ArrayList<String> arrayList, ArrayList<String> arrayList2, int i2, h.d dVar, int i3, boolean z, boolean z2) {
        k a2 = this.f666a.a(str);
        e d2 = this.f666a.d(str);
        if (a2 == null) {
            a2 = new k();
            a2.e();
            Bitmap[] bitmapArr = new Bitmap[arrayList.size()];
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                bitmapArr[i4] = l.a(arrayList.get(i4), this.g);
            }
            a2.a(i3);
            a2.a(dVar);
            a2.a(bitmapArr);
            a2.b(str);
            this.f666a.a(a2);
        } else {
            a2.e();
        }
        if (d2 == null) {
            p b2 = this.f666a.b(i2);
            if (b2 == null) {
                Log.e("FXAnimationInterface : ", "mSkeleton is null, we need skeleton to add body mesh: " + str);
                return;
            }
            int i5 = (dVar == h.d.HAIR || dVar == h.d.HEAD || dVar == h.d.HAIR_ACC) ? 46 : 0;
            if (!z2) {
                i5 = 0;
            }
            d a3 = l.a(str, i5, b2, z2);
            a3.a(true);
            e eVar = new e();
            eVar.g();
            eVar.a(a3);
            eVar.a(str);
            eVar.a(h.a.MESH);
            this.f666a.a(eVar);
            if (arrayList2 != null) {
                for (int i6 = 0; i6 < arrayList2.size(); i6++) {
                    eVar.a(l.c(arrayList2.get(i6)), a3.p());
                }
                float[] fArr = new float[26];
                for (int i7 = 0; i7 < 26; i7++) {
                    fArr[i7] = 0.0f;
                }
                float[] a4 = eVar.a(fArr, eVar.q());
                this.f666a.a(a2, eVar);
                a2.e(a2.h(a4));
            } else {
                this.f666a.a(a2, eVar);
                a2.e(a2.h(eVar.q()));
            }
        } else {
            this.f666a.a(a2, d2);
            d2.h();
        }
        this.f666a.a(a2, i2, z);
    }

    public void a(String str, String str2, ArrayList<String> arrayList, ArrayList<String> arrayList2, GlobalDefine.CLOTHES_CATEGORY_TYPE clothes_category_type, h.d dVar, int i2, int i3, int i4) {
        String str3 = str;
        String str4 = str2;
        ArrayList<String> arrayList3 = arrayList2;
        if (this.f667b.g() == null) {
            Log.e("FXAnimationInterface : ", "[c] AddClothMesh - tempAnimator == null!");
            return;
        }
        p h2 = h(i3);
        if (h2 == null) {
            Log.e("FXAnimationInterface : ", "[c] ERROR: AddClothMesh - no available reference skeleton");
            return;
        }
        k a2 = this.f666a.a(str3);
        e d2 = this.f666a.d(str4);
        ArrayList<i> p = h2.p();
        if (d2 == null) {
            d2 = new e();
            d2.g();
            d a3 = l.a(str4, 0, h2, true);
            a3.a(false);
            a3.g();
            a3.i();
            d2.a(a3);
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                d2.a(l.c(arrayList.get(i5)), a3.p());
            }
            if (arrayList3 != null) {
                d2.a(true);
                for (int i6 = 0; i6 < arrayList2.size(); i6++) {
                    d2.a(l.c(arrayList3.get(i6)), a3.p());
                }
            }
            d2.a(h.a.MESH);
            d2.a(str4);
            d2.b(true);
            this.f666a.a(d2);
        } else {
            d2.h();
        }
        e eVar = d2;
        if (a2 == null) {
            l.a b2 = l.b(str3, this.g);
            a2 = l.a(p, str, h2, eVar.y(), eVar.z(), (short[]) null, eVar.A(), b2.h, dVar);
            a2.e();
            a2.a(i2);
            a2.a(dVar);
            a2.a(clothes_category_type);
            a2.b(b2.h);
            a2.a(b2.g);
            a2.b(str3);
            a2.a(true);
            this.f666a.a(a2);
        } else {
            a2.e();
        }
        a2.d(i4);
        this.f666a.a(a2, eVar);
        if (!a2.af()) {
            Log.e("FXAnimationInterface : ", "[i] UpdateCollisionTable failed " + str3);
        }
    }

    public void a(String str, ArrayList<String> arrayList, String str2, int i2, int i3) {
        if (str == null || arrayList == null || str2 == null) {
            Log.e("FXAnimationInterface : ", " SkeletonData Path or Lists are null, please check it ");
        }
        a(str, arrayList, str2, i2, this.f, c(str), i3);
        this.f++;
    }

    public void a(String str, String str2, String str3, int i2, int i3) {
        if (str2 == null || str3 == null) {
            Log.e("FXAnimationInterface : ", " SkeletonHairData Path or SkeletonHairAniData are null, please check it ");
        }
        a(str, str2, str3, i2, this.f, d(str2), i3);
        this.f++;
    }

    public void e(String str) {
        p c2 = this.f666a.c(str);
        if (c2 != null) {
            c2.b();
        }
    }

    public void a(String str, String str2, int i2, int i3) {
        if (str == null) {
            Log.e("FXAnimationInterface : ", " MeshData customAnimationFilePath is null, please check it ");
        }
        a(str, str2, i2, this.f, i3);
        this.f++;
    }

    public void a(String str, ArrayList<String> arrayList, String str2, ArrayList<String> arrayList2, int i2, h.d dVar, ArrayList<String> arrayList3, boolean z, boolean z2) {
        if (str == null) {
            Log.e("FXAnimationInterface : ", " MeshData meshFilePath are null, please check it ");
            return;
        }
        if (arrayList == null || arrayList.isEmpty()) {
            Log.e("FXAnimationInterface : ", " MeshData textureFilePath are null, please check it, mesh will be generated without textures ");
        }
        if (arrayList3 == null) {
            Log.e("FXAnimationInterface : ", " There are no blendShape. If it needs, please add blendShapeFile");
            a(str, arrayList, str2, arrayList2, (ArrayList<String>) null, i2, dVar, this.e, z, z2);
            this.e++;
            return;
        }
        a(str, arrayList, str2, arrayList2, arrayList3, i2, dVar, this.e, z, z2);
        this.e++;
    }

    public void a(String str, ArrayList<String> arrayList, int i2, h.d dVar, ArrayList<String> arrayList2, boolean z, boolean z2) {
        if (str == null || arrayList == null) {
            Log.e("FXAnimationInterface : ", " MeshData meshFilePath or textureFilePath are null, please check it ");
        } else if (arrayList2 == null) {
            Log.e("FXAnimationInterface : ", " There are no blendShape. If it needs, please add blendShapeFile");
            a(str, arrayList, (ArrayList<String>) null, i2, dVar, this.e, z, z2);
            this.e++;
        } else {
            a(str, arrayList, arrayList2, i2, dVar, this.e, z, z2);
            this.e++;
        }
    }

    public void a(String str, String str2, ArrayList<String> arrayList, ArrayList<String> arrayList2, GlobalDefine.CLOTHES_CATEGORY_TYPE clothes_category_type, h.d dVar, int i2, int i3) {
        if (str == null) {
            Log.e("FXAnimationInterface : ", " MeshData meshFilePath or textureFilePath are null, please check it ");
        } else if (arrayList == null || str2 == null) {
            Log.e("FXAnimationInterface : ", " baseMeshFilePath, blendShapeFilePathList is null, please check it ");
        } else {
            a(str, str2, arrayList, arrayList2, clothes_category_type, dVar, this.e, i2, i3);
            this.e++;
        }
    }

    public void a(String str, String str2, int i2, h.d dVar) {
        if (str == null || str2 == null) {
            Log.e("FXAnimationInterface : ", " MeshData meshFilePath or textureFilePath are null, please check it ");
            return;
        }
        a(str, new ArrayList(Arrays.asList(new String[]{str2})), str2, (ArrayList<String>) null, (ArrayList<String>) null, i2, dVar, this.e, false, false);
        this.e++;
    }

    public float[] a(int i2, float[] fArr) {
        p c2 = this.f666a.c(i2);
        if (c2 == null || c2.E() == null || c2.E().k == null) {
            Log.e("FXAnimationInterface : ", "[c] UpdateSkeletonBlendWeight skeleton null!");
            return null;
        }
        c2.g(fArr);
        float[] fArr2 = {c2.E().k[301], c2.E().k[201], c2.E().k[200]};
        b.a(c2, c2.F());
        if (c2.a() != null) {
            b.b(c2, c2.a().F());
        }
        fArr2[0] = c2.E().k[301] - c2.E().m[301];
        fArr2[1] = c2.E().k[201] - c2.E().m[201];
        fArr2[2] = c2.E().k[200] - c2.E().m[200];
        return fArr2;
    }

    public void b(int i2, float[] fArr) {
        if (i2 >= 4) {
            Log.e("FXAnimationInterface : ", "Update Blend Weight is allowed only to avatar");
            return;
        }
        c f2 = this.f666a.f(i2);
        float[] a2 = a(i2, fArr);
        if (f2.f670a != null) {
            f2.f670a.a(fArr, this.f666a.c(i2));
        }
        if (f2.f671b != null) {
            f2.f671b.f(a2[0]);
        }
        if (f2.c != null) {
            f2.c.f(a2[0]);
        }
        if (f2.i != null) {
            f2.i.f(a2[1]);
            f2.i.g(a2[2]);
        }
        f2.a(fArr);
    }

    public void i(int i2) {
        p c2;
        c f2 = this.f666a.f(4);
        c f3 = this.f666a.f(i2 == 0 ? 0 : i2 == 1 ? 1 : i2 == 2 ? 2 : i2 == 3 ? 3 : 4);
        if (!(f3.f670a == null || (c2 = this.f666a.c(4)) == null)) {
            f3.f670a.a(f2.a(), c2);
        }
        f3.a(f2.a());
    }

    public float a(int i2, float[] fArr, int[] iArr, float f2) {
        if (i2 >= 4) {
            Log.e("FXAnimationInterface : ", "Update Blend Weight is allowed only to avatar");
            return GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        }
        c f3 = this.f666a.f(i2);
        if (f3.f670a != null) {
            return f3.f670a.a(fArr, iArr, f2);
        }
        return GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    }

    public float[] a(int i2, float[] fArr, float f2) {
        int[] iArr;
        int i3 = i2;
        float[] fArr2 = fArr;
        if (i3 == 1) {
            iArr = h;
        } else if (i3 == 0) {
            iArr = i;
        } else {
            Log.e("FXAnimationInterface : ", "[c] SearchUpdateBodyBlendWeight not support!");
            return null;
        }
        float f3 = f2;
        float f4 = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        while (true) {
            float a2 = a(i3, fArr2, iArr, f3);
            if (f4 == a2 || Math.abs(a2) < j) {
                break;
            }
            float abs = Math.abs(a2) * 5.0f;
            if (abs < 1.0f) {
                abs = 1.0f;
            }
            if (a2 > j) {
                if (fArr2[4] > GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
                    fArr2[4] = fArr2[4] - (k * abs);
                    if (fArr2[4] < GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
                        fArr2[4] = 0.0f;
                        fArr2[5] = k * abs;
                    }
                } else if (fArr2[5] > GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
                    fArr2[5] = fArr2[5] + (k * abs);
                    if (fArr2[5] > 1.0f) {
                        fArr2[5] = 1.0f;
                        if (this.f667b.e() == 9 || this.f667b.e() == 2 || this.f667b.e() == 6 || this.f667b.e() == -1) {
                            return null;
                        }
                        return fArr2;
                    }
                }
            } else if (a2 < (-j)) {
                if (fArr2[4] > GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
                    fArr2[4] = fArr2[4] + (k * abs);
                    if (fArr2[4] > 1.0f) {
                        fArr2[4] = 1.0f;
                        if (this.f667b.e() == 9 || this.f667b.e() == 2 || this.f667b.e() == 6 || this.f667b.e() == -1) {
                            return null;
                        }
                        return fArr2;
                    }
                } else if (fArr2[5] > GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
                    fArr2[5] = fArr2[5] - (k * abs);
                    if (fArr2[5] < GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
                        fArr2[5] = 0.0f;
                        fArr2[4] = k * abs;
                    }
                }
            }
            if (Math.abs(a2) <= j) {
                break;
            }
            f4 = a2;
        }
        return fArr2;
    }

    public void b(int i2, float[] fArr, float f2) {
        if (i2 == 1 || i2 == 0) {
            float[] a2 = a(i2, fArr, f2);
            if (a2 != null) {
                b(i2, a2);
            }
        } else if (i2 == 2 || i2 == 3) {
            b(i2, fArr);
        } else {
            Log.e("FXAnimationInterface : ", "[c] UpdateBodyBlendWeight() - adjWeight (only female and male) not support!");
            b(i2, fArr);
        }
    }

    public boolean j(int i2) {
        if (this.f666a.f(i2).f671b != null) {
            return this.f666a.f(i2).f671b.j();
        }
        return false;
    }

    public float k(int i2) {
        return this.f666a.f(i2).f671b != null ? this.f666a.f(i2).f671b.ab() : GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    }

    public void a(int i2, int i3, float f2) {
        if (this.f666a.f(i2).f671b != null) {
            this.f666a.f(i2).f671b.c(i3);
            this.f666a.f(i2).f671b.e(f2);
        }
    }

    public boolean a(String str, int i2) {
        k a2 = this.f666a.a(str);
        if (a2 == null) {
            Log.e("FXAnimationInterface : ", "Requested mesh does not exist!");
            return false;
        }
        a2.f();
        this.f666a.a(a2, i2, false);
        return true;
    }

    public void a(int i2, h.d dVar) {
        this.f666a.a(i2, dVar);
    }

    public void a(int i2, boolean z, boolean z2, boolean z3) {
        this.f666a.a(i2, z, z2, z3);
    }

    public void c(int i2, float[] fArr) {
        this.f666a.a(i2, fArr);
    }

    public Bitmap a(float[] fArr, int i2, int i3, int i4, boolean z, boolean z2, boolean z3) {
        k kVar;
        if (!z2) {
            int i5 = i4;
            kVar = this.f666a.b(i4, h.d.BODY);
            if (kVar != null) {
                kVar.b(kVar.S());
            }
        } else {
            int i6 = i4;
            kVar = null;
        }
        k kVar2 = kVar;
        Bitmap a2 = this.f667b.a(fArr, i2, i3, i4, z, z2, z3);
        if (kVar2 != null) {
            kVar2.y();
        }
        return a2;
    }

    public void a(int i2, float f2) {
        this.f666a.a(i2, f2);
    }

    public void a(int i2, boolean z) {
        this.f666a.a(i2, z);
    }

    public void a(int i2, e.b bVar) {
        this.f666a.a(i2, bVar.f1504a, bVar.f1505b, bVar.c, bVar.h, bVar.f, bVar.g, bVar.d, bVar.e);
    }

    public void b(int i2, e.b bVar) {
        this.f666a.a(i2, bVar.f1504a, bVar.f1505b, bVar.c, bVar.h, bVar.f, bVar.g, bVar.d);
    }

    public void a(boolean z) {
        this.f667b.a(z);
    }

    public boolean i() {
        return this.f667b.c();
    }

    public void j() {
        this.f667b.h();
    }

    private void a(p pVar, String str, int i2, int i3) {
        p pVar2 = pVar;
        String str2 = str;
        int i4 = i3;
        if (str2.contains("Woman/Animation_44.bin")) {
            Log.i("FXAnimationInterface : ", "Custom tuning is applied to " + str2);
            pVar2.c = 1.0f;
            pVar2.d = 0.36f;
            pVar2.e = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            pVar2.f = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            pVar2.g = 0.5f;
            pVar2.i[0] = 2.5f;
            pVar2.i[1] = 0.0f;
            pVar2.h = new float[26];
            pVar2.h[0] = 0.0f;
            pVar2.h[1] = 0.25f;
            pVar2.h[2] = 0.674244f;
            pVar2.h[3] = 0.0f;
            pVar2.h[4] = 0.215634f;
            pVar2.h[5] = 0.0f;
            pVar2.h[6] = 0.0f;
            pVar2.h[7] = 0.0f;
            pVar2.h[8] = 0.467194f;
            pVar2.h[9] = 0.0f;
            pVar2.h[10] = 0.247555f;
            pVar2.h[11] = 0.0f;
            pVar2.h[12] = 0.494891f;
            pVar2.h[13] = 0.0f;
            pVar2.h[14] = 0.407443f;
            pVar2.h[15] = 0.0f;
            pVar2.h[16] = 0.3f;
            pVar2.h[17] = 0.0f;
            pVar2.h[18] = 0.0f;
            pVar2.h[19] = 0.0f;
            pVar2.h[20] = 0.1f;
            pVar2.h[21] = 0.0f;
            pVar2.h[22] = 0.35f;
            pVar2.h[23] = 0.0f;
            pVar2.h[24] = 0.1f;
            pVar2.h[25] = 0.0f;
            pVar2.j[0] = 0.0f;
            pVar2.j[1] = 0.0f;
            pVar2.j[2] = 0.0f;
            this.f667b.a(1.0f, (float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        } else if (str2.contains("Woman/Animation_55.bin")) {
            Log.i("FXAnimationInterface : ", "Custom tuning is applied to " + str2);
            pVar2.c = 2.3f;
            pVar2.d = 0.32f;
            pVar2.e = -1.6f;
            pVar2.f = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            pVar2.g = 3.0f;
            pVar2.i[0] = 0.0f;
            pVar2.i[1] = 0.0f;
            pVar2.h = new float[26];
            pVar2.h[0] = 0.0f;
            pVar2.h[1] = 0.1f;
            pVar2.h[2] = 0.2f;
            pVar2.h[3] = 0.0f;
            pVar2.h[4] = 0.2915189f;
            pVar2.h[5] = 0.0f;
            pVar2.h[6] = 0.089449f;
            pVar2.h[7] = 0.0f;
            pVar2.h[8] = 0.7432f;
            pVar2.h[9] = 0.0f;
            pVar2.h[10] = 0.0f;
            pVar2.h[11] = 0.1f;
            pVar2.h[12] = 0.55f;
            pVar2.h[13] = 0.0f;
            pVar2.h[14] = 0.16987f;
            pVar2.h[15] = 0.0f;
            pVar2.h[16] = 0.16987f;
            pVar2.h[17] = 0.0f;
            pVar2.h[18] = 0.16987f;
            pVar2.h[19] = 0.0f;
            pVar2.h[20] = 0.20987f;
            pVar2.h[21] = 0.0f;
            pVar2.h[22] = 0.3f;
            pVar2.h[23] = 0.0f;
            pVar2.h[24] = 0.3f;
            pVar2.h[25] = 0.0f;
            pVar2.j[0] = 0.0f;
            pVar2.j[1] = 0.0f;
            pVar2.j[2] = 0.0f;
            this.f667b.a(1.0f, (float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        } else if (str2.contains("Woman/Animation_66.bin")) {
            Log.i("FXAnimationInterface : ", "Custom tuning is applied to " + str2);
            pVar2.c = 2.3f;
            pVar2.d = 0.32f;
            pVar2.e = -0.8f;
            pVar2.f = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            pVar2.g = 1.1f;
            pVar2.i[0] = 0.0f;
            pVar2.i[1] = 0.0f;
            pVar2.h = new float[26];
            pVar2.h[0] = 0.4f;
            pVar2.h[1] = 0.0f;
            pVar2.h[2] = 0.47404128f;
            pVar2.h[3] = 0.0f;
            pVar2.h[4] = 0.3810875f;
            pVar2.h[5] = 0.0f;
            pVar2.h[6] = 0.46057597f;
            pVar2.h[7] = 0.0f;
            pVar2.h[8] = 0.312f;
            pVar2.h[9] = 0.0f;
            pVar2.h[10] = 0.1f;
            pVar2.h[11] = 0.0f;
            pVar2.h[12] = 0.95459f;
            pVar2.h[13] = 0.0f;
            pVar2.h[14] = 0.314f;
            pVar2.h[15] = 0.0f;
            pVar2.h[16] = 0.314f;
            pVar2.h[17] = 0.0f;
            pVar2.h[18] = 0.314f;
            pVar2.h[19] = 0.0f;
            pVar2.h[20] = 0.514f;
            pVar2.h[21] = 0.0f;
            pVar2.h[22] = 0.48f;
            pVar2.h[23] = 0.0f;
            pVar2.h[24] = 0.41311f;
            pVar2.h[25] = 0.0f;
            pVar2.j[0] = 0.0f;
            pVar2.j[1] = 0.0f;
            pVar2.j[2] = 0.0f;
            this.f667b.a(1.0f, (float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        } else if (str2.contains("Man/Animation_95.bin")) {
            Log.i("FXAnimationInterface : ", "Custom tuning is applied to " + str2);
            pVar2.c = 2.3f;
            pVar2.d = 0.3f;
            pVar2.e = -0.5f;
            pVar2.f = 0.5f;
            pVar2.g = 0.3f;
            pVar2.i[0] = 0.0f;
            pVar2.i[1] = 0.0f;
            pVar2.h = new float[26];
            pVar2.h[0] = 0.018f;
            pVar2.h[1] = 0.0f;
            pVar2.h[2] = 0.1243f;
            pVar2.h[3] = 0.0f;
            pVar2.h[4] = 0.13f;
            pVar2.h[5] = 0.0f;
            pVar2.h[6] = 0.0f;
            pVar2.h[7] = 0.13f;
            pVar2.h[8] = 0.0f;
            pVar2.h[9] = 0.0f;
            pVar2.h[10] = 0.0f;
            pVar2.h[11] = 0.1971203f;
            pVar2.h[12] = 0.1f;
            pVar2.h[13] = 0.0f;
            pVar2.h[14] = 0.2539544f;
            pVar2.h[15] = 0.0f;
            pVar2.h[16] = 0.2539544f;
            pVar2.h[17] = 0.0f;
            pVar2.h[18] = 0.2539544f;
            pVar2.h[19] = 0.0f;
            pVar2.h[20] = 0.0f;
            pVar2.h[21] = 0.1f;
            pVar2.h[22] = 0.44008f;
            pVar2.h[23] = 0.0f;
            pVar2.h[24] = 0.34008f;
            pVar2.h[25] = 0.0f;
            pVar2.j[0] = 0.0f;
            pVar2.j[1] = 0.0f;
            pVar2.j[2] = 0.0f;
            this.f667b.a(1.0f, (float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        } else if (str2.contains("Man/Animation_100.bin")) {
            Log.i("FXAnimationInterface : ", "Custom tuning is applied to " + str2);
            pVar2.c = 2.3f;
            pVar2.d = 0.32f;
            pVar2.e = -0.5f;
            pVar2.f = 0.5f;
            pVar2.g = 0.5f;
            pVar2.i[0] = 0.0f;
            pVar2.i[1] = 0.0f;
            pVar2.h = new float[26];
            pVar2.h[0] = 0.6425976f;
            pVar2.h[1] = 0.0f;
            pVar2.h[2] = 0.2823115f;
            pVar2.h[3] = 0.0f;
            pVar2.h[4] = 0.4f;
            pVar2.h[5] = 0.0f;
            pVar2.h[6] = 0.2229715f;
            pVar2.h[7] = 0.0f;
            pVar2.h[8] = 0.14329383f;
            pVar2.h[9] = 0.0f;
            pVar2.h[10] = 0.12004225f;
            pVar2.h[11] = 0.0f;
            pVar2.h[12] = 0.41687375f;
            pVar2.h[13] = 0.0f;
            pVar2.h[14] = 0.20291509f;
            pVar2.h[15] = 0.0f;
            pVar2.h[16] = 0.4829151f;
            pVar2.h[17] = 0.0f;
            pVar2.h[18] = 0.20291509f;
            pVar2.h[19] = 0.0f;
            pVar2.h[20] = 0.20291509f;
            pVar2.h[21] = 0.0f;
            pVar2.h[22] = 0.6f;
            pVar2.h[23] = 0.0f;
            pVar2.h[24] = 0.6f;
            pVar2.h[25] = 0.0f;
            pVar2.j[0] = 0.0f;
            pVar2.j[1] = 0.0f;
            pVar2.j[2] = 0.0f;
            this.f667b.a(1.0f, (float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        } else if (str2.contains("Man/Animation_105.bin")) {
            Log.i("FXAnimationInterface : ", "Custom tuning is applied to " + str2);
            pVar2.c = 1.0f;
            pVar2.d = 0.25f;
            pVar2.e = 0.5f;
            pVar2.f = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            pVar2.g = 0.5f;
            pVar2.i[0] = 0.0f;
            pVar2.i[1] = 0.0f;
            pVar2.h = new float[26];
            pVar2.h[0] = 0.353029f;
            pVar2.h[1] = 0.0f;
            pVar2.h[2] = 0.338571f;
            pVar2.h[3] = 0.0f;
            pVar2.h[4] = 0.381277f;
            pVar2.h[5] = 0.0f;
            pVar2.h[6] = 0.2239f;
            pVar2.h[7] = 0.0f;
            pVar2.h[8] = 0.239365f;
            pVar2.h[9] = 0.0f;
            pVar2.h[10] = 0.150033f;
            pVar2.h[11] = 0.0f;
            pVar2.h[12] = 0.143097f;
            pVar2.h[13] = 0.0f;
            pVar2.h[14] = 0.20972f;
            pVar2.h[15] = 0.096143f;
            pVar2.h[16] = 0.4f;
            pVar2.h[17] = 0.0f;
            pVar2.h[18] = 0.0f;
            pVar2.h[19] = 0.0f;
            pVar2.h[20] = 0.2f;
            pVar2.h[21] = 0.0f;
            pVar2.h[22] = 0.45f;
            pVar2.h[23] = 0.0f;
            pVar2.h[24] = 0.45f;
            pVar2.h[25] = 0.0f;
            pVar2.j[0] = 0.0f;
            pVar2.j[1] = 0.0f;
            pVar2.j[2] = 0.0f;
            this.f667b.a(1.0f, (float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        } else if (str2.contains("Man/Animation_110.bin")) {
            Log.i("FXAnimationInterface : ", "Custom tuning is applied to " + str2);
            pVar2.c = 2.6f;
            pVar2.d = 0.28f;
            pVar2.e = -0.7f;
            pVar2.f = 0.5f;
            pVar2.g = -0.0f;
            pVar2.i[0] = 0.0f;
            pVar2.i[1] = 0.0f;
            pVar2.h = new float[26];
            pVar2.h[0] = 0.6f;
            pVar2.h[1] = 0.0f;
            pVar2.h[2] = 0.3002237f;
            pVar2.h[3] = 0.0f;
            pVar2.h[4] = 0.325f;
            pVar2.h[5] = 0.0f;
            pVar2.h[6] = 0.16160862f;
            pVar2.h[7] = 0.0f;
            pVar2.h[8] = 0.2715246f;
            pVar2.h[9] = 0.0f;
            pVar2.h[10] = 0.2536114f;
            pVar2.h[11] = 0.0f;
            pVar2.h[12] = 0.5723168f;
            pVar2.h[13] = 0.0f;
            pVar2.h[14] = 0.6487844f;
            pVar2.h[15] = 0.0f;
            pVar2.h[16] = 0.6487844f;
            pVar2.h[17] = 0.0f;
            pVar2.h[18] = 0.6487844f;
            pVar2.h[19] = 0.0f;
            pVar2.h[20] = 0.387844f;
            pVar2.h[21] = 0.0f;
            pVar2.h[22] = 0.8f;
            pVar2.h[23] = 0.0f;
            pVar2.h[24] = 0.75f;
            pVar2.h[25] = 0.0f;
            pVar2.j[0] = 0.0f;
            pVar2.j[1] = 0.0f;
            pVar2.j[2] = 0.0f;
            this.f667b.a(1.0f, (float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        } else if (str2.contains("Girl/Animation_110.bin")) {
            Log.i("FXAnimationInterface : ", "Custom tuning is applied to " + str2);
            pVar2.c = 2.0f;
            pVar2.d = 0.25f;
            pVar2.e = 1.0f;
            pVar2.f = 1.0f;
            pVar2.g = 2.5f;
            pVar2.i[0] = 2.0f;
            pVar2.i[1] = 9.5f;
            pVar2.h = new float[26];
            pVar2.h[0] = 0.06329296f;
            pVar2.h[1] = 0.0f;
            pVar2.h[2] = 0.62958974f;
            pVar2.h[3] = 0.0f;
            pVar2.h[4] = 0.3358619f;
            pVar2.h[5] = 0.0f;
            pVar2.h[6] = 0.22348475f;
            pVar2.h[7] = 0.0f;
            pVar2.h[8] = 0.0f;
            pVar2.h[9] = 0.10712976f;
            pVar2.h[10] = 0.0f;
            pVar2.h[11] = 0.5890264f;
            pVar2.h[12] = 0.0f;
            pVar2.h[13] = 0.10395266f;
            pVar2.h[14] = -0.004807386f;
            pVar2.h[15] = 0.0f;
            pVar2.h[16] = -0.004807386f;
            pVar2.h[17] = 0.0f;
            pVar2.h[18] = -0.004807386f;
            pVar2.h[19] = 0.0f;
            pVar2.h[20] = -0.004807386f;
            pVar2.h[21] = 0.0f;
            pVar2.h[22] = 0.2736f;
            pVar2.h[23] = 0.0f;
            pVar2.h[24] = 0.2736f;
            pVar2.h[25] = 0.0f;
            pVar2.j[0] = 0.0f;
            pVar2.j[1] = 13.0f;
            pVar2.j[2] = 40.0f;
            this.f667b.a(1.15f, 55.0f);
        } else if (str2.contains("Girl/Animation_120.bin")) {
            Log.i("FXAnimationInterface : ", "Custom tuning is applied to " + str2);
            pVar2.c = 2.6f;
            pVar2.d = 0.38f;
            pVar2.e = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            pVar2.f = 1.0f;
            pVar2.g = 3.0f;
            pVar2.i[0] = 2.5f;
            pVar2.i[1] = 0.0f;
            pVar2.h = new float[26];
            pVar2.h[0] = 0.12058056f;
            pVar2.h[1] = 0.0f;
            pVar2.h[2] = 0.10224384f;
            pVar2.h[3] = 0.0f;
            pVar2.h[4] = 0.15f;
            pVar2.h[5] = 0.0f;
            pVar2.h[6] = 0.0f;
            pVar2.h[7] = 0.10231785f;
            pVar2.h[8] = 0.0f;
            pVar2.h[9] = 0.14370476f;
            pVar2.h[10] = 0.0f;
            pVar2.h[11] = 0.9281824f;
            pVar2.h[12] = 0.0f;
            pVar2.h[13] = 0.48f;
            pVar2.h[14] = -0.03070885f;
            pVar2.h[15] = 0.0f;
            pVar2.h[16] = -0.03070885f;
            pVar2.h[17] = 0.0f;
            pVar2.h[18] = -0.03070885f;
            pVar2.h[19] = 0.0f;
            pVar2.h[20] = -0.03070885f;
            pVar2.h[21] = 0.0f;
            pVar2.h[22] = 0.2456708f;
            pVar2.h[23] = 0.0f;
            pVar2.h[24] = 0.2456708f;
            pVar2.h[25] = 0.0f;
            pVar2.j[0] = 0.0f;
            pVar2.j[1] = 20.0f;
            pVar2.j[2] = 60.0f;
            this.f667b.a(1.3f, 80.0f);
        } else if (str2.contains("Girl/Animation_130.bin")) {
            Log.i("FXAnimationInterface : ", "Custom tuning is applied to " + str2);
            pVar2.c = 1.5f;
            pVar2.d = 0.6f;
            pVar2.e = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            pVar2.f = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            pVar2.g = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            pVar2.i[0] = 0.0f;
            pVar2.i[1] = -17.5f;
            pVar2.h = new float[26];
            pVar2.h[0] = 0.0f;
            pVar2.h[1] = 0.0f;
            pVar2.h[2] = 0.1f;
            pVar2.h[3] = 0.0f;
            pVar2.h[4] = 0.0f;
            pVar2.h[5] = 0.0f;
            pVar2.h[6] = 0.0f;
            pVar2.h[7] = 0.2f;
            pVar2.h[8] = 0.1f;
            pVar2.h[9] = 0.0f;
            pVar2.h[10] = 0.0f;
            pVar2.h[11] = 0.0f;
            pVar2.h[12] = 0.0f;
            pVar2.h[13] = 0.0f;
            pVar2.h[14] = 0.1f;
            pVar2.h[15] = 0.0f;
            pVar2.h[16] = 0.0f;
            pVar2.h[17] = 0.0f;
            pVar2.h[18] = 0.0f;
            pVar2.h[19] = 0.0f;
            pVar2.h[20] = 0.0f;
            pVar2.h[21] = 0.0f;
            pVar2.h[22] = 0.0f;
            pVar2.h[23] = 0.0f;
            pVar2.h[24] = 0.1f;
            pVar2.h[25] = 0.0f;
            pVar2.j[0] = 0.5f;
            pVar2.j[1] = 7.5f;
            pVar2.j[2] = 15.0f;
            this.f667b.a(1.0f, (float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        } else if (str2.contains("Girl/Animation_160.bin")) {
            Log.i("FXAnimationInterface : ", "Custom tuning is applied to " + str2);
            pVar2.c = 2.6f;
            pVar2.d = 0.28f;
            pVar2.e = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            pVar2.f = 1.75f;
            pVar2.g = 3.0f;
            pVar2.i[0] = -4.0f;
            pVar2.i[1] = 10.0f;
            pVar2.h = new float[26];
            pVar2.h[0] = 0.7006835f;
            pVar2.h[1] = 0.0f;
            pVar2.h[2] = 0.7756846f;
            pVar2.h[3] = 0.0f;
            pVar2.h[4] = 0.6427478f;
            pVar2.h[5] = 0.0f;
            pVar2.h[6] = 0.5601759f;
            pVar2.h[7] = 0.0f;
            pVar2.h[8] = 0.53588164f;
            pVar2.h[9] = 0.0f;
            pVar2.h[10] = 0.0f;
            pVar2.h[11] = 0.35868695f;
            pVar2.h[12] = 0.45735127f;
            pVar2.h[13] = 0.0f;
            pVar2.h[14] = 0.35013524f;
            pVar2.h[15] = 0.0f;
            pVar2.h[16] = 0.20013523f;
            pVar2.h[17] = 0.0f;
            pVar2.h[18] = 0.20013523f;
            pVar2.h[19] = 0.0f;
            pVar2.h[20] = 0.20013523f;
            pVar2.h[21] = 0.0f;
            pVar2.h[22] = 0.41317248f;
            pVar2.h[23] = 0.0f;
            pVar2.h[24] = 0.41317248f;
            pVar2.h[25] = 0.0f;
            pVar2.j[0] = 0.0f;
            pVar2.j[1] = 0.0f;
            pVar2.j[2] = 0.0f;
            this.f667b.a(1.0f, (float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        } else if (str2.contains("Boy/Animation_110.bin")) {
            Log.i("FXAnimationInterface : ", "Custom tuning is applied to " + str2);
            pVar2.c = 2.6f;
            pVar2.d = 0.225f;
            pVar2.e = 0.5f;
            pVar2.f = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            pVar2.g = 2.0f;
            pVar2.i[0] = -17.0f;
            pVar2.i[1] = -2.0f;
            pVar2.h = new float[26];
            pVar2.h[0] = 0.0f;
            pVar2.h[1] = 0.0f;
            pVar2.h[2] = 0.0916272f;
            pVar2.h[3] = 0.0f;
            pVar2.h[4] = 0.34797084f;
            pVar2.h[5] = 0.0f;
            pVar2.h[6] = 0.0f;
            pVar2.h[7] = 0.4f;
            pVar2.h[8] = 0.0f;
            pVar2.h[9] = 0.2f;
            pVar2.h[10] = 0.0f;
            pVar2.h[11] = 0.57743937f;
            pVar2.h[12] = 0.0f;
            pVar2.h[13] = 0.04564868f;
            pVar2.h[14] = 0.050557543f;
            pVar2.h[15] = 0.0f;
            pVar2.h[16] = 0.010557541f;
            pVar2.h[17] = 0.0f;
            pVar2.h[18] = 0.010557541f;
            pVar2.h[19] = 0.0f;
            pVar2.h[20] = 0.010557541f;
            pVar2.h[21] = 0.0f;
            pVar2.h[22] = 0.284064f;
            pVar2.h[23] = 0.0f;
            pVar2.h[24] = 0.284064f;
            pVar2.h[25] = 0.0f;
            pVar2.j[0] = 0.0f;
            pVar2.j[1] = 20.0f;
            pVar2.j[2] = 60.0f;
            this.f667b.a(1.3f, 80.0f);
        } else if (str2.contains("Boy/Animation_140.bin")) {
            Log.i("FXAnimationInterface : ", "Custom tuning is applied to " + str2);
            pVar2.c = 2.6f;
            pVar2.d = 0.34f;
            pVar2.e = -0.2f;
            pVar2.f = 1.0f;
            pVar2.g = 1.5f;
            pVar2.i[0] = -34.0f;
            pVar2.i[1] = 22.0f;
            pVar2.h = new float[26];
            pVar2.h[0] = 0.38541055f;
            pVar2.h[1] = 0.0f;
            pVar2.h[2] = 0.30064708f;
            pVar2.h[3] = 0.0f;
            pVar2.h[4] = 0.44554773f;
            pVar2.h[5] = 0.0f;
            pVar2.h[6] = 0.40478247f;
            pVar2.h[7] = 0.0f;
            pVar2.h[8] = 0.035207264f;
            pVar2.h[9] = 0.0f;
            pVar2.h[10] = 0.0f;
            pVar2.h[11] = 0.4872391f;
            pVar2.h[12] = 1.0f;
            pVar2.h[13] = 0.0f;
            pVar2.h[14] = 0.29031825f;
            pVar2.h[15] = 0.0f;
            pVar2.h[16] = 0.020318236f;
            pVar2.h[17] = 0.0f;
            pVar2.h[18] = -0.020318236f;
            pVar2.h[19] = 0.0f;
            pVar2.h[20] = 0.020318236f;
            pVar2.h[21] = 0.0f;
            pVar2.h[22] = 0.19254589f;
            pVar2.h[23] = 0.0f;
            pVar2.h[24] = 0.16254589f;
            pVar2.h[25] = 0.0f;
            pVar2.j[0] = 0.0f;
            pVar2.j[1] = 0.0f;
            pVar2.j[2] = 0.0f;
            this.f667b.a(1.0f, (float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        } else if (str2.contains("Boy/Animation_150.bin")) {
            Log.i("FXAnimationInterface : ", "Custom tuning is applied to " + str2);
            pVar2.c = 1.2f;
            pVar2.d = 0.28f;
            pVar2.e = -0.5f;
            pVar2.f = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            pVar2.g = 3.0f;
            pVar2.i[0] = -1.5f;
            pVar2.i[1] = -21.0f;
            pVar2.h = new float[26];
            pVar2.h[0] = 0.889333f;
            pVar2.h[1] = 0.0f;
            pVar2.h[2] = 0.6538292f;
            pVar2.h[3] = 0.0f;
            pVar2.h[4] = 0.7434853f;
            pVar2.h[5] = 0.0f;
            pVar2.h[6] = 0.8209944f;
            pVar2.h[7] = 0.0f;
            pVar2.h[8] = 0.7219918f;
            pVar2.h[9] = 0.0f;
            pVar2.h[10] = 0.0f;
            pVar2.h[11] = 0.0f;
            pVar2.h[12] = 0.54013515f;
            pVar2.h[13] = 0.0f;
            pVar2.h[14] = 0.13163035f;
            pVar2.h[15] = 0.0f;
            pVar2.h[16] = 0.13163035f;
            pVar2.h[17] = 0.0f;
            pVar2.h[18] = 0.13163035f;
            pVar2.h[19] = 0.0f;
            pVar2.h[20] = 0.13163035f;
            pVar2.h[21] = 0.0f;
            pVar2.h[22] = 0.3665184f;
            pVar2.h[23] = 0.0f;
            pVar2.h[24] = 0.3665184f;
            pVar2.h[25] = 0.0f;
            pVar2.j[0] = 0.0f;
            pVar2.j[1] = 0.0f;
            pVar2.j[2] = 0.0f;
            this.f667b.a(1.0f, (float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        } else if (str2.contains("Boy/Animation_160.bin")) {
            Log.i("FXAnimationInterface : ", "Custom tuning is applied to " + str2);
            pVar2.c = 1.0f;
            pVar2.d = 0.225f;
            pVar2.e = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            pVar2.f = 0.1f;
            pVar2.g = 2.0f;
            pVar2.i[0] = -1.0f;
            pVar2.i[1] = -10.0f;
            pVar2.h = new float[26];
            pVar2.h[0] = 0.7f;
            pVar2.h[1] = 0.0f;
            pVar2.h[2] = 0.705082f;
            pVar2.h[3] = 0.0f;
            pVar2.h[4] = 0.661184f;
            pVar2.h[5] = 0.0f;
            pVar2.h[6] = 0.145612f;
            pVar2.h[7] = 0.0f;
            pVar2.h[8] = 0.650056f;
            pVar2.h[9] = 0.2f;
            pVar2.h[10] = 0.0f;
            pVar2.h[11] = 0.0f;
            pVar2.h[12] = 0.54177f;
            pVar2.h[13] = 0.0f;
            pVar2.h[14] = 0.25873f;
            pVar2.h[15] = 0.071353f;
            pVar2.h[16] = 0.2f;
            pVar2.h[17] = 0.0f;
            pVar2.h[18] = 0.0f;
            pVar2.h[19] = 0.0f;
            pVar2.h[20] = 0.25f;
            pVar2.h[21] = 0.0f;
            pVar2.h[22] = 0.4f;
            pVar2.h[23] = 0.0f;
            pVar2.h[24] = 0.4f;
            pVar2.h[25] = 0.0f;
            pVar2.j[0] = 1.0f;
            pVar2.j[1] = 5.0f;
            pVar2.j[2] = 10.0f;
            this.f667b.a(1.0f, (float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        } else {
            pVar2.c = 2.1f;
            pVar2.d = 0.35f;
            pVar2.e = i4 == 0 ? 1.0f : GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            pVar2.f = i4 == 0 ? 1.0f : GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            pVar2.g = (i4 == 3 || i4 == 2) ? GlobalDefine.DEFAULT_AUTO_FILTER_VALUE : 1.0f;
            pVar2.i[0] = 0.0f;
            pVar2.i[1] = 0.0f;
            pVar2.h = null;
            pVar2.j[0] = 0.0f;
            pVar2.j[1] = 0.0f;
            pVar2.j[2] = 0.0f;
            this.f667b.a(1.0f, (float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        }
    }

    public boolean b(int i2, int i3) {
        if (this.f667b != null) {
            return this.f667b.b(i2, i3);
        }
        return false;
    }

    public void k() {
        k b2;
        if ((g() == h.e.AVATAR || g() == h.e.CHECK_CLOTHES_SIZE) && this.c != null && (b2 = this.f666a.b(h(), h.d.BODY)) != null) {
            if (this.c.a(b2, this.f666a.b(h(), h.d.PANTS), this.f666a.b(h(), h.d.INNER), this.f666a.b(h(), h.d.ONEPIECE), this.f666a.b(h(), h.d.JACK))) {
                this.c.a();
            } else {
                Log.i("FXAnimationInterface : ", "Draping solver is disabled (or failed to initialize)");
            }
        }
    }

    public void a(int i2, int i3, h.d dVar) {
        if (this.f666a != null) {
            this.f666a.a(i2, i3, dVar);
        }
    }

    public void a(qlSolver qlsolver) {
        this.c = qlsolver;
        if (this.f667b != null) {
            this.f667b.a(qlsolver);
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\b\b.java ==========

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




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\b\c.java ==========

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




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\b\d.java ==========

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




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\b\e.java ==========

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




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\b\f.java ==========

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




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\b\g.java ==========

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




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\b\h.java ==========

package net.fxgear.b;

/* compiled from: FXGlobal */
public class h {

    /* compiled from: FXGlobal */
    public enum a {
        NONE,
        MESH,
        SKELETON
    }

    /* compiled from: FXGlobal */
    public enum b {
        PART_NONE,
        LEFT_ARM,
        LEFT_SHOULDER_UPPER_ARM,
        LEFT_UPPER_ARM,
        LEFT_LOWER_ARM,
        LEFT_HAND,
        RIGHT_ARM,
        RIGHT_SHOULDER_UPPER_ARM,
        RIGHT_UPPER_ARM,
        RIGHT_LOWER_ARM,
        RIGHT_HAND,
        LEFT_LEG,
        RIGHT_LEG,
        NECK,
        UNDER_HIP_CENTER
    }

    /* compiled from: FXGlobal */
    public enum c {
        Color,
        Tension,
        Pressure
    }

    /* compiled from: FXGlobal */
    public enum d {
        NONE,
        BODY,
        JACK,
        INNER,
        PANTS,
        ONEPIECE,
        COAT,
        HEAD,
        HAIR,
        HAIR_ACC,
        SHOES,
        CAT
    }

    /* compiled from: FXGlobal */
    public enum e {
        NONE,
        AVATAR,
        AVATAR_CUSTOM_FACE_EDITING,
        AVATAR_FACE_EDITING,
        AVATAR_HAIR_EDITING,
        AVATAR_SKIN_TONE_EDITING,
        AVATAR_BODY_EDITING,
        REAL,
        CAPTURE,
        CHECK_CLOTHES_SIZE
    }

    /* compiled from: FXGlobal */
    public enum f {
        DISABLED,
        COLLISION_RESOLUTION,
        SIZE_SIMULATION
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\b\i.java ==========

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




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\b\j.java ==========

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




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\b\k.java ==========

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
                fArr2 = l.a(pVar, a2, this.J.y(), this.J.A(), this.f697b, this.I);
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




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\b\l.java ==========

package net.fxgear.b;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import net.fxgear.GlobalDefine;
import net.fxgear.b.h;

/* compiled from: FXNativeImporter */
public class l {

    /* compiled from: FXNativeImporter */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f699a;

        /* renamed from: b  reason: collision with root package name */
        public int f700b;
        public byte[] c;
        public byte[] d;
        public byte[] e;
        public byte[] f;
        public Bitmap g;
        public Bitmap h;
    }

    public static int a(int i) {
        switch (i) {
            case 0:
                return 66;
            case 1:
                return 61;
            case 2:
                return 89;
            case 3:
                return 75;
            case 4:
                return 71;
            case 5:
                return 24;
            case 6:
                return 26;
            case 7:
                return 27;
            case 8:
                return 70;
            case 9:
                return 0;
            case 10:
                return 2;
            case 11:
                return 3;
            case 12:
                return 68;
            case GlobalDefine.RESULT_CODE_ERROR_MALFORMEDURL:
                return 55;
            case 14:
                return 52;
            case GlobalDefine.RESULT_CODE_ERROR_OUT_OF_MEMORY:
                return 53;
            case GlobalDefine.RESULT_CODE_ERROR_NOT_FOUND_FILE:
                return 67;
            case GlobalDefine.RESULT_CODE_ERROR_FAILED_TO_SAVE_BITMAP:
                return 51;
            case GlobalDefine.RESULT_CODE_ERROR_FAILED_TO_DETECT:
                return 48;
            case GlobalDefine.RESULT_CODE_ERROR_FAILED_TO_DETECT_WITH_LOW_SCROE:
                return 49;
            case GlobalDefine.RESULT_CODE_ERROR_FAILED_TO_DETECT_ZERO_FACE:
                return 72;
            case 21:
                return -1;
            case 22:
                return -1;
            case 23:
                return -1;
            case 24:
                return -1;
            default:
                return -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0086 A[SYNTHETIC, Splitter:B:40:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x008b A[Catch:{ IOException -> 0x0049 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x009e A[SYNTHETIC, Splitter:B:50:0x009e] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a3 A[Catch:{ IOException -> 0x0049 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00b6 A[SYNTHETIC, Splitter:B:60:0x00b6] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00bb A[Catch:{ IOException -> 0x0049 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00ce A[SYNTHETIC, Splitter:B:70:0x00ce] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00d3 A[Catch:{ IOException -> 0x0049 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00da A[Catch:{ IOException -> 0x0049 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00df A[Catch:{ IOException -> 0x0049 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:47:0x0092=Splitter:B:47:0x0092, B:67:0x00c2=Splitter:B:67:0x00c2, B:37:0x007a=Splitter:B:37:0x007a, B:57:0x00aa=Splitter:B:57:0x00aa} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int[] a(java.lang.String r8) {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ FileNotFoundException -> 0x00bf, IOException -> 0x00a7, OutOfMemoryError -> 0x008f, Exception -> 0x0077, all -> 0x0073 }
            r1.<init>(r8)     // Catch:{ FileNotFoundException -> 0x00bf, IOException -> 0x00a7, OutOfMemoryError -> 0x008f, Exception -> 0x0077, all -> 0x0073 }
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x00bf, IOException -> 0x00a7, OutOfMemoryError -> 0x008f, Exception -> 0x0077, all -> 0x0073 }
            r8.<init>(r1)     // Catch:{ FileNotFoundException -> 0x00bf, IOException -> 0x00a7, OutOfMemoryError -> 0x008f, Exception -> 0x0077, all -> 0x0073 }
            java.nio.channels.FileChannel r2 = r8.getChannel()     // Catch:{ FileNotFoundException -> 0x0070, IOException -> 0x006d, OutOfMemoryError -> 0x006a, Exception -> 0x0067, all -> 0x0063 }
            long r3 = r1.length()     // Catch:{ FileNotFoundException -> 0x0060, IOException -> 0x005e, OutOfMemoryError -> 0x005c, Exception -> 0x005a }
            int r1 = (int) r3     // Catch:{ FileNotFoundException -> 0x0060, IOException -> 0x005e, OutOfMemoryError -> 0x005c, Exception -> 0x005a }
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocate(r1)     // Catch:{ FileNotFoundException -> 0x0060, IOException -> 0x005e, OutOfMemoryError -> 0x005c, Exception -> 0x005a }
            java.nio.ByteOrder r3 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ FileNotFoundException -> 0x0060, IOException -> 0x005e, OutOfMemoryError -> 0x005c, Exception -> 0x005a }
            r1.order(r3)     // Catch:{ FileNotFoundException -> 0x0060, IOException -> 0x005e, OutOfMemoryError -> 0x005c, Exception -> 0x005a }
            r2.read(r1)     // Catch:{ FileNotFoundException -> 0x0060, IOException -> 0x005e, OutOfMemoryError -> 0x005c, Exception -> 0x005a }
            r1.rewind()     // Catch:{ FileNotFoundException -> 0x0060, IOException -> 0x005e, OutOfMemoryError -> 0x005c, Exception -> 0x005a }
            int r3 = r1.getInt()     // Catch:{ FileNotFoundException -> 0x0060, IOException -> 0x005e, OutOfMemoryError -> 0x005c, Exception -> 0x005a }
            int[] r4 = new int[r3]     // Catch:{ FileNotFoundException -> 0x0060, IOException -> 0x005e, OutOfMemoryError -> 0x005c, Exception -> 0x005a }
            r5 = 0
        L_0x002a:
            if (r5 >= r3) goto L_0x0043
            int r6 = r1.getInt()     // Catch:{ FileNotFoundException -> 0x0060, IOException -> 0x005e, OutOfMemoryError -> 0x005c, Exception -> 0x005a }
            byte[] r6 = new byte[r6]     // Catch:{ FileNotFoundException -> 0x0060, IOException -> 0x005e, OutOfMemoryError -> 0x005c, Exception -> 0x005a }
            r1.get(r6)     // Catch:{ FileNotFoundException -> 0x0060, IOException -> 0x005e, OutOfMemoryError -> 0x005c, Exception -> 0x005a }
            java.lang.String r7 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x0060, IOException -> 0x005e, OutOfMemoryError -> 0x005c, Exception -> 0x005a }
            r7.<init>(r6)     // Catch:{ FileNotFoundException -> 0x0060, IOException -> 0x005e, OutOfMemoryError -> 0x005c, Exception -> 0x005a }
            int r6 = d(r7)     // Catch:{ FileNotFoundException -> 0x0060, IOException -> 0x005e, OutOfMemoryError -> 0x005c, Exception -> 0x005a }
            r4[r5] = r6     // Catch:{ FileNotFoundException -> 0x0060, IOException -> 0x005e, OutOfMemoryError -> 0x005c, Exception -> 0x005a }
            int r5 = r5 + 1
            goto L_0x002a
        L_0x0043:
            if (r2 == 0) goto L_0x004b
            r2.close()     // Catch:{ IOException -> 0x0049 }
            goto L_0x004b
        L_0x0049:
            r8 = move-exception
            goto L_0x004f
        L_0x004b:
            r8.close()     // Catch:{ IOException -> 0x0049 }
            return r4
        L_0x004f:
            r8.printStackTrace()
            java.lang.String r8 = "FXNativeImporter : "
            java.lang.String r1 = "BoneLoader - Load io xxception"
            android.util.Log.w(r8, r1)
            return r0
        L_0x005a:
            r1 = move-exception
            goto L_0x007a
        L_0x005c:
            r1 = move-exception
            goto L_0x0092
        L_0x005e:
            r1 = move-exception
            goto L_0x00aa
        L_0x0060:
            r1 = move-exception
            goto L_0x00c2
        L_0x0063:
            r1 = move-exception
            r2 = r0
            goto L_0x00d8
        L_0x0067:
            r1 = move-exception
            r2 = r0
            goto L_0x007a
        L_0x006a:
            r1 = move-exception
            r2 = r0
            goto L_0x0092
        L_0x006d:
            r1 = move-exception
            r2 = r0
            goto L_0x00aa
        L_0x0070:
            r1 = move-exception
            r2 = r0
            goto L_0x00c2
        L_0x0073:
            r1 = move-exception
            r8 = r0
            r2 = r8
            goto L_0x00d8
        L_0x0077:
            r1 = move-exception
            r8 = r0
            r2 = r8
        L_0x007a:
            r1.printStackTrace()     // Catch:{ all -> 0x00d7 }
            java.lang.String r1 = "FXNativeImporter : "
            java.lang.String r3 = "BoneLoader - Error unknow"
            android.util.Log.w(r1, r3)     // Catch:{ all -> 0x00d7 }
            if (r2 == 0) goto L_0x0089
            r2.close()     // Catch:{ IOException -> 0x0049 }
        L_0x0089:
            if (r8 == 0) goto L_0x008e
            r8.close()     // Catch:{ IOException -> 0x0049 }
        L_0x008e:
            return r0
        L_0x008f:
            r1 = move-exception
            r8 = r0
            r2 = r8
        L_0x0092:
            r1.printStackTrace()     // Catch:{ all -> 0x00d7 }
            java.lang.String r1 = "FXNativeImporter : "
            java.lang.String r3 = "BoneLoader - Out of memory"
            android.util.Log.w(r1, r3)     // Catch:{ all -> 0x00d7 }
            if (r2 == 0) goto L_0x00a1
            r2.close()     // Catch:{ IOException -> 0x0049 }
        L_0x00a1:
            if (r8 == 0) goto L_0x00a6
            r8.close()     // Catch:{ IOException -> 0x0049 }
        L_0x00a6:
            return r0
        L_0x00a7:
            r1 = move-exception
            r8 = r0
            r2 = r8
        L_0x00aa:
            r1.printStackTrace()     // Catch:{ all -> 0x00d7 }
            java.lang.String r1 = "FXNativeImporter : "
            java.lang.String r3 = "BoneLoader - Load io xxception"
            android.util.Log.w(r1, r3)     // Catch:{ all -> 0x00d7 }
            if (r2 == 0) goto L_0x00b9
            r2.close()     // Catch:{ IOException -> 0x0049 }
        L_0x00b9:
            if (r8 == 0) goto L_0x00be
            r8.close()     // Catch:{ IOException -> 0x0049 }
        L_0x00be:
            return r0
        L_0x00bf:
            r1 = move-exception
            r8 = r0
            r2 = r8
        L_0x00c2:
            r1.printStackTrace()     // Catch:{ all -> 0x00d7 }
            java.lang.String r1 = "FXNativeImporter : "
            java.lang.String r3 = "BoneLoader - File not found"
            android.util.Log.w(r1, r3)     // Catch:{ all -> 0x00d7 }
            if (r2 == 0) goto L_0x00d1
            r2.close()     // Catch:{ IOException -> 0x0049 }
        L_0x00d1:
            if (r8 == 0) goto L_0x00d6
            r8.close()     // Catch:{ IOException -> 0x0049 }
        L_0x00d6:
            return r0
        L_0x00d7:
            r1 = move-exception
        L_0x00d8:
            if (r2 == 0) goto L_0x00dd
            r2.close()     // Catch:{ IOException -> 0x0049 }
        L_0x00dd:
            if (r8 == 0) goto L_0x00e2
            r8.close()     // Catch:{ IOException -> 0x0049 }
        L_0x00e2:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.b.l.a(java.lang.String):int[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x008e A[SYNTHETIC, Splitter:B:42:0x008e] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0093 A[Catch:{ IOException -> 0x0051 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00a6 A[SYNTHETIC, Splitter:B:52:0x00a6] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ab A[Catch:{ IOException -> 0x0051 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00be A[SYNTHETIC, Splitter:B:62:0x00be] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00c3 A[Catch:{ IOException -> 0x0051 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00d6 A[SYNTHETIC, Splitter:B:72:0x00d6] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00db A[Catch:{ IOException -> 0x0051 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00e2 A[Catch:{ IOException -> 0x0051 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00e7 A[Catch:{ IOException -> 0x0051 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:39:0x0082=Splitter:B:39:0x0082, B:59:0x00b2=Splitter:B:59:0x00b2, B:49:0x009a=Splitter:B:49:0x009a, B:69:0x00ca=Splitter:B:69:0x00ca} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<java.lang.String> b(java.lang.String r8) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch:{ FileNotFoundException -> 0x00c7, IOException -> 0x00af, OutOfMemoryError -> 0x0097, Exception -> 0x007f, all -> 0x007b }
            r2.<init>(r8)     // Catch:{ FileNotFoundException -> 0x00c7, IOException -> 0x00af, OutOfMemoryError -> 0x0097, Exception -> 0x007f, all -> 0x007b }
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x00c7, IOException -> 0x00af, OutOfMemoryError -> 0x0097, Exception -> 0x007f, all -> 0x007b }
            r8.<init>(r2)     // Catch:{ FileNotFoundException -> 0x00c7, IOException -> 0x00af, OutOfMemoryError -> 0x0097, Exception -> 0x007f, all -> 0x007b }
            java.nio.channels.FileChannel r3 = r8.getChannel()     // Catch:{ FileNotFoundException -> 0x0078, IOException -> 0x0075, OutOfMemoryError -> 0x0072, Exception -> 0x006f, all -> 0x006b }
            long r4 = r2.length()     // Catch:{ FileNotFoundException -> 0x0068, IOException -> 0x0066, OutOfMemoryError -> 0x0064, Exception -> 0x0062 }
            int r2 = (int) r4     // Catch:{ FileNotFoundException -> 0x0068, IOException -> 0x0066, OutOfMemoryError -> 0x0064, Exception -> 0x0062 }
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r2)     // Catch:{ FileNotFoundException -> 0x0068, IOException -> 0x0066, OutOfMemoryError -> 0x0064, Exception -> 0x0062 }
            java.nio.ByteOrder r4 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ FileNotFoundException -> 0x0068, IOException -> 0x0066, OutOfMemoryError -> 0x0064, Exception -> 0x0062 }
            r2.order(r4)     // Catch:{ FileNotFoundException -> 0x0068, IOException -> 0x0066, OutOfMemoryError -> 0x0064, Exception -> 0x0062 }
            r3.read(r2)     // Catch:{ FileNotFoundException -> 0x0068, IOException -> 0x0066, OutOfMemoryError -> 0x0064, Exception -> 0x0062 }
            r2.rewind()     // Catch:{ FileNotFoundException -> 0x0068, IOException -> 0x0066, OutOfMemoryError -> 0x0064, Exception -> 0x0062 }
            int r4 = r2.getInt()     // Catch:{ FileNotFoundException -> 0x0068, IOException -> 0x0066, OutOfMemoryError -> 0x0064, Exception -> 0x0062 }
            r5 = 0
        L_0x002d:
            if (r5 >= r4) goto L_0x004b
            int r6 = r2.getInt()     // Catch:{ FileNotFoundException -> 0x0068, IOException -> 0x0066, OutOfMemoryError -> 0x0064, Exception -> 0x0062 }
            byte[] r6 = new byte[r6]     // Catch:{ FileNotFoundException -> 0x0068, IOException -> 0x0066, OutOfMemoryError -> 0x0064, Exception -> 0x0062 }
            r2.get(r6)     // Catch:{ FileNotFoundException -> 0x0068, IOException -> 0x0066, OutOfMemoryError -> 0x0064, Exception -> 0x0062 }
            java.lang.String r7 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x0068, IOException -> 0x0066, OutOfMemoryError -> 0x0064, Exception -> 0x0062 }
            r7.<init>(r6)     // Catch:{ FileNotFoundException -> 0x0068, IOException -> 0x0066, OutOfMemoryError -> 0x0064, Exception -> 0x0062 }
            java.lang.String r6 = "zHairAni"
            boolean r6 = r7.contains(r6)     // Catch:{ FileNotFoundException -> 0x0068, IOException -> 0x0066, OutOfMemoryError -> 0x0064, Exception -> 0x0062 }
            if (r6 == 0) goto L_0x0048
            r0.add(r7)     // Catch:{ FileNotFoundException -> 0x0068, IOException -> 0x0066, OutOfMemoryError -> 0x0064, Exception -> 0x0062 }
        L_0x0048:
            int r5 = r5 + 1
            goto L_0x002d
        L_0x004b:
            if (r3 == 0) goto L_0x0053
            r3.close()     // Catch:{ IOException -> 0x0051 }
            goto L_0x0053
        L_0x0051:
            r8 = move-exception
            goto L_0x0057
        L_0x0053:
            r8.close()     // Catch:{ IOException -> 0x0051 }
            return r0
        L_0x0057:
            r8.printStackTrace()
            java.lang.String r8 = "FXNativeImporter : "
            java.lang.String r0 = "BoneLoader - Load io xxception"
            android.util.Log.w(r8, r0)
            return r1
        L_0x0062:
            r0 = move-exception
            goto L_0x0082
        L_0x0064:
            r0 = move-exception
            goto L_0x009a
        L_0x0066:
            r0 = move-exception
            goto L_0x00b2
        L_0x0068:
            r0 = move-exception
            goto L_0x00ca
        L_0x006b:
            r0 = move-exception
            r3 = r1
            goto L_0x00e0
        L_0x006f:
            r0 = move-exception
            r3 = r1
            goto L_0x0082
        L_0x0072:
            r0 = move-exception
            r3 = r1
            goto L_0x009a
        L_0x0075:
            r0 = move-exception
            r3 = r1
            goto L_0x00b2
        L_0x0078:
            r0 = move-exception
            r3 = r1
            goto L_0x00ca
        L_0x007b:
            r0 = move-exception
            r8 = r1
            r3 = r8
            goto L_0x00e0
        L_0x007f:
            r0 = move-exception
            r8 = r1
            r3 = r8
        L_0x0082:
            r0.printStackTrace()     // Catch:{ all -> 0x00df }
            java.lang.String r0 = "FXNativeImporter : "
            java.lang.String r2 = "BoneLoader - Error unknow"
            android.util.Log.w(r0, r2)     // Catch:{ all -> 0x00df }
            if (r3 == 0) goto L_0x0091
            r3.close()     // Catch:{ IOException -> 0x0051 }
        L_0x0091:
            if (r8 == 0) goto L_0x0096
            r8.close()     // Catch:{ IOException -> 0x0051 }
        L_0x0096:
            return r1
        L_0x0097:
            r0 = move-exception
            r8 = r1
            r3 = r8
        L_0x009a:
            r0.printStackTrace()     // Catch:{ all -> 0x00df }
            java.lang.String r0 = "FXNativeImporter : "
            java.lang.String r2 = "BoneLoader - Out of memory"
            android.util.Log.w(r0, r2)     // Catch:{ all -> 0x00df }
            if (r3 == 0) goto L_0x00a9
            r3.close()     // Catch:{ IOException -> 0x0051 }
        L_0x00a9:
            if (r8 == 0) goto L_0x00ae
            r8.close()     // Catch:{ IOException -> 0x0051 }
        L_0x00ae:
            return r1
        L_0x00af:
            r0 = move-exception
            r8 = r1
            r3 = r8
        L_0x00b2:
            r0.printStackTrace()     // Catch:{ all -> 0x00df }
            java.lang.String r0 = "FXNativeImporter : "
            java.lang.String r2 = "BoneLoader - Load io xxception"
            android.util.Log.w(r0, r2)     // Catch:{ all -> 0x00df }
            if (r3 == 0) goto L_0x00c1
            r3.close()     // Catch:{ IOException -> 0x0051 }
        L_0x00c1:
            if (r8 == 0) goto L_0x00c6
            r8.close()     // Catch:{ IOException -> 0x0051 }
        L_0x00c6:
            return r1
        L_0x00c7:
            r0 = move-exception
            r8 = r1
            r3 = r8
        L_0x00ca:
            r0.printStackTrace()     // Catch:{ all -> 0x00df }
            java.lang.String r0 = "FXNativeImporter : "
            java.lang.String r2 = "BoneLoader - File not found"
            android.util.Log.w(r0, r2)     // Catch:{ all -> 0x00df }
            if (r3 == 0) goto L_0x00d9
            r3.close()     // Catch:{ IOException -> 0x0051 }
        L_0x00d9:
            if (r8 == 0) goto L_0x00de
            r8.close()     // Catch:{ IOException -> 0x0051 }
        L_0x00de:
            return r1
        L_0x00df:
            r0 = move-exception
        L_0x00e0:
            if (r3 == 0) goto L_0x00e5
            r3.close()     // Catch:{ IOException -> 0x0051 }
        L_0x00e5:
            if (r8 == 0) goto L_0x00ea
            r8.close()     // Catch:{ IOException -> 0x0051 }
        L_0x00ea:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.b.l.b(java.lang.String):java.util.ArrayList");
    }

    public static p a(String str, String str2, int i, int[] iArr) {
        p pVar = new p();
        ArrayList arrayList = new ArrayList();
        i iVar = new i();
        for (int i2 = 0; i2 < iArr.length; i2++) {
            arrayList.add(iVar);
        }
        a((ArrayList<i>) arrayList, str, iArr);
        b(arrayList, str2, iArr);
        pVar.b((ArrayList<i>) arrayList);
        pVar.c(i);
        return pVar;
    }

    public static p a(String str, String str2, int i, ArrayList<String> arrayList) {
        p pVar = new p();
        ArrayList arrayList2 = new ArrayList();
        i iVar = new i();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.add(iVar);
        }
        a((ArrayList<i>) arrayList2, str, str2, arrayList);
        pVar.b((ArrayList<i>) arrayList2);
        pVar.c(i);
        return pVar;
    }

    public static d a(String str, int i, p pVar, boolean z) {
        d dVar = new d();
        a(dVar, str, i, pVar, z);
        return dVar;
    }

    public static k a(ArrayList<i> arrayList, String str, p pVar, int[] iArr, float[] fArr, short[] sArr, float[] fArr2, Bitmap bitmap, h.d dVar) {
        k kVar = new k();
        a(kVar, arrayList, str, pVar, iArr, fArr, sArr, fArr2, bitmap, dVar);
        return kVar;
    }

    public static f c(String str) {
        f fVar = new f();
        a(fVar, str);
        return fVar;
    }

    public static f a(String str, int[] iArr) {
        f fVar = new f();
        if (iArr == null) {
            Log.e("FXNativeImporter : ", "Converting Table is required when loading bone blend targets. convertingTable : " + iArr);
        }
        a(fVar, str, iArr);
        return fVar;
    }

    public static Bitmap a(Bitmap bitmap) {
        Bitmap.Config config;
        if (bitmap == null || (config = bitmap.getConfig()) == Bitmap.Config.RGB_565 || config == Bitmap.Config.ARGB_4444 || config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.ALPHA_8) {
            return bitmap;
        }
        Log.i("FXNativeImporter : ", "[c] CheckBitmapNConvert convert " + config);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawBitmap(bitmap, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, new Paint());
        bitmap.recycle();
        return createBitmap;
    }

    public static Bitmap a(String str, int i) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = a(options, i);
        options.inJustDecodeBounds = false;
        options.inScaled = true;
        options.inPreferQualityOverSpeed = true;
        return a(BitmapFactory.decodeFile(str, options));
    }

    private static int a(BitmapFactory.Options options, int i) {
        int max = Math.max(options.outWidth, options.outHeight);
        int i2 = 1;
        if (max > i) {
            while (i < max / i2) {
                i2 *= 2;
            }
        }
        Log.i("FXNativeImporter : ", "calculateInSampleSize : " + i2);
        return i2;
    }

    public static a b(String str, int i) {
        GLES20.glGenTextures(1, new int[1], 0);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferQualityOverSpeed = true;
        options.inScaled = true;
        options.inSampleSize = 1;
        a e = e(str);
        e.g = BitmapFactory.decodeByteArray(e.d, 0, e.d.length, options);
        int max = Math.max(e.g.getWidth(), e.g.getHeight());
        if (max > i) {
            int i2 = 2;
            while (i < max / i2) {
                i2 *= 2;
            }
            e.g.recycle();
            e.g = null;
            options.inScaled = true;
            options.inSampleSize = i2;
            Log.i("FXNativeImporter : ", "SamplingRate is modified to : " + i2);
            e.g = BitmapFactory.decodeByteArray(e.d, 0, e.d.length, options);
        }
        if (e.e != null) {
            e.h = BitmapFactory.decodeByteArray(e.e, 0, e.e.length, options);
            if (!(e.g.getWidth() == e.h.getWidth() && e.g.getHeight() == e.h.getHeight())) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(e.h, e.g.getWidth(), e.g.getHeight(), false);
                e.h.recycle();
                e.h = null;
                e.h = createScaledBitmap;
            }
        }
        return e;
    }

    public static int a(Bitmap bitmap, int i) {
        int max = Math.max(bitmap.getWidth(), bitmap.getHeight());
        if (max > i) {
            int i2 = 2;
            while (i < max / i2) {
                i2 *= 2;
            }
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / i2, bitmap.getHeight() / i2, false);
            bitmap.recycle();
            bitmap = createScaledBitmap;
        }
        Bitmap a2 = a(bitmap);
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameteri(3553, 10240, 9728);
        GLUtils.texImage2D(3553, 0, a2, 0);
        GLES20.glBindTexture(3553, 0);
        Log.i("FXNativeImporter : ", "Texture is generated : " + iArr[0]);
        return iArr[0];
    }

    public static int a() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameterf(36197, 10241, 9729.0f);
        GLES20.glTexParameterf(36197, 10240, 9729.0f);
        if (iArr[0] >= 0) {
            return iArr[0];
        }
        Log.e("FXNativeImporter : ", "Generating video texture is failed");
        return -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:112:? A[Catch:{ IOException -> 0x014c }, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0186 A[SYNTHETIC, Splitter:B:59:0x0186] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x018b A[Catch:{ IOException -> 0x014c }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x019d A[SYNTHETIC, Splitter:B:68:0x019d] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x01a2 A[Catch:{ IOException -> 0x014c }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01b4 A[SYNTHETIC, Splitter:B:77:0x01b4] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01b9 A[Catch:{ IOException -> 0x014c }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01cb A[SYNTHETIC, Splitter:B:86:0x01cb] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01d0 A[Catch:{ IOException -> 0x014c }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01d8 A[Catch:{ IOException -> 0x014c }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01dd A[Catch:{ IOException -> 0x014c }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:65:0x0191=Splitter:B:65:0x0191, B:74:0x01a8=Splitter:B:74:0x01a8, B:56:0x017a=Splitter:B:56:0x017a, B:83:0x01bf=Splitter:B:83:0x01bf} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.util.ArrayList<net.fxgear.b.i> r11, java.lang.String r12, int[] r13) {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ FileNotFoundException -> 0x01bd, IOException -> 0x01a6, OutOfMemoryError -> 0x018f, Exception -> 0x0178, all -> 0x0174 }
            r1.<init>(r12)     // Catch:{ FileNotFoundException -> 0x01bd, IOException -> 0x01a6, OutOfMemoryError -> 0x018f, Exception -> 0x0178, all -> 0x0174 }
            java.io.FileInputStream r12 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x01bd, IOException -> 0x01a6, OutOfMemoryError -> 0x018f, Exception -> 0x0178, all -> 0x0174 }
            r12.<init>(r1)     // Catch:{ FileNotFoundException -> 0x01bd, IOException -> 0x01a6, OutOfMemoryError -> 0x018f, Exception -> 0x0178, all -> 0x0174 }
            java.nio.channels.FileChannel r2 = r12.getChannel()     // Catch:{ FileNotFoundException -> 0x0172, IOException -> 0x0170, OutOfMemoryError -> 0x016e, Exception -> 0x016c }
            long r0 = r1.length()     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            int r0 = (int) r0     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.allocate(r0)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            java.nio.ByteOrder r1 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r0.order(r1)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r2.read(r0)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r0.rewind()     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            int r1 = r0.getInt()     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r3 = 0
            r4 = 0
        L_0x0029:
            if (r4 >= r1) goto L_0x0049
            r5 = r13[r4]     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            net.fxgear.b.i r6 = new net.fxgear.b.i     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r6.<init>()     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            int r7 = r0.getInt()     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            byte[] r7 = new byte[r7]     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r0.get(r7)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            java.lang.String r8 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r8.<init>(r7)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r6.a((java.lang.String) r8)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r11.set(r5, r6)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            int r4 = r4 + 1
            goto L_0x0029
        L_0x0049:
            r4 = 0
        L_0x004a:
            if (r4 >= r1) goto L_0x008f
            r5 = r13[r4]     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            int r6 = r0.getInt()     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            byte[] r6 = new byte[r6]     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r0.get(r6)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            java.lang.String r7 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r7.<init>(r6)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            int r6 = a((java.util.ArrayList<net.fxgear.b.i>) r11, (java.lang.String) r7)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            java.lang.Object r7 = r11.get(r5)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            net.fxgear.b.i r7 = (net.fxgear.b.i) r7     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r7.a((int) r6)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r7 = -1
            if (r6 == r7) goto L_0x0076
            java.lang.Object r6 = r11.get(r6)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            net.fxgear.b.i r6 = (net.fxgear.b.i) r6     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r6.b((int) r5)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            goto L_0x008c
        L_0x0076:
            java.lang.String r6 = "FXNativeImporter : "
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r7.<init>()     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            java.lang.String r8 = "Find Root : "
            r7.append(r8)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r7.append(r5)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            java.lang.String r5 = r7.toString()     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            android.util.Log.i(r6, r5)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
        L_0x008c:
            int r4 = r4 + 1
            goto L_0x004a
        L_0x008f:
            r4 = 0
        L_0x0090:
            r5 = 2
            r6 = 3
            r7 = 1
            if (r4 >= r1) goto L_0x00c4
            r8 = r13[r4]     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            float[] r6 = new float[r6]     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            float r9 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r6[r3] = r9     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            float r9 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r6[r7] = r9     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            float r7 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r6[r5] = r7     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            java.lang.Object r5 = r11.get(r8)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            net.fxgear.b.i r5 = (net.fxgear.b.i) r5     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r5.b((float[]) r6)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            net.fxgear.b.q r5 = a((float[]) r6)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            java.lang.Object r6 = r11.get(r8)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            net.fxgear.b.i r6 = (net.fxgear.b.i) r6     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r6.b((net.fxgear.b.q) r5)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            int r4 = r4 + 1
            goto L_0x0090
        L_0x00c4:
            r4 = 0
        L_0x00c5:
            if (r4 >= r1) goto L_0x00e9
            r8 = r13[r4]     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            float[] r9 = new float[r6]     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            float r10 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r9[r3] = r10     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            float r10 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r9[r7] = r10     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            float r10 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r9[r5] = r10     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            java.lang.Object r8 = r11.get(r8)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            net.fxgear.b.i r8 = (net.fxgear.b.i) r8     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r8.c((float[]) r9)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            int r4 = r4 + 1
            goto L_0x00c5
        L_0x00e9:
            r4 = 0
        L_0x00ea:
            if (r4 >= r1) goto L_0x011b
            r8 = r13[r4]     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            float[] r9 = new float[r6]     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            float r10 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r9[r3] = r10     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            float r10 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r9[r7] = r10     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            float r10 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r9[r5] = r10     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            java.lang.Object r10 = r11.get(r8)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            net.fxgear.b.i r10 = (net.fxgear.b.i) r10     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r10.a((float[]) r9)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            net.fxgear.b.q r9 = a((float[]) r9)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            java.lang.Object r8 = r11.get(r8)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            net.fxgear.b.i r8 = (net.fxgear.b.i) r8     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r8.a((net.fxgear.b.q) r9)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            int r4 = r4 + 1
            goto L_0x00ea
        L_0x011b:
            r4 = 0
        L_0x011c:
            if (r4 >= r1) goto L_0x0146
            r8 = r13[r4]     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            float[] r9 = new float[r6]     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            float r10 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r9[r3] = r10     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            float r10 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r9[r7] = r10     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            float r10 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r9[r5] = r10     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            java.lang.Object r8 = r11.get(r8)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            net.fxgear.b.i r8 = (net.fxgear.b.i) r8     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            java.lang.Object r9 = r9.clone()     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            float[] r9 = (float[]) r9     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            r8.d((float[]) r9)     // Catch:{ FileNotFoundException -> 0x0169, IOException -> 0x0166, OutOfMemoryError -> 0x0163, Exception -> 0x0160, all -> 0x015d }
            int r4 = r4 + 1
            goto L_0x011c
        L_0x0146:
            if (r2 == 0) goto L_0x014e
            r2.close()     // Catch:{ IOException -> 0x014c }
            goto L_0x014e
        L_0x014c:
            r11 = move-exception
            goto L_0x0152
        L_0x014e:
            r12.close()     // Catch:{ IOException -> 0x014c }
            return
        L_0x0152:
            r11.printStackTrace()
            java.lang.String r11 = "FXNativeImporter : "
            java.lang.String r12 = "BoneLoader - Load io xxception"
            android.util.Log.w(r11, r12)
            return
        L_0x015d:
            r11 = move-exception
            goto L_0x01d6
        L_0x0160:
            r11 = move-exception
            r0 = r2
            goto L_0x017a
        L_0x0163:
            r11 = move-exception
            r0 = r2
            goto L_0x0191
        L_0x0166:
            r11 = move-exception
            r0 = r2
            goto L_0x01a8
        L_0x0169:
            r11 = move-exception
            r0 = r2
            goto L_0x01bf
        L_0x016c:
            r11 = move-exception
            goto L_0x017a
        L_0x016e:
            r11 = move-exception
            goto L_0x0191
        L_0x0170:
            r11 = move-exception
            goto L_0x01a8
        L_0x0172:
            r11 = move-exception
            goto L_0x01bf
        L_0x0174:
            r11 = move-exception
            r12 = r0
            r2 = r12
            goto L_0x01d6
        L_0x0178:
            r11 = move-exception
            r12 = r0
        L_0x017a:
            r11.printStackTrace()     // Catch:{ all -> 0x01d4 }
            java.lang.String r11 = "FXNativeImporter : "
            java.lang.String r13 = "BoneLoader - Error unknow"
            android.util.Log.w(r11, r13)     // Catch:{ all -> 0x01d4 }
            if (r0 == 0) goto L_0x0189
            r0.close()     // Catch:{ IOException -> 0x014c }
        L_0x0189:
            if (r12 == 0) goto L_0x018e
            r12.close()     // Catch:{ IOException -> 0x014c }
        L_0x018e:
            return
        L_0x018f:
            r11 = move-exception
            r12 = r0
        L_0x0191:
            r11.printStackTrace()     // Catch:{ all -> 0x01d4 }
            java.lang.String r11 = "FXNativeImporter : "
            java.lang.String r13 = "BoneLoader - Out of memory"
            android.util.Log.w(r11, r13)     // Catch:{ all -> 0x01d4 }
            if (r0 == 0) goto L_0x01a0
            r0.close()     // Catch:{ IOException -> 0x014c }
        L_0x01a0:
            if (r12 == 0) goto L_0x01a5
            r12.close()     // Catch:{ IOException -> 0x014c }
        L_0x01a5:
            return
        L_0x01a6:
            r11 = move-exception
            r12 = r0
        L_0x01a8:
            r11.printStackTrace()     // Catch:{ all -> 0x01d4 }
            java.lang.String r11 = "FXNativeImporter : "
            java.lang.String r13 = "BoneLoader - Load io xxception"
            android.util.Log.w(r11, r13)     // Catch:{ all -> 0x01d4 }
            if (r0 == 0) goto L_0x01b7
            r0.close()     // Catch:{ IOException -> 0x014c }
        L_0x01b7:
            if (r12 == 0) goto L_0x01bc
            r12.close()     // Catch:{ IOException -> 0x014c }
        L_0x01bc:
            return
        L_0x01bd:
            r11 = move-exception
            r12 = r0
        L_0x01bf:
            r11.printStackTrace()     // Catch:{ all -> 0x01d4 }
            java.lang.String r11 = "FXNativeImporter : "
            java.lang.String r13 = "BoneLoader - File not found"
            android.util.Log.w(r11, r13)     // Catch:{ all -> 0x01d4 }
            if (r0 == 0) goto L_0x01ce
            r0.close()     // Catch:{ IOException -> 0x014c }
        L_0x01ce:
            if (r12 == 0) goto L_0x01d3
            r12.close()     // Catch:{ IOException -> 0x014c }
        L_0x01d3:
            return
        L_0x01d4:
            r11 = move-exception
            r2 = r0
        L_0x01d6:
            if (r2 == 0) goto L_0x01db
            r2.close()     // Catch:{ IOException -> 0x014c }
        L_0x01db:
            if (r12 == 0) goto L_0x01e0
            r12.close()     // Catch:{ IOException -> 0x014c }
        L_0x01e0:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.b.l.a(java.util.ArrayList, java.lang.String, int[]):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v25, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v38, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v39, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v40, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v41, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v43, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v53, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v54, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v55, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r24v56, resolved type: java.io.FileInputStream} */
    /* JADX WARNING: type inference failed for: r24v0, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r24v3, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r24v4 */
    /* JADX WARNING: type inference failed for: r24v5, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r24v6 */
    /* JADX WARNING: type inference failed for: r24v7, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r24v8 */
    /* JADX WARNING: type inference failed for: r24v9, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r24v10 */
    /* JADX WARNING: type inference failed for: r24v11 */
    /* JADX WARNING: type inference failed for: r24v20 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x041c A[SYNTHETIC, Splitter:B:174:0x041c] */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0421 A[Catch:{ IOException -> 0x0373 }] */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0426 A[Catch:{ IOException -> 0x0373 }] */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x042b A[Catch:{ IOException -> 0x0373 }] */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x0441 A[SYNTHETIC, Splitter:B:188:0x0441] */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x0446 A[Catch:{ IOException -> 0x0373 }] */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x044b A[Catch:{ IOException -> 0x0373 }] */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x0450 A[Catch:{ IOException -> 0x0373 }] */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x0466 A[SYNTHETIC, Splitter:B:202:0x0466] */
    /* JADX WARNING: Removed duplicated region for block: B:205:0x046b A[Catch:{ IOException -> 0x0373 }] */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x0470 A[Catch:{ IOException -> 0x0373 }] */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x0475 A[Catch:{ IOException -> 0x0373 }] */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x048b A[SYNTHETIC, Splitter:B:216:0x048b] */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x0490 A[Catch:{ IOException -> 0x0373 }] */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x0495 A[Catch:{ IOException -> 0x0373 }] */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x049a A[Catch:{ IOException -> 0x0373 }] */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x04a4 A[Catch:{ IOException -> 0x0373 }] */
    /* JADX WARNING: Removed duplicated region for block: B:230:0x04a9 A[Catch:{ IOException -> 0x0373 }] */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x04ae A[Catch:{ IOException -> 0x0373 }] */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x04b3 A[Catch:{ IOException -> 0x0373 }] */
    /* JADX WARNING: Removed duplicated region for block: B:267:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:269:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:271:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:273:? A[Catch:{ IOException -> 0x0373 }, RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:171:0x0410=Splitter:B:171:0x0410, B:185:0x0435=Splitter:B:185:0x0435, B:199:0x045a=Splitter:B:199:0x045a, B:213:0x047f=Splitter:B:213:0x047f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.util.ArrayList<net.fxgear.b.i> r30, java.lang.String r31, java.lang.String r32, java.util.ArrayList<java.lang.String> r33) {
        /*
            r1 = r30
            r2 = 0
            java.io.File r3 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0479, IOException -> 0x0454, OutOfMemoryError -> 0x042f, Exception -> 0x040a, all -> 0x0402 }
            r4 = r31
            r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0479, IOException -> 0x0454, OutOfMemoryError -> 0x042f, Exception -> 0x040a, all -> 0x0402 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0479, IOException -> 0x0454, OutOfMemoryError -> 0x042f, Exception -> 0x040a, all -> 0x0402 }
            r4.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0479, IOException -> 0x0454, OutOfMemoryError -> 0x042f, Exception -> 0x040a, all -> 0x0402 }
            java.nio.channels.FileChannel r5 = r4.getChannel()     // Catch:{ FileNotFoundException -> 0x03fd, IOException -> 0x03f8, OutOfMemoryError -> 0x03f4, Exception -> 0x03f0, all -> 0x03ec }
            long r6 = r3.length()     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            int r3 = (int) r6     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r3)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            java.nio.ByteOrder r6 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            r3.order(r6)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            r5.read(r3)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            r3.rewind()     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            int r6 = r3.getInt()     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            r7.<init>()     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            r8 = 0
            r9 = 0
            r10 = 0
        L_0x0033:
            if (r9 >= r6) goto L_0x005e
            int r11 = r3.getInt()     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            byte[] r11 = new byte[r11]     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            r3.get(r11)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            java.lang.String r12 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            r12.<init>(r11)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            r7.add(r12)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            java.lang.String r11 = "zHairAni"
            boolean r11 = r12.contains(r11)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            if (r11 == 0) goto L_0x005b
            net.fxgear.b.i r11 = new net.fxgear.b.i     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            r11.<init>()     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            r11.a((java.lang.String) r12)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            r1.set(r10, r11)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            int r10 = r10 + 1
        L_0x005b:
            int r9 = r9 + 1
            goto L_0x0033
        L_0x005e:
            r9 = 0
        L_0x005f:
            if (r9 >= r6) goto L_0x00ba
            int r10 = r3.getInt()     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            byte[] r10 = new byte[r10]     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            r3.get(r10)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            java.lang.String r11 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            r11.<init>(r10)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            java.lang.Object r10 = r7.get(r9)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            java.lang.String r12 = "zHairAni"
            boolean r10 = r10.contains(r12)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            if (r10 == 0) goto L_0x00b7
            java.lang.Object r10 = r7.get(r9)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            int r10 = a((java.util.ArrayList<net.fxgear.b.i>) r1, (java.lang.String) r10)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            int r11 = a((java.util.ArrayList<net.fxgear.b.i>) r1, (java.lang.String) r11)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            java.lang.Object r12 = r1.get(r10)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            net.fxgear.b.i r12 = (net.fxgear.b.i) r12     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            r12.a((int) r11)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            r12 = -1
            if (r11 == r12) goto L_0x00a1
            java.lang.Object r11 = r1.get(r11)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            net.fxgear.b.i r11 = (net.fxgear.b.i) r11     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            r11.b((int) r10)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            goto L_0x00b7
        L_0x00a1:
            java.lang.String r11 = "FXNativeImporter : "
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            r12.<init>()     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            java.lang.String r13 = "Find Root : "
            r12.append(r13)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            r12.append(r10)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            java.lang.String r10 = r12.toString()     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            android.util.Log.i(r11, r10)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
        L_0x00b7:
            int r9 = r9 + 1
            goto L_0x005f
        L_0x00ba:
            r9 = 0
        L_0x00bb:
            r10 = 2
            r11 = 3
            r12 = 1
            if (r9 >= r6) goto L_0x0105
            float[] r11 = new float[r11]     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            float r13 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            r11[r8] = r13     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            float r13 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            r11[r12] = r13     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            float r12 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            r11[r10] = r12     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            java.lang.Object r10 = r7.get(r9)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            java.lang.String r12 = "zHairAni"
            boolean r10 = r10.contains(r12)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            if (r10 == 0) goto L_0x0102
            java.lang.Object r10 = r7.get(r9)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            int r10 = a((java.util.ArrayList<net.fxgear.b.i>) r1, (java.lang.String) r10)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            java.lang.Object r12 = r1.get(r10)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            net.fxgear.b.i r12 = (net.fxgear.b.i) r12     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            r12.b((float[]) r11)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            net.fxgear.b.q r11 = a((float[]) r11)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            java.lang.Object r10 = r1.get(r10)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            net.fxgear.b.i r10 = (net.fxgear.b.i) r10     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            r10.b((net.fxgear.b.q) r11)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
        L_0x0102:
            int r9 = r9 + 1
            goto L_0x00bb
        L_0x0105:
            r9 = 0
        L_0x0106:
            if (r9 >= r6) goto L_0x0140
            float[] r13 = new float[r11]     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            float r14 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            r13[r8] = r14     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            float r14 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            r13[r12] = r14     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            float r14 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            r13[r10] = r14     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            java.lang.Object r14 = r7.get(r9)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            java.lang.String r15 = "zHairAni"
            boolean r14 = r14.contains(r15)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            if (r14 == 0) goto L_0x013d
            java.lang.Object r14 = r7.get(r9)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            int r14 = a((java.util.ArrayList<net.fxgear.b.i>) r1, (java.lang.String) r14)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            java.lang.Object r14 = r1.get(r14)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            net.fxgear.b.i r14 = (net.fxgear.b.i) r14     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            r14.c((float[]) r13)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
        L_0x013d:
            int r9 = r9 + 1
            goto L_0x0106
        L_0x0140:
            r9 = 0
        L_0x0141:
            if (r9 >= r6) goto L_0x0188
            float[] r13 = new float[r11]     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            float r14 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            r13[r8] = r14     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            float r14 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            r13[r12] = r14     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            float r14 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            r13[r10] = r14     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            java.lang.Object r14 = r7.get(r9)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            java.lang.String r15 = "zHairAni"
            boolean r14 = r14.contains(r15)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            if (r14 == 0) goto L_0x0185
            java.lang.Object r14 = r7.get(r9)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            int r14 = a((java.util.ArrayList<net.fxgear.b.i>) r1, (java.lang.String) r14)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            java.lang.Object r15 = r1.get(r14)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            net.fxgear.b.i r15 = (net.fxgear.b.i) r15     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            r15.a((float[]) r13)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            net.fxgear.b.q r13 = a((float[]) r13)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            java.lang.Object r14 = r1.get(r14)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            net.fxgear.b.i r14 = (net.fxgear.b.i) r14     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            r14.a((net.fxgear.b.q) r13)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
        L_0x0185:
            int r9 = r9 + 1
            goto L_0x0141
        L_0x0188:
            r9 = 0
        L_0x0189:
            if (r9 >= r6) goto L_0x01c9
            float[] r13 = new float[r11]     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            float r14 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            r13[r8] = r14     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            float r14 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            r13[r12] = r14     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            float r14 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            r13[r10] = r14     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            java.lang.Object r14 = r7.get(r9)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            java.lang.String r15 = "zHairAni"
            boolean r14 = r14.contains(r15)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            if (r14 == 0) goto L_0x01c6
            java.lang.Object r14 = r7.get(r9)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            java.lang.String r14 = (java.lang.String) r14     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            int r14 = a((java.util.ArrayList<net.fxgear.b.i>) r1, (java.lang.String) r14)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            java.lang.Object r14 = r1.get(r14)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            net.fxgear.b.i r14 = (net.fxgear.b.i) r14     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            java.lang.Object r13 = r13.clone()     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            float[] r13 = (float[]) r13     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            r14.d((float[]) r13)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
        L_0x01c6:
            int r9 = r9 + 1
            goto L_0x0189
        L_0x01c9:
            java.io.File r3 = new java.io.File     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            r6 = r32
            r3.<init>(r6)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            r6.<init>(r3)     // Catch:{ FileNotFoundException -> 0x03e4, IOException -> 0x03dc, OutOfMemoryError -> 0x03d4, Exception -> 0x03cc, all -> 0x03c6 }
            java.nio.channels.FileChannel r9 = r6.getChannel()     // Catch:{ FileNotFoundException -> 0x03c0, IOException -> 0x03ba, OutOfMemoryError -> 0x03b4, Exception -> 0x03ae, all -> 0x03a8 }
            long r2 = r3.length()     // Catch:{ FileNotFoundException -> 0x03a2, IOException -> 0x039d, OutOfMemoryError -> 0x0398, Exception -> 0x0393, all -> 0x038d }
            int r2 = (int) r2     // Catch:{ FileNotFoundException -> 0x03a2, IOException -> 0x039d, OutOfMemoryError -> 0x0398, Exception -> 0x0393, all -> 0x038d }
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r2)     // Catch:{ FileNotFoundException -> 0x03a2, IOException -> 0x039d, OutOfMemoryError -> 0x0398, Exception -> 0x0393, all -> 0x038d }
            java.nio.ByteOrder r3 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ FileNotFoundException -> 0x03a2, IOException -> 0x039d, OutOfMemoryError -> 0x0398, Exception -> 0x0393, all -> 0x038d }
            r2.order(r3)     // Catch:{ FileNotFoundException -> 0x03a2, IOException -> 0x039d, OutOfMemoryError -> 0x0398, Exception -> 0x0393, all -> 0x038d }
            r9.read(r2)     // Catch:{ FileNotFoundException -> 0x03a2, IOException -> 0x039d, OutOfMemoryError -> 0x0398, Exception -> 0x0393, all -> 0x038d }
            r2.rewind()     // Catch:{ FileNotFoundException -> 0x03a2, IOException -> 0x039d, OutOfMemoryError -> 0x0398, Exception -> 0x0393, all -> 0x038d }
            int r3 = r2.getInt()     // Catch:{ FileNotFoundException -> 0x03a2, IOException -> 0x039d, OutOfMemoryError -> 0x0398, Exception -> 0x0393, all -> 0x038d }
            int r13 = r2.getInt()     // Catch:{ FileNotFoundException -> 0x03a2, IOException -> 0x039d, OutOfMemoryError -> 0x0398, Exception -> 0x0393, all -> 0x038d }
            float[] r14 = new float[r13]     // Catch:{ FileNotFoundException -> 0x03a2, IOException -> 0x039d, OutOfMemoryError -> 0x0398, Exception -> 0x0393, all -> 0x038d }
            int r15 = r13 * r3
            int r15 = r15 * 3
            float[] r10 = new float[r15]     // Catch:{ FileNotFoundException -> 0x03a2, IOException -> 0x039d, OutOfMemoryError -> 0x0398, Exception -> 0x0393, all -> 0x038d }
            float[] r12 = new float[r15]     // Catch:{ FileNotFoundException -> 0x03a2, IOException -> 0x039d, OutOfMemoryError -> 0x0398, Exception -> 0x0393, all -> 0x038d }
            float[] r15 = new float[r15]     // Catch:{ FileNotFoundException -> 0x03a2, IOException -> 0x039d, OutOfMemoryError -> 0x0398, Exception -> 0x0393, all -> 0x038d }
        L_0x0201:
            if (r8 >= r13) goto L_0x022e
            float r19 = r2.getFloat()     // Catch:{ FileNotFoundException -> 0x0227, IOException -> 0x0220, OutOfMemoryError -> 0x0219, Exception -> 0x0212, all -> 0x020c }
            r14[r8] = r19     // Catch:{ FileNotFoundException -> 0x0227, IOException -> 0x0220, OutOfMemoryError -> 0x0219, Exception -> 0x0212, all -> 0x020c }
            int r8 = r8 + 1
            goto L_0x0201
        L_0x020c:
            r0 = move-exception
            r1 = r0
            r24 = r6
            goto L_0x04a1
        L_0x0212:
            r0 = move-exception
            r1 = r0
            r2 = r5
            r24 = r6
            goto L_0x0410
        L_0x0219:
            r0 = move-exception
            r1 = r0
            r2 = r5
            r24 = r6
            goto L_0x0435
        L_0x0220:
            r0 = move-exception
            r1 = r0
            r2 = r5
            r24 = r6
            goto L_0x045a
        L_0x0227:
            r0 = move-exception
            r1 = r0
            r2 = r5
            r24 = r6
            goto L_0x047f
        L_0x022e:
            r8 = 0
        L_0x022f:
            if (r8 >= r13) goto L_0x025b
            int r19 = r8 * r3
            int r19 = r19 * 3
            r11 = 0
        L_0x0236:
            if (r11 >= r3) goto L_0x0257
            int r21 = r11 * 3
            int r21 = r19 + r21
            int r22 = r21 + 0
            float r23 = r2.getFloat()     // Catch:{ FileNotFoundException -> 0x0227, IOException -> 0x0220, OutOfMemoryError -> 0x0219, Exception -> 0x0212, all -> 0x020c }
            r15[r22] = r23     // Catch:{ FileNotFoundException -> 0x0227, IOException -> 0x0220, OutOfMemoryError -> 0x0219, Exception -> 0x0212, all -> 0x020c }
            int r22 = r21 + 1
            float r23 = r2.getFloat()     // Catch:{ FileNotFoundException -> 0x0227, IOException -> 0x0220, OutOfMemoryError -> 0x0219, Exception -> 0x0212, all -> 0x020c }
            r15[r22] = r23     // Catch:{ FileNotFoundException -> 0x0227, IOException -> 0x0220, OutOfMemoryError -> 0x0219, Exception -> 0x0212, all -> 0x020c }
            int r21 = r21 + 2
            float r22 = r2.getFloat()     // Catch:{ FileNotFoundException -> 0x0227, IOException -> 0x0220, OutOfMemoryError -> 0x0219, Exception -> 0x0212, all -> 0x020c }
            r15[r21] = r22     // Catch:{ FileNotFoundException -> 0x0227, IOException -> 0x0220, OutOfMemoryError -> 0x0219, Exception -> 0x0212, all -> 0x020c }
            int r11 = r11 + 1
            goto L_0x0236
        L_0x0257:
            int r8 = r8 + 1
            r11 = 3
            goto L_0x022f
        L_0x025b:
            r8 = 0
        L_0x025c:
            if (r8 >= r13) goto L_0x029c
            int r11 = r8 * r3
            r19 = 3
            int r11 = r11 * 3
            r24 = r6
            r6 = 0
        L_0x0267:
            if (r6 >= r3) goto L_0x0297
            int r19 = r6 * 3
            int r19 = r11 + r19
            int r21 = r19 + 0
            float r22 = r2.getFloat()     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            r10[r21] = r22     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            int r21 = r19 + 1
            float r22 = r2.getFloat()     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            r10[r21] = r22     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            int r19 = r19 + 2
            float r21 = r2.getFloat()     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            r10[r19] = r21     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            int r6 = r6 + 1
            goto L_0x0267
        L_0x0288:
            r0 = move-exception
            goto L_0x0390
        L_0x028b:
            r0 = move-exception
            goto L_0x0396
        L_0x028e:
            r0 = move-exception
            goto L_0x039b
        L_0x0291:
            r0 = move-exception
            goto L_0x03a0
        L_0x0294:
            r0 = move-exception
            goto L_0x03a5
        L_0x0297:
            int r8 = r8 + 1
            r6 = r24
            goto L_0x025c
        L_0x029c:
            r24 = r6
            r6 = 0
        L_0x029f:
            if (r6 >= r13) goto L_0x02cb
            int r8 = r6 * r3
            r11 = 3
            int r8 = r8 * 3
            r11 = 0
        L_0x02a7:
            if (r11 >= r3) goto L_0x02c8
            int r19 = r11 * 3
            int r19 = r8 + r19
            int r21 = r19 + 0
            float r22 = r2.getFloat()     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            r12[r21] = r22     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            int r21 = r19 + 1
            float r22 = r2.getFloat()     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            r12[r21] = r22     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            int r19 = r19 + 2
            float r21 = r2.getFloat()     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            r12[r19] = r21     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            int r11 = r11 + 1
            goto L_0x02a7
        L_0x02c8:
            int r6 = r6 + 1
            goto L_0x029f
        L_0x02cb:
            r6 = 3
            float[] r2 = new float[r6]     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            float[] r8 = new float[r6]     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            float[] r11 = new float[r6]     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            r6 = 0
        L_0x02d3:
            if (r6 >= r13) goto L_0x036d
            int r19 = r6 * r3
            r20 = 3
            int r19 = r19 * 3
            r26 = r13
            r13 = 0
        L_0x02de:
            if (r13 >= r3) goto L_0x035b
            int r21 = r13 * 3
            int r21 = r19 + r21
            int r22 = r21 + 0
            r23 = r15[r22]     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            r18 = 0
            r2[r18] = r23     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            int r23 = r21 + 1
            r25 = r15[r23]     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            r17 = 1
            r2[r17] = r25     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            int r21 = r21 + 2
            r25 = r15[r21]     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            r16 = 2
            r2[r16] = r25     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            r25 = r10[r22]     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            r18 = 0
            r8[r18] = r25     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            r25 = r10[r23]     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            r17 = 1
            r8[r17] = r25     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            r25 = r10[r21]     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            r16 = 2
            r8[r16] = r25     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            r22 = r12[r22]     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            r18 = 0
            r11[r18] = r22     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            r22 = r12[r23]     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            r17 = 1
            r11[r17] = r22     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            r21 = r12[r21]     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            r16 = 2
            r11[r16] = r21     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            r27 = r3
            net.fxgear.b.q r3 = a((float[]) r2)     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            r28 = r2
            net.fxgear.b.j r2 = new net.fxgear.b.j     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            r29 = r10
            r10 = r14[r6]     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            r2.<init>(r6, r10, r3, r8)     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            java.lang.Object r3 = r7.get(r13)     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            java.lang.String r10 = "zHairAni"
            boolean r3 = r3.contains(r10)     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            if (r3 == 0) goto L_0x0352
            java.lang.Object r3 = r7.get(r13)     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            int r3 = a((java.util.ArrayList<net.fxgear.b.i>) r1, (java.lang.String) r3)     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            java.lang.Object r3 = r1.get(r3)     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            net.fxgear.b.i r3 = (net.fxgear.b.i) r3     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
            r3.a((net.fxgear.b.j) r2)     // Catch:{ FileNotFoundException -> 0x0294, IOException -> 0x0291, OutOfMemoryError -> 0x028e, Exception -> 0x028b, all -> 0x0288 }
        L_0x0352:
            int r13 = r13 + 1
            r3 = r27
            r2 = r28
            r10 = r29
            goto L_0x02de
        L_0x035b:
            r28 = r2
            r27 = r3
            r29 = r10
            r16 = 2
            r17 = 1
            r18 = 0
            int r6 = r6 + 1
            r13 = r26
            goto L_0x02d3
        L_0x036d:
            if (r5 == 0) goto L_0x0376
            r5.close()     // Catch:{ IOException -> 0x0373 }
            goto L_0x0376
        L_0x0373:
            r0 = move-exception
            r1 = r0
            goto L_0x0382
        L_0x0376:
            r4.close()     // Catch:{ IOException -> 0x0373 }
            if (r9 == 0) goto L_0x037e
            r9.close()     // Catch:{ IOException -> 0x0373 }
        L_0x037e:
            r24.close()     // Catch:{ IOException -> 0x0373 }
            return
        L_0x0382:
            r1.printStackTrace()
            java.lang.String r1 = "FXNativeImporter : "
            java.lang.String r2 = "BoneLoader - Load io xxception"
            android.util.Log.w(r1, r2)
            return
        L_0x038d:
            r0 = move-exception
            r24 = r6
        L_0x0390:
            r1 = r0
            goto L_0x04a1
        L_0x0393:
            r0 = move-exception
            r24 = r6
        L_0x0396:
            r1 = r0
            goto L_0x03d1
        L_0x0398:
            r0 = move-exception
            r24 = r6
        L_0x039b:
            r1 = r0
            goto L_0x03d9
        L_0x039d:
            r0 = move-exception
            r24 = r6
        L_0x03a0:
            r1 = r0
            goto L_0x03e1
        L_0x03a2:
            r0 = move-exception
            r24 = r6
        L_0x03a5:
            r1 = r0
            goto L_0x03e9
        L_0x03a8:
            r0 = move-exception
            r24 = r6
            r1 = r0
            goto L_0x04a2
        L_0x03ae:
            r0 = move-exception
            r24 = r6
            r1 = r0
            r9 = r2
            goto L_0x03d1
        L_0x03b4:
            r0 = move-exception
            r24 = r6
            r1 = r0
            r9 = r2
            goto L_0x03d9
        L_0x03ba:
            r0 = move-exception
            r24 = r6
            r1 = r0
            r9 = r2
            goto L_0x03e1
        L_0x03c0:
            r0 = move-exception
            r24 = r6
            r1 = r0
            r9 = r2
            goto L_0x03e9
        L_0x03c6:
            r0 = move-exception
            r1 = r0
            r24 = r2
            goto L_0x04a2
        L_0x03cc:
            r0 = move-exception
            r1 = r0
            r9 = r2
            r24 = r9
        L_0x03d1:
            r2 = r5
            goto L_0x0410
        L_0x03d4:
            r0 = move-exception
            r1 = r0
            r9 = r2
            r24 = r9
        L_0x03d9:
            r2 = r5
            goto L_0x0435
        L_0x03dc:
            r0 = move-exception
            r1 = r0
            r9 = r2
            r24 = r9
        L_0x03e1:
            r2 = r5
            goto L_0x045a
        L_0x03e4:
            r0 = move-exception
            r1 = r0
            r9 = r2
            r24 = r9
        L_0x03e9:
            r2 = r5
            goto L_0x047f
        L_0x03ec:
            r0 = move-exception
            r1 = r0
            r5 = r2
            goto L_0x0406
        L_0x03f0:
            r0 = move-exception
            r1 = r0
            r9 = r2
            goto L_0x040e
        L_0x03f4:
            r0 = move-exception
            r1 = r0
            r9 = r2
            goto L_0x0433
        L_0x03f8:
            r0 = move-exception
            r1 = r0
            r9 = r2
            goto L_0x0458
        L_0x03fd:
            r0 = move-exception
            r1 = r0
            r9 = r2
            goto L_0x047d
        L_0x0402:
            r0 = move-exception
            r1 = r0
            r4 = r2
            r5 = r4
        L_0x0406:
            r24 = r5
            goto L_0x04a2
        L_0x040a:
            r0 = move-exception
            r1 = r0
            r4 = r2
            r9 = r4
        L_0x040e:
            r24 = r9
        L_0x0410:
            r1.printStackTrace()     // Catch:{ all -> 0x049e }
            java.lang.String r1 = "FXNativeImporter : "
            java.lang.String r3 = "BoneLoader - Error unknow"
            android.util.Log.w(r1, r3)     // Catch:{ all -> 0x049e }
            if (r2 == 0) goto L_0x041f
            r2.close()     // Catch:{ IOException -> 0x0373 }
        L_0x041f:
            if (r4 == 0) goto L_0x0424
            r4.close()     // Catch:{ IOException -> 0x0373 }
        L_0x0424:
            if (r9 == 0) goto L_0x0429
            r9.close()     // Catch:{ IOException -> 0x0373 }
        L_0x0429:
            if (r24 == 0) goto L_0x042e
            r24.close()     // Catch:{ IOException -> 0x0373 }
        L_0x042e:
            return
        L_0x042f:
            r0 = move-exception
            r1 = r0
            r4 = r2
            r9 = r4
        L_0x0433:
            r24 = r9
        L_0x0435:
            r1.printStackTrace()     // Catch:{ all -> 0x049e }
            java.lang.String r1 = "FXNativeImporter : "
            java.lang.String r3 = "BoneLoader - Out of memory"
            android.util.Log.w(r1, r3)     // Catch:{ all -> 0x049e }
            if (r2 == 0) goto L_0x0444
            r2.close()     // Catch:{ IOException -> 0x0373 }
        L_0x0444:
            if (r4 == 0) goto L_0x0449
            r4.close()     // Catch:{ IOException -> 0x0373 }
        L_0x0449:
            if (r9 == 0) goto L_0x044e
            r9.close()     // Catch:{ IOException -> 0x0373 }
        L_0x044e:
            if (r24 == 0) goto L_0x0453
            r24.close()     // Catch:{ IOException -> 0x0373 }
        L_0x0453:
            return
        L_0x0454:
            r0 = move-exception
            r1 = r0
            r4 = r2
            r9 = r4
        L_0x0458:
            r24 = r9
        L_0x045a:
            r1.printStackTrace()     // Catch:{ all -> 0x049e }
            java.lang.String r1 = "FXNativeImporter : "
            java.lang.String r3 = "BoneLoader - Load io xxception"
            android.util.Log.w(r1, r3)     // Catch:{ all -> 0x049e }
            if (r2 == 0) goto L_0x0469
            r2.close()     // Catch:{ IOException -> 0x0373 }
        L_0x0469:
            if (r4 == 0) goto L_0x046e
            r4.close()     // Catch:{ IOException -> 0x0373 }
        L_0x046e:
            if (r9 == 0) goto L_0x0473
            r9.close()     // Catch:{ IOException -> 0x0373 }
        L_0x0473:
            if (r24 == 0) goto L_0x0478
            r24.close()     // Catch:{ IOException -> 0x0373 }
        L_0x0478:
            return
        L_0x0479:
            r0 = move-exception
            r1 = r0
            r4 = r2
            r9 = r4
        L_0x047d:
            r24 = r9
        L_0x047f:
            r1.printStackTrace()     // Catch:{ all -> 0x049e }
            java.lang.String r1 = "FXNativeImporter : "
            java.lang.String r3 = "BoneLoader - File not found"
            android.util.Log.w(r1, r3)     // Catch:{ all -> 0x049e }
            if (r2 == 0) goto L_0x048e
            r2.close()     // Catch:{ IOException -> 0x0373 }
        L_0x048e:
            if (r4 == 0) goto L_0x0493
            r4.close()     // Catch:{ IOException -> 0x0373 }
        L_0x0493:
            if (r9 == 0) goto L_0x0498
            r9.close()     // Catch:{ IOException -> 0x0373 }
        L_0x0498:
            if (r24 == 0) goto L_0x049d
            r24.close()     // Catch:{ IOException -> 0x0373 }
        L_0x049d:
            return
        L_0x049e:
            r0 = move-exception
            r1 = r0
            r5 = r2
        L_0x04a1:
            r2 = r9
        L_0x04a2:
            if (r5 == 0) goto L_0x04a7
            r5.close()     // Catch:{ IOException -> 0x0373 }
        L_0x04a7:
            if (r4 == 0) goto L_0x04ac
            r4.close()     // Catch:{ IOException -> 0x0373 }
        L_0x04ac:
            if (r2 == 0) goto L_0x04b1
            r2.close()     // Catch:{ IOException -> 0x0373 }
        L_0x04b1:
            if (r24 == 0) goto L_0x04b6
            r24.close()     // Catch:{ IOException -> 0x0373 }
        L_0x04b6:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.b.l.a(java.util.ArrayList, java.lang.String, java.lang.String, java.util.ArrayList):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x016a A[SYNTHETIC, Splitter:B:56:0x016a] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x016f A[Catch:{ IOException -> 0x0142 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x017a A[SYNTHETIC, Splitter:B:65:0x017a] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x017f A[Catch:{ IOException -> 0x0142 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0187 A[Catch:{ IOException -> 0x0142 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x018c A[Catch:{ IOException -> 0x0142 }] */
    /* JADX WARNING: Removed duplicated region for block: B:86:? A[Catch:{ IOException -> 0x0142 }, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:87:? A[Catch:{ IOException -> 0x0142 }, RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:53:0x0165=Splitter:B:53:0x0165, B:62:0x0175=Splitter:B:62:0x0175} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(java.util.ArrayList<net.fxgear.b.i> r25, java.lang.String r26, int[] r27) {
        /*
            r1 = 0
            java.io.File r0 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0173, IOException -> 0x0163, all -> 0x015f }
            r2 = r26
            r0.<init>(r2)     // Catch:{ FileNotFoundException -> 0x0173, IOException -> 0x0163, all -> 0x015f }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0173, IOException -> 0x0163, all -> 0x015f }
            r2.<init>(r0)     // Catch:{ FileNotFoundException -> 0x0173, IOException -> 0x0163, all -> 0x015f }
            java.nio.channels.FileChannel r3 = r2.getChannel()     // Catch:{ FileNotFoundException -> 0x015d, IOException -> 0x015b }
            long r0 = r0.length()     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            int r0 = (int) r0     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.allocate(r0)     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            java.nio.ByteOrder r1 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            r0.order(r1)     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            r3.read(r0)     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            r0.rewind()     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            int r1 = r0.getInt()     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            int r4 = r0.getInt()     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            float[] r5 = new float[r4]     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            int r6 = r4 * r1
            r7 = 3
            int r6 = r6 * 3
            float[] r8 = new float[r6]     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            float[] r9 = new float[r6]     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            float[] r6 = new float[r6]     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            r10 = 0
            r11 = 0
        L_0x003c:
            if (r11 >= r4) goto L_0x0047
            float r12 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            r5[r11] = r12     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            int r11 = r11 + 1
            goto L_0x003c
        L_0x0047:
            r11 = 0
        L_0x0048:
            if (r11 >= r4) goto L_0x0072
            int r12 = r11 * r1
            int r12 = r12 * 3
            r13 = 0
        L_0x004f:
            if (r13 >= r1) goto L_0x006f
            int r14 = r13 * 3
            int r14 = r14 + r12
            int r15 = r14 + 0
            float r16 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            r6[r15] = r16     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            int r15 = r14 + 1
            float r16 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            r6[r15] = r16     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            int r14 = r14 + 2
            float r15 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            r6[r14] = r15     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            int r13 = r13 + 1
            goto L_0x004f
        L_0x006f:
            int r11 = r11 + 1
            goto L_0x0048
        L_0x0072:
            r11 = 0
        L_0x0073:
            if (r11 >= r4) goto L_0x009d
            int r12 = r11 * r1
            int r12 = r12 * 3
            r13 = 0
        L_0x007a:
            if (r13 >= r1) goto L_0x009a
            int r14 = r13 * 3
            int r14 = r14 + r12
            int r15 = r14 + 0
            float r16 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            r8[r15] = r16     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            int r15 = r14 + 1
            float r16 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            r8[r15] = r16     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            int r14 = r14 + 2
            float r15 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            r8[r14] = r15     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            int r13 = r13 + 1
            goto L_0x007a
        L_0x009a:
            int r11 = r11 + 1
            goto L_0x0073
        L_0x009d:
            r11 = 0
        L_0x009e:
            if (r11 >= r4) goto L_0x00c8
            int r12 = r11 * r1
            int r12 = r12 * 3
            r13 = 0
        L_0x00a5:
            if (r13 >= r1) goto L_0x00c5
            int r14 = r13 * 3
            int r14 = r14 + r12
            int r15 = r14 + 0
            float r16 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            r9[r15] = r16     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            int r15 = r14 + 1
            float r16 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            r9[r15] = r16     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            int r14 = r14 + 2
            float r15 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            r9[r14] = r15     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            int r13 = r13 + 1
            goto L_0x00a5
        L_0x00c5:
            int r11 = r11 + 1
            goto L_0x009e
        L_0x00c8:
            float[] r0 = new float[r7]     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            float[] r11 = new float[r7]     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            float[] r12 = new float[r7]     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            r13 = 0
        L_0x00cf:
            if (r13 >= r4) goto L_0x013c
            int r14 = r13 * r1
            int r14 = r14 * 3
            r15 = 0
        L_0x00d6:
            if (r15 >= r1) goto L_0x012f
            r7 = r27[r15]     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            int r17 = r15 * 3
            int r17 = r14 + r17
            int r18 = r17 + 0
            r19 = r6[r18]     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            r0[r10] = r19     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            int r19 = r17 + 1
            r20 = r6[r19]     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            r21 = 1
            r0[r21] = r20     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            int r17 = r17 + 2
            r20 = r6[r17]     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            r22 = 2
            r0[r22] = r20     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            r20 = r8[r18]     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            r11[r10] = r20     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            r20 = r8[r19]     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            r11[r21] = r20     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            r20 = r8[r17]     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            r11[r22] = r20     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            r18 = r9[r18]     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            r12[r10] = r18     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            r18 = r9[r19]     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            r12[r21] = r18     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            r17 = r9[r17]     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            r12[r22] = r17     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            net.fxgear.b.q r10 = a((float[]) r0)     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            r23 = r0
            net.fxgear.b.j r0 = new net.fxgear.b.j     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            r24 = r1
            r1 = r5[r13]     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            r0.<init>(r13, r1, r10, r11)     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            r1 = r25
            java.lang.Object r7 = r1.get(r7)     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            net.fxgear.b.i r7 = (net.fxgear.b.i) r7     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            r7.a((net.fxgear.b.j) r0)     // Catch:{ FileNotFoundException -> 0x0158, IOException -> 0x0155, all -> 0x0153 }
            int r15 = r15 + 1
            r0 = r23
            r1 = r24
            r7 = 3
            r10 = 0
            goto L_0x00d6
        L_0x012f:
            r23 = r0
            r24 = r1
            r1 = r25
            int r13 = r13 + 1
            r1 = r24
            r7 = 3
            r10 = 0
            goto L_0x00cf
        L_0x013c:
            if (r3 == 0) goto L_0x0144
            r3.close()     // Catch:{ IOException -> 0x0142 }
            goto L_0x0144
        L_0x0142:
            r0 = move-exception
            goto L_0x0148
        L_0x0144:
            r2.close()     // Catch:{ IOException -> 0x0142 }
            goto L_0x0182
        L_0x0148:
            r0.printStackTrace()
            java.lang.String r0 = "FXNativeImporter : "
            java.lang.String r1 = "AnimationLoader - Load io xxception"
            android.util.Log.w(r0, r1)
            return
        L_0x0153:
            r0 = move-exception
            goto L_0x0185
        L_0x0155:
            r0 = move-exception
            r1 = r3
            goto L_0x0165
        L_0x0158:
            r0 = move-exception
            r1 = r3
            goto L_0x0175
        L_0x015b:
            r0 = move-exception
            goto L_0x0165
        L_0x015d:
            r0 = move-exception
            goto L_0x0175
        L_0x015f:
            r0 = move-exception
            r2 = r1
            r3 = r2
            goto L_0x0185
        L_0x0163:
            r0 = move-exception
            r2 = r1
        L_0x0165:
            r0.printStackTrace()     // Catch:{ all -> 0x0183 }
            if (r1 == 0) goto L_0x016d
            r1.close()     // Catch:{ IOException -> 0x0142 }
        L_0x016d:
            if (r2 == 0) goto L_0x0182
            r2.close()     // Catch:{ IOException -> 0x0142 }
            goto L_0x0182
        L_0x0173:
            r0 = move-exception
            r2 = r1
        L_0x0175:
            r0.printStackTrace()     // Catch:{ all -> 0x0183 }
            if (r1 == 0) goto L_0x017d
            r1.close()     // Catch:{ IOException -> 0x0142 }
        L_0x017d:
            if (r2 == 0) goto L_0x0182
            r2.close()     // Catch:{ IOException -> 0x0142 }
        L_0x0182:
            return
        L_0x0183:
            r0 = move-exception
            r3 = r1
        L_0x0185:
            if (r3 == 0) goto L_0x018a
            r3.close()     // Catch:{ IOException -> 0x0142 }
        L_0x018a:
            if (r2 == 0) goto L_0x018f
            r2.close()     // Catch:{ IOException -> 0x0142 }
        L_0x018f:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.b.l.b(java.util.ArrayList, java.lang.String, int[]):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:149:0x02d3, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x02d4, code lost:
        r28 = r4;
        r29 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x008b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x008c, code lost:
        r28 = r4;
        r2 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0091, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0092, code lost:
        r28 = r4;
        r2 = r5;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x02d3 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:5:0x0012] */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x0306 A[SYNTHETIC, Splitter:B:171:0x0306] */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x030b A[Catch:{ IOException -> 0x02bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x0318 A[SYNTHETIC, Splitter:B:180:0x0318] */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x031d A[Catch:{ IOException -> 0x02bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x0326 A[Catch:{ IOException -> 0x02bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x032b A[Catch:{ IOException -> 0x02bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:211:? A[Catch:{ IOException -> 0x02bb }, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:212:? A[Catch:{ IOException -> 0x02bb }, RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:168:0x0301=Splitter:B:168:0x0301, B:177:0x0313=Splitter:B:177:0x0313} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(net.fxgear.b.d r33, java.lang.String r34, int r35, net.fxgear.b.p r36, boolean r37) {
        /*
            r0 = r33
            java.io.File r3 = new java.io.File     // Catch:{ FileNotFoundException -> 0x030f, IOException -> 0x02fd, all -> 0x02f7 }
            r4 = r34
            r3.<init>(r4)     // Catch:{ FileNotFoundException -> 0x030f, IOException -> 0x02fd, all -> 0x02f7 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x030f, IOException -> 0x02fd, all -> 0x02f7 }
            r4.<init>(r3)     // Catch:{ FileNotFoundException -> 0x030f, IOException -> 0x02fd, all -> 0x02f7 }
            java.nio.channels.FileChannel r5 = r4.getChannel()     // Catch:{ FileNotFoundException -> 0x02f2, IOException -> 0x02ed, all -> 0x02e9 }
            long r6 = r3.length()     // Catch:{ FileNotFoundException -> 0x02e1, IOException -> 0x02d9, all -> 0x02d3 }
            int r3 = (int) r6     // Catch:{ FileNotFoundException -> 0x02e1, IOException -> 0x02d9, all -> 0x02d3 }
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r3)     // Catch:{ FileNotFoundException -> 0x02e1, IOException -> 0x02d9, all -> 0x02d3 }
            java.nio.ByteOrder r6 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ FileNotFoundException -> 0x02e1, IOException -> 0x02d9, all -> 0x02d3 }
            r3.order(r6)     // Catch:{ FileNotFoundException -> 0x02e1, IOException -> 0x02d9, all -> 0x02d3 }
            r5.read(r3)     // Catch:{ FileNotFoundException -> 0x02e1, IOException -> 0x02d9, all -> 0x02d3 }
            r3.rewind()     // Catch:{ FileNotFoundException -> 0x02e1, IOException -> 0x02d9, all -> 0x02d3 }
            int r6 = r3.getInt()     // Catch:{ FileNotFoundException -> 0x02e1, IOException -> 0x02d9, all -> 0x02d3 }
            r7 = r6 & 1
            if (r7 == 0) goto L_0x0030
            r7 = 1
            goto L_0x0031
        L_0x0030:
            r7 = 0
        L_0x0031:
            r10 = r6 & 2
            if (r10 == 0) goto L_0x0037
            r10 = 1
            goto L_0x0038
        L_0x0037:
            r10 = 0
        L_0x0038:
            r11 = r6 & 4
            if (r11 == 0) goto L_0x003e
            r11 = 1
            goto L_0x003f
        L_0x003e:
            r11 = 0
        L_0x003f:
            r12 = r6 & 8
            if (r12 == 0) goto L_0x0045
            r12 = 1
            goto L_0x0046
        L_0x0045:
            r12 = 0
        L_0x0046:
            r13 = r6 & 16
            if (r13 == 0) goto L_0x004c
            r13 = 1
            goto L_0x004d
        L_0x004c:
            r13 = 0
        L_0x004d:
            r14 = r6 & 32
            if (r14 == 0) goto L_0x0053
            r14 = 1
            goto L_0x0054
        L_0x0053:
            r14 = 0
        L_0x0054:
            r6 = r6 & 64
            if (r6 == 0) goto L_0x005a
            r6 = 1
            goto L_0x005b
        L_0x005a:
            r6 = 0
        L_0x005b:
            int r15 = r3.getInt()     // Catch:{ FileNotFoundException -> 0x02e1, IOException -> 0x02d9, all -> 0x02d3 }
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ FileNotFoundException -> 0x02e1, IOException -> 0x02d9, all -> 0x02d3 }
            r2.<init>()     // Catch:{ FileNotFoundException -> 0x02e1, IOException -> 0x02d9, all -> 0x02d3 }
            if (r7 == 0) goto L_0x0097
            int r7 = r15 * 3
            float[] r7 = new float[r7]     // Catch:{ FileNotFoundException -> 0x0091, IOException -> 0x008b, all -> 0x02d3 }
            r8 = 0
        L_0x006b:
            if (r8 >= r15) goto L_0x0097
            int r16 = r8 * 3
            int r17 = r16 + 0
            float r9 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x0091, IOException -> 0x008b, all -> 0x02d3 }
            float r9 = -r9
            r7[r17] = r9     // Catch:{ FileNotFoundException -> 0x0091, IOException -> 0x008b, all -> 0x02d3 }
            int r9 = r16 + 1
            float r17 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x0091, IOException -> 0x008b, all -> 0x02d3 }
            r7[r9] = r17     // Catch:{ FileNotFoundException -> 0x0091, IOException -> 0x008b, all -> 0x02d3 }
            int r16 = r16 + 2
            float r9 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x0091, IOException -> 0x008b, all -> 0x02d3 }
            r7[r16] = r9     // Catch:{ FileNotFoundException -> 0x0091, IOException -> 0x008b, all -> 0x02d3 }
            int r8 = r8 + 1
            goto L_0x006b
        L_0x008b:
            r0 = move-exception
            r28 = r4
            r2 = r5
            goto L_0x0301
        L_0x0091:
            r0 = move-exception
            r28 = r4
            r2 = r5
            goto L_0x0313
        L_0x0097:
            if (r10 == 0) goto L_0x00a9
            int r7 = r15 * 3
            float[] r8 = new float[r7]     // Catch:{ FileNotFoundException -> 0x0091, IOException -> 0x008b, all -> 0x02d3 }
            r9 = 0
        L_0x009e:
            if (r9 >= r7) goto L_0x00aa
            float r10 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x0091, IOException -> 0x008b, all -> 0x02d3 }
            r8[r9] = r10     // Catch:{ FileNotFoundException -> 0x0091, IOException -> 0x008b, all -> 0x02d3 }
            int r9 = r9 + 1
            goto L_0x009e
        L_0x00a9:
            r8 = 0
        L_0x00aa:
            if (r11 == 0) goto L_0x00bc
            int r7 = r15 * 2
            float[] r9 = new float[r7]     // Catch:{ FileNotFoundException -> 0x0091, IOException -> 0x008b, all -> 0x02d3 }
            r10 = 0
        L_0x00b1:
            if (r10 >= r7) goto L_0x00bd
            float r11 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x0091, IOException -> 0x008b, all -> 0x02d3 }
            r9[r10] = r11     // Catch:{ FileNotFoundException -> 0x0091, IOException -> 0x008b, all -> 0x02d3 }
            int r10 = r10 + 1
            goto L_0x00b1
        L_0x00bc:
            r9 = 0
        L_0x00bd:
            if (r12 == 0) goto L_0x00d9
            int r7 = r3.getInt()     // Catch:{ FileNotFoundException -> 0x0091, IOException -> 0x008b, all -> 0x02d3 }
            short[] r10 = new short[r7]     // Catch:{ FileNotFoundException -> 0x0091, IOException -> 0x008b, all -> 0x02d3 }
            r11 = 0
        L_0x00c6:
            if (r11 >= r7) goto L_0x00da
            int r12 = r3.getInt()     // Catch:{ FileNotFoundException -> 0x0091, IOException -> 0x008b, all -> 0x02d3 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ FileNotFoundException -> 0x0091, IOException -> 0x008b, all -> 0x02d3 }
            short r12 = r12.shortValue()     // Catch:{ FileNotFoundException -> 0x0091, IOException -> 0x008b, all -> 0x02d3 }
            r10[r11] = r12     // Catch:{ FileNotFoundException -> 0x0091, IOException -> 0x008b, all -> 0x02d3 }
            int r11 = r11 + 1
            goto L_0x00c6
        L_0x00d9:
            r10 = 0
        L_0x00da:
            if (r13 == 0) goto L_0x00ee
            int r7 = r3.getInt()     // Catch:{ FileNotFoundException -> 0x0091, IOException -> 0x008b, all -> 0x02d3 }
            int[] r11 = new int[r7]     // Catch:{ FileNotFoundException -> 0x0091, IOException -> 0x008b, all -> 0x02d3 }
            r12 = 0
        L_0x00e3:
            if (r12 >= r7) goto L_0x00f0
            int r13 = r3.getInt()     // Catch:{ FileNotFoundException -> 0x0091, IOException -> 0x008b, all -> 0x02d3 }
            r11[r12] = r13     // Catch:{ FileNotFoundException -> 0x0091, IOException -> 0x008b, all -> 0x02d3 }
            int r12 = r12 + 1
            goto L_0x00e3
        L_0x00ee:
            r7 = 0
            r11 = 0
        L_0x00f0:
            r12 = 300(0x12c, float:4.2E-43)
            if (r14 == 0) goto L_0x01d9
            int r7 = r3.getInt()     // Catch:{ FileNotFoundException -> 0x02e1, IOException -> 0x02d9, all -> 0x02d3 }
            int[] r12 = new int[r12]     // Catch:{ FileNotFoundException -> 0x02e1, IOException -> 0x02d9, all -> 0x02d3 }
            int[] r14 = new int[r7]     // Catch:{ FileNotFoundException -> 0x02e1, IOException -> 0x02d9, all -> 0x02d3 }
            r13 = 0
        L_0x00fd:
            if (r13 >= r7) goto L_0x0108
            int r16 = r3.getInt()     // Catch:{ FileNotFoundException -> 0x0091, IOException -> 0x008b, all -> 0x02d3 }
            r14[r13] = r16     // Catch:{ FileNotFoundException -> 0x0091, IOException -> 0x008b, all -> 0x02d3 }
            int r13 = r13 + 1
            goto L_0x00fd
        L_0x0108:
            r13 = 0
        L_0x0109:
            if (r13 >= r7) goto L_0x0143
            int r14 = r3.getInt()     // Catch:{ FileNotFoundException -> 0x0091, IOException -> 0x008b, all -> 0x02d3 }
            byte[] r14 = new byte[r14]     // Catch:{ FileNotFoundException -> 0x0091, IOException -> 0x008b, all -> 0x02d3 }
            r3.get(r14)     // Catch:{ FileNotFoundException -> 0x0091, IOException -> 0x008b, all -> 0x02d3 }
            r26 = r7
            java.lang.String r7 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x0091, IOException -> 0x008b, all -> 0x02d3 }
            r7.<init>(r14)     // Catch:{ FileNotFoundException -> 0x0091, IOException -> 0x008b, all -> 0x02d3 }
            if (r37 == 0) goto L_0x0124
            int r16 = d(r7)     // Catch:{ FileNotFoundException -> 0x0091, IOException -> 0x008b, all -> 0x02d3 }
            r12[r13] = r16     // Catch:{ FileNotFoundException -> 0x0091, IOException -> 0x008b, all -> 0x02d3 }
            goto L_0x013b
        L_0x0124:
            net.fxgear.b.p r16 = r36.a()     // Catch:{ FileNotFoundException -> 0x0091, IOException -> 0x008b, all -> 0x02d3 }
            if (r16 == 0) goto L_0x0139
            net.fxgear.b.p r16 = r36.a()     // Catch:{ FileNotFoundException -> 0x0091, IOException -> 0x008b, all -> 0x02d3 }
            java.util.ArrayList r14 = r16.p()     // Catch:{ FileNotFoundException -> 0x0091, IOException -> 0x008b, all -> 0x02d3 }
            int r14 = a((java.util.ArrayList<net.fxgear.b.i>) r14, (java.lang.String) r7)     // Catch:{ FileNotFoundException -> 0x0091, IOException -> 0x008b, all -> 0x02d3 }
            r12[r13] = r14     // Catch:{ FileNotFoundException -> 0x0091, IOException -> 0x008b, all -> 0x02d3 }
            goto L_0x013b
        L_0x0139:
            r12[r13] = r13     // Catch:{ FileNotFoundException -> 0x0091, IOException -> 0x008b, all -> 0x02d3 }
        L_0x013b:
            r2.add(r7)     // Catch:{ FileNotFoundException -> 0x0091, IOException -> 0x008b, all -> 0x02d3 }
            int r13 = r13 + 1
            r7 = r26
            goto L_0x0109
        L_0x0143:
            int r7 = r3.getInt()     // Catch:{ FileNotFoundException -> 0x02e1, IOException -> 0x02d9, all -> 0x02d3 }
            int r2 = r7 * 4
            float[] r13 = new float[r2]     // Catch:{ FileNotFoundException -> 0x02e1, IOException -> 0x02d9, all -> 0x02d3 }
            float[] r2 = new float[r2]     // Catch:{ FileNotFoundException -> 0x02e1, IOException -> 0x02d9, all -> 0x02d3 }
            r14 = 0
        L_0x014e:
            if (r14 >= r7) goto L_0x01cc
            r28 = r4
            r27 = r7
            r4 = 4
            r7 = 0
        L_0x0156:
            if (r7 >= r4) goto L_0x01a5
            int r4 = r14 * 4
            int r4 = r4 + r7
            r29 = r5
            int r5 = r3.getInt()     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            r30 = r8
            int r8 = r12.length     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            if (r5 < r8) goto L_0x0185
            java.lang.String r8 = "FXNativeImporter : "
            r31 = r9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            r9.<init>()     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            r32 = r15
            java.lang.String r15 = "ID is not valid!! id : "
            r9.append(r15)     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            r9.append(r5)     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            java.lang.String r5 = r9.toString()     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            android.util.Log.e(r8, r5)     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            r5 = 0
            r8 = r12[r5]     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            r5 = r8
            goto L_0x0189
        L_0x0185:
            r31 = r9
            r32 = r15
        L_0x0189:
            r5 = r12[r5]     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            int r5 = r5 - r35
            float r5 = (float) r5     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            r13[r4] = r5     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            r5 = r13[r4]     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            r8 = 0
            int r5 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r5 >= 0) goto L_0x0199
            r13[r4] = r8     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
        L_0x0199:
            int r7 = r7 + 1
            r5 = r29
            r8 = r30
            r9 = r31
            r15 = r32
            r4 = 4
            goto L_0x0156
        L_0x01a5:
            r29 = r5
            r30 = r8
            r31 = r9
            r32 = r15
            r4 = 0
        L_0x01ae:
            r5 = 4
            if (r4 >= r5) goto L_0x01bd
            int r5 = r14 * 4
            int r5 = r5 + r4
            float r7 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            r2[r5] = r7     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            int r4 = r4 + 1
            goto L_0x01ae
        L_0x01bd:
            int r14 = r14 + 1
            r7 = r27
            r4 = r28
            r5 = r29
            r8 = r30
            r9 = r31
            r15 = r32
            goto L_0x014e
        L_0x01cc:
            r28 = r4
            r29 = r5
            r27 = r7
            r30 = r8
            r31 = r9
            r32 = r15
            goto L_0x0227
        L_0x01d9:
            r28 = r4
            r29 = r5
            r30 = r8
            r31 = r9
            r32 = r15
            int[] r2 = new int[r12]     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            r4 = 0
        L_0x01e6:
            r5 = 133(0x85, float:1.86E-43)
            if (r4 >= r5) goto L_0x01f5
            java.lang.String r5 = "hair_root"
            int r5 = d(r5)     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            r2[r4] = r5     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            int r4 = r4 + 1
            goto L_0x01e6
        L_0x01f5:
            int r2 = r7 * 4
            float[] r4 = new float[r2]     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            float[] r2 = new float[r2]     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            r5 = 0
        L_0x01fc:
            if (r5 >= r7) goto L_0x0226
            r8 = 0
        L_0x01ff:
            r9 = 4
            if (r8 >= r9) goto L_0x0216
            int r9 = r5 * 4
            int r9 = r9 + r8
            int r12 = 108 - r35
            float r12 = (float) r12     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            r4[r9] = r12     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            r12 = r4[r9]     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            r13 = 0
            int r12 = (r12 > r13 ? 1 : (r12 == r13 ? 0 : -1))
            if (r12 >= 0) goto L_0x0213
            r4[r9] = r13     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
        L_0x0213:
            int r8 = r8 + 1
            goto L_0x01ff
        L_0x0216:
            r8 = 0
        L_0x0217:
            if (r8 >= r9) goto L_0x0223
            int r12 = r5 * 4
            int r12 = r12 + r8
            r13 = 1065353216(0x3f800000, float:1.0)
            r2[r12] = r13     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            int r8 = r8 + 1
            goto L_0x0217
        L_0x0223:
            int r5 = r5 + 1
            goto L_0x01fc
        L_0x0226:
            r13 = r4
        L_0x0227:
            r1 = 3
            float[] r1 = new float[r1]     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            r1 = {1203982336, 1203982336, 1203982336} // fill-array     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            if (r6 == 0) goto L_0x027c
            int r4 = r3.getInt()     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            int r5 = r4 * 3
            float[] r5 = new float[r5]     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            r6 = 0
        L_0x0238:
            if (r6 >= r4) goto L_0x0258
            int r8 = r6 * 3
            int r9 = r8 + 0
            float r12 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            float r12 = -r12
            r5[r9] = r12     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            int r9 = r8 + 1
            float r12 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            r5[r9] = r12     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            int r8 = r8 + 2
            float r9 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            r5[r8] = r9     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            int r6 = r6 + 1
            goto L_0x0238
        L_0x0258:
            int r3 = r7 * 2
            float[] r3 = new float[r3]     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            if (r36 == 0) goto L_0x0273
            r24 = 0
            r25 = 0
            r18 = r36
            r19 = r5
            r20 = r11
            r21 = r13
            r22 = r3
            r23 = r10
            float[] r1 = a(r18, r19, r20, r21, r22, r23, r24, r25)     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            goto L_0x027e
        L_0x0273:
            r4 = 0
        L_0x0274:
            if (r4 >= r7) goto L_0x027e
            r6 = 0
            r3[r4] = r6     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            int r4 = r4 + 1
            goto L_0x0274
        L_0x027c:
            r3 = 0
            r5 = 0
        L_0x027e:
            int r4 = r10.length     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            r0.b((int) r4)     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            r4 = r32
            r0.a((int) r4)     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            r4 = 0
            r4 = r1[r4]     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            r0.a((float) r4)     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            r4 = 1
            r4 = r1[r4]     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            r0.b((float) r4)     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            r4 = 2
            r1 = r1[r4]     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            r0.c((float) r1)     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            r0.f(r5)     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            r0.a((int[]) r11)     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            r9 = r31
            r0.a((float[]) r9)     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            r0.b((float[]) r2)     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            r0.c((float[]) r13)     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            r8 = r30
            r0.d(r8)     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            r0.a((short[]) r10)     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            r0.e(r3)     // Catch:{ FileNotFoundException -> 0x02d1, IOException -> 0x02cf, all -> 0x02cd }
            if (r29 == 0) goto L_0x02bd
            r29.close()     // Catch:{ IOException -> 0x02bb }
            goto L_0x02bd
        L_0x02bb:
            r0 = move-exception
            goto L_0x02c2
        L_0x02bd:
            r28.close()     // Catch:{ IOException -> 0x02bb }
            goto L_0x0320
        L_0x02c2:
            r0.printStackTrace()
            java.lang.String r0 = "FXNativeImporter : "
            java.lang.String r1 = "MeshLoader - Load io xxception"
            android.util.Log.w(r0, r1)
            return
        L_0x02cd:
            r0 = move-exception
            goto L_0x0324
        L_0x02cf:
            r0 = move-exception
            goto L_0x02de
        L_0x02d1:
            r0 = move-exception
            goto L_0x02e6
        L_0x02d3:
            r0 = move-exception
            r28 = r4
            r29 = r5
            goto L_0x0324
        L_0x02d9:
            r0 = move-exception
            r28 = r4
            r29 = r5
        L_0x02de:
            r2 = r29
            goto L_0x0301
        L_0x02e1:
            r0 = move-exception
            r28 = r4
            r29 = r5
        L_0x02e6:
            r2 = r29
            goto L_0x0313
        L_0x02e9:
            r0 = move-exception
            r28 = r4
            goto L_0x02fa
        L_0x02ed:
            r0 = move-exception
            r28 = r4
            r2 = 0
            goto L_0x0301
        L_0x02f2:
            r0 = move-exception
            r28 = r4
            r2 = 0
            goto L_0x0313
        L_0x02f7:
            r0 = move-exception
            r28 = 0
        L_0x02fa:
            r29 = 0
            goto L_0x0324
        L_0x02fd:
            r0 = move-exception
            r2 = 0
            r28 = 0
        L_0x0301:
            r0.printStackTrace()     // Catch:{ all -> 0x0321 }
            if (r2 == 0) goto L_0x0309
            r2.close()     // Catch:{ IOException -> 0x02bb }
        L_0x0309:
            if (r28 == 0) goto L_0x0320
            r28.close()     // Catch:{ IOException -> 0x02bb }
            goto L_0x0320
        L_0x030f:
            r0 = move-exception
            r2 = 0
            r28 = 0
        L_0x0313:
            r0.printStackTrace()     // Catch:{ all -> 0x0321 }
            if (r2 == 0) goto L_0x031b
            r2.close()     // Catch:{ IOException -> 0x02bb }
        L_0x031b:
            if (r28 == 0) goto L_0x0320
            r28.close()     // Catch:{ IOException -> 0x02bb }
        L_0x0320:
            return
        L_0x0321:
            r0 = move-exception
            r29 = r2
        L_0x0324:
            if (r29 == 0) goto L_0x0329
            r29.close()     // Catch:{ IOException -> 0x02bb }
        L_0x0329:
            if (r28 == 0) goto L_0x032e
            r28.close()     // Catch:{ IOException -> 0x02bb }
        L_0x032e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.b.l.a(net.fxgear.b.d, java.lang.String, int, net.fxgear.b.p, boolean):void");
    }

    public static void a(k kVar, ArrayList<i> arrayList, String str, p pVar, int[] iArr, float[] fArr, short[] sArr, float[] fArr2, Bitmap bitmap, h.d dVar) {
        int i;
        float[] fArr3;
        int i2;
        float[] fArr4;
        float[] fArr5;
        k kVar2 = kVar;
        ByteBuffer wrap = ByteBuffer.wrap(e(str).c);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        wrap.rewind();
        int i3 = wrap.getInt();
        boolean z = (i3 & 1) != 0;
        boolean z2 = (i3 & 2) != 0;
        boolean z3 = (i3 & 4) != 0;
        boolean z4 = (i3 & 8) != 0;
        boolean z5 = (i3 & 16) != 0;
        boolean z6 = (i3 & 32) != 0;
        boolean z7 = (i3 & 64) != 0;
        boolean z8 = (i3 & 128) != 0;
        ArrayList arrayList2 = new ArrayList();
        if (z) {
            i = wrap.getInt();
            float[] fArr6 = new float[(i * 3)];
            for (int i4 = 0; i4 < i; i4++) {
                int i5 = i4 * 3;
                fArr6[i5 + 0] = -wrap.getFloat();
                fArr6[i5 + 1] = wrap.getFloat();
                fArr6[i5 + 2] = wrap.getFloat();
            }
        } else {
            i = 0;
        }
        if (z2) {
            if (i == 0) {
                i = wrap.getInt();
            }
            int i6 = i * 3;
            float[] fArr7 = new float[i6];
            for (int i7 = 0; i7 < i6; i7++) {
                fArr7[i7] = wrap.getFloat();
            }
        }
        if (z3) {
            if (i == 0) {
                i = wrap.getInt();
            }
            int i8 = i * 2;
            fArr3 = new float[i8];
            for (int i9 = 0; i9 < i8; i9++) {
                fArr3[i9] = wrap.getFloat();
            }
        } else {
            fArr3 = null;
        }
        if (z4) {
            int i10 = wrap.getInt();
            short[] sArr2 = new short[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                sArr2[i11] = Integer.valueOf(wrap.getInt()).shortValue();
            }
        }
        if (z5) {
            int i12 = wrap.getInt();
            int[] iArr2 = new int[i12];
            for (int i13 = 0; i13 < i12; i13++) {
                iArr2[i13] = wrap.getInt();
            }
        }
        if (z6) {
            int i14 = wrap.getInt();
            int[] iArr3 = new int[300];
            int[] iArr4 = new int[i14];
            for (int i15 = 0; i15 < i14; i15++) {
                iArr4[i15] = wrap.getInt();
            }
            for (int i16 = 0; i16 < i14; i16++) {
                byte[] bArr = new byte[wrap.getInt()];
                wrap.get(bArr);
                String str2 = new String(bArr);
                iArr3[i16] = d(str2);
                arrayList2.add(str2);
            }
            i2 = wrap.getInt();
            int i17 = i2 * 4;
            float[] fArr8 = new float[i17];
            float[] fArr9 = new float[i17];
            for (int i18 = 0; i18 < i2; i18++) {
                for (int i19 = 0; i19 < 4; i19++) {
                    int i20 = (i18 * 4) + i19;
                    int i21 = wrap.getInt();
                    if (i21 >= iArr3.length) {
                        Log.e("FXNativeImporter : ", "ID is not valid!! id : " + i21);
                        i21 = iArr3[0];
                    }
                    fArr8[i20] = (float) iArr3[i21];
                }
                for (int i22 = 0; i22 < 4; i22++) {
                    fArr9[(i18 * 4) + i22] = wrap.getFloat();
                }
            }
        } else {
            i2 = 0;
        }
        float[] fArr10 = {100000.0f, 100000.0f, 100000.0f};
        if (z7) {
            int i23 = wrap.getInt();
            fArr4 = new float[(i23 * 3)];
            for (int i24 = 0; i24 < i23; i24++) {
                int i25 = i24 * 3;
                fArr4[i25 + 0] = -wrap.getFloat();
                fArr4[i25 + 1] = wrap.getFloat();
                fArr4[i25 + 2] = wrap.getFloat();
            }
            fArr5 = new float[(i2 * 2)];
            if (pVar != null) {
                fArr10 = a(pVar, fArr4, iArr, fArr, fArr5, sArr, fArr2, bitmap);
            } else {
                for (int i26 = 0; i26 < i2; i26++) {
                    fArr5[i26] = 0.0f;
                }
            }
        } else {
            fArr5 = null;
            fArr4 = null;
        }
        if (z8) {
            int i27 = wrap.getInt();
            float[] fArr11 = new float[i27];
            for (int i28 = 0; i28 < i27; i28++) {
                fArr11[i28] = ((float) (wrap.get() & 255)) / 255.0f;
            }
            kVar2.j(fArr11);
        }
        kVar2.a(fArr4);
        kVar2.d(fArr5);
        kVar2.b(fArr10[0]);
        kVar2.c(fArr10[1]);
        kVar2.d(fArr10[2]);
        if (fArr3 != null) {
            kVar2.f(fArr3);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:105:0x015e A[SYNTHETIC, Splitter:B:105:0x015e] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0163 A[Catch:{ IOException -> 0x0120 }] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x016b A[Catch:{ IOException -> 0x0120 }] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0170 A[Catch:{ IOException -> 0x0120 }] */
    /* JADX WARNING: Removed duplicated region for block: B:126:? A[Catch:{ IOException -> 0x0120 }, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:127:? A[Catch:{ IOException -> 0x0120 }, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x014d A[SYNTHETIC, Splitter:B:96:0x014d] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0152 A[Catch:{ IOException -> 0x0120 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:93:0x0148=Splitter:B:93:0x0148, B:102:0x0159=Splitter:B:102:0x0159} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(net.fxgear.b.f r17, java.lang.String r18) {
        /*
            r0 = r17
            java.io.File r2 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0156, IOException -> 0x0145, all -> 0x0141 }
            r3 = r18
            r2.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0156, IOException -> 0x0145, all -> 0x0141 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0156, IOException -> 0x0145, all -> 0x0141 }
            r3.<init>(r2)     // Catch:{ FileNotFoundException -> 0x0156, IOException -> 0x0145, all -> 0x0141 }
            java.nio.channels.FileChannel r4 = r3.getChannel()     // Catch:{ FileNotFoundException -> 0x013e, IOException -> 0x013b, all -> 0x0139 }
            long r5 = r2.length()     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            int r2 = (int) r5     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r2)     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            java.nio.ByteOrder r5 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            r2.order(r5)     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            r4.read(r2)     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            r2.rewind()     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            int r5 = r2.getInt()     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            r6 = r5 & 1
            r7 = 1
            r8 = 0
            if (r6 == 0) goto L_0x0032
            r6 = 1
            goto L_0x0033
        L_0x0032:
            r6 = 0
        L_0x0033:
            r9 = r5 & 2
            if (r9 == 0) goto L_0x0039
            r9 = 1
            goto L_0x003a
        L_0x0039:
            r9 = 0
        L_0x003a:
            r10 = r5 & 4
            if (r10 == 0) goto L_0x0040
            r10 = 1
            goto L_0x0041
        L_0x0040:
            r10 = 0
        L_0x0041:
            r11 = r5 & 8
            if (r11 == 0) goto L_0x0047
            r11 = 1
            goto L_0x0048
        L_0x0047:
            r11 = 0
        L_0x0048:
            r12 = r5 & 16
            r12 = r5 & 32
            if (r12 == 0) goto L_0x0050
            r12 = 1
            goto L_0x0051
        L_0x0050:
            r12 = 0
        L_0x0051:
            r5 = r5 & 64
            if (r5 == 0) goto L_0x0056
            goto L_0x0057
        L_0x0056:
            r7 = 0
        L_0x0057:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            r5.<init>()     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            if (r6 == 0) goto L_0x0060
            float[] r6 = new float[r8]     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
        L_0x0060:
            if (r9 == 0) goto L_0x0064
            float[] r6 = new float[r8]     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
        L_0x0064:
            if (r10 == 0) goto L_0x0069
            float[] r6 = new float[r8]     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            goto L_0x006a
        L_0x0069:
            r6 = 0
        L_0x006a:
            if (r11 == 0) goto L_0x0086
            int r9 = r2.getInt()     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            short[] r11 = new short[r9]     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            r13 = 0
        L_0x0073:
            if (r13 >= r9) goto L_0x0086
            int r14 = r2.getInt()     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            short r14 = r14.shortValue()     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            r11[r13] = r14     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            int r13 = r13 + 1
            goto L_0x0073
        L_0x0086:
            if (r12 == 0) goto L_0x00e3
            int r9 = r2.getInt()     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            int[] r11 = new int[r9]     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            r12 = 0
        L_0x008f:
            if (r12 >= r9) goto L_0x009a
            int r13 = r2.getInt()     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            r11[r12] = r13     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            int r12 = r12 + 1
            goto L_0x008f
        L_0x009a:
            r11 = 0
        L_0x009b:
            if (r11 >= r9) goto L_0x00b1
            int r12 = r2.getInt()     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            byte[] r12 = new byte[r12]     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            r2.get(r12)     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            java.lang.String r13 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            r13.<init>(r12)     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            r5.add(r13)     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            int r11 = r11 + 1
            goto L_0x009b
        L_0x00b1:
            int r5 = r2.getInt()     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            int r11 = r5 * 4
            int[] r12 = new int[r11]     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            float[] r11 = new float[r11]     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            r13 = 0
        L_0x00bc:
            if (r13 >= r5) goto L_0x00e3
            r14 = 0
        L_0x00bf:
            r15 = 4
            if (r14 >= r15) goto L_0x00d1
            int r15 = r13 * 4
            int r15 = r15 + r14
            int r1 = r2.getInt()     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            if (r1 < r9) goto L_0x00cc
            r1 = 0
        L_0x00cc:
            r12[r15] = r1     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            int r14 = r14 + 1
            goto L_0x00bf
        L_0x00d1:
            r1 = 0
        L_0x00d2:
            if (r1 >= r15) goto L_0x00e0
            int r14 = r13 * 4
            int r14 = r14 + r1
            float r16 = r2.getFloat()     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            r11[r14] = r16     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            int r1 = r1 + 1
            goto L_0x00d2
        L_0x00e0:
            int r13 = r13 + 1
            goto L_0x00bc
        L_0x00e3:
            if (r7 == 0) goto L_0x010d
            int r1 = r2.getInt()     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            int r5 = r1 * 3
            float[] r5 = new float[r5]     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
        L_0x00ed:
            if (r8 >= r1) goto L_0x010f
            int r7 = r8 * 3
            int r9 = r7 + 0
            float r11 = r2.getFloat()     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            float r11 = -r11
            r5[r9] = r11     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            int r9 = r7 + 1
            float r11 = r2.getFloat()     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            r5[r9] = r11     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            int r7 = r7 + 2
            float r9 = r2.getFloat()     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            r5[r7] = r9     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            int r8 = r8 + 1
            goto L_0x00ed
        L_0x010d:
            r1 = 0
            r5 = 0
        L_0x010f:
            r0.a((int) r1)     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            r0.b(r5)     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
            if (r10 == 0) goto L_0x011a
            r0.c(r6)     // Catch:{ FileNotFoundException -> 0x0136, IOException -> 0x0133, all -> 0x0131 }
        L_0x011a:
            if (r4 == 0) goto L_0x0122
            r4.close()     // Catch:{ IOException -> 0x0120 }
            goto L_0x0122
        L_0x0120:
            r0 = move-exception
            goto L_0x0126
        L_0x0122:
            r3.close()     // Catch:{ IOException -> 0x0120 }
            goto L_0x0166
        L_0x0126:
            r0.printStackTrace()
            java.lang.String r0 = "FXNativeImporter : "
            java.lang.String r1 = "BlendTargetMeshLoader - Load io xxception"
            android.util.Log.w(r0, r1)
            return
        L_0x0131:
            r0 = move-exception
            goto L_0x0169
        L_0x0133:
            r0 = move-exception
            r1 = r4
            goto L_0x0148
        L_0x0136:
            r0 = move-exception
            r1 = r4
            goto L_0x0159
        L_0x0139:
            r0 = move-exception
            goto L_0x0143
        L_0x013b:
            r0 = move-exception
            r1 = 0
            goto L_0x0148
        L_0x013e:
            r0 = move-exception
            r1 = 0
            goto L_0x0159
        L_0x0141:
            r0 = move-exception
            r3 = 0
        L_0x0143:
            r4 = 0
            goto L_0x0169
        L_0x0145:
            r0 = move-exception
            r1 = 0
            r3 = 0
        L_0x0148:
            r0.printStackTrace()     // Catch:{ all -> 0x0167 }
            if (r1 == 0) goto L_0x0150
            r1.close()     // Catch:{ IOException -> 0x0120 }
        L_0x0150:
            if (r3 == 0) goto L_0x0166
            r3.close()     // Catch:{ IOException -> 0x0120 }
            goto L_0x0166
        L_0x0156:
            r0 = move-exception
            r1 = 0
            r3 = 0
        L_0x0159:
            r0.printStackTrace()     // Catch:{ all -> 0x0167 }
            if (r1 == 0) goto L_0x0161
            r1.close()     // Catch:{ IOException -> 0x0120 }
        L_0x0161:
            if (r3 == 0) goto L_0x0166
            r3.close()     // Catch:{ IOException -> 0x0120 }
        L_0x0166:
            return
        L_0x0167:
            r0 = move-exception
            r4 = r1
        L_0x0169:
            if (r4 == 0) goto L_0x016e
            r4.close()     // Catch:{ IOException -> 0x0120 }
        L_0x016e:
            if (r3 == 0) goto L_0x0173
            r3.close()     // Catch:{ IOException -> 0x0120 }
        L_0x0173:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.b.l.a(net.fxgear.b.f, java.lang.String):void");
    }

    public static float[] a(p pVar, float[] fArr, int[] iArr, float[] fArr2, Bitmap bitmap, h.d dVar) {
        int[] iArr2;
        int i;
        int i2;
        int i3;
        int i4;
        p pVar2 = pVar;
        int[] iArr3 = iArr;
        Bitmap bitmap2 = bitmap;
        h.d dVar2 = dVar;
        float[] f = pVar2.f(66);
        float[] f2 = pVar2.f(61);
        if (bitmap2 != null) {
            int[] iArr4 = new int[(bitmap.getWidth() * bitmap.getHeight())];
            iArr2 = iArr4;
            bitmap.getPixels(iArr4, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
            i2 = bitmap.getWidth();
            i = bitmap.getHeight();
        } else {
            i2 = 0;
            i = 0;
            iArr2 = null;
        }
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        float f3 = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        float f4 = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        float f5 = 10000.0f;
        float f6 = 10000.0f;
        for (int i9 = 0; i9 < iArr3.length; i9++) {
            float f7 = fArr[(iArr3[i9] * 3) + 0];
            float f8 = fArr[(iArr3[i9] * 3) + 1];
            float f9 = fArr[(iArr3[i9] * 3) + 2];
            if (dVar2 != h.d.PANTS) {
                if (dVar2 == h.d.INNER) {
                    if (iArr2 != null) {
                        int i10 = i9 * 2;
                        int pixel = bitmap2.getPixel((int) (((float) i2) * fArr2[i10 + 0]), (int) (((float) i) * (1.0f - fArr2[i10 + 1])));
                        i3 = 255;
                        i4 = pixel & 255;
                    } else {
                        i3 = 255;
                        i4 = 0;
                    }
                    if ((iArr2 == null || i4 == i3) && f8 < f2[1]) {
                        if (f9 > GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
                            if (f7 < 0.5f && f7 > -0.5f && f8 < f5) {
                                i7 = i9;
                                f5 = f8;
                            }
                        } else if (f7 < 0.5f && f7 > -0.5f && f8 < f6) {
                            i8 = i9;
                            f6 = f8;
                        }
                    }
                } else {
                    Log.e("FXNativeImporter : ", "[c] SetTuckInPartID error CategoryID.");
                }
            } else if (f8 > f[1]) {
                if (f9 > GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
                    if (f7 < 0.5f && f7 > -0.5f && f8 > f3) {
                        i5 = i9;
                        f3 = f8;
                    }
                } else if (f7 < 0.5f && f7 > -0.5f && f8 > f4) {
                    i6 = i9;
                    f4 = f8;
                }
            }
        }
        if (dVar2 == h.d.PANTS) {
            return new float[]{fArr[(iArr3[i5] * 3) + 1], (float) i5, fArr[(iArr3[i6] * 3) + 1], (float) i6};
        } else if (dVar2 == h.d.INNER) {
            return new float[]{fArr[(iArr3[i7] * 3) + 1], (float) i7, fArr[(iArr3[i8] * 3) + 1], (float) i8};
        } else {
            Log.e("FXNativeImporter : ", "[c] SetTuckInPartID error result null");
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:101:0x03af, code lost:
        r7 = r7 + 1;
        r30 = r5;
        r31 = r6;
        r29 = r11;
        r32 = r14;
        r5 = r33;
        r6 = r34;
        r0 = r36;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0244, code lost:
        r36 = r0;
        r5 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0248, code lost:
        r14 = r32;
     */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0394  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0175  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01f7  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0209  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x024d  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0264  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x02f8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static float[] a(net.fxgear.b.p r37, float[] r38, int[] r39, float[] r40, float[] r41, short[] r42, float[] r43, android.graphics.Bitmap r44) {
        /*
            r0 = r37
            r3 = r41
            r13 = r44
            r5 = 10
            float[] r14 = r0.f((int) r5)
            r5 = 34
            float[] r15 = r0.f((int) r5)
            r12 = 70
            float[] r11 = r0.f((int) r12)
            r10 = 71
            float[] r9 = r0.f((int) r10)
            r5 = 50
            float[] r16 = r0.f((int) r5)
            r5 = 75
            float[] r17 = r0.f((int) r5)
            r5 = 65
            float[] r0 = r0.f((int) r5)
            r8 = 3
            float[] r7 = new float[r8]
            r18 = 0
            r5 = r11[r18]
            r6 = r9[r18]
            float r5 = r5 - r6
            float r5 = java.lang.Math.abs(r5)
            r19 = 1073741824(0x40000000, float:2.0)
            float r5 = r5 / r19
            r20 = 1061997773(0x3f4ccccd, float:0.8)
            float r21 = r5 * r20
            if (r13 == 0) goto L_0x008d
            int r5 = r44.getWidth()
            int r6 = r44.getHeight()
            int r5 = r5 * r6
            int[] r6 = new int[r5]
            r22 = 0
            int r23 = r44.getWidth()
            r24 = 0
            r25 = 0
            int r26 = r44.getWidth()
            int r27 = r44.getHeight()
            r5 = r44
            r28 = r6
            r29 = r7
            r7 = r22
            r8 = r23
            r30 = r9
            r9 = r24
            r10 = r25
            r31 = r11
            r11 = r26
            r32 = r14
            r14 = 70
            r12 = r27
            r5.getPixels(r6, r7, r8, r9, r10, r11, r12)
            int r5 = r44.getWidth()
            int r6 = r44.getHeight()
            goto L_0x009c
        L_0x008d:
            r29 = r7
            r30 = r9
            r31 = r11
            r32 = r14
            r14 = 70
            r6 = 0
            r28 = r6
            r5 = 0
            r6 = 0
        L_0x009c:
            r7 = 1203982336(0x47c35000, float:100000.0)
            r7 = 0
            r8 = 1203982336(0x47c35000, float:100000.0)
            r9 = 1203982336(0x47c35000, float:100000.0)
            r10 = 1203982336(0x47c35000, float:100000.0)
        L_0x00a9:
            int r11 = r3.length
            r12 = 2
            int r11 = r11 / r12
            r22 = 0
            r23 = 1
            if (r7 >= r11) goto L_0x03c3
            net.fxgear.b.h$b r11 = net.fxgear.b.h.b.PART_NONE
            if (r28 == 0) goto L_0x00e1
            int r24 = r7 * 2
            int r25 = r24 + 0
            r25 = r43[r25]
            float r12 = (float) r5
            float r12 = r12 * r25
            r25 = 1065353216(0x3f800000, float:1.0)
            int r24 = r24 + 1
            r24 = r43[r24]
            float r25 = r25 - r24
            float r14 = (float) r6
            float r14 = r14 * r25
            int r12 = (int) r12
            int r14 = (int) r14
            int r12 = r13.getPixel(r12, r14)
            r12 = r12 & 255(0xff, float:3.57E-43)
            float r12 = (float) r12
            r14 = 1132396544(0x437f0000, float:255.0)
            float r12 = r12 / r14
            r33 = r5
            double r4 = (double) r12
            r24 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            int r12 = (r4 > r24 ? 1 : (r4 == r24 ? 0 : -1))
            if (r12 >= 0) goto L_0x00e3
            r4 = 0
            goto L_0x00e4
        L_0x00e1:
            r33 = r5
        L_0x00e3:
            r4 = 1
        L_0x00e4:
            r34 = r6
            r5 = 0
            r12 = 0
            r14 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
        L_0x00f1:
            r6 = 4
            if (r5 >= r6) goto L_0x012d
            int r6 = r7 * 4
            int r6 = r6 + r5
            r6 = r40[r6]
            int r6 = (int) r6
            r35 = r11
            r11 = 70
            if (r6 != r11) goto L_0x0101
            r12 = 1
        L_0x0101:
            if (r6 != 0) goto L_0x0106
            r11 = 2
            r14 = 1
            goto L_0x0107
        L_0x0106:
            r11 = 2
        L_0x0107:
            if (r6 < r11) goto L_0x0112
            r11 = 23
            if (r6 > r11) goto L_0x0112
            r11 = 71
            r24 = 1
            goto L_0x0114
        L_0x0112:
            r11 = 71
        L_0x0114:
            if (r6 != r11) goto L_0x0118
            r25 = 1
        L_0x0118:
            r11 = 24
            if (r6 != r11) goto L_0x011e
            r26 = 1
        L_0x011e:
            r11 = 26
            if (r6 < r11) goto L_0x0128
            r11 = 47
            if (r6 > r11) goto L_0x0128
            r27 = 1
        L_0x0128:
            int r5 = r5 + 1
            r11 = r35
            goto L_0x00f1
        L_0x012d:
            r35 = r11
            if (r12 != 0) goto L_0x0135
            if (r14 != 0) goto L_0x0135
            if (r24 == 0) goto L_0x0139
        L_0x0135:
            net.fxgear.b.h$b r11 = net.fxgear.b.h.b.LEFT_ARM
            r35 = r11
        L_0x0139:
            if (r25 != 0) goto L_0x013f
            if (r26 != 0) goto L_0x013f
            if (r27 == 0) goto L_0x0141
        L_0x013f:
            net.fxgear.b.h$b r35 = net.fxgear.b.h.b.RIGHT_ARM
        L_0x0141:
            r5 = r39[r7]
            r6 = 3
            int r5 = r5 * 3
            int r5 = r5 + 0
            r5 = r38[r5]
            r11 = r17[r18]
            float r5 = r5 - r11
            r11 = r29
            r11[r18] = r5
            r5 = r39[r7]
            int r5 = r5 * 3
            int r5 = r5 + 1
            r5 = r38[r5]
            r12 = r17[r23]
            float r5 = r5 - r12
            r11[r23] = r5
            r5 = r39[r7]
            int r5 = r5 * 3
            r12 = 2
            int r5 = r5 + r12
            r5 = r38[r5]
            r14 = r17[r12]
            float r5 = r5 - r14
            r11[r12] = r5
            float r5 = b((float[]) r11)
            r12 = 1099956224(0x41900000, float:18.0)
            int r14 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r14 >= 0) goto L_0x0196
            r14 = r39[r7]
            int r14 = r14 * 3
            int r14 = r14 + 0
            r14 = r38[r14]
            float r14 = java.lang.Math.abs(r14)
            r6 = r31
            r24 = r6[r18]
            r25 = r17[r18]
            float r24 = r24 - r25
            float r24 = java.lang.Math.abs(r24)
            float r24 = r24 / r19
            int r14 = (r14 > r24 ? 1 : (r14 == r24 ? 0 : -1))
            if (r14 >= 0) goto L_0x0198
            net.fxgear.b.h$b r35 = net.fxgear.b.h.b.NECK
            goto L_0x01c6
        L_0x0196:
            r6 = r31
        L_0x0198:
            int r12 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r12 < 0) goto L_0x01c6
            r12 = r17[r23]
            r14 = r0[r23]
            float r12 = r12 - r14
            float r12 = r12 * r20
            int r5 = (r5 > r12 ? 1 : (r5 == r12 ? 0 : -1))
            if (r5 >= 0) goto L_0x01c6
            r5 = r39[r7]
            r12 = 3
            int r5 = r5 * 3
            r14 = 2
            int r5 = r5 + r14
            r5 = r38[r5]
            int r5 = (r5 > r22 ? 1 : (r5 == r22 ? 0 : -1))
            if (r5 <= 0) goto L_0x01c6
            r5 = r39[r7]
            int r5 = r5 * 3
            int r5 = r5 + 0
            r5 = r38[r5]
            float r5 = java.lang.Math.abs(r5)
            int r5 = (r5 > r21 ? 1 : (r5 == r21 ? 0 : -1))
            if (r5 >= 0) goto L_0x01c6
            net.fxgear.b.h$b r35 = net.fxgear.b.h.b.NECK
        L_0x01c6:
            r5 = r35
            net.fxgear.b.h$b r12 = net.fxgear.b.h.b.LEFT_ARM
            if (r5 == r12) goto L_0x01f9
            net.fxgear.b.h$b r12 = net.fxgear.b.h.b.RIGHT_ARM
            if (r5 == r12) goto L_0x01f9
            r12 = r39[r7]
            r14 = 3
            int r12 = r12 * 3
            int r12 = r12 + 0
            r12 = r38[r12]
            r11[r18] = r12
            r12 = r39[r7]
            int r12 = r12 * 3
            int r12 = r12 + 1
            r12 = r38[r12]
            r11[r23] = r12
            r12 = r39[r7]
            int r12 = r12 * 3
            r14 = 2
            int r12 = r12 + r14
            r12 = r38[r12]
            r11[r14] = r12
            r12 = r11[r23]
            r14 = r0[r23]
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 >= 0) goto L_0x01f9
            net.fxgear.b.h$b r5 = net.fxgear.b.h.b.UNDER_HIP_CENTER
        L_0x01f9:
            int[] r12 = net.fxgear.b.l.AnonymousClass1.f698a
            int r5 = r5.ordinal()
            r5 = r12[r5]
            r12 = 1097859072(0x41700000, float:15.0)
            r14 = 1128792064(0x43480000, float:200.0)
            switch(r5) {
                case 1: goto L_0x0394;
                case 2: goto L_0x02f8;
                case 3: goto L_0x0264;
                case 4: goto L_0x024d;
                case 5: goto L_0x0209;
                default: goto L_0x0208;
            }
        L_0x0208:
            goto L_0x0244
        L_0x0209:
            int r5 = r7 * 2
            int r12 = r5 + 0
            r14 = r39[r7]
            r24 = 3
            int r14 = r14 * 3
            int r14 = r14 + 1
            r14 = r38[r14]
            r23 = r16[r23]
            float r14 = r14 - r23
            r3[r12] = r14
            r14 = r3[r12]
            int r14 = (r14 > r22 ? 1 : (r14 == r22 ? 0 : -1))
            if (r14 >= 0) goto L_0x0225
            r3[r12] = r22
        L_0x0225:
            int r5 = r5 + 1
            r14 = r39[r7]
            r22 = 3
            int r14 = r14 * 3
            int r14 = r14 + 0
            r14 = r38[r14]
            r3[r5] = r14
            r5 = r3[r12]
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 >= 0) goto L_0x023d
            if (r4 == 0) goto L_0x023d
            r10 = r3[r12]
        L_0x023d:
            r4 = r3[r12]
            r5 = 1130758144(0x43660000, float:230.0)
            float r4 = r4 + r5
            r3[r12] = r4
        L_0x0244:
            r36 = r0
            r5 = r30
        L_0x0248:
            r14 = r32
        L_0x024a:
            r0 = 3
            goto L_0x03af
        L_0x024d:
            int r4 = r7 * 2
            int r5 = r4 + 0
            r12 = 1129447424(0x43520000, float:210.0)
            r3[r5] = r12
            int r4 = r4 + 1
            r5 = r39[r7]
            r22 = 3
            int r5 = r5 * 3
            int r5 = r5 + 0
            r5 = r38[r5]
            r3[r4] = r5
            goto L_0x0244
        L_0x0264:
            r22 = 3
            r5 = r39[r7]
            int r5 = r5 * 3
            int r5 = r5 + 0
            r5 = r38[r5]
            r11[r18] = r5
            r5 = r39[r7]
            int r5 = r5 * 3
            int r5 = r5 + 1
            r5 = r38[r5]
            r11[r23] = r5
            r5 = r39[r7]
            int r5 = r5 * 3
            r24 = 2
            int r5 = r5 + 2
            r5 = r38[r5]
            r11[r24] = r5
            r5 = r30
            float r24 = a((float[]) r15, (float[]) r5, (float[]) r11)
            int r12 = (r24 > r12 ? 1 : (r24 == r12 ? 0 : -1))
            if (r12 >= 0) goto L_0x02e3
            r12 = r39[r7]
            int r12 = r12 * 3
            int r12 = r12 + 0
            r12 = r38[r12]
            r14 = r15[r18]
            float r12 = r12 - r14
            r11[r18] = r12
            r12 = r39[r7]
            int r12 = r12 * 3
            int r12 = r12 + 1
            r12 = r38[r12]
            r14 = r15[r23]
            float r12 = r12 - r14
            r11[r23] = r12
            r12 = r39[r7]
            int r12 = r12 * 3
            r14 = 2
            int r12 = r12 + r14
            r12 = r38[r12]
            r22 = r15[r14]
            float r12 = r12 - r22
            r11[r14] = r12
            int r12 = r7 * 2
            int r14 = r12 + 0
            float r22 = b((float[]) r11)
            r3[r14] = r22
            int r12 = r12 + 1
            r22 = r39[r7]
            r23 = 3
            int r22 = r22 * 3
            int r22 = r22 + 0
            r22 = r38[r22]
            r3[r12] = r22
            r12 = r3[r14]
            int r12 = (r12 > r9 ? 1 : (r12 == r9 ? 0 : -1))
            if (r12 >= 0) goto L_0x02df
            if (r4 == 0) goto L_0x02df
            r4 = r3[r14]
            r36 = r0
            r9 = r4
            goto L_0x0248
        L_0x02df:
            r36 = r0
            goto L_0x0248
        L_0x02e3:
            int r4 = r7 * 2
            int r12 = r4 + 0
            r3[r12] = r14
            int r4 = r4 + 1
            r12 = r39[r7]
            r22 = 3
            int r12 = r12 * 3
            int r12 = r12 + 0
            r12 = r38[r12]
            r3[r4] = r12
            goto L_0x02df
        L_0x02f8:
            r5 = r30
            r22 = 3
            r24 = r39[r7]
            int r24 = r24 * 3
            int r24 = r24 + 0
            r24 = r38[r24]
            r11[r18] = r24
            r24 = r39[r7]
            int r24 = r24 * 3
            int r24 = r24 + 1
            r24 = r38[r24]
            r11[r23] = r24
            r24 = r39[r7]
            int r24 = r24 * 3
            r25 = 2
            int r24 = r24 + 2
            r24 = r38[r24]
            r11[r25] = r24
            r14 = r32
            float r24 = a((float[]) r14, (float[]) r6, (float[]) r11)
            int r12 = (r24 > r12 ? 1 : (r24 == r12 ? 0 : -1))
            if (r12 >= 0) goto L_0x037d
            r12 = r39[r7]
            int r12 = r12 * 3
            int r12 = r12 + 0
            r12 = r38[r12]
            r24 = r14[r18]
            float r12 = r12 - r24
            r11[r18] = r12
            r12 = r39[r7]
            int r12 = r12 * 3
            int r12 = r12 + 1
            r12 = r38[r12]
            r24 = r14[r23]
            float r12 = r12 - r24
            r11[r23] = r12
            r12 = r39[r7]
            int r12 = r12 * 3
            r22 = 2
            int r12 = r12 + 2
            r12 = r38[r12]
            r24 = r14[r22]
            float r12 = r12 - r24
            r11[r22] = r12
            int r12 = r7 * 2
            int r22 = r12 + 0
            float r24 = b((float[]) r11)
            r3[r22] = r24
            int r12 = r12 + 1
            r23 = r39[r7]
            r24 = 3
            int r23 = r23 * 3
            int r23 = r23 + 0
            r23 = r38[r23]
            r3[r12] = r23
            r12 = r3[r22]
            int r12 = (r12 > r8 ? 1 : (r12 == r8 ? 0 : -1))
            if (r12 >= 0) goto L_0x0379
            if (r4 == 0) goto L_0x0379
            r4 = r3[r22]
            r36 = r0
            r8 = r4
            goto L_0x024a
        L_0x0379:
            r36 = r0
            goto L_0x024a
        L_0x037d:
            int r4 = r7 * 2
            int r12 = r4 + 0
            r22 = 1128792064(0x43480000, float:200.0)
            r3[r12] = r22
            int r4 = r4 + 1
            r12 = r39[r7]
            r22 = 3
            int r12 = r12 * 3
            int r12 = r12 + 0
            r12 = r38[r12]
            r3[r4] = r12
            goto L_0x0379
        L_0x0394:
            r5 = r30
            r14 = r32
            int r4 = r7 * 2
            int r12 = r4 + 0
            r22 = 1128792064(0x43480000, float:200.0)
            r3[r12] = r22
            int r4 = r4 + 1
            r12 = r39[r7]
            r36 = r0
            r0 = 3
            int r12 = r12 * 3
            int r12 = r12 + 0
            r12 = r38[r12]
            r3[r4] = r12
        L_0x03af:
            int r7 = r7 + 1
            r30 = r5
            r31 = r6
            r29 = r11
            r32 = r14
            r5 = r33
            r6 = r34
            r0 = r36
            r14 = 70
            goto L_0x00a9
        L_0x03c3:
            r6 = r31
            r0 = 3
            float r1 = java.lang.Math.max(r8, r9)
            float[] r0 = new float[r0]
            r0[r18] = r1
            r0[r23] = r10
            r1 = r6[r18]
            float r1 = java.lang.Math.abs(r1)
            float r1 = r1 + r22
            r2 = 2
            r0[r2] = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.b.l.a(net.fxgear.b.p, float[], int[], float[], float[], short[], float[], android.graphics.Bitmap):float[]");
    }

    public static float a(float[] fArr, float[] fArr2, float[] fArr3) {
        double abs = (double) Math.abs(((((fArr2[1] - fArr[1]) * fArr3[0]) - ((fArr2[0] - fArr[0]) * fArr3[1])) + (fArr2[0] * fArr[1])) - (fArr2[1] * fArr[0]));
        double sqrt = Math.sqrt((double) (((fArr2[1] - fArr[1]) * (fArr2[1] - fArr[1])) + ((fArr2[0] - fArr[0]) * (fArr2[0] - fArr[0]))));
        Double.isNaN(abs);
        return (float) (abs / sqrt);
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:102:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:104:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:106:? A[Catch:{ IOException -> 0x00c9 }, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0103 A[SYNTHETIC, Splitter:B:55:0x0103] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0108 A[Catch:{ IOException -> 0x00c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x011a A[SYNTHETIC, Splitter:B:64:0x011a] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x011f A[Catch:{ IOException -> 0x00c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0131 A[SYNTHETIC, Splitter:B:73:0x0131] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0136 A[Catch:{ IOException -> 0x00c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0148 A[SYNTHETIC, Splitter:B:82:0x0148] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x014d A[Catch:{ IOException -> 0x00c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0155 A[Catch:{ IOException -> 0x00c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x015a A[Catch:{ IOException -> 0x00c9 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:70:0x0125=Splitter:B:70:0x0125, B:52:0x00f7=Splitter:B:52:0x00f7, B:79:0x013c=Splitter:B:79:0x013c, B:61:0x010e=Splitter:B:61:0x010e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(net.fxgear.b.f r12, java.lang.String r13, int[] r14) {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ FileNotFoundException -> 0x013a, IOException -> 0x0123, OutOfMemoryError -> 0x010c, Exception -> 0x00f5, all -> 0x00f1 }
            r1.<init>(r13)     // Catch:{ FileNotFoundException -> 0x013a, IOException -> 0x0123, OutOfMemoryError -> 0x010c, Exception -> 0x00f5, all -> 0x00f1 }
            java.io.FileInputStream r13 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x013a, IOException -> 0x0123, OutOfMemoryError -> 0x010c, Exception -> 0x00f5, all -> 0x00f1 }
            r13.<init>(r1)     // Catch:{ FileNotFoundException -> 0x013a, IOException -> 0x0123, OutOfMemoryError -> 0x010c, Exception -> 0x00f5, all -> 0x00f1 }
            java.nio.channels.FileChannel r2 = r13.getChannel()     // Catch:{ FileNotFoundException -> 0x00ef, IOException -> 0x00ed, OutOfMemoryError -> 0x00eb, Exception -> 0x00e9 }
            long r0 = r1.length()     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            int r0 = (int) r0     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.allocate(r0)     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            java.nio.ByteOrder r1 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            r0.order(r1)     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            r2.read(r0)     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            r0.rewind()     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            int r1 = r0.getInt()     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            r3 = 0
            r4 = 0
        L_0x0029:
            if (r4 >= r1) goto L_0x0037
            int r5 = r0.getInt()     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            byte[] r5 = new byte[r5]     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            r0.get(r5)     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            int r4 = r4 + 1
            goto L_0x0029
        L_0x0037:
            r4 = 0
        L_0x0038:
            if (r4 >= r1) goto L_0x0046
            int r5 = r0.getInt()     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            byte[] r5 = new byte[r5]     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            r0.get(r5)     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            int r4 = r4 + 1
            goto L_0x0038
        L_0x0046:
            r4 = 0
        L_0x0047:
            r5 = 2
            r6 = 3
            r7 = 1
            if (r4 >= r1) goto L_0x0063
            float[] r6 = new float[r6]     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            float r8 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            r6[r3] = r8     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            float r8 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            r6[r7] = r8     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            float r7 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            r6[r5] = r7     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            int r4 = r4 + 1
            goto L_0x0047
        L_0x0063:
            int r4 = r1 * 3
            float[] r4 = new float[r4]     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            r8 = 0
        L_0x0068:
            if (r8 >= r1) goto L_0x0089
            r9 = r14[r8]     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            int r9 = r9 * 3
            int r10 = r9 + 0
            float r11 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            r4[r10] = r11     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            int r10 = r9 + 1
            float r11 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            r4[r10] = r11     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            int r9 = r9 + 2
            float r10 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            r4[r9] = r10     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            int r8 = r8 + 1
            goto L_0x0068
        L_0x0089:
            r14 = 0
        L_0x008a:
            if (r14 >= r1) goto L_0x00a3
            float[] r8 = new float[r6]     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            float r9 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            r8[r3] = r9     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            float r9 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            r8[r7] = r9     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            float r9 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            r8[r5] = r9     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            int r14 = r14 + 1
            goto L_0x008a
        L_0x00a3:
            r14 = 0
        L_0x00a4:
            if (r14 >= r1) goto L_0x00bd
            float[] r8 = new float[r6]     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            float r9 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            r8[r3] = r9     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            float r9 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            r8[r7] = r9     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            float r9 = r0.getFloat()     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            r8[r5] = r9     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            int r14 = r14 + 1
            goto L_0x00a4
        L_0x00bd:
            r12.a((int) r1)     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            r12.b(r4)     // Catch:{ FileNotFoundException -> 0x00e6, IOException -> 0x00e3, OutOfMemoryError -> 0x00e0, Exception -> 0x00dd, all -> 0x00da }
            if (r2 == 0) goto L_0x00cb
            r2.close()     // Catch:{ IOException -> 0x00c9 }
            goto L_0x00cb
        L_0x00c9:
            r12 = move-exception
            goto L_0x00cf
        L_0x00cb:
            r13.close()     // Catch:{ IOException -> 0x00c9 }
            return
        L_0x00cf:
            r12.printStackTrace()
            java.lang.String r12 = "FXNativeImporter : "
            java.lang.String r13 = "BoneLoader - Load io xxception"
            android.util.Log.w(r12, r13)
            return
        L_0x00da:
            r12 = move-exception
            goto L_0x0153
        L_0x00dd:
            r12 = move-exception
            r0 = r2
            goto L_0x00f7
        L_0x00e0:
            r12 = move-exception
            r0 = r2
            goto L_0x010e
        L_0x00e3:
            r12 = move-exception
            r0 = r2
            goto L_0x0125
        L_0x00e6:
            r12 = move-exception
            r0 = r2
            goto L_0x013c
        L_0x00e9:
            r12 = move-exception
            goto L_0x00f7
        L_0x00eb:
            r12 = move-exception
            goto L_0x010e
        L_0x00ed:
            r12 = move-exception
            goto L_0x0125
        L_0x00ef:
            r12 = move-exception
            goto L_0x013c
        L_0x00f1:
            r12 = move-exception
            r13 = r0
            r2 = r13
            goto L_0x0153
        L_0x00f5:
            r12 = move-exception
            r13 = r0
        L_0x00f7:
            r12.printStackTrace()     // Catch:{ all -> 0x0151 }
            java.lang.String r12 = "FXNativeImporter : "
            java.lang.String r14 = "BoneLoader - Error unknow"
            android.util.Log.w(r12, r14)     // Catch:{ all -> 0x0151 }
            if (r0 == 0) goto L_0x0106
            r0.close()     // Catch:{ IOException -> 0x00c9 }
        L_0x0106:
            if (r13 == 0) goto L_0x010b
            r13.close()     // Catch:{ IOException -> 0x00c9 }
        L_0x010b:
            return
        L_0x010c:
            r12 = move-exception
            r13 = r0
        L_0x010e:
            r12.printStackTrace()     // Catch:{ all -> 0x0151 }
            java.lang.String r12 = "FXNativeImporter : "
            java.lang.String r14 = "BoneLoader - Out of memory"
            android.util.Log.w(r12, r14)     // Catch:{ all -> 0x0151 }
            if (r0 == 0) goto L_0x011d
            r0.close()     // Catch:{ IOException -> 0x00c9 }
        L_0x011d:
            if (r13 == 0) goto L_0x0122
            r13.close()     // Catch:{ IOException -> 0x00c9 }
        L_0x0122:
            return
        L_0x0123:
            r12 = move-exception
            r13 = r0
        L_0x0125:
            r12.printStackTrace()     // Catch:{ all -> 0x0151 }
            java.lang.String r12 = "FXNativeImporter : "
            java.lang.String r14 = "BoneLoader - Load io xxception"
            android.util.Log.w(r12, r14)     // Catch:{ all -> 0x0151 }
            if (r0 == 0) goto L_0x0134
            r0.close()     // Catch:{ IOException -> 0x00c9 }
        L_0x0134:
            if (r13 == 0) goto L_0x0139
            r13.close()     // Catch:{ IOException -> 0x00c9 }
        L_0x0139:
            return
        L_0x013a:
            r12 = move-exception
            r13 = r0
        L_0x013c:
            r12.printStackTrace()     // Catch:{ all -> 0x0151 }
            java.lang.String r12 = "FXNativeImporter : "
            java.lang.String r14 = "BoneLoader - File not found"
            android.util.Log.w(r12, r14)     // Catch:{ all -> 0x0151 }
            if (r0 == 0) goto L_0x014b
            r0.close()     // Catch:{ IOException -> 0x00c9 }
        L_0x014b:
            if (r13 == 0) goto L_0x0150
            r13.close()     // Catch:{ IOException -> 0x00c9 }
        L_0x0150:
            return
        L_0x0151:
            r12 = move-exception
            r2 = r0
        L_0x0153:
            if (r2 == 0) goto L_0x0158
            r2.close()     // Catch:{ IOException -> 0x00c9 }
        L_0x0158:
            if (r13 == 0) goto L_0x015d
            r13.close()     // Catch:{ IOException -> 0x00c9 }
        L_0x015d:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.b.l.a(net.fxgear.b.f, java.lang.String, int[]):void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v18, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: float[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v57, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v37, resolved type: float[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x027a A[Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x027b A[Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0502 A[Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x0503 A[Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x05b2  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x05b7 A[SYNTHETIC, Splitter:B:194:0x05b7] */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x05fd  */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x0602 A[SYNTHETIC, Splitter:B:234:0x0602] */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x0607 A[Catch:{ IOException -> 0x05bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x0612  */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x0617 A[SYNTHETIC, Splitter:B:245:0x0617] */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x061c A[Catch:{ IOException -> 0x05bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x0622  */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x0627 A[SYNTHETIC, Splitter:B:252:0x0627] */
    /* JADX WARNING: Removed duplicated region for block: B:255:0x062c A[Catch:{ IOException -> 0x05bb }] */
    /* JADX WARNING: Removed duplicated region for block: B:282:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:283:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:229:0x05f8=Splitter:B:229:0x05f8, B:240:0x060d=Splitter:B:240:0x060d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(net.fxgear.b.p r38, java.lang.String r39) {
        /*
            r1 = r38
            r2 = 0
            r3 = 0
            r4 = 0
            java.io.File r5 = new java.io.File     // Catch:{ FileNotFoundException -> 0x060b, IOException -> 0x05f6 }
            r6 = r39
            r5.<init>(r6)     // Catch:{ FileNotFoundException -> 0x060b, IOException -> 0x05f6 }
            r6 = 2
            byte[] r7 = new byte[r6]     // Catch:{ FileNotFoundException -> 0x060b, IOException -> 0x05f6 }
            java.io.FileInputStream r8 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x060b, IOException -> 0x05f6 }
            r8.<init>(r5)     // Catch:{ FileNotFoundException -> 0x060b, IOException -> 0x05f6 }
            java.nio.channels.FileChannel r2 = r8.getChannel()     // Catch:{ FileNotFoundException -> 0x05ec, IOException -> 0x05e8, all -> 0x05e5 }
            long r9 = r5.length()     // Catch:{ FileNotFoundException -> 0x05e1, IOException -> 0x05dd, all -> 0x05da }
            int r3 = (int) r9     // Catch:{ FileNotFoundException -> 0x05e1, IOException -> 0x05dd, all -> 0x05da }
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.allocate(r3)     // Catch:{ FileNotFoundException -> 0x05e1, IOException -> 0x05dd, all -> 0x05da }
            java.nio.ByteOrder r4 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r3.order(r4)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r2.read(r3)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r3.rewind()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r4 = 1
            byte[] r5 = new byte[r4]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r3.get(r5)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r3.get(r7)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r5 = 0
            byte r9 = r7[r5]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r10 = 24
            r11 = 21
            r12 = 15
            r13 = 16
            r14 = 26
            r5 = 70
            r6 = 14
            r19 = 1120403456(0x42c80000, float:100.0)
            r20 = 0
            if (r9 != r5) goto L_0x032e
            byte r7 = r7[r4]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r9 = 88
            if (r7 == r9) goto L_0x0054
            goto L_0x032e
        L_0x0054:
            int r7 = r3.getInt()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            java.lang.String r9 = "FXNativeImporter : "
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r15.<init>()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            java.lang.String r4 = "[c] Custom Animation version "
            r15.append(r4)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r15.append(r7)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            java.lang.String r4 = r15.toString()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            android.util.Log.i(r9, r4)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r1.d((int) r7)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r4 = r3.getInt()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            float[] r7 = new float[r4]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r9 = 0
        L_0x0078:
            if (r9 >= r4) goto L_0x0083
            float r15 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r7[r9] = r15     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r9 = r9 + 1
            goto L_0x0078
        L_0x0083:
            float[] r9 = r1.h     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            if (r9 == 0) goto L_0x0096
            float[] r4 = r1.h     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            java.lang.Object r4 = r4.clone()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            float[] r4 = (float[]) r4     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r1.f((float[]) r4)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r1.g((float[]) r4)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            goto L_0x00ed
        L_0x0096:
            float[] r9 = new float[r14]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            if (r4 != r13) goto L_0x00cf
            r4 = 0
        L_0x009b:
            if (r4 >= r6) goto L_0x00a4
            r15 = r7[r4]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r9[r4] = r15     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r4 = r4 + 1
            goto L_0x009b
        L_0x00a4:
            r4 = r7[r6]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r7 = r7[r12]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r9[r6] = r4     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r9[r12] = r20     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r9[r13] = r4     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r6 = 17
            r9[r6] = r20     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r6 = 18
            r9[r6] = r4     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r6 = 19
            r9[r6] = r20     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r6 = 20
            r9[r6] = r4     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r9[r11] = r20     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r4 = 22
            r9[r4] = r7     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r4 = 23
            r9[r4] = r20     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r9[r10] = r7     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r4 = 25
            r9[r4] = r20     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            goto L_0x00d6
        L_0x00cf:
            java.lang.Object r4 = r7.clone()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r9 = r4
            float[] r9 = (float[]) r9     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
        L_0x00d6:
            if (r9 == 0) goto L_0x00e7
            r4 = 4
            r6 = r9[r4]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r6 = (r6 > r20 ? 1 : (r6 == r20 ? 0 : -1))
            if (r6 <= 0) goto L_0x00e7
            r6 = r9[r4]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r7 = 1028443341(0x3d4ccccd, float:0.05)
            float r6 = r6 - r7
            r9[r4] = r6     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
        L_0x00e7:
            r1.f((float[]) r9)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r1.g((float[]) r9)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
        L_0x00ed:
            r4 = 25
            int r6 = r3.getInt()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r7 = 75
            if (r6 == r7) goto L_0x00fe
            java.lang.String r6 = "FXNativeImporter : "
            java.lang.String r9 = "[c] APOSE joint count didn't match"
            android.util.Log.e(r6, r9)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
        L_0x00fe:
            float[] r6 = new float[r7]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r9 = 0
        L_0x0101:
            if (r9 >= r4) goto L_0x0120
            int r12 = r9 * 3
            int r13 = r12 + 0
            float r15 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r6[r13] = r15     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r13 = r12 + 1
            float r15 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r6[r13] = r15     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r12 = r12 + 2
            float r13 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r6[r12] = r13     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r9 = r9 + 1
            goto L_0x0101
        L_0x0120:
            int r6 = r3.getInt()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            float[] r9 = new float[r6]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r12 = 0
        L_0x0127:
            if (r12 >= r6) goto L_0x0132
            float r13 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r9[r12] = r13     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r12 = r12 + 1
            goto L_0x0127
        L_0x0132:
            r1.b((float[]) r9)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r6 = r3.getInt()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            float[] r9 = new float[r6]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r12 = 0
        L_0x013c:
            if (r12 >= r6) goto L_0x0147
            float r13 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r9[r12] = r13     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r12 = r12 + 1
            goto L_0x013c
        L_0x0147:
            r1.c((float[]) r9)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r6 = r3.getInt()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            float[] r9 = new float[r6]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r12 = 0
        L_0x0151:
            if (r12 >= r6) goto L_0x015c
            float r13 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r9[r12] = r13     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r12 = r12 + 1
            goto L_0x0151
        L_0x015c:
            r1.d((float[]) r9)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r6 = r3.getInt()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            float[] r9 = new float[r6]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r12 = 0
        L_0x0166:
            if (r12 >= r6) goto L_0x0171
            float r13 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r9[r12] = r13     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r12 = r12 + 1
            goto L_0x0166
        L_0x0171:
            r1.e((float[]) r9)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r6 = r3.getInt()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r9 = 0
        L_0x0179:
            if (r9 >= r6) goto L_0x05b0
            float r12 = (float) r9     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r13 = 1106247680(0x41f00000, float:30.0)
            float r12 = r12 / r13
            r3.getFloat()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r13 = r3.getInt()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            if (r13 == r7) goto L_0x018f
            java.lang.String r13 = "FXNativeImporter : "
            java.lang.String r15 = "[c] jointPosCount count didn't match"
            android.util.Log.e(r13, r15)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
        L_0x018f:
            float[] r13 = new float[r7]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r15 = 0
        L_0x0192:
            if (r15 >= r4) goto L_0x01b1
            int r24 = r15 * 3
            int r25 = r24 + 0
            float r26 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r13[r25] = r26     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r25 = r24 + 1
            float r26 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r13[r25] = r26     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r24 = r24 + 2
            float r25 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r13[r24] = r25     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r15 = r15 + 1
            goto L_0x0192
        L_0x01b1:
            int r15 = r3.getInt()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r7 = 100
            if (r15 == r7) goto L_0x01c0
            java.lang.String r15 = "FXNativeImporter : "
            java.lang.String r14 = "[c] jointOrientCount count didn't match"
            android.util.Log.e(r15, r14)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
        L_0x01c0:
            float[] r7 = new float[r7]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r14 = 0
        L_0x01c3:
            if (r14 >= r4) goto L_0x01ea
            int r15 = r14 * 4
            int r24 = r15 + 0
            float r25 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r7[r24] = r25     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r24 = r15 + 1
            float r25 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r7[r24] = r25     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r24 = r15 + 2
            float r25 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r7[r24] = r25     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r15 = r15 + 3
            float r24 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r7[r15] = r24     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r14 = r14 + 1
            goto L_0x01c3
        L_0x01ea:
            int r14 = r3.getInt()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            if (r14 == r4) goto L_0x01f7
            java.lang.String r15 = "FXNativeImporter : "
            java.lang.String r4 = "[c] trackingStateCount count didn't match"
            android.util.Log.e(r15, r4)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
        L_0x01f7:
            int[] r4 = new int[r14]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r15 = 0
        L_0x01fa:
            if (r15 >= r14) goto L_0x0205
            int r24 = r3.getInt()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r4[r15] = r24     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r15 = r15 + 1
            goto L_0x01fa
        L_0x0205:
            r4 = 0
        L_0x0206:
            if (r4 >= r11) goto L_0x031c
            int r14 = a((int) r4)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r15 = -1
            if (r14 != r15) goto L_0x0215
            r33 = r6
            r34 = r7
            goto L_0x030e
        L_0x0215:
            if (r14 == r5) goto L_0x0220
            r15 = 71
            if (r14 != r15) goto L_0x021c
            goto L_0x0220
        L_0x021c:
            r11 = 61
            r15 = 0
            goto L_0x0254
        L_0x0220:
            float r15 = r1.g     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r15 = (r15 > r20 ? 1 : (r15 == r20 ? 0 : -1))
            if (r15 != 0) goto L_0x0250
            r15 = 61
            r24 = r13[r15]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            float r24 = r24 * r19
            int r15 = r4 * 3
            r23 = 1
            int r15 = r15 + 1
            r25 = r13[r15]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            float r25 = r25 * r19
            r26 = 1056964608(0x3f000000, float:0.5)
            float r25 = r25 + r26
            int r24 = (r24 > r25 ? 1 : (r24 == r25 ? 0 : -1))
            if (r24 <= 0) goto L_0x0250
            r18 = 61
            r24 = r13[r18]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            float r24 = r24 * r19
            r15 = r13[r15]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            float r15 = r15 * r19
            float r24 = r24 - r15
            r15 = 1056964608(0x3f000000, float:0.5)
            float r15 = r24 - r15
            r1.g = r15     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
        L_0x0250:
            float r15 = r1.g     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r11 = 61
        L_0x0254:
            if (r14 == r11) goto L_0x0281
            r11 = 72
            if (r14 == r11) goto L_0x0281
            r11 = 89
            if (r14 == r11) goto L_0x0281
            r11 = 75
            if (r14 == r11) goto L_0x0281
            if (r14 == r5) goto L_0x0281
            if (r14 == 0) goto L_0x0281
            r11 = 2
            if (r14 == r11) goto L_0x0281
            r11 = 3
            if (r14 == r11) goto L_0x0281
            r11 = 71
            if (r14 == r11) goto L_0x0281
            if (r14 == r10) goto L_0x0281
            r11 = 26
            if (r14 == r11) goto L_0x0281
            r11 = 27
            if (r14 != r11) goto L_0x027b
            goto L_0x0281
        L_0x027b:
            float r11 = r1.f     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r24 = -1063256064(0xffffffffc0a00000, float:-5.0)
            r5 = 3
            goto L_0x0286
        L_0x0281:
            float r11 = r1.e     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r5 = 3
            r24 = 0
        L_0x0286:
            float[] r10 = new float[r5]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r5 = r4 * 3
            int r25 = r5 + 0
            r25 = r13[r25]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            float r25 = r25 * r19
            float r25 = r25 + r11
            r11 = 0
            r10[r11] = r25     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r11 = r5 + 1
            r11 = r13[r11]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            float r11 = r11 * r19
            float r11 = r11 + r15
            r15 = 1
            r10[r15] = r11     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r5 = r5 + 2
            r5 = r13[r5]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            float r5 = -r5
            float r5 = r5 * r19
            float r5 = r5 + r24
            r11 = 2
            r10[r11] = r5     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r5 = 4
            float[] r11 = new float[r5]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r5 = r4 * 4
            int r15 = r5 + 0
            r15 = r7[r15]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r16 = 0
            r11[r16] = r15     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r15 = r5 + 1
            r15 = r7[r15]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r23 = 1
            r11[r23] = r15     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r15 = r5 + 2
            r15 = r7[r15]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r17 = 2
            r11[r17] = r15     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r5 = r5 + 3
            r5 = r7[r5]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r15 = 3
            r11[r15] = r5     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            net.fxgear.b.q r5 = new net.fxgear.b.q     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r16 = 0
            r15 = r11[r16]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r33 = r6
            r22 = 1
            r6 = r11[r22]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r34 = r7
            r17 = 2
            r7 = r11[r17]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r22 = 3
            r11 = r11[r22]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r5.<init>(r15, r6, r7, r11)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            net.fxgear.b.j r6 = new net.fxgear.b.j     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r27 = 0
            r30 = 0
            r31 = 0
            r32 = 1
            r24 = r6
            r25 = r9
            r26 = r12
            r28 = r5
            r29 = r10
            r24.<init>(r25, r26, r27, r28, r29, r30, r31, r32)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            net.fxgear.b.i r5 = r1.e((int) r14)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r5.a((net.fxgear.b.j) r6)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            net.fxgear.b.i r5 = r1.e((int) r14)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r6 = 1
            r5.b((boolean) r6)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
        L_0x030e:
            int r4 = r4 + 1
            r6 = r33
            r7 = r34
            r5 = 70
            r10 = 24
            r11 = 21
            goto L_0x0206
        L_0x031c:
            r33 = r6
            int r9 = r9 + 1
            r4 = 25
            r5 = 70
            r7 = 75
            r10 = 24
            r11 = 21
            r14 = 26
            goto L_0x0179
        L_0x032e:
            java.lang.String r4 = "FXNativeImporter : "
            java.lang.String r5 = "[c] No head FX! old version"
            android.util.Log.e(r4, r5)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r4 = 0
            r1.d((int) r4)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r3.rewind()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r4 = r3.getInt()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            float[] r5 = new float[r4]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r7 = 0
        L_0x0343:
            if (r7 >= r4) goto L_0x034e
            float r9 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r5[r7] = r9     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r7 = r7 + 1
            goto L_0x0343
        L_0x034e:
            float[] r7 = r1.h     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            if (r7 == 0) goto L_0x0362
            float[] r4 = r1.h     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            java.lang.Object r4 = r4.clone()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            float[] r4 = (float[]) r4     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r1.f((float[]) r4)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r1.g((float[]) r4)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
        L_0x0360:
            r4 = 1
            goto L_0x03c0
        L_0x0362:
            r7 = 26
            float[] r9 = new float[r7]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            if (r4 != r13) goto L_0x03a1
            r4 = 0
        L_0x0369:
            if (r4 >= r6) goto L_0x0372
            r7 = r5[r4]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r9[r4] = r7     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r4 = r4 + 1
            goto L_0x0369
        L_0x0372:
            r4 = r5[r6]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r5 = r5[r12]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r9[r6] = r4     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r9[r12] = r20     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r9[r13] = r4     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r6 = 17
            r9[r6] = r20     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r6 = 18
            r9[r6] = r4     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r6 = 19
            r9[r6] = r20     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r6 = 20
            r9[r6] = r4     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r4 = 21
            r9[r4] = r20     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r4 = 22
            r9[r4] = r5     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r4 = 23
            r9[r4] = r20     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r4 = 24
            r9[r4] = r5     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r4 = 25
            r9[r4] = r20     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            goto L_0x03a8
        L_0x03a1:
            java.lang.Object r4 = r5.clone()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r9 = r4
            float[] r9 = (float[]) r9     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
        L_0x03a8:
            if (r9 == 0) goto L_0x03b9
            r4 = 4
            r5 = r9[r4]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r5 = (r5 > r20 ? 1 : (r5 == r20 ? 0 : -1))
            if (r5 <= 0) goto L_0x03b9
            r5 = r9[r4]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r6 = 1028443341(0x3d4ccccd, float:0.05)
            float r5 = r5 - r6
            r9[r4] = r5     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
        L_0x03b9:
            r1.f((float[]) r9)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r1.g((float[]) r9)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            goto L_0x0360
        L_0x03c0:
            byte[] r5 = new byte[r4]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r3.get(r5)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r4 = 0
            byte r5 = r5[r4]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            byte[] r4 = new byte[r5]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r3.get(r4)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            java.lang.String r5 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r5.<init>(r4)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            java.lang.String r4 = "APose"
            boolean r4 = r5.equals(r4)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            if (r4 == 0) goto L_0x0402
            int r4 = r3.getInt()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r5 = r4 * 3
            float[] r5 = new float[r5]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r6 = 0
        L_0x03e3:
            if (r6 >= r4) goto L_0x0402
            int r7 = r6 * 3
            int r9 = r7 + 0
            float r10 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r5[r9] = r10     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r9 = r7 + 1
            float r10 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r5[r9] = r10     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r7 = r7 + 2
            float r9 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r5[r7] = r9     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r6 = r6 + 1
            goto L_0x03e3
        L_0x0402:
            r4 = 3
            float[] r5 = new float[r4]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            float r4 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r6 = 0
            r5[r6] = r4     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            float r4 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r6 = 1
            r5[r6] = r4     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            float r4 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r6 = 2
            r5[r6] = r4     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r1.a((float[]) r5)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r4 = 3
            float[] r5 = new float[r4]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r4 = 0
        L_0x0421:
            int r6 = r3.remaining()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            if (r6 <= 0) goto L_0x05b0
            r3.getFloat()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            float r6 = (float) r4     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r7 = 1106247680(0x41f00000, float:30.0)
            float r6 = r6 / r7
            int r7 = r3.getInt()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r9 = r7 * 3
            float[] r9 = new float[r9]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r10 = r7 * 4
            float[] r10 = new float[r10]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int[] r11 = new int[r7]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r12 = 0
        L_0x043d:
            if (r12 >= r7) goto L_0x045c
            int r13 = r12 * 3
            int r14 = r13 + 0
            float r15 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r9[r14] = r15     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r14 = r13 + 1
            float r15 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r9[r14] = r15     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r13 = r13 + 2
            float r14 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r9[r13] = r14     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r12 = r12 + 1
            goto L_0x043d
        L_0x045c:
            if (r4 != 0) goto L_0x0479
            r12 = 60
            r12 = r9[r12]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            float r12 = r12 * r19
            r13 = 0
            r5[r13] = r12     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r12 = 61
            r13 = r9[r12]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            float r13 = r13 * r19
            r12 = 1
            r5[r12] = r13     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r12 = 62
            r12 = r9[r12]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            float r12 = r12 * r19
            r13 = 2
            r5[r13] = r12     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
        L_0x0479:
            r12 = 0
        L_0x047a:
            if (r12 >= r7) goto L_0x04a1
            int r13 = r12 * 4
            int r14 = r13 + 0
            float r15 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r10[r14] = r15     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r14 = r13 + 1
            float r15 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r10[r14] = r15     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r14 = r13 + 2
            float r15 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r10[r14] = r15     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r13 = r13 + 3
            float r14 = r3.getFloat()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r10[r13] = r14     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r12 = r12 + 1
            goto L_0x047a
        L_0x04a1:
            r12 = 0
        L_0x04a2:
            if (r12 >= r7) goto L_0x04ad
            int r13 = r3.getInt()     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r11[r12] = r13     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r12 = r12 + 1
            goto L_0x04a2
        L_0x04ad:
            r7 = 0
        L_0x04ae:
            r12 = 21
            if (r7 >= r12) goto L_0x05a3
            int r13 = a((int) r7)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r14 = -1
            if (r13 != r14) goto L_0x04c8
            r35 = r5
            r36 = r9
            r37 = r10
            r9 = 1
            r16 = 0
            r17 = 2
            r18 = 3
            goto L_0x0599
        L_0x04c8:
            r14 = 70
            if (r13 == r14) goto L_0x04d5
            r14 = 71
            if (r13 != r14) goto L_0x04d1
            goto L_0x04d5
        L_0x04d1:
            r14 = 0
        L_0x04d2:
            r15 = 61
            goto L_0x04d8
        L_0x04d5:
            float r14 = r1.g     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            goto L_0x04d2
        L_0x04d8:
            if (r13 == r15) goto L_0x050b
            r12 = 72
            if (r13 == r12) goto L_0x050b
            r12 = 89
            if (r13 == r12) goto L_0x050b
            r12 = 75
            if (r13 == r12) goto L_0x050b
            r12 = 70
            if (r13 == r12) goto L_0x050b
            if (r13 == 0) goto L_0x050b
            r12 = 2
            if (r13 == r12) goto L_0x050b
            r12 = 3
            if (r13 == r12) goto L_0x050b
            r12 = 71
            if (r13 == r12) goto L_0x050b
            r12 = 24
            if (r13 == r12) goto L_0x050b
            r12 = 26
            if (r13 == r12) goto L_0x050b
            r12 = 27
            if (r13 != r12) goto L_0x0503
            goto L_0x050b
        L_0x0503:
            float r12 = r1.f     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r18 = -1063256064(0xffffffffc0a00000, float:-5.0)
            r35 = r5
            r15 = 3
            goto L_0x0512
        L_0x050b:
            float r12 = r1.e     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r35 = r5
            r15 = 3
            r18 = 0
        L_0x0512:
            float[] r5 = new float[r15]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r15 = r7 * 3
            int r24 = r15 + 0
            r24 = r9[r24]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            float r24 = r24 * r19
            float r24 = r24 + r12
            r12 = 0
            r5[r12] = r24     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r12 = r15 + 1
            r12 = r9[r12]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            float r12 = r12 * r19
            float r12 = r12 + r14
            r14 = 1
            r5[r14] = r12     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r15 = r15 + 2
            r12 = r9[r15]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            float r12 = -r12
            float r12 = r12 * r19
            float r12 = r12 + r18
            r14 = 2
            r5[r14] = r12     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r12 = 4
            float[] r14 = new float[r12]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r15 = r7 * 4
            int r18 = r15 + 0
            r18 = r10[r18]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r16 = 0
            r14[r16] = r18     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r18 = r15 + 1
            r18 = r10[r18]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r21 = 1
            r14[r21] = r18     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r18 = r15 + 2
            r18 = r10[r18]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r17 = 2
            r14[r17] = r18     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            int r15 = r15 + 3
            r15 = r10[r15]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r18 = 3
            r14[r18] = r15     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            net.fxgear.b.q r15 = new net.fxgear.b.q     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r16 = 0
            r12 = r14[r16]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r36 = r9
            r21 = 1
            r9 = r14[r21]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r37 = r10
            r17 = 2
            r10 = r14[r17]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r14 = r14[r18]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r15.<init>(r12, r9, r10, r14)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            net.fxgear.b.j r9 = new net.fxgear.b.j     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r27 = 0
            r30 = 0
            r31 = r11[r7]     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r32 = 1
            r24 = r9
            r25 = r4
            r26 = r6
            r28 = r15
            r29 = r5
            r24.<init>(r25, r26, r27, r28, r29, r30, r31, r32)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            net.fxgear.b.i r5 = r1.e((int) r13)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r5.a((net.fxgear.b.j) r9)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            net.fxgear.b.i r5 = r1.e((int) r13)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
            r9 = 1
            r5.b((boolean) r9)     // Catch:{ FileNotFoundException -> 0x05d6, IOException -> 0x05d2, all -> 0x05ce }
        L_0x0599:
            int r7 = r7 + 1
            r5 = r35
            r9 = r36
            r10 = r37
            goto L_0x04ae
        L_0x05a3:
            r35 = r5
            r9 = 1
            r16 = 0
            r17 = 2
            r18 = 3
            int r4 = r4 + 1
            goto L_0x0421
        L_0x05b0:
            if (r3 == 0) goto L_0x05b5
            r3.clear()
        L_0x05b5:
            if (r2 == 0) goto L_0x05be
            r2.close()     // Catch:{ IOException -> 0x05bb }
            goto L_0x05be
        L_0x05bb:
            r0 = move-exception
            r1 = r0
            goto L_0x05c3
        L_0x05be:
            r8.close()     // Catch:{ IOException -> 0x05bb }
            goto L_0x061f
        L_0x05c3:
            r1.printStackTrace()
            java.lang.String r1 = "FXNativeImporter : "
            java.lang.String r2 = "AnimationLoader - Load io xxception"
            android.util.Log.w(r1, r2)
            return
        L_0x05ce:
            r0 = move-exception
            r1 = r0
            goto L_0x0620
        L_0x05d2:
            r0 = move-exception
            r1 = r0
            r4 = r3
            goto L_0x05df
        L_0x05d6:
            r0 = move-exception
            r1 = r0
            r4 = r3
            goto L_0x05e3
        L_0x05da:
            r0 = move-exception
            r1 = r0
            goto L_0x05f4
        L_0x05dd:
            r0 = move-exception
            r1 = r0
        L_0x05df:
            r3 = r2
            goto L_0x05ea
        L_0x05e1:
            r0 = move-exception
            r1 = r0
        L_0x05e3:
            r3 = r2
            goto L_0x05ee
        L_0x05e5:
            r0 = move-exception
            r1 = r0
            goto L_0x05f3
        L_0x05e8:
            r0 = move-exception
            r1 = r0
        L_0x05ea:
            r2 = r8
            goto L_0x05f8
        L_0x05ec:
            r0 = move-exception
            r1 = r0
        L_0x05ee:
            r2 = r8
            goto L_0x060d
        L_0x05f0:
            r0 = move-exception
            r1 = r0
            r8 = r2
        L_0x05f3:
            r2 = r3
        L_0x05f4:
            r3 = r4
            goto L_0x0620
        L_0x05f6:
            r0 = move-exception
            r1 = r0
        L_0x05f8:
            r1.printStackTrace()     // Catch:{ all -> 0x05f0 }
            if (r4 == 0) goto L_0x0600
            r4.clear()
        L_0x0600:
            if (r3 == 0) goto L_0x0605
            r3.close()     // Catch:{ IOException -> 0x05bb }
        L_0x0605:
            if (r2 == 0) goto L_0x061f
            r2.close()     // Catch:{ IOException -> 0x05bb }
            goto L_0x061f
        L_0x060b:
            r0 = move-exception
            r1 = r0
        L_0x060d:
            r1.printStackTrace()     // Catch:{ all -> 0x05f0 }
            if (r4 == 0) goto L_0x0615
            r4.clear()
        L_0x0615:
            if (r3 == 0) goto L_0x061a
            r3.close()     // Catch:{ IOException -> 0x05bb }
        L_0x061a:
            if (r2 == 0) goto L_0x061f
            r2.close()     // Catch:{ IOException -> 0x05bb }
        L_0x061f:
            return
        L_0x0620:
            if (r3 == 0) goto L_0x0625
            r3.clear()
        L_0x0625:
            if (r2 == 0) goto L_0x062a
            r2.close()     // Catch:{ IOException -> 0x05bb }
        L_0x062a:
            if (r8 == 0) goto L_0x062f
            r8.close()     // Catch:{ IOException -> 0x05bb }
        L_0x062f:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.b.l.a(net.fxgear.b.p, java.lang.String):void");
    }

    public static int a(ArrayList<i> arrayList, String str) {
        int i = 0;
        while (true) {
            if (i >= arrayList.size()) {
                i = -1;
                break;
            } else if (str.equals(arrayList.get(i).g())) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            Log.i("FXNativeImporter : ", "Root Parent Index = -1 : " + str);
        }
        return i;
    }

    public static q a(float[] fArr) {
        float[] fArr2 = {(fArr[0] * 3.1415927f) / 180.0f, (fArr[1] * 3.1415927f) / 180.0f, (fArr[2] * 3.1415927f) / 180.0f};
        float[] fArr3 = {1.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE};
        float[] fArr4 = {GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE};
        float[] fArr5 = {GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f};
        q qVar = new q(fArr2[0], fArr3);
        return new q(fArr2[2], fArr5).c(new q(fArr2[1], fArr4).c(qVar));
    }

    public static float b(float[] fArr) {
        return (float) Math.sqrt((double) ((fArr[0] * fArr[0]) + (fArr[1] * fArr[1]) + (fArr[2] * fArr[2])));
    }

    public static int d(String str) {
        if (str.equals("ELBOW_LEFT_J")) {
            return 0;
        }
        if (str.equals("ELBOW_TWIST_LEFT_J")) {
            return 1;
        }
        if (str.equals("WRIST_LEFT_J")) {
            return 2;
        }
        if (str.equals("HAND_LEFT_J")) {
            return 3;
        }
        if (str.equals("INDEX_LEFT_1_J")) {
            return 4;
        }
        if (str.equals("INDEX_LEFT_2_J")) {
            return 5;
        }
        if (str.equals("INDEX_LEFT_3_J")) {
            return 6;
        }
        if (str.equals("INDEX_LEFT_4_END")) {
            return 7;
        }
        if (str.equals("MIDDLE_LEFT_1_J")) {
            return 8;
        }
        if (str.equals("MIDDLE_LEFT_2_J")) {
            return 9;
        }
        if (str.equals("MIDDLE_LEFT_3_J")) {
            return 10;
        }
        if (str.equals("MIDDLE_LEFT_4_END")) {
            return 11;
        }
        if (str.equals("PINKIE_LEFT_1_J")) {
            return 12;
        }
        if (str.equals("PINKIE_LEFT_2_J")) {
            return 13;
        }
        if (str.equals("PINKIE_LEFT_3_J")) {
            return 14;
        }
        if (str.equals("PINKIE_LEFT_4_END")) {
            return 15;
        }
        if (str.equals("RING_LEFT_1_J")) {
            return 16;
        }
        if (str.equals("RING_LEFT_2_J")) {
            return 17;
        }
        if (str.equals("RING_LEFT_3_J")) {
            return 18;
        }
        if (str.equals("RING_LEFT_4_END")) {
            return 19;
        }
        if (str.equals("THUMB_LEFT_1_J")) {
            return 20;
        }
        if (str.equals("THUMB_LEFT_2_J")) {
            return 21;
        }
        if (str.equals("THUMB_LEFT_3_J")) {
            return 22;
        }
        if (str.equals("THUMB_LEFT_4_END")) {
            return 23;
        }
        if (str.equals("ELBOW_RIGHT_J")) {
            return 24;
        }
        if (str.equals("ELBOW_TWIST_RIGHT_J")) {
            return 25;
        }
        if (str.equals("WRIST_RIGHT_J")) {
            return 26;
        }
        if (str.equals("HAND_RIGHT_J")) {
            return 27;
        }
        if (str.equals("INDEX_RIGHT_1_J")) {
            return 28;
        }
        if (str.equals("INDEX_RIGHT_2_J")) {
            return 29;
        }
        if (str.equals("INDEX_RIGHT_3_J")) {
            return 30;
        }
        if (str.equals("INDEX_RIGHT_4_END")) {
            return 31;
        }
        if (str.equals("MIDDLE_RIGHT_1_J")) {
            return 32;
        }
        if (str.equals("MIDDLE_RIGHT_2_J")) {
            return 33;
        }
        if (str.equals("MIDDLE_RIGHT_3_J")) {
            return 34;
        }
        if (str.equals("MIDDLE_RIGHT_4_END")) {
            return 35;
        }
        if (str.equals("PINKIE_RIGHT_1_J")) {
            return 36;
        }
        if (str.equals("PINKIE_RIGHT_2_J")) {
            return 37;
        }
        if (str.equals("PINKIE_RIGHT_3_J")) {
            return 38;
        }
        if (str.equals("PINKIE_RIGHT_4_END")) {
            return 39;
        }
        if (str.equals("RING_RIGHT_1_J")) {
            return 40;
        }
        if (str.equals("RING_RIGHT_2_J")) {
            return 41;
        }
        if (str.equals("RING_RIGHT_3_J")) {
            return 42;
        }
        if (str.equals("RING_RIGHT_4_END")) {
            return 43;
        }
        if (str.equals("THUMB_RIGHT_1_J")) {
            return 44;
        }
        if (str.equals("THUMB_RIGHT_2_J")) {
            return 45;
        }
        if (str.equals("THUMB_RIGHT_3_J")) {
            return 46;
        }
        if (str.equals("THUMB_RIGHT_4_END")) {
            return 47;
        }
        if (str.equals("ANKLE_LEFT_J")) {
            return 48;
        }
        if (str.equals("FOOT_LEFT_1_J")) {
            return 49;
        }
        if (str.equals("FOOT_LEFT_2_END")) {
            return 50;
        }
        if (str.equals("KNEE_LEFT_J")) {
            return 51;
        }
        if (str.equals("ANKLE_RIGHT_J")) {
            return 52;
        }
        if (str.equals("FOOT_RIGHT_1_J")) {
            return 53;
        }
        if (str.equals("FOOT_RIGHT_2_END")) {
            return 54;
        }
        if (str.equals("KNEE_RIGHT_J")) {
            return 55;
        }
        if (str.equals("BELLY_J")) {
            return 56;
        }
        if (str.equals("BREAST_LEFT_END")) {
            return 57;
        }
        if (str.equals("BREAST_LEFT_J")) {
            return 58;
        }
        if (str.equals("BREAST_RIGHT_END")) {
            return 59;
        }
        if (str.equals("BREAST_RIGHT_J")) {
            return 60;
        }
        if (str.equals("CHEST_J")) {
            return 61;
        }
        if (str.equals("CLAVICLE_LEFT_J")) {
            return 62;
        }
        if (str.equals("CLAVICLE_RIGHT_J")) {
            return 63;
        }
        if (str.equals("DO")) {
            return 64;
        }
        if (str.equals("HIP_CENTER_J")) {
            return 65;
        }
        if (str.equals("HIP_CENTER_SIZE_J")) {
            return 66;
        }
        if (str.equals("HIP_LEFT_J")) {
            return 67;
        }
        if (str.equals("HIP_RIGHT_J1")) {
            return 68;
        }
        if (str.equals("PELVIS_J")) {
            return 69;
        }
        if (str.equals("SHOULDER_LEFT_J")) {
            return 70;
        }
        if (str.equals("SHOULDER_RIGHT_J")) {
            return 71;
        }
        if (str.equals("SHOULDER_SIZE_J")) {
            return 72;
        }
        if (str.equals("SPINE_J")) {
            return 73;
        }
        if (str.equals("Head_End")) {
            return 74;
        }
        if (str.equals("Head_J")) {
            return 75;
        }
        if (str.equals("Jaw")) {
            return 76;
        }
        if (str.equals("LB")) {
            return 77;
        }
        if (str.equals("LC")) {
            return 78;
        }
        if (str.equals("LF")) {
            return 79;
        }
        if (str.equals("LL")) {
            return 80;
        }
        if (str.equals("LN")) {
            return 81;
        }
        if (str.equals("LO_down")) {
            return 82;
        }
        if (str.equals("LO_up")) {
            return 83;
        }
        if (str.equals("LP")) {
            return 84;
        }
        if (str.equals("LT")) {
            return 85;
        }
        if (str.equals("LZ")) {
            return 86;
        }
        if (str.equals("MM")) {
            return 87;
        }
        if (str.equals("Mouth_root")) {
            return 88;
        }
        if (str.equals("NECK_J")) {
            return 89;
        }
        if (str.equals("PR")) {
            return 90;
        }
        if (str.equals("RB")) {
            return 91;
        }
        if (str.equals("RC")) {
            return 92;
        }
        if (str.equals("RF")) {
            return 93;
        }
        if (str.equals("RN")) {
            return 94;
        }
        if (str.equals("RO_down")) {
            return 95;
        }
        if (str.equals("RO_up")) {
            return 96;
        }
        if (str.equals("RP")) {
            return 97;
        }
        if (str.equals("RR")) {
            return 98;
        }
        if (str.equals("RT")) {
            return 99;
        }
        if (str.equals("RZ")) {
            return 100;
        }
        if (str.equals("UO")) {
            return 101;
        }
        if (str.equals("eye_root")) {
            return 102;
        }
        if (str.equals("teeth_down")) {
            return 103;
        }
        if (str.equals("teeth_up")) {
            return 104;
        }
        if (str.equals("tongue1")) {
            return 105;
        }
        if (str.equals("tongue2")) {
            return 106;
        }
        if (str.equals("tongue3")) {
            return 107;
        }
        if (str.equals("hair_root")) {
            return 108;
        }
        if (str.equals("bl_joint1")) {
            return 109;
        }
        if (str.equals("bl_joint2")) {
            return 110;
        }
        if (str.equals("bl_joint3")) {
            return 111;
        }
        if (str.equals("bl_joint4")) {
            return 112;
        }
        if (str.equals("bl_joint5e")) {
            return 113;
        }
        if (str.equals("br_joint1")) {
            return 114;
        }
        if (str.equals("br_joint2")) {
            return 115;
        }
        if (str.equals("br_joint3")) {
            return 116;
        }
        if (str.equals("br_joint4")) {
            return 117;
        }
        if (str.equals("br_joint5e")) {
            return 118;
        }
        if (str.equals("f_joint1")) {
            return 119;
        }
        if (str.equals("f_joint2")) {
            return 120;
        }
        if (str.equals("f_joint3")) {
            return 121;
        }
        if (str.equals("f_joint4e")) {
            return 122;
        }
        if (str.equals("l_joint1")) {
            return 123;
        }
        if (str.equals("l_joint2")) {
            return 124;
        }
        if (str.equals("l_joint3")) {
            return 125;
        }
        if (str.equals("l_joint4")) {
            return 126;
        }
        if (str.equals("l_joint5e")) {
            return 127;
        }
        if (str.equals("r_joint1")) {
            return 128;
        }
        if (str.equals("r_joint2")) {
            return 129;
        }
        if (str.equals("r_joint3")) {
            return 130;
        }
        if (str.equals("r_joint4")) {
            return 131;
        }
        return str.equals("r_joint5e") ? 132 : -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0111, code lost:
        r11 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0123, code lost:
        r11 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x013d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x013e, code lost:
        r0.printStackTrace();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0123 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:4:0x0009] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0133 A[SYNTHETIC, Splitter:B:58:0x0133] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0139 A[SYNTHETIC, Splitter:B:62:0x0139] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static net.fxgear.b.l.a e(java.lang.String r11) {
        /*
            r0 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x012c }
            java.lang.String r2 = "r"
            r1.<init>(r11, r2)     // Catch:{ IOException -> 0x012c }
            r11 = 2
            byte[] r2 = new byte[r11]     // Catch:{ IOException -> 0x0125, all -> 0x0123 }
            r1.read(r2)     // Catch:{ IOException -> 0x0125, all -> 0x0123 }
            r3 = 0
            byte r4 = r2[r3]     // Catch:{ IOException -> 0x0125, all -> 0x0123 }
            r5 = 70
            if (r4 != r5) goto L_0x0113
            r4 = 1
            byte r2 = r2[r4]     // Catch:{ IOException -> 0x0125, all -> 0x0123 }
            r5 = 88
            if (r2 == r5) goto L_0x001e
            goto L_0x0113
        L_0x001e:
            r2 = 4
            byte[] r5 = new byte[r2]     // Catch:{ IOException -> 0x0125, all -> 0x0123 }
            r1.read(r5)     // Catch:{ IOException -> 0x0125, all -> 0x0123 }
            java.nio.ByteBuffer r5 = java.nio.ByteBuffer.wrap(r5)     // Catch:{ IOException -> 0x0125, all -> 0x0123 }
            java.nio.ByteOrder r6 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ IOException -> 0x0125, all -> 0x0123 }
            java.nio.ByteBuffer r5 = r5.order(r6)     // Catch:{ IOException -> 0x0125, all -> 0x0123 }
            int r5 = r5.getInt()     // Catch:{ IOException -> 0x0125, all -> 0x0123 }
            if (r5 > 0) goto L_0x0053
            java.lang.String r11 = "FXNativeImporter : "
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0125, all -> 0x0123 }
            r2.<init>()     // Catch:{ IOException -> 0x0125, all -> 0x0123 }
            java.lang.String r3 = "[c] ERROR: LoadPackageBin - head length! "
            r2.append(r3)     // Catch:{ IOException -> 0x0125, all -> 0x0123 }
            r2.append(r5)     // Catch:{ IOException -> 0x0125, all -> 0x0123 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x0125, all -> 0x0123 }
            android.util.Log.e(r11, r2)     // Catch:{ IOException -> 0x0125, all -> 0x0123 }
            r1.close()     // Catch:{ IOException -> 0x004e }
            goto L_0x0052
        L_0x004e:
            r11 = move-exception
            r11.printStackTrace()
        L_0x0052:
            return r0
        L_0x0053:
            byte[] r5 = new byte[r5]     // Catch:{ IOException -> 0x0125, all -> 0x0123 }
            r1.read(r5)     // Catch:{ IOException -> 0x0125, all -> 0x0123 }
            java.nio.ByteBuffer r5 = java.nio.ByteBuffer.wrap(r5)     // Catch:{ IOException -> 0x0125, all -> 0x0123 }
            java.nio.ByteOrder r6 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ IOException -> 0x0125, all -> 0x0123 }
            java.nio.ByteBuffer r5 = r5.order(r6)     // Catch:{ IOException -> 0x0125, all -> 0x0123 }
            int r6 = r5.getInt()     // Catch:{ IOException -> 0x0125, all -> 0x0123 }
            int r7 = r5.getInt()     // Catch:{ IOException -> 0x0125, all -> 0x0123 }
            int r5 = r5.getInt()     // Catch:{ IOException -> 0x0125, all -> 0x0123 }
            java.lang.String r8 = "FXNativeImporter : "
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0125, all -> 0x0123 }
            r9.<init>()     // Catch:{ IOException -> 0x0125, all -> 0x0123 }
            java.lang.String r10 = "[c] LoadPackageBin - head version "
            r9.append(r10)     // Catch:{ IOException -> 0x0125, all -> 0x0123 }
            r9.append(r6)     // Catch:{ IOException -> 0x0125, all -> 0x0123 }
            java.lang.String r10 = ", "
            r9.append(r10)     // Catch:{ IOException -> 0x0125, all -> 0x0123 }
            r9.append(r7)     // Catch:{ IOException -> 0x0125, all -> 0x0123 }
            java.lang.String r10 = ", "
            r9.append(r10)     // Catch:{ IOException -> 0x0125, all -> 0x0123 }
            r9.append(r5)     // Catch:{ IOException -> 0x0125, all -> 0x0123 }
            java.lang.String r9 = r9.toString()     // Catch:{ IOException -> 0x0125, all -> 0x0123 }
            android.util.Log.i(r8, r9)     // Catch:{ IOException -> 0x0125, all -> 0x0123 }
            net.fxgear.b.l$a r8 = new net.fxgear.b.l$a     // Catch:{ IOException -> 0x0125, all -> 0x0123 }
            r8.<init>()     // Catch:{ IOException -> 0x0125, all -> 0x0123 }
            r8.f699a = r6     // Catch:{ IOException -> 0x0111, all -> 0x0123 }
            r8.f700b = r7     // Catch:{ IOException -> 0x0111, all -> 0x0123 }
        L_0x009d:
            if (r3 >= r5) goto L_0x0108
            byte[] r0 = new byte[r2]     // Catch:{ IOException -> 0x0111, all -> 0x0123 }
            r1.read(r0)     // Catch:{ IOException -> 0x0111, all -> 0x0123 }
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.wrap(r0)     // Catch:{ IOException -> 0x0111, all -> 0x0123 }
            java.nio.ByteOrder r6 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ IOException -> 0x0111, all -> 0x0123 }
            java.nio.ByteBuffer r0 = r0.order(r6)     // Catch:{ IOException -> 0x0111, all -> 0x0123 }
            int r0 = r0.getInt()     // Catch:{ IOException -> 0x0111, all -> 0x0123 }
            byte[] r6 = new byte[r2]     // Catch:{ IOException -> 0x0111, all -> 0x0123 }
            r1.read(r6)     // Catch:{ IOException -> 0x0111, all -> 0x0123 }
            java.nio.ByteBuffer r6 = java.nio.ByteBuffer.wrap(r6)     // Catch:{ IOException -> 0x0111, all -> 0x0123 }
            java.nio.ByteOrder r7 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ IOException -> 0x0111, all -> 0x0123 }
            java.nio.ByteBuffer r6 = r6.order(r7)     // Catch:{ IOException -> 0x0111, all -> 0x0123 }
            int r6 = r6.getInt()     // Catch:{ IOException -> 0x0111, all -> 0x0123 }
            java.lang.String r7 = "FXNativeImporter : "
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0111, all -> 0x0123 }
            r9.<init>()     // Catch:{ IOException -> 0x0111, all -> 0x0123 }
            java.lang.String r10 = "[c] LoadPackageBin - data "
            r9.append(r10)     // Catch:{ IOException -> 0x0111, all -> 0x0123 }
            r9.append(r0)     // Catch:{ IOException -> 0x0111, all -> 0x0123 }
            java.lang.String r10 = ", "
            r9.append(r10)     // Catch:{ IOException -> 0x0111, all -> 0x0123 }
            r9.append(r6)     // Catch:{ IOException -> 0x0111, all -> 0x0123 }
            java.lang.String r9 = r9.toString()     // Catch:{ IOException -> 0x0111, all -> 0x0123 }
            android.util.Log.i(r7, r9)     // Catch:{ IOException -> 0x0111, all -> 0x0123 }
            byte[] r6 = new byte[r6]     // Catch:{ IOException -> 0x0111, all -> 0x0123 }
            if (r0 != r4) goto L_0x00ed
            r1.read(r6)     // Catch:{ IOException -> 0x0111, all -> 0x0123 }
            r8.c = r6     // Catch:{ IOException -> 0x0111, all -> 0x0123 }
            goto L_0x0105
        L_0x00ed:
            if (r0 != r11) goto L_0x00f5
            r1.read(r6)     // Catch:{ IOException -> 0x0111, all -> 0x0123 }
            r8.d = r6     // Catch:{ IOException -> 0x0111, all -> 0x0123 }
            goto L_0x0105
        L_0x00f5:
            r7 = 3
            if (r0 != r7) goto L_0x00fe
            r1.read(r6)     // Catch:{ IOException -> 0x0111, all -> 0x0123 }
            r8.e = r6     // Catch:{ IOException -> 0x0111, all -> 0x0123 }
            goto L_0x0105
        L_0x00fe:
            if (r0 != r2) goto L_0x0105
            r1.read(r6)     // Catch:{ IOException -> 0x0111, all -> 0x0123 }
            r8.f = r6     // Catch:{ IOException -> 0x0111, all -> 0x0123 }
        L_0x0105:
            int r3 = r3 + 1
            goto L_0x009d
        L_0x0108:
            r1.close()     // Catch:{ IOException -> 0x010c }
            goto L_0x0136
        L_0x010c:
            r11 = move-exception
            r11.printStackTrace()
            goto L_0x0136
        L_0x0111:
            r11 = move-exception
            goto L_0x0127
        L_0x0113:
            java.lang.String r11 = "FXNativeImporter : "
            java.lang.String r2 = "[c] ERROR: LoadPackageBin - head fx!"
            android.util.Log.e(r11, r2)     // Catch:{ IOException -> 0x0125, all -> 0x0123 }
            r1.close()     // Catch:{ IOException -> 0x011e }
            goto L_0x0122
        L_0x011e:
            r11 = move-exception
            r11.printStackTrace()
        L_0x0122:
            return r0
        L_0x0123:
            r11 = move-exception
            goto L_0x0137
        L_0x0125:
            r11 = move-exception
            r8 = r0
        L_0x0127:
            r0 = r1
            goto L_0x012e
        L_0x0129:
            r11 = move-exception
            r1 = r0
            goto L_0x0137
        L_0x012c:
            r11 = move-exception
            r8 = r0
        L_0x012e:
            r11.printStackTrace()     // Catch:{ all -> 0x0129 }
            if (r0 == 0) goto L_0x0136
            r0.close()     // Catch:{ IOException -> 0x010c }
        L_0x0136:
            return r8
        L_0x0137:
            if (r1 == 0) goto L_0x0141
            r1.close()     // Catch:{ IOException -> 0x013d }
            goto L_0x0141
        L_0x013d:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0141:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.b.l.e(java.lang.String):net.fxgear.b.l$a");
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\b\m.java ==========

package net.fxgear.b;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import javax.microedition.khronos.opengles.GL10;
import net.fxgear.GlobalDefine;
import net.fxgear.b.h;
import net.fxgear.fittingview.qlSolver;
import net.fxgear.util.FXUtil;

/* compiled from: FXRenderer */
public class m {
    private FloatBuffer A;
    private FloatBuffer B;
    private int C = -1;
    private int D = -1;
    private int E = 0;
    private long F = 0;
    private double G = -1.0d;
    private int H;
    private int I;
    private int J;
    private int K;
    private int[] L = new int[this.v.length];
    private int M;
    private final int N = 0;
    private final int O = 1;
    private final int P = 2;
    private final int Q = 3;
    private final int R = 4;
    private final int S = 5;
    private final int T = 6;
    private final int U = 7;
    private final int V = 8;
    private final int W = 9;
    private final int X = 10;
    private final int Y = 11;
    private float Z = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;

    /* renamed from: a  reason: collision with root package name */
    float[] f701a = new float[16];
    private int aA = -1;
    private int aB = -1;
    private int aC = -1;
    private int aD = -1;
    private int aE = -1;
    private int aF = -1;
    private int aG = -1;
    private int aH = -1;
    private int aI = -1;
    private int aJ = -1;
    private int aK = -1;
    private int aL = -1;
    private int aM = -1;
    private int aN = -1;
    private int aO = -1;
    private int aP = -1;
    private int aQ = -1;
    private int aR = -1;
    private int aS = -1;
    private int aT = -1;
    private int aU = -1;
    private int aV = -1;
    private int aW = -1;
    private int aX = -1;
    private int aY = -1;
    private int aZ = -1;
    private float aa = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    private float ab = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    private float ac = 200.0f;
    private int ad = 0;
    private int ae = -1;
    private final float af = 15.0f;
    private float ag = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    private float ah = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    private float ai = 1.0f;
    private float aj = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    private final float ak = -1000.0f;
    private final float al = 1000.0f;
    private final float am = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    private final float an = 199.5f;
    private final float ao = 205.0f;
    private final float ap = 215.0f;
    private final float aq = 200.5f;
    private final float ar = 225.0f;
    private final float as = 1000.0f;
    private h.e at = h.e.AVATAR;
    private int au = 0;
    private float av = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
    private float[] aw = {1.0f, 1.0f, 1.0f, 1.0f};
    private float[] ax = {GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f, 1.0f, 1.0f};
    private int ay = -1;
    private int az = -1;

    /* renamed from: b  reason: collision with root package name */
    float[] f702b = new float[16];
    private int[] bA = new int[this.v.length];
    private int[] bB = new int[this.v.length];
    private int[] bC = new int[this.v.length];
    private int[] bD = new int[this.v.length];
    private int[] bE = new int[this.v.length];
    private final float bF = 0.3f;
    private Rect bG = new Rect();
    private qlSolver bH = null;
    private int ba = -1;
    private int bb = -1;
    private int bc = -1;
    private int bd = -1;
    private int be = -1;
    private int bf = -1;
    private int bg = -1;
    private int bh = -1;
    private int bi = -1;
    private int bj = -1;
    private int bk = -1;
    private int bl = -1;
    private int bm = -1;
    private int bn = -1;
    private int[] bo = new int[this.v.length];
    private int[] bp = new int[this.v.length];
    private int[] bq = new int[this.v.length];
    private int[] br = new int[this.v.length];
    private int[] bs = new int[this.v.length];
    private int[] bt = new int[this.v.length];
    private int[] bu = new int[this.v.length];
    private int[] bv = new int[this.v.length];
    private int[] bw = new int[this.v.length];
    private int[] bx = new int[this.v.length];
    private int[] by = new int[this.v.length];
    private int[] bz = new int[this.v.length];
    float[] c = {0.9f, 0.9f, 0.9f, 0.9f};
    float[] d = new float[16];
    int e = 75;
    float f = 1.0f;
    float g = 1.0f;
    float h = 1.0f;
    final float i = 15.0f;
    float[] j = new float[344];
    float[] k = new float[344];
    boolean l = false;
    private final String m = "precision lowp float; \nuniform mat4   uMVPMatrix;\nattribute vec4 aPosition;\nattribute vec2 a_tex_coord;\nvarying vec2   v_tex_coord;\nuniform float  uXScale; \nvoid main() \n{ \n   v_tex_coord = vec2(a_tex_coord.x, 1.0 - a_tex_coord.y); \n   gl_Position = uMVPMatrix * aPosition; \n   gl_Position.x *= uXScale; \n} \n";
    private final String n = "#extension GL_OES_EGL_image_external : require \nprecision lowp float; \nuniform samplerExternalOES sTexture; \nvarying vec2  v_tex_coord; \nvoid main() \n{ \n   gl_FragColor = texture2D(sTexture, v_tex_coord); \n} \n";
    private final String o = "precision lowp float; \nuniform mat4   uMVPMatrix; \nattribute vec4 aPosition; \nattribute vec2 a_tex_coord; \nvarying vec2   v_tex_coord; \nvoid main() \n{ \n   v_tex_coord = vec2(a_tex_coord.x, 1.0 - a_tex_coord.y); \n   gl_Position = uMVPMatrix * aPosition; \n} \n";
    private final String p = "precision lowp float; \nuniform sampler2D sTexture; \nvarying vec2  v_tex_coord; \nvoid main() \n{ \n   gl_FragColor = texture2D(sTexture, v_tex_coord); \n} \n ";
    private final String q = "precision highp float; \nuniform mat4   uMVPMatrix; \nuniform mat4   uROTMatrix; \nuniform vec4   uRealDQ[90]; \nuniform vec4   uDualDQ[90]; \nattribute vec4 aBoneWeight; \nattribute vec4 aBoneIndex; \nattribute vec2 aPartIndex; \nattribute vec4 aPosition; \nattribute vec2 aTexCoord; \nattribute vec3 aNormal; \nattribute float aStrain; \nattribute float aPressure; \nvarying float vStrain;varying float vPressure;varying vec2   vTexCoord; \nvarying vec2   vPart; \nuniform float  uYTrans; \nuniform float  uXTrans; \nuniform float  uXScale; \nuniform float  uHeadScale; \nuniform vec3   uHeadJointPos; \nuniform int    uHeadJointIndex; \nuniform vec2   uImageTrans; \nvoid main() \n{ \n   vec4 blendRealDQ = vec4(0.0); \n   vec4 blendDualDQ = vec4(0.0); \n   float neckScale = 0.0; \n   float neckScaleValue = 1.0; \n   if(int(aBoneIndex.x) == uHeadJointIndex) { neckScaleValue += (uHeadScale-1.0)*aBoneWeight.x; neckScale = 1.0;} \n   if(int(aBoneIndex.y) == uHeadJointIndex) { neckScaleValue += (uHeadScale-1.0)*aBoneWeight.y; neckScale = 1.0;} \n   if(int(aBoneIndex.z) == uHeadJointIndex) { neckScaleValue += (uHeadScale-1.0)*aBoneWeight.z; neckScale = 1.0;} \n   if(int(aBoneIndex.w) == uHeadJointIndex) { neckScaleValue += (uHeadScale-1.0)*aBoneWeight.w; neckScale = 1.0;} \n   blendRealDQ += aBoneWeight.x * uRealDQ[int(aBoneIndex.x)]; \n   blendRealDQ += aBoneWeight.y * uRealDQ[int(aBoneIndex.y)]; \n   blendRealDQ += aBoneWeight.z * uRealDQ[int(aBoneIndex.z)]; \n   blendRealDQ += aBoneWeight.w * uRealDQ[int(aBoneIndex.w)]; \n   blendDualDQ += aBoneWeight.x * uDualDQ[int(aBoneIndex.x)]; \n   blendDualDQ += aBoneWeight.y * uDualDQ[int(aBoneIndex.y)]; \n   blendDualDQ += aBoneWeight.z * uDualDQ[int(aBoneIndex.z)]; \n   blendDualDQ += aBoneWeight.w * uDualDQ[int(aBoneIndex.w)]; \n   float len = length(blendRealDQ); \n   blendRealDQ /= len; \n   blendDualDQ /= len; \n   vec3 pos = aPosition.xyz; \n   pos.y += uYTrans; \n   pos.x += sign(pos.x)*uXTrans;\n   if(neckScale > 0.5 && neckScaleValue != 1.0) {pos -= uHeadJointPos; pos *= neckScaleValue; pos += uHeadJointPos;} \n   pos = pos.xyz + 2.0*cross(blendRealDQ.xyz, cross(blendRealDQ.xyz, pos.xyz) + blendRealDQ.w*pos.xyz); \n   pos += 2.0*(blendRealDQ.w*blendDualDQ.xyz - blendDualDQ.w*blendRealDQ.xyz + cross(blendRealDQ.xyz, blendDualDQ.xyz)); \n   gl_Position = uMVPMatrix * vec4(pos, 1.0); \n   vTexCoord = vec2(aTexCoord.x, 1.0 - aTexCoord.y); \n   vPart = aPartIndex; \n   vStrain = 10.0*aStrain;\n   vPressure = 10.0*aPressure;\n   gl_Position.x *= uXScale;\n   gl_Position.xy += uImageTrans;\n} \n";
    private final String r = "precision lowp float; \nuniform int        uStrainMode;\nuniform vec3       uMaterial; \nuniform vec3       uTone; \nuniform sampler2D  sTexture; \nuniform sampler2D  sTextureHighlight; \nuniform float      uArmFilterMin; \nuniform float      uArmFilterMax; \nuniform float      uShoulderLengthMin; \nuniform float      uShoulderLengthMax; \nuniform int        uHighlightMode; \nuniform int        uDrawPart; \nuniform vec3       uTensionColor; \nuniform vec3       uPressureColor; \nvarying vec2       vTexCoord; \nvarying vec2       vPart; \nvarying float       vStrain;varying float       vPressure;void main() \n{ \n   { \n       if(vPart.r > uArmFilterMax || vPart.r < uArmFilterMin) discard;\n       if(uDrawPart == 1 && vPart.r > 199.5) discard; \n       if(abs(vPart.g) > uShoulderLengthMax || abs(vPart.g) < uShoulderLengthMin) \n       { \n           if(uDrawPart == 1) discard; \n           if(uDrawPart == 2 && vPart.r < 199.5) discard; \n       } \n   } \n   vec4 mainColor = texture2D(sTexture, vTexCoord); \n   if(mainColor.a < 0.5) discard; \n   if(uStrainMode==0)\n   {\n   float mainLumi = (mainColor.r + mainColor.g + mainColor.b)/3.0; \n   mainColor.rgb *= uTone; \n   float tonedLumi = (mainColor.r + mainColor.g + mainColor.b)/3.0; \n   mainColor.rgb *= mainLumi/tonedLumi; \n   gl_FragColor = mainColor; \n   if(uHighlightMode == 1) \n   { \n       vec4 colorMask = texture2D(sTextureHighlight, vTexCoord); \n       gl_FragColor.rgb += colorMask.a*colorMask.rgb; \n   } \n   } else if(uStrainMode==1)\n   {\n   gl_FragColor = vec4((1.0-vStrain)*mainColor.rgb + vStrain*uTensionColor, mainColor.a*0.7); \n   } else if(uStrainMode==2)\n   {\n   gl_FragColor = vec4((1.0-vPressure)*mainColor.rgb + vPressure*uPressureColor, mainColor.a*0.7); \n   }\n} \n";
    private final String s = "precision highp float; \nuniform mat4   uMVPMatrix; \nuniform mat4   uROTMatrix; \nuniform vec4   uRealDQ[90]; \nuniform vec4   uDualDQ[90]; \nattribute vec4 aBoneWeight; \nattribute vec4 aBoneIndex; \nattribute vec4 aPosition; \nattribute vec2 aTexCoord; \nattribute vec3 aNormal; \nvarying vec2   vTexCoord; \nuniform float  uYTrans; \nuniform float  uHeadScale; \nuniform vec3   uHeadJointPos; \nuniform vec2   uImageTrans; \nvoid main() \n{ \n   vec4 blendRealDQ = vec4(0.0); \n   vec4 blendDualDQ = vec4(0.0); \n   float neckScale = 0.0; \n   float neckScaleValue = uHeadScale; \n   blendRealDQ += aBoneWeight.x * uRealDQ[int(aBoneIndex.x)]; \n   blendRealDQ += aBoneWeight.y * uRealDQ[int(aBoneIndex.y)]; \n   blendRealDQ += aBoneWeight.z * uRealDQ[int(aBoneIndex.z)]; \n   blendRealDQ += aBoneWeight.w * uRealDQ[int(aBoneIndex.w)]; \n   blendDualDQ += aBoneWeight.x * uDualDQ[int(aBoneIndex.x)]; \n   blendDualDQ += aBoneWeight.y * uDualDQ[int(aBoneIndex.y)]; \n   blendDualDQ += aBoneWeight.z * uDualDQ[int(aBoneIndex.z)]; \n   blendDualDQ += aBoneWeight.w * uDualDQ[int(aBoneIndex.w)]; \n   float len = length(blendRealDQ); \n   blendRealDQ /= len; \n   blendDualDQ /= len; \n   vec3 pos = aPosition.xyz; \n   pos.y += uYTrans; \n   pos -= uHeadJointPos; pos *= neckScaleValue; pos += uHeadJointPos; \n   pos = pos.xyz + 2.0*cross(blendRealDQ.xyz, cross(blendRealDQ.xyz, pos.xyz) + blendRealDQ.w*pos.xyz); \n   pos += 2.0*(blendRealDQ.w*blendDualDQ.xyz - blendDualDQ.w*blendRealDQ.xyz + cross(blendRealDQ.xyz, blendDualDQ.xyz)); \n   gl_Position = uMVPMatrix * vec4(pos, 1.0); \n   vTexCoord = vec2(aTexCoord.x, 1.0 - aTexCoord.y); \n   gl_Position.xy += uImageTrans;\n} \n";
    private final String t = "precision lowp float; \nconst vec3 cAmbient = vec3(0.1, 0.1, 0.1); \nconst vec3 cColor = vec3(0.7, 0.7, 0.7); \nconst vec3 cEyePos = vec3(0.0, 0.5, 10.50); \nconst vec3 cLightPos = vec3(0.0, 0.6, 10.50); \nconst vec3 cLightDir = vec3(0.0, 0.0, 1.0); \nuniform vec3       uMaterial; \nuniform vec3       uTone; \nuniform sampler2D  sTexture; \nuniform sampler2D  sTextureShadow; \nuniform sampler2D  sTextureHairy; \nvarying vec2       vTexCoord; \nuniform float      uShadowFactor; \nvoid main() \n{ \n   vec4 shadow = texture2D(sTextureShadow, vTexCoord); \n   vec4 hairy = texture2D(sTextureHairy, vTexCoord); \n   vec4 mainColor = texture2D(sTexture, vTexCoord)*(1.0-hairy.a) + hairy; \n   float mainLumi = (mainColor.r + mainColor.g + mainColor.b)/3.0; \n   mainColor.rgb *= uTone; \n   float tonedLumi = (mainColor.r + mainColor.g + mainColor.b)/3.0; \n   mainColor.rgb *= mainLumi/tonedLumi; \n   if(uShadowFactor > 0.0) \n   { \n       gl_FragColor = mainColor * shadow; \n   } \n   else \n   { \n       gl_FragColor = mainColor; \n   } \n} \n";
    private final String u = "precision highp float; \nuniform mat4   uMVPMatrix; \nuniform mat4   uROTMatrix; \nuniform vec4   uRealDQ[90]; \nuniform vec4   uDualDQ[90]; \nattribute vec4 aBoneWeight; \nattribute vec4 aBoneIndex; \nattribute vec4 aPosition; \nattribute vec2 aTexCoord; \nattribute vec3 aNormal; \nvarying vec2   vTexCoord; \nvarying vec3   vNormal; \nvarying vec3   vPos; \nuniform float  uYTrans; \nuniform float  uHeadScale; \nuniform vec3   uHeadJointPos; \nuniform vec2   uImageTrans; \nvoid main() \n{ \n   vec4 blendRealDQ = vec4(0.0); \n   vec4 blendDualDQ = vec4(0.0); \n   float neckScale = 0.0; \n   float neckScaleValue = uHeadScale; \n   blendRealDQ += aBoneWeight.x * uRealDQ[int(aBoneIndex.x)]; \n   blendRealDQ += aBoneWeight.y * uRealDQ[int(aBoneIndex.y)]; \n   blendRealDQ += aBoneWeight.z * uRealDQ[int(aBoneIndex.z)]; \n   blendRealDQ += aBoneWeight.w * uRealDQ[int(aBoneIndex.w)]; \n   blendDualDQ += aBoneWeight.x * uDualDQ[int(aBoneIndex.x)]; \n   blendDualDQ += aBoneWeight.y * uDualDQ[int(aBoneIndex.y)]; \n   blendDualDQ += aBoneWeight.z * uDualDQ[int(aBoneIndex.z)]; \n   blendDualDQ += aBoneWeight.w * uDualDQ[int(aBoneIndex.w)]; \n   float len = length(blendRealDQ); \n   blendRealDQ /= len; \n   blendDualDQ /= len; \n   vec3 qPos = aPosition.xyz; \n   qPos.y += uYTrans; \n   qPos -= uHeadJointPos; qPos *= neckScaleValue; qPos += uHeadJointPos; \n   qPos = qPos.xyz + 2.0*cross(blendRealDQ.xyz, cross(blendRealDQ.xyz, qPos.xyz) + blendRealDQ.w*qPos.xyz); \n   qPos += 2.0*(blendRealDQ.w*blendDualDQ.xyz - blendDualDQ.w*blendRealDQ.xyz + cross(blendRealDQ.xyz, blendDualDQ.xyz)); \n   gl_Position = uMVPMatrix * vec4(qPos, 1.0); \n   vTexCoord = vec2(aTexCoord.x, 1.0 - aTexCoord.y); \n   vec4 normal = uROTMatrix * vec4(aNormal, 1.0); \n   vNormal = normalize(normal.rgb); \n   vPos = qPos; \n   gl_Position.xy += uImageTrans;\n} \n";
    private final String[] v = {"precision lowp float; \nconst vec3 cEyePos = vec3(0.0, 0.5, 10.50); \nuniform float      uMaterial[13]; \nuniform float      uAlphaThreshold; \nuniform sampler2D  sTexture; \nuniform sampler2D  sTextureSpec; \nvarying vec2       vTexCoord; \nvarying vec3       vNormal; \nvarying vec3       vPos; \nvoid main() \n{ \n   vec4 mainTex = texture2D(sTexture, vTexCoord); \n   vec4 specTex = texture2D(sTextureSpec, vTexCoord); \n   float alpha = mainTex.a; \n   if(alpha < uAlphaThreshold) discard; \n   vec3 L1 = normalize(vPos - vec3(uMaterial[6], uMaterial[7], uMaterial[8])); \n   vec3 L2 = normalize(vPos - vec3(uMaterial[9], uMaterial[10], uMaterial[11])); \n   vec3 L = vec3(uMaterial[3], uMaterial[4], uMaterial[5]); \n   vec3 V = normalize(vPos - cEyePos); \n   vec3 H = normalize((L1 + V)/2.0); \n   vec3 H1 = normalize((L2 + V)/2.0); \n   float DotNL = abs(dot(vNormal, L)); \n   float DotNH = clamp(1.0-abs(dot(vNormal, H)), 0.0, 1.0); \n   float DotNH1 = clamp(1.0-abs(dot(vNormal, H1)), 0.0, 1.0); \n   vec3 albedo = (mainTex.rgb / mainTex.a); \n   vec3 ambient = albedo * uMaterial[0]; \n   vec3 diffuse = albedo * DotNL * uMaterial[1]; \n   vec3 spec = vec3(0.2, 0.2, 0.2) * pow(DotNH, uMaterial[12]) * specTex.r * uMaterial[2] ; \n   vec3 spec1 = vec3(0.2, 0.2, 0.2) * pow(DotNH1, uMaterial[12]) * specTex.r * uMaterial[2] ; \n   gl_FragColor.rgb = (ambient + diffuse + spec + spec1); \n   gl_FragColor.a = alpha; \n} \n", "precision lowp float; \nuniform vec3       uMaterial; \nuniform float      uAlphaThreshold; \nuniform sampler2D  sTexture; \nvarying vec2       vTexCoord; \nvarying vec3       vNormal; \nvarying vec3       vPos; \nvoid main() \n{ \n   vec4 mainTex = texture2D(sTexture, vTexCoord); \n   if(mainTex.a >= uAlphaThreshold || mainTex.a <= 0.001) discard; \n   gl_FragColor.rgb = mainTex.rgb / mainTex.a; \n   gl_FragColor.a = mainTex.a; \n} \n", "precision lowp float; \nconst vec3 cEyePos = vec3(0.0, 0.5, 10.50); \nuniform float      uMaterial[13]; \nuniform float      uAlphaThreshold; \nuniform sampler2D  sTexture; \nvarying vec2       vTexCoord; \nvarying vec3       vNormal; \nvarying vec3       vPos; \nvoid main() \n{ \n   vec4 mainTex = texture2D(sTexture, vTexCoord); \n   vec3 L1 = normalize(vPos - vec3(uMaterial[6], uMaterial[7], uMaterial[8])); \n   vec3 L2 = normalize(vPos - vec3(uMaterial[9], uMaterial[10], uMaterial[11])); \n   vec3 L = vec3(uMaterial[3], uMaterial[4], uMaterial[5]); \n   vec3 V = normalize(vPos - cEyePos); \n   vec3 H = normalize((L1 + V)/2.0); \n   vec3 H1 = normalize((L2 + V)/2.0); \n   float DotNL = abs(dot(vNormal, L)); \n   float DotNH = clamp(1.0-abs(dot(vNormal, H)), 0.0, 1.0); \n   float DotNH1 = clamp(1.0-abs(dot(vNormal, H1)), 0.0, 1.0); \n   vec3 albedo = mainTex.rgb; \n   vec3 ambient = albedo * uMaterial[0]; \n   vec3 diffuse = albedo * DotNL * uMaterial[1]; \n   vec3 spec = vec3(0.2, 0.2, 0.2) * pow(DotNH, uMaterial[12]) * uMaterial[2] ; \n   vec3 spec1 = vec3(0.2, 0.2, 0.2) * pow(DotNH1, uMaterial[12]) * uMaterial[2] ; \n   gl_FragColor.rgb = (ambient + diffuse + spec + spec1); \n   gl_FragColor.a = 1.0; \n} \n"};
    private final String w = "precision highp float; \nuniform mat4   uMVPMatrix; \nuniform float  uPointSize; \nattribute vec4 aPosition; \nvarying float  vDeem; \nuniform vec2   uImageTrans; \nvoid main() \n{ \n   vec4 pos = aPosition; \n   pos.w = 1.0; \n   vDeem = aPosition.w; \n   gl_Position = uMVPMatrix * pos; \n   gl_PointSize = uPointSize; \n   gl_Position.xy += uImageTrans;\n} \n";
    private final String x = "precision highp float; \nuniform vec4   uColor; \nvarying float  vDeem; \nvoid main() \n{ \n   gl_FragColor = uColor*vDeem; \n} \n";
    private b y;
    private n z;

    public void a(qlSolver qlsolver) {
        this.bH = qlsolver;
    }

    public m(n nVar) {
        this.y = new b(nVar);
        this.z = nVar;
        float[] fArr = {-405.0f, -540.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 405.0f, -540.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, -405.0f, 540.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f, 405.0f, 540.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f, 1.0f};
        this.A = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.A.put(fArr).position(0);
        float[] fArr2 = {-0.5f, -0.5f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 0.5f, -0.5f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, -0.5f, 0.5f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f, 0.5f, 0.5f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f, 1.0f};
        this.B = ByteBuffer.allocateDirect(fArr2.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.B.put(fArr2).position(0);
    }

    public void a() {
        IntBuffer allocate = IntBuffer.allocate(1);
        IntBuffer allocate2 = IntBuffer.allocate(3);
        GLES20.glGetIntegerv(36347, allocate);
        GLES20.glGetIntegerv(3379, allocate2);
        int i2 = allocate.get(0);
        allocate.clear();
        Log.i("FXSkeletalAnimationRenderer : ", "Max Uniform Component is " + i2);
        GLES20.glClearColor(0.2f, 0.2f, 0.2f, 0.2f);
        GLES20.glClearDepthf(1.0f);
        GLES20.glClearStencil(0);
        this.H = o.a("precision lowp float; \nuniform mat4   uMVPMatrix;\nattribute vec4 aPosition;\nattribute vec2 a_tex_coord;\nvarying vec2   v_tex_coord;\nuniform float  uXScale; \nvoid main() \n{ \n   v_tex_coord = vec2(a_tex_coord.x, 1.0 - a_tex_coord.y); \n   gl_Position = uMVPMatrix * aPosition; \n   gl_Position.x *= uXScale; \n} \n", "#extension GL_OES_EGL_image_external : require \nprecision lowp float; \nuniform samplerExternalOES sTexture; \nvarying vec2  v_tex_coord; \nvoid main() \n{ \n   gl_FragColor = texture2D(sTexture, v_tex_coord); \n} \n");
        this.I = o.a("precision lowp float; \nuniform mat4   uMVPMatrix; \nattribute vec4 aPosition; \nattribute vec2 a_tex_coord; \nvarying vec2   v_tex_coord; \nvoid main() \n{ \n   v_tex_coord = vec2(a_tex_coord.x, 1.0 - a_tex_coord.y); \n   gl_Position = uMVPMatrix * aPosition; \n} \n", "precision lowp float; \nuniform sampler2D sTexture; \nvarying vec2  v_tex_coord; \nvoid main() \n{ \n   gl_FragColor = texture2D(sTexture, v_tex_coord); \n} \n ");
        this.J = o.a("precision highp float; \nuniform mat4   uMVPMatrix; \nuniform mat4   uROTMatrix; \nuniform vec4   uRealDQ[90]; \nuniform vec4   uDualDQ[90]; \nattribute vec4 aBoneWeight; \nattribute vec4 aBoneIndex; \nattribute vec2 aPartIndex; \nattribute vec4 aPosition; \nattribute vec2 aTexCoord; \nattribute vec3 aNormal; \nattribute float aStrain; \nattribute float aPressure; \nvarying float vStrain;varying float vPressure;varying vec2   vTexCoord; \nvarying vec2   vPart; \nuniform float  uYTrans; \nuniform float  uXTrans; \nuniform float  uXScale; \nuniform float  uHeadScale; \nuniform vec3   uHeadJointPos; \nuniform int    uHeadJointIndex; \nuniform vec2   uImageTrans; \nvoid main() \n{ \n   vec4 blendRealDQ = vec4(0.0); \n   vec4 blendDualDQ = vec4(0.0); \n   float neckScale = 0.0; \n   float neckScaleValue = 1.0; \n   if(int(aBoneIndex.x) == uHeadJointIndex) { neckScaleValue += (uHeadScale-1.0)*aBoneWeight.x; neckScale = 1.0;} \n   if(int(aBoneIndex.y) == uHeadJointIndex) { neckScaleValue += (uHeadScale-1.0)*aBoneWeight.y; neckScale = 1.0;} \n   if(int(aBoneIndex.z) == uHeadJointIndex) { neckScaleValue += (uHeadScale-1.0)*aBoneWeight.z; neckScale = 1.0;} \n   if(int(aBoneIndex.w) == uHeadJointIndex) { neckScaleValue += (uHeadScale-1.0)*aBoneWeight.w; neckScale = 1.0;} \n   blendRealDQ += aBoneWeight.x * uRealDQ[int(aBoneIndex.x)]; \n   blendRealDQ += aBoneWeight.y * uRealDQ[int(aBoneIndex.y)]; \n   blendRealDQ += aBoneWeight.z * uRealDQ[int(aBoneIndex.z)]; \n   blendRealDQ += aBoneWeight.w * uRealDQ[int(aBoneIndex.w)]; \n   blendDualDQ += aBoneWeight.x * uDualDQ[int(aBoneIndex.x)]; \n   blendDualDQ += aBoneWeight.y * uDualDQ[int(aBoneIndex.y)]; \n   blendDualDQ += aBoneWeight.z * uDualDQ[int(aBoneIndex.z)]; \n   blendDualDQ += aBoneWeight.w * uDualDQ[int(aBoneIndex.w)]; \n   float len = length(blendRealDQ); \n   blendRealDQ /= len; \n   blendDualDQ /= len; \n   vec3 pos = aPosition.xyz; \n   pos.y += uYTrans; \n   pos.x += sign(pos.x)*uXTrans;\n   if(neckScale > 0.5 && neckScaleValue != 1.0) {pos -= uHeadJointPos; pos *= neckScaleValue; pos += uHeadJointPos;} \n   pos = pos.xyz + 2.0*cross(blendRealDQ.xyz, cross(blendRealDQ.xyz, pos.xyz) + blendRealDQ.w*pos.xyz); \n   pos += 2.0*(blendRealDQ.w*blendDualDQ.xyz - blendDualDQ.w*blendRealDQ.xyz + cross(blendRealDQ.xyz, blendDualDQ.xyz)); \n   gl_Position = uMVPMatrix * vec4(pos, 1.0); \n   vTexCoord = vec2(aTexCoord.x, 1.0 - aTexCoord.y); \n   vPart = aPartIndex; \n   vStrain = 10.0*aStrain;\n   vPressure = 10.0*aPressure;\n   gl_Position.x *= uXScale;\n   gl_Position.xy += uImageTrans;\n} \n", "precision lowp float; \nuniform int        uStrainMode;\nuniform vec3       uMaterial; \nuniform vec3       uTone; \nuniform sampler2D  sTexture; \nuniform sampler2D  sTextureHighlight; \nuniform float      uArmFilterMin; \nuniform float      uArmFilterMax; \nuniform float      uShoulderLengthMin; \nuniform float      uShoulderLengthMax; \nuniform int        uHighlightMode; \nuniform int        uDrawPart; \nuniform vec3       uTensionColor; \nuniform vec3       uPressureColor; \nvarying vec2       vTexCoord; \nvarying vec2       vPart; \nvarying float       vStrain;varying float       vPressure;void main() \n{ \n   { \n       if(vPart.r > uArmFilterMax || vPart.r < uArmFilterMin) discard;\n       if(uDrawPart == 1 && vPart.r > 199.5) discard; \n       if(abs(vPart.g) > uShoulderLengthMax || abs(vPart.g) < uShoulderLengthMin) \n       { \n           if(uDrawPart == 1) discard; \n           if(uDrawPart == 2 && vPart.r < 199.5) discard; \n       } \n   } \n   vec4 mainColor = texture2D(sTexture, vTexCoord); \n   if(mainColor.a < 0.5) discard; \n   if(uStrainMode==0)\n   {\n   float mainLumi = (mainColor.r + mainColor.g + mainColor.b)/3.0; \n   mainColor.rgb *= uTone; \n   float tonedLumi = (mainColor.r + mainColor.g + mainColor.b)/3.0; \n   mainColor.rgb *= mainLumi/tonedLumi; \n   gl_FragColor = mainColor; \n   if(uHighlightMode == 1) \n   { \n       vec4 colorMask = texture2D(sTextureHighlight, vTexCoord); \n       gl_FragColor.rgb += colorMask.a*colorMask.rgb; \n   } \n   } else if(uStrainMode==1)\n   {\n   gl_FragColor = vec4((1.0-vStrain)*mainColor.rgb + vStrain*uTensionColor, mainColor.a*0.7); \n   } else if(uStrainMode==2)\n   {\n   gl_FragColor = vec4((1.0-vPressure)*mainColor.rgb + vPressure*uPressureColor, mainColor.a*0.7); \n   }\n} \n");
        GLES20.glUseProgram(this.J);
        this.ay = GLES20.glGetUniformLocation(this.J, "uRealDQ");
        this.az = GLES20.glGetUniformLocation(this.J, "uDualDQ");
        this.aA = GLES20.glGetUniformLocation(this.J, "uMVPMatrix");
        this.aB = GLES20.glGetUniformLocation(this.J, "uROTMatrix");
        this.aC = GLES20.glGetUniformLocation(this.J, "uMaterial");
        this.aD = GLES20.glGetUniformLocation(this.J, "uStrainMode");
        this.aE = GLES20.glGetUniformLocation(this.J, "uYTrans");
        this.aF = GLES20.glGetUniformLocation(this.J, "uXTrans");
        this.aG = GLES20.glGetUniformLocation(this.J, "uXScale");
        this.aH = GLES20.glGetUniformLocation(this.J, "uTone");
        this.aI = GLES20.glGetUniformLocation(this.J, "uHeadScale");
        this.aJ = GLES20.glGetUniformLocation(this.J, "uHeadJointPos");
        this.aK = GLES20.glGetUniformLocation(this.J, "uHeadJointIndex");
        this.aL = GLES20.glGetUniformLocation(this.J, "sTexture");
        this.aM = GLES20.glGetUniformLocation(this.J, "sTextureHighlight");
        this.aN = GLES20.glGetUniformLocation(this.J, "uHighlightMode");
        this.aO = GLES20.glGetAttribLocation(this.J, "aPosition");
        this.aP = GLES20.glGetAttribLocation(this.J, "aStrain");
        this.aQ = GLES20.glGetAttribLocation(this.J, "aPressure");
        this.aR = GLES20.glGetAttribLocation(this.J, "aTexCoord");
        this.aS = GLES20.glGetAttribLocation(this.J, "aNormal");
        this.aT = GLES20.glGetAttribLocation(this.J, "aBoneIndex");
        this.aU = GLES20.glGetAttribLocation(this.J, "aBoneWeight");
        this.aV = GLES20.glGetAttribLocation(this.J, "aPartIndex");
        this.K = o.a("precision highp float; \nuniform mat4   uMVPMatrix; \nuniform mat4   uROTMatrix; \nuniform vec4   uRealDQ[90]; \nuniform vec4   uDualDQ[90]; \nattribute vec4 aBoneWeight; \nattribute vec4 aBoneIndex; \nattribute vec4 aPosition; \nattribute vec2 aTexCoord; \nattribute vec3 aNormal; \nvarying vec2   vTexCoord; \nuniform float  uYTrans; \nuniform float  uHeadScale; \nuniform vec3   uHeadJointPos; \nuniform vec2   uImageTrans; \nvoid main() \n{ \n   vec4 blendRealDQ = vec4(0.0); \n   vec4 blendDualDQ = vec4(0.0); \n   float neckScale = 0.0; \n   float neckScaleValue = uHeadScale; \n   blendRealDQ += aBoneWeight.x * uRealDQ[int(aBoneIndex.x)]; \n   blendRealDQ += aBoneWeight.y * uRealDQ[int(aBoneIndex.y)]; \n   blendRealDQ += aBoneWeight.z * uRealDQ[int(aBoneIndex.z)]; \n   blendRealDQ += aBoneWeight.w * uRealDQ[int(aBoneIndex.w)]; \n   blendDualDQ += aBoneWeight.x * uDualDQ[int(aBoneIndex.x)]; \n   blendDualDQ += aBoneWeight.y * uDualDQ[int(aBoneIndex.y)]; \n   blendDualDQ += aBoneWeight.z * uDualDQ[int(aBoneIndex.z)]; \n   blendDualDQ += aBoneWeight.w * uDualDQ[int(aBoneIndex.w)]; \n   float len = length(blendRealDQ); \n   blendRealDQ /= len; \n   blendDualDQ /= len; \n   vec3 pos = aPosition.xyz; \n   pos.y += uYTrans; \n   pos -= uHeadJointPos; pos *= neckScaleValue; pos += uHeadJointPos; \n   pos = pos.xyz + 2.0*cross(blendRealDQ.xyz, cross(blendRealDQ.xyz, pos.xyz) + blendRealDQ.w*pos.xyz); \n   pos += 2.0*(blendRealDQ.w*blendDualDQ.xyz - blendDualDQ.w*blendRealDQ.xyz + cross(blendRealDQ.xyz, blendDualDQ.xyz)); \n   gl_Position = uMVPMatrix * vec4(pos, 1.0); \n   vTexCoord = vec2(aTexCoord.x, 1.0 - aTexCoord.y); \n   gl_Position.xy += uImageTrans;\n} \n", "precision lowp float; \nconst vec3 cAmbient = vec3(0.1, 0.1, 0.1); \nconst vec3 cColor = vec3(0.7, 0.7, 0.7); \nconst vec3 cEyePos = vec3(0.0, 0.5, 10.50); \nconst vec3 cLightPos = vec3(0.0, 0.6, 10.50); \nconst vec3 cLightDir = vec3(0.0, 0.0, 1.0); \nuniform vec3       uMaterial; \nuniform vec3       uTone; \nuniform sampler2D  sTexture; \nuniform sampler2D  sTextureShadow; \nuniform sampler2D  sTextureHairy; \nvarying vec2       vTexCoord; \nuniform float      uShadowFactor; \nvoid main() \n{ \n   vec4 shadow = texture2D(sTextureShadow, vTexCoord); \n   vec4 hairy = texture2D(sTextureHairy, vTexCoord); \n   vec4 mainColor = texture2D(sTexture, vTexCoord)*(1.0-hairy.a) + hairy; \n   float mainLumi = (mainColor.r + mainColor.g + mainColor.b)/3.0; \n   mainColor.rgb *= uTone; \n   float tonedLumi = (mainColor.r + mainColor.g + mainColor.b)/3.0; \n   mainColor.rgb *= mainLumi/tonedLumi; \n   if(uShadowFactor > 0.0) \n   { \n       gl_FragColor = mainColor * shadow; \n   } \n   else \n   { \n       gl_FragColor = mainColor; \n   } \n} \n");
        GLES20.glUseProgram(this.K);
        this.aW = GLES20.glGetUniformLocation(this.K, "uRealDQ");
        this.aX = GLES20.glGetUniformLocation(this.K, "uDualDQ");
        this.aY = GLES20.glGetUniformLocation(this.K, "uMVPMatrix");
        this.aZ = GLES20.glGetUniformLocation(this.K, "uROTMatrix");
        this.ba = GLES20.glGetUniformLocation(this.K, "uMaterial");
        this.bb = GLES20.glGetUniformLocation(this.K, "uYTrans");
        this.bc = GLES20.glGetUniformLocation(this.K, "uTone");
        this.bd = GLES20.glGetUniformLocation(this.K, "uHeadScale");
        this.be = GLES20.glGetUniformLocation(this.K, "uHeadJointPos");
        this.bf = GLES20.glGetUniformLocation(this.K, "uHeadJointIndex");
        this.bg = GLES20.glGetUniformLocation(this.K, "sTexture");
        this.bh = GLES20.glGetUniformLocation(this.K, "sTextureShadow");
        this.bi = GLES20.glGetUniformLocation(this.K, "sTextureHairy");
        this.bj = GLES20.glGetAttribLocation(this.K, "aPosition");
        this.bk = GLES20.glGetAttribLocation(this.K, "aTexCoord");
        this.bl = GLES20.glGetAttribLocation(this.K, "aNormal");
        this.bm = GLES20.glGetAttribLocation(this.K, "aBoneIndex");
        this.bn = GLES20.glGetAttribLocation(this.K, "aBoneWeight");
        for (int i3 = 0; i3 < this.v.length; i3++) {
            this.L[i3] = o.a("precision highp float; \nuniform mat4   uMVPMatrix; \nuniform mat4   uROTMatrix; \nuniform vec4   uRealDQ[90]; \nuniform vec4   uDualDQ[90]; \nattribute vec4 aBoneWeight; \nattribute vec4 aBoneIndex; \nattribute vec4 aPosition; \nattribute vec2 aTexCoord; \nattribute vec3 aNormal; \nvarying vec2   vTexCoord; \nvarying vec3   vNormal; \nvarying vec3   vPos; \nuniform float  uYTrans; \nuniform float  uHeadScale; \nuniform vec3   uHeadJointPos; \nuniform vec2   uImageTrans; \nvoid main() \n{ \n   vec4 blendRealDQ = vec4(0.0); \n   vec4 blendDualDQ = vec4(0.0); \n   float neckScale = 0.0; \n   float neckScaleValue = uHeadScale; \n   blendRealDQ += aBoneWeight.x * uRealDQ[int(aBoneIndex.x)]; \n   blendRealDQ += aBoneWeight.y * uRealDQ[int(aBoneIndex.y)]; \n   blendRealDQ += aBoneWeight.z * uRealDQ[int(aBoneIndex.z)]; \n   blendRealDQ += aBoneWeight.w * uRealDQ[int(aBoneIndex.w)]; \n   blendDualDQ += aBoneWeight.x * uDualDQ[int(aBoneIndex.x)]; \n   blendDualDQ += aBoneWeight.y * uDualDQ[int(aBoneIndex.y)]; \n   blendDualDQ += aBoneWeight.z * uDualDQ[int(aBoneIndex.z)]; \n   blendDualDQ += aBoneWeight.w * uDualDQ[int(aBoneIndex.w)]; \n   float len = length(blendRealDQ); \n   blendRealDQ /= len; \n   blendDualDQ /= len; \n   vec3 qPos = aPosition.xyz; \n   qPos.y += uYTrans; \n   qPos -= uHeadJointPos; qPos *= neckScaleValue; qPos += uHeadJointPos; \n   qPos = qPos.xyz + 2.0*cross(blendRealDQ.xyz, cross(blendRealDQ.xyz, qPos.xyz) + blendRealDQ.w*qPos.xyz); \n   qPos += 2.0*(blendRealDQ.w*blendDualDQ.xyz - blendDualDQ.w*blendRealDQ.xyz + cross(blendRealDQ.xyz, blendDualDQ.xyz)); \n   gl_Position = uMVPMatrix * vec4(qPos, 1.0); \n   vTexCoord = vec2(aTexCoord.x, 1.0 - aTexCoord.y); \n   vec4 normal = uROTMatrix * vec4(aNormal, 1.0); \n   vNormal = normalize(normal.rgb); \n   vPos = qPos; \n   gl_Position.xy += uImageTrans;\n} \n", this.v[i3]);
            GLES20.glUseProgram(this.L[i3]);
            this.bo[i3] = GLES20.glGetUniformLocation(this.L[i3], "uRealDQ");
            this.bp[i3] = GLES20.glGetUniformLocation(this.L[i3], "uDualDQ");
            this.bq[i3] = GLES20.glGetUniformLocation(this.L[i3], "uMVPMatrix");
            this.br[i3] = GLES20.glGetUniformLocation(this.L[i3], "uROTMatrix");
            this.bs[i3] = GLES20.glGetUniformLocation(this.L[i3], "uMaterial");
            this.bt[i3] = GLES20.glGetUniformLocation(this.L[i3], "uAlphaThreshold");
            this.bu[i3] = GLES20.glGetUniformLocation(this.L[i3], "uYTrans");
            this.bv[i3] = GLES20.glGetUniformLocation(this.L[i3], "uHeadScale");
            this.bw[i3] = GLES20.glGetUniformLocation(this.L[i3], "uHeadJointPos");
            this.bx[i3] = GLES20.glGetUniformLocation(this.L[i3], "uHeadJointIndex");
            this.by[i3] = GLES20.glGetUniformLocation(this.L[i3], "sTexture");
            this.bz[i3] = GLES20.glGetUniformLocation(this.L[i3], "sTextureSpec");
            this.bA[i3] = GLES20.glGetAttribLocation(this.L[i3], "aPosition");
            this.bB[i3] = GLES20.glGetAttribLocation(this.L[i3], "aTexCoord");
            this.bC[i3] = GLES20.glGetAttribLocation(this.L[i3], "aNormal");
            this.bD[i3] = GLES20.glGetAttribLocation(this.L[i3], "aBoneIndex");
            this.bE[i3] = GLES20.glGetAttribLocation(this.L[i3], "aBoneWeight");
        }
        this.M = o.a("precision highp float; \nuniform mat4   uMVPMatrix; \nuniform float  uPointSize; \nattribute vec4 aPosition; \nvarying float  vDeem; \nuniform vec2   uImageTrans; \nvoid main() \n{ \n   vec4 pos = aPosition; \n   pos.w = 1.0; \n   vDeem = aPosition.w; \n   gl_Position = uMVPMatrix * pos; \n   gl_PointSize = uPointSize; \n   gl_Position.xy += uImageTrans;\n} \n", "precision highp float; \nuniform vec4   uColor; \nvarying float  vDeem; \nvoid main() \n{ \n   gl_FragColor = uColor*vDeem; \n} \n");
        this.F = System.nanoTime();
        GLES20.glFrontFace(2304);
    }

    public void a(int i2, int i3) {
        this.ag = (float) i2;
        this.ah = (float) i3;
        GLES20.glViewport(0, 0, i2, i3);
        Matrix.setIdentityM(this.f702b, 0);
        Matrix.orthoM(this.f702b, 0, -0.5f, 0.5f, -0.5f, 0.5f, -1.0f, 1.0E-5f);
        a(this.ai, this.aj);
    }

    public void a(float f2, float f3) {
        if (f2 != GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
            float f4 = this.ag / this.ah;
            this.ai = f2;
            this.aj = f3;
            Matrix.setIdentityM(this.f701a, 0);
            Matrix.orthoM(this.f701a, 0, (((-f4) * 1080.0f) / 2.0f) / f2, ((f4 * 1080.0f) / 2.0f) / f2, (-540.0f / f2) - f3, (540.0f / f2) - f3, -10.0f, 10.0f);
        }
    }

    public void a(GL10 gl10) {
        if (this.A != null) {
            this.A.clear();
            this.A = null;
        }
        if (this.B != null) {
            this.B.clear();
            this.B = null;
        }
        if (this.D != -1) {
            GLES20.glDeleteTextures(1, new int[]{this.D}, 0);
            this.D = -1;
        }
        if (this.z != null) {
            this.z.e(gl10);
            this.z.f(gl10);
            this.z.g(gl10);
            this.z = null;
        }
        if (this.y != null) {
            this.y.a();
            this.y = null;
        }
    }

    public void b() {
        this.F = System.nanoTime();
    }

    public void a(h.e eVar) {
        b();
        this.at = eVar;
    }

    public void a(boolean z2) {
        if (z2) {
            double nanoTime = (double) (System.nanoTime() - this.F);
            Double.isNaN(nanoTime);
            this.G = nanoTime * 1.0E-9d;
            return;
        }
        double nanoTime2 = (double) System.nanoTime();
        Double.isNaN(nanoTime2);
        this.F = (long) (nanoTime2 - (this.G / 1.0E-9d));
        this.G = -1.0d;
    }

    public boolean c() {
        return this.G != -1.0d;
    }

    public h.e d() {
        return this.at;
    }

    public void a(int i2) {
        this.ae = i2;
    }

    public int e() {
        return this.ae;
    }

    public void b(int i2) {
        this.au = i2;
    }

    public int f() {
        return this.au;
    }

    public float c(int i2) {
        return (this.z.f(i2) == null || this.z.f(i2).f671b == null) ? GlobalDefine.DEFAULT_AUTO_FILTER_VALUE : this.z.f(i2).f671b.ac();
    }

    public String d(int i2) {
        return this.z.b(i2).n();
    }

    public p e(int i2) {
        return this.z.b(i2);
    }

    public b g() {
        if (this.y != null) {
            return this.y;
        }
        Log.e("FXSkeletalAnimationRenderer : ", "Renderer does not have Animator, plz initialize renderer and attach animator");
        return null;
    }

    public void f(int i2) {
        this.C = i2;
    }

    public void a(Bitmap bitmap, int i2) {
        if (this.D != -1) {
            GLES20.glDeleteTextures(1, new int[]{this.D}, 0);
        }
        this.D = l.a(bitmap, i2);
    }

    public void a(GL10 gl10, float[] fArr, int i2, int i3, int i4, boolean z2, boolean z3) {
        int i5 = this.au;
        this.ag = (float) i2;
        this.ah = (float) i3;
        GLES20.glViewport(0, 0, i2, i3);
        switch (this.at) {
            case AVATAR:
                this.f = this.h;
                a(fArr, i5);
                b(fArr, i2, i3, i5, z2, z3);
                return;
            case CHECK_CLOTHES_SIZE:
            case AVATAR_CUSTOM_FACE_EDITING:
            case AVATAR_FACE_EDITING:
                this.f = this.h;
                break;
            case AVATAR_HAIR_EDITING:
                break;
            case AVATAR_SKIN_TONE_EDITING:
            case AVATAR_BODY_EDITING:
                break;
            case REAL:
                this.f = this.g;
                a(fArr, i5);
                a(fArr, i2, i3, i5, i4, z2, z3);
                return;
            default:
                Log.e("FXSkeletalAnimationRenderer : ", "Mode is illegal : " + this.at);
                return;
        }
        this.f = this.h;
        this.f = this.h;
        c(fArr, i2, i3, i5, z2, z3);
    }

    private void a(float[] fArr, p pVar) {
        if (this.z.n(this.au) != 0) {
            GLES20.glUseProgram(this.J);
            GLES20.glUniform4fv(this.ay, 90, this.z.g(this.au), 0);
            GLES20.glUniform4fv(this.az, 90, this.z.h(this.au), 0);
            GLES20.glUniform1i(this.aL, 0);
            GLES20.glUniform1i(this.aM, 1);
            GLES20.glUniformMatrix4fv(this.aA, 1, false, fArr, 0);
            GLES20.glUniformMatrix4fv(this.aB, 1, false, this.d, 0);
            GLES20.glUniform3f(this.aC, 1.0f, 0.2f, 0.1f);
            GLES20.glUniform3f(this.aJ, pVar.f(this.e)[0], pVar.f(this.e)[1], pVar.f(this.e)[2]);
            GLES20.glUniform1i(this.aK, this.e);
            GLES20.glUniform1f(this.aG, this.f);
            GLES20.glUniform2f(GLES20.glGetUniformLocation(this.J, "uImageTrans"), pVar.i[0], pVar.i[1]);
        }
    }

    private void b(float[] fArr, p pVar) {
        if (this.z.n(this.au) != 0) {
            this.z.b(this.au, this.j);
            this.z.d(this.au, this.k);
            GLES20.glUseProgram(this.K);
            GLES20.glUniform4fv(this.aW, 86, this.j, 0);
            GLES20.glUniform4fv(this.aX, 86, this.k, 0);
            GLES20.glUniform1i(this.bg, 0);
            GLES20.glUniform1i(this.bh, 1);
            GLES20.glUniform1i(this.bi, 2);
            GLES20.glUniformMatrix4fv(this.aY, 1, false, fArr, 0);
            GLES20.glUniformMatrix4fv(this.aZ, 1, false, this.d, 0);
            GLES20.glUniform3f(this.ba, 0.8f, 0.2f, 0.1f);
            GLES20.glUniform3f(this.be, pVar.f(this.e)[0], pVar.f(this.e)[1], pVar.f(this.e)[2]);
            GLES20.glUniform1i(this.bf, this.e);
            GLES20.glUniform2f(GLES20.glGetUniformLocation(this.K, "uImageTrans"), pVar.i[0], pVar.i[1]);
        }
    }

    private void c(float[] fArr, p pVar) {
        if (this.z.n(this.au) != 0) {
            if (pVar.a() != null) {
                this.z.c(this.au, this.j);
                this.z.e(this.au, this.k);
            } else {
                this.z.b(this.au, this.j);
                this.z.d(this.au, this.k);
            }
            System.arraycopy(fArr, 0, this.d, 0, this.d.length);
            this.d[3] = 0.0f;
            this.d[7] = 0.0f;
            this.d[11] = 0.0f;
            this.d[12] = 0.0f;
            this.d[13] = 0.0f;
            this.d[14] = 0.0f;
            this.d[15] = 1.0f;
            for (int i2 = 0; i2 < this.L.length; i2++) {
                GLES20.glUseProgram(this.L[i2]);
                GLES20.glUniform4fv(this.bo[i2], 86, this.j, 0);
                GLES20.glUniform4fv(this.bp[i2], 86, this.k, 0);
                GLES20.glUniform1i(this.by[i2], 0);
                GLES20.glUniform1i(this.bz[i2], 1);
                GLES20.glUniformMatrix4fv(this.bq[i2], 1, false, fArr, 0);
                GLES20.glUniformMatrix4fv(this.br[i2], 1, false, this.d, 0);
                GLES20.glUniform3f(this.bw[i2], pVar.f(this.e)[0], pVar.f(this.e)[1], pVar.f(this.e)[2]);
                GLES20.glUniform1i(this.bx[i2], this.e);
                GLES20.glUniform2f(GLES20.glGetUniformLocation(this.L[i2], "uImageTrans"), pVar.i[0], pVar.i[1]);
            }
        }
    }

    private void b(float[] fArr, int i2, int i3, int i4, boolean z2, boolean z3) {
        if (this.z.b(i4) != null && this.z.b(i4).E() != null) {
            if (this.z.b(i4).a() == null || this.z.b(i4).a().E() != null) {
                GLES20.glClearColor(this.c[0], this.c[1], this.c[2], this.c[3]);
                GLES20.glClearStencil(0);
                GLES20.glClear(17664);
                h();
                long nanoTime = System.nanoTime();
                double d2 = (double) (nanoTime - this.F);
                Double.isNaN(d2);
                double d3 = d2 * 1.0E-9d;
                if (d3 > ((double) this.z.o(i4))) {
                    this.F = nanoTime;
                    d3 = 0.0d;
                }
                try {
                    if (this.G >= 0.0d) {
                        d3 = this.G;
                    }
                    if (this.at == h.e.CHECK_CLOTHES_SIZE && this.bH != null && this.bH.c() == h.f.SIZE_SIMULATION) {
                        this.y.a(-1, i4);
                    } else {
                        this.y.a((float) d3, i4);
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                a(fArr, this.z.b(i4));
                b(fArr, this.z.b(i4));
                c(fArr, this.z.b(i4));
                c(i4, this.z.b(i4).k());
                if (this.l) {
                    b(fArr, this.ax, i4);
                }
            }
        }
    }

    private void c(float[] fArr, int i2, int i3, int i4, boolean z2, boolean z3) {
        if (this.z.b(i4) != null && this.z.b(i4).E() != null) {
            if (this.z.b(i4).a() == null || this.z.b(i4).a().E() != null) {
                GLES20.glClearColor(this.c[0], this.c[1], this.c[2], this.c[3]);
                GLES20.glClearStencil(0);
                GLES20.glClear(17664);
                h();
                try {
                    this.y.a(-1, i4);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                a(fArr, this.z.b(i4));
                b(fArr, this.z.b(i4));
                c(fArr, this.z.b(i4));
                c(i4, this.z.b(i4).k());
                if (this.l) {
                    a(fArr, this.aw, i4);
                }
            }
        }
    }

    private void a(float[] fArr, int i2, int i3, int i4, int i5, boolean z2, boolean z3) {
        if (this.z.b(i4) != null && this.z.b(i4).E() != null) {
            GLES20.glClearColor(0.76171875f, 0.765625f, 0.75390625f, 1.0f);
            GLES20.glClearStencil(0);
            GLES20.glClear(17664);
            if (z3) {
                i();
            }
            this.av = ((float) i5) / 1000.0f;
            if (i5 < 0) {
                this.av = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            }
            if (this.av > this.z.o(i4)) {
                this.av = this.z.o(i4);
            }
            if (z2) {
                this.y.a(this.av, i4);
                a(fArr, this.z.b(i4));
                c(i4, this.z.b(i4).k());
            }
            if (this.l) {
                b(fArr, this.ax, i4);
            }
        }
    }

    public Bitmap a(float[] fArr, int i2, int i3, int i4, boolean z2, boolean z3, boolean z4) {
        if (this.z.b(i4) == null) {
            return null;
        }
        this.y.a(z2 ? -2 : -1, i4);
        a(fArr, this.z.b(i4));
        b(fArr, this.z.b(i4));
        c(fArr, this.z.b(i4));
        return a(fArr, i2, i3, i4, z3, z4);
    }

    private void i() {
        GLES20.glUseProgram(this.H);
        GLES20.glVertexAttribPointer(GLES20.glGetAttribLocation(this.H, "aPosition"), 3, 5126, false, 20, this.A.position(0));
        GLES20.glVertexAttribPointer(GLES20.glGetAttribLocation(this.H, "a_tex_coord"), 2, 5126, false, 20, this.A.position(3));
        GLES20.glEnableVertexAttribArray(GLES20.glGetAttribLocation(this.H, "aPosition"));
        GLES20.glEnableVertexAttribArray(GLES20.glGetAttribLocation(this.H, "a_tex_coord"));
        GLES20.glUniform1f(GLES20.glGetUniformLocation(this.H, "uXScale"), this.f);
        GLES20.glUniform1i(GLES20.glGetUniformLocation(this.H, "sTexture"), 0);
        GLES20.glUniform2f(GLES20.glGetUniformLocation(this.H, "uResolution"), this.ag, this.ah);
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.H, "uMVPMatrix"), 1, false, this.f701a, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, this.C);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glBindTexture(36197, 0);
        GLES20.glDisableVertexAttribArray(GLES20.glGetAttribLocation(this.H, "aPosition"));
        GLES20.glDisableVertexAttribArray(GLES20.glGetAttribLocation(this.H, "a_tex_coord"));
    }

    public void h() {
        if (this.D == -1) {
            Log.e("FXSkeletalAnimationRenderer : ", "[c] ERROR: DrawBG() - mBGTexture == -1");
            return;
        }
        GLES20.glUseProgram(this.I);
        GLES20.glVertexAttribPointer(GLES20.glGetAttribLocation(this.I, "aPosition"), 3, 5126, false, 20, this.B.position(0));
        GLES20.glVertexAttribPointer(GLES20.glGetAttribLocation(this.I, "a_tex_coord"), 2, 5126, false, 20, this.B.position(3));
        GLES20.glEnableVertexAttribArray(GLES20.glGetAttribLocation(this.I, "aPosition"));
        GLES20.glEnableVertexAttribArray(GLES20.glGetAttribLocation(this.I, "a_tex_coord"));
        GLES20.glUniform1i(GLES20.glGetUniformLocation(this.I, "sTexture"), 0);
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.I, "uMVPMatrix"), 1, false, this.f702b, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.D);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glBindTexture(3553, 0);
        GLES20.glDisableVertexAttribArray(GLES20.glGetAttribLocation(this.I, "aPosition"));
        GLES20.glDisableVertexAttribArray(GLES20.glGetAttribLocation(this.I, "a_tex_coord"));
    }

    private int a(c cVar) {
        int i2 = (cVar.g != null && cVar.f == null && cVar.e == null && cVar.h == null) ? 1 : 0;
        if (cVar.g == null && cVar.f != null && cVar.e == null && cVar.h == null) {
            i2 = 2;
        }
        if (cVar.g == null && cVar.f == null && cVar.e != null && cVar.h == null) {
            i2 = 3;
        }
        if (cVar.g == null && cVar.f == null && cVar.e == null && cVar.h != null) {
            i2 = 4;
        }
        if (cVar.g != null && cVar.f != null && cVar.e == null && cVar.h == null) {
            i2 = 5;
        }
        if (cVar.g != null && cVar.f == null && cVar.e != null && cVar.h == null) {
            i2 = 6;
        }
        if (cVar.g == null && cVar.f == null && cVar.e != null && cVar.h != null) {
            i2 = 7;
        }
        if (cVar.g == null && cVar.f != null && cVar.e != null && cVar.h == null) {
            i2 = 8;
        }
        if (!(cVar.g == null || cVar.f == null || cVar.e == null || cVar.h != null)) {
            i2 = 9;
        }
        if (cVar.g == null && cVar.f != null && cVar.e == null && cVar.h != null) {
            i2 = 10;
        }
        if (cVar.g != null || cVar.f == null || cVar.e == null || cVar.h == null) {
            return i2;
        }
        return 11;
    }

    private void c(int i2, int i3) {
        c f2 = this.z.f(i2);
        if (i2 == 4) {
            int a2 = a(f2);
            if (a2 == 8 || a2 == 9 || a2 == 7) {
                int i4 = 0;
                if (i3 != 0) {
                    if (i3 == 1) {
                        i4 = 1;
                    } else if (i3 == 2) {
                        i4 = 2;
                    } else if (i3 == 3) {
                        i4 = 3;
                    }
                }
                a(f2, this.z.f(i4), a2, true, i3);
                return;
            }
            b(f2);
        } else if (f2.f670a == null || f2.f671b == null || f2.c == null || !f2.f670a.m() || !f2.f671b.m() || !f2.c.m()) {
            Log.e("FXSkeletalAnimationRenderer : ", "[c] ERROR: DrawMesh() - avatarRef mesh != CheckResourceValidation()");
        } else {
            int a3 = a(f2);
            if (this.at == h.e.CHECK_CLOTHES_SIZE && this.bH != null && this.bH.d() != h.c.Color) {
                a(f2, a3);
            } else if (a3 == 8 || a3 == 9 || a3 == 7 || a3 == 11) {
                c(f2, a3, true, i3);
            } else {
                a(f2, a3, true, i3);
            }
        }
    }

    private void a(k kVar, int i2, boolean z2, boolean z3) {
        int i3 = i2;
        if (kVar != null && !kVar.h() && kVar.m()) {
            GLES20.glUseProgram(this.J);
            if (z3) {
                GLES20.glEnable(2929);
            }
            if (kVar.P() == h.d.BODY) {
                GLES20.glUniform3f(this.aC, 1.0f, 0.2f, 0.1f);
            } else {
                GLES20.glUniform3f(this.aC, 1.0f, 0.1f, 0.05f);
            }
            if (this.at == h.e.CHECK_CLOTHES_SIZE && this.bH != null && this.bH.c() == h.f.SIZE_SIMULATION && (kVar.P() == h.d.INNER || kVar.P() == h.d.PANTS || kVar.P() == h.d.JACK || kVar.P() == h.d.COAT || kVar.P() == h.d.ONEPIECE)) {
                GLES20.glUniform1i(this.aD, this.bH.d().ordinal());
            } else {
                GLES20.glUniform1i(this.aD, 0);
            }
            GLES20.glUniform1f(this.aE, kVar.ac());
            GLES20.glUniform1f(this.aF, kVar.ad());
            GLES20.glUniform3f(this.aH, kVar.n()[0], kVar.n()[1], kVar.n()[2]);
            GLES20.glUniform1f(this.aI, kVar.o());
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.J, "uShoulderLengthMin"), this.Z);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.J, "uShoulderLengthMax"), this.aa);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.J, "uArmFilterMin"), this.ab);
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.J, "uArmFilterMax"), this.ac);
            GLES20.glUniform1i(GLES20.glGetUniformLocation(this.J, "uDrawPart"), this.ad);
            float[] w2 = kVar.w();
            float[] x2 = kVar.x();
            GLES20.glUniform3f(GLES20.glGetUniformLocation(this.J, "uTensionColor"), w2[0], w2[1], w2[2]);
            GLES20.glUniform3f(GLES20.glGetUniformLocation(this.J, "uPressureColor"), x2[0], x2[1], x2[2]);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, kVar.R());
            if (this.ae == -1) {
                GLES20.glUniform1i(this.aN, 0);
                GLES20.glActiveTexture(33985);
                GLES20.glBindTexture(3553, 0);
            } else if (kVar.T() != null) {
                GLES20.glActiveTexture(33985);
                GLES20.glBindTexture(3553, kVar.T()[this.ae]);
                GLES20.glUniform1i(this.aN, 1);
            } else {
                GLES20.glActiveTexture(33985);
                GLES20.glBindTexture(3553, 0);
                GLES20.glUniform1i(this.aN, 0);
            }
            GLES20.glBindBuffer(34962, kVar.F());
            GLES20.glVertexAttribPointer(this.aO, 3, 5126, false, 0, 0);
            GLES20.glEnableVertexAttribArray(this.aO);
            if (kVar.G() >= 0) {
                GLES20.glBindBuffer(34962, kVar.G());
                GLES20.glVertexAttribPointer(this.aP, 1, 5126, false, 0, 0);
                GLES20.glEnableVertexAttribArray(this.aP);
            }
            if (kVar.H() >= 0) {
                GLES20.glBindBuffer(34962, kVar.H());
                GLES20.glVertexAttribPointer(this.aQ, 1, 5126, false, 0, 0);
                GLES20.glEnableVertexAttribArray(this.aQ);
            }
            GLES20.glBindBuffer(34962, kVar.I());
            GLES20.glVertexAttribPointer(this.aR, 2, 5126, false, 0, 0);
            GLES20.glEnableVertexAttribArray(this.aR);
            if (this.aS >= 0 && kVar.J() >= 0) {
                GLES20.glBindBuffer(34962, kVar.J());
                GLES20.glVertexAttribPointer(this.aS, 3, 5126, false, 0, 0);
                GLES20.glEnableVertexAttribArray(this.aS);
            }
            GLES20.glBindBuffer(34962, kVar.L());
            GLES20.glVertexAttribPointer(this.aT, 4, 5126, false, 0, 0);
            GLES20.glEnableVertexAttribArray(this.aT);
            GLES20.glBindBuffer(34962, kVar.M());
            GLES20.glVertexAttribPointer(this.aU, 4, 5126, false, 0, 0);
            GLES20.glEnableVertexAttribArray(this.aU);
            GLES20.glBindBuffer(34962, kVar.K());
            GLES20.glVertexAttribPointer(this.aV, 2, 5126, false, 0, 0);
            GLES20.glEnableVertexAttribArray(this.aV);
            if (z2) {
                GLES20.glEnable(3042);
                GLES20.glBlendFunc(770, 771);
            }
            if (i3 != 0) {
                if (i3 != 1032) {
                    switch (i3) {
                        case 1028:
                            GLES20.glEnable(2884);
                            GLES20.glCullFace(1029);
                            break;
                        case 1029:
                            GLES20.glEnable(2884);
                            GLES20.glCullFace(1028);
                            break;
                    }
                } else {
                    GLES20.glDisable(2884);
                }
            }
            GLES20.glBindBuffer(34963, kVar.N());
            GLES20.glDrawElements(4, kVar.O(), 5123, 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, 0);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindBuffer(34963, 0);
            GLES20.glBindBuffer(34962, 0);
            GLES20.glDisable(3042);
            GLES20.glDisable(2929);
            GLES20.glDisable(2884);
            GLES20.glDisableVertexAttribArray(this.aO);
            GLES20.glDisableVertexAttribArray(this.aR);
            if (this.aS >= 0) {
                GLES20.glDisableVertexAttribArray(this.aS);
            }
            GLES20.glDisableVertexAttribArray(this.aT);
            GLES20.glDisableVertexAttribArray(this.aU);
            GLES20.glDisableVertexAttribArray(this.aV);
        }
    }

    private void a(k kVar, k kVar2, int i2, boolean z2) {
        if (kVar == null) {
            Log.i("FXSkeletalAnimationRenderer : ", "DrawDQSModel_HEAD : currMesh is null.");
        } else if (!kVar.h()) {
            if (!kVar.m()) {
                Log.e("FXSkeletalAnimationRenderer : ", "DrawDQSModel_HEAD : currMesh is not valid");
                return;
            }
            GLES20.glUseProgram(this.K);
            GLES20.glEnable(2929);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, kVar.R());
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, kVar2.W());
            GLES20.glActiveTexture(33986);
            GLES20.glBindTexture(3553, kVar2.X());
            GLES20.glUniform1f(GLES20.glGetUniformLocation(this.K, "uShadowFactor"), 1.0f);
            GLES20.glUniform1f(this.bb, kVar.ac());
            GLES20.glUniform3f(this.bc, kVar.n()[0], kVar.n()[1], kVar.n()[2]);
            GLES20.glUniform1f(this.bd, kVar.o());
            GLES20.glBindBuffer(34962, kVar.F());
            GLES20.glVertexAttribPointer(this.bj, 3, 5126, false, 0, 0);
            GLES20.glEnableVertexAttribArray(this.bj);
            GLES20.glBindBuffer(34962, kVar.I());
            GLES20.glVertexAttribPointer(this.bk, 2, 5126, false, 0, 0);
            GLES20.glEnableVertexAttribArray(this.bk);
            if (kVar.J() >= 0) {
                GLES20.glBindBuffer(34962, kVar.J());
                GLES20.glVertexAttribPointer(this.bl, 3, 5126, false, 0, 0);
                GLES20.glEnableVertexAttribArray(this.bl);
            }
            GLES20.glBindBuffer(34962, kVar.L());
            GLES20.glVertexAttribPointer(this.bm, 4, 5126, false, 0, 0);
            GLES20.glEnableVertexAttribArray(this.bm);
            GLES20.glBindBuffer(34962, kVar.M());
            GLES20.glVertexAttribPointer(this.bn, 4, 5126, false, 0, 0);
            GLES20.glEnableVertexAttribArray(this.bn);
            if (z2) {
                GLES20.glEnable(3042);
                GLES20.glBlendFunc(770, 771);
            }
            if (i2 != 0) {
                switch (i2) {
                    case 1028:
                        GLES20.glEnable(2884);
                        GLES20.glCullFace(1029);
                        break;
                    case 1029:
                        GLES20.glEnable(2884);
                        GLES20.glCullFace(1028);
                        break;
                }
            }
            GLES20.glBindBuffer(34963, kVar.N());
            GLES20.glDrawElements(4, kVar.O(), 5123, 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, 0);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindBuffer(34963, 0);
            GLES20.glBindBuffer(34962, 0);
            GLES20.glDisable(3042);
            GLES20.glDisable(2884);
            GLES20.glDisable(2929);
            GLES20.glDisableVertexAttribArray(this.bj);
            GLES20.glDisableVertexAttribArray(this.bk);
        }
    }

    private void b(k kVar, k kVar2, int i2, boolean z2) {
        if (kVar == null || kVar.h()) {
            return;
        }
        if (!kVar.m()) {
            Log.e("FXSkeletalAnimationRenderer : ", "DrawDQSModel_HAIR : currMesh is not valid");
            return;
        }
        int i3 = 0;
        while (i3 < 3) {
            int i4 = i3 > 1 ? 1 : i3;
            GLES20.glUseProgram(this.L[i4]);
            if (i3 == 0) {
                GLES20.glEnable(2929);
                GLES20.glDepthFunc(515);
                GLES20.glDepthMask(true);
                GLES20.glDisable(3042);
                GLES20.glDisable(2884);
                GLES20.glUniform1fv(this.bs[i4], kVar.p().length, kVar.p(), 0);
            } else if (i3 == 1) {
                GLES20.glEnable(2929);
                GLES20.glDepthFunc(515);
                GLES20.glDepthMask(false);
                GLES20.glEnable(3042);
                GLES20.glBlendFunc(770, 771);
                GLES20.glEnable(2884);
                GLES20.glCullFace(1028);
            } else if (i3 == 2) {
                GLES20.glEnable(2929);
                GLES20.glDepthFunc(515);
                GLES20.glDepthMask(false);
                GLES20.glEnable(3042);
                GLES20.glBlendFunc(770, 771);
                GLES20.glEnable(2884);
                GLES20.glCullFace(1029);
            }
            GLES20.glUniform1f(this.bu[i4], kVar.ac());
            GLES20.glUniform1f(this.bv[i4], kVar.o());
            GLES20.glUniform1f(this.bt[i4], kVar.p()[13]);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, kVar.U());
            if (i4 == 0) {
                GLES20.glActiveTexture(33985);
                GLES20.glBindTexture(3553, kVar.V());
            }
            GLES20.glBindBuffer(34962, kVar.F());
            GLES20.glVertexAttribPointer(this.bA[i4], 3, 5126, false, 0, 0);
            GLES20.glEnableVertexAttribArray(this.bA[i4]);
            GLES20.glBindBuffer(34962, kVar.I());
            GLES20.glVertexAttribPointer(this.bB[i4], 2, 5126, false, 0, 0);
            GLES20.glEnableVertexAttribArray(this.bB[i4]);
            if (i4 == 0) {
                GLES20.glBindBuffer(34962, kVar.J());
                GLES20.glVertexAttribPointer(this.bC[i4], 3, 5126, false, 0, 0);
                GLES20.glEnableVertexAttribArray(this.bC[i4]);
            }
            GLES20.glBindBuffer(34962, kVar.L());
            GLES20.glVertexAttribPointer(this.bD[i4], 4, 5126, false, 0, 0);
            GLES20.glEnableVertexAttribArray(this.bD[i4]);
            GLES20.glBindBuffer(34962, kVar.M());
            GLES20.glVertexAttribPointer(this.bE[i4], 4, 5126, false, 0, 0);
            GLES20.glEnableVertexAttribArray(this.bE[i4]);
            GLES20.glBindBuffer(34963, kVar.N());
            GLES20.glDrawElements(4, kVar.O(), 5123, 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, 0);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindBuffer(34963, 0);
            GLES20.glBindBuffer(34962, 0);
            GLES20.glDisableVertexAttribArray(this.bA[i4]);
            GLES20.glDisableVertexAttribArray(this.bB[i4]);
            if (i4 == 0) {
                GLES20.glDisableVertexAttribArray(this.bC[i4]);
            }
            GLES20.glDisableVertexAttribArray(this.bD[i4]);
            GLES20.glDisableVertexAttribArray(this.bE[i4]);
            i3++;
        }
        if (!(kVar2 == null || kVar == null)) {
            GLES20.glUseProgram(this.L[2]);
            GLES20.glEnable(2929);
            GLES20.glDepthFunc(515);
            GLES20.glDepthMask(true);
            GLES20.glDisable(3042);
            GLES20.glDisable(2884);
            GLES20.glUniform1fv(this.bs[2], kVar2.p().length, kVar2.p(), 0);
            GLES20.glUniform1f(this.bu[2], kVar.ac());
            GLES20.glUniform1f(this.bv[2], kVar.o());
            GLES20.glUniform1f(this.bt[2], 1.0f);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, kVar.U());
            GLES20.glBindBuffer(34962, kVar2.F());
            GLES20.glVertexAttribPointer(this.bA[2], 3, 5126, false, 0, 0);
            GLES20.glEnableVertexAttribArray(this.bA[2]);
            GLES20.glBindBuffer(34962, kVar2.I());
            GLES20.glVertexAttribPointer(this.bB[2], 2, 5126, false, 0, 0);
            GLES20.glEnableVertexAttribArray(this.bB[2]);
            GLES20.glBindBuffer(34962, kVar2.J());
            GLES20.glVertexAttribPointer(this.bC[2], 3, 5126, false, 0, 0);
            GLES20.glEnableVertexAttribArray(this.bC[2]);
            GLES20.glBindBuffer(34962, kVar2.L());
            GLES20.glVertexAttribPointer(this.bD[2], 4, 5126, false, 0, 0);
            GLES20.glEnableVertexAttribArray(this.bD[2]);
            GLES20.glBindBuffer(34962, kVar2.M());
            GLES20.glVertexAttribPointer(this.bE[2], 4, 5126, false, 0, 0);
            GLES20.glEnableVertexAttribArray(this.bE[2]);
            GLES20.glBindBuffer(34963, kVar2.N());
            GLES20.glDrawElements(4, kVar2.O(), 5123, 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, 0);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindBuffer(34963, 0);
            GLES20.glBindBuffer(34962, 0);
            GLES20.glDisableVertexAttribArray(this.bA[2]);
            GLES20.glDisableVertexAttribArray(this.bB[2]);
            GLES20.glDisableVertexAttribArray(this.bC[2]);
            GLES20.glDisableVertexAttribArray(this.bD[2]);
            GLES20.glDisableVertexAttribArray(this.bE[2]);
        }
        GLES20.glDisable(2929);
        GLES20.glDepthMask(true);
        GLES20.glDisable(3042);
        GLES20.glDisable(2884);
    }

    public Bitmap a(float[] fArr, int i2, int i3, int i4, boolean z2, boolean z3) {
        int i5;
        int i6 = i2;
        int i7 = i3;
        int i8 = i4;
        Bitmap createBitmap = Bitmap.createBitmap(i6, i7, Bitmap.Config.ARGB_8888);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i6 * i7 * 4);
        int[] iArr = {0};
        int[] iArr2 = {0};
        int[] iArr3 = {0};
        GLES20.glGenFramebuffers(1, iArr, 0);
        GLES20.glGenRenderbuffers(1, iArr2, 0);
        GLES20.glGenTextures(1, iArr3, 0);
        GLES20.glBindRenderbuffer(36161, iArr2[0]);
        GLES20.glRenderbufferStorage(36161, 35056, i6, i7);
        GLES20.glBindTexture(3553, iArr3[0]);
        GLES20.glTexImage2D(3553, 0, 6407, i2, i3, 0, 6407, 5121, (Buffer) null);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        int[] iArr4 = iArr;
        GLES20.glBindFramebuffer(36160, iArr4[0]);
        int[] iArr5 = iArr3;
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, iArr5[0], 0);
        int[] iArr6 = iArr2;
        GLES20.glFramebufferRenderbuffer(36160, 36096, 36161, iArr6[0]);
        GLES20.glFramebufferRenderbuffer(36160, 36128, 36161, iArr6[0]);
        if (GLES20.glCheckFramebufferStatus(36160) == 36053) {
            Log.i("FXSkeletalAnimationRenderer : ", "Capture framebuffer bind success.");
        } else {
            int glGetError = GLES20.glGetError();
            Log.i("FXSkeletalAnimationRenderer : ", "Capture framebuffer bind fails. gl error : " + glGetError);
        }
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glViewport(0, 0, i6, i7);
        GLES20.glBindFramebuffer(36160, iArr4[0]);
        GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        GLES20.glClearStencil(0);
        GLES20.glClear(17664);
        if (z3) {
            h();
        }
        if (z2) {
            int a2 = a(this.z.f(i8));
            if (a2 == 8 || a2 == 9 || a2 == 7 || a2 == 11) {
                c(this.z.f(i8), a2, true, this.z.b(i8).k());
            } else {
                a(this.z.f(i8), a2, true, this.z.b(i8).k());
            }
        } else {
            c(this.z.f(i8), a(this.z.f(i8)), false, this.z.b(i8).k());
        }
        GLES20.glFinish();
        allocateDirect.position(0);
        int[] iArr7 = iArr5;
        GLES20.glReadPixels(0, 0, i2, i3, 6408, 5121, allocateDirect);
        createBitmap.copyPixelsFromBuffer(allocateDirect);
        GLES20.glBindFramebuffer(36160, 0);
        if (iArr4[0] != 0) {
            i5 = 1;
            GLES20.glDeleteFramebuffers(1, iArr4, 0);
        } else {
            i5 = 1;
        }
        if (iArr6[0] != 0) {
            GLES20.glDeleteRenderbuffers(i5, iArr6, 0);
        }
        if (iArr7[0] != 0) {
            GLES20.glDeleteTextures(i5, iArr7, 0);
        }
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.postScale(1.0f, -1.0f);
        Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, 0, 0, createBitmap.getWidth(), createBitmap.getHeight(), matrix, true);
        if (createBitmap2 != null && !createBitmap2.equals(createBitmap)) {
            createBitmap.recycle();
        }
        return createBitmap2;
    }

    private void a(float[] fArr, float[] fArr2, int i2) {
        float[] fArr3 = fArr;
        int i3 = i2;
        int i4 = this.M;
        GLES20.glUseProgram(i4);
        GLES20.glDisable(2929);
        GLES20.glDisable(2960);
        float[] i5 = this.z.i(i3);
        float[] l2 = this.z.l(i3);
        if (i5 != null) {
            int length = i5.length;
            FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect((length * 32) / 8).order(ByteOrder.nativeOrder()).asFloatBuffer();
            asFloatBuffer.put(i5).position(0);
            int length2 = l2.length;
            FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect((length2 * 32) / 8).order(ByteOrder.nativeOrder()).asFloatBuffer();
            asFloatBuffer2.put(l2).position(0);
            int glGetAttribLocation = GLES20.glGetAttribLocation(i4, "aPosition");
            int glGetUniformLocation = GLES20.glGetUniformLocation(i4, "uMVPMatrix");
            int glGetUniformLocation2 = GLES20.glGetUniformLocation(i4, "uColor");
            GLES20.glUseProgram(i4);
            GLES20.glEnableVertexAttribArray(glGetAttribLocation);
            FloatBuffer floatBuffer = asFloatBuffer2;
            int i6 = glGetUniformLocation2;
            GLES20.glVertexAttribPointer(glGetAttribLocation, 4, 5126, false, 0, asFloatBuffer);
            GLES20.glUniformMatrix4fv(glGetUniformLocation, 1, false, fArr3, 0);
            GLES20.glUniform4f(i6, fArr2[0], fArr2[1], fArr2[2], fArr2[3]);
            GLES20.glDrawArrays(0, 0, length / 4);
            GLES20.glVertexAttribPointer(glGetAttribLocation, 4, 5126, false, 0, floatBuffer);
            GLES20.glUniformMatrix4fv(glGetUniformLocation, 1, false, fArr3, 0);
            GLES20.glUniform4f(i6, 1.0f, 1.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f);
            GLES20.glDrawArrays(1, 0, length2 / 4);
            GLES20.glDisableVertexAttribArray(glGetAttribLocation);
        }
    }

    private void b(float[] fArr, float[] fArr2, int i2) {
        int i3 = i2;
        int i4 = this.M;
        GLES20.glUseProgram(i4);
        GLES20.glDisable(2929);
        GLES20.glDisable(2960);
        float[] j2 = this.z.j(i3);
        if (j2 != null) {
            float[] m2 = this.z.m(i3);
            float[] k2 = this.z.k(i3);
            int length = j2.length;
            FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect((length * 32) / 8).order(ByteOrder.nativeOrder()).asFloatBuffer();
            asFloatBuffer.put(j2).position(0);
            int length2 = m2.length;
            FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect((length2 * 32) / 8).order(ByteOrder.nativeOrder()).asFloatBuffer();
            asFloatBuffer2.put(m2).position(0);
            int length3 = k2.length;
            FloatBuffer asFloatBuffer3 = ByteBuffer.allocateDirect((length3 * 32) / 8).order(ByteOrder.nativeOrder()).asFloatBuffer();
            asFloatBuffer3.put(k2).position(0);
            int glGetAttribLocation = GLES20.glGetAttribLocation(i4, "aPosition");
            int glGetUniformLocation = GLES20.glGetUniformLocation(i4, "uMVPMatrix");
            int glGetUniformLocation2 = GLES20.glGetUniformLocation(i4, "uColor");
            int glGetUniformLocation3 = GLES20.glGetUniformLocation(i4, "uPointSize");
            GLES20.glUniform2f(GLES20.glGetUniformLocation(i4, "uImageTrans"), this.z.b(i3).i[0], this.z.b(i3).i[1]);
            GLES20.glEnableVertexAttribArray(glGetAttribLocation);
            GLES20.glUniformMatrix4fv(glGetUniformLocation, 1, false, fArr, 0);
            GLES20.glUniform1f(glGetUniformLocation3, 5.0f);
            int i5 = glGetUniformLocation2;
            GLES20.glVertexAttribPointer(glGetAttribLocation, 4, 5126, false, 0, asFloatBuffer2);
            GLES20.glUniform4f(i5, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f);
            GLES20.glDrawArrays(1, 0, 214);
            GLES20.glUniform4f(i5, 1.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f);
            GLES20.glDrawArrays(1, 214, (length2 / 4) - 214);
            int i6 = glGetAttribLocation;
            GLES20.glVertexAttribPointer(i6, 4, 5126, false, 0, asFloatBuffer.position(0));
            GLES20.glUniform4f(i5, 1.0f, 1.0f, 1.0f, 1.0f);
            GLES20.glDrawArrays(0, 0, 107);
            GLES20.glUniform4f(i5, 1.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f);
            GLES20.glDrawArrays(0, 107, (length / 4) - 107);
            GLES20.glVertexAttribPointer(i6, 4, 5126, false, 0, asFloatBuffer3.position(0));
            GLES20.glUniform4f(i5, 1.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f);
            GLES20.glDrawArrays(0, 0, length3 / 4);
            int i7 = i5;
            a(glGetAttribLocation, i7, glGetUniformLocation3, 15.0f, new float[]{GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, 1.0f, 1.0f}, asFloatBuffer, 108);
            GLES20.glDisableVertexAttribArray(glGetAttribLocation);
            GLES20.glDisable(2929);
        }
    }

    private void a(int i2, int i3, int i4, float f2, float[] fArr, FloatBuffer floatBuffer, int i5) {
        GLES20.glVertexAttribPointer(i2, 4, 5126, false, 0, floatBuffer.position(i5 * 4));
        GLES20.glUniform4f(i3, fArr[0], fArr[1], fArr[2], fArr[3]);
        GLES20.glUniform1f(i4, f2);
        GLES20.glDrawArrays(0, 0, 1);
    }

    private void a(c cVar, int i2, boolean z2, int i3) {
        boolean z3 = false;
        k kVar = null;
        if (i2 != 10) {
            switch (i2) {
                case 1:
                    if (cVar.g != null && cVar.g.k() == GlobalDefine.CLOTHES_CATEGORY_TYPE.Swimsuit) {
                        z3 = true;
                    }
                    if (z3) {
                        kVar = cVar.g;
                        break;
                    }
                    break;
                case 2:
                    kVar = cVar.f;
                    break;
                case 3:
                    kVar = cVar.e;
                    break;
                case 4:
                    if (cVar.h != null && cVar.h.k() == GlobalDefine.CLOTHES_CATEGORY_TYPE.Swimsuit) {
                        z3 = true;
                    }
                    kVar = cVar.h;
                    break;
                case 5:
                    kVar = cVar.f;
                    break;
                case 6:
                    kVar = cVar.e;
                    break;
            }
        } else {
            kVar = cVar.f;
        }
        if (z3) {
            a(cVar, kVar, z2);
        } else if (kVar == null || ((i2 != 10 && kVar.q() > 40.0f) || i3 == 3 || i3 == 2)) {
            a(cVar, z2);
        } else {
            b(cVar, i2, z2, i3);
        }
    }

    private void a(c cVar, int i2) {
        k kVar;
        k kVar2;
        this.ad = 0;
        this.ab = -1000.0f;
        this.ac = 1000.0f;
        this.Z = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        this.aa = 200.0f;
        k kVar3 = cVar.f670a;
        k kVar4 = null;
        switch (i2) {
            case 1:
                kVar2 = null;
                kVar4 = cVar.g;
                kVar = null;
                break;
            case 2:
                kVar = cVar.f;
                break;
            case 3:
                kVar2 = cVar.e;
                kVar = null;
                break;
            case 4:
                kVar = cVar.h;
                break;
            case 5:
                kVar4 = cVar.g;
                kVar = cVar.f;
                kVar2 = null;
                break;
            case 6:
                k kVar5 = cVar.g;
                kVar2 = cVar.e;
                kVar4 = kVar5;
                kVar = null;
                break;
            case 7:
                kVar = cVar.h;
                kVar2 = cVar.e;
                break;
            case 8:
                kVar = cVar.f;
                kVar2 = cVar.e;
                break;
            case 9:
                kVar4 = cVar.g;
                kVar = cVar.f;
                kVar2 = cVar.e;
                break;
            case 10:
                kVar = cVar.f;
                kVar2 = cVar.h;
                break;
            case 11:
                kVar4 = cVar.f;
                kVar = cVar.h;
                kVar2 = cVar.e;
                break;
            default:
                kVar = null;
                kVar2 = null;
                break;
        }
        kVar2 = null;
        GLES20.glEnable(32823);
        GLES20.glPolygonOffset(1.0f, 1200.0f);
        a(kVar2, 1029, true, true);
        a(kVar, 1029, true, true);
        a(kVar4, 1029, true, true);
        a(kVar3, 1028, true, true);
        GLES20.glPolygonOffset(1.0f, 800.0f);
        a(kVar4, 1028, true, true);
        GLES20.glPolygonOffset(1.0f, 400.0f);
        a(kVar, 1028, true, true);
        GLES20.glPolygonOffset(1.0f, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        a(kVar2, 1028, true, true);
        GLES20.glDisable(32823);
        a(cVar.f671b, cVar.c, 0, false);
        b(cVar.c, cVar.d, 0, true);
        if (kVar == null) {
            a(cVar.i, 0, false, true);
        } else if (kVar.r() >= 3.0f) {
            a(cVar.i, 1028, false, true);
        }
    }

    private void a(c cVar, k kVar, boolean z2) {
        this.ad = 0;
        this.ab = -1000.0f;
        this.ac = 1000.0f;
        this.Z = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        this.aa = 200.0f;
        GLES20.glEnable(2929);
        GLES20.glEnable(32823);
        GLES20.glPolygonOffset(1.0f, 2000.0f);
        a(cVar.f670a, 1028, false, true);
        GLES20.glDisable(32823);
        if (z2) {
            a(kVar, 1032, false, true);
        }
        GLES20.glDisable(2929);
        b(cVar, false);
    }

    private void a(c cVar, boolean z2) {
        boolean z3;
        this.ad = 0;
        this.ab = -1000.0f;
        this.ac = 1000.0f;
        this.Z = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        this.aa = 200.0f;
        GLES20.glEnable(2929);
        GLES20.glEnable(2960);
        GLES20.glStencilOp(7680, 7680, 7681);
        if (cVar.h == null) {
            GLES20.glStencilFunc(518, 0, 65535);
            a(cVar.i, 0, false, true);
        } else if (cVar.h.r() >= 3.0f) {
            GLES20.glStencilFunc(518, 0, 65535);
            a(cVar.i, 0, false, true);
        }
        this.ab = -1000.0f;
        this.ac = 1000.0f;
        if (z2) {
            GLES20.glStencilFunc(518, 1, 65535);
            a(cVar.e, 1029, false, true);
            GLES20.glStencilFunc(518, 3, 65535);
            a(cVar.g, 1029, false, true);
            GLES20.glStencilFunc(518, 10, 65535);
            a(cVar.e, 1028, false, true);
            this.ab = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            if (cVar.e == null || cVar.h == null || cVar.e.q() >= cVar.h.q() + 15.0f) {
                z3 = false;
            } else {
                this.ab = 190.0f;
                z3 = true;
            }
            this.ac = 1000.0f;
            GLES20.glStencilFunc(518, 2, 65535);
            a(cVar.h, 1029, false, true);
            GLES20.glStencilFunc(518, 9, 65535);
            a(cVar.h, 1028, false, true);
        } else {
            z3 = false;
        }
        this.ab = -1000.0f;
        this.ac = 1000.0f;
        if (z2) {
            GLES20.glStencilFunc(518, 4, 65535);
            a(cVar.f, 1029, false, true);
            GLES20.glStencilFunc(518, 8, 65535);
            a(cVar.f, 1028, false, true);
            GLES20.glStencilFunc(518, 7, 65535);
            a(cVar.g, 1028, false, true);
        }
        GLES20.glStencilFunc(518, 6, 65535);
        a(cVar.f670a, 1028, false, true);
        this.ab = -1000.0f;
        this.ac = 1000.0f;
        GLES20.glDisable(2929);
        GLES20.glDisable(2960);
        b(cVar, z3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0031, code lost:
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        r2 = null;
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0023, code lost:
        r19 = r6;
        r6 = r2;
        r2 = r19;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(net.fxgear.b.c r21, int r22, boolean r23, int r24) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            r4 = r24
            net.fxgear.b.k r5 = r1.f670a
            r6 = 10
            r7 = 0
            if (r2 == r6) goto L_0x003b
            switch(r2) {
                case 0: goto L_0x0038;
                case 1: goto L_0x0033;
                case 2: goto L_0x002f;
                case 3: goto L_0x002c;
                case 4: goto L_0x0029;
                case 5: goto L_0x001f;
                case 6: goto L_0x001a;
                default: goto L_0x0012;
            }
        L_0x0012:
            java.lang.String r2 = "FXSkeletalAnimationRenderer : "
            java.lang.String r6 = "[c] DrawAvatarModelM1: layer error"
            android.util.Log.e(r2, r6)
            goto L_0x0038
        L_0x001a:
            net.fxgear.b.k r2 = r1.g
            net.fxgear.b.k r6 = r1.e
            goto L_0x0023
        L_0x001f:
            net.fxgear.b.k r2 = r1.g
            net.fxgear.b.k r6 = r1.f
        L_0x0023:
            r19 = r6
            r6 = r2
            r2 = r19
            goto L_0x0044
        L_0x0029:
            net.fxgear.b.k r2 = r1.h
            goto L_0x0031
        L_0x002c:
            net.fxgear.b.k r2 = r1.e
            goto L_0x0031
        L_0x002f:
            net.fxgear.b.k r2 = r1.f
        L_0x0031:
            r6 = r7
            goto L_0x0044
        L_0x0033:
            net.fxgear.b.k r2 = r1.g
            r6 = r2
            r2 = r7
            goto L_0x0044
        L_0x0038:
            r2 = r7
            r6 = r2
            goto L_0x0044
        L_0x003b:
            net.fxgear.b.k r2 = r1.f
            net.fxgear.b.k r6 = r1.h
            r19 = r7
            r7 = r6
            r6 = r19
        L_0x0044:
            r8 = 2929(0xb71, float:4.104E-42)
            android.opengl.GLES20.glEnable(r8)
            r9 = 2960(0xb90, float:4.148E-42)
            android.opengl.GLES20.glEnable(r9)
            r10 = 7681(0x1e01, float:1.0763E-41)
            r11 = 7680(0x1e00, float:1.0762E-41)
            r12 = 1028(0x404, float:1.44E-42)
            android.opengl.GLES20.glStencilOpSeparate(r12, r11, r11, r10)
            r13 = 1029(0x405, float:1.442E-42)
            android.opengl.GLES20.glStencilOpSeparate(r13, r11, r11, r10)
            r10 = 0
            r11 = 1
            if (r4 != r11) goto L_0x0075
            r4 = 1082130432(0x40800000, float:4.0)
            r14 = 1082130432(0x40800000, float:4.0)
            float r15 = r5.s()
            r16 = 1093629527(0x412f7657, float:10.966392)
            float r15 = r15 - r16
            float r15 = r15 * r14
            r14 = 1085018930(0x40ac1332, float:5.377343)
            float r15 = r15 / r14
            float r4 = r4 - r15
            goto L_0x008d
        L_0x0075:
            if (r4 != 0) goto L_0x008c
            r4 = 1056964608(0x3f000000, float:0.5)
            r14 = 1086324736(0x40c00000, float:6.0)
            float r15 = r5.s()
            r16 = 1097496412(0x416a775c, float:14.65414)
            float r15 = r15 - r16
            float r15 = r15 * r14
            r14 = 1089374608(0x40ee8990, float:7.4542923)
            float r15 = r15 / r14
            float r4 = r4 - r15
            goto L_0x008d
        L_0x008c:
            r4 = 0
        L_0x008d:
            r15 = 519(0x207, float:7.27E-43)
            r16 = 1084227584(0x40a00000, float:5.0)
            r9 = 65535(0xffff, float:9.1834E-41)
            r14 = 0
            if (r23 == 0) goto L_0x013d
            r18 = 100
            android.opengl.GLES20.glClearStencil(r18)
            r18 = 1024(0x400, float:1.435E-42)
            android.opengl.GLES20.glClear(r18)
            android.opengl.GLES20.glColorMask(r14, r14, r14, r14)
            android.opengl.GLES20.glDisable(r8)
            r0.ad = r14
            r8 = 1129119744(0x434d0000, float:205.0)
            r0.ab = r8
            r8 = 1129775104(0x43570000, float:215.0)
            r0.ac = r8
            r0.Z = r10
            r8 = 1128792064(0x43480000, float:200.0)
            r0.aa = r8
            android.opengl.GLES20.glDepthMask(r14)
            android.opengl.GLES20.glStencilFuncSeparate(r12, r15, r14, r9)
            android.opengl.GLES20.glStencilFuncSeparate(r13, r15, r14, r9)
            r0.a((net.fxgear.b.k) r2, (int) r14, (boolean) r14, (boolean) r11)
            r0.a((net.fxgear.b.k) r5, (int) r14, (boolean) r14, (boolean) r11)
            r8 = 2
            r0.ad = r8
            r8 = -998637568(0xffffffffc47a0000, float:-1000.0)
            r0.ab = r8
            r8 = 1148846080(0x447a0000, float:1000.0)
            r0.ac = r8
            float r8 = r5.s()
            r0.aa = r8
            r0.Z = r10
            if (r7 == 0) goto L_0x00f2
            float r8 = r5.s()
            float r8 = r8 + r4
            float r8 = r8 + r16
            r0.aa = r8
            r0.Z = r10
            android.opengl.GLES20.glDepthMask(r14)
            android.opengl.GLES20.glStencilFuncSeparate(r12, r15, r14, r9)
            android.opengl.GLES20.glStencilFuncSeparate(r13, r15, r14, r9)
            r0.a((net.fxgear.b.k) r7, (int) r14, (boolean) r14, (boolean) r11)
        L_0x00f2:
            float r8 = r5.s()
            float r8 = r8 + r4
            float r8 = r8 + r16
            r0.aa = r8
            r0.Z = r10
            android.opengl.GLES20.glDepthMask(r14)
            android.opengl.GLES20.glStencilFuncSeparate(r12, r15, r14, r9)
            android.opengl.GLES20.glStencilFuncSeparate(r13, r15, r14, r9)
            r0.a((net.fxgear.b.k) r2, (int) r14, (boolean) r14, (boolean) r11)
            r8 = 1148846080(0x447a0000, float:1000.0)
            r0.aa = r8
            r0.Z = r10
            android.opengl.GLES20.glDepthMask(r14)
            android.opengl.GLES20.glStencilFuncSeparate(r12, r15, r14, r9)
            android.opengl.GLES20.glStencilFuncSeparate(r13, r15, r14, r9)
            r0.a((net.fxgear.b.k) r6, (int) r14, (boolean) r14, (boolean) r11)
            float r8 = r5.s()
            float r8 = r8 + r4
            float r8 = r8 + r16
            r0.aa = r8
            r0.Z = r10
            android.opengl.GLES20.glDepthMask(r14)
            android.opengl.GLES20.glStencilFuncSeparate(r12, r15, r14, r9)
            android.opengl.GLES20.glStencilFuncSeparate(r13, r15, r14, r9)
            r0.a((net.fxgear.b.k) r5, (int) r14, (boolean) r14, (boolean) r11)
            android.opengl.GLES20.glColorMask(r11, r11, r11, r11)
            r8 = 2929(0xb71, float:4.104E-42)
            android.opengl.GLES20.glEnable(r8)
            android.opengl.GLES20.glDepthMask(r11)
        L_0x013d:
            r8 = 2
            r0.ad = r8
            r8 = -998637568(0xffffffffc47a0000, float:-1000.0)
            r0.ab = r8
            r8 = 1148846080(0x447a0000, float:1000.0)
            r0.ac = r8
            float r17 = r5.s()
            float r15 = r17 - r16
            r0.aa = r15
            r0.Z = r10
            r15 = 4
            r12 = 518(0x206, float:7.26E-43)
            android.opengl.GLES20.glStencilFuncSeparate(r13, r12, r15, r9)
            r0.a((net.fxgear.b.k) r5, (int) r13, (boolean) r14, (boolean) r11)
            r0.aa = r8
            r0.Z = r10
            r8 = 3
            android.opengl.GLES20.glStencilFuncSeparate(r13, r12, r8, r9)
            r0.a((net.fxgear.b.k) r6, (int) r13, (boolean) r14, (boolean) r11)
            float r8 = r5.s()
            float r8 = r8 + r4
            r15 = 1073741824(0x40000000, float:2.0)
            float r8 = r8 - r15
            r0.aa = r8
            r0.Z = r10
            r8 = 2
            android.opengl.GLES20.glStencilFuncSeparate(r13, r12, r8, r9)
            r0.a((net.fxgear.b.k) r2, (int) r13, (boolean) r14, (boolean) r11)
            if (r7 == 0) goto L_0x01a2
            float r8 = r5.s()
            float r8 = r8 + r4
            float r8 = r8 + r16
            r0.aa = r8
            r0.Z = r10
            android.opengl.GLES20.glStencilFuncSeparate(r13, r12, r11, r9)
            r0.a((net.fxgear.b.k) r7, (int) r13, (boolean) r14, (boolean) r11)
            float r8 = r5.s()
            float r8 = r8 + r4
            float r8 = r8 + r16
            r0.aa = r8
            r0.Z = r10
            r8 = 8
            r15 = 1028(0x404, float:1.44E-42)
            android.opengl.GLES20.glStencilFuncSeparate(r15, r12, r8, r9)
            r0.a((net.fxgear.b.k) r7, (int) r15, (boolean) r14, (boolean) r11)
            goto L_0x01a4
        L_0x01a2:
            r15 = 1028(0x404, float:1.44E-42)
        L_0x01a4:
            float r8 = r5.s()
            float r8 = r8 + r4
            r18 = 1073741824(0x40000000, float:2.0)
            float r8 = r8 - r18
            r0.aa = r8
            r0.Z = r10
            r8 = 7
            android.opengl.GLES20.glStencilFuncSeparate(r15, r12, r8, r9)
            r0.a((net.fxgear.b.k) r2, (int) r15, (boolean) r14, (boolean) r11)
            r8 = 1148846080(0x447a0000, float:1000.0)
            r0.aa = r8
            r0.Z = r10
            r8 = 6
            android.opengl.GLES20.glStencilFuncSeparate(r15, r12, r8, r9)
            r0.a((net.fxgear.b.k) r6, (int) r15, (boolean) r14, (boolean) r11)
            float r6 = r5.s()
            float r6 = r6 - r16
            r0.aa = r6
            r0.Z = r10
            r6 = 5
            android.opengl.GLES20.glStencilFuncSeparate(r15, r12, r6, r9)
            r0.a((net.fxgear.b.k) r5, (int) r15, (boolean) r14, (boolean) r11)
            r0.ad = r11
            r6 = -998637568(0xffffffffc47a0000, float:-1000.0)
            r0.ab = r6
            r6 = 1148846080(0x447a0000, float:1000.0)
            r0.ac = r6
            r0.aa = r6
            float r6 = r5.s()
            r0.Z = r6
            if (r23 == 0) goto L_0x02bf
            r6 = 100
            android.opengl.GLES20.glClearStencil(r6)
            r6 = 1024(0x400, float:1.435E-42)
            android.opengl.GLES20.glClear(r6)
            android.opengl.GLES20.glColorMask(r14, r14, r14, r14)
            r6 = 2929(0xb71, float:4.104E-42)
            android.opengl.GLES20.glDisable(r6)
            r0.ad = r11
            r6 = -998637568(0xffffffffc47a0000, float:-1000.0)
            r0.ab = r6
            r6 = 1148846080(0x447a0000, float:1000.0)
            r0.ac = r6
            r0.aa = r6
            float r6 = r5.s()
            float r6 = r6 - r4
            float r6 = r6 - r16
            r0.Z = r6
            android.opengl.GLES20.glDepthMask(r14)
            r6 = 10
            r8 = 1028(0x404, float:1.44E-42)
            r15 = 519(0x207, float:7.27E-43)
            android.opengl.GLES20.glStencilFuncSeparate(r8, r15, r6, r9)
            android.opengl.GLES20.glStencilFuncSeparate(r13, r15, r6, r9)
            r0.a((net.fxgear.b.k) r7, (int) r14, (boolean) r14, (boolean) r11)
            r0.a((net.fxgear.b.k) r2, (int) r14, (boolean) r14, (boolean) r11)
            r0.a((net.fxgear.b.k) r5, (int) r14, (boolean) r14, (boolean) r11)
            android.opengl.GLES20.glColorMask(r11, r11, r11, r11)
            r6 = 2929(0xb71, float:4.104E-42)
            android.opengl.GLES20.glEnable(r6)
            android.opengl.GLES20.glDepthMask(r11)
            r6 = 1148846080(0x447a0000, float:1000.0)
            r0.aa = r6
            float r8 = r5.s()
            float r8 = r8 + r16
            r0.Z = r8
            r8 = -998637568(0xffffffffc47a0000, float:-1000.0)
            r0.ab = r8
            r0.ac = r6
            r8 = 14
            android.opengl.GLES20.glStencilFuncSeparate(r13, r12, r8, r9)
            r0.a((net.fxgear.b.k) r5, (int) r13, (boolean) r14, (boolean) r11)
            r0.aa = r6
            float r8 = r5.s()
            float r8 = r8 - r4
            float r8 = r8 - r16
            r0.Z = r8
            r8 = 12
            android.opengl.GLES20.glStencilFuncSeparate(r13, r12, r8, r9)
            r0.a((net.fxgear.b.k) r2, (int) r13, (boolean) r14, (boolean) r11)
            if (r7 == 0) goto L_0x0292
            r0.aa = r6
            float r8 = r5.s()
            float r8 = r8 - r4
            float r8 = r8 - r16
            r0.Z = r8
            r8 = 11
            android.opengl.GLES20.glStencilFuncSeparate(r13, r12, r8, r9)
            r0.a((net.fxgear.b.k) r7, (int) r13, (boolean) r14, (boolean) r11)
            r0.aa = r6
            float r8 = r5.s()
            float r8 = r8 - r4
            float r8 = r8 - r16
            r0.Z = r8
            r8 = -998637568(0xffffffffc47a0000, float:-1000.0)
            r0.ab = r8
            r0.ac = r6
            r8 = 18
            r13 = 1028(0x404, float:1.44E-42)
            android.opengl.GLES20.glStencilFuncSeparate(r13, r12, r8, r9)
            r0.a((net.fxgear.b.k) r7, (int) r13, (boolean) r14, (boolean) r11)
            goto L_0x0294
        L_0x0292:
            r13 = 1028(0x404, float:1.44E-42)
        L_0x0294:
            r0.aa = r6
            float r7 = r5.s()
            float r7 = r7 - r4
            float r7 = r7 - r16
            r0.Z = r7
            r4 = -998637568(0xffffffffc47a0000, float:-1000.0)
            r0.ab = r4
            r0.ac = r6
            r4 = 17
            android.opengl.GLES20.glStencilFuncSeparate(r13, r12, r4, r9)
            r0.a((net.fxgear.b.k) r2, (int) r13, (boolean) r14, (boolean) r11)
            r0.aa = r6
            float r4 = r5.s()
            float r4 = r4 + r16
            r0.Z = r4
            r4 = 15
            android.opengl.GLES20.glStencilFuncSeparate(r13, r12, r4, r9)
            r0.a((net.fxgear.b.k) r5, (int) r13, (boolean) r14, (boolean) r11)
        L_0x02bf:
            if (r2 == 0) goto L_0x0311
            r4 = 2960(0xb90, float:4.148E-42)
            android.opengl.GLES20.glEnable(r4)
            android.opengl.GLES20.glClearStencil(r14)
            r4 = 1024(0x400, float:1.435E-42)
            android.opengl.GLES20.glClear(r4)
            android.opengl.GLES20.glColorMask(r14, r14, r14, r14)
            r4 = 2929(0xb71, float:4.104E-42)
            android.opengl.GLES20.glDisable(r4)
            android.opengl.GLES20.glDepthMask(r14)
            android.opengl.GLES20.glColorMask(r11, r11, r11, r11)
            android.opengl.GLES20.glEnable(r4)
            android.opengl.GLES20.glDepthMask(r11)
            r0.ad = r14
            r0.ab = r10
            r4 = 1128759296(0x43478000, float:199.5)
            r0.ac = r4
            float r4 = r5.s()
            r6 = 1065353216(0x3f800000, float:1.0)
            float r4 = r4 + r6
            r0.aa = r4
            float r4 = r5.s()
            float r4 = r4 - r16
            r0.Z = r4
            r4 = 7
            r6 = 1028(0x404, float:1.44E-42)
            android.opengl.GLES20.glStencilFuncSeparate(r6, r12, r4, r9)
            r0.a((net.fxgear.b.k) r2, (int) r6, (boolean) r14, (boolean) r11)
            r4 = 5
            android.opengl.GLES20.glStencilFuncSeparate(r6, r12, r4, r9)
            r0.a((net.fxgear.b.k) r5, (int) r6, (boolean) r14, (boolean) r11)
            r4 = 2960(0xb90, float:4.148E-42)
            android.opengl.GLES20.glDisable(r4)
        L_0x0311:
            r0.ad = r14
            r4 = -998637568(0xffffffffc47a0000, float:-1000.0)
            r0.ab = r4
            r4 = 1148846080(0x447a0000, float:1000.0)
            r0.ac = r4
            r0.Z = r10
            r4 = 1128792064(0x43480000, float:200.0)
            r0.aa = r4
            if (r23 == 0) goto L_0x0335
            if (r2 == 0) goto L_0x0335
            float r2 = r2.r()
            r3 = 1077936128(0x40400000, float:3.0)
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 < 0) goto L_0x033a
            net.fxgear.b.k r2 = r1.i
            r0.a((net.fxgear.b.k) r2, (int) r14, (boolean) r14, (boolean) r11)
            goto L_0x033a
        L_0x0335:
            net.fxgear.b.k r2 = r1.i
            r0.a((net.fxgear.b.k) r2, (int) r14, (boolean) r14, (boolean) r11)
        L_0x033a:
            r0.ad = r14
            r2 = -998637568(0xffffffffc47a0000, float:-1000.0)
            r0.ab = r2
            r2 = 1148846080(0x447a0000, float:1000.0)
            r0.ac = r2
            r0.Z = r10
            r2 = 1128792064(0x43480000, float:200.0)
            r0.aa = r2
            net.fxgear.b.k r2 = r1.f671b
            net.fxgear.b.k r3 = r1.c
            r0.a((net.fxgear.b.k) r2, (net.fxgear.b.k) r3, (int) r14, (boolean) r14)
            net.fxgear.b.k r2 = r1.c
            net.fxgear.b.k r1 = r1.d
            r0.b((net.fxgear.b.k) r2, (net.fxgear.b.k) r1, (int) r14, (boolean) r11)
            r1 = 2929(0xb71, float:4.104E-42)
            android.opengl.GLES20.glDisable(r1)
            r1 = 2960(0xb90, float:4.148E-42)
            android.opengl.GLES20.glDisable(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.b.m.b(net.fxgear.b.c, int, boolean, int):void");
    }

    private void b(c cVar) {
        this.ad = 0;
        this.ab = -1000.0f;
        this.ac = 1000.0f;
        this.Z = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        this.aa = 200.0f;
        GLES20.glEnable(2929);
        GLES20.glEnable(2960);
        GLES20.glStencilOp(7680, 7680, 7681);
        GLES20.glStencilFunc(518, 3, 65535);
        GLES20.glColorMask(false, false, false, false);
        a(cVar.g, 1029, false, true);
        GLES20.glStencilFunc(518, 10, 65535);
        GLES20.glColorMask(true, true, true, true);
        a(cVar.e, 1028, false, true);
        this.ab = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        if (!(cVar.e == null || cVar.h == null || cVar.e.q() >= cVar.h.q() + 15.0f)) {
            this.ab = 190.0f;
        }
        this.ac = 1000.0f;
        GLES20.glStencilFunc(518, 2, 65535);
        GLES20.glColorMask(false, false, false, false);
        a(cVar.h, 1029, false, true);
        GLES20.glStencilFunc(518, 9, 65535);
        GLES20.glColorMask(true, true, true, true);
        a(cVar.h, 1028, false, true);
        this.ab = -1000.0f;
        this.ac = 1000.0f;
        GLES20.glStencilFunc(518, 5, 65535);
        GLES20.glColorMask(false, false, false, false);
        a(cVar.f670a, 1029, false, true);
        GLES20.glStencilFunc(518, 4, 65535);
        GLES20.glColorMask(false, false, false, false);
        a(cVar.f, 1029, false, true);
        GLES20.glStencilFunc(518, 8, 65535);
        GLES20.glColorMask(true, true, true, true);
        a(cVar.f, 1028, false, true);
        GLES20.glStencilFunc(518, 7, 65535);
        GLES20.glColorMask(true, true, true, true);
        a(cVar.g, 1028, false, true);
        GLES20.glStencilFunc(518, 6, 65535);
        GLES20.glColorMask(false, false, false, false);
        a(cVar.f670a, 1028, false, true);
        GLES20.glColorMask(true, true, true, true);
        GLES20.glDisable(2929);
        GLES20.glDisable(2960);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0053, code lost:
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005d, code lost:
        r8 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x005e, code lost:
        android.opengl.GLES20.glEnable(2929);
        android.opengl.GLES20.glEnable(2960);
        android.opengl.GLES20.glStencilOpSeparate(1028, 7680, 7680, 7681);
        android.opengl.GLES20.glStencilOpSeparate(1029, 7680, 7680, 7681);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0078, code lost:
        if (r3 != 1) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007a, code lost:
        r3 = 4.0f - (((r4.s() - 10.966392f) * 4.0f) / 5.377343f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0091, code lost:
        if (r3 != 0) goto L_0x00aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0093, code lost:
        r3 = 0.5f - (((r4.s() - 14.65414f) * 6.0f) / 7.4542923f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00aa, code lost:
        r3 = net.fxgear.GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00b2, code lost:
        if (r22 == false) goto L_0x014f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00b4, code lost:
        android.opengl.GLES20.glClearStencil(0);
        android.opengl.GLES20.glClear(net.fxgear.util.FXUtil.MAX_CUSTOM_FACE_IMAGE_SIZE);
        android.opengl.GLES20.glColorMask(true, true, true, true);
        android.opengl.GLES20.glEnable(2929);
        android.opengl.GLES20.glDepthMask(true);
        r0.ad = 2;
        r0.ab = -1000.0f;
        r0.ac = 1000.0f;
        r0.aa = r4.s();
        r0.Z = net.fxgear.GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        android.opengl.GLES20.glStencilFuncSeparate(1029, 518, 4, 65535);
        a(r4, 1029, false, true);
        r0.aa = r4.s();
        r0.Z = net.fxgear.GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        android.opengl.GLES20.glStencilFuncSeparate(1028, 518, 9, 65535);
        android.opengl.GLES20.glStencilFuncSeparate(1029, 518, 0, 65535);
        a(r5, 0, false, true);
        r0.aa = r4.s();
        r0.Z = net.fxgear.GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        android.opengl.GLES20.glStencilFuncSeparate(1028, 518, 8, 65535);
        android.opengl.GLES20.glStencilFuncSeparate(1029, 518, 1, 65535);
        a(r7, 0, false, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0111, code lost:
        if (r5.q() <= 1000.0f) goto L_0x011f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0113, code lost:
        r0.aa = (r4.s() + r3) + 1.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x011f, code lost:
        r0.aa = r4.s();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0126, code lost:
        r0.Z = net.fxgear.GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        android.opengl.GLES20.glStencilFuncSeparate(1028, 518, 7, 65535);
        android.opengl.GLES20.glStencilFuncSeparate(1029, 518, 2, 65535);
        a(r6, 0, false, true);
        r0.aa = 1000.0f;
        r0.Z = net.fxgear.GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        android.opengl.GLES20.glStencilFuncSeparate(1028, 518, 6, 65535);
        android.opengl.GLES20.glStencilFuncSeparate(1029, 518, 3, 65535);
        a(r8, 0, false, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x014f, code lost:
        r0.ad = 2;
        r0.aa = r4.s();
        r0.Z = net.fxgear.GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        r0.ab = -1000.0f;
        r0.ac = 1000.0f;
        android.opengl.GLES20.glStencilFuncSeparate(1028, 518, 5, 65535);
        a(r4, 1028, false, true);
        r0.ad = 1;
        r0.ab = -1000.0f;
        r0.ac = 1000.0f;
        r0.aa = 1000.0f;
        r0.Z = r4.s();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x017f, code lost:
        if (r22 == false) goto L_0x030c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0181, code lost:
        android.opengl.GLES20.glClearStencil(9);
        android.opengl.GLES20.glClear(net.fxgear.util.FXUtil.MAX_CUSTOM_FACE_IMAGE_SIZE);
        android.opengl.GLES20.glColorMask(false, false, false, false);
        android.opengl.GLES20.glDisable(2929);
        r0.ad = 1;
        r0.ab = -1000.0f;
        r0.ac = 1000.0f;
        r0.aa = 1000.0f;
        r0.Z = r4.s() + r3;
        android.opengl.GLES20.glColorMask(true, true, true, true);
        android.opengl.GLES20.glEnable(2929);
        android.opengl.GLES20.glDepthMask(true);
        r0.ab = -1000.0f;
        r0.ac = 1000.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x01b3, code lost:
        if (r22 == false) goto L_0x01d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x01b5, code lost:
        r0.ac = java.lang.Math.min(java.lang.Math.min(r6.q(), r0.ac) + 15.0f, java.lang.Math.min(r5.q(), r0.ac) + 15.0f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x01d1, code lost:
        r0.aa = 1000.0f;
        r0.Z = r4.s();
        android.opengl.GLES20.glStencilFuncSeparate(1029, 518, 14, 65535);
        a(r4, 1029, false, true);
        r0.aa = 1000.0f;
        r0.Z = r4.s() + r3;
        android.opengl.GLES20.glStencilFuncSeparate(1028, 518, 19, 65535);
        android.opengl.GLES20.glStencilFuncSeparate(1029, 518, 10, 65535);
        r0.ab = -1000.0f;
        r0.ac = 1000.0f;
        a(r5, 0, false, true);
        r0.aa = 1000.0f;
        r0.Z = r4.s() + r3;
        android.opengl.GLES20.glStencilFuncSeparate(1028, 518, 18, 65535);
        android.opengl.GLES20.glStencilFuncSeparate(1029, 518, 11, 65535);
        r0.ab = -1000.0f;
        r0.ac = 1000.0f;
        a(r7, 0, false, true);
        r0.aa = 1000.0f;
        r0.Z = (r4.s() + r3) + 1.0f;
        android.opengl.GLES20.glStencilFuncSeparate(1028, 518, 17, 65535);
        android.opengl.GLES20.glStencilFuncSeparate(1029, 518, 12, 65535);
        r0.ab = -1000.0f;
        r0.ac = 1000.0f;
        a(r6, 0, false, true);
        r0.ab = -1000.0f;
        r0.ac = 1000.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x024c, code lost:
        if (r22 == false) goto L_0x026c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x024e, code lost:
        r0.ac = java.lang.Math.min(java.lang.Math.min(r6.q(), r0.ac) + 15.0f, java.lang.Math.min(r5.q(), r0.ac) + 15.0f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x026c, code lost:
        r0.aa = 1000.0f;
        r0.Z = r4.s();
        android.opengl.GLES20.glStencilFuncSeparate(1028, 518, 15, 65535);
        a(r4, 1028, false, true);
        android.opengl.GLES20.glEnable(2960);
        android.opengl.GLES20.glClearStencil(9);
        android.opengl.GLES20.glClear(net.fxgear.util.FXUtil.MAX_CUSTOM_FACE_IMAGE_SIZE);
        android.opengl.GLES20.glColorMask(true, true, true, true);
        android.opengl.GLES20.glEnable(2929);
        android.opengl.GLES20.glDepthMask(true);
        r0.ad = 1;
        r0.ab = -1000.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x02ad, code lost:
        if (r5.q() <= net.fxgear.GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) goto L_0x02b2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x02af, code lost:
        r13 = 1000.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x02b2, code lost:
        r13 = r5.q() + 15.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x02ba, code lost:
        r0.ac = r13;
        r0.aa = (r4.s() + r3) + 2.0f;
        r0.Z = r4.s() - 5.0f;
        android.opengl.GLES20.glStencilFuncSeparate(1028, 518, 19, 65535);
        android.opengl.GLES20.glStencilFuncSeparate(1029, 518, 10, 65535);
        r3 = true;
        a(r5, 0, false, true);
        r0.Z = r4.s();
        android.opengl.GLES20.glStencilFuncSeparate(1028, 518, 18, 65535);
        android.opengl.GLES20.glStencilFuncSeparate(1029, 518, 11, 65535);
        a(r7, 0, false, true);
        android.opengl.GLES20.glStencilFuncSeparate(1028, 518, 17, 65535);
        android.opengl.GLES20.glStencilFuncSeparate(1029, 518, 12, 65535);
        a(r6, 0, false, true);
        r5 = 2960;
        android.opengl.GLES20.glDisable(2960);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x030c, code lost:
        r3 = true;
        r5 = 2960;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x030f, code lost:
        android.opengl.GLES20.glDisable(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0312, code lost:
        if (r22 != false) goto L_0x0328;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0314, code lost:
        r5 = -1000.0f;
        r0.ab = -1000.0f;
        r7 = 1000.0f;
        r0.ac = 1000.0f;
        r0.aa = 1000.0f;
        r0.Z = r4.s();
        a(r4, 0, false, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0328, code lost:
        r5 = -1000.0f;
        r7 = 1000.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x032c, code lost:
        r0.ad = 0;
        r0.ab = r5;
        r0.ac = r7;
        r0.Z = net.fxgear.GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        r0.aa = 200.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0339, code lost:
        if (r22 == false) goto L_0x034e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x033b, code lost:
        if (r6 == null) goto L_0x034e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0345, code lost:
        if (r6.r() < 3.0f) goto L_0x0354;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0347, code lost:
        a(r1.i, 0, false, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x034e, code lost:
        a(r1.i, 0, false, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0354, code lost:
        r0.ad = 0;
        r0.ab = -1000.0f;
        r0.ac = 1000.0f;
        r0.Z = net.fxgear.GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        r0.aa = 200.0f;
        a(r1.f671b, r1.c, 0, false);
        b(r1.c, r1.d, 0, true);
        android.opengl.GLES20.glDisable(2929);
        android.opengl.GLES20.glDisable(2960);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x037e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0032, code lost:
        r8 = null;
        r5 = r7;
        r7 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(net.fxgear.b.c r20, int r21, boolean r22, int r23) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r3 = r23
            net.fxgear.b.k r4 = r1.f670a
            r5 = 0
            switch(r21) {
                case 0: goto L_0x005b;
                case 1: goto L_0x0055;
                case 2: goto L_0x0051;
                case 3: goto L_0x004a;
                case 4: goto L_0x0047;
                case 5: goto L_0x003f;
                case 6: goto L_0x0036;
                case 7: goto L_0x002e;
                case 8: goto L_0x0029;
                case 9: goto L_0x001b;
                case 10: goto L_0x000c;
                case 11: goto L_0x000e;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x005b
        L_0x000e:
            net.fxgear.b.k r6 = r1.f
            net.fxgear.b.k r7 = r1.h
            net.fxgear.b.k r8 = r1.e
            r18 = r8
            r8 = r5
            r5 = r18
            goto L_0x005e
        L_0x001b:
            net.fxgear.b.k r6 = r1.g
            net.fxgear.b.k r7 = r1.f
            net.fxgear.b.k r8 = r1.e
            r18 = r7
            r7 = r5
            r5 = r8
            r8 = r6
            r6 = r18
            goto L_0x005e
        L_0x0029:
            net.fxgear.b.k r6 = r1.f
            net.fxgear.b.k r7 = r1.e
            goto L_0x0032
        L_0x002e:
            net.fxgear.b.k r6 = r1.h
            net.fxgear.b.k r7 = r1.e
        L_0x0032:
            r8 = r5
            r5 = r7
            r7 = r8
            goto L_0x005e
        L_0x0036:
            net.fxgear.b.k r6 = r1.g
            net.fxgear.b.k r7 = r1.e
            r8 = r6
            r6 = r5
            r5 = r7
            r7 = r6
            goto L_0x005e
        L_0x003f:
            net.fxgear.b.k r6 = r1.g
            net.fxgear.b.k r7 = r1.f
            r8 = r6
            r6 = r7
            r7 = r5
            goto L_0x005e
        L_0x0047:
            net.fxgear.b.k r6 = r1.h
            goto L_0x0053
        L_0x004a:
            net.fxgear.b.k r6 = r1.e
            r7 = r5
            r8 = r7
            r5 = r6
            r6 = r8
            goto L_0x005e
        L_0x0051:
            net.fxgear.b.k r6 = r1.f
        L_0x0053:
            r7 = r5
            goto L_0x005d
        L_0x0055:
            net.fxgear.b.k r6 = r1.g
            r7 = r5
            r8 = r6
            r6 = r7
            goto L_0x005e
        L_0x005b:
            r6 = r5
            r7 = r6
        L_0x005d:
            r8 = r7
        L_0x005e:
            r9 = 2929(0xb71, float:4.104E-42)
            android.opengl.GLES20.glEnable(r9)
            r10 = 2960(0xb90, float:4.148E-42)
            android.opengl.GLES20.glEnable(r10)
            r11 = 7681(0x1e01, float:1.0763E-41)
            r12 = 7680(0x1e00, float:1.0762E-41)
            r13 = 1028(0x404, float:1.44E-42)
            android.opengl.GLES20.glStencilOpSeparate(r13, r12, r12, r11)
            r14 = 1029(0x405, float:1.442E-42)
            android.opengl.GLES20.glStencilOpSeparate(r14, r12, r12, r11)
            r11 = 0
            r12 = 1
            if (r3 != r12) goto L_0x0091
            r3 = 1082130432(0x40800000, float:4.0)
            r15 = 1082130432(0x40800000, float:4.0)
            float r16 = r4.s()
            r17 = 1093629527(0x412f7657, float:10.966392)
            float r16 = r16 - r17
            float r16 = r16 * r15
            r15 = 1085018930(0x40ac1332, float:5.377343)
            float r16 = r16 / r15
            float r3 = r3 - r16
            goto L_0x00ab
        L_0x0091:
            if (r3 != 0) goto L_0x00aa
            r3 = 1056964608(0x3f000000, float:0.5)
            r15 = 1086324736(0x40c00000, float:6.0)
            float r16 = r4.s()
            r17 = 1097496412(0x416a775c, float:14.65414)
            float r16 = r16 - r17
            float r16 = r16 * r15
            r15 = 1089374608(0x40ee8990, float:7.4542923)
            float r16 = r16 / r15
            float r3 = r3 - r16
            goto L_0x00ab
        L_0x00aa:
            r3 = 0
        L_0x00ab:
            r15 = 1024(0x400, float:1.435E-42)
            r10 = -998637568(0xffffffffc47a0000, float:-1000.0)
            r13 = 1148846080(0x447a0000, float:1000.0)
            r14 = 0
            if (r22 == 0) goto L_0x014f
            android.opengl.GLES20.glClearStencil(r14)
            android.opengl.GLES20.glClear(r15)
            android.opengl.GLES20.glColorMask(r12, r12, r12, r12)
            android.opengl.GLES20.glEnable(r9)
            android.opengl.GLES20.glDepthMask(r12)
            r9 = 2
            r0.ad = r9
            r0.ab = r10
            r0.ac = r13
            float r9 = r4.s()
            r0.aa = r9
            r0.Z = r11
            r9 = 4
            r10 = 65535(0xffff, float:9.1834E-41)
            r13 = 1029(0x405, float:1.442E-42)
            r15 = 518(0x206, float:7.26E-43)
            android.opengl.GLES20.glStencilFuncSeparate(r13, r15, r9, r10)
            r0.a((net.fxgear.b.k) r4, (int) r13, (boolean) r14, (boolean) r12)
            float r9 = r4.s()
            r0.aa = r9
            r0.Z = r11
            r9 = 9
            r11 = 1028(0x404, float:1.44E-42)
            android.opengl.GLES20.glStencilFuncSeparate(r11, r15, r9, r10)
            android.opengl.GLES20.glStencilFuncSeparate(r13, r15, r14, r10)
            r0.a((net.fxgear.b.k) r5, (int) r14, (boolean) r14, (boolean) r12)
            float r9 = r4.s()
            r0.aa = r9
            r9 = 0
            r0.Z = r9
            r9 = 8
            android.opengl.GLES20.glStencilFuncSeparate(r11, r15, r9, r10)
            android.opengl.GLES20.glStencilFuncSeparate(r13, r15, r12, r10)
            r0.a((net.fxgear.b.k) r7, (int) r14, (boolean) r14, (boolean) r12)
            float r9 = r5.q()
            r10 = 1148846080(0x447a0000, float:1000.0)
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 <= 0) goto L_0x011f
            float r9 = r4.s()
            float r9 = r9 + r3
            r10 = 1065353216(0x3f800000, float:1.0)
            float r9 = r9 + r10
            r0.aa = r9
        L_0x011d:
            r9 = 0
            goto L_0x0126
        L_0x011f:
            float r9 = r4.s()
            r0.aa = r9
            goto L_0x011d
        L_0x0126:
            r0.Z = r9
            r10 = 7
            r11 = 518(0x206, float:7.26E-43)
            r13 = 65535(0xffff, float:9.1834E-41)
            r15 = 1028(0x404, float:1.44E-42)
            android.opengl.GLES20.glStencilFuncSeparate(r15, r11, r10, r13)
            r10 = 2
            r15 = 1029(0x405, float:1.442E-42)
            android.opengl.GLES20.glStencilFuncSeparate(r15, r11, r10, r13)
            r0.a((net.fxgear.b.k) r6, (int) r14, (boolean) r14, (boolean) r12)
            r10 = 1148846080(0x447a0000, float:1000.0)
            r0.aa = r10
            r0.Z = r9
            r9 = 6
            r10 = 1028(0x404, float:1.44E-42)
            android.opengl.GLES20.glStencilFuncSeparate(r10, r11, r9, r13)
            r9 = 3
            android.opengl.GLES20.glStencilFuncSeparate(r15, r11, r9, r13)
            r0.a((net.fxgear.b.k) r8, (int) r14, (boolean) r14, (boolean) r12)
        L_0x014f:
            r8 = 2
            r0.ad = r8
            float r8 = r4.s()
            r0.aa = r8
            r8 = 0
            r0.Z = r8
            r8 = -998637568(0xffffffffc47a0000, float:-1000.0)
            r0.ab = r8
            r9 = 1148846080(0x447a0000, float:1000.0)
            r0.ac = r9
            r10 = 5
            r11 = 518(0x206, float:7.26E-43)
            r13 = 65535(0xffff, float:9.1834E-41)
            r15 = 1028(0x404, float:1.44E-42)
            android.opengl.GLES20.glStencilFuncSeparate(r15, r11, r10, r13)
            r0.a((net.fxgear.b.k) r4, (int) r15, (boolean) r14, (boolean) r12)
            r0.ad = r12
            r0.ab = r8
            r0.ac = r9
            r0.aa = r9
            float r8 = r4.s()
            r0.Z = r8
            if (r22 == 0) goto L_0x030c
            r8 = 9
            android.opengl.GLES20.glClearStencil(r8)
            r8 = 1024(0x400, float:1.435E-42)
            android.opengl.GLES20.glClear(r8)
            android.opengl.GLES20.glColorMask(r14, r14, r14, r14)
            r8 = 2929(0xb71, float:4.104E-42)
            android.opengl.GLES20.glDisable(r8)
            r0.ad = r12
            r10 = -998637568(0xffffffffc47a0000, float:-1000.0)
            r0.ab = r10
            r0.ac = r9
            r0.aa = r9
            float r11 = r4.s()
            float r11 = r11 + r3
            r0.Z = r11
            android.opengl.GLES20.glColorMask(r12, r12, r12, r12)
            android.opengl.GLES20.glEnable(r8)
            android.opengl.GLES20.glDepthMask(r12)
            r0.ab = r10
            r0.ac = r9
            r8 = 1097859072(0x41700000, float:15.0)
            if (r22 == 0) goto L_0x01d1
            float r9 = r6.q()
            float r10 = r0.ac
            float r9 = java.lang.Math.min(r9, r10)
            float r9 = r9 + r8
            float r10 = r5.q()
            float r11 = r0.ac
            float r10 = java.lang.Math.min(r10, r11)
            float r10 = r10 + r8
            float r9 = java.lang.Math.min(r9, r10)
            r0.ac = r9
        L_0x01d1:
            r9 = 1148846080(0x447a0000, float:1000.0)
            r0.aa = r9
            float r10 = r4.s()
            r0.Z = r10
            r10 = 14
            r11 = 518(0x206, float:7.26E-43)
            r13 = 65535(0xffff, float:9.1834E-41)
            r15 = 1029(0x405, float:1.442E-42)
            android.opengl.GLES20.glStencilFuncSeparate(r15, r11, r10, r13)
            r0.a((net.fxgear.b.k) r4, (int) r15, (boolean) r14, (boolean) r12)
            r0.aa = r9
            float r10 = r4.s()
            float r10 = r10 + r3
            r0.Z = r10
            r10 = 19
            r8 = 1028(0x404, float:1.44E-42)
            android.opengl.GLES20.glStencilFuncSeparate(r8, r11, r10, r13)
            r10 = 10
            android.opengl.GLES20.glStencilFuncSeparate(r15, r11, r10, r13)
            r10 = -998637568(0xffffffffc47a0000, float:-1000.0)
            r0.ab = r10
            r0.ac = r9
            r0.a((net.fxgear.b.k) r5, (int) r14, (boolean) r14, (boolean) r12)
            r0.aa = r9
            float r16 = r4.s()
            float r12 = r16 + r3
            r0.Z = r12
            r12 = 18
            android.opengl.GLES20.glStencilFuncSeparate(r8, r11, r12, r13)
            r8 = 11
            android.opengl.GLES20.glStencilFuncSeparate(r15, r11, r8, r13)
            r0.ab = r10
            r0.ac = r9
            r8 = 1
            r0.a((net.fxgear.b.k) r7, (int) r14, (boolean) r14, (boolean) r8)
            r0.aa = r9
            float r8 = r4.s()
            float r8 = r8 + r3
            r10 = 1065353216(0x3f800000, float:1.0)
            float r8 = r8 + r10
            r0.Z = r8
            r8 = 17
            r10 = 1028(0x404, float:1.44E-42)
            android.opengl.GLES20.glStencilFuncSeparate(r10, r11, r8, r13)
            r8 = 12
            r10 = 1029(0x405, float:1.442E-42)
            android.opengl.GLES20.glStencilFuncSeparate(r10, r11, r8, r13)
            r8 = -998637568(0xffffffffc47a0000, float:-1000.0)
            r0.ab = r8
            r0.ac = r9
            r10 = 1
            r0.a((net.fxgear.b.k) r6, (int) r14, (boolean) r14, (boolean) r10)
            r0.ab = r8
            r0.ac = r9
            if (r22 == 0) goto L_0x026c
            float r8 = r6.q()
            float r9 = r0.ac
            float r8 = java.lang.Math.min(r8, r9)
            r9 = 1097859072(0x41700000, float:15.0)
            float r8 = r8 + r9
            float r10 = r5.q()
            float r11 = r0.ac
            float r10 = java.lang.Math.min(r10, r11)
            float r10 = r10 + r9
            float r8 = java.lang.Math.min(r8, r10)
            r0.ac = r8
        L_0x026c:
            r8 = 1148846080(0x447a0000, float:1000.0)
            r0.aa = r8
            float r8 = r4.s()
            r0.Z = r8
            r8 = 15
            r9 = 518(0x206, float:7.26E-43)
            r10 = 65535(0xffff, float:9.1834E-41)
            r11 = 1028(0x404, float:1.44E-42)
            android.opengl.GLES20.glStencilFuncSeparate(r11, r9, r8, r10)
            r8 = 1
            r0.a((net.fxgear.b.k) r4, (int) r11, (boolean) r14, (boolean) r8)
            r9 = 2960(0xb90, float:4.148E-42)
            android.opengl.GLES20.glEnable(r9)
            r9 = 9
            android.opengl.GLES20.glClearStencil(r9)
            r9 = 1024(0x400, float:1.435E-42)
            android.opengl.GLES20.glClear(r9)
            android.opengl.GLES20.glColorMask(r8, r8, r8, r8)
            r9 = 2929(0xb71, float:4.104E-42)
            android.opengl.GLES20.glEnable(r9)
            android.opengl.GLES20.glDepthMask(r8)
            r0.ad = r8
            r8 = -998637568(0xffffffffc47a0000, float:-1000.0)
            r0.ab = r8
            float r8 = r5.q()
            r9 = 0
            int r8 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r8 <= 0) goto L_0x02b2
            r13 = 1148846080(0x447a0000, float:1000.0)
            goto L_0x02ba
        L_0x02b2:
            float r8 = r5.q()
            r9 = 1097859072(0x41700000, float:15.0)
            float r13 = r8 + r9
        L_0x02ba:
            r0.ac = r13
            float r8 = r4.s()
            float r8 = r8 + r3
            r3 = 1073741824(0x40000000, float:2.0)
            float r8 = r8 + r3
            r0.aa = r8
            float r3 = r4.s()
            r8 = 1084227584(0x40a00000, float:5.0)
            float r3 = r3 - r8
            r0.Z = r3
            r3 = 19
            r8 = 518(0x206, float:7.26E-43)
            r9 = 65535(0xffff, float:9.1834E-41)
            r10 = 1028(0x404, float:1.44E-42)
            android.opengl.GLES20.glStencilFuncSeparate(r10, r8, r3, r9)
            r3 = 10
            r11 = 1029(0x405, float:1.442E-42)
            android.opengl.GLES20.glStencilFuncSeparate(r11, r8, r3, r9)
            r3 = 1
            r0.a((net.fxgear.b.k) r5, (int) r14, (boolean) r14, (boolean) r3)
            float r5 = r4.s()
            r0.Z = r5
            r5 = 18
            android.opengl.GLES20.glStencilFuncSeparate(r10, r8, r5, r9)
            r5 = 11
            android.opengl.GLES20.glStencilFuncSeparate(r11, r8, r5, r9)
            r0.a((net.fxgear.b.k) r7, (int) r14, (boolean) r14, (boolean) r3)
            r5 = 17
            android.opengl.GLES20.glStencilFuncSeparate(r10, r8, r5, r9)
            r5 = 12
            android.opengl.GLES20.glStencilFuncSeparate(r11, r8, r5, r9)
            r0.a((net.fxgear.b.k) r6, (int) r14, (boolean) r14, (boolean) r3)
            r5 = 2960(0xb90, float:4.148E-42)
            android.opengl.GLES20.glDisable(r5)
            goto L_0x030f
        L_0x030c:
            r3 = 1
            r5 = 2960(0xb90, float:4.148E-42)
        L_0x030f:
            android.opengl.GLES20.glDisable(r5)
            if (r22 != 0) goto L_0x0328
            r5 = -998637568(0xffffffffc47a0000, float:-1000.0)
            r0.ab = r5
            r7 = 1148846080(0x447a0000, float:1000.0)
            r0.ac = r7
            r0.aa = r7
            float r8 = r4.s()
            r0.Z = r8
            r0.a((net.fxgear.b.k) r4, (int) r14, (boolean) r14, (boolean) r3)
            goto L_0x032c
        L_0x0328:
            r5 = -998637568(0xffffffffc47a0000, float:-1000.0)
            r7 = 1148846080(0x447a0000, float:1000.0)
        L_0x032c:
            r0.ad = r14
            r0.ab = r5
            r0.ac = r7
            r3 = 0
            r0.Z = r3
            r3 = 1128792064(0x43480000, float:200.0)
            r0.aa = r3
            if (r22 == 0) goto L_0x034e
            if (r6 == 0) goto L_0x034e
            float r2 = r6.r()
            r3 = 1077936128(0x40400000, float:3.0)
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 < 0) goto L_0x0354
            net.fxgear.b.k r2 = r1.i
            r3 = 1
            r0.a((net.fxgear.b.k) r2, (int) r14, (boolean) r14, (boolean) r3)
            goto L_0x0354
        L_0x034e:
            r3 = 1
            net.fxgear.b.k r2 = r1.i
            r0.a((net.fxgear.b.k) r2, (int) r14, (boolean) r14, (boolean) r3)
        L_0x0354:
            r0.ad = r14
            r2 = -998637568(0xffffffffc47a0000, float:-1000.0)
            r0.ab = r2
            r2 = 1148846080(0x447a0000, float:1000.0)
            r0.ac = r2
            r2 = 0
            r0.Z = r2
            r2 = 1128792064(0x43480000, float:200.0)
            r0.aa = r2
            net.fxgear.b.k r2 = r1.f671b
            net.fxgear.b.k r3 = r1.c
            r0.a((net.fxgear.b.k) r2, (net.fxgear.b.k) r3, (int) r14, (boolean) r14)
            net.fxgear.b.k r2 = r1.c
            net.fxgear.b.k r1 = r1.d
            r3 = 1
            r0.b((net.fxgear.b.k) r2, (net.fxgear.b.k) r1, (int) r14, (boolean) r3)
            r1 = 2929(0xb71, float:4.104E-42)
            android.opengl.GLES20.glDisable(r1)
            r1 = 2960(0xb90, float:4.148E-42)
            android.opengl.GLES20.glDisable(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.b.m.c(net.fxgear.b.c, int, boolean, int):void");
    }

    private void a(c cVar, c cVar2, int i2, boolean z2, int i3) {
        float f2;
        float f3;
        int i4;
        int i5;
        float f4;
        boolean z3;
        c cVar3 = cVar;
        int i6 = i2;
        int i7 = i3;
        k kVar = cVar2.f670a;
        k kVar2 = null;
        k kVar3 = null;
        k kVar4 = null;
        switch (i6) {
            case 1:
                kVar2 = cVar3.g;
                break;
            case 2:
                kVar3 = cVar3.f;
                break;
            case 3:
                kVar4 = cVar3.e;
                break;
            case 4:
                kVar3 = cVar3.h;
                break;
            case 5:
                kVar2 = cVar3.g;
                kVar3 = cVar3.f;
                break;
            case 6:
                kVar2 = cVar3.g;
                kVar4 = cVar3.e;
                break;
            case 7:
                kVar3 = cVar3.h;
                kVar4 = cVar3.e;
                break;
            case 8:
                kVar3 = cVar3.f;
                kVar4 = cVar3.e;
                break;
            case 9:
                kVar2 = cVar3.g;
                kVar3 = cVar3.f;
                kVar4 = cVar3.e;
                break;
        }
        GLES20.glEnable(2929);
        GLES20.glEnable(2960);
        GLES20.glStencilOpSeparate(1028, 7680, 7680, 7681);
        GLES20.glStencilOpSeparate(1029, 7680, 7680, 7681);
        if (i7 == 1) {
            f2 = 4.0f - (((kVar.s() - 10.966392f) * 4.0f) / 5.377343f);
        } else {
            f2 = i7 == 0 ? 0.5f - (((kVar.s() - 14.65414f) * 6.0f) / 7.4542923f) : GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        }
        if (z2) {
            if (!(kVar4 == null || kVar3 == null)) {
                GLES20.glClearStencil(100);
                GLES20.glClear(FXUtil.MAX_CUSTOM_FACE_IMAGE_SIZE);
                GLES20.glColorMask(false, false, false, false);
                GLES20.glDisable(2929);
                this.ad = 0;
                this.ab = 205.0f;
                this.ac = 215.0f;
                this.Z = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
                this.aa = 200.0f;
                GLES20.glDepthMask(false);
                GLES20.glStencilFuncSeparate(1028, 519, 0, 65535);
                GLES20.glStencilFuncSeparate(1029, 519, 0, 65535);
                a(kVar4, 1028, false, true);
                a(kVar, 1028, false, true);
                this.ad = 1;
                this.ab = -1000.0f;
                this.ac = 1000.0f;
                this.aa = 1000.0f;
                this.Z = kVar.s() + f2;
                GLES20.glDepthMask(false);
                GLES20.glStencilFuncSeparate(1028, 519, 10, 65535);
                GLES20.glStencilFuncSeparate(1029, 519, 10, 65535);
                a(kVar4, 1028, false, true);
                GLES20.glDepthMask(false);
                GLES20.glStencilFuncSeparate(1028, 519, 10, 65535);
                GLES20.glStencilFuncSeparate(1029, 519, 10, 65535);
                a(kVar3, 1028, false, true);
                GLES20.glDepthMask(false);
                GLES20.glStencilFuncSeparate(1028, 519, 10, 65535);
                GLES20.glStencilFuncSeparate(1029, 519, 10, 65535);
                a(kVar, 1028, false, true);
                this.ad = 2;
                this.ab = -1000.0f;
                this.ac = 1000.0f;
                this.aa = kVar.s();
                this.Z = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
                this.aa = kVar.s() + 5.0f;
                this.Z = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
                GLES20.glDepthMask(false);
                GLES20.glStencilFuncSeparate(1028, 519, 0, 65535);
                GLES20.glStencilFuncSeparate(1029, 519, 0, 65535);
                a(kVar4, 1028, false, true);
                this.aa = 1000.0f;
                this.Z = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
                GLES20.glDepthMask(false);
                GLES20.glStencilFuncSeparate(1028, 519, 0, 65535);
                GLES20.glStencilFuncSeparate(1029, 519, 0, 65535);
                a(kVar2, 1028, false, true);
                this.aa = kVar.s();
                this.Z = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
                GLES20.glDepthMask(false);
                GLES20.glStencilFuncSeparate(1028, 519, 0, 65535);
                GLES20.glStencilFuncSeparate(1029, 519, 0, 65535);
                a(kVar, 1028, false, true);
                boolean z4 = cVar3.f != null && cVar3.f.k() == GlobalDefine.CLOTHES_CATEGORY_TYPE.LongTop;
                if (i6 == 7 || ((i6 == 8 && z4) || (i6 == 9 && z4))) {
                    this.ad = 2;
                    this.ab = 200.5f;
                    this.ac = 1000.0f;
                    this.aa = kVar.s();
                    this.Z = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
                    GLES20.glDepthMask(false);
                    GLES20.glStencilFuncSeparate(1028, 519, 0, 65535);
                    GLES20.glStencilFuncSeparate(1029, 519, 0, 65535);
                    z3 = true;
                    a(kVar3, 1028, false, true);
                } else {
                    z3 = true;
                }
                GLES20.glColorMask(z3, z3, z3, z3);
                GLES20.glEnable(2929);
                GLES20.glDepthMask(z3);
            }
            this.ad = 2;
            this.ab = -1000.0f;
            this.ac = 1000.0f;
            this.aa = kVar.s();
            this.Z = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            this.aa = kVar.s() + 5.0f;
            this.Z = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            GLES20.glStencilFuncSeparate(1028, 518, 8, 65535);
            i4 = 1;
            GLES20.glStencilFuncSeparate(1029, 518, 1, 65535);
            a(kVar4, 1028, false, true);
            this.aa = kVar.s();
            this.Z = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            GLES20.glStencilFuncSeparate(1028, 518, 7, 65535);
            GLES20.glStencilFuncSeparate(1029, 518, 2, 65535);
            a(kVar3, 1028, false, true);
            f3 = 1000.0f;
            this.aa = 1000.0f;
            this.Z = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
            GLES20.glStencilFuncSeparate(1028, 518, 6, 65535);
            GLES20.glStencilFuncSeparate(1029, 518, 3, 65535);
            a(kVar2, 1028, false, true);
        } else {
            i4 = 1;
            f3 = 1000.0f;
        }
        this.ad = i4;
        this.ab = -1000.0f;
        this.ac = f3;
        this.aa = f3;
        this.Z = kVar.s();
        if (z2) {
            this.aa = f3;
            this.Z = kVar.s() + f2;
            GLES20.glStencilFuncSeparate(1028, 518, 18, 65535);
            GLES20.glStencilFuncSeparate(1029, 518, 11, 65535);
            this.ab = -1000.0f;
            this.ac = f3;
            a(kVar4, 1028, false, true);
            this.aa = f3;
            this.Z = kVar.s() + f2;
            GLES20.glStencilFuncSeparate(1028, 518, 17, 65535);
            GLES20.glStencilFuncSeparate(1029, 518, 12, 65535);
            this.ab = -1000.0f;
            if (kVar4 != null) {
                if (kVar4.q() > f3) {
                    f4 = 1000.0f;
                } else {
                    f4 = kVar4.q() + 15.0f;
                }
                this.ac = f4;
            }
            if (kVar4 != null && kVar3 != null) {
                a(kVar3, 1028, false, true);
            } else if (kVar4 == null && kVar3 != null) {
                a(kVar3, 1028, false, true);
            }
            if (!(kVar4 == null || kVar3 == null || kVar4.q() <= 1000.0f)) {
                GLES20.glEnable(2960);
                GLES20.glClearStencil(100);
                GLES20.glClear(FXUtil.MAX_CUSTOM_FACE_IMAGE_SIZE);
                GLES20.glColorMask(false, false, false, false);
                GLES20.glDisable(2929);
                GLES20.glDepthMask(false);
                this.ad = 0;
                this.ab = -1000.0f;
                this.ac = kVar4.q() > 1000.0f ? 1000.0f : kVar4.q() + 15.0f;
                this.aa = kVar.s() + f2 + 1.0f;
                this.Z = (kVar.s() + f2) - 5.0f;
                GLES20.glStencilFuncSeparate(1028, 519, 18, 65535);
                GLES20.glStencilFuncSeparate(1029, 519, 1, 65535);
                a(kVar4, 1028, false, true);
                GLES20.glStencilFuncSeparate(1028, 519, 0, 65535);
                GLES20.glStencilFuncSeparate(1029, 519, 0, 65535);
                a(kVar, 1028, false, true);
                GLES20.glColorMask(true, true, true, true);
                GLES20.glEnable(2929);
                GLES20.glDepthMask(true);
                this.ad = 1;
                this.ab = -1000.0f;
                this.ac = kVar4.q() > 1000.0f ? 1000.0f : kVar4.q() + 15.0f;
                this.aa = kVar.s() + f2 + 1.0f;
                this.Z = (kVar.s() + f2) - 5.0f;
                GLES20.glStencilFuncSeparate(1028, 518, 17, 65535);
                GLES20.glStencilFuncSeparate(1029, 518, 2, 65535);
                a(kVar3, 1028, false, true);
                i5 = 2960;
                GLES20.glDisable(2960);
                GLES20.glDisable(i5);
                this.ad = 0;
                this.ab = -1000.0f;
                this.ac = 1000.0f;
                this.Z = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
                this.aa = 200.0f;
                GLES20.glDisable(2929);
                GLES20.glDisable(i5);
            }
        }
        i5 = 2960;
        GLES20.glDisable(i5);
        this.ad = 0;
        this.ab = -1000.0f;
        this.ac = 1000.0f;
        this.Z = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        this.aa = 200.0f;
        GLES20.glDisable(2929);
        GLES20.glDisable(i5);
    }

    private void b(c cVar, boolean z2) {
        this.ad = 0;
        this.ab = -1000.0f;
        this.ac = 1000.0f;
        this.Z = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        this.aa = 200.0f;
        GLES20.glEnable(2929);
        float min = (cVar.f == null || z2) ? 199.5f : Math.min(cVar.f.q(), 199.5f);
        if (cVar.e != null) {
            min = Math.min(cVar.e.q(), min);
        }
        if (cVar.h != null && !z2) {
            min = Math.min(cVar.h.q(), min);
        }
        this.ad = 1;
        this.Z = cVar.f670a.s();
        this.aa = 200.0f;
        this.ab = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        this.ac = min + 15.0f;
        if (this.ac <= 199.5f) {
            if (this.ac <= (cVar.h != null ? 14.0f : 45.0f)) {
                a(cVar.f670a, 0, false, true);
                this.ad = 0;
                this.Z = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
                this.aa = 200.0f;
                this.ab = -1000.0f;
                this.ac = 1000.0f;
                a(cVar.f671b, cVar.c, 0, false);
                b(cVar.c, cVar.d, 0, true);
            }
        }
        this.ab = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        this.ac = 199.5f;
        this.aa = this.Z + 1.0f;
        GLES20.glEnable(2960);
        a(cVar.f670a, 0, false, true);
        this.Z += 1.0f;
        this.aa = 200.0f;
        GLES20.glDisable(2960);
        a(cVar.f670a, 0, false, true);
        this.ad = 0;
        this.Z = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        this.aa = 200.0f;
        this.ab = -1000.0f;
        this.ac = 1000.0f;
        a(cVar.f671b, cVar.c, 0, false);
        b(cVar.c, cVar.d, 0, true);
    }

    public boolean b(int i2, int i3) {
        if (this.bG != null) {
            return this.bG.contains(i2, i3);
        }
        return false;
    }

    private void a(float[] fArr, int i2) {
        float f2;
        float f3;
        float f4;
        float f5;
        int i3 = i2;
        float[] j2 = this.z.j(i3);
        if (j2 == null) {
            Log.e("FXSkeletalAnimationRenderer : ", "No animation pos table yet.");
            if (this.bG != null) {
                this.bG.left = 0;
                this.bG.top = 0;
                this.bG.right = 0;
                this.bG.bottom = 0;
            }
        } else if (j2.length <= 71) {
            Log.e("FXSkeletalAnimationRenderer : ", "Not enough animation position to calculate body rect.");
            if (this.bG != null) {
                this.bG.left = 0;
                this.bG.top = 0;
                this.bG.right = 0;
                this.bG.bottom = 0;
            }
        } else {
            float f6 = this.z.b(i3).i[0];
            float f7 = this.z.b(i3).i[1];
            float f8 = j2[280];
            float f9 = j2[281];
            float f10 = j2[282];
            if (f8 == GlobalDefine.DEFAULT_AUTO_FILTER_VALUE && f9 == GlobalDefine.DEFAULT_AUTO_FILTER_VALUE && f10 == GlobalDefine.DEFAULT_AUTO_FILTER_VALUE) {
                Log.e("FXSkeletalAnimationRenderer : ", "Invalid joint data (not initialized.");
                return;
            }
            float f11 = (fArr[0] * f8) + (fArr[4] * f9) + (fArr[8] * f10) + (fArr[12] * 1.0f);
            int i4 = fArr[2];
            int i5 = fArr[6];
            int i6 = fArr[10];
            int i7 = fArr[14];
            float f12 = (fArr[3] * f8) + (fArr[7] * f9) + (fArr[11] * f10) + (fArr[15] * 1.0f);
            float f13 = (f11 + f6) / f12;
            float f14 = (((((fArr[1] * f8) + (fArr[5] * f9)) + (fArr[9] * f10)) + (fArr[13] * 1.0f)) + f7) / f12;
            float f15 = j2[284];
            float f16 = j2[285];
            float f17 = j2[286];
            float f18 = (fArr[0] * f15) + (fArr[4] * f16) + (fArr[8] * f17) + (fArr[12] * 1.0f);
            float f19 = (fArr[1] * f15) + (fArr[5] * f16) + (fArr[9] * f17) + (fArr[13] * 1.0f);
            int i8 = fArr[2];
            float f20 = fArr[6];
            int i9 = fArr[10];
            int i10 = fArr[14];
            float f21 = (fArr[3] * f15) + (fArr[7] * f16) + (fArr[11] * f17) + (fArr[15] * 1.0f);
            float f22 = (f18 + f6) / f21;
            float f23 = (f19 + f7) / f21;
            float f24 = j2[204];
            float f25 = j2[205];
            float f26 = j2[206];
            float f27 = fArr[0];
            int i11 = fArr[4];
            float f28 = fArr[8];
            int i12 = fArr[12];
            float f29 = (fArr[1] * f24) + (fArr[5] * f25) + (fArr[9] * f26) + (fArr[13] * 1.0f);
            int i13 = fArr[2];
            int i14 = fArr[6];
            int i15 = fArr[10];
            int i16 = fArr[14];
            float f30 = (f29 + f7) / ((((fArr[3] * f24) + (fArr[7] * f25)) + (fArr[11] * f26)) + (fArr[15] * 1.0f));
            float f31 = j2[220];
            float f32 = j2[221];
            float f33 = j2[222];
            int i17 = fArr[0];
            int i18 = fArr[4];
            int i19 = fArr[8];
            int i20 = fArr[12];
            float f34 = (fArr[1] * f31) + (fArr[5] * f32) + (fArr[9] * f33) + (fArr[13] * 1.0f);
            int i21 = fArr[2];
            int i22 = fArr[6];
            int i23 = fArr[10];
            int i24 = fArr[14];
            float f35 = (f34 + f7) / ((((fArr[3] * f31) + (fArr[7] * f32)) + (fArr[11] * f33)) + (fArr[15] * 1.0f));
            float f36 = j2[224];
            float f37 = j2[225];
            float f38 = j2[226];
            float f39 = (fArr[0] * f36) + (fArr[4] * f37) + (fArr[8] * f38) + (fArr[12] * 1.0f);
            float f40 = (fArr[1] * f36) + (fArr[5] * f37) + (fArr[9] * f38) + (fArr[13] * 1.0f);
            int i25 = fArr[2];
            int i26 = fArr[6];
            int i27 = fArr[10];
            int i28 = fArr[14];
            float f41 = (fArr[3] * f36) + (fArr[7] * f37) + (fArr[11] * f38) + (fArr[15] * 1.0f);
            float f42 = (f39 + f6) / f41;
            float f43 = (f40 + f7) / f41;
            if (f22 > f13) {
                float f44 = f13;
                f13 = f22;
                f22 = f44;
            }
            if (f23 <= f14) {
                f14 = f23;
            }
            if (f35 <= f30) {
                f35 = f30;
            }
            float f45 = f22 + 1.0f;
            float f46 = f42 + 1.0f;
            float f47 = 2.0f - (f14 + 1.0f);
            float f48 = 2.0f - (f35 + 1.0f);
            float f49 = 2.0f - (f43 + 1.0f);
            float f50 = this.ag / 2.0f;
            float f51 = this.ah / 2.0f;
            float f52 = (f13 + 1.0f) - f45;
            if (f52 < 0.3f) {
                f3 = (f46 - 0.15f) * f50;
                f2 = f50 * 0.3f;
            } else {
                f3 = f45 * f50;
                f2 = f50 * f52;
            }
            float f53 = f48 - f47;
            if (f53 < 0.3f) {
                f5 = (f49 - 0.15f) * f51;
                f4 = f51 * 0.3f;
            } else {
                f5 = f47 * f51;
                f4 = f51 * f53;
            }
            if (this.bG != null) {
                this.bG.left = Math.round(f3);
                this.bG.top = Math.round(f5);
                this.bG.right = this.bG.left + Math.round(f2);
                this.bG.bottom = this.bG.top + Math.round(f4);
            }
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\b\n.java ==========

package net.fxgear.b;

import android.util.Log;
import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL10;
import net.fxgear.GlobalDefine;
import net.fxgear.b.h;
import net.fxgear.b.p;

/* compiled from: FXResourceMgr */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private p[] f704a = new p[5];

    /* renamed from: b  reason: collision with root package name */
    private c[] f705b = new c[5];
    private ArrayList<k> c = null;
    private ArrayList<p> d = null;
    private ArrayList<e> e = null;
    private float f = 0.4f;
    private float g = 0.4f;
    private float h = 0.001f;
    private float i = 0.3f;
    private float j = 1.4f;
    private int k = 8;

    public n() {
        for (int i2 = 0; i2 < 5; i2++) {
            this.f704a[i2] = new p();
            this.f705b[i2] = new c();
        }
        this.c = new ArrayList<>();
        this.d = new ArrayList<>();
        this.e = new ArrayList<>();
    }

    public void a() {
        int i2;
        synchronized (this.c) {
            for (int i3 = 0; i3 < this.c.size(); i3++) {
                this.c.get(i3).t();
            }
        }
        synchronized (this.e) {
            for (i2 = 0; i2 < this.e.size(); i2++) {
                this.e.get(i2).b();
            }
        }
    }

    public void b() {
        synchronized (this.c) {
            for (int i2 = 0; i2 < this.c.size(); i2++) {
                if (this.c.get(i2).j()) {
                    this.c.get(i2).g();
                }
            }
        }
    }

    public void c() {
        int i2;
        synchronized (this.c) {
            for (int i3 = 0; i3 < this.c.size(); i3++) {
                this.c.get(i3).g();
            }
        }
        synchronized (this.d) {
            for (int i4 = 0; i4 < this.d.size(); i4++) {
                this.d.get(i4).h();
            }
        }
        synchronized (this.e) {
            for (i2 = 0; i2 < this.e.size(); i2++) {
                this.e.get(i2).B();
            }
        }
    }

    public void a(int i2) {
        if (this.f705b[i2].f670a != null) {
            this.f705b[i2].f670a.Z();
            this.f705b[i2].f670a.g();
            this.f705b[i2].f670a = null;
        }
        if (this.f705b[i2].f671b != null) {
            this.f705b[i2].f671b.Z();
            this.f705b[i2].f671b.g();
            this.f705b[i2].f671b = null;
        }
        if (this.f705b[i2].c != null) {
            this.f705b[i2].c.Z();
            this.f705b[i2].c.g();
            this.f705b[i2].c = null;
        }
        if (this.f705b[i2].d != null) {
            this.f705b[i2].d.Z();
            this.f705b[i2].d.g();
            this.f705b[i2].d = null;
        }
        if (this.f705b[i2].e != null) {
            this.f705b[i2].e.Z();
            this.f705b[i2].e.g();
            this.f705b[i2].e = null;
        }
        if (this.f705b[i2].f != null) {
            this.f705b[i2].f.Z();
            this.f705b[i2].f.g();
            this.f705b[i2].f = null;
        }
        if (this.f705b[i2].g != null) {
            this.f705b[i2].g.Z();
            this.f705b[i2].g.g();
            this.f705b[i2].g = null;
        }
        if (this.f705b[i2].h != null) {
            this.f705b[i2].h.Z();
            this.f705b[i2].h.g();
            this.f705b[i2].h = null;
        }
        if (this.f705b[i2].i != null) {
            this.f705b[i2].i.Z();
            this.f705b[i2].i.g();
            this.f705b[i2].i = null;
        }
        this.f705b[i2].j = null;
        this.f705b[i2].k = null;
        this.f705b[i2].m = null;
        this.f705b[i2].n = null;
    }

    public void d() {
        e((GL10) null);
        f((GL10) null);
        g((GL10) null);
        for (int i2 = 0; i2 < 5; i2++) {
            this.f704a[i2].a((GL10) null);
            this.f704a[i2] = null;
            a(i2);
            this.f705b[i2] = null;
        }
        this.f704a = null;
        this.f705b = null;
    }

    public void a(int i2, float[] fArr) {
        this.f705b[i2].b(fArr);
    }

    public void a(int i2, boolean z, boolean z2, boolean z3) {
        this.f705b[i2].a(z, z2, z3);
    }

    public void a(int i2, float f2) {
        this.f705b[i2].a(f2);
    }

    public void a(int i2, float f2, float f3, float f4, float[] fArr, float[] fArr2, float[] fArr3, float f5, float f6) {
        this.f705b[i2].a(f2, f3, f4, fArr, fArr2, fArr3, f5, f6);
    }

    public void a(int i2, float f2, float f3, float f4, float[] fArr, float[] fArr2, float[] fArr3, float f5) {
        this.f705b[i2].a(f2, f3, f4, fArr, fArr2, fArr3, f5);
    }

    public void a(int i2, boolean z) {
        this.f705b[i2].f671b.b(z);
    }

    public void a(k kVar) {
        this.c.add(kVar);
        Log.i("FXResourceMgr : ", "mAssociatedMesh added");
    }

    public void a(p pVar) {
        this.d.add(pVar);
        Log.i("FXResourceMgr : ", "mAssociatedSkeleton added " + this.d.size());
    }

    public void a(e eVar) {
        this.e.add(eVar);
        Log.i("FXResourceMgr : ", "mAssociatedBlendShape added");
    }

    public k a(String str) {
        synchronized (this.c) {
            int size = this.c.size();
            int i2 = 0;
            while (i2 < size) {
                if (this.c.get(i2).aa() == null || !this.c.get(i2).aa().equals(str)) {
                    i2++;
                } else {
                    k kVar = this.c.get(i2);
                    return kVar;
                }
            }
            return null;
        }
    }

    public p b(String str) {
        synchronized (this.d) {
            int size = this.d.size();
            int i2 = 0;
            while (i2 < size) {
                if (this.d.get(i2).m() == null || !this.d.get(i2).m().equals(str)) {
                    i2++;
                } else {
                    p pVar = this.d.get(i2);
                    return pVar;
                }
            }
            return null;
        }
    }

    public p c(String str) {
        synchronized (this.d) {
            int size = this.d.size();
            int i2 = 0;
            while (i2 < size) {
                if (this.d.get(i2).l() == null || !this.d.get(i2).l().equals(str)) {
                    i2++;
                } else {
                    p pVar = this.d.get(i2);
                    return pVar;
                }
            }
            return null;
        }
    }

    public p b(int i2) {
        return this.f704a[i2];
    }

    public e d(String str) {
        synchronized (this.e) {
            int size = this.e.size();
            int i2 = 0;
            while (i2 < size) {
                if (this.e.get(i2).k() == null || !this.e.get(i2).k().equals(str)) {
                    i2++;
                } else {
                    e eVar = this.e.get(i2);
                    return eVar;
                }
            }
            return null;
        }
    }

    public void a(GL10 gl10) {
        b(gl10);
        c(gl10);
        d(gl10);
    }

    public void b(GL10 gl10) {
        int i2;
        synchronized (this.c) {
            i2 = 0;
            for (int size = this.c.size() - 1; size >= 0; size--) {
                k kVar = this.c.get(size);
                if ((kVar.d() == 0 && ((!kVar.i() || kVar.c() > 5.0f) && !kVar.l())) || (kVar.h() && !kVar.l())) {
                    if (kVar.Y() != null) {
                        kVar.Y().d();
                    }
                    kVar.a(gl10);
                    this.c.remove(size);
                    i2++;
                }
            }
        }
        if (i2 > 0) {
            Log.i("FXResourceMgr : ", "[c] DeleteGabageMeshes heap removeCount: " + i2);
            System.gc();
        }
        Log.i("FXResourceMgr : ", "[c] Total " + i2 + " meshes are removed from memory. " + this.c.size());
    }

    public void c(GL10 gl10) {
        int i2;
        synchronized (this.d) {
            i2 = 0;
            for (int size = this.d.size() - 1; size >= 0; size--) {
                p pVar = this.d.get(size);
                if ((pVar.f() == 0 && ((!pVar.j() || pVar.e() > 5.0f) && !pVar.g())) || (pVar.i() && !pVar.g())) {
                    if (pVar.A() != null) {
                        pVar.A().d();
                    }
                    pVar.a(gl10);
                    this.d.remove(size);
                    i2++;
                }
            }
        }
        if (i2 > 0) {
            Log.i("FXResourceMgr : ", "[c] DeleteGabageSkeletons heap removeCount: " + i2);
            System.gc();
        }
        Log.i("FXResourceMgr : ", "[c] Total " + i2 + " skeletons are removed from memory. " + this.d.size());
    }

    public void d(GL10 gl10) {
        int i2;
        synchronized (this.e) {
            i2 = 0;
            for (int size = this.e.size() - 1; size >= 0; size--) {
                e eVar = this.e.get(size);
                if ((eVar.f() == 0 && ((!eVar.D() || eVar.e() > 5.0f) && !eVar.i())) || (eVar.C() && !eVar.i())) {
                    eVar.a(gl10);
                    this.e.remove(size);
                    i2++;
                }
            }
        }
        if (i2 > 0) {
            Log.i("FXResourceMgr : ", "[c] DeleteGabageBlendShapes heap removeCount: " + i2);
            System.gc();
        }
        Log.i("FXResourceMgr : ", "[c] Total " + i2 + " blendshapes are removed from memory. " + this.e.size());
    }

    public void e(GL10 gl10) {
        Log.i("FXResourceMgr : ", "[c] DeleteAllMeshes not gc()!");
        if (this.c != null) {
            synchronized (this.c) {
                for (int i2 = 0; i2 < this.c.size(); i2++) {
                    this.c.get(i2).a(gl10);
                }
                this.c.clear();
            }
            this.c = null;
        }
    }

    public void f(GL10 gl10) {
        if (this.d != null) {
            synchronized (this.d) {
                for (int i2 = 0; i2 < this.d.size(); i2++) {
                    this.d.get(i2).a(gl10);
                }
                this.d.clear();
            }
            this.d = null;
        }
    }

    public void g(GL10 gl10) {
        if (this.e != null) {
            synchronized (this.e) {
                for (int i2 = 0; i2 < this.e.size(); i2++) {
                    this.e.get(i2).a(gl10);
                }
                this.e.clear();
            }
            this.e = null;
        }
    }

    public void a(p pVar, int i2, boolean z) {
        if (z) {
            b.a(pVar, pVar.F());
            if (pVar.a() != null) {
                b.b(pVar, pVar.a().F());
            }
        }
        a(pVar, i2);
    }

    public void a(p pVar, int i2) {
        if (this.f704a[i2].r() > -1) {
            this.f704a[i2].d();
        }
        this.f704a[i2] = pVar;
        if (pVar.x() != null) {
            this.f705b[i2].a(pVar.x());
            e(i2);
        }
        this.f704a[i2].c();
    }

    public p c(int i2) {
        if (this.f704a[i2].r() > -1) {
            return this.f704a[i2];
        }
        Log.e("FXResourceMgr : ", "mSkeleton is null modelCategory : " + i2);
        return null;
    }

    public p d(int i2) {
        p pVar;
        switch (i2) {
            case 0:
                pVar = this.f704a[0];
                break;
            case 1:
                pVar = this.f704a[1];
                break;
            case 2:
                pVar = this.f704a[2];
                break;
            case 3:
                pVar = this.f704a[3];
                break;
            default:
                pVar = null;
                break;
        }
        if (pVar == null) {
            Log.e("FXResourceMgr : ", "No available skeleton gender ID: " + i2);
        }
        return pVar;
    }

    public void a(p pVar, e eVar) {
        if (pVar.A() != null) {
            pVar.A().d();
        }
        pVar.a(eVar);
        eVar.c();
        eVar.h();
    }

    public void a(k kVar, e eVar) {
        if (kVar.Y() != null) {
            kVar.Y().d();
        }
        kVar.a(eVar);
        eVar.c();
        eVar.h();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0048, code lost:
        if (r1[26] > 1.0f) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0055, code lost:
        if (r1[27] > 1.0f) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x007f, code lost:
        if (r1[28] > 1.0f) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x008c, code lost:
        if (r1[29] > 1.0f) goto L_0x008e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(net.fxgear.b.k r22, net.fxgear.b.k r23, net.fxgear.b.p r24, float[] r25) {
        /*
            r21 = this;
            r0 = r24
            r1 = r25
            long r2 = java.lang.System.currentTimeMillis()
            r4 = 0
            r5 = r23
            r6 = 0
            r7 = 0
        L_0x000d:
            float[] r8 = r5.a((float[]) r1, (net.fxgear.b.p) r0, (boolean) r4)
            r9 = 1
            r10 = r22
            float[] r11 = r10.a((float[]) r1, (net.fxgear.b.p) r0, (boolean) r9)
            if (r8 == 0) goto L_0x00c9
            if (r11 == 0) goto L_0x00c9
            r12 = 0
            r13 = 27
            r14 = 26
            r15 = 1056964608(0x3f000000, float:0.5)
            r16 = 1065353216(0x3f800000, float:1.0)
            r17 = 1036831949(0x3dcccccd, float:0.1)
            if (r6 != 0) goto L_0x0058
            r18 = r8[r4]
            r19 = r11[r4]
            float r19 = r19 + r15
            float r19 = r19 - r18
            float r18 = java.lang.Math.abs(r19)
            int r18 = (r18 > r15 ? 1 : (r18 == r15 ? 0 : -1))
            if (r18 <= 0) goto L_0x0057
            int r18 = (r19 > r12 ? 1 : (r19 == r12 ? 0 : -1))
            if (r18 <= 0) goto L_0x004b
            r18 = r1[r14]
            float r18 = r18 + r17
            r1[r14] = r18
            r18 = r1[r14]
            int r18 = (r18 > r16 ? 1 : (r18 == r16 ? 0 : -1))
            if (r18 <= 0) goto L_0x0058
            goto L_0x0057
        L_0x004b:
            r18 = r1[r13]
            float r18 = r18 + r17
            r1[r13] = r18
            r18 = r1[r13]
            int r18 = (r18 > r16 ? 1 : (r18 == r16 ? 0 : -1))
            if (r18 <= 0) goto L_0x0058
        L_0x0057:
            r6 = 1
        L_0x0058:
            r18 = 29
            r19 = 28
            if (r7 != 0) goto L_0x008f
            r20 = 2
            r8 = r8[r20]
            r11 = r11[r20]
            r20 = 1069547520(0x3fc00000, float:1.5)
            float r11 = r11 + r20
            float r11 = r11 - r8
            float r8 = java.lang.Math.abs(r11)
            int r8 = (r8 > r15 ? 1 : (r8 == r15 ? 0 : -1))
            if (r8 <= 0) goto L_0x008e
            int r8 = (r11 > r12 ? 1 : (r11 == r12 ? 0 : -1))
            if (r8 <= 0) goto L_0x0082
            r8 = r1[r19]
            float r8 = r8 + r17
            r1[r19] = r8
            r8 = r1[r19]
            int r8 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1))
            if (r8 <= 0) goto L_0x008f
            goto L_0x008e
        L_0x0082:
            r8 = r1[r18]
            float r8 = r8 + r17
            r1[r18] = r8
            r8 = r1[r18]
            int r8 = (r8 > r16 ? 1 : (r8 == r16 ? 0 : -1))
            if (r8 <= 0) goto L_0x008f
        L_0x008e:
            r7 = 1
        L_0x008f:
            if (r6 == 0) goto L_0x000d
            if (r7 == 0) goto L_0x000d
            java.lang.String r0 = "FXResourceMgr : "
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "[c] RefreshAvatarBlendWeight front_checked && back_checked break, blendweight[26]: "
            r4.append(r5)
            r5 = r1[r14]
            r4.append(r5)
            java.lang.String r5 = ", blendweight[27]: "
            r4.append(r5)
            r5 = r1[r13]
            r4.append(r5)
            java.lang.String r5 = ", blendweight[28]: "
            r4.append(r5)
            r5 = r1[r19]
            r4.append(r5)
            java.lang.String r5 = ", blendweight[29]: "
            r4.append(r5)
            r1 = r1[r18]
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            android.util.Log.e(r0, r1)
        L_0x00c9:
            java.lang.String r0 = "FXResourceMgr : "
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "[JE] time: "
            r1.append(r4)
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r2
            r1.append(r4)
            java.lang.String r1 = r1.toString()
            android.util.Log.d(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.fxgear.b.n.a(net.fxgear.b.k, net.fxgear.b.k, net.fxgear.b.p, float[]):void");
    }

    public void e(int i2) {
        if (this.f705b[i2].a() != null) {
            if (this.f704a[i2] != null) {
                this.f704a[i2].g(this.f705b[i2].a());
            }
            if (this.f705b[i2].f670a != null && !this.f705b[i2].f670a.h()) {
                this.f705b[i2].f670a.a(this.f705b[i2].a(), this.f704a[i2]);
            }
            if (this.f705b[i2].f671b != null && !this.f705b[i2].f671b.h()) {
                this.f705b[i2].f671b.a(this.f705b[i2].a(), this.f704a[i2]);
            }
            if (this.f705b[i2].c != null && !this.f705b[i2].c.h()) {
                this.f705b[i2].c.a(this.f705b[i2].a(), this.f704a[i2]);
            }
            if (this.f705b[i2].d != null && !this.f705b[i2].d.h()) {
                this.f705b[i2].d.a(this.f705b[i2].a(), this.f704a[i2]);
            }
            if (this.f705b[i2].e != null && !this.f705b[i2].e.h()) {
                this.f705b[i2].e.a(this.f705b[i2].a(), this.f704a[i2]);
            }
            if (this.f705b[i2].f != null && !this.f705b[i2].f.h()) {
                float[] a2 = this.f705b[i2].a();
                Log.i("FXResourceMgr : ", "[c] RefreshAvatarBlendWeight : mTop.GetBlendTarget " + this.f705b[i2].f.Y().o().size());
                if (this.f705b[i2].f.Y().p()) {
                    float[] fArr = new float[(a2.length + this.k)];
                    for (int i3 = 0; i3 < a2.length; i3++) {
                        fArr[i3] = a2[i3];
                    }
                    float[] a3 = this.f705b[i2].f.a(fArr, this.f704a[i2], false);
                    if (a3 != null) {
                        Log.e("FXResourceMgr : ", "[c] RefreshAvatarBlendWeight top_tuckin: " + a3[0]);
                    }
                    if (this.f705b[i2].g != null && !this.f705b[i2].g.h()) {
                        a(this.f705b[i2].f, this.f705b[i2].g, this.f704a[i2], fArr);
                    }
                    this.f705b[i2].f.a(fArr, this.f704a[i2]);
                } else {
                    this.f705b[i2].f.a(a2, this.f704a[i2]);
                }
            }
            if (this.f705b[i2].g != null && !this.f705b[i2].g.h()) {
                this.f705b[i2].g.a(this.f705b[i2].a(), this.f704a[i2]);
            }
            if (this.f705b[i2].h != null && !this.f705b[i2].h.h()) {
                this.f705b[i2].h.a(this.f705b[i2].a(), this.f704a[i2]);
            }
            if (this.f705b[i2].i != null && !this.f705b[i2].i.h()) {
                this.f705b[i2].i.a(this.f705b[i2].a(), this.f704a[i2]);
            }
        }
    }

    public void a(k kVar, int i2, boolean z) {
        int i3 = AnonymousClass1.f706a[kVar.P().ordinal()];
        float f2 = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        switch (i3) {
            case 1:
                if (this.f705b[i2].f670a != null) {
                    this.f705b[i2].f670a.b();
                }
                if (this.f705b[i2].a() != null) {
                    kVar.a(this.f705b[i2].a(), this.f704a[i2]);
                }
                this.f705b[i2].f670a = kVar;
                kVar.a();
                kVar.f();
                break;
            case 2:
                if (this.f705b[i2].f671b != null) {
                    this.f705b[i2].f671b.b();
                    f2 = this.f705b[i2].f671b.ac();
                }
                if (this.f705b[i2].a() != null) {
                    kVar.a(this.f705b[i2].a(), this.f704a[i2]);
                }
                if (!z) {
                    kVar.f(f2);
                }
                this.f705b[i2].f671b = kVar;
                kVar.a();
                kVar.f();
                break;
            case 3:
                if (this.f705b[i2].c != null) {
                    this.f705b[i2].c.b();
                    f2 = this.f705b[i2].c.ac();
                }
                if (this.f705b[i2].a() != null) {
                    kVar.a(this.f705b[i2].a(), this.f704a[i2]);
                }
                if (!z) {
                    kVar.f(f2);
                }
                this.f705b[i2].c = kVar;
                kVar.a();
                kVar.f();
                break;
            case 4:
                if (this.f705b[i2].d != null) {
                    this.f705b[i2].d.b();
                    f2 = this.f705b[i2].d.ac();
                }
                if (this.f705b[i2].a() != null) {
                    kVar.a(this.f705b[i2].a(), this.f704a[i2]);
                }
                if (!z) {
                    kVar.f(f2);
                }
                this.f705b[i2].d = kVar;
                kVar.a();
                kVar.f();
                break;
            case 5:
                kVar.c(true);
                break;
            case 6:
                break;
            case 7:
                if (this.f705b[i2].f != null) {
                    this.f705b[i2].f.b();
                }
                if (this.f705b[i2].a() != null) {
                    kVar.a(this.f705b[i2].a(), this.f704a[i2]);
                }
                this.f705b[i2].f = kVar;
                kVar.a();
                kVar.f();
                break;
            case 8:
                if (this.f705b[i2].g != null) {
                    this.f705b[i2].g.b();
                }
                if (this.f705b[i2].a() != null) {
                    kVar.a(this.f705b[i2].a(), this.f704a[i2]);
                }
                this.f705b[i2].g = kVar;
                kVar.a();
                kVar.f();
                break;
            case 9:
                if (this.f705b[i2].h != null) {
                    this.f705b[i2].h.b();
                }
                if (this.f705b[i2].a() != null) {
                    kVar.a(this.f705b[i2].a(), this.f704a[i2]);
                }
                this.f705b[i2].h = kVar;
                kVar.a();
                kVar.f();
                break;
            case 10:
                if (this.f705b[i2].i != null) {
                    this.f705b[i2].i.b();
                }
                if (this.f705b[i2].a() != null) {
                    kVar.a(this.f705b[i2].a(), this.f704a[i2]);
                }
                this.f705b[i2].i = kVar;
                kVar.a();
                kVar.f();
                break;
            default:
                Log.e("FXResourceMgr : ", "[c] ERROR: AttachMeshToAvatar case default!");
                break;
        }
        if (this.f705b[i2].e != null) {
            this.f705b[i2].e.b();
        }
        if (this.f705b[i2].a() != null) {
            kVar.a(this.f705b[i2].a(), this.f704a[i2]);
        }
        this.f705b[i2].e = kVar;
        kVar.a();
        kVar.f();
        this.f705b[i2].b();
    }

    public void a(int i2, h.d dVar) {
        switch (dVar) {
            case BODY:
                if (this.f705b[i2].f670a != null) {
                    this.f705b[i2].f670a.b();
                }
                this.f705b[i2].f670a = null;
                break;
            case HEAD:
                if (this.f705b[i2].f671b != null) {
                    this.f705b[i2].f671b.b();
                }
                this.f705b[i2].f671b = null;
                break;
            case HAIR:
                if (this.f705b[i2].c != null) {
                    this.f705b[i2].c.b();
                }
                this.f705b[i2].c = null;
                break;
            case HAIR_ACC:
                if (this.f705b[i2].d != null) {
                    this.f705b[i2].d.b();
                }
                this.f705b[i2].d = null;
                break;
            case COAT:
            case JACK:
                if (this.f705b[i2].e != null) {
                    this.f705b[i2].e.b();
                }
                this.f705b[i2].e = null;
                break;
            case INNER:
                if (this.f705b[i2].f != null) {
                    this.f705b[i2].f.b();
                }
                this.f705b[i2].f = null;
                break;
            case PANTS:
                if (this.f705b[i2].g != null) {
                    this.f705b[i2].g.b();
                }
                this.f705b[i2].g = null;
                break;
            case ONEPIECE:
                if (this.f705b[i2].h != null) {
                    this.f705b[i2].h.b();
                }
                this.f705b[i2].h = null;
                break;
        }
        this.f705b[i2].b();
    }

    public c f(int i2) {
        return this.f705b[i2];
    }

    public k b(int i2, h.d dVar) {
        if (dVar == h.d.BODY) {
            if (this.f705b[i2].f670a.Q() != -1) {
                return this.f705b[i2].f670a;
            }
            Log.e("FXResourceMgr : ", "Model Category : " + i2 + " mBody was not attached");
            return null;
        } else if (dVar == h.d.HEAD) {
            if (this.f705b[i2].f671b.Q() != -1) {
                return this.f705b[i2].f671b;
            }
            Log.e("FXResourceMgr : ", "Model Category : " + i2 + " mHead was not attached");
            return null;
        } else if (dVar == h.d.HAIR) {
            if (this.f705b[i2].c.Q() != -1) {
                return this.f705b[i2].c;
            }
            Log.e("FXResourceMgr : ", "Model Category : " + i2 + " mHair was not attached");
            return null;
        } else if (dVar == h.d.HAIR_ACC) {
            if (this.f705b[i2].d.Q() != -1) {
                return this.f705b[i2].d;
            }
            Log.e("FXResourceMgr : ", "Model Category : " + i2 + " mHairAcc was not attached");
            return null;
        } else if (dVar == h.d.JACK || dVar == h.d.COAT) {
            if (this.f705b[i2].e == null || this.f705b[i2].e.Q() == -1) {
                return null;
            }
            return this.f705b[i2].e;
        } else if (dVar == h.d.INNER) {
            if (this.f705b[i2].f == null || this.f705b[i2].f.Q() == -1) {
                return null;
            }
            return this.f705b[i2].f;
        } else if (dVar == h.d.PANTS) {
            if (this.f705b[i2].g == null || this.f705b[i2].g.Q() == -1) {
                return null;
            }
            return this.f705b[i2].g;
        } else if (dVar != h.d.ONEPIECE || this.f705b[i2].h == null || this.f705b[i2].h.Q() == -1) {
            return null;
        } else {
            return this.f705b[i2].h;
        }
    }

    public float[] g(int i2) {
        p.a E = this.f704a[i2].E();
        if (E != null && E.q != null) {
            return E.q;
        }
        Log.e("FXResourceMgr : ", "mRealDQTable is null");
        return null;
    }

    public void b(int i2, float[] fArr) {
        p.a E = this.f704a[i2].E();
        if (E != null && E.q != null) {
            System.arraycopy(E.q, 184, fArr, 0, 344);
        }
    }

    public void c(int i2, float[] fArr) {
        p.a E = this.f704a[i2].a().E();
        if (E != null && E.q != null) {
            System.arraycopy(E.q, 0, fArr, 0, E.q.length);
        }
    }

    public float[] h(int i2) {
        p.a E = this.f704a[i2].E();
        if (E != null && E.r != null) {
            return this.f704a[i2].E().r;
        }
        Log.e("FXResourceMgr : ", "mDualDQTable is null");
        return null;
    }

    public void d(int i2, float[] fArr) {
        p.a E = this.f704a[i2].E();
        if (E != null && E.r != null) {
            System.arraycopy(E.r, 184, fArr, 0, 344);
        }
    }

    public void e(int i2, float[] fArr) {
        p.a E = this.f704a[i2].a().E();
        if (E != null && E.r != null) {
            System.arraycopy(E.r, 0, fArr, 0, E.r.length);
        }
    }

    public float[] i(int i2) {
        p.a E = this.f704a[i2].E();
        if (E == null || E.k == null) {
            Log.e("FXResourceMgr : ", "mBindPosTable is null");
            return null;
        }
        p a2 = this.f704a[i2].a();
        if (a2 == null) {
            return E.k;
        }
        float[] fArr = new float[(a2.E().k.length + 436)];
        System.arraycopy(E.k, 0, fArr, 0, 436);
        System.arraycopy(a2.E().k, 0, fArr, 436, a2.E().k.length);
        return fArr;
    }

    public float[] j(int i2) {
        p.a E = this.f704a[i2].E();
        if (E == null || E.h == null) {
            Log.e("FXResourceMgr : ", "mAniPosTable is null");
            return null;
        }
        p a2 = this.f704a[i2].a();
        if (a2 == null) {
            return E.h;
        }
        float[] fArr = new float[(a2.E().h.length + 436)];
        System.arraycopy(E.h, 0, fArr, 0, 436);
        System.arraycopy(a2.E().h, 0, fArr, 436, a2.E().h.length);
        return fArr;
    }

    public float[] k(int i2) {
        p.a E = this.f704a[i2].E();
        if (E != null && E.i != null) {
            return E.i;
        }
        Log.e("FXResourceMgr : ", "mAbsPosTable is null");
        return null;
    }

    public float[] l(int i2) {
        char c2;
        int i3 = i2;
        p c3 = c(i2);
        if (c3 == null || c3.E() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<i> p = c3.p();
        int i4 = 0;
        while (true) {
            c2 = 3;
            int i5 = 4;
            if (i4 >= p.size()) {
                break;
            }
            int i6 = 107;
            if (c3.a() == null || i4 <= 107) {
                int i7 = i4 * 4;
                float[] fArr = {c3.E().k[i7 + 0], c3.E().k[i7 + 1], c3.E().k[i7 + 2], 1.0f};
                ArrayList<Integer> o = p.get(i4).o();
                int i8 = 0;
                while (i8 < o.size()) {
                    int intValue = o.get(i8).intValue();
                    if (c3.a() == null || intValue <= i6) {
                        float[] fArr2 = new float[i5];
                        int i9 = intValue * 4;
                        fArr2[0] = c3.E().k[i9 + 0];
                        fArr2[1] = c3.E().k[i9 + 1];
                        fArr2[2] = c3.E().k[i9 + 2];
                        fArr2[3] = 0.0f;
                        if (i3 == 4) {
                            arrayList.add(Float.valueOf(fArr[0]));
                            arrayList.add(Float.valueOf(fArr[1]));
                            arrayList.add(Float.valueOf(fArr[2]));
                            arrayList.add(Float.valueOf(1.0f));
                            arrayList.add(Float.valueOf(fArr2[0]));
                            arrayList.add(Float.valueOf(fArr2[1]));
                            arrayList.add(Float.valueOf(fArr2[2]));
                            arrayList.add(Float.valueOf(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE));
                        } else {
                            arrayList.add(Float.valueOf(fArr[0]));
                            arrayList.add(Float.valueOf(fArr[1]));
                            arrayList.add(Float.valueOf(fArr[2]));
                            arrayList.add(Float.valueOf(1.0f));
                            arrayList.add(Float.valueOf(fArr2[0]));
                            arrayList.add(Float.valueOf(fArr2[1]));
                            arrayList.add(Float.valueOf(fArr2[2]));
                            arrayList.add(Float.valueOf(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE));
                        }
                    }
                    i8++;
                    i5 = 4;
                    i6 = 107;
                }
            }
            i4++;
        }
        if (c3.a() != null) {
            ArrayList<i> p2 = c3.a().p();
            int i10 = 0;
            while (i10 < p2.size()) {
                float[] fArr3 = new float[4];
                int i11 = i10 * 4;
                fArr3[0] = c3.a().E().k[i11 + 0];
                fArr3[1] = c3.a().E().k[i11 + 1];
                fArr3[2] = c3.a().E().k[i11 + 2];
                fArr3[c2] = 1.0f;
                ArrayList<Integer> o2 = p2.get(i10).o();
                for (int i12 = 0; i12 < o2.size(); i12++) {
                    int intValue2 = o2.get(i12).intValue() * 4;
                    float[] fArr4 = {c3.a().E().k[intValue2 + 0], c3.a().E().k[intValue2 + 1], c3.a().E().k[intValue2 + 2], 0.0f};
                    if (i3 == 4) {
                        arrayList.add(Float.valueOf(fArr3[0]));
                        arrayList.add(Float.valueOf(fArr3[1]));
                        arrayList.add(Float.valueOf(fArr3[2]));
                        arrayList.add(Float.valueOf(1.0f));
                        arrayList.add(Float.valueOf(fArr4[0]));
                        arrayList.add(Float.valueOf(fArr4[1]));
                        arrayList.add(Float.valueOf(fArr4[2]));
                        arrayList.add(Float.valueOf(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE));
                    } else {
                        arrayList.add(Float.valueOf(fArr3[0]));
                        arrayList.add(Float.valueOf(fArr3[1]));
                        arrayList.add(Float.valueOf(fArr3[2]));
                        arrayList.add(Float.valueOf(1.0f));
                        arrayList.add(Float.valueOf(fArr4[0]));
                        arrayList.add(Float.valueOf(fArr4[1]));
                        arrayList.add(Float.valueOf(fArr4[2]));
                        arrayList.add(Float.valueOf(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE));
                    }
                }
                i10++;
                c2 = 3;
            }
        }
        float[] fArr5 = new float[arrayList.size()];
        for (int i13 = 0; i13 < fArr5.length; i13++) {
            fArr5[i13] = ((Float) arrayList.get(i13)).floatValue();
        }
        return fArr5;
    }

    public float[] m(int i2) {
        char c2;
        int i3 = i2;
        p c3 = c(i2);
        if (c3 == null || c3.E() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<i> p = c3.p();
        int i4 = 0;
        while (true) {
            c2 = 3;
            int i5 = 4;
            if (i4 >= p.size()) {
                break;
            }
            int i6 = 107;
            if (c3.a() == null || i4 <= 107) {
                int i7 = i4 * 4;
                float[] fArr = {c3.E().h[i7 + 0], c3.E().h[i7 + 1], c3.E().h[i7 + 2], 1.0f};
                ArrayList<Integer> o = p.get(i4).o();
                int i8 = 0;
                while (i8 < o.size()) {
                    int intValue = o.get(i8).intValue();
                    if (c3.a() == null || intValue <= i6) {
                        float[] fArr2 = new float[i5];
                        int i9 = intValue * 4;
                        fArr2[0] = c3.E().h[i9 + 0];
                        fArr2[1] = c3.E().h[i9 + 1];
                        fArr2[2] = c3.E().h[i9 + 2];
                        fArr2[3] = 0.0f;
                        if (i3 == 4) {
                            arrayList.add(Float.valueOf(fArr[0]));
                            arrayList.add(Float.valueOf(fArr[1]));
                            arrayList.add(Float.valueOf(fArr[2]));
                            arrayList.add(Float.valueOf(1.0f));
                            arrayList.add(Float.valueOf(fArr2[0]));
                            arrayList.add(Float.valueOf(fArr2[1]));
                            arrayList.add(Float.valueOf(fArr2[2]));
                            arrayList.add(Float.valueOf(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE));
                        } else {
                            arrayList.add(Float.valueOf(fArr[0]));
                            arrayList.add(Float.valueOf(fArr[1]));
                            arrayList.add(Float.valueOf(fArr[2]));
                            arrayList.add(Float.valueOf(1.0f));
                            arrayList.add(Float.valueOf(fArr2[0]));
                            arrayList.add(Float.valueOf(fArr2[1]));
                            arrayList.add(Float.valueOf(fArr2[2]));
                            arrayList.add(Float.valueOf(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE));
                        }
                    }
                    i8++;
                    i5 = 4;
                    i6 = 107;
                }
            }
            i4++;
        }
        if (c3.a() != null) {
            ArrayList<i> p2 = c3.a().p();
            int i10 = 0;
            while (i10 < p2.size()) {
                float[] fArr3 = new float[4];
                int i11 = i10 * 4;
                fArr3[0] = c3.a().E().h[i11 + 0];
                fArr3[1] = c3.a().E().h[i11 + 1];
                fArr3[2] = c3.a().E().h[i11 + 2];
                fArr3[c2] = 1.0f;
                ArrayList<Integer> o2 = p2.get(i10).o();
                for (int i12 = 0; i12 < o2.size(); i12++) {
                    int intValue2 = o2.get(i12).intValue() * 4;
                    float[] fArr4 = {c3.a().E().h[intValue2 + 0], c3.a().E().h[intValue2 + 1], c3.a().E().h[intValue2 + 2], 0.0f};
                    if (i3 == 4) {
                        arrayList.add(Float.valueOf(fArr3[0]));
                        arrayList.add(Float.valueOf(fArr3[1]));
                        arrayList.add(Float.valueOf(fArr3[2]));
                        arrayList.add(Float.valueOf(1.0f));
                        arrayList.add(Float.valueOf(fArr4[0]));
                        arrayList.add(Float.valueOf(fArr4[1]));
                        arrayList.add(Float.valueOf(fArr4[2]));
                        arrayList.add(Float.valueOf(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE));
                    } else {
                        arrayList.add(Float.valueOf(fArr3[0]));
                        arrayList.add(Float.valueOf(fArr3[1]));
                        arrayList.add(Float.valueOf(fArr3[2]));
                        arrayList.add(Float.valueOf(1.0f));
                        arrayList.add(Float.valueOf(fArr4[0]));
                        arrayList.add(Float.valueOf(fArr4[1]));
                        arrayList.add(Float.valueOf(fArr4[2]));
                        arrayList.add(Float.valueOf(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE));
                    }
                }
                i10++;
                c2 = 3;
            }
        }
        float[] fArr5 = new float[arrayList.size()];
        for (int i13 = 0; i13 < fArr5.length; i13++) {
            fArr5[i13] = ((Float) arrayList.get(i13)).floatValue();
        }
        return fArr5;
    }

    public int n(int i2) {
        if (this.f704a[i2].p() == null) {
            return 0;
        }
        return this.f704a[i2].p().size();
    }

    public float o(int i2) {
        return this.f704a[i2].E().g;
    }

    public void a(int i2, int i3, h.d dVar) {
        if (dVar == h.d.INNER && this.f705b[i3].f != null) {
            this.f705b[i3].f.d(i2);
        } else if (dVar == h.d.PANTS && this.f705b[i3].g != null) {
            this.f705b[i3].g.d(i2);
        } else if (dVar == h.d.ONEPIECE && this.f705b[i3].h != null) {
            this.f705b[i3].h.d(i2);
        } else if ((dVar == h.d.JACK || dVar == h.d.COAT) && this.f705b[i3].e != null) {
            this.f705b[i3].e.d(i2);
        }
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\b\o.java ==========

package net.fxgear.b;

import android.opengl.GLES20;
import android.util.Log;

/* compiled from: FXShader */
public class o {
    public static int a(String str, String str2) {
        int a2;
        int a3 = a(35633, str);
        if (a3 == 0 || (a2 = a(35632, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, a3);
            a("glAttachShader");
            GLES20.glAttachShader(glCreateProgram, a2);
            a("glAttachShader");
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                Log.e("FXShader : ", "Could not link program: ");
                Log.e("FXShader : ", GLES20.glGetProgramInfoLog(glCreateProgram));
                GLES20.glDeleteProgram(glCreateProgram);
                return 0;
            }
        }
        return glCreateProgram;
    }

    public static void a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Log.e("FittingRenderer", str + ": glError " + glGetError);
        }
    }

    private static int a(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        if (glCreateShader == 0) {
            return glCreateShader;
        }
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return glCreateShader;
        }
        Log.e("FXShader : ", "Could not compile shader " + i + ":");
        Log.e("FXShader : ", GLES20.glGetShaderInfoLog(glCreateShader));
        GLES20.glDeleteShader(glCreateShader);
        return 0;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\b\p.java ==========

package net.fxgear.b;

import android.util.Log;
import java.util.ArrayList;
import javax.microedition.khronos.opengles.GL10;
import net.fxgear.GlobalDefine;

/* compiled from: FXSkeleton */
public class p {
    private String A;
    private int B;
    private long C;
    private boolean D;
    private float[] E;
    private p F;
    private ArrayList<String> G;
    private int H;
    private boolean I;
    private boolean J;

    /* renamed from: a  reason: collision with root package name */
    public e f707a;

    /* renamed from: b  reason: collision with root package name */
    public int f708b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float[] h;
    public float[] i;
    public float[] j;
    private a k;
    private ArrayList<i> l;
    private ArrayList<i> m;
    private int n;
    private int o;
    private float[] p;
    private int q;
    private float[] r;
    private float[] s;
    private float[] t;
    private float[] u;
    private float[] v;
    private float[] w;
    private int x;
    private String y;
    private String z;

    /* compiled from: FXSkeleton */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public int f709a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f710b = 0;
        public float c = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        public int d = 0;
        public int e = 0;
        public int f = 0;
        public float g = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        public float[] h = null;
        public float[] i = null;
        public float[] j = null;
        public float[] k = null;
        public float[] l = null;
        public float[] m = null;
        public float[] n = null;
        public float[] o = null;
        public float[] p = new float[16];
        public float[] q = null;
        public float[] r = null;

        public a() {
        }
    }

    p() {
        this.k = null;
        this.f707a = null;
        this.l = null;
        this.m = null;
        this.n = 0;
        this.o = -1;
        this.p = null;
        this.f708b = -1;
        this.q = -1;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = 0;
        this.c = 2.1f;
        this.d = 0.35f;
        this.e = -1.0f;
        this.f = -1.0f;
        this.g = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        this.h = null;
        this.i = new float[]{GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE};
        this.j = new float[]{GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE};
        this.y = new String();
        this.z = new String();
        this.A = new String();
        this.B = 0;
        this.C = 0;
        this.D = false;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = -1;
        this.I = false;
        this.J = false;
        this.k = new a();
    }

    public void a(GL10 gl10) {
        if (this.k != null) {
            this.k.o = null;
            this.k.p = null;
            this.k.h = null;
            this.k.i = null;
            this.k.j = null;
            this.k.k = null;
            this.k.l = null;
            this.k.m = null;
            this.k.n = null;
            this.k.r = null;
            this.k.q = null;
            this.k = null;
        }
        if (this.f707a != null) {
            this.f707a.a(gl10);
            this.f707a = null;
        }
        if (this.l != null) {
            for (int i2 = 0; i2 < this.l.size(); i2++) {
                this.l.get(i2).a(true);
            }
            this.l.clear();
            this.l = null;
        }
        if (this.m != null) {
            for (int i3 = 0; i3 < this.m.size(); i3++) {
                this.m.get(i3).a(true);
            }
            this.m.clear();
            this.m = null;
        }
        this.p = null;
        this.r = null;
        this.s = null;
        this.h = null;
        this.y = null;
        this.z = null;
        this.A = null;
        this.E = null;
        if (this.F != null) {
            this.F.a(gl10);
            this.F = null;
        }
        if (this.G != null) {
            this.G.clear();
            this.G = null;
        }
    }

    public void a(ArrayList<String> arrayList) {
        if (this.G != null) {
            this.G.clear();
            this.G = null;
        }
        this.G = arrayList;
    }

    public void a(p pVar) {
        p pVar2 = this.F;
        this.F = pVar;
        if (pVar2 != null) {
            pVar2.a((GL10) null);
        }
    }

    public p a() {
        return this.F;
    }

    public void b() {
        if (this.F != null) {
            this.F.a((GL10) null);
            this.F = null;
        }
    }

    public void c() {
        this.B++;
    }

    public void d() {
        this.B--;
        if (this.B == 0) {
            this.C = System.currentTimeMillis();
        }
    }

    public float e() {
        return ((float) (System.currentTimeMillis() - this.C)) / 1000.0f;
    }

    public int f() {
        return this.B;
    }

    public boolean g() {
        return this.D;
    }

    public void h() {
        this.I = true;
        this.y = "gabage hierarchy";
        this.z = "gabage animation";
        if (this.f707a != null) {
            this.f707a.B();
        }
    }

    public boolean i() {
        return this.I;
    }

    public boolean j() {
        return this.J;
    }

    public void a(int i2) {
        this.H = i2;
    }

    public int k() {
        return this.H;
    }

    public void a(String str) {
        this.y = str;
    }

    public String l() {
        return this.y;
    }

    public void b(String str) {
        this.z = str;
    }

    public String m() {
        return this.z;
    }

    public void c(String str) {
        this.A = str;
    }

    public String n() {
        return this.A;
    }

    public void b(int i2) {
        this.q = i2;
    }

    public int o() {
        return this.q;
    }

    public void b(ArrayList<i> arrayList) {
        if (arrayList == null) {
            Log.e("FXSkeleton : ", "Input Joint List is null : " + arrayList);
        } else if (arrayList.size() == 0) {
            Log.e("FXSkeleton : ", "Input Joint List size is 0 : " + arrayList);
        } else {
            if (this.l != null) {
                this.l.clear();
                this.l = null;
            }
            this.l = new ArrayList<>();
            this.l.addAll(arrayList);
            if (this.p != null) {
                this.p = null;
            }
            this.p = new float[(this.l.size() * 3)];
            for (int i2 = 0; i2 < this.l.size(); i2++) {
                int i3 = i2 * 3;
                this.p[i3 + 0] = this.l.get(i2).l()[0];
                this.p[i3 + 1] = this.l.get(i2).l()[1];
                this.p[i3 + 2] = this.l.get(i2).l()[2];
            }
            this.n = this.l.size();
        }
    }

    public ArrayList<i> p() {
        if (this.l == null) {
            Log.e("FXSkeleton : ", "FXSkeleton does not have any joints");
        }
        return this.l;
    }

    public void c(ArrayList<i> arrayList) {
        this.m = arrayList;
    }

    public ArrayList<i> q() {
        return this.m;
    }

    public void c(int i2) {
        this.o = i2;
    }

    public int r() {
        return this.o;
    }

    public void a(float[] fArr) {
        if (this.r != null) {
            this.r = null;
        }
        this.r = new float[3];
        this.r = (float[]) fArr.clone();
    }

    public float[] s() {
        if (this.r != null) {
            return this.r;
        }
        Log.e("FXSkeleton : ", "Skeleton does not have mCalibratedPos, set before get.");
        return null;
    }

    public void b(float[] fArr) {
        if (this.t != null) {
            this.t = null;
        }
        this.t = (float[]) fArr.clone();
    }

    public float[] t() {
        if (this.t != null) {
            return this.t;
        }
        Log.e("FXSkeleton : ", "Skeleton does not have mAutoCalibP, set before get.");
        return null;
    }

    public void c(float[] fArr) {
        if (this.u != null) {
            this.u = null;
        }
        this.u = (float[]) fArr.clone();
    }

    public float[] u() {
        if (this.u != null) {
            return this.u;
        }
        Log.e("FXSkeleton : ", "Skeleton does not have mAutoCalibR, set before get.");
        return null;
    }

    public void d(float[] fArr) {
        if (this.v != null) {
            this.v = null;
        }
        this.v = (float[]) fArr.clone();
    }

    public float[] v() {
        if (this.v != null) {
            return this.v;
        }
        Log.e("FXSkeleton : ", "Skeleton does not have mAutoCalibT, set before get.");
        return null;
    }

    public void e(float[] fArr) {
        if (this.w != null) {
            this.w = null;
        }
        this.w = (float[]) fArr.clone();
    }

    public void d(int i2) {
        this.x = i2;
    }

    public int w() {
        return this.x;
    }

    public void f(float[] fArr) {
        if (this.s != null) {
            this.s = null;
        }
        if (fArr.length <= 0) {
            Log.e("FXSkeleton : ", "Input blend weight is null!");
        } else {
            this.s = (float[]) fArr.clone();
        }
    }

    public float[] x() {
        if (this.s != null) {
            return this.s;
        }
        Log.e("FXSkeleton : ", "mCustomBlendWeight is null");
        return null;
    }

    public i e(int i2) {
        if (this.l == null) {
            Log.e("FXSkeleton : ", "Requested Joint id is not exist ID : " + i2);
            return null;
        } else if (this.l.size() > i2 && i2 >= 0) {
            return this.l.get(i2);
        } else {
            Log.e("FXSkeleton : ", "Requested Joint id is out of bound : " + i2);
            return null;
        }
    }

    public int y() {
        return this.n;
    }

    public float[] z() {
        return this.p;
    }

    public void b(p pVar) {
        if (this.l != null) {
            this.l.clear();
            this.l = null;
        }
        this.l = new ArrayList<>();
        for (int i2 = 0; i2 < pVar.y(); i2++) {
            this.l.add(new i(pVar.e(i2)));
        }
        if (this.p != null) {
            this.p = null;
        }
        this.p = (float[]) pVar.z().clone();
        this.n = this.l.size();
        this.f708b = pVar.F();
        a(pVar.A());
        this.k.h = new float[(p().size() * 4)];
        this.k.j = new float[(p().size() * 4)];
        this.k.i = new float[(p().size() * 4)];
        this.k.k = new float[(p().size() * 4)];
        this.k.l = new float[(p().size() * 4)];
        this.k.m = new float[(p().size() * 4)];
        this.k.n = new float[(p().size() * 4)];
        this.k.q = new float[(p().size() * 4)];
        this.k.r = new float[(p().size() * 4)];
        this.k.o = new float[(p().size() * 16)];
    }

    public void a(e eVar) {
        if (this.f707a != null) {
            this.f707a = null;
        }
        this.f707a = eVar;
    }

    public e A() {
        if (this.f707a != null) {
            return this.f707a;
        }
        Log.e("FXSkeleton : ", "There is no attached blend shape SkeletonID : " + this.o);
        return null;
    }

    private boolean h(float[] fArr) {
        if (this.E == null) {
            return false;
        }
        for (int i2 = 0; i2 < fArr.length; i2++) {
            if (Math.abs(fArr[i2] - this.E[i2]) > 1.0E-7f) {
                return false;
            }
        }
        Log.i("FXSkeleton : ", "Blendweight is same, skeleton is reserved.");
        return true;
    }

    public void g(float[] fArr) {
        if (fArr == null) {
            Log.e("FXSkeleton : ", "UpdateBlendShape weight is null");
        } else if (!h(fArr)) {
            int y2 = y();
            float[] a2 = this.f707a == null ? null : this.f707a.a(fArr, this.p);
            if (a2 != null) {
                for (int i2 = 0; i2 < y2; i2++) {
                    int i3 = i2 * 3;
                    e(i2).c(new float[]{a2[i3 + 0], a2[i3 + 1], a2[i3 + 2]});
                }
                this.E = (float[]) fArr.clone();
            }
        }
    }

    public void B() {
        for (int i2 = 0; i2 < this.n; i2++) {
            this.l.get(i2).f();
        }
    }

    public void C() {
        if (p() != null) {
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= p().size()) {
                    break;
                } else if (e(i3).n() == -1) {
                    this.f708b = i3;
                    break;
                } else {
                    i3++;
                }
            }
            this.k.f709a = e(this.f708b).p().size();
            while (true) {
                if (i2 >= this.k.f709a) {
                    break;
                } else if (((double) e(F()).d(i2).e()) == 1.0d) {
                    this.k.f710b = i2;
                    break;
                } else {
                    i2++;
                }
            }
            this.k.c = 1.0f / ((float) this.k.f710b);
            this.k.g = e(F()).d(this.k.f709a - 1).e();
            this.k.h = new float[(p().size() * 4)];
            this.k.j = new float[(p().size() * 4)];
            this.k.i = new float[(p().size() * 4)];
            this.k.k = new float[(p().size() * 4)];
            this.k.l = new float[(p().size() * 4)];
            this.k.m = new float[(p().size() * 4)];
            this.k.n = new float[(p().size() * 4)];
            this.k.q = new float[(p().size() * 4)];
            this.k.r = new float[(p().size() * 4)];
            this.k.o = new float[(p().size() * 16)];
        }
    }

    public void D() {
        this.k.f709a = e(this.f708b).p().size();
        int i2 = 0;
        while (true) {
            if (i2 >= this.k.f709a) {
                break;
            } else if (((double) e(F()).d(i2).e()) == 1.0d) {
                this.k.f710b = i2;
                break;
            } else {
                i2++;
            }
        }
        this.k.c = 1.0f / ((float) this.k.f710b);
        this.k.g = e(F()).d(this.k.f709a - 1).e();
    }

    public a E() {
        return this.k;
    }

    public int F() {
        return this.f708b;
    }

    public float[] f(int i2) {
        int i3 = i2 * 4;
        return new float[]{this.k.k[i3 + 0], this.k.k[i3 + 1], this.k.k[i3 + 2]};
    }

    public void g(int i2) {
        j jVar;
        i iVar = this.l.get(i2);
        int i3 = 0;
        if (iVar.a()) {
            ArrayList<Integer> o2 = iVar.o();
            while (i3 < o2.size()) {
                g(o2.get(i3).intValue());
                i3++;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        a((ArrayList<Integer>) arrayList, (ArrayList<Integer>) arrayList2, i2);
        if (arrayList.size() == 0) {
            iVar.f();
            float[] fArr = {GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, GlobalDefine.DEFAULT_AUTO_FILTER_VALUE};
            q qVar = new q();
            qVar.c();
            iVar.c(fArr);
            iVar.a(qVar);
            iVar.b(qVar);
            while (i3 < arrayList2.size()) {
                this.l.get(((Integer) arrayList2.get(i3)).intValue()).f();
                this.l.get(((Integer) arrayList2.get(i3)).intValue()).c(fArr);
                this.l.get(((Integer) arrayList2.get(i3)).intValue()).a(qVar);
                this.l.get(((Integer) arrayList2.get(i3)).intValue()).b(qVar);
                i3++;
            }
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        if (iVar.n() != -1) {
            arrayList3.add(this.l.get(iVar.n()).p());
        }
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            arrayList3.add(this.l.get(((Integer) arrayList.get(i4)).intValue()).p());
        }
        float f2 = 0.5f;
        if (i2 == 65) {
            f2 = this.d;
        }
        if (i2 == 62 || i2 == 63) {
            f2 = 0.1f;
        }
        for (int i5 = 0; i5 < ((ArrayList) arrayList3.get(0)).size(); i5++) {
            if (arrayList3.size() == 1) {
                jVar = new j((j) ((ArrayList) arrayList3.get(0)).get(i5));
            } else {
                jVar = new j();
                j jVar2 = new j((j) ((ArrayList) arrayList3.get(0)).get(i5));
                for (int i6 = 1; i6 < arrayList3.size(); i6++) {
                    j.b(jVar2, (j) ((ArrayList) arrayList3.get(i6)).get(i5), f2, jVar);
                    if (i6 < arrayList3.size() - 1) {
                        jVar2.a(jVar);
                    }
                }
            }
            if (i2 == 62 || i2 == 63) {
                jVar.a(true);
            }
            iVar.a(jVar);
        }
        iVar.b(true);
        ArrayList<Integer> o3 = iVar.o();
        while (i3 < o3.size()) {
            g(o3.get(i3).intValue());
            i3++;
        }
    }

    private void a(ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2, int i2) {
        arrayList2.add(Integer.valueOf(i2));
        if (this.l.get(i2).a()) {
            arrayList.add(Integer.valueOf(i2));
            return;
        }
        ArrayList<Integer> o2 = this.l.get(i2).o();
        if (o2.size() != 0) {
            for (int i3 = 0; i3 < o2.size(); i3++) {
                a(arrayList, arrayList2, o2.get(i3).intValue());
            }
        }
    }

    public void G() {
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            i iVar = this.l.get(i2);
            if (iVar.p().size() > 0) {
                float[] fArr = new float[iVar.p().size()];
                float[] fArr2 = new float[iVar.p().size()];
                float[] fArr3 = new float[iVar.p().size()];
                float[] fArr4 = new float[iVar.p().size()];
                float[] fArr5 = new float[iVar.p().size()];
                float[] fArr6 = new float[iVar.p().size()];
                for (int i3 = 0; i3 < iVar.p().size(); i3++) {
                    fArr[i3] = iVar.d(i3).g()[0];
                    fArr2[i3] = iVar.d(i3).g()[1];
                    fArr3[i3] = iVar.d(i3).g()[2];
                }
                for (int i4 = 0; i4 < iVar.p().size(); i4++) {
                    fArr4[i4] = a(i4, 3, fArr);
                    fArr5[i4] = a(i4, 3, fArr2);
                    fArr6[i4] = a(i4, 3, fArr3);
                }
                for (int i5 = 0; i5 < iVar.p().size(); i5++) {
                    fArr[i5] = b(i5, 7, fArr4);
                    fArr2[i5] = b(i5, 7, fArr5);
                    fArr3[i5] = b(i5, 7, fArr6);
                }
                int i6 = 2;
                while (i6 < iVar.p().size() - 2) {
                    int i7 = i6 - 2;
                    int i8 = i6 - 1;
                    int i9 = i6 + 1;
                    int i10 = i6 + 2;
                    fArr4[i6] = ((((fArr[i7] + fArr[i8]) + fArr[i6]) + fArr[i9]) + fArr[i10]) / 5.0f;
                    fArr5[i6] = ((((fArr2[i7] + fArr2[i8]) + fArr2[i6]) + fArr2[i9]) + fArr2[i10]) / 5.0f;
                    fArr6[i6] = ((((fArr3[i7] + fArr3[i8]) + fArr3[i6]) + fArr3[i9]) + fArr3[i10]) / 5.0f;
                    iVar.d(i6).a(fArr4[i6], fArr5[i6], fArr6[i6]);
                    i6 = i9;
                }
            }
        }
    }

    public static float a(int i2, int i3, float[] fArr) {
        int i4 = (int) (((float) i3) / 2.0f);
        float[] fArr2 = new float[i3];
        int i5 = 0;
        int i6 = 0;
        for (int i7 = i2 - i4; i7 < i2 + i4; i7++) {
            if (i7 >= 0 && i7 < fArr.length) {
                fArr2[i6] = fArr[i7];
                i6++;
            }
        }
        while (i5 < i6 - 1) {
            int i8 = i5 + 1;
            for (int i9 = i8; i9 < i6; i9++) {
                if (Math.abs(fArr2[i5]) < Math.abs(fArr2[i9])) {
                    float f2 = fArr2[i5];
                    fArr2[i5] = fArr2[i9];
                    fArr2[i9] = f2;
                }
            }
            i5 = i8;
        }
        return fArr2[(int) (((float) i6) / 2.0f)];
    }

    public static float b(int i2, int i3, float[] fArr) {
        float[] fArr2 = fArr;
        float f2 = (float) i3;
        float f3 = 2.0f;
        int i4 = (int) (f2 / 2.0f);
        float f4 = fArr2[i2];
        int i5 = i2 - i4;
        int i6 = i2 + i4;
        if (i5 < 0 || i6 >= fArr2.length) {
            return f4;
        }
        float f5 = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        float f6 = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        while (i5 < i6) {
            float f7 = fArr2[i5];
            float abs = Math.abs(f7 - f4);
            float abs2 = (float) Math.abs(i2 - i5);
            float f8 = f2 * f2;
            double d2 = (double) f8;
            Double.isNaN(d2);
            double d3 = (double) 9.0f;
            Double.isNaN(d3);
            float exp = ((float) (1.0d / (((Math.exp((double) ((abs2 * abs2) / (f8 * f3))) * 2.0d) * 3.141592653589793d) * d2))) * ((float) (1.0d / (((Math.exp((double) ((abs * abs) / 18.0f)) * 2.0d) * 3.141592653589793d) * d3)));
            f5 += exp;
            f6 += exp * f7;
            i5++;
            i6 = i6;
            f3 = 2.0f;
        }
        return f6 / f5;
    }
}




// ========== File: C:\Users\pc\OneDrive - ssat\last data\classes.dex_Decompiler.com\sources\sources\net\fxgear\b\q.java ==========

package net.fxgear.b;

import net.fxgear.GlobalDefine;

/* compiled from: Quaternion */
public class q {
    static float[] k = new float[3];

    /* renamed from: a  reason: collision with root package name */
    public double f711a;

    /* renamed from: b  reason: collision with root package name */
    public double f712b;
    public double c;
    public double d;
    public double[] e = new double[3];
    public float[] f = new float[16];
    public double g = 1.0E-9d;
    q h = null;
    q i = null;
    q j = null;

    public q() {
        c();
    }

    public q(float f2, float f3, float f4, float f5) {
        this.f711a = (double) f3;
        this.f712b = (double) f4;
        this.c = (double) f5;
        this.d = (double) f2;
    }

    public q(float f2, float[] fArr) {
        for (int i2 = 0; i2 < 3; i2++) {
            this.e[i2] = (double) fArr[i2];
        }
        double sqrt = Math.sqrt((double) ((fArr[0] * fArr[0]) + (fArr[1] * fArr[1]) + (fArr[2] * fArr[2])));
        if (sqrt > this.g) {
            for (int i3 = 0; i3 < 3; i3++) {
                double[] dArr = this.e;
                double d2 = (double) fArr[i3];
                Double.isNaN(d2);
                dArr[i3] = d2 / sqrt;
            }
            double d3 = (double) f2;
            Double.isNaN(d3);
            double d4 = d3 * 0.5d;
            double sin = Math.sin(d4);
            this.f711a = this.e[0] * sin;
            this.f712b = this.e[1] * sin;
            this.c = this.e[2] * sin;
            this.d = Math.cos(d4);
            return;
        }
        this.f711a = 0.0d;
        this.f712b = 0.0d;
        this.c = 0.0d;
        this.d = 1.0d;
    }

    public void a() {
        this.e = null;
        this.f = null;
        this.h = null;
        this.i = null;
        this.j = null;
    }

    public void b() {
        this.h = new q();
        this.i = new q();
        this.j = new q();
    }

    public void a(float f2, float[] fArr) {
        for (int i2 = 0; i2 < 3; i2++) {
            this.e[i2] = (double) fArr[i2];
        }
        double sqrt = Math.sqrt((double) ((fArr[0] * fArr[0]) + (fArr[1] * fArr[1]) + (fArr[2] * fArr[2])));
        if (sqrt > this.g) {
            for (int i3 = 0; i3 < 3; i3++) {
                double[] dArr = this.e;
                double d2 = (double) fArr[i3];
                Double.isNaN(d2);
                dArr[i3] = d2 / sqrt;
            }
            double d3 = (double) f2;
            Double.isNaN(d3);
            double d4 = d3 * 0.5d;
            double sin = Math.sin(d4);
            this.f711a = this.e[0] * sin;
            this.f712b = this.e[1] * sin;
            this.c = this.e[2] * sin;
            this.d = Math.cos(d4);
            return;
        }
        this.f711a = 0.0d;
        this.f712b = 0.0d;
        this.c = 0.0d;
        this.d = 1.0d;
    }

    public void a(q qVar) {
        this.f711a = qVar.f711a;
        this.f712b = qVar.f712b;
        this.c = qVar.c;
        this.d = qVar.d;
    }

    public void a(float f2, float f3, float f4, float f5) {
        this.f711a = (double) f2;
        this.f712b = (double) f3;
        this.c = (double) f4;
        this.d = (double) f5;
    }

    public void c() {
        this.c = 0.0d;
        this.f712b = 0.0d;
        this.f711a = 0.0d;
        this.d = 1.0d;
    }

    public void b(q qVar) {
        qVar.f711a = -this.f711a;
        qVar.f712b = -this.f712b;
        qVar.c = -this.c;
        qVar.d = this.d;
    }

    public void d() {
        double sqrt = Math.sqrt((this.f711a * this.f711a) + (this.f712b * this.f712b) + (this.c * this.c) + (this.d * this.d));
        if (sqrt > this.g) {
            this.f711a /= sqrt;
            this.f712b /= sqrt;
            this.c /= sqrt;
            this.d /= sqrt;
        }
    }

    public q e() {
        b(this.h);
        this.h.d();
        return this.h;
    }

    public q c(q qVar) {
        q qVar2 = new q();
        qVar2.f711a = (((this.f711a * qVar.d) + (this.f712b * qVar.c)) - (this.c * qVar.f712b)) + (this.d * qVar.f711a);
        qVar2.f712b = ((-this.f711a) * qVar.c) + (this.f712b * qVar.d) + (this.c * qVar.f711a) + (this.d * qVar.f712b);
        qVar2.c = ((this.f711a * qVar.f712b) - (this.f712b * qVar.f711a)) + (this.c * qVar.d) + (this.d * qVar.c);
        qVar2.d = ((((-this.f711a) * qVar.f711a) - (this.f712b * qVar.f712b)) - (this.c * qVar.c)) + (this.d * qVar.d);
        return qVar2;
    }

    public void a(q qVar, q qVar2) {
        qVar2.f711a = (((this.f711a * qVar.d) + (this.f712b * qVar.c)) - (this.c * qVar.f712b)) + (this.d * qVar.f711a);
        qVar2.f712b = ((-this.f711a) * qVar.c) + (this.f712b * qVar.d) + (this.c * qVar.f711a) + (this.d * qVar.f712b);
        qVar2.c = ((this.f711a * qVar.f712b) - (this.f712b * qVar.f711a)) + (this.c * qVar.d) + (this.d * qVar.c);
        qVar2.d = ((((-this.f711a) * qVar.f711a) - (this.f712b * qVar.f712b)) - (this.c * qVar.c)) + (this.d * qVar.d);
    }

    public void a(double d2) {
        this.f711a *= d2;
        this.f712b *= d2;
        this.c *= d2;
        this.d *= d2;
    }

    public void a(float[] fArr) {
        this.d = Math.sqrt(Math.max(0.0d, (double) (fArr[0] + 1.0f + fArr[5] + fArr[10]))) * 0.5d;
        this.f711a = Math.sqrt(Math.max(0.0d, (double) (((fArr[0] + 1.0f) - fArr[5]) - fArr[10]))) * 0.5d;
        this.f712b = Math.sqrt(Math.max(0.0d, (double) (((1.0f - fArr[0]) + fArr[5]) - fArr[10]))) * 0.5d;
        this.c = Math.sqrt(Math.max(0.0d, (double) (((1.0f - fArr[0]) - fArr[5]) + fArr[10]))) * 0.5d;
        this.f711a = Math.copySign(this.f711a, (double) (fArr[6] - fArr[9]));
        this.f712b = Math.copySign(this.f712b, (double) (fArr[8] - fArr[2]));
        this.c = Math.copySign(this.c, (double) (fArr[1] - fArr[4]));
    }

    public float[] f() {
        float f2 = (float) (this.d * this.d);
        float f3 = (float) (this.f711a * this.f711a);
        float f4 = (float) (this.f712b * this.f712b);
        float f5 = (float) (this.c * this.c);
        float f6 = (float) (this.f711a * this.f712b);
        float f7 = (float) (this.c * this.d);
        float f8 = (float) (this.f711a * this.c);
        float f9 = (float) (this.f712b * this.d);
        float f10 = (float) (this.f712b * this.c);
        float f11 = (float) (this.f711a * this.d);
        float f12 = f3 + f4 + f5 + f2;
        float f13 = ((double) Math.abs(f12)) > 0.0d ? 1.0f / f12 : 1.0f;
        this.f[0] = (((f3 - f4) - f5) + f2) * f13;
        this.f[4] = (f6 - f7) * 2.0f * f13;
        this.f[8] = (f8 + f9) * 2.0f * f13;
        this.f[12] = 0.0f;
        this.f[1] = (f6 + f7) * 2.0f * f13;
        float f14 = -f3;
        this.f[5] = (((f14 + f4) - f5) + f2) * f13;
        this.f[9] = (f10 - f11) * 2.0f * f13;
        this.f[13] = 0.0f;
        this.f[2] = (f8 - f9) * 2.0f * f13;
        this.f[6] = (f10 + f11) * 2.0f * f13;
        this.f[10] = ((f14 - f4) + f5 + f2) * f13;
        this.f[14] = 0.0f;
        this.f[3] = 0.0f;
        this.f[7] = 0.0f;
        this.f[11] = 0.0f;
        this.f[15] = 1.0f;
        return this.f;
    }

    public double d(q qVar) {
        return (this.f711a * qVar.f711a) + (this.f712b * qVar.f712b) + (this.c * qVar.c) + (this.d * qVar.d);
    }

    public float[] a(float f2, float f3, float f4) {
        q c2 = c(new q(GlobalDefine.DEFAULT_AUTO_FILTER_VALUE, f2, f3, f4)).c(e());
        return new float[]{(float) c2.f711a, (float) c2.f712b, (float) c2.c};
    }

    public void a(float f2, float f3, float f4, float[] fArr) {
        this.i.a(f2, f3, f4, (float) GlobalDefine.DEFAULT_AUTO_FILTER_VALUE);
        a(this.i, this.j);
        this.j.a(e(), this.i);
        fArr[0] = (float) this.i.f711a;
        fArr[1] = (float) this.i.f712b;
        fArr[2] = (float) this.i.c;
    }

    public void a(q qVar, double d2, q qVar2) {
        double d3;
        q qVar3 = qVar;
        q qVar4 = qVar2;
        double d4 = d(qVar);
        double d5 = 0.0d;
        if (d4 < 0.0d) {
            qVar3.a(-1.0d);
            d4 = -d4;
        }
        double d6 = 1.0d - d2;
        if (1.0d - d4 > 0.1d) {
            double acos = Math.acos(d4);
            if (Math.abs(Math.sin(acos)) > 0.0d) {
                d5 = 1.0d / Math.sin(acos);
            }
            d6 = Math.sin(d6 * acos) * d5;
            d3 = Math.sin(d2 * acos) * d5;
        } else {
            d3 = d2;
        }
        qVar4.f711a = (this.f711a * d6) + (qVar3.f711a * d3);
        qVar4.f712b = (this.f712b * d6) + (qVar3.f712b * d3);
        qVar4.c = (this.c * d6) + (qVar3.c * d3);
        qVar4.d = (d6 * this.d) + (d3 * qVar3.d);
    }

    public static float a(float[] fArr, float[] fArr2) {
        return (fArr[0] * fArr2[0]) + (fArr[1] * fArr2[1]) + (fArr[2] * fArr2[2]);
    }

    public static void a(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr3[0] = (fArr[1] * fArr2[2]) - (fArr[2] * fArr2[1]);
        fArr3[1] = (fArr[2] * fArr2[0]) - (fArr[0] * fArr2[2]);
        fArr3[2] = (fArr[0] * fArr2[1]) - (fArr[1] * fArr2[0]);
    }

    public static void a(float[] fArr, float[] fArr2, q qVar) {
        float sqrt = (float) Math.sqrt((double) (a(fArr, fArr) * a(fArr2, fArr2)));
        float a2 = a(fArr, fArr2) + sqrt;
        if (a2 < sqrt * 1.0E-6f) {
            if (Math.abs(fArr[0]) > Math.abs(fArr[2])) {
                k[0] = -fArr[1];
                k[1] = fArr[0];
                k[2] = 0.0f;
            } else {
                k[0] = 0.0f;
                k[1] = -fArr[2];
                k[2] = fArr[1];
            }
            a2 = GlobalDefine.DEFAULT_AUTO_FILTER_VALUE;
        } else {
            a(fArr, fArr2, k);
        }
        qVar.a(k[0], k[1], k[2], a2);
        qVar.d();
    }
}


